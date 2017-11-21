public class CreditCard {
  private String cardnumber;
  private String issuer = "Unknown";
  public CreditCard(String ccn){
    cardnumber = clean(ccn);
    issuer = getIssuer();
  }

  public String getIssuer(){

    if(cardnumber.startsWith("6011") && cardnumber.length() == 16) return "Discover";
    if((cardnumber.startsWith("51") || cardnumber.startsWith("52") || cardnumber.startsWith("53") || cardnumber.startsWith("54") || cardnumber.startsWith("55") ) && cardnumber.length() == 16) return "MasterCard";
    if(cardnumber.startsWith("4") && (cardnumber.length() == 16 || cardnumber.length() == 13) ) return "VISA";
    if((cardnumber.startsWith("34") || cardnumber.startsWith("37")) && cardnumber.length() == 15  ) return "American Express";
    if((cardnumber.startsWith("300") || cardnumber.startsWith("301") || cardnumber.startsWith("302") || cardnumber.startsWith("303") || cardnumber.startsWith("304") || cardnumber.startsWith("305") || cardnumber.startsWith("36") || cardnumber.startsWith("38") ) && cardnumber.length() == 14) return "Diner's Club";

    return "Unknown";
  }

  public boolean isValid(){
    int[] CCN = new int[cardnumber.length()];
    for(int i = 0; i < cardnumber.length(); i++) CCN[i] = Integer.parseInt(cardnumber.substring(i, i+1));
    for(int i = CCN.length - 2; i >= 0; i = i-2){
      int curr = CCN[i];
      curr = curr * 2;
      if(curr > 9) curr = curr % 10 + 1;
      CCN[i] = curr;
    }
    int sum = 0;
    for(int curr : CCN) sum += curr;
    if(sum % 10 == 0) return true;
    else return false;
  }

  public static String clean(String s){
    String ret = "";
    for (int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)) ret += c;
    }
    return ret;
  }

  public String toString(){
    return cardnumber + " was issued by " + issuer + " and is"+(isValid() ? "" : " not")+" valid.";
  }
}
