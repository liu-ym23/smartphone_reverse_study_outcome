package tmsdkobf;

import android.content.Context;
import android.content.pm.PackageManager;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: classes5.dex */
public abstract class je {
    public static String a(Context r2, String r3) {
        PackageManager r0 = r2.getPackageManager();     // Catch: Throwable -> L6
        ByteArrayInputStream r4 = new ByteArrayInputStream(r0.getPackageInfo(r0.getPackagesForUid(r2.getPackageManager().getApplicationInfo(r3, 0).uid)[0], 64).signatures[0].toByteArray());     // Catch: Throwable -> L6
        String r5 = k8.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(r4)).getEncoded());     // Catch: Throwable -> L12
    L17:
        r4.close();     // Catch: Throwable -> L11
    L10:
        return r5;
    L7:
        r5 = "";
        if (r4 == null) goto L10;
    L6:
        r4 = null;
        goto L7
    }

    public static List a(File r5) {
        ArrayList r0 = new ArrayList();
        JarFile r1 = new JarFile(r5);
        Certificate[] r6 = a(r1, r1.getJarEntry("AndroidManifest.xml"), new byte[8192]);     // Catch: Throwable -> L9 Exception -> L14
        if (r6 == null) goto L12;
        int r2 = r6.length;     // Catch: Throwable -> L9 Exception -> L14
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        r0.add(k8.a(r6[r3].getEncoded()));     // Catch: Throwable -> L9 Exception -> L14
        r3 = r3 + 1;
        goto L6
    L9:
        th = move-exception;
        r1.close();
        throw th;
    L12:
        r1.close();
        return r0;
    }

    public static Certificate[] a(JarFile r3, JarEntry r4, byte[] r5) {
        InputStream r0 = null;
        Certificate[] r1 = null;
        InputStream r6 = r3.getInputStream(r4);     // Catch: Throwable -> L13 IOException -> L17
    L33:
    L11:
        th = th;
        r0 = r6;
    L14:
        if (r0 != null) goto L29;
    L16:
        throw th;
    L29:
        r0.close();     // Catch: IOException -> L22
        goto L16
    L5:
        if (r6.read(r5, 0, r5.length) != (-1)) goto L33;
        if (r4 == null) goto L27;
        r1 = r4.getCertificates();     // Catch: Throwable -> L11 IOException -> L23
    L27:
        r6.close();     // Catch: IOException -> L21
    L10:
        return r1;
    L18:
        if (r6 != null) goto L25;
    L20:
        return null;
    L25:
        r6.close();     // Catch: IOException -> L24
    L17:
        r6 = null;
    L13:
        th = th;
        goto L14
    }
}
