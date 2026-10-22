package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.Binder;
import android.os.SystemProperties;
import android.provider.Settings;
import android.telephony.Rlog;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.UiccSlotInfo;
import android.util.Log;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.PhoneFactory;
import com.android.internal.telephony.RIL;
import com.android.internal.telephony.vendor.VendorSubscriptionController;

/* JADX INFO: loaded from: classes4.dex */
public class QtiSubscriptionController extends VendorSubscriptionController {
    private static final String APM_SIM_NOT_PWDN_PROPERTY = "persist.vendor.radio.apm_sim_not_pwdn";
    private static final String CARRIER_MODE_CT_CLASS_A = "ct_class_a";
    private static final int DEFAULT_PHONE_INDEX = 0;
    static final String LOG_TAG = "QtiSubscriptionController";
    private static final int NOT_PROVISIONED = 0;
    private static final int PROVISIONED = 1;
    private String mCarrierMode;
    private boolean mIsCTClassA;
    private boolean mNotifyAddSubInfo;

    private void logd(String r1) {
    }

    public static QtiSubscriptionController init(Context r3) {
        monitor-enter(QtiSubscriptionController.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new QtiSubscriptionController(r3);     // Catch: Throwable -> L11
    L8:
        QtiSubscriptionController r4 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(QtiSubscriptionController.class);     // Catch: Throwable -> L11
        return r4;
    L7:
        Log.wtf(LOG_TAG, "init() called multiple times!  sInstance = " + sInstance);     // Catch: Throwable -> L11
        goto L8
    }

    public static QtiSubscriptionController getInstance() {
        if (sInstance != null) goto L6;
        Log.wtf(LOG_TAG, "getInstance null");
    L6:
        return sInstance;
    }

    private QtiSubscriptionController(Context r2) {
        super(r2);
        String r3 = SystemProperties.get("persist.vendor.radio.carrier_mode", "default");
        this.mCarrierMode = r3;
        this.mIsCTClassA = r3.equals(CARRIER_MODE_CT_CLASS_A);
        this.mNotifyAddSubInfo = true;
    }

    public boolean isRadioInValidState() {
        int r1 = QtiTelephonyComponentFactory.getInstance().getRil(0).getPropertyValueInt(APM_SIM_NOT_PWDN_PROPERTY, 0);     // Catch: Throwable -> L5
    L8:
        if (r1 != 1) goto L10;
        boolean r2 = true;
    L11:
        int r3 = Settings.Global.getInt(this.mContext.getContentResolver(), "airplane_mode_on", 0);
        if (r3 != 1) goto L17;
        if (r2 == true) goto L17;
        logd("isRadioInValidState, isApmSimNotPwrDown = " + r2 + ", isAPMOn:" + r3);
        return false;
    L17:
        return super.isRadioInValidState();
    L10:
        r2 = false;
    L5:
        e = move-exception;
        loge("Exception: " + e);
        r1 = 0;
        goto L8
    }

    protected void handleDataPreference(int r3) {
        if (getActiveSubscriptionInfoList(this.mContext.getOpPackageName()) != null) goto L5;
        return;
    L5:
        logd(" handleDataPreference ");
        if (this.mIsCTClassA == true) goto L8;
    L10:
        super.handleDataPreference(r3);
    L12:
        if (PhoneFactory.getPhone(0).getHalVersion().less(RIL.RADIO_HAL_VERSION_1_5) == false) goto L15;
        QtiUiccCardProvisioner.getInstance().setDdsIfRequired();
        return;
    L15:
        return;
    L8:
        if (isSubProvisioned(getSubId(0)[0]) == false) goto L10;
        logd("set dds to slot0 for ct classA mode");
        setDefaultDataSubId(getSubId(0)[0]);
        goto L12
    }

    private int getUiccProvisionStatus(int r1) {
        QtiPhoneUtils r0 = QtiPhoneUtils.getInstance();
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.getCurrentUiccCardProvisioningStatus(r1);
    }

    protected boolean isSubProvisioned(int r5) {
        boolean r0 = SubscriptionManager.isUsableSubIdValue(r5);
        if (r0 == false) goto L12;
        int r1 = getSlotIndex(r5);
        if (SubscriptionManager.isValidSlotIndex(r1) == true) goto L8;
        loge(" Invalid slotId " + r1 + " or subId = " + r5);
        return false;
    L8:
        if (getUiccProvisionStatus(r1) == 1) goto L10;
        r0 = false;
    L10:
        loge("isSubProvisioned, state = " + r0 + " subId = " + r5);
        return r0;
    L12:
        return r0;
    }

    public boolean isSMSPromptEnabled() {
        boolean r0 = false;
        int r1 = Settings.Global.getInt(this.mContext.getContentResolver(), "multi_sim_sms_prompt");     // Catch: Settings.SettingNotFoundException -> L5
    L6:
        if (r1 == 0) goto L10;
        r0 = true;
    L10:
        if (VDBG == false) goto L12;
        logd("SMS Prompt option:" + r0);
    L12:
        return r0;
    L5:
        loge("Settings Exception Reading Dual Sim SMS Prompt Values");
        r1 = 0;
        goto L6
    }

    public void setSMSPromptEnabled(boolean r3) {
        enforceModifyPhoneState("setSMSPromptEnabled");
        Settings.Global.putInt(this.mContext.getContentResolver(), "multi_sim_sms_prompt", r3 ? 1 : 0);
        logi("setSMSPromptOption to " + r3);
    }

    public boolean setSubscriptionEnabled(boolean r4, int r5) {
        enforceModifyPhoneState("setSubscriptionEnabled");
        boolean r2 = true;
        if (getUiccProvisionStatus(getSlotIndex(r5)) == 1) goto L6;
        r2 = false;
    L6:
        if (r4 != r2) goto L9;
        return false;
    L9:
        return super.setSubscriptionEnabled(r4, r5);
    }

    public int setUiccApplicationsEnabled(boolean r3, int r4) {
        Phone r0 = PhoneFactory.getPhone(SubscriptionManager.getPhoneId(r4));
        if (r0 != null) goto L5;
    L7:
        enforceModifyPhoneState("setUiccApplicationsEnabled");
        long r1 = Binder.clearCallingIdentity();
        int r5 = getSlotIdForSubId(r4);     // Catch: Throwable -> L15
        if (r3 == false) goto L11;
        int r6 = QtiUiccCardProvisioner.getInstance().activateUiccCard(r5);     // Catch: Throwable -> L15
    L12:
        refreshCachedActiveSubscriptionInfoList();     // Catch: Throwable -> L15
        notifySubscriptionInfoChanged();     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(r1);
        return r6;
    L11:
        r6 = QtiUiccCardProvisioner.getInstance().deactivateUiccCard(r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(r1);
        throw th;
    L5:
        if (r0.getHalVersion().greaterOrEqual(RIL.RADIO_HAL_VERSION_1_5) == false) goto L7;
        return super.setUiccApplicationsEnabled(r3, r4);
    }

    private int getSlotIdForSubId(int r3) {
        SubscriptionManager r0 = (SubscriptionManager) this.mContext.getSystemService(SubscriptionManager.class);
        if (r0 != null) goto L7;
        return -1;
    L7:
        if (r0.isActiveSubscriptionId(r3) == false) goto L11;
        return getSlotIndex(r3);
    L11:
        return getSlotIdForDeactivatedSub(r3);
    }

    private int getSlotIdForDeactivatedSub(int r6) {
        SubscriptionInfo r7 = getSubscriptionInfo(r6);
        UiccSlotInfo[] r0 = ((TelephonyManager) this.mContext.getSystemService(TelephonyManager.class)).getUiccSlotsInfo();
        if (r0 != null) goto L5;
        return -1;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r0.length) goto L13;
        if (r7.getIccId().equals(r0[r2].getCardId()) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        logd("getSlotIdForDeactivatedSub: slotId found: " + r2);
        return r2;
    L13:
        return -1;
    }

    protected boolean isUiccProvisioned(int r3) {
        int[] r4 = getSubId(r3);
        if (r4 != null) goto L5;
    L8:
        return false;
    L5:
        if (r4.length <= 0) goto L8;
        return isSubProvisioned(r4[0]);
    }

    public int addSubInfo(String r4, String r5, int r6, int r7) {
        int r8 = super.addSubInfo(r4, r5, r6, r7);
        int r9 = TelephonyManager.getDefault().getActiveModemCount();
        if (r9 > 1) goto L5;
    L14:
        return r8;
    L5:
        if (this.mNotifyAddSubInfo == false) goto L14;
        int r10 = 0;
    L7:
        if (r10 >= r9) goto L13;
        PhoneFactory.getPhone(r10).notifySubInfoAdded();     // Catch: ClassCastException -> L10
    L12:
        r10 = r10 + 1;
    L10:
        e = move-exception;
        loge("addSubInfo, exception " + e);
        goto L12
    L13:
        this.mNotifyAddSubInfo = false;
        goto L14
    }

    private void logi(String r1) {
        Rlog.i(LOG_TAG, r1);
    }

    private void loge(String r1) {
        Rlog.e(LOG_TAG, r1);
    }
}
