public class FT {
    public static void computeDft(double[] inreal, double[] inimag, double[] outreal, double[] outimag) {
        int n = inreal.length;
        for (int k = 0; k < n; k++) {
            double sumreal = 0;
            double sumimag = 0;
            for (int t = 0; t < n; t++) {
                double angle = 2 * Math.PI * t * k / n;
                sumreal +=  inreal[t] * Math.cos(angle) + inimag[t] * Math.sin(angle);
                sumimag += -inreal[t] * Math.sin(angle) + inimag[t] * Math.cos(angle);
            }
            outreal[k] = sumreal;
            outimag[k] = sumimag;
        }
    }

}
// https://www.nayuki.io/res/how-to-implement-the-discrete-fourier-transform/Dft.java
