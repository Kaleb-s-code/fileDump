# I want this program to:
  # Ask predefined options 
  
  # show transactions
   # display file name, and total date range 
   # include option to show all totals in
   # full range
   # get total transactions in date range
   # get total spent in date range
   # get highest transaction 
   # get lowest transaction
   # get category totals in range 
   # get average money spent in a month 
   # get average money spent in a week 
  # find bills
   # import fnmatch? or re 
   # ask for bill name input 
   # search file for bill and return 
   # date last paid and amount
   # return previous payment dates and prices
   # upon user request
  # find out total in versus total out 
   # find for a given date range 
   # find for the year to date 
  # make projections for coming months 
   # based on averages find likely spending 
   # per week, per month 
   # project total needed income to be able to 
   # save a user defined amount per month 
import datetime
def main():
    infile = open("C:/Users/Kaleb/Documents/fileDump/csvFiles/transactions.csv")
    initial = getInitialResponse()
    handler = mainMenuValidation(initial)
    if handler == 1:
    	transactionData(infile)
    	infile.close()
    elif handler == 2:
    	findBills(infile)
    	infile.close()
    elif handler == 3:
    	getCashFlow(infile)
    	infile.close()
def getInitialResponse():
   resList = ["1", "2", "3"]
   response1 = input("Please select one of the predefined options:\n\n1. Show Transactions\n2. Find Bills\n3. Cash Flow\n\nEnter 1,2 or 3: ")
   while response1 not in resList:
   	response1 = input("Enter 1, 2 or 3: ")
   print("\n")
   return response1
# This needs user input 
def mainMenuValidation(res1):
    res1 = int(res1)
    yesList = ["Yes", "y", "Y", "YES"]
    noList = ["n", "No", "no","NO","nO", "Nope"]
    var = 'null'
    done = True
    while res1 > 0:
	    if res1 == 1:
	    	while var not in yesList and res1 == 1:
	    		var = input("You have selected Show Transactions. Continue?(y/n): ")
	    		if var in noList:
	    			done = False
	    			res1 = int(input("Enter 1,2 or 3: "))
	    			print("\n")
	    		if var in yesList:
	    			done = True
	    			if done == True:
	    				return 1
	    elif res1 == 2:
	    	while var not in yesList and res1 == 2:
	    		var = input("You have selected Find Bills. Continue?(y/n): ")
	    		if var in noList:
	    			done = False
	    			res1 = int(input("Enter 1,2 or 3: "))
	    			print("\n")
	    		if var in yesList:
	    			done = True
	    			if done == True:
	    				return 2
	    elif res1 == 3:
	    	while var not in yesList and res1 == 3:
	    		var = input("You have selected Cash Flow. Continue?(y/n): ")
	    		if var in noList: 
	    			done = False
	    			res1 = int(input("Enter 1,2 or 3:"))
	    			print("\n")
	    		if var in yesList:
	    			done = True
	    			if done == True:
	    				return 3
def transactionData(in1):
    print("\nYou are viewing transactions from:\n{}\n".format(in1.name))
    in1.readline()
    idx = 0
    count = 0
    response2 = 0
    dateContainer = []
    nonExpenseList = ["Starting Balance:", "Additions:", "Digit", "Rebalancing:", "Expected Savings", "S balance +:", "S balance -:"]
    yesList = ["Yes", "y", "Y", "YES"]
    date1 = ""
    date2 = ""
    maximumMinimumDates = []
    for line in in1:
        var = line.split(",")
        var[-1] = var[-1].strip("\n").strip("$").strip('""')
        if var[-1] < "0":
        	var[-1] = "0.00"
        if var[3] not in nonExpenseList:
            count += float(var[-1])
        dateContainer.append(var[0])
    maximumMinimumDates.append(max(dateContainer))
    maximumMinimumDates.append(min(dateContainer))
    while response2 == 0:    
        print("Most Recent Transaction Date: {}\nOldest Transaction Date: {}".format(maximumMinimumDates[0], maximumMinimumDates[1]))
        response2 = int(input("\nSelect An Option From Below:\n1. Show total spent to date\n2. Show spending with given date range\n3. Show totals per category\n4. Show category spending in a range\n5. Show averages\nEnter a number: "))
        if response2 == 1:
            print("\n")
            print("Total spent up to {0}: ${1:,.2f}".format(maximumMinimumDates[0], count))
            repeat = input("Back to menu?:" )
            print("\n")
            if repeat in yesList:
                response2 = 0
        elif response2 == 2:
            print("\n")
            print("Input the date you would like to begin the search")
            print("=" * 25)
            while date1 not in dateContainer:
                date1 = input("Enter a date: ")
                date1 = date1.strip()
            print("\nInput the date you would like to end the search")
            print("=" * 25)
            while date2 not in dateContainer:
                date2 = input("Enter a date: ")
                if date2 < date1:
                    date2 = ""
            dateRanges(date1, date2)
            repeat = input("Back to menu?:" )
            print("\n")
            if repeat in yesList:
                response2 = 0
def dateRanges(d1, d2):
    in1 = open("C:/Users/Kaleb/Documents/fileDump/csvFiles/transactions.csv")
    in1.readline()
    transactionRange = []
    nonExpenseList = ["Starting Balance:", "Additions:", "Digit", "Rebalancing:", "Expected Savings", "S balance +:", "S balance -:"]
    count = 0
    transCount = 0
    idx = 0
    idx2 = 0
    for line in in1:
        var = line.split(",")
        var[-1] = var[-1].strip("\n").strip("$").strip('""')
        for idx in range(5):
            if var[idx] < "0" or var[idx] == '':
                var[idx] = "Null"
        if var[0] >= d1 and var[0] <= d2:
            if var[3] not in nonExpenseList:
                count += float(var[-1])
                transCount += 1
                transactionRange.append(var[0])
                transactionRange.append(var[3:])
    print("\n")
    print("=" * 25)
    print("Transaction summary")
    print("=" * 25)
    if d1 != d2:
        print("\nBetween {0} and {1} you spent ${2:,.2f}".format(d1[0:5], d2[0:5], count))
        print("There were a total of {} transactions\n".format(transCount))
        while idx2 < len(transactionRange):
            print(transactionRange[idx2], ", ".join(transactionRange[idx2 + 1]))
            idx2 += 2
    else:
        print("\nOn {0} you spent ${1:,.2f}".format(d1[0:5], count))
        print("There were a total of {} transactions\n".format(transCount))
        while idx2 < len(transactionRange):
            print(transactionRange[idx2], ", ".join(transactionRange[idx2 + 1]))
            idx2 += 2
    in1.close()
def findBills(in1):
	for line in in1:
		print(line)
def getCashFlow(in1):
	for line in in1:
		var = line.split(",")
		var[-1] = var[-1].strip("\n").strip("$")
		print(var[-1])
main()