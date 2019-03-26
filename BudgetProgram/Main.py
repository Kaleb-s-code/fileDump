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
from _datetime import date, datetime
from userInput import getDateLastPaid, getItem, getAmount, \
    getExpectedMonthly, getDueDate, getNotes, updateAnItem, getTheName, \
    getTheNewDate, getOldName, getAValue, getNewMonthly, \
    getAnID, getStartDate, getEndDate, getAccountBalance, getDesc
from dbMethods import addANewAccount
from SpendingReport import generateReportByCategory, \
    generateReportByDate, generateReportByPurchaser, \
    generateReportByAmount

'''This main method utilizes all of the imported modules to get user 
input, store that input into a database and generate a report.'''


def Main():

    ans = 'y'
    choice = 0
    while choice != 11:
        choice = userInput.greeting()
        ans = 'y'
        if choice == 1:
            createAccount = input('Would you like to add a new account(y/n)? ')
            if createAccount == 'y':
                account = getAccountBalance()
                aType = getDesc()
                dbMethods.addANewAccount(account, aType)
            print("\n")
        elif choice == 2:
            theDate = date.today()
            while ans == 'y':
                purchaser = userInput.getPurchaser()
                ven = userInput.getVendor()
                desc = userInput.getDesc()
                cat = userInput.getCategory()
                price = userInput.getAmount()
                dbMethods.addANewTransaction(theDate, purchaser, ven, desc, cat, price)
                ans = input("Input another(y/n)? ")
                print("\n")
        elif choice == 3:
            while ans == 'y':
                ans2 = userInput.updateATransaction()
                if ans2 == 1:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newDate = userInput.getTheNewDate()
                        dbMethods.updateTransactionDate(anId, newDate)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 2:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newPurchaser = userInput.getPurchaser()
                        dbMethods.updateTransactionPurchaser(anId, newPurchaser)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 3:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newAmount = userInput.getAmount()
                        dbMethods.updateTransactionAmount(anId, newAmount)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 4:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newVen = userInput.getVendor()
                        dbMethods.updateTransactionVendor(anId, newVen)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 5:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newDesc = userInput.getDesc()
                        dbMethods.updateTransactionDesc(anId, newDesc)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 6:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newCat = userInput.getCategory()
                        dbMethods.updateTransactionCategory(anId, newCat)
                        ans = input("Update another(y/n)? ")
                elif ans2 == 7:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        dbMethods.deleteFromTransaction(anId)
                        ans = input("Delete another(y/n)? ")
                elif ans2 == 8:
                    pass
                print("\n")
        elif choice == 4:
            print(dbMethods.viewTransactions(0, '', '','', '', '', ''))
        elif choice == 5:
            ans = 'y'
            while ans == 'y':
                ans2 = userInput.reportOptions()
                if ans2 == 1:
                    SpendingReport.generateGeneralReport()
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 2:
                    begin = userInput.getStartDate()
                    end = userInput.getEndDate()
                    SpendingReport.generateReportByDate(begin, end)
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 3:
                    name = userInput.getDesc()
                    SpendingReport.generateReportByPurchaser(name)
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 4:
                    amount = userInput.getAmount()
                    SpendingReport.generateReportByAmount(amount)
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 5:
                    ven = userInput.getVendor()
                    SpendingReport.generateReportByVendor(ven)
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 6:
                    cat = userInput.getCategory()
                    SpendingReport.generateReportByCategory(cat)
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 7:
                    SpendingReport.createWordDocumentOfBudget()
                    ans = input("Generate another report(y/n)? ")
                elif ans2 == 8:
                    ans = 'n'
                    pass
        elif choice == 6:
            ans = 'y'
            while ans == 'y':
                name = getItem()
                aDate = getDateLastPaid()
                anAmount = getAmount()
                expected = getExpectedMonthly()
                due = getDueDate()
                note = getNotes()
                dbMethods.addLineItemToBudget(aDate, name, anAmount, expected, due, note)
                ans = input("Input another(y/n)? ")
                print("\n")
        elif choice == 7:
            print(dbMethods.viewBudget())
        elif choice == 8:
            ans = 'y'
            ans2 = userInput.updateAnItem()
            if ans2 == 1:
                while ans == 'y':
                    name = getTheName()
                    newDate = getTheNewDate()
                    dbMethods.updateBudgetDateLastPaid(name, newDate)
                    ans = input("Update another date last paid(y/n)? ")
            elif ans2 == 2:
                while ans == 'y':
                    oldName = getOldName()
                    newName = getTheName()
                    dbMethods.updateBudgetItemName(oldName, newName)
                    ans = input("Update another item name(y/n)? ")
            elif ans2 == 3:
                while ans == 'y':
                    name = getTheName()
                    value = getAValue()
                    dbMethods.updateBudgetItemValue(name, value)
                    ans = input("Update another item value(y/n)? ")
            elif ans2 == 4:
                while ans == 'y':
                    name = getTheName()
                    exp = getNewMonthly()
                    dbMethods.updateBudgetExpectedValue(name, exp)
                    ans = input("Update another expected value(y/n)? ")
            elif ans2 == 5:
                while ans == 'y':
                    name = getTheName()
                    newDate = getTheNewDate()
                    dbMethods.updateBudgetItemDueDate(name, newDate)
                    ans = input("Update another item due date(y/n)? ")
            elif ans2 == 6:
                while ans == 'y':
                    name = getTheName()
                    note = getNotes()
                    dbMethods.updateBudgetItemNotes(name, note)
                    ans = input("Update another item's notes(y/n)? ")
            elif ans2 == 7:
                while ans == 'y':
                    name = getTheName()
                    dbMethods.deleteFromBudget(0, name, '')
                    ans = input("Delete another item by name(y/n)? ")
            elif ans2 == 8:
                while ans == 'y':
                    theId = getAnID()
                    dbMethods.deleteFromBudget(1, '', theId)
                    ans = input("Delete another item by ID(y/n)? ")
            elif ans2 == 9:
                pass
        elif choice == 9:
            print(dbMethods.viewAccounts(), '\n')
        elif choice == 10:
            ans = 'y'
            ans2 = userInput.updateAnAccount()
            if ans2 == 1:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.addToAccountBalance(anID, newBalance)
                    ans = input("Add more(y/n)? ")
            elif ans2 == 2:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.subtractFromAccountBalance(anID, newBalance)
                    ans = input("Subtract more(y/n)? ")
            elif ans2 == 3:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.updateAccountBalance(anID, newBalance)
                    ans = input("Update again(y/n)? ")
            elif ans2 == 4:
                while ans == 'y':
                    anID = getAnID()
                    newType = getDesc()
                    dbMethods.updateAccountType(anID, newType)
                    ans = input("Update another type(y/n)? ")
            elif ans2 == 5:
                while ans == 'y':
                    anID = getAnID()
                    dbMethods.deleteFromAccount(anID)
                    ans = input("Delete another account(y/n)? ")
            elif ans2 == 6:
                pass
    print("**Program terminated**")


Main()
