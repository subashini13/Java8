import java.util.stream.IntStream;

public class CreditCardValidator {

    protected static boolean luhnCheck(String cardNumber) {
        int cardLen = cardNumber.length();
        //check if card length is odd or even. if even double all even places if odd double all odd places
        int oddorEven = cardLen & 1; //& return 1 if both are 1 if a number is even it ends with 0 odd its ends with 1 - return 1 if odd 0 if even
        long sum =0;
        boolean isValid = false;
        sum = IntStream.range(0,cardLen).mapToLong(i -> {
            int digit = 0;
            digit = Integer.parseInt(cardNumber.charAt(i) + "");
            if(((i & 1) ^ oddorEven)==0){ // XOR returns 0 if both are 0 or both are 1  else return 1
                digit *=2;
                if(digit>9){
                    digit-=9;
                }
            } return digit;}).sum();

        return (sum==0)?false:(sum%10==0);

    }
    public static void main(String[] args) {
        System.out.println( luhnCheck("5500005555555559"));
        System.out.println( luhnCheck("371449635398431"));
        System.out.println( luhnCheck("36438936438936"));
        System.out.println( luhnCheck("6011016011016011"));
        System.out.println( luhnCheck("1111111111111111"));
    }
}
