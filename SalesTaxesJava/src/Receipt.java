import java.util.ArrayList;
import java.util.List;

public class Receipt {

	private List<Item> basket;
	private String basketOut;
	
	Receipt(List<Item> basket){
		this.basket = basket;

	}
	
	public String output() {
		basketOut += "";
		for (Item i: basket){
		}
		return basketOut;
	}
//shopping basket
//total tax
//total
	

}