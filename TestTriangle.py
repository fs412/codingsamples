# -*- coding: utf-8 -*-
"""
Updated Jan 21, 2018
The primary goal of this file is to demonstrate a simple unittest implementation

@author: jrr
@author: rk
"""

import unittest

from Triangle import classifyTriangle

# This code implements the unit test functionality
# https://docs.python.org/3/library/unittest.html has a nice description of the framework

class TestTriangles(unittest.TestCase):
    # define multiple sets of tests as functions with names that begin

    def testRightTriangleA(self): 
        self.assertEqual(classifyTriangle(3,4,5),'Scalene Right','3,4,5 is a Scalene Right triangle')

    def testRightTriangleB(self): 
        self.assertEqual(classifyTriangle(5,3,4),'Scalene Right','5,3,4 is a Scalene Right triangle')
        
    def testEquilateralTriangles(self): 
        self.assertEqual(classifyTriangle(1,1,1),'Equilateral','1,1,1 should be equilateral')

    def testIsoscelesTriangles(self): 
        self.assertEqual(classifyTriangle(5,5,6),'Isosceles','5,5,6 should be isosceles')

    def testInvalidInput(self): 
        self.assertEqual(classifyTriangle(-1,1,1),'InvalidInput')
        self.assertEqual(classifyTriangle(201,201,201),'InvalidInput')

    def testNotATriangle(self): 
        self.assertEqual(classifyTriangle(3,3,9),'NotATriangle')

if __name__ == '__main__':
    print('Running unit tests')
    unittest.main()

