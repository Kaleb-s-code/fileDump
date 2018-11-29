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
    getHealthyAverage(in1)
    in1.close()
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
    container = []
    iterations = 0
    healthyCount = 0
    idx = 1
    # This is supposed to get the totals of healthy people into a list
    for line in a:
        var = line.split(",")
        if line[-2] == '0':
            container.append(var[idx])
            # This checks for questionmarks and replaces them with str 0
            if var[idx] == '?':
                var[idx] = var[idx].replace("?", '0')
                container.append(var[idx])
                container.remove("?")
            healthyCount += 1
            while iterations < healthyCount:
                if var[idx]:
                    totalsContainer[idx] += float(var[idx])
                    iterations += 1       
    print(totalsContainer)
    print(container)
    print("iterations",iterations)
    print("idx",idx)
main() 

