package w8;

import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import com.bytedance.android.bytehook.ByteHook;
import com.bytedance.crash.Npth;
import com.bytedance.crash.n;
import com.bytedance.crash.nativecrash.NativeImpl;
import com.bytedance.crash.p;
import com.bytedance.crash.util.NativeTools;
import java.lang.reflect.Field;
import l9.m;
import l9.o;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements l9.b {
    @Override // l9.b
    public final void a() {
    }

    @Override // l9.b
    public final void b() {
        boolean r10 = true;
        if (l9.c.b() == true) goto L24;
        m r5 = m.a();
        if (r5.d == true) goto L16;
        r5.d = true;
        Field r11 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L10
        r11.setAccessible(true);     // Catch: Exception -> L10
        Printer r12 = (Printer) r11.get(Looper.getMainLooper());     // Catch: Exception -> L10
    L12:
        m.e = r12;
        jg.g r13 = m.g;
        if (r12 != r13) goto L15;
        m.e = null;
    L15:
        Looper.getMainLooper().setMessageLogging(r13);
    L10:
        e = move-exception;
        io.reactivex.exceptions.a.j(e);
        r12 = null;
    L16:
        m r14 = m.a();
        jg.g r15 = new jg.g(2);
        monitor-enter(r14);
        r14.f19577b.add(r15);     // Catch: Throwable -> L21
        monitor-exit(r14);     // Catch: Throwable -> L21
        m r16 = m.a();
        r16.f19578c.add(new jg.g(3));
        a.a.f20j = a.a.f27q;
        a.a.f21k = SystemClock.uptimeMillis();
    L21:
        th = move-exception;
        throw th;
    L24:
        z5.a.k();
        JSONArray r17 = mh.e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "enable_api_level"});
        JSONObject r18 = n9.d.f20218a;
        if (r17 != null) goto L126;
    L114:
        int r19 = mh.e.c(l9.c.e(), 60000, new String[]{"custom_event_settings", "npth_simple_setting", "fix_art_delayed_time"});
        if (r19 < 0) goto L134;
        o.e().c(new so.e(8), r19);
        return;
    L134:
        return;
    L126:
    L112:
        th = move-exception;
        com.bytedance.crash.c.f4025a.getClass();
        m.b.h("NPTH_CATCH", th);
        goto L114
    L28:
        if (r17.toString().contains("none") == true) goto L114;
        if (r17.toString().contains("all") == false) goto L34;
    L40:
        JSONArray r20 = mh.e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "enable_device_brand"});
        if (r20 == null) goto L114;
        if (r20.toString().contains("none") == true) goto L114;
        if (r20.toString().contains("all") == false) goto L50;
    L60:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_pthread_key_monitor"}) != 1) goto L70;
        int r21 = ByteHook.init();     // Catch: Throwable -> L118
        Log.i("LooperMonitor", "NPTH_KEY init,status_code: " + r21);     // Catch: Throwable -> L118
        if (r21 == 0) goto L64;
        Log.i("LooperMonitor", "NPTH_KEY init FAILED, status_code: " + r21);     // Catch: Throwable -> L118
    L64:
        int r22 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L118
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "delete_repeat_pthread_key"}) != 1) goto L67;
        boolean r23 = true;
    L68:
        NativeImpl.e(r22, r23);     // Catch: Throwable -> L118
        goto L70
    L67:
        r23 = false;
    L70:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_env_monitor"}) != 1) goto L79;
        int r24 = Build.VERSION.SDK_INT;
        if (r24 > 31) goto L79;
        NativeTools r25 = NativeTools.k();
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_debug"}) != 1) goto L76;
        boolean r26 = true;
    L77:
        r25.h(r26, r24);
        goto L79
    L76:
        r26 = false;
    L79:
        if (NativeTools.k().E() == false) goto L96;
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_gwp_asan"}) == 1) goto L88;
        if (n.h() == true) goto L88;
        if ("true".equals(null) == false) goto L96;
    L88:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_native_heap_track"}) == 1) goto L96;
        if (Build.VERSION.SDK_INT > 31) goto L96;
        Log.i("LooperMonitor", "[xasan] enable. ");
        if (p.f4088l == null) goto L96;
        Npth.startGwpAsan(false);
    L96:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "npth_simple_setting", "enable_native_heap_track"}) != 1) goto L101;
        Log.i("LooperMonitor", "NativeHeapTracker enable.");
        JSONArray r27 = mh.e.f(l9.c.e(), new String[]{"custom_event_settings", "npth_simple_setting", "native_heap_params"});
        if (p.f4087k == null) goto L101;
        Npth.startNativeHeapTracker(r27);
    L101:
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "fd_track", "enable_fd_track"}) != 1) goto L105;
        Log.i("LooperMonitor", "fd_tracker enable.");
        if (p.f4089m == null) goto L114;
        Npth.startFdTracker();
        goto L114
    L105:
        int r28 = mh.e.c(l9.c.e(), 100, new String[]{"custom_event_settings", "fd_track", "track_water_line"});
        long r29 = mh.e.c(l9.c.e(), 1000, new String[]{"custom_event_settings", "fd_track", "track_sleep_time"});
        if (mh.e.c(l9.c.e(), -1, new String[]{"custom_event_settings", "fd_track", "allow_loop_monitor"}) == 1) goto L109;
        r10 = false;
    L109:
        a.a.f33x = r10;
        new h(r28, r29).start();
        goto L114
    L50:
        if (Build.BRAND.isEmpty() == true) goto L114;
        if (r20.length() <= 0) goto L114;
        int r30 = 0;
    L56:
        if (r30 >= r20.length()) goto L114;
        if (Build.BRAND.equals(r20.optString(r30)) == true) goto L60;
        r30 = r30 + 1;
        goto L56
    L34:
        if (r17.length() <= 0) goto L114;
        int r31 = 0;
    L37:
        if (r31 >= r17.length()) goto L114;
        if (Build.VERSION.SDK_INT == Integer.parseInt(r17.optString(r31))) goto L40;
        r31 = r31 + 1;
        goto L37
    }
}
