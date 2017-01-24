/*
 * Abstract super class to all TaxDecorator subclasses
 * Contains all shared functionality amongst subclasses
 * (i.e. methods returning item information)
 */
public abstract class TaxDecorator implements Item{
	
	public TaxDecorator(Item item){
		this.item = item;
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
	
	/* Helper method for subclasses. 
	   Subclasses pass in their applicable tax and 
	   a well rounded taxed price is returned to them
	 */
	public double computeTaxedPrice(double tax){
		double d = item.getPrice() * tax; 
		double rounded =  Math.round(d * 20.0) / 20.0;   //Round to nearest 5 cents
		d =  (d > rounded) ? rounded + 0.05 : rounded;   //If rounded down round back up to 5 cents
		
		return d;
	}
	
	private Item item;
}
