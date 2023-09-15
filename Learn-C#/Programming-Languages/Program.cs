using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace ProgrammingLanguages
{
    class Program
    {
        static void Main()
        {
            List<Language> languages = File.ReadAllLines("./languages.tsv")
              .Skip(1)
              .Select(line => Language.FromTsv(line))
              .ToList();

            foreach (var language in languages)
            {
                // Console.WriteLine(language.Prettify());
            }

            var basicInfos = languages.Select(x => $"{x.Year}, {x.Name}, {x.ChiefDeveloper}");

            var csharpLangs = languages.Where(x => x.Name == "C#");

            var microsoftLangs = languages.Where(x => x.ChiefDeveloper.Contains("Microsoft"));

            var lispLangs = languages.Where(x => x.Predecessors.Contains("Lisp"));

            var scriptLangs = languages
              .Where(x => x.Name.Contains("Script"))
              .Select(x => x.Name);

            // Console.WriteLine($"Number of languages: {languages.Count}");

            var nearMilleniumLangs = languages
            .Where(x => x.Year >= 1995 && x.Year <= 2005)
            .Select(x => $"{x.Name} was invented in {x.Year}");

            // Console.WriteLine($"Near millenium languages: {nearMilleniumLangs.Count()}");


        }

        public static void PrettyPrintAll(IEnumerable<Language> langs)
        {
            foreach (Language lang in langs)
            {
                Console.WriteLine(lang.Prettify());
            }
        }

        public static void PrintAll(IEnumerable<Object> sequence)
        {
            foreach (Object obj in sequence)
            {
                Console.WriteLine(obj);
            }
        }

    }
}
