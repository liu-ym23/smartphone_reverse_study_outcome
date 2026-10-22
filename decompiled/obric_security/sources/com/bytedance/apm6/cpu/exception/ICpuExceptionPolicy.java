package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.config.CpuExceptionConfig;

/* JADX INFO: loaded from: classes.dex */
public interface ICpuExceptionPolicy {
    void startDetect(CpuExceptionConfig r1);

    void stopDetect();
}
