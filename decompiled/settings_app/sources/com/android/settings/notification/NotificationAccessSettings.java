package com.android.settings.notification;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.MultiSDKAdapter;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ManagedServiceSettings;
import com.android.settings.utils.ServiceListing;
import com.android.settings.widget.NotificationAccessPreference;
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
public class NotificationAccessSettings extends ManagedServiceSettings {
    private static final ManagedServiceSettings.Config CONFIG = null;
    private static final String TAG = "NotificationAccessSettings";
    private View mEmptyView;
    private NotificationManager mNm;

    public void com_android_settings_notification_NotificationAccessSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.utils.ManagedServiceSettings, com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.utils.ManagedServiceSettings, com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationAccessSettings() {
    }

    static /* synthetic */ NotificationManager access$000(NotificationAccessSettings r0) {
        return r0.mNm;
    }

    static /* synthetic */ boolean access$100(NotificationAccessSettings r0, CompoundButton r1, ComponentName r2, String r3, boolean r4) {
        return r0.setEnabled(r1, r2, r3, r4);
    }

    static {
        CONFIG = getNotificationListenerConfig();
    }

    public void com_android_settings_notification_NotificationAccessSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setBytedanceStyle(true);
        this.mNm = (NotificationManager) getSystemService("notification");
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r5) {
        super.onActivityCreated(r5);
        RecyclerView r6 = getListView();
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L6;
        View r1 = LayoutInflater.from(r0).inflate(R.layout.notification_access_empty_layout, null, false);
        r1.setVisibility(8);
        ((ViewGroup) r6.getParent()).addView(r1);
        this.mEmptyView = r1;
        return;
    }

    private static ManagedServiceSettings.Config getNotificationListenerConfig() {
        ManagedServiceSettings.Config r0 = new ManagedServiceSettings.Config();
        r0.tag = TAG;
        r0.setting = "enabled_notification_listeners";
        r0.intentAction = "android.service.notification.NotificationListenerService";
        r0.permission = "android.permission.BIND_NOTIFICATION_LISTENER_SERVICE";
        r0.noun = "notification listener";
        r0.warningDialogTitle = R.string.notification_listener_security_warning_title;
        r0.warningDialogSummary = R.string.notification_listener_security_warning_summary;
        r0.emptyText = R.string.no_notification_listeners;
        return r0;
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected ManagedServiceSettings.Config getConfig() {
        return CONFIG;
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected boolean isServiceEnabled(ComponentName r1) {
        return MultiSDKAdapter.isNotificationListenerAccessGranted(this.mNm, r1);
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected void enable(ComponentName r2) {
        MultiSDKAdapter.setNotificationListenerAccessGranted(this.mNm, r2, true);
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected void disable(final ComponentName r3) {
        MultiSDKAdapter.setNotificationListenerAccessGranted(this.mNm, r3, false);
        AsyncTask.execute(new AnonymousClass1(this, r3));
    }

    public static int getListenersCount(PackageManager r1) {
        return ServiceListing.getServicesCount(CONFIG, r1);
    }

    public static int getEnabledListenersCount(Context r1) {
        return ServiceListing.getEnabledServicesCount(CONFIG, r1);
    }

    private static void deleteRules(final Context r1, final String r2) {
        AsyncTask.execute(new AnonymousClass2(r1, r2));
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected void onServiceEnabled(Context r1, String r2) {
        deleteRules(r1, r2);
    }

    @Override // com.android.settings.utils.ManagedServiceSettings
    protected void updateList(List<ServiceInfo> r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        PreferenceScreen r0 = getPreferenceScreen();
        r0.removeAll();
        Collections.sort(r11, new PackageItemInfo.DisplayNameComparator(this.mPM));
        int r1 = r11.size();
        Iterator<ServiceInfo> r2 = r11.iterator();
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L17;
        ServiceInfo r5 = r2.next();
        final ComponentName r6 = new ComponentName(r5.packageName, r5.name);
        final String r7 = r5.loadLabel(this.mPM).toString();
        NotificationAccessPreference r8 = new NotificationAccessPreference(this.mContext);
        int r9 = 1;
        if (r1 == 1) goto L16;
        if (r4 != 0) goto L13;
        r9 = 2;
        goto L16
    L13:
        if (r4 != (r1 - 1)) goto L15;
        r9 = 4;
        goto L16
    L15:
        r9 = 3;
    L16:
        r8.setBackgroundStyle(r9);
        r8.setPersistent(false);
        r8.setIcon(r5.loadIcon(this.mPM));
        r8.setTitle(r7);
        r8.setChecked(isServiceEnabled(r6));
        r8.setOnCheckedChangeListener(new AnonymousClass3(this, r6, r7));
        r0.addPreference(r8);
        r4 = r4 + 1;
        goto L6
    L17:
        View r10 = this.mEmptyView;
        if (r10 != null) goto L20;
        return;
    L20:
        if (r11.isEmpty() == true) goto L23;
        r3 = 8;
    L23:
        r10.setVisibility(r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationAccessSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_NotificationAccessSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationAccessSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_NotificationAccessSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationAccessSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_NotificationAccessSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
