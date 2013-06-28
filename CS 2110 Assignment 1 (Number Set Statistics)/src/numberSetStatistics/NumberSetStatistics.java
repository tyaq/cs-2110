package numberSetStatistics;

//Import Classes Necessary for Program
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.lang.Math;

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
		
		//Ask if user wants to use self input or file input make it so it reminds you what options you have

			
			double min;
			double max;
			double checkNumber;
			double avg;
			double stdev;
			double sum;
			double residualSum;
			double variance;
			double[] numberSet;
			
			messageOut.println("Give the path of a file or type in your data.");
			String inputFilePath=userInput.readLine();
			String input = "";
			File file = new File(inputFilePath);
			if (file.exists() && file.canRead()) {
				FileReader fr = new FileReader(inputFilePath);
				userInput = new BufferedReader(fr);
				String line =userInput.readLine();
				while(line !=null){
					input+=line + " ";
					line=userInput.readLine();					
				}
				userInput = new BufferedReader(isr);
			} else { 
				input=userInput.readLine();
				}
			String save = ""; 
			String[] numberSets = input.split("[^0-9\\.\\s]+");
			for (int i = 0;i<numberSets.length;i++) {
				
				String aSet =numberSets[i];
				messageOut.println("This is a numberSet before split " + aSet);
				
				if (aSet.isEmpty()) {
					messageOut.println("I just read an empty set so there no statistics.");
					save += "I just read an empty set so there no statistics.\n";
					System.exit(0);
				}//Close if
				
				aSet = aSet.replaceAll("\\s+"," ");
				if (aSet.charAt(aSet.length()-1)==' '){
					aSet= aSet.substring(0,aSet.length()-1);
				}//Close if
				
				if (aSet.charAt(0)==' '){
					aSet= aSet.substring(1);
				}//Close if
				

				String[] numberSetString = aSet.split("\\s+");
				
				if (numberSetString.length==1){
					//print out message
					min = max = avg =Double.parseDouble(numberSetString[0]);
					messageOut.println("avg,min,and max are all the same thing. Stdev does not exist.");
					if ((i+1)<numberSets.length) {
						i++;
					} else {
						System.exit(0);
				}//Close if
				} else {
				
				numberSet = new double[numberSetString.length];
				//Parse to double[]
				for(int j=0;j<numberSetString.length;j++){
					numberSet[j]=Double.parseDouble(numberSetString[j]);
					messageOut.println("this is a number in it " + numberSet[j]);
				}//close For
				min = numberSet[0];
				max=min;
				sum = min;
				residualSum = 0;
				
					
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
					
				}//Close for
				
				avg = sum/numberSet.length;
					
				for (int l=0; l<numberSet.length;l++) {
					residualSum = residualSum + Math.pow(numberSet[l]-avg,2);
				}//Close for Stdev
				
				stdev = Math.sqrt(residualSum/numberSet.length);
			
				variance = stdev*stdev;

				messageOut.print("\nFor set [");
				save += "\nFor set [";
				for (int m=0; (m)<numberSet.length;m++) {
					messageOut.print(numberSet[m]);
					save += numberSet[m];
					if ((m+1)<numberSet.length) {
						messageOut.print(",");
					}
				}
				messageOut.println("]");
				messageOut.println("\tThe minimum of the set is " + min);
				messageOut.println("\tThe maximum of the set is " + max);
				messageOut.println("\tThe average of the set is " + avg);
				messageOut.println("\tThe standard deviation is " + stdev);
				messageOut.println("\tThe variance is " + variance);
				messageOut.println("\tThe Sum of the residuals is " + residualSum);
				save += "]\n\tThe minimum of the set is " + min + "\n\tThe maximum of the set is " + max
						+ "\n\tThe average of the set is " + avg + "\n\tThe standard deviation is " + stdev
						+ "\n\tThe variance is " + variance + "\n\tThe Sum of the residuals is " + residualSum +"\n";
				}//Close else
				messageOut.println("\nNew Set of Numbers");
				
				}//Close for
			messageOut.println("Do you want to save these stats? (\"yes\" or \"no\")");
			String response=userInput.readLine();
			if(response.equals("no")) {
				System.out.println("OK. Thank you for using this program for calculating statistics");
			
			} else if (response.equals("yes")){
					messageOut.println("Type name of file you wish to send stats to");
					String outputFilePath=userInput.readLine();
					file= new File(outputFilePath);
					file.createNewFile();
					FileWriter writer=new FileWriter(file.getAbsoluteFile());
					BufferedWriter buffered= new BufferedWriter(writer);
					buffered.write(save);
					buffered.close();
					System.out.println("Okay, you can find it at " + outputFilePath);
			} else {
				messageOut.println("Sorry i didn't understand you, but thank you" +
						" for using this program to calculate statistics");
			}

	}//Close main Method
}//Close Class NumberSetStatistics 

