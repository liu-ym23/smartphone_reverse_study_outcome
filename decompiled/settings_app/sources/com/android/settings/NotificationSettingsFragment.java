package com.android.settings;

import android.app.INotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ListView;
import bytedanceos.api.SmtOpsManagerSmt;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.applications.ApplicationsState;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.notification.IConversationView;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.obric.olog.OLog;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.forms.OInputLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    private static final String ALLOW_SMART_NOTIFICATION = "smart_notification";
    private static final String DOT_TYPE_KEY = "obric_launcher_dot_type";
    public static final String GAME_MODE_NO_DISTURB_ENABLED = "game_mode_no_disturb_enabled";
    public static final String HIGH_PRIORITY_NOTIFICATION = "high_priority_notification";
    private static final String LOCKSCREEN_ALLOW_TRIVIAL_CONTROLS = "lockscreen_allow_trivial_controls";
    private static final String LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS = "lock_screen_allow_private_notifications";
    public static final String NOTIFICATION_LAUNCH_FREEFORM_ENABLED = "obric_notification_launch_freeform";
    private static final String NOTIFICATION_REDUCTION_MODE = "notification_reduction_mode";
    private static final int NOT_SHOW = 0;
    private static final int ONLY_NUM = 1;
    public static final String PLAY_AFTER_BLUETOOTH_CONNECTION_SETTING_KEY = "active_play_after_bluetooth_connection";
    private static final int SWITCHER_ID_NOTIFICATION = 1802;
    private static final int TYPE_DISABLE = 2;
    private static final int TYPE_HIDE = 1;
    private static final int TYPE_SHOW = 0;
    private static final int UPDATE_VIEW_DELAY_TIME = 100;
    private final Comparator<NotificationEntry> mAlphaComparator;
    private ApplicationsState mApplicationsState;
    private ArrayList<NotificationEntry> mEntries;
    private OCardListItem mGameTimeNotification;
    private OAlertDialog mHideNotificationAlertDialog;
    private OCardListItem mHighPriorityNotification;
    private ContentObserver mHighPriorityNotificationObserver;
    private boolean mIsObricNewHighPriorityNotification;
    private OCardListItem mLauncherBadgeNotification;
    private OPopover mLauncherBadgeNotificationSettingMenu;
    private ListView mListView;
    private OCardListItem mLockNotification;
    private LockPatternUtils mLockPatternUtils;
    private OSimpleFormDialog mLockScreenMessageInputDialog;
    private OCardListItem mLockScreenMessageItem;
    private OCardListItem mLockscreenTrivialControlsSwitch;
    private NotificationAppsAdapter mNotificationAppsAdapter;
    private OCardListItem mNotificationLaunchFreeform;
    private INotificationManager mNotificationManager;
    private OPopover mPopMenu;
    private View mSearchView;
    private OCardListItem mShowSensitiveNotification;
    private SmtOpsManagerSmt mSmtOps;
    private String[] mSocialAppList;
    private final Comparator<NotificationEntry> mSocialPackageComparator;
    private OCardListItem mStatusBarItem;
    private OCardListItem mSystemNotificationItem;
    private int mTitleStringResId;

    private class NotificationAppsAdapter extends SettingsAdapter implements ApplicationsState.Callbacks, CompoundButton.OnCheckedChangeListener {
        private PackageManager mPackageManager;
        private boolean mResumed;
        private final ApplicationsState.Session mSession;
        final /* synthetic */ NotificationSettingsFragment this$0;

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onAllSizesComputed() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r1, boolean r2) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageSizeChanged(String r1) {
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRunningStateChanged(boolean r1) {
        }

        static /* synthetic */ ArrayList access$1500(NotificationAppsAdapter r0, ArrayList r1) {
            return r0.filter(r1);
        }

        static /* synthetic */ ApplicationsState.Session access$1600(NotificationAppsAdapter r0) {
            return r0.mSession;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public NotificationAppsAdapter(NotificationSettingsFragment r1, Context r2, ApplicationsState r3) {
            this.this$0 = r1;
            NotificationSettingsFragment.access$1302(r1, LayoutInflater.from(r2));
            this.mSession = r3.newSession(this);
            this.mPackageManager = r1.getPackageManager();
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
            if (NotificationSettingsFragment.access$1400(this.this$0) != null) goto L7;
            return 0;
        L7:
            return NotificationSettingsFragment.access$1400(this.this$0).size();
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public NotificationEntry getItem(int r1) {
            return (NotificationEntry) NotificationSettingsFragment.access$1400(this.this$0).get(r1);
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public long getItemId(int r1) {
            return ((NotificationEntry) NotificationSettingsFragment.access$1400(this.this$0).get(r1)).appEntry.id;
        }

        @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
        public View getView(int r5, View r6, ViewGroup r7) {
            if (r6 != null) goto L4;
        L7:
            OCardListItem r8 = new OCardListItem(this.this$0.mContext);
        L8:
            final NotificationEntry r9 = getItem(r5);
            r8.setTitle(r9.appEntry.label);
            int r0 = 1;
            r8.showTitle(true);
            if (r9.appEntry.icon != null) goto L11;
            r9.appEntry.ensureIconLocked(this.this$0.mContext, this.mPackageManager);
        L11:
            r8.setAppIcon(r9.appEntry.icon);
            r8.getIconView().setOutlineProvider(null);
            r8.showIcon(true);
            if (r9.noficationEnabled == false) goto L14;
            String r1 = ResourceUtils.getString(R.string.settings_state_on);
        L15:
            OCardListItemUtils.setCustomEndTipTextView(r8, r1);
            r8.setDefaultTailIcon(0);
            r8.showTailIcon(true);
            if (r5 != 0) goto L22;
            if (getCount() != 1) goto L20;
            r0 = 0;
        L20:
            r8.setCardPosition(r0);
        L25:
            r8.setOnContentClickListener(new AnonymousClass1(this, r9));
            return r8;
        L22:
            if (r5 != (getCount() - 1)) goto L24;
            r8.setCardPosition(3);
            goto L25
        L24:
            r8.setCardPosition(2);
            goto L25
        L14:
            r1 = "";
            goto L15
        L4:
            if ((r6 instanceof OCardListItem) == false) goto L7;
            r8 = (OCardListItem) r6;
            goto L8
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageListChanged() {
            rebuild();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.NotificationSettingsFragment$NotificationAppsAdapter$2] */
        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onRebuildComplete(final ArrayList<ApplicationsState.AppEntry> r2) {
            new AnonymousClass2(this, r2).execute(new Void[0]);
        }

        @Override // com.android.settings.applications.ApplicationsState.Callbacks
        public void onPackageIconChanged() {
            notifyDataSetChanged();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.android.settings.NotificationSettingsFragment$NotificationAppsAdapter$3] */
        public void rebuild() {
            new AnonymousClass3(this).execute(new Void[0]);
        }

        private ArrayList<NotificationEntry> filter(ArrayList<ApplicationsState.AppEntry> r11) {
            ArrayList r0 = new ArrayList();
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            ArrayList<NotificationEntry> r3 = new ArrayList();
            Iterator<ApplicationsState.AppEntry> r12 = r11.iterator();
        L4:
            if (r12.hasNext() == false) goto L26;
            ApplicationsState.AppEntry r4 = r12.next();
            if (NotificationHelper.isRootOrSystemUid(r4.info.uid) == true) goto L4;
            boolean r5 = Utils.isNotificationWhiteApp(this.this$0.mContext, NotificationSettingsFragment.access$1700(this.this$0), r4.info);
            boolean r6 = Utils.isPackageLocked(this.mPackageManager, r4.info.packageName, r4.info.uid);
            boolean r7 = r4.info.packageName.equals(r4.label);
            if (r5 == true) goto L4;
            if (r6 == true) goto L4;
            if (r7 == true) goto L4;
            boolean r8 = isNotificationEnabled(r4.info.packageName, r4.info.uid);
            NotificationEntry r9 = new NotificationEntry();
            r9.appEntry = r4;
            r9.noficationEnabled = r8;
            r9.lightenScreenEnabled = isLightenScreenEnabled(r4.info.packageName, r4.info.uid);
            r9.topLocateEnabled = isTopLocateEnabled(r4.info.packageName, r4.info.uid);
            boolean r10 = false;
            if (Arrays.asList(this.this$0.mContext.getResources().getStringArray(R.array.pop_up_dialog_package_list)).contains(r4.info.packageName) == true) goto L16;
            r9.isPopupDialogEnabled = false;
        L22:
            r9.ledEnabled = isLedEnable(r4.info);
            if (r8 == true) goto L24;
            r2.add(r9);
            goto L4
        L24:
            r1.add(r9);
            goto L4
        L16:
            if (isPopupDialogEnable(r4.info.packageName, r4.info.uid) == true) goto L18;
        L20:
            r9.isPopupDialogEnabled = r10;
            goto L22
        L18:
            if (SettingsFeature.NEW_NOFITICATION_FEATURE == true) goto L20;
            r10 = true;
            goto L20
        L26:
            Collections.sort(r0, NotificationSettingsFragment.access$1800(this.this$0));
            Collections.sort(r1, NotificationSettingsFragment.access$1900(this.this$0));
            Collections.sort(r2, NotificationSettingsFragment.access$1900(this.this$0));
            r3.addAll(r0);
            r3.addAll(r1);
            r3.addAll(r2);
            r0.clear();
            r1.clear();
            r2.clear();
            return r3;
        }

        private boolean isNotificationEnabled(String r1, int r2) {
            return NotificationSettingsFragment.access$2000(this.this$0).areNotificationsEnabledForPackage(r1, r2);
        L4:
            return false;
        }

        private boolean isLightenScreenEnabled(String r5, int r6) {
            if (NotificationSettingsFragment.access$2100(this.this$0) == null) goto L12;
            if (NotificationSettingsFragment.access$2100(this.this$0).checkOpNoThrow(this.this$0.mContext, 25, r6, r5) == 0) goto L14;
            return false;
        L14:
            return true;
        L7:
            e = move-exception;
            OLog.e(NotificationSettingsFragment.access$2200(this.this$0), "isLightenScreenEnabled error:" + e);
            return false;
        L12:
            return false;
        }

        private boolean isLockscreenNotificationOn(ApplicationInfo r3) {
            if (android.provider.Settings.Global.getInt(this.this$0.mContext.getContentResolver(), "lockscreen_notification_for" + r3.packageName + ":" + UserHandle.getUserId(r3.uid), 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean isTopLocateEnabled(String r6, int r7) {
            if ("com.android.contacts".equals(r6) == false) goto L13;
            r7 = Utils.getAppUid(this.this$0.mContext, "com.android.server.telecom");
            r6 = "com.android.server.telecom";
        L13:
            if (NotificationSettingsFragment.access$2100(this.this$0).checkOpNoThrow(this.this$0.mContext, 26, r7, r6) != 0) goto L15;
            return true;
        L15:
            return false;
        L10:
            e = move-exception;
            OLog.e(NotificationSettingsFragment.access$2300(this.this$0), "isTopLocateEnabled error:" + e);
            return false;
        }

        private boolean isPopupDialogEnable(String r3, int r4) {
            if (android.provider.Settings.Global.getInt(this.this$0.getContentResolver(), "pop_up_dialog_in_lock_screen_" + r3 + ":" + UserHandle.getUserId(r4), 1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        private boolean isLedEnable(ApplicationInfo r5) {
            if ("com.android.contacts".equals(r5.packageName) == false) goto L16;
            r5 = this.mPackageManager.getApplicationInfo("com.android.server.telecom", 0);     // Catch: PackageManager.NameNotFoundException -> L6
        L6:
            e = move-exception;
            OLog.e(NotificationSettingsFragment.access$2400(this.this$0), "isLedEnable error:" + e);
            return false;
        L16:
            return NotificationSettingsFragment.access$2000(this.this$0).getISmtEx().isNotiicationLedEnabledForPackage(r5.packageName, r5.uid);
        L11:
            e = move-exception;
            OLog.e(NotificationSettingsFragment.access$2500(this.this$0), "isLedEnable error:" + e);
            return false;
        }
    }

    public static class NotificationEntry {
        ApplicationsState.AppEntry appEntry;
        boolean isPopupDialogEnabled;
        boolean ledEnabled;
        boolean lightenScreenEnabled;
        boolean lockscreenNotificationEnabled;
        boolean noficationEnabled;
        boolean topLocateEnabled;

        public NotificationEntry() {
        }
    }

    public static boolean isAllNotificationsDisabled(Context r0) {
        return false;
    }

    public void com_android_settings_NotificationSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationSettingsFragment() {
        this.mPopMenu = null;
        this.mAlphaComparator = new AnonymousClass10(this);
        this.mSocialPackageComparator = new AnonymousClass11(this);
        final Handler r1 = new Handler();
        this.mHighPriorityNotificationObserver = new AnonymousClass14(this, r1);
    }

    static /* synthetic */ Integer access$000(NotificationSettingsFragment r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ Integer access$100(NotificationSettingsFragment r0) {
        return r0.mTitleResId;
    }

    static /* synthetic */ String access$1000(NotificationSettingsFragment r0) {
        return r0.getLauncherBadgeState();
    }

    static /* synthetic */ OPopover access$1100(NotificationSettingsFragment r0) {
        return r0.mLauncherBadgeNotificationSettingMenu;
    }

    static /* synthetic */ OPopover access$1102(NotificationSettingsFragment r0, OPopover r1) {
        r0.mLauncherBadgeNotificationSettingMenu = r1;
        return r1;
    }

    static /* synthetic */ int access$1200(NotificationSettingsFragment r0, String r1) {
        return r0.findSocialPackageIndex(r1);
    }

    static /* synthetic */ LayoutInflater access$1302(NotificationSettingsFragment r0, LayoutInflater r1) {
        r0.mLayoutInflater = r1;
        return r1;
    }

    static /* synthetic */ ArrayList access$1400(NotificationSettingsFragment r0) {
        return r0.mEntries;
    }

    static /* synthetic */ ArrayList access$1402(NotificationSettingsFragment r0, ArrayList r1) {
        r0.mEntries = r1;
        return r1;
    }

    static /* synthetic */ ApplicationsState access$1700(NotificationSettingsFragment r0) {
        return r0.mApplicationsState;
    }

    static /* synthetic */ Comparator access$1800(NotificationSettingsFragment r0) {
        return r0.mSocialPackageComparator;
    }

    static /* synthetic */ Comparator access$1900(NotificationSettingsFragment r0) {
        return r0.mAlphaComparator;
    }

    static /* synthetic */ void access$200(NotificationSettingsFragment r0, Intent r1) {
        r0.showDialog(r1);
    }

    static /* synthetic */ INotificationManager access$2000(NotificationSettingsFragment r0) {
        return r0.mNotificationManager;
    }

    static /* synthetic */ SmtOpsManagerSmt access$2100(NotificationSettingsFragment r0) {
        return r0.mSmtOps;
    }

    static /* synthetic */ String access$2200(NotificationSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$2300(NotificationSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$2400(NotificationSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$2500(NotificationSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$2600(NotificationSettingsFragment r0, Intent r1) {
        r0.systemAccountLogin(r1);
    }

    static /* synthetic */ boolean access$2700(NotificationSettingsFragment r0) {
        return r0.mIsObricNewHighPriorityNotification;
    }

    static /* synthetic */ boolean access$2800(NotificationSettingsFragment r0) {
        return r0.isHighPriorityNotification();
    }

    static /* synthetic */ OCardListItem access$2900(NotificationSettingsFragment r0) {
        return r0.mHighPriorityNotification;
    }

    static /* synthetic */ Intent access$300(NotificationSettingsFragment r0) {
        return r0.getSmartNotificationSettingActivity();
    }

    static /* synthetic */ String access$400(NotificationSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ boolean access$500(NotificationSettingsFragment r0, boolean r1) {
        return r0.setHighPriorityNotification(r1);
    }

    static /* synthetic */ void access$600(NotificationSettingsFragment r0) {
        r0.showLockScreenMessageInputDialog();
    }

    static /* synthetic */ void access$700(NotificationSettingsFragment r0) {
        r0.showLauncherBadgeNotificationSettingMenu();
    }

    static /* synthetic */ void access$800(NotificationSettingsFragment r0, boolean r1) {
        r0.setShowSensitiveNotificationState(r1);
    }

    static /* synthetic */ OCardListItem access$900(NotificationSettingsFragment r0) {
        return r0.mLauncherBadgeNotification;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.manage_applications_layout, r4, false);
        this.mNotificationManager = INotificationManager.Stub.asInterface(ServiceManager.getService("notification"));
        this.mSmtOps = SmtOpsManagerSmt.getInstance();
        this.mSocialAppList = ResourceUtils.getResources().getStringArray(R.array.social_package_list);
        this.mTitleStringResId = R.string.system_notification_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        r6.setCenterTitle(ResourceUtils.getString(this.mTitleStringResId));
        View r7 = r6.addEndAction(R.drawable.oui_icon_oic_magnifier_search, -1, null);
        this.mSearchView = r7;
        r7.setOnClickListener(new AnonymousClass1(this));
        this.mListView = (ListView) findViewByIdNullable(R.id.listView);
        initHeaderView(r3);
        this.mApplicationsState = ApplicationsState.getInstance(this._mActivity.getApplication(), true);
        NotificationAppsAdapter r8 = new NotificationAppsAdapter(this, this._mActivity, this.mApplicationsState);
        this.mNotificationAppsAdapter = r8;
        this.mListView.setAdapter(r8);
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListView);
        this.mLockPatternUtils = new ChooseLockSettingsHelper(this._mActivity).utils();
        return this.mRootView;
    }

    private void initHeaderView(LayoutInflater r5) {
        View r6 = r5.inflate(R.layout.notification_settings_header_view, null);
        FrameLayout r0 = (FrameLayout) r6.findViewById(R.id.conversation);
        IConversationView r1 = (IConversationView) com.bytedance.news.common.service.manager.ServiceManager.getService(IConversationView.class);
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.createToParent(this.mContext, r0);
    L6:
        this.mIsObricNewHighPriorityNotification = isActivityAvailable(getSmartNotificationSettingActivity());
        OLog.i(this.TAG, "onCreateView: mIsObricNewHighPriorityNotification=" + this.mIsObricNewHighPriorityNotification);
        OCardListItem r2 = (OCardListItem) r6.findViewById(R.id.high_priority_notification);
        this.mHighPriorityNotification = r2;
        if (this.mIsObricNewHighPriorityNotification == false) goto L9;
        r2.showTailIcon(true);
        this.mHighPriorityNotification.showSubTitle(false);
        OCardListItemUtils.setCustomEndTipTextView(this.mHighPriorityNotification, getHighPriorityNotificationState());
        this.mHighPriorityNotification.setOnContentClickListener(new AnonymousClass2(this));
    L10:
        OCardListItem r3 = (OCardListItem) r6.findViewById(R.id.lock_screen_message_item);
        this.mLockScreenMessageItem = r3;
        r3.setOnContentClickListener(new AnonymousClass4(this));
        OCardListItem r4 = (OCardListItem) r6.findViewById(R.id.lockscreen_trivial_controls_switch);
        this.mLockscreenTrivialControlsSwitch = r4;
        r4.getContentContainer().setClickable(false);
        ((OSwitch) this.mLockscreenTrivialControlsSwitch.getCustomEndView()).setChecked(getLockscreenTrivialControlsState());
        ((OSwitch) this.mLockscreenTrivialControlsSwitch.getCustomEndView()).setOnCheckedChangeListener(this);
        OCardListItem r7 = (OCardListItem) r6.findViewById(R.id.launcher_badge_notification);
        this.mLauncherBadgeNotification = r7;
        OCardListItemUtils.setCustomEndTipTextView(r7, getLauncherBadgeState());
        this.mLauncherBadgeNotification.setOnContentClickListener(new AnonymousClass5(this));
        OCardListItem r8 = (OCardListItem) r6.findViewById(R.id.status_bar_item);
        this.mStatusBarItem = r8;
        r8.setOnContentClickListener(new NotificationSettingsFragment$$ExternalSyntheticLambda6(this));
        OCardListItem r9 = (OCardListItem) r6.findViewById(R.id.lock_notification);
        this.mLockNotification = r9;
        r9.setOnContentClickListener(new AnonymousClass6(this));
        OCardListItem r10 = (OCardListItem) r6.findViewById(R.id.game_time_notification);
        this.mGameTimeNotification = r10;
        r10.getContentContainer().setClickable(false);
        ((OSwitch) this.mGameTimeNotification.getCustomEndView()).setChecked(isDisplayNotificationGameTime());
        ((OSwitch) this.mGameTimeNotification.getCustomEndView()).setOnCheckedChangeListener(this);
        int r11 = 8;
        if (SettingsFeature.isSupportGameHideNotification() == true) goto L13;
        this.mGameTimeNotification.setVisibility(8);
    L13:
        OCardListItem r12 = (OCardListItem) r6.findViewById(R.id.notification_launch_freeform);
        this.mNotificationLaunchFreeform = r12;
        r12.getContentContainer().setClickable(false);
        ((OSwitch) this.mNotificationLaunchFreeform.getCustomEndView()).setChecked(isNotificationLaunchFreeformEnabled());
        ((OSwitch) this.mNotificationLaunchFreeform.getCustomEndView()).setOnCheckedChangeListener(this);
        if (SettingsFeature.isSupportGameHideNotification() == true) goto L16;
        this.mNotificationLaunchFreeform.setVisibility(8);
    L16:
        OCardListItem r13 = (OCardListItem) r6.findViewById(R.id.system_notification_item);
        this.mSystemNotificationItem = r13;
        if (this.mIsLandScreen == true) goto L19;
    L21:
        r13.setVisibility(r11);
        this.mSystemNotificationItem.setOnClickListener(new AnonymousClass7(this));
        OCardListItem r14 = (OCardListItem) r6.findViewById(R.id.lock_show_sensitive_notification);
        this.mShowSensitiveNotification = r14;
        r14.getContentContainer().setClickable(false);
        ((OSwitch) this.mShowSensitiveNotification.getCustomEndView()).setChecked(getShowSensitiveNotificationState());
        ((OSwitch) this.mShowSensitiveNotification.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass8(this));
        this.mListView.addHeaderView(r6);
        return;
    L19:
        if (this.mIsExtDisplaying == false) goto L21;
        r11 = 0;
        goto L21
    L9:
        r2.showTailIcon(false);
        this.mHighPriorityNotification.showSubTitle(true);
        this.mHighPriorityNotification.setDefaultCustomEndView(1);
        this.mHighPriorityNotification.showCustomEnd(true);
        this.mHighPriorityNotification.getContentContainer().setClickable(false);
        ((OSwitch) this.mHighPriorityNotification.getCustomEndView()).setChecked(isHighPriorityNotification());
        ((OSwitch) this.mHighPriorityNotification.getCustomEndView()).setOnCheckedChangeListener(new AnonymousClass3(this));
        goto L10
    }

    /* JADX INFO: renamed from: lambda$initHeaderView$0$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ void m179x268cbae5(View r1) {
        start(StatusBarSettingFragment.class);
    }

    private void showLauncherBadgeNotificationSettingMenu() {
        ArrayList r0 = new ArrayList();
        int r1 = android.provider.Settings.Global.getInt(getContentResolver(), DOT_TYPE_KEY, 1);
        String r4 = getString(R.string.system_notification_launcher_badge_not_show);
        boolean r5 = false;
        if (r1 != 0) goto L5;
        boolean r6 = true;
    L6:
        r0.add(new Item(r4, r6));
        String r7 = getString(R.string.system_notification_launcher_badge_only_num);
        if (r1 != 1) goto L9;
        r5 = true;
    L9:
        r0.add(new Item(r7, r5));
        this.mLauncherBadgeNotificationSettingMenu = OPopoverHelper.showPopoverList(this._mActivity, this.mLauncherBadgeNotification, r0, new AnonymousClass9(this), true);
        return;
    L5:
        r6 = false;
        goto L6
    }

    private void showLockScreenMessageInputDialog() {
        if (isDeviceOwnerInfoEnabled() == false) goto L5;
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, getDeviceOwner());
        return;
    L5:
        OSimpleFormDialog r0 = new OSimpleFormDialog(this._mActivity, new OSimpleFormDialog.Modifier(getString(R.string.lock_screen_message_input_dialog_title), "", new OSimpleFormDialog.InputViewConfig(true, false, new NotificationSettingsFragment$$ExternalSyntheticLambda1(this)), new OSimpleFormDialog.InputViewConfig(false, false, null), new OBaseDialog.ButtonConfig(getString(R.string.lock_screen_message_input_dialog_save_button), new NotificationSettingsFragment$$ExternalSyntheticLambda2(this), null), new OBaseDialog.ButtonConfig(getString(R.string.lock_screen_message_input_dialog_cancel_button), new NotificationSettingsFragment$$ExternalSyntheticLambda3(this), null)));
        this.mLockScreenMessageInputDialog = r0;
        r0.show();
    }

    /* JADX INFO: renamed from: lambda$showLockScreenMessageInputDialog$1$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ Unit m182xafe4a183(OInputLayout r2) {
        r2.setHint(getString(R.string.lock_screen_message_input_dialog_hint));
        if (isOwnerInfoEnabled() == false) goto L6;
        String r1 = getOwnerInfo();
        r2.setText(r1);
        r2.getVInput().setSelection(0, r1.length());
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$showLockScreenMessageInputDialog$2$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ Unit m183xf36fbf44() {
        OSimpleFormDialog r0 = this.mLockScreenMessageInputDialog;
        if (r0 == null) goto L18;
        String r1 = r0.getInputView1().getText().toString();     // Catch: Exception -> L14
        int r2 = UserHandle.myUserId();     // Catch: Exception -> L14
        LockPatternUtils r3 = this.mLockPatternUtils;     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r1) == true) goto L7;
        boolean r4 = true;
    L8:
        r3.setOwnerInfoEnabled(r4, r2);     // Catch: Exception -> L14
        this.mLockPatternUtils.setOwnerInfo(r1, r2);     // Catch: Exception -> L14
        OCardListItem r5 = this.mLockScreenMessageItem;     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r1) == false) goto L12;
        r1 = getString(R.string.owner_info_settings_summary);     // Catch: Exception -> L14
    L12:
        r5.setSubTitle(r1);     // Catch: Exception -> L14
    L16:
        this.mLockScreenMessageInputDialog.dismiss();
        goto L18
    L7:
        r4 = false;
    L14:
        e = move-exception;
        OLog.e(this.TAG, "showLockScreenMessageInputDialog error", e);
    L18:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$showLockScreenMessageInputDialog$3$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ Unit m184x36fadd05() {
        OSimpleFormDialog r0 = this.mLockScreenMessageInputDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        return Unit.INSTANCE;
    }

    private void showHideNotificationAlertDialog() {
        if (this.mHideNotificationAlertDialog != null) goto L5;
        this.mHideNotificationAlertDialog = new OAlertDialogBuilder(this._mActivity).horizontalButton().title(android.R.string.dialog_alert_title).message(R.string.system_notification_lock_screen_hint).positiveButton(R.string.dialog_positive_button_setup, new NotificationSettingsFragment$$ExternalSyntheticLambda4(this)).negativeButton(android.R.string.cancel, new NotificationSettingsFragment$$ExternalSyntheticLambda5(this)).build();
    L5:
        this.mHideNotificationAlertDialog.show();
    }

    /* JADX INFO: renamed from: lambda$showHideNotificationAlertDialog$4$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ void m180x8d07e87(DialogInterface r2, int r3) {
        Intent r4 = new Intent("android.app.action.SET_NEW_PASSWORD");
        r4.putExtra("minimum_quality", 65536);
        startActivity(r4);
        OAlertDialog r1 = this.mHideNotificationAlertDialog;
        if (r1 == null) goto L6;
        r1.dismiss();
        return;
    }

    /* JADX INFO: renamed from: lambda$showHideNotificationAlertDialog$5$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ void m181x4c5b9c48(DialogInterface r1, int r2) {
        OAlertDialog r0 = this.mHideNotificationAlertDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    private boolean checkKeyGuardQuality() {
        int r0 = UserManager.get(getActivity()).getCredentialOwnerProfile(UserHandle.myUserId());
        if (new LockPatternUtils(getActivity()).getActivePasswordQuality(r0) < 65536) goto L5;
        return true;
    L5:
        return false;
    }

    private int getLockScreenNotificationMode() {
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), "lock_screen_show_notifications", 0) == 0) goto L5;
        boolean r0 = true;
    L7:
        if (new LockPatternUtils(this.mContext).isSecure(UserHandle.myUserId()) == true) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r0 == true) goto L15;
        return 2;
    L15:
        if (r5 == false) goto L18;
        return 0;
    L18:
        return 1;
    L9:
        if (android.provider.Settings.Secure.getIntForUser(this.mContext.getContentResolver(), LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS, 0, UserHandle.myUserId()) != 0) goto L12;
        r5 = false;
        goto L13
    L5:
        r0 = false;
        goto L7
    }

    private void updateLockScreenNotificationMode(int r4) {
        int r1 = 1;
        if (r4 == 2) goto L5;
        int r0 = 1;
    L6:
        if (r4 == 0) goto L9;
        r1 = 0;
    L9:
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS, r1);
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), "lock_screen_show_notifications", r0);
        return;
    L5:
        r0 = 0;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        registerContentObserver();
        OCardListItemUtils.setCustomEndTipTextView(this.mLauncherBadgeNotification, getLauncherBadgeState());
        if (this.mIsObricNewHighPriorityNotification == false) goto L5;
        OCardListItemUtils.setCustomEndTipTextView(this.mHighPriorityNotification, getHighPriorityNotificationState());
    L6:
        updateLockScreenMessageItemStatus();
        updateLockScreenShowSensitiveNotificationItemStatus();
        updateLockscreenTrivialControlsSwitchStatus();
        return;
    L5:
        ((OSwitch) this.mHighPriorityNotification.getCustomEndView()).setChecked(isHighPriorityNotification());
        goto L6
    }

    public void com_android_settings_NotificationSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mNotificationAppsAdapter.resume();
        OCardListItemUtils.setCustomEndTipTextView(this.mLauncherBadgeNotification, getLauncherBadgeState());
        if (this.mIsObricNewHighPriorityNotification == false) goto L5;
        OCardListItemUtils.setCustomEndTipTextView(this.mHighPriorityNotification, getHighPriorityNotificationState());
    L6:
        updateLockScreenMessageItemStatus();
        updateLockScreenShowSensitiveNotificationItemStatus();
        updateLockscreenTrivialControlsSwitchStatus();
        return;
    L5:
        ((OSwitch) this.mHighPriorityNotification.getCustomEndView()).setChecked(isHighPriorityNotification());
        goto L6
    }

    private void updateLockScreenMessageItemStatus() {
        if (this.mLockScreenMessageItem != null) goto L6;
        return;
    L6:
        if (XTSUtils.isInXtsMode() == false) goto L8;
        this.mLockScreenMessageItem.setVisibility(0);
    L10:
        if (isDeviceOwnerInfoEnabled() == false) goto L12;
        this.mLockScreenMessageItem.setSubTitle(getDeviceOwnerInfo());
        this.mLockScreenMessageItem.setEnabled(true);
        OCardListItemUtils.setContentContainerEnabled(this.mLockScreenMessageItem, false);
        this.mLockScreenMessageItem.getContentContainer().setClickable(true);
        return;
    L12:
        OCardListItem r0 = this.mLockScreenMessageItem;
        if (isOwnerInfoEnabled() == false) goto L15;
        String r1 = getOwnerInfo();
    L16:
        r0.setSubTitle(r1);
        this.mLockScreenMessageItem.setEnabled(!this.mLockPatternUtils.isLockScreenDisabled(UserHandle.myUserId()));
        return;
    L15:
        r1 = getString(R.string.owner_info_settings_summary);
        goto L16
    L8:
        this.mLockScreenMessageItem.setVisibility(8);
        goto L10
    }

    private void updateLockscreenTrivialControlsSwitchStatus() {
        if (this.mLockscreenTrivialControlsSwitch != null) goto L5;
        return;
    L5:
        boolean r0 = XTSUtils.isInXtsMode();
        OCardListItem r1 = this.mLockscreenTrivialControlsSwitch;
        if (r0 == false) goto L8;
        int r2 = 0;
    L9:
        r1.setVisibility(r2);
        this.mLockscreenTrivialControlsSwitch.getContentContainer().setClickable(false);
        ((OSwitch) this.mLockscreenTrivialControlsSwitch.getCustomEndView()).setChecked(getLockscreenTrivialControlsState());
        return;
    L8:
        r2 = 8;
        goto L9
    }

    private void updateLockScreenShowSensitiveNotificationItemStatus() {
        if (this.mShowSensitiveNotification != null) goto L6;
        return;
    L6:
        if (XTSUtils.isInXtsMode() == false) goto L8;
        this.mShowSensitiveNotification.setVisibility(0);
    L9:
        this.mShowSensitiveNotification.getContentContainer().setClickable(false);
        ((OSwitch) this.mShowSensitiveNotification.getCustomEndView()).setChecked(getShowSensitiveNotificationState());
        final RestrictedLockUtils.EnforcedAdmin r0 = getEnforcedAdmin(UserHandle.myUserId());
        if (r0 == null) goto L12;
        this.mShowSensitiveNotification.setSubTitle(getString(R.string.disabled_by_administrator_summary));
        this.mShowSensitiveNotification.showSubTitle(true);
        ((OSwitch) this.mShowSensitiveNotification.getCustomEndView()).setClickable(false);
        OCardListItemUtils.setContentContainerEnabled(this.mShowSensitiveNotification, false);
        this.mShowSensitiveNotification.getContentContainer().setClickable(true);
        this.mShowSensitiveNotification.getContentContainer().setOnClickListener(new NotificationSettingsFragment$$ExternalSyntheticLambda0(this, r0));
        return;
    L12:
        this.mShowSensitiveNotification.setSubTitle("");
        this.mShowSensitiveNotification.showSubTitle(false);
        this.mShowSensitiveNotification.setEnabled(true);
        ((OSwitch) this.mShowSensitiveNotification.getCustomEndView()).setClickable(true);
        this.mShowSensitiveNotification.getContentContainer().setOnClickListener(null);
        return;
    L8:
        this.mShowSensitiveNotification.setVisibility(8);
        goto L9
    }

    /* JADX INFO: renamed from: lambda$updateLockScreenShowSensitiveNotificationItemStatus$6$com-android-settings-NotificationSettingsFragment, reason: not valid java name */
    /* synthetic */ void m185x61350a78(RestrictedLockUtils.EnforcedAdmin r1, View r2) {
        RestrictedLockUtils.sendShowAdminSupportDetailsIntent(this.mContext, r1);
    }

    private boolean getShowSensitiveNotificationState() {
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS, 1) != 0) goto L7;
        return false;
    L7:
        return true;
    }

    private RestrictedLockUtils.EnforcedAdmin getEnforcedAdmin(int r3) {
        RestrictedLockUtils.EnforcedAdmin r0 = RestrictedLockUtilsInternal.checkIfKeyguardFeaturesDisabled(this.mContext, 4, r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return RestrictedLockUtilsInternal.checkIfKeyguardFeaturesDisabled(this.mContext, 8, r3);
    }

    private void setShowSensitiveNotificationState(boolean r2) {
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), LOCK_SCREEN_ALLOW_PRIVATE_NOTIFICATIONS, r2 ? 1 : 0);
    }

    private boolean getLockscreenTrivialControlsState() {
        if (android.provider.Settings.Secure.getInt(this.mContext.getContentResolver(), LOCKSCREEN_ALLOW_TRIVIAL_CONTROLS, 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    private void setLockscreenTrivialControlsState(boolean r2) {
        android.provider.Settings.Secure.putInt(this.mContext.getContentResolver(), LOCKSCREEN_ALLOW_TRIVIAL_CONTROLS, r2 ? 1 : 0);
    }

    private boolean isDeviceOwnerInfoEnabled() {
        return this.mLockPatternUtils.isDeviceOwnerInfoEnabled();
    }

    private RestrictedLockUtils.EnforcedAdmin getDeviceOwner() {
        return RestrictedLockUtilsInternal.getDeviceOwner(this.mContext);
    }

    private String getDeviceOwnerInfo() {
        return this.mLockPatternUtils.getDeviceOwnerInfo();
    }

    private boolean isOwnerInfoEnabled() {
        return this.mLockPatternUtils.isOwnerInfoEnabled(UserHandle.myUserId());
    }

    private String getOwnerInfo() {
        return this.mLockPatternUtils.getOwnerInfo(UserHandle.myUserId());
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mNotificationAppsAdapter.pause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        NotificationAppsAdapter r0 = this.mNotificationAppsAdapter;
        if (r0 == null) goto L5;
        r0.destroy();
    L5:
        OAlertDialog r1 = this.mHideNotificationAlertDialog;
        if (r1 == null) goto L8;
        r1.dismiss();
        this.mHideNotificationAlertDialog = null;
    L8:
        OSimpleFormDialog r2 = this.mLockScreenMessageInputDialog;
        if (r2 == null) goto L11;
        r2.dismiss();
        this.mLockScreenMessageInputDialog = null;
    L11:
        unRegisterContentObserver();
    }

    private int findSocialPackageIndex(String r5) {
        if (r5 != null) goto L5;
    L13:
        return 0;
    L5:
        if (this.mSocialAppList == null) goto L13;
        int r1 = 0;
    L7:
        String[] r2 = this.mSocialAppList;
        if (r1 >= r2.length) goto L13;
        if (r5.equals(r2[r1]) == true) goto L11;
        r1 = r1 + 1;
        goto L7
    L11:
        return r1;
    }

    private boolean isDisplayNotificationGameTime() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), GAME_MODE_NO_DISTURB_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setDisplayNotificationGameTime(boolean r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), GAME_MODE_NO_DISTURB_ENABLED, r2 ? 1 : 0);
        TrackerEvent.switchEvent(GAME_MODE_NO_DISTURB_ENABLED, r2);
    }

    private boolean isNotificationLaunchFreeformEnabled() {
        if (android.provider.Settings.System.getInt(getContentResolver(), NOTIFICATION_LAUNCH_FREEFORM_ENABLED, 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setNotificationLaunchFreeformEnabled(boolean r2) {
        android.provider.Settings.System.putInt(getContentResolver(), NOTIFICATION_LAUNCH_FREEFORM_ENABLED, r2 ? 1 : 0);
        TrackerEvent.switchEvent("notification_launch_freeform", r2);
    }

    private boolean isHighPriorityNotification() {
        if (android.provider.Settings.System.getInt(getContentResolver(), HIGH_PRIORITY_NOTIFICATION, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean setHighPriorityNotification(boolean r2) {
        return android.provider.Settings.System.putInt(getContentResolver(), HIGH_PRIORITY_NOTIFICATION, r2 ? 1 : 0);
    }

    private String getLauncherBadgeState() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), DOT_TYPE_KEY, 1) != 0) goto L5;
        int r2 = R.string.system_notification_launcher_badge_not_show;
    L7:
        return ResourceUtils.getString(r2);
    L5:
        r2 = R.string.system_notification_launcher_badge_only_num;
        goto L7
    }

    private String getHighPriorityNotificationState() {
        if (this.mIsObricNewHighPriorityNotification == false) goto L12;
        if (isHighPriorityNotification() == false) goto L10;
        if (OAccountHelper.isLogin() == false) goto L10;
        return ResourceUtils.getString(R.string.settings_state_on);
    L10:
        return ResourceUtils.getString(R.string.settings_state_off);
    L12:
        if (isHighPriorityNotification() == false) goto L15;
        return ResourceUtils.getString(R.string.settings_state_on);
    L15:
        return ResourceUtils.getString(R.string.settings_state_off);
    }

    private Intent getSmartNotificationSettingActivity() {
        Intent r3 = new Intent();
        r3.setComponent(new ComponentName(Constants.PKG_ORIGINAL_SMARTNOTIFICATION, Constants.PKG_ORIGINAL_SMARTNOTIFICATION_CLASS_NAME));
        r3.setPackage(Constants.PKG_ORIGINAL_SMARTNOTIFICATION);
        return r3;
    }

    private boolean isActivityAvailable(Intent r4) {
        PackageManager r1 = this._mActivity.getPackageManager();     // Catch: Exception -> L10 PackageManager.NameNotFoundException -> L8
        ComponentName r2 = r4.getComponent();     // Catch: Exception -> L10 PackageManager.NameNotFoundException -> L8
        if (r2 == null) goto L7;
        return r1.getActivityInfo(r2, 0).exported;
    L8:
        OLog.e(this.TAG, "isActivityAvailable:  component not exist: " + r4.getComponent());
        return false;
    L7:
        return false;
    }

    private void showDialog(final Intent r4) {
        new OAlertDialogBuilder(this._mActivity).autoDismiss(false).horizontalButton().title(R.string.system_account_logout_dialog_login_title).message(R.string.system_account_logout_dialog_login_message).negativeButton(R.string.system_account_logout_dialog_login_btn_cancel, new AnonymousClass13(this)).positiveButton(R.string.system_account_logout_dialog_login_btn_confirm, new AnonymousClass12(this, r4)).show();
    }

    private void systemAccountLogin(Intent r3) {
        OLog.d(this.TAG, "systemAccountLogin, start");
        OAccountHelper.prepareAccountLaunchIntent(this._mActivity, r3);     // Catch: Exception -> L5
        Utils.startActivity(this._mActivity, r3, 0, 0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "start account app error:" + e);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != ((OSwitch) this.mGameTimeNotification.getCustomEndView())) goto L6;
        setDisplayNotificationGameTime(r3);
        return;
    L6:
        if (r2 != ((OSwitch) this.mNotificationLaunchFreeform.getCustomEndView())) goto L9;
        setNotificationLaunchFreeformEnabled(r3);
        return;
    L9:
        if (r2 != ((OSwitch) this.mLockscreenTrivialControlsSwitch.getCustomEndView())) goto L14;
        setLockscreenTrivialControlsState(r3);
        return;
    }

    private void registerContentObserver() {
        getContentResolver().registerContentObserver(android.provider.Settings.System.getUriFor(HIGH_PRIORITY_NOTIFICATION), true, this.mHighPriorityNotificationObserver);
    }

    private void unRegisterContentObserver() {
        getContentResolver().unregisterContentObserver(this.mHighPriorityNotificationObserver);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
