package application;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		
		System.out.print("Enter Departament's name: ");
		String depName = sc.nextLine();
		System.out.println("Enter the Work Data:");
		System.out.print("name: ");
		String name = sc.nextLine();
		System.out.print("Level: ");
		String levelName = sc.nextLine();		
		System.out.print("Base Salary: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(name, WorkerLevel.valueOf(levelName), baseSalary, new Department(depName));
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.print("Enter contract #" + i + "data:");
			System.out.print("Data (dd/MM/yyyy)");
			Date contractDate = sdf.parse(sc.next()); 
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hour): ");
			int duration = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			worker.addContract(contract); 
		}
		
		System.out.print("Enter month and year to calculate income (MM/YYYY): ");
		Date date = sdf1.parse(sc.next());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int _year = cal.get(Calendar.YEAR);
		int _month = 1 + cal.get(Calendar.MONTH);
		
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + _month);
		worker.income(_year, _month);
		System.out.println("$ " + worker.getBaseSalary());
		
	}

}
