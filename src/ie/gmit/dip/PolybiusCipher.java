/*
ProgrammeName: ADFGVXPolybiusCipherApp
ClassName: PolybiusCipher Class
ClassDescription:
The "PolybiusCipher" Class Encrypts & Decrypts any of the files supplied for this assignment. The 
"fileEncryption" Method reads-in the file for encryption which is accompanied by a buffered reader,
and a for-loop then loops through all of the read-in characters from the text document. The for-loop 
searches the hash map in the "setGetMaps" Class and creates array lists sized appropriately for the 
documents being encrypted and decrypted. Using an encryptDecryptKey that is set by the user, the document
is then encrypted with the corresponding characters associated with the private key inputed. These corresponding
characters are then written to an "EncryptedFile.txt" file. The "Decrypt" method reads-in line by line from
the encrypted file, "EncryptedFile.txt" and fills the array list "decrypt" with the corresponding decryption
characters. These are then in-turn written to a file "DecryptedFile.txt".
Comments:
### Acid-stripped Code Adaption from - 
	(1) GeeksforGeeks. (2019). Polybius Square Cipher. [online]
		Available at: https://www.geeksforgeeks.org/polybius-square-cipher/ 
		[Accessed 11 Aug. 2019].
	
	(2) GitHub. (2019). Encryption-Decryption-Program. [online]
		Available at: https://github.com/codevonnie/Encryption-Decryption-Program 
		[Accessed 14 Aug. 2019].
	
*/

package ie.gmit.dip;
import java.io.*;
import java.util.*;


public class PolybiusCipher {


	//Encryption Methods--------------------------------------------------------------------------------------	
	
		/* fileEncryption - Method reads in chosen File for encryption, converts to upper-case and runs hash map to 
		 * find corresponding key value to append to the string builder, sbA. 		 */
	    public StringBuilder fileEncryption(Map<String, String> adfgvx, String fileChoice) throws IOException {
			
			StringBuilder sbA = new StringBuilder(); //new instance of sbA.
			File f = new File(fileChoice); //File chosen assigned to File f for parsing with bf.
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f))); //br - Increases efficiency of reading in the characters (parser).
			String linesIn, charUp;
			int i = 0;
			
			while((linesIn = br.readLine())!= null){   //As long as values are present to read-in i.e. (!= null).
				
				char[] c = linesIn.toCharArray();      //Convert read-in Line (readLine) to char array c.
				int len = c.length; //len == Length of array c.
				
					while(i < len){ //Convert the chars to upper-case and compare these to the polybius map in the Maps Class.
						
						charUp = Character.toString(c[i]).toUpperCase(); //Characters To Uppercase.
												
						if(adfgvx.containsKey(charUp)){ //If the hash map contains the key char, append the value associated with key to stringbuilder.	
								sbA.append(adfgvx.get(charUp));
							}
						i++;
					}
					
				i = 0;
				sbA.append(adfgvx.get("\n")); //Breaks up values being appended to string builder.
				}
			br.close(); 
			return sbA;
		}
	    
		
    	/* fillEncryptArray - Method for filling the array list "encrypt" with encrypted
		 * chars from the file that is chosen by the user to encrypt. */
		public void fillEncryptArray(String encryptDecryptKey, List<List<Character>> encrypt, StringBuilder sbA) {
			int count = 0, i = 0;
			int len = sbA.length(); //len == sbA length above.
			int keyLen = encryptDecryptKey.length(); //keyLen == inputted encryptDecryptKey length.
			
				while(i < len){
					encrypt.get(count).add(sbA.charAt(i)); //Use int count to add the value above to correct array list.
					i++;
					count++;
					
					if(count == keyLen) {
						count = 0;
					}
				}	
				
		}
		

	    /* sortArray - Method that sorts the order to write the array lists to the file for columnar transposition.
	     *  i.e. alphabetising the encryptDecryptKey key inputed by the user and reading the sorted columns to the file in the
	     *  order of the alphabetised key word.*/
		public int[] sortArray(String encryptDecryptKey) {
			
			char[] keySorted = encryptDecryptKey.toCharArray(); //The char array keySorted is  is set to length of inputed encryptDecryptKey length.
			char[] oriKey = encryptDecryptKey.toCharArray(); //The char array ori (original unsorted Key), is set to length of inputed encryptDecryptKey length.
			int len = encryptDecryptKey.length();//len == encryptDecryptKey length inputed by the user.
			int k [] = new int[len]; //int array k length == len value.
			Arrays.sort(keySorted); //Alphabetically sort the keyword.
			
			for(int i = 0; i < len; i++){
				
				for(int j = 0; j < len; j++){
					
					if(keySorted[i] == oriKey[j]){
						
						k[i] = j;
						keySorted[i] = '`';
						oriKey[j] = '¬'; 
						
					}
				}
			}
			return k; //return int array k.
		}
		
		
		//writeFile - Writes Encrypted Characters from sortArray to a text file.
		public void writeEncryptionFile(List<List<Character>> encrypt, int[] code) throws FileNotFoundException {
			
			StringBuilder sbA = new StringBuilder();
			PrintWriter writer = null;
			int len = code.length;
			int i = 0;
			writer = new PrintWriter("EncryptedFile.txt");
		
			while(i < len){ //While-loop reads array list columns in order of alphabetically sorted keyword inputed.
                
                for(Character list: encrypt.get(code[i])){
					sbA.append(list); //Append to string Builder.
					
				}
                
				i++;
				writer.print(sbA); //Write sbA to file.
				writer.println();
				sbA.setLength(0);
			}
			//Housekeeping
			writer.flush();
			writer.close();
        }

        
		
   //Decryption Methods---------------------------------------------------------------------------------------

		/* encryptFileIn - Method that takes in the  file "EncryptedFile.txt" line by line to be decrypted as new file 'decruptF'.
		 * This is passed through a buffered reader speeding up decryption times. Depending on the sorted order of 
		 * the columns the decryptF file is created. */
		public int encryptFileIn(String keyword, List<List<Character>> decrypt, int[] code) throws IOException {
		
				File decryptF = new File("EncryptedFile.txt"); // new file containing the "EncryptedFile.txt" message.
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(decryptF))); //New Buffered Reader.																																												
				String decLine = null;
				int numChars = 0, count = 0; //int count adds each value to correct array List.
				int listLen = code.length;
		
					while ((decLine = br.readLine()) != null) { //While loop.
			
						char[] c = decLine.toCharArray();
						int cLen = c.length;
			
						for (int i = 0; i < cLen; i++) { //for loop.
			
							if (count == listLen) {
								count = 0;
			
							}
							decrypt.get(code[count]).add(c[i]); 
							numChars++;
						}
			
						count++;
					}
		
				br.close(); //Close buffered reader.
				return numChars;
		
			}


		// fillDecryptArray - Method that fills Decrypt Array depending on user-inputed encryptDecryptKey length.
		public StringBuilder fillDecryptArray(String encryptDecryptKey, List<List<Character>> decrypt, int numChars) {
	
				StringBuilder sbA = new StringBuilder();
				int rows;
				int len = encryptDecryptKey.length();
		
				if (numChars % len != 0) { //If numChars % encryptDecryptKey.length != 0 - run if statement.
					rows = (numChars / len) + 1;
		
				} else {
					rows = (numChars / len);// else if numChars % encryptDecryptKey.length = 0, row value changes.
		
				}
		
				for (int j = 0; j < rows; j++) { //for-loop.
		
					for (int i = 0; i < len; i++) {//Nested for-loop.
		
						List<Character> rowList = decrypt.get(i);
						if (j < rowList.size()) {
		
							sbA.append(rowList.get(j)); //Append to string builder "sbA".
							
						}
					}
				}
		
				return sbA;
		
		}


		/* decryptionFileGen - Method decrypts the encryption version of the fileChoice and writes it to the 
		 * file "DecryptionFile.txt". It searches for the key in the hash map and outputs to "sbB" the 
		 * character associated with the key. */
		public void decryptionFileGen(Map<String, String> adfgvx, StringBuilder sbA) throws FileNotFoundException {
	
			PrintWriter writer = null;
			writer = new PrintWriter("DecryptedFile.txt");
			StringBuilder sbB = new StringBuilder(); //new string builder.
			String charUp;
			int i = 0;
			int len = sbA.length();
			
			while (i < len) {
	
				charUp = sbA.substring(i, i + 2);
				
				if (adfgvx.containsKey(charUp)) {
					
					sbB.append(adfgvx.get(charUp));
				}
				
				i += 2; // Reads 2 characters and adds them to the string being generated for decryption.
			}
	
			writer.println(sbB); // Decryption characters output to File "DecryptedFile.txt"
	
			// Housekeeping
			writer.flush();
			writer.close();
	
			}
	

}//End of Class


