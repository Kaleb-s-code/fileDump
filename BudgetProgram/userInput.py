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
def getJust():
    just = input("Enter a description: ")
    return just.lower()

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
            price = float(input('Enter transaction amount: '))
            retry = False
        except Exception:
            print('Try Again')
            retry = True
    return price    

