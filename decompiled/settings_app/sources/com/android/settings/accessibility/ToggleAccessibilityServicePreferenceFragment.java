package com.android.settings.accessibility;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.ConfirmDeviceCredentialActivityNew;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.utils.NullSafe;
import com.android.settingslib.accessibility.AccessibilityUtils;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ToggleAccessibilityServicePreferenceFragment extends ToggleFeaturePreferenceFragment implements DialogInterface.OnClickListener {
    public static final int ACTIVITY_REQUEST_CONFIRM_CREDENTIAL_FOR_WEAKER_ENCRYPTION = 1;
    private static final int DIALOG_ID_DISABLE_WARNING = 2;
    private static final int DIALOG_ID_ENABLE_WARNING = 1;
    private ComponentName mComponentName;
    private LockPatternUtils mLockPatternUtils;
    private final SettingsContentObserver mSettingsContentObserver;
    private int mShownDialogId;

    private boolean isFullDiskEncrypted() {
        return false;
    }

    public ToggleAccessibilityServicePreferenceFragment() {
        final Handler r1 = new Handler();
        this.mSettingsContentObserver = new AnonymousClass1(this, r1);
    }

    static /* synthetic */ void access$000(ToggleAccessibilityServicePreferenceFragment r0) {
        r0.updateSwitchBarToggleSwitch();
    }

    static /* synthetic */ ComponentName access$100(ToggleAccessibilityServicePreferenceFragment r0) {
        return r0.mComponentName;
    }

    static /* synthetic */ void access$200(ToggleAccessibilityServicePreferenceFragment r0, int r1) {
        r0.showDialog(r1);
    }

    static /* synthetic */ void access$300(ToggleAccessibilityServicePreferenceFragment r0, int r1) {
        r0.showDialog(r1);
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment, com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.mLockPatternUtils = new LockPatternUtils(getActivity());
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.mSettingsContentObserver.register(getContentResolver());
        updateSwitchBarToggleSwitch();
        super.onResume();
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.mSettingsContentObserver.unregister(getContentResolver());
        super.onPause();
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    public void onPreferenceToggled(String r1, boolean r2) {
        ComponentName r3 = ComponentName.unflattenFromString(r1);
        AccessibilityUtils.setAccessibilityServiceState(getActivity(), r3, r2);
    }

    private AccessibilityServiceInfo getAccessibilityServiceInfo() {
        List<AccessibilityServiceInfo> r0 = AccessibilityManager.getInstance(getActivity()).getInstalledAccessibilityServiceList();
        int r1 = r0.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        AccessibilityServiceInfo r3 = r0.get(r2);
        ResolveInfo r4 = r3.getResolveInfo();
        if (this.mComponentName.getPackageName().equals(r4.serviceInfo.packageName) == false) goto L9;
        if (this.mComponentName.getClassName().equals(r4.serviceInfo.name) == false) goto L9;
        return r3;
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        return null;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.DialogCreatable
    public Dialog onCreateDialog(int r9) {
        if (r9 != 1) goto L5;
        this.mShownDialogId = 1;
        AccessibilityServiceInfo r10 = getAccessibilityServiceInfo();
        if (r10 != null) goto L16;
        return null;
    L16:
        AlertDialog r11 = new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.enable_service_title, new Object[]{r10.getResolveInfo().loadLabel(getPackageManager())})).setView(createEnableDialogContentView(r10)).setCancelable(true).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).create();
        View.OnTouchListener r0 = new AnonymousClass2(this);
        r11.create();
        r11.getButton(-1).setOnTouchListener(r0);
        Window r8 = r11.getWindow();
        WindowManager.LayoutParams r1 = r8.getAttributes();
        r1.privateFlags |= MultiSDKAdapterNew.getOverlayWindowsFlag();
        r8.setAttributes(r1);
        return r11;
    L5:
        if (r9 != 2) goto L12;
        this.mShownDialogId = 2;
        AccessibilityServiceInfo r12 = getAccessibilityServiceInfo();
        if (r12 != null) goto L10;
        return null;
    L10:
        return new AlertDialog.Builder(getActivity()).setTitle(getString(R.string.disable_service_title, new Object[]{r12.getResolveInfo().loadLabel(getPackageManager())})).setMessage(getString(R.string.disable_service_message, new Object[]{r12.getResolveInfo().loadLabel(getPackageManager())})).setCancelable(true).setPositiveButton(android.R.string.ok, this).setNegativeButton(android.R.string.cancel, this).create();
    L12:
        throw new IllegalArgumentException();
    }

    private void updateSwitchBarToggleSwitch() {
        String r0 = Settings.Secure.getString(getContentResolver(), "enabled_accessibility_services");
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.mSwitchBar.setCheckedInternal(r1);
        return;
    L5:
        if (r0.contains(this.mComponentName.flattenToString()) == false) goto L7;
        r1 = true;
        goto L8
    }

    private View createEnableDialogContentView(AccessibilityServiceInfo r17) {
        LayoutInflater r1 = (LayoutInflater) getSystemService("layout_inflater");
        ViewGroup r3 = null;
        View r2 = r1.inflate(R.layout.enable_accessibility_service_dialog_content, null);
        TextView r4 = (TextView) r2.findViewById(R.id.encryption_warning);
        int r7 = 0;
        if (isFullDiskEncrypted() == false) goto L5;
        r4.setText(getString(R.string.enable_service_encryption_warning, new Object[]{r17.getResolveInfo().loadLabel(getPackageManager())}));
        r4.setVisibility(0);
    L6:
        ((TextView) r2.findViewById(R.id.capabilities_header)).setText(getString(R.string.capabilities_list_title, new Object[]{r17.getResolveInfo().loadLabel(getPackageManager())}));
        LinearLayout r5 = (LinearLayout) r2.findViewById(R.id.capabilities);
        View r6 = r1.inflate(android.R.layout.autofill_dataset_picker, null);
        ((ImageView) r6.findViewById(android.R.id.search_app_icon)).setImageDrawable(getActivity().getDrawable(android.R.drawable.pointer_wait_vector_21));
        ((TextView) r6.findViewById(android.R.id.search_edit_frame)).setText(getString(R.string.capability_title_receiveAccessibilityEvents));
        ((TextView) r6.findViewById(android.R.id.search_mag_icon)).setText(getString(R.string.capability_desc_receiveAccessibilityEvents));
        List r12 = r17.getCapabilityInfos();
        r5.addView(r6);
        int r8 = r12.size();
    L7:
        if (r7 >= r8) goto L9;
        AccessibilityServiceInfo.CapabilityInfo r13 = (AccessibilityServiceInfo.CapabilityInfo) r12.get(r7);
        View r14 = r1.inflate(android.R.layout.autofill_dataset_picker, r3);
        ((ImageView) r14.findViewById(android.R.id.search_app_icon)).setImageDrawable(getActivity().getDrawable(android.R.drawable.pointer_wait_vector_21));
        ((TextView) r14.findViewById(android.R.id.search_edit_frame)).setText(getString(r13.titleResId));
        ((TextView) r14.findViewById(android.R.id.search_mag_icon)).setText(getString(r13.descResId));
        r5.addView(r14);
        r7 = r7 + 1;
        r3 = null;
        goto L7
    L9:
        return r2;
    L5:
        r4.setVisibility(8);
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r4, int r5, Intent r6) {
        if (r4 == 1) goto L5;
    L10:
        super.onActivityResult(r4, r5, r6);
        return;
    L5:
        if (r5 != (-1)) goto L9;
        handleConfirmServiceEnabled(true);
        if (isFullDiskEncrypted() == false) goto L10;
        Settings.Global.putInt(getContentResolver(), "require_password_to_decrypt", 0);
        goto L10
    L9:
        handleConfirmServiceEnabled(false);
        goto L10
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        boolean r0 = false;
        if (r4 == (-2)) goto L16;
        if (r4 != (-1)) goto L14;
        if (this.mShownDialogId == 1) goto L9;
        handleConfirmServiceEnabled(false);
        return;
    L9:
        if (isFullDiskEncrypted() == false) goto L11;
        startActivityForResult(ConfirmDeviceCredentialActivityNew.createIntent(createConfirmCredentialReasonMessage(), null), 1);
        return;
    L11:
        handleConfirmServiceEnabled(true);
        return;
    L14:
        throw new IllegalArgumentException();
    L16:
        if (this.mShownDialogId != 2) goto L18;
        r0 = true;
    L18:
        handleConfirmServiceEnabled(r0);
    }

    private void handleConfirmServiceEnabled(boolean r3) {
        this.mSwitchBar.setCheckedInternal(r3);
        getArguments().putBoolean("checked", r3);
        onPreferenceToggled(this.mPreferenceKey, r3);
    }

    private String createConfirmCredentialReasonMessage() {
        int r0 = this.mLockPatternUtils.getKeyguardStoredPasswordQuality(UserHandle.myUserId());
        if (r0 != 65536) goto L5;
        int r1 = R.string.enable_service_pattern_reason;
    L12:
        return getString(r1, new Object[]{getAccessibilityServiceInfo().getResolveInfo().loadLabel((PackageManager) NullSafe.nonNull(getPackageManager()))});
    L5:
        if (r0 != 131072) goto L7;
    L9:
        r1 = R.string.enable_service_pin_reason;
        goto L12
    L7:
        if (r0 == 196608) goto L9;
        r1 = R.string.enable_service_password_reason;
        goto L12
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onInstallSwitchBarToggleSwitch() {
        super.onInstallSwitchBarToggleSwitch();
        this.mToggleSwitch.setOnBeforeCheckedChangeListener(new AnonymousClass3(this));
    }

    @Override // com.android.settings.accessibility.ToggleFeaturePreferenceFragment
    protected void onProcessArguments(Bundle r5) {
        super.onProcessArguments(r5);
        String r0 = r5.getString(AccessibilitySettings.EXTRA_SETTINGS_TITLE);
        String r1 = r5.getString(AccessibilitySettings.EXTRA_SETTINGS_COMPONENT_NAME);
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L9:
        this.mComponentName = (ComponentName) r5.getParcelable(AccessibilitySettings.EXTRA_COMPONENT_NAME);
        return;
    L5:
        if (TextUtils.isEmpty(r1) == true) goto L9;
        Intent r2 = new Intent("android.intent.action.MAIN").setComponent(ComponentName.unflattenFromString(r1.toString()));
        if (getPackageManager().queryIntentActivities(r2, 0).isEmpty() == true) goto L9;
        this.mSettingsTitle = r0;
        this.mSettingsIntent = r2;
        setHasOptionsMenu(true);
        goto L9
    }
}
