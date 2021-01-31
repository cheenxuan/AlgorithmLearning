package com.xuan.algorithm.datastructure;

/**
 * 双端队列
 *
 * @param <E> 元素类型
 */
public class Deque<E> {
    private E[] data;
    private int front, tail;
    private int size;

    private Deque(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public Deque() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public void addLast(E e) {
        if (size == getCapacity())
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    public void addFront(E e) {
        if (size == getCapacity())
            resize(getCapacity() * 2);

        front = front == 0 ? front = data.length - 1 : front - 1;
        data[front] = e;
        size++;
    }


    public E removeFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Connot dequeue from a empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return ret;
    }

    public E removeLast() {
        if (isEmpty())
            throw new IllegalArgumentException("Connot dequeue from a empty queue.");
        tail = tail == 0 ? data.length - 1 : tail - 1;
        E ret = data[tail];
        data[tail] = null;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize();
    }

    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 13; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 4 == 3) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
