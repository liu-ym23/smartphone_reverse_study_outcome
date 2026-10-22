package com.android.settings;

import android.accounts.Account;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AccountItem extends RelativeLayout {
    public static final int SYNC_DISABLED = 1;
    public static final int SYNC_ENABLED = 0;
    public static final int SYNC_ERROR = 2;
    public static final int SYNC_IN_PROGRESS = 3;
    private static final String TAG = "AccountItem";
    private final Account mAccount;
    private final ArrayList<String> mAuthorities;
    private final boolean mShowTypeIcon;
    private int mStatus;
    private final TextView mSubTitle;
    private final ImageView mSyncStatusIcon;
    private final TextView mTitle;

    public AccountItem(Context r3, Account r4, Drawable r5, ArrayList<String> r6, boolean r7) {
        super(r3);
        LayoutInflater.from(r3).inflate(R.layout.setting_account_item_layout, this, true);
        this.mTitle = (TextView) findViewById(R.id.item_title);
        this.mSubTitle = (TextView) findViewById(R.id.item_subtitle);
        this.mSyncStatusIcon = (ImageView) findViewById(R.id.item_icon);
        this.mAccount = r4;
        this.mAuthorities = r6;
        this.mShowTypeIcon = r7;
        if (r7 == false) goto L5;
        setIcon(r5);
    L6:
        setTitle(r4.name);
        setSummary(r4.name);
        setSyncStatus(1, false);
        return;
    L5:
        setIcon(getSyncStatusIcon(1));
        goto L6
    }

    public void setTitle(String r1) {
        this.mTitle.setText(r1);
    }

    public void setSummary(CharSequence r1) {
        this.mSubTitle.setText(r1);
    }

    public void setSummary(int r1) {
        this.mSubTitle.setText(r1);
    }

    public void setIcon(int r1) {
        this.mSyncStatusIcon.setBackgroundResource(r1);
    }

    public void setIcon(Drawable r1) {
        this.mSyncStatusIcon.setBackground(r1);
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public ArrayList<String> getAuthorities() {
        return this.mAuthorities;
    }

    public void setSyncStatus(int r3, boolean r4) {
        this.mStatus = r3;
        if (this.mShowTypeIcon == true) goto L7;
        ImageView r0 = this.mSyncStatusIcon;
        if (r0 == null) goto L7;
        r0.setImageResource(getSyncStatusIcon(r3));
        this.mSyncStatusIcon.setContentDescription(getSyncContentDescription(this.mStatus));
    L7:
        if (r4 == false) goto L10;
        setSummary(getSyncStatusMessage(r3));
        return;
    }

    private int getSyncStatusMessage(int r3) {
        if (r3 != 0) goto L4;
        return R.string.sync_enabled;
    L4:
        if (r3 != 1) goto L6;
        return R.string.sync_disabled;
    L6:
        if (r3 != 2) goto L8;
        return R.string.sync_error;
    L8:
        if (r3 == 3) goto L10;
        OLog.e(TAG, "Unknown sync status: " + r3);
        return R.string.sync_error;
    L10:
        return R.string.sync_in_progress;
    }

    private int getSyncStatusIcon(int r3) {
        if (r3 != 0) goto L5;
        return R.drawable.ic_sync_green;
    L5:
        if (r3 != 1) goto L7;
        return R.drawable.ic_sync_grey;
    L7:
        if (r3 == 2) goto L16;
        if (r3 == 3) goto L15;
        OLog.e(TAG, "Unknown sync status: " + r3);
        goto L16
    L15:
        return R.drawable.ic_sync_green;
    L16:
        return R.drawable.ic_sync_red;
    }

    private String getSyncContentDescription(int r4) {
        if (r4 == 0) goto L14;
        if (r4 == 1) goto L12;
        if (r4 == 2) goto L10;
        OLog.e(TAG, "Unknown sync status: " + r4);
        return getContext().getString(R.string.accessibility_sync_error);
    L10:
        return getContext().getString(R.string.accessibility_sync_error);
    L12:
        return getContext().getString(R.string.accessibility_sync_disabled);
    L14:
        return getContext().getString(R.string.accessibility_sync_enabled);
    }
}
