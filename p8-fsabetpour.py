""" My name is Fran Sabetpour and the purpose of this script is to read a file and to print out the email address and the number of emails sent by that email address that sent the most emails. """
def ReadEmails():
    file_name = input("Enter a file name: ")
    count = dict()
    try:
        file_name = open(file_name)
    except:
        print ("Invalid file name.")
        return
    for line in file_name:
        email = line.split()
        if line.startswith("From:"):
            count[email[1]] = count.get(email[1], 0) + 1
    most = 0
    address = ""
    for i in count:
        if count[i] > most:
            most = count[i]
            address = i
    print(address, most)

if __name__ == '__main__':
    ReadEmails()
    while True:
        tryagain = input("Would you like to try again? Press 'Y' for yes or 'N' for no. ")
        if tryagain.lower() != "y":
            print("Exiting the program.")
            quit()
        else:
            ReadEmails()
