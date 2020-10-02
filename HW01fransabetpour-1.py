""" My name is Fran Sabetpour and here is my script for the classic "Rock, Paper, Scissors" game! """
def startover():
# User gets to input their choice between rock, paper, scissors.
    game = input("Let's play some Rock, Paper, Scissors! R = rock, S = scissors, P = paper. Press Q if you would like to quit. Now let's begin! Rock, paper, scissors, shoot! (Enter your answer): ")
    if game == "R":
        print("You have drawn rock!")
    elif game == "S":
        print("You have drawn scissors!")
    elif game == "P":
        print("You have drawn paper!")
# Here's an option for the user to quit the game.
    elif game == "Q":
        import sys
        sys.exit()
# Now, it is the computer's turn to make a random choice.
    play = ["rock", "paper", "scissors"]
    import random
    player = random.choice(play)
# This determines whether the user has lost, won, or got a tie.
    if game == "R" and player == "scissors":
        print("Computer draws scissors. You win!")
    elif game == "R" and player == "rock":
        print("Computer draws rock. We have a tie!")
    elif game == "R" and player == "paper":
        print("Computer draws paper. You lose!")
    if game == "P" and player == "scissors":
        print("Computer draws scissors. You lose!")
    elif game == "P" and player == "rock":
        print("Computer draws rock. You win!")
    elif game == "P" and player == "paper":
        print("Computer draws paper. We have a tie!")
    if game == "S" and player == "scissors":
        print("Computer draws scissors. We have a tie!")
    elif game == "S" and player == "paper":
        print("Computer draws paper. You lose!")
    elif game == "S" and player == "rock":
        print("Computer draws rock. You win!")
# Here is an option for the player to quit the game or try again.
    answer = input("Would you like to play again? Enter 'Y' for yes or 'N' for no. ")
    if answer == "N":
        import sys
        sys.exit()
    if answer == "Y":
        print("Alright! Let's play again!")  
while True:  
    startover()