import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class ReceiptTest {

	@Test
	public void testPrintReceipt() {
		String expectedResult = "1 book: 12.49 \n Sales Taxes: 1.50 \n Total: 29.83";
		Item item1 = ItemFactory.makeItem("book", 12.49, 1, 0, 0);
		List<Item> shoppingBasket = new ArrayList<Item>();
		shoppingBasket.add(item1);
		Receipt receipt = new Receipt(shoppingBasket);
		
		
		String actualResult = receipt.output(); 
		assertEquals(actualResult, expectedResult);
	}

}
