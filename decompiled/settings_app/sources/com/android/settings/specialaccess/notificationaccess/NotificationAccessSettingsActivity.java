package com.android.settings.specialaccess.notificationaccess;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.companion.ICompanionDeviceManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.IconDrawableFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.ToastUtils;
import com.android.settings.accounts.obric.ObricIconUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.bluetooth.Utils;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.specialaccess.SpecialAccessBaseActivity;
import com.android.settings.specialaccess.SpecialAccessGeneralViewHolder;
import com.android.settings.specialaccess.SpecialAccessHeaderAdapter;
import com.android.settings.specialaccess.SpecialAccessHeaderViewHolder;
import com.android.settings.specialaccess.vrlistener.ManagedServiceActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.applications.ServiceListing;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationAccessSettingsActivity extends SpecialAccessBaseActivity {
    public static final ManagedServiceActivity.Config CONFIG = null;
    private static final String TAG = "NotificationAccessSettingsActivity";
    private ApplicationAdapter mApplicationAdapter;
    private NotificationBackend mBackend;
    protected Context mContext;
    private DevicePolicyManager mDpm;
    private IconDrawableFactory mIconDrawableFactory;
    NotificationManager mNm;
    private PackageManager mPm;
    private ServiceListing mServiceListing;

    static class ApplicationAdapter extends SpecialAccessHeaderAdapter {
        private int TYPE_ALLOW_CONTENT;
        private int TYPE_ALLOW_HEADER;
        private int TYPE_NOT_ALLOW_CONTENT;
        private int TYPE_NOT_ALLOW_HEADER;
        private final Activity activity;
        List<ServiceInfo> allowedList;
        private NotificationBackend mBackend;
        private DevicePolicyManager mDpm;
        private PackageManager mPkgMan;
        private ServiceListing mServiceListing;
        private int managedProfileId;
        List<ServiceInfo> notAllowedList;

        private final boolean enableSwitch(ComponentName r1) {
            return true;
        }

        static /* synthetic */ Activity access$200(ApplicationAdapter r0) {
            return r0.activity;
        }

        public ApplicationAdapter(Activity r1, PackageManager r2, DevicePolicyManager r3, ServiceListing r4, Function1<OSectionSupportiveText, Unit> r5) {
            super(r5);
            this.mBackend = new NotificationBackend();
            this.managedProfileId = -10000;
            this.allowedList = new ArrayList();
            this.notAllowedList = new ArrayList();
            this.TYPE_ALLOW_HEADER = -1;
            this.TYPE_ALLOW_CONTENT = 0;
            this.TYPE_NOT_ALLOW_HEADER = 1;
            this.TYPE_NOT_ALLOW_CONTENT = 2;
            this.activity = r1;
            this.mPkgMan = r2;
            this.mDpm = r3;
            this.mServiceListing = r4;
        }

        public void setManagedProfileId(int r1) {
            this.managedProfileId = r1;
        }

        public void setData(List<ServiceInfo> r1, List<ServiceInfo> r2) {
            this.allowedList = r1;
            this.notAllowedList = r2;
            notifyDataSetChanged();
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup r2, int r3) {
            if (r3 == this.TYPE_ALLOW_HEADER) goto L10;
            if (r3 == this.TYPE_NOT_ALLOW_HEADER) goto L10;
            return new SpecialAccessGeneralViewHolder(SpecialAccessGeneralViewHolder.newPressableView(r2));
        L10:
            return new SpecialAccessHeaderViewHolder(SpecialAccessHeaderViewHolder.newView(r2));
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getContentItemViewType(int r3) {
            int r0 = this.allowedList.size();
            if (r3 == 0) goto L5;
            if (r3 <= 0) goto L12;
            if (r3 >= (r0 + 1)) goto L12;
            return this.TYPE_ALLOW_CONTENT;
        L12:
            if (r3 != (r0 + 1)) goto L16;
            return this.TYPE_NOT_ALLOW_HEADER;
        L16:
            return this.TYPE_NOT_ALLOW_CONTENT;
        L5:
            return this.TYPE_ALLOW_HEADER;
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public void onBindContentViewHolder(RecyclerView.ViewHolder r7, int r8) {
            int r0 = getContentItemViewType(r8);
            int r1 = this.TYPE_ALLOW_HEADER;
            boolean r2 = true;
            if (r0 != r1) goto L5;
        L23:
            SpecialAccessHeaderViewHolder r9 = (SpecialAccessHeaderViewHolder) r7;
            if (r0 != r1) goto L26;
            boolean r10 = true;
        L27:
            r9.setFirstHeader(r10);
            Activity r3 = this.activity;
            if (r10 == false) goto L30;
            int r4 = R.string.notification_listener_allowed;
        L31:
            String r5 = r3.getString(r4);
            r9.setTitle(r5, r5);
            if (r10 == false) goto L34;
            List<ServiceInfo> r6 = this.allowedList;
        L35:
            int r11 = r6.size();
            View r12 = r9.itemView;
            if (r11 <= 0) goto L38;
            int r13 = 0;
        L39:
            r12.setVisibility(r13);
            if (r11 > 0) goto L43;
            r2 = false;
        L43:
            r9.setHeaderVisible(r2);
            return;
        L38:
            r13 = 8;
            goto L39
        L34:
            r6 = this.notAllowedList;
            goto L35
        L30:
            r4 = R.string.notification_listener_not_allowed;
            goto L31
        L26:
            r10 = false;
            goto L27
        L5:
            if (r0 == this.TYPE_NOT_ALLOW_HEADER) goto L23;
            SpecialAccessGeneralViewHolder r14 = (SpecialAccessGeneralViewHolder) r7;
            if (r0 != this.TYPE_ALLOW_CONTENT) goto L10;
            int r15 = r8 - 1;
            final ServiceInfo r16 = this.allowedList.get(r15);
            r14.initCardItemInAdapter(this.allowedList.size(), r15);
        L11:
            r14.showTailIcon();
            final ComponentName r17 = new ComponentName(r16.packageName, r16.name);
            CharSequence r18 = this.mPkgMan.getApplicationInfoAsUser(r16.packageName, 0, UserHandle.myUserId()).loadLabel(this.mPkgMan);     // Catch: PackageManager.NameNotFoundException -> L14
        L16:
            String r19 = NotificationBackend.getDeviceList(ICompanionDeviceManager.Stub.asInterface(ServiceManager.getService("companiondevice")), Utils.getLocalBtManager(this.activity), r16.packageName, UserHandle.myUserId()).toString();
            if (this.managedProfileId != (-10000)) goto L19;
        L21:
            r14.setIcon(r16.applicationInfo.loadIcon(this.mPkgMan));
            r14.setIcon(ObricIconUtils.getDrawable(r16.packageName, r16.applicationInfo.uid));
            r14.setTitle(r18, r18);
            r14.setSummary(r19);
            r14.setOnClickListener(new AnonymousClass1(this, r17, r16));
            return;
        L19:
            if (this.mDpm.isNotificationListenerServicePermitted(r16.packageName, this.managedProfileId) == true) goto L21;
            r19 = this.mDpm.getResources().getString("Settings.WORK_PROFILE_NOTIFICATION_LISTENER_BLOCKED", new NotificationAccessSettingsActivity$ApplicationAdapter$$ExternalSyntheticLambda1(this));
        L14:
            e = move-exception;
            OLog.e(NotificationAccessSettingsActivity.access$100(), "can't find package name", e);
            r18 = null;
            goto L16
        L10:
            int r20 = r8 - 2;
            r16 = this.notAllowedList.get(r20 - this.allowedList.size());
            r14.initCardItemInAdapter(this.notAllowedList.size(), r20 - this.allowedList.size());
            goto L11
        }

        /* JADX INFO: renamed from: lambda$onBindContentViewHolder$0$com-android-settings-specialaccess-notificationaccess-NotificationAccessSettingsActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ String m616x556cc02d() {
            return this.activity.getString(R.string.work_profile_notification_access_blocked_summary);
        }

        @Override // com.android.settings.specialaccess.HeaderBaseAdapter
        public int getItemContentCount() {
            if (this.allowedList.isEmpty() == false) goto L9;
            if (this.notAllowedList.isEmpty() == false) goto L9;
            return 0;
        L9:
            return (this.allowedList.size() + 2) + this.notAllowedList.size();
        }

        public CompoundButton.OnCheckedChangeListener getSwitchOnCheckedListener(final ComponentName r2) {
            if (r2 != null) goto L6;
            return null;
        L6:
            return new NotificationAccessSettingsActivity$ApplicationAdapter$$ExternalSyntheticLambda0(this, r2);
        }

        /* JADX INFO: renamed from: lambda$getSwitchOnCheckedListener$1$com-android-settings-specialaccess-notificationaccess-NotificationAccessSettingsActivity$ApplicationAdapter, reason: not valid java name */
        /* synthetic */ void m615x2c1858ec(ComponentName r1, CompoundButton r2, boolean r3) {
            setEnabled(r1, r3);
        }

        private final boolean checkSwitch(ComponentName r1) {
            return isServiceEnabled(r1);
        }

        protected boolean isServiceEnabled(ComponentName r1) {
            return this.mServiceListing.isEnabled(r1);
        }

        protected boolean setEnabled(ComponentName r2, boolean r3) {
            if (r3 == true) goto L7;
            this.mServiceListing.setEnabled(r2, false);
            return true;
        L7:
            if (this.mServiceListing.isEnabled(r2) == false) goto L9;
            return true;
        L9:
            this.mServiceListing.setEnabled(r2, true);
            return true;
        }
    }

    public static /* synthetic */ void $r8$lambda$WzUizPFuIu3i0uiEPt0eWc49sJo(NotificationAccessSettingsActivity r0, List r1) {
        r0.updateList(r1);
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getEmptyRes() {
        return R.string.manage_notification_access_summary_zero;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getPackageIdx(String r1) {
        return -1;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getSubtitleResId() {
        return R.string.manage_notification_access_summary;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity
    protected int getTitleRes() {
        return R.string.manage_notification_access_title;
    }

    @Override // com.android.settings.specialaccess.SpecialAccessBaseActivity, com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public NotificationAccessSettingsActivity() {
        this.mBackend = new NotificationBackend();
    }

    static /* synthetic */ void access$000(NotificationAccessSettingsActivity r0, OSectionSupportiveText r1) {
        r0.initDescText(r1);
    }

    static /* synthetic */ String access$100() {
        return TAG;
    }

    static {
        CONFIG = new ManagedServiceActivity.Config.Builder().setTag("NotificationAccessSettingsActivity").setSetting("enabled_notification_listeners").setIntentAction("android.service.notification.NotificationListenerService").setPermission("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE").setNoun("notification listener").setWarningDialogTitle(R.string.notification_listener_security_warning_title).setWarningDialogSummary(R.string.notification_listener_security_warning_summary).setEmptyText(R.string.no_notification_listeners).build();
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onCreate$___twin___(Bundle r8) {
        super.onCreate(r8);
        this.mContext = this;
        this.mNm = (NotificationManager) getSystemService(NotificationManager.class);
        this.mPm = this.mContext.getPackageManager();
        this.mDpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");
        this.mIconDrawableFactory = IconDrawableFactory.newInstance(this.mContext);
        ServiceListing.Builder r9 = new ServiceListing.Builder(this.mContext);
        ManagedServiceActivity.Config r0 = CONFIG;
        ServiceListing r10 = r9.setPermission(r0.permission).setIntentAction(r0.intentAction).setNoun(r0.noun).setSetting(r0.setting).setTag(r0.tag).build();
        this.mServiceListing = r10;
        r10.addCallback(new NotificationAccessSettingsActivity$$ExternalSyntheticLambda0(this));
        this.mApplicationAdapter = new ApplicationAdapter(this, this.mPm, this.mDpm, this.mServiceListing, new AnonymousClass1(this));
        this.mRecyclerView.setAdapter(this.mApplicationAdapter);
        if (UserManager.get(this.mContext).isManagedProfile() == false) goto L6;
        ToastUtils.show(this.mContext, this.mDpm.getResources().getString("Settings.WORK_APPS_CANNOT_ACCESS_NOTIFICATION_SETTINGS", new NotificationAccessSettingsActivity$$ExternalSyntheticLambda1(this)));
        finish();
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-specialaccess-notificationaccess-NotificationAccessSettingsActivity, reason: not valid java name */
    /* synthetic */ String m614x888c7faf() {
        return this.mContext.getString(R.string.notification_settings_work_profile);
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onResume$___twin___() {
        super.onResume();
        this.mServiceListing.reload();
        this.mServiceListing.setListening(true);
    }

    public void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onPause$___twin___() {
        super.onPause();
        this.mServiceListing.setListening(false);
    }

    private void updateList(List<ServiceInfo> r7) {
        int r0 = com.android.settings.Utils.getManagedProfileId((UserManager) this.mContext.getSystemService(PickApplicationActivity.EXTRA_USER), UserHandle.myUserId());
        r7.sort(new PackageItemInfo.DisplayNameComparator(this.mPm));
        if (r7.isEmpty() == false) goto L5;
        showEmptyView();
    L6:
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        this.mApplicationAdapter.setManagedProfileId(r0);
        Iterator<ServiceInfo> r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L17;
        ServiceInfo r3 = r8.next();
        ComponentName r4 = new ComponentName(r3.packageName, r3.name);
        boolean r5 = this.mNm.isNotificationListenerAccessGranted(r4);
        if (r5 == true) goto L14;
        if (r4.flattenToString().length() > NotificationManager.MAX_SERVICE_COMPONENT_NAME_LENGTH) goto L8;
    L14:
        if (r5 == true) goto L15;
        r2.add(r3);
        goto L8
    L15:
        r1.add(r3);
        goto L8
    L17:
        this.mApplicationAdapter.setData(r1, r2);
        updatePositionAfterNotify();
        return;
    L5:
        showContent();
        goto L6
    }

    private int getCurrentUser(int r1) {
        if (r1 == (-10000)) goto L6;
        return r1;
    L6:
        return UserHandle.myUserId();
    }

    protected boolean isServiceEnabled(ComponentName r1) {
        return this.mServiceListing.isEnabled(r1);
    }

    protected boolean setEnabled(ComponentName r1, String r2, boolean r3) {
        if (r3 == true) goto L7;
        this.mServiceListing.setEnabled(r1, false);
        return true;
    L7:
        if (this.mServiceListing.isEnabled(r1) == false) goto L9;
        return true;
    L9:
        enable(r1);
        return true;
    }

    protected void enable(ComponentName r2) {
        this.mServiceListing.setEnabled(r2, true);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(NotificationAccessSettingsActivity r1) {
        r1.com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onStop$___twin___();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(NotificationAccessSettingsActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(NotificationAccessSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessSettingsActivity r5 = r4;
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
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(NotificationAccessSettingsActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(NotificationAccessSettingsActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(NotificationAccessSettingsActivity r4) {
        String r0 = r4.getClass().getName();
        r4.com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onPause$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(NotificationAccessSettingsActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        r3.com_android_settings_specialaccess_notificationaccess_NotificationAccessSettingsActivity__onCreate$___twin___(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        NotificationAccessSettingsActivity r5 = r3;
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
