public class Printer{

	private Receipt receipt;

	public Printer(Receipt receipt) {
		this.receipt = receipt;
	}

	public void print() {
		System.out.println(this.receipt.output());
		
	}


}

