package com.android.settingslib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.lang.UProperty;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.EditTextPreference;
import androidx.preference.EditTextPreferenceDialogFragmentCompat;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class CustomEditTextPreferenceCompat extends EditTextPreference {
    private CustomPreferenceDialogFragment mFragment;

    public static class CustomPreferenceDialogFragment extends EditTextPreferenceDialogFragmentCompat {
        public void com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.preference.EditTextPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public CustomPreferenceDialogFragment() {
        }

        public static CustomPreferenceDialogFragment newInstance(String r3) {
            CustomPreferenceDialogFragment r0 = new CustomPreferenceDialogFragment();
            Bundle r1 = new Bundle(1);
            r1.putString("key", r3);
            r0.setArguments(r1);
            return r0;
        }

        private CustomEditTextPreferenceCompat getCustomizablePreference() {
            return (CustomEditTextPreferenceCompat) getPreference();
        }

        @Override // androidx.preference.EditTextPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
        protected void onBindDialogView(View r1) {
            super.onBindDialogView(r1);
            getCustomizablePreference().onBindDialogView(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat
        protected void onPrepareDialogBuilder(AlertDialog.Builder r2) {
            super.onPrepareDialogBuilder(r2);
            CustomEditTextPreferenceCompat.access$000(getCustomizablePreference(), this);
            getCustomizablePreference().onPrepareDialogBuilder(r2, this);
        }

        @Override // androidx.preference.EditTextPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
        public void onDialogClosed(boolean r1) {
            super.onDialogClosed(r1);
            getCustomizablePreference().onDialogClosed(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            super.onClick(r1, r2);
            getCustomizablePreference().onClick(r1, r2);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CustomPreferenceDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settingslib_CustomEditTextPreferenceCompat$CustomPreferenceDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    protected void onClick(DialogInterface r1, int r2) {
    }

    protected void onDialogClosed(boolean r1) {
    }

    protected void onPrepareDialogBuilder(AlertDialog.Builder r1, DialogInterface.OnClickListener r2) {
    }

    static /* synthetic */ void access$000(CustomEditTextPreferenceCompat r0, CustomPreferenceDialogFragment r1) {
        r0.setFragment(r1);
    }

    public CustomEditTextPreferenceCompat(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public CustomEditTextPreferenceCompat(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public CustomEditTextPreferenceCompat(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CustomEditTextPreferenceCompat(Context r1) {
        super(r1);
    }

    public EditText getEditText() {
        CustomPreferenceDialogFragment r1 = this.mFragment;
        if (r1 == null) goto L8;
        Dialog r2 = r1.getDialog();
        if (r2 != null) goto L7;
        return null;
    L7:
        return (EditText) r2.findViewById(android.R.id.edit);
    L8:
        return null;
    }

    public boolean isDialogOpen() {
        if (getDialog() != null) goto L5;
    L7:
        return false;
    L5:
        if (getDialog().isShowing() == false) goto L7;
        return true;
    }

    public Dialog getDialog() {
        CustomPreferenceDialogFragment r0 = this.mFragment;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getDialog();
    }

    protected void onBindDialogView(View r1) {
        EditText r0 = (EditText) r1.findViewById(android.R.id.edit);
        if (r0 == null) goto L6;
        r0.setInputType(UProperty.BIDI_MIRRORING_GLYPH);
        r0.requestFocus();
        return;
    }

    private void setFragment(CustomPreferenceDialogFragment r1) {
        this.mFragment = r1;
    }
}
