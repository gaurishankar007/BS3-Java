from threading import *
from time import sleep
# There are two ways for threading


class MyThread(Thread):  # If you give "Thread" then you must have to name the method "run" (Way1)
    def run(self):
        for x in range(6):
            print("hello", current_thread().getName())


obj = MyThread()
obj.start()
obj.join()
print("bye bye", current_thread().getName())


class Ax(Thread):
    def run(self):
        for i in range(100):
            print("Hello")
            sleep(0.2)


class Ax1(Thread):
    def run(self):
        for i in range(100):
            print("Hi")
            sleep(0.2)


Obj = Ax()
Obj1 = Ax1()
Obj.start()
Obj1.start()
print("abc")


class Ex:  # Way 2
    def test(self):
        for i in range(5):
            print("Hello")
            sleep(0.5)


class Ex1:
    def sum(self):
        for i in range(10):
            print("Hi")
            sleep(0.5)


obj1 = Ex()
obj2 = Ex1()
t1 = Thread(target=obj1.test())
t2 = Thread(target=obj2.sum())
t1.start()
t2.start()