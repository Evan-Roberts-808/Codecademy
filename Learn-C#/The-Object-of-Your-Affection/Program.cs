using System;

namespace DatingProfile
{
  class Program
  {
    static void Main(string[] args)
    {
      Profile sam = new Profile("Sam Drakkila", 30, "New York", "USA", "he/him");
      string[] samsHobbies = new string[] {"skiiing", "fleeing", "treeing"};
      sam.SetHobbies(samsHobbies);
      Console.WriteLine(sam.ViewProfile);
    }
  }
}
