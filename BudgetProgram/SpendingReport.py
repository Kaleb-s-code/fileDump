'''
Created on Mar 13, 2019

The purpose of this module is to house all of the methods relating
to generating the spending report. 
@author: Kaleb
'''
from datetime import datetime
import dbMethods

'''This method should generate a simple .txt file 
with a summary of the transactions for a given range'''
def generateReport(theFile):
    time = [datetime.now().strftime('%Y-%m-%d')]
    theFile.write('Transaction Summary:\n')
    theFile.write('Date: ' + str(time) + '\n')
    theFile.write('=' * 40 + '\n\n')
    theFile.write(str(dbMethods.viewTransactions()))
    print('\n**Session Report Generated**')

