package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.GlobalProxyLancet;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.util.NetUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
class InstallDispatcher implements Handler.Callback {
    private static final int MSG_BG_START = 1234;
    private static final int MSG_WORK_ONE = 1235;
    private Activator mActivator;
    private final AtomicBoolean mActive;
    private final AppStateListener mAppStateListener;
    private final InstallOptions mConfig;
    private final DeviceManager mDeviceManager;
    private Env mEnv;
    private long mFetchActiveTime;
    private final Handler mHandler;
    private final NetworkObserver mObservers;
    private Register mRegisterWorker;

    static class NetworkObserver {
        private final Context mContext;
        private final AtomicBoolean mHasListenNetwork;
        private final Set<WeakReference<OnNetworkReadyListener>> mListeners;
        ConnectivityManager.NetworkCallback networkCallback;

        interface OnNetworkReadyListener {
            void onNetworkReady();
        }

        static /* synthetic */ Set access$1000(NetworkObserver r0) {
            return r0.mListeners;
        }

        static /* synthetic */ void access$800(NetworkObserver r0) {
            r0.notifyObserver();
        }

        static /* synthetic */ Context access$900(NetworkObserver r0) {
            return r0.mContext;
        }

        public NetworkObserver(Context r3) {
            this.mListeners = Collections.synchronizedSet(new HashSet());
            this.mHasListenNetwork = new AtomicBoolean(false);
            this.networkCallback = null;
            this.mContext = r3;
        }

        private void registerNetworkChange() {
            Log.i("Dispatcher", "registerNetworkChange: ");
            if (this.networkCallback == null) goto L5;
            return;
        L5:
            ConnectivityManager r0 = (ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class);
            ConnectivityManager.NetworkCallback r1 = new AnonymousClass1(this);
            this.networkCallback = r1;
            r0.registerDefaultNetworkCallback(r1);
        }

        private void unregisterNetworkChange() {
            Log.i("Dispatcher", "unregisterNetworkChange: ");
            if (this.mListeners.size() <= 0) goto L5;
            return;
        L5:
            if (this.networkCallback == null) goto L10;
            ((ConnectivityManager) this.mContext.getSystemService(ConnectivityManager.class)).unregisterNetworkCallback(this.networkCallback);
            this.networkCallback = null;
            return;
        }

        public synchronized void observe(OnNetworkReadyListener r3) {
            monitor-enter(this);
            this.mListeners.add(new WeakReference(r3));     // Catch: Throwable -> L6
            registerNetworkChange();     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private void tryListenNetChange() {
            if (this.mHasListenNetwork.compareAndSet(false, true) == false) goto L12;
            BroadcastReceiver r0 = new AnonymousClass2(this);
            IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, r0, r1);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            e.printStackTrace();
            return;
        }

        private void notifyObserver() {
            ExecutorUtil.runOnHandlerThread(new AnonymousClass3(this));
        }

        public synchronized void unObserve(OnNetworkReadyListener r3) {
            monitor-enter(this);
            Iterator<WeakReference<OnNetworkReadyListener>> r0 = this.mListeners.iterator();     // Catch: Throwable -> L15
        L5:
            if (r0.hasNext() == false) goto L12;
            WeakReference<OnNetworkReadyListener> r1 = r0.next();     // Catch: Throwable -> L15
            if (r1 == null) goto L8;
            if (r1.get() != r3) goto L5;
            r0.remove();     // Catch: Throwable -> L15
            goto L12
        L8:
            r0.remove();     // Catch: Throwable -> L15
        L12:
            unregisterNetworkChange();     // Catch: Throwable -> L15
            monitor-exit(this);
            return;
        L15:
            th = move-exception;
            throw th;
        }
    }

    static /* synthetic */ AtomicBoolean access$000(InstallDispatcher r0) {
        return r0.mActive;
    }

    static /* synthetic */ InstallOptions access$100(InstallDispatcher r0) {
        return r0.mConfig;
    }

    static /* synthetic */ Env access$200(InstallDispatcher r0) {
        return r0.mEnv;
    }

    static /* synthetic */ void access$300(InstallDispatcher r0, Activator r1) {
        r0.activeImmediately(r1);
    }

    static /* synthetic */ AppStateListener access$400(InstallDispatcher r0) {
        return r0.mAppStateListener;
    }

    static /* synthetic */ DeviceManager access$500(InstallDispatcher r0) {
        return r0.mDeviceManager;
    }

    static /* synthetic */ NetworkObserver access$600(InstallDispatcher r0) {
        return r0.mObservers;
    }

    static /* synthetic */ Handler access$700(InstallDispatcher r0) {
        return r0.mHandler;
    }

    InstallDispatcher(InstallOptions r3, DeviceManager r4, AppStateListener r5, Env r6) {
        this.mActive = new AtomicBoolean(false);
        this.mConfig = r3;
        this.mDeviceManager = r4;
        this.mAppStateListener = r5;
        this.mHandler = new Handler(ExecutorUtil.getLooper(), this);
        this.mEnv = r6;
        this.mObservers = new NetworkObserver(r3.getContext());
    }

    void start(boolean r2) {
        register(this.mEnv, r2);
        active();
    }

    boolean changeEnv(Env r2, boolean r3) {
        if (this.mEnv.equals(r2) == false) goto L6;
        return false;
    L6:
        this.mEnv = r2;
        this.mDeviceManager.changeEnv(r2, r3);
        return true;
    }

    boolean reStart(Env r4, boolean r5, boolean r6) {
        if (changeEnv(r4, r6) == true) goto L7;
        if (r5 == true) goto L7;
        DrLog.e("the env is the same with before,ignore." + r4);
        return false;
    L7:
        this.mHandler.removeMessages(MSG_WORK_ONE);
        this.mDeviceManager.reloadHeaderSstLoader();
        if (this.mHandler.hasMessages(MSG_BG_START) == false) goto L10;
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(MSG_BG_START, true));
    L15:
        return true;
    L10:
        Register r7 = new Register(this.mConfig, this.mDeviceManager, r4, this.mAppStateListener);
        workImmediately(r7);
        this.mRegisterWorker = r7;
        if (this.mConfig.isAutoActive() == false) goto L15;
        if (this.mActive.get() == false) goto L15;
        activeImmediately(new Activator(this.mConfig, r4));
        goto L15
    }

    void activeManually() {
        DrLog.d("dispatcher#activeManually");
        long r0 = System.currentTimeMillis();
        if ((r0 - this.mFetchActiveTime) >= 900000) goto L5;
        return;
    L5:
        if (NetUtils.isNetReady(this.mConfig.getContext()) == false) goto L10;
        this.mFetchActiveTime = r0;
        activeImmediately(new Activator(this.mConfig, this.mEnv));
        return;
    }

    private void active() {
        if (this.mConfig.isAutoActive() == true) goto L5;
        return;
    L5:
        final Runnable r0 = new AnonymousClass1(this);
        this.mAppStateListener.setOnResumeListener(new AnonymousClass2(this, r0));
        if (this.mConfig.isDirectActive() == false) goto L9;
        DrLog.d("dispatcher#active isActive");
        r0.run();
        return;
    L9:
        if (this.mAppStateListener.isActive() == false) goto L13;
        DrLog.d("dispatcher#active isActive");
        r0.run();
        return;
    }

    private void register(Env r5, boolean r6) {
        ExecutorUtil.runOnNetExecutor(new AnonymousClass3(this));
        if (this.mDeviceManager.load() == false) goto L14;
        Register r0 = new Register(this.mConfig, this.mDeviceManager, r5, this.mAppStateListener);
        CallbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
        if (r6 == false) goto L7;
    L12:
        r0.setImmediately();
    L13:
        workAndPostAgain(r0);
        this.mRegisterWorker = r0;
        return;
    L7:
        if (this.mDeviceManager.isUpgrade() == true) goto L12;
        if (this.mDeviceManager.isDiffChannel() == true) goto L12;
        if (this.mDeviceManager.isDiffAid() == false) goto L13;
    L14:
        this.mHandler.removeMessages(MSG_BG_START);
        Handler r4 = this.mHandler;
        r4.sendMessageDelayed(r4.obtainMessage(MSG_BG_START, Boolean.valueOf(r6)), 1000);
    }

    private void workAndPostAgain(final BaseWorker r2) {
        ExecutorUtil.runOnNetExecutor(new AnonymousClass4(this, r2));
    }

    private void activeImmediately(Activator r4) {
        DrLog.d("dispatcher#activeImmediately");
        this.mActive.set(true);
        Activator r0 = this.mActivator;
        if (r0 == null) goto L6;
        if (r4 == null) goto L6;
        r0.stop();
        this.mHandler.removeMessages(MSG_WORK_ONE, this.mActivator);
    L6:
        this.mActivator = r4;
        workImmediately(r4);
    }

    private void workImmediately(BaseWorker r2) {
        workImmediately(r2, false);
    }

    private void workImmediately(BaseWorker r3, boolean r4) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L12;
        if (r3 == null) goto L13;
        r0.removeMessages(MSG_WORK_ONE, r3);
        Message r5 = this.mHandler.obtainMessage(MSG_WORK_ONE, r3.setImmediately());
        if (r4 == true) goto L8;
    L10:
        this.mHandler.sendMessage(r5);
        return;
    L8:
        if (Looper.myLooper() != this.mHandler.getLooper()) goto L10;
        handleMessage(r5);
        return;
    L13:
        return;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r3) {
        int r0 = r3.what;
        if (r0 != MSG_BG_START) goto L5;
        register(this.mEnv, ((Boolean) r3.obj).booleanValue());
        return false;
    L5:
        if (r0 != MSG_WORK_ONE) goto L18;
        BaseWorker r4 = (BaseWorker) r3.obj;
        if (checkSilenceBg(r4) == false) goto L11;
        return false;
    L11:
        if (r4.isStop() == true) goto L16;
        workAndPostAgain(r4);
        return false;
    L16:
        return false;
    L18:
        return false;
    }

    private boolean checkSilenceBg(BaseWorker r4) {
        if (this.mConfig.isSilenceInBackground() == true) goto L5;
        return false;
    L5:
        if (this.mAppStateListener.isForeground() == false) goto L7;
        return false;
    L7:
        if (DrLog.debug() == false) goto L9;
        DrLog.d("skip work " + r4 + " cause user set silent in bg.");
    L9:
        Handler r3 = this.mHandler;
        r3.sendMessageDelayed(r3.obtainMessage(MSG_WORK_ONE, r4), r4.silenceCheckInterval());
        return true;
    }

    void redoRegister() {
        Register r0 = this.mRegisterWorker;
        if (r0 == null) goto L6;
        workImmediately(r0, true);
        return;
    }
}
