""" My name is Fran Sabetpour and the purpose of this script is to provide a summary of the total words, total distinct words, top 25 most frequent words and counts and character frequency. """

import os
import operator
from string import punctuation

def classic_books(filename):
    try:
        if os.path.exists(filename) and os.path.getsize(filename) > 0:
            opener = open(filename, encoding = "utf-8")
            thefilename = opener.read()
        else:
            return "Invalid file name."
    except FileNotFoundError as error:
        return error
            
    diction = {}
    punc_translator = str.maketrans({key: None for key in punctuation})
    cleanString = thefilename.translate (punc_translator).lower().split()
    diction["number"] = len(cleanString)

    contain = {}
    for word in cleanString:
        contain[word]=contain.get(word,0)+1
    diction["distinct"] = len(contain)

    content = []
    for i, k in contain.items():
        content.append((k,i))
    content.sort(reverse = True)
    diction["freq"] = content

    characters = {}
    string = "".join(cleanString)
    for x in range (0, len(string)):
        c = string[x]
        if str.isalpha(c):
            characters[c] = characters.get(c,0) + 1

    index = []
    for i, k in characters.items():
        index.append((k,i))
    index.sort(reverse = True)
    diction["cc"] = index
    return diction


file_name = input ("Enter a file name: ")  
diff = classic_books(file_name)  
if not isinstance(diff, dict):
    print("An error has occured: ", diff)
else:
    if len(diff.keys()) > 0:
        if "number" in diff.keys():
            print("Total Number of Words: ", diff["number"])
        if "distinct" in diff.keys():
            print ("Total Number of Distinct Words: " , diff["distinct"] )
        if "freq" in diff.keys():
            if len(diff["freq"]) > 0:
                print ("Top 25 Most Frequent Words: ")
                for k, i in diff["freq"][:25]:
                    print (i, k)
        if "cc" in diff.keys():
            if len(diff["cc"]) > 0:
                print ("Frequency of characters: ")
                for k, i in diff["cc"]:
                    print (i, k)
