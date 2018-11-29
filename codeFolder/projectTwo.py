def main():
    # Need to figure out how to send functions to grab data without 
    # Part one: Open the file
    in1 = open("train.csv", 'r')
    # Get the total healthy and ill people
    healthyIll = countersAccumulators(in1)
    in1.close()
    # print("Total healthy, Total Ill")
    # print(healthyIll)
    in1 = open("train.csv", 'r')
    patientTotal = totalPatients(in1)
    # print("Patient total")
    # print(patientTotal)
    in1.close()
    in1 = open("train.csv", 'r')
    getTotals(in1)
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
def getTotals(a):
    healthyAverages = []
    container = []
    another = 0
    count = 0
    for line in a:
        var = line.split(",")
        # THis is supposed to get the totals of healthy people into a list
        if line[-2] == '0':
            count += 1
            container.append(float(var[0]))      
    for item in container:
        another += item
    healthyAverages.append(another / count)
    print(container)
    print(healthyAverages)
main()
# while idx < 14:
    # idx += 1
