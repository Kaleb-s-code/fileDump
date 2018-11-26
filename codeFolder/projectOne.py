print("Kaleb Moreno")
print("Student Number: 1873583")
print("Programming Project 1")
print("*" * 50)


def projectOne():
    letters = get_Letter_String()
    intoList = turn_Input_Into_List(letters)
    validated = validation(intoList)
    indicies = get_Index_Location(validated)
    math = convert_Indicies_To_Binary(indicies)
    print("The first number is: {:,}".format(math))
    letters2 = get_Letter_String()
    intoList2 = turn_Input_Into_List(letters2)
    validated2 = validation(intoList2)
    indicies2 = get_Index_Location(validated2)
    math2 = convert_Indicies_To_Binary(indicies2)
    print("The second number is: {:,}".format(math2))
    operator = get_Arithmetic_Operator()
    operation = do_Arithemtic(math, operator, math2)
    final = final_Conversion(operation)
    outputFunction(operation, final)
####################################################################
# This function gets the very first string from the user
####################################################################
def get_Letter_String():
    var = input("Enter Napier's Number: ")
    return var
####################################################################
# This function turns that input into a list, and performs a check
####################################################################
def turn_Input_Into_List(var1):
    listVar = list(var1)
    if len(listVar) > 1:
        return listVar
    else:
        return str(0)
####################################################################
# This function validates the input that is passed to it
####################################################################
def validation(a):
    var = []
    var2 = []
    letters = []
    letters2 = []
    someVar = False
    testOnePass = False
    letterList = "abcdefghijklmnopqrstuvwxyz"
    letterList = list(letterList)
    for letter in a:
        var.append(letter)
        if letter in letterList:
            letters.append(letter)
    if len(letters) == len(var):
        someVar = True
        testOnePass = True
    else:
        someVar = False
    if someVar == False:
        while someVar != True:
            var2.clear()
            letters2.clear()
            stuff = input("Lets try that again: ")
            stuff = list(stuff)
            for letter in stuff:
                var2.append(letter)
                if letter in letterList:
                    letters2.append(letter)
            if len(letters2) == len(var2) and len(letters2) > 0:
                someVar = True
                var.clear()
                letters.clear()
    if testOnePass == True:
        return letters
    if someVar == True:
        return letters2
####################################################################
# This function finds the index of a letter based on the list that
# is passed to it
####################################################################
def get_Index_Location(a):
    var = []
    letterList = "abcdefghijklmnopqrstuvwxyz"
    letterList = list(letterList)
    for letter in a:
        if letter in letterList:
            var.append(letterList.index(letter))
        else:
            print(False)
    return var
####################################################################
# This function converts the indicies to binary
####################################################################
def convert_Indicies_To_Binary(a):
   base2 = 2
   container = []
   for item in a:
       container.append(base2 ** item)
   container = sum(container)
   return container
####################################################################
# This function gets the arithmetic operator and performs a check
####################################################################
def get_Arithmetic_Operator():
    ordinalList = [chr(42), chr(43), chr(45), chr(47)]
    var = str(input("Enter an arithmetic operator: "))
    while var not in ordinalList:
        var = input("Try again: ")
    return ord(var)
####################################################################
# This function does the actual math and performs another simple
# check
####################################################################
def do_Arithemtic(a, sign, b):
    nums = 0
    sign = chr(sign) 
    if sign == chr(42):
        nums = a * b
    elif sign == chr(43):
        nums = a + b
    elif sign == chr(45):
        nums = a - b
    elif sign == chr(47):
        nums = a // b
    if nums != 0:
        return nums
    else:
        return ""
####################################################################
# This function converts the result of the arithmetic to a string of
# letters using an algorithm I proudly forged from scratch! All of 
# This works based on the 13 division example given in the assignment
####################################################################
def final_Conversion(a):
    container = []
    aList = []
    indicies = []
    counter = 0
    alph = "abcdefghijklmnopqrstuvwxyz"
    alph = list(alph)
    num = a
    negative = False
    if num == "":
        return ""
    if num < 0:
        num = abs(num)
        negative = True
    while num > 0:
        aList.append(num)
        num = num // 2
    for num in aList:
        if num % 2 == 1:
            container.append(1)
        else:
            container.append(0)
    container_copy = container[:]
    
    while counter < len(container_copy):
        counter += 1
        if 1 in container_copy:
            indicies.append(container_copy.index(1))
            startPosition = container_copy.index(1)
            container_copy.remove(1) 
            container_copy.insert(startPosition, 0)
    
    final_list = []
    for num in indicies:
        final_list.append(alph[num])
    seperator = ""
    if negative == True:
        lastVar = seperator.join(final_list)
        return("-{}".format(lastVar))
    else:
        return seperator.join(final_list)
####################################################################
# This function determines what will print out in the last statement
#  based on a simple check
####################################################################
def outputFunction(op,fin):
    if op == "":
        print("The result is: {} or {}".format(op, fin))
    else:
        print("The result is: {:,} or {}".format(op, fin))

answer = "y"
possibleAnswers = ["y", "n"]
while answer == "y":
    print(" ")
    projectOne()
    answer = input("Would you like to repeat the program? Enter y for yes, n for no: ")
    if answer not in possibleAnswers:
        answer = input("Lets try that again. Enter a 'y' or 'n': ")
        while answer not in possibleAnswers:
            answer = input("Lets try that again. Enter a 'y' or 'n': ")