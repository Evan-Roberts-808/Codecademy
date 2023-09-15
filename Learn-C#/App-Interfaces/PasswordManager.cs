using System;

namespace SavingInterface
{
  class PasswordManager : IDisplayable, IResetable
  {
    private string Password
    { get; set; }

    public bool Hidden
    { get; private set; }

    public PasswordManager(string password, bool hidden)
    {
      Password = password;
      Hidden = hidden;
    }

    public void Display() {
      if(Hidden == false) {
        Console.WriteLine(Password);
      } else {
        string asterisks = new string('*', Password.Length);
        Console.WriteLine(asterisks);
      }
    }

    public void Reset() {
      Password = new string("");
      Hidden = false;
    }

  }
}