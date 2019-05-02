# Project5
First, I created the frame class called HammingDistFrame with a constructor adding 2 JPanels to the class for each side of the
GUI. Next, I started adding theJButtons, JTextFields, etc. to the JPanels and had them all in the program, formatted
correctly, but with no functionality.Then I added in the methods readFile, findHammingDist, and findNodes in order to utilize
them later in reading the input file,calculating the hamming distance between two STID values, and to find the number of
stations with a specific Hamming distancefrom a specified STID value. Finally I added ChangeListeners and ActionListeners at
the end of the constructor giving the JSlider, and 2 JButtons functionality. In the free zone, I implemented an error message
that triggered when the "AddStation" JButton was pressed and the text field input was either longer than 4 characters, or
contained a character that is not an uppercase character. However, when there is a successful input, the error message will
change and saym "No errors"
![Project 5 UML](https://github.com/jwilkerson257/project5UML/blob/master/Project5_UML.jpeg)
