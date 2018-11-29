in1 = open("textFiles.txt\char.cnt", 'r')
#out1 = open("ch.csv", 'w')
cc = [0] * 26
for line in in1:
    line.lower()
    for ch in line:
        if ord(ch) >= ord("a") and ord(ch) <= ord("z"):
            cc[ord(ch) - ord("a")] += 1
print(cc)
letter = 0
while letter < len(cc):
    print("{0:a},{1:d}\n".format(chr(ord("a")) + letter, cc[letter]))
    letter += 1
in1.close()
#out1.close()
