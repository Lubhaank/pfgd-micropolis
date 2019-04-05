package micropolisj.engine;

public class LeasedLandEntity {
	
	
	int id;
	
	int amountLeft;
	
	int x;
	
	int y;
	
	boolean bulldozable;
	
	public LeasedLandEntity(int id, int amount,Micropolis engine, int x, int y) {
		
		
		this.id = id;
		
		this.bulldozable = false;
		
		this.amountLeft = amount;
		
		this.x = x;
		
		this.y = y;
		
		
		
		engine.idToLLEntity.put(id, this);
		
		engine.budget.totalFunds += amount;
		
		engine.LeaseID += 1;
		
		for(int c = y - 1; c < y + 7; c++) {
			
			for(int r = x-1; r < x + 7; r++) {
				
				engine.leaseIDArr[c][r] = this.id;
			}
			
			
		}
				
	}
	
	public boolean pay(Micropolis engine, int pay) {
		
		
		if(pay > engine.budget.totalFunds || pay > this.amountLeft) {
			
			return false;
		}
		this.amountLeft -= pay;
		
		engine.budget.totalFunds -= pay;
		
		if( amountLeft == 0) {
			
			this.bulldozable = true;
		}
		
		return true;
		
	}
	
	public boolean canBulldoze() {
		
		return this.bulldozable;
	}

	@Override
	public String toString() {
		
		return "Id: " + this.id + " Amount :" + this.amountLeft + " x " + x + " y " + y; 
		
		
	}
}
