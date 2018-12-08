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
    infile = open("C:/Users/Kaleb/Documents/fileDump/csvFiles/transactions.csv")
    initial = getInitialResponse()
    handler = processUserInput(initial, infile)
    # dates = getDatesAndUserInput(infile)
    infile.close()
def getInitialResponse():
    response1 = input("Please select one of the predefined options:\n\n1. Show Transactions\n2. Find Bills\n3. Cash Flow\n\nEnter 1,2 or 3: ")
    print("\n")
    return response1
# This needs user input 
def processUserInput(res1, in1):
    varList = ["Yes", "y", "Y", "YES"]
    responses = ["1","2","3"]
    var = 'No'
    done = True
    while res1 not in responses:
        print("Something happened. Try again.")
        getInitialResponse()
    if res1 == 1:
        while var not in varList:
            var = input("You have selected Show Transactions. Continue?(y/n): ")
            done = False
        if var in varList:
            done = True
        if done == True:
            getDatesAndUserInput(in1)
def getDatesAndUserInput(in1):
    print("You are viewing transactions from:\n{}\n".format(in1.name))
    in1.readline()
    idx = 0
    dateContainer = []
    # This containes max date and min date
    retContainer = []
    for line in in1:
        var = line.split(",")
        var[-1] = var[-1].strip("\n").strip("$")
        dateContainer.append(var[0])
    retContainer.append(max(dateContainer))
    retContainer.append(min(dateContainer))
    print("Most Recent Transaction Date: {}\nOldest Transaction Date: {}".format(retContainer[0], retContainer[1]))
    response2 = input("\nSelect An Option From Below:\n1. Show total spent to date\n2. Show spending with given date range\n3. Show totals per category\n4. Show category spending in a range\n5. Show averages")
    return response2
main()
# in1 = open("csvFiles/transactions.csv")
# in1.readline()
# counter = 0
# idx = 0
# for line in in1:
#     var = line.split(",")
#     var[-1] = var[-1].strip("\n")
#     var[-1] = var[-1].strip("$")
#     dates = var[0].split("/")
#     counter += float(var[-1])
# print("Total money in this file: ${0:.2f}".format(counter))
