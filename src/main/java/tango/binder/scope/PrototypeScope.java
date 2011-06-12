package tango.binder.scope;

import java.util.HashMap;
import java.util.Map;

import tango.binder.util.ClassUtil;


public class PrototypeScope implements Scope {

private Map<String, Class> components = new HashMap<String, Class>();
	
	@Override
	public String getScopeType() {
		return ScopeType.PROTOTYPE;
	}

	@Override
	public Object getComponent(String name) {
		return ClassUtil.newInstance(components.get(name));
	}

	@Override
	public <T> void registerComponent(String name, Class<T> clazz) {
		components.put(name, clazz);
	}
}
