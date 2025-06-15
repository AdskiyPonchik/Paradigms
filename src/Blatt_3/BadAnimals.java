package Blatt_3;

class BadAnimals {

public static void printAnimalMoving(Animal a) {
    /*
    if (a instanceof Dog)
        ((Dog)a).run();
    else if (a instanceof Cat)
        ((Cat)a).tiptoe();
    else if (a instanceof Bird)
        ((Bird)a).fly();
    else if (a instanceof Cheetah)
        ((Cheetah)a).sprint();
    else if (a instanceof Sloth)
        ((Sloth)a).hang();
    else
        System.out.println("I'm an Animal, I just move.");
     */
    a.move();
}

public static void main(String[] args) {
    Animal a = new Animal();
    Dog d = new Dog();
    Cat c = new Cat();
    Bird b = new Bird();
    Cheetah ch = new Cheetah();
    Sloth s = new Sloth();

    printAnimalMoving(a);
    printAnimalMoving(b);
    printAnimalMoving(d);
    printAnimalMoving(c);
    printAnimalMoving(ch);
    printAnimalMoving(s);
}
}


class Animal {
    public void move(){};
}

class Dog extends Animal {
    @Override
    public void move() {
        System.out.println("Dogs run.");
    }
}

class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("Cats tiptoe.");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("Birds fly.");
    }
}

class Cheetah extends Animal {
    @Override
    public void move() {
        System.out.println("Cheetah sprint.");
    }
}

class Sloth extends Animal {
    @Override
    public void move() {
        System.out.println("Sloths don't move!");
    }
}