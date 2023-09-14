using System;

namespace CaesarCipher
{
    class Program
    {
        static void Main(string[] args)
        {
            char[] alphabet = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

            Console.WriteLine("Please give me a secret message");
            string input = Console.ReadLine();

            char[] secretMessage = input.ToCharArray();

            char[] encryptedMessage = new char[secretMessage.Length];

            for (int i = 0; i < secretMessage.Length; i++)
            {
                char current = secretMessage[i];
                int alphabetIndex = Array.IndexOf(alphabet, current);
                int shifted = (alphabetIndex + 3) % alphabet.Length;
                char newEncryptedLetter = alphabet[shifted];
                encryptedMessage[i] = newEncryptedLetter;
            }

            string message = String.Join("", encryptedMessage);
            Console.WriteLine(message);

        }
    }
}