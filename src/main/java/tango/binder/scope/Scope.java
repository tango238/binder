package tango.binder.scope;


public interface Scope {
	
	String getScopeType();
	
	Object getComponent(String name);

	<T> void registerComponent(String name, Class<T> clazz);
	
}
