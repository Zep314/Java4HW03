package model;

public class Item {  // Класс элемента списка
    private Item previous;  // Ссылка на предыдущий элемент
    private Item next;  // Ссылка на следующий элемент
    private String data;  // Какие-то данные, которые будем хранить в элементах списка

    @SuppressWarnings("unused")
    public Item(Item previous, Item next, String data) {  // Конструктор универсальный
        this.previous = previous;
        this.next = next;
        this.data = data;
    }
    public Item(String data) {  // Перегруженный конструктор
        this.previous = null;
        this.next = null;
        this.data = data;
    }

    // геттеры - сеттеры
    public Item getNext() {
        return this.next;
    }

    public Item getPrevious() {
        return this.previous;
    }

    public String getData() {
        return this.data;
    }

    public void setNext(Item next) {
        this.next = next;
    }

    public void setPrevious(Item previous) {
        this.previous = previous;
    }

    @SuppressWarnings("unused")
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {  // Для красивой печати
        return this.getData();
    }
}
