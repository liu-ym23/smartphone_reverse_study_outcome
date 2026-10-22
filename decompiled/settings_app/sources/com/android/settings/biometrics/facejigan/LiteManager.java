package com.android.settings.biometrics.facejigan;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class LiteManager {
    private static final int EVENT_INIT = 1;
    private static final int EVENT_RESTOREFEATURE = 3;
    private static final int EVENT_SAVEFEATURE = 2;
    private static final String TAG = "LiteManager";
    private static LiteManager sInstance;
    List<CachedNV21> caches;
    private Context mContext;
    private HashMap<String, Integer> mExtractMap;
    private AtomicInteger mFeatureSaveState;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private HashMap<String, Integer> mLiveTypeMap;
    private Handler mUIHandler;
    private Handler.Callback mUIHanlderCallback;
    long totalSize;

    protected class CachedNV21 {
        byte[] data;
        int h;
        String name;
        String path;
        final /* synthetic */ LiteManager this$0;
        int w;

        protected CachedNV21(LiteManager r1) {
            this.this$0 = r1;
        }
    }

    public interface Callback {
        void onError(String r1);

        void onFailed(int r1, Object r2);

        void onSuccess(Object r1);
    }

    private static class State {
        public static final int FAILED = 2;
        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int SUCCESS = 3;
        public static final int TIMEOUT = 4;

        private State() {
        }
    }

    public int deleteFeature(int r1) {
        return -1;
    }

    static /* synthetic */ void access$000(LiteManager r0, int r1, Object r2, Callback r3) {
        r0.callbackToCaller(r1, r2, r3);
    }

    static /* synthetic */ void access$100(LiteManager r0, int r1) {
        r0.setFeatureSaveState(r1);
    }

    public static LiteManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(LiteManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new LiteManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(LiteManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private LiteManager() {
        this.mLiveTypeMap = new HashMap();
        this.mExtractMap = new HashMap();
        this.mFeatureSaveState = new AtomicInteger(0);
        this.caches = new ArrayList();
        this.totalSize = 0;
        this.mLiveTypeMap.put("NONE", 0);
        this.mLiveTypeMap.put("CPU", 1);
        this.mLiveTypeMap.put("SNPE", 2);
        this.mLiveTypeMap.put("OPENCL", 3);
        this.mLiveTypeMap.put("NPU", 4);
        this.mLiveTypeMap.put("DSP", 5);
        this.mExtractMap.put("SINGLE_CORE_NORMAL", 0);
        this.mExtractMap.put("DOUBLE_CORE_NORMAL", 1);
        this.mExtractMap.put("OPENCL", 2);
        this.mExtractMap.put("DSP", 3);
        this.mExtractMap.put("APU", 4);
    }

    public void initLite(Context r1, Callback r2) {
        if (r1 != null) goto L5;
        OLog.e(TAG, "context is null");
        r2.onError("context is null");
        return;
    L5:
        initManager(r1);
    }

    private void initManager(Context r3) {
        OLog.d(TAG, "initManager()...");
        if (this.mHandlerThread != null) goto L6;
        HandlerThread r0 = new HandlerThread(TAG);
        this.mHandlerThread = r0;
        r0.start();
    L6:
        if (this.mHandler != null) goto L8;
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    L8:
        Context r4 = r3.getApplicationContext();
        this.mContext = r4;
        initUIHandler(r4);
    }

    private void initUIHandler(Context r3) {
        OLog.d(TAG, "initUIHandler()...");
        this.mUIHanlderCallback = new AnonymousClass1(this);
        this.mUIHandler = new Handler(r3.getMainLooper(), this.mUIHanlderCallback);
    }

    private void sendResultMessage(int r2, Callback r3, int r4) {
        Message.obtain(this.mUIHandler, r4, r2, -1, r3).sendToTarget();
    }

    private void callbackToCaller(int r1, Object r2, Callback r3) {
        r3.onFailed(r1, r2);
    }

    public boolean canSaveFeature() {
        if (this.mFeatureSaveState.get() != 0) goto L5;
    L8:
        return true;
    L5:
        if (2 == this.mFeatureSaveState.get()) goto L8;
        return false;
    }

    private void setFeatureSaveState(int r1) {
        this.mFeatureSaveState.set(r1);
    }

    private void resetManager() {
        OLog.d(TAG, "resetManager()...");
        setFeatureSaveState(0);
        Handler r2 = this.mUIHandler;
        if (r2 == null) goto L6;
        r2.removeCallbacksAndMessages(null);
        return;
    }

    void addSavedNV21(byte[] r5, int r6, int r7, String r8, String r9) {
        long r0 = this.totalSize;
        if (r0 <= 31457280) goto L5;
        return;
    L5:
        this.totalSize = r0 + ((long) r5.length);
        CachedNV21 r1 = new CachedNV21(this);
        r1.data = r5;
        r1.w = r6;
        r1.h = r7;
        r1.path = r8;
        r1.name = r9;
        this.caches.add(r1);
    }
}
