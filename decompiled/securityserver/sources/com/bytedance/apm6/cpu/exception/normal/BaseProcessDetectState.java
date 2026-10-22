package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionJudgeHelper;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.CpuLoadCollector;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.watson.assist.api.IAssistStat;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseProcessDetectState extends BaseCpuExceptionState {
    public CpuExceptionConfig config;
    private AsyncTask detectTask;
    protected boolean isBackground;

    public BaseProcessDetectState(CpuExceptionStateMachine r1) {
        super(r1);
    }

    public static /* synthetic */ void access$000(BaseProcessDetectState r0) {
        r0.judgeCpuLoad();
    }

    private void judgeCpuLoad() {
        if (CpuExceptionJudgeHelper.isNeedSkipJudge() == true) goto L5;
        double r0 = CpuLoadCollector.collectSpeed();
        IAssistStat r2 = this.machine.getAssistStat();
        if (r2 == null) goto L13;
        boolean r3 = r2.isCpuAbnormalProcess((float) r0);
        if (r3 == false) goto L14;
        r3 = CpuExceptionJudgeHelper.judge(this.config, r0, this.isBackground);
    L14:
        cpuExceptionLog("run judge process cpu usage task, is over max threshold?: " + r3 + " speed: " + r0 + ", back max speed: " + this.config.getMaxProcessBackCpuSpeed() + ", fore max speed: " + this.config.getMaxProcessForeCpuSpeed());
        if (reactAfterJudge(r3) == false) goto L19;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        return;
    L19:
        return;
    L13:
        r3 = CpuExceptionJudgeHelper.judge(this.config, r0, this.isBackground);
        goto L14
    L5:
        if (reactOnSkip() == false) goto L18;
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r7, boolean r8) {
        super.onEnterThisState(r7, r8);
        this.config = r7;
        this.isBackground = r8;
        Logger.i(Constants.TAG, "enter : " + provideType() + " provideDetectInterval : " + provideDetectInterval() + " isBack : " + r8);
        AsyncTask r9 = this.detectTask;
        if (r9 != null) goto L5;
        final long r2 = provideDetectInterval();
        final long r4 = provideDetectInterval();
        this.detectTask = new AnonymousClass1(this, r2, r4);
    L6:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).sendTask(this.detectTask);
        return;
    L5:
        r9.refresh(provideDetectInterval(), provideDetectInterval());
        goto L6
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r2) {
        super.onLifeCycleChange(r2);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
        this.machine.onIdle();
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.CPU).removeTask(this.detectTask);
    }

    public abstract long provideDetectInterval();

    public abstract boolean reactAfterJudge(boolean r1);

    public abstract boolean reactOnSkip();
}
