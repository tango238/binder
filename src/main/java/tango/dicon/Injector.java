package tango.dicon;

import java.util.HashMap;
import java.util.Map;

import tango.dicon.util.ClassUtil;

public class Injector {

	private static Map<String, Object> components = new HashMap<String, Object>();

	public <T> void register(String name, Class<T> clz) {
		components.put(name, ClassUtil.newInstance(clz));
	}

	protected void init() {
	}

	public void destroy() {
		components.clear();
	}

	public Object getComponent(String name) {
		return components.get(name);
	}

	@SuppressWarnings("unchecked")
	public <T> T getComponent(String name, Class<T> clz) {
		return (T) getComponent(name);
	}

}
