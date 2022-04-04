import java.util.*;

public class airlinePriority implements Comparable <airlinePriority >{
	private int rank; 
	private int Length_of_wait; 
	private String customer; 
	
		
	public airlinePriority(String customer, int rank, int Length_of_wait) { 
		this.customer = customer; 
		this.rank = rank; 
		this.Length_of_wait = Length_of_wait; 
		}

	@Override
	public int compareTo(airlinePriority  flight) {
			
		if (rank < flight.rank) { 
			return -1; 
		}
			
		else if (rank > flight.rank ) { 
			return 1; 
		}
			
		if(Length_of_wait < flight.Length_of_wait) { 
			return -1; 
		}
			
		if (Length_of_wait > flight.Length_of_wait ) { 
			return 1; 
		}
			
			return 0; 
		}
		
		@Override
	public String toString() { 
		String res = "customer: " + customer + ", " + "rank: " + rank + ", " + "Length of wait: " + Length_of_wait; 
		return res; 
		}

		//menu build	
	static void upgradeMenu() {
		
		System.out.println("||  Menu  ||");
		System.out.println("1 - Super");
		System.out.println("2 - Platinum");
		System.out.println("3 - Gold");
		System.out.println("4 - Silver");
		System.out.println();
		
		   }
		
		
	public static void main(String[] args) {
		
		PriorityQueue <airlinePriority > chair = new PriorityQueue<>(); 
			
		System.out.println("Enter the number of chairs you would like to upgrade: "); 
			
		Scanner scanner1 = new Scanner(System.in); 
		final int chairs_max = scanner1.nextInt(); 
		int i = 0;
			while ( i < chairs_max) { 
					
			System.out.println("Enter your customer name: ");
				
			Scanner scanner2 = new Scanner(System.in); 
			String customer = scanner2.next(); 
				
			//upgrade menu call - display menu
			upgradeMenu(); 
				
			System.out.println("Choose number associated with your upgrade rank: ");
				
			
			
			Scanner scanner3 = new Scanner(System.in); 
			int upgrade_priority = scanner3.nextInt();
				
			if (upgrade_priority < 1 || upgrade_priority > 4) { 
				System.out.println("please choose rank 1-4!!!");
				
				continue; 
			}
			
			
			
			System.out.println("wait time: ");
			Scanner scanner4 = new Scanner(System.in); 
			int Length_of_wait = scanner4.nextInt();
				
			
			
			// deny or confirm reservation
			System.out.println("Type confirm to confirm or deny to deny");
			
			Scanner scanner5 = new Scanner(System.in); 
			String s = scanner5.next(); 
			if (s.equals("deny")) { 
				System.out.println("reservation cancled");
				continue; 
			}
			if (s.equals("confirm")) { 
				System.out.println("reservation confirmed!");
				
			chair.add(new airlinePriority  (customer, upgrade_priority, Length_of_wait));
				
				
			i++;
				
			}
		}
				
				
		Iterator <airlinePriority> iterator1 = chair.iterator(); 
			
		while(iterator1.hasNext()) {
			
			System.out.println(chair.poll().toString());
			
			}
		}
	}
