package com.android.settings.vpn2;

import android.content.Context;
import android.content.res.Resources;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.android.settings.GearPreference;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ManageablePreference extends GearPreference {
    public static int STATE_NONE = -1;
    boolean mIsAlwaysOn;
    int mState;
    int mUserId;

    static {
    }

    public ManageablePreference(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.mIsAlwaysOn = false;
        this.mState = STATE_NONE;
        setPersistent(false);
        setOrder(0);
        setUserId(UserHandle.myUserId());
    }

    public int getUserId() {
        return this.mUserId;
    }

    public void setUserId(int r2) {
        this.mUserId = r2;
        checkRestrictionAndSetDisabled("no_config_vpn", r2);
    }

    public boolean isAlwaysOn() {
        return this.mIsAlwaysOn;
    }

    public int getState() {
        return this.mState;
    }

    public void setState(int r2) {
        if (this.mState == r2) goto L6;
        this.mState = r2;
        updateSummary();
        notifyHierarchyChanged();
        return;
    }

    public void setAlwaysOn(boolean r2) {
        if (this.mIsAlwaysOn == r2) goto L6;
        this.mIsAlwaysOn = r2;
        updateSummary();
        return;
    }

    protected void updateSummary() {
        Resources r0 = getContext().getResources();
        String[] r1 = r0.getStringArray(R.array.vpn_states);
        int r2 = this.mState;
        if (r2 != STATE_NONE) goto L5;
        String r3 = "";
    L7:
        if (this.mIsAlwaysOn == false) goto L12;
        String r4 = r0.getString(R.string.vpn_always_on_active);
        if (TextUtils.isEmpty(r3) == false) goto L11;
        r3 = r4;
        goto L12
    L11:
        r3 = r0.getString(R.string.join_two_unrelated_items, new Object[]{r3, r4});
    L12:
        setSummary(r3);
        return;
    L5:
        r3 = r1[r2];
        goto L7
    }
}
