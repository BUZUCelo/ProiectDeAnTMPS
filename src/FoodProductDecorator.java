abstract class FoodProductDecorator implements FoodProduct {
    protected FoodProduct decoratedFoodProduct;

    public FoodProductDecorator(FoodProduct decoratedFoodProduct) {
        this.decoratedFoodProduct = decoratedFoodProduct;
    }

    public double getPrice() {
        return decoratedFoodProduct.getPrice();
    }

    public String getDescription() {
        return decoratedFoodProduct.getDescription();
    }
}