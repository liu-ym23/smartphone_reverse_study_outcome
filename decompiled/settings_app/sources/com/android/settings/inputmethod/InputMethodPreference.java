package com.android.settings.inputmethod;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.preference.Preference;
import com.android.internal.inputmethod.InputMethodUtils;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settingslib.RestrictedSwitchPreference;
import com.obric.olog.OLog;
import java.text.Collator;

/* JADX INFO: loaded from: classes2.dex */
class InputMethodPreference extends RestrictedSwitchPreference implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {
    private static final String EMPTY_TEXT = "";
    private static final int NO_WIDGET = 0;
    private static final String TAG = "InputMethodPreference";
    private AlertDialog mDialog;
    private final boolean mHasPriorityInSorting;
    private final InputMethodInfo mImi;
    private final InputMethodSettingValuesWrapper mInputMethodSettingValues;
    private final boolean mIsAllowedByOrganization;
    private final OnSavePreferenceListener mOnSaveListener;

    interface OnSavePreferenceListener {
        void onSaveInputMethodPreference(InputMethodPreference r1);
    }

    static {
    }

    static /* synthetic */ OnSavePreferenceListener access$000(InputMethodPreference r0) {
        return r0.mOnSaveListener;
    }

    static /* synthetic */ void access$100(InputMethodPreference r0) {
        r0.notifyChanged();
    }

    static /* synthetic */ void access$200(InputMethodPreference r0) {
        r0.notifyChanged();
    }

    InputMethodPreference(Context r3, InputMethodInfo r4, boolean r5, boolean r6, OnSavePreferenceListener r7) {
        super(r3);
        this.mDialog = null;
        boolean r1 = false;
        setPersistent(false);
        this.mImi = r4;
        this.mIsAllowedByOrganization = r6;
        this.mOnSaveListener = r7;
        if (r5 == true) goto L5;
        setWidgetLayoutResource(0);
    L5:
        setSwitchTextOn("");
        setSwitchTextOff("");
        setKey(r4.getId());
        setTitle(r4.loadLabel(r3.getPackageManager()));
        String r8 = r4.getSettingsActivity();
        if (TextUtils.isEmpty(r8) == false) goto L8;
        setIntent(null);
    L9:
        InputMethodSettingValuesWrapper r9 = InputMethodSettingValuesWrapper.getInstance(r3);
        this.mInputMethodSettingValues = r9;
        if (InputMethodUtils.isSystemIme(r4) == true) goto L12;
    L14:
        this.mHasPriorityInSorting = r1;
        setOnPreferenceClickListener(this);
        setOnPreferenceChangeListener(this);
        return;
    L12:
        if (r9.isValidSystemNonAuxAsciiCapableIme(r4, r3) == false) goto L14;
        r1 = true;
        goto L14
    L8:
        Intent r10 = new Intent("android.intent.action.MAIN");
        r10.setClassName(r4.getPackageName(), r8);
        setIntent(r10);
        goto L9
    }

    public InputMethodInfo getInputMethodInfo() {
        return this.mImi;
    }

    private boolean isImeEnabler() {
        if (getWidgetLayoutResource() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        if (isImeEnabler() == true) goto L6;
        return false;
    L6:
        if (isChecked() == false) goto L10;
        setChecked(false);
        this.mOnSaveListener.onSaveInputMethodPreference(this);
        return false;
    L10:
        if (InputMethodUtils.isSystemIme(this.mImi) == false) goto L13;
        setChecked(true);
        this.mOnSaveListener.onSaveInputMethodPreference(this);
        return false;
    L13:
        showSecurityWarnDialog(this.mImi);
        return false;
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r5) {
        if (isImeEnabler() == false) goto L5;
        return true;
    L5:
        Context r6 = getContext();
        Intent r1 = getIntent();     // Catch: ActivityNotFoundException -> L10
        if (r1 == null) goto L12;
        r6.startActivity(r1);     // Catch: ActivityNotFoundException -> L10
    L12:
        return true;
    L10:
        e = move-exception;
        OLog.d(TAG, "IME's Settings Activity Not Found", e);
        ToastUtils.show(r6, r6.getString(R.string.failed_to_open_app_settings_toast, new Object[]{this.mImi.loadLabel(r6.getPackageManager())}));
        goto L12
    }

    void updatePreferenceViews() {
        if (this.mInputMethodSettingValues.isAlwaysCheckedIme(this.mImi, getContext()) == false) goto L8;
        if (isImeEnabler() == false) goto L8;
        setDisabledByAdmin(null);
        setEnabled(false);
    L11:
        setChecked(this.mInputMethodSettingValues.isEnabledImi(this.mImi));
        if (isDisabledByAdmin() == true) goto L15;
        setSummary(getSummaryString());
        return;
    L15:
        return;
    L8:
        if (this.mIsAllowedByOrganization == true) goto L10;
        setDisabledByAdmin(MultiSDKAdapterNew.checkIfInputMethodDisallowed(getContext(), this.mImi.getPackageName(), UserHandle.myUserId()));
        goto L11
    L10:
        setEnabled(true);
        goto L11
    }

    private InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getContext().getSystemService("input_method");
    }

    private String getSummaryString() {
        return InputMethodAndSubtypeUtil.getSubtypeLocaleNameListAsSentence(getInputMethodManager().getEnabledInputMethodSubtypeList(this.mImi, true), getContext(), this.mImi);
    }

    private void showSecurityWarnDialog(InputMethodInfo r5) {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        Context r1 = getContext();
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setCancelable(true);
        r2.setTitle(android.R.string.dialog_alert_title);
        r2.setMessage(r1.getString(R.string.ime_security_warning, new Object[]{r5.getServiceInfo().applicationInfo.loadLabel(r1.getPackageManager())}));
        r2.setPositiveButton(android.R.string.ok, new AnonymousClass1(this));
        r2.setNegativeButton(android.R.string.cancel, new AnonymousClass2(this));
        AlertDialog r6 = r2.create();
        this.mDialog = r6;
        r6.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    int compareTo(InputMethodPreference r5, Collator r6) {
        if (this != r5) goto L5;
        return 0;
    L5:
        boolean r0 = this.mHasPriorityInSorting;
        if (r0 != r5.mHasPriorityInSorting) goto L15;
        CharSequence r4 = getTitle();
        CharSequence r7 = r5.getTitle();
        if (TextUtils.isEmpty(r4) == false) goto L11;
        return 1;
    L11:
        if (TextUtils.isEmpty(r7) == false) goto L14;
        return -1;
    L14:
        return r6.compare(r4.toString(), r7.toString());
    L15:
        if (r0 == false) goto L18;
        return -1;
    L18:
        return 1;
    }
}
