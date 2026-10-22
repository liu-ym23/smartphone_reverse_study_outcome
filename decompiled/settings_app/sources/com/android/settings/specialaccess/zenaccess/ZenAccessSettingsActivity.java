package com.android.settings.specialaccess.zenaccess;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArraySet;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessSwitchViewHolder;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ZenAccessSettingsActivity extends SpecialAccessBaseActivity implements ZenAccessSettingObserverMixin.Listener {
    private final String TAG;
    private ApplicationAdapter mApplicationAdapter;
    private Context mContext;
    private NotificationManager mNoMan;
    private PackageManager mPkgMan;

    static class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private final Activity activity;
        ArrayList<ApplicationInfo> apps;
        ArraySet<String> autoApproved;
        private PackageManager mPkgMan;

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return onCreateContentViewHolder(r1, r2);
        }

        public ApplicationAdapter(Activity r1, PackageManager r2, Function1<OSectionSupportiveText, Unit> r3) {
            super(r3);
            this.apps = new ArrayList();
            this.autoApproved = new ArraySet();
            this.activity = r1;
            this.mPkgMan = r2;
        }

        public void setData(ArrayList<ApplicationInfo> r1, ArraySet<String> r2) {
            this.apps = r1;
            this.autoApproved = r2;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public SpecialAccessSwitchViewHolder onCreateContentViewHolder(ViewGroup r1, int r2) {
            return new SpecialAccessSwitchViewHolder(SpecialAccessSwitchViewHolder.newView(r1));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r3, int r4) {
            SpecialAccessSwitchViewHolder r5 = (SpecialAccessSwitchViewHolder) r3;
            ApplicationInfo r0 = this.apps.get(r4);
            r5.setIcon(ObricIconUtils.getDrawable(r0));
            CharSequence r1 = r0.loadLabel(this.mPkgMan);
            r5.setTitle(r1, r1);
            r5.initCardItemInAdapter(this.apps.size(), r4);
            r5.updateSwitch(getSwitchOnCheckedListener(r0), enableSwitch(r0.packageName), checkSwitch(r0.packageName));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            ArrayList<ApplicationInfo> r0 = this.apps;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.size();
        }

        public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ApplicationInfo r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new ZenAccessSettingsActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r2);
        }

        /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$0$com-android-settings-specialaccess-zenaccess-ZenAccessSettingsActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ void m621xa8189f37(ApplicationInfo r1, CompoundButton r2, boolean r3) {
            if (r3 == false) goto L4;
            ZenAccessController.setAccess(this.activity, r1.packageName, true);
            return;
        L4:
            ZenAccessController.deleteRules(this.activity, r1.packageName);
            ZenAccessController.setAccess(this.activity, r1.packageName, false);
        }

        private final boolean enableSwitch(String r1) {
            return !this.autoApproved.contains(r1);
        }

        private final boolean checkSwitch(String r1) {
            return ZenAccessController.hasAccess(this.activity, r1);
        }
    }

    public void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.zen_access_empty_text;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.manage_zen_access_subtitle;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.manage_zen_access_title;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ZenAccessSettingsActivity() {
        this.TAG = "ZenAccessSettings";
    }

    public void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mContext = this;
        this.mPkgMan = getPackageManager();
        this.mNoMan = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        this.mApplicationAdapter = new ApplicationAdapter(this, this.mPkgMan, new ZenAccessSettingsActivity$$ExternalSyntheticLambda0(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
        getSettingsLifecycle().addObserver(new ZenAccessSettingObserverMixin(this, this));
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-specialaccess-zenaccess-ZenAccessSettingsActivity, reason: not valid java name */
    /* synthetic */ Unit m620x972da23(OSectionSupportiveText r1) {
        initDescText(r1);
        return Unit.INSTANCE;
    }

    public void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onResume$___twin___() {
        super.onResume();
        reloadList();
    }

    @Override // com.android.settings.specialaccess.zenaccess.ZenAccessSettingObserverMixin.Listener
    public void onZenAccessPolicyChanged() {
        reloadList();
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r4) {
        int r0 = this.mApplicationAdapter.getItemCount();
        if (this.mPackageName == null) goto L13;
        if (r0 <= 0) goto L13;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L13;
        ApplicationInfo r2 = this.mApplicationAdapter.apps.get(r1);
        if (r2 == null) goto L12;
        if (TextUtils.equals(r4, r2.packageName) == false) goto L12;
    L14:
        OLog.i("ZenAccessSettings", "jump to: " + r1 + ", package: " + r4);
        return r1;
    L12:
        r1 = r1 + 1;
    L13:
        r1 = -1;
        goto L14
    }

    private void reloadList() {
        if (((UserManager) this.mContext.getSystemService(UserManager.class)).isManagedProfile(UserHandle.myUserId()) == false) goto L6;
        OLog.w("ZenAccessSettings", "DND access cannot be enabled in a work profile");
        return;
    L6:
        ArrayList<ApplicationInfo> r0 = new ArrayList();
        Set<String> r1 = ZenAccessController.getPackagesRequestingNotificationPolicyAccess();
        if (r1.isEmpty() == true) goto L16;
        List<ApplicationInfo> r2 = this.mPkgMan.getInstalledApplications(0);
        if (r2 == null) goto L16;
        Iterator<ApplicationInfo> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L16;
        ApplicationInfo r4 = r3.next();
        if (r1.contains(r4.packageName) == false) goto L12;
        r0.add(r4);
    L16:
        ArraySet<String> r5 = new ArraySet();
        r5.addAll(this.mNoMan.getEnabledNotificationListenerPackages());
        r5.addAll(ZenAccessController.getPackagesWithManageNotifications());
        Collections.sort(r0, new PackageItemInfo.DisplayNameComparator(this.mPkgMan));
        if (r0.isEmpty() == false) goto L19;
        showEmptyView();
    L20:
        this.mApplicationAdapter.setData(r0, r5);
        updatePositionAfterNotify();
        return;
    L19:
        showContent();
        goto L20
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ZenAccessSettingsActivity r1) {
        r1.com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ZenAccessSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ZenAccessSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ZenAccessSettingsActivity r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ZenAccessSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ZenAccessSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ZenAccessSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ZenAccessSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_zenaccess_ZenAccessSettingsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ZenAccessSettingsActivity r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }
}
