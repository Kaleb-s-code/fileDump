'''
Created on Mar 18, 2019

This module contains all of the methods that work with the 
database directly. 

@author: Kaleb
'''
import Budget
from Budget import TheBudget
from Budget import Transactions

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
This method adds items to the database budget
'''
def addTransaction(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    newItem = Transactions(theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount)
    session.add(newItem)
    session.commit()
    session.close()
    print("**item added to budget**")


'''
This method deletes from the database items matching the ID
'''
def deleteTransactionByID(theId):
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    session.query(Transactions).filter(Transactions.itemId == theId).delete(synchronize_session=False)
    session.query(Transactions).filter(Transactions.itemId == theId).delete(synchronize_session='evaluate')
    session.commit()
    session.close()
    print("**Transaction with ID: ", theId, " deleted**")

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
        amount: {}\n'.format(tran.itemId, tran.dateOfTransaction, 
                   tran.purchaser, tran.vendor, tran.description,
                   tran.category, tran.amount))
    return result
    session.close()
        
'''
This method deletes from the database items matching the ID
'''
def viewBudget():
    result = ""
    Budget.myBase.metadata.create_all(Budget.myEngine)
    session = Budget.sessionmaker(bind=Budget.myEngine)()
    budg = session.query(TheBudget).all()
    result += ("|{0:<8}|\t |{1:<10}|\t |{2:<10}|\t |{3:<15}|\t |{4:<7}|\t |{5:<10}|\n".format(
        'itemId', 'dateLastPaid', 'itemValue', 'expectedMonthly', 'dueDate', 'itemNotes'))
    for item in budg:
        result += ('{0:<8}\t {1:<10}\t {2:<10}\t {3:<15}\t {4:<7}\t {5:<10}\n'.format(str(item.itemId), str(item.dateLastPaid), 
                       str(item.itemValue), str(item.expectedMonthlyValue), str(item.dueDate),
                       str(item.itemNotes)))
    session.close()

'''
This method deletes from the database items matching the ID
'''

    
    
    