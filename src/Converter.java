public class Converter {
    public static long convertDecimalToBinary(int n) {
        long binaryNumber = 0;
        int remainder, i = 1, step = 1;

        while (n!=0) {
            remainder = n % 2;
            System.out.println("Step " + step++ + ": " + n + "/2");
            System.out.println("Quotient = " + n/2 + ", Remainder = " + remainder);
            n /= 2;
            binaryNumber += remainder * i;
            i *= 10;
        }
        return binaryNumber;
    }
}
//https://www.programiz.com/java-programming/examples/binary-decimal-convert

