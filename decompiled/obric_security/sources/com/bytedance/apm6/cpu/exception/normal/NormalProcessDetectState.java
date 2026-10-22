package com.bytedance.apm6.cpu.exception.normal;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionManager;
import com.bytedance.apm6.cpu.exception.CpuExceptionStateMachine;
import com.bytedance.apm6.cpu.exception.StateType;

/* JADX INFO: loaded from: classes.dex */
class NormalProcessDetectState extends BaseProcessDetectState {
    private static final long DETECTED_BACKGROUND_INTERVAL = 600000;
    private static final long DETECTED_INTERVAL = 1000;

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactOnSkip() {
        return false;
    }

    public NormalProcessDetectState(CpuExceptionStateMachine r1) {
        super(r1);
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public StateType provideType() {
        return StateType.PROCESS_DETECT;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected long provideDetectInterval() {
        if (this.config != null) goto L10;
        if (this.isBackground == true) goto L14;
        return 30000;
    L14:
        return 600000;
    L10:
        if (this.isBackground == false) goto L13;
        return 600000;
    L13:
        return ((long) this.config.getProcessDetectInterval()) * 1000;
    }

    @Override // com.bytedance.apm6.cpu.exception.normal.BaseProcessDetectState
    protected boolean reactAfterJudge(boolean r2) {
        if (r2 == false) goto L10;
        ApmCpuManager.ICpuExceptionFilter r0 = CpuExceptionManager.getInstance().getExceptionFilter();
        if (r0 != null) goto L6;
    L9:
        this.machine.onProcessDoubleDetect();
        goto L10
    L6:
        if (r0.needFilter() == false) goto L9;
        return false;
    L10:
        return r2;
    }
}
