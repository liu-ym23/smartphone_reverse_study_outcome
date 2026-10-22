package tmsdkobf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public abstract class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f271a = null;
    public static final String b = null;

    static {
        f271a = p.a("mpdc_").append(n0.f360a).append("_").append(1).toString();
        b = p.a("mpdc_r_").append(n0.f360a).append("_").append(1).toString();
    }

    public static String a(Context r17) {
        String r1 = r17.getPackageName();
        if (TextUtils.isEmpty(r1) == false) goto L66;
        return null;
    L66:
        PackageInfo r0 = r17.getPackageManager().getPackageInfo(r1, 64);     // Catch: Throwable -> L54
        if (r0 != null) goto L9;
        return null;
    L9:
        ApplicationInfo r3 = r0.applicationInfo;
        if (r3 == null) goto L53;
        if (TextUtils.isEmpty(r3.sourceDir) == true) goto L53;
        String r4 = r3.sourceDir;
        File r5 = new File(r4);
        int r6 = r3.flags;
        long r7 = -1;
        long r8 = r5.length();     // Catch: Throwable -> L17
    L58:
        r7 = r5.lastModified() / 1000;     // Catch: Throwable -> L56
    L19:
        String r9 = r0.versionName;
        if (r9 != null) goto L22;
        r9 = "";
    L22:
        int r11 = r0.versionCode;
        long r12 = r0.firstInstallTime;
        long r14 = r0.lastUpdateTime;
        Signature[] r2 = r0.signatures;
        if (r2 != null) goto L25;
    L40:
        String r10 = "";
    L42:
        if (TextUtils.isEmpty(r10) == false) goto L51;
        ArrayList r13 = (ArrayList) je.a(new File(r4));     // Catch: Throwable -> L57
        if (r13.size() <= 0) goto L51;
        String r15 = (String) r13.get(0);     // Catch: Throwable -> L57
        if (r15 != null) goto L48;
        String r16 = "";
    L49:
        r10 = r16;
        goto L51
    L48:
        r16 = r15;
    L51:
        return r8 + ":" + r10 + ":" + r1 + ":" + r9 + ":" + r11 + ":" + r12 + ":" + r14 + ":" + r6 + ":" + r7;
    L25:
        if (r2.length <= 0) goto L40;
        ByteArrayInputStream r18 = new ByteArrayInputStream(r2[0].toByteArray());     // Catch: Throwable -> L32
        r10 = k8.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(r18)).getEncoded());     // Catch: Throwable -> L30
    L36:
        j.a(r18);
    L30:
        th = th;
        ByteArrayInputStream r19 = r18;
    L68:
        th.printStackTrace();     // Catch: Throwable -> L37
        r10 = "";
        r18 = r19;
    L37:
        th = move-exception;
        j.a(r19);
        throw th;
    L32:
        th = th;
        r19 = null;
    L17:
        r8 = -1;
    L53:
        return null;
    L55:
        return null;
    }

    public static synchronized String a(Context r12, String r13) {
        monitor-enter(id.class);
        String r1 = a(r12);     // Catch: Throwable -> L85
        if (r1 == null) goto L7;
        byte[] r2 = r1.getBytes();     // Catch: Throwable -> L85
        FileLock r3 = null;
        MessageDigest r4 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L13 Throwable -> L85
        r4.update(r2);     // Catch: NoSuchAlgorithmException -> L13 Throwable -> L85
        byte[] r5 = r4.digest();     // Catch: NoSuchAlgorithmException -> L13 Throwable -> L85
    L14:
        String r6 = z1.a(r5);     // Catch: Throwable -> L85
        File r7 = r12.getDir("turingfd", 0);     // Catch: Throwable -> L85
        if (r7 != null) goto L17;
        File r8 = null;
    L18:
        if (r8 != null) goto L21;
    L19:
        String r9 = null;
    L49:
        if (r9 != null) goto L54;
        monitor-exit(id.class);
        return "";
    L54:
        if (TextUtils.equals(r9, r6) == true) goto L56;
        File r14 = r12.getDir("turingfd", 0);     // Catch: Throwable -> L85
        if (r14 != null) goto L61;
        File r10 = null;
    L62:
        if (r10 != null) goto L105;
    L83:
        monitor-exit(id.class);
        return r1;
    L105:
        RandomAccessFile r15 = new RandomAccessFile(r10, "rw");     // Catch: Throwable -> L77
        FileChannel r16 = r15.getChannel();     // Catch: Throwable -> L76
        r3 = r16.lock();     // Catch: Throwable -> L89
        byte[] r11 = r6.getBytes();     // Catch: Throwable -> L89
        ByteBuffer r17 = ByteBuffer.allocate(r11.length);     // Catch: Throwable -> L89
        r17.put(r11);     // Catch: Throwable -> L89
        r17.flip();     // Catch: Throwable -> L89
    L68:
        if (r17.hasRemaining() == false) goto L70;
        r16.write(r17);     // Catch: Throwable -> L89
        goto L68
    L70:
        r16.truncate(r11.length);     // Catch: Throwable -> L89
        if (r3 != null) goto L73;
    L75:
        j.a(r16);     // Catch: Throwable -> L85
        j.a(r15);     // Catch: Throwable -> L85
        goto L83
    L73:
        if (r3.isValid() == false) goto L75;
        r3.release();     // Catch: IOException -> L88 Throwable -> L85
    L78:
        if (r3 != null) goto L80;
    L82:
        j.a(r16);     // Catch: Throwable -> L85
        j.a(r15);     // Catch: Throwable -> L85
        goto L83
    L80:
        if (r3.isValid() == false) goto L82;
        r3.release();     // Catch: IOException -> L90 Throwable -> L85
    L76:
        r16 = null;
    L77:
        r15 = null;
        r16 = null;
        goto L78
    L61:
        r10 = new File(r14, r13);     // Catch: Throwable -> L85
        goto L62
    L56:
        monitor-exit(id.class);
        return "";
    L21:
        if (r8.exists() == true) goto L24;
        r9 = "";
        goto L49
    L24:
        if (r8.isFile() == true) goto L26;
        xj.a(r8);     // Catch: Throwable -> L85
        r9 = "";
        goto L49
    L26:
        ByteArrayOutputStream r18 = new ByteArrayOutputStream();     // Catch: Throwable -> L85
        RandomAccessFile r19 = new RandomAccessFile(r8, "rw");     // Catch: Throwable -> L43
        FileChannel r20 = r19.getChannel();     // Catch: Throwable -> L42
        FileLock r21 = r20.lock();     // Catch: Throwable -> L41
        ByteBuffer r22 = ByteBuffer.allocate(32);     // Catch: Throwable -> L92
    L32:
        int r110 = r20.read(r22);     // Catch: Throwable -> L92
        if (r110 <= 0) goto L35;
        r18.write(r22.array(), 0, r110);     // Catch: Throwable -> L92
        goto L32
    L35:
        String r23 = r18.toString();     // Catch: Throwable -> L92
        if (r21 != null) goto L38;
    L40:
        j.a(r20);     // Catch: Throwable -> L85
        j.a(r19);     // Catch: Throwable -> L85
        j.a(r18);     // Catch: Throwable -> L85
        r9 = r23;
        goto L49
    L38:
        if (r21.isValid() == false) goto L40;
        r21.release();     // Catch: IOException -> L91 Throwable -> L85
    L44:
        if (r21 != null) goto L46;
    L48:
        j.a(r20);     // Catch: Throwable -> L85
        j.a(r19);     // Catch: Throwable -> L85
        j.a(r18);     // Catch: Throwable -> L85
        goto L19
    L46:
        if (r21.isValid() == false) goto L48;
        r21.release();     // Catch: IOException -> L93 Throwable -> L85
    L41:
        r21 = null;
    L42:
        r20 = null;
        r21 = null;
    L43:
        r20 = null;
        r19 = null;
        r21 = null;
        goto L44
    L17:
        r8 = new File(r7, r13);     // Catch: Throwable -> L85
    L13:
        r5 = null;
        goto L14
    L7:
        monitor-exit(id.class);
        return "";
    L85:
        th = move-exception;
        throw th;
    }
}
