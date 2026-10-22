package com.bytedance.apm.block.trace;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.Choreographer;
import android.view.Window;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.AbsLooperObserver;
import com.bytedance.apm.constant.CommonConsts;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.apm.core.ILifecycle;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.thread.AsyncEventManager;
import com.bytedance.apm.thread.ThreadWithBlockingQueue;
import com.bytedance.apm.thread.ThreadWithHandler;
import com.bytedance.monitor.collector.AbsLooperDispatchListener;
import com.bytedance.monitor.collector.LooperMonitor;
import com.bytedance.monitor.collector.PerfMonitorManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class MainThreadMonitor implements BeatLifecycle, ILifecycle {
    private static final String ADD_CALLBACK = "addCallbackLocked";
    public static final int CALLBACK_INPUT = 0;
    private static final String FRAME_CALLBACK_TOKEN = "FRAME_CALLBACK_TOKEN";
    private static final String TAG = "MainThreadMonitor";
    private static boolean blockDetectorAdded;
    private static AbsLooperObserver mFrameObserver;
    private static final MainThreadMonitor sInstance = null;
    private Method addInputQueue;
    private boolean callbackExist;
    private Object callbackQueueLock;
    private Object[] callbackQueues;
    Runnable callbackRunnable;
    private Choreographer choreographer;
    private long[] dispatchTimeMs;
    private volatile boolean isAlive;
    private boolean isBelongFrame;
    private boolean isBelongJavaMessage;
    private boolean isEnableFpsAllocOpt;
    public boolean isEnableLooperOpt;
    private boolean isInit;
    private HashMap<String, Window.OnFrameMetricsAvailableListener> listenerHashMap;
    private boolean mFpsLifeCycleChanged;
    private long[] mFrameInfo;
    private long mFrameTimeMs;
    private boolean mFullFpsTracer;
    final ThreadWithBlockingQueue mThreadWithBlockingQueue;
    final ThreadWithHandler mThreadWithHandler;
    public final MainThreadInfo mainThreadInfo;
    private final List<AbsLooperObserver> observers;

    /* JADX INFO: renamed from: com.bytedance.apm.block.trace.MainThreadMonitor$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ MainThreadMonitor this$0;
        final /* synthetic */ long val$begin;
        final /* synthetic */ long val$end;

        AnonymousClass2(MainThreadMonitor r1, long r2, long r4) {
            this.this$0 = r1;
            this.val$begin = r2;
            this.val$end = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator r0 = MainThreadMonitor.access$300(this.this$0).iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            ((AbsLooperObserver) r0.next()).doFrame(ActivityLifeObserver.getInstance().getTopActivityClassName(), this.val$begin, this.val$end);
            goto L4
        }
    }

    private boolean isNeedHookDoFrame() {
        return false;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onBackground(Activity r1) {
    }

    static /* synthetic */ boolean access$000(MainThreadMonitor r0) {
        return r0.isAlive;
    }

    static /* synthetic */ void access$100(MainThreadMonitor r0, String r1) {
        r0.dispatchBegin(r1);
    }

    static /* synthetic */ Method access$1002(MainThreadMonitor r0, Method r1) {
        r0.addInputQueue = r1;
        return r1;
    }

    static /* synthetic */ Method access$1100(MainThreadMonitor r0, Object r1, String r2, Class[] r3) {
        return r0.reflectChoreographerMethod(r1, r2, r3);
    }

    static /* synthetic */ void access$1200(MainThreadMonitor r0, Runnable r1) {
        r0.addFrameCallback(r1);
    }

    static /* synthetic */ boolean access$1300(MainThreadMonitor r0) {
        return r0.isBelongJavaMessage;
    }

    static /* synthetic */ boolean access$1400(MainThreadMonitor r0) {
        return r0.isEnableFpsAllocOpt;
    }

    static /* synthetic */ AbsLooperObserver access$1500() {
        return mFrameObserver;
    }

    static /* synthetic */ void access$200(MainThreadMonitor r0) {
        r0.dispatchEnd();
    }

    static /* synthetic */ List access$300(MainThreadMonitor r0) {
        return r0.observers;
    }

    static /* synthetic */ Object access$400(MainThreadMonitor r0) {
        return r0.callbackQueueLock;
    }

    static /* synthetic */ Object access$402(MainThreadMonitor r0, Object r1) {
        r0.callbackQueueLock = r1;
        return r1;
    }

    static /* synthetic */ Choreographer access$500(MainThreadMonitor r0) {
        return r0.choreographer;
    }

    static /* synthetic */ Object access$600(MainThreadMonitor r0, Object r1, String r2) {
        return r0.reflectObject(r1, r2);
    }

    static /* synthetic */ Object access$700(MainThreadMonitor r0, Object r1, String r2) {
        return r0.reflectHideObject(r1, r2);
    }

    static /* synthetic */ Object[] access$800(MainThreadMonitor r0) {
        return r0.callbackQueues;
    }

    static /* synthetic */ Object[] access$802(MainThreadMonitor r0, Object[] r1) {
        r0.callbackQueues = r1;
        return r1;
    }

    static /* synthetic */ long[] access$900(MainThreadMonitor r0) {
        return r0.mFrameInfo;
    }

    static /* synthetic */ long[] access$902(MainThreadMonitor r0, long[] r1) {
        r0.mFrameInfo = r1;
        return r1;
    }

    static {
        sInstance = new MainThreadMonitor();
    }

    public static MainThreadMonitor getMonitor() {
        return sInstance;
    }

    private MainThreadMonitor() {
        this.mainThreadInfo = new MainThreadInfo();
        this.dispatchTimeMs = new long[4];
        this.observers = new CopyOnWriteArrayList();
        this.mFpsLifeCycleChanged = false;
        this.mFullFpsTracer = false;
        this.isBelongFrame = false;
        this.isBelongJavaMessage = false;
        this.callbackExist = false;
        this.mThreadWithBlockingQueue = new ThreadWithBlockingQueue(CommonConsts.APM_INNER_LOOPER_COST);
        this.mThreadWithHandler = new ThreadWithHandler(CommonConsts.APM_INNER_LOOPER_COST);
        this.listenerHashMap = new HashMap();
        this.mFrameTimeMs = -1;
    }

    public boolean isInit() {
        return this.isInit;
    }

    public void start() {
        this.mThreadWithBlockingQueue.start();
        this.mThreadWithHandler.start();
    }

    public void init() {
        if (this.isInit == false) goto L6;
        return;
    L6:
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) goto L10;
        ActivityLifeObserver.getInstance().register(this);
        LooperMonitor.init();
        LooperMonitor.setFirstListener(new AnonymousClass1(this));
        this.isInit = true;
        return;
    L10:
        throw new AssertionError("must be init in main thread!");
    }

    public void setFullFpsTracer(boolean r1) {
        this.mFullFpsTracer = r1;
    }

    public void setFpsLifeCycleChange(boolean r1) {
        this.mFpsLifeCycleChanged = r1;
    }

    public ThreadWithHandler getThreadWithHandler() {
        return this.mThreadWithHandler;
    }

    public ThreadWithBlockingQueue getThreadWithBlockingQueue() {
        return this.mThreadWithBlockingQueue;
    }

    public void addObserver(AbsLooperObserver r2) {
        if (this.isAlive == true) goto L6;
        onStart();
    L6:
        if (this.observers.contains(r2) == true) goto L11;
        this.observers.add(r2);
        if (this.isEnableLooperOpt == false) goto L12;
        LooperMonitor.unBlockLooperMonitor();
        return;
    L12:
        return;
    }

    public void setBlockDetectorAdded() {
        blockDetectorAdded = true;
    }

    public boolean isBlockDetectorAdded() {
        return blockDetectorAdded;
    }

    public void removeObserver(AbsLooperObserver r2) {
        this.observers.remove(r2);
        if (this.isEnableLooperOpt == false) goto L10;
        if (getObservers() == 0) goto L7;
        return;
    L7:
        if (LooperMonitor.getLisenerSize() != 0) goto L14;
        LooperMonitor.blockLooperMonitor();
        return;
    L14:
        return;
    L10:
        if (this.observers.isEmpty() == false) goto L16;
        onStop();
        return;
    }

    public int getObservers() {
        int r0 = this.observers.size();
        boolean r1 = SamplerHelper.getPerfSecondStageSwitch("block_monitor");
        if (isBlockDetectorAdded() == false) goto L7;
        if (r1 == false) goto L6;
        return r0;
    L6:
        return r0 - 1;
    L7:
        return r0;
    }

    private void dispatchBegin(String r7) {
        this.isBelongJavaMessage = true;
        int r3 = 0;
        this.dispatchTimeMs[0] = AbsLooperDispatchListener.uptime;
        this.dispatchTimeMs[2] = AbsLooperDispatchListener.cpuTime;
        List<AbsLooperObserver> r6 = this.observers;
        int r0 = r6.size();
    L3:
        if (r3 >= r0) goto L8;
        AbsLooperObserver r1 = r6.get(r3);
        if (r1.isDispatchBegin() == true) goto L7;
        r1.dispatchBegin(r7);
    L7:
        r3 = r3 + 1;
        goto L3
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void dispatchEnd() {
        boolean r11 = this.isBelongFrame;
        if (isNeedHookDoFrame() == true) goto L5;
    L12:
        char r12 = 1;
        this.dispatchTimeMs[1] = AbsLooperDispatchListener.uptime;
        this.dispatchTimeMs[3] = AbsLooperDispatchListener.cpuTime;
        List<AbsLooperObserver> r14 = this.observers;
        int r15 = r14.size();
        char r10 = 0;
        int r8 = 0;
    L13:
        if (r8 >= r15) goto L19;
        AbsLooperObserver r1 = r14.get(r8);
        if (r1.isDispatchBegin() == false) goto L18;
        long[] r2 = this.dispatchTimeMs;
        r1.dispatchEnd(r2[r10], r2[2], r2[r12], r2[3], r11);
    L18:
        r8 = r8 + 1;
        r10 = r10;
        r12 = 1;
        goto L13
    L19:
        this.mainThreadInfo.reset();
        this.isBelongJavaMessage = r10;
        return;
    L5:
        if (this.isBelongFrame == false) goto L12;
        doFrameEnd();
        long r3 = AbsLooperDispatchListener.uptime;
        if (this.mFrameInfo == null) goto L12;
        if (PerfMonitorManager.getInstance().getFrameCallback() == null) goto L11;
        PerfMonitorManager.getInstance().getFrameCallback().doFrame(this.mFrameInfo);
    L11:
        JankTracer.getInstance().doFrame(this.mFrameInfo, r3);
        goto L12
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStart() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (ApmContext.isMainProcessSimple() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.isInit == false) goto L18;
        if (this.isAlive == true) goto L13;
        this.isAlive = true;     // Catch: Throwable -> L19
    L13:
        if (isNeedHookDoFrame() == false) goto L15;
        addFrameCallback(this.callbackRunnable);     // Catch: Throwable -> L19
    L15:
        monitor-exit(this);
        return;
    L18:
        throw new RuntimeException("never init!");     // Catch: Throwable -> L19
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public synchronized void onStop() {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (ApmContext.isMainProcess() == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.isInit == false) goto L15;
        if (this.isAlive == false) goto L12;
        this.isAlive = false;     // Catch: Throwable -> L16
    L12:
        monitor-exit(this);
        return;
    L15:
        throw new RuntimeException("MainThreadMonitor is never init!");     // Catch: Throwable -> L16
    }

    private synchronized void addFrameCallback(Runnable r8) {
        monitor-enter(this);
    L23:
        th = move-exception;
        throw th;
    L4:
        if (this.isAlive == true) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.callbackExist == false) goto L31;
        monitor-exit(this);
        return;
    L31:
        Object r0 = this.callbackQueueLock;     // Catch: Exception -> L26 Throwable -> L23
        monitor-enter(r0);     // Catch: Exception -> L26 Throwable -> L23
        Method r1 = this.addInputQueue;     // Catch: Throwable -> L18
        if (r1 == null) goto L16;
        r1.invoke(this.callbackQueues[0], new Object[]{-1L, r8, null});     // Catch: Throwable -> L18
        this.callbackExist = true;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;     // Catch: Exception -> L26 Throwable -> L23
    L21:
        monitor-exit(this);
    }

    private void doFrameBegin() {
        this.isBelongFrame = true;
    }

    private void doFrameEnd() {
        addFrameCallback(this.callbackRunnable);
        this.isBelongFrame = false;
    }

    public void doInputCallbackHook() {
    L10:
        th = move-exception;
        this.callbackExist = false;
        throw th;
    L4:
        if (this.mFrameInfo != null) goto L6;
        this.mFrameTimeMs = AbsLooperDispatchListener.uptime;     // Catch: Throwable -> L10
    L7:
        doFrameBegin();     // Catch: Throwable -> L10
        this.callbackExist = false;
        return;
    L6:
        this.mFrameTimeMs = this.mFrameInfo[2] / 1000000;     // Catch: Throwable -> L10
        goto L7
    }

    @Override // com.bytedance.apm.block.trace.BeatLifecycle
    public boolean isAlive() {
        return this.isAlive;
    }

    private <T> T reflectObject(Object r1, String r2) {
        Field r0 = r1.getClass().getDeclaredField(r2);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (T) r0.get(r1);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private <T> T reflectHideObject(Object r6, String r7) {
        Field r5 = (Field) Class.class.getDeclaredMethod("getDeclaredField", new Class[]{String.class}).invoke(r6.getClass(), new Object[]{r7});     // Catch: Exception -> L4
        r5.setAccessible(true);     // Catch: Exception -> L4
        return (T) r5.get(r6);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private Method reflectChoreographerMethod(Object r1, String r2, Class<?>... r3) {
        Method r0 = r1.getClass().getDeclaredMethod(r2, r3);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return r0;
    L4:
        return null;
    }

    public static Method reflectHideMethod(Class r7, String r8, Class<?>... r9) {
        Method r10 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r7, new Object[]{r8, r9});     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
        return r10;
    L4:
        return null;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onFront(Activity r2) {
        if (this.choreographer == null) goto L6;
        return;
    L6:
        if (isNeedHookDoFrame() == false) goto L13;
        this.choreographer = Choreographer.getInstance();     // Catch: Exception -> L10
    L8:
        AsyncEventManager.getInstance().post(new AnonymousClass3(this));
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityCreated(Activity r3, Bundle r4) {
        Window r5 = r3.getWindow();     // Catch: Exception -> L9
        final Window.Callback r1 = r5.getCallback();     // Catch: Exception -> L9
        r5.setCallback(new AnonymousClass4(this, r1));     // Catch: Exception -> L9
        final String r0 = r3.getClass().getName();     // Catch: Exception -> L9
        String r6 = r3.toString();     // Catch: Exception -> L9
        LooperMonitor.checkLooperState();     // Catch: Exception -> L9
        if (this.mFpsLifeCycleChanged == false) goto L6;
        return;
    L6:
        if (this.mThreadWithHandler.isReady() == false) goto L12;
        Window.OnFrameMetricsAvailableListener r2 = new AnonymousClass5(this, r0);     // Catch: Exception -> L9
        this.listenerHashMap.put(r6, r2);     // Catch: Exception -> L9
        r5.addOnFrameMetricsAvailableListener(r2, this.mThreadWithHandler.mRealHandler);     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityDestroyed(Activity r2) {
        Window.OnFrameMetricsAvailableListener r1 = this.listenerHashMap.remove(r2.toString());     // Catch: Exception -> L6
        if (r1 == null) goto L9;
        r2.getWindow().removeOnFrameMetricsAvailableListener(r1);     // Catch: Exception -> L6
        return;
    L9:
        return;
    }

    @Override // com.bytedance.apm.core.ILifecycle
    public void onActivityResumed(Activity r4) {
        if (this.mFpsLifeCycleChanged == true) goto L15;
        return;
    L15:
        Window r0 = r4.getWindow();     // Catch: Exception -> L14
        final String r1 = r4.getClass().getName();     // Catch: Exception -> L14
        String r5 = r4.toString();     // Catch: Exception -> L14
        HashMap<String, Window.OnFrameMetricsAvailableListener> r2 = this.listenerHashMap;     // Catch: Exception -> L14
        if (r2 == null) goto L11;
        if (r2.containsKey(r5) == false) goto L11;
        return;
    L11:
        if (this.mThreadWithHandler.isReady() == false) goto L17;
        Window.OnFrameMetricsAvailableListener r3 = new AnonymousClass6(this, r1);     // Catch: Exception -> L14
        this.listenerHashMap.put(r5, r3);     // Catch: Exception -> L14
        r0.addOnFrameMetricsAvailableListener(r3, this.mThreadWithHandler.mRealHandler);     // Catch: Exception -> L14
        return;
    L17:
        return;
    }

    public void setEnableFpsAllocOpt(boolean r1) {
        this.isEnableFpsAllocOpt = r1;
    }

    public void setEnableLooperOpt(boolean r1) {
        this.isEnableLooperOpt = r1;
    }

    public boolean isEnableLooperOpt() {
        return this.isEnableLooperOpt;
    }

    public void setFrameObserver(AbsLooperObserver r1) {
        mFrameObserver = r1;
    }
}
