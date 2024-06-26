package vn.edu.likelion.Entities;

import vn.edu.likelion.Abstracts.AStaff;

public class Manager extends AStaff {
    private double bonus;

    public Manager(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double computeTotalSalary() {
        return getBaseSalary() + bonus;
    }

    @Override
    public void showInfo() {
        System.out.println("Manager name: " + getName());
        System.out.println("Base salary: " + getBaseSalary());
        System.out.println("Bonus: " + bonus);
        System.out.println("Total salary: " + computeTotalSalary());
    }
}
