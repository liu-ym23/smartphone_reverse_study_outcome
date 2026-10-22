package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class SingletonConnectivityReceiver {
    private static final String TAG = "ConnectivityMonitor";
    private static volatile SingletonConnectivityReceiver instance;
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    private boolean isRegistered;
    final Set<ConnectivityMonitor.ConnectivityListener> listeners;

    private interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    private static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback;

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1, reason: invalid class name */
        class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
            final /* synthetic */ FrameworkConnectivityMonitorPostApi24 this$0;

            AnonymousClass1(FrameworkConnectivityMonitorPostApi24 r1) {
                this.this$0 = r1;
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network r1) {
                postOnConnectivityChange(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network r1) {
                postOnConnectivityChange(false);
            }

            private void postOnConnectivityChange(final boolean r2) {
                Util.postOnUiThread(new RunnableC00171(this, r2));
            }

            void onConnectivityChange(boolean r3) {
                Util.assertMainThread();
                boolean r0 = this.this$0.isConnected;
                this.this$0.isConnected = r3;
                if (r0 == r3) goto L6;
                this.this$0.listener.onConnectivityChanged(r3);
                return;
            }
        }

        FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier<ConnectivityManager> r2, ConnectivityMonitor.ConnectivityListener r3) {
            this.networkCallback = new AnonymousClass1(this);
            this.connectivityManager = r2;
            this.listener = r3;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            if (this.connectivityManager.get().getActiveNetwork() == null) goto L5;
            boolean r0 = true;
        L6:
            this.isConnected = r0;
            this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);     // Catch: RuntimeException -> L9
            return true;
        L9:
            e = move-exception;
            if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5) == false) goto L13;
            Log.w(SingletonConnectivityReceiver.TAG, "Failed to register callback", e);
        L13:
            return false;
        L5:
            r0 = false;
            goto L6
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    private static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        static final Executor EXECUTOR = null;
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        final BroadcastReceiver connectivityReceiver;
        final Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final ConnectivityMonitor.ConnectivityListener listener;

        static {
            EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
        }

        FrameworkConnectivityMonitorPreApi24(Context r2, GlideSuppliers.GlideSupplier<ConnectivityManager> r3, ConnectivityMonitor.ConnectivityListener r4) {
            this.connectivityReceiver = new AnonymousClass1(this);
            this.context = r2.getApplicationContext();
            this.connectivityManager = r3;
            this.listener = r4;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            EXECUTOR.execute(new AnonymousClass2(this));
            return true;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            EXECUTOR.execute(new AnonymousClass3(this));
        }

        void onConnectivityChange() {
            EXECUTOR.execute(new AnonymousClass4(this));
        }

        void notifyChangeOnUiThread(final boolean r2) {
            Util.postOnUiThread(new AnonymousClass5(this, r2));
        }

        boolean isConnected() {
            NetworkInfo r3 = this.connectivityManager.get().getActiveNetworkInfo();     // Catch: RuntimeException -> L10
            if (r3 != null) goto L6;
        L8:
            return false;
        L6:
            if (r3.isConnected() == false) goto L8;
            return true;
        L10:
            e = move-exception;
            if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5) == false) goto L14;
            Log.w(SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e);
        L14:
            return true;
        }
    }

    static SingletonConnectivityReceiver get(Context r2) {
        if (instance != null) goto L15;
        monitor-enter(SingletonConnectivityReceiver.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (instance != null) goto L9;
        instance = new SingletonConnectivityReceiver(r2.getApplicationContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SingletonConnectivityReceiver.class);     // Catch: Throwable -> L11
    L15:
        return instance;
    }

    static void reset() {
        instance = null;
    }

    private SingletonConnectivityReceiver(final Context r3) {
        this.listeners = new HashSet();
        this.frameworkConnectivityMonitor = new FrameworkConnectivityMonitorPostApi24(GlideSuppliers.memorize(new AnonymousClass1(this, r3)), new AnonymousClass2(this));
    }

    synchronized void register(ConnectivityMonitor.ConnectivityListener r2) {
        monitor-enter(this);
        this.listeners.add(r2);     // Catch: Throwable -> L6
        maybeRegisterReceiver();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void unregister(ConnectivityMonitor.ConnectivityListener r2) {
        monitor-enter(this);
        this.listeners.remove(r2);     // Catch: Throwable -> L6
        maybeUnregisterReceiver();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void maybeRegisterReceiver() {
        if (this.isRegistered == false) goto L5;
        return;
    L5:
        if (this.listeners.isEmpty() == true) goto L10;
        this.isRegistered = this.frameworkConnectivityMonitor.register();
        return;
    }

    private void maybeUnregisterReceiver() {
        if (this.isRegistered == true) goto L5;
        return;
    L5:
        if (this.listeners.isEmpty() == false) goto L10;
        this.frameworkConnectivityMonitor.unregister();
        this.isRegistered = false;
        return;
    }
}
