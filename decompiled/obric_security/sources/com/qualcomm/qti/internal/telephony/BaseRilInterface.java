package com.qualcomm.qti.internal.telephony;

import android.os.Handler;

/* JADX INFO: loaded from: classes4.dex */
public interface BaseRilInterface {
    boolean isServiceReady();

    void registerForServiceReadyEvent(Handler r1, int r2, Object r3);

    void sendPhoneStatus(int r1, int r2);

    boolean setLocalCallHold(int r1, boolean r2);

    void unRegisterForServiceReadyEvent(Handler r1);
}
