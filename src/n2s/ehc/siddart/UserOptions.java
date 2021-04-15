package n2s.ehc.siddart;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


//
public class UserOptions {
	public static Hashtable<Integer,String> ht = new Hashtable<Integer,String>();
	
	public static void insertUser() {
		
		System.out.println("******** Insert Users ********");
		
		try
		{ 
		  System.out.println("Insert ID now");
		  
		  UserMain.beans.setUserId(UserMain.readNum());
		  userIdCheck(UserMain.beans.getUserId());	
		  
		  System.out.println("Enter Name now: \n");
		  
		  UserMain.beans.setUserName(UserMain.scons.next());
		  ht.put(UserMain.beans.getUserId(), UserMain.beans.getUserName());
		  
		  System.out.println("Insert Success");

		}
		catch(CustomExceptions.InvalidUserId iu){
			System.out.println(iu);
		}
		System.out.println("Do you wish to Insert more");
		if(UserMain.scons.next().equalsIgnoreCase("y")) {
			insertUser();
		}


	}
	
	public static void updateUser() {
		System.out.println("******** Update Users ********");
		try {
			  System.out.println("Insert ID now");
			  
			  UserMain.beans.setUserId(UserMain.readNum());
			  notFound(UserMain.beans.getUserId());
			  
			  System.out.println("Enter Name now: \n");
			  UserMain.beans.setUserName(UserMain.scons.next());
			  
			  ht.put(UserMain.beans.getUserId(), UserMain.beans.getUserName());
			  System.out.println("Update Success");
		}
		catch(CustomExceptions.UserIdNotFound nf) {
			
			System.out.println(nf);
			
		}
		System.out.println("Do you wish to Update more");
		
		if(UserMain.scons.next().equalsIgnoreCase("y")) 
		{
			
		updateUser();
		
		}
		
		
	}
	public static void deleteUser() {
		System.out.println("******** Update Users ********");
		try {
			  System.out.println("Insert ID now");
			  
			  UserMain.beans.setUserId(UserMain.readNum());
			  notFound(UserMain.beans.getUserId());		  
			 
			  ht.remove(UserMain.beans.getUserId());
			  System.out.println("Delete Success");
		}
		catch(CustomExceptions.UserIdNotFound nf) {
			System.out.println(nf);
		}
		System.out.println("Do you wish to delete more");
		if(UserMain.scons.next().equalsIgnoreCase("y")) {
		deleteUser();
		}
	}
	
	public static void displayUsers() {
		TreeMap<Integer, String> tmap = new TreeMap<Integer, String>( ht );
		int count = 1;
		System.out.println("\n_________________________");
		System.out.println("S.No\tID\tName \n");
		for(Map.Entry<Integer, String> itr : tmap.entrySet()) {
			System.out.println(count+" \t"+ itr.getKey()+" \t" + itr.getValue());
			count++;
		}
		System.out.println("\n");

	}
	
	
	public static void userIdCheck(int id) throws CustomExceptions.InvalidUserId {
		if (id<1 || id>Integer.MAX_VALUE || ht.containsKey( id)) {
			//throw  IO.new InvalidUserId("Invalid User ID");
			throw new CustomExceptions.InvalidUserId("Invalid User ID or ID already exists");
		}
		
	}
	public static void notFound(int id) throws CustomExceptions.UserIdNotFound {
		if ( ht.containsKey( id)==false) {
			//throw  IO.new InvalidUserId("Invalid User ID");
			throw new CustomExceptions.UserIdNotFound("ID not found, try another");
		}
		
	}


}
