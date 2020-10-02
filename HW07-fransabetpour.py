""" My name is Fran Sabetpour and here is my script for Homework 7. """

import unittest 
from collections import defaultdict, Counter

#part 1.1

def an_anagram(str1, str2):
    firstword = list((str1).lower())
    secondword = list((str2).lower())
    if sorted(firstword) == sorted(secondword):
        return True

class AnAnagramTest(unittest.TestCase):

    def test_an_anagram(self):
        "Testing an anagram function"
        self.assertTrue(an_anagram("dormitory", "dirtyroom"))
        self.assertTrue(an_anagram("iceman", "cinema"))
        self.assertTrue(an_anagram("star", "rats"))
        self.assertFalse(an_anagram("cat", "dog"))

#part 1.2

def anagram(str1, str2):
    return sorted(str1) == sorted(str2)

def anagram_dd(str1, str2):
    dd = defaultdict(int)
    for i in str1:
        dd[i] += 1

    for i in str2:
        if i not in dd.keys():
            return False
        else:
            dd[i] -= 1
    return not any(dd.values())

class AnagramTest(unittest.TestCase):

    def test_anagram(self):
        "Testing the anagram function"
        self.assertTrue(anagram("dormitory", "dirtyroom"))
        self.assertTrue(anagram("iceman", "cinema"))
        self.assertTrue(anagram("star", "rats"))
        self.assertFalse(anagram("cat", "dog"))

    def test_anagram_dd(self):
        "Testing the anagram default dict function"
        self.assertTrue(anagram_dd("dormitory", "dirtyroom"))
        self.assertTrue(anagram_dd("iceman", "cinema"))
        self.assertTrue(anagram_dd("star", "rats"))
        self.assertFalse(anagram_dd("cat", "dog"))

#part 1.3

def anagram_counter(str1, str2):
    return Counter(str1) == Counter(str2)

class AnagramCounterTest(unittest.TestCase):

    def test_anagram_counter(self):
        "Testing anagram counter function"
        self.assertTrue(anagram_counter("dormitory", "dirtyroom"))
        self.assertTrue(anagram_counter("iceman", "cinema"))
        self.assertTrue(anagram_counter("star", "rats"))
        self.assertFalse(anagram_counter("cat", "dog"))

#part 2

def covers_alphabet(sentence):
    for letter in set("abcdefghijklmnopqrstuvwxyz"):
        if letter not in set(sentence.lower()):
            return False
    return True

class CoversAlphabetTest(unittest.TestCase):

    def test_covers_alphabet(self):
        "Testing covers alphabet function"
        self.assertTrue(covers_alphabet("abcdefghijklmnopqrstuvwxyz"))
        self.assertTrue(covers_alphabet("aabbcdefghijklmnopqrstuvwxyzzabc"))
        self.assertTrue(covers_alphabet("The quick brown fox jumps over the lazy dog"))
        self.assertTrue(covers_alphabet("We promptly judged antique ivory buckles for the next prize"))
        self.assertTrue(covers_alphabet("The quick, brown, fox; jumps over the lazy dog!"))
        self.assertFalse(covers_alphabet("xyz"))

#part 3

def book_index(words):
    dd = defaultdict(list)
    for item in sorted(words, key = lambda n: n[1]):
        if item[1] not in dd[item[0]]:
            dd[item[0]].append(item[1])
    return [[item[0], item[1]] for item in sorted(dd.items())] 

class BookIndexTest(unittest.TestCase):

    def test_book_index(self):
        "Testing book index function"

        woodchucks = [('how', 3), ('much', 3), ('wood', 3), ('would', 2), ('a', 1), ('woodchuck', 1), ('chuck', 3), ('if', 1), ('a', 1), ('woodchuck', 2), ('could', 2), ('chuck', 1), ('wood', 1)]
        should_return = [['a', [1]], ['chuck', [1, 3]], ['could', [2]], ['how', [3]], ['if', [1]], ['much', [3]], ['wood', [1, 3]], ['woodchuck', [1, 2]], ['would', [2]]]
        shouldntreturn = [['a', [10]], ['chuck', [10, 30]], ['could', [20]], ['how', [30]], ['if', [10]], ['much', [30]], ['wood', [10, 30]], ['woodchuck', [10, 20]], ['would', [20]]]
        self.assertTrue(book_index(woodchucks) == should_return)
        self.assertFalse(book_index(woodchucks) == shouldntreturn)

if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)