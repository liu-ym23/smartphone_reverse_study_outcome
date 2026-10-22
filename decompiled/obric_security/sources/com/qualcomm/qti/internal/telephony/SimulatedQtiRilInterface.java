package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.AsyncResult;
import android.os.Handler;
import android.os.Registrant;
import android.os.RegistrantList;
import android.telephony.Rlog;
import android.util.Log;
import com.qualcomm.qcrilhook.QcRilHook;

/* JADX INFO: loaded from: classes4.dex */
public class SimulatedQtiRilInterface implements BaseRilInterface {
    private static final String LOG_TAG = "SimulatedQtiRilInterface";
    private static boolean mIsServiceReady = false;
    private static SimulatedQtiRilInterface sInstance;
    private QcRilHook mQcRilHook;
    private RegistrantList mServiceReadyRegistrantList;

    static {
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public boolean isServiceReady() {
        return true;
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public boolean setLocalCallHold(int r1, boolean r2) {
        return true;
    }

    public static synchronized SimulatedQtiRilInterface getInstance(Context r3) {
        monitor-enter(SimulatedQtiRilInterface.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new SimulatedQtiRilInterface(r3);     // Catch: Throwable -> L11
    L8:
        SimulatedQtiRilInterface r4 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(SimulatedQtiRilInterface.class);
        return r4;
    L7:
        Log.wtf(LOG_TAG, "instance = " + sInstance);     // Catch: Throwable -> L11
        goto L8
    }

    private SimulatedQtiRilInterface(Context r1) {
        logd(" in constructor ");
        this.mServiceReadyRegistrantList = new RegistrantList();
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void sendPhoneStatus(int r3, int r4) {
        logd("sendPhoneStatus, isReady: " + r3 + ", phoneId: " + r4);
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void registerForServiceReadyEvent(Handler r2, int r3, Object r4) {
        Registrant r0 = new Registrant(r2, r3, r4);
        this.mServiceReadyRegistrantList.add(r0);
        if (isServiceReady() == false) goto L6;
        r0.notifyRegistrant(new AsyncResult(null, Boolean.valueOf(mIsServiceReady), null));
        return;
    }

    @Override // com.qualcomm.qti.internal.telephony.BaseRilInterface
    public void unRegisterForServiceReadyEvent(Handler r1) {
        this.mServiceReadyRegistrantList.remove(r1);
    }

    private void logd(String r1) {
        Rlog.d(LOG_TAG, r1);
    }
}
