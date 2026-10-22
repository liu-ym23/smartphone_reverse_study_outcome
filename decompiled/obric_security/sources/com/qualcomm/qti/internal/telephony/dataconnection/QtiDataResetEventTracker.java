package com.qualcomm.qti.internal.telephony.dataconnection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.Rlog;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import com.android.internal.telephony.Phone;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataResetEventTracker {
    private static final boolean DBG = true;
    private Context mContext;
    private DataEnabledChangedListener mDataEnabledCallback;
    private Handler mHandler;
    private ResetEventListener mListener;
    private Phone mPhone;
    private PhoneStateListener mPhoneStateListener;
    private GsmCellLocation mPreviousLocation;
    private int mPreviousRAT;
    private BroadcastReceiver mSimStateReceiver;
    private TelephonyManager mTelephonyManager;
    private int mTransportType;

    private class DataEnabledChangedListener extends TelephonyCallback implements TelephonyCallback.UserMobileDataStateListener {
        private int mSubId;
        final /* synthetic */ QtiDataResetEventTracker this$0;

        public DataEnabledChangedListener(QtiDataResetEventTracker r1, int r2) {
            this.this$0 = r1;
            this.mSubId = r2;
        }

        @Override // android.telephony.TelephonyCallback.UserMobileDataStateListener
        public void onUserMobileDataStateChanged(boolean r4) {
            QtiDataResetEventTracker.m739$$Nest$mlog(this.this$0, "onUserMobileDataStateChanged: sub= " + this.mSubId + " enabled= " + r4);
            if (r4 == true) goto L6;
            QtiDataResetEventTracker.m733$$Nest$fgetmHandler(this.this$0).sendMessage(QtiDataResetEventTracker.m733$$Nest$fgetmHandler(this.this$0).obtainMessage(270382));
            return;
        }

        public void unregisterListener() {
            QtiDataResetEventTracker.m736$$Nest$fgetmTelephonyManager(this.this$0).createForSubscriptionId(this.mSubId).unregisterTelephonyCallback(this);
        }
    }

    public interface ResetEventListener {
        void onResetEvent(boolean r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m733$$Nest$fgetmHandler(QtiDataResetEventTracker r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreviousLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ GsmCellLocation m734$$Nest$fgetmPreviousLocation(QtiDataResetEventTracker r0) {
        return r0.mPreviousLocation;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPreviousRAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m735$$Nest$fgetmPreviousRAT(QtiDataResetEventTracker r0) {
        return r0.mPreviousRAT;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ TelephonyManager m736$$Nest$fgetmTelephonyManager(QtiDataResetEventTracker r0) {
        return r0.mTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPreviousLocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m737$$Nest$fputmPreviousLocation(QtiDataResetEventTracker r0, GsmCellLocation r1) {
        r0.mPreviousLocation = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPreviousRAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m738$$Nest$fputmPreviousRAT(QtiDataResetEventTracker r0, int r1) {
        r0.mPreviousRAT = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlog, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m739$$Nest$mlog(QtiDataResetEventTracker r0, String r1) {
        r0.log(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyResetEvent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m740$$Nest$mnotifyResetEvent(QtiDataResetEventTracker r0, String r1, boolean r2) {
        r0.notifyResetEvent(r1, r2);
    }

    public QtiDataResetEventTracker(int r4, Phone r5, ResetEventListener r6) {
        this.mTelephonyManager = null;
        this.mPreviousLocation = null;
        this.mPhoneStateListener = null;
        this.mContext = null;
        this.mPhone = null;
        this.mListener = null;
        this.mPreviousRAT = 0;
        this.mHandler = new AnonymousClass1(this);
        this.mSimStateReceiver = new AnonymousClass2(this);
        log("QtiDataResetEventTracker constructor: " + this);
        this.mPhone = r5;
        Context r7 = r5.getContext();
        this.mContext = r7;
        this.mListener = r6;
        this.mTransportType = r4;
        this.mTelephonyManager = (TelephonyManager) r7.getSystemService("phone");
        if (this.mPhone.isUsingNewDataStack() == false) goto L5;
        int r8 = this.mPhone.getSubId();
        this.mDataEnabledCallback = new DataEnabledChangedListener(this, r8);
        this.mTelephonyManager.createForSubscriptionId(r8).registerTelephonyCallback(this.mContext.getMainExecutor(), this.mDataEnabledCallback);
        return;
    L5:
        this.mPhone.getDataEnabledSettings().registerForDataEnabledChanged(this.mHandler, 270382, null);
    }

    public void startResetEventTracker() {
        log("startResetEventTracker");
        this.mPreviousRAT = 0;
        this.mPhone.getServiceStateTracker().registerForDataRegStateOrRatChanged(this.mTransportType, this.mHandler, 270377, null);
        this.mPhone.mCi.registerForOffOrNotAvailable(this.mHandler, 270342, null);
        this.mContext.registerReceiver(this.mSimStateReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        CellLocation r0 = this.mPhone.getCurrentCellIdentity().asCellLocation();
        if ((r0 instanceof GsmCellLocation) == false) goto L5;
        this.mPreviousLocation = (GsmCellLocation) r0;
        log("DataConnection mPreviousLocation : " + this.mPreviousLocation);
    L5:
        int r1 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (this.mPhoneStateListener != null) goto L8;
        this.mPhoneStateListener = new AnonymousClass3(this);
    L8:
        this.mTelephonyManager.createForSubscriptionId(r1).listen(this.mPhoneStateListener, 16);
    }

    public void stopResetEventTracker() {
        log("stopResetTimer");
        this.mPreviousRAT = 0;     // Catch: Exception -> L8
        this.mPreviousLocation = null;     // Catch: Exception -> L8
        PhoneStateListener r1 = this.mPhoneStateListener;     // Catch: Exception -> L8
        if (r1 == null) goto L6;
        this.mTelephonyManager.listen(r1, 0);     // Catch: Exception -> L8
    L6:
        this.mPhone.getServiceStateTracker().unregisterForDataRegStateOrRatChanged(this.mTransportType, this.mHandler);     // Catch: Exception -> L8
        this.mPhone.mCi.unregisterForOffOrNotAvailable(this.mHandler);     // Catch: Exception -> L8
        this.mContext.unregisterReceiver(this.mSimStateReceiver);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        log("error:" + e.getMessage());
        e.printStackTrace();
    }

    public void dispose() {
        log("dispose");
        stopResetEventTracker();
        DataEnabledChangedListener r0 = this.mDataEnabledCallback;
        if (r0 != null) goto L5;
    L7:
        this.mTelephonyManager = null;
        return;
    L5:
        if (this.mTelephonyManager == null) goto L7;
        r0.unregisterListener();
        goto L7
    }

    private void notifyResetEvent(String r3, boolean r4) {
        log("notifyResetEvent: reason=" + r3 + ", retry=" + r4);
        stopResetEventTracker();
        ResetEventListener r2 = this.mListener;
        if (r2 == null) goto L6;
        r2.onResetEvent(r4);
        return;
    }

    private void log(String r1) {
        Rlog.d("QtiDataResetEventTracker", r1);
    }
}
