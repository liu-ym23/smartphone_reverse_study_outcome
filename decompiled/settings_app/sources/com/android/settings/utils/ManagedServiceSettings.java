package com.android.settings.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.widget.CompoundButton;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingSwitchPreference;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ManagedServiceSettings extends SettingsPreferenceFragment23 {
    private final Config mConfig;
    protected Context mContext;
    protected PackageManager mPM;
    protected ServiceListing mServiceListing;

    public static class Config {
        public int emptyText;
        public String intentAction;
        public String noun;
        public String permission;
        public String secondarySetting;
        public String setting;
        public String tag;
        public int warningDialogSummary;
        public int warningDialogTitle;

        public Config() {
        }
    }

    public static class ScaryWarningDialogFragment extends DialogFragment {
        static final String KEY_COMPONENT = "c";
        static final String KEY_LABEL = "l";
        CompoundButton checkbox;

        public void com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment__onCreate$___twin___(Bundle r1) {
            super.onCreate(r1);
        }

        public void com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment__onResume$___twin___() {
            super.onResume();
        }

        @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ScaryWarningDialogFragment() {
        }

        public ScaryWarningDialogFragment(CompoundButton r1) {
            this.checkbox = r1;
        }

        public ScaryWarningDialogFragment setServiceInfo(ComponentName r3, String r4, Fragment r5) {
            Bundle r0 = new Bundle();
            r0.putString(KEY_COMPONENT, r3.flattenToString());
            r0.putString(KEY_LABEL, r4);
            setArguments(r0);
            setTargetFragment(r5, 0);
            return this;
        }

        @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r3) {
            CompoundButton r0 = this.checkbox;
            if (r0 == null) goto L5;
            r0.setChecked(false);
        L5:
            super.onCancel(r3);
        }

        @Override // androidx.fragment.app.DialogFragment
        public Dialog onCreateDialog(Bundle r9) {
            super.onCreate(r9);
            Bundle r10 = getArguments();
            String r0 = r10.getString(KEY_LABEL);
            final ComponentName r11 = ComponentName.unflattenFromString(r10.getString(KEY_COMPONENT));
            final ManagedServiceSettings r1 = (ManagedServiceSettings) getTargetFragment();
            return new AlertDialog.Builder(getContext()).setMessage(getResources().getString(ManagedServiceSettings.access$000(r1).warningDialogSummary, new Object[]{r0})).setTitle(getResources().getString(ManagedServiceSettings.access$000(r1).warningDialogTitle, new Object[]{r0})).setCancelable(true).setPositiveButton(R.string.allow, new AnonymousClass2(this, r1, r11)).setNegativeButton(R.string.deny, new AnonymousClass1(this)).create();
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ScaryWarningDialogFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ScaryWarningDialogFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ScaryWarningDialogFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_utils_ManagedServiceSettings$ScaryWarningDialogFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    protected abstract Config getConfig();

    protected void onServiceEnabled(Context r1, String r2) {
    }

    static /* synthetic */ Config access$000(ManagedServiceSettings r0) {
        return r0.mConfig;
    }

    public ManagedServiceSettings() {
        this.mConfig = getConfig();
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        this.mContext = r4;
        this.mPM = r4.getPackageManager();
        ServiceListing r5 = new ServiceListing(this.mContext, this.mConfig);
        this.mServiceListing = r5;
        r5.addCallback(new AnonymousClass1(this));
        setPreferenceScreen(getPreferenceManager().createPreferenceScreen(this.mContext));
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mServiceListing.reload();
        this.mServiceListing.setListening(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mServiceListing.setListening(false);
    }

    protected void updateList(List<ServiceInfo> r7) {
        PreferenceScreen r0 = getPreferenceScreen();
        r0.removeAll();
        Collections.sort(r7, new PackageItemInfo.DisplayNameComparator(this.mPM));
        Iterator<ServiceInfo> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        ServiceInfo r1 = r8.next();
        final ComponentName r2 = new ComponentName(r1.packageName, r1.name);
        final String r3 = r1.loadLabel(this.mPM).toString();
        SettingSwitchPreference r4 = new SettingSwitchPreference(this.mContext);
        r4.setPersistent(false);
        r4.setIcon(r1.loadIcon(this.mPM));
        r4.setTitle(r3);
        r4.setChecked(isServiceEnabled(r2));
        r4.setOnCheckedChangeListener(new AnonymousClass2(this, r2, r3));
        r0.addPreference(r4);
        goto L4
    }

    protected boolean setEnabled(CompoundButton r2, ComponentName r3, String r4, boolean r5) {
        if (r5 == true) goto L10;
        if (isServiceEnabled(r3) == true) goto L7;
        return true;
    L7:
        disable(r3);
        return true;
    L10:
        if (isServiceEnabled(r3) == false) goto L12;
        return true;
    L12:
        new ScaryWarningDialogFragment(r2).setServiceInfo(r3, r4, this).show(getParentFragmentManager(), "dialog");
        return false;
    }

    protected boolean isServiceEnabled(ComponentName r1) {
        return this.mServiceListing.isEnabled(r1);
    }

    protected void enable(ComponentName r2) {
        this.mServiceListing.setEnabled(r2, true);
    }

    protected void disable(ComponentName r2) {
        this.mServiceListing.setEnabled(r2, false);
    }
}
