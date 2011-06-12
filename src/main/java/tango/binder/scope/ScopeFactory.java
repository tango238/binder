package tango.binder.scope;

import tango.binder.util.ClassUtil;


public abstract class ScopeFactory {

	abstract void init();
	
	abstract void destroy();
	
	abstract Object getComponent(String name);
	
	abstract <T> T getComponent(String name, Class<T> clazz);

	public static Scope getInstance(String scopeType) {
		return (Scope) ClassUtil.newInstanceByName(scopeType);
	}
	
}
