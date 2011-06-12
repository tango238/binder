package tango.binder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tango.binder.scope.Scope;
import tango.binder.scope.ScopeType;

public class Binder {

	private boolean initialized = false;
	
	private List<ComponentDef> componentDefs = new ArrayList<ComponentDef>();

	private Map<String, String> packageScopes = new HashMap<String, String>();
	
	private ComponentManager componentManager;
	
	/**
	 * Sets the scope rule to each package name.
	 * 
	 * @param scopeType
	 */
	public Binder setPackageScope(String packageName, String scopeType){
		packageScopes.put(packageName, scopeType);
		return this;
	}
	
	public <T> Binder bind(String name, Class<T> clazz) {
		return bind(name, clazz, ScopeType.SINGLETON);
	}
	
	public <T> Binder bind(String name, Class<T> clazz, String scope){
		ComponentDef<T> componentDef = new ComponentDef<T>(name, clazz, scope);
		componentDefs.add(componentDef);
		return this;
	}

	protected void init() {
		componentManager = new ComponentManager();
		
		List<Scope> scopes = new ArrayList<Scope>();
		scopes.add(componentManager.init(ScopeType.SINGLETON));
		scopes.add(componentManager.init(ScopeType.PROTOTYPE));
		
		for(ComponentDef componentDef : componentDefs){
			registerComponent(componentDef, scopes);
		}
		
		initialized = true;
	}

	@SuppressWarnings("unchecked")
	private void registerComponent(ComponentDef componentDef, List<Scope> scopes) {
		for(Scope scope : scopes){
			if(componentDef.scopeType.equals(scope.getScopeType())){
				scope.registerComponent(componentDef.name, componentDef.component);
			}
		}
	}

	public void destroy() {
		componentDefs.clear();
		componentManager.destroy();
	}

	public Object getComponent(String name) {
		if(initialized == false){
			init();
		}
		for(ComponentDef componentDef : componentDefs){
			if(name.equals(componentDef.name)){
				return componentManager.getComponent(name, componentDef.scopeType);
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T getComponent(String name, Class<T> clz) {
		return (T) getComponent(name);
	}

}
