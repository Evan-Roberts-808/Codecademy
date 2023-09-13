using System;

namespace PasswordChecker
{
  class Program
  {
    public static void Main(string[] args)
    {
      int minLength = 8;
      string uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
      string lowercase = "abcdefghijklmnopqrstuvwxyz";
      string digits = "0123456789";
      string specialChars = "!@#$%^&*()_+-=";

      Console.WriteLine("Enter Password");
      string userPass = Console.ReadLine();

      int score = 0;

      if (userPass.Length >= minLength) {
        score += 1;
      }

      if (Tools.Contains(userPass, uppercase)) {
        score += 1;
      }

      if (Tools.Contains(userPass, lowercase)) {
        score += 1;
      }

      if (Tools.Contains(userPass, digits)) {
        score += 1;
      }

      if (Tools.Contains(userPass, specialChars)) {
        score += 1;
      }

      switch(score) {
        case 5:
          Console.WriteLine("Extremely Strong");
          break;
        case 4:
          Console.WriteLine("Extremely Strong");
          break;
        case 3:
          Console.WriteLine("Strong");
          break;
        case 2:
          Console.WriteLine("Medium");
          break;
        case 1:
          Console.WriteLine("Weak");
          break;
        default:
          Console.WriteLine("Doesnt meet requirements");
          break;
      }

    }
  }
}
