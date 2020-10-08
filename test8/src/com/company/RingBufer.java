package com.company;

import java.nio.BufferUnderflowException;
import java.util.Iterator;

public class RingBufer<E> implements Ring<E> {
    private E[] buffer;
    private int head, count;

    public RingBufer(int n)
    {
        buffer = (E[]) new Object[n];
        count = 0; head = 0;
    }

    @Override
    public  E poll()
    {
        if(isEmpty())
        {
            throw  new BufferUnderflowException();
        }
        E res = buffer[head];
        head=(head+1)%buffer.length;
        count--;
        return res;
    }
    @Override
    public E peek()
    {
        return buffer[head];
    }

    @Override
    public void add(E item)
    {
        if(isFull())
        {
            buffer[head]=item;
            head = (head+1)%buffer.length;
        }
        else
        {

            buffer[(head+count)%buffer.length]= item;
            count++;
        }
    }
    @Override
    public int getSize()
    {
        return count;
    }
    private boolean isEmpty()
    {
        return count==0;
    }
    private boolean isFull()
    {
        return count == buffer.length;
    }

    public String toString ()
    {
        String str="Буфер ";
        for(int i = head; i<count+head;i++)
        {
            str = str+buffer[i%buffer.length].toString()+" ";
        }
        return str;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < buffer.length && buffer[currentIndex] != null;
            }

            @Override
            public E next() {
                return buffer[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
