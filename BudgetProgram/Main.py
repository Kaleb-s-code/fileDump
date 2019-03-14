'''
Created on Mar 13, 2019

This module is the driver for several other modules. In combination
this driver creates and manipulates a budget like program.

@author: Kaleb
'''

import DatabaseMethods
import SpendingReport
import userInput

'''This main method utilizes all of the imported modules to get user 
input, store that input into a database and generate a report.'''
def Main():
    ans = 'y'
    choice = 0
    myConnect = DatabaseMethods.connect()
    DatabaseMethods.createTable(myConnect)
    myFile = open('Charges.txt', 'w+')
    while choice != 7:
        choice = userInput.greeting()
        ans = 'y'
        if choice == 1:
            while ans == 'y':
                purchaser = userInput.getPurchaser()
                ven = userInput.getVendor()
                just = userInput.getJust()
                cat = userInput.getCategory()
                price = userInput.getAmount()
                DatabaseMethods.storeTransaction(purchaser, ven, just, cat, price, myConnect)
                ans = input("Input another(y/n)? ")
                print("\n")
        elif choice == 2:
            DatabaseMethods.showDataBase(myConnect)
        elif choice == 3:     
            SpendingReport.generateReport(myConnect, myFile)
    print("**Program terminated**")
    
    myConnect.close()
Main()
