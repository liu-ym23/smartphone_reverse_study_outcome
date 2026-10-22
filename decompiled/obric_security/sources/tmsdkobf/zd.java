package tmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.android.apksigner.CertInfoObject;
import java.io.ByteArrayInputStream;
import java.security.MessageDigest;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.SdkSettingUpdate;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f663a = null;

    static {
        f663a = new byte[]{77, 68, 53};
    }

    private static String a(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02x", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString().toUpperCase();
    }

    private static String b(byte[] r3) {
        if (r3 != null) goto L8;
        return null;
    L8:
        return a(MessageDigest.getInstance(new String(f663a)).digest(r3));
    L7:
        return null;
    }

    private static String c(byte[] r2) {
        if (r2 != null) goto L8;
        return null;
    L8:
        return a(MessageDigest.getInstance("SHA-256").digest(r2));
    L7:
        return null;
    }

    private static X509Certificate d(byte[] r3) {
        if (r3 != null) goto L8;
        return null;
    L8:
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(r3));
    L7:
        return null;
    }

    private static void a(List r5, int r6, Signature[] r7, Signature[] r8) {
        if (r5 != null) goto L4;
        return;
    L4:
        Vector r0 = new Vector();
        int r1 = 0;
        if (r7 == null) goto L12;
        int r2 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        Signature r4 = r7[r3];
        if (r4 == null) goto L11;
        a(r5, r4, r0, r6);
    L11:
        r3 = r3 + 1;
    L12:
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L26;
        Signature r10 = r8[r1];
        if (r10 == null) goto L18;
        a(r5, r10, r0, r6);
    L18:
        r1 = r1 + 1;
        goto L14
    L26:
        return;
    }

    private static void a(List r9, Signature r10, Vector r11, int r12) {
        if (r9 == null) goto L27;
        if (r10 == null) goto L28;
        if (r11 == null) goto L32;
        byte[] r13 = r10.toByteArray();
        X509Certificate r0 = d(r13);
        String r1 = "";
        if (r0 == null) goto L9;
        String r2 = r0.getSerialNumber().toString();
    L11:
        if (TextUtils.isEmpty(r2) == false) goto L13;
        return;
    L13:
        if (r11.contains(r2) == true) goto L30;
        if (r0 == null) goto L31;
        r11.add(r2);
        if (r12 != SdkSettingUpdate.VirusCloudType.ONLY_MD_5.getValue()) goto L19;
        String r3 = b(r13);
        String r4 = "";
    L25:
        r9.add(new CertInfoObject(r3, r4, r0.getNotBefore().getTime(), r0.getNotAfter().getTime()));
        return;
    L19:
        if (r12 != SdkSettingUpdate.VirusCloudType.ONLY_SHA256.getValue()) goto L22;
    L20:
        r4 = c(r13);
        r3 = r1;
        goto L25
    L22:
        if (r12 != SdkSettingUpdate.VirusCloudType.BOTH_HASH.getValue()) goto L24;
        r1 = b(r13);
        goto L20
    L24:
        r3 = "";
        r4 = r3;
        goto L25
    L31:
        return;
    L30:
        return;
    L9:
        r2 = "";
        goto L11
    L32:
        return;
    L28:
        return;
    }

    public static List a(m r2, int r3) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Context r1 = TMSDKContext.getApplicaionContext();
        if (r1 != null) goto L14;
        return r0;
    L14:
        PackageInfo r4 = a(r2, r1);     // Catch: Throwable -> L13
        if (r4 != null) goto L11;
        return r0;
    L11:
        a(r0, r3, r4.signingInfo.getApkContentsSigners(), r4.signingInfo.getSigningCertificateHistory());     // Catch: Throwable -> L13
    L12:
        return r0;
    }

    private static PackageInfo a(m r3, Context r4) {
        if (r4 != null) goto L13;
        return null;
    L13:
        PackageManager r5 = r4.getPackageManager();     // Catch: Throwable -> L10
        if (r3.r() == false) goto L9;
        return r5.getPackageArchiveInfo(r3.a(), 134217728);
    L9:
        return r5.getPackageInfo(r3.k(), 134217728);
    L10:
        th = move-exception;
        q8.b("SignUtil", th);
        return null;
    }
}
