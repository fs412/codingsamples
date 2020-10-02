""" My name is Fran Sabetpour and this is the script for P10: Writing Regex. """

import re

def writing_regex():
    try:
        file_name = input("Enter a file name: ")
        fname = open(file_name)
    except: 
        print ("Invalid file name.")
        return
    total = 0
    count = 0
    for i in fname:
        a = re.findall(r"^New Revision:(\s*[0-9]*)", i)
        if a:  
            total += float(a [0])
            count += 1
        if count == 0:
            print("It looks like you entered a file with no 'New Revision' inside the file.")
            return           
    print("Average: {} ".format(round(total/count, 1)))
    print ("Number of lines = ", count)

if __name__ == '__main__':
    writing_regex()
    while True:
        tryagain = input("Would you like to try again? Press 'Y' for yes or 'N' for no. ")
        if tryagain.lower() != "y":
            print("Exiting the program.")
            quit()
        else:
            writing_regex()