package com.bytedance.apm.block;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public interface ILooperObserver {
    void messageDispatchStarting(String r1);

    void messageDispatched(String r1, Message r2);
}
