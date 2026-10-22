package com.android.settings;

import android.accounts.Account;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class AccountPreference extends Preference {
    public static final int SYNC_DISABLED = 1;
    public static final int SYNC_ENABLED = 0;
    public static final int SYNC_ERROR = 2;
    public static final int SYNC_IN_PROGRESS = 3;
    private static final String TAG = "AccountPreference";
    private OCardListItem itemView;
    private Account mAccount;
    private ArrayList<String> mAuthorities;
    private int mIndex;
    private boolean mShowTypeIcon;
    private int mStatus;

    public AccountPreference(Context r1, Account r2, Drawable r3, ArrayList<String> r4, boolean r5, int r6) {
        super(r1);
        setLayoutResource(R.layout.list_content_item_check_oui_with_icon_2);
        this.mAccount = r2;
        this.mAuthorities = r4;
        this.mShowTypeIcon = r5;
        if (r5 == false) goto L5;
        setIcon(r3);
    L6:
        setTitle(this.mAccount.name);
        setSummary("");
        setPersistent(false);
        setSyncStatus(1, false);
        this.mIndex = r6;
        return;
    L5:
        setIcon(getSyncStatusIcon(1));
        goto L6
    }

    public Account getAccount() {
        return this.mAccount;
    }

    public ArrayList<String> getAuthorities() {
        return this.mAuthorities;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        OCardListItem r4 = (OCardListItem) r3.itemView.findViewById(R.id.item_check);
        this.itemView = r4;
        r4.setTitle(getTitle());
        this.itemView.setSubTitle(getSummary());
        this.itemView.showSubTitle(true);
        if (this.mShowTypeIcon == true) goto L5;
        this.itemView.setAppIcon(getSyncStatusIcon(this.mStatus));
        this.itemView.setContentDescription(getSyncContentDescription(this.mStatus));
    L7:
        if (this.mIndex != 0) goto L9;
        this.itemView.setCardPosition(1);
    L10:
        this.itemView.setOnContentClickListener(new AccountPreference$$ExternalSyntheticLambda0(this));
        return;
    L9:
        this.itemView.setCardPosition(2);
        goto L10
    L5:
        this.itemView.setAppIcon(getIcon());
        goto L7
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-AccountPreference, reason: not valid java name */
    /* synthetic */ void m73lambda$onBindViewHolder$0$comandroidsettingsAccountPreference(View r1) {
        if (getOnPreferenceClickListener() == null) goto L6;
        getOnPreferenceClickListener().onPreferenceClick(this);
        return;
    }

    public void setSyncStatus(int r3, boolean r4) {
        this.mStatus = r3;
        if (this.mShowTypeIcon == true) goto L7;
        OCardListItem r0 = this.itemView;
        if (r0 == null) goto L7;
        r0.setAppIcon(getSyncStatusIcon(r3));
        this.itemView.setContentDescription(getSyncContentDescription(this.mStatus));
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
        if (r3 != 0) goto L4;
    L11:
        return R.drawable.ic_sync_green_holo;
    L4:
        if (r3 != 1) goto L6;
        return R.drawable.ic_sync_grey_holo;
    L6:
        if (r3 != 2) goto L8;
        return R.drawable.ic_sync_red_holo;
    L8:
        if (r3 == 3) goto L11;
        OLog.e(TAG, "Unknown sync status: " + r3);
        return R.drawable.ic_sync_red_holo;
    }

    private String getSyncContentDescription(int r4) {
        if (r4 == 0) goto L18;
        if (r4 == 1) goto L16;
        if (r4 == 2) goto L14;
        if (r4 == 3) goto L12;
        OLog.e(TAG, "Unknown sync status: " + r4);
        return getContext().getString(R.string.accessibility_sync_error);
    L12:
        return getContext().getString(R.string.accessibility_sync_in_progress);
    L14:
        return getContext().getString(R.string.accessibility_sync_error);
    L16:
        return getContext().getString(R.string.accessibility_sync_disabled);
    L18:
        return getContext().getString(R.string.accessibility_sync_enabled);
    }
}
