package tmsdkobf;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import kotlin.UByte;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f359a = null;

    static {
        f359a = new byte[]{77, 68, 53};
    }

    public static m a(boolean r1, String r2) {
        return a(r1, r2, null);
    }

    public static m a(boolean r7, String r8, m r9) {
        q8.c("AppEntityUtil", "getAppInfo isApk = " + r7 + ", apkKey = " + r8);
        if (TextUtils.isEmpty(r8) == false) goto L21;
        return null;
    L21:
        PackageManager r2 = TMSDKContext.getApplicaionContext().getPackageManager();     // Catch: Throwable -> L18
        if (r7 == false) goto L15;
        PackageInfo r5 = r2.getPackageArchiveInfo(r8, 0);     // Catch: Throwable -> L18
        if (r5 == null) goto L13;
        q8.c("AppEntityUtil", "packageManager.getPackageArchiveInfo, pkgInfo.packageName = " + r5.packageName);     // Catch: Throwable -> L18
        if (r5.applicationInfo == null) goto L12;
        q8.c("AppEntityUtil", "packageManager.getPackageArchiveInfo, pkgInfo.applicationInfo.name = " + r5.applicationInfo.name);     // Catch: Throwable -> L18
        ApplicationInfo r0 = r5.applicationInfo;     // Catch: Throwable -> L18
        r0.sourceDir = r8;     // Catch: Throwable -> L18
        r0.publicSourceDir = r8;     // Catch: Throwable -> L18
    L16:
        return a(r2, r5, r7, r9);
    L12:
        String r10 = "packageManager.getPackageArchiveInfo, pkgInfo.applicationInfo is null";
    L14:
        q8.c("AppEntityUtil", r10);     // Catch: Throwable -> L18
        goto L16
    L13:
        r10 = "packageManager.getPackageArchiveInfo, pkgInfo is null";
        goto L14
    L15:
        r5 = r2.getPackageInfo(r8, 0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        q8.e("AppEntityUtil", th.getMessage());
        return null;
    }

    public static m a() {
        m r0 = new m();
        PackageInfo r1 = TMSDKContext.getApplicaionContext().getPackageManager().getPackageInfo(TMSDKContext.getApplicaionContext().getPackageName(), 64);     // Catch: PackageManager.NameNotFoundException -> L19
        r0.h(r1.applicationInfo.packageName);     // Catch: PackageManager.NameNotFoundException -> L19
        File r3 = new File(r1.applicationInfo.sourceDir);     // Catch: PackageManager.NameNotFoundException -> L19
        if (r3.exists() == false) goto L6;
        r0.c(r3.length());     // Catch: PackageManager.NameNotFoundException -> L19
    L6:
        byte[] r2 = r1.signatures[0].toByteArray();
        MessageDigest r4 = MessageDigest.getInstance(new String(f359a));     // Catch: NoSuchAlgorithmException -> L16
        if (r4 == null) goto L15;
        byte[] r5 = r4.digest(r2);     // Catch: NoSuchAlgorithmException -> L16
        StringBuilder r6 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L16
        int r7 = r5.length;     // Catch: NoSuchAlgorithmException -> L16
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L14;
        r6.append(Integer.toHexString((r5[r8] & UByte.MAX_VALUE) | 256).substring(1, 3).toUpperCase());     // Catch: NoSuchAlgorithmException -> L16
        r6.append(":");     // Catch: NoSuchAlgorithmException -> L16
        r8 = r8 + 1;     // Catch: NoSuchAlgorithmException -> L16
        goto L12
    L14:
        r0.e(r6.substring(0, r6.length() - 1));     // Catch: NoSuchAlgorithmException -> L16
    L15:
        return r0;
    L16:
        e = move-exception;
        throw new RuntimeException(e);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static String a(PackageManager r3, String r4) {
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: Throwable -> L17
        r0.addCategory("android.intent.category.LAUNCHER");     // Catch: Throwable -> L17
        r0.setPackage(r4);     // Catch: Throwable -> L17
        Iterator<ResolveInfo> r1 = r3.queryIntentActivities(r0, 0).iterator();     // Catch: Throwable -> L17
    L4:
        if (r1.hasNext() == false) goto L30;
        ResolveInfo r2 = r1.next();     // Catch: Throwable -> L17
        if (r2 == null) goto L4;
        ActivityInfo r5 = r2.activityInfo;     // Catch: Throwable -> L17
        if (r5 == null) goto L4;
        if (r4.equals(r5.packageName) == false) goto L4;
        CharSequence r6 = r2.loadLabel(r3);     // Catch: Throwable -> L17
        if (r6 == null) goto L4;
        return r6.toString();
    L30:
        return null;
    L15:
        return null;
    }

    private static m a(PackageManager r8, PackageInfo r9, boolean r10, m r11) {
        if (r9 != null) goto L5;
        return null;
    L5:
        m r0 = new m();
        ApplicationInfo r1 = r9.applicationInfo;     // Catch: Throwable -> L62
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        if (r11 != null) goto L13;
    L15:
        CharSequence r3 = a(r8, r0.k());     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r3) == false) goto L22;
        ApplicationInfo r4 = r9.applicationInfo;     // Catch: Throwable -> L62
        if (r4 == null) goto L26;
        r3 = (String) r4.nonLocalizedLabel;     // Catch: Throwable -> L62
        if (TextUtils.isEmpty(r3) == false) goto L22;
        if (r8 == null) goto L26;
        r3 = r8.getApplicationLabel(r9.applicationInfo);     // Catch: Throwable -> L62
    L26:
        if (r9.applicationInfo == null) goto L31;
        if (r8 == null) goto L31;
        if (b3.c() == false) goto L31;
        r0.a(r9.applicationInfo.loadIcon(r8));     // Catch: Throwable -> L62
    L31:
        r0.a(7, r9.versionName);     // Catch: Throwable -> L62
        r0.a(8, Integer.valueOf(r9.versionCode));     // Catch: Throwable -> L62
        r0.a(15, r9.applicationInfo.sourceDir);     // Catch: Throwable -> L62
        if (r10 == false) goto L35;
        Boolean r12 = Boolean.FALSE;     // Catch: Throwable -> L62
        r0.a(16, r12);     // Catch: Throwable -> L62
        r0.a(4, r12);     // Catch: Throwable -> L62
        int r13 = -1;     // Catch: Throwable -> L62
    L34:
        r0.a(2, r13);     // Catch: Throwable -> L62
        if (r11 != null) goto L48;
    L52:
        ApplicationInfo r14 = r9.applicationInfo;     // Catch: Throwable -> L62
        if (r14 != null) goto L55;
    L59:
        if (r11 == null) goto L64;
        r11.b(r0.b());     // Catch: Throwable -> L62
        r11.b(r0.n());     // Catch: Throwable -> L62
        r11.a(r0.h());     // Catch: Throwable -> L62
        r11.a(r0.i());     // Catch: Throwable -> L62
        r11.d(r0.o());     // Catch: Throwable -> L62
        r11.c(r0.m());     // Catch: Throwable -> L62
        r11.b(r0.j());     // Catch: Throwable -> L62
        r11.b(r0.t());     // Catch: Throwable -> L62
        r11.c(r0.q());     // Catch: Throwable -> L62
        r11.j(r0.p());     // Catch: Throwable -> L62
        r11.h(r0.k());     // Catch: Throwable -> L62
        r11.a(r0.a());     // Catch: Throwable -> L62
        r11.a(Boolean.valueOf(r0.s()));     // Catch: Throwable -> L62
    L64:
        return r0;
    L55:
        if (TextUtils.isEmpty(r14.sourceDir) == true) goto L59;
        File r15 = new File(r9.applicationInfo.sourceDir);     // Catch: Throwable -> L62
        if (r15.exists() == false) goto L59;
        r0.a(9, Long.valueOf(r15.length()));     // Catch: Throwable -> L62
        r0.a(10, Long.valueOf(r15.lastModified()));     // Catch: Throwable -> L62
        goto L59
    L48:
        if (r11.m() == 0) goto L52;
        if (r11.j() == 0) goto L52;
        r0.c(r11.m());     // Catch: Throwable -> L62
        r0.b(r11.j());     // Catch: Throwable -> L62
        goto L59
    L35:
        long r6 = r9.lastUpdateTime;     // Catch: Throwable -> L62
        if (r6 <= 0) goto L38;
        r0.d(r6);     // Catch: Throwable -> L62
    L38:
        long r7 = r9.firstInstallTime;     // Catch: Throwable -> L62
        if (r7 <= 0) goto L41;
        r0.a(r7);     // Catch: Throwable -> L62
    L41:
        r0.a(16, Boolean.TRUE);     // Catch: Throwable -> L62
        ApplicationInfo r16 = r9.applicationInfo;     // Catch: Throwable -> L62
        if ((r16.flags & 1) != 0) goto L45;
        r2 = false;
    L45:
        int r17 = r16.uid;     // Catch: Throwable -> L62
        r0.a(4, Boolean.valueOf(r2));     // Catch: Throwable -> L62
        r13 = Integer.valueOf(r17);     // Catch: Throwable -> L62
    L22:
        r0.a(3, r3);     // Catch: Throwable -> L62
        goto L26
    L13:
        if (TextUtils.isEmpty(r11.b()) == true) goto L15;
        r0.b(r11.b());     // Catch: Throwable -> L62
        goto L26
    L9:
        if (TextUtils.isEmpty(r1.packageName) == true) goto L11;
        r0.a(1, r9.applicationInfo.packageName);     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        q8.e("AppEntityUtil", th.getMessage());
        goto L64
    }
}
