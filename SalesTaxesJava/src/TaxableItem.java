/* Concrete item class that implements the item interface
 * TaxDecorators wrap around this item and implement the shared
 * methods they possess through the item interface
 */
public class TaxableItem implements Item{

	public TaxableItem(String name, double price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}	
	
	public String getName(){
		return name;
	}
	
	public double getPrice(){
		return quantity*price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	/* Total price after taxes 
	 * Decorator classes override this method 
	 */
	public double totalPrice(){
		double d = quantity*price;
		return d; 			
	}
	
	/* Total sum of sales taxes 
	 * Decorator classes override this method
	 */
	public double totalTax() {
		return 0;				
	}
	
	private String name;
	private double price;
	private int quantity;
	
	
}
