# There are 14 attributes 
def main():
    # Need to figure out how to send functions to grab data without 
    # Part one: Open the file
    in1 = open("codeFolder/train.csv", 'r')
    # Get the total healthy and ill people
    healthyIll = countersAccumulators(in1)
    in1.close()
    # print("Total healthy, Total Ill")
    # print(healthyIll)
    in1 = open("codeFolder/train.csv", 'r')
    patientTotal = totalPatients(in1)
    # print("Patient total")
    # print(patientTotal)
    in1.close()
    in1 = open("codeFolder/train.csv", 'r')
    healthyAvs = getHealthyAverage(in1)
    in1.close()
    in1 = open("codeFolder/train.csv", 'r')
    unHealthyAvs = getUnhealthyAverages(in1)
    in1.close()
    classSeps = getClassSeps(healthyAvs, unHealthyAvs)
    print(classSeps)
    in1 = open("csvFiles/cleveland.csv", 'r')
    newData = compareNewData(in1, classSeps)
    in1.close
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
    c1 = 0
    c2 = 0
    c3 = 0
    idx = 0
    val = 0
    for line in a:
        c2Before = c2
        var = line.split(",")
        var[-1] = var[-1].strip("\n")
        for idx in range(13):
                if var[idx] == '?':
                    var[idx] = var[idx].replace("?", '0')
                    if var[idx] > b[idx]:
                        c2 += 2
                        if c2 > (len(var) / 2):
                            c3 += 1
                else:
                    if float(var[idx]) > b[idx]:
                        print(True)
                        c2 += 1
                    else:
                        print(False)
                        val += 1
        if (c2 - c2Before) > 6:
            c3 += 1
    print(c1, c2, c3, val)
main() 