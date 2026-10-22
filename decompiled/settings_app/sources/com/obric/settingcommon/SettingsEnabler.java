package com.obric.settingcommon;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.CompoundButton;
import bytedanceos.app.settings.search.SearchResultItem;
import bytedanceos.app.settings.search.SwitchItemValue;
import com.android.internal.widget.LockPatternUtils;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes5.dex */
public class SettingsEnabler implements CompoundButton.OnCheckedChangeListener {
    protected static boolean sHasConfirm;
    protected Context mContext;
    private LockPatternUtils mLockPatternUtils;
    protected boolean mOpposite;
    protected SearchResultItem mSearchResultItem;
    protected OSwitch mSwitch;
    protected SwitchItemValue mSwitchItemValue;
    protected AlertDialog mTntConfirmDialog;

    public void doConfirm(boolean r1) {
    }

    protected boolean isEnabled() {
        return false;
    }

    public boolean isLeboConnected() {
        return false;
    }

    public boolean isMiracastOn() {
        return false;
    }

    public boolean isWirelessBostonOn() {
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
    }

    public void onTntConfirmDialogDismiss() {
    }

    public void onTntConfirmDialogShow() {
    }

    protected void setEnabled(boolean r1) {
    }

    public void showTntExitConfirmDialog(boolean r1, String r2, String r3) {
    }

    public SettingsEnabler(Context r2, OSwitch r3) {
        this(r2, r3, null);
    }

    public SettingsEnabler(Context r2, OSwitch r3, SwitchItemValue r4) {
        this.mOpposite = false;
        this.mContext = r2;
        this.mSwitch = r3;
        this.mSwitchItemValue = r4;
    }

    public void setSearchItem(SearchResultItem r1) {
        this.mSearchResultItem = r1;
    }

    protected void updateView() {
        OSwitch r0 = this.mSwitch;
        if (r0 == null) goto L6;
        r0.setOnCheckedChangeListener(null);
        this.mSwitch.setChecked(isEnabled());
        this.mSwitch.setOnCheckedChangeListener(this);
        return;
    }

    protected LockPatternUtils getLockPatternUtils() {
        if (this.mLockPatternUtils != null) goto L6;
        this.mLockPatternUtils = new LockPatternUtils(this.mContext);
    L6:
        return this.mLockPatternUtils;
    }

    protected void trigger() {
        setEnabled(!isEnabled());
    }

    public static void setConfirm(boolean r0) {
        sHasConfirm = r0;
    }

    public static void trigger(Context r1, SearchResultItem r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        SettingsEnabler r3 = EnablerFactory.createSettingsEnabler(r1, r2, true);
        if (r3 == null) goto L8;
        r3.trigger();
        return;
    }

    public static void trigger(Context r0, SearchResultItem r1, boolean r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        SettingsEnabler r3 = EnablerFactory.createSettingsEnabler(r0, r1, r2);
        if (r3 == null) goto L8;
        r3.trigger();
        return;
    }

    public void setOpposite(boolean r1) {
        this.mOpposite = r1;
    }

    public void dismissTntConfirmDialog() {
        AlertDialog r0 = this.mTntConfirmDialog;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L9;
        this.mTntConfirmDialog.dismiss();
        return;
    }
}
