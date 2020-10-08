package com.company;
import java.util.Iterator;
import java.nio.BufferUnderflowException;

/**
 * Коллекция, реализующая FIFO и циклический буфер.
 *
 * @param <E> тип элементов
 */
interface Ring<E> extends Iterable<E> {

    /**
     * Возвращает и удаляет элемент из начала очереди.
     *
     * @return Элемент или {@code null}, если очередь пуста
     */
    E poll();

    /**
     * Возвращает (но не удаляет) элемент из начала очереди.
     *
     * @return Элемент или {@code null}, если очередь пуста
     */
    E peek();

    /**
     * Добавляет элемент в конец очереди.
     * Затирает начало очереди в случае, если она заполнена.
     *
     * @param item новый элемент
     */
    void add(E item);

    /**
     * Возвращает размер коллекции.
     *
     * @return размер
     */
    int getSize();

}
