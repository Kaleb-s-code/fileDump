'''
Created on Mar 18, 2019

This module contains all of the methods that work with the 
database directly. 

@author: Kaleb
'''
import Budget
from Budget import TheBudget
from Budget import Transactions
from Budget import Accounts
from sqlalchemy import desc

'''
This method adds items to the database budget
'''
def addItemToDb(theDate, theName, theValue, theExpected, theDueDate, theNotes):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    newItem = TheBudget(theDate, theName, theValue, theExpected, theDueDate, theNotes)
    session.add(newItem)
    session.commit()
    session.close()
    print("**item added to budget**")
    
'''
This method adds items to the database budget
'''
def addAccountToDb(theBalance, theType):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    newAccount = Accounts(theBalance, theType)
    session.add(newAccount)
    session.commit()
    session.close()
    print("**Account added**")

'''
This method updates the account balance
'''
def updateAccountBalance(theID, theNewValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: theNewValue})
    session.commit()
    session.close()
    print("**Balance updated**")
    
'''
This method updates the account type
'''
def updateAccountType(theID, theType):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.type: theType})
    session.commit()
    session.close()
    print("**Account Type updated**")

'''
This method deletes from the database an item matching the name 
passed
'''
def deleteFromDbByName(theName):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theName).delete(synchronize_session=False)
    session.query(TheBudget).filter(TheBudget.itemName == theName).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Item with name: '", theName, "' deleted**")

'''
This method deletes from the database items matching the ID
'''
def deleteFromDbByID(theId):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemId == theId).delete(synchronize_session=False)
    session.query(TheBudget).filter(TheBudget.itemId == theId).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Item with ID: ", theId, " deleted**")
    
'''
This method deletes from the database items matching the ID
'''
def deleteAccountFromDbByID(theId):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Accounts).filter(Accounts.itemId == theId).delete(synchronize_session=False)
    session.query(Accounts).filter(Accounts.itemId == theId).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Account with ID: ", theId, " deleted**")


'''
This method adds items to the database budget and removes the value from
the budget table and the account balance in the account table.
'''
def addTransaction(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    newItem = Transactions(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount)
    session.add(newItem)
    session.commit()
    session.close()
    print("\n\n")
    print(viewAccounts())
    anId = int(input("Which account would you like to deduct from?: "))
    subtractFromAccountBalance(anId, theAmount)
    subtractFromBudgetItemValue(theCategory, theAmount)
    print("**item added to budget**")


'''
This method updates the items in the budget whenever a transaction is made.
This method is called from the method above and executed every time a new
transaction is made.
'''
def subtractFromBudgetItemValue(theCategory, theValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theCategory).update(
        {TheBudget.itemValue: TheBudget.itemValue - theValue})
    session.commit()
    session.close()
    
'''
This method updates the items in the Account whenever a transaction is made.
This method is called from the method above and executed every time a new
transaction is made.
'''
def subtractFromAccountBalance(theID, theValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: Accounts.balance - theValue})
    session.commit()
    session.close()

'''
This method updates the items in the Account whenever a transaction is made.
This method is called from the method above and executed every time a new
transaction is made.
'''
def AddToAccountBalance(theID, theValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: Accounts.balance + theValue})
    session.commit()
    session.close()

'''
This method updates the item name in the budget table
'''
def updateBudgetItemName(theOldName, theName):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theOldName).update(
        {TheBudget.itemName: theName})
    session.commit()
    session.close()
    print("**item updated**")

'''
This method updates the item value in the budget table
'''
def updateBudgetItemValue(theName, theNewValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.itemValue: theNewValue})
    session.commit()
    session.close()
    print("**item updated**")

'''
This method updates the date last paid for an item in the budget table
'''
def updateBudgetDateLastPaid(theName, theNewDate):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(
        TheBudget.itemName == theName).update(
            {TheBudget.dateLastPaid: theNewDate})
    session.commit()
    session.close()
    print("**item updated**")

'''
This method updates the expected monthly value in the budget table
'''
def updateBudgetExpectedValue(theName, theNewExpectedValue):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.expectedMonthlyValue: theNewExpectedValue})
    session.commit()
    session.close()
    print("**item updated**")

'''
This method updates the due date of the item in the budget table
'''
def updateBudgetItemDueDate(theName, theNewDate):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(
        TheBudget.itemName == theName).update(
            {TheBudget.dueDate: theNewDate})
    session.commit()
    session.close()  
    print("**item updated**")  

'''
This method updates the item item notes in the budget table
'''
def updateBudgetItemNotes(theName, theNewNotes):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.itemNotes: theNewNotes})
    session.commit()
    session.close()
    print("**item updated**")
    
'''
This method deletes from the database items matching the ID
'''
def deleteTransactionByID(theId):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theId).delete(
        synchronize_session=False)
    session.query(Transactions).filter(Transactions.itemId == theId).delete(
        synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Transaction with ID: ", theId, " deleted**")

'''
This method updates the item name in the budget table
'''
def updateTransactionDate(theID, theDate):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.dateOfTransaction: theDate})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")

'''
This method updates the item value in the budget table
'''
def updateTransactionPurchaser(theID, thePurchaser):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.purchaser: thePurchaser})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")

'''
This method updates the date last paid for an item in the budget table
'''
def updateTransactionAmount(theID, theAmount):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.amount: theAmount})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")

'''
This method updates the expected monthly value in the budget table
'''
def updateTransactionVendor(theID, theVen):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.vendor: theVen})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")

'''
This method updates the due date of the item in the budget table
'''
def updateTransactionDesc(theID, theDesc):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.description: theDesc})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**") 

'''
This method updates the item item notes in the budget table
'''
def updateTransactionCategory(theID, theCat):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.category: theCat})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")


'''
This method shows all of the info about the accounts
'''
def viewAccounts():
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    account = session.query(Accounts).all()
    for acc in account:
        result += ("Account ID: [{}]\nAccount Balance: ${:,.2f}\nAccount Type: {}\n\n".format(acc.itemId, acc.balance, acc.type))
    return result
    session.close()

'''
This method deletes from the database items matching the ID
'''
def viewTransactions():
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).all()
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
    
'''
This method deletes from the database items matching the ID
'''
def viewTransactionsByDate(theBeginDate, theEndDate):
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBeginDate,
                                               Transactions.dateOfTransaction <= theEndDate )
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
    
'''
This method deletes from the database items matching the ID
'''
def viewTransactionsByPurchaser(thePurchaser):
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(
        Transactions.purchaser == thePurchaser)
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
'''
This method deletes from the database items matching the ID
'''
def viewTransactionsByAmount(theAmount):
    result = ""

    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.amount == theAmount)
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
'''
This method deletes from the database items matching the ID
'''
def viewTransactionsByVendor(theVendor):
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.vendor == theVendor)
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
'''
This method deletes from the database items matching the ID
'''
def viewTransactionsByCategory(theCat):
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.category == theCat)
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
        
'''
This method deletes from the database items matching the ID
'''
def viewBudget():
    result = ""
    value = 0
    monthly = 0
    test = 0
    
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()
    noHealthInsurance = session.query(TheBudget).filter(TheBudget.itemName != 'medical & dental')
    accountBal = session.query(Accounts).all()
    result += ("|{0:<8}|\t |{1:<10}|\t |{2:<15}\t |{3:<10}|\t |{4:<15}|\t |{5:<7}|\t\n".format(
        'itemId', 'dateLastPaid', 'itemName', 'itemValue', 'expectedMonthly', 'dueDate'))
    for item in budg:
        result += ('{0:<8}\t {1:<10}\t {2:<15}\t {3:<10}\t {4:<15}\t {5:<7}\t\n'.format(str(item.itemId), str(item.dateLastPaid), 
                       str(item.itemName), str(item.itemValue), str(item.expectedMonthlyValue), str(item.dueDate)))
   
    for item in budg:
        value += float(item.itemValue)
    for item in noHealthInsurance:
        monthly += float(item.expectedMonthlyValue)
        
    result += '\nTOTAL BUDGETED: ${:0,.2f} | TOTAL MONTHLY: ${:1,.2f}\n'.format(value, monthly)
    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    for account in accountBal:
        result += 'TOTAL IN ACCOUNT: ${:0,.2f}, TYPE: {}\n'.format(account.balance, account.type)
        
    if test.balance - value > 0:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES: ${:0,.2f}\nSAVINGS TOTAL: ${:1,.2f}".format(
            0, test.balance - value)
    elif test.balance - value < 0:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES: ${:0,.2f}".format(abs(test.balance - value))
    else:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES: ${:0,.2f}".format(0)
        
    result += "\n\n"
    session.close()
    return result

def getDbItemsIntoArray():
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()
    result = []
    for item in budg:
        result.append([str(item.itemId), str(item.dateLastPaid), str(item.itemName), str(item.itemValue), 
        str(item.expectedMonthlyValue), str(item.dueDate)])
    return result

def getTotalBudgeted():
    value = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()

    for item in budg:
        value += float(item.itemValue)
    return value

def getAmountNeeded():
    result = ""
    value = 0
    test = 0
    
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()

    for item in budg:
        value += float(item.itemValue)

    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    if test.balance - value > 0:
        result += "${:1,.2f}".format(0, test.balance - value)
    elif test.balance - value < 0:
        result += "${:0,.2f}".format(abs(test.balance - value))
    else:
        result += "${:0,.2f}".format(0)
    return result

def getTotalSaved():
    result = ""
    value = 0
    test = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()
    for item in budg:
        value += float(item.itemValue)
  
    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    if test.balance - value > 0:
        result += "${:,.2f}".format(test.balance - value)
    else:
        result +="${:,.2f}".format(0)
    return result

def getTransactionsIntoArrayDescinding(theCat):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(
        Transactions.category == theCat).order_by(desc(
            Transactions.dateOfTransaction))
    result = []
    for item in trans:
        result.append([str(item.itemId), str(item.dateOfTransaction), str(item.purchaser), str(item.vendor), 
        str(item.description), str(item.category), str(item.amount)])
    return result

def getTheTotalSpent(theCat):
    result = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.category == theCat)
    for item in trans:
        result += item.amount
    return result

def totalNumberOfTransactions(theCat):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session.query(Transactions).filter(Transactions.category == theCat).count() 

def getTransactionsIntoArrayDescindingVendor(theVen):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(
        Transactions.vendor == theVen).order_by(desc(
            Transactions.dateOfTransaction))
    result = []
    for item in trans:
        result.append([str(item.itemId), str(item.dateOfTransaction), str(item.purchaser), str(item.vendor), 
        str(item.description), str(item.category), str(item.amount)])
    return result

def getTheTotalSpentVendor(theVen):
    result = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.vendor == theVen)
    for item in trans:
        result += item.amount
    return result

def totalNumberOfTransactionsVendor(theVen):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session.query(Transactions).filter(Transactions.vendor == theVen).count() 

def getTransactionsIntoArrayDescindingPurchaser(theP):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(
        Transactions.purchaser == theP).order_by(desc(
            Transactions.dateOfTransaction))
    result = []
    for item in trans:
        result.append([str(item.itemId), str(item.dateOfTransaction), str(item.purchaser), str(item.vendor), 
        str(item.description), str(item.category), str(item.amount)])
    return result

def getTheTotalSpentPurchaser(theP):
    result = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.purchaser == theP)
    for item in trans:
        result += item.amount
    return result

def totalNumberOfTransactionsPurchaser(theP):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session.query(Transactions).filter(Transactions.purchaser == theP).count() 

def getTransactionsIntoArrayDescindingDate(theBegin, theEnd):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBegin,
                                               Transactions.dateOfTransaction <= theEnd )
    result = []
    for item in trans:
        result.append([str(item.itemId), str(item.dateOfTransaction), str(item.purchaser), str(item.vendor), 
        str(item.description), str(item.category), str(item.amount)])
    return result

def getTheTotalSpentDate(theBegin, theEnd):
    result = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBegin,
                                               Transactions.dateOfTransaction <= theEnd )
    for item in trans:
        result += item.amount
    return result

def totalNumberOfTransactionsDate(theBegin, theEnd):
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session.query(Transactions).filter(Transactions.dateOfTransaction >= theBegin,
                                               Transactions.dateOfTransaction <= theEnd ).count()

def getTransactionsIntoArrayDescindingGeneral():
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).order_by(desc(Transactions.dateOfTransaction))
    result = []
    for item in trans:
        result.append([str(item.itemId), str(item.dateOfTransaction), str(item.purchaser), str(item.vendor), 
        str(item.description), str(item.category), str(item.amount)])
    return result

def getTheTotalSpentGeneral():
    result = 0
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    trans = session.query(Transactions).all()
    for item in trans:
        result += item.amount
    return result

def totalNumberOfTransactionsGeneral():
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session.query(Transactions).count() 



        
