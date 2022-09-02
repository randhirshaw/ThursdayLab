

public class FoodMenu {
	private int foodId;
	private String foodName;
	private double foodPrice;
	
	public int getFoodId() {
		return foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public FoodMenu(int foodId, String foodName, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
	public void display()
	{
		System.out.println(" "+getFoodName()+"\t"+getFoodPrice());
	}
}

