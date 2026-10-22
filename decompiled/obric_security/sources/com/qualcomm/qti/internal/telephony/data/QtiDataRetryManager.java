package com.qualcomm.qti.internal.telephony.data;

import android.R;
import android.app.AlertDialog;
import android.os.Looper;
import android.telephony.DataFailCause;
import android.telephony.data.DataProfile;
import android.util.SparseArray;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.data.DataNetworkController;
import com.android.internal.telephony.data.DataRetryManager;
import com.android.internal.telephony.data.DataServiceManager;
import com.android.internal.telephony.data.DataUtils;
import com.android.internal.telephony.data.TelephonyNetworkRequest;
import com.qualcomm.qti.internal.telephony.dataconnection.QtiDataResetEventTracker;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataRetryManager extends DataRetryManager {
    public static final int MAX_PDP_REJECT_COUNT = 3;
    protected static AlertDialog mDataRejectDialog;
    private int mDataRejectCount;
    private String mDataRejectReason;
    private final Set<Integer> mNoResetReasons;
    private int mPdpRejectCauseCode;
    private QtiDataConfigManager mQtiDataConfigManager;
    private QtiDataResetEventTracker mQtiDataResetEventTracker;
    private QtiDataResetEventTracker.ResetEventListener mResetEventListener;

    /* JADX INFO: renamed from: -$$Nest$fgetmQtiDataResetEventTracker, reason: not valid java name */
    static /* bridge */ /* synthetic */ QtiDataResetEventTracker m729$$Nest$fgetmQtiDataResetEventTracker(QtiDataRetryManager r0) {
        return r0.mQtiDataResetEventTracker;
    }

    /* JADX INFO: renamed from: -$$Nest$mresetDataRejectCounter, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m730$$Nest$mresetDataRejectCounter(QtiDataRetryManager r0) {
        r0.resetDataRejectCounter();
    }

    static {
    }

    private boolean isMatchingPdpRejectCause(int r1) {
        if (r1 != 29) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 33) goto L10;
        if (r1 == 55) goto L10;
        return false;
    }

    static /* synthetic */ void access$000(QtiDataRetryManager r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ void access$100(QtiDataRetryManager r0, String r1) {
        r0.log(r1);
    }

    static /* synthetic */ DataNetworkController access$200(QtiDataRetryManager r0) {
        return r0.mDataNetworkController;
    }

    static /* synthetic */ DataNetworkController access$300(QtiDataRetryManager r0) {
        return r0.mDataNetworkController;
    }

    static /* synthetic */ DataNetworkController access$400(QtiDataRetryManager r0) {
        return r0.mDataNetworkController;
    }

    public QtiDataRetryManager(Phone r1, DataNetworkController r2, SparseArray<DataServiceManager> r3, Looper r4, DataRetryManager.DataRetryManagerCallback r5) {
        super(r1, r2, r3, r4, r5);
        this.mQtiDataResetEventTracker = null;
        this.mDataRejectReason = "NONE";
        this.mDataRejectCount = 0;
        this.mPdpRejectCauseCode = 0;
        this.mNoResetReasons = new AnonymousClass1(this);
        this.mResetEventListener = new AnonymousClass2(this);
        log("QtiDataRetryManager: constructor");
        this.mQtiDataConfigManager = (QtiDataConfigManager) this.mDataConfigManager;
    }

    protected void onReset(int r3) {
        if (this.mQtiDataConfigManager.isPdpRejectConfigEnabled() == true) goto L5;
    L10:
        super.onReset(r3);
        return;
    L5:
        if (this.mDataRejectCount <= 0) goto L10;
        if (this.mNoResetReasons.contains(Integer.valueOf(r3)) == false) goto L10;
        log("Skipping reset for " + resetReasonToString(r3));
    }

    boolean isDataProfileOfTypeDefault(DataProfile r3) {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.getApnSetting() != null) goto L6;
        return false;
    L6:
        if ((r3.getApnSetting().getApnTypeBitmask() & 17) != 17) goto L12;
        log("isDataProfileOfTypeDefault: true, dataProfile: " + r3);
        return true;
    L12:
        return false;
    }

    boolean isPdpRejectRetryOngoing() {
        if (this.mQtiDataConfigManager.isPdpRejectConfigEnabled() == true) goto L5;
        return false;
    L5:
        if (this.mDataRejectCount <= 0) goto L10;
        log("isPdpRejectRetryOngoing: true");
        return true;
    L10:
        return false;
    }

    public void handlePdpRejectCauseSuccess() {
        if (this.mDataRejectCount <= 0) goto L6;
        log("handlePdpRejectCauseSuccess: reset reject count");
        resetDataRejectCounter();
        return;
    }

    private void resetDataRejectCounter() {
        this.mDataRejectCount = 0;
        this.mDataRejectReason = "NONE";
    }

    private boolean isWcdma(int r1) {
        if (DataUtils.networkTypeToAccessNetworkType(r1) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    protected void onEvaluateDataSetupRetry(DataProfile r9, int r10, DataNetworkController.NetworkRequestList r11, int r12, long r13) {
        if (this.mQtiDataConfigManager.isPdpRejectConfigEnabled() == true) goto L5;
    L26:
        super.onEvaluateDataSetupRetry(r9, r10, r11, r12, r13);
        return;
    L5:
        if (((TelephonyNetworkRequest) r11.get(0)).getApnTypeNetworkCapability() != 12) goto L26;
        String r0 = DataFailCause.toString(r12);
        if (isMatchingPdpRejectCause(r12) == true) goto L9;
    L25:
        log("onDataSetupCompleteError: reset reject count");
        resetDataRejectCounter();
        goto L26
    L9:
        if (isWcdma(this.mDataNetworkController.getDataNetworkType(r10)) == false) goto L25;
        if (this.mQtiDataResetEventTracker != null) goto L14;
        this.mQtiDataResetEventTracker = new QtiDataResetEventTracker(r10, this.mPhone, this.mResetEventListener);
    L14:
        if (r0.equalsIgnoreCase(this.mDataRejectReason) == true) goto L17;
        resetDataRejectCounter();
    L17:
        if (this.mDataRejectCount != 0) goto L19;
        this.mQtiDataResetEventTracker.startResetEventTracker();
    L19:
        this.mDataRejectCount++;
        this.mDataRejectReason = r0;
        log("RejectCount: " + this.mDataRejectCount + ", RejectReason: " + this.mDataRejectReason);
        if (3 > this.mDataRejectCount) goto L23;
        log("onEvaluateDataSetupRetry: reached max retry count");
        displayPdpRejectPopup(r12);
        r13 = Long.MAX_VALUE;
        goto L26
    L23:
        if (r13 != (-1)) goto L26;
        r13 = this.mQtiDataConfigManager.getPdpRejectRetryDelay();
        log("onEvaluateDataSetupRetry: delay from config: " + r13);
        goto L26
    }

    private void displayPdpRejectPopup(int r4) {
        log("displayPdpRejectPopup : " + DataFailCause.toString(r4));
        String r0 = this.mQtiDataConfigManager.getPdpRejectDialogTitle();
        if (r4 != 29) goto L5;
        String r5 = this.mQtiDataConfigManager.getPdpRejectCauseUserAuthentication();
    L13:
        AlertDialog r1 = mDataRejectDialog;
        if (r1 != null) goto L16;
    L17:
        AlertDialog.Builder r2 = new AlertDialog.Builder(this.mPhone.getContext());
        r2.setPositiveButton(R.string.ok, null);
        mDataRejectDialog = r2.create();
    L18:
        mDataRejectDialog.setMessage(r5);
        mDataRejectDialog.setCanceledOnTouchOutside(false);
        mDataRejectDialog.setTitle(r0);
        mDataRejectDialog.getWindow().setType(2003);
        mDataRejectDialog.show();
        return;
    L16:
        if (r1.isShowing() == true) goto L18;
    L5:
        if (r4 != 33) goto L7;
        r5 = this.mQtiDataConfigManager.getPdpRejectCauseServiceNotSubscribed();
        goto L13
    L7:
        if (r4 == 55) goto L10;
        loge("displayPdpRejectPopup: invalid dataFailCause: " + r4);
        return;
    L10:
        r5 = this.mQtiDataConfigManager.getPdpRejectCauseSamePdnNotAllowed();
        goto L13
    }
}
