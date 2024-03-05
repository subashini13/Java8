public class Equals {

    public static void main(String[] args)
    {
        String startPosition = "5h";

        int rowStart = Character.getNumericValue(startPosition.charAt(0));
        String column = Character.toString(startPosition.charAt(1));

        String alphaString = "abcdefgh";
        int columnStart = alphaString.indexOf(column)+1;

        int endRow = getPosition(rowStart,11);
        int endColumn = getPosition(columnStart,23);

        String endPosition = String.valueOf(endRow)+alphaString.charAt(endColumn-1);
        System.out.println(endPosition);

    }

    public static int getPosition(int start, int increment){
        int endPos =  (start+increment>8)? (start+increment)%8 : (start+increment);
        return (endPos==0)?1:endPos;
    }

}
