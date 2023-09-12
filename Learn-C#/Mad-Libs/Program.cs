using System;

namespace MadLibs
{
  class Program
  {
    static void Main(string[] args)
    {
      /*
      This program askes user for input and writes a madlib with their inputs
      Author: Evan
      */


      // Let the user know that the program is starting:
      Console.WriteLine("The program is starting");

      // Give the Mad Lib a title:
      string title = "That One Guy From That One Show";

      Console.WriteLine(title);
      // Define user input and variables:
      Console.WriteLine("Enter a name: ");
      string name = Console.ReadLine();

      Console.WriteLine("We need 3 adjectives, what is adjective 1? ");
      string adj1 = Console.ReadLine();
      Console.WriteLine("What is adjective 2? ");
      string adj2 = Console.ReadLine();
      Console.WriteLine("And the third? ");
      string adj3 = Console.ReadLine();

      Console.WriteLine("Now we need a verb: ");
      string verb = Console.ReadLine();

      Console.WriteLine("Alrighty, now two nouns... What is noun 1?");
      string noun1 = Console.ReadLine();
      Console.WriteLine("And the second?");
      string noun2 = Console.ReadLine();

      Console.WriteLine("Now for the weird part, we need an animal, food, fruit, superhero, country, dessert, and a year... First give us an animal: ");
      string animal = Console.ReadLine();
      Console.WriteLine("Now a food:");
      string food = Console.ReadLine();
      Console.WriteLine("Now a fruit:");
      string fruit = Console.ReadLine();;
      Console.WriteLine("Now a superhero:");
      string superhero = Console.ReadLine();
      Console.WriteLine("Now a country:");
      string country = Console.ReadLine();
      Console.WriteLine("Now a dessert:");
      string dessert = Console.ReadLine();
      Console.WriteLine("And last but not least, a year:");
      string year = Console.ReadLine();

      // The template for the story:

      string story = $"This morning {name} woke up feeling {adj1}. 'It is going to be a {adj2} day!' Outside, a bunch of {animal}s were protesting to keep {food} in stores. They began to {verb} to the rhythm of the {noun1}, which made all the {fruit}s very {adj3}. Concerned, {name} texted {superhero}, who flew {name} to {country} and dropped {name} in a puddle of frozen {dessert}. {name} woke up in the year {year}, in a world where {noun2}s ruled the world.";


      // Print the story:
      Console.WriteLine("Your story is complete... here it is\n");
      Console.WriteLine(story);
    }
  }
}
