package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.Constants;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseCpuExceptionState implements ICpuExceptionState {
    protected static final boolean IS_DEBUG = false;
    protected CpuExceptionStateMachine machine;

    public BaseCpuExceptionState(CpuExceptionStateMachine r1) {
        this.machine = r1;
    }

    public void cpuExceptionLog(String r3) {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "[" + provideType() + "]: " + r3);
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onEnterThisState(CpuExceptionConfig r1, boolean r2) {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "enter : " + provideType());
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onLifeCycleChange(boolean r2) {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "onLifeCycleChange when state is : " + provideType());
        return;
    }

    @Override // com.bytedance.apm6.cpu.exception.ICpuExceptionState
    public void onStopDetect() {
        if (ApmBaseContext.isDebugMode() == false) goto L6;
        Logger.i(Constants.TAG, "stop detect when state is : " + provideType());
        return;
    }
}
