package com.example.springboot_demo.DesignMode.Factory.easyfactory;

/**
 * 获取具体动物的工厂
 */
public class AnimalFactory extends Dog {
    public static Animal getAnimal(String animalname) {
        Animal animal = null;
        switch (animalname) {
            case "dog":
                animal = new Dog();
                break;
            case "cat":
                animal = new Cat();
                break;
        }
        return animal;
    }
}

class AnimalFactoryTest{
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Animal dog = animalFactory.getAnimal("dog");
        dog.say();
        dog.eat();
        Animal cat = animalFactory.getAnimal("cat");
        cat.say();
        cat.eat();
    }
}
