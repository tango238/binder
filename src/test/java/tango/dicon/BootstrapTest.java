package tango.dicon;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class BootstrapTest {

	@Test
	public void test_init() throws Exception {
		Injector injector = new Injector();
		Bootstrap.init(injector);
		assertThat(Bootstrap.getInjector(), is(notNullValue()));
		Bootstrap.destroy();
	}
}
