
package app;

import java.util.ArrayList;


public class CreditCardsList {
    private ArrayList<CreditCards> cards;

    public CreditCardsList(){
        cards = new ArrayList<>();
    }

    public void addCard(CreditCards card){
        cards.add(card);
    }

    public String toString(){
        String info = "";
        for(CreditCards c : cards){
            info = "Card Number: " + c.getCardNumber() + "\t" +
                   "Expiration Date: " + c.getExpirationDate() + "\t" +
                   "CSV Number: " + c.getCsvCode() + "\t " +
                   "Card Type: " + c.getCardType();
            System.out.println("");
        }
        return info;
    }
}
