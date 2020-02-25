import java.util.PriorityQueue;
import java.util.Vector;


public class SJF 
{
	public static void schedule(Vector<process> processes)
	{
		PriorityQueue<process> waiting = new PriorityQueue<process>(processes.size(), new CompareBurst());
		Vector<process> executed = new Vector<process>(); /// To hold executed processes.
		
		int ExecutionTime = processes.get(0).ArrivalTime;
		int Waiting_Time;
		int Turnaround;
		double Avg_waiting = 0;
		double Avg_turnaround = 0;
				
   		System.out.print("Process name" + "\t" + "Arrival time" + "\t" + "Burst time" + "\t" +  "Waiting time" + "\t" + "Turnaround time" + "\t" + "\n");
   		
   		while(executed.size() != processes.size())
   		{
   			for(int i = 0; i < processes.size(); i++)
   			{
   				if((processes.get(i).ArrivalTime <= ExecutionTime) && (!executed.contains(processes.get(i))) && (!waiting.contains(processes.get(i))))
   				{
   					waiting.add(processes.get(i));
   				} 
   			}
   			Waiting_Time = ExecutionTime - waiting.peek().ArrivalTime;
   			Turnaround = Waiting_Time + waiting.peek().BurstTime;
   			
   			Avg_waiting += Waiting_Time;
   			Avg_turnaround += Turnaround;
   			System.out.print("\t" + waiting.peek().name + "\t\t" + waiting.peek().ArrivalTime + "\t\t" + waiting.peek().BurstTime + "\t\t" +  Waiting_Time + "\t\t" + Turnaround + "\t\t" + "\n");
   			
   			ExecutionTime += waiting.peek().BurstTime;
			executed.add(waiting.peek());
   			waiting.poll();	
   		}
   		System.out.println("Average waiting time is: " + Avg_waiting / processes.size());
   		System.out.println("Average turnaround time is: " + Avg_turnaround / processes.size());

	}

}
