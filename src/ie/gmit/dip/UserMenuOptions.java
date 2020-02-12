/*
ProgrammeName: ADFGVXPolybiusCipherApp
ClassName: userMenuOptions Class
ClassDescription:
This "userMenuOptions" Class acts as a User Interface for a User Menu for this application. The menu consists
of Two options related to the Polybius Cipher application. One allows the user to encrypt & decrypt several 
text files supplied with this assignment. This option calls upon the classes and methods that are required to 
carry out this Encryption & Decryption. The Second option 'Quits' the application.
Comments:
### Acid-stripped Code Adaption from - 
StudentApp Week 9, Dr.John Healy - learnonline.gmit.ie (2019)[online].
Available at: https://learnonline.gmit.ie/course/view.php?id=3414
[Accessed 05 Aug. 2019].
*/

package ie.gmit.dip;
import java.io.*;
import java.util.*;

public class UserMenuOptions {
	private Scanner s;
    private boolean keepRunning = true;
    
    public void start() throws IOException{ //Starts up Menu in "Runner" Class.
       
    	s = new Scanner(System.in); //Creates a new instance of a scanner, s.
        
    	while (keepRunning){
            showOptionsA();
            int selection = Integer.parseInt(s.next()); //Waits on Input from User - Options Below.
            
            if (selection == 1){ // Selects A File for Encrypt & Decryption.
            	encryptDecryptFile(); 
            	keepRunning = false;
            	
            }else if (selection == 2){ // Quit Application.
                System.out.println("Closing Application...GoodBye!");
                System.out.print("\n");
                System.out.println("######################################################");
                System.out.println("######################################################");
                keepRunning = false;
            	   
            }else{ 
                System.out.println("Invalid choice!"); //Invalid Input displayed for Numbers outside range of 1-3.
            	}
        	}
        }
        
    
    private void showOptionsA(){ //ADFGVX Polybius Square Cipher Opening Menu.
    	
        	System.out.print("\n");	
        	System.out.println("######################################################");	
            System.out.println("######## ADFGVX Polybius Square Cipher v 1.0   #######"); 
            System.out.println("######################################################");
            System.out.print("\n");	
            System.out.print("\n");	
            System.out.println("(1) Encrypt & Decrypt a File.");   
            System.out.print("\n");        
            System.out.print("\n");	
            System.out.println("(2) Quit."); 
            System.out.print("\n");	
            System.out.print("\n");	
            System.out.println("******************************************************");	
            System.out.println("Select An Option [1-2]: "); 
            System.out.print("\n");	
            System.out.println("******************************************************");
    }
        
        
    private void showOptionsB(){ //Menu to Choose file to Encrypt/Decrypt.
        	
        	System.out.print("\n");	
    		System.out.println("#######################################################");
    		System.out.println("####### File's for Encryption/Decryption ##############");
    		System.out.println("#######################################################");
    		System.out.print("\n");	
    		System.out.println(">PoblachtNaHEireann");
    		System.out.println(">DeBelloGallico-Caesar");
    		System.out.println(">WarAndPeace-Tolstoy");
    		System.out.println(">DivineComedy-Dante");
    		System.out.println(">HappyPrince-Wilde");
    		System.out.println(">IgnoreWords");
    		System.out.println(">PictureOfDorianGray-Wilde");
    		System.out.println(">ThePrince-Machiavelli");
    		System.out.print("\n");	
    		System.out.println("*******************************************************");
    		System.out.println("Please Enter the Text File Name for Encrypt/Decryption: "); 
    		System.out.println("(fileNameAbove.txt e.g. IgnoreWords.txt )");
    		System.out.println("*******************************************************");
    		System.out.print("\n");	
    }
    

       
    private void encryptDecryptFile() { //Method to Encrypt&Decrypt a File chosen by the User.
   
        	Scanner s = new Scanner(System.in);
        	showOptionsB();
        	String fileChoice = s.next(); //User Inputs Text-File Name.
    		System.out.print("\n");	
    		System.out.println("*******************************************************");
    		System.out.println("Enter Key Word for Cipher Encryption/Decryption: ");
    		System.out.println("*******************************************************");
			String encryptDecryptKey = s.next(); //User Inputs encryptDecryptKey for Encryption.
			System.out.print("\n");	
			System.out.print("\n");
			System.out.println("*******************************************************");
			s.close();
    		
    		
    		
        	try{
        		long startTime = System.currentTimeMillis();  //Start Timing - 'Performance test' i.e. to see how quickly the application runs.
        		SetGetMaps maps = new SetGetMaps(); //Create an Instance of the "Maps" Class.
         		maps.setMap(); //Set the Hash map values for the Encryption Cipher.
         		PolybiusCipher polybiusCipher = new PolybiusCipher(); //Create an Instance of "PolybiusCipher" Class.
         		maps.createArrayLists(encryptDecryptKey);
         		
         			//Encryption Methods.
         				StringBuilder sbA = polybiusCipher.fileEncryption(maps.getMap(), fileChoice); //The char array takes the value returned by the encrypt method.
         				polybiusCipher.fillEncryptArray(encryptDecryptKey, maps.getEncrypt(), sbA); //The File array lists with their encrypted values. 
         				int[] code = polybiusCipher.sortArray(encryptDecryptKey); //The order of the array lists to be read-to the file.
         				polybiusCipher.writeEncryptionFile(maps.getEncrypt(), code); //Write encrypted message to file "EncryptedFile.txt".
         				System.out.println("*******************************************************");
         				System.out.print("\n");	
         				System.out.print("Encryption File  Completed.");
         				System.out.print("\n");	
         				System.out.println("File Encryption Run Time (ms): " + (System.currentTimeMillis() - startTime)); //End of Performance test - time outputted to screen.
         				System.out.print("\n");	
         				System.out.print("\n");	
         			//Decryption Methods.
         				long startTimeB = System.currentTimeMillis();
         				int numChars = polybiusCipher.encryptFileIn(encryptDecryptKey, maps.getDecrypt(), code); //Read-in encrypted file & count # of chars read-in.
         				sbA = polybiusCipher.fillDecryptArray(encryptDecryptKey, maps.getDecrypt(),  numChars); //Fill the array list with read-in chars.
         				polybiusCipher.decryptionFileGen(maps.getMap(),sbA); //Decrypt the file.
         				System.out.print("Decryption File Completed.");
         				System.out.print("\n");	
         				System.out.println("File Decryption Run Time (ms): " + (System.currentTimeMillis() - startTimeB));
         				System.out.print("\n");	
         				System.out.print("\n");	
     		     		System.out.println("Total File Encryption/Decryption Run Time (ms): " + (System.currentTimeMillis() - startTime)); //End of Performance test - time outputted to screen.
     		     		System.out.print("\n");
     		     		System.out.print("NOTE: Files can be found in the Folder.");
     		     		System.out.print("\n");
     		     		System.out.print("\n");
     		     		System.out.println("#######################################################");
     		     		System.out.println("#######################################################");
     		     		    
		    }catch (Exception e){
		    	
	            System.out.println("Message: " + e.getMessage()); //Shows the Key Issue if the above was tried and failed.
	            e.printStackTrace(); //Shows entire Stack Trace highlighting where issues occurred.   
		    
		    }
        	 
        }
    
   

    
}//End of Class
        
        
  
