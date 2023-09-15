// Mage.cs
using System;

namespace MagicalInheritance
{
  class Mage : Pupil {
    public Mage(string title) : base(title) {
      }

    public virtual Storm CastRainStorm(){
      Storm newStorm = new Storm("rain", false, Title);
      return newStorm;
    }
  }
}
