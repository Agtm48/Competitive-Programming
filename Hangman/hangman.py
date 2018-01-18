import random
import time
import os
def startUp():
    print("Welcome to Hangman!")
    print("This game has 2 modes: Single Player or Multiplayer (S/M) ")
    gameType = raw_input("Select your game mode: (S/M)")
    if(gameType.lower() == "m"):
        word = raw_input("Select a word that you would like to use for the game.")
    elif(gameType.lower() == "s"):
        path = raw_input("What is the file path of the text you would like to load in? Use '/'s to separate folders.")
        path.replace("/", "\\")
        os.chdir(path)
        f = open("words.txt", "r")
        wordArr = []
        for line in f:
            wordArr.append(line)
        word = wordArr[random.randrange(0, len(wordArr) - 1)]
        time.sleep(0.5)
    else:
        print("Sorry. That is not a correct option.");
        startUp();
    for num in range(1, 10):
        print("")
    strLength = len(word)
    game(word, strLength)

def game(name, strLen):
    for line in range(1, strLen + 1):
        print("_"),
        break
    letterList = []  # contains t, e, s, t, e, r
    guesses = []
    tries = 7;
    wonGame = False
    for c in name:
        letterList.append(c)
    while(wonGame == True or tries > 0):
        letter = raw_input("Choose a letter : ")

        try:
            # Checks to see whether the letter is in the alphabet or not
            isAlpha = (ord(letter) >= 65 and ord(letter) <= 90) or (ord(letter) >= 97 and ord(letter) <= 122 ) or (ord(letter) == 32);
            if(isAlpha):
                guesses.append(letter)
            else:
                print("Must enter a letter!")
                tries = tries - 1
        except:
            time.sleep(0.45)
            print("Error: Must enter a letter.")

        for i in letterList:
            if i in guesses:
                print(i),

            else:
                print("_"),
        if(checkIfWon(letterList, guesses, name)):
            print("You win!")
            break
        if(letter in name):
            tries = tries
        else:
            tries = tries - 1;
        validate(tries, name)


def checkIfWon(list, guess, sname):
    num_right = 0
    for i in list:
        if i in guess:
            num_right = num_right + 1
    return (len(sname) == num_right)

def validate(tries, word):
    if (tries != 0):
        print("You have " + str(tries) + " tries remaining. Please solve the problem")
    else:
        print("Sorry. Game Over- You did not answer within the correct amount of tries. The word was " + word)
    print("")
def main():
    startUp()


main()