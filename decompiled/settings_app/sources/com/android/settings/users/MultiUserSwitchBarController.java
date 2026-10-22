package com.android.settings.users;

import android.content.Context;
import android.os.UserHandle;
import android.provider.Settings;
import com.android.settings.widget.SwitchWidgetController;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.core.lifecycle.LifecycleObserver;
import com.android.settingslib.core.lifecycle.events.OnStart;
import com.android.settingslib.core.lifecycle.events.OnStop;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class MultiUserSwitchBarController implements SwitchWidgetController.OnSwitchChangeListener, LifecycleObserver, OnStart, OnStop {
    private static final String TAG = "MultiUserSwitchBarCtrl";
    private final Context mContext;
    private final OnMultiUserSwitchChangedListener mListener;
    final SwitchWidgetController mSwitchBar;
    private final UserCapabilities mUserCapabilities;

    interface OnMultiUserSwitchChangedListener {
        void onMultiUserSwitchChanged(boolean r1);
    }

    MultiUserSwitchBarController(Context r1, SwitchWidgetController r2, OnMultiUserSwitchChangedListener r3) {
        this.mContext = r1;
        this.mSwitchBar = r2;
        this.mListener = r3;
        this.mUserCapabilities = UserCapabilities.create(r1);
        updateState();
        r2.setListener(this);
    }

    void updateState() {
        this.mUserCapabilities.updateAddUserCapabilities(this.mContext);
        this.mSwitchBar.setChecked(this.mUserCapabilities.mUserSwitcherEnabled);
        RestrictedLockUtils.EnforcedAdmin r0 = RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_user_switch", UserHandle.myUserId());
        if (r0 == null) goto L5;
        this.mSwitchBar.setDisabledByAdmin(r0);
        return;
    L5:
        SwitchWidgetController r1 = this.mSwitchBar;
        if (this.mUserCapabilities.mIsMain == true) goto L8;
    L10:
        boolean r3 = false;
    L11:
        r1.setEnabled(r3);
        return;
    L8:
        if (this.mUserCapabilities.mDisallowSwitchUser == true) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStart
    public void onStart() {
        this.mSwitchBar.startListening();
    }

    @Override // com.android.settingslib.core.lifecycle.events.OnStop
    public void onStop() {
        this.mSwitchBar.stopListening();
    }

    @Override // com.android.settings.widget.SwitchWidgetController.OnSwitchChangeListener
    public boolean onSwitchToggled(boolean r3) {
        OLog.d(TAG, "Toggling multi-user feature enabled state to: " + r3);
        return Settings.Global.putInt(this.mContext.getContentResolver(), "user_switcher_enabled", r3 ? 1 : 0);
    }

    public boolean isSwitchDisallow() {
        if (RestrictedLockUtilsInternal.checkIfRestrictionEnforced(this.mContext, "no_user_switch", UserHandle.myUserId()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isSwitchEnable() {
        return this.mSwitchBar.isChecked();
    }
}
