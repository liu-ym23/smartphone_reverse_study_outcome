package adcpeJava.adcpe;

import java.security.MessageDigest;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

/* JADX INFO: loaded from: classes.dex */
public class Encryptor {
    private final double approxFactor;
    private final SecretKey sk;

    public Encryptor(SecretKey r3) {
        this.sk = r3;
        this.approxFactor = 0.1d;
    }

    public Encryptor(SecretKey r1, double r2) {
        this.sk = r1;
        this.approxFactor = r2;
    }

    Ciphertext encryptKernel(double[] r9, byte[] r10) throws Exception {
        RealVector r0 = Utils.computeLambdaM(this.sk.s(), this.sk.kBytes(), r10, this.approxFactor, r9.length);
        RealVector r11 = new ArrayRealVector(r9).mapMultiply(this.sk.s()).add(r0);
        if (this.sk.getKeyType() != Constants.KeyType.KEY_VERSION_QR.ordinal()) goto L6;
        r11 = Utils.multiply(this.sk.orthogonalMat(), r11, this.sk.orthogonalMatDim(), r11.getDimension());
    L9:
        return new Ciphertext(r11.toArray(), r10);
    L6:
        if (this.sk.getKeyType() != Constants.KeyType.KEY_VERSION_HOUSEHOLDER.ordinal()) goto L9;
        double r1 = this.sk.houseHolderVector().dotProduct(r11) * 2.0d;
        r11 = r11.subtract(this.sk.houseHolderVector().mapMultiply(r1));
        goto L9
    }

    public Ciphertext deterministicallyEncrypt(double[] r3) throws Exception {
        if (r3.length != this.sk.dim()) goto L7;
        byte[] r0 = Utils.doubleArrayToBytes(r3);
        MessageDigest r1 = MessageDigest.getInstance("SHA-256");
        r1.update(r0);
        return encryptKernel(r3, r1.digest());
    L7:
        throw new RuntimeException(String.format("the length of plain vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r3.length), Integer.valueOf(this.sk.dim())}));
    }

    public Ciphertext encrypt(double[] r3) throws Exception {
        if (r3.length != this.sk.dim()) goto L7;
        return encryptKernel(r3, Utils.generateRandomBytes(32));
    L7:
        throw new RuntimeException(String.format("the length of plain vector %d should be equal to the dim %d of sk", new Object[]{Integer.valueOf(r3.length), Integer.valueOf(this.sk.dim())}));
    }
}
