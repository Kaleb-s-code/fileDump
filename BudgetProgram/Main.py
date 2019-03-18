'''
Created on Mar 13, 2019

This module is the driver for several other modules. In combination
this driver creates and manipulates a budget like program.

@author: Kaleb
'''
import Budget
import dbMethods
import SpendingReport
import userInput
from _datetime import date
from userInput import getDateLastPaid, getItem, getAmount,\
    getExpectedMonthly, getDueDate, getNotes

'''This main method utilizes all of the imported modules to get user 
input, store that input into a database and generate a report.'''


def Main():
    ans = 'y'
    choice = 0
    myFile = open('Charges.txt', 'w+')
    while choice != 7:
        choice = userInput.greeting()
        ans = 'y'
        if choice == 1:
            theDate = date.today()
            while ans == 'y':
                purchaser = userInput.getPurchaser()
                ven = userInput.getVendor()
                desc = userInput.getDesc()
                cat = userInput.getCategory()
                price = userInput.getAmount()
                dbMethods.addTransaction(theDate, purchaser, ven, desc, cat, price)
                ans = input("Input another(y/n)? ")
                print("\n")
        elif choice == 2:
            print(dbMethods.viewTransactions())
        elif choice == 3:     
            SpendingReport.generateReport(myFile)
        elif choice == 4:
            ans = 'y'
            while ans == 'y':
                name = getItem()
                aDate = getDateLastPaid()
                anAmount = getAmount()
                expected = getExpectedMonthly()
                due = getDueDate()
                note = getNotes()
                dbMethods.addItemToDb(aDate, name, anAmount, expected, due, note)
                ans = input("Input another(y/n)? ")
                print("\n")
        elif choice == 5:
            print(dbMethods.viewBudget())
    print("**Program terminated**")
Main()
