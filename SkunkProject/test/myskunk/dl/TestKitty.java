package myskunk.dl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestKitty {

	@Test
	void test_kitty() {
		Kitty.add_kitty(5);
		assertEquals(5,Kitty.get_kitty());
	}

}
