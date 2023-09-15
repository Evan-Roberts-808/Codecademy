using System;

namespace ArchitectArithmetic
{
  class Program
  {

    static double Rect(double length, double width) {
      double area = length * width;
      return area;
    }

    static double Circle(double radius){
      double area = Math.PI * Math.Pow(radius, 2);
      return area;
    }

    static double Triangle(double bottom, double height){
      double area = 0.5 * bottom * height;
      return area;
    }

    public static void Main(string[] args)
    {
      // Step 4 Tests
      // double rect = Rect(4, 5);
      // Console.WriteLine(rect);
      // double circ = Circle(4);
      // Console.WriteLine(circ);
      // double tri = Triangle(10, 9);
      // Console.WriteLine(tri);

      // Teotihuacan
      double rectangle = Rect(2500, 1500);
      double circle = Circle(375) / 2;
      double triangle = Triangle(750, 500);
      double total = rectangle + circle + triangle;

      double cost = total * 180;
      cost = Math.Round(cost, 2);

      Console.WriteLine($"The cost in flooring material is {cost} pesos... This was calculated by getting the area of each part and adding them together and multiplying by the cost of material being 180 pesos");
    }
  }
}
