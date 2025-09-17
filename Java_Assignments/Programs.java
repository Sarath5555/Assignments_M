abstract class Shape {
    abstract public double calculateArea();
}

class Circle extends Shape {
    private double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, length;
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }
    public double calculateArea() {
        return width * length;
    }
}

class Triangle extends Shape {
    private double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class Animal {
    public void makeSound() {
        System.out.println("some sound");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Sport {
    public void play() {
        System.out.println("Playing a sport");
    }
}

class Football extends Sport {
    public void play() {
        System.out.println("Playing Football");
    }
}

class Basketball extends Sport {
    public void play() {
        System.out.println("Playing Basketball");
    }
}

class Tennis extends Sport {
    public void play() {
        System.out.println("Playing Tennis");
    }
}

abstract class Vehicle {
    abstract public void startEngine();
    abstract public void stopEngine();
}

class Car extends Vehicle {
    public void startEngine() {
        System.out.println("Car engine started");
    }

    public void stopEngine() {
        System.out.println("Car engine stopped");
    }
}

class MotorCycle extends Vehicle {
    public void startEngine() {
        System.out.println("MotorCycle engine started");
    }

    public void stopEngine() {
        System.out.println("MotorCycle engine stopped");
    }
}

class BankAccount {
    private int accountNumber;
    private double balance;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class Person {
    String name;
    int age;
    static int count = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void showCount() {
        System.out.println("Total Persons Created: " + count);
    }
}

public class Programs {
    public static void main(String[] args) {

        System.out.println("Q1. Shape Areas");
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 7);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Triangle Area: " + triangle.calculateArea());

        System.out.println("\nQ2. Animal Sounds");
        Animal animal = new Animal();
        Animal dog = new Dog();
        Animal cat = new Cat();
        animal.makeSound();
        dog.makeSound();
        cat.makeSound();

        System.out.println("\nQ3. Sports");
        Sport sport = new Sport();
        Sport football = new Football();
        Sport basketball = new Basketball();
        Sport tennis = new Tennis();
        sport.play();
        football.play();
        basketball.play();
        tennis.play();

        System.out.println("\nQ4. Engine Actions");
        Vehicle car = new Car();
        Vehicle motorcycle = new MotorCycle();
        car.startEngine();
        car.stopEngine();
        motorcycle.startEngine();
        motorcycle.stopEngine();

        System.out.println("\nQ5. Bank Accounts");
        BankAccount acc1 = new BankAccount(1, 10000);
        acc1.deposit(1000);
        acc1.withdraw(2000);
        acc1.display();

        System.out.println("\nQ6. Person Count");
        Person p1 = new Person("Pavan", 22);
        Person p2 = new Person("Ajay", 30);
        Person p3 = new Person("Chandu", 25);
        p1.display();
        p2.display();
        p3.display();
        Person.showCount();

    }
}

