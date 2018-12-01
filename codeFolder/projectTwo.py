def main():
    in1 = open("codeFolder/train.csv", 'r')
    healthyIll = countersAccumulators(in1)
    in1.close()
    in1 = open("codeFolder/train.csv", 'r')
    patientTotal = totalPatients(in1)
    in1.close()
    in1 = open("codeFolder/train.csv", 'r')
    healthyAvs = getHealthyAverage(in1)
    in1.close()
    in1 = open("codeFolder/train.csv", 'r')
    unHealthyAvs = getUnhealthyAverages(in1)
    in1.close()
    classSeps = getClassSeps(healthyAvs, unHealthyAvs)
    in1 = open("codeFolder/train.csv", 'r')
    # # in1 = open("csvFiles/cleveland.csv", 'r')
    newData = compareNewData(in1, classSeps)
    in1.close()
    present = getProperPresentation(patientTotal, healthyIll[0], healthyIll[1],healthyAvs, unHealthyAvs, classSeps)
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
def compareNewData(a, b):
    questionMarks = 0
    sickPeople = 0
    idx = 0
    atRisk = 0
    for line in a:
        var = line.split(",")
        var[-1] = var[-1].strip("\n")
        for idx in range(13):
            if var[idx] == '?':
                var[idx] = var[idx].replace("?", '0')
            if float(var[idx]) > b[idx]:
                atRisk += 1
        if atRisk > 7:
            atRisk = 0
            sickPeople += 1
    # 139 is the total sick in train.csv
    somevar = (139 / sickPeople) * 100
    print("sick people counted: ",sickPeople)
    print("prediction rate (train.csv): %{0:.2f}".format(somevar))
    print("-" * 50)
def getProperPresentation(tot, hel, ill, havs, unhavs, seps):
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
main() 