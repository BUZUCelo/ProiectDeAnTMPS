class ExtraCheeseDecorator extends FoodProductDecorator {
    public ExtraCheeseDecorator(FoodProduct decoratedFoodProduct) {
        super(decoratedFoodProduct);
    }

    public double getPrice() {
        return super.getPrice() + 1.0;
    }

    public String getDescription() {
        return super.getDescription() + " with Extra Cheese";
    }
}
