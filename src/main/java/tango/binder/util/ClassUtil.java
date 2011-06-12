package tango.binder.util;



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
	
	@SuppressWarnings("unchecked")
	public static <T> Class<T> forName(String name){
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		try {
			return (Class<T>) Class.forName(name, true, loader);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return null;
	}

	public static <T> T newInstanceByName(String name) {
		Class<T> clazz = forName(name);
		try {
			return (T) clazz.newInstance();
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
