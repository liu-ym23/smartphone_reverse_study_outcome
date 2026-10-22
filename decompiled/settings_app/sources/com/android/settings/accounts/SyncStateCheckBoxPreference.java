package com.android.settings.accounts;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class SyncStateCheckBoxPreference {
    static final String SYNC_EXTRAS_USER_CLICK = "sync_extras_user_click";
    private Account mAccount;
    private String mAuthority;
    private boolean mChecked;
    private boolean mFailed;
    private Drawable mIcon;
    private boolean mIsActive;
    private boolean mIsPending;
    private boolean mOneTimeSyncMode;
    private String mSummary;
    private int mSummaryResId;
    private String mTitle;
    private int mUserId;

    public boolean getSyncState() {
        return getSyncState(getAuthority(), getAccount());
    }

    private boolean getSyncState(String r1, Account r2) {
        return ContentResolver.getSyncAutomaticallyAsUser(r2, r1, this.mUserId);
    }

    public SyncStateCheckBoxPreference(Context r1, Account r2, String r3, Drawable r4, int r5) {
        this.mIsActive = false;
        this.mIsPending = false;
        this.mFailed = false;
        this.mOneTimeSyncMode = false;
        this.mAccount = r2;
        this.mAuthority = r3;
        this.mIcon = r4;
        this.mUserId = r5;
    }

    public void setTitle(CharSequence r1) {
        this.mTitle = r1.toString();
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getSummaryResId() {
        return this.mSummaryResId;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public Drawable getIcon() {
        return this.mIcon;
    }

    public int getUserId() {
        return this.mUserId;
    }

    public void setChecked(boolean r1) {
        this.mChecked = r1;
    }

    public boolean isChecked() {
        return this.mChecked;
    }

    public void setSummary(int r1) {
        this.mSummaryResId = r1;
    }

    public void setSummary(CharSequence r1) {
        this.mSummary = r1.toString();
    }

    public void requestOrCancelSync(Account r3, String r4, boolean r5) {
        if (r5 == false) goto L4;
        Bundle r6 = new Bundle();
        r6.putBoolean("force", true);
        r6.putBoolean(SYNC_EXTRAS_USER_CLICK, true);
        ContentResolver.requestSyncAsUser(r3, r4, this.mUserId, r6);
        return;
    L4:
        ContentResolver.cancelSyncAsUser(r3, r4, this.mUserId);
    }

    public void setActive(boolean r1) {
        this.mIsActive = r1;
    }

    public void setPending(boolean r1) {
        this.mIsPending = r1;
    }

    public void setFailed(boolean r1) {
        this.mFailed = r1;
    }

    public void setOneTimeSyncMode(boolean r1) {
        this.mOneTimeSyncMode = r1;
    }

    public boolean isOneTimeSyncMode() {
        return this.mOneTimeSyncMode;
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public String getAuthority() {
        return this.mAuthority;
    }
}
