package com.example.Unicorn.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class UnicornStoreApplicationTests {

	@Test
	public void addUnicornsToRepo() {
		UnicornRepo unicornRepo = new UnicornRepo();

		unicornRepo.addUnicorn(new Unicorn(100004L, "Twinkle", 183, Colors.BLACK, true, false, 149999.99));
		Assertions.assertEquals(5, unicornRepo.unicornsInStore());

		unicornRepo.addUnicorn(new Unicorn(100005L, "Hornless", 106, Colors.WHITE, false, true, 12999.99));
		Assertions.assertEquals(6, unicornRepo.unicornsInStore());

		unicornRepo.addUnicorn(new Unicorn(100006L, "Butterscotch", 75, Colors.WHITE, true, true, 138999.99));
		Assertions.assertEquals(7, unicornRepo.unicornsInStore());
	}
}