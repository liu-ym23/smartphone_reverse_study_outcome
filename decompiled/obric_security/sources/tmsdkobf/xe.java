package tmsdkobf;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes5.dex */
final class xe {
    private static final long f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Properties f620a;
    private Context b;
    boolean c;
    int d;
    int e;

    class a implements w6 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f621a;
        final /* synthetic */ xe b;

        a(xe r1, CountDownLatch r2) {
            this.b = r1;
            this.f621a = r2;
        }

        @Override // tmsdkobf.w6
        public void onFinish(int r1, int r2, int r3, int r4, JceStruct r5) {
            xe r6 = this.b;
            r6.d = r3;
            r6.e = r4;
            this.f621a.countDown();
        }
    }

    static {
        f = new GregorianCalendar(2040, 0, 1).getTimeInMillis() / 1000;
    }

    xe(Properties r2, Context r3) {
        this.c = false;
        this.d = 0;
        this.e = 0;
        this.f620a = r2;
        this.b = r3;
    }

    synchronized int a(jc r8) {
        monitor-enter(this);
        za r0 = ve.e();     // Catch: Throwable -> L18
        z0 r2 = new z0();     // Catch: Throwable -> L18
        String r1 = ve.b();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r1) == true) goto L10;
        CountDownLatch r6 = new CountDownLatch(1);     // Catch: Throwable -> L18
        r2.f650a = r1;     // Catch: Throwable -> L18
        r2.b = a(this.b.getPackageName());     // Catch: Throwable -> L18
        r0.a(1309, r2, r8, 2, new a(this, r6));     // Catch: Throwable -> L18
        r6.await();     // Catch: InterruptedException -> L8 Throwable -> L18
    L11:
        int r9 = this.e;     // Catch: Throwable -> L18
        if (r9 == 0) goto L15;
        monitor-exit(this);
        return r9;
    L15:
        int r10 = this.d;     // Catch: Throwable -> L18
        monitor-exit(this);
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        goto L11
    L10:
        new RuntimeException("Unknown licence! Please contact TMS(Tencent Mobile Secure) group.");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public String b() {
        return this.f620a.getProperty("lc_sdk_channel");
    }

    public long c() {
        return Long.parseLong(this.f620a.getProperty("expiry.seconds", String.valueOf(-1)));
    }

    public long d() {
        return f;
    }

    public boolean a() {
        if (this.c == false) goto L5;
        return true;
    L5:
        String r0 = a(this.b.getPackageName());
        if (r0 != null) goto L8;
        return true;
    L8:
        String r1 = this.f620a.getProperty("signature").toUpperCase().trim();
        this.c = r0.equals(r1);
        q8.c("DEBUG", "your    signature is " + r0 + " len:" + r0.length());
        q8.c("DEBUG", "licence signature is " + r1 + " len:" + r1.length());
        return this.c;
    }

    private String a(String r3) {
        String r1 = null;
        PackageInfo r2 = this.b.getPackageManager().getPackageInfo(r3, 64);     // Catch: Exception -> L5
    L7:
        if (r2 == null) goto L18;
        ByteArrayInputStream r4 = new ByteArrayInputStream(r2.signatures[0].toByteArray());
        r1 = x8.b(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(r4)).getEncoded());     // Catch: Throwable -> L11
        r4.close();     // Catch: Throwable -> L11
        return r1;
    L11:
        e = move-exception;
        e.printStackTrace();
        return r1;
    L18:
        return null;
    L5:
        e = move-exception;
        e.printStackTrace();
        r2 = null;
        goto L7
    }
}
