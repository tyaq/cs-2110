package numberSetStatistics;

//Import Classes Necessary for Program
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class NumberSetStatistics {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//Create Objects to get User Input from Console and message the User
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader userInput = new BufferedReader (isr);
		PrintWriter messageOut = new PrintWriter (System.out,true);
		
		boolean nav= true;
		//Ask if user wants to use self input or file input make it so it reminds you what options you have
			messageOut.println("Do you prefer to type in data or give the name of a file holding the data?");
			String typeChoice = userInput.readLine();
			if (typeChoice.equals("type")) {
				messageOut.println("Enter in your Numbers on seperate lines. When you are finish press enter agian.");
				/*String regex = "([-+]?[0-9]*\\.?([0-9]+([eE][-+]?[0-9]+)?)?)";//regex to get doubles and empty string
				Boolean enteringNumbers = true;//used to get user continuing to enter valid data
				ArrayList numberSet = new ArrayList();
				for (int i=0;enteringNumbers==true;i++) {
					String enteredNumber = userInput.readLine();
					enteringNumbers = enteredNumber.matches(regex) && !enteredNumber.equals("");//empty string removed from regex
					if (enteringNumbers){
					numberSet.add(i,Double.parseDouble(enteredNumber));}
				}//Close for
				
				if (numberSet.get(0)==null) {
				messageOut.println("I just read an empty set so there no statistics.");
				} else if (numberSet.size()==1){
					//print out message
					messageOut.println("avg,min,and max are all the same thing. Stdev does not exist.");
					System.exit(0);
				} 
				
				double min = (double) numberSet.get(0);
				double max=min;
				double checkNumber;
				double avg;
				double stdev;
				double sum = min;
				double residualSum = 0;*/
				
				String input=userInput.readLine();
				String[] numberSets = input.split("[^0-9\\.\\s]+");
				for (int i = 0;i<numberSets.length;i++) {
					String aSet =numberSets[i];
					String[] numberSet = aSet.split("\\s+");
					for(int j=0;j<numberSet.length;j++){
					System.out.println("this is a number " + numberSet[j]);
					}
					System.out.println("New Set of Numbers");
				}
				//String[] numbers = .split("\\s+");
				
				//for (int i = 0;i<numbers.length;i++) {
					//int j=numbers[i].indexOf("\\s+");
					//System.out.println(j);
				//}
				/*numbers.indexOf();
				for (int i=1; i<numberSet.size();i++) {
					//messageOut.println(numberSet.get(i));
					checkNumber = (double) numberSet.get(i);
					if (checkNumber<min){
						min=checkNumber;
					}//Close if
					if (checkNumber>max) {
						max=checkNumber;
					}//Close if
					sum=sum+checkNumber;
				}//Close for
				
				avg = sum/numberSet.size();
				
				for (int i=0; i<numberSet.size();i++) {
					residualSum = residualSum + Math.pow((double) numberSet.get(i)-avg,2);
				}
				stdev = Math.sqrt(residualSum/numberSet.size());
				
				
				messageOut.println("The minimum of the set is " + min);
				messageOut.println("The maximum of the set is " + max);
				messageOut.println("The average of the set is " + avg);
				messageOut.println("The standard deveation is " + stdev);
				*/
			}//Close If
			//else if (input=="file") {useFile();}
			else {messageOut.println("Please tell me Either\"type\" or \"file\" or \"close\".");}

	}//Close main Method

public void useType() {
	
}
	
	//Create a saving method
	public static void saveFile() {
	
	}//Close saveFile Method
}//Close Class NumberSetStatistics 

