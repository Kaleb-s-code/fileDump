

    # This is supposed to get the totals of healthy people into a list
    # while idx < 12:
    #     for line in a:
    #         var = line.split(",")
    #         if line[-2] == '0':
    #             container.append(var[idx])
    #             # This checks for questionmarks and replaces them with str 0
    #             if var[idx] == '?':
    #                 var[idx] = var[idx].replace("?", '0')
    #                 container.append(var[idx])
    #                 container.remove("?")
    #                 totalsContainer[idx] += float(var[idx])
    #                 ifCount += 1
    #             else:
    #                 totalsContainer[idx] += float(var[idx])
    #                 elseCount += 1
    #         if idx < 12:
    #             idx += 1

        # for idx in range(12):
        #print(idx)
        #print(totalsContainer)
in1 = open("codeFolder/train.csv", 'r')
count = 0
for line in in1:
    line.split(",")
    print(line[-2])
    if line[-2] > '0':
        count += 1
in1.close()
print(count)