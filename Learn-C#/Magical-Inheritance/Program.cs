using System;

namespace MagicalInheritance
{
  class Program
  {
    static void Main(string[] args)
    {
      Storm zul = new Storm("wind", false, "Zul'rajas");
      Console.WriteLine(zul.Announce());

      Pupil mezil = new Pupil("Mezil-kree");
      Storm mezilStorm = mezil.CastWindStorm();
      Console.WriteLine(mezilStorm.Announce());
      
      Mage gul = new Mage("Gul'dan");
      Storm gulStorm = gul.CastRainStorm();
      Console.WriteLine(gulStorm.Announce());

      Archmage nielas = new Archmage("Nielas Aran");
      Storm nielasRainStorm = nielas.CastRainStorm();
      Storm nielasLightningStorm = nielas.CastLightningStorm();
      Console.WriteLine(nielasRainStorm.Announce());
      Console.WriteLine(nielasLightningStorm.Announce());
    }
  }
}