package model;

import java.util.Iterator;

// Класс - двунаправленный список с возможностью разворота элементов списка
public class DoublyList implements Iterator<Item>{
    private Item head;  // Первый элемент списка
    private Item tail;  // Последний элемент списка
    int index;  // Указатель на текущий элемент списка
    int size;  // размер списка
    Item current;  // Текущий элемент

    public DoublyList(){  // Создаем пустой список
        this.head = null;
        this.tail = null;
        this.index = 0;
        this.current = null;
        this.size = 0;
    }

    @SuppressWarnings("unused")
    public Item getItem() {
        return this.current;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @SuppressWarnings("unused")
    public boolean hasPrev() {
        return this.current != null;
    }

    @Override
    public Item next() {
        Item ret = this.current;
        this.current = this.current.getNext();
        index++;
        return ret;
    }

    @SuppressWarnings("unused")
    public Item prev() {
        Item ret = this.current;
        this.current = this.current.getPrevious();
        index--;
        return ret;
    }

    public void setToFirst() {  // Все указатели - на начало списка
        index = 0;
        this.current = this.head;
    }

    @SuppressWarnings("unused")
    public void setToLast() {  // Все указатели - на конец списка
        index = this.getSize() - 1;
        this.current = this.tail;
    }

    public void add(Item item) {  // Добавление нового элемента в список
        if (this.current != null) {  // Если в списке уже что-то есть
            this.tail = item;
            this.current.setNext(item);
            item.setPrevious(this.current);
            this.current = item;
            this.index = this.size;
            this.size++;
        }
        else {  // Список пуст - это первый (и пока последний) элемент
            current = item;
            this.index = 0;
            this.size = 1;
            this.head = item;
            this.tail = item;
        }
    }
    public void add(String data) {  // Когда добавляют сразу данные, а не элемент
        Item item = new Item(data);
        add(item);
    }

    public void reverse() {  // Разворот списка
        if (this.getSize() > 0) {
            Item temp;  // Временный элемент - через него делаем обмен
            this.setToFirst();
            current = this.head;
            while (this.current != null) {  // Цикл по всем элементам
                temp = this.current.getNext();  // Меняем указатели prev и next местами в текущем элементе
                this.current.setNext(this.current.getPrevious());
                this.current.setPrevious(temp);
                this.current = this.current.getPrevious(); // на самом деле - next
            }

            temp = this.head;  // Меняем местами указатели на первый и последний элементы списка
            this.head = this.tail;
            this.tail = temp;
        }
    }
}
