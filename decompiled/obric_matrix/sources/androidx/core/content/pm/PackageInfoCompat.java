package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class PackageInfoCompat {

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        @Nullable
        @DoNotInline
        static Signature[] getApkContentsSigners(@NonNull SigningInfo r0) {
            return r0.getApkContentsSigners();
        }

        @DoNotInline
        static long getLongVersionCode(PackageInfo r2) {
            return r2.getLongVersionCode();
        }

        @Nullable
        @DoNotInline
        static Signature[] getSigningCertificateHistory(@NonNull SigningInfo r0) {
            return r0.getSigningCertificateHistory();
        }

        @DoNotInline
        static boolean hasMultipleSigners(@NonNull SigningInfo r0) {
            return r0.hasMultipleSigners();
        }

        @DoNotInline
        static boolean hasSigningCertificate(@NonNull PackageManager r0, @NonNull String r1, @NonNull byte[] r2, int r3) {
            return r0.hasSigningCertificate(r1, r2, r3);
        }
    }

    private PackageInfoCompat() {
    }

    private static boolean byteArrayContains(@NonNull byte[][] r4, @NonNull byte[] r5) {
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

    public static long getLongVersionCode(@NonNull PackageInfo r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getLongVersionCode(r2);
    L7:
        return r2.versionCode;
    }

    @NonNull
    public static List<Signature> getSignatures(@NonNull PackageManager r2, @NonNull String r3) {
        if (Build.VERSION.SDK_INT < 28) goto L8;
        SigningInfo r4 = r2.getPackageInfo(r3, 134217728).signingInfo;
        if (Api28Impl.hasMultipleSigners(r4) == false) goto L7;
        Signature[] r5 = Api28Impl.getApkContentsSigners(r4);
    L9:
        if (r5 != null) goto L13;
        return Collections.emptyList();
    L13:
        return Arrays.asList(r5);
    L7:
        r5 = Api28Impl.getSigningCertificateHistory(r4);
        goto L9
    L8:
        r5 = r2.getPackageInfo(r3, 64).signatures;
        goto L9
    }

    public static boolean hasSignatures(@NonNull PackageManager r7, @NonNull String r8, @NonNull @Size(min = 1) Map<byte[], Integer> r9, boolean r10) {
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
        if (r10 == true) goto L34;
        if (Build.VERSION.SDK_INT < 28) goto L34;
        Iterator<byte[]> r11 = r0.iterator();
    L28:
        if (r11.hasNext() == false) goto L32;
        byte[] r1 = r11.next();
        if (Api28Impl.hasSigningCertificate(r7, r8, r1, r9.get(r1).intValue()) == true) goto L28;
        return false;
    L32:
        return true;
    L34:
        if (r5.size() != 0) goto L36;
    L61:
        return false;
    L36:
        if (r9.size() > r5.size()) goto L61;
        if (r10 == true) goto L39;
    L41:
        byte[][] r12 = null;
        if (r9.containsValue(1) == false) goto L47;
        r12 = new byte[r5.size()][];
        int r13 = 0;
    L45:
        if (r13 >= r5.size()) goto L47;
        r12[r13] = computeSHA256Digest(r5.get(r13).toByteArray());
        r13 = r13 + 1;
    L47:
        Iterator<byte[]> r14 = r0.iterator();
        if (r14.hasNext() == false) goto L61;
        byte[] r15 = r14.next();
        Integer r16 = r9.get(r15);
        int r17 = r16.intValue();
        if (r17 == 0) goto L58;
        if (r17 != 1) goto L56;
        if (byteArrayContains(r12, r15) == true) goto L60;
        return false;
    L60:
        return true;
    L56:
        throw new IllegalArgumentException("Unsupported certificate type " + r16);
    L58:
        if (r5.contains(new Signature(r15)) == true) goto L60;
        return false;
    L39:
        if (r9.size() == r5.size()) goto L41;
        goto L41
    }
}
