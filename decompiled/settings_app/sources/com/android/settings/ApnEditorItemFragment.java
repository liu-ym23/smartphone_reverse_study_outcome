package com.android.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputLayout;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ApnEditorItemFragment extends DialogFragment {
    private static final String KEY_INPUT_CONTENT = "input_content";
    private OSimpleFormDialog mInputDialog;
    private TitleSummaryItem mItem;
    private OEditText mOEditor;
    private View.OnClickListener mOnClickListener;

    public void com_android_settings_ApnEditorItemFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_ApnEditorItemFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(ApnEditorItemFragment r0, OInputLayout r1, String r2) {
        r0.initOEditor(r1, r2);
    }

    static /* synthetic */ void access$100(ApnEditorItemFragment r0) {
        r0.doApplyApn();
    }

    static /* synthetic */ OSimpleFormDialog access$200(ApnEditorItemFragment r0) {
        return r0.mInputDialog;
    }

    public void setOnClickListener(View.OnClickListener r1) {
        this.mOnClickListener = r1;
    }

    public ApnEditorItemFragment() {
    }

    public ApnEditorItemFragment(TitleSummaryItem r1) {
        this.mItem = r1;
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r12) {
        TitleSummaryItem r0 = this.mItem;
        if (r0 != null) goto L6;
        dismiss();
        return null;
    L6:
        final String r1 = r0.getText();
        if (r12 == null) goto L9;
        r1 = r12.getString(KEY_INPUT_CONTENT, r1);
    L9:
        String r13 = "";
        if (r1 != null) goto L13;
        r1 = "";
    L13:
        if (this.mItem.getTitle() == null) goto L15;
        r13 = this.mItem.getTitle().toString();
    L15:
        final String r3 = r13;
        OSimpleFormDialog r14 = new OSimpleFormDialog(getActivity(), new OSimpleFormDialog.Modifier(r3, "", new OSimpleFormDialog.InputViewConfig(true, false, new AnonymousClass1(this, r3, r1)), new OSimpleFormDialog.InputViewConfig(false, false, null), new OBaseDialog.ButtonConfig(getString(R.string.menu_ok_confirm), new AnonymousClass2(this), null), new OBaseDialog.ButtonConfig(getString(R.string.menu_cancel_confirm), new AnonymousClass3(this), null)));
        this.mInputDialog = r14;
        return r14;
    }

    private void initOEditor(OInputLayout r3, String r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.mOEditor = (OEditText) r3.findViewById(R.id.input);
        int r0 = 2;
        if (this.mItem.getInputMethodType() != 1) goto L8;
    L11:
        this.mOEditor.setInputType(r0);
        this.mOEditor.setSingleLine();
        this.mOEditor.setText(r4);
        this.mOEditor.setSelection(0, r4.length());
        this.mOEditor.setOnEditorActionListener(new AnonymousClass4(this));
        return;
    L8:
        if (this.mItem.getInputMethodType() != 2) goto L10;
        r0 = 129;
        goto L11
    L10:
        r0 = 1;
        goto L11
    }

    private void doApplyApn() {
        OEditText r0 = this.mOEditor;
        if (r0 != null) goto L5;
    L7:
        String r1 = "";
    L9:
        if (this.mOnClickListener == null) goto L12;
        TextView r2 = new TextView((Context) NullSafe.nonNull(getActivity()));
        r2.setText(r1);
        this.mOnClickListener.onClick(r2);
        return;
    L12:
        return;
    L5:
        if (r0.getText() == null) goto L7;
        r1 = this.mOEditor.getText().toString();
        goto L9
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        OEditText r0 = this.mOEditor;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getText() != null) goto L7;
        String r1 = this.mOEditor.getText().toString();
    L8:
        r2.putString(KEY_INPUT_CONTENT, r1);
        return;
    L7:
        r1 = null;
        goto L8
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mInputDialog = null;
        this.mOEditor = null;
        this.mItem = null;
        this.mOnClickListener = null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ApnEditorItemFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApnEditorItemFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ApnEditorItemFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ApnEditorItemFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ApnEditorItemFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ApnEditorItemFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
