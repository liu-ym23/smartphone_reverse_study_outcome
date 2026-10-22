package com.android.settingslib.inputmethod;

import android.R;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import com.GlobalProxyLancet;
import com.android.settingslib.PrimarySwitchPreference;
import com.android.settingslib.RestrictedLockUtilsInternal;
import java.text.Collator;

/* JADX INFO: loaded from: classes.dex */
public class InputMethodPreference extends PrimarySwitchPreference implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {
    private static final String TAG = "InputMethodPreference";
    private AlertDialog mDialog;
    private final boolean mHasPriorityInSorting;
    private final InputMethodInfo mImi;
    private final InputMethodSettingValuesWrapper mInputMethodSettingValues;
    private final boolean mIsAllowedByOrganization;
    private final OnSavePreferenceListener mOnSaveListener;
    private final int mUserId;

    public interface OnSavePreferenceListener {
        void onSaveInputMethodPreference(InputMethodPreference r1);
    }

    static {
    }

    public InputMethodPreference(Context r9, InputMethodInfo r10, boolean r11, OnSavePreferenceListener r12, int r13) {
        this(r9, r10, r10.loadLabel(r9.getPackageManager()), r11, r12, r13);
    }

    InputMethodPreference(Context r3, InputMethodInfo r4, CharSequence r5, boolean r6, OnSavePreferenceListener r7, int r8) {
        super(r3);
        this.mDialog = null;
        boolean r1 = false;
        setPersistent(false);
        this.mImi = r4;
        this.mIsAllowedByOrganization = r6;
        this.mOnSaveListener = r7;
        setKey(r4.getId());
        setTitle(r5);
        String r9 = r4.getSettingsActivity();
        if (TextUtils.isEmpty(r9) == false) goto L5;
        setIntent(null);
    L7:
        if (r8 == UserHandle.myUserId()) goto L10;
        r3 = getContext().createContextAsUser(UserHandle.of(r8), 0);
    L10:
        this.mInputMethodSettingValues = InputMethodSettingValuesWrapper.getInstance(r3);
        this.mUserId = r8;
        if (r4.isSystem() == true) goto L13;
    L15:
        this.mHasPriorityInSorting = r1;
        setOnPreferenceClickListener(this);
        setOnPreferenceChangeListener(this);
        return;
    L13:
        if (InputMethodAndSubtypeUtil.isValidNonAuxAsciiCapableIme(r4) == false) goto L15;
        r1 = true;
        goto L15
    L5:
        Intent r10 = new Intent("android.intent.action.MAIN");
        r10.setClassName(r4.getPackageName(), r9);
        setIntent(r10);
        goto L7
    }

    public InputMethodInfo getInputMethodInfo() {
        return this.mImi;
    }

    @Override // com.android.settingslib.PrimarySwitchPreference, com.android.settingslib.RestrictedPreference, com.android.settingslib.widget.TwoTargetPreference, androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r3) {
        super.onBindViewHolder(r3);
        final CompoundButton r0 = getSwitch();
        if (r0 == null) goto L5;
        r0.setOnClickListener(new InputMethodPreference$$ExternalSyntheticLambda2(this, r0));
    L5:
        ImageView r4 = (ImageView) r3.itemView.findViewById(R.id.icon);
        int r2 = getContext().getResources().getDimensionPixelSize(com.android.settingslib.R.dimen.secondary_app_icon_size);
        if (r4 == null) goto L10;
        if (r2 <= 0) goto L11;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
        r1.height = r2;
        r1.width = r2;
        r4.setLayoutParams(r1);
        return;
    L11:
        return;
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m762x17bf641(CompoundButton r2, View r3) {
        if (r2.isEnabled() == true) goto L5;
        return;
    L5:
        boolean r4 = !isChecked();
        r2.setChecked(isChecked());
        callChangeListener(Boolean.valueOf(r4));
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r1, Object r2) {
        if (isChecked() == false) goto L7;
        setCheckedInternal(false);
        return false;
    L7:
        if (this.mImi.isSystem() == true) goto L9;
        showSecurityWarnDialog();
    L18:
        return false;
    L9:
        if (this.mImi.getServiceInfo().directBootAware == false) goto L11;
    L16:
        setCheckedInternal(true);
        goto L18
    L11:
        if (isTv() == true) goto L16;
        if (isTv() == true) goto L18;
        showDirectBootWarnDialog();
        goto L18
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference r5) {
        Context r6 = getContext();
        Intent r1 = getIntent();     // Catch: ActivityNotFoundException -> L7
        if (r1 == null) goto L9;
        r6.startActivityAsUser(r1, UserHandle.of(this.mUserId));     // Catch: ActivityNotFoundException -> L7
    L9:
        return true;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "IME's Settings Activity Not Found", e);
        Toast.makeText(r6, r6.getString(com.android.settingslib.R.string.failed_to_open_app_settings_toast, new Object[]{this.mImi.loadLabel(r6.getPackageManager())}), 1).show();
        goto L9
    }

    public void updatePreferenceViews() {
        if (this.mInputMethodSettingValues.isAlwaysCheckedIme(this.mImi) == false) goto L6;
        setDisabledByAdmin(null);
        setSwitchEnabled(false);
    L9:
        setChecked(this.mInputMethodSettingValues.isEnabledImi(this.mImi));
        if (isDisabledByAdmin() == true) goto L13;
        setSummary(getSummaryString());
        return;
    L13:
        return;
    L6:
        if (this.mIsAllowedByOrganization == true) goto L8;
        setDisabledByAdmin(RestrictedLockUtilsInternal.checkIfInputMethodDisallowed(getContext(), this.mImi.getPackageName(), this.mUserId));
        goto L9
    L8:
        setEnabled(true);
        setSwitchEnabled(true);
        goto L9
    }

    private InputMethodManager getInputMethodManager() {
        return (InputMethodManager) getContext().getSystemService("input_method");
    }

    private String getSummaryString() {
        return InputMethodAndSubtypeUtil.getSubtypeLocaleNameListAsSentence(getInputMethodManager().getEnabledInputMethodSubtypeList(this.mImi, true), getContext(), this.mImi);
    }

    private void setCheckedInternal(boolean r1) {
        super.setChecked(r1);
        this.mOnSaveListener.onSaveInputMethodPreference(this);
        notifyChanged();
    }

    private void showSecurityWarnDialog() {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        Context r1 = getContext();
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setCancelable(true);
        r2.setTitle(R.string.dialog_alert_title);
        CharSequence r3 = this.mImi.getServiceInfo().applicationInfo.loadLabel(r1.getPackageManager());
        r2.setMessage(r1.getString(com.android.settingslib.R.string.ime_security_warning, new Object[]{r3}));
        r2.setPositiveButton(R.string.ok, new InputMethodPreference$$ExternalSyntheticLambda3(this));
        r2.setNegativeButton(R.string.cancel, new InputMethodPreference$$ExternalSyntheticLambda4(this));
        r2.setOnCancelListener(new InputMethodPreference$$ExternalSyntheticLambda5(this));
        AlertDialog r4 = r2.create();
        this.mDialog = r4;
        r4.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$1$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m765x4324a060(DialogInterface r1, int r2) {
        if (this.mImi.getServiceInfo().directBootAware == false) goto L5;
    L8:
        setCheckedInternal(true);
        return;
    L5:
        if (isTv() == true) goto L8;
        showDirectBootWarnDialog();
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$2$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m766x53da6d21(DialogInterface r1, int r2) {
        setCheckedInternal(false);
    }

    /* JADX INFO: renamed from: lambda$showSecurityWarnDialog$3$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m767x649039e2(DialogInterface r1) {
        setCheckedInternal(false);
    }

    private boolean isTv() {
        if ((getContext().getResources().getConfiguration().uiMode & 15) != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private void showDirectBootWarnDialog() {
        AlertDialog r0 = this.mDialog;
        if (r0 != null) goto L5;
    L7:
        Context r1 = getContext();
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setCancelable(true);
        r2.setMessage(r1.getText(com.android.settingslib.R.string.direct_boot_unaware_dialog_message));
        r2.setPositiveButton(R.string.ok, new InputMethodPreference$$ExternalSyntheticLambda0(this));
        r2.setNegativeButton(R.string.cancel, new InputMethodPreference$$ExternalSyntheticLambda1(this));
        AlertDialog r3 = r2.create();
        this.mDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
        this.mDialog.dismiss();
        goto L7
    }

    /* JADX INFO: renamed from: lambda$showDirectBootWarnDialog$4$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m763x43b71f1e(DialogInterface r1, int r2) {
        setCheckedInternal(true);
    }

    /* JADX INFO: renamed from: lambda$showDirectBootWarnDialog$5$com-android-settingslib-inputmethod-InputMethodPreference, reason: not valid java name */
    /* synthetic */ void m764x546cebdf(DialogInterface r1, int r2) {
        setCheckedInternal(false);
    }

    public int compareTo(InputMethodPreference r5, Collator r6) {
        int r0 = 0;
        if (this != r5) goto L5;
        return 0;
    L5:
        boolean r1 = this.mHasPriorityInSorting;
        if (r1 == r5.mHasPriorityInSorting) goto L11;
        if (r1 == true) goto L23;
        return 1;
    L23:
        return -1;
    L11:
        CharSequence r4 = getTitle();
        CharSequence r7 = r5.getTitle();
        boolean r2 = TextUtils.isEmpty(r4);
        boolean r3 = TextUtils.isEmpty(r7);
        if (r2 == true) goto L16;
        if (r3 == true) goto L16;
        return r6.compare(r4.toString(), r7.toString());
    L16:
        if (r2 == false) goto L18;
        int r8 = -1;
    L19:
        if (r3 == false) goto L22;
        r0 = -1;
    L22:
        return r8 - r0;
    L18:
        r8 = 0;
        goto L19
    }
}
