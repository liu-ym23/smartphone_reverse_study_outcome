package tmsdkobf;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemProperties;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.io.File;
import java.util.Locale;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class la {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f326a = "";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f327a;
        public long b;

        public a() {
        }
    }

    static {
    }

    public static String a(Context r0) {
        return f326a;
    }

    public static String b(Context r1) {
        if (mb.b() == true) goto L5;
        return "";
    L5:
        return c(r1);
    }

    public static String c(Context r0) {
        return "00000000000000";
    }

    public static String d() {
        return k4.c();
    }

    public static int e() {
        TelephonyManager r1 = (TelephonyManager) TMSDKContext.getApplicaionContext().getSystemService("phone");     // Catch: Throwable -> L7
        if (r1 == null) goto L10;
        return r1.getNetworkType();
    L10:
        return -1;
    L11:
        return -1;
    }

    public static String a() {
        return k4.a();
    }

    public static String b() {
        String r1 = Build.MANUFACTURER;     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return null;
    L6:
        String r2 = r1.toLowerCase(Locale.ENGLISH);     // Catch: Exception -> L49
        if (r2.contains("xiaomi") == false) goto L12;
        return a("ro.miui.ui.version.name");
    L12:
        if (r2.contains("gionee") == false) goto L19;
        String r3 = a("ro.gn.extvernumber");     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r3) == true) goto L16;
        return r3;
    L16:
        return a("ro.build.display.id");
    L19:
        if (r2.contains("vivo") == false) goto L28;
        String r4 = a("ro.vivo.os.name");     // Catch: Exception -> L49
        String r5 = a("ro.vivo.os.version");     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r4) == true) goto L26;
        if (TextUtils.isEmpty(r5) == true) goto L26;
        return r4 + "_" + r5;
    L26:
        return a("ro.vivo.os.build.display.id");
    L28:
        if (r2.contains("meizu") == false) goto L32;
        return a("ro.build.display.id");
    L32:
        if (r2.contains("lenovo") == false) goto L46;
        String r6 = a("ro.lenovo.lvp.version");     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r6) == true) goto L40;
        String[] r7 = r6.split("_");     // Catch: Exception -> L49
        if (r7 == null) goto L40;
        if (r7.length <= 0) goto L40;
        String r8 = r7[0];     // Catch: Exception -> L49
    L42:
        if (TextUtils.isEmpty(r8) == true) goto L44;
        return r8;
    L44:
        return a("ro.build.version.incremental");
    L40:
        r8 = null;
        goto L42
    L46:
        if (r2.contains("letv") == true) goto L48;
        return null;
    L48:
        return a("ro.letv.eui");
    L55:
        return null;
    }

    public static String c() {
        String r0 = k4.b();
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return NetworkStackConstant.UNKNOWN_TYPE;
    L6:
        return r0;
    }

    public static String a(String r0) {
        String r1 = SystemProperties.get(r0);     // Catch: Throwable -> L4
    L5:
        if (r1 != null) goto L10;
        return "";
    L10:
        return r1;
    L4:
        r1 = null;
        goto L5
    }

    public static void a(File r5, a r6) {
        StatFs r0 = new StatFs(r5.getPath());     // Catch: Exception -> L4
        long r1 = r0.getBlockSize();     // Catch: Exception -> L4
        r6.f327a = ((long) r0.getAvailableBlocks()) * r1;     // Catch: Exception -> L4
        r6.b = ((long) r0.getBlockCount()) * r1;     // Catch: Exception -> L4
        return;
    }

    public static void a(a r2) {
        if (z4.a() == false) goto L5;
        a(Environment.getExternalStorageDirectory(), r2);
        return;
    L5:
        r2.f327a = 0;
        r2.b = 0;
    }
}
