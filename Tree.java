/*
Реализовать, с учетом ООП подхода, приложение для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
 - модель человека
 - компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение, брат, свекровь, сестра и т. д.
 - компонента для проведения исследований
 - дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл, 
получение\построение отдельных моделей человека c “проведением исследования” можно понимать получение всех детей выбранного человека.

Используйя код написанный выше, необходимо гарантированно продумать иерархию компонент и взаимодействия их между собой.

Обеспечить переход от использования явных классов в сторону использования абстрактных типов. Т е работаем не с:

Конкретным экземпляром генеалогического древа, а с интерфейсом “генеалогическое древо”
Конкретным экземпляром котика, а с интерфейсом “котик”. 
Лучше уйти от взаимодействия с конкретными питомцами и повысить уровень абстракции до взаимодействия с интерфейсом “животное”
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tree {


    public static void main(String[] args) {

        String male = "Мужской";
        String female = "Женский";

        People man1 = new People();
        man1.id = 1;
        man1.fullName = "Иванов Иван Иванович";
        man1.wasBorn = "28.6.1990";
        man1.gender = male;
        man1.familyRole = "Не женат";
        man1.parent1 = "Иванов Иван Андреевич";
        man1.parent2 = "Иванова Мария Никодимовна";

        People man2 = new People();
        man2.id = 2;
        man2.fullName = "Иванов Пётр Иванович";
        man2.wasBorn = "24.6.1988";
        man2.gender = male;
        man2.familyRole = "Женат";
        man2.parent1 = "Иванов Иван Андреевич";
        man2.parent2 = "Иванова Мария Никодимовна";
        man2.partner = "Иванова Ангелина Валериевна";

        People man3 = new People();
        man3.id = 3;
        man3.fullName = "Иванова Мария Никодимовна";
        man3.wasBorn = "6.1.1964";
        man3.gender = female;
        man3.familyRole = "Замужем";
        man3.partner = "Иванов Иван Андреевич";
        man3.parent1 = "Никелев Никодим Васильевич";
        man3.parent2 = "Никелева Анастасия Павловна";

        People man4 = new People();
        man4.id = 4;
        man4.fullName = "Иванов Иван Андреевич";
        man4.wasBorn = "28.8.1964";
        man4.gender = male;
        man4.familyRole = "Женат";
        man4.partner = "Иванова Мария Никодимовна";
        man4.parent1 = "Иванов Андрей Борисович";
        man4.parent2 = "Иванова Виктория Алексеевна";

        People man5 = new People();
        man5.id = 5;
        man5.fullName = "Иванова Ангелина Валериевна";
        man5.wasBorn = "19.4.1992";
        man5.gender = female;
        man5.familyRole = "Замужем";
        man5.partner = "Иванов Пётр Иванович";
        man5.parent1 = "Бессмертнов Валерий Вениаминович";
        man5.parent2 = "Бессмертнова Алевтина Карловна";

        People man6 = new People();
        man6.id = 6;
        man6.fullName = "Иванова Александра Петровна";
        man6.wasBorn = "13.10.2015";
        man6.gender = female;
        man6.familyRole = "Не замужем";
        man6.parent1 = "Иванов Пётр Иванович";
        man6.parent2 = "Иванова Ангелина Валериевна";

        People man7 = new People();
        man7.id = 7;
        man7.fullName = "Бессмертнов Валерий Вениаминович";
        man7.wasBorn = "21.5.1968";
        man7.gender = male;
        man7.familyRole = "Женат";
        man7.partner = "Бессмертнова Алевтина Карловна";
        man7.parent1 = "Бессмертнов Вениамин Дмитриевич";
        man7.parent2 = "Бессмертнова Наталья Павловна";

        People man8 = new People();
        man8.id = 8;
        man8.fullName = "Бессмертнова Алевтина Карловна";
        man8.wasBorn = "4.2.1970";
        man8.gender = female;
        man8.familyRole = "Замужем";
        man8.partner = "Бессмертнов Валерий Вениаминович";
        man8.parent1 = "Дойчев Карл Шпрехович";
        man8.parent2 = "Дойчева Наталья Васильевна";

        People man9 = new People();
        man9.id = 9;
        man9.fullName = "Иванова Дарья Петровна";
        man9.wasBorn = "13.10.2018";
        man9.gender = female;
        man9.familyRole = "Не замужем";
        man9.parent1 = "Иванов Пётр Иванович";
        man9.parent2 = "Иванова Ангелина Валериевна";

        //Сохранил всех известных членов семьи в виде списка
        List<People> tree = new ArrayList<People>(Arrays.asList(man1, man2, man3, man4, man5, man6, man7, man8, man9));

        //Считываю данные из сканера, опираясь на которые система проведет анализ.
        People user = new People();
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите ID человека из генеалогического древа: ");
        int id = in.nextInt();
        in.close();

        //Нахожу в списке человека, ФИО которого совпадают с введенными в консоль данными и сохраняю их в отдельной переменной для дальнейшей работы
        for (int i = 0; i < tree.size(); i++) {
            if (id == tree.get(i).id) {
                tree.get(i).info();
                user = tree.get(i);
                System.out.println();
            }
        }

        List<People> children = new ArrayList<People>(); // Отдельный список, в который сохраняем список детей исследуемого

        for (int i = 0; i < tree.size(); i++) {
            if (user.fullName != tree.get(i).fullName & user.wasBorn != tree.get(i).wasBorn) { // Проверка не получили ли мы из списка самого исследуемого

                if (user.parent1 == tree.get(i).parent1 || user.parent2 == tree.get(i).parent2) { // Проверяем степень родства на брата/сестру
                    if (tree.get(i).gender == female) {
                        System.out.printf("Сестра: %s \n", tree.get(i).fullName);
                    }
                    if (tree.get(i).gender == male) {
                        System.out.printf("Брат: %s \n", tree.get(i).fullName);
                    }
                }
                if (user.partner == tree.get(i).fullName) {  // Проверяем на тестя/тёщу/свёкра/свекровь
                    if (user.gender == male) {
                        System.out.printf("Тёща: %s \n", tree.get(i).parent2);
                        System.out.printf("Тесть: %s \n", tree.get(i).parent1);
                    }
                    if (user.gender == female) {
                        System.out.printf("Свекровь: %s \n", tree.get(i).parent2);
                        System.out.printf("Свёкор: %s \n", tree.get(i).parent1);
                    }
                }
                // Проверяем на детей, сохраняем имена найденных в отдельном списке.
                
                if (user.fullName == tree.get(i).parent1 || user.fullName == tree.get(i).parent2) {  
                    children.add(tree.get(i));
                }
            }
        }

        // Выводим на печать список найденных детей.
        System.out.print("Дети: ");
        for (int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i).fullName);
            System.out.print(", ");
        }
        System.out.println();
    }           
}