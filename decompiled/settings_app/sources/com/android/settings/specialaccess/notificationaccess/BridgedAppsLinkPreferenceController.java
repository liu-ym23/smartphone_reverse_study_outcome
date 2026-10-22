package com.android.settings.specialaccess.notificationaccess;

import android.content.ComponentName;
import android.service.notification.NotificationListenerFilter;
import android.view.View;
import com.android.settings.notification.NotificationBackend;

/* JADX INFO: loaded from: classes2.dex */
public class BridgedAppsLinkPreferenceController {
    private ComponentName mCn;
    private NotificationListenerFilter mNlf;
    private NotificationBackend mNm;
    private int mTargetSdk;
    private int mUserId;

    public BridgedAppsLinkPreferenceController() {
    }

    public BridgedAppsLinkPreferenceController setCn(ComponentName r1) {
        this.mCn = r1;
        return this;
    }

    public BridgedAppsLinkPreferenceController setUserId(int r1) {
        this.mUserId = r1;
        return this;
    }

    public BridgedAppsLinkPreferenceController setNm(NotificationBackend r1) {
        this.mNm = r1;
        return this;
    }

    public BridgedAppsLinkPreferenceController setTargetSdk(int r1) {
        this.mTargetSdk = r1;
        return this;
    }

    public boolean getAvailabilityStatus() {
        if (this.mNm.isNotificationListenerAccessGranted(this.mCn) == true) goto L5;
        return false;
    L5:
        if (this.mTargetSdk <= 31) goto L7;
        return true;
    L7:
        NotificationListenerFilter r0 = this.mNm.getListenerFilter(this.mCn, this.mUserId);
        this.mNlf = r0;
        if (r0.areAllTypesAllowed() == true) goto L10;
    L11:
        return true;
    L10:
        if (this.mNlf.getDisallowedPackages().isEmpty() == false) goto L11;
        return false;
    }

    public void updateState(View r1) {
        r1.setEnabled(getAvailabilityStatus());
    }
}
