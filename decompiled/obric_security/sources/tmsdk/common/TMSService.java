package tmsdk.common;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tmsdkobf.d0;
import tmsdkobf.e0;
import tmsdkobf.ua;
import tmsdkobf.uc;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TMSService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap f40a = null;
    private static final HashMap b = null;

    static {
        f40a = new HashMap();
        b = new HashMap();
    }

    public TMSService() {
    }

    public static IBinder bindService(Class<? extends d0> r1, e0 r2) {
        monitor-enter(d0.class);
        ua.a(f40a.get(r1));     // Catch: Throwable -> L8
        monitor-exit(d0.class);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    public static d0 startService(d0 r1) {
        startService(r1, null);
        return null;
    }

    public static boolean stopService(Class<? extends d0> r3) {
        monitor-enter(d0.class);
        HashMap r1 = f40a;     // Catch: Throwable -> L18
        if (r1.containsKey(r3) == false) goto L15;
        List r2 = (List) b.get(r3);     // Catch: Throwable -> L18
        if (r2 != null) goto L9;
    L13:
        ua.a(r1.get(r3));     // Catch: Throwable -> L18
        throw null;     // Catch: Throwable -> L18
    L9:
        if (r2.size() == 0) goto L13;
        monitor-exit(d0.class);     // Catch: Throwable -> L18
        return false;
    L15:
        monitor-exit(d0.class);     // Catch: Throwable -> L18
        return true;
    L18:
        th = move-exception;
        throw th;
    }

    public static void unBindService(Class<? extends d0> r2, e0 r3) {
        monitor-enter(d0.class);
        List r4 = (List) b.get(r2);     // Catch: Throwable -> L9
        if (r4 == null) goto L7;
        r4.remove(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(d0.class);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return uc.c();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        f40a.clear();
        b.clear();
    }

    @Override // android.app.Service
    public void onDestroy() {
        monitor-enter(d0.class);
        HashMap r2 = f40a;     // Catch: Throwable -> L12
        Iterator r1 = new ArrayList(r2.values()).iterator();     // Catch: Throwable -> L12
        if (r1.hasNext() == true) goto L10;
        r2.clear();     // Catch: Throwable -> L12
        b.clear();     // Catch: Throwable -> L12
        monitor-exit(d0.class);     // Catch: Throwable -> L12
        super.onDestroy();
        return;
    L10:
        ua.a(r1.next());     // Catch: Throwable -> L12
        throw null;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // android.app.Service
    public void onStart(Intent r1, int r2) {
        super.onStart(r1, r2);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        super.onStartCommand(r1, r2, r3);
        return 1;
    }

    public static d0 startService(d0 r0, Intent r1) {
        monitor-enter(d0.class);
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean stopService(d0 r1) {
        monitor-enter(TMSService.class);
        throw null;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
