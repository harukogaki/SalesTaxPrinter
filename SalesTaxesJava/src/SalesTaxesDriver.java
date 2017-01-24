import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class SalesTaxesDriver {
	
	static String INPUTFILE= "C:\\Users\\harukogaki\\Desktop\\Input3.txt";
	/*
	 * Loads basket of items from a path file.
	 * The path is a text file "formatted" to
	 * be parsed. 
	 */
	public static int loadItems(String path, List<Item> items){	
		
		try {
			//If there is no file specified to begin with 
			if (path == null)
				throw new IOException();
			
			// read from text file
			List<String> itemStrs = Files.readAllLines(Paths.get(path));
			StringTokenizer token;
			
			//Parse text file
			String name;
			double price;
			int quantity, salesTax, importTax;
			
			for (String str : itemStrs){
				
				//Parse item tokens from line
				token     =  new StringTokenizer(str,",");
				name      =  token.nextToken(",");
				price     =  Double.parseDouble(token.nextToken(" ,"));
				quantity  =  Integer.parseInt(token.nextToken(" ,"));
				salesTax  =  Integer.parseInt(token.nextToken(" ,"));
				importTax =  Integer.parseInt(token.nextToken(" ,"));
				
				//instantiate and insert object into basket
				items.add(ItemFactory.makeItem(name, price, quantity, salesTax, importTax));
			}
		} catch (IOException e) {
			
			System.out.println("Couldn't read file specified by path or path not specified\n");
			return 0;
		}
		catch (NumberFormatException n){
			System.out.println("Please make sure integers are indeed integers\n");
			return 0;
		}
		catch (NoSuchElementException i){
			System.out.println("Please make sure at least 5 tokens are supplied per line\n");
			return 0;
		}
		
		return 1;
	}
	
	/* 
	 * Prints and formats the receipt given a Basket of items
	 */
	public static void printReceipt(List<Item> items){
		double totalPrice = 0.0;
		double totalTax = 0.0;
		
		for (Item i : items){
			double currPrice = i.totalPrice(); //Calculate taxedPrice
			
			System.out.format("%d %s: %.2f\n", i.getQuantity(), i.getName(), currPrice); 
			
			totalPrice += currPrice;     //add to the Total
			totalTax += i.totalTax();    //Calculate total tax for item and add to its total
		}
		
		System.out.format("Sales Taxes: %.2f\nTotal: %.2f", totalTax, totalPrice);
	}
	
	public static void main(String[]args){
		List<Item> items = new ArrayList<>();
		
		//If path is passed in as a command line argument
		if (args.length != 0)
			INPUTFILE = args[0];
		
		//Make sure to print receipt if basket is properly loaded
		if (loadItems(INPUTFILE,items) == 1){
			printReceipt(items);
			//new Printer(new Receipt(items)).print();
		}
	}
}
