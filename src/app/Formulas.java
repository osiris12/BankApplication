
package app;

import java.text.SimpleDateFormat;
import java.util.Date;

//Credit card formula
public class Formulas {
    ReadFiles r = new ReadFiles();
    double[][] doubleArray = new double[r.findRowNumber()][7];
    Date[] dateArray = new Date[r.findRowNumber()];
    
    public void createDateArray(String[][] n){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        for(int x = 0; x<n.length; x++){
            for(int y = 0; y<n[x].length; y++){
                if(y == 0){
                    try{
                        Date newDate = (Date)df.parse(n[x][0]);
                        dateArray[x] = newDate;
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
            }
        }
    }
    
    public void createFloatArray(String[][] n){
        double f = 0.0;
        for(int x = 0; x<n.length; x++){
            for(int y = 0; y<n[x].length; y++){
                if(y>0){
                    f = Double.parseDouble(n[x][y]);
                    doubleArray[x][y] = f;
                }else{
                    doubleArray[x][y] = 0;
                }
            }
        }
    }
    
    public void printArray(){
        for(int x = 0; x<doubleArray.length; x++){
            for(int y = 0; y<doubleArray[x].length; y++){
                double d = doubleArray[x][y];
                System.out.printf("%.2f ", d);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
