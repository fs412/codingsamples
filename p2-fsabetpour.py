""" My name is Fran Sabetpour and the purpose of the script is to ask the user a quiz score and convert the score to a letter grade. """
try:
    score = float(input("Enter a score to get your equivalent letter grade:" ))
    if score >= 93 and score <= 100:
        print("Your letter grade is an A.")
    elif score >= 100:
        print("Enter a score that is less than 100.")
    elif score >= 90 and score < 93:
        print("Your letter grade is an A-.")
    elif score >= 87 and score < 90:
        print("Your letter grade is a B+.")
    elif score >= 83 and score < 87:
        print("Your letter grade is a B.")
    elif score >= 80 and score < 83:
        print("Your letter grade is a B-.")
    elif score >= 70 and score < 80:
        print("Your letter grade is a C.")
    elif score < 70 and score > 0:
        print("Your letter grade is a F.")
    elif score < 0:
        print("Enter a score that is a positive number.")
    else:
        print("Enter a valid number.")