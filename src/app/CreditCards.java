
package app;


public class CreditCards {
    private long cardNumber;
    private String expirationDate;
    private int csvCode;
    private String cardType;
    
    public CreditCards(long cardNumber, String expirationDate, int csvCode, String cardType){
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.csvCode = csvCode;
        this.cardType = cardType;
    }
    
    public CreditCards(long cardNumber, String cardType, String expirationDate){
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
    }
    
    public void cardNumberToArray(long l){
        String temp = Long.toString(l);
        int[] newGuess = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            newGuess[i] = temp.charAt(i) ;
        }
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCsvCode() {
        return csvCode;
    }

    public String getCardType() {
        return cardType;
    }
    
    
}
