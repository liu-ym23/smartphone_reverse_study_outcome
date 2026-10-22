package adcpeJava.adcpe;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class Decryptor {
    private final double approxFactor;
    private final SecretKey sk;

    public Decryptor(SecretKey r3) {
        this.sk = r3;
        this.approxFactor = 0.1d;
    }

    public Decryptor(SecretKey r1, double r2) {
        this.sk = r1;
        this.approxFactor = r2;
    }

    public double[] decrypt(Ciphertext r9) throws Exception {
        double[] r0 = r9.c();
        byte[] r4 = r9.nBytes();
        int r7 = r0.length;
        if (r7 != 0) goto L7;
        return new double[0];
    L7:
        if (r7 != this.sk.dim()) goto L17;
        RealVector r10 = new ArrayRealVector(r0);
        if (this.sk.getKeyType() != Constants.KeyType.KEY_VERSION_QR.ordinal()) goto L12;
        r10 = Utils.multiply(this.sk.orthogonalMatInv(), r10, this.sk.orthogonalMatDim(), r7);
    L15:
        return r10.subtract(Utils.computeLambdaM(this.sk.s(), this.sk.kBytes(), r4, this.approxFactor, r7)).mapDivide(this.sk.s()).toArray();
    L12:
        if (this.sk.getKeyType() != Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()) goto L15;
        r10 = r10.subtract(this.sk.houseHolderVector().mapMultiply(this.sk.houseHolderVector().dotProduct(r10) * 2.0d));
        goto L15
    L17:
        throw new RuntimeException(String.format("the length of cipher vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r7), Integer.valueOf(this.sk.dim())}));
    }
}
