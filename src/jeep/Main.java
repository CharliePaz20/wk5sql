package jeep;


import java.util.List;
import java.util.Scanner;
import jeep.dao.JeepDao;
import jeep.entity.Jeep;





public class Main {
  private Scanner scanner = new Scanner(System.in);
 private JeepDao jeepDao = new JeepDao()
;		 
		 public static void main(String[] args) {
		new Main().run();
	                                       }

	private void run() {
		
		boolean done = false;
	
	    
		while(!done) {
		               printMenu();	
			
			
			
			try {	
				switch(scanIntValue("Enter A Menu Item")) {
				
				case -1:
				done = true;
				break;
				
				case 1:
					listJeeps();
				break;
				   
				case 2:
					 createJeep();
					break;
					
				case 3:
					 modifyJeep();
					break;	
				
				case 4:
					 deleteJeep();
					break;	
				
				default:
					System.out.println("Only select one of the Values Listed");
					break;
				
			}
		        }
	       catch(Exception e) { 
	System.out.println("Error! " + e.toString());
	done = true;
	                          }
		             }
	
		System.out.println("Come on Man.");
	
	                   }

	private void listJeeps() {
		System.out.println("View All Jeep");
		List<Jeep> jeeps = jeepDao.listAllJeeps();
		
		System.out.println();
		for(Jeep jeep : jeeps) {
			System.out.println("  " + jeep.getJeepId() + ": " + jeep.getName() );
		}
	}

	private void deleteJeep() {
		System.out.println("Your are deleting Jeep");
		int jeepId = scanIntValue("Enter Jeep ID");
		jeepDao.deleteJeep(jeepId);
		System.out.println("Jeep Deleted");
		
		
	}

	private void modifyJeep() {
		System.out.println("Change Jeep name");
		int jeepId = scanIntValue("Enter Jeep ID");
		String name = scanStringValue("Enter a new name for Jeep");
		
		jeepDao.modifyJeep(jeepId, name);
		System.out.println("Jeep name changed to " + name);
		
		
	}

	private void createJeep() {
		System.out.println("Your are Creating Jeep");
		String name = scanStringValue("Enter a name for Jeep");
		jeepDao.createJeep(name);
		
		
		
		System.out.println("You created a Jeep named " + name);
		
	}
private String scanStringValue(String message) {
	
			System.out.print(message + ": ");
		return scanner.nextLine();		
	}



private int scanIntValue(String message) {
		
		try {
			System.out.print(message + ": ");
		String value = scanner.nextLine();
		return Integer.parseInt(value);
		
		}
		catch(Exception e){ 
			System.out.println("Error next line");
		}
		
		return 0;
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1 List all Jeeps");
		System.out.println("2 Create a Jeep");
		System.out.println("3 Modify a Jeep");
		System.out.println("4 Delete a Jeep");
		System.out.println("-1) to Quit");
	
	}
	               }
