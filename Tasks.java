import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.*;

public class Tasks {

	int day;
	int month;
	int year;

	// tasks related
	String tid = ""; // task ID
	String tname = ""; // task Name
	String duration = ""; // the duration of a task

	// resources related
	String rname = ""; // resource name
	String type = ""; // type of a resource {work\cost\material}
	String Material = ""; // unit of materials
	String max = ""; // ------
	String stRate = ""; // standard rate
	String Ovt = ""; // overtime rate

	


	// adding new tasks:
	public void writeTasks(int id, String tname, long days, String sdate, String fdate) {

		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Tasks.txt", true); // 
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.print(id + "    ");
			printWriter.print(tname + "    ");
			printWriter.print(days + 2 + "    "); // "+2" to include sdate and fdate
			printWriter.print(sdate + "    "); // starting date
			printWriter.print(fdate + "    "); // finishing date
			printWriter.println("");
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error in writeTasks();");
		}

	}
	
	
	// writing new resources
	public void writeResources(String rname, String rtype, int material, int maxn, int rate, int ovt, int cuse) { // cuse is cost of use

		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Resources.txt", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.print(rname + "    " + rtype + "    " + material + "    " + maxn + "    " + rate + "    " + ovt
					+ "    " + cuse);

			printWriter.println("");
			printWriter.close();
		} catch (Exception e) {
		}

	}
	
	private Scanner p; 
	private Scanner q;

	// allocating resources to tasks
	public void allocate(String id, String rname) {
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Tasks.txt"));
		} catch (Exception e) {
			System.out.println("Error in allocate(), the file is not found");
		}
		String idd = id;
		String tnamee = "";
		String dayss = "";
		String startt = "";
		String finishh = "";
		String rnamee = "";

		while (q.hasNext()) { // looping through tasks

			String tid = q.next();
			if (id.equals(tid)) {
				String tname = q.next();
				String days = q.next();
				String start = q.next();
				String finish = q.next();
				
				System.out.printf("%s %s %s %s %s ", tid, tname, days, start, finish);
				tid = id;
				tnamee = tname;
				dayss = days;
				startt = start;
				finishh = finish;

				try {
					p = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Resources.txt"));
				} catch (Exception e) {
					System.out.println("File is not found");
				}
				while (p.hasNext()) { // looping through resources
					String name = p.next();
					if (rname.equalsIgnoreCase(name)) {
						System.out.printf("%s\n", rname);
						rnamee = rname;

					}
				}
			}
		}
		writeTasksResources(idd, tnamee, dayss, startt, finishh, rnamee); 

		q.close();
		p.close();

	}

	// this method prints a file containing the allocated resources with the corresponding tasks.
	public void writeTasksResources(String id, String tname, String days, String sdate, String fdate, String resource) {

		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\allocateTasksResources.txt",	true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.print(id + "    ");
			printWriter.print(tname + "    ");
			printWriter.print(days + "    ");
			printWriter.print(sdate + "    ");
			printWriter.print(fdate + "    ");
			printWriter.print(resource + "    ");
			printWriter.println("");
			printWriter.close();
		} catch (Exception e) {
		}

	}

	// displaying tasks
	public void openTasks() {
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Tasks.txt"));
		} catch (Exception e) {
			System.out.println("Error in openTasks(), the file is not found(1)");
		}
		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\TasksReport.txt", false); // "false" prevents appending to the file.
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("ID    TaskName    Duration    Start    Finish");
			printWriter.println("ID    TaskName    Duration    Start    Finish");

			while (q.hasNext()) {
				String id = q.next();
				String tname = q.next();
				String days = q.next();
				String start = q.next();
				String finish = q.next();
				System.out.printf("%s %s %s %s %s \n", id, tname, days, start, finish);

				printWriter.print(id + "    " + tname + "    " + days + "    " + start + "    " + finish + "\n");
			}
			printWriter.close();

		} catch (Exception e) {
			System.out.println("Error in openTasks(), File is not found (2)");
		}

		q.close();
	}

	// displaying resources
	public void openResources() {
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Resources.txt"));
		} catch (Exception e) {
			System.out.println("Error in openResources(), the file is not found (1)");
		}
		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\ResourcesReport.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("Resource Name    Type    Material   Max   Rate   ovt   cost/use");
			printWriter.println("Resource Name    Type    Material   Max   Rate   ovt   cost/use");

			while (q.hasNext()) {
				String a = q.next();
				String b = q.next();
				String c = q.next();
				String d = q.next();
				String e = q.next();
				String f = q.next();
				String g = q.next();
				System.out.printf("%s           %s       %s     %s     %s     %s    %s   \n", a, b, c, d, e, f, g);
				printWriter.println(
						a + "         " + b + "      " + c + "      " + d + "      " + e + "      " + f + "      " + g);
			}
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error in openResources(), the file is not found (2)");
		}
		q.close();
	}
	// displaying the allocated resources with their corresponding tasks
	public void OpenTasksResources() {
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\allocateTasksResources.txt"));
		} catch (Exception e) {
			System.out.println("Error in openResources(), the file is not found (1)");
		}
		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\TasksResourcesReport.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("ID    TaskName    Duration    Start    Finish    Resource");
			printWriter.println("ID    TaskName    Duration    Start    Finish    Resource");

			while (q.hasNext()) {
				String a = q.next();
				String b = q.next();
				String c = q.next();
				String d = q.next();
				String e = q.next();
				String f = q.next();

				System.out.printf("%s   %s   %s   %s   %s   %s   \n", a, b, c, d, e, f);
				printWriter.println(a + "    " + b + "    " + c + "    " + d + "    " + e + "    " + f);

			}
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error in OpenTasksResources(), file is not found (2)");
		}

		q.close();
	}
	// calculating the total cost of a task
	public void costOfTask() {
		int dur = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;

		int total = 0;
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\allocateTasksResources.txt"));
		} catch (Exception e) {
			System.out.println("Error in costOfTasks(), the file is not found (1)");
		}
		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\CostOfTask.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("ID    TaskName    Duration    Start    Finish    Resource     Cost");
			printWriter.println("ID    TaskName    Duration    Start    Finish    Resource      Cost");

			while (q.hasNext()) {
				String a = q.next(); // task id
				String b = q.next(); // task name
				String c = q.next(); // duration
				String d = q.next(); // start
				String e = q.next(); // finish
				String f = q.next(); // resource name

				try {
					p = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Resources.txt"));
				} catch (Exception e1) {
					System.out.println("Error in costOfTasks(), the file is not found (2)");
				}

				while (p.hasNext()) {
					String rsrc = p.next();
					if (rsrc.equalsIgnoreCase(f)) {

						String r1 = p.next(); // type
						String r2 = p.next(); // material(unit)
						String r3 = p.next(); // Max
						String r4 = p.next(); // rate
						String r5 = p.next(); // ovt
						String r6 = p.next(); // cost/use

						if (r1.equalsIgnoreCase("work")) { // work
							i3 = Integer.parseInt(r3); // max integer
							i4 = Integer.parseInt(r4); // rate integer
							i5 = Integer.parseInt(r5); // ovt
							dur = Integer.parseInt(c);
							total = i3 * i4 * dur * 8 + i5 * i4;

						}
						if (r1.equalsIgnoreCase("cost")) { // cost
							int i6 = Integer.parseInt(r6);
							total = i6;

						}
						if (r1.equalsIgnoreCase("material")) { // material
							int i6 = Integer.parseInt(r6);
							total = i6;
						}

					}
				}

				System.out.printf("%s   %s   %s   %s   %s   %s   %s   \n", a, b, c, d, e, f, total);
				printWriter
						.println(a + "    " + b + "    " + c + "    " + d + "    " + e + "    " + f + "    " + total);

			}
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error in costOfTasks(), file is not found (3)");
		}

		q.close();

	}

	public void TotalCostOfTasks() { // total cost of the whole project
		int dur = 0;
		int i3 = 0;
		int i4 = 0;
		int i5 = 0;

		int total = 0;
		int totalCosts = 0;
		try {
			q = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\allocateTasksResources.txt"));
		} catch (Exception e) {
			System.out.println("Error in TotalCostOfTasks(), File is not found (1)");
		}
		try {

			FileWriter fileWriter = new FileWriter("C:\\\\Users\\\\SALEH\\\\Desktop\\\\TotalCostOfTasks.txt", false);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			System.out.println("ID    TaskName    Duration    Start    Finish    Resource     Cost");
			printWriter.println("ID    TaskName    Duration    Start    Finish    Resource      Cost");

			while (q.hasNext()) {
				String a = q.next(); // task id
				String b = q.next(); // task name
				String c = q.next(); // duration
				String d = q.next(); // start
				String e = q.next(); // finish
				String f = q.next(); // resourcename

				try {
					p = new Scanner(new File("C:\\\\Users\\\\SALEH\\\\Desktop\\\\Resources.txt"));
				} catch (Exception e1) {
					System.out.println("Error in TotalCostOfTasks(), File is not found (2)");
				}

				while (p.hasNext()) {
					String rsrc = p.next();
					if (rsrc.equalsIgnoreCase(f)) {

						String r1 = p.next(); // type
						String r2 = p.next(); // material(unit)
						String r3 = p.next(); // Max
						String r4 = p.next(); // rate
						String r5 = p.next(); // ovt
						String r6 = p.next(); // cost/use

						if (r1.equalsIgnoreCase("work")) { // work 
							i3 = Integer.parseInt(r3); // max integer
							i4 = Integer.parseInt(r4); // rate integer
							i5 = Integer.parseInt(r5); // ovt
							dur = Integer.parseInt(c);
							total = i3 * i4 * dur * 8 + i5 * i4;

						}
						if (r1.equalsIgnoreCase("cost")) { // cost 
							int i6 = Integer.parseInt(r6);
							total = i6;

						}
						if (r1.equalsIgnoreCase("material")) { // material 
							int i6 = Integer.parseInt(r6);
							total = i6;
						}
					}
				}
				totalCosts += total;
				System.out.printf("%s   %s   %s   %s   %s   %s   %s   \n", a, b, c, d, e, f, total);
				printWriter
						.println(a + "    " + b + "    " + c + "    " + d + "    " + e + "    " + f + "    " + total);

			}
			System.out.println("Total cost of all tasks i             "+totalCosts);
			printWriter.println("Total cost of all tasks is:         "+totalCosts);
			printWriter.close();
		} catch (Exception e) {
			System.out.println("Error in TotalCostOfTasks(), File is not found (3)");
		}

		q.close();

	}
	// this method is for calculating the days between two dates
	public long daysBetween(Date one, Date two) {
		long difference = (one.getTime() - two.getTime()) / 86400000;
		return Math.abs(difference);
	}


	
	public static void main(String[] args) {
		Tasks myObject = new Tasks();
		Scanner d = new Scanner(System.in); // dates
		Scanner t = new Scanner(System.in); // tasks


		while (true) {
			Scanner S = new Scanner(System.in);
			System.out.println("Choose one  of the following: ");
			System.out.println("(1)- Tasks");
			System.out.println("(2)- Resource identification");
			System.out.println("(3)- Allocate appropriate resource to a task");
			System.out.println("(4)- Report of all tasks");
			System.out.println("(5)- Display resources");
			System.out.println("(6)- Display tasks and resources");
			System.out.println("(7)- Display task resource of each task");
			System.out.println("(8)- Display the total cost for whole project");

			int x = S.nextInt();


			if (x == 1) {

				System.out.println("Enter task ID: ");
				int id = t.nextInt();

				System.out.println("Enter task name: ");
				String tname = t.next();

				// Date Related
				Calendar finishdate = Calendar.getInstance();
				Calendar startdate = Calendar.getInstance();

				// Scanner for dates

				System.out.println("Enter year, month, day respectevely for start date :");

				int syear = d.nextInt();
				int smonth = d.nextInt() - 1;
				int sday = d.nextInt();
				startdate.set(syear, smonth, sday);

				System.out.println("Enter year, month, day respectevely for finish date :");

				int fyear = d.nextInt();
				int fmonth = d.nextInt() - 1;
				int fday = d.nextInt();
				finishdate.set(fyear, fmonth, fday);

				Date start = startdate.getTime();
				Date finish = finishdate.getTime();

				long days = myObject.daysBetween(start, finish);

				System.out.print(id + "    ");
				System.out.print(tname + "    ");
				System.out.print(days + 2 + "    ");
				String sdate = sday + "/" + (smonth + 1) + "/" + syear;
				System.out.print(sdate);
				String fdate = fday + "/" + (fmonth + 1) + "/" + fyear;
				System.out.println("    " + fdate);
				myObject.writeTasks(id, tname, days, sdate, fdate);

				//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			} else if (x == 2) {
				String rname = "null";
				String rtype = "null";
				int maxn = 0;
				int rate = 0;
				int ovt = 0;
				int ovtlength = 0;
				int cost = 0;
				int material = 0;
				int unit = 0;
				int cuse = 0;

				System.out.println("Enter Resource Name ");
				rname = t.next();

				System.out.println("Enter Resource Type ");
				rtype = t.next();

				if (rtype.equalsIgnoreCase("work")) { // case 1
					System.out.println("Enter Max: ");
					maxn = t.nextInt() / 100;
					System.out.println("Enter rate per hour: ");
					rate = t.nextInt();

					System.out.println("Enter overtime cost per hour if any (zero if non): ");
					ovt = t.nextInt();

				} else if (rtype.equalsIgnoreCase("cost")) { // case 2
					System.out.println("Enter cost: ");
					cuse = t.nextInt();
				}

				else if (rtype.equalsIgnoreCase("material")) { // case 3
					System.out.println("Enter unit:");
					unit = t.nextInt();
					System.out.println("Enter cost of use: ");
					cuse = t.nextInt();
				}

				System.out.println("");
				System.out.print(rname + "    " + rtype + "    ");

				if (rtype.equalsIgnoreCase("work")) {
					System.out.print(maxn + "    " + rate + "    " + ovt + "    ");
				}

				if (rtype.equalsIgnoreCase("material")) {
					System.out.print(unit);
					System.out.print("   " + cuse);
				}
				if (rtype.equalsIgnoreCase("cost")) {

					System.out.println(cuse);
				}
				myObject.writeResources(rname, rtype, unit, maxn, rate, ovtlength, cuse);
			}
			///////////////////////////////////////////////////////////////////////////////////////////////////////////
			else if (x == 3) {
				String id = "";
				String rname = "";
				System.out.println("Enter Task ID: ");
				id = t.next();

				System.out.println("Enter resource name");
				rname = t.next();

				myObject.allocate(id, rname);

			}
			else if (x == 4) {
				myObject.openTasks();
			}
			else if (x == 5) {
				myObject.openResources();
			}

			else if (x == 6) {
				myObject.OpenTasksResources();
			}

			else if (x == 7) {
				myObject.costOfTask();

			}
			else if (x==8) {
				myObject.TotalCostOfTasks();
			}
			System.out.println("\nEnter 1 if you want to continue, -1 to exit: ");
			int c = t.nextInt();
			if (c == -1) {
				System.out.println("Thank you :)");
				break;
			}

		}
	}
}
