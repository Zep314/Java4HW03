package controller;

import model.DoublyList;
import view.View;

public class Controller {  // Контроллер
    private final View view;  // Вьювер
    private final DoublyList dList;  // наш двунаправленный список
    public Controller() {
        this.view = new View();
        this.dList = new DoublyList();
    }
    public void run(){
        dList.add("Первый");  // Заполняем список данными
        dList.add("Второй");
        dList.add("Третий");
        dList.add("Четвертый");
        dList.add("Пятый");

        view.print("============= Список до разворота =============");
        dList.setToFirst();
        while (dList.hasNext()) {
            view.print(dList.next());
        }

        dList.reverse();  // Разворот списка

        view.print("============ Список после разворота ============");
        dList.setToFirst();
        while (dList.hasNext()) {
            view.print(dList.next());
        }
    }
}
