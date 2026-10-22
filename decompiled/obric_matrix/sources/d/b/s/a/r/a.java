package d.b.s.a.r;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.CookieManager;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f14897a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static b f14898b;

    static {
    }

    public a() {
    }

    public static Object a(Context r5, String r6, String r7, Object... r8) {
        int r0 = r6.hashCode();     // Catch: Throwable -> L47
        byte r3 = -1;
        if (r0 == (-854125431)) goto L11;
        if (r0 == 106642798) goto L8;
    L13:
        byte r1 = -1;
    L14:
        if (r1 == 0) goto L30;
        if (r1 != 1) goto L45;
        CookieManager r9 = CookieManager.getInstance();     // Catch: Throwable -> L47
        if (r9 != null) goto L21;
        return null;
    L21:
        if (r7.hashCode() == 341257562) goto L24;
    L26:
        if (r3 == 0) goto L29;
        return null;
    L29:
        return r9.getCookie((String) r8[0]);
    L24:
        if (r7.equals("getCookie") == false) goto L26;
        r3 = 0;
        goto L26
    L45:
        return null;
    L30:
        if (r5 == null) goto L51;
        TelephonyManager r10 = (TelephonyManager) r5.getSystemService(r6);     // Catch: Throwable -> L47
        if (r10 != null) goto L36;
        return null;
    L36:
        if (r7.hashCode() == 1714085202) goto L39;
    L41:
        if (r3 == 0) goto L44;
        return null;
    L44:
        return Integer.valueOf(r10.getNetworkType());
    L39:
        if (r7.equals("getNetworkType") == false) goto L41;
        r3 = 0;
        goto L41
    L51:
        return null;
    L8:
        if (r6.equals("phone") == false) goto L13;
        r1 = 0;
        goto L14
    L11:
        if (r6.equals("CookieManager") == false) goto L13;
        r1 = 1;
        goto L14
    L54:
        return null;
    }

    private static b b() {
        if (f14898b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f14898b == null) goto L17;
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L15
    L17:
        f14898b = (b) Class.forName("com.bytedance.sdk.account.adapter.bpea.AccountSdkBpeaAdapter").newInstance();     // Catch: Exception -> L16 Throwable -> L11
    L15:
        return f14898b;
    }

    public static Object c(Context r7, String r8, String r9, Object... r10) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r9) == false) goto L8;
        return null;
    L8:
        if (d() == false) goto L14;
        if (f14897a == false) goto L14;
        return b().a(r7, r8, r9, "bpea-account_request_api", r10);
    L14:
        return a(r7, r8, r9, r10);
    }

    public static boolean d() {
        if (b() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
