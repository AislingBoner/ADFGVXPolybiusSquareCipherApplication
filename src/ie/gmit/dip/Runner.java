/*
ProgrammeName: ADFGVXPolybiusCipherApp
ClassName: Runner Class
ClassDescription:
The following Polybius Cipher application is run using the “Runner” Class. It carries this out by 
initiating the "Menu" Class,a class which is used to call upon all the classes required to run the
encryption and decryption methods for this application.  
Comments:
### Acid-stripped Code Adaption from - 
StudentApp Week 9, Dr.John Healy - learnonline.gmit.ie (2019)[online].
Available at: https://learnonline.gmit.ie/course/view.php?id=3414
[Accessed 05 Aug. 2019].
*/

package ie.gmit.dip; //Package Name.
import java.io.*;

public class Runner {
		
	//Main Method - To Run Application.
	public static void main(String[] args) throws IOException {
			 
				UserMenuOptions m = new UserMenuOptions(); //Create a New Instance of a userMenuOptions Class.
				m.start();
				
					
		}
		
	}//End of Class

