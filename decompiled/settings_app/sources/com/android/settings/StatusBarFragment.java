package com.android.settings;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageManager;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bytedanceos.api.PackageManagerSmt;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class StatusBarFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String THIRD_APP_STATUS_BAR_MODE = "3rd_app_status_bar_mode";
    private final String SYSTEM_APP_STATUSBAR_MODE_PREFS;
    private ApplicationsState mApplicationState;
    private ArrayList<String> mBlackListApp;
    private CloudFeedBackReceiver mCloudFeedBackReceiver;
    private ArrayList<ApplicationsState.AppEntry> mEntries;
    private int mIconSize;
    private ImmersiveAppsAdapter mImmersiveAppsAdapter;
    private LayoutInflater mInflater;
    private boolean mIsChanged;
    private boolean mIsClassicStatusBar;
    private ListView mListView;
    private TextView mLoadingTipsTv;
    private PackageManager mPackageManager;
    private IPackageManager mPm;
    private SettingItemCheck mStatusBarAdaptiveCheck;
    private SettingItemCheck mStatusBarClassicCheck;
    private LinearLayout mStatusBarModeSystemAppsContainer;
    private boolean mStatusBarNotch;
    private SharedPreferences mSystemAppModePrefs;
    private String[] mSystemImmersiveApp;

    /* JADX INFO: renamed from: com.android.settings.StatusBarFragment$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    class CloudFeedBackReceiver extends BroadcastReceiver {
        final /* synthetic */ StatusBarFragment this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_StatusBarFragment$CloudFeedBackReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        CloudFeedBackReceiver(StatusBarFragment r1) {
            this.this$0 = r1;
        }

        public void com_android_settings_StatusBarFragment$CloudFeedBackReceiver__onReceive$___twin___(Context r1, Intent r2) {
            if (Constants.DOWNLOADS_FROM_CLOUD_IMMERSIVE_BLACK_LIST.equals(r2.getStringExtra("name")) == false) goto L6;
            this.this$0.updateBlackList();
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_StatusBarFragment$CloudFeedBackReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(CloudFeedBackReceiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            CloudFeedBackReceiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_StatusBarFragment$CloudFeedBackReceiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_StatusBarFragment$CloudFeedBackReceiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_StatusBarFragment$CloudFeedBackReceiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_StatusBarFragment$CloudFeedBackReceiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    private class ImmersiveAppsAdapter extends SettingsAdapter implements ApplicationsState.Callbacks, CompoundButton.OnCheckedChangeListener {
        private LayoutInflater mLayoutInflater;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ StatusBarFragment this$0;

        private class ViewHolder {
            SettingItemSwitch mItemSwitch;
            final /* synthetic */ ImmersiveAppsAdapter this$1;

            private ViewHolder(ImmersiveAppsAdapter r1) {
                this.this$1 = r1;
            }

            /* synthetic */ ViewHolder(ImmersiveAppsAdapter r1, AnonymousClass1 r2) {
                this(r1);
            }
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ApplicationsState.Session access$1000(ImmersiveAppsAdapter r0) {
            return r0.mSession;
        }

        public ImmersiveAppsAdapter(StatusBarFragment r1, Context r2, ApplicationsState r3) {
            this.this$0 = r1;
            this.mLayoutInflater = LayoutInflater.from(r2);
            this.mSession = r3.newSession(this);
        }

        public void resume() {
            if (this.mResumed == true) goto L5;
            this.mResumed = true;
            this.mSession.resume(false);
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
            if (StatusBarFragment.access$000(this.this$0).isChecked() == false) goto L6;
            return 0;
        L6:
            if (StatusBarFragment.access$100(this.this$0) == null) goto L8;
            int r0 = StatusBarFragment.access$100(this.this$0).size();
        L10:
            if (Utils.isCameraInScreen() == true) goto L12;
            return r0;
        L12:
            if (StatusBarFragment.access$200(this.this$0) == true) goto L14;
            return 0;
        L14:
            return r0;
        L8:
            r0 = 0;
            goto L10
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public Object getItem(int r1) {
            return StatusBarFragment.access$100(this.this$0).get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return ((ApplicationsState.AppEntry) StatusBarFragment.access$100(this.this$0).get(r1)).id;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r7, View r8, ViewGroup r9) {
            AnonymousClass1 r1 = null;
            if (r8 != null) goto L5;
            r8 = LayoutInflater.from(this.this$0.mContext).inflate(R.layout.list_content_item_switch, r9, false);
            ViewHolder r10 = new ViewHolder(this, r1);
            r10.mItemSwitch = (SettingItemSwitch) r8.findViewById(R.id.item_switch);
            Utils.setItemIconSize(r10.mItemSwitch, StatusBarFragment.access$400(this.this$0), StatusBarFragment.access$400(this.this$0));
            r8.setTag(r10);
        L6:
            r10.mItemSwitch.setOnCheckedChangeListener(null);
            ApplicationsState.AppEntry r2 = (ApplicationsState.AppEntry) StatusBarFragment.access$100(this.this$0).get(r7);
            r10.mItemSwitch.setTitle(r2.label);
            r10.mItemSwitch.setIcon(r2.icon);
            r10.mItemSwitch.getSwitch().setTag(R.id.item_switch, r2);
            if (StatusBarFragment.access$500(this.this$0).contains(r2.info.packageName) == false) goto L9;
            r10.mItemSwitch.setEnabled(false);
            r10.mItemSwitch.setSwitchDisabledTips(R.string.immersive_black_list_app_message);
        L10:
            r10.mItemSwitch.setChecked(StatusBarFragment.access$600(this.this$0, r2.info.packageName));
            r10.mItemSwitch.setOnCheckedChangeListener(this);
            if (r7 == 0) goto L13;
            Utils.setItemBgStyle(r10.mItemSwitch, getCount(), r7);
        L17:
            return r8;
        L13:
            if (getCount() != 1) goto L15;
            r10.mItemSwitch.setBackgroundStyle(4);
            goto L17
        L15:
            r10.mItemSwitch.setBackgroundStyle(3);
            goto L17
        L9:
            r10.mItemSwitch.setEnabled(true);
            r10.mItemSwitch.setSwitchDisabledTips(0);
            goto L10
        L5:
            r10 = (ViewHolder) r8.getTag();
            goto L6
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r2, boolean r3) {
            ApplicationsState.AppEntry r4 = (ApplicationsState.AppEntry) r2.getTag(R.id.item_switch);
            StatusBarFragment.access$700(this.this$0, r4.info.packageName, r3);
            StatusBarFragment.access$802(this.this$0, true);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(ArrayList<ApplicationsState.AppEntry> r2) {
            StatusBarFragment.access$102(this.this$0, r2);
            notifyDataSetChanged();
            StatusBarFragment.access$900(this.this$0);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.StatusBarFragment$ImmersiveAppsAdapter$1] */
        public void rebuild() {
            new AnonymousClass1(this).execute(new Void[0]);
        }
    }

    private void setCustomizedStatusBarEnable(String r1, boolean r2) {
    }

    public void com_android_settings_StatusBarFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public void updateBlackList() {
    }

    public StatusBarFragment() {
        this.SYSTEM_APP_STATUSBAR_MODE_PREFS = "system_app_statusbar_mode_prefs";
        this.mBlackListApp = new ArrayList();
    }

    static /* synthetic */ SettingItemCheck access$000(StatusBarFragment r0) {
        return r0.mStatusBarClassicCheck;
    }

    static /* synthetic */ ArrayList access$100(StatusBarFragment r0) {
        return r0.mEntries;
    }

    static /* synthetic */ ArrayList access$102(StatusBarFragment r0, ArrayList r1) {
        r0.mEntries = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(StatusBarFragment r0) {
        return r0.mIsClassicStatusBar;
    }

    static /* synthetic */ TextView access$1200(StatusBarFragment r0) {
        return r0.mLoadingTipsTv;
    }

    static /* synthetic */ void access$1300(StatusBarFragment r0) {
        r0.updateSystemAppHeaderView();
    }

    static /* synthetic */ boolean access$200(StatusBarFragment r0) {
        return r0.mStatusBarNotch;
    }

    static /* synthetic */ int access$400(StatusBarFragment r0) {
        return r0.mIconSize;
    }

    static /* synthetic */ ArrayList access$500(StatusBarFragment r0) {
        return r0.mBlackListApp;
    }

    static /* synthetic */ boolean access$600(StatusBarFragment r0, String r1) {
        return r0.isCustomizedStatusBarEnable(r1);
    }

    static /* synthetic */ void access$700(StatusBarFragment r0, String r1, boolean r2) {
        r0.setCustomizedStatusBarEnable(r1, r2);
    }

    static /* synthetic */ boolean access$802(StatusBarFragment r0, boolean r1) {
        r0.mIsChanged = r1;
        return r1;
    }

    static /* synthetic */ void access$900(StatusBarFragment r0) {
        r0.updateLastHeaderItemBackground();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        this.mRootView = r4.inflate(R.layout.status_bar_mode_layout, r5, false);
        this.mPackageManager = getPackageManager();
        this.mPm = IPackageManager.Stub.asInterface(ServiceManager.getService("package"));
        this.mSystemImmersiveApp = getResources().getStringArray(R.array.system_immersive_app);
        this.mSystemAppModePrefs = this.mContext.getSharedPreferences("system_app_statusbar_mode_prefs", 0);
        this.mIconSize = getResources().getDimensionPixelSize(R.dimen.settings_list_item_icon_size);
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        this.mInflater = r4;
        View r7 = r4.inflate(R.layout.status_bar_mode_settings_header_view, null);
        this.mStatusBarClassicCheck = (SettingItemCheck) r7.findViewById(R.id.status_bar_style_classic);
        this.mStatusBarAdaptiveCheck = (SettingItemCheck) r7.findViewById(R.id.status_bar_style_adaptive);
        this.mStatusBarClassicCheck.setOnClickListener(this);
        this.mStatusBarAdaptiveCheck.setOnClickListener(this);
        this.mStatusBarModeSystemAppsContainer = (LinearLayout) r7.findViewById(R.id.switch_statusbar_mode_system_apps_container);
        this.mLoadingTipsTv = (TextView) findViewByIdNullable(R.id.view_empty);
        boolean r2 = true;
        if (android.provider.Settings.System.getInt(getContentResolver(), "3rd_app_status_bar_mode", 1) == 0) goto L6;
        r2 = false;
    L6:
        this.mIsClassicStatusBar = r2;
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) this.mLoadingTipsTv.getLayoutParams();
        this.mStatusBarNotch = Utils.isNotchStatusBar(this.mContext);
        r8.addRule(12);
        r8.bottomMargin = getResources().getDimensionPixelSize(R.dimen.settings_status_bar_tips_bottom_margin);
        if (this.mStatusBarNotch == true) goto L9;
    L11:
        this.mLoadingTipsTv.setLayoutParams(r8);
        this.mListView.addHeaderView(r7);
        this.mListView.addFooterView(Utils.inflateListTransparentFooter(this.mContext, null, false));
        this.mApplicationState = ApplicationsState.getInstance(requireActivity().getApplication(), false);
        ImmersiveAppsAdapter r9 = new ImmersiveAppsAdapter(this, this.mContext, this.mApplicationState);
        this.mImmersiveAppsAdapter = r9;
        this.mListView.setAdapter(r9);
        this.mListView.setOnItemClickListener(null);
        initReceiver();
        updateBlackList();
        return this.mRootView;
    L9:
        if (this.mIsClassicStatusBar == true) goto L11;
        this.mLoadingTipsTv.setVisibility(0);
        goto L11
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        updateUI(this.mIsClassicStatusBar);
        if (Utils.isNotchStatusBar(this.mContext) == false) goto L6;
        updateSystemAppHeaderView();
        return;
    }

    private void initReceiver() {
        this.mCloudFeedBackReceiver = new CloudFeedBackReceiver(this);
        IntentFilter r0 = new IntentFilter();
        r0.addAction(Constants.DOWNLOADS_FROM_CLOUD_FEED_BACK);
        registerReceiver(this.mCloudFeedBackReceiver, r0);
    }

    private void updateSystemAppHeaderView() {
        this.mStatusBarModeSystemAppsContainer.removeAllViews();
        int r1 = 0;
    L3:
        String[] r2 = this.mSystemImmersiveApp;
        if (r1 >= r2.length) goto L28;
        String r3 = r2[r1];
        ApplicationsState.AppEntry r4 = this.mApplicationState.getEntry(r3);
        if (r4 != null) goto L8;
    L29:
        ApplicationInfo r5 = this.mPackageManager.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L25
        OLog.d(this.TAG, "updateSystemAppHeaderView appEntry:" + r4);     // Catch: PackageManager.NameNotFoundException -> L25
        String r6 = r5.loadLabel(this.mPackageManager).toString();
        Drawable r7 = r5.loadIcon(this.mPackageManager);
        String r8 = r6;
        Drawable r9 = r7;
    L13:
        View r10 = this.mInflater.inflate(R.layout.list_content_item_switch, this.mStatusBarModeSystemAppsContainer, false);
        SettingItemSwitch r11 = (SettingItemSwitch) r10.findViewById(R.id.item_switch);
        r11.setTitle(r8);
        r11.setIcon(r9);
        int r12 = this.mIconSize;
        Utils.setItemIconSize(r11, r12, r12);
        int r13 = 1;
        if (android.provider.Settings.Global.getInt(getContentResolver(), Constants.SYSTEM_APP_CUSTOMIZED_STATUS_BAR + r3, 1) != 1) goto L16;
        boolean r14 = true;
    L17:
        r11.setChecked(r14);
        r11.getSwitch().setTag(R.id.item_switch, r3);
        r11.setOnCheckedChangeListener(this);
        if (r1 == 0) goto L20;
        r13 = 3;
    L24:
        r11.setBackgroundStyle(r13);
        this.mStatusBarModeSystemAppsContainer.addView(r10);
    L27:
        r1 = r1 + 1;
        goto L3
    L20:
        if (this.mSystemImmersiveApp.length == 1) goto L24;
        r13 = 2;
        goto L24
    L16:
        r14 = false;
    L25:
        e = move-exception;
        e.printStackTrace();
        OLog.e(this.TAG, "updateSystemAppHeaderView: e:" + e);
        goto L27
    L8:
        if (r4.icon == null) goto L29;
        r8 = r4.label;
        r9 = r4.icon;
        goto L13
    }

    private void updateLastHeaderItemBackground() {
        LinearLayout r0 = this.mStatusBarModeSystemAppsContainer;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.mImmersiveAppsAdapter == null) goto L17;
        int r1 = r0.getChildCount();
        if (r1 <= 2) goto L15;
        View r2 = this.mStatusBarModeSystemAppsContainer.getChildAt(r1 - 1);
        if (this.mImmersiveAppsAdapter.getCount() != 0) goto L12;
        r2.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_bottom);
        return;
    L12:
        r2.setBackgroundResource(R.drawable.selector_setting_sub_item_bg_middle);
        return;
    L15:
        return;
    }

    public void com_android_settings_StatusBarFragment__onResume$___twin___() {
        super.onResume();
        updateUI(this.mIsClassicStatusBar);
        if (Utils.isNotchStatusBar(this.mContext) == false) goto L5;
        updateSystemAppHeaderView();
    L5:
        this.mImmersiveAppsAdapter.resume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mImmersiveAppsAdapter.pause();
        updateCustomizedStatusBarState();
        if (this.mIsChanged == false) goto L6;
        sendBroadcast(new Intent(Constants.ACTION.ACTION_STATUSBAR_SETTINGS_CHANGED));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mImmersiveAppsAdapter.destroy();
        this.mImmersiveAppsAdapter = null;
        unregisterReceiver(this.mCloudFeedBackReceiver);
    }

    public static void updateCustomizedStatusBarState() {
        IBinder r0 = ServiceManager.getService("activity");     // Catch: RemoteException -> L6
        if (r0 == null) goto L11;
        Parcel r1 = Parcel.obtain();     // Catch: RemoteException -> L6
        Parcel r2 = Parcel.obtain();     // Catch: RemoteException -> L6
        r0.transact(2040, r1, r2, 0);     // Catch: RemoteException -> L6
        r2.readException();     // Catch: RemoteException -> L6
        r1.recycle();     // Catch: RemoteException -> L6
        r2.recycle();     // Catch: RemoteException -> L6
        return;
    L11:
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    private boolean isCustomizedStatusBarEnable(String r2) {
        return PackageManagerSmt.getInstance().isCustomizedStatusBarEnable(this.mPackageManager, r2);
    }

    public void setClassicStatusBar() {
        if (this.mStatusBarClassicCheck.isChecked() == false) goto L5;
        return;
    L5:
        if (this.mEntries == null) goto L22;
        String[] r0 = this.mSystemImmersiveApp;
        int r1 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r1) goto L16;
        String r4 = r0[r3];
        if (SettingsFeature.isSystemAppDefaultImmersive() == true) goto L12;
    L14:
        android.provider.Settings.Global.putInt(getContentResolver(), Constants.SYSTEM_APP_CUSTOMIZED_STATUS_BAR + r4, 0);
        setCustomizedStatusBarEnable(r4, false);
    L15:
        r3 = r3 + 1;
        goto L8
    L12:
        if ("com.bytedanceos.tpassword".equals(r4) == true) goto L14;
    L16:
        updateUI(true);
        return;
    }

    public void setAdaptiveStatusBar() {
        if (this.mStatusBarAdaptiveCheck.isChecked() == false) goto L5;
        return;
    L5:
        String[] r0 = this.mSystemImmersiveApp;
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L18;
        String r4 = r0[r3];
        if (SettingsFeature.isSystemAppDefaultImmersive() == true) goto L10;
    L12:
        int r5 = this.mSystemAppModePrefs.getInt(r4, 0);
        android.provider.Settings.Global.putInt(getContentResolver(), Constants.SYSTEM_APP_CUSTOMIZED_STATUS_BAR + r4, r5);
        if (r5 == 0) goto L15;
        boolean r6 = true;
    L16:
        setCustomizedStatusBarEnable(r4, r6);
    L17:
        r3 = r3 + 1;
        goto L6
    L15:
        r6 = false;
        goto L16
    L10:
        if ("com.bytedanceos.tpassword".equals(r4) == true) goto L12;
    L18:
        updateSystemAppHeaderView();
        updateUI(false);
        updateLastHeaderItemBackground();
    }

    public void updateUI(boolean r3) {
        if (this.mStatusBarModeSystemAppsContainer != null) goto L5;
        return;
    L5:
        if (this.mImmersiveAppsAdapter == null) goto L14;
        this.mStatusBarClassicCheck.setChecked(r3);
        this.mStatusBarAdaptiveCheck.setChecked(!r3);
        LinearLayout r0 = this.mStatusBarModeSystemAppsContainer;
        if (r3 == false) goto L10;
        int r4 = 8;
    L11:
        r0.setVisibility(r4);
        this.mImmersiveAppsAdapter.notifyDataSetChanged();
        return;
    L10:
        r4 = 0;
        goto L11
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.mStatusBarClassicCheck) goto L6;
        setClassicStatusBar();
        this.mIsClassicStatusBar = true;
        android.provider.Settings.System.putInt(getContentResolver(), "3rd_app_status_bar_mode", 0);
    L8:
        this.mIsChanged = true;
        return;
    L6:
        if (r5 != this.mStatusBarAdaptiveCheck) goto L8;
        this.mIsClassicStatusBar = false;
        setAdaptiveStatusBar();
        android.provider.Settings.System.putInt(getContentResolver(), "3rd_app_status_bar_mode", 1);
        goto L8
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r5, boolean r6) {
        this.mIsChanged = true;
        String r7 = (String) r5.getTag(R.id.item_switch);
        if (r6 == false) goto L5;
        android.provider.Settings.Global.putInt(getContentResolver(), Constants.SYSTEM_APP_CUSTOMIZED_STATUS_BAR + r7, 1);
    L6:
        SharedPreferences.Editor r0 = this.mSystemAppModePrefs.edit();
        r0.putInt(r7, r6 ? 1 : 0);
        r0.apply();
        setCustomizedStatusBarEnable(r7, r6);
        return;
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), Constants.SYSTEM_APP_CUSTOMIZED_STATUS_BAR + r7, 0);
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StatusBarFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_StatusBarFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StatusBarFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_StatusBarFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StatusBarFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_StatusBarFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
