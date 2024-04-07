package com.startjava.lesson_2_3_4.robot;

public class JaegerTest {
    public static void main(String[] args){
        Jaeger jaegerOne = new Jaeger();

        jaegerOne.setModelName("Bracer Phoenix");
        jaegerOne.setMark("Mark4-5555");
        jaegerOne.setOrigin("USA");
        jaegerOne.setHeight(70.7f);
        jaegerOne.setWeight(2.1f);
        jaegerOne.setStrength(8);
        jaegerOne.setArmor(9);
        System.out.println(jaegerOne.getModelName());

        jaegerOne.useVortexCannon();
        jaegerOne.getInfo();
        jaegerOne.drift();
        jaegerOne.jump();
        jaegerOne.setMark("Mark-5");
        jaegerOne.getInfo();

        Jaeger jaegerTwo = new Jaeger("Crimson Typhoon", "Mark-4", "USA", 80.3f, 3.4f, 6, 7);
        jaegerTwo.useVortexCannon();
        jaegerTwo.move();
        jaegerTwo.getInfo();
        jaegerTwo.scanKaiju();
        jaegerTwo.fight();
        jaegerTwo.setArmor(6);
        jaegerTwo.setWeight(3.1f);
        jaegerTwo.getInfo();
    }
}
