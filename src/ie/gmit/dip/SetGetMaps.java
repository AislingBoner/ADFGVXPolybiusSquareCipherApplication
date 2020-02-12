/*
ProgrammeName: ADFGVXPolybiusCipherApp
ClassName: setGetMaps Class
ClassDescription:
This setGetMaps Class supplies the PolybiusCipher Class (i.e. class that has encrypt & decrypt methods) 
with the hash map array needed for Encryption & Decryption. The hash map assigns key value pairs
to an array whereby one object is used as a key to access another object within the key value pairs.
This is useful in the case of this project as the key value pair can be used in conjunction with the
user-chosen-encryptDecryptKey codeword to encrypt the supplied files for the project. The Hash Map allows
the use of the 'set and get methods' previously used in the Student Class of the StudentApp created 
during the workshops of this module.
Comments:
### Acid-stripped Code Adaption from - 
W3schools.com. (2019). Java HashMap. [online] 
Available at: https://www.w3schools.com/java/java_hashmap.asp 
[Accessed 11 Aug. 2019].
*/

package ie.gmit.dip;
import java.util.*;

public class SetGetMaps {
	
	//Declare variables.
	
	//Create a hash map that holds string keys and values.
	private static Map <String,String> adfgvx = new HashMap <String,String>(100);
	
	//Create an array list that holds Char array list(s).
	private static List <List<Character>> encrypt = new ArrayList <List<Character>>();
	private static List <List<Character>> decrypt = new ArrayList <List<Character>>();
	
	//Set up Encryption/Decryption Hash Map.
	public void setMap() { 
		adfgvx.put("AA", "P");adfgvx.put("P","AA");adfgvx.put("AD", "H");adfgvx.put("H", "AD");adfgvx.put("AF", "0");adfgvx.put("0", "AF");
		adfgvx.put("AG", "Q");adfgvx.put("Q", "AG");adfgvx.put("AV", "G");adfgvx.put("G", "AV");adfgvx.put("AX", "6");adfgvx.put("6", "AX");
		adfgvx.put("AY", ".");adfgvx.put(".", "AY");adfgvx.put("DA", "4");adfgvx.put("4", "DA");adfgvx.put("DD", "M");adfgvx.put("M", "DD");
		adfgvx.put("DF", "E");adfgvx.put("E", "DF");adfgvx.put("DG", "A");adfgvx.put("A", "DG");adfgvx.put("DV", "1");adfgvx.put("1", "DV");
		adfgvx.put("DX", "Y");adfgvx.put("Y", "DX");adfgvx.put("DY", ",");adfgvx.put(",", "DY");adfgvx.put("FA", "L");adfgvx.put("L", "FA");
		adfgvx.put("FD", "2");adfgvx.put("2", "FD");adfgvx.put("FF", "N");adfgvx.put("N", "FF");adfgvx.put("FG", "O");adfgvx.put("O", "FG");
		adfgvx.put("FV", "F");adfgvx.put("F", "FV");adfgvx.put("FX", "D");adfgvx.put("D", "FX");adfgvx.put("FY", "!");adfgvx.put("!", "FY");
		adfgvx.put("GA", "X");adfgvx.put("X", "GA");adfgvx.put("GD", "K");adfgvx.put("K", "GD");adfgvx.put("GF", "R");adfgvx.put("R", "GF");
		adfgvx.put("GG", "3");adfgvx.put("3", "GG");adfgvx.put("GV", "C");adfgvx.put("C", "GV");adfgvx.put("GX", "V");adfgvx.put("V", "GX");
		adfgvx.put("GY", "?");adfgvx.put("?", "GY");adfgvx.put("VA", "S");adfgvx.put("S", "VA");adfgvx.put("VD", "5");adfgvx.put("5", "VD");
		adfgvx.put("VF", "Z");adfgvx.put("Z", "VF");adfgvx.put("VG", "W");adfgvx.put("W", "VG");adfgvx.put("VV", "7");adfgvx.put("7", "VV");
		adfgvx.put("VX", "B");adfgvx.put("B", "VX");adfgvx.put("VY", " ");adfgvx.put(" ", "VY");adfgvx.put("XA", "J");adfgvx.put("J", "XA");
		adfgvx.put("XD", "9");adfgvx.put("9", "XD");adfgvx.put("XF", "U");adfgvx.put("U", "XF");adfgvx.put("XG", "T");adfgvx.put("T", "XG");
		adfgvx.put("XV", "I");adfgvx.put("I", "XV");adfgvx.put("XX", "8");adfgvx.put("8", "XX");adfgvx.put("XY", ":");adfgvx.put(":", "XY");
		adfgvx.put("RA", ";");adfgvx.put(";", "RA");adfgvx.put("RD", "-");adfgvx.put("-", "RD");adfgvx.put("RF", "*");adfgvx.put("*", "RF");
		adfgvx.put("RG", "(");adfgvx.put("(", "RG");adfgvx.put("RV", ")");adfgvx.put(")", "RV");adfgvx.put("RX", "\n");adfgvx.put("\n","RX");
		
	}
	
	//Get Map
	public Map<String, String> getMap() { 
		return adfgvx;	
	}
	
	
	//Creates an ArrayList - depending on the length of the inputed key.
	public void createArrayLists(String keyword) { 
		
			int len = keyword.length();
			int i = 0;
			
			while(i < len){
				
				encrypt.add(i, new ArrayList<Character>()); 
				decrypt.add(i, new ArrayList<Character>());
				i++;
				}
			}
		
	
	
	//Get encryption array list.
	public List<List<Character>> getEncrypt(){ 
		return encrypt;
	}
	
	
	//Get decryption array list.
	public List<List<Character>> getDecrypt(){ 
		return decrypt;
	}

	
}//End of Class
	


