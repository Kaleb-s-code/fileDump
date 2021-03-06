'''
Created on Mar 13, 2019

This module gets a number of user inputs and tests them for 
relevance in the budget program.  

@author: Kaleb
'''

'''This method serves as the initial greeting and menu which will 
determine the course of the program.'''
from datetime import datetime

# Menu options
#=======================================================================
def greeting():
    retry = True
    ans = "y"
    greet = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Add an account\n",
          "2.) Enter a transaction\n",
          "3.) Edit a transaction\n",
          "4.) View transactions\n", 
          "5.) Generate a report\n", 
          "6.) Add a line item to a budget\n",
          "7.) View a budget\n", 
          "8.) Edit the budget\n",
          "9.) View Accounts\n",
          "10.) Edit Accounts\n",
          "11.) Exit program")
    while retry or ans == "n":
        try:
            greet = int(input('Enter a number: '))
            print("You have selected ", greet)
            ans = input("\ncontinue(y/n)? \n")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return greet

'''This is the secondary menu for changing things in the database'''
def updateAnItem():
    retry = True
    ans = "y"
    choice = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Update the date last paid\n", 
          "2.) Update the item name\n", 
          "3.) Update the item's budgeted value\n",
          "4.) Update an item's current value\n", 
          "5.) Update the expected monthly value\n",
          "6.) Update the due date\n", 
          "7.) Update an item's notes\n",
          "8.) Delete an item by name\n",
          "9.) Delete an item by ID\n",
          "10.) Set current values to budgeted values\n",
          "11.) Set budget period\n",
          "12.) Withdrew the cash\n",
          "13.) Go back")
    while retry or ans == "n":
        try:
            choice = int(input('Enter a number: '))
            print("You have selected ", choice)
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return choice

'''This is the secondary menu for changing things in the database'''
def updateAnAccount():
    retry = True
    ans = "y"
    choice = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Add to account balance\n",
          "2.) Subtract from Account balance\n", 
          "3.) Update account balance\n", 
          "4.) Update account type\n", 
          "5.) Delete an account\n",
          "6.) Go back")
    while retry or ans == "n":
        try:
            choice = int(input('Enter a number: '))
            print("You have selected ", choice)
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return choice

'''This is the secondary menu for changing things in the database'''
def updateATransaction():
    retry = True
    ans = "y"
    choice = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Change the date of a transaction\n",
          "2.) Change the purchaser\n", 
          "3.) Change the amount\n", 
          "4.) Change the vendor\n", 
          "5.) Change the description\n",
          "6.) Change the category\n",
          "7.) Delete a transaction by ID\n",
          "8.) Delete transactions by purchaser\n",
          "9.) Go back")
    while retry or ans == "n":
        try:
            choice = int(input('Enter a number: '))
            print("You have selected ", choice)
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return choice

'''This is a menu for changing guiding transaction reports'''
def reportOptions():
    retry = True
    ans = "y"
    choice = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Generate a general transaction report\n",
          "2.) Generate transaction report by date\n", 
          "3.) Generate transaction report by purchaser\n", 
          "4.) Generate transaction report by amount \n", 
          "5.) Generate report by vendor\n",
          "6.) Generate transaction report by category\n",
          "7.) Print the budget\n",
          "8.) Go back")
    while retry or ans == "n":
        try:
            choice = int(input('Enter a number: '))
            print("You have selected ", choice)
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return choice

# Money & ID getters
#=======================================================================
'''This method gets the starting account balance'''
def getAccountBalance():
    retry = True
    ans = "y"
    accountBal = 0

    while retry or ans == "n":
        try:
            accountBal = float(input('Enter your current account balance: '))
            print("You input: ${:0,.2f}".format(accountBal))
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return accountBal

def getAValue():
    retry = True
    value = 0
    while retry == True:
        try:
            value = float(input("Enter a value: "))
            retry = False
        except Exception as e:
            print('Try again: ', e)
            retry = True
    return value

def getAnID():
    retry = True
    ID = 0
    while retry == True:
        try:
            ID = float(input("Enter an ID: "))
            retry = False
        except Exception as e:
            print('Try again: ', e)
            retry = True
    return ID

def getNewMonthly():
    exp = float(input("Enter new monthly expected value: "))
    return exp

'''This method gets the amount that the transaction came to'''
def getAmount():
    retry = True
    while retry:
        try:
            price = float(input('Enter an amount: '))
            retry = False
        except Exception:
            print('Try Again')
            retry = True
    return price  
 
'''This method gets the amount that the transaction came to'''
def getExpectedMonthly():
    retry = True
    while retry:
        try:
            price = float(input('Enter the anticipated monthly cost of this item: '))
            retry = False
        except Exception:
            print('Try Again')
            retry = True
    return price 

# Date getters
#=======================================================================
'''This just gets the start date for the budget'''
def getStartDate():
    retry = True
    while retry == True:
        date = input("Enter the start date(YYYY-MM-DD): ")
        try:
            date = datetime.strptime(date, '%Y-%m-%d')
            retry = False
        except Exception as e:
            print('Try again: ', e)
            retry = True
    return date

'''This just gets the end date for the budget'''
def getEndDate():
    retry = True
    while retry == True:
        date = input("Enter the end date(YYYY-MM-DD): ")
        try:
            date = datetime.strptime(date, '%Y-%m-%d')
            retry = False
        except Exception as e:
            print('Try again: ', e)
            retry = True
    return date

''' This method gets the date last paid'''
def getDateLastPaid():
    date = input("Enter the date you last paid this item\
    (If this item does not associate with a date enter '0000-00-00'): ")
    return date

''' This method gets the due date for a budget line item'''
def getDueDate():
    date = input("Enter the due date\
    (If this item does not associate with a date enter '0000-00-00'): ")
    return date

def getTheNewDate():
    date = input("Enter the new date(YYYY-MM-DD): ")
    return date

# String getters
#=======================================================================
'''This method just gets the name of the purchaser'''
def getPurchaser():
    who = input("Who made the transaction?: ")
    return who.lower()

'''This method just gets the vendor'''
def getVendor():
    ven = input("Enter a vendor: ")
    return ven.lower()

'''This method gets the justification for the transaction'''
def getDesc():
    just = input("Enter a description: ")
    return just.lower()

'''This method gets the name of the line item to be added to the 
budget.'''
def getItem():
    itemName = input("Enter a name for this budget line item: ")
    return itemName.lower()

''' This method gets the due date for a budget line item'''
def getNotes():
    note = input("Enter a note associated with this line item\
    (If this item does not need a note, enter ''): ")
    return note.lower()

def getOldName():
    itemName = input("Enter the old name: ")
    return itemName.lower()

def getTheName():   
    itemName = input("Enter a name: ")
    return itemName.lower()  

'''This method gets the category under
 which the transaction should fall'''
def getCategory():
    retry = True
    cat = ''
    options = ["additions", "deductions", "mortgage", "hoa", "student loans",
               "ipad", "car insurance", "medical dental", "sprint", "xfinity",
               "groceries", "donations", "allowance", "netflix", "ymca", "hp instant ink",
               "fuel", "pse", "home needs", "state farm", "healthy paws", "date night",
               "wishlist", "buffer","other", "addition", "deduction", "adjustment", "income", "savings"]
    while retry or cat not in options:
        try:
            cat = input("Enter a category: ")
            cat = cat.lower()
            retry = False
        except Exception:
            print('Try Again')
            retry = True
    return cat
