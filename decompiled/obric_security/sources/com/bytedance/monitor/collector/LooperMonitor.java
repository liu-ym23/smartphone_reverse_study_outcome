package com.bytedance.monitor.collector;

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
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
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
    private static volatile boolean sInited;
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
    L16:
        initLooperPrinterUtils();
        return;
    L11:
        if (LooperObserverMonitor.init() == false) goto L16;
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L15:
        LooperObserverMonitor.addMessageObserver(sObserver);
    }

    public static void setFirstListener(AbsLooperDispatchListener r0) {
        mFirstListener = r0;
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

    public static void blockLooperMonitor() {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mBlocked == false) goto L8;
        return;
    L8:
        if (SamplerHelper.getPerfSecondStageSwitch("block_monitor") == false) goto L10;
        return;
    L10:
        if (Util.enableLooperObserver == true) goto L12;
    L17:
        LooperPrinterUtils.removeMessageLogging(sPrinter);
    L18:
        mBlocked = true;
        return;
    L12:
        if (LooperObserverMonitor.init() == false) goto L17;
        if (ApmContext.isDebugMode() == false) goto L16;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L16:
        LooperObserverMonitor.removeMessageObserver(sObserver);
        goto L18
    }

    public static int getLisenerSize() {
        return listeners.size();
    }

    public static void unBlockLooperMonitor() {
        if (sInited == true) goto L5;
        return;
    L5:
        if (mBlocked == true) goto L8;
        return;
    L8:
        if (Util.enableLooperObserver == true) goto L10;
    L15:
        initLooperPrinterUtils();
    L16:
        mBlocked = false;
        return;
    L10:
        if (LooperObserverMonitor.init() == false) goto L15;
        if (ApmContext.isDebugMode() == false) goto L14;
        Logger.i(TAG, "enable Looper Observer monitor.");
    L14:
        LooperObserverMonitor.addMessageObserver(sObserver);
        goto L16
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
        r0.remove(r1);     // Catch: Throwable -> L15
        if (MainThreadMonitor.getMonitor().isEnableLooperOpt() == true) goto L9;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L9:
        if (r0.isEmpty() == false) goto L13;
        if (MainThreadMonitor.getMonitor().getObservers() != 0) goto L13;
        blockLooperMonitor();     // Catch: Throwable -> L15
    L15:
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
        if (listeners.isEmpty() == false) goto L16;
        if (r0 != 0) goto L17;
        blockLooperMonitor();
        return;
    L17:
        return;
    }

    public static void dispatch(boolean r9, String r10, Message r11) {
        long r1 = System.nanoTime();
        AbsLooperDispatchListener.uptime = r1 / 1000000;
        AbsLooperDispatchListener.cpuTime = SystemClock.currentThreadTimeMillis();
        if (r9 == false) goto L45;
        AbsLooperDispatchListener r3 = mFirstListener;
        if (r3 == null) goto L45;
        if (r3.isValid() == false) goto L45;
        mFirstListener.dispatchStart(r10);
    L45:
        CopyOnWriteArrayList<AbsLooperDispatchListener> r5 = listeners;     // Catch: Exception -> L44
        int r6 = 0;
    L11:
        if (r6 >= r5.size()) goto L29;
        AbsLooperDispatchListener r7 = r5.get(r6);     // Catch: Exception -> L44
        if (r7 != null) goto L16;
    L24:
        if (r9 == true) goto L28;
        if (r7.isHasDispatchStart == false) goto L28;
        r7.dispatchEnd("", null);     // Catch: Exception -> L44
    L28:
        r6 = r6 + 1;
        goto L11
    L16:
        if (r7.isValid() == false) goto L24;
        if (r9 == false) goto L22;
        if (r7.isHasDispatchStart == true) goto L28;
        r7.dispatchStart(r10);     // Catch: Exception -> L44
        goto L28
    L22:
        if (r7.isHasDispatchStart == false) goto L28;
        r7.dispatchEnd(r10, r11);     // Catch: Exception -> L44
    L29:
        if (r9 == true) goto L36;
        AbsLooperDispatchListener r12 = mFirstListener;
        if (r12 == null) goto L36;
        if (r12.isValid() == false) goto L36;
        mFirstListener.dispatchEnd("", null);
    L36:
        if (enableLooperCostMonitor == false) goto L55;
        cost += System.nanoTime() - r1;
        int r13 = count;
        count = r13 + 1;
        if (r13 >= 1000) goto L40;
        return;
    L40:
        if (iReporter == null) goto L42;
        iReporter.reportCost(cost);
    L42:
        count = 0;
        cost = 0;
        enableLooperCostMonitor = false;
        return;
    }
}
