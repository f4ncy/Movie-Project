import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class DataFileReader {
	static ArrayList<String> StringList = new ArrayList<String>();
	
	//this sets each line to an index inside an arraylist called StringList
	public static ArrayList<String> readFile(){
		String title;
		String date;
		double rating;
		String length;
		String seasons;
		int startIndex = 0;
		int endIndex;
		
		
        try {
            Scanner input = new Scanner(System.in);

            File file = new File("NetflixUSA_Oct15_cleaned.txt");

            input = new Scanner(file);


            while (input.hasNextLine()) {
                String line = input.nextLine();
                //if the show is a season
                if(line.contains("Season")) {
                	startIndex = 0;
                	endIndex = 0;
                	endIndex = line.indexOf("(");
                	title = line.substring(startIndex, endIndex-1);
                	startIndex = endIndex;
                	endIndex = line.indexOf(")");
                	date = (line.substring(startIndex+1, endIndex));
                	startIndex = endIndex+7;
                	endIndex = line.indexOf(",") - 6;
                	rating = Double.parseDouble(line.substring(startIndex-1,endIndex));
                	startIndex = line.indexOf(",") + 1;
                	endIndex = line.length();
                	seasons = (line.substring(startIndex, endIndex));
                	Media x = new Series(title, date, rating, seasons);
                	
                }else if (!line.contains("Season")) {
                	startIndex = 0;
                	endIndex = 0;
                	endIndex = line.indexOf("(");
                	title = line.substring(startIndex, endIndex-1);
                	startIndex = endIndex;
                	endIndex = line.indexOf(")");
                	date = (line.substring(startIndex+1, endIndex));
                	startIndex = endIndex+7;
                	endIndex = line.indexOf(",") - 6;
                	rating = Double.parseDouble(line.substring(startIndex-1,endIndex));
                	startIndex = line.indexOf(",") + 1;
                	endIndex = line.length();
                	length = (line.substring(startIndex, endIndex));
                	Media y = new Movie(title, date, rating, length);
                }
                
                
                
                StringList.add(line);
                System.out.println(line);
            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return StringList;
    }
	
	
	

}
