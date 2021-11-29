package com.example.foodies;

public class PreferenceObj {

    private String restName;
    private int price;
    private int distance;
    private boolean asian;
    private boolean cafe;
    private boolean mexicanHispanic;
    private boolean fastFood;
    private boolean pizza;
    private boolean italian;
    private boolean sandwiches;
    private boolean burgers;
    private boolean dessert;
    private boolean chickenWings;
    private boolean american;
    private boolean bar;
    private boolean foreign;
    private boolean seafood;
    private boolean bakery;
    private boolean other;

    public PreferenceObj(String restName, int price, int distance, boolean asian, boolean cafe, boolean mexicanHispanic, boolean fastFood, boolean pizza, boolean italian, boolean sandwiches, boolean burgers, boolean dessert, boolean chickenWings, boolean american, boolean bar, boolean foreign, boolean seafood, boolean bakery, boolean other) {
        this.restName = restName;
        this.price = price;
        this.distance = distance;
        this.asian = asian;
        this.cafe = cafe;
        this.mexicanHispanic = mexicanHispanic;
        this.fastFood = fastFood;
        this.pizza = pizza;
        this.italian = italian;
        this.sandwiches = sandwiches;
        this.burgers = burgers;
        this.dessert = dessert;
        this.chickenWings = chickenWings;
        this.american = american;
        this.bar = bar;
        this.foreign = foreign;
        this.seafood = seafood;
        this.bakery = bakery;
        this.other = other;
    }

    public PreferenceObj() {
        this.restName = "";
        this.price = 1;
        this.distance = 0;
        this.asian = false;
        this.cafe = false;
        this.mexicanHispanic = false;
        this.fastFood = false;
        this.pizza = false;
        this.italian = false;
        this.sandwiches = false;
        this.burgers = false;
        this.dessert = false;
        this.chickenWings = false;
        this.american = false;
        this.bar = false;
        this.foreign = false;
        this.seafood = false;
        this.bakery = false;
        this.other = false;
    }

    public void setReset() {
        this.restName = "";
        this.price = 1;
        this.distance = 0;
        this.asian = false;
        this.cafe = false;
        this.mexicanHispanic = false;
        this.fastFood = false;
        this.pizza = false;
        this.italian = false;
        this.sandwiches = false;
        this.burgers = false;
        this.dessert = false;
        this.chickenWings = false;
        this.american = false;
        this.bar = false;
        this.foreign = false;
        this.seafood = false;
        this.bakery = false;
        this.other = false;
    }
    public String getRestName() {
        return restName;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isAsian() {
        return asian;
    }

    public void setAsian(boolean asian) {
        this.asian = asian;
    }

    public boolean isCafe() {
        return cafe;
    }

    public void setCafe(boolean cafe) {
        this.cafe = cafe;
    }

    public boolean isMexicanHispanic() {
        return mexicanHispanic;
    }

    public void setMexicanHispanic(boolean mexicanHispanic) {
        this.mexicanHispanic = mexicanHispanic;
    }

    public boolean isFastFood() {
        return fastFood;
    }

    public void setFastFood(boolean fastFood) {
        this.fastFood = fastFood;
    }

    public boolean isPizza() {
        return pizza;
    }

    public void setPizza(boolean pizza) {
        this.pizza = pizza;
    }

    public boolean isItalian() {
        return italian;
    }

    public void setItalian(boolean italian) {
        this.italian = italian;
    }

    public boolean isSandwiches() {
        return sandwiches;
    }

    public void setSandwiches(boolean sandwiches) {
        this.sandwiches = sandwiches;
    }

    public boolean isBurgers() {
        return burgers;
    }

    public void setBurgers(boolean burgers) {
        this.burgers = burgers;
    }

    public boolean isDessert() {
        return dessert;
    }

    public void setDessert(boolean dessert) {
        this.dessert = dessert;
    }

    public boolean isChickenWings() {
        return chickenWings;
    }

    public void setChickenWings(boolean chickenWings) {
        this.chickenWings = chickenWings;
    }

    public boolean isAmerican() {
        return american;
    }

    public void setAmerican(boolean american) {
        this.american = american;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isForeign() {
        return foreign;
    }

    public void setForeign(boolean foreign) {
        this.foreign = foreign;
    }

    public boolean isSeafood() {
        return seafood;
    }

    public void setSeafood(boolean seafood) {
        this.seafood = seafood;
    }

    public boolean isBakery() {
        return bakery;
    }

    public void setBakery(boolean bakery) {
        this.bakery = bakery;
    }

    public boolean isOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }
}
