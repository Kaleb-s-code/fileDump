'''
Created on Mar 14, 2019

The purpose of this module is to give the user the ability to add
items to the budget database. All data is held in a local MySQl 
database. 

@author: Kaleb
'''

import pymysql
from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String, Date, Float
from sqlalchemy.orm import sessionmaker
from unicodedata import category

# Establishing a connection to the database.
myEngine = create_engine('mysql+pymysql://root:Admin-PASSwo-Rd@localhost/testdb')
myBase = declarative_base()

'''
the purpose of this class is to represent a budget database through 
witch users can add and remove budget line items.
'''


class TheBudget(myBase):
    __tablename__ = 'budget'
    
    itemId = Column(Integer, primary_key=True)
    # YYYY-MM-DD
    dateLastPaid = Column(Date, nullable=True)
    itemName = Column(String(100), nullable=False)
    itemValue = Column(Float, nullable=False)
    expectedMonthlyValue = Column(Float, nullable=False)
    dueDate = Column(Date, nullable=True)
    itemNotes = Column(String(500), nullable=True)
    
    def __init__(self, theDate, theName, theValue, theExpectedMonthly, theDueDate, theNotes):
        if theDate == '':
            self.dateLastPaid = '0000-00-00'
        else:
            self.dateLastPaid = theDate
        self.itemName = theName
        self.itemValue = theValue
        self.expectedMonthlyValue = theExpectedMonthly
        if theDueDate == '':
            self.dueDate = '0000-00-00'
        else:
            self.dueDate = theDueDate
        self.itemNotes = theNotes


'''
The purpose of this class is to represent the transactions made 
in a given budget period.
'''
class Transactions(myBase):
    __tablename__ = 'transactions'
    
    itemId = Column(Integer, primary_key=True)
    # YYYY-MM-DD
    dateOfTransaction = Column(Date, nullable=False)
    purchaser = Column(String(100), nullable=False)
    vendor = Column(String(100), nullable=False)
    description = Column(String(500), nullable=True)
    category = Column(String(100), nullable=False)
    amount = Column(Float, nullable=False)
    
    def __init__(self, theDate, thePurchaser, theVendor, theDesc, theCategory, theAmount):
        if theDate == '':
            self.dateOfTransaction = '0000-00-00'
        else:
            self.dateOfTransaction = theDate
        self.purchaser = thePurchaser
        self.vendor = theVendor
        self.description = theDesc
        self.category = theCategory
        self.amount = float(theAmount)

'''
The purpose of this class is to take on the characteristics of a bank 
account
'''
class Accounts(myBase):
    __tablename__ = 'accounts'
    
    itemId = Column(Integer, primary_key=True)
    balance = Column(Float, nullable=False)
    type = Column(String(100), nullable=False)
    
    def __init__(self, theBalance, theType):
        self.balance = theBalance
        self.type = theType
    
    

