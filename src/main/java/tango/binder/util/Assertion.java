package tango.binder.util;

public class Assertion {

	private Assertion(){
	}
	
	public static void isNotNull(Object target){
		if(target == null){
			throw new NullPointerException();
		}
	}
}
