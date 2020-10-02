""" My name is Fran Sabetpour and the purpose of this script is to be able to make a function that provides the maximum of the 3 values given by the user. """
def maxOfThree():
    if maxOfThree1 >= maxOfThree2 and maxOfThree1 >= maxOfThree3:
        maximum = maxOfThree
    elif maxOfThree2 >= maxOfThree3 and maxOfThree2 >= maxOfThree2:
        maximum = maxOfThree2
    else:
        maximum = maxOfThree3
    try: 
        maxOfThree1 = float(input("Enter the first value. " ))
        maxOfThree2 = float(input("Enter second value. " ))
        maxOfThree3 = float(input("Enter third value. " ))
    except:
        print("Enter a valid number.")
    return
    
    print("The maximum of " + maxOfThree1 + "," + maxOfThree2 + "and" + maxOfThree3 + "is: " + maximum "." )