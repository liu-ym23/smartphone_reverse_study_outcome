package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.cpu.exception.BaseCpuExceptionState;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;

/* JADX INFO: loaded from: classes.dex */
class NormalCoolDownState extends BaseCpuExceptionState {
    private static final long COOL_DOWN_INTERVAL = 120000;
    private static final long COOL_DOWN_INTERVAL_BACKGROUND = 1200000;
    private AsyncTask finishCoolDownTask;
    private volatile boolean isBackground;

    static /* synthetic */ boolean access$000(NormalCoolDownState r0) {
        return r0.isBackground;
    }

    static /* synthetic */ void access$100(NormalCoolDownState r0, String r1) {
        r0.cpuExceptionLog(r1);
    }

    public NormalCoolDownState(final CpuExceptionStateMachine r9) {
        super(r9);
        this.isBackground = false;
        final long r3 = getInterval();
        final long r5 = 0;
        this.finishCoolDownTask = new AnonymousClass1(this, r3, r5, r9);
    }

    private long getInterval() {
        if (this.isBackground == false) goto L5;
        return 1200000;
    L5:
        return 120000;
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r5, boolean r6) {
        super.onEnterThisState(r5, r6);
        AsyncTask r7 = this.finishCoolDownTask;
        if (r7 == null) goto L5;
        r7.refresh(getInterval(), 0);
    L5:
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        super.onStopDetect();
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).removeTask(this.finishCoolDownTask);
    }

    @Override // com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r1) {
        super.onLifeCycleChange(r1);
        this.isBackground = r1;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.COOL_DOWN;
    }
}
