""" My name is Fran Sabetpour and here is my script for Homework 5. """
import unittest
import string 
#part 1
def backwards(string):
    formed_string = []
    index = len(string)
    while index:
        index -= 1                       
        formed_string.append(string[index])
    return ''.join(formed_string)

class BackwardsTest(unittest.TestCase):

    def test_backwards(self):
        """ Test for reversal """
        self.assertTrue(("Hello") == backwards("olleH"))
        self.assertTrue(("world") == backwards("dlrow"))
        self.assertTrue(("Hi") != backwards("Farewell"))       
        self.assertFalse(("Hello") != backwards("olleH"))
        self.assertFalse(("Hello") == backwards("Farewell"))
        self.assertFalse(("Okay") == backwards("Byeeeee"))

#part 2
def rev_enumerate(seq):
    return [(i, seq[i]) for i in range(len(seq)-1, -1, -1)]

class EnumerateTest(unittest.TestCase):

    def test_rev_enumerate(self):
        """ Test for enumerate """
        self.assertEqual([(2, '!'), (1, 'i'), (0, 'H')], rev_enumerate("Hi!"))
        self.assertNotEqual([(2, '!'), (1, 'i'), (0, 'H')], rev_enumerate("Bye!"))
        
#part 3
def find_second(s1, s2):
    return s1.find(s2, s1.find(s2)+1)

class FindSecondTest(unittest.TestCase):

    def test_find_second(self):
        """ Test for find_second """
        s1 = "yeahyeah"
        s2 = "yea"
        self.assertTrue((4) == find_second(s1,s2))
        self.assertFalse((5) == find_second(s1,s2))

#part 4

def get_lines(path):
    fp = path
    with open(fp, 'r') as f:
        line = f.readline().strip('\r\n')
        while line != "":
            while line.endswith('\\')  :   
                line = line[:-1] + f.readline().strip('\r\n')
                
            if '#' in line:
                line = line[:line.find("#")]
        
            if line != "":
                yield line
            
            line = f.readline().strip('\r\n')

def main():
    file_name = "readme.txt"

    for line in get_lines(file_name):
        print(line)
        
class GetLinesTest(unittest.TestCase):

    def test_get_lines(self):
        file_name = "readme.txt"

        expect = ['<line0>', '<line1>', '<line2>', '<line3.1 line3.2 line3.3>','<line4.1 line4.2>', '<line5>', '<line6>']
        result = list(get_lines(file_name))
        self.assertEqual(result, expect)

if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)