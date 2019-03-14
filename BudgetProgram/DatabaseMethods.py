'''
Created on Mar 13, 2019

The purpose of this module is to handle all things related to 
the database. 

@author: Kaleb
'''
import sqlite3
from datetime import datetime

''' This method makes and returns a connection to the Transaction
 database.'''
def connect():
    connection = sqlite3.connect("TransactionDB")
    return connection


'''This method creates the transaction table'''
def createTable(theC):
    c = theC.cursor()
    c.execute('''CREATE TABLE IF NOT EXISTS transactions (
        Date TEXT NOT NULL,
        Purchaser TEXT,
        Vendor TEXT NOT NULL,
        Description TEXT NOT NULL,
        Category TEXT NOT NULL, 
        Amount REAL NOT NULL)''')
    return theC
    
    
'''This method drops the table in the TransactionDB'''
def dropTable(theC):
    drop = 'DROP TABLE transactions'
    c = theC.cursor()
    c.execute(drop)

'''This method actually adds a transaction to the database'''
def storeTransaction(thePurchaser, theVen, theJust, theCat, thePrice, theConnect):
    time = datetime.now().strftime('%Y-%m-%d')
    data = [time, thePurchaser, theVen, theJust, theCat, thePrice]
    
    c = theConnect.cursor()
    
    sure = input('Commit(y/n)? ')
    if sure == 'y':
        c.execute("INSERT INTO transactions VALUES(?,?,?,?,?,?)", data)
        theConnect.commit()
        print('\n**Transaction entered into the database**')
    else:
        print('**Transaction aborted**')
    return ""

'''This method shows all of the data in the transactions table'''
        
def showDataBase(theConnection):
    i = 1
    cursor = theConnection.cursor()
    cursor.execute("SELECT * FROM transactions")
    rows = cursor.fetchall()
    print("=" * 80)
    for row in rows:
        print(str(i) + '.) ' + str(row))
        i += 1
    print("=" * 80)



