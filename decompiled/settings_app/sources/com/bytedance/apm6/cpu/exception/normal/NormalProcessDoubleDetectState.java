package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes3.dex */
class NormalProcessDoubleDetectState extends BaseProcessDetectState {
    private static final long DETECTED_BACKGROUND_INTERVAL = 300000;
    private static final long DETECTED_INTERVAL = 5000;
    private static final int MAX_OVER_TIMES = 2;
    private int overTimes;

    public NormalProcessDoubleDetectState(CpuExceptionStateMachine r1) {
        super(r1);
        this.overTimes = 0;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DOUBLE_DETECT;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected long provideDetectInterval() {
        if (this.isBackground == false) goto L5;
        return 300000;
    L5:
        return 5000;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState, com.bytedance.apm6.cpu.exception.BaseCpuExceptionState, com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r2) {
        if (r2 == false) goto L4;
        this.overTimes = 0;
    L4:
        super.onLifeCycleChange(r2);
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactAfterJudge(boolean r4) {
        if (r4 == false) goto L9;
        this.overTimes++;
        cpuExceptionLog("over time: " + this.overTimes + " max over time: 2");
        if (this.overTimes < 2) goto L8;
        this.overTimes = 0;
        this.machine.onThreadDetect();
        return true;
    L8:
        return false;
    L9:
        this.overTimes = 0;
        this.machine.onProcessDetect();
        return true;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactOnSkip() {
        this.overTimes = 0;
        this.machine.onProcessDetect();
        return true;
    }
}
