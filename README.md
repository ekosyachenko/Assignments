# Assignments
Study programs in Java, which I wrote as part of the application process to the Graduate Certificate in Software Design and Development program in UW Bothell in 2015.

<b>HangPersonGame</b>

This is the hangperson game where a player tries to guess a word given the spaces it takes up. 
Each time an incorrect letter is chosen, another body part is added to the gallows. After seven tries, the whole body is hung 
and the player loses.
Before the user plays, an introduction is displayed briefly describing the game. At the start of one round of the game, 
empty gallows are display, dashes or underscores appear where the letters would be, and where the guessed letters will be displayed. 
Additionally letters that the user has already guessed are displayed. As the user plays the game, the gallows, the word to guess, 
the letters guessed are continually updated. After the player wins or loses one round, a prompt asks if the player wants to continue 
playing.

<b>Sieve</b>

In this program, you will use a queue to implement an algorithm for finding all of the prime numbers up to a specified value n. 
The technique, called the Sieve of Eratosthenes, is ancient (third century BCE) and was developed by a Greek named Eratosthenes.

<b>SoftDrinkInventory</b>

You work at a soft drink distributorship that sells at most 100 different kinds of soft drinks. 
The program you write for this assignment will process weekly transactions and allow for a report to be 
displayed that includes the soft-drink name, ID, starting inventory, final inventory, and the number of transactions received.

<b>Wumpus</b>

The goal of Wumpus Mountain is for your Wumpus Hunter to search the mountain pathways for the golden scales left behind by 
all baby wumpus hatchlings. In the original game of "Hunt the Wumpus" the hero explored caverns searching for gold, avoiding 
bottomless pits, and using a bow and arrows to kill the wumpus. Fortunately, baby wumpi aren't dangerous. While there is no risk 
of death, and no shooting arrows in this version of the Wumpus World, you will be exploring new territory in search of gold.
The paths on Wumpus Mountain are arranged like what a computer scientist would call a "tree". This means that paths branch 
repeatedly, but they never come back together. So, once you reach the end of a path, you always need to backtrack to a preceding 
branch to continue your search. Also, there is only one way to get to any point on the mountain, and the only way to get off the 
mountain is the way you went in. So, you will need to navigate the tree structure in some logical order using a stack. Note that 
this assignment could be done recursively, and Java's runtime would then manage the stack, but you should explicitly use a stack 
structure (and an iterative algorithm) for this assignment.
