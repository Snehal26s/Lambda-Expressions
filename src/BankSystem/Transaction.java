package BankSystem;

public class Transaction {
	    int id;
	    String type; 
	    double amount;
		public Transaction(int id, String type, double amount) {
			super();
			this.id = id;
			this.type = type;
			this.amount = amount;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "Transcation [id=" + id + ", type=" + type + ", amount=" + amount + "]";
		}
	    
	    
}
