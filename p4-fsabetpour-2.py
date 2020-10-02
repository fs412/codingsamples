""" My name is Fran Sabetpour and the purpose of this script is to run a Guess the Number game. """
import random

def guessedNumber(compNumber, guessNumber):
    if guessNumber < compNumber:
        return -1
    elif guessNumber > compNumber:
        return 1
    else:
        return 0

def game():
    compnumber = random.randint(1, 20)
    attempts = 1
    name = input("Hello! What is your name? ")
    print("Well, " + name + ", I am thinking of a number between 1 and 20. ")
    while True:
        try:
            if attempts < 6:
                guess = int(input("Take a guess. "))
        except ValueError:
                print("Enter a valid number. ")
                return
        if guess < 1:
            print("You have entered a number less than 1. Please enter between a range of 1 and 20.")
            continue
        if guess > 20:
            print("You have entered a number greater than 20. Please enter between a range of 1 and 20.")
            continue
        valuenumber = guessedNumber(compnumber, guess)
        if valuenumber == -1:
            print(f"Your guess was {guess}. Your guess is too low.")
            attempts = attempts + 1 
        elif valuenumber == 1:
            print(f"Your guess was {guess}. Your guess is too high.")
            attempts = attempts + 1 
        elif valuenumber == 0:
            print("Good job, " + name + "! You guessed my number in " + str(attempts) + " guess(es)!")
            return     
        if attempts == 6 : 
            print(f"You used up all 5 tries. The number I was thinking of was {compnumber}.")
            break


if __name__ == '__main__':
    game()
    while True:
        playagain = input("Would you like to play a game of Guess the Number? Press 'Y' for yes or 'N' for no. ")
        if playagain.lower() != "y":
            print("Exiting the game.")
            quit()
        else:
            game()