# An abstract method is a method that is declared, but contains no implementation. Abstract classes may not be
# instantiated, and its abstract methods must be implemented by its subclasses. ... The 'abc' module in Python library
# provides the infrastructure for defining custom abstract base classes

from abc import ABC, abstractmethod


class Animal:

    @abstractmethod
    def sound(self):
        pass


class Lion(Animal):
    def sound(self):
        print("roar")


class Dog(Animal):
    def sound(self):
        print("woof")


com = Lion()
com.sound()