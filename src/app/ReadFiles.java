
package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

public class ReadFiles {
    
    File file = new File("C:\\Stocks\\20_Google_Prices.csv");
    int row = 0;
    String[][] items;
    
    public boolean checkIsFile(){
        return this.file.isFile();
    }
    
    
    public int findRowNumber(){
        row = 0;
        if(checkIsFile()){
            
            try{
                BufferedReader reader = new BufferedReader(new FileReader(file));
                while((reader.readLine()) != null){
                    row++;
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else{
            System.out.println("This is not a file!");
        }
        return row;
    }
    
    //Converts csv file to array
    public void convertToArray(){
        int r = 0;
        int columns = 7;
        items = new String[findRowNumber()][columns];
        
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            
            //Assigns line to current text being read and checks if not null
            while((line=reader.readLine()) != null){
                StringTokenizer z = new StringTokenizer(line, ",");
                while(z.hasMoreTokens()){
                    for(int c = 0; c<columns; c++){
                        items[r][c] = z.nextToken();
                    }
                    r++;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void printArray(){
        for(int x = 0; x<items.length; x++){
            System.out.print(x+1 + " - ");
            for(int y = 0; y<items[x].length; y++){
                System.out.print(items[x][y]);
            }
            System.out.println();
        }
    }
    
    //Returns array of items
    public String[][] getArray(){
        return items;
    }
}
