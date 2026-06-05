import java.util.ArrayList;
import java.util.Scanner;

public class AnimalShelter {
public static void main(String[] args) {
ArrayList<Animal> animals = new ArrayList<>();
Scanner in = new Scanner(System.in);
int nextId = 1;

    while (true) {
        System.out.println("\nAnimal Shelter Manager");
        System.out.println("1. Add animal");
        System.out.println("2. View animals");
        System.out.println("3. Search animal");
        System.out.println("4. Remove animal (in progress)");
        System.out.println("5. Mark animal as adopted");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");

        String choice = in.nextLine();

        switch (choice) {
            case "1":
                System.out.print("Enter animal type (dog/cat): ");
                String type = in.nextLine().toLowerCase();

                System.out.print("Enter animal name: ");
                String name = in.nextLine();

                System.out.print("Enter age: ");
                int age = Integer.parseInt(in.nextLine());

                if (type.equals("dog")) {
                    animals.add(new Dog(nextId, name, age));
                    nextId++;
                } else if (type.equals("cat")) {
                    animals.add(new Cat(nextId, name, age));
                    nextId++;
                } else {
                    System.out.println("Invalid animal type.");
                }
                break;

            case "2":
                if (animals.isEmpty()) {
                    System.out.println("No animals found.");
                } else {
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                }
                break;

            case "3":
                System.out.print("Enter animal name to search: ");
                String search = in.nextLine().toLowerCase();

                boolean found = false;

                for (Animal animal : animals) {
                    if (animal.getName().toLowerCase().contains(search)) {
                        System.out.println(animal);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Animal not found.");
                }
                break;

            case "4":
                System.out.println("Remove animal feature is still being developed.");
                break;

            case "5":
                System.out.print("Enter animal ID: ");
                int id = Integer.parseInt(in.nextLine());

                for (Animal animal : animals) {
                    if (animal.getId() == id) {
                        animal.setAdopted(true);
                        System.out.println(animal.getName() + " marked as adopted.");
                    }
                }
                break;

            case "6":
                System.out.println("Exiting program.");
                return;

            default:
                System.out.println("Invalid option.");
        }
    }
}

}

class Animal {
protected int id;
protected String name;
protected int age;
protected boolean adopted;

public Animal(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.adopted = false;
}

public int getId() {
    return id;
}

public String getName() {
    return name;
}

public void setAdopted(boolean adopted) {
    this.adopted = adopted;
}

public String getStatus() {
    if (adopted) {
        return "Adopted";
    }
    return "Available";
}

public String makeSound() {
    return "";
}

public String toString() {
    return "ID: " + id + " | " + name + " | Age: " + age +
            " | Status: " + getStatus() +
            " | Sound: " + makeSound();
}

}

class Dog extends Animal {
public Dog(int id, String name, int age) {
super(id, name, age);
}

@Override
public String makeSound() {
    return "Woof!";
}

}

class Cat extends Animal {
public Cat(int id, String name, int age) {
super(id, name, age);
}

@Override
public String makeSound() {
    return "Meow!";
}

}
