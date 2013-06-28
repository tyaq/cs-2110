
/**
 * Ishtyaq Habib
 * CS 2110, Summer 2013
 * Assignment 1, June 27, 2013
 * 
 * This program takes a user's input of Number Sets and displays statistics about them.
 * This program will take a user’s input of either a file path or sets of number.
 * It determines sets with non-numeral as separators.
 * Numbers are determined by spaces in between them.  
 * Also, the statistics can be exported out to a text file.
 * 
 * Highlight Feature: multiple Number Sets can be calculated in a run through.
 * 
 * Readme: Due to the implementation of doing multiple Number Sets methods would not declare
 * As a result to keep this program in one class i was unable to use method, sorry.
 * If another class had been used the main method would have been only a couple of methods.
 * Also, i was working on concatinating the rediculusly long numbers but did not have time.
 * 
 * 
 */


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
		
		//Reserve statistic variables 	
		double min;
		double max;
		double checkNumber;
		double avg;
		double stdev;
		double sum;
		double residualSum;
		double variance;
		double range;
		double[] numberSet;
		String input = "";
		String save = "";
		
		//Ask user for either a file path or for them to begin typing in data
		//They can enter more than one set inline
			messageOut.println("Give the path of a file or type in your data.");
			String inputFilePath=userInput.readLine();
			
		//Checks if file exists if not assume Data is inputed	
			File file = new File(inputFilePath);
			if (file.exists() && file.canRead()) {
				FileReader fr = new FileReader(inputFilePath);
				userInput = new BufferedReader(fr);
				save += "Input:\tFrom " + inputFilePath + "\n";
				String line =userInput.readLine();
				while(line !=null){
					input+=line + " ";
					line=userInput.readLine();					
				}
				save += "\t" + input + "\n";
				userInput = new BufferedReader(isr);
		//Assumes Data is inputed
			} else { 
				input=inputFilePath;
				save += "Input:\tEntered Data\n" + "\t" + input + "\n";
				} 
		//Terminators are used to find number sets
			String[] numberSets = input.split("[^0-9\\.\\s]+");
			
			for (int i = 0;i<numberSets.length;i++) {
			//spaces are used to find numbers and their input is cleaned further	
				String aSet =numberSets[i];
				messageOut.println("This is a numberSet before split " + aSet);
				
			//Closes Program if no input is entered
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
				
			//Separates numbers in a set
				String[] numberSetString = aSet.split("\\s+");
				
			//If set is only one number then stats are shown accordingly
				if (numberSetString.length==1){
					//print out message
					min = max = avg =Double.parseDouble(numberSetString[0]);
					stdev = 0;
					messageOut.println("avg,min,and max are all the same thing. Stdev does not exist.");
					messageOut.print("\nFor set [" + min);
					save += "\nFor set [" + min;

					messageOut.println("]");
					messageOut.println("\tThe minimum of the set is " + min);
					messageOut.println("\tThe maximum of the set is " + max);
					messageOut.println("\tThe average of the set is " + avg);
					messageOut.println("\tThe standard deviation is " + stdev);
					save += "]\n\tThe minimum of the set is " + min + "\n\tThe maximum of the set is " + max
							+ "\n\tThe average of the set is " + avg + "\n\tThe standard deviation is " + stdev
							+ "\n";
				//If this lone number set is not the last set the program moves on to the next set or it closes
					if ((i+1)<numberSets.length) {
						i++;
					} else {
						System.exit(0);
				}//Close if
				} else {
				
			//the individual number string are parsed to doubles		
				numberSet = new double[numberSetString.length];
				//Parse to double[]
				for(int j=0;j<numberSetString.length;j++){
					numberSet[j]=Double.parseDouble(numberSetString[j]);
					messageOut.println("this is a number in it " + numberSet[j]);
				}//close For
				
			//Some Stats are created to allow testing to first number
				min = numberSet[0];
				max=min;
				sum = min;
				residualSum = 0;
				
					
		//Calculations
			//Method to get min and max
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
			//Uses the repetition of minMax to calculate average and minMax for range
				avg = sum/numberSet.length;
				
				range = max -min;
				
			//Another method using average to find residuals	
				for (int l=0; l<numberSet.length;l++) {
					residualSum = residualSum + Math.pow(numberSet[l]-avg,2);
				}//Close for Stdev
			
			//Calculates Stdev and variance
				stdev = Math.sqrt(residualSum/numberSet.length);
			
				variance = stdev*stdev;

			//Print statement to format output
				messageOut.print("\nFor set [");
				save += "\nFor set [";
				for (int m=0; (m)<numberSet.length;m++) {
					messageOut.print(numberSet[m]);
					save += numberSet[m];
					if ((m+1)<numberSet.length) {
						messageOut.print(",");
						save += ",";
					}
				}
				messageOut.println("]");
				messageOut.println("\tThe range of the set is " + range);
				messageOut.println("\tThe minimum of the set is " + min);
				messageOut.println("\tThe maximum of the set is " + max);
				messageOut.println("\tThe average of the set is " + avg);
				messageOut.println("\tThe standard deviation is " + stdev);
				messageOut.println("\tThe variance is " + variance);
				messageOut.println("\tThe Sum of the residuals is " + residualSum);
				save += "]\n\t The range of the set is " + range + "The minimum of the set is " + min + "\n\tThe maximum of the set is " + max
						+ "\n\tThe average of the set is " + avg + "\n\tThe standard deviation is " + stdev
						+ "\n\tThe variance is " + variance + "\n\tThe Sum of the residuals is " + residualSum +"\n";
				}//Close else
				messageOut.println("\nNew Set of Numbers");
				
				}//Close for
			
		//Asks user if they want to output calculations
			messageOut.println("Do you want to save these stats? (\"yes\" or \"no\")");
			String response=userInput.readLine();
			if(response.equals("no")) {
				System.out.println("OK. Thank you for using this program for calculating statistics");
			
			} else if (response.equals("yes")){
					save += "\nMade using Ishtyaq Habib Software (ih239@cornell.edu)";
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
	userInput.close();

	}//Close main Method
}//Close Class NumberSetStatistics 

