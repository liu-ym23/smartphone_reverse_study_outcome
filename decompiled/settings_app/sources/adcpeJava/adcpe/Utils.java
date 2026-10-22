package adcpeJava.adcpe;

import com.google.crypto.tink.subtle.Random;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    static boolean isHexChar(char r2) {
        if (r2 < '0') goto L8;
        if (r2 > '9') goto L8;
        return true;
    L8:
        if (r2 < 'A') goto L13;
        if (r2 > 'F') goto L13;
        return true;
    L13:
        if (r2 >= 'a') goto L15;
        return false;
    L15:
        if (r2 > 'f') goto L19;
        return true;
    L19:
        return false;
    }

    public Utils() {
    }

    public static double[] normalizeVector(double[] r3) {
        ArrayRealVector r0 = new ArrayRealVector(r3);
        return r0.mapDivide(r0.getNorm()).toArray();
    }

    static double getMaxAbsoluteValue(RealVector r6) {
        double r0 = 0.0d;
        int r2 = 0;
    L4:
        if (r2 >= r6.getDimension()) goto L9;
        double r3 = Math.abs(r6.getEntry(r2));
        if (r3 <= r0) goto L8;
        r0 = r3;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        return r0;
    }

    public static double maxDiff(double[] r2, double[] r3) {
        if (r2.length == r3.length) goto L7;
        return 1.0d;
    L7:
        return getMaxAbsoluteValue(new ArrayRealVector(r2).subtract(new ArrayRealVector(r3)));
    }

    static int byteToShort(byte[] r3) throws IllegalArgumentException {
        if (r3.length == 2) goto L5;
        wrongInputLengthError("inBytes", 2, r3.length);
    L5:
        ByteBuffer r4 = ByteBuffer.wrap(r3);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        return r4.getShort(0);
    }

    static double byteToDouble(byte[] r3) throws IllegalArgumentException {
        if (r3.length == 8) goto L5;
        wrongInputLengthError("inBytes", 8, r3.length);
    L5:
        ByteBuffer r4 = ByteBuffer.wrap(r3);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        return r4.getDouble(0);
    }

    static byte[] doubleToBytes(double r2) {
        ByteBuffer r0 = ByteBuffer.allocate(8);
        r0.order(ByteOrder.LITTLE_ENDIAN);
        r0.putDouble(r2);
        return r0.array();
    }

    static byte[] doubleArrayToBytes(double[] r7) {
        byte[] r0 = new byte[r7.length * 8];
        int r3 = 0;
    L4:
        if (r3 >= r7.length) goto L6;
        ByteBuffer r4 = ByteBuffer.allocate(8);
        r4.order(ByteOrder.LITTLE_ENDIAN);
        r4.putDouble(r7[r3]);
        System.arraycopy(r4.array(), 0, r0, r3 * 8, 8);
        r3 = r3 + 1;
        goto L4
    L6:
        return r0;
    }

    static float[] convertDoubleArrayToFloatArray(double[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        float[] r0 = new float[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = (float) r4[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static double[] convertFloatArrayToDoubleArray(float[] r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        double[] r0 = new double[r4.length];
        int r1 = 0;
    L7:
        if (r1 >= r4.length) goto L9;
        r0[r1] = r4[r1];
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    static void wrongInputLengthError(String r2, int r3, int r4) throws IllegalArgumentException {
        throw new IllegalArgumentException(String.format("the wanted length of %s is %d, not %d", new Object[]{r2, Integer.valueOf(r3), Integer.valueOf(r4)}));
    }

    static String convertDoubleArrayToString(double[] r7) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r7.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L7;
        r0.append(String.format("%.10f", new Object[]{Double.valueOf(r7[r3])})).append(",");
        r3 = r3 + 1;
        goto L4
    L7:
        if (r0.length() <= 0) goto L10;
        r0.setLength(r0.length() - 1);
    L10:
        return r0.toString();
    }

    public static double[] convertStringToDoubleArray(String r4) throws NumberFormatException {
        String[] r5 = r4.replaceAll("[\\[\\]]", "").split(",");
        double[] r0 = new double[r5.length];
        int r1 = 0;
    L4:
        if (r1 >= r5.length) goto L6;
        r0[r1] = Double.parseDouble(r5[r1].trim());
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    static byte[] hexStringToByteArray(String r8, int r9) throws IllegalArgumentException {
        int r0 = r8.length();
        if (r0 != r9) goto L15;
        byte[] r10 = new byte[r0 / 2];
        int r3 = 0;
    L5:
        if (r3 >= r0) goto L13;
        if (isHexChar(r8.charAt(r3)) == false) goto L12;
        int r4 = r3 + 1;
        if (isHexChar(r8.charAt(r4)) == false) goto L12;
        r10[r3 / 2] = (byte) ((Character.digit(r8.charAt(r3), 16) << 4) + Character.digit(r8.charAt(r4), 16));
        r3 = r3 + 2;
    L12:
        throw new IllegalArgumentException(String.format("each character in %s should be a valid hexadecimal character", new Object[]{r8}));
    L13:
        return r10;
    L15:
        throw new IllegalArgumentException(String.format("the size of string s should be equal to %d", new Object[]{Integer.valueOf(r9)}));
    }

    static String byteArrayToHexString(byte[] r6) {
        Formatter r1 = new Formatter(new StringBuilder());
        int r0 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1.format("%02x", new Object[]{Byte.valueOf(r6[r3])});
        r3 = r3 + 1;
        goto L3
    L5:
        String r7 = r1.toString();
        r1.close();
        return r7;
    }

    static byte[] generateRandomBytes(int r0) {
        return Random.randBytes(r0);
    }

    static double generateRandomDouble(byte[] r3) throws IllegalArgumentException {
        int r0 = r3.length;
        if (r0 == 16) goto L6;
        wrongInputLengthError("seed", 16, r0);
    L6:
        return new SecureRandom(r3).nextDouble();
    }

    static double[] generateNormalVec(byte[] r4, int r5) throws IllegalArgumentException {
        int r0 = r4.length;
        if (r0 == 16) goto L5;
        wrongInputLengthError("seed", 16, r0);
    L5:
        SecureRandom r1 = new SecureRandom(r4);
        double[] r6 = new double[r5];
        int r2 = 0;
    L6:
        if (r2 >= r5) goto L8;
        r6[r2] = r1.nextGaussian();
        r2 = r2 + 1;
        goto L6
    L8:
        return r6;
    }

    static RealVector multiply(RealMatrix r2, RealVector r3, int r4, int r5) throws Exception {
        if (r4 != r5) goto L11;
        return r2.operate(r3);
    L11:
        RealVector r1 = r3.getSubVector(0, r4);     // Catch: Exception -> L8
        return r2.operate(r1).append(r3.getSubVector(r4, r5 - r4));
    L8:
        e = move-exception;
        throw new Exception(String.format("there exists an error %s in multiply function", new Object[]{e.getMessage()}));
    }

    static RealVector computeLambdaM(double r4, byte[] r6, byte[] r7, double r8, int r10) throws Exception {
        MessageDigest r0 = MessageDigest.getInstance("SHA-256");
        r0.update(r6);
        r0.update(r7);
        byte[] r9 = r0.digest();
        if (r9.length != 32) goto L7;
        byte[] r1 = new byte[16];
        byte[] r2 = new byte[16];
        System.arraycopy(r9, 0, r1, 0, 16);
        System.arraycopy(r9, 16, r2, 0, 16);
        double[] r11 = generateNormalVec(r1, r10);
        double r3 = (Constants.GAMMA * (r4 * r8)) * Math.pow(generateRandomDouble(r2), 1.0d / ((double) r10));
        ArrayRealVector r5 = new ArrayRealVector(r11);
        return r5.mapMultiply(r3 / r5.getNorm());
    L7:
        throw new RuntimeException(String.format("the hash output byte cnt should equal to %d", new Object[]{32}));
    }

    static int getKeyType(int r3) {
        HashMap r0 = new HashMap();
        r0.put(Integer.valueOf(Constants.AlgoVersion.NOT_SUPPORTED), Integer.valueOf(Constants.KeyType.NOT_SUPPORTED.ordinal()));
        r0.put(Integer.valueOf(Constants.AlgoVersion.ALGO_VERSION_1Dot0Dot011), Integer.valueOf(Constants.KeyType.KEY_VERSION_QR.ordinal()));
        r0.put(Integer.valueOf(Constants.AlgoVersion.ALGO_VERSION_1Dot0Dot012), Integer.valueOf(Constants.KeyType.KEY_VERSION_NO_MAT.ordinal()));
        r0.put(Integer.valueOf(Constants.AlgoVersion.ALGO_VERSION_1Dot0Dot016), Integer.valueOf(Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()));
        r0.put(Integer.valueOf(Constants.AlgoVersion.ALGO_VERSION_1Dot0Dot017), Integer.valueOf(Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()));
        if (r0.containsKey(Integer.valueOf(r3)) == false) goto L7;
        return ((Integer) r0.get(Integer.valueOf(r3))).intValue();
    L7:
        return Constants.KeyType.NOT_SUPPORTED.ordinal();
    }
}
