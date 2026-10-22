package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PackageInfoCompat {

    private static class Api28Impl {
        private Api28Impl() {
        }

        static boolean hasSigningCertificate(PackageManager r0, String r1, byte[] r2, int r3) {
            return r0.hasSigningCertificate(r1, r2, r3);
        }

        static boolean hasMultipleSigners(SigningInfo r0) {
            return r0.hasMultipleSigners();
        }

        static Signature[] getApkContentsSigners(SigningInfo r0) {
            return r0.getApkContentsSigners();
        }

        static Signature[] getSigningCertificateHistory(SigningInfo r0) {
            return r0.getSigningCertificateHistory();
        }

        static long getLongVersionCode(PackageInfo r2) {
            return r2.getLongVersionCode();
        }
    }

    public static long getLongVersionCode(PackageInfo r2) {
        return Api28Impl.getLongVersionCode(r2);
    }

    public static List<Signature> getSignatures(PackageManager r1, String r2) throws PackageManager.NameNotFoundException {
        SigningInfo r3 = r1.getPackageInfo(r2, 134217728).signingInfo;
        if (Api28Impl.hasMultipleSigners(r3) == false) goto L5;
        Signature[] r4 = Api28Impl.getApkContentsSigners(r3);
    L6:
        if (r4 != null) goto L10;
        return Collections.emptyList();
    L10:
        return Arrays.asList(r4);
    L5:
        r4 = Api28Impl.getSigningCertificateHistory(r3);
        goto L6
    }

    public static boolean hasSignatures(PackageManager r7, String r8, Map<byte[], Integer> r9, boolean r10) throws PackageManager.NameNotFoundException {
        if (r9.isEmpty() == false) goto L5;
        return false;
    L5:
        Set<byte[]> r0 = r9.keySet();
        Iterator<byte[]> r2 = r0.iterator();
    L7:
        if (r2.hasNext() == false) goto L22;
        byte[] r3 = r2.next();
        if (r3 == null) goto L21;
        Integer r4 = r9.get(r3);
        if (r4 == null) goto L19;
        int r6 = r4.intValue();
        if (r6 == 0) goto L7;
        if (r6 == 1) goto L7;
        throw new IllegalArgumentException("Unsupported certificate type " + r4 + " when verifying " + r8);
    L19:
        throw new IllegalArgumentException("Type must be specified for cert when verifying " + r8);
    L21:
        throw new IllegalArgumentException("Cert byte array cannot be null when verifying " + r8);
    L22:
        List<Signature> r5 = getSignatures(r7, r8);
        if (r10 == true) goto L32;
        Iterator<byte[]> r11 = r0.iterator();
    L26:
        if (r11.hasNext() == false) goto L30;
        byte[] r1 = r11.next();
        if (Api28Impl.hasSigningCertificate(r7, r8, r1, r9.get(r1).intValue()) == true) goto L26;
        return false;
    L30:
        return true;
    L32:
        if (r5.size() != 0) goto L34;
    L60:
        return false;
    L34:
        if (r9.size() > r5.size()) goto L60;
        if (r10 == false) goto L40;
        if (r9.size() != r5.size()) goto L60;
    L40:
        if (r9.containsValue(1) == false) goto L45;
        byte[][] r12 = new byte[r5.size()][];
        int r13 = 0;
    L43:
        if (r13 >= r5.size()) goto L46;
        r12[r13] = computeSHA256Digest(r5.get(r13).toByteArray());
        r13 = r13 + 1;
    L46:
        Iterator<byte[]> r14 = r0.iterator();
        if (r14.hasNext() == false) goto L60;
        byte[] r15 = r14.next();
        Integer r16 = r9.get(r15);
        int r17 = r16.intValue();
        if (r17 == 0) goto L57;
        if (r17 != 1) goto L55;
        if (byteArrayContains(r12, r15) == true) goto L59;
        return false;
    L59:
        return true;
    L55:
        throw new IllegalArgumentException("Unsupported certificate type " + r16);
    L57:
        if (r5.contains(new Signature(r15)) == true) goto L59;
        return false;
    L45:
        r12 = null;
        goto L46
    }

    private static boolean byteArrayContains(byte[][] r4, byte[] r5) {
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        if (Arrays.equals(r5, r4[r2]) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static byte[] computeSHA256Digest(byte[] r2) {
        return MessageDigest.getInstance("SHA256").digest(r2);
    L4:
        e = move-exception;
        throw new RuntimeException("Device doesn't support SHA256 cert checking", e);
    }

    private PackageInfoCompat() {
    }
}
