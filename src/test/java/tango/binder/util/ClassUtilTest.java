package tango.binder.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import tango.binder.scope.ScopeType;
import tango.binder.scope.SingletonScope;

public class ClassUtilTest {

	@Test
	public void test_newInstanceByName() throws Exception {
		SingletonScope singletonScope = (SingletonScope) ClassUtil.newInstanceByName(ScopeType.SINGLETON);
		assertThat(singletonScope, is(notNullValue()));
	}
}
