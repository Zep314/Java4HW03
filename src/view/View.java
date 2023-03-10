package view;

import model.Item;

// Класс - вьювера. Собраны методы отображения информации и взаимодействия с пользователем
public class View {
    public View() {

    }

    public void print(Item item){  // Печать данных элемента списка
        System.out.println(item.toString());
    }

    public void print(String string){  // Просто печать строки
        System.out.println(string);
    }
}
