
package app;

//Testings
public class StockReader {
    public static void main(String[] args){
        ReadFiles r = new ReadFiles();
        r.convertToArray();
        Formulas f = new Formulas();
        f.createFloatArray(r.getArray());
        f.printArray(); 
    }
}
