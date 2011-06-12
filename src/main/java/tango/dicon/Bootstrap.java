package tango.dicon;


public final class Bootstrap {

	private static Injector injector;
	
	public static void init(Injector obj){
		injector = obj;
		injector.init();
	}
	
	public static Injector getInjector(){
		return injector;
	}
	
	public static void destroy(){
		injector.destroy();
	}
}
