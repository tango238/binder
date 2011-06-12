package tango.binder;

import java.util.HashMap;
import java.util.Map;

import tango.binder.scope.Scope;
import tango.binder.scope.ScopeFactory;

public class ComponentManager {

	private Map<String, Scope> map = new HashMap<String, Scope>();

	public Scope init(String scopeType) {
		Scope scope = ScopeFactory.getInstance(scopeType);
		map.put(scopeType, scope);
		return scope;
	}
	
	public Scope getScope(String scopeType){
		return map.get(scopeType);
	}

	public Object getComponent(String name, String scopeType) {
		Scope scope = map.get(scopeType);
		return scope.getComponent(name);
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
