public class People {

    int id;
    String fullName;
    String wasBorn;
    String gender;
    String familyRole;
    String parent1;
    String parent2;
    String partner;

    public void info() {
        System.out.println();
        System.out.printf("ФИО: %s \n", fullName);
        System.out.printf("Дата рождения: %s \n", wasBorn);
        System.out.printf("Пол: %s \n", gender);
        System.out.printf("Семейное положение: %s \n", familyRole);
        System.out.printf("Родители: %s, %s \n", parent1, parent2);

    }
}