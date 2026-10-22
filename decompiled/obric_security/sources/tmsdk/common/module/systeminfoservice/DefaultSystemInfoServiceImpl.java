package tmsdk.common.module.systeminfoservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import tmsdk.common.TMSDKContext;
import tmsdk.common.creator.BaseManagerC;
import tmsdkobf.b3;
import tmsdkobf.gf;
import tmsdkobf.m;
import tmsdkobf.n;
import tmsdkobf.q8;
import tmsdkobf.x8;

/* JADX INFO: loaded from: classes5.dex */
public final class DefaultSystemInfoServiceImpl extends BaseManagerC implements gf {
    private PackageManager b;
    private Context c;
    private CertificateFactory d;

    public DefaultSystemInfoServiceImpl() {
        this.b = null;
        this.c = null;
        this.d = null;
    }

    private void a(PackageInfo r3, m r4) {
        if (r3 == null) goto L18;
        Signature[] r5 = r3.signatures;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.length < 1) goto L21;
        X509Certificate r2 = (X509Certificate) a(r5[0]);
        if (r2 == null) goto L20;
        String r6 = x8.b(r2.getEncoded());     // Catch: CertificateEncodingException -> L12
    L14:
        r4.a(11, r6);
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        r6 = null;
        goto L14
    L20:
        return;
    L21:
        return;
    }

    private int b(int r1) {
        if ((r1 & 16) == 0) goto L5;
        int r0 = 64;
    L7:
        if ((r1 & 32) != 0) goto L9;
        return r0;
    L9:
        return r0 | 4096;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // tmsdkobf.gf
    public NetworkInfo getActiveNetworkInfo() {
        return ((ConnectivityManager) this.c.getSystemService("connectivity")).getActiveNetworkInfo();
    L4:
        e = move-exception;
        q8.e("getActiveNetworkInfo", " getActiveNetworkInfo NullPointerException--- \n" + e.getMessage());
        return null;
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(String r3, int r4) {
        m r0 = new m();
        r0.a(1, r3);
        return getAppInfo(r0, r4);
    }

    public int getAppVersionStatus(String r2, int r3) {
        PackageInfo r1 = getPackageInfo(r2, 0);
        if (r1 != null) goto L6;
        return -1;
    L6:
        int r4 = r1.versionCode;
        if (r3 != r4) goto L9;
        return 0;
    L9:
        if (r3 >= r4) goto L15;
        if (r3 != 0) goto L13;
        return -2;
    L13:
        return 2;
    L15:
        return 1;
    }

    public synchronized ApplicationInfo getApplicationInfo(String r2, int r3) {
        monitor-enter(this);
        ApplicationInfo r4 = this.b.getApplicationInfo(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L7:
        return null;
    }

    @Override // tmsdkobf.gf
    public ArrayList<m> getInstalledApp(int r6, int r7) {
        List<PackageInfo> r0 = this.b.getInstalledPackages(b(r6));     // Catch: Exception -> L4
    L6:
        ArrayList<m> r1 = new ArrayList();
        if (r0 == null) goto L21;
        Iterator<PackageInfo> r2 = r0.iterator();
    L10:
        if (r2.hasNext() == false) goto L21;
        PackageInfo r3 = r2.next();
        if ((r3.applicationInfo.flags & 1) == 0) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L17;
        if (r7 == 1) goto L10;
    L17:
        if (r4 == false) goto L20;
        if (r7 == 0) goto L10;
    L20:
        m r5 = new m();
        a(r3, r5, r6);
        r1.add(r5);
        goto L10
    L14:
        r4 = false;
    L21:
        return r1;
    L4:
        e = move-exception;
        e.printStackTrace();
        r0 = null;
        goto L6
    }

    public synchronized PackageInfo getPackageInfo(String r2, int r3) {
        monitor-enter(this);
        PackageInfo r4 = this.b.getPackageInfo(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L7:
        return null;
    }

    public PackageStats getPackageSizeInfo(String r1) {
        return null;
    }

    public String installApp(boolean r1, String r2, Activity r3, int r4) {
        return null;
    }

    @Override // tmsdkobf.gf
    public boolean isPackageInstalled(String r2) {
        if (getPackageInfo(r2, 0) == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r1) {
        this.c = r1;
        this.b = r1.getPackageManager();
        this.d = CertificateFactory.getInstance("X.509");     // Catch: CertificateException -> L5
        return;
    }

    public List<ResolveInfo> queryBroadcastReceivers(Intent r1, int r2) {
        return this.b.queryBroadcastReceivers(r1, r2);
    }

    public List<ResolveInfo> queryIntentActivities(Intent r1, int r2) {
        return this.b.queryIntentActivities(r1, r2);
    }

    public List<ResolveInfo> queryIntentServices(Intent r1, int r2) {
        return this.b.queryIntentServices(r1, r2);
    }

    private void a(ApplicationInfo r8, m r9, int r10) {
        if (r8 == null) goto L63;
        if (r9 != null) goto L6;
        return;
    L6:
        if ((r10 & 32) == 0) goto L9;
        r9.a(14, r8.permission);
    L9:
        if ((r10 & 16384) != 0) goto L61;
    L15:
        boolean r1 = false;
        if ((r10 & 1) == 0) goto L35;
        if (TextUtils.isEmpty(r9.k()) == false) goto L21;
        r9.a(1, r8.packageName);
    L21:
        if (TextUtils.isEmpty(r9.b()) == false) goto L30;
        CharSequence r0 = n.a(this.b, r9.k());
        if (TextUtils.isEmpty(r0) == false) goto L27;
        r0 = (String) r8.nonLocalizedLabel;
        if (TextUtils.isEmpty(r0) == false) goto L27;
        r0 = r8.loadLabel(this.b);
    L27:
        r9.a(3, r0);
    L30:
        if ((r8.flags & 1) == 0) goto L32;
        boolean r2 = true;
    L33:
        r9.a(4, Boolean.valueOf(r2));
        r9.a(2, Integer.valueOf(r8.uid));
        goto L35
    L32:
        r2 = false;
    L35:
        if ((r10 & 2) == 0) goto L42;
        r9.a(1, r8.packageName);
        if ((r8.flags & 1) == 0) goto L39;
        boolean r3 = true;
    L40:
        r9.a(4, Boolean.valueOf(r3));
        r9.a(2, Integer.valueOf(r8.uid));
        goto L42
    L39:
        r3 = false;
    L42:
        if (b3.c() == false) goto L47;
        if ((r10 & 4) == 0) goto L47;
        r9.a(6, r8.loadIcon(this.b));
    L47:
        if ((r10 & 8) == 0) goto L52;
        if (TextUtils.isEmpty(r8.sourceDir) == true) goto L52;
        File r7 = new File(r8.sourceDir);
        r9.a(9, Long.valueOf(r7.length()));
        r9.a(10, Long.valueOf(r7.lastModified()));
    L52:
        if ((r10 & 64) == 0) goto L55;
        r9.a(15, r8.sourceDir);
        r9.a(16, Boolean.FALSE);
    L55:
        if ((r10 & 8192) != 0) goto L57;
        return;
    L57:
        if ((r8.flags & 262144) == 0) goto L59;
        r1 = true;
    L59:
        r9.a(17, Boolean.valueOf(r1));
        return;
    L61:
        PackageInfo r4 = ((Context) Objects.requireNonNull(TMSDKContext.getApplicaionContext())).getPackageManager().getPackageInfo(r8.packageName, 128);     // Catch: Throwable -> L12
    L13:
        if (r4 == null) goto L15;
        r9.a(r4.firstInstallTime);
        r9.d(r4.lastUpdateTime);
        r9.a(7, r4.versionName);
        r9.a(8, Integer.valueOf(r4.versionCode));
    L12:
        r4 = null;
        goto L13
    }

    @Override // tmsdkobf.gf
    public m getAppInfo(m r3, int r4) {
        ApplicationInfo r0 = getApplicationInfo((String) r3.a(1), b(r4));
        if (r0 == null) goto L6;
        a(r0, r3, r4);
        return r3;
    L6:
        return null;
    }

    private void a(PackageInfo r8, m r9, int r10) {
        if (r8 == null) goto L55;
        if (r9 != null) goto L6;
        return;
    L6:
        if ((r10 & 16) == 0) goto L9;
        a(r8, r9);
    L9:
        if ((r10 & 32) == 0) goto L11;
        r9.a(14, r8.requestedPermissions);
    L11:
        ApplicationInfo r0 = r8.applicationInfo;
        if (r0 != null) goto L14;
        return;
    L14:
        int r2 = -1;
        boolean r3 = false;
        if ((r10 & 1) == 0) goto L26;
        r9.a(1, r0.packageName);
        r9.a(3, this.b.getApplicationLabel(r8.applicationInfo).toString());
        if ((r8.applicationInfo.flags & 1) == 0) goto L19;
        boolean r1 = true;
    L20:
        r9.a(4, Boolean.valueOf(r1));
        ApplicationInfo r4 = r8.applicationInfo;
        if (r4 == null) goto L23;
        int r5 = r4.uid;
    L24:
        r9.a(2, Integer.valueOf(r5));
        goto L26
    L23:
        r5 = -1;
        goto L24
    L19:
        r1 = false;
    L26:
        if ((r10 & 2) == 0) goto L36;
        r9.a(1, r8.applicationInfo.packageName);
        if ((r8.applicationInfo.flags & 1) == 0) goto L30;
        boolean r6 = true;
    L31:
        r9.a(4, Boolean.valueOf(r6));
        ApplicationInfo r7 = r8.applicationInfo;
        if (r7 == null) goto L34;
        r2 = r7.uid;
    L34:
        r9.a(2, Integer.valueOf(r2));
        goto L36
    L30:
        r6 = false;
    L36:
        if ((r10 & 4) == 0) goto L39;
        r9.a(6, r8.applicationInfo.loadIcon(this.b));
    L39:
        if ((r10 & 8) == 0) goto L44;
        if (TextUtils.isEmpty(r8.applicationInfo.sourceDir) == true) goto L44;
        r9.a(7, r8.versionName);
        r9.a(8, Integer.valueOf(r8.versionCode));
        File r11 = new File(r8.applicationInfo.sourceDir);
        r9.a(9, Long.valueOf(r11.length()));
        r9.a(10, Long.valueOf(r11.lastModified()));
    L44:
        if ((r10 & 64) == 0) goto L47;
        r9.a(15, r8.applicationInfo.sourceDir);
        r9.a(16, Boolean.FALSE);
    L47:
        if ((r10 & 8192) == 0) goto L56;
        ApplicationInfo r12 = r8.applicationInfo;
        if (r12 != null) goto L51;
        return;
    L51:
        if ((r12.flags & 262144) == 0) goto L53;
        r3 = true;
    L53:
        r9.a(17, Boolean.valueOf(r3));
        return;
    L56:
        return;
    }

    private Certificate a(Signature r3) {
        ByteArrayInputStream r0 = new ByteArrayInputStream(r3.toByteArray());
        X509Certificate r2 = (X509Certificate) this.d.generateCertificate(r0);     // Catch: Throwable -> L8 Exception -> L10 CertificateException -> L12
        r0.close();     // Catch: IOException -> L6
    L19:
        return r2;
    L6:
        IOException e = e;
    L18:
        e.printStackTrace();
        goto L19
    L8:
        th = move-exception;
        r0.close();     // Catch: IOException -> L22
    L24:
        throw th;
    L22:
        e = move-exception;
        e.printStackTrace();
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
    L27:
        r0.close();     // Catch: IOException -> L16
        return null;
    L16:
        e = move-exception;
        e = e;
        r2 = null;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L27
    }
}
