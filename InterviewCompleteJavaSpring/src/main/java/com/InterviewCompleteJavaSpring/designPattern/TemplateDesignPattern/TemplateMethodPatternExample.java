package com.InterviewCompleteJavaSpring.designPattern.TemplateDesignPattern;

// Abstract class representing a template for preparing a hot beverage
abstract class HotBeverageTemplate {
    // Template method defining the algorithm
    final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Abstract methods to be implemented by subclasses
    abstract void brew();

    abstract void addCondiments();

    // Common methods used by subclasses
    void boilWater() {
        System.out.println("Boiling water");
    }

    void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

// Concrete class representing a specific hot beverage (Coffee)
class Coffee extends HotBeverageTemplate {
    void brew() {
        System.out.println("Brewing coffee grounds");
    }

    void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

// Concrete class representing another hot beverage (Tea)
class Tea extends HotBeverageTemplate {
    void brew() {
        System.out.println("Steeping the tea");
    }

    void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Example usage
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        System.out.println("Preparing Coffee:");
        HotBeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();

        System.out.println("\nPreparing Tea:");
        HotBeverageTemplate tea = new Tea();
        tea.prepareBeverage();
    }
}
