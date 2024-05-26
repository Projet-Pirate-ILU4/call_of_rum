package fr.call_of_rum.model.market;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

import fr.call_of_rum.model.item.Item;
import fr.call_of_rum.util.ItemType;
import util.stub.ItemStub;

public class MarketTest {

	private static final int ITEM1_PRICE = 50;
	private static final ItemType ITEM1_TYPE = ItemType.CLOVER;
	private static final ItemStock ITEM1 = new ItemStock(ItemStub::new, ItemType.CLOVER, ITEM1_PRICE);
	
	private static final int ITEM2_PRICE = 100;
	private static final ItemType ITEM2_TYPE = ItemType.CLOVER;
	private static final ItemStock ITEM2 = new ItemStock(ItemStub::new, ItemType.CLOVER, ITEM2_PRICE);
	
	private Market market;
	
	@Before
	public void setUp() throws Exception {
		market = new Market(ITEM1, ITEM2);
	}

	@Test
	public void itemForSaleTest() {
		assertEquals(2, market.getNumberOfItems());
		assertArrayEquals(new ItemStock[] {ITEM1, ITEM2}, market.getItemsForSale());
	}
	
	@Test
	public void priceTest() {
		assertEquals(ITEM1_PRICE, market.getPrice(0));
		assertEquals(ITEM2_PRICE, market.getPrice(1));
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> market.getPrice(2));
	}
	
	 @Test
	 public void itemTest() {
		 Item item1 = market.getItem(0);
		 assertEquals(ItemStub.class, item1.getClass());
		 assertEquals(ITEM1_TYPE, item1.getType());
		 Item item2 = market.getItem(1);
		 assertEquals(ItemStub.class, item2.getClass());
		 assertEquals(ITEM2_TYPE, item1.getType());
		 assertThrows(ArrayIndexOutOfBoundsException.class, () -> market.getItem(2));
	 }

}
