class Animal
{
    void speak()
    {
        System.out.println("Animal says - what's up blr?");
    }
}

class Cat extends Animal
{
    @Override
    void speak()
    {
        System.out.println("Cat says: Meow Meow Meow.");
    }
}

class Dog extends Animal
{
    @Override
    void speak()
    {
        System.out.println("Dog says: Woof Woof, Horror Woo-oof.");
    }
}

public class RuntimePolymorphism
{
    public static void main(String[] args)
    {
        Animal whoAmI = new Cat();
        Animal whoAmI2 = new Dog();
        Animal whoAmI3 = new Animal();
        whoAmI.speak();
        whoAmI2.speak();
        whoAmI3.speak();
    }
}
