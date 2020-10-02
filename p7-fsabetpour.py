""" My name is Fran Sabetpour and the purpose of this script is to read a file and to print out unique emails that have been sent to the user. """
def ReadEmails():
    file_name = input("Enter a file name: ")
    i = set()
    try:
        file_name = open(file_name)
    except:
        print ("Invalid file name.")
        return
    for line in file_name:
        if line.startswith("From:"):
            i.add(line)
    print(len(i))

if __name__ == '__main__':
    ReadEmails()
    while True:
        tryagain = input("Would you like to try again? Press 'Y' for yes or 'N' for no. ")
        if tryagain.lower() != "y":
            print("Exiting the program.")
            quit()
        else:
            ReadEmails()
