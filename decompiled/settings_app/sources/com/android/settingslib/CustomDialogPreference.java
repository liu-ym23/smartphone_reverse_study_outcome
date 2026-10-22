package com.android.settingslib;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.DialogPreference;
import androidx.preference.PreferenceDialogFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class CustomDialogPreference extends DialogPreference {
    private CustomPreferenceDialogFragment mFragment;
    private DialogInterface.OnShowListener mOnShowListener;

    public static class CustomPreferenceDialogFragment extends PreferenceDialogFragment {
        public void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment, android.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(this, r1);
        }

        @Override // android.app.Fragment
        public void onPause() {
            com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(this);
        }

        @Override // android.app.Fragment
        public void onResume() {
            com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(this);
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
            return (CustomDialogPreference) getPreference();
        }

        @Override // androidx.preference.PreferenceDialogFragment
        protected void onPrepareDialogBuilder(AlertDialog.Builder r2) {
            super.onPrepareDialogBuilder(r2);
            CustomDialogPreference.access$000(getCustomizablePreference(), this);
            getCustomizablePreference().onPrepareDialogBuilder(r2, this);
        }

        @Override // androidx.preference.PreferenceDialogFragment
        public void onDialogClosed(boolean r1) {
            getCustomizablePreference().onDialogClosed(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragment
        protected void onBindDialogView(View r1) {
            super.onBindDialogView(r1);
            getCustomizablePreference().onBindDialogView(r1);
        }

        @Override // androidx.preference.PreferenceDialogFragment, android.app.DialogFragment
        public Dialog onCreateDialog(Bundle r1) {
            Dialog r2 = super.onCreateDialog(r1);
            r2.setOnShowListener(CustomDialogPreference.access$100(getCustomizablePreference()));
            return r2;
        }

        @Override // androidx.preference.PreferenceDialogFragment, android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            super.onClick(r1, r2);
            getCustomizablePreference().onClick(r1, r2);
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Fragment(CustomPreferenceDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_Fragment " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Fragment(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_Fragment " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Fragment(CustomPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settingslib_CustomDialogPreference$CustomPreferenceDialogFragment__onPause$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Fragment " + r0);
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

    static /* synthetic */ DialogInterface.OnShowListener access$100(CustomDialogPreference r0) {
        return r0.getOnShowListener();
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

    public void setOnShowListener(DialogInterface.OnShowListener r1) {
        this.mOnShowListener = r1;
    }

    private void setFragment(CustomPreferenceDialogFragment r1) {
        this.mFragment = r1;
    }

    private DialogInterface.OnShowListener getOnShowListener() {
        return this.mOnShowListener;
    }
}
