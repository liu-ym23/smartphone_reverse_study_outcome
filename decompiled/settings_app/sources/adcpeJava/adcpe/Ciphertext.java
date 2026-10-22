package adcpeJava.adcpe;

import java.util.Arrays;
import org.apache.commons.math3.linear.ArrayRealVector;

/* JADX INFO: loaded from: classes.dex */
public class Ciphertext {
    private final double[] c;
    private final byte[] nBytes;

    Ciphertext(double[] r1, byte[] r2) {
        this.c = r1;
        this.nBytes = r2;
    }

    public double[] c() {
        return this.c;
    }

    public float[] floatC() {
        return Utils.convertDoubleArrayToFloatArray(this.c);
    }

    public double[] normalizedC() {
        ArrayRealVector r0 = new ArrayRealVector(this.c);
        return r0.mapDivide(r0.getNorm()).toArray();
    }

    public float[] floatNormalizedC() {
        return Utils.convertDoubleArrayToFloatArray(normalizedC());
    }

    public byte[] nBytes() {
        return this.nBytes;
    }

    public String nHexStr() {
        return Utils.byteArrayToHexString(this.nBytes);
    }

    public String nAndNormHexStr() {
        return nHexStr() + Utils.byteArrayToHexString(Utils.doubleToBytes(new ArrayRealVector(this.c).getNorm()));
    }

    public String cStr() {
        return "[" + Utils.convertDoubleArrayToString(this.c) + "]";
    }

    public String nBytesStr() {
        return Constants.ENCODER.encodeToString(this.nBytes);
    }

    public String toStr() {
        return cStr() + ":" + nBytesStr();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L17:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L17;
        Ciphertext r6 = (Ciphertext) r5;
        if (Arrays.equals(this.c, r6.c) == false) goto L16;
        if (Arrays.equals(this.nBytes, r6.nBytes) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public static Ciphertext fromStr(String r5) throws IllegalArgumentException {
        if (r5.contains(":") == false) goto L21;
        String[] r6 = r5.replaceAll("\\s+", "").split(":", 2);
        String r1 = r6[0];
        String r7 = r6[1];
        if (r1.startsWith("[") == false) goto L19;
        if (r1.endsWith("]") == false) goto L19;
        if (r7.length() != 44) goto L17;
        return new Ciphertext(Utils.convertStringToDoubleArray(r1), Constants.DECODER.decode(r7));
    L13:
        e = move-exception;
        throw new IllegalArgumentException("the cStr part of input is illegal: " + e.getMessage());
    L17:
        throw new IllegalArgumentException(String.format("the nStr part of input is illegal, the byteCnt should be %d", new Object[]{44}));
    L19:
        throw new IllegalArgumentException("the cStr part of input is illegal, should be like [...]");
    L21:
        throw new IllegalArgumentException("the input should contain ':' which is a sep");
    }

    public static Ciphertext fromHexStr(float[] r1, String r2) throws IllegalArgumentException {
        byte[] r3 = Utils.hexStringToByteArray(r2, 64);
        return new Ciphertext(Utils.convertFloatArrayToDoubleArray(r1), r3);
    }

    public static Ciphertext fromHexStr(double[] r1, String r2) throws IllegalArgumentException {
        return new Ciphertext(r1, Utils.hexStringToByteArray(r2, 64));
    }

    public static Ciphertext fromNAndNormHexStr(float[] r0, String r1) throws IllegalArgumentException {
        return fromNAndNormHexStr(Utils.convertFloatArrayToDoubleArray(r0), r1);
    }

    public static Ciphertext fromNAndNormHexStr(double[] r5, String r6) throws IllegalArgumentException {
        byte[] r7 = Utils.hexStringToByteArray(r6, 80);
        byte[] r1 = new byte[32];
        byte[] r3 = new byte[8];
        System.arraycopy(r7, 0, r1, 0, 32);
        System.arraycopy(r7, 32, r3, 0, 8);
        double r2 = Utils.byteToDouble(r3);
        return new Ciphertext(new ArrayRealVector(r5).mapMultiply(r2).toArray(), r1);
    }
}
