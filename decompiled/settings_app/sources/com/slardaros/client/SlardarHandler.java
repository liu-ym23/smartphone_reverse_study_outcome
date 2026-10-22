package com.slardaros.client;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
class SlardarHandler extends BaseHandler {
    public static final String APPINFO = "appinfo";
    public static final String IORAP = "iorap";
    private static final int MSG_ABRESULT = 8;
    private static final int MSG_APP_PROFILE = 9;
    private static final int MSG_EVENT = 2;
    private static final int MSG_EVENTS = 5;
    private static final int MSG_EXIT = 4;
    private static final int MSG_INIT = 1;
    private static final int MSG_PROFILE = 7;
    private static final int MSG_SLARDAR_SERVICE_CONNECTED = 3;
    private static final int MSG_UNBIND = 6;
    private static Object lock;
    private static Context sContext;
    public static SlardarHandler sInstance;
    public static int sProfileCode;
    private Context mContext;
    private WorkHandler mHandler;

    private static class WorkHandler extends Handler {
        private static final int MAX_CACHE_SIZE = 100;
        private List<Bundle> mAbResultCache;
        private SlardarServiceProxy.BindCallback mCallback;
        private volatile Context mContext;
        private List<AgentEvent> mEventsCache;
        private Map<String, Object> mGlobalParams;
        private AtomicBoolean mInitDone;
        private SlardarServiceProxy mServiceProxy;

        WorkHandler(Looper r2) {
            super(r2);
            this.mEventsCache = new ArrayList();
            this.mInitDone = new AtomicBoolean(false);
            this.mAbResultCache = new ArrayList();
            this.mCallback = new AnonymousClass1(this);
            SlardarServiceProxy r3 = SlardarServiceProxy.getSlardarServiceProxy(this);
            this.mServiceProxy = r3;
            r3.setBindCallback(this.mCallback);
            OLog.d(Constants.TAG, "WorkHandler onCreated");
        }

        public void setContext(Context r1) {
            this.mContext = r1;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r6) {
            OLog.d(Constants.TAG, "WorkHandler handle msg: " + r6.what);
            if (this.mServiceProxy != null) goto L6;
            return;
        L6:
            if (this.mContext != null) goto L8;
            setContext(SlardarHandler.access$000());
        L8:
            int r0 = r6.what;
            if (r0 != 1005) goto L11;
            OLog.d(Constants.TAG, "get message from server");
            SlardarHandler.sProfileCode = r6.arg1;
            return;
        L11:
            switch(r0) {
                case 2: goto L33;
                case 3: goto L32;
                case 4: goto L31;
                case 5: goto L30;
                case 6: goto L29;
                case 7: goto L25;
                case 8: goto L21;
                case 9: goto L13;
                default: goto L51;
            };
        L13:
            final AppProfile r7 = (AppProfile) r6.obj;
            if (SlardarUtil.isTargetDevice(this.mContext) == true) goto L18;
            SlardarHandler.sProfileCode = 3;
            return;
        L18:
            if (this.mServiceProxy.isServiceConnected() == false) goto L20;
            onProfile(r7, new Messenger(this));
            return;
        L20:
            onInit();
            postDelayed(new SlardarHandler$WorkHandler$$ExternalSyntheticLambda1(this, r7), 1000);
            return;
        L21:
            final Bundle r8 = r6.getData();
            OLog.d(Constants.TAG, "data: " + r8.toString());
            if (this.mServiceProxy.isServiceConnected() == false) goto L24;
            onAbResult(r8);
            return;
        L24:
            onInit();
            postDelayed(new SlardarHandler$WorkHandler$$ExternalSyntheticLambda2(this, r8), 1000);
            return;
        L25:
            final AppProfile r9 = (AppProfile) r6.obj;
            if (this.mServiceProxy.isServiceConnected() == false) goto L28;
            onProfile(r9, new Messenger(this));
            return;
        L28:
            onInit();
            postDelayed(new SlardarHandler$WorkHandler$$ExternalSyntheticLambda0(this, r9), 1000);
            return;
        L29:
            onUnbind();
            return;
        L30:
            onInit();
            onEvent((List) r6.obj);
            return;
        L31:
            onExit();
            return;
        L32:
            onTeaServiceConnected();
            return;
        L33:
            AgentEvent r10 = (AgentEvent) r6.obj;
            if (this.mServiceProxy.isServiceConnected() == false) goto L36;
            onEvent(r10);
            return;
        L36:
            onInit();
            cacheEvent(r10, true);
            return;
        }

        /* JADX INFO: renamed from: lambda$handleMessage$0$com-slardaros-client-SlardarHandler$WorkHandler, reason: not valid java name */
        /* synthetic */ void m1476xa3b90a76(AppProfile r2) {
            onProfile(r2, new Messenger(this));
        }

        /* JADX INFO: renamed from: lambda$handleMessage$1$com-slardaros-client-SlardarHandler$WorkHandler, reason: not valid java name */
        /* synthetic */ void m1477xa342a477(AppProfile r2) {
            onProfile(r2, new Messenger(this));
        }

        /* JADX INFO: renamed from: lambda$handleMessage$2$com-slardaros-client-SlardarHandler$WorkHandler, reason: not valid java name */
        /* synthetic */ void m1478xa2cc3e78(Bundle r1) {
            onAbResult(r1);
        }

        private void onAbResult(Bundle r2) {
            if (r2 != null) goto L5;
            return;
        L5:
            if (this.mServiceProxy.isServiceConnected() == false) goto L7;
            this.mServiceProxy.onAbResult(r2);
            return;
        L7:
            cacheData(r2, false);
            this.mServiceProxy.bindService(this.mContext);
        }

        private void onProfile(AppProfile r8, Messenger r9) {
            if (r8 != null) goto L7;
            OLog.d("Slardar", "onProfile profile is null");
            SlardarHandler.sProfileCode = 2;
            return;
        L7:
            if (this.mServiceProxy.isServiceConnected() == false) goto L9;
            OLog.d("Slardar", "onProfile");
            this.mServiceProxy.onProfile(r8, r9);
            return;
        L9:
            boolean r2 = false;
            int r3 = 0;
            boolean r4 = false;
        L11:
            if (r3 >= 5) goto L23;
            Thread.sleep(1000);     // Catch: InterruptedException -> L20
            if (this.mServiceProxy.isServiceConnected() == false) goto L18;
            this.mServiceProxy.onProfile(r8, r9);     // Catch: InterruptedException -> L20
        L24:
            if (r2 == false) goto L35;
            OLog.d("Slardar", "onProfile 2");
            SlardarHandler.sProfileCode = 2;
            return;
        L35:
            return;
        L18:
            if (r3 != 4) goto L22;
            r4 = true;
        L22:
            r3 = r3 + 1;
        L20:
            e = move-exception;
            e.printStackTrace();
            goto L22
        L23:
            r2 = r4;
            goto L24
        }

        private void onInit() {
            OLog.d(Constants.TAG, "isTargetDevice: " + SlardarUtil.isTargetDevice(this.mContext));
            if (SlardarUtil.isTargetDevice(this.mContext) == true) goto L5;
        L7:
            this.mInitDone.set(true);
            return;
        L5:
            if (this.mServiceProxy.isServiceConnected() == true) goto L7;
            OLog.d(Constants.TAG, "bindService");
            this.mServiceProxy.bindService(this.mContext);
            goto L7
        }

        private void onEvent(AgentEvent r5) {
            if (r5 != null) goto L5;
            return;
        L5:
            if (this.mInitDone.get() == true) goto L7;
        L18:
            OLog.i(Constants.TAG, "onEvent before Init=" + this.mInitDone.get());
            cacheEvent(r5, false);
            return;
        L7:
            if (hasMessages(3) == true) goto L18;
            if (SlardarUtil.isTargetDevice(this.mContext) == true) goto L14;
            OLog.i(Constants.TAG, "not target device.");
            onExit();
            return;
        L14:
            if (this.mServiceProxy.isServiceConnected() == false) goto L16;
            cacheEvent(r5, true);
            onEvent(this.mEventsCache);
            return;
        L16:
            cacheEvent(r5, false);
            this.mServiceProxy.bindService(this.mContext);
        }

        private void cacheEvent(AgentEvent r4, boolean r5) {
            if (r4 != null) goto L7;
            OLog.d(Constants.TAG, "cachEvent event is null ");
            return;
        L7:
            if (this.mEventsCache.size() < 100) goto L10;
            if (r5 == true) goto L10;
            this.mEventsCache.remove(0);
        L10:
            OLog.d(Constants.TAG, "cachEvent event:" + r4.toString());
            this.mEventsCache.add(r4);
        }

        private void cacheData(Bundle r3, boolean r4) {
            if (r3 != null) goto L5;
            return;
        L5:
            if (this.mAbResultCache.size() < 100) goto L8;
            if (r4 == true) goto L8;
            this.mAbResultCache.remove(0);
        L8:
            this.mAbResultCache.add(r3);
        }

        private void onTeaServiceConnected() {
            if (this.mEventsCache.isEmpty() == false) goto L6;
            return;
        L6:
            if (this.mServiceProxy.isServiceConnected() == false) goto L16;
            onEvent(this.mEventsCache);
            if (this.mAbResultCache.size() <= 0) goto L17;
            Iterator<Bundle> r0 = this.mAbResultCache.iterator();
        L11:
            if (r0.hasNext() == false) goto L13;
            Bundle r1 = r0.next();
            this.mServiceProxy.onAbResult(r1);
            goto L11
        L13:
            this.mAbResultCache.clear();
            return;
        L17:
            return;
        }

        private void onEvent(List<AgentEvent> r3) {
            if (r3 != null) goto L5;
        L18:
            OLog.d(Constants.TAG, "onEvents list empth");
            return;
        L5:
            if (r3.isEmpty() == true) goto L18;
            if (this.mServiceProxy.isServiceConnected() == true) goto L10;
            OLog.d(Constants.TAG, "onEvents add events to cache");
            Iterator<AgentEvent> r4 = r3.iterator();
        L14:
            if (r4.hasNext() == false) goto L16;
            cacheEvent(r4.next(), true);
            goto L14
        L16:
            this.mServiceProxy.bindService(this.mContext);
            return;
        L10:
            if (this.mServiceProxy.onEvent(r3) == false) goto L21;
            OLog.d(Constants.TAG, "onEvents done: ");
            r3.clear();
            return;
        }

        private void onUnbind() {
            this.mInitDone.set(false);
            OLog.d(Constants.TAG, "do onUnbind");
            SlardarServiceProxy r2 = this.mServiceProxy;
            if (r2 == null) goto L6;
            r2.unbindService();
            return;
        }

        private void onExit() {
            OLog.i(Constants.TAG, "Handler onExit...");
            List<AgentEvent> r0 = this.mEventsCache;
            if (r0 == null) goto L5;
            r0.clear();
            this.mEventsCache = null;
        L5:
            SlardarServiceProxy r1 = this.mServiceProxy;
            if (r1 == null) goto L8;
            r1.unbindService();
            this.mServiceProxy.setBindCallback(null);
            this.mServiceProxy = null;
        L8:
            this.mContext = null;
            SlardarHandler.sInstance = null;
        }
    }

    static /* synthetic */ Context access$000() {
        return sContext;
    }

    static {
        lock = new Object();
    }

    public static SlardarHandler getInstance() {
        Object r0 = lock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        OLog.d(Constants.TAG, "get new SlardarHandler");     // Catch: Throwable -> L10
        sInstance = new SlardarHandler();     // Catch: Throwable -> L10
    L7:
        SlardarHandler r1 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    }

    @Override // com.slardaros.client.BaseHandler
    public void init(Context r2) {
        if (r2 == null) goto L10;
        if (r2.getApplicationContext() == null) goto L7;
        r2 = r2.getApplicationContext();
    L7:
        this.mContext = r2;
        this.mHandler.setContext(r2);
        sContext = this.mContext;
        Message.obtain(this.mHandler, 1).sendToTarget();
        return;
    L10:
        throw new IllegalArgumentException("context can't be null when initing slardar agent.");
    }

    public Context getContext() {
        return this.mContext;
    }

    @Override // com.slardaros.client.BaseHandler
    public void onEvent(AgentEvent r2) {
        Message.obtain(this.mHandler, 2, r2).sendToTarget();
    }

    @Override // com.slardaros.client.BaseHandler
    public void onEvents(List<AgentEvent> r2) {
        Message.obtain(this.mHandler, 5, r2).sendToTarget();
    }

    @Override // com.slardaros.client.BaseHandler
    public boolean onRequestProfile(String r11, String r12, String r13, String r14, String r15, boolean r16) {
        Object r1 = lock;
        monitor-enter(r1);
        sProfileCode = 0;     // Catch: Throwable -> L31
        AppProfile r0 = new AppProfile(r11, r12, r13, r14, r15, r16);     // Catch: Throwable -> L31
        Message r3 = Message.obtain(this.mHandler, 7);     // Catch: Throwable -> L31
        r3.obj = r0;     // Catch: Throwable -> L31
        r3.sendToTarget();     // Catch: Throwable -> L31
        int r2 = 0;
    L8:
        if (r2 >= 100) goto L14;
        Thread.sleep(100);     // Catch: Throwable -> L22 Exception -> L24
        if (sProfileCode != 0) goto L14;
        r2 = r2 + 1;     // Catch: Throwable -> L22 Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L22
        sProfileCode = 0;     // Catch: Throwable -> L31
        return false;
    L22:
        th = move-exception;
        sProfileCode = 0;     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L14:
        OLog.d(SlardarAgent.TAG, " profile code: " + sProfileCode);     // Catch: Throwable -> L22 Exception -> L24
        boolean r4 = true;
        if (sProfileCode == 1) goto L19;
        r4 = false;
    L19:
        sProfileCode = 0;     // Catch: Throwable -> L31
        monitor-exit(r1);     // Catch: Throwable -> L31
        return r4;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.slardaros.client.BaseHandler
    public int onRequestAppProfile(String r11, String r12, String r13, String r14, String r15, boolean r16) {
        Object r1 = lock;
        monitor-enter(r1);
        sProfileCode = 0;     // Catch: Throwable -> L28
        AppProfile r0 = new AppProfile(r11, r12, r13, r14, r15, r16);     // Catch: Throwable -> L28
        Message r3 = Message.obtain(this.mHandler, 7);     // Catch: Throwable -> L28
        r3.obj = r0;     // Catch: Throwable -> L28
        r3.sendToTarget();     // Catch: Throwable -> L28
        int r2 = 0;
    L8:
        if (r2 >= 100) goto L14;
        Thread.sleep(100);     // Catch: Throwable -> L18 Exception -> L20
        if (sProfileCode != 0) goto L14;
        r2 = r2 + 1;     // Catch: Throwable -> L18 Exception -> L20
    L18:
        th = move-exception;
        sProfileCode = 0;     // Catch: Throwable -> L28
        throw th;     // Catch: Throwable -> L28
    L20:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L18
        sProfileCode = 0;     // Catch: Throwable -> L28
        return 3;
    L14:
        OLog.d(SlardarAgent.TAG, " app profile code: " + sProfileCode);     // Catch: Throwable -> L18 Exception -> L20
        int r4 = sProfileCode;     // Catch: Throwable -> L18 Exception -> L20
        sProfileCode = 0;     // Catch: Throwable -> L28
        monitor-exit(r1);     // Catch: Throwable -> L28
        return r4;
    L28:
        th = move-exception;
        throw th;
    }

    @Override // com.slardaros.client.BaseHandler
    public void onAbResult(String r3, int r4, String r5) {
        Message r2 = Message.obtain(this.mHandler, 8);
        Bundle r0 = new Bundle();
        r0.putString(Constants.MESSAGE_AB_FEATURE, r3);
        r0.putInt(Constants.MESSAGE_AB_RESULT, r4);
        r0.putString(Constants.MESSAGE_AB_PHASE, r5);
        r2.setData(r0);
        r2.sendToTarget();
    }

    @Override // com.slardaros.client.BaseHandler
    public void onExit() {
        Message.obtain(this.mHandler, 4).sendToTarget();
        this.mHandler.getLooper().quitSafely();
    }

    @Override // com.slardaros.client.BaseHandler
    public void onUnbind() {
        Message.obtain(this.mHandler, 6).sendToTarget();
    }

    public SlardarHandler() {
        HandlerThread r0 = new HandlerThread("SlardarHandler");
        r0.start();
        this.mHandler = new WorkHandler((Looper) Objects.requireNonNull(r0.getLooper()));
    }
}
