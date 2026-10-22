package com.google.crypto.tink.aead.internal;

import android.bluetooth.client.pbap.BluetoothPbapClient;
import com.google.crypto.tink.subtle.Bytes;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class Poly1305 {
    public static final int MAC_KEY_SIZE_IN_BYTES = 32;
    public static final int MAC_TAG_SIZE_IN_BYTES = 16;

    private Poly1305() {
    }

    private static long load32(byte[] in, int idx) {
        int r0 = ((in[idx] & 255) | ((in[idx + 1] & 255) << 8)) | ((in[idx + 2] & 255) << 16);
        return ((long) (((in[idx + 3] & 255) << 24) | r0)) & 4294967295L;
    }

    private static long load26(byte[] in, int idx, int shift) {
        return (load32(in, idx) >> shift) & 67108863;
    }

    private static void toByteArray(byte[] output, long num, int idx) {
        int r0 = 0;
    L4:
        if (r0 >= 4) goto L6;
        output[idx + r0] = (byte) (255 & num);
        r0 = r0 + 1;
        num = num >> 8;
        goto L4
    }

    private static void copyBlockSize(byte[] output, byte[] in, int idx) {
        int r0 = Math.min(16, in.length - idx);
        System.arraycopy(in, idx, output, 0, r0);
        output[r0] = 1;
        if (r0 == 16) goto L6;
        Arrays.fill(output, r0 + 1, output.length, (byte) 0);
        return;
    }

    public static byte[] computeMac(final byte[] key, byte[] data) {
        if (key.length != 32) goto L11;
        int r2 = 0;
        long r4 = load26(key, 0, 0) & 67108863;
        int r8 = 3;
        long r10 = load26(key, 3, 2) & 67108611;
        long r14 = load26(key, 6, 4) & 67092735;
        long r17 = load26(key, 9, 6) & 66076671;
        long r21 = load26(key, 12, 8) & 1048575;
        long r25 = r10 * 5;
        long r27 = r14 * 5;
        long r29 = r17 * 5;
        long r31 = r21 * 5;
        byte[] r6 = new byte[17];
        long r33 = 0;
        int r7 = 0;
        long r35 = 0;
        long r37 = 0;
        long r39 = 0;
        long r41 = 0;
    L6:
        if (r7 >= data.length) goto L8;
        copyBlockSize(r6, data, r7);
        long r42 = r41 + load26(r6, r2, r2);
        long r34 = r33 + load26(r6, r8, 2);
        long r36 = r35 + load26(r6, 6, 4);
        long r38 = r37 + load26(r6, 9, 6);
        long r310 = r39 + (load26(r6, 12, 8) | ((long) (r6[16] << 24)));
        long r3 = ((((r42 * r4) + (r34 * r31)) + (r36 * r29)) + (r38 * r27)) + (r310 * r25);
        long r45 = ((((r42 * r10) + (r34 * r4)) + (r36 * r31)) + (r38 * r29)) + (r310 * r27);
        long r47 = ((((r42 * r14) + (r34 * r10)) + (r36 * r4)) + (r38 * r31)) + (r310 * r29);
        long r49 = ((((r42 * r17) + (r34 * r14)) + (r36 * r10)) + (r38 * r4)) + (r310 * r31);
        long r43 = ((((r42 * r21) + (r34 * r17)) + (r36 * r14)) + (r38 * r10)) + (r310 * r4);
        long r46 = r45 + (r3 >> 26);
        long r48 = r47 + (r46 >> 26);
        long r410 = r49 + (r48 >> 26);
        long r44 = r43 + (r410 >> 26);
        long r5 = (r3 & 67108863) + ((r44 >> 26) * 5);
        r33 = (r46 & 67108863) + (r5 >> 26);
        r7 = r7 + 16;
        r35 = r48 & 67108863;
        r37 = r410 & 67108863;
        r39 = r44 & 67108863;
        r8 = 3;
        r41 = r5 & 67108863;
        r2 = 0;
        goto L6
    L8:
        long r311 = r35 + (r33 >> 26);
        long r9 = r311 & 67108863;
        long r312 = r37 + (r311 >> 26);
        long r11 = r312 & 67108863;
        long r313 = r39 + (r312 >> 26);
        long r15 = r313 & 67108863;
        long r411 = r41 + ((r313 >> 26) * 5);
        long r18 = r411 & 67108863;
        long r12 = (r33 & 67108863) + (r411 >> 26);
        long r23 = r18 + 5;
        long r22 = r23 & 67108863;
        long r1 = (r23 >> 26) + r12;
        long r24 = r9 + (r1 >> 26);
        long r26 = r11 + (r24 >> 26);
        long r28 = (r15 + (r26 >> 26)) - BluetoothPbapClient.VCARD_ATTR_CLASS;
        long r13 = r28 >> 63;
        long r19 = r18 & r13;
        long r16 = r12 & r13;
        long r20 = r9 & r13;
        long r30 = r11 & r13;
        long r110 = r15 & r13;
        long r111 = ~r13;
        long r32 = ((r1 & 67108863) & r111) | r16;
        long r40 = ((r24 & 67108863) & r111) | r20;
        long r50 = ((r26 & 67108863) & r111) | r30;
        long r51 = (r28 & r111) | r110;
        long r112 = ((r19 | (r22 & r111)) | (r32 << 26)) & 4294967295L;
        long r52 = ((r32 >> 6) | (r40 << 20)) & 4294967295L;
        long r53 = ((r40 >> 12) | (r50 << 14)) & 4294967295L;
        long r54 = ((r50 >> 18) | (r51 << 8)) & 4294967295L;
        long r113 = r112 + load32(key, 16);
        long r55 = r113 & 4294967295L;
        long r56 = (r52 + load32(key, 20)) + (r113 >> 32);
        long r114 = r56 & 4294967295L;
        long r57 = (r53 + load32(key, 24)) + (r56 >> 32);
        long r58 = r57 & 4294967295L;
        long r59 = ((r54 + load32(key, 28)) + (r57 >> 32)) & 4294967295L;
        byte[] r0 = new byte[16];
        toByteArray(r0, r55, 0);
        toByteArray(r0, r114, 4);
        toByteArray(r0, r58, 8);
        toByteArray(r0, r59, 12);
        return r0;
    L11:
        throw new IllegalArgumentException("The key length in bytes must be 32.");
    }

    public static void verifyMac(final byte[] key, byte[] data, byte[] mac) throws GeneralSecurityException {
        if (Bytes.equal(computeMac(key, data), mac) == false) goto L6;
        return;
    L6:
        throw new GeneralSecurityException("invalid MAC");
    }
}
