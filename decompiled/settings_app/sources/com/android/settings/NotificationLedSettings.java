package com.android.settings;

import android.app.AlertDialog;
import android.app.INotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.os.ServiceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationLedSettings extends BaseFragment {
    public static final String TELECOM_PACKAGE_NAME = "com.android.server.telecom";
    private final Comparator<NotificationEntry> mAlphaComparator;
    private AlertDialog mDialog;
    private ArrayList<NotificationEntry> mEntries;
    private SettingItemSwitch mLedMms;
    private SettingItemSwitch mLedPhone;
    private ListView mListView;
    private NotificationAppsAdapter mNotificationAppsAdapter;
    private INotificationManager mNotificationManager;
    private String[] mSocialAppList;

    private class NotificationAppsAdapter extends SettingsAdapter implements ApplicationsState.Callbacks, CompoundButton.OnCheckedChangeListener {
        private int mIconSize;
        private LayoutInflater mLayoutInflater;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ NotificationLedSettings this$0;

        private class ViewHolder {
            SettingItemSwitch itemSwitch;
            final /* synthetic */ NotificationAppsAdapter this$1;

            private ViewHolder(NotificationAppsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(NotificationAppsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ApplicationsState.Session access$500(NotificationAppsAdapter r0) {
            return r0.mSession;
        }

        static /* synthetic */ ArrayList access$600(NotificationAppsAdapter r0, ArrayList r1) {
            return r0.filter(r1);
        }

        public NotificationAppsAdapter(NotificationLedSettings r1, Context r2, ApplicationsState r3) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
            this.mSession = r3.newSession(this);
            this.mIconSize = r2.getResources().getDimensionPixelSize(R.dimen.settings_list_item_icon_size);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(true);
            rebuild();
            return;
        L5:
            rebuild();
        }

        public void pause() {
            if (this.mResumed == false) goto L6;
            this.mResumed = false;
            this.mSession.pause();
            return;
        }

        public void destroy() {
            this.mSession.release();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public int getCount() {
            if (NotificationLedSettings.access$300(this.this$0) != null) goto L7;
            return 0;
        L7:
            return NotificationLedSettings.access$300(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return NotificationLedSettings.access$300(this.this$0).get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return ((NotificationEntry) NotificationLedSettings.access$300(this.this$0).get(r1)).appEntry.id;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
        L7:
            ViewHolder r8 = new ViewHolder(this, null);
            View r9 = this.mLayoutInflater.inflate(R.layout.list_content_item_switch, r7, false);
            r8.itemSwitch = (SettingItemSwitch) r9.findViewById(R.id.item_switch);
            r8.itemSwitch.setOnCheckedChangeListener(this);
            SettingItemSwitch r0 = r8.itemSwitch;
            int r1 = this.mIconSize;
            Utils.setItemIconSize(r0, r1, r1);
            r9.setTag(r8);
            ViewHolder r10 = r8;
            r6 = r9;
        L8:
            NotificationEntry r2 = (NotificationEntry) NotificationLedSettings.access$300(this.this$0).get(r5);
            r10.itemSwitch.setTitle(r2.appEntry.label);
            r10.itemSwitch.setIcon(r2.appEntry.icon);
            r10.itemSwitch.setChecked(r2.ledEnabled);
            r10.itemSwitch.getSwitch().setTag(r2);
            Utils.setItemBgStyle(r10.itemSwitch, getCount(), r5);
            return r6;
        L4:
            if (r6.getTag() == null) goto L7;
            r10 = (ViewHolder) r6.getTag();
            goto L8
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r2, boolean r3) {
            if (r2.isShown() == true) goto L5;
            return;
        L5:
            NotificationEntry r4 = (NotificationEntry) r2.getTag();
            r4.ledEnabled = r3;
            NotificationLedSettings.access$200(this.this$0, r4.appEntry.info.packageName, r4.appEntry.info.uid, r3);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r2) {
            NotificationLedSettings.access$302(this.this$0, filter(r2));
            notifyDataSetChanged();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
            rebuild();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.NotificationLedSettings$NotificationAppsAdapter$1] */
        public void rebuild() {
            new AnonymousClass1(this).execute(new Void[0]);
        }

        private ArrayList<NotificationEntry> filter(ArrayList<ApplicationsState.AppEntry> r9) {
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            ArrayList<NotificationEntry> r2 = new ArrayList();
            Iterator<ApplicationsState.AppEntry> r10 = r9.iterator();
        L4:
            if (r10.hasNext() == false) goto L12;
            ApplicationsState.AppEntry r3 = r10.next();
            if (this.this$0.isSocialPackage(r3.info.packageName) == false) goto L4;
            boolean r4 = NotificationLedSettings.access$700(this.this$0, r3.info.packageName, r3.info.uid);
            NotificationEntry r5 = new NotificationEntry(this.this$0, null);
            r5.appEntry = r3;
            r5.ledEnabled = r4;
            if (r4 == true) goto L10;
            r1.add(r5);
            goto L4
        L10:
            r0.add(r5);
            goto L4
        L12:
            Collections.sort(r0, NotificationLedSettings.access$900(this.this$0));
            Collections.sort(r1, NotificationLedSettings.access$900(this.this$0));
            r2.addAll(r0);
            r2.addAll(r1);
            r0.clear();
            r1.clear();
            return r2;
        }
    }

    private class NotificationEntry {
        ApplicationsState.AppEntry appEntry;
        boolean ledEnabled;
        final /* synthetic */ NotificationLedSettings this$0;

        private NotificationEntry(NotificationLedSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ NotificationEntry(NotificationLedSettings r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public void com_android_settings_NotificationLedSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment
    public int getTitleResId() {
        return R.string.notification_led_settings;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationLedSettings() {
        this.mAlphaComparator = new AnonymousClass4(this);
    }

    static /* synthetic */ Integer access$000(NotificationLedSettings r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ Integer access$100(NotificationLedSettings r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ void access$200(NotificationLedSettings r0, String r1, int r2, boolean r3) {
        r0.setNotificationLedEnabled(r1, r2, r3);
    }

    static /* synthetic */ ArrayList access$300(NotificationLedSettings r0) {
        return r0.mEntries;
    }

    static /* synthetic */ ArrayList access$302(NotificationLedSettings r0, ArrayList r1) {
        r0.mEntries = r1;
        return r1;
    }

    static /* synthetic */ boolean access$700(NotificationLedSettings r0, String r1, int r2) {
        return r0.isNotificationLedEnabled(r1, r2);
    }

    static /* synthetic */ Comparator access$900(NotificationLedSettings r0) {
        return r0.mAlphaComparator;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mNotificationManager = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        int r0 = 0;
        this.mRootView = r2.inflate(R.layout.manage_applications_layout, r3, false);
        ListView r5 = (ListView) findViewByIdNullable(R.id.listView);
        this.mListView = r5;
        r5.setEmptyView(findViewByIdNullable(R.id.view_empty));
        View r6 = r2.inflate(R.layout.notification_led_settings_header_view, null);
        this.mLedPhone = (SettingItemSwitch) NullSafe.nonNull(r6.findViewById(R.id.led_phone));
        this.mLedMms = (SettingItemSwitch) NullSafe.nonNull(r6.findViewById(R.id.led_mms));
        View r7 = NullSafe.nonNull(r6.findViewById(R.id.led_brightness_settings));
        if (SettingsFeature.isLEDBrightnessSettingsEnabled() == true) goto L6;
        r0 = 8;
    L6:
        r7.setVisibility(r0);
        r7.setOnClickListener(new AnonymousClass1(this));
        this.mListView.addHeaderView(r6);
        View r8 = Utils.inflateListTransparentHeader(this.mContext);
        this.mListView.addFooterView(r8);
        NotificationAppsAdapter r9 = new NotificationAppsAdapter(this, this.mContext, ApplicationsState.getInstance(requireActivity().getApplication(), true));
        this.mNotificationAppsAdapter = r9;
        this.mListView.setAdapter(r9);
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r3) {
        super.onViewStateRestored(r3);
        this.mLedPhone.setChecked(isNotificationLedEnabled("com.android.server.telecom", -1));
        this.mLedMms.setChecked(isNotificationLedEnabled(Constants.PKG_MMS, -1));
        this.mLedPhone.setOnCheckedChangeListener(new AnonymousClass2(this));
        this.mLedMms.setOnCheckedChangeListener(new AnonymousClass3(this));
    }

    public void com_android_settings_NotificationLedSettings__onResume$___twin___() {
        super.onResume();
        this.mNotificationAppsAdapter.resume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mNotificationAppsAdapter.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mNotificationAppsAdapter.destroy();
        this.mNotificationAppsAdapter = null;
    }

    protected boolean isSocialPackage(String r5) {
        if (r5 == null) goto L13;
        String[] r4 = this.mSocialAppList;
        if (r4 == null) goto L13;
        int r1 = r4.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r5.equals(r4[r2]) == true) goto L10;
        r2 = r2 + 1;
        goto L7
    L10:
        return true;
    L13:
        return false;
    }

    private boolean isNotificationLedEnabled(String r3, int r4) {
        if (r4 < 0) goto L10;
    L5:
        return this.mNotificationManager.getISmtEx().isNotiicationLedEnabledForPackage(r3, r4);
    L7:
        e = move-exception;
        OLog.e(this.TAG, "isNotificationLedEnabled error:" + e);
        return false;
    L10:
        r4 = getPackageManager().getApplicationInfo(r3, 0).uid;     // Catch: Exception -> L7
        goto L5
    }

    private void setNotificationLedEnabled(String r3, int r4, boolean r5) {
        if (r4 < 0) goto L11;
    L6:
        this.mNotificationManager.getISmtEx().setNotificationLightEnableForPackage(r3, r4, r5);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
        return;
    L11:
        ApplicationInfo r0 = getPackageManager().getApplicationInfo(r3, 0);     // Catch: Exception -> L8
        if (r0 == null) goto L6;
        r4 = r0.uid;     // Catch: Exception -> L8
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationLedSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationLedSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationLedSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationLedSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationLedSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationLedSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
