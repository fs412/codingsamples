""" My name is Fran Sabetpour and the purpose of this script is to convert a word from singular form to plural form. """
def plural(word):
    if word.endswith(("ay", "ey", "iy", "oy", "uy")):
        return word + "s"    
    elif word.endswith("y"):
        return word[:-1] + "ies" 
    elif word.endswith(("o", "ch", "s", "sh", "x", "z")): 
        return word + "es" 
    else:
        return word + "s" 
word = input("Enter a noun that you would like to be converted from singular form to plural form: ").split(" ")
print(" ".join((plural(word.strip()) for word in word)))