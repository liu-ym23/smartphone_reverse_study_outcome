package adcpeJava.adcpe;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public final class SecureRandom extends Random implements Serializable {
    private static final long serialVersionUID = 3581829991155417889L;
    private transient MessageDigest digest;
    private int digest_out_size;
    private int remCount;
    private byte[] remainder;
    private byte[] state;

    public SecureRandom(byte[] r1) throws IllegalArgumentException, InternalError {
        if (r1 == null) goto L7;
        init(r1);
        return;
    L7:
        throw new IllegalArgumentException("the seed should be not null");
    }

    private void init(byte[] r2) throws InternalError {
        this.digest_out_size = 32;     // Catch: NoSuchAlgorithmException -> L6
        this.digest = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L6
        engineSetSeed(r2);
        return;
    L6:
        e = move-exception;
        throw new InternalError("internal error: SHA-256 is unavailable.", e);
    }

    private synchronized void engineSetSeed(byte[] r5) {
        monitor-enter(this);
        byte[] r0 = this.state;     // Catch: Throwable -> L12
        if (r0 == null) goto L9;
        this.digest.update(r0);     // Catch: Throwable -> L12
        int r1 = 0;
    L6:
        byte[] r2 = this.state;     // Catch: Throwable -> L12
        if (r1 >= r2.length) goto L9;
        r2[r1] = 0;     // Catch: Throwable -> L12
        r1 = r1 + 1;     // Catch: Throwable -> L12
    L9:
        this.state = this.digest.digest(r5);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void updateState(byte[] r7, byte[] r8) {
        int r4 = 1;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r2 >= r7.length) goto L10;
        byte r5 = r7[r2];
        int r6 = (r8[r2] + r5) + r4;
        byte r9 = (byte) r6;
        if (r5 == r9) goto L8;
        boolean r10 = true;
    L9:
        r3 = r3 | r10;
        r7[r2] = r9;
        r4 = r6 >> 8;
        r2 = r2 + 1;
        goto L4
    L8:
        r10 = false;
        goto L9
    L10:
        if (r3 == true) goto L16;
        r7[0] = (byte) (r7[0] + 1);
        return;
    }

    private synchronized void engineNextBytes(byte[] r8) {
        monitor-enter(this);
        byte[] r0 = this.remainder;     // Catch: Throwable -> L31
        if (this.state == null) goto L30;
        int r1 = this.remCount;     // Catch: Throwable -> L31
        if (r1 <= 0) goto L15;
        int r3 = r8.length - 0;     // Catch: Throwable -> L31
        int r4 = this.digest_out_size;     // Catch: Throwable -> L31
        if (r3 >= (r4 - r1)) goto L10;
        int r5 = r8.length - 0;     // Catch: Throwable -> L31
    L11:
        int r6 = 0;
    L12:
        if (r6 >= r5) goto L14;
        r8[r6] = r0[r1];     // Catch: Throwable -> L31
        r0[r1] = 0;     // Catch: Throwable -> L31
        r6 = r6 + 1;     // Catch: Throwable -> L31
        r1 = r1 + 1;     // Catch: Throwable -> L31
        goto L12
    L14:
        this.remCount += r5;     // Catch: Throwable -> L31
        int r7 = r5 + 0;     // Catch: Throwable -> L31
    L17:
        if (r7 >= r8.length) goto L26;
        r0 = this.state;     // Catch: Throwable -> L31
        this.digest.update(r0);     // Catch: Throwable -> L31
        byte[] r2 = this.digest.digest();     // Catch: Throwable -> L31
        this.state = r2;     // Catch: Throwable -> L31
        updateState(r2, r0);     // Catch: Throwable -> L31
        int r9 = r8.length - r7;     // Catch: Throwable -> L31
        int r10 = this.digest_out_size;     // Catch: Throwable -> L31
        if (r9 > r10) goto L22;
        r10 = r8.length - r7;     // Catch: Throwable -> L31
    L22:
        int r11 = 0;
    L23:
        if (r11 >= r10) goto L25;
        r8[r7] = r0[r11];     // Catch: Throwable -> L31
        r0[r11] = 0;     // Catch: Throwable -> L31
        r11 = r11 + 1;     // Catch: Throwable -> L31
        r7 = r7 + 1;     // Catch: Throwable -> L31
        goto L23
    L25:
        this.remCount += r10;     // Catch: Throwable -> L31
        goto L17
    L26:
        this.remainder = r0;     // Catch: Throwable -> L31
        this.remCount %= this.digest_out_size;     // Catch: Throwable -> L31
        monitor-exit(this);
        return;
    L10:
        r5 = r4 - r1;     // Catch: Throwable -> L31
        goto L11
    L15:
        r7 = 0;
        goto L17
    L30:
        throw new RuntimeException("there exists an error, because this.state is null");     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] r1) {
        engineNextBytes(r1);
    }

    @Override // java.util.Random
    protected int next(int r5) {
        int r0 = (r5 + 7) / 8;
        byte[] r1 = new byte[r0];
        nextBytes(r1);
        int r4 = 0;
        int r2 = 0;
    L3:
        if (r4 >= r0) goto L6;
        r2 = (r2 << 8) + (r1[r4] & 255);
        r4 = r4 + 1;
        goto L3
    L6:
        return r2 >>> ((r0 * 8) - r5);
    }
}
