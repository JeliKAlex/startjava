public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.sex = "Самец";
        wolfOne.nick = "Белый клык";
        wolfOne.weight = 45.3f;
        wolfOne.age = 6;
        wolfOne.color = "Белый";

        System.out.println("\nПол: " + wolfOne.sex);
        System.out.println("Кличка: " + wolfOne.nick);
        System.out.println("Вес: " + wolfOne.weight);
        System.out.println("Возраст: " + wolfOne.age);
        System.out.println("Окрас: " + wolfOne.color + "\n");

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}
