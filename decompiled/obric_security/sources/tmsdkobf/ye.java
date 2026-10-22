package tmsdkobf;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;
import java.util.Properties;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.security.cert.X509Certificate;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public final class ye {
    private static volatile ye d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n4 f640a;
    private Calendar b;
    private xe c;

    static {
    }

    private ye() {
        this.b = Calendar.getInstance();
        f();
    }

    public static synchronized ye d() {
        monitor-enter(ye.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (d != null) goto L7;
        d = new ye();     // Catch: Throwable -> L10
    L7:
        ye r1 = d;     // Catch: Throwable -> L10
        monitor-exit(ye.class);
        return r1;
    }

    private void f() {
        int r1 = 0;
    L45:
        byte[] r2 = a(r1);     // Catch: RuntimeException -> L35
        if (r2 == null) goto L34;
        RSAPublicKey r3 = (RSAPublicKey) X509Certificate.getInstance(z.a("LS0tLS1CRUdJTiBDRVJUSUZJQ0FURS0tLS0tCk1JSUM5ekNDQWQ4Q0NRRGlsbUFjTWxiczVEQU5C\nZ2txaGtpRzl3MEJBUVVGQURCK01Rc3dDUVlEVlFRR0V3SkQKVGpFTE1Ba0dBMVVFQ0JNQ1IwUXhD\nekFKQmdOVkJBY1RBa2RhTVJJd0VBWURWUVFLRkFsMFpXTUlibU5sYm5ReApDekFKQmdOVkJBc1RB\nak5ITVE0d0RBWURWUVFERXdWdlltRnRZVEVrTUNJR0NTcUdTSWIzRFFFSkFSWVZiMkpoCmJXRjZa\nVzVuUUhSbGJtTmxiblF1WTI5dE1CNFhEVEV4TVRFeE5qRXhNVGN4TjFvWERURXlNREl5TkRFeE1U\nY3gKTjFvd2dZQXhDekFKQmdOVkJBWVRBa05PTVFzd0NRWURWUVFJRXdKSFJERUxNQWtHQTFVRUJ4\nTUNSMW94RURBTwpCZ05WQkFvVEIzUmxibU5sYm5ReEN6QUpCZ05WQkFzVEFqTkhNUkl3RUFZRFZR\nUURFd2x2WW1GdFlYcGxibWN4CkpEQWlCZ2txaGtpRzl3MEJDUUVXRlc5aVlXMWhlbVZ1WjBCMFpX\nNWpaVzUwTG1OdmJUQ0JuekFOQmdrcWhraUcKOXcwQkFRRUZBQU9CalFBd2dZa0NnWUVBd1kvV3FI\nV2NlRERkSm16anI3TlpSeS9qTllwS1NzVzExZngxaTIrQwpxTUE3NTJXb1d1bDZuSTB1MGZkWitk\nUzVUandRNkU0Qm13dXduVTVnQmJYK1VzQ2VHRHZaQVhQc045UEVWYnZTCkcvR25YclQrcTI2VUpP\nNHcrd3VNdmk5YWxkZHhhbkNKeXJ2ZWQ2NUdvMXhXUEErWGNHaVQxMndubjZtUHhyMnUKcVEwQ0F3\nRUFBVEFOQmdrcWhraUc5dzBCQVFVRkFBT0NBUUVBblpzV3FpSmV5SC9sT0prSWN6L2ZidDN3MXFL\nRApGTXJ5cFVHVFN6Z3NONWNaMW9yOGlvVG5ENGRLaDdJN2ttbDRpcGNvMDF0enc2MGhLYUtwNG9G\nMnYrMEs2NGZDCnBEMG9EUlkrOGoyK2RsMmNxeHBsT0FYdDc1RWFKNW40MG1DZDdTN0VBS0d2Z2Na\naVhyV0Z1eUtCL2QvNTh3Qm4KOEFGUVJhTnBySXNOSHpxMkMwL0JXR1pTSnJicmhOWExFY0ZtL0Ru\nTG14ZEVNYWxPSXhnSkhGcEFOS2tadXBzdgo0L0lDVFhSL0RJaURjbXJjbDFkNkc2VmgyaUcwaS9v\nRDBHQnBMZlFPcEF0Vmx6Y2lxZnBsTkphcnpRUTZUVXRyCm5GRmVNVDNDc2t5VGJwYnp1R2dDdUxj\nQVR3cnRQd1BOOWZzQXYrSjRJZm0rZUNVVDVnZlorMSsyNHc9PQotLS0tLUVORCBDRVJUSUZJQ0FU\nRS0tLS0tCg==\n".getBytes(), 0)).getPublicKey();     // Catch: Throwable -> L7
        byte[] r5 = new byte[128];     // Catch: Throwable -> L7
        System.arraycopy(r2, 0, r5, 0, 128);     // Catch: Throwable -> L7
        Cipher r6 = Cipher.getInstance("RSA/ECB/PKCS1Padding");     // Catch: Throwable -> L7
        r6.init(2, r3);     // Catch: Throwable -> L7
        byte[] r4 = r6.doFinal(r5);     // Catch: Throwable -> L7
        int r7 = r2.length - 128;     // Catch: Throwable -> L7
        byte[] r8 = new byte[r7];     // Catch: Throwable -> L7
        System.arraycopy(r2, 128, r8, 0, r7);     // Catch: Throwable -> L7
        SecretKey r9 = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(r4));     // Catch: Throwable -> L7
        Cipher r10 = Cipher.getInstance(new String("DES/ECB/NoPadding".getBytes(), StandardCharsets.UTF_8));     // Catch: Throwable -> L7
        r10.init(2, r9);     // Catch: Throwable -> L7
        byte[] r11 = r10.doFinal(r8);     // Catch: Throwable -> L7
    L9:
        if (r11 == null) goto L27;
        ByteArrayInputStream r12 = new ByteArrayInputStream(r11);
        Properties r13 = new Properties();
        r13.load(r12);     // Catch: Throwable -> L17 IOException -> L19
    L43:
        r12.close();     // Catch: IOException -> L15
    L23:
        xe r14 = new xe(r13, TMSDKContext.getApplicaionContext());
        this.c = r14;
        if (r14.a() == false) goto L27;
        g();
        this.b.setTimeInMillis(System.currentTimeMillis());
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    L19:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r12.close();     // Catch: IOException -> L30
    L32:
        throw th;
    L30:
        e = move-exception;
        e.printStackTrace();
    L27:
        r1 = r1 + 1;
    L7:
        th = move-exception;
        th.printStackTrace();
        r11 = null;
        goto L9
    L34:
        throw new RuntimeException("Certification file is missing! Please contact TMS(Tencent Mobile Secure) group.");
    L36:
        throw new RuntimeException("loadLicence Invaild LicenceFile! Please contact TMS(Tencent Mobile Secure) group.");
    }

    private final void g() {
        String r0 = new h9("licence").a("expiry.2019.enc_seconds", null);
        boolean r4 = false;
        if (TextUtils.isEmpty(r0) == true) goto L5;
        long r1 = Long.parseLong(new String(z.a(r0.getBytes(), 0)), 16);
    L7:
        if (r1 != (-1)) goto L11;
        r1 = this.c.c();
        if (r1 != (-1)) goto L11;
        r1 = this.c.d();
        r4 = true;
    L11:
        Calendar r2 = Calendar.getInstance();
        r2.setTimeInMillis(1000 * r1);
        r2.add(6, 1);
        Calendar r3 = Calendar.getInstance();
        r3.setTimeInMillis(System.currentTimeMillis());
        boolean r5 = r3.after(r2);
        if (r4 == false) goto L19;
        if (r5 == false) goto L19;
        if (TMSDKContext.isInitialized() == false) goto L19;
        if (TMSDKContext.isAbroad() == true) goto L19;
        this.b.setTimeInMillis(System.currentTimeMillis());
        b();
    L19:
        q8.a("LicMan", "expirySeconds=" + r1 + "(" + r2.get(1) + "-" + (r2.get(2) + 1) + "-" + r2.get(5) + ") expired=" + r5);
        this.f640a = new n4(r5);
        return;
    L5:
        r1 = -1;
        goto L7
    }

    public final boolean a() {
        return this.c.a();
    }

    public boolean b() {
        jc r0 = new jc();
        if (this.c.a(r0) != 0) goto L13;
        int r1 = r0.f287a;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L8;
        a(r0.c);
    L11:
        boolean r3 = true;
    L15:
        return !r3;
    L8:
        if (r1 == 2) goto L11;
    L12:
        a(r0.c);
        r3 = false;
    L13:
        r3 = e();
        goto L15
    }

    public String c() {
        return this.c.b();
    }

    public boolean e() {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(System.currentTimeMillis());
        if (r0.get(1) == this.b.get(1)) goto L5;
    L6:
        g();
    L7:
        this.b.setTimeInMillis(System.currentTimeMillis());
        return this.f640a.a();
    L5:
        if (r0.get(6) == this.b.get(6)) goto L7;
        goto L6
    }

    private byte[] a(int r5) {
        InputStream r1 = null;
        Context r2 = TMSDKContext.getCurrentContext();     // Catch: Throwable -> L16 IOException -> L18
        if (r2 != null) goto L6;
        r2 = TMSDKContext.getApplicaionContext();     // Catch: Throwable -> L16 IOException -> L18
    L6:
        AssetManager r3 = r2.getAssets();     // Catch: Throwable -> L16 IOException -> L18
        if (r5 != 0) goto L9;
        String r6 = "licence.conf";
    L10:
        q8.c("TMSLicenceManager", "loadLicence: " + r6);     // Catch: Throwable -> L16 IOException -> L18
        r1 = r3.open(r6);     // Catch: Throwable -> L16 IOException -> L18
        byte[] r4 = new byte[r1.available()];     // Catch: Throwable -> L16 IOException -> L18
        r1.read(r4);     // Catch: Throwable -> L16 IOException -> L18
    L31:
        r1.close();     // Catch: IOException -> L13
    L15:
        return r4;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L9:
        r6 = "licence" + r5 + ".conf";     // Catch: Throwable -> L16 IOException -> L18
    L16:
        th = move-exception;
        if (r1 != null) goto L29;
    L26:
        throw th;
    L29:
        r1.close();     // Catch: IOException -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
    L18:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L16
    }

    public void a(String r5) {
        n1.a(new Class[]{ye.class});
        new h9("licence").a("expiry.2019.enc_seconds", z.c(r5.getBytes(), 0), true);
        g();
    }
}
