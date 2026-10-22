package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.normal.NormalCpuExceptionPolicy;
import com.bytedance.apm6.foundation.context.ApmContext;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionManager {
    private CpuExceptionConfig cpuConfig;
    private ApmCpuManager.ICpuExceptionListener exceptionListener;
    private ICpuExceptionPolicy exceptionPolicy;
    private ApmCpuManager.ICpuExceptionFilter filter;

    @Deprecated
    private boolean isForceOpen;
    private boolean isOpen;
    private long lastExceptionTimestamp;
    private boolean needFetchStack;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.exception.CpuExceptionManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class SingletonHolder {
        private static final CpuExceptionManager instance = null;

        static {
            instance = new CpuExceptionManager(null);
        }

        private SingletonHolder() {
        }

        public static /* synthetic */ CpuExceptionManager access$100() {
            return instance;
        }
    }

    public /* synthetic */ CpuExceptionManager(AnonymousClass1 r1) {
        this();
    }

    public static CpuExceptionManager getInstance() {
        return SingletonHolder.access$100();
    }

    @Deprecated
    public synchronized void forceOpen() {
        monitor-enter(this);
        this.isForceOpen = true;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void forceOpenNoStack() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isOpen == true) goto L13;
        CpuExceptionConfig r0 = this.cpuConfig;     // Catch: Throwable -> L11
        if (r0 == null) goto L13;
        this.isOpen = true;     // Catch: Throwable -> L11
        this.needFetchStack = false;     // Catch: Throwable -> L11
        this.exceptionPolicy.startDetect(r0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L13:
        monitor-exit(this);
    }

    public ApmCpuManager.ICpuExceptionFilter getExceptionFilter() {
        return this.filter;
    }

    public ApmCpuManager.ICpuExceptionListener getExceptionListener() {
        return this.exceptionListener;
    }

    public long getLastExceptionTimestamp() {
        return this.lastExceptionTimestamp;
    }

    public synchronized boolean needFetchStack() {
        monitor-enter(this);
        boolean r0 = this.needFetchStack;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void setCpuFilterListener(ApmCpuManager.ICpuExceptionFilter r1) {
        this.filter = r1;
    }

    public void setExceptionListener(ApmCpuManager.ICpuExceptionListener r1) {
        this.exceptionListener = r1;
    }

    public void setLastExceptionTimestamp(long r1) {
        this.lastExceptionTimestamp = r1;
    }

    public synchronized void stopForceOpenNoStack() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isOpen == true) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.needFetchStack == true) goto L13;
        this.isOpen = false;     // Catch: Throwable -> L11
        this.exceptionPolicy.stopDetect();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void updateConfig(CpuExceptionConfig r3) {
        monitor-enter(this);
        if (r3 != null) goto L29;
        monitor-exit(this);
        return;
    L29:
    L12:
        th = move-exception;
        throw th;
    L7:
        if (ApmContext.isMainProcess() == false) goto L9;
    L14:
        this.cpuConfig = r3;     // Catch: Throwable -> L12
        if (this.isForceOpen == false) goto L22;
        if (this.isOpen == true) goto L19;
        this.isOpen = true;     // Catch: Throwable -> L12
        this.needFetchStack = r3.isCollectThreadStack();     // Catch: Throwable -> L12
        this.exceptionPolicy.startDetect(r3);     // Catch: Throwable -> L12
    L19:
        monitor-exit(this);
        return;
    L22:
        if (r3.isOpen() == false) goto L24;
        this.isOpen = true;     // Catch: Throwable -> L12
        this.needFetchStack = r3.isCollectThreadStack();     // Catch: Throwable -> L12
        this.exceptionPolicy.startDetect(r3);     // Catch: Throwable -> L12
    L25:
        monitor-exit(this);
        return;
    L24:
        this.isOpen = false;     // Catch: Throwable -> L12
        this.exceptionPolicy.stopDetect();     // Catch: Throwable -> L12
        goto L25
    L9:
        if (r3.isCollectAllProcess() == true) goto L14;
        monitor-exit(this);
    }

    private CpuExceptionManager() {
        this.exceptionPolicy = new NormalCpuExceptionPolicy();
    }
}
