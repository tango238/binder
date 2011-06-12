package tango.binder;

import java.util.concurrent.atomic.AtomicBoolean;

import tango.binder.util.Assertion;


public final class Bootstrap {

	private static AtomicBoolean initialized = new AtomicBoolean(false);
	
	private static Binder binder;
	
	public static void init(Binder b){
		if(initialized.get() == false){
			Assertion.isNotNull(b);
			binder = b;
			binder.init();
			initialized.set(true);
		}
	}
	
	public static Binder getBinder(){
		if(initialized.get() == false){
			init(binder);
		}
		return binder;
	}
	
	public static void destroy(){
		binder.destroy();
		initialized.set(false);
	}
}
