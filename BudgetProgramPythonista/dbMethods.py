'''
Created on Mar 25, 2019

@author: Kaleb
'''
import Budget
from Budget import TheBudget
from Budget import Transactions
from Budget import Accounts
from sqlalchemy import desc
from userInput import getAccountBalance
from datetime import datetime

def newSession():
#     Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    return session;

'''
Addition methods
===================================================================
'''     
def addLineItemToBudget(theDateLastPaid, theName, theValue, theExpected, theDueDate, theNotes):
    session = newSession()
    newItem = TheBudget(theDateLastPaid, theName, theValue, theExpected, theDueDate, theNotes)
    session.add(newItem)
    session.commit()
    session.close()
    print("**item added to budget**")
    
def addANewTransaction(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount):
    today = datetime.today()
    newBalance = 0
    anId = 0
    session = newSession()
    bills = ['mortgage', 'hoa', 'student loans', 'ipad', 'car insurance', 
             'sprint', 'xfinity', 'medical & dental', 'donations', 'netflix', 
             'hp instant ink', 'ymca', 'pse', 'healthy paws']
    # This checks to see if a transaction is a bill,
    # then sets the date paid to the current date if so
    if theCategory in bills:
        theDate = today.strftime('%Y-%m-%d')
        updateBudgetDateLastPaid(theCategory, theDate)
    print("\n\n")
    print(viewAccounts())
    
    if theCategory == 'addition' or 'income':
        anId = int(input('Enter an account ID to add to: '))
        newBalance = float(getCurrentBalance(anId)) + theAmount
        addToAccountBalance(anId, theAmount)
    elif theCategory == 'adjustment': 
        anId = int(input("Enter the ID for the account you'd like to adjust: "))
        newBalance = theAmount
    else:
        anId = int(input("Enter the ID for the account you'd like to deduct from: "))
        if anId != 0:
            newBalance = float(getCurrentBalance(anId)) - theAmount
            subtractFromAccountBalance(anId, theAmount)
            subtractFromBudgetItemValue(theCategory, theAmount)
        elif anId == 0 or anId == '':
            subtractFromBudgetItemValue(theCategory, theAmount)
            newBalance = float(getCurrentBalance(anId))
            
    newItem = Transactions(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount, newBalance, anId)
    session.add(newItem)
    session.commit()
    session.close()
    print("**Transaction recorded**")
    
def addANewAccount(theBalance, theType):
    session = newSession()
    newAccount = Accounts(theBalance, theType)
    session.add(newAccount)
    session.commit()
    session.close()
    print("**Account added**")
    
def addToAccountBalance(theID, theValue):
    session = newSession()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: Accounts.balance + theValue})
    session.commit()
    session.close()

'''
Update methods
===================================================================
''' 
# Account Updates 
def updateAccountBalance(theID, theNewValue):
    session = newSession()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: theNewValue})
    session.commit()
    session.close()
    print("**Balance updated**")
    
def updateAccountType(theID, theType):
    session = newSession()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.type: theType})
    session.commit()
    session.close()
    print("**Account Type updated**")
    
# Budget Updates
def updateBudgetItemName(theOldName, theName):
    session = newSession()
    session.query(TheBudget).filter(TheBudget.itemName == theOldName).update(
        {TheBudget.itemName: theName})
    session.commit()
    session.close()
    print("**item updated**")
    
def updateBudgetItemValue(theName, theNewValue):
    session = newSession()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.budgetedValue: theNewValue})
    session.commit()
    session.close()
    print("**item updated**")
    
def updateBudgetDateLastPaid(theName, theNewDate):
    session = newSession()
    session.query(TheBudget).filter(
        TheBudget.itemName == theName).update(
            {TheBudget.dateLastPaid: theNewDate})
    session.commit()
    session.close()
    print("**item updated**")
    
def updateBudgetExpectedValue(theName, theNewExpectedValue):
    session = newSession()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.expectedMonthlyValue: theNewExpectedValue})
    session.commit()
    session.close()
    print("**item updated**")
    
def updateBudgetItemDueDate(theName, theNewDate):
    session = newSession()
    session.query(TheBudget).filter(
        TheBudget.itemName == theName).update(
            {TheBudget.dueDate: theNewDate})
    session.commit()
    session.close()  
    print("**item updated**")
    
def updateBudgetItemNotes(theName, theNewNotes):
    session = newSession()
    session.query(TheBudget).filter(TheBudget.itemName == theName).update(
        {TheBudget.itemNotes: theNewNotes})
    session.commit()
    session.close()
    print("**item updated**")
    
# Transaction Updates
def updateTransactionDate(theID, theDate):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.dateOfTransaction: theDate})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")
    
def updateTransactionPurchaser(theID, thePurchaser):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.purchaser: thePurchaser})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")
    
def updateTransactionAmount(theID, theAmount):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.amount: theAmount})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")
    
def updateTransactionVendor(theID, theVen):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.vendor: theVen})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")
    
def updateTransactionDesc(theID, theDesc):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.description: theDesc})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**") 
    
def updateTransactionCategory(theID, theCat):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theID).update(
        {Transactions.category: theCat})
    session.commit()
    session.close()
    print("**Transaction with ID: ",  theID, " updated**")

'''
Delete methods
===================================================================
''' 
# Deletes a row from the budget db
def deleteFromBudget(theMethID, theName, theID):
    session = newSession()
    if theMethID == 0:
        session.query(TheBudget).filter(TheBudget.itemName == theName).delete(synchronize_session=False)
        session.query(TheBudget).filter(TheBudget.itemName == theName).delete(synchronize_session='evaluate')
    else:
        session.query(TheBudget).filter(TheBudget.itemId == theID).delete(synchronize_session=False)
        session.query(TheBudget).filter(TheBudget.itemId == theID).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Item deleted**")

# Deletes a row from the account db
def deleteFromAccount(theId):
    session = newSession()
    session.query(Accounts).filter(Accounts.itemId == theId).delete(synchronize_session=False)
    session.query(Accounts).filter(Accounts.itemId == theId).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Account deleted**")
    
# Deletes a row from the transaction db
def deleteFromTransaction(theId):
    session = newSession()
    session.query(Transactions).filter(Transactions.itemId == theId).delete(
        synchronize_session=False)
    session.query(Transactions).filter(Transactions.itemId == theId).delete(
        synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Transaction deleted**")
    
# Deletes a row from the transaction db
def deleteFromTransactionByName(theP):
    session = newSession()
    session.query(Transactions).filter(Transactions.purchaser == theP).delete(
        synchronize_session=False)
    session.query(Transactions).filter(Transactions.purchaser == theP).delete(
        synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**All transactions matching purchaser: ", theP, "deleted**")

'''
Subtraction methods
===================================================================
''' 
# Subtracts a given amount from the 'currentValue' column in the budget db
def subtractFromBudgetItemValue(theCategory, theValue):
    session = newSession()
    session.query(TheBudget).filter(TheBudget.itemName == theCategory).update(
        {TheBudget.currentValue: TheBudget.currentValue - theValue})
    session.commit()
    session.close()

# Subtracts the given amount from a specified account
def subtractFromAccountBalance(theID, theValue):
    session = newSession()
    session.query(Accounts).filter(Accounts.itemId == theID).update(
        {Accounts.balance: Accounts.balance - theValue})
    session.commit()
    session.close()

'''
View methods
===================================================================
''' 
def viewAccounts():
    result = ""
    session = newSession()
    account = session.query(Accounts).order_by(Accounts.type).all()
    for acc in account:
        result += ("Account ID: [{}]\nAccount Balance: ${:,.2f}\nAccount Type: {}\n\n".format(acc.itemId, acc.balance, acc.type))
    session.close()
    return result
    
    
def viewTransactions(theMethNum, theBeginDate, theEndDate, thePurchaser, theAmount,
                     theVendor, theCat):
    result = ""
    session = newSession()
    # General Transactions
    if theMethNum == 0:
        trans = session.query(Transactions).all()
    # Transactions by date
    elif theMethNum == 1:
        trans = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBeginDate, Transactions.dateOfTransaction <= theEndDate )
    # Transactions by purchaser
    elif theMethNum == 2:
        trans = session.query(Transactions).filter(Transactions.purchaser == thePurchaser)
    # Transactions by amount
    elif theMethNum == 3:
        trans = session.query(Transactions).filter(Transactions.amount == theAmount)
    # Transactions by vendor
    elif theMethNum == 4:
        trans = session.query(Transactions).filter(Transactions.vendor == theVendor)
    # Transactions by category
    elif theMethNum == 5:
        trans = session.query(Transactions).filter(Transactions.category == theCat)
    for tran in trans:
        result += ('itemId: |{}|\n\
        date: {}\n\
        purchaser: {}\n\
        vendor: {}\n\
        description: {}\n\
        category: {}\n\
        amount: ${:,.2f}\n\
        balance after transaction: ${:,.2f} in account: [{}]\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount, tran.accountBalance, tran.accountId))
    session.close()
    return result
    

# All the moving pieces that make viewing the state of the budget in the console
# possible
def viewBudget():
    result = ""
    value = 0
    monthly = 0
    test = 0
    
    session = newSession()
    budg = session.query(TheBudget).all()
    noHealthInsurance = session.query(TheBudget).filter(TheBudget.itemName != 'medical & dental')
    accountBal = session.query(Accounts).order_by(Accounts.type).all()
    result += ("|{0:<}|\t |{1:<}|\t |{2:<}|\t |{3:<}|\t |{4:<}|\t\n".format(
        'itemId', 'dateLastPaid', 'itemName','currentValue', 'budgetedValue'))
    for item in budg:
        result += ('{0:<8}\t {1:<15}\t {2:<16}\t {3:<15}\t {4:^}\t\n'.format(str(item.itemId), str(item.dateLastPaid), 
                       str(item.itemName), str(item.currentValue), str(item.budgetedValue)))
   
    for item in budg:
        value += float(item.budgetedValue)
    for item in noHealthInsurance:
        monthly += float(item.expectedMonthlyValue)
        
    result += '\nTOTAL BUDGETED: ${:0,.2f} | TOTAL MONTHLY: ${:1,.2f}\n'.format(value, monthly)
    result += '\nTOTAL WITHDRAWAL AMOUNT: ${:,.2f}\n'.format(getTotalCashWithdrawal())
    result += '\nTOTAL MONTHLY SAVINGS: ${:0,.2f}\n\n'.format(getTotalMonthlySaved())
    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    for account in accountBal:
        result += 'TOTAL IN ACCOUNT: ${:0,.2f}, TYPE: {}\n'.format(account.balance, account.type)
        
    if test.balance - value > 0:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES (3611): ${:0,.2f}\nTOTAL PERIOD SAVINGS TOTAL: ${:1,.2f}".format(
            0, test.balance - value)
    elif test.balance - value < 0:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES (3611): ${:0,.2f}".format(abs(test.balance - value))
    else:
        result += "\nAMOUNT NEEDED TO COVER EXPENSES (3611): ${:0,.2f}".format(0)
        
    result += "\n\n"
    session.close()
    return result

'''
Get methods
===================================================================
''' 

# The sum of all budgeted items
def getTotalBudgeted():
    value = 0
    session = newSession()
    budg = session.query(TheBudget).all()

    for item in budg:
        value += float(item.budgetedValue)
    session.close()
    return value

# Gets the total income minus the total expenses
def getTotalMonthlySaved():
    result = 0
    totalMonthly = getTotalMonthlyExpenses()
    session = newSession()
    income = session.query(Transactions).filter(
        Transactions.category == 'income')
    size = income.count()
    for item in income:
        result += item.amount
    total = ((result / size) * 2) - totalMonthly
    return total

# Gets the total monthly expenses
def getTotalMonthlyExpenses():
    result = 0
    session = newSession()
    trans = session.query(TheBudget).filter(TheBudget.expectedMonthlyValue, TheBudget.itemName != 'medical & dental')
    for item in trans:
        result += item.expectedMonthlyValue
    session.close()
    return result

# The sum of all transaction amounts that match a criteria
def getTheTotalSpent(theMethNum, theCat, theVen, theP, theBegin, theEnd):
    result = 0
    session = newSession()
    if theMethNum == 0:
        trans = session.query(Transactions).all()
    elif theMethNum == 1: 
        trans = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBegin, Transactions.dateOfTransaction <= theEnd)
    elif theMethNum == 2:
        trans = session.query(Transactions).filter(Transactions.purchaser == theP)
    elif theMethNum == 3:
        trans = session.query(Transactions).filter(Transactions.vendor == theVen)
    elif theMethNum == 4:
        trans = session.query(Transactions).filter(Transactions.category == theCat)
    for item in trans:
        result += item.amount
    session.close()
    return result

# The sum of all transactions that match a criteria
def getTotalNumberOfTransactions(theMethNum, theCat, theVen, theP, theBegin, theEnd):
    count = 0
    session = newSession()
    if theMethNum == 0:
        count = session.query(Transactions).count()  
    elif theMethNum == 1:
        count = session.query(Transactions).filter(Transactions.dateOfTransaction >= theBegin, Transactions.dateOfTransaction <= theEnd ).count()
    elif theMethNum == 2:
        count = session.query(Transactions).filter(Transactions.purchaser == theP).count()
    elif theMethNum == 3:
        count = session.query(Transactions).filter(Transactions.vendor == theVen).count()
    elif theMethNum == 4:
        count = session.query(Transactions).filter(Transactions.category == theCat).count()
    session.close()
    return count

# Returns the current account balance
def getCurrentBalance(theID):
    result = 0
    session = newSession()
    account = session.query(Accounts).filter(Accounts.itemId == theID)
    for acc in account:
        result += acc.balance
    session.close()
    return result
    

# The amount needed to pay for the sum of the budgeted items
def getAmountNeeded():
    result = ""
    value = 0
    test = 0
    
    session = newSession()
    budg = session.query(TheBudget).all()

    for item in budg:
        value += float(item.budgetedValue)

    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    if test.balance - value > 0:
        result += "${:1,.2f}".format(0, test.balance - value)
    elif test.balance - value < 0:
        result += "${:0,.2f}".format(abs(test.balance - value))
    else:
        result += "${:0,.2f}".format(0)
    session.close()
    return result

# The total potential savings amount
def getTotalSaved():
    result = ""
    value = 0
    test = 0
    session = newSession()
    budg = session.query(TheBudget).all()
    for item in budg:
        value += float(item.budgetedValue)
  
    checkingAccount = session.query(Accounts).filter(Accounts.itemId == 1)
    for check in checkingAccount:
        test = check
    
    if test.balance - value > 0:
        result += "${:,.2f}".format(test.balance - value)
    else:
        result +="${:,.2f}".format(0)
    session.close()
    return result

# Gets the total amount needed for the cash system
def getTotalCashWithdrawal():
    value = 0
    cashItems = ['groceries', 'allowance', 'fuel', 
                 'home needs', 'date night']
    session = newSession()
    budg = session.query(TheBudget).filter(TheBudget.itemName.in_(cashItems))
    for item in budg:
        value += float(item.budgetedValue)
        
    return value
    session.close()
        
'''
Reset methods
===================================================================
'''
# This method resets the current values so that they are equal to
# the budgeted values.
def resetBudgetValues():
    session = newSession()
    budg = session.query(TheBudget).all()

    for item in budg:
        item.currentValue = item.budgetedValue
    session.commit()
    session.close()
    print("**Current values reset**")

# This method sets the values in the budget to a given period
# It also sets the current values to the newly reset values
def resetToBudgetPeriod(thePeriod):
    i = 0
    session = newSession()
    budg = session.query(TheBudget).all()
    if thePeriod == 0:
        period = [0, 0, 0, 0, 0, 
                         0, 0, 0, 0, 0, 
                         0, 0, 0, 0, 0,
                         0, 0, 0, 0, 0,
                         0, 0]
    elif thePeriod == 1:
        period = [879.17, 345, 0, 51.08, 0, 
                         0, 0, 0, 170, 40, 
                         35, 0, 0, 0, 30,
                         100, 25, 77.72, 40, 0,
                         25, 50]
    else:
        period = [0, 0, 20, 0, 209.87, 
                     126.38, 94.04, 0, 170, 38, 
                     35, 10.99, 3.29, 22.40, 30,
                     0, 0, 0, 40, 0,
                     25, 50]
        
    for item in budg:
        item.budgetedValue = period[i]
        item.currentValue = item.budgetedValue
        i = i + 1
    session.commit()
    session.close()
    print("**Budget reset to period: ", thePeriod, "**")
     
     
    
