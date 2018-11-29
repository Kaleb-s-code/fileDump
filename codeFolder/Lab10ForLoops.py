def ex3a(num):

def ex3b(num):

def ex3c(word):
    
def main():
    num = int(input('Enter a number of terms: '))
    total = ex3a(num)
    print("The sum of the geometric series from 1 to {} is {}".\
          format(4 ** (num - 1), total))
    total = ex3b(num)
    print("The sum of the arithmetic series from 1/3 to {}/3 is {:.5f}".format(num, total))
    word = input("Enter a word: ")
    isReverse = ex3c(word)
    negation = 'not '
    if isReverse:
        negation = ''
    print("The word {} is {}in reverse alphabetical order".format(word, negation))
        
main()
