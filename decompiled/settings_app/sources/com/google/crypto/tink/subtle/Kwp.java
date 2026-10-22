package com.google.crypto.tink.subtle;

import com.google.crypto.tink.KeyWrap;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class Kwp implements KeyWrap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int MAX_WRAP_KEY_SIZE = 4096;
    static final int MIN_WRAP_KEY_SIZE = 16;
    static final byte[] PREFIX = null;
    static final int ROUNDS = 6;
    private final SecretKey aesKey;

    static {
        PREFIX = new byte[]{-90, 89, 89, -90};
    }

    public Kwp(final byte[] key) throws GeneralSecurityException {
        if (key.length != 16) goto L5;
    L9:
        this.aesKey = new SecretKeySpec(key, "AES");
        return;
    L5:
        if (key.length == 32) goto L9;
        throw new GeneralSecurityException("Unsupported key length");
    }

    private int wrappingSize(int inputSize) {
        return (inputSize + (7 - ((inputSize + 7) % 8))) + 8;
    }

    private byte[] computeW(final byte[] iv, final byte[] key) throws GeneralSecurityException {
        if (key.length <= 8) goto L22;
        if (key.length > 2147483631) goto L22;
        if (iv.length != 8) goto L22;
        int r0 = wrappingSize(key.length);
        byte[] r2 = new byte[r0];
        System.arraycopy(iv, 0, r2, 0, iv.length);
        System.arraycopy(key, 0, r2, 8, key.length);
        int r1 = (r0 / 8) - 1;
        Cipher r15 = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        r15.init(1, this.aesKey);
        byte[] r3 = new byte[16];
        System.arraycopy(r2, 0, r3, 0, 8);
        int r5 = 0;
    L10:
        if (r5 >= 6) goto L19;
        int r6 = 0;
    L12:
        if (r6 >= r1) goto L18;
        int r7 = r6 + 1;
        int r8 = r7 * 8;
        System.arraycopy(r2, r8, r3, 8, 8);
        r15.doFinal(r3, 0, 16, r3);
        int r9 = ((r5 * r1) + r6) + 1;
        int r10 = 0;
    L15:
        if (r10 >= 4) goto L17;
        int r11 = 7 - r10;
        r3[r11] = (byte) (r3[r11] ^ ((byte) (r9 & 255)));
        r9 = r9 >>> 8;
        r10 = r10 + 1;
        goto L15
    L17:
        System.arraycopy(r3, 8, r2, r8, 8);
        r6 = r7;
        goto L12
    L18:
        r5 = r5 + 1;
        goto L10
    L19:
        System.arraycopy(r3, 0, r2, 0, 8);
        return r2;
    L22:
        throw new GeneralSecurityException("computeW called with invalid parameters");
    }

    private byte[] invertW(final byte[] wrapped) throws GeneralSecurityException {
        if (wrapped.length < 24) goto L19;
        if ((wrapped.length % 8) != 0) goto L19;
        byte[] r14 = Arrays.copyOf(wrapped, wrapped.length);
        int r0 = (r14.length / 8) - 1;
        Cipher r2 = EngineFactory.CIPHER.getInstance("AES/ECB/NoPadding");
        r2.init(2, this.aesKey);
        byte[] r3 = new byte[16];
        System.arraycopy(r14, 0, r3, 0, 8);
        int r5 = 5;
    L7:
        if (r5 < 0) goto L16;
        int r6 = r0 - 1;
    L9:
        if (r6 < 0) goto L15;
        int r7 = (r6 + 1) * 8;
        System.arraycopy(r14, r7, r3, 8, 8);
        int r8 = ((r5 * r0) + r6) + 1;
        int r9 = 0;
    L12:
        if (r9 >= 4) goto L14;
        int r10 = 7 - r9;
        r3[r10] = (byte) (r3[r10] ^ ((byte) (r8 & 255)));
        r8 = r8 >>> 8;
        r9 = r9 + 1;
        goto L12
    L14:
        r2.doFinal(r3, 0, 16, r3);
        System.arraycopy(r3, 8, r14, r7, 8);
        r6 = r6 - 1;
        goto L9
    L15:
        r5 = r5 - 1;
        goto L7
    L16:
        System.arraycopy(r3, 0, r14, 0, 8);
        return r14;
    L19:
        throw new GeneralSecurityException("Incorrect data size");
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] wrap(final byte[] data) throws GeneralSecurityException {
        if (data.length < 16) goto L15;
        if (data.length > 4096) goto L13;
        byte[] r1 = new byte[8];
        byte[] r2 = PREFIX;
        int r4 = 0;
        System.arraycopy(r2, 0, r1, 0, r2.length);
    L8:
        if (r4 >= 4) goto L11;
        r1[r4 + 4] = (byte) ((data.length >> ((3 - r4) * 8)) & 255);
        r4 = r4 + 1;
        goto L8
    L11:
        return computeW(r1, data);
    L13:
        throw new GeneralSecurityException("Key size of key to wrap too large");
    L15:
        throw new GeneralSecurityException("Key size of key to wrap too small");
    }

    @Override // com.google.crypto.tink.KeyWrap
    public byte[] unwrap(final byte[] data) throws GeneralSecurityException {
        if (data.length < wrappingSize(16)) goto L39;
        if (data.length > wrappingSize(4096)) goto L37;
        if ((data.length % 8) != 0) goto L35;
        byte[] r7 = invertW(data);
        boolean r0 = true;
        boolean r2 = false;
        int r3 = 0;
    L9:
        int r4 = 4;
        if (r3 >= 4) goto L15;
        if (PREFIX[r3] == r7[r3]) goto L14;
        r0 = false;
    L14:
        r3 = r3 + 1;
        goto L9
    L15:
        int r5 = 0;
    L16:
        if (r4 >= 8) goto L19;
        r5 = (r5 << 8) + (r7[r4] & 255);
        r4 = r4 + 1;
        goto L16
    L19:
        if (wrappingSize(r5) != r7.length) goto L29;
        int r6 = r5 + 8;
    L23:
        if (r6 >= r7.length) goto L28;
        if (r7[r6] == 0) goto L27;
        r0 = false;
    L27:
        r6 = r6 + 1;
        goto L23
    L28:
        r2 = r0;
    L29:
        if (r2 == false) goto L33;
        return Arrays.copyOfRange(r7, 8, r5 + 8);
    L33:
        throw new BadPaddingException("Invalid padding");
    L35:
        throw new GeneralSecurityException("Wrapped key size must be a multiple of 8 bytes");
    L37:
        throw new GeneralSecurityException("Wrapped key size is too large");
    L39:
        throw new GeneralSecurityException("Wrapped key size is too small");
    }
}
