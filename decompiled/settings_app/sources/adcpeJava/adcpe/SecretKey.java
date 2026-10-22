package adcpeJava.adcpe;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class SecretKey {
    private final int dim;
    private final RealVector houseHolderVector;
    private final byte[] kBytes;
    private final int keyType;
    private final RealMatrix orthogonalMat;
    private final int orthogonalMatDim;
    private final RealMatrix orthogonalMatInv;
    private final double s;

    SecretKey(int r1, double r2, byte[] r4, SecureRandom r5, int r6) {
        this.dim = r1;
        this.s = r2;
        this.kBytes = r4;
        this.keyType = r6;
        if (r6 != Constants.KeyType.KEY_VERSION_NO_MAT.ordinal()) goto L6;
        this.orthogonalMatDim = 0;
        this.houseHolderVector = null;
        this.orthogonalMat = null;
        this.orthogonalMatInv = null;
        return;
    L6:
        if (r6 == Constants.KeyType.KEY_VERSION_QR.ordinal()) goto L8;
        this.orthogonalMat = null;
        this.orthogonalMatInv = null;
        this.orthogonalMatDim = r1;
        this.houseHolderVector = genHouseHolderVector(r1, r5);
        return;
    L8:
        if (r1 <= 512) goto L10;
        r1 = 512;
    L10:
        this.orthogonalMatDim = r1;
        this.houseHolderVector = null;
        RealMatrix r3 = genOrthogonalMat(r1, r5);
        this.orthogonalMat = r3;
        this.orthogonalMatInv = r3.transpose();
    }

    int dim() {
        return this.dim;
    }

    double s() {
        return this.s;
    }

    int getKeyType() {
        return this.keyType;
    }

    byte[] kBytes() {
        return this.kBytes;
    }

    RealVector houseHolderVector() {
        return this.houseHolderVector;
    }

    RealMatrix orthogonalMat() {
        return this.orthogonalMat;
    }

    int orthogonalMatDim() {
        return this.orthogonalMatDim;
    }

    RealMatrix orthogonalMatInv() {
        return this.orthogonalMatInv;
    }

    static RealMatrix genOrthogonalMat(int r8, SecureRandom r9) {
        RealMatrix r0 = MatrixUtils.createRealIdentityMatrix(r8);
        RealMatrix r1 = MatrixUtils.createRealIdentityMatrix(r8);
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r8) goto L8;
        int r4 = 0;
    L5:
        if (r4 >= r8) goto L7;
        r1.setEntry(r3, r4, r9.nextDouble());
        r4 = r4 + 1;
        goto L5
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        int r5 = 0;
    L10:
        if (r5 >= 10000) goto L14;
        r0 = new QRDecomposition(r1).getQ();     // Catch: Exception -> L13
    L13:
        r1.setEntry(((r5 / r8) + 1) % r8, r5 % r8, r9.nextDouble());
        r5 = r5 + 1;
    L14:
        int r10 = r8 - 1;
        if (r0.getEntry(0, r10) <= 0.0d) goto L18;
    L16:
        if (r2 >= r8) goto L18;
        r0.setEntry(r2, r10, r0.getEntry(r2, r10) * (-1.0d));
        r2 = r2 + 1;
    L18:
        return r0;
    }

    static RealVector genHouseHolderVector(int r6, SecureRandom r7) {
        ArrayRealVector r0 = new ArrayRealVector(r6);
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L5;
        r0.setEntry(r2, r7.nextDouble());
        r2 = r2 + 1;
        goto L3
    L5:
        r0.setEntry(0, r0.getEntry(0) + (Math.signum(r0.getEntry(0)) * r0.getNorm()));
        r0.mapDivideToSelf(r0.getNorm());
        return r0;
    }

    public static SecretKey fromSeed(String r1, int r2) throws IllegalArgumentException {
        return fromSeed(r1, r2, Constants.AlgoVersion.ALGO_VERSION_1Dot0Dot017);
    }

    public static SecretKey fromSeed(String r11, int r12, int r13) throws IllegalArgumentException {
        if (r12 == 0) goto L17;
        if (r11.length() < 32) goto L15;
        int r10 = Utils.getKeyType(r13);
        if (r10 == Constants.KeyType.NOT_SUPPORTED.ordinal()) goto L13;
        byte[] r14 = r11.getBytes();
        byte[] r0 = new byte[2];
        System.arraycopy(r14, 0, r0, 0, 2);
        double r1 = Utils.byteToShort(r0) + 1048576;
        if (r10 != Constants.KeyType.KEY_VERSION_NO_MAT.ordinal()) goto L10;
        r1 = r1 * (-1.0d);
    L10:
        double r6 = r1;
        int r2 = r14.length - 2;
        byte[] r8 = new byte[r2];
        System.arraycopy(r14, 2, r8, 0, r2);
        return new SecretKey(r12, r6, r8, new SecureRandom(r14), r10);
    L13:
        throw new IllegalArgumentException(String.format("the algoVersion is illegal %d", new Object[]{Integer.valueOf(r13)}));
    L15:
        throw new IllegalArgumentException(String.format("the len(seed) should be not less than %d", new Object[]{32}));
    L17:
        throw new IllegalArgumentException("parameter dim should be not 0");
    }
}
