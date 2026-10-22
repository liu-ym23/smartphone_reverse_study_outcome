package com.qualcomm.qti.internal.telephony.data;

import android.os.Looper;
import android.telephony.data.ApnSetting;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.data.DataNetworkController;
import com.android.internal.telephony.data.DataProfileManager;
import com.android.internal.telephony.data.DataServiceManager;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class QtiDataProfileManager extends DataProfileManager {
    private static final int APN_NAME = 3;
    private static final int APN_TYPE = 1;
    private static final int DEVICE_CAPABILITY = 2;
    private static final int GID = 0;
    private static final int KEY_MULTI_APN_ARRAY_FOR_SAME_GID_ENTRY_LENGTH = 4;
    private QtiDataConfigManager mQtiDataConfigManager;
    private QtiDataNetworkController mQtiDataNetworkController;

    public QtiDataProfileManager(Phone r1, DataNetworkController r2, DataServiceManager r3, Looper r4, DataProfileManager.DataProfileManagerCallback r5) {
        super(r1, r2, r3, r4, r5);
        log("QtiDataProfileManager: constructor");
        this.mQtiDataNetworkController = (QtiDataNetworkController) this.mDataNetworkController;
        this.mQtiDataConfigManager = (QtiDataConfigManager) this.mDataConfigManager;
    }

    protected void filterApnSettingsWithRadioCapability(ArrayList<ApnSetting> r6) {
        if (this.mQtiDataConfigManager.isApnFilteringWithRadioCapabilityRequired() == true) goto L5;
        return;
    L5:
        log("filterApnSettingsWithRadioCapability start: allApnSettings: " + r6);
        int r0 = 0;
    L7:
        if (r0 >= r6.size()) goto L20;
        ApnSetting r1 = r6.get(r0);
        String r2 = ApnSetting.getApnTypesStringFromBitmask(r1.getApnTypeBitmask());
        if (r1.hasMvnoParams() == false) goto L19;
        if (r1.getMvnoType() != 2) goto L19;
        if (isApnFilteringRequired(r1.getMvnoMatchData(), r2) == false) goto L19;
        String r3 = getApnBasedOnRadioCapability(r1.getMvnoMatchData(), r2, this.mQtiDataNetworkController.getEnhancedRadioCapabilityResponse().getEnhancedRadioCapability());
        if (r3 == null) goto L19;
        if (r3.equals(r1.getApnName()) == true) goto L19;
        r6.remove(r0);
        log("filterApnSettingsWithRadioCapability: removed not supported apn:" + r1);
    L19:
        r0 = r0 + 1;
        goto L7
    L20:
        log("filterApnSettingsWithRadioCapability: end: allApnSettings:" + r6);
    }

    private boolean isApnFilteringRequired(String r7, String r8) {
        String[] r6 = this.mQtiDataConfigManager.getApnsWithSameGID();
        int r0 = r6.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        String[] r3 = r6[r2].split(":");
        if (r3.length != 4) goto L11;
        if (r7.equals(r3[0]) == false) goto L11;
        if (r8.equals(r3[1]) == false) goto L11;
        return true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return false;
    }

    private String getApnBasedOnRadioCapability(String r8, String r9, String r10) {
        if (r10 != null) goto L6;
        loge("getApnBasedOnRadioCapability: deviceCapability is null");
        return null;
    L6:
        String[] r7 = this.mQtiDataConfigManager.getApnsWithSameGID();
        int r1 = r7.length;
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L20;
        String[] r4 = r7[r3].split(":");
        if (r4.length != 4) goto L19;
        if (r10 == null) goto L19;
        if (r8.equals(r4[0]) == false) goto L19;
        if (r9.equals(r4[1]) == false) goto L19;
        if (r10.equals(r4[2]) == false) goto L19;
        return r4[3];
    L19:
        r3 = r3 + 1;
        goto L7
    L20:
        return null;
    }
}
