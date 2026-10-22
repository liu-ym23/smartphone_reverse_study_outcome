package com.android.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceDialogFragmentCompat;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CustomDialogPreference extends DialogPreference {
    private CustomPreferenceDialogFragment mFragment;

    public static class CustomPreferenceDialogFragment extends PreferenceDialogFragmentCompat {
        public void com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
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

        private CustomDialogPreference getCustomizablePreference() {
            return (CustomDialogPreference) NullSafe.nonNull(getPreference());
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat
        protected void onPrepareDialogBuilder(AlertDialog.Builder r2) {
            super.onPrepareDialogBuilder(r2);
            if (getCustomizablePreference() == null) goto L6;
            CustomDialogPreference.access$000(getCustomizablePreference(), this);
            getCustomizablePreference().onPrepareDialogBuilder(r2, this);
            return;
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat
        public void onDialogClosed(boolean r1) {
            getCustomizablePreference().onDialogClosed(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat
        protected void onBindDialogView(View r1) {
            super.onBindDialogView(r1);
            getCustomizablePreference().onBindDialogView(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            super.onClick(r1, r2);
            getCustomizablePreference().onClick(r1, r2);
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CustomPreferenceDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_CustomDialogPreference$CustomPreferenceDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    protected void onBindDialogView(View r1) {
    }

    protected void onClick(DialogInterface r1, int r2) {
    }

    protected void onDialogClosed(boolean r1) {
    }

    protected void onPrepareDialogBuilder(AlertDialog.Builder r1, DialogInterface.OnClickListener r2) {
    }

    static /* synthetic */ void access$000(CustomDialogPreference r0, CustomPreferenceDialogFragment r1) {
        r0.setFragment(r1);
    }

    public CustomDialogPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }

    public CustomDialogPreference(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    public CustomDialogPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CustomDialogPreference(Context r1) {
        super(r1);
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

    private void setFragment(CustomPreferenceDialogFragment r1) {
        this.mFragment = r1;
    }
}
