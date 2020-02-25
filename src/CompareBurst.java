import java.util.Comparator;

public class CompareBurst implements Comparator<process>
{
    
	@Override
	public int compare(process o1, process o2) 
	{
		// TODO Auto-generated method stub
		return o1.BurstTime - o2.BurstTime;
	}
}