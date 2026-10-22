package com.android.settingslib.mobile;

import android.os.Handler;
import android.os.Looper;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.GlobalProxyLancet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MobileStatusTracker {
    private static final String TAG = "MobileStatusTracker";
    private final Callback mCallback;
    private final SubscriptionDefaults mDefaults;
    private boolean mListening;
    private final MobileStatus mMobileStatus;
    private final TelephonyManager mPhone;
    private final Handler mReceiverHandler;
    private final SubscriptionInfo mSubscriptionInfo;
    private final MobileTelephonyCallback mTelephonyCallback;

    public interface Callback {
        void onMobileStatusChanged(boolean r1, MobileStatus r2);
    }

    public static class MobileStatus {
        public boolean activityIn;
        public boolean activityOut;
        public boolean carrierNetworkChangeMode;
        public boolean dataSim;
        public int dataState;
        public ServiceState serviceState;
        public SignalStrength signalStrength;
        public TelephonyDisplayInfo telephonyDisplayInfo;

        public MobileStatus() {
            this.dataState = 0;
            this.telephonyDisplayInfo = new TelephonyDisplayInfo(0, 0, false);
        }

        public MobileStatus(MobileStatus r3) {
            this.dataState = 0;
            this.telephonyDisplayInfo = new TelephonyDisplayInfo(0, 0, false);
            copyFrom(r3);
        }

        protected void copyFrom(MobileStatus r2) {
            this.activityIn = r2.activityIn;
            this.activityOut = r2.activityOut;
            this.dataSim = r2.dataSim;
            this.carrierNetworkChangeMode = r2.carrierNetworkChangeMode;
            this.dataState = r2.dataState;
            this.serviceState = r2.serviceState;
            this.signalStrength = r2.signalStrength;
            this.telephonyDisplayInfo = r2.telephonyDisplayInfo;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("[activityIn=").append(this.activityIn).append(",activityOut=").append(this.activityOut).append(",dataSim=").append(this.dataSim).append(",carrierNetworkChangeMode=").append(this.carrierNetworkChangeMode).append(",dataState=").append(this.dataState).append(",serviceState=");
            String r2 = "";
            if (this.serviceState != null) goto L5;
            String r1 = "";
        L6:
            StringBuilder r3 = r0.append(r1).append(",signalStrength=");
            SignalStrength r4 = this.signalStrength;
            if (r4 != null) goto L9;
            Object r5 = "";
        L10:
            StringBuilder r6 = r3.append(r5).append(",telephonyDisplayInfo=");
            TelephonyDisplayInfo r7 = this.telephonyDisplayInfo;
            if (r7 == null) goto L15;
            r2 = r7.toString();
        L15:
            return r6.append(r2).append(']').toString();
        L9:
            r5 = Integer.valueOf(r4.getLevel());
            goto L10
        L5:
            r1 = "mVoiceRegState=" + this.serviceState.getState() + "(" + ServiceState.rilServiceStateToString(this.serviceState.getState()) + "), mDataRegState=" + this.serviceState.getDataRegState() + "(" + ServiceState.rilServiceStateToString(this.serviceState.getDataRegState()) + ")";
            goto L6
        }
    }

    public class MobileTelephonyCallback extends TelephonyCallback implements TelephonyCallback.ServiceStateListener, TelephonyCallback.SignalStrengthsListener, TelephonyCallback.DataConnectionStateListener, TelephonyCallback.DataActivityListener, TelephonyCallback.CarrierNetworkListener, TelephonyCallback.ActiveDataSubscriptionIdListener, TelephonyCallback.DisplayInfoListener {
        final /* synthetic */ MobileStatusTracker this$0;

        public MobileTelephonyCallback(MobileStatusTracker r1) {
            this.this$0 = r1;
        }

        @Override // android.telephony.TelephonyCallback.SignalStrengthsListener
        public void onSignalStrengthsChanged(SignalStrength r5) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L9;
            StringBuilder r0 = new StringBuilder("onSignalStrengthsChanged signalStrength=").append(r5);
            if (r5 != null) goto L7;
            String r2 = "";
        L8:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, r0.append(r2).toString());
            goto L9
        L7:
            r2 = " level=" + r5.getLevel();
        L9:
            MobileStatusTracker.access$000(this.this$0).signalStrength = r5;
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.ServiceStateListener
        public void onServiceStateChanged(ServiceState r5) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L13;
            StringBuilder r0 = new StringBuilder("onServiceStateChanged voiceState=");
            Object r2 = "";
            if (r5 != null) goto L7;
            Object r3 = "";
        L8:
            StringBuilder r1 = r0.append(r3).append(" dataState=");
            if (r5 == null) goto L12;
            r2 = Integer.valueOf(r5.getDataRegistrationState());
        L12:
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, r1.append(r2).toString());
            goto L13
        L7:
            r3 = Integer.valueOf(r5.getState());
        L13:
            MobileStatusTracker.access$000(this.this$0).serviceState = r5;
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.DataConnectionStateListener
        public void onDataConnectionStateChanged(int r4, int r5) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, "onDataConnectionStateChanged: state=" + r4 + " type=" + r5);
        L5:
            MobileStatusTracker.access$000(this.this$0).dataState = r4;
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.DataActivityListener
        public void onDataActivity(int r4) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, "onDataActivity: direction=" + r4);
        L5:
            MobileStatusTracker.access$200(this.this$0, r4);
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(false, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.CarrierNetworkListener
        public void onCarrierNetworkChange(boolean r4) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, "onCarrierNetworkChange: active=" + r4);
        L5:
            MobileStatusTracker.access$000(this.this$0).carrierNetworkChangeMode = r4;
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.ActiveDataSubscriptionIdListener
        public void onActiveDataSubscriptionIdChanged(int r4) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, "onActiveDataSubscriptionIdChanged: subId=" + r4);
        L5:
            MobileStatusTracker.access$300(this.this$0);
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }

        @Override // android.telephony.TelephonyCallback.DisplayInfoListener
        public void onDisplayInfoChanged(TelephonyDisplayInfo r4) {
            if (Log.isLoggable(MobileStatusTracker.TAG, 3) == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MobileStatusTracker.TAG, "onDisplayInfoChanged: telephonyDisplayInfo=" + r4);
        L5:
            MobileStatusTracker.access$000(this.this$0).telephonyDisplayInfo = r4;
            MobileStatusTracker.access$100(this.this$0).onMobileStatusChanged(true, new MobileStatus(MobileStatusTracker.access$000(this.this$0)));
        }
    }

    public static class SubscriptionDefaults {
        public SubscriptionDefaults() {
        }

        public int getDefaultVoiceSubId() {
            return SubscriptionManager.getDefaultVoiceSubscriptionId();
        }

        public int getDefaultDataSubId() {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }

        public int getActiveDataSubId() {
            return SubscriptionManager.getActiveDataSubscriptionId();
        }
    }

    public static /* synthetic */ boolean $r8$lambda$xMC8M6LLEeW997bBmO6BCC6GGAM(Handler r0, Runnable r1) {
        return r0.post(r1);
    }

    static /* synthetic */ MobileStatus access$000(MobileStatusTracker r0) {
        return r0.mMobileStatus;
    }

    static /* synthetic */ Callback access$100(MobileStatusTracker r0) {
        return r0.mCallback;
    }

    static /* synthetic */ void access$200(MobileStatusTracker r0, int r1) {
        r0.setActivity(r1);
    }

    static /* synthetic */ void access$300(MobileStatusTracker r0) {
        r0.updateDataSim();
    }

    public MobileStatusTracker(TelephonyManager r2, Looper r3, SubscriptionInfo r4, SubscriptionDefaults r5, Callback r6) {
        this.mListening = false;
        this.mPhone = r2;
        Handler r7 = new Handler(r3);
        this.mReceiverHandler = r7;
        this.mTelephonyCallback = new MobileTelephonyCallback(this);
        this.mSubscriptionInfo = r4;
        this.mDefaults = r5;
        this.mCallback = r6;
        this.mMobileStatus = new MobileStatus();
        updateDataSim();
        r7.post(new MobileStatusTracker$$ExternalSyntheticLambda1(this));
    }

    /* JADX INFO: renamed from: lambda$new$0$com-android-settingslib-mobile-MobileStatusTracker, reason: not valid java name */
    /* synthetic */ void m770lambda$new$0$comandroidsettingslibmobileMobileStatusTracker() {
        this.mCallback.onMobileStatusChanged(false, new MobileStatus(this.mMobileStatus));
    }

    public MobileTelephonyCallback getTelephonyCallback() {
        return this.mTelephonyCallback;
    }

    public void setListening(boolean r3) {
        if (this.mListening != r3) goto L5;
        return;
    L5:
        this.mListening = r3;
        if (r3 == false) goto L8;
        TelephonyManager r4 = this.mPhone;
        final Handler r0 = this.mReceiverHandler;
        Objects.requireNonNull(r0);
        r4.registerTelephonyCallback(new MobileStatusTracker$$ExternalSyntheticLambda0(r0), this.mTelephonyCallback);
        return;
    L8:
        this.mPhone.unregisterTelephonyCallback(this.mTelephonyCallback);
    }

    public boolean isListening() {
        return this.mListening;
    }

    private void updateDataSim() {
        int r0 = this.mDefaults.getActiveDataSubId();
        boolean r2 = true;
        if (SubscriptionManager.isValidSubscriptionId(r0) == false) goto L9;
        MobileStatus r1 = this.mMobileStatus;
        if (r0 == this.mSubscriptionInfo.getSubscriptionId()) goto L8;
        r2 = false;
    L8:
        r1.dataSim = r2;
        return;
    L9:
        this.mMobileStatus.dataSim = true;
    }

    private void setActivity(int r6) {
        MobileStatus r0 = this.mMobileStatus;
        boolean r1 = false;
        if (r6 == 3) goto L7;
        if (r6 == 1) goto L7;
        boolean r4 = false;
    L8:
        r0.activityIn = r4;
        MobileStatus r5 = this.mMobileStatus;
        if (r6 != 3) goto L11;
    L12:
        r1 = true;
    L13:
        r5.activityOut = r1;
        return;
    L11:
        if (r6 != 2) goto L13;
    L7:
        r4 = true;
        goto L8
    }
}
