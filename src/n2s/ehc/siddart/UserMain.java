package n2s.ehc.siddart;

import java.util.Scanner;

public class UserMain {
	//public static UserExceptions IO = new UserExceptions() ;
	public static UserBean beans = new UserBean();
	public static Scanner scons = new Scanner(System.in);
	public static void main(String[] args) {
		while(true)
		{
			System.out.println("Choose the option below\r\n" + 
					"***********************\r\n" + 
					"1 - Insert\r\n" + 
					"2 - Update\r\n" + 
					"3 - Delete\r\n" + 
					"4 - View\r\n" + 
					"5 - Exit");
			// CHECK VALID OPTION
			try {
				beans.setOptionValue(readNum());
				optionCheck(beans.getOptionValue());
			}
			catch(CustomExceptions.InvalidEntry ie){
				System.out.println(ie);
				beans.setOptionValue(0);
				continue;
			}
			// Call the CRUD function
			if(beans.getOptionValue()==1) {
				UserOptions.insertUser();
			}
			else if(beans.getOptionValue()==2) {
				UserOptions.updateUser();
			}
			else if(beans.getOptionValue()==3) {
				UserOptions.deleteUser();
			}
			else if(beans.getOptionValue()==4) {
				UserOptions.displayUsers();
			}
			else if(beans.getOptionValue()==5) {
				scons.close();
				System.exit(0);
			}
			
				

		}
		}
			
	// Check if number
	public static int readNum() {
		try {
			return Integer.parseInt(scons.next());
		}
		catch(NumberFormatException ne) {
			System.out.println(new CustomExceptions.InvalidEntry("No integer detected"));
			return -1;
		}
		
	}
	
	public static void optionCheck(int opt) throws CustomExceptions.InvalidEntry {
			
		 if(opt<1 || opt>5)
			{
				throw new CustomExceptions.InvalidEntry("Invalid Integer, enter b/w 1 to 5");
			}
		 

	}



}
