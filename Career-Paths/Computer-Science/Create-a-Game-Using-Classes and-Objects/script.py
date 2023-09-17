class Student:
    def __init__(self, name, age, grade):
        self.name = name
        self.age = age
        self.grade = grade

    def study(self, subject):
        print(f"{self.name} is studying {subject}.")

    def take_exam(self):
        print(f"{self.name} is taking an exam.")

    def __repr__(self):
        return f"Student(name='{self.name}', age={self.age}, grade={self.grade})"


class Teacher:
    def __init__(self, name, subject, experience):
        self.name = name
        self.subject = subject
        self.experience = experience

    def teach(self, student):
        print(f"{self.name} is teaching {student.name} {self.subject}.")

    def evaluate_student(self, student):
        print(f"{self.name} is evaluating {student.name}.")

    def __repr__(self):
        return f"Teacher(name='{self.name}', subject='{self.subject}', experience={self.experience})"


# Creating instances of the Student class
student1 = Student("Alice", 18, "A")
student2 = Student("Bob", 17, "B")

# Testing methods of the Student class
student1.study("Math")
student2.take_exam()

# Creating instances of the Teacher class
teacher1 = Teacher("Mr. Smith", "Physics", 10)
teacher2 = Teacher("Mrs. Johnson", "Chemistry", 5)

# Testing methods of the Teacher class
teacher1.teach(student1)
teacher2.evaluate_student(student2)

# Interactions between the two classes
teacher1.teach(student2)
student1.study("Physics")
