
/*
 *  Sales Tax Application
 *  Author: Salvador Ariza
 *  
 *  ===========================
 *  Input and Basic operations
 *  ===========================
 *  
 *  This application receives as input string. This string denotes a pathname to a "properly" formatted text file containing 
 *  a basket items. "Properly" is defined as such:
 *  
 *  - Each new line denotes a new Item
 *  - Each Item = (item name),(item price), (item quantity), (salesTaxable: 1 or 0), (importTaxable: 1 or 0)
 *  - Make sure each token is separated by a ","
 *  
 *   (i.e. Input1.txt) 
 *   book, 12.49 , 1 , 0 , 0 
 *   music CD, 14.99 , 1 , 1 , 0
 *   chocolate bar, 0.85 , 1 , 0 , 0
 *  
 *   Please supply the pathname to your proper text files and assign it to the global variable "inputFile" below 
 *   or just pass it in as a command line argument. Afterwards just compile and run and you should be good to go. :)
 *  
 *  ====================================
 *  Design Patterns and Implementations
 *  ====================================
 *  
 *  The first thing that came into mind when creating this application was the Decorator(Wrapper)
 *  design pattern. By defining an item interface that is both implemented by a TaxDecorator and A TaxableItem,
 *  It becomes a bit more simplistic executing functions such as totalPrice and totalTax since both of them 
 *  can be instantiated to the same interface and execute the same functions.
 *  
 *   Along the way i also thought about implementing the Factory design pattern when creating particular items.
 *   Since there are multiple (in this case 4) types of items that can be created 
 *   - non-taxed
 *   - sales-taxed
 *   - import-taxed
 *   - both
 *   Thats why i decided to delegate the instantiation to an ItemFactory class that follows, as the name suggests,
 *   the factory design pattern.
 *   
 *   All items implement 5 basic operations:
 *   getName()		 //returns the name of the item 
 *   getQuantity()   //returns the quantity bought
 *   getPrice()      //returns the price of the item
 *   totalPrice()    //Price including additional taxes 
 *   totalTax()      //Additional taxes alone 
 *   
 *   Every Decorator Class (SalesTax, importTax) override the totalTax() and totalPrice()
 *   methods to return the well rounded tax on the item and call the remaining wrapped decorators
 *   to add on to it.
 *   
 *   All shared functionality of Tax Decorators (name, price, quantity) is moved to the super class (TaxDecorator) 
 *   and shared amongst subclasses to avoid code duplication. The super class also offers a method to calculate the
 *   taxed price given an applicableTax as a parameter. Again, this is to avoid code duplication. The totalTax() and totalPrice()
 *   methods share the same functionality but at the last function call (in TaxableItem) the final return statement changes the outcome
 *   of the return: totalTax() returns 0 so ultimately the sales tax is returned and the totalPrice() returns the original price to be 
 *   added on to the tax.
 *   
 */