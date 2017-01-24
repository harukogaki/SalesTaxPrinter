/*
 * In contrast to the other subclasses of TaxDecorator, this class receives the 
 * applicable tax via the constructor therefore any changes on the TaxDecorator's primary
 * subclass GenericTaxDecorator end would not reflect changes on the ItemFactory's end.
 */
public class GenericTaxDecorator implements Item {

	public GenericTaxDecorator(Item item, double applicableTax) {
		this.item = item;
		this.applicableTax = applicableTax;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double totalPrice() {
		// TODO Auto-generated method stub
		double total = computeTaxedPrice(applicableTax);
		return total + item.totalPrice();
	}

	@Override
	public double totalTax() {
		// TODO Auto-generated method stub
		double total = computeTaxedPrice(applicableTax);
		return total + item.totalTax();
	}
	
	public double getPrice() {
		return item.getPrice();
	}

	public String getName() {
		return item.getName();
	}
	
	public int getQuantity() {
		return item.getQuantity();
	}
	
	public double computeTaxedPrice(double tax){
		double d = item.getPrice() * tax; 
		double rounded =  Math.round(d * 20.0) / 20.0;         //Round to nearest 5 cents
		rounded =  (d > rounded) ? rounded + 0.05 : rounded;   //If rounded down round back up to 5 cents
		
		return rounded;
	}

	private Item item;
	private final double applicableTax;
}
