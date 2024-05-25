package fr.call_of_rum.model.item;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.item.liquid.Liquid;
import fr.call_of_rum.model.pirate.Pirate;
import fr.call_of_rum.util.Player;
import util.stub.LiquidStub;

public class LiquidTest {
	
	private Pirate pirate;
	private Liquid liquid;

	@Before
	public void setUp() throws Exception {
		pirate = new Pirate(Player.BILL_JAMBE_DE_BOIS, 0, 6);
		liquid = new LiquidStub(2, 0.2f);
		pirate.setHealthPoints(3);
	}

	@Test
	public void useTest() {
		pirate.give(liquid);
		liquid.use();
		assertEquals(5, pirate.getHealthPoints());
		assertEquals(0.2f, pirate.getIntoxicationGauge().getLevel(), 0.001f);
	}

}
