package gingi.junit4.server;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HamcrestTest {
	private List<String> values;
	
	public void setUpList() {
		values = new ArrayList<String>();
		values.add("x");
		values.add("y");
		values.add("z");
	}
	
	@Test
	public void testWithHamcrest(){
		assertThat(values, hasItem(anyOf(equalTo("one"), equalTo("two"), equalTo("three") )));
	}
}
