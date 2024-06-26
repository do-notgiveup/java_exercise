package vn.edu.likelion.Entities;

import vn.edu.likelion.Abstracts.AStaff;

public class Programmer extends AStaff {
    private double overTime;
    private double hourlyRate;

    public Programmer(int id, String name, double baseSalary, double overTime, double hourlyRate) {
        super(id, name, baseSalary);
        this.overTime = overTime;
        this.hourlyRate = hourlyRate;
    }

    public double getOverTime() {
        return overTime;
    }

    public void setOverTime(double overTime) {
        this.overTime = overTime;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double computeTotalSalary() {
        return getBaseSalary() + overTime * hourlyRate;
    }

    @Override
    public void showInfo() {
        System.out.println("Programmer name: " + getName());
        System.out.println("Base salary: " + getBaseSalary());
        System.out.println("Overtime Hours: " + overTime);
        System.out.println("Hourly rate: " + hourlyRate);
        System.out.println("Total salary: " + computeTotalSalary());
    }
}
