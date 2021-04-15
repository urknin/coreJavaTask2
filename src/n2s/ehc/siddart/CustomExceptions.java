package n2s.ehc.siddart;

public class CustomExceptions {
	public static class InvalidEntry extends Exception {
		InvalidEntry(String s){
			super(s);
		}
	}
	public static  class InvalidUserId extends Exception {
		InvalidUserId(String s){
			super(s);
		}
	}
	public static  class UserIdNotFound extends Exception {
		UserIdNotFound(String s){
			super(s);
		}
	}

}
