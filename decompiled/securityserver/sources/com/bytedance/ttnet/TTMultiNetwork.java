package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
    private static Map<MultiNetStateObserver, Handler> sObservers;

    public interface MultiNetStateObserver {
        void onMultiNetStateChanged(int r1, int r2, long r3);

        void onUserSpecifiedNetworkEnabled(boolean r1, long r2);
    }

    static {
        sObservers = new HashMap();
    }

    public TTMultiNetwork() {
    }

    private static SsCronetHttpClient getCronetHttpClient() {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static void notifyMultiNetState(final int r12, final int r13) {
        final long r6 = System.currentTimeMillis();
        monitor-enter(TTMultiNetwork.class);
        Iterator<Map.Entry<MultiNetStateObserver, Handler>> r9 = sObservers.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r9.hasNext() == false) goto L12;
        Map.Entry<MultiNetStateObserver, Handler> r0 = r9.next();     // Catch: Throwable -> L10
        final MultiNetStateObserver r1 = r0.getKey();     // Catch: Throwable -> L10
        Handler r10 = r0.getValue();     // Catch: Throwable -> L10
        if (r10 == null) goto L6;
        r10.post(new AnonymousClass1(r1, r12, r13, r6));     // Catch: Throwable -> L10
        goto L6
    L12:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static boolean notifySwitchToMultiNetwork(boolean r1) {
        SsCronetHttpClient r0 = getCronetHttpClient();     // Catch: Exception -> L6
        if (r0 == null) goto L12;
        return r0.notifySwitchToMultiNetwork(r1);
    L12:
        return false;
    L6:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    private static synchronized void notifyUserSpecifiedNetworkEnabled(final boolean r8) {
        monitor-enter(TTMultiNetwork.class);
        final long r1 = System.currentTimeMillis();     // Catch: Throwable -> L19
        monitor-enter(TTMultiNetwork.class);     // Catch: Throwable -> L19
        Iterator<Map.Entry<MultiNetStateObserver, Handler>> r4 = sObservers.entrySet().iterator();     // Catch: Throwable -> L12
    L8:
        if (r4.hasNext() == false) goto L14;
        Map.Entry<MultiNetStateObserver, Handler> r5 = r4.next();     // Catch: Throwable -> L12
        final MultiNetStateObserver r6 = r5.getKey();     // Catch: Throwable -> L12
        Handler r7 = r5.getValue();     // Catch: Throwable -> L12
        if (r7 == null) goto L8;
        r7.post(new AnonymousClass2(r6, r8, r1));     // Catch: Throwable -> L12
        goto L8
    L14:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L12
        monitor-exit(TTMultiNetwork.class);
        return;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static void registerMultiNetObserver(MultiNetStateObserver r3, Handler r4) {
        if (r3 == null) goto L17;
        monitor-enter(TTMultiNetwork.class);
    L9:
        th = move-exception;
        throw th;
    L6:
        if (sObservers.containsKey(r3) == true) goto L12;
        if (r4 != null) goto L11;
        sObservers.put(r3, new Handler(Looper.getMainLooper()));     // Catch: Throwable -> L9
        goto L12
    L11:
        sObservers.put(r3, r4);     // Catch: Throwable -> L9
    L12:
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L9
        return;
    L17:
        throw new NullPointerException("observer == null");
    }

    public static void triggerSwitchingToCellular() {
        SsCronetHttpClient r0 = getCronetHttpClient();     // Catch: Exception -> L6
        if (r0 == null) goto L11;
        r0.triggerSwitchingToCellular();     // Catch: Exception -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public static void unregisterMultiNetObserver(MultiNetStateObserver r2) {
        if (r2 == null) goto L12;
        monitor-enter(TTMultiNetwork.class);
        sObservers.remove(r2);     // Catch: Throwable -> L8
        monitor-exit(TTMultiNetwork.class);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new NullPointerException("observer == null");
    }
}
