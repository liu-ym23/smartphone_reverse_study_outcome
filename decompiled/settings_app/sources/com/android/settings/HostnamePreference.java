package com.android.settings;

import android.content.Context;
import android.os.SystemProperties;
import android.preference.EditTextPreference;
import android.text.InputFilter;
import android.util.AttributeSet;
import com.obric.olog.OLog;

/* JADX INFO: loaded from: classes2.dex */
public class HostnamePreference extends EditTextPreference {
    private static final String PROP_HOSTNAME = "net.hostname";
    private static final String TAG = "HostnamePreference";
    private final String DEFAULT_HOSTNAME;
    InputFilter mHostnameInputFilter;

    public HostnamePreference(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        this.mHostnameInputFilter = new AnonymousClass1(this);
        String r5 = android.provider.Settings.Secure.getString(getContext().getContentResolver(), "android_id");
        if (r5 != null) goto L5;
    L7:
        this.DEFAULT_HOSTNAME = "";
    L8:
        setSummary(getText());
        getEditText().setFilters(new InputFilter[]{this.mHostnameInputFilter});
        getEditText().setHint(this.DEFAULT_HOSTNAME);
        return;
    L5:
        if (r5.length() <= 0) goto L7;
        this.DEFAULT_HOSTNAME = "android-".concat(r5);
        goto L8
    }

    public HostnamePreference(Context r2, AttributeSet r3) {
        this(r2, r3, android.R.attr.editTextPreferenceStyle);
    }

    public HostnamePreference(Context r2) {
        this(r2, null);
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean r3) {
        if (r3 == false) goto L11;
        String r4 = getEditText().getText().toString().replaceAll("(?:\\.|-)+$", "").replaceAll("^(?:\\.|-)+", "");
        if (r4.length() == 0) goto L6;
    L9:
        setText(r4);
        return;
    L6:
        if (this.DEFAULT_HOSTNAME.length() == 0) goto L8;
        r4 = this.DEFAULT_HOSTNAME;
        goto L9
    L8:
        r4 = getText();
        goto L9
    }

    @Override // android.preference.EditTextPreference
    public void setText(String r4) {
        if (r4 != null) goto L7;
        OLog.e(TAG, "tried to set null hostname, request ignored");
        return;
    L7:
        if (r4.length() != 0) goto L9;
        OLog.w(TAG, "setting empty hostname");
    L10:
        SystemProperties.set(PROP_HOSTNAME, r4);
        persistHostname(r4);
        setSummary(r4);
        return;
    L9:
        OLog.i(TAG, "hostname has been set: " + r4);
        goto L10
    }

    @Override // android.preference.EditTextPreference
    public String getText() {
        return SystemProperties.get(PROP_HOSTNAME);
    }

    @Override // android.preference.EditTextPreference, android.preference.Preference
    public void onSetInitialValue(boolean r1, Object r2) {
        persistHostname(getText());
    }

    public void persistHostname(String r2) {
        android.provider.Settings.Secure.putString(getContext().getContentResolver(), "device_hostname", r2);
    }
}
