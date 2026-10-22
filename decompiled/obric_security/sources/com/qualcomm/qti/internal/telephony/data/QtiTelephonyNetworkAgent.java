package com.qualcomm.qti.internal.telephony.data;

import android.net.NetworkAgentConfig;
import android.net.NetworkProvider;
import android.net.NetworkScore;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.SubscriptionController;
import com.android.internal.telephony.data.DataNetwork;
import com.android.internal.telephony.data.PhoneSwitcher;
import com.android.internal.telephony.data.TelephonyNetworkAgent;
import java.time.Duration;

/* JADX INFO: loaded from: classes4.dex */
public class QtiTelephonyNetworkAgent extends TelephonyNetworkAgent {
    private static final int EVENT_ACTIVE_PHONE_SWITCH = 1;
    private static final long NETWORK_LINGER_TIME_DDS = 30000;
    private static final long NETWORK_LINGER_TIME_NON_DDS = 2000;
    private static final int TEARDOWN_DELAY_TIMEOUT_DDS = 0;
    private static final int TEARDOWN_DELAY_TIMEOUT_NON_DDS = 3000;
    private Handler mInternalHandler;
    private PhoneSwitcher mPhoneSwitcher;
    private int mScore;

    private class InternalHandler extends Handler {
        final /* synthetic */ QtiTelephonyNetworkAgent this$0;

        public InternalHandler(QtiTelephonyNetworkAgent r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            if (r3.what == 1) goto L6;
            QtiTelephonyNetworkAgent.access$100(this.this$0, "Unknown message = " + r3.what);
            return;
        L6:
            if (QtiTelephonyNetworkAgent.access$000(this.this$0).getNetworkCapabilities().hasCapability(12) == false) goto L10;
            QtiTelephonyNetworkAgent.m732$$Nest$monActivePhoneSwitch(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$monActivePhoneSwitch, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m732$$Nest$monActivePhoneSwitch(QtiTelephonyNetworkAgent r0) {
        r0.onActivePhoneSwitch();
    }

    static /* synthetic */ DataNetwork access$000(QtiTelephonyNetworkAgent r0) {
        return r0.mDataNetwork;
    }

    static /* synthetic */ void access$100(QtiTelephonyNetworkAgent r0, String r1) {
        r0.loge(r1);
    }

    public QtiTelephonyNetworkAgent(Phone r1, Looper r2, DataNetwork r3, NetworkScore r4, NetworkAgentConfig r5, NetworkProvider r6, TelephonyNetworkAgent.TelephonyNetworkAgentCallback r7) {
        super(r1, r2, r3, r4, r5, r6, r7);
        this.mLogTag = "QtiTNA-" + this.mId + "-" + r1.getPhoneId();
        this.mScore = r4.getLegacyInt();
        this.mPhoneSwitcher = PhoneSwitcher.getInstance();
        InternalHandler r8 = new InternalHandler(this, r2);
        this.mInternalHandler = r8;
        this.mPhoneSwitcher.registerForActivePhoneSwitch(r8, 1, null);
        log("Constructor");
    }

    private void onActivePhoneSwitch() {
        boolean r2 = false;
        if (this.mPhone.getSubId() != SubscriptionController.getInstance().getActiveDataSubscriptionId()) goto L5;
        long r0 = 30000;
        int r3 = 0;
        r2 = true;
    L6:
        log("onActivePhoneSwitch: setTransportPrimary = " + r2);
        setLingerDuration(Duration.ofMillis(r0));
        setTeardownDelayMillis(r3);
        sendNetworkScore(new NetworkScore.Builder().setLegacyInt(this.mScore).setTransportPrimary(r2).build());
        return;
    L5:
        r0 = NETWORK_LINGER_TIME_NON_DDS;
        r3 = 3000;
        goto L6
    }

    public void onNetworkUnwanted() {
        log("onNetworkUnwanted - no-op");
    }

    public void onNetworkDestroyed() {
        log("onNetworkDestroyed - tearing down");
        this.mPhoneSwitcher.unregisterForActivePhoneSwitch(this.mInternalHandler);
        this.mInternalHandler = null;
        if (this.mAbandoned == false) goto L6;
        log("The agent is already abandoned. Ignored to tear down");
        return;
    L6:
        this.mDataNetwork.tearDown(1);
    }
}
