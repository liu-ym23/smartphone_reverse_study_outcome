package com.android.settings.specialaccess.notificationaccess;

import android.content.ComponentName;
import android.content.pm.ServiceInfo;
import android.service.notification.NotificationListenerFilter;
import android.text.TextUtils;
import android.widget.CompoundButton;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.notification.NotificationBackend;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeFilterPreferenceController implements CompoundButton.OnCheckedChangeListener {
    private static final String FLAG_SEPARATOR = "\\|";
    private static final String TAG = "TypeFilterPrefCntlr";
    private ComponentName mCn;
    private NotificationListenerFilter mNlf;
    private NotificationBackend mNm;
    private ServiceInfo mSi;
    private int mTargetSdk;
    private int mUserId;

    private boolean hasFlag(int r1, int r2) {
        if ((r1 & r2) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected abstract int getType();

    public TypeFilterPreferenceController() {
    }

    public TypeFilterPreferenceController setCn(ComponentName r1) {
        this.mCn = r1;
        return this;
    }

    public TypeFilterPreferenceController setUserId(int r1) {
        this.mUserId = r1;
        return this;
    }

    public TypeFilterPreferenceController setNm(NotificationBackend r1) {
        this.mNm = r1;
        return this;
    }

    public TypeFilterPreferenceController setServiceInfo(ServiceInfo r1) {
        this.mSi = r1;
        return this;
    }

    public TypeFilterPreferenceController setTargetSdk(int r1) {
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

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        OLog.i(TAG, "onCheckedChanged: flag=" + getType() + ", isChecked:" + r4);
        NotificationListenerFilter r5 = this.mNm.getListenerFilter(this.mCn, this.mUserId);
        this.mNlf = r5;
        int r6 = r5.getTypes();
        if (r4 == false) goto L5;
        int r7 = r6 | getType();
    L6:
        this.mNlf.setTypes(r7);
        this.mNm.setListenerFilter(this.mCn, this.mUserId, this.mNlf);
        return;
    L5:
        r7 = r6 & (~getType());
        goto L6
    }

    public void updateState(OCardListItem r8) {
        NotificationListenerFilter r0 = this.mNm.getListenerFilter(this.mCn, this.mUserId);
        this.mNlf = r0;
        OCardListItemUtils.setChecked(r8, hasFlag(r0.getTypes(), getType()));
        ServiceInfo r1 = this.mSi;
        boolean r2 = true;
        if (r1 != null) goto L5;
    L34:
        boolean r3 = false;
    L35:
        if (r3 == true) goto L37;
    L39:
        boolean r4 = false;
    L41:
        if (getAvailabilityStatus() == false) goto L44;
        if (r4 == true) goto L44;
    L45:
        OCardListItemUtils.setEnabled(r8, r2);
        return;
    L44:
        r2 = false;
        goto L45
    L37:
        if (OCardListItemUtils.isChecked(r8) == true) goto L39;
        r4 = true;
        goto L41
    L5:
        if (r1.metaData == null) goto L34;
        if (this.mSi.metaData.containsKey("android.service.notification.disabled_filter_types") == false) goto L34;
        String r5 = this.mSi.metaData.get("android.service.notification.disabled_filter_types").toString();
        if (r5 == null) goto L34;
        String[] r6 = r5.split(FLAG_SEPARATOR);
        int r7 = 0;
        int r9 = 0;
    L12:
        if (r7 >= r6.length) goto L32;
        String r10 = r6[r7];
        if (TextUtils.isEmpty(r10) == true) goto L30;
        if (r10.equalsIgnoreCase("ONGOING") == false) goto L20;
        r9 = r9 | 8;
        goto L30
    L20:
        if (r10.equalsIgnoreCase("CONVERSATIONS") == false) goto L23;
        r9 = r9 | 1;
        goto L30
    L23:
        if (r10.equalsIgnoreCase("SILENT") == false) goto L26;
        r9 = r9 | 4;
        goto L30
    L26:
        if (r10.equalsIgnoreCase("ALERTING") == false) goto L48;
        r9 = r9 | 2;
        goto L30
    L48:
        r9 = r9 | Integer.parseInt(r10);
    L30:
        r7 = r7 + 1;
        goto L12
    L32:
        if (hasFlag(r9, getType()) == false) goto L34;
        r3 = true;
        goto L35
    }
}
