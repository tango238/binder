package tango.binder.scope;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import tango.binder.Binder;
import tango.binder.Bootstrap;
import tango.binder.component.Component1;

public class PrototypeScopeTest {

	@Test
	public void test_PrototypeScope() throws Exception {
		Binder b = new Binder();
		b.bind("component1", Component1.class, ScopeType.PROTOTYPE);
		Bootstrap.init(b);
		Binder binder = Bootstrap.getBinder();
		Component1 c1 = (Component1) binder.getComponent("component1");
		Component1 c2 = (Component1) binder.getComponent("component1");
		assertFalse(c1 == c2);
	}
}
