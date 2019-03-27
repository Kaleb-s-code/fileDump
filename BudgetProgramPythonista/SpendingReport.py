'''
Created on Mar 13, 2019

The purpose of this module is to house all of the methods relating
to generating the spending report. 
@author: Kaleb
'''
from datetime import datetime
import dbMethods
from docx import Document
from docx.shared import Inches
from Budget import Transactions

'''This method should generate a simple .txt file 
with a summary of the transactions for a given range'''
def generateGeneralReport():
    document = Document()
    
    headingString = 'General Transaction Report'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    numberOfTransactions = "Total number of transactions: {}".format(
        dbMethods.getTotalNumberOfTransactions(0, '', '', '', '', ''))
    totalSpent = "Total spent: ${:,.2f}".format(dbMethods.getTheTotalSpent(0, '', '', '', '', ''))

    document.add_heading(headingString, 0)
    document.add_heading(dateString)

    document.add_heading("Overview", level=1)
    
    document.add_paragraph(
        numberOfTransactions
    )
    document.add_paragraph(
        totalSpent
    )
    records = (
        dbMethods.getTransactionsIntoArrayDescinding(0, '', '', '', '', '')
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=7)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date of Transaction'
    hdr_cells[2].text = 'Purchaser'
    hdr_cells[3].text = 'Vendor'
    hdr_cells[4].text = 'Description'
    hdr_cells[5].text = 'Category'
    hdr_cells[6].text = 'Amount'
    for itemId, dateOfTrans, purchaser, vendor, desc, cat, amount in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = dateOfTrans
        row_cells[2].text = purchaser
        row_cells[3].text = vendor
        row_cells[4].text = desc
        row_cells[5].text = cat
        row_cells[6].text = amount

    document.save('GeneralReport{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated**')

    
def generateReportByDate(theBeginDate, theEndDate):
    document = Document()
    
    headingString = 'Transactions by Date Report'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    numberOfTransactions = "Total number of transactions: {}".format(dbMethods.getTotalNumberOfTransactions(1, '', '', '', theBeginDate, theEndDate))
    totalSpent = "Total spent in date range: ${:,.2f}".format(dbMethods.getTheTotalSpent(1,  '', '', '', theBeginDate, theEndDate))

    document.add_heading(headingString, 0)
    document.add_heading(dateString)
    
    document.add_heading("Overview", level=1)
    
    document.add_paragraph(
        numberOfTransactions
    )
    document.add_paragraph(
        totalSpent
    )
    records = (
        dbMethods.getTransactionsIntoArrayDescinding(1,  '', '', '', theBeginDate, theEndDate)
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=7)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date of Transaction'
    hdr_cells[2].text = 'Purchaser'
    hdr_cells[3].text = 'Vendor'
    hdr_cells[4].text = 'Description'
    hdr_cells[5].text = 'Category'
    hdr_cells[6].text = 'Amount'
    for itemId, dateOfTrans, purchaser, vendor, desc, cat, amount in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = dateOfTrans
        row_cells[2].text = purchaser
        row_cells[3].text = vendor
        row_cells[4].text = desc
        row_cells[5].text = cat
        row_cells[6].text = amount

    document.save('SpendingByDate{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated**')

def generateReportByPurchaser(thePurchaser):
    document = Document()
    
    headingString = 'Transactions by Purchaser Report'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    numberOfTransactions = "Total number of transactions: {}".format(dbMethods.getTotalNumberOfTransactions(2,  '', '', thePurchaser, '', ''))
    totalSpent = "Total spent by purchaser: ${:,.2f}".format(dbMethods.getTheTotalSpent(2, '', '', thePurchaser, '', ''))

    document.add_heading(headingString, 0)
    document.add_heading(dateString)
    
    
    document.add_heading("Overview", level=1)
    
    document.add_paragraph(
        numberOfTransactions
    )
    document.add_paragraph(
        totalSpent
    )
    records = (
        dbMethods.getTransactionsIntoArrayDescinding(2, '', '', thePurchaser, '', '')
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=7)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date of Transaction'
    hdr_cells[2].text = 'Purchaser'
    hdr_cells[3].text = 'Vendor'
    hdr_cells[4].text = 'Description'
    hdr_cells[5].text = 'Category'
    hdr_cells[6].text = 'Amount'
    for itemId, dateOfTrans, purchaser, vendor, desc, cat, amount in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = dateOfTrans
        row_cells[2].text = purchaser
        row_cells[3].text = vendor
        row_cells[4].text = desc
        row_cells[5].text = cat
        row_cells[6].text = amount

    document.save('SpendingByPurchaser{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated**')

def generateReportByAmount(theFile, theAmount):
    time = [datetime.now().strftime('%Y-%m-%d')]
    theFile.write('Transaction Summary:\n')
    theFile.write('Date: ' + str(time) + '\n')
    theFile.write('=' * 40 + '\n\n')
    theFile.write(str(dbMethods.viewTransactions(3, '', '', '', theAmount, '', '')))
    theFile.close()
    print('\n**Session Report Generated**')

def generateReportByVendor(theVendor):
    document = Document()
    
    headingString = 'Transactions by Vendor Report'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    numberOfTransactions = "Total number of transactions: {}".format(dbMethods.getTotalNumberOfTransactions(3, '', theVendor, '', '', ''))
    totalSpent = "Total spent by vendor: ${:,.2f}".format(dbMethods.getTheTotalSpent(3, '', theVendor, '', '', ''))

    document.add_heading(headingString, 0)
    document.add_heading(dateString)
    
    document.add_heading("Overview", level=1)
    
    document.add_paragraph(
        numberOfTransactions
    )
    document.add_paragraph(
        totalSpent
    )
    records = (
        dbMethods.getTransactionsIntoArrayDescinding(3, '', theVendor, '', '', '')
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=7)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date of Transaction'
    hdr_cells[2].text = 'Purchaser'
    hdr_cells[3].text = 'Vendor'
    hdr_cells[4].text = 'Description'
    hdr_cells[5].text = 'Category'
    hdr_cells[6].text = 'Amount'
    for itemId, dateOfTrans, purchaser, vendor, desc, cat, amount in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = dateOfTrans
        row_cells[2].text = purchaser
        row_cells[3].text = vendor
        row_cells[4].text = desc
        row_cells[5].text = cat
        row_cells[6].text = amount

    document.save('SpendingByVendor{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated**')
    
    
def generateReportByCategory(theCat):
    document = Document()
    
    headingString = 'Transactions by Category Report'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    numberOfTransactions = "Total number of transactions: {}".format(dbMethods.getTotalNumberOfTransactions(4, theCat, '', '', '', ''))
    totalSpent = "Total spent in category: ${:,.2f}".format(dbMethods.getTheTotalSpent(4, theCat, '', '', '', ''))

    document.add_heading(headingString, 0)
    document.add_heading(dateString)
    
    document.add_heading("Overview", level=1)
    
    document.add_paragraph(
        numberOfTransactions
    )
    document.add_paragraph(
        totalSpent
    )
    records = (
        dbMethods.getTransactionsIntoArrayDescinding(4, theCat, '', '', '', '')
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=7)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date of Transaction'
    hdr_cells[2].text = 'Purchaser'
    hdr_cells[3].text = 'Vendor'
    hdr_cells[4].text = 'Description'
    hdr_cells[5].text = 'Category'
    hdr_cells[6].text = 'Amount'
    for itemId, dateOfTrans, purchaser, vendor, desc, cat, amount in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = dateOfTrans
        row_cells[2].text = purchaser
        row_cells[3].text = vendor
        row_cells[4].text = desc
        row_cells[5].text = cat
        row_cells[6].text = amount

    document.save('SpendingByCategory{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated**')
    
def createWordDocumentOfBudget():
    document = Document()
    totalBudgeted = "Total Amount For Budgeted Items: ${:,.2f}".format(dbMethods.getTotalBudgeted())
    accounts = "Total In Accounts:\n{}".format(dbMethods.viewAccounts())
    amountNeeded = "Amount Needed To cover Expenses: {}".format(dbMethods.getAmountNeeded())
    totalSaved = "Total Savings: {}".format(dbMethods.getTotalSaved())


    headingString = 'The Budget'
    dateString = 'Generated on: ', str(datetime.now().strftime('%Y-%m-%d')), '.'
    document.add_heading(headingString, 0)
    document.add_heading(dateString)
    
    document.add_heading("Financial Overview", level=1)
    
    document.add_paragraph(
        totalBudgeted
    )
    document.add_paragraph(
        accounts
    )
    document.add_paragraph (
        amountNeeded
    )
    document.add_paragraph (
        totalSaved
    )
    records = (
        dbMethods.getDbItemsIntoArray()
    )
    document.add_heading("Breakdown:", level=1)
    table = document.add_table(rows=1, cols=6)
    hdr_cells = table.rows[0].cells
    hdr_cells[0].text = 'Item Id'
    hdr_cells[1].text = 'Date Last Paid'
    hdr_cells[2].text = 'Item Name'
    hdr_cells[3].text = 'Item Value'
    hdr_cells[4].text = 'Expected Monthly'
    hdr_cells[5].text = 'Due Date'
    for itemId, lastPaid, name, value, exp, due in records:
        row_cells = table.add_row().cells
        row_cells[0].text = str(itemId)
        row_cells[1].text = lastPaid
        row_cells[2].text = name
        row_cells[3].text = value
        row_cells[4].text = exp
        row_cells[5].text = due

    document.save('TheBudget{}.docx'.format(str(datetime.now().strftime('%Y-%m-%d'))))
    print('**Report Generated***')

