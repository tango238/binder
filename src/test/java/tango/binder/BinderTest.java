package tango.binder;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tango.binder.component.Component1;
import tango.binder.component.Component2;

public class BinderTest {

	@Test
	public void test_register() throws Exception {
		Binder binder1 = new Binder();
		binder1.bind("component1", Component1.class);
		binder1.bind("component1_2", Component1.class);
		
		Bootstrap.init(binder1);
		
		Binder binder2 = Bootstrap.getBinder();
		Component1 component1 = (Component1) binder2.getComponent("component1");
		Component1 component1_2 = (Component1) binder2.getComponent("component1_2");
		
		assertTrue(component1.equals(component1_2) == false);
	}

	@Test
	public void test_register2() throws Exception {
		Binder binder = new Binder();
		binder.bind("component1", Component1.class);
		binder.bind("component1_2", Component1.class);
		Bootstrap.init(binder);
		Binder injector = Bootstrap.getBinder();
		Component1 component1 = injector.getComponent("component1",
				Component1.class);
		Component1 component1_2 = injector.getComponent("component1_2",
				Component1.class);
		assertTrue(component1.equals(component1_2) == false);
	}

	@Test
	public void test_bind() throws Exception {
		Binder binder = new Binder();
		binder.bind("component1", Component1.class).bind("component2",
				Component2.class);
		Bootstrap.init(binder);
		Bootstrap.destroy();
	}

	/*
	@Test
	public void test_setPackageScope() throws Exception {
		Binder binder = new Binder();
		binder
			.setPackageScope("tango.binder.component", ScopeType.SINGLETON)
			.bind("component1", Component1.class)
			.bind("component2", Component2.class);
	}
	*/
}
