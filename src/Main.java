import java.util.*;
public class Main 
{
	public static Vector<process> processes = new Vector<process>(); /// To hold different processes.

	public static Scanner input = new Scanner(System.in); 
	
	public static void getInfo(process p)
	{
		System.out.println("Enter name of the process: ");
		p.name = input.nextLine();
		
		System.out.println("Enter arrival time of the process: ");
		p.ArrivalTime = input.nextInt();
		input.nextLine();

		System.out.println("Enter burst time of the process: ");
		p.BurstTime = input.nextInt();
		input.nextLine();

		

		processes.add(p);
	}
	public static void main(String[] args) 
	{
		int NumberOfProcesses;
		process p = new process();
		System.out.println("Enter number of processes: ");
		NumberOfProcesses = input.nextInt();
		input.nextLine();
		
			for(int i = 0; i < NumberOfProcesses; i++)
			{
				p = new process();
				getInfo(p);
			}
			 Comparator<process> comp = new Compare();
			 Collections.sort(processes, comp);
			 
			 SJF.schedule(processes);
			
		
		
		
		
	}

}
