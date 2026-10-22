package com.android.settings;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.ListPreference;
import androidx.preference.ListPreferenceDialogFragmentCompat;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CustomListPreference extends ListPreference {

    public static class CustomListPreferenceDialogFragment extends ListPreferenceDialogFragmentCompat {
        private static final String KEY_CLICKED_ENTRY_INDEX = "settings.CustomListPrefDialog.KEY_CLICKED_ENTRY_INDEX";
        private int mClickedDialogEntryIndex;

        public void com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public CustomListPreferenceDialogFragment() {
        }

        static /* synthetic */ CustomListPreference access$000(CustomListPreferenceDialogFragment r0) {
            return r0.getCustomizablePreference();
        }

        public static ListPreferenceDialogFragmentCompat newInstance(String r3) {
            CustomListPreferenceDialogFragment r0 = new CustomListPreferenceDialogFragment();
            Bundle r1 = new Bundle(1);
            r1.putString("key", r3);
            r0.setArguments(r1);
            return r0;
        }

        private CustomListPreference getCustomizablePreference() {
            return (CustomListPreference) getPreference();
        }

        @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
        protected void onPrepareDialogBuilder(AlertDialog.Builder r3) {
            super.onPrepareDialogBuilder(r3);
            this.mClickedDialogEntryIndex = getCustomizablePreference().findIndexOfValue(getCustomizablePreference().getValue());
            getCustomizablePreference().onPrepareDialogBuilder(r3, getOnItemClickListener());
            if (getCustomizablePreference().isAutoClosePreference() == true) goto L6;
            r3.setPositiveButton(R.string.okay, new AnonymousClass1(this));
            return;
        }

        @Override // androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r4) {
            Dialog r0 = super.onCreateDialog(r4);
            if (r4 == null) goto L5;
            this.mClickedDialogEntryIndex = r4.getInt(KEY_CLICKED_ENTRY_INDEX, this.mClickedDialogEntryIndex);
        L5:
            ((CustomListPreference) NullSafe.nonNull(getCustomizablePreference())).onDialogCreated(r0);
            return r0;
        }

        @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r2) {
            super.onSaveInstanceState(r2);
            r2.putInt(KEY_CLICKED_ENTRY_INDEX, this.mClickedDialogEntryIndex);
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onActivityCreated(Bundle r2) {
            super.onActivityCreated(r2);
            getCustomizablePreference().onDialogStateRestored(getDialog(), r2);
        }

        protected DialogInterface.OnClickListener getOnItemClickListener() {
            return new AnonymousClass2(this);
        }

        protected void setClickedDialogEntryIndex(int r1) {
            this.mClickedDialogEntryIndex = r1;
        }

        @Override // androidx.preference.ListPreferenceDialogFragmentCompat, androidx.preference.PreferenceDialogFragmentCompat
        public void onDialogClosed(boolean r2) {
            getCustomizablePreference().onDialogClosed(r2);
            CustomListPreference r0 = getCustomizablePreference();
            if (r2 == true) goto L5;
            return;
        L5:
            if (this.mClickedDialogEntryIndex < 0) goto L14;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.getEntryValues() == null) goto L16;
            String r1 = r0.getEntryValues()[this.mClickedDialogEntryIndex].toString();
            if (r0.callChangeListener(r1) == false) goto L17;
            r0.setValue(r1);
            return;
        L17:
            return;
        L16:
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CustomListPreferenceDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CustomListPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CustomListPreferenceDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_CustomListPreference$CustomListPreferenceDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    protected boolean isAutoClosePreference() {
        return true;
    }

    protected void onDialogClosed(boolean r1) {
    }

    protected void onDialogCreated(Dialog r1) {
    }

    protected void onDialogStateRestored(Dialog r1, Bundle r2) {
    }

    protected void onPrepareDialogBuilder(AlertDialog.Builder r1, DialogInterface.OnClickListener r2) {
    }

    public CustomListPreference(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public CustomListPreference(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
