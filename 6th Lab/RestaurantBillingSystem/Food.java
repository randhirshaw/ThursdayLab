package RestaurantBillingSystem;

class Food {
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
	public Food(int foodId, String foodName, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
	}
}