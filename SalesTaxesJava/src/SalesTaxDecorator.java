
public class SalesTaxDecorator extends TaxDecorator {
	public SalesTaxDecorator(Item item) {
		super(item);
		this.item = item;
	}

	public double totalPrice() {
		double d = super.computeTaxedPrice(applicableTax);
		return (d + item.totalPrice());
	}

	public double totalTax() {
		double d = super.computeTaxedPrice(applicableTax);
		return (d + item.totalTax());
	}
	
	final private double applicableTax = 0.10;
	private Item item;
}
