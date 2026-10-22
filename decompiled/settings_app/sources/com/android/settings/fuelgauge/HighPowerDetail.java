package com.android.settings.fuelgauge;

import android.R;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class HighPowerDetail extends DialogFragment implements DialogInterface.OnClickListener, View.OnClickListener {
    private static final String ARG_DEFAULT_ON = "default_on";
    private final PowerWhitelistBackend mBackend;
    private boolean mDefaultOn;
    private boolean mIsEnabled;
    private CharSequence mLabel;
    private Checkable mOptionOff;
    private Checkable mOptionOn;
    private String mPackageName;

    public void com_android_settings_fuelgauge_HighPowerDetail__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public HighPowerDetail() {
        this.mBackend = PowerWhitelistBackend.getInstance();
    }

    public void com_android_settings_fuelgauge_HighPowerDetail__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mPackageName = getArguments().getString("package");
        PackageManager r4 = getContext().getPackageManager();
        boolean r0 = false;
        ApplicationInfo r1 = r4.getApplicationInfo(this.mPackageName, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r1 == null) goto L8;
        this.mLabel = r1.loadLabel(r4);     // Catch: PackageManager.NameNotFoundException -> L7
    L8:
        boolean r5 = getArguments().getBoolean(ARG_DEFAULT_ON);
        this.mDefaultOn = r5;
        if (r5 == false) goto L11;
    L12:
        r0 = true;
    L13:
        this.mIsEnabled = r0;
        return;
    L11:
        if (this.mBackend.isWhitelisted(this.mPackageName) == false) goto L13;
    L7:
        this.mLabel = this.mPackageName;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Checkable setup(View r3, boolean r4) {
        TextView r0 = (TextView) r3.findViewById(R.id.title);
        if (r4 == false) goto L5;
        int r1 = com.android.settings.R.string.ignore_optimizations_on;
    L6:
        r0.setText(r1);
        TextView r2 = (TextView) r3.findViewById(R.id.summary);
        if (r4 == false) goto L9;
        int r5 = com.android.settings.R.string.ignore_optimizations_on_desc;
    L10:
        r2.setText(r5);
        r3.setClickable(true);
        r3.setOnClickListener(this);
        if (r4 == true) goto L16;
        if (this.mBackend.isSysWhitelisted(this.mPackageName) == false) goto L16;
        r3.setEnabled(false);
    L16:
        return (Checkable) r3;
    L9:
        r5 = com.android.settings.R.string.ignore_optimizations_off_desc;
        goto L10
    L5:
        r1 = com.android.settings.R.string.ignore_optimizations_off;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle r3) {
        AlertDialog.Builder r4 = new AlertDialog.Builder(getContext()).setTitle(this.mLabel).setNegativeButton(com.android.settings.R.string.cancel, null).setView(com.android.settings.R.layout.ignore_optimizations_content);
        if (this.mBackend.isSysWhitelisted(this.mPackageName) == true) goto L6;
        r4.setPositiveButton(com.android.settings.R.string.done, this);
    L6:
        return r4.create();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mOptionOn = setup(getDialog().findViewById(com.android.settings.R.id.ignore_on), true);
        this.mOptionOff = setup(getDialog().findViewById(com.android.settings.R.id.ignore_off), false);
        updateViews();
    }

    private void updateViews() {
        this.mOptionOn.setChecked(this.mIsEnabled);
        this.mOptionOff.setChecked(!this.mIsEnabled);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mOptionOn) goto L6;
        this.mIsEnabled = true;
        updateViews();
        return;
    L6:
        if (r2 != this.mOptionOff) goto L10;
        this.mIsEnabled = false;
        updateViews();
        return;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        if (r3 != (-1)) goto L10;
        boolean r4 = this.mIsEnabled;
        if (r4 == this.mBackend.isWhitelisted(this.mPackageName)) goto L11;
        if (r4 == false) goto L8;
        this.mBackend.addApp(this.mPackageName);
        return;
    L8:
        this.mBackend.removeApp(this.mPackageName);
        return;
    L11:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        super.onDismiss(r3);
        Fragment r4 = getTargetFragment();
        if (r4 == null) goto L6;
        r4.onActivityResult(getTargetRequestCode(), 0, null);
        return;
    }

    public static CharSequence getSummary(Context r0, ApplicationsState.AppEntry r1) {
        return getSummary(r0, r1.info.packageName);
    }

    public static CharSequence getSummary(Context r2, String r3) {
        PowerWhitelistBackend r0 = PowerWhitelistBackend.getInstance();
        if (r0.isSysWhitelisted(r3) == false) goto L6;
        int r4 = com.android.settings.R.string.high_power_system;
    L10:
        return r2.getString(r4);
    L6:
        if (r0.isWhitelisted(r3) == false) goto L8;
        r4 = com.android.settings.R.string.high_power_on;
        goto L10
    L8:
        r4 = com.android.settings.R.string.high_power_off;
        goto L10
    }

    public static void show(Fragment r3, String r4, int r5, boolean r6) {
        HighPowerDetail r0 = new HighPowerDetail();
        Bundle r1 = new Bundle();
        r1.putString("package", r4);
        r1.putBoolean(ARG_DEFAULT_ON, r6);
        r0.setArguments(r1);
        r0.setTargetFragment(r3, r5);
        r0.show(r3.getParentFragmentManager(), "HighPowerDetail");
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HighPowerDetail r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_HighPowerDetail__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HighPowerDetail r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_fuelgauge_HighPowerDetail_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HighPowerDetail r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_fuelgauge_HighPowerDetail__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
