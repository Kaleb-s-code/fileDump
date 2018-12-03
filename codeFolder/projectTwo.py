def main():
    # getFiles()
    in1 = open("codeFolder/train.csv", 'r')
    healthyIll = countersAccumulators(in1)
    # in1.close()
    # in1 = open("codeFolder/train.csv", 'r')
    patientTotal = totalPatients(in1)
    # in1.close()
    # in1 = open("codeFolder/train.csv", 'r')
    healthyAvs = getHealthyAverage(in1)
    # in1.close()
    # in1 = open("codeFolder/train.csv", 'r')
    unHealthyAvs = getUnhealthyAverages(in1)
    in1.close()
    classSeps = getClassSeps(healthyAvs, unHealthyAvs)
    # in1 = open("codeFolder/train.csv", 'r')
    in1 = open("csvFiles/cleveland.csv", 'r')
    newData = compareData(in1, classSeps)
    in1.close()
    getProperPresentation(patientTotal, healthyIll[0], healthyIll[1],healthyAvs, unHealthyAvs, classSeps,newData)
# def getFiles():
#     in1 = open("codeFolder/train.csv", 'r')
#     in2 = open("csvFiles/cleveland.csv", 'r')
    # return in1, in2
def countersAccumulators(a):
    # This function can return the total of healthy people and ill people (in that order), and the total numneber of files processed. 
    statusContainer = []
    healthy = []
    ill = []
    lineCounter = 0
    test = 0
    for line in a:
        lineCounter += 1
        while test < lineCounter:
            test += 1
            if line[-2] == '0':
                healthy.append(line[-2])
            else:
                ill.append(line[-2])
    statusContainer.append(len(healthy))
    statusContainer.append(len(ill))
    return statusContainer
def totalPatients(a):
    # This function returns the total patient count in the file
    lineCounter = 0
    for line in a:
        lineCounter += 1
    return lineCounter
def getHealthyAverage(a):
    totalsContainer = [0] * 13
    test = []
    c1 = 0
    idx = 0
    for line in a:
        var = line.split(",")
        var[-1] = var[-1].strip("\n")
        if var[-1] == '0':
            c1 += 1
            for idx in range(13):
                if var[idx] == '?':
                    var[idx] = var[idx].replace("?", '0')
                    totalsContainer[idx] += float(var[idx])
                else:
                    totalsContainer[idx] += float(var[idx])
    for item in totalsContainer:
        test.append(item / c1)
    return test
def getUnhealthyAverages(a):
    totalsContainer = [0] * 13
    test = []
    c1 = 0
    idx = 0
    for line in a:
        var = line.split(",")
        var[-1] = var[-1].strip("\n")
        if var[-1] > '0':
            c1 += 1
            for idx in range(13):
                if var[idx] == '?':
                    var[idx] = var[idx].replace("?", '0')
                    totalsContainer[idx] += float(var[idx])
                else:
                    totalsContainer[idx] += float(var[idx])
    for item in totalsContainer:
        test.append(item / c1)
    return test
def getClassSeps(a, b):
    container = [0] * 13
    seps = []
    for i in range(13):
        container[i] += a[i] + b[i]
    for item in container:
        seps.append(round(item / 2, 2))
    return seps 
def compareData(a, b):
    sickPeople = 0
    idx = 0
    atRisk = 0
    actuallySick = 0
    out1 = open("clevelanddiag.csv", "w")
    test = []
    test2 = []
    count = 0
    countClev = 0
    combine = []
    value = 0
    difFile = False
    # This is just splitting up the line and adding index zero to the test list
    for line in a:
        var = line.split(",")
        var[-1] = var[-1].strip("\n")
        test.append(var[0])
        if float(var[0]) > 1000:
            difFile = True
            actuallySick = 124
        if len(var) > len(b):
            var = var[1:]
        for idx in range(13):
            # print("at Risk moved up:", atRisk, "Places")
            # print("\n")
            # print("Before check: ", var[idx], "____",b[idx])
            if var[idx] == "?":
                # print(var[idx])
                var[idx] = var[idx].replace("?", "0") 
            if float(var[idx]) > b[idx]:
                # print("\n")
                # print("During Check: ", var[idx], "____",b[idx])
                # print("at Risk AFTER check:", atRisk)
                atRisk += 1
        #Now we have left the for loop in range 13
        #This is checking to see what file we are dealing with 
        if var[-1] > "0" and difFile == False:
            actuallySick += 1

        # This is where we determine if the person is sick or not, and add it to the list that will be sent to a csv file. This is where things are going wrong I think
        if atRisk >= 7:
            count += 1
            atRisk = 0
            sickPeople += 1
            test2.append("1")
        else:
            test2.append("0")
        if atRisk < 7:
            atRisk = 0
    # This while loop is getting things ready for the csv
    while value < len(test):
        combine.append(test[value])
        combine.append(",")
        combine.append(test2[value])
        combine.append("\n")
        value += 1
    for item in combine:
        out1.write(item)
    #13 too many sick counted
    somevar = (actuallySick / sickPeople) * 100
    print("-" * 50)
    print("sick prediction:", sickPeople)
    print("actually sick:", actuallySick)
    print("prediction rate: %{0:.2f}".format(somevar))
    print("-" * 50)
    return somevar
    out1.close()
def getProperPresentation(tot, hel, ill, havs, unhavs, seps, data):
    templist = []
    templist2 = []
    for item in havs:
        templist.append(round(item,2))
    templist = str(templist)
    for item in unhavs:
        templist2.append(round(item,2))
    templist2 = str(templist2)
    seps = str(seps)
    print("Total Lines Processed: {}".format(tot))
    print("Total Healthy Count: {}".format(hel))
    print("Total Ill Count: {}".format(ill))
    print("Averages of Healthy Patients:\n{}".format(templist[1:-1]))
    print("Averages of Ill Patients:\n{}".format(templist2[1:-1]))
    print("Seperation Values are:\n{}".format(seps[1:-1]))
    print("Accuracy of The Model: %{0:.2f}".format(data))
main() 