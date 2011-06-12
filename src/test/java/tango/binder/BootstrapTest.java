package tango.binder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tango.binder.Binder;
import tango.binder.Bootstrap;

public class BootstrapTest {

	@Test
	public void test_init() throws Exception {
		Binder binder = new Binder();
		Bootstrap.init(binder);
		assertThat(Bootstrap.getBinder(), is(notNullValue()));
		Bootstrap.destroy();
	}
}
