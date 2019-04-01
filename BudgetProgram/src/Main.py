'''
Created on Mar 13, 2019

This module is the driver for several other modules. In combination
this driver creates and manipulates a budget like program.

@author: Kaleb
'''

import dbMethods
import SpendingReport
import userInput
from userInput import getDateLastPaid, getItem, getAmount, \
    getExpectedMonthly, getDueDate, getNotes, getTheName, \
    getTheNewDate, getOldName, getAValue, getNewMonthly, \
    getAnID, getAccountBalance, getDesc

'''This main method utilizes all of the imported modules to get user 
input, store that input into a database and generate a report.'''


def Main():

    ans = 'y'
    choice = 0
    while choice != 11:
        choice = userInput.greeting()
        ans = 'y'
        # Add an account
        if choice == 1:
            createAccount = input('Would you like to add a new account(y/n)? ')
            if createAccount == 'y':
                account = getAccountBalance()
                aType = getDesc()
                dbMethods.addANewAccount(account, aType)
            print("\n")
        # Enter a transaction
        elif choice == 2:
            while ans == 'y':
                purchaser = userInput.getPurchaser()
                ven = userInput.getVendor()
                desc = userInput.getDesc()
                cat = userInput.getCategory()
                price = userInput.getAmount()
                dbMethods.addANewTransaction(purchaser, ven, desc, cat, price)
                ans = input("Input another(y/n)? ")
                print("\n")
        # Edit a transaction
        elif choice == 3:
            while ans == 'y':
                ans2 = userInput.updateATransaction()
                # Change the date
                if ans2 == 1:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newDate = userInput.getTheNewDate()
                        dbMethods.updateTransactionDate(anId, newDate)
                        ans = input("Update another(y/n)? ")
                # Change the purchaser
                elif ans2 == 2:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newPurchaser = userInput.getPurchaser()
                        dbMethods.updateTransactionPurchaser(anId, newPurchaser)
                        ans = input("Update another(y/n)? ")
                # Change the amount
                elif ans2 == 3:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newAmount = userInput.getAmount()
                        dbMethods.updateTransactionAmount(anId, newAmount)
                        ans = input("Update another(y/n)? ")
                # Change the vendor
                elif ans2 == 4:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newVen = userInput.getVendor()
                        dbMethods.updateTransactionVendor(anId, newVen)
                        ans = input("Update another(y/n)? ")
                # Change the description
                elif ans2 == 5:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newDesc = userInput.getDesc()
                        dbMethods.updateTransactionDesc(anId, newDesc)
                        ans = input("Update another(y/n)? ")
                # Change the category
                elif ans2 == 6:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        newCat = userInput.getCategory()
                        dbMethods.updateTransactionCategory(anId, newCat)
                        ans = input("Update another(y/n)? ")
                # Delete transaction by ID
                elif ans2 == 7:
                    while ans == 'y':
                        anId = userInput.getAnID()
                        dbMethods.deleteFromTransaction(anId)
                        ans = input("Delete another(y/n)? ")
                # Delete transaction by purchaser
                elif ans2 == 8:
                    while ans == 'y':
                        aP = userInput.getPurchaser()
                        dbMethods.deleteFromTransactionByName(aP)
                        ans = input("Delete another(y/n)? ")
                # Exit the loop
                elif ans2 == 9:
                    ans = 'n'
                    pass
                print("\n")
        # View transactions
        elif choice == 4:
            print(dbMethods.viewTransactions(0, '', '','', '', '', ''))
        # Add line item to the budgetDB
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
        # Add a line item to the budget
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
        # View the budget
        elif choice == 7:
            print(dbMethods.viewBudget())
        # Edit the budget
        elif choice == 8:
            while ans == 'y':
                ans = 'y'
                ans2 = userInput.updateAnItem()
                # Change date last paid
                if ans2 == 1:
                    while ans == 'y':
                        name = getTheName()
                        newDate = getTheNewDate()
                        dbMethods.updateBudgetDateLastPaid(name, newDate)
                        ans = input("Update another date last paid(y/n)? ")
                # Change item name
                elif ans2 == 2:
                    while ans == 'y':
                        oldName = getOldName()
                        newName = getTheName()
                        dbMethods.updateBudgetItemName(oldName, newName)
                        ans = input("Update another item name(y/n)? ")
                # Change item's value
                elif ans2 == 3:
                    while ans == 'y':
                        name = getTheName()
                        value = getAValue()
                        dbMethods.updateBudgetItemValue(name, value)
                        ans = input("Update another item value(y/n)? ")
                # Change item's value
                elif ans2 == 4:
                    while ans == 'y':
                        name = getTheName()
                        value = getAValue()
                        dbMethods.updateBudgetCurrentValue(name, value)
                        ans = input("Update another item value(y/n)? ")
                # Change expected monthly
                elif ans2 == 5:
                    while ans == 'y':
                        name = getTheName()
                        exp = getNewMonthly()
                        dbMethods.updateBudgetExpectedValue(name, exp)
                        ans = input("Update another expected value(y/n)? ")
                # Change due date
                elif ans2 == 6:
                    while ans == 'y':
                        name = getTheName()
                        newDate = getTheNewDate()
                        dbMethods.updateBudgetItemDueDate(name, newDate)
                        ans = input("Update another item due date(y/n)? ")
                # Change item notes
                elif ans2 == 7:
                    while ans == 'y':
                        name = getTheName()
                        note = getNotes()
                        dbMethods.updateBudgetItemNotes(name, note)
                        ans = input("Update another item's notes(y/n)? ")
                # Change item name
                elif ans2 == 8:
                    while ans == 'y':
                        name = getTheName()
                        dbMethods.deleteFromBudget(0, name, '')
                        ans = input("Delete another item by name(y/n)? ")
                # Delete an item by ID
                elif ans2 == 9:
                    while ans == 'y':
                        theId = getAnID()
                        dbMethods.deleteFromBudget(1, '', theId)
                        ans = input("Delete another item by ID(y/n)? ")
                # This resets the current values to the budgeted values
                elif ans2 == 10:
                    dbMethods.resetBudgetValues()
                # Reset a budget to a given period
                # period of 0: sets to 0, 1: period 1, 2: period 2
                elif ans2 == 11:
                    period = getAValue()
                    dbMethods.resetToBudgetPeriod(period)
                # Sets the items 
                elif ans2 == 12:
                    dbMethods.doTheWithdrawal()
                # Breaks the loop
                elif ans2 == 13:
                    ans = 'n'
                    pass
        # View accounts
        elif choice == 9:
            print(dbMethods.viewAccounts(), '\n')
        elif choice == 10:
            ans = 'y'
            ans2 = userInput.updateAnAccount()
            # Add to account balance 
            if ans2 == 1:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.addToAccountBalance(anID, newBalance)
                    ans = input("Add more(y/n)? ") 
            # Subtract form account balance
            elif ans2 == 2:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.subtractFromAccountBalance(anID, newBalance)
                    ans = input("Subtract more(y/n)? ")
            # Update account balance
            elif ans2 == 3:
                while ans == 'y':
                    anID = getAnID()
                    newBalance = getAValue()
                    dbMethods.updateAccountBalance(anID, newBalance)
                    ans = input("Update again(y/n)? ")
            # Update account type
            elif ans2 == 4:
                while ans == 'y':
                    anID = getAnID()
                    newType = getDesc()
                    dbMethods.updateAccountType(anID, newType)
                    ans = input("Update another type(y/n)? ")
            # Delete account from DB
            elif ans2 == 5:
                while ans == 'y':
                    anID = getAnID()
                    dbMethods.deleteFromAccount(anID)
                    ans = input("Delete another account(y/n)? ")
            # Break the loop
            elif ans2 == 6:
                ans = 'n'
                pass
    print("**Program terminated**")


Main()
