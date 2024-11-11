package kapyrin.test.modify;

public class Dog extends Animal {
    @Override
    public Dog eat() {
       return (Dog) super.eat();
    }

    @Override
    public  Dog sleep() {
      return (Dog) super.sleep();
    }
}
