package com.android.settings.specialaccess.notificationaccess;

import android.content.ComponentName;
import android.service.notification.NotificationListenerFilter;
import com.android.settings.notification.NotificationBackend;

/* JADX INFO: loaded from: classes2.dex */
public class PreUpgradePreferenceController {
    private ComponentName mCn;
    private NotificationListenerFilter mNlf;
    private NotificationBackend mNm;
    private int mTargetSdk;
    private int mUserId;

    public PreUpgradePreferenceController() {
    }

    public PreUpgradePreferenceController setCn(ComponentName r1) {
        this.mCn = r1;
        return this;
    }

    public PreUpgradePreferenceController setUserId(int r1) {
        this.mUserId = r1;
        return this;
    }

    public PreUpgradePreferenceController setNm(NotificationBackend r1) {
        this.mNm = r1;
        return this;
    }

    public PreUpgradePreferenceController setTargetSdk(int r1) {
        this.mTargetSdk = r1;
        return this;
    }

    public boolean getAvailabilityStatus() {
        NotificationListenerFilter r0 = this.mNm.getListenerFilter(this.mCn, this.mUserId);
        this.mNlf = r0;
        if (this.mTargetSdk <= 31) goto L6;
        return false;
    L6:
        if (r0.areAllTypesAllowed() == true) goto L8;
    L12:
        return false;
    L8:
        if (this.mNlf.getDisallowedPackages().isEmpty() == false) goto L12;
        return true;
    }
}
