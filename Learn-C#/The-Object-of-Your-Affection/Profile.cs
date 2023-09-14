using System;

namespace DatingProfile
{
    class Profile
    {
        // Fields
        private string name;
        private int age;
        private string city;
        private string country;
        private string pronouns;
        private string[] hobbies;

        // Constructor
        public Profile(string name, int age, string city, string country, string pronouns = "they/them")
        {
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
            this.pronouns = pronouns;
        }

        // View Profile Method
        public string ViewProfile()
        {
            string bio = $"Name: {name}\nAge: {age}\nCity: {city}\nCountry: {country}\nPronouns: {pronouns}\nHobbies: ";

            foreach (string hobby in this.hobbies)
            {
                bio += $" {hobby} ";
            }

            return bio;
        }

        // Set Hobbies Method
        public void SetHobbies(string[] hobbies)
        {
            this.hobbies = hobbies;
        }
    }
}
