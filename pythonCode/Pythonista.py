import codecs


	
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
def main():
    infile = codecs.open("transactions.csv", "r", "utf-8")
    initial = getInitialResponse()
    handler = processUserInput(initial)
    if handler == 1:
    	getDatesAndUserInput(infile)
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
def processUserInput(res1):
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
def getDatesAndUserInput(in1):
    print("\nYou are viewing transactions from:\n{}\n".format(in1.name))
    in1.readline()
    idx = 0
    count = 0
    dateContainer = []
    # This containes max date and min date
    retContainer = []
    for line in in1:
        var = line.split(",")
        var[-1] = var[-1].strip("\n").strip("$").strip('""')
        if var[-1] < "0":
        	var[-1] = "0.00"
        count += float(var[-1])
        dateContainer.append(var[0])
    retContainer.append(max(dateContainer))
    retContainer.append(min(dateContainer))
    print("Most Recent Transaction Date: {}\nOldest Transaction Date: {}".format(retContainer[1], retContainer[0]))
    response2 = int(input("\nSelect An Option From Below:\n1. Show total spent to date\n2. Show spending with given date range\n3. Show totals per category\n4. Show category spending in a range\n5. Show averages"))
    if response2 == 1:
    	print("\n")
    	print("Total money moved: ${0:,.2f}".format(count))
def findBills(in1):
	for line in in1:
		print(line)
def getCashFlow(in1):
	for line in in1:
		var = line.split(",")
		var[-1] = var[-1].strip("\n").strip("$")
		print(var[-1])
main()