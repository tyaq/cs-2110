package numberSetStatistics;

//Import Classes Necessary for Program
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;


public class NumberSetStatistics {

	double min;
	double max;
	double avg;
	double stdev;
	double sum;
	double residualSum;
	double variance;
	double[] numberSet;
	
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
				double residualSum = 0;
				test string
				4321 41234 2314 1242 1 421 41t 4124 1242134124214241242 t43t32t 343222t
				Problem if something like 2.1.3 or 2.2.2.2 is entered
				*/
				
				String input=userInput.readLine();
				String[] numberSets = input.split("[^0-9\\.\\s]+");
				for (int i = 0;i<numberSets.length;i++) {
					
					String aSet =numberSets[i];
					messageOut.println("This is a numberSet before split " + aSet);
					
					if (aSet.isEmpty()) {
						messageOut.println("I just read an empty set so there no statistics.");
						System.exit(0);
					}//Close if
					
					aSet = aSet.replaceAll("\\s+"," ");
					if (aSet.charAt(aSet.length()-1)==' '){
						aSet= aSet.substring(0,aSet.length()-1);
					}//Close if
					
					if (aSet.charAt(0)==' '){
						aSet= aSet.substring(1);
					}//Close if
					
					messageOut.println("This is a numberSet after taking off whitespace " + aSet);
					String[] numberSetString = aSet.split("\\s+");
					
					if (numberSetString.length==1){
						//print out message
						messageOut.println("avg,min,and max are all the same thing. Stdev does not exist.");
						if ((i+1)<numberSets.length) {
							i++;
						} else {
							System.exit(0);
					}//Close if
					} else {
					
					double[] numberSet = new double[numberSetString.length];
					//Parse to double[]
					for(int j=0;j<numberSetString.length;j++){
						numberSet[j]=Double.parseDouble(numberSetString[j]);
						messageOut.println("this is a number in it " + numberSet[j]);
					}//close For
					
					double min = numberSet[0];
					double max=min;
					double checkNumber;
					double avg;
					double stdev;
					double sum = min;
					double residualSum = 0;
					double variance;
					
					
					//Calculations
					
					for (int k=1; k<numberSet.length;k++) {
						//messageOut.println(numberSet.get(i));
						checkNumber = numberSet[k];
						if (checkNumber<min){
							min=checkNumber;
						}//Close if
						if (checkNumber>max) {
							max=checkNumber;
						}//Close if
						sum=sum+checkNumber;
						
					}//Close for Mean Calc
					
					avg = sum/numberSet.length;
					
					for (int l=0; l<numberSet.length;i++) {
						residualSum = residualSum + Math.pow((double) numberSet[l]-avg,2);
					}//Close for Stdev
					
					stdev = Math.sqrt(residualSum/numberSet.length);
					
					variance = stdev*stdev;
					
					messageOut.print("\nFor set [");
					for (int m=0; m<numberSet.length;m++) {
						messageOut.print(numberSet[m]);
						if ((m+1)<numberSet.length) {
							messageOut.print(",");
						}
					}
					messageOut.println("]");
					messageOut.println("\tThe minimum of the set is " + min);
					messageOut.println("\tThe maximum of the set is " + max);
					messageOut.println("\tThe average of the set is " + avg);
					messageOut.println("\tThe standard deveation is " + stdev);
					messageOut.println("\tThe variance is " + variance);
					messageOut.println("\tThe Sum of the residuals is " + residualSum);
					}//Close else
					messageOut.println("New Set of Numbers");
					
					
				}//Close type for
				
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

public void calcMaxMin(double[] numberSet) {
	double checkNumber;
	for (int k=1; k<numberSet.length;k++) {
		//messageOut.println(numberSet.get(i));
		checkNumber = numberSet[k];
		if (checkNumber<min){
			min=checkNumber;
		}//Close if
		if (checkNumber>max) {
			max=checkNumber;
		}//Close if
		sum=sum+checkNumber;
		
	}//Close for Mean Calc
}//Close calcMaxMin Method
	
	//Create a saving method
	public static void saveFile() {
	
	}//Close saveFile Method
}//Close Class NumberSetStatistics 

