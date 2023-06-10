package test;

public class Cat extends Animal{
    String breed;

    public Cat(String breed, String nickName, int age){
       this.breed = breed;
       this.nickName = nickName;
       this.age = age;
    }

    @Override
    public void sayHello(){
        System.out.println("Meow-Meow");
        System.out.println("Меня зовут " + nickName + ", мне " + age + " лет.");
        System.out.println("Я самый породистый " + breed);
    }
}
