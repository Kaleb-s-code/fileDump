'''
Created on Mar 13, 2019

This module gets a number of user inputs and tests them for 
relevance in the budget program.  

@author: Kaleb
'''

'''This method serves as the initial greeting and menu which will 
determine the course of the program.'''
def greeting():
    retry = True
    ans = "y"
    greet = 0
    print(
          "Pick from one of the following menu options\n\n", 
          "1.) Enter a transaction\n", 
          "2.) View transactions\n", 
          "3.) Generate a report\n", 
          "4.) Create a budget\n",
          "5.) View a budget\n", 
          "6.) Edit a budget\n", 
          "7.) Exit program")
    while retry or ans == "n":
        try:
            greet = int(input('Enter a number: '))
            print("You have selected ", greet)
            ans = input("\ncontinue(y/n)? ")
            retry = False
        except Exception as e:
            print('Try Again: ', e)
            retry = True 
    return greet

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


''' This method gets the date last paid'''
def getDateLastPaid():
    date = input("Enter the date you last paid this item:\
    (If this item does not associate with a date enter '0000-00-00'): ")
    return date

''' This method gets the due date for a budget line item'''
def getDueDate():
    date = input("Enter the due date:\
    (If this item does not associate with a date enter '0000-00-00'): ")
    return date

''' This method gets the due date for a budget line item'''
def getNotes():
    note = input("Enter a note associated with this line item: \n\
    (If this item does not need a note, enter '')")
    return note


'''This method gets the category under
 which the transaction should fall'''
def getCategory():
    retry = True
    cat = ''
    options = ["additions", "deductions", "mortgage", "hoa", "student loans",
               "ipad", "car insurance", "medical dental", "sprint", "xfinity",
               "groceries", "donations", "allowance", "netflix", "ymca", "hp instant ink",
               "fuel", "pse", "home needs", "state farm", "healthy paws", "date night",
               "wishlist", "other"]
    while retry or cat not in options:
        try:
            cat = input("Enter a category: ")
            cat = cat.lower()
            retry = False
        except Exception:
            print('Try Again')
            retry = True
    return cat

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

