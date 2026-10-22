package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class TTMultiNetwork {
    public static final int STATE_COUNT = 8;
    public static final int STATE_DEFAULT_CELLULAR = 1;
    public static final int STATE_DEFAULT_WIFI_WITH_CELLULAR_DOWN = 2;
    public static final int STATE_DEFAULT_WIFI_WITH_CELLULAR_UP = 3;
    public static final int STATE_EVALUATE_CELLULAR = 7;
    public static final int STATE_NO_NETWORK = 0;
    public static final int STATE_STOPPED = -1;
    public static final int STATE_WAIT_CELLULAR_ALWAYS_UP = 4;
    public static final int STATE_WAIT_USER_ENABLE = 5;
    public static final int STATE_WIFI_WITH_CELLULAR_TRANS_DATA = 6;
    private static final String TAG = "TTMultiNetwork";
    private static Map<c, Handler> sObservers;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f6270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f6271g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f6272h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ long f6273i;

        a(c r1, int r2, int r3, long r4) {
            this.f6270f = r1;
            this.f6271g = r2;
            this.f6272h = r3;
            this.f6273i = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6270f.a(this.f6271g, this.f6272h, this.f6273i);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f6274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f6275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f6276h;

        b(c r1, boolean r2, long r3) {
            this.f6274f = r1;
            this.f6275g = r2;
            this.f6276h = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6274f.b(this.f6275g, this.f6276h);
        }
    }

    public interface c {
        void a(int r1, int r2, long r3);

        void b(boolean r1, long r2);
    }

    static {
        sObservers = new HashMap();
    }

    public TTMultiNetwork() {
    }

    private static j getCronetHttpClient() {
        if (d.c() == false) goto L7;
        return j.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static void notifyMultiNetState(int r12, int r13) {
        long r6 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<c, Handler>> r9 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r9.hasNext() == false) goto L10;
        Map.Entry<c, Handler> r0 = r9.next();     // Catch: Throwable -> L12
        c r1 = r0.getKey();     // Catch: Throwable -> L12
        Handler r10 = r0.getValue();     // Catch: Throwable -> L12
        if (r10 == null) goto L6;
        r10.post(new a(r1, r12, r13, r6));     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean notifySwitchToMultiNetwork(boolean r1) {
        j r0 = getCronetHttpClient();     // Catch: Exception -> L8
        if (r0 == null) goto L6;
        return r0.B(r1);
    L6:
        return false;
    L11:
        return false;
    }

    private static synchronized void notifyUserSpecifiedNetworkEnabled(boolean r7) {
        monitor-enter(TTMultiNetwork.class);
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L18
        monitor-enter(TTMultiNetwork.class);     // Catch: Throwable -> L18
        Iterator<Map.Entry<c, Handler>> r3 = sObservers.entrySet().iterator();     // Catch: Throwable -> L15
    L8:
        if (r3.hasNext() == false) goto L12;
        Map.Entry<c, Handler> r4 = r3.next();     // Catch: Throwable -> L15
        c r5 = r4.getKey();     // Catch: Throwable -> L15
        Handler r6 = r4.getValue();     // Catch: Throwable -> L15
        if (r6 == null) goto L8;
        r6.post(new b(r5, r7, r1));     // Catch: Throwable -> L15
        goto L8
    L12:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L15
        monitor-exit(TTMultiNetwork.class);
        return;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(c r3, Handler r4) {
        Objects.requireNonNull(r3, "observer == null");
        monitor-enter(TTMultiNetwork.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sObservers.containsKey(r3) == true) goto L9;
        if (r4 != null) goto L8;
        sObservers.put(r3, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L11
        goto L9
    L8:
        sObservers.put(r3, r4);     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L11
    }

    public static void triggerSwitchingToCellular() {
        j r0 = getCronetHttpClient();     // Catch: Exception -> L6
        if (r0 == null) goto L9;
        r0.Z();     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    public static void unregisterMultiNetObserver(c r2) {
        Objects.requireNonNull(r2, "observer == null");
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
