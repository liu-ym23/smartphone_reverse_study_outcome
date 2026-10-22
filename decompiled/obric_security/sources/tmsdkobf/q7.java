package tmsdkobf;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes5.dex */
public class q7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f435a = null;
    private static boolean b = false;
    private static r7 c;
    private static r7 d;
    private static r7 e;
    private static r7 f;
    private static Object g;
    private static HandlerThread h;
    private static Handler i;
    private static String j;
    private static String k;
    private static String l;
    private static String m;
    private static String n;
    private static volatile q7 o;
    private static volatile r3 p;

    static class a extends Handler {
        a(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            if (r2.what == 11) goto L21;
            Log.e("VMS_IDLG_SDK_Client", "message type valid");
            return;
        L21:
            q7.a(q7.a().a(r2.getData().getInt("type"), r2.getData().getString("appid")));     // Catch: Exception -> L7
        L9:
            Object r1 = q7.b();
            monitor-enter(r1);
            q7.b().notify();     // Catch: Throwable -> L14
            monitor-exit(r1);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        L7:
            e = move-exception;
            Log.e("VMS_IDLG_SDK_Client", "readException:" + e.toString());
            e.printStackTrace();
            goto L9
        }
    }

    static {
        g = new Object();
    }

    private q7() {
    }

    static /* synthetic */ String a(String r0) {
        j = r0;
        return r0;
    }

    static /* synthetic */ Object b() {
        return g;
    }

    public static void c() {
        b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private static void e() {
        HandlerThread r0 = new HandlerThread("SqlWorkThread");
        h = r0;
        r0.start();
        i = new a(h.getLooper());
    }

    public String d() {
        if (f() == true) goto L5;
        return null;
    L5:
        String r0 = k;
        if (r0 == null) goto L8;
        return r0;
    L8:
        a(0, null);
        if (c != null) goto L12;
        a(f435a, 0, null);
    L12:
        return k;
    }

    public boolean f() {
        return b;
    }

    static /* synthetic */ r3 a() {
        return p;
    }

    private void b(int r3, String r4) {
        Message r2 = i.obtainMessage();
        r2.what = 11;
        Bundle r0 = new Bundle();
        r0.putInt("type", r3);
        if (r3 != 1) goto L5;
    L6:
        r0.putString("appid", r4);
    L7:
        r2.setData(r0);
        i.sendMessage(r2);
        return;
    L5:
        if (r3 != 2) goto L7;
        goto L6
    }

    public static q7 a(Context r2) {
        if (o != null) goto L15;
        monitor-enter(q7.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (o != null) goto L9;
        f435a = r2.getApplicationContext();     // Catch: Throwable -> L11
        o = new q7();     // Catch: Throwable -> L11
    L9:
        monitor-exit(q7.class);     // Catch: Throwable -> L11
    L15:
        if (p != null) goto L27;
        monitor-enter(q7.class);
    L23:
        th = move-exception;
        throw th;
    L19:
        if (p != null) goto L21;
        f435a = r2.getApplicationContext();     // Catch: Throwable -> L23
        e();     // Catch: Throwable -> L23
        p = new r3(f435a);     // Catch: Throwable -> L23
        c();     // Catch: Throwable -> L23
    L21:
        monitor-exit(q7.class);     // Catch: Throwable -> L23
    L27:
        return o;
    }

    public void a(int r8, String r9) {
        Object r0 = g;
        monitor-enter(r0);
        b(r8, r9);     // Catch: Throwable -> L34
        long r1 = SystemClock.uptimeMillis();     // Catch: Throwable -> L34
        g.wait(2000);     // Catch: InterruptedException -> L8 Throwable -> L34
    L11:
        if ((SystemClock.uptimeMillis() - r1) < 2000) goto L13;
        Log.d("VMS_IDLG_SDK_Client", "query timeout");     // Catch: Throwable -> L34
    L32:
        monitor-exit(r0);     // Catch: Throwable -> L34
        return;
    L13:
        if (r8 != 0) goto L15;
        k = j;     // Catch: Throwable -> L34
        j = null;     // Catch: Throwable -> L34
        goto L32
    L15:
        if (r8 != 1) goto L17;
        String r10 = j;     // Catch: Throwable -> L34
        if (r10 == null) goto L29;
        l = r10;     // Catch: Throwable -> L34
        j = null;     // Catch: Throwable -> L34
        goto L32
    L29:
        Log.e("VMS_IDLG_SDK_Client", "get vaid failed");     // Catch: Throwable -> L34
        goto L32
    L17:
        if (r8 != 2) goto L19;
        String r11 = j;     // Catch: Throwable -> L34
        if (r11 == null) goto L24;
        m = r11;     // Catch: Throwable -> L34
        j = null;     // Catch: Throwable -> L34
    L25:
        n = j;     // Catch: Throwable -> L34
        j = null;     // Catch: Throwable -> L34
        goto L32
    L24:
        Log.e("VMS_IDLG_SDK_Client", "get aaid failed");     // Catch: Throwable -> L34
        goto L25
    L19:
        if (r8 == 4) goto L25;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    }

    public static String a(String r7, String r8) {
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L4 Throwable -> L7
        return (String) r0.getMethod("get", new Class[]{String.class, String.class}).invoke(r0, new Object[]{r7, EnvironmentCompat.MEDIA_UNKNOWN});
    L4:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
    L6:
        return r8;
    }

    private static void a(Context r5, int r6, String r7) {
        if (r6 == 0) goto L12;
        if (r6 != 1) goto L6;
        d = new r7(o, 1, r7);
        r5.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r7), false, d);
        return;
    L6:
        if (r6 != 2) goto L17;
        e = new r7(o, 2, r7);
        r5.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r7), false, e);
        String r8 = r5.getPackageName();
        if (r8.equals(r7) == true) goto L14;
        f = new r7(o, 2, r8);
        r5.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r8), false, f);
        return;
    L14:
        return;
    L17:
        return;
    L12:
        c = new r7(o, 0, null);
        r5.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, c);
    }
}
