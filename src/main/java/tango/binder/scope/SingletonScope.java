package tango.binder.scope;

import java.util.HashMap;
import java.util.Map;

import tango.binder.util.ClassUtil;


public class SingletonScope implements Scope {

	private Map<String, Object> components = new HashMap<String, Object>();
	
	@Override
	public String getScopeType() {
		return ScopeType.SINGLETON;
	}

	@Override
	public Object getComponent(String name) {
		return components.get(name);
	}

	@Override
	public <T> void registerComponent(String name, Class<T> clazz) {
		components.put(name, ClassUtil.newInstance(clazz));
	}

}
