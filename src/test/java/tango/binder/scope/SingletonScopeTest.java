package tango.binder.scope;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tango.binder.Binder;
import tango.binder.Bootstrap;
import tango.binder.component.Component1;


public class SingletonScopeTest {

	@Test
	public void test_SingletonScope() throws Exception {
		Binder b = new Binder();
		b.bind("component1", Component1.class, ScopeType.SINGLETON)
		 .bind("component1_2", Component1.class, ScopeType.SINGLETON);
		Bootstrap.init(b);
		Binder binder = Bootstrap.getBinder();
		Component1 c1 = (Component1) binder.getComponent("component1");
		Component1 c2 = (Component1) binder.getComponent("component1");
		Component1 c3 = (Component1) binder.getComponent("component1_2");
		assertThat(c1, is(c2));
		assertFalse(c1 == c3);
	}
}
