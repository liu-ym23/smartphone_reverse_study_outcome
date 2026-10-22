package com.android.settings.applications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class RunningServices extends SettingsPreferenceFragment {
    private static final int SHOW_BACKGROUND_PROCESSES = 2;
    private static final int SHOW_RUNNING_SERVICES = 1;
    private View mLoadingContainer;
    private Menu mOptionsMenu;
    private final Runnable mRunningProcessesAvail;
    private RunningProcessesView_ mRunningProcessesView_;

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public RunningServices() {
        this.mRunningProcessesAvail = new AnonymousClass1(this);
    }

    static /* synthetic */ View access$000(RunningServices r0) {
        return r0.mLoadingContainer;
    }

    static /* synthetic */ RunningProcessesView_ access$100(RunningServices r0) {
        return r0.mRunningProcessesView_;
    }

    public void com_android_settings_applications_RunningServices__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setHasOptionsMenu(true);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.manage_applications_running_, null);
        RunningProcessesView_ r5 = (RunningProcessesView_) r4.findViewById(R.id.running_processes);
        this.mRunningProcessesView_ = r5;
        r5.doCreate();
        this.mLoadingContainer = r4.findViewById(R.id.oui_loading_container);
        return r4;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(Menu r4, MenuInflater r5) {
        this.mOptionsMenu = r4;
        r4.add(0, 1, 1, R.string.show_running_services).setShowAsAction(1);
        r4.add(0, 2, 2, R.string.show_background_processes).setShowAsAction(1);
        updateOptionsMenu();
    }

    public void com_android_settings_applications_RunningServices__onResume$___twin___() {
        super.onResume();
        boolean r0 = this.mRunningProcessesView_.doResume(this, this.mRunningProcessesAvail);
        Utils.handleLoadingContainer(this.mLoadingContainer, this.mRunningProcessesView_, r0, false);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mRunningProcessesView_.doPause();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem r4) {
        int r5 = r4.getItemId();
        if (r5 != 1) goto L5;
        this.mRunningProcessesView_.mAdapter.setShowBackground(false);
    L9:
        updateOptionsMenu();
        return true;
    L5:
        if (r5 == 2) goto L7;
        return false;
    L7:
        this.mRunningProcessesView_.mAdapter.setShowBackground(true);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onPrepareOptionsMenu(Menu r1) {
        updateOptionsMenu();
    }

    private void updateOptionsMenu() {
        boolean r0 = this.mRunningProcessesView_.mAdapter.getShowBackground();
        this.mOptionsMenu.findItem(1).setVisible(r0);
        this.mOptionsMenu.findItem(2).setVisible(!r0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(RunningServices r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_RunningServices__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(RunningServices r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applications_RunningServices_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(RunningServices r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applications_RunningServices__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
