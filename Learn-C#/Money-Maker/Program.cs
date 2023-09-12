using System;

namespace MoneyMaker
{
  class MainClass
  {
    public static void Main(string[] args)
    {

      int goldCoin = 10;
      int silverCoin = 5;

      Console.WriteLine("Welcome to Money Maker!");
      Console.WriteLine("How much would you like to convert?");
      double amountToConvert = Convert.ToDouble(Console.ReadLine());
      Console.WriteLine(amountToConvert + " is equal to...");

      // find max num of gold coins that fit
      double goldCoins = Math.Floor(amountToConvert / goldCoin);
      double remainder = amountToConvert % goldCoin;

      // find max num of silver after gold has been found
      double silverCoins = Math.Floor(remainder / silverCoin);
      remainder = remainder % silverCoin;

      Console.WriteLine("Gold Coins: " + goldCoins + "\n" + "Silver Coins: " + silverCoins + "\n" + "Bronze Coins: " + remainder);

    }
  }
}
