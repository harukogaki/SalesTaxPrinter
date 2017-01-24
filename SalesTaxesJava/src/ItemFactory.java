
public class ItemFactory {
	/*
	 * Returns an Item given the specifications
	 * @name       Product Name
	 * @price      Product Price
	 * @quantity   Quantity of Product
	 * @SalesTax   Is it Sales Taxable? 
	 * @ImportTax  Is it Import Taxable?
	 */
	public static Item makeItem(String name, double price, int quantity, int SalesTax, int ImportTax){
		Item i = new TaxableItem(name, price, quantity);

		/* Wraps a TaxDecorator depending on the passed in parameters */
		if (SalesTax == 1){
			//i = new SalesTaxDecorator(i);
			i = new GenericTaxDecorator(i, .10);
		}
		
		if (ImportTax == 1){
			//i = new ImportTaxDecorator(i);
			i = new GenericTaxDecorator(i, .05);
		}
	
		return i;
	}
	
	private ItemFactory(){}
}
