package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {


    System.out.println("Hello, World!");
    hello("Alex");
    hello("Piter");
    hello("Tutor");
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 6);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}
 
