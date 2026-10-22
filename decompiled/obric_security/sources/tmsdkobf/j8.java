package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Debug;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class j8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a2 f284a = null;

    static {
        f284a = new a2();
    }

    public static String a() {
        Iterator r0 = ((ArrayList) v1.a()).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        nk r1 = (nk) r0.next();
        if (r1.f376a.contains(q3.c) == false) goto L4;
        return r1.b;
    L9:
        return "";
    }

    public static int b(Context r6) {
        Intent r1 = null;
        r1 = r6.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L20
    L5:
        if (r1 != null) goto L7;
        return 0;
    L7:
        int r0 = r1.getIntExtra("status", -1);
        if (r0 != 2) goto L10;
    L13:
        int r2 = r1.getIntExtra("plugged", -1);
        if (r2 != 2) goto L17;
        return 3;
    L17:
        if (r2 != 1) goto L19;
        return 2;
    L19:
        return 0;
    L10:
        if (r0 == 5) goto L13;
        return 1;
    }

    public static String c(Context r5) {
        a2 r0 = f284a;
        monitor-enter(r0);
        String r1 = (String) r0.a();     // Catch: Throwable -> L22
        if (r1 == null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r1;
    L8:
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L22
        TelephonyManager r6 = (TelephonyManager) r5.getSystemService("phone");     // Catch: Throwable -> L18
        r2.append(r6.getSimState());     // Catch: Throwable -> L18
        int r3 = r6.getPhoneCount();     // Catch: Throwable -> L18
        r2.append(",");     // Catch: Throwable -> L18
        r2.append(r3);     // Catch: Throwable -> L18
        if (r3 <= 1) goto L17;
        r2.append(",");     // Catch: Throwable -> L18
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L17;
        if (r4 <= 0) goto L15;
        r2.append(";");     // Catch: Throwable -> L18
    L15:
        r2.append(r6.getSimState(r4));     // Catch: Throwable -> L18
        r4 = r4 + 1;
    L17:
        String r7 = r2.toString();     // Catch: Throwable -> L22
        a2 r8 = f284a;     // Catch: Throwable -> L22
    L19:
        r8.a(r7, 0);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        return r7;
    L18:
        r7 = r2.toString();     // Catch: Throwable -> L22
        r8 = f284a;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public static int d(Context r0) {
        return 0;
    }

    public static String f(Context r5) {
        Map r0 = dg.f155a;
        ArrayList r1 = new ArrayList();
        String r2 = r5.getPackageName();
        if (TextUtils.isEmpty(r2) == true) goto L7;
        String r6 = je.a(r5, r2);
        nk r3 = new nk();
        r3.f376a = q3.f431a + q3.b;
        r3.b = r2 + "_" + r6;
        r1.add(r3);
    L7:
        if (r1.size() != 0) goto L9;
        return "";
    L9:
        return ((nk) r1.get(0)).b;
    }

    public static boolean e(Context r2) {
        if (Settings.Secure.getInt(r2.getContentResolver(), "adb_enabled", 0) <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public static int a(Context r4) {
        boolean r1 = false;
        int r0 = vk.a(0, e(r4), 0);
        if (Settings.Secure.getInt(r4.getContentResolver(), "development_settings_enabled", 0) <= 0) goto L5;
        boolean r2 = true;
    L6:
        int r3 = vk.a(r0, r2, 1);
        if ((r4.getApplicationInfo().flags & 2) <= 0) goto L12;
        r1 = true;
    L12:
        return vk.a(vk.a(r3, r1, 2), Debug.isDebuggerConnected(), 3);
    L5:
        r2 = false;
        goto L6
    }

    public static String b() {
        Iterator r0 = ((ArrayList) v1.a()).iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        nk r1 = (nk) r0.next();
        if (r1.f376a.contains(q3.d) == false) goto L4;
        return r1.b;
    L9:
        return "";
    }

    public static String c() {
        StringBuilder r0 = new StringBuilder();
        monitor-enter(mh.class);     // Catch: Throwable -> L23
        Context r2 = mh.f353a;     // Catch: Throwable -> L18
        monitor-exit(mh.class);     // Catch: Throwable -> L23
        m4 r1 = c6.a(r2);     // Catch: Throwable -> L23
        int r3 = 0;
    L9:
        if (r3 >= r1.f345a.a()) goto L22;
        if (r0.length() <= 0) goto L13;
        r0.append(",");     // Catch: Throwable -> L23
    L13:
        Locale r4 = r1.f345a.a(r3);     // Catch: Throwable -> L23
        if (r4 == null) goto L17;
        r0.append(r4.getLanguage()).append("-").append(r4.getCountry());     // Catch: Throwable -> L23
    L17:
        r3 = r3 + 1;     // Catch: Throwable -> L23
        goto L9
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L22:
        return r0.toString();
    }
}
