import random


class Question:
    def __init__(self, question, options, correct_option):
        self.question = question
        self.options = options
        self.correct_option = correct_option

    def ask_question(self):
        print(self.question)
        for i, option in enumerate(self.options, 1):
            print(f"{i}. {option}")

        user_answer = input("Select the correct option (1-4): ")
        if user_answer.isdigit() and 1 <= int(user_answer) <= 4:
            user_answer = int(user_answer)
            if user_answer == self.correct_option:
                return True
        print("Sorry, that's incorrect!")
        return False

    def __repr__(self):
        return self.question


def play_game():
    questions = [
        Question("What is the capital of France?", [
                 "London", "Paris", "Berlin", "Madrid"], 2),
        Question("Which planet is known as the Red Planet?",
                 ["Mars", "Venus", "Jupiter", "Saturn"], 1),
        Question("What is the largest mammal in the world?", [
                 "Elephant", "Giraffe", "Blue Whale", "Hippopotamus"], 3),
        Question("Which gas do plants absorb from the atmosphere?", [
                 "Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"], 2),
    ]

    random.shuffle(questions)
    
    total_winnings = 0
    secured_winnings = 0

    for i, question in enumerate(questions):
        print(f"\nQuestion {i + 1}: {question}")
        if question.ask_question():
            total_winnings += 1000
            print(f"Congratulations! You've won ${total_winnings}")
        else:
            print(f"Game Over! You've won ${secured_winnings}")
            break

        if i == 2:
            secured_winnings = total_winnings

    print(f"\nTotal Winnings: ${total_winnings}")


if __name__ == "__main__":
    play_game()
