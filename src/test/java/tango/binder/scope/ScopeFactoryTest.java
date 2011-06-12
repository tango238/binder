package tango.binder.scope;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class ScopeFactoryTest {

	@Test
	public void test_getInstance() throws Exception {
		Scope single = (Scope) ScopeFactory.getInstance(ScopeType.SINGLETON);
		assertThat(single, is(notNullValue()));
	}
	
	
	@Test(expected = NullPointerException.class)
	public void test_getInstance2() throws Exception {
		Scope notRegistered = (Scope) ScopeFactory.getInstance("not.registered.scope");
		assertThat(notRegistered, is(nullValue()));
	}
}
