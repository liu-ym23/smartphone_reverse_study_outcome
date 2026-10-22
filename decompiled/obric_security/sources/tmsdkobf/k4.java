package tmsdkobf;

import android.os.Build;
import android.text.TextUtils;
import tmsdk.common.TMServiceFactory;
import tmsdk.common.module.update.SdkSettingUpdate;

/* JADX INFO: loaded from: classes5.dex */
public abstract class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f301a = "";
    private static volatile String b = "";
    private static volatile String c = "";

    static {
    }

    public static String a() {
        if (TextUtils.isEmpty(b) == false) goto L5;
        p6 r1 = TMServiceFactory.getPreferenceService("daps");     // Catch: Throwable -> L15
        String r2 = r1.a("bra");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r2) == true) goto L10;
        b = r2;     // Catch: Throwable -> L15
        return b;
    L10:
        b = Build.BRAND;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(b) == true) goto L14;
        r1.putString("bra", b);     // Catch: Throwable -> L15
    L14:
        return b;
    L5:
        return b;
    }

    public static String b() {
        if (TextUtils.isEmpty(c) == false) goto L5;
        p6 r1 = TMServiceFactory.getPreferenceService("daps");     // Catch: Throwable -> L15
        String r2 = r1.a("maft");     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r2) == true) goto L10;
        c = r2;     // Catch: Throwable -> L15
        return c;
    L10:
        c = Build.MANUFACTURER;     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(c) == true) goto L14;
        r1.putString("maft", c);     // Catch: Throwable -> L15
    L14:
        return c;
    L5:
        return c;
    }

    public static String c() {
        if (TextUtils.isEmpty(f301a) == false) goto L5;
        SdkSettingUpdate r0 = SdkSettingUpdate.INSTANCE;     // Catch: Throwable -> L25
        if (r0.getMobileModelSpEN() == false) goto L13;
        p6 r1 = TMServiceFactory.getPreferenceService("daps");     // Catch: Throwable -> L25
        String r4 = r1.a("mona");     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(r4) == true) goto L15;
        f301a = r4;     // Catch: Throwable -> L25
        return f301a;
    L15:
        if (r0.getMobileModelSysEN() == false) goto L24;
        if (r1 != null) goto L18;
        r1 = TMServiceFactory.getPreferenceService("daps");     // Catch: Throwable -> L25
    L18:
        f301a = Build.MODEL;     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(f301a) == true) goto L22;
        r1.putString("mona", f301a);     // Catch: Throwable -> L25
    L22:
        return f301a;
    L13:
        r1 = null;
    L24:
        return f301a;
    L5:
        return f301a;
    }

    public static void a(String r0) {
        f301a = r0;
    }
}
