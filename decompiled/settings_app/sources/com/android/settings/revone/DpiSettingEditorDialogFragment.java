package com.android.settings.revone;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.fragment.app.DialogFragment;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DpiSettingEditorDialogFragment extends DialogFragment implements TextWatcher {
    private static final String TAG = "com.android.settings.revone.DpiSettingEditorDialogFragment";
    private CharSequence mContent;
    private AlertDialog mDialog;
    private EditText mEditor;
    private Handler mHandler;
    private View.OnClickListener mListener;
    private CharSequence mTitle;

    static {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public void com_android_settings_revone_DpiSettingEditorDialogFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_DpiSettingEditorDialogFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    public DpiSettingEditorDialogFragment() {
    }

    static /* synthetic */ View.OnClickListener access$000(DpiSettingEditorDialogFragment r0) {
        return r0.mListener;
    }

    static /* synthetic */ EditText access$100(DpiSettingEditorDialogFragment r0) {
        return r0.mEditor;
    }

    static /* synthetic */ AlertDialog access$200(DpiSettingEditorDialogFragment r0) {
        return r0.mDialog;
    }

    public void init(CharSequence r1, CharSequence r2, View.OnClickListener r3) {
        this.mTitle = r1;
        this.mContent = r2;
        this.mListener = r3;
        this.mHandler = new Handler();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        this.mDialog = new AlertDialog.Builder(getActivity()).setTitle(this.mTitle).setView(createDialogView(this.mContent)).setPositiveButton(R.string.wifi_save, new AnonymousClass1(this)).setNegativeButton(R.string.cancel, null).create();
        updateSaveButtonEnableState();
        this.mDialog.getWindow().setSoftInputMode(37);
        return this.mDialog;
    }

    private View createDialogView(CharSequence r4) {
        View r0 = ((LayoutInflater) getActivity().getSystemService("layout_inflater")).inflate(R.layout.dialog_edittext, null);
        OEditText r1 = ((OInputView) NullSafe.nonNull(r0.findViewById(R.id.edittext))).getVInput();
        this.mEditor = r1;
        r1.setHint(R.string.tablet_dpi_settings_hint);
        this.mEditor.requestFocus();
        this.mEditor.setInputType(2);
        this.mEditor.addTextChangedListener(this);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        this.mEditor.setText(r4);
        this.mEditor.setSelection(0, r4.length());
    L5:
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mDialog = null;
        this.mListener = null;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        updateSaveButtonEnableState();
    }

    private void updateSaveButtonEnableState() {
        final boolean r0 = isInputContentValid(this.mEditor.getText().toString());
        Handler r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.post(new AnonymousClass2(this, r0));
        return;
    }

    private boolean isInputContentValid(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return isDpiValid(r2);
    }

    private boolean isDpiValid(String r2) {
        int r3 = Integer.parseInt(r2);     // Catch: NumberFormatException -> L10
        if (r3 >= 160) goto L7;
        return false;
    L7:
        if (r3 > 480) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DpiSettingEditorDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_DpiSettingEditorDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DpiSettingEditorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_DpiSettingEditorDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DpiSettingEditorDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_DpiSettingEditorDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
