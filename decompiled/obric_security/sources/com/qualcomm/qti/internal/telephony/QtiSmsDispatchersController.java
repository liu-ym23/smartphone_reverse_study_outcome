package com.qualcomm.qti.internal.telephony;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.telephony.TelephonyManager;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.SmsDispatchersController;
import com.android.internal.telephony.SmsNumberUtils;
import com.android.internal.telephony.SmsStorageMonitor;
import com.android.internal.telephony.SmsUsageMonitor;
import com.android.telephony.Rlog;
import com.qti.extphone.Client;
import com.qti.extphone.ExtTelephonyManager;
import com.qti.extphone.IExtPhoneCallback;
import com.qti.extphone.ServiceCallback;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class QtiSmsDispatchersController extends SmsDispatchersController {
    private static final String LOG_TAG = "QtiSmsDispatchersController";
    private IExtPhoneCallback mCallback;
    private Context mContext;
    private ExtTelephonyManager mExtTelephonyManager;
    private boolean mIsInSecureMode;
    private String mPackageName;
    private Phone mPhone;
    private Client mQtiRadioConfigClient;
    private ServiceCallback mServiceCallback;
    private TelephonyManager mTelephonyManager;

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IExtPhoneCallback m688$$Nest$fgetmCallback(QtiSmsDispatchersController r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExtTelephonyManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExtTelephonyManager m689$$Nest$fgetmExtTelephonyManager(QtiSmsDispatchersController r0) {
        return r0.mExtTelephonyManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m690$$Nest$fgetmPackageName(QtiSmsDispatchersController r0) {
        return r0.mPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ Client m691$$Nest$fgetmQtiRadioConfigClient(QtiSmsDispatchersController r0) {
        return r0.mQtiRadioConfigClient;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsInSecureMode, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m692$$Nest$fputmIsInSecureMode(QtiSmsDispatchersController r0, boolean r1) {
        r0.mIsInSecureMode = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmQtiRadioConfigClient, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m693$$Nest$fputmQtiRadioConfigClient(QtiSmsDispatchersController r0, Client r1) {
        r0.mQtiRadioConfigClient = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mlogd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m694$$Nest$mlogd(QtiSmsDispatchersController r0, String r1) {
        r0.logd(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mloge, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m695$$Nest$mloge(QtiSmsDispatchersController r0, String r1) {
        r0.loge(r1);
    }

    public QtiSmsDispatchersController(Phone r1, SmsStorageMonitor r2, SmsUsageMonitor r3) {
        super(r1, r2, r3);
        this.mIsInSecureMode = false;
        this.mServiceCallback = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        logd("Constructor");
        this.mPhone = r1;
        this.mContext = r1.getContext();
        this.mPackageName = r1.getContext().getPackageName();
        this.mTelephonyManager = (TelephonyManager) r1.getContext().getSystemService(TelephonyManager.class);
        ExtTelephonyManager r4 = ExtTelephonyManager.getInstance(this.mContext);
        this.mExtTelephonyManager = r4;
        r4.connectService(this.mServiceCallback);
    }

    protected void sendData(String r6, String r7, String r8, int r9, byte[] r10, PendingIntent r11, PendingIntent r12, boolean r13) {
        boolean r0 = this.mTelephonyManager.isEmergencyNumber(filterDestAddress(r7));
        boolean r1 = this.mImsSmsDispatcher.isAvailable();
        boolean r2 = this.mImsSmsDispatcher.isEmergencySmsSupport(r7);
        logd("sendData: mIsInSecureMode = " + this.mIsInSecureMode + ", isEmergency = " + r0 + ", isImsAvailable = " + r1 + ", isEmergencySmsSupported = " + r2);
        if (this.mIsInSecureMode == false) goto L9;
        if (r0 == false) goto L8;
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
    L8:
        triggerSentIntentForFailure(r11);
        return;
    L9:
        super.sendData(r6, r7, r8, r9, r10, r11, r12, r13);
    }

    public void sendText(String r8, String r9, String r10, PendingIntent r11, PendingIntent r12, Uri r13, String r14, boolean r15, int r16, boolean r17, int r18, boolean r19, long r20) {
        boolean r1 = this.mTelephonyManager.isEmergencyNumber(filterDestAddress(r8));
        boolean r2 = this.mImsSmsDispatcher.isAvailable();
        boolean r3 = this.mImsSmsDispatcher.isEmergencySmsSupport(r8);
        logd("sendText: mIsInSecureMode = " + this.mIsInSecureMode + ", isEmergency = " + r1 + ", isImsAvailable = " + r2 + ", isEmergencySmsSupported = " + r3);
        if (this.mIsInSecureMode == false) goto L9;
        if (r1 == false) goto L8;
        if (r2 == true) goto L9;
        if (r3 == true) goto L9;
    L8:
        triggerSentIntentForFailure(r11);
        return;
    L9:
        super.sendText(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    protected void sendMultipartText(String r8, String r9, ArrayList<String> r10, ArrayList<PendingIntent> r11, ArrayList<PendingIntent> r12, Uri r13, String r14, boolean r15, int r16, boolean r17, int r18, long r19) {
        boolean r1 = this.mTelephonyManager.isEmergencyNumber(filterDestAddress(r8));
        boolean r2 = this.mImsSmsDispatcher.isAvailable();
        boolean r3 = this.mImsSmsDispatcher.isEmergencySmsSupport(r8);
        logd("sendMultipartText: mIsInSecureMode = " + this.mIsInSecureMode + ", isEmergency = " + r1 + ", isImsAvailable = " + r2 + ", isEmergencySmsSupported = " + r3);
        if (this.mIsInSecureMode == false) goto L9;
        if (r1 == false) goto L8;
        if (r2 == true) goto L9;
        if (r3 == true) goto L9;
    L8:
        triggerSentIntentForFailure(r11);
        return;
    L9:
        super.sendMultipartText(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    private void triggerSentIntentForFailure(PendingIntent r2) {
        if (r2 != null) goto L8;
        return;
    L8:
        r2.send(1);     // Catch: PendingIntent.CanceledException -> L6
        return;
    L6:
        loge("Intent has been canceled!");
    }

    private void triggerSentIntentForFailure(ArrayList<PendingIntent> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<PendingIntent> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        triggerSentIntentForFailure(r3.next());
        goto L6
    }

    private String filterDestAddress(String r2) {
        String r1 = SmsNumberUtils.filterDestAddr(this.mContext, this.mPhone.getSubId(), r2);
        if (r1 != null) goto L5;
        return r2;
    L5:
        return r1;
    }

    private void logd(String r1) {
        Rlog.d(LOG_TAG, r1);
    }

    private void loge(String r1) {
        Rlog.e(LOG_TAG, r1);
    }
}
