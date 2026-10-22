package com.android.settings.bluetooth;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.android.settings.R;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceRenameDialogFragment extends DialogFragment {
    private static final int BLUETOOTH_NAME_MAX_LENGTH_BYTES = 32;
    private static final String EXTRA_DEVICE_NAME = "device_name";
    private static final String EXTRA_DIALOG_TITLE = "dialog_title";
    private static final String EXTRA_POSITIVE_BTN_TEXT = "positive_btn_text";
    private OSimpleFormDialog dialog;
    private EditText editor;
    private CharSequence mDeviceName;
    private String mDialogTitle;
    private boolean mIsDeviceNameEdited;
    private View.OnClickListener mListener;
    private OButton mOkButton;
    private String mPositiveBtnText;
    private boolean otherReasonResolved;

    public void com_android_settings_bluetooth_DeviceRenameDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ View.OnClickListener access$000(DeviceRenameDialogFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ EditText access$100(DeviceRenameDialogFragment r0) {
        return r0.editor;
    }

    static /* synthetic */ OSimpleFormDialog access$200(DeviceRenameDialogFragment r0) {
        return r0.dialog;
    }

    static /* synthetic */ CharSequence access$300(DeviceRenameDialogFragment r0) {
        return r0.mDeviceName;
    }

    static /* synthetic */ boolean access$402(DeviceRenameDialogFragment r0, boolean r1) {
        r0.mIsDeviceNameEdited = r1;
        return r1;
    }

    static /* synthetic */ OButton access$500(DeviceRenameDialogFragment r0) {
        return r0.mOkButton;
    }

    static /* synthetic */ boolean access$600(DeviceRenameDialogFragment r0) {
        return r0.renameButtonEnable();
    }

    public DeviceRenameDialogFragment() {
        this.otherReasonResolved = true;
    }

    public DeviceRenameDialogFragment(CharSequence r2) {
        this.otherReasonResolved = true;
        this.mDeviceName = r2;
    }

    public void setDialogTitle(String r1) {
        this.mDialogTitle = r1;
    }

    public void setPositiveButtonText(String r1) {
        this.mPositiveBtnText = r1;
    }

    public void setPositiveButtonClickListener(View.OnClickListener r1) {
        this.mListener = r1;
    }

    public void showInActivity(Activity r2) {
        OSimpleFormDialog r3 = buildDialog(r2, null);
        this.dialog = r3;
        r3.show();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r2) {
        return buildDialog(requireActivity(), r2);
    }

    private OSimpleFormDialog buildDialog(final Activity r12, Bundle r13) {
        if (r13 == null) goto L13;
        if (r13.containsKey(EXTRA_DEVICE_NAME) == false) goto L7;
        this.mDeviceName = r13.getCharSequence(EXTRA_DEVICE_NAME);
    L7:
        if (r13.containsKey(EXTRA_DIALOG_TITLE) == false) goto L10;
        this.mDialogTitle = r13.getString(EXTRA_DIALOG_TITLE);
    L10:
        if (r13.containsKey(EXTRA_POSITIVE_BTN_TEXT) == false) goto L13;
        this.mPositiveBtnText = r13.getString(EXTRA_POSITIVE_BTN_TEXT);
    L13:
        if (this.dialog != null) goto L15;
        this.dialog = ODialogUtils.INSTANCE.getMiscDialog(r12, this.mDialogTitle, "", this.mPositiveBtnText, r12.getString(R.string.cancel), "", "", false, new AnonymousClass1(this, r12), new AnonymousClass2(this));
    L15:
        OInputLayout r14 = (OInputLayout) ((ViewGroup) this.dialog.findViewById(R.id.simple_form_input_1_container)).getChildAt(0);
        r14.showClear(true);
        OEditText r15 = r14.getVInput();
        this.editor = r15;
        r15.setText(this.mDeviceName);
        this.editor.setSelection(0, this.mDeviceName.length());
        this.editor.setFilters(new InputFilter[]{new Utf8ByteLengthFilter(32)});
        this.editor.addTextChangedListener(new AnonymousClass3(this));
        if (this.editor.requestFocus() == false) goto L19;
        this.dialog.getWindow().setSoftInputMode(5);
    L19:
        return this.dialog;
    }

    private boolean renameButtonEnable() {
        EditText r0 = this.editor;
        if (r0 != null) goto L5;
    L11:
        return false;
    L5:
        if (r0.getText().length() <= 0) goto L11;
        if (this.mIsDeviceNameEdited == false) goto L11;
        if (this.otherReasonResolved == false) goto L11;
        return true;
    }

    public boolean isDialogShowing() {
        OSimpleFormDialog r0 = this.dialog;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public void setRenameButtonState(boolean r1) {
        this.otherReasonResolved = r1;
        OButton r2 = this.mOkButton;
        if (r2 == null) goto L6;
        r2.setEnabled(renameButtonEnable());
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r3) {
        super.onSaveInstanceState(r3);
        r3.putCharSequence(EXTRA_DEVICE_NAME, this.mDeviceName);
        r3.putString(EXTRA_DIALOG_TITLE, this.mDialogTitle);
        r3.putString(EXTRA_POSITIVE_BTN_TEXT, this.mPositiveBtnText);
    }

    public void com_android_settings_bluetooth_DeviceRenameDialogFragment__onResume$___twin___() {
        super.onResume();
        OButton r0 = this.mOkButton;
        if (r0 == null) goto L6;
        r0.setEnabled(this.mIsDeviceNameEdited);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.dialog = null;
        this.mListener = null;
        this.mOkButton = null;
        this.mIsDeviceNameEdited = false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DeviceRenameDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DeviceRenameDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DeviceRenameDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_DeviceRenameDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DeviceRenameDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_DeviceRenameDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
