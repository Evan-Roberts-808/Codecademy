using System;

namespace TrueOrFalse
{
    class Program
    {
        static void Main(string[] args)
        {
            // Do not edit these lines
            Console.WriteLine("Welcome to 'True or False?'\nPress Enter to begin:");
            string entry = Console.ReadLine();
            Tools.SetUpInputStream(entry);

            // Type your code below
            string[] questions = new string[] { "SpongeBob was originally going to be named SpongeBoy.", "Some of SpongeBob's hobbies are driving and weightlifting.", "SpongeBob is a fry cook.", "Mr. Krabs is addicted to money, and is very greedy.", "SpongeBob's favorite holiday is Thanksgiving.", "When SpongeBob and Patrick become entrepreneurs, they decide to sell donuts.", "Squidward plays the clarinet.", "Eugene and Sheldon are characters in the show.", "\"SpongeBob SquarePants\" is shown on Cartoon Network.", "Squidward is an octopus." };

            bool[] answers = new bool[] { true, false, true, true, false, false, true, true, false, true };

            bool[] responses = new bool[10];

            if (questions.Length != responses.Length)
            {
                Console.WriteLine("Questions and Answers length doesn't match");
            }

            int askingIndex = 0;

            foreach (string question in questions)
            {
                string input;
                bool isBool;
                bool inputBool;
                Console.WriteLine(question);
                Console.WriteLine("True or False?");
                input = Console.ReadLine().ToLower();
                isBool = Boolean.TryParse(input, out inputBool);

                while (isBool == false)
                {
                    Console.WriteLine("Please answer with true or false");
                    input = Console.ReadLine().ToLower();
                    isBool = Boolean.TryParse(input, out inputBool);
                }

                responses[askingIndex] = inputBool;
                askingIndex++;

            }

            int scoringIndex = 0;
            int score = 0;

            foreach (bool answer in answers)
            {
                bool curr = responses[scoringIndex];
                Console.WriteLine($"Input: {curr} | Answer: {answers[scoringIndex]}");
                if (curr == answers[scoringIndex])
                {
                    score++;
                }
                scoringIndex++;
            }

            Console.WriteLine($"You got {score} out of {answers.Length} correct!");

        }
    }
}
