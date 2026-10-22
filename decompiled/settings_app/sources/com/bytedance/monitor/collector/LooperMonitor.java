package com.bytedance.monitor.collector;

import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Printer;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.ILooperObserver;
import com.bytedance.apm.block.LooperObserverMonitor;
import com.bytedance.apm.block.trace.MainThreadMonitor;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.LooperPrinterUtils;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class LooperMonitor {
    private static final char END = '<';
    private static final char START = '>';
    private static final String TAG = "LooperMonitor";
    private static long cost;
    private static int count;
    private static volatile boolean enableLooperCostMonitor;
    private static volatile IReporter iReporter;
    private static final CopyOnWriteArrayList<AbsLooperDispatchListener> listeners = null;
    private static boolean mBlocked;
    private static AbsLooperDispatchListener mFirstListener;
    private static boolean mLooperBlocked;
    private static AbsLooperDispatchListener mRealFirstListener;
    private static volatile boolean sInited;
    private static Printer sLooperUtilsPrinter;
    private static ILooperObserver sObserver;
    private static Printer sPrinter;
    private static List<Printer> tempPrinters;

    public interface IReporter {
        void reportCost(long r1);
    }

    public LooperMonitor() {
    }

    static {
        listeners = new CopyOnWriteArrayList();
        enableLooperCostMonitor = false;
        cost = 0;
        count = 0;
    }

    public static void enableLooperCostMonitor(boolean r0) {
        enableLooperCostMonitor = r0;
    }

    public static void setReporter(IReporter r0) {
        iReporter = r0;
    }

    public static void init() {
        if (Util.enable == false) goto L6;
        return;
    L6:
        if (sInited == false) goto L8;
        return;
    L8:
        sInited = true;
        sPrinter = new AnonymousClass1();
        sObserver = new AnonymousClass2();
        if (Util.enableLooperObserver == true) goto L11;
    L19:
        initLooperPrinterUtils();
        return;
    L11:
        if (LooperObserverMonitor.init(sPrinter) == false) goto L19;
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L16:
        if (LooperObserverMonitor.isUsePrinter == false) goto L18;
        initLooperPrinterUtils();
    L18:
        LooperObserverMonitor.addMessageObserver(sObserver);
    }

    public static void setFirstListener(AbsLooperDispatchListener r0) {
        mFirstListener = r0;
    }

    public static void setRealFirstListener(AbsLooperDispatchListener r0) {
        mRealFirstListener = r0;
        if (r0 == null) goto L6;
        unBlockLooperMonitor();
        return;
    }

    public static void destroy() {
        if (sInited == true) goto L5;
        return;
    L5:
        LooperPrinterUtils.removeMessageLogging(sPrinter);
    }

    public static void initLooperPrinterUtils() {
        LooperPrinterUtils.init();
        LooperPrinterUtils.addMessageLogging(sPrinter);
    }

    private static boolean realUseLooperObserver() {
        if (Util.enableLooperObserver == true) goto L5;
    L9:
        return false;
    L5:
        if (LooperObserverMonitor.init(sPrinter) == false) goto L9;
        if (LooperObserverMonitor.isUsePrinter == true) goto L9;
        return true;
    }

    public static void blockLooperMonitor() {
        if (sInited == false) goto L21;
        if (mBlocked == true) goto L21;
        if (mRealFirstListener != null) goto L21;
        if (SamplerHelper.getPerfSecondStageSwitch("block_monitor") == true) goto L26;
        blockLooperPrinterObserver();
        if (realUseLooperObserver() == true) goto L14;
        LooperPrinterUtils.removeMessageLogging(sPrinter);
    L18:
        mBlocked = true;
        return;
    L14:
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L16:
        LooperObserverMonitor.removeMessageObserver(sObserver);
        goto L18
    L26:
        return;
    L21:
        if (mBlocked == true) goto L23;
        return;
    L23:
        if (mLooperBlocked == true) goto L28;
        blockLooperPrinterObserver();
        return;
    }

    public static void blockLooperPrinterObserver() {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mLooperBlocked == false) goto L7;
        return;
    L7:
        if (Util.enableLooperOpt == true) goto L10;
        return;
    L10:
        if (realUseLooperObserver() == false) goto L18;
        List<ILooperObserver> r0 = LooperObserverMonitor.getObservers();
        if (r0 == null) goto L28;
        if (r0.size() != 1) goto L28;
        if (r0.get(0) != sObserver) goto L28;
        LooperObserverMonitor.removeMessageObserverWrapper();
        mLooperBlocked = true;
    L28:
        if (ApmContext.isDebugMode() == false) goto L33;
        Logger.i(TAG, "enable Looper Observer block.");
        return;
    L33:
        return;
    L18:
        List<Printer> r1 = LooperPrinterUtils.getPrinters();
        if (r1 == null) goto L28;
        if (r1.size() != 1) goto L28;
        if (r1.get(0) != sPrinter) goto L28;
        Printer r2 = getCurrentPrinter();
        sLooperUtilsPrinter = r2;
        if (r2 == null) goto L28;
        Looper.getMainLooper().setMessageLogging(null);
        mLooperBlocked = true;
        goto L28
    }

    private static Printer getCurrentPrinter() {
        Field r0 = Class.forName("android.os.Looper").getDeclaredField("mLogging");     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return (Printer) r0.get(Looper.getMainLooper());
    L4:
        return null;
    }

    public static int getLisenerSize() {
        return listeners.size();
    }

    public static void unBlockLooperMonitor() {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mBlocked == false) goto L17;
        unBlockLooperPrinterObserver(false);
        if (realUseLooperObserver() == true) goto L10;
        initLooperPrinterUtils();
    L14:
        mBlocked = false;
        return;
    L10:
        if (ApmContext.isDebugMode() == false) goto L12;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L12:
        LooperObserverMonitor.addMessageObserver(sObserver);
        goto L14
    }

    public static void unBlockLooperPrinterObserver(boolean r1) {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mLooperBlocked == true) goto L7;
        return;
    L7:
        if (Util.enableLooperOpt == true) goto L10;
        return;
    L10:
        if (realUseLooperObserver() == false) goto L14;
        if (r1 == false) goto L14;
        return;
    L14:
        if (realUseLooperObserver() == false) goto L17;
        LooperObserverMonitor.addMessageObserverWrapper();
    L20:
        if (ApmContext.isDebugMode() == false) goto L22;
        Logger.i(TAG, "enable Looper Observer unblock.");
    L22:
        mLooperBlocked = false;
        return;
    L17:
        if (sLooperUtilsPrinter == null) goto L20;
        Looper.getMainLooper().setMessageLogging(sLooperUtilsPrinter);
        goto L20
    }

    public static void register(AbsLooperDispatchListener r2) {
        CopyOnWriteArrayList<AbsLooperDispatchListener> r0 = listeners;
        monitor-enter(r0);
        if (r2 != null) goto L15;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r0.contains(r2) == true) goto L10;
        r0.add(r2);     // Catch: Throwable -> L12
        if (MainThreadMonitor.getMonitor().isEnableLooperOpt() == false) goto L10;
        unBlockLooperMonitor();     // Catch: Throwable -> L12
        goto L10
    }

    public static void unregister(AbsLooperDispatchListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        CopyOnWriteArrayList<AbsLooperDispatchListener> r0 = listeners;
        monitor-enter(r0);
        r0.remove(r1);     // Catch: Throwable -> L17
        if (MainThreadMonitor.getMonitor().isEnableLooperOpt() == true) goto L9;
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L17
        return;
    L9:
        if (r0.isEmpty() == false) goto L15;
        if (MainThreadMonitor.getMonitor().getObservers() != 0) goto L15;
        if (mRealFirstListener != null) goto L15;
        blockLooperMonitor();     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    public static void checkLooperState() {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mBlocked == false) goto L8;
        return;
    L8:
        if (MainThreadMonitor.getMonitor().isEnableLooperOpt() == true) goto L10;
        return;
    L10:
        int r0 = MainThreadMonitor.getMonitor().getObservers();
        if (listeners.isEmpty() == false) goto L18;
        if (r0 == 0) goto L14;
        return;
    L14:
        if (mRealFirstListener != null) goto L20;
        blockLooperMonitor();
        return;
    L20:
        return;
    }

    public static void dispatch(boolean r9, String r10, Message r11) {
        long r1 = System.nanoTime();
        AbsLooperDispatchListener.uptime = r1 / 1000000;
        AbsLooperDispatchListener.cpuTime = SystemClock.currentThreadTimeMillis();
        if (r9 == false) goto L9;
        AbsLooperDispatchListener r3 = mRealFirstListener;
        if (r3 == null) goto L9;
        if (r3.isValid() == false) goto L9;
        mRealFirstListener.dispatchStart(r10);
    L9:
        if (r9 == false) goto L57;
        AbsLooperDispatchListener r4 = mFirstListener;
        if (r4 == null) goto L57;
        if (r4.isValid() == false) goto L57;
        mFirstListener.dispatchStart(r10);
    L57:
        CopyOnWriteArrayList<AbsLooperDispatchListener> r5 = listeners;     // Catch: Exception -> L56
        int r6 = 0;
    L17:
        if (r6 >= r5.size()) goto L35;
        AbsLooperDispatchListener r7 = r5.get(r6);     // Catch: Exception -> L56
        if (r7 != null) goto L22;
    L30:
        if (r9 == true) goto L34;
        if (r7.isHasDispatchStart == false) goto L34;
        r7.dispatchEnd("", null);     // Catch: Exception -> L56
    L34:
        r6 = r6 + 1;
        goto L17
    L22:
        if (r7.isValid() == false) goto L30;
        if (r9 == false) goto L28;
        if (r7.isHasDispatchStart == true) goto L34;
        r7.dispatchStart(r10);     // Catch: Exception -> L56
        goto L34
    L28:
        if (r7.isHasDispatchStart == false) goto L34;
        r7.dispatchEnd(r10, r11);     // Catch: Exception -> L56
    L35:
        if (r9 == true) goto L41;
        AbsLooperDispatchListener r12 = mFirstListener;
        if (r12 == null) goto L41;
        if (r12.isValid() == false) goto L41;
        mFirstListener.dispatchEnd("", null);
    L41:
        if (r9 == true) goto L48;
        AbsLooperDispatchListener r13 = mRealFirstListener;
        if (r13 == null) goto L48;
        if (r13.isValid() == false) goto L48;
        mRealFirstListener.dispatchEnd("", null);
    L48:
        if (enableLooperCostMonitor == false) goto L67;
        cost += System.nanoTime() - r1;
        int r14 = count;
        count = r14 + 1;
        if (r14 >= 1000) goto L52;
        return;
    L52:
        if (iReporter == null) goto L54;
        iReporter.reportCost(cost);
    L54:
        count = 0;
        cost = 0;
        enableLooperCostMonitor = false;
        return;
    }
}
