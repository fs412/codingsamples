""" My name is Fran Sabetpour and here is my script for Homework 6. """

import unittest

#part 1

def remove_vowels(s):
    return "".join([c for c in s if c.lower() not in 'aeiou'])

class RemoveVowelsTest(unittest.TestCase):

    def test_remove_vowels(self):
        """ Test for the remove vowels function """
        self.assertEqual(remove_vowels('hello'), "hll")
        self.assertEqual(remove_vowels('hello world'), "hll wrld")
        self.assertNotEqual(remove_vowels('hello'), "goodbye")

#part 2

def check_pwd(pwd):
    return any(i.isupper() for i in pwd) and any(i.islower() for i in pwd) and pwd[-1].isdigit()

class CheckPasswordTest(unittest.TestCase):

    def test_check_pwd(self):
        """ Test for the check password function """
        self.assertTrue(check_pwd("Psswrd1"))
        self.assertFalse(check_pwd("1111111"))
        self.assertFalse(check_pwd("!!!!!!"))
        self.assertFalse(check_pwd("Pass1word"))
        self.assertFalse(check_pwd("password"))
        self.assertFalse(check_pwd("PASSWORD"))
        self.assertFalse(check_pwd("PASSWORD1"))
        self.assertFalse(check_pwd("password1"))
        self.assertFalse(check_pwd("Password")) 
        self.assertFalse(check_pwd("PASSWORd"))
        self.assertFalse(check_pwd(""))
        self.assertFalse(check_pwd(" "))
        self.assertFalse(check_pwd("1Password"))   

#part 3

def insertion_sort(l):

    a_list = list()
    for i in l:
        for i, j in reversed(list(enumerate(a_list))):
            if i > j:
                a_list.insert(i+1, i)
                break
        else:
            a_list.insert(0, i)
    return a_list

class CheckInsertionSortTest(unittest.TestCase):

    def test_insertion_sort(self):
        """ Test for the insertion sort function """
        a = [0,0,1,2]
        self.assertEqual(insertion_sort(a), sorted(a))
        a = [1,0,1,2]
        self.assertNotEqual(insertion_sort(a), sorted(a))

#part 4

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BTree:
    def __init__(self, value=None):
        if not value:
            self.root = None
        else:
            self.root = Node(value)

    def insert(self,value):
        if self.root == None:
            self.root = Node(value)
        else:
            if (self.find(value)==True):
                return None
        current = self.root
        while True:
            if value < current.value:
                if current.left:
                    current = current.left
                else:
                    current.left= Node(value)
                    return
            elif value > current.value:
                if current.right:
                    current = current.right               
                else:
                    current.right= Node(value)
                    return

    def find(self,value):
        if self.root == None:
            return False
        current = self.root
        
        while True:
            if value < current.value:
                if current.left:
                    current = current.left
                else:
                    return False
            elif value > current.value:
                if current.right:
                    current = current.right               
                else:
                    return False
            else:
                return True

    def traverse_tree(current_node):
        if current_node is None:
            return []
        left=[]
        if current_node.left:
            left=BTree.traverse_tree(current_node.left)
        right=[]
        if current_node.right:
            right=BTree.traverse_tree(current_node.right)
        return left+[current_node.value]+right

                
    def traverse(self):
        return BTree.traverse_tree(self.root)

class BTreeTest(unittest.TestCase):

    def test_btree(self):
        """ Test for binary tree """
        bt = BTree(27)
        bt.insert(1)
        bt.insert(15)
        bt.insert(5)
        self.assertEqual(bt.traverse(), [1,5,15,27])
        self.assertTrue(bt.find(5))
        self.assertFalse(bt.find(55))

if __name__ == "__main__":
    unittest.main(exit=False, verbosity=2)