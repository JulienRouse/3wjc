package exercices.junit;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class JunitTestMatcher {

	//core
	@Test
	public void testMatcherAnything() {
		assertThat("hello world", anything("always match"));
		assertThat(42, anything("always match"));
	}

	@Test
	public void testMatcherIs(){
		//is(42)==is(equalTo(42))
		assertThat(42, is(42));
		assertThat("hello", is("hello"));
	}

	//logical
	@Test
	public void testMatcherAllOf(){
		//court circuit comme &&
		 assertThat("abc", allOf(containsString("a"), (containsString("b"))));
	}
	
	@Test 
	public void testMatcherAnyOf(){
		//court circuit comme ||
		assertThat("abc", anyOf(containsString("z"), containsString("a")));
	}
	
	@Test
	public void testMatcherNot(){
		assertThat(42, not(is(0)));
	}
}
