package com.bytedance.apm6.cpu.exception;

import androidx.annotation.Nullable;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.service.lifecycle.ActivityLifecycleService;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.watson.assist.api.AssistStatFactory;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionStateMachine {
    private IAssistStat assistStat;
    private CpuExceptionConfig config;
    private ICpuExceptionState coolDownState;
    private ICpuExceptionState currentState;
    private ICpuExceptionState idleState;
    private boolean isBackground;
    private boolean isInit;
    private boolean isStart;
    private ActivityLifecycleService lifecycleService;
    private ICpuExceptionState processDetectState;
    private ICpuExceptionState processDoubleDetectState;
    private ICpuExceptionState threadDetectState;

    public CpuExceptionStateMachine(ActivityLifecycleService r2) {
        this.isStart = false;
        this.isInit = false;
        this.lifecycleService = r2;
    }

    private void changeState(ICpuExceptionState r3) {
        if (this.isStart == true) goto L5;
        return;
    L5:
        if (this.isInit == false) goto L17;
        this.currentState = r3;
        CpuExceptionConfig r0 = this.config;
        ActivityLifecycleService r1 = this.lifecycleService;
        if (r1 != null) goto L10;
    L13:
        boolean r2 = true;
    L14:
        r3.onEnterThisState(r0, r2);
        logState();
        return;
    L10:
        if (r1.isForeground() == false) goto L13;
        r2 = false;
        goto L14
    }

    private void logState() {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "change cpu exception detect state: " + this.currentState);
        return;
    }

    @Nullable
    public IAssistStat getAssistStat() {
        return this.assistStat;
    }

    public void init(ICpuExceptionState r2, ICpuExceptionState r3, ICpuExceptionState r4, ICpuExceptionState r5, ICpuExceptionState r6) {
        if (this.isInit == false) goto L5;
        return;
    L5:
        this.processDetectState = r2;
        this.processDoubleDetectState = r3;
        this.threadDetectState = r4;
        this.coolDownState = r5;
        this.idleState = r6;
        this.assistStat = AssistStatFactory.create(ApmContext.getContext());     // Catch: Throwable -> L9
    L7:
        this.isInit = true;
    }

    public synchronized void onCoolDown() {
        monitor-enter(this);
        changeState(this.coolDownState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onIdle() {
        monitor-enter(this);
        changeState(this.idleState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onLifeCycleChange(boolean r3) {
        monitor-enter(this);
        ICpuExceptionState r0 = this.currentState;     // Catch: Throwable -> L15
        if (r0 != null) goto L6;
    L17:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L17;
        if (this.isBackground != r3) goto L12;
        monitor-exit(this);
        return;
    L12:
        this.isBackground = r3;     // Catch: Throwable -> L15
        r0.onLifeCycleChange(r3);     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public synchronized void onProcessDetect() {
        monitor-enter(this);
        changeState(this.processDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onProcessDoubleDetect() {
        monitor-enter(this);
        changeState(this.processDoubleDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void onThreadDetect() {
        monitor-enter(this);
        changeState(this.threadDetectState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void start(CpuExceptionConfig r2) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isStart == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.isInit == false) goto L13;
        this.config = r2;     // Catch: Throwable -> L11
        this.isStart = true;     // Catch: Throwable -> L11
        CpuExceptionJudgeHelper.initScene(ApmCpuManager.getInstance().getCpuSceneString());     // Catch: Throwable -> L11
        this.isBackground = true ^ this.lifecycleService.isForeground();     // Catch: Throwable -> L11
        onProcessDetect();     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    public synchronized void stop() {
        monitor-enter(this);
        ICpuExceptionState r0 = this.currentState;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.isStart == false) goto L13;
        r0.onStopDetect();     // Catch: Throwable -> L11
        this.isStart = false;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
