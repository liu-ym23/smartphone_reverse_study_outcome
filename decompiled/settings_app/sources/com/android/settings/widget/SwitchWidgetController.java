package com.android.settings.widget;

import com.android.settingslib.RestrictedLockUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class SwitchWidgetController {
    protected OnSwitchChangeListener mListener;

    public interface OnSwitchChangeListener {
        boolean onSwitchToggled(boolean r1);
    }

    public abstract boolean isChecked();

    public abstract void setChecked(boolean r1);

    public abstract void setDisabledByAdmin(RestrictedLockUtils.EnforcedAdmin r1);

    public abstract void setEnabled(boolean r1);

    public abstract void setTitle(String r1);

    public void setupView() {
    }

    public abstract void startListening();

    public abstract void stopListening();

    public void teardownView() {
    }

    public SwitchWidgetController() {
    }

    public void setListener(OnSwitchChangeListener r1) {
        this.mListener = r1;
    }
}
