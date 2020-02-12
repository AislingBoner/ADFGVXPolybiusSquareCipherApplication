Project Name:  ADFGVX Polybius Square Cypher Assignment.

Submission Date: GMIT 31 August 2019

StudentName:  Aisling Boner

StudentID: G00376422

This is my README.txt for the ADFGVX Polybius Square Cypher Assignment.


Project Description & Application Instructions:______________________________________________________________________________________

For this Assignment we were required to develop a java application based on the ADFGVX Polybius cypher that was originally used by the Germans during the Ludendorff Offensive in WW1 (Practicalcryptography.com, 2019).

The following application was created on the 'Eclipse IDE 2019 06' Desktop Platform.

Instructions:
1).Run the program using "java ie.gmit.dip.Runner" which initiates userMenuOptions Class. 
2).You will be prompted to choose 'Encrypt & Decrypt a File' or 'Quit' application.
3).Upon choosing 'Encrypt & Decrypt a File'- you will beasked to enter
 the name of the file for encrypt/decryption i.e.Please Enter the Text File Name for Encrypt/Decryption:(fileNameAbove.txt e.g. IgnoreWords.txt ).
4).Next enter a Key code-word for Cipher Encryption/Decryption. 
5).The program will then Initalise the polybius square in the form of a hash map, carry out encryption and decryption methods utilising the encryptDecryptKey and output the results file text documents "EncryptedFile.txt" and "DecryptedFile.txt". 


Class Descriptions: _________________________________________________________________________________________________________________

Runner Class - The following Polybius Cipher application is run using the “Runner” Class. It carries this out by initiating the "Menu" Class, a class which is used to call upon all the classes required to run the encryption and decryption methods for this application.  

UserMenuOptions Class - This "userMenuOptions" Class acts as a User Interface for a User Menu for this application. The menu consists of Two options related to the Polybius Cipher application. One allows the user to encrypt & decrypt several text files supplied with this assignment. This option calls upon the classes and methods that are required to carry out this Encryption & Decryption. The second option 'Quits' the application.

SetGetMaps Class - This setGetMaps Class supplies the PolybiusCipher Class (i.e. class that has encrypt & decrypt methods) with the hash map array needed for Encryption & Decryption. The hash map assigns key value pairs to an array whereby one object is used as a key to access another object within the key value pairs. This is useful in the case of this project as the key value pair can be used in conjunction with the user-chosen-encryptDecryptKey codeword to encrypt the supplied files for the project. The Hash Map allows the use of the 'set and get methods' previously used in the Student Class of the StudentApp created during the workshops of this module.

PolybiusCipher Class - The "PolybiusCipher" Class Encrypts & Decrypts any of the files supplied for this assignment. The "fileEncryption" Method reads-in the file for encryption which is accompanied by a buffered reader, and a for-loop then loops through all of the read-in characters from the text document. The for-loop  searches the hash map in the "setGetMaps" Class and creates array lists sized appropriately for the documents being encrypted and decrypted. Using an encryptDecryptKey that is set by the user, the document is then encrypted with the corresponding characters associated with the private key inputed. These corresponding characters are then written to an "EncryptedFile.txt" file. The "Decrypt" method reads-in line by line from the encrypted file, "EncryptedFile.txt" and fills the array list "decrypt" with the corresponding decryption characters. These are then in-turn written to a file "DecryptedFile.txt".


Acknowledgement and References (i.e.Code design and Ideology adapted from): ________________________________________________________

GeeksforGeeks. (2019). Polybius Square Cipher. [online] Available at: https://www.geeksforgeeks.org/polybius-square-cipher/ [Accessed 11 Aug. 2019].

GitHub. (2019). Encryption-Decryption-Program. [online] Available at: https://github.com/codevonnie/Encryption-Decryption-Program [Accessed 14 Aug. 2019].

Hossain, I. (2019). How do I get the coordinates of a word in a Polybius cipher in Java?. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/57197678/how-do-i-get-the-coordinates-of-a-word-in-a-polybius-cipher-in-java [Accessed 9 Aug. 2019].

Malcolm, J. (2019). WW2Encryption. [online] GitHub. Available at: https://github.com/johnmalcolm/WW2Encryption/blob/master/ColumnarTransposition.java [Accessed 11 Aug. 2019].
Practicalcryptography.com. (2019). Practical Cryptography. [online] Available at: http://practicalcryptography.com/ciphers/adfgvx-cipher/ [Accessed 10 Aug. 2019].

StudentApp Week 9, Dr.John Healy - learnonline.gmit.ie (2019)[online]. Available at: https://learnonline.gmit.ie/course/view.php?id=3414[Accessed 05 Aug. 2019].

Tighe, C. (2019). How to pair string input with chars in a 2D array?. [online] Stack Overflow. Available at: https://stackoverflow.com/questions/29354559/how-to-pair-string-input-with-chars-in-a-2d-array [Accessed 9 Aug. 2019].

W3schools.com. (2019). Java HashMap. [online] Available at: https://www.w3schools.com/java/java_hashmap.asp [Accessed 11 Aug. 2019].

Whyte, K. (2019). ADFGVX-Cypher-Java-Programming. [online] GitHub. Available at: https://github.com/whytekieran/ADFGVX-Cypher-Java-Programming/blob/master/README.md [Accessed 11 Aug. 2019].
