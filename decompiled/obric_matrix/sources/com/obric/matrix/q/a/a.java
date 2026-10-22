package com.obric.matrix.q.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.text.TextUtils;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.news.common.settings.e;
import com.obric.matrix.base.settings.iconfig.IMatrixAuthConfig;
import com.obric.matrix.r.c.c;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.i0.i;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u001c\u0010\u0017\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u001b\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u001c\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\rH\u0016J$\u0010\u001e\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0016\u0010\"\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010#\u001a\u00020\rJ\u0010\u0010$\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010&\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/matrix/base/auth/AuthenticationManager;", "Lcom/obric/matrix/base/auth/IApiAuthentication;", "()V", "AUTH_PKG_WHITE_MAP_LOCAL", "", "", "AUTH_PKG_WHITE_MAP_NEW_LOCAL", "", "PACKAGE_TO_SIGNATURE_MAP_CACHE", "Ljava/util/concurrent/ConcurrentHashMap;", "SIGNATURE_MD5_FOR_MATRIX", "TAG", "UID_FOR_MATRIX", "", "blackList", "", "obricAssistantAppMd5", "obricDoubaoMd5", "obricInputMethodAppMd5", "authByOneCmd", "", "cmd", "packageNameOfCaller", "authByPackageName", "context", "Landroid/content/Context;", "authByPackageNameAndMatrix", "authByPackageNameAndWhiteList", "authByUid", "uidOfCaller", "authByUidAndPackageName", "encryptionMD5", "byteStr", "", "getPkgByUid", "uid", "getSelfUid", "getSignatureMD5WithPackageName", "packageName", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9829a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f9830b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f9831c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f9832d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map<String, String> f9833e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final List<String> f9834f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final List<String> f9835g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final List<String> f9836h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Map<String, List<String>> f9837i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<String> f9838j = null;

    static {
        f9829a = new a();
        f9832d = new ConcurrentHashMap();
        f9833e = m0.h();
        List<String> r0 = r.m(new String[]{"46f3ca36520094530f217c0b9c46ff33"});
        f9834f = r0;
        List<String> r1 = r.m(new String[]{"9993555540b7498515d56e33edc01ddf", "8975833ddbbf977b53ab38daa6c92705", "2239bfabf8dce2b93c02f359f2468df8"});
        f9835g = r1;
        List<String> r2 = r.m(new String[]{"f32d2daae92240ffeb6660f5f3325009"});
        f9836h = r2;
        f9837i = m0.k(new u[]{new u("com.obric.assistant", r0), new u("com.bytedance.android.doubaoime", r1), new u("com.larus.nova", r2)});
        f9838j = r.d("com.android.shell");
    }

    private a() {
    }

    private final boolean d(Context r7, String r8) {
        if (r7 != null) goto L8;
        String r6 = "authByPackageNameAndWhiteList, context is null, return false";
    L5:
        c.b("AuthenticationManager", r6);
        return false;
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        r6 = "authByPackageNameAndWhiteList, packageNameOfCaller is empty, return false";
        goto L5
    L10:
        ConcurrentHashMap<String, String> r3 = f9832d;
        if (r3.containsKey(r8) == false) goto L13;
        String r9 = r3.get(r8);
    L17:
        String r10 = f9833e.get(r8);
        if (r10 != null) goto L20;
    L23:
        List<String> r11 = f9837i.get(r8);
        if (r11 == null) goto L58;
        Iterator<T> r12 = r11.iterator();
    L27:
        if (r12.hasNext() == false) goto L58;
        if (o.a((String) r12.next(), r9) == true) goto L30;
        c.b("AuthenticationManager", "authByPackageNameAndWhiteList, auth by new white list local but not match!");
        goto L27
    L30:
        return true;
    L58:
        Map<String, String> r13 = ((IMatrixAuthConfig) e.e(IMatrixAuthConfig.class)).getMatrixAuthConfig().f();     // Catch: Exception -> L41
        if (r13 == null) goto L60;
        String r14 = r13.get(r8);     // Catch: Exception -> L41
        if (r14 == null) goto L60;
        if (o.a(r14, r9) == false) goto L39;
        return true;
    L39:
        c.b("AuthenticationManager", "authByPackageNameAndWhiteList, auth by old white list from Settings but not match!");     // Catch: Exception -> L41
    L60:
        Map<String, List<String>> r15 = ((IMatrixAuthConfig) e.e(IMatrixAuthConfig.class)).getMatrixAuthConfig().g();     // Catch: Exception -> L55
        if (r15 == null) goto L57;
        List<String> r16 = r15.get(r8);     // Catch: Exception -> L55
        if (r16 == null) goto L57;
        Iterator<T> r17 = r16.iterator();     // Catch: Exception -> L55
    L49:
        if (r17.hasNext() == false) goto L57;
        if (o.a((String) r17.next(), r9) == true) goto L52;
        c.b("AuthenticationManager", "authByPackageNameAndWhiteList, auth by new white list from Settings but not match! return false");     // Catch: Exception -> L55
        goto L49
    L52:
        return true;
    L57:
        return false;
    L55:
        e = move-exception;
        c.f("AuthenticationManager", "authByPackageNameAndWhiteList, auth by new white list from Settings exception：" + e);
    L41:
        e = move-exception;
        c.f("AuthenticationManager", "authByPackageNameAndWhiteList, auth by old white list from Settings exception：" + e);
        goto L60
    L20:
        if (o.a(r10, r9) == false) goto L22;
        return true;
    L22:
        c.b("AuthenticationManager", "authByPackageNameAndWhiteList, auth by old white list local but not match!");
        goto L23
    L13:
        c.b("AuthenticationManager", "authByPackageNameAndWhiteList, the signature of " + r8 + " not in cache, put it in");
        o.c(r8);
        r9 = j(r7, r8);
        if (r9 == null) goto L16;
        r3.put(r8, r9);
        goto L17
    L16:
        r9 = null;
        goto L17
    }

    private final String g(byte[] r6) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r5 = new StringBuilder();
        MessageDigest r0 = MessageDigest.getInstance("MD5");     // Catch: NoSuchAlgorithmException -> L15
        o.e(r0, "getInstance(\"MD5\")");     // Catch: NoSuchAlgorithmException -> L15
        r0.reset();     // Catch: NoSuchAlgorithmException -> L15
        r0.update(r6);     // Catch: NoSuchAlgorithmException -> L15
        byte[] r7 = r0.digest();     // Catch: NoSuchAlgorithmException -> L15
        o.e(r7, "byteArray");     // Catch: NoSuchAlgorithmException -> L15
        int r1 = 0;
        int r2 = r7.length;     // Catch: NoSuchAlgorithmException -> L15
    L7:
        if (r1 >= r2) goto L14;
        int r3 = r7[r1] & 255;     // Catch: NoSuchAlgorithmException -> L15
        if (Integer.toHexString(r3).length() != 1) goto L11;
        r5.append(BDLocationException.ERROR_TIMEOUT);     // Catch: NoSuchAlgorithmException -> L15
    L11:
        r5.append(Integer.toHexString(r3));     // Catch: NoSuchAlgorithmException -> L15
        r1 = r1 + 1;
    L14:
        return r5.toString();
    }

    private final int i(Context r3) {
        if (f9831c > 0) goto L5;
        ApplicationInfo r2 = null;
        r2 = r3.getPackageManager().getApplicationInfo(r3.getPackageName(), 128);     // Catch: Exception -> L9
    L11:
        if (r2 == null) goto L14;
        f9831c = r2.uid;
    L14:
        return f9831c;
    L9:
        e = move-exception;
        c.b("AuthenticationManager", "getSelfUid, with Exception = " + e);
        goto L11
    L5:
        return f9831c;
    }

    private final String j(Context r6, String r7) {
        if (r6 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L47;
        PackageManager r8 = r6.getPackageManager();
        if (r8 != null) goto L44;
        return "";
    L44:
        PackageInfo r9 = r8.getPackageInfo(r7, 134217728);     // Catch: Throwable -> L43
        if (r9 != null) goto L14;
        return "";
    L14:
        SigningInfo r10 = r9.signingInfo;     // Catch: Throwable -> L43
        byte[] r2 = null;
        if (r10 != null) goto L17;
    L30:
        byte[] r11 = null;
    L31:
        if (r11 != null) goto L41;
        Signature[] r12 = r9.signatures;     // Catch: Throwable -> L43
        if (r12 != null) goto L35;
    L37:
        Signature r13 = null;
    L38:
        if (r13 == null) goto L40;
        r2 = r13.toByteArray();     // Catch: Throwable -> L43
    L40:
        r11 = r2;
        goto L41
    L35:
        if (r12.length <= 0) goto L37;
        r13 = r12[0];     // Catch: Throwable -> L43
    L41:
        return g(r11);
    L17:
        if (r10.getApkContentsSigners() == null) goto L30;
        Signature[] r14 = r10.getApkContentsSigners();     // Catch: Throwable -> L43
        if (r14 != null) goto L21;
    L27:
        Signature r15 = null;
    L28:
        if (r15 == null) goto L30;
        r11 = r15.toByteArray();     // Catch: Throwable -> L43
        goto L31
    L21:
        if (r14.length != 0) goto L23;
        boolean r3 = true;
    L25:
        if ((!r3) == false) goto L27;
        r15 = r14[0];     // Catch: Throwable -> L43
        goto L28
    L23:
        r3 = false;
    L48:
        return "";
    L47:
        return "";
    }

    public boolean a(int r11, String r12) {
        boolean r10 = false;
        if (r12 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L14;
        String r13 = "authByOneCmd(), packageNameOfCaller is null, return true";
    L12:
        c.b("AuthenticationManager", r13);
        return true;
    L14:
        Object r2 = e.e(IMatrixAuthConfig.class);
        o.e(r2, "obtain(IMatrixAuthConfig::class.java)");
        IMatrixAuthConfig r3 = (IMatrixAuthConfig) r2;
        Map<String, String> r4 = r3.getMatrixAuthConfig().c();
        Map<String, List<String>> r5 = r3.getMatrixAuthConfig().b();
        Map<String, com.obric.matrix.base.settings.config.a> r6 = r3.getMatrixAuthConfig().d();
        com.obric.matrix.base.settings.config.a r7 = null;
        if (r4 == null) goto L17;
        String r8 = r4.get(String.valueOf(r11));
    L18:
        if (r8 != null) goto L30;
        if (r5 == null) goto L30;
        Set<String> r9 = r5.keySet();
        if (r9 == null) goto L30;
        Iterator<T> r14 = r9.iterator();
    L24:
        if (r14.hasNext() == false) goto L30;
        String r15 = (String) r14.next();
        List<String> r16 = r5.get(r15);
        if (r16 == null) goto L24;
        if (r16.contains(String.valueOf(r11)) == false) goto L24;
        r8 = r15;
    L30:
        if (r8 != null) goto L32;
        return true;
    L32:
        if (r6 == null) goto L34;
        r7 = r6.get(r8);
    L34:
        if (r7 != null) goto L36;
        r13 = "authByOneCmd(), cmdGroup = " + r8 + ", but no mdGroupPermission, return true";
        goto L12
    L36:
        String r17 = r7.a();
        List<String> r18 = r7.b();
        if (r17 != null) goto L39;
        r13 = "authByOneCmd(), cmdGroupPermission opt is null, return true";
        goto L12
    L39:
        if (r18 != null) goto L41;
        String r19 = "authByOneCmd(), cmdGroupPermission pkgs is null, return true";
    L50:
        c.b("AuthenticationManager", r19);
    L51:
        r10 = true;
    L52:
        if (r10 == true) goto L54;
        c.b("AuthenticationManager", "authByOneCmd(), authByOneCmd is fail, cmd = " + r11 + ", cmdGroup = " + r8 + ", cmdGroupPermission opt = " + r7.a() + ", cmdGroupPermission pkgs = " + r7.b());
    L54:
        return r10;
    L41:
        if (o.a(r17, "contain") == false) goto L44;
        r10 = r18.contains(r12);
        goto L52
    L44:
        if (o.a(r17, "exclude") == true) goto L46;
        r19 = "authByOneCmd(), cmdGroupPermission opt = " + r17 + " is invalid, return true";
        goto L50
    L46:
        if (r18.contains(r12) == true) goto L52;
    L17:
        r8 = null;
        goto L18
    L5:
        if (r12.length() == 0) goto L8;
        r1 = false;
        goto L10
    }

    public boolean b(Context r7, String r8) {
        if (r7 != null) goto L8;
        String r6 = "authByPackageName, context is null, return false";
    L5:
        c.b("AuthenticationManager", r6);
        return false;
    L8:
        if (TextUtils.isEmpty(r8) == false) goto L10;
        r6 = "authByPackageName, packageNameOfCaller is empty, return false";
        goto L5
    L10:
        c.b("AuthenticationManager", "authByPackageName, packageNameOfCaller is " + r8);
        if (r.J(f9838j, r8) == false) goto L32;
        r6 = "authByPackageName, " + r8 + " is in local blackList, return false";
        goto L5
    L32:
        List<String> r4 = ((IMatrixAuthConfig) e.e(IMatrixAuthConfig.class)).getMatrixAuthConfig().e();     // Catch: Exception -> L23
        if (r4 == null) goto L19;
        o.c(r8);     // Catch: Exception -> L23
        if (r4.contains(r8) != true) goto L19;
        boolean r5 = true;
    L20:
        if (r5 == false) goto L26;
        c.b("AuthenticationManager", "authByPackageName, " + r8 + " is in settings blackList, return false");     // Catch: Exception -> L23
        return false;
    L26:
        if (c(r7, r8) == false) goto L29;
        return true;
    L29:
        if (d(r7, r8) == false) goto L31;
        return true;
    L31:
        return false;
    L19:
        r5 = false;
    L23:
        e = move-exception;
        c.f("AuthenticationManager", "get settings blackList with Exception: " + e);
        goto L26
    }

    public final boolean c(Context r8, String r9) {
        o.f(r8, "context");
        if (TextUtils.isEmpty(f9830b) == false) goto L5;
        String r0 = r8.getPackageName();
        o.e(r0, "context.packageName");
        f9830b = j(r8, r0);
        c.b("AuthenticationManager", "authByPackageName, SIGNATURE_MD5_FOR_MATRIX is " + f9830b);
    L5:
        boolean r2 = false;
        if (TextUtils.isEmpty(f9830b) == false) goto L9;
        c.b("AuthenticationManager", "authByPackageName, SIGNATURE_MD5_FOR_MATRIX is empty, return false");
        return false;
    L9:
        ConcurrentHashMap<String, String> r1 = f9832d;
        if (r1.containsKey(r9) == true) goto L12;
    L16:
        o.c(r9);
        String r7 = j(r8, r9);
        if (TextUtils.isEmpty(r7) == false) goto L20;
        StringBuilder r10 = new StringBuilder();
        r10.append("authByPackageName, the signature of ");
        r10.append(r9);
        String r11 = " is empty, return false";
    L19:
        r10.append(r11);
        c.b("AuthenticationManager", r10.toString());
    L23:
        return r2;
    L20:
        r1.put(r9, r7);
        r2 = k.p(r7, f9830b, false, 2, null);
        if (r2 == true) goto L23;
        r10 = new StringBuilder();
        r10.append("authByPackageName, the signature of ");
        r10.append(r9);
        r11 = " is not equals to MATRIX, return false";
        goto L19
    L12:
        if (k.p(f9830b, r1.get(r9), false, 2, null) == false) goto L15;
        return true;
    L15:
        c.b("AuthenticationManager", "authByPackageName, " + r9 + " is in signature cache，but not equals to MATRIX");
        goto L16
    }

    public boolean e(Context r3, int r4) {
        boolean r0 = false;
        if (r3 != null) goto L5;
        return false;
    L5:
        PackageManager r1 = r3.getPackageManager();
        if (r1 != null) goto L9;
        return false;
    L9:
        if (r1.checkSignatures(i(r3), r4) != 0) goto L11;
        r0 = true;
    L11:
        if (r0 == true) goto L13;
        c.b("AuthenticationManager", "authByUid, uidOfCaller is " + r4 + ", AuthSuccessful is false, return false");
    L13:
        return r0;
    }

    public boolean f(Context r3, int r4, String r5) {
        c.b("AuthenticationManager", "authByUidAndPackageName callPkg = " + r5 + ", callUid = " + r4);
        if (r4 != 0) goto L8;
        if (o.a(r5, "root") == false) goto L8;
        return false;
    L8:
        if (r.J(f9838j, r5) == false) goto L11;
        return false;
    L11:
        if (e(r3, r4) == false) goto L14;
        return true;
    L14:
        if (b(r3, r5) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public final String h(Context r1, int r2) {
        o.f(r1, "context");
        PackageManager r0 = r1.getPackageManager();
        if (r0 != null) goto L13;
        return "";
    L13:
        String[] r3 = r0.getPackagesForUid(r2);     // Catch: Throwable -> L12
        if (r3 == null) goto L15;
        String r4 = (String) i.B(r3, 0);     // Catch: Throwable -> L12
        if (r4 != null) goto L11;
        return "";
    L11:
        return r4;
    L15:
        return "";
    L17:
        return "";
    }
}
