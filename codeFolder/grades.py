# Kaleb Moreno 

######################################################
# This is the main function header where I 
# set the variables and declared the function names
######################################################
def main():
    var = get_input()
    grade1 = printLetterGrade(var[0])
    grade2 = printLetterGrade(var[1])
    grade3 = printLetterGrade(var[2])
    grade4 = printLetterGrade(var[3])
    grade5 = printLetterGrade(var[4])
    formatOutput(var[0], grade1)
    formatOutput(var[1], grade2)
    formatOutput(var[2], grade3)
    formatOutput(var[3], grade4)
    formatOutput(var[4], grade5)
    avg = getAverage(var[0], var[1], var[2], var[3], var[4])
    print("The average is: {} which is a {}".format(avg, printLetterGrade(avg)))
######################################################
# This function gets input from the user and returns 
# those values to whatever called it
######################################################
def get_input():
    var1 = int(input("Enter first score: "))
    var2 = int(input("Enter second score: "))
    var3 = int(input("Enter third score: "))
    var4 = int(input("Enter fourth score: "))
    var5 = int(input("Enter fifth score: "))
    input_collection = var1, var2, var3, var4, var5
    return input_collection
######################################################
# This function contains all of my if conditions
# that test each item against the criteria 
######################################################
def printLetterGrade(num):
    if num > 0:
        if num >= 90:
            grade = "A"
        elif num <= 89 and num >= 80:
            grade = "B"
        elif num <= 79 and num >= 70:
            grade = "C"
        elif num <= 69 and num >= 60:
            grade = "D"
        elif num < 60:
            grade = "F"
    else:
        grade = "Something went wrong in printLetterGrade()."
    return grade
#######################################################
# This function formats the input from the user
######################################################
def formatOutput(a, b):
    phrase = "{} is {}".format(a, b)
    print(phrase)
    return phrase
######################################################
#  This function calculates the average of all
#  the input grades, then returns that average
######################################################
def getAverage(a, b, c, d, e):
    average = (a + b + c + d + e) / 5
    return average
    
main()
    