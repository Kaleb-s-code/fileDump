def main():
    # open up input
    infile = open("textFiles.txt\scores.txt", 'r')
    # create counters list
    stuff = create_lists(infile)
    # display histogram
    display_Histo(stuff)
    # display history
def create_lists(a):
    ses = []
    scoreCuts = [0] * 101
    for line in a:
        score = int(line)
        scoreCuts[score] = scoreCuts[score] + 1
    i = 0
    while i < 101:
        i += 1
        ses.append(0)
    return scoreCuts
def display_Histo(a):
    index = 0
    counter = 0
    otherCounter = 0
    while index < len(a):
        print("{0}:".format(index), end = '')
        index += 1
        stats = 0
    return counter
        

main()