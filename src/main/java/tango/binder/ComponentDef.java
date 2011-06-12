package tango.binder;

public class ComponentDef<T> {

	public String scopeType;
	
	public String name;

	public Class<T> component;
	
	public ComponentDef(String name, Class<T> component, String scopeType){
		this.name = name;
		this.component = component;
		this.scopeType = scopeType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((component == null) ? 0 : component.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((scopeType == null) ? 0 : scopeType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentDef other = (ComponentDef) obj;
		if (component == null) {
			if (other.component != null)
				return false;
		} else if (!component.equals(other.component))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (scopeType == null) {
			if (other.scopeType != null)
				return false;
		} else if (!scopeType.equals(other.scopeType))
			return false;
		return true;
	}
}
