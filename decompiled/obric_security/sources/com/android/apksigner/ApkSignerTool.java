package com.android.apksigner;

import com.android.apksig.ApkVerifier;
import com.android.apksig.apk.MinSdkVersionException;
import com.android.apksig.internal.apk.ISchemeSignerInfo;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ApkSignerTool {
    private static final int HASH_TYPE_ALL = 3;
    private static final int HASH_TYPE_M = 1;
    private static final int HASH_TYPE_SHA256 = 2;
    private static final MessageDigest hash1 = null;
    private static final MessageDigest hash2 = null;

    static {
        hash1 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L4
        hash2 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public ApkSignerTool() {
    }

    private static <T extends ISchemeSignerInfo> void formatSigners(List<T> r12, String r13, List<CertInfoObject> r14, int r15) {
        if (r12 != null) goto L4;
        return;
    L4:
        if (r12.size() <= 0) goto L42;
        Iterator<T> r16 = r12.iterator();
    L7:
        if (r16.hasNext() == false) goto L43;
        Iterator<X509Certificate> r0 = r16.next().getCertificates().iterator();
    L10:
        if (r0.hasNext() == false) goto L7;
        X509Certificate r1 = r0.next();
        String r4 = "";
        if (r15 == 1) goto L16;
        if (r15 == 3) goto L16;
        String r6 = "";
    L18:
        if (r15 == 2) goto L20;
        if (r15 == 3) goto L20;
    L21:
        String r7 = r4;
        Iterator<CertInfoObject> r2 = r14.iterator();
    L23:
        if (r2.hasNext() == false) goto L29;
        CertInfoObject r3 = r2.next();
        if (r3.getHash1().equals(r6) == false) goto L23;
        if (r3.getHash2().equals(r7) == false) goto L23;
        r3.setSignerVersion(r13);
        goto L10
    L29:
        CertInfoObject r5 = new CertInfoObject(r6, r7, r1.getNotBefore().getTime(), r1.getNotAfter().getTime());
        r5.setSignerVersion(r13);
        r14.add(r5);
    L20:
        r4 = getHash2(r1);
    L16:
        r6 = getHash1(r1);
        goto L18
    L43:
        return;
    }

    public static List<CertInfoObject> getCerts(String r6, int r7) throws Exception {
        ArrayList r0 = new ArrayList();
        if (r6 != null) goto L5;
    L17:
        return r0;
    L5:
        if (r6.trim().isEmpty() == true) goto L17;
        ApkVerifier r8 = new ApkVerifier.Builder(new File(r6)).build();
        long r1 = System.currentTimeMillis();
        ApkVerifier.Result r9 = r8.verify();     // Catch: MinSdkVersionException -> L14
        if (r9.isVerified() == false) goto L12;
        formatSigners(r9.getV3SchemeSigners(), "V3", r0, r7);
        formatSigners(r9.getV2SchemeSigners(), "V2", r0, r7);
        formatSigners(r9.getV31SchemeSigners(), "V3.1", r0, r7);
        formatSigners(r9.getV1SchemeSigners(), "V1", r0, r7);
    L12:
        System.out.println("Total time: " + (System.currentTimeMillis() - r1) + "ms");
        return r0;
    L14:
        e = move-exception;
        e.getMessage().endsWith(LibrarianImpl.Constants.DOT);
        throw new MinSdkVersionException("Failed to determine APK's minimum supported platform version. Use --min-sdk-version to override", e);
    }

    private static String getHash1(Certificate r1) {
        byte[] r2 = r1.getEncoded();     // Catch: Exception -> L4
        MessageDigest r0 = hash1;     // Catch: Exception -> L4
        r0.update(r2);     // Catch: Exception -> L4
        return toHexString(r0.digest());
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String getHash2(Certificate r1) {
        byte[] r2 = r1.getEncoded();     // Catch: Exception -> L4
        MessageDigest r0 = hash2;     // Catch: Exception -> L4
        r0.update(r2);     // Catch: Exception -> L4
        return toHexString(r0.digest());
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static void main(String[] r5) throws Exception {
        ArrayList r0 = new ArrayList();
        if (r5.length > 0) goto L5;
    L11:
        r0.add("D:\\git_code\\apksingerTool_justGetCert\\apks\\10a3af42101dd9cfbefdc9e9d76e83947968d838.apk");
    L12:
        Iterator r6 = r0.iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        String r1 = (String) r6.next();
        System.out.println("---------------------start=" + r1 + "-----------------------------");
        List r2 = new ArrayList();
        r2 = getCerts(r1, 3);     // Catch: Exception -> L18
    L20:
        Iterator r3 = r2.iterator();
    L22:
        if (r3.hasNext() == false) goto L24;
        System.out.println("" + ((CertInfoObject) r3.next()));
        goto L22
    L24:
        System.out.println("----------------------end----------------------------");
    L18:
        e = move-exception;
        e.printStackTrace();
        System.out.println(r1 + " error");
        goto L20
    L25:
        return;
    L5:
        if (r5[0].equals("-f") == false) goto L11;
        if (r5.length >= 2) goto L10;
        System.err.println("Error: Missing file path after -f");
        return;
    L10:
        r0.add(r5[1]);
        goto L12
    }

    private static String toHexString(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02X", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }
}
