package tango.dicon;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tango.dicon.component.Component1;


public class InjectorTest {

	@Test
	public void test_register() throws Exception {
		Injector register = new Injector();
		register.register("component1", Component1.class);
		register.register("component1_2", Component1.class);
		Bootstrap.init(register);
		Injector injector = Bootstrap.getInjector();
		Component1 component1 = (Component1) injector.getComponent("component1");
		Component1 component1_2 = (Component1) injector.getComponent("component1_2");
		assertTrue(component1.equals(component1_2) == false);
	}
	
	@Test
	public void test_register2() throws Exception {
		Injector register = new Injector();
		register.register("component1", Component1.class);
		register.register("component1_2", Component1.class);
		Bootstrap.init(register);
		Injector injector = Bootstrap.getInjector();
		Component1 component1 = injector.getComponent("component1", Component1.class);
		Component1 component1_2 = injector.getComponent("component1_2", Component1.class);
		assertTrue(component1.equals(component1_2) == false);
	}
}
