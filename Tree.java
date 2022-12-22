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

        String male = "Male";
        String female = "Female";

        People man1 = new People();
        man1.fullName = "Ivanov Ivan Ivanovich";
        man1.wasBorn = "28.6.1990";
        man1.gender = male;
        man1.familyRole = "Unmarried";
        man1.parent1 = "Ivanov Ivan Andreevich";
        man1.parent2 = "Ivanova Mariya Nikodimovna";

        People man2 = new People();
        man2.fullName = "Ivanov Petr Ivanovich";
        man2.wasBorn = "24.6.1988";
        man2.gender = male;
        man2.familyRole = "Married";
        man2.parent1 = "Ivanov Ivan Andreevich";
        man2.parent2 = "Ivanova Mariya Nikodimovna";
        man2.partner = "Ivanova Angelina Valeryevna";

        People man3 = new People();
        man3.fullName = "Ivanova Mariya Nikodimovna";
        man3.wasBorn = "6.1.1964";
        man3.gender = female;
        man3.familyRole = "Married";
        man3.partner = "Ivanov Ivan Andreevich";

        People man4 = new People();
        man4.fullName = "Ivanov Ivan Andreevich";
        man4.wasBorn = "28.8.1964";
        man4.gender = male;
        man4.familyRole = "Married";
        man4.partner = "Ivanova Mariya Nikodimovna";

        People man5 = new People();
        man5.fullName = "Ivanova Angelina Valeryevna";
        man5.wasBorn = "19.4.1992";
        man5.gender = female;
        man5.familyRole = "Married";
        man5.partner = "Ivanov Petr Ivanovich";
        man5.parent1 = "Bessmertnov Valeriy Veniaminovich";
        man5.parent2 = "Bessmertnova Aleftina Karlovna";

        People man6 = new People();
        man6.fullName = "Ivanova Aleksandra Petrovna";
        man6.wasBorn = "13.10.2015";
        man6.gender = female;
        man6.familyRole = "Unmarried";
        man6.parent1 = "Ivanov Petr Ivanovich";
        man6.parent2 = "Ivanova Angelina Valeryevna";

        People man7 = new People();
        man7.fullName = "Bessmertnov Valeriy Veniaminovich";
        man7.wasBorn = "21.5.1968";
        man7.gender = male;
        man7.familyRole = "Married";
        man7.partner = "Bessmertnova Aleftina Karlovna";

        People man8 = new People();
        man8.fullName = "Bessmertnova Aleftina Karlovna";
        man8.wasBorn = "4.2.1970";
        man8.gender = female;
        man8.familyRole = "Married";
        man8.partner = "Bessmertnov Valeriy Veniaminovich";

        People man9 = new People();
        man9.fullName = "Ivanova Darya Petrovna";
        man9.wasBorn = "13.10.2018";
        man9.gender = female;
        man9.familyRole = "Unmarried";
        man9.parent1 = "Ivanov Petr Ivanovich";
        man9.parent2 = "Ivanova Angelina Valeryevna";

        //Сохранил всех известных членов семьи в виде списка
        List<People> tree = new ArrayList<People>(Arrays.asList(man1, man2, man3, man4, man5, man6, man7, man8, man9));

        //Считываю данные из сканера, опираясь на которые система проведет анализ.
        People user = new People();
        Scanner in = new Scanner(System.in);
        System.out.println("Укажите ФИО человека из генеалогического древа: ");
        user.fullName = in.nextLine();
        in.close();

        //Нахожу в списке человека, ФИО которого совпадают с введенными в консоль данными и сохраняю их в отдельной переменной для дальнейшей работы
        for (int i = 0; i < tree.size(); i++) {
            if (tree.get(i).search(user)) {
                tree.get(i).info();
                user.wasBorn = tree.get(i).wasBorn;
                user.gender = tree.get(i).gender;
                user.familyRole = tree.get(i).familyRole;
                user.parent1 = tree.get(i).parent1;
                user.parent2 = tree.get(i).parent2;
                user.partner = tree.get(i).partner;
                System.out.println();
            }
        }

        // Research userResearch = new Research(); // Создаю переменную отдельного класса для проведения исследования
        // userResearch.name = (tree.get(i).fullName);
        // System.out.println(userResearch.name);

        List<People> children = new ArrayList<People>(); // Отдельный список, в который сохраняем список детей исследуемого

        for (int i = 0; i < tree.size(); i++) {
            if (user.fullName != tree.get(i).fullName & user.wasBorn != tree.get(i).wasBorn) { // Проверка не получили ли мы из списка самого исследуемого
                
                if (user.fullName == tree.get(i).parent1 || user.fullName == tree.get(i).parent2) {  // Проверяем на детей, сохраняем имена всех найденных детей в отдельную переменную.
                    children.add(tree.get(i));
                }

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



            }
        }

        for (int i = 0; i < children.size(); i++) {
            System.out.print(children.get(i).fullName);            
        }
    }           
}