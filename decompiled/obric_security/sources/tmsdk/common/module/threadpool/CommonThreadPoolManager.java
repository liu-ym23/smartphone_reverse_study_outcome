package tmsdk.common.module.threadpool;

import android.content.Context;
import android.os.HandlerThread;
import java.util.List;
import tmsdk.common.creator.BaseManagerC;
import tmsdkobf.e7;
import tmsdkobf.f7;
import tmsdkobf.g7;
import tmsdkobf.o2;

/* JADX INFO: loaded from: classes5.dex */
public class CommonThreadPoolManager extends BaseManagerC {
    private o2 b;

    public CommonThreadPoolManager() {
    }

    public void addCostTimeTask(Runnable r8, String r9, long r10) {
        this.b.a(r8, r9, r10, false, null);
    }

    public void addTask(int r9, Runnable r10, String r11, long r12) {
        this.b.a(r9, r10, r11, r12, false, null);
    }

    public void addThreadPoolInfoObserver(e7 r1) {
        this.b.addThreadPoolInfoObserver(r1);
    }

    public void addThreadPoolStatusObserver(f7 r1) {
        this.b.addThreadPoolStatusObserver(r1);
    }

    public void addUrgentTask(Runnable r8, String r9, long r10) {
        this.b.c(r8, r9, r10, false, null);
    }

    public void addUrgentWeakTask(Runnable r8, String r9, long r10, Object r12) {
        this.b.c(r8, r9, r10, true, r12);
    }

    public void addWeakTask(int r9, Runnable r10, String r11, long r12, Object r14) {
        this.b.a(r9, r10, r11, r12, true, r14);
    }

    public boolean containsTask(Runnable r1) {
        return this.b.containsTask(r1);
    }

    public boolean containsTaskOfCaller(long r1) {
        return this.b.containsTaskOfCaller(r1);
    }

    public List<g7> getRunningTasks() {
        return this.b.getRunningTasks();
    }

    public Thread getRunningThread(Runnable r1) {
        return this.b.getRunningThread(r1);
    }

    public void interruptTask(Runnable r1) {
        this.b.interruptTask(r1);
    }

    public boolean isTaskAwaiting(Runnable r1) {
        return this.b.isTaskAwaiting(r1);
    }

    public boolean isTaskRunning(Runnable r1) {
        return this.b.isTaskRunning(r1);
    }

    public boolean isThreadPoolBusy() {
        return this.b.isThreadPoolBusy();
    }

    public HandlerThread newFreeHandlerThread(String r1, int r2, long r3) {
        return this.b.newFreeHandlerThread(r1, r2, r3);
    }

    public Thread newFreeThread(Runnable r1, String r2, long r3) {
        return this.b.newFreeThread(r1, r2, r3);
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        o2 r0 = new o2();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void pauseThreadPool(long r1) {
        this.b.pauseThreadPool(r1);
    }

    public boolean removeTask(Runnable r1) {
        return this.b.removeTask(r1);
    }

    public void removeThreadPoolInfoListener(e7 r1) {
        this.b.removeThreadPoolInfoListener(r1);
    }

    public void removeThreadPoolStatusObserver(f7 r1) {
        this.b.removeThreadPoolStatusObserver(r1);
    }

    public boolean removeWeakTask(Runnable r1) {
        return this.b.removeTask(r1);
    }

    public void removeWeakTaskOfObject(Object r1) {
        this.b.a(r1);
    }

    public void shutdown() {
        this.b.shutdown();
    }

    public void wakeupThreadPool() {
        this.b.wakeupThreadPool();
    }

    public void addTask(Runnable r8, String r9, long r10) {
        this.b.b(r8, r9, r10, false, null);
    }

    public void addWeakTask(Runnable r8, String r9, long r10, Object r12) {
        this.b.b(r8, r9, r10, true, r12);
    }
}
