public class WolfTest {
    public static void main(String[] args) {
        Wolf wolfOne = new Wolf();

        wolfOne.setSex("Самец");
        wolfOne.setNick("Белый клык");
        wolfOne.setWeight(45.3f);
        wolfOne.setAge(6);
        wolfOne.setColor("Белый");

        System.out.println("\nПол: " + wolfOne.getSex());
        System.out.println("Кличка: " + wolfOne.getNick());
        System.out.println("Вес: " + wolfOne.getWeight());
        System.out.println("Возраст: " + wolfOne.getAge());
        System.out.println("Окрас: " + wolfOne.getColor() + "\n");

        wolfOne.walk();
        wolfOne.sit();
        wolfOne.run();
        wolfOne.howl();
        wolfOne.hunt();
    }
}
