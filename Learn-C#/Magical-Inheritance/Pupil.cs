// Pupil.cs
using System;

namespace MagicalInheritance
{
  class Pupil {
    public string Title
    {get; private set;}

    public Pupil(string title){
      this.Title = title;
    }

    public Storm CastWindStorm(){
      Storm newStorm = new Storm("wind", false, Title);
      return newStorm;
    }
  }
}
