package com.obric.matrix.r.c;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdinstall.c0;
import com.bytedance.bdinstall.i;
import com.ss.android.agilelogger.ALog;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/common_utils/log/ALogInitTask;", "", "()V", "TAG", "", "initComplete", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitComplete", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "doInit", "", "context", "Landroid/content/Context;", "debug", "", "init", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9915b = null;

    /* JADX INFO: renamed from: com.obric.matrix.r.c.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\f"}, d2 = {"com/obric/matrix/common_utils/log/ALogInitTask$doInit$1", "Lcom/bytedance/bdinstall/ILogger;", "d", "", NotificationCompat.CATEGORY_MESSAGE, "", "t", "", "e", "i", BaseSwitches.V, "w", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class C0283a implements c0 {
        C0283a() {
        }

        @Override // com.bytedance.bdinstall.c0
        public void a(String r5, Throwable r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (k.F(r5, "device_token", false, 2, null) == false) goto L6;
        L29:
            e.b("ALogInitTask", r5, r6);
            return;
        L6:
            if (k.F(r5, "dr_oaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "Oaid#initOaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "udid_list", false, 2, null) == true) goto L29;
            if (k.F(r5, "install_id", false, 2, null) == true) goto L29;
            if (k.F(r5, "ssid", false, 2, null) == true) goto L29;
            if (k.F(r5, "pico_sn", false, 2, null) == true) goto L29;
            if (k.F(r5, "BDLocation", false, 2, null) == true) goto L29;
            if (k.F(r5, "clientudid", false, 2, null) == true) goto L29;
            if (k.F(r5, "cdid", false, 2, null) == true) goto L29;
            if (k.F(r5, "loadHeader", false, 2, null) == true) goto L29;
            if (k.F(r5, "getOaid", false, 2, null) == true) goto L29;
            c.c("ALogInitTask", r5, r6);
        }

        @Override // com.bytedance.bdinstall.c0
        public void b(String r5, Throwable r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (k.F(r5, "device_token", false, 2, null) == false) goto L6;
        L29:
            e.k("ALogInitTask", r5);
            return;
        L6:
            if (k.F(r5, "dr_oaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "Oaid#initOaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "udid_list", false, 2, null) == true) goto L29;
            if (k.F(r5, "install_id", false, 2, null) == true) goto L29;
            if (k.F(r5, "ssid", false, 2, null) == true) goto L29;
            if (k.F(r5, "pico_sn", false, 2, null) == true) goto L29;
            if (k.F(r5, "BDLocation", false, 2, null) == true) goto L29;
            if (k.F(r5, "clientudid", false, 2, null) == true) goto L29;
            if (k.F(r5, "cdid", false, 2, null) == true) goto L29;
            if (k.F(r5, "loadHeader", false, 2, null) == true) goto L29;
            if (k.F(r5, "getOaid", false, 2, null) == true) goto L29;
            c.t("ALogInitTask", r5, r6);
        }

        @Override // com.bytedance.bdinstall.c0
        public void c(String r5, Throwable r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (k.F(r5, "device_token", false, 2, null) == false) goto L6;
        L29:
            e.j("ALogInitTask", r5, r6);
            return;
        L6:
            if (k.F(r5, "dr_oaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "Oaid#initOaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "udid_list", false, 2, null) == true) goto L29;
            if (k.F(r5, "install_id", false, 2, null) == true) goto L29;
            if (k.F(r5, "ssid", false, 2, null) == true) goto L29;
            if (k.F(r5, "pico_sn", false, 2, null) == true) goto L29;
            if (k.F(r5, "BDLocation", false, 2, null) == true) goto L29;
            if (k.F(r5, "clientudid", false, 2, null) == true) goto L29;
            if (k.F(r5, "cdid", false, 2, null) == true) goto L29;
            if (k.F(r5, "loadHeader", false, 2, null) == true) goto L29;
            if (k.F(r5, "getOaid", false, 2, null) == true) goto L29;
            c.r("ALogInitTask", r5, r6);
        }

        @Override // com.bytedance.bdinstall.c0
        public void d(String r5, Throwable r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (k.F(r5, "device_token", false, 2, null) == false) goto L6;
        L29:
            e.c("ALogInitTask", r5);
            return;
        L6:
            if (k.F(r5, "dr_oaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "Oaid#initOaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "udid_list", false, 2, null) == true) goto L29;
            if (k.F(r5, "install_id", false, 2, null) == true) goto L29;
            if (k.F(r5, "ssid", false, 2, null) == true) goto L29;
            if (k.F(r5, "pico_sn", false, 2, null) == true) goto L29;
            if (k.F(r5, "BDLocation", false, 2, null) == true) goto L29;
            if (k.F(r5, "clientudid", false, 2, null) == true) goto L29;
            if (k.F(r5, "cdid", false, 2, null) == true) goto L29;
            if (k.F(r5, "loadHeader", false, 2, null) == true) goto L29;
            if (k.F(r5, "getOaid", false, 2, null) == true) goto L29;
            c.g("ALogInitTask", r5, r6);
        }

        @Override // com.bytedance.bdinstall.c0
        public void e(String r5, Throwable r6) {
            if (r5 != null) goto L4;
            return;
        L4:
            if (k.F(r5, "device_token", false, 2, null) == false) goto L6;
        L29:
            e.d("ALogInitTask", r5);
            return;
        L6:
            if (k.F(r5, "dr_oaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "Oaid#initOaid", false, 2, null) == true) goto L29;
            if (k.F(r5, "udid_list", false, 2, null) == true) goto L29;
            if (k.F(r5, "install_id", false, 2, null) == true) goto L29;
            if (k.F(r5, "ssid", false, 2, null) == true) goto L29;
            if (k.F(r5, "pico_sn", false, 2, null) == true) goto L29;
            if (k.F(r5, "BDLocation", false, 2, null) == true) goto L29;
            if (k.F(r5, "clientudid", false, 2, null) == true) goto L29;
            if (k.F(r5, "cdid", false, 2, null) == true) goto L29;
            if (k.F(r5, "loadHeader", false, 2, null) == true) goto L29;
            if (k.F(r5, "getOaid", false, 2, null) == true) goto L29;
            c.k("ALogInitTask", r5, r6);
        }
    }

    static {
        f9914a = new a();
        f9915b = new AtomicBoolean(false);
    }

    private a() {
    }

    private final void a(Context r3, boolean r4) {
        String r2 = r3.getFilesDir().getAbsolutePath();
        Context r1 = r3.getApplicationContext();
        if (r1 != null) goto L5;
        r1 = r3;
    L5:
        com.ss.android.agilelogger.a.b r0 = new com.ss.android.agilelogger.a.b(r1);
        r0.f(20971520);
        r0.g(2097152);
        r0.d(r2 + "/ALOG");
        if (r4 == false) goto L8;
        int r5 = 2;
    L9:
        r0.c(r5);
        o.e(r0, "Builder(\n               …BOSE else LogLevel.DEBUG)");
        ALog.setDebug(r4);
        ALog.init(r0.a());
        e.e(r0.a(), r4);
        d.b(r3, r4);
        i.x(new C0283a());
        return;
    L8:
        r5 = 3;
        goto L9
    }

    public final AtomicBoolean b() {
        return f9915b;
    }

    public final void c(Context r3, boolean r4) {
        o.f(r3, "context");
        Log.i("ALogInitTask", "init start");     // Catch: Exception -> L5
        a(r3, r4);     // Catch: Exception -> L5
        f9915b.set(true);     // Catch: Exception -> L5
        Log.i("ALogInitTask", "init success");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e("ALogInitTask", "init failed", e);
    }
}
