package com.android.settings.accounts;

import android.accounts.Account;
import android.app.ActivityManager;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.PreferenceViewHolder;
import androidx.preference.SwitchPreference;
import com.android.settings.R;
import com.android.settingslib.widget.AnimatedImageView;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class SyncStateSwitchPreference extends SwitchPreference {
    private Account mAccount;
    private String mAuthority;
    private boolean mFailed;
    private boolean mIsActive;
    private boolean mIsPending;
    private boolean mOneTimeSyncMode;

    public SyncStateSwitchPreference(Context r3, AttributeSet r4) {
        super(r3, r4, 0, R.style.SyncSwitchPreference);
        this.mIsActive = false;
        this.mIsPending = false;
        this.mFailed = false;
        this.mOneTimeSyncMode = false;
        this.mAccount = null;
        this.mAuthority = null;
    }

    public SyncStateSwitchPreference(Context r4, Account r5, String r6) {
        super(r4, null, 0, R.style.SyncSwitchPreference);
        this.mIsActive = false;
        this.mIsPending = false;
        this.mFailed = false;
        this.mOneTimeSyncMode = false;
        setup(r5, r6);
    }

    public void setup(Account r1, String r2) {
        this.mAccount = r1;
        this.mAuthority = r2;
        notifyChanged();
    }

    @Override // androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r8) {
        super.onBindViewHolder(r8);
        AnimatedImageView r0 = (AnimatedImageView) r8.findViewById(R.id.sync_active);
        View r1 = r8.findViewById(R.id.sync_failed);
        if (this.mIsActive == false) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L12;
        int r6 = 0;
    L13:
        r0.setVisibility(r6);
        r0.setAnimating(this.mIsActive);
        if (this.mFailed == false) goto L17;
        if (r2 == true) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L20;
        int r4 = 0;
    L21:
        r1.setVisibility(r4);
        View r5 = r8.findViewById(android.R.id.switch_widget);
        if (this.mOneTimeSyncMode == false) goto L24;
        r5.setVisibility(8);
        ((TextView) r8.findViewById(android.R.id.summary)).setText(getContext().getString(R.string.sync_one_time_sync, new Object[]{getSummary()}));
        return;
    L24:
        r5.setVisibility(0);
        return;
    L20:
        r4 = 8;
    L17:
        r3 = false;
        goto L18
    L12:
        r6 = 8;
        goto L13
    L5:
        if (this.mIsPending == true) goto L8;
        r2 = false;
        goto L10
    }

    public void setActive(boolean r1) {
        this.mIsActive = r1;
        notifyChanged();
    }

    public void setPending(boolean r1) {
        this.mIsPending = r1;
        notifyChanged();
    }

    public void setFailed(boolean r1) {
        this.mFailed = r1;
        notifyChanged();
    }

    public void setOneTimeSyncMode(boolean r1) {
        this.mOneTimeSyncMode = r1;
        notifyChanged();
    }

    public boolean isOneTimeSyncMode() {
        return this.mOneTimeSyncMode;
    }

    @Override // androidx.preference.TwoStatePreference, androidx.preference.Preference
    protected void onClick() {
        if (this.mOneTimeSyncMode == false) goto L5;
        return;
    L5:
        if (ActivityManager.isUserAMonkey() == false) goto L7;
        OLog.d("SyncState", "ignoring monkey's attempt to flip sync state");
        return;
    L7:
        super.onClick();
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public String getAuthority() {
        return this.mAuthority;
    }
}
