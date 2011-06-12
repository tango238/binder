package tango.dicon.util;



public class ClassUtil {

	private ClassUtil(){}
	
	public static <T> T newInstance(Class<T> clz){
		try {
			return (T)clz.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
