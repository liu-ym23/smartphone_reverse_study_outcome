package com.android.settings.notification;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.UserInfo;
import android.os.Bundle;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ScrollView;
import androidx.core.app.NotificationChannelCompat;
import bytedanceos.api.NotificationChannelSmt;
import com.GlobalProxyLancet;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.NotificationDetailsFragment;
import com.android.settings.NotificationSettingsFragment;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.applications.utils.Item;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.applications.utils.OPopoverHelper;
import com.android.settings.applications.utils.XTSUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ChannelNotificationSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    public static final String ARG_PACKAGE_ENABLE_FLAGS = "enable_flags";
    public static final String ARG_PACKAGE_NAME = "package";
    public static final String ARG_PACKAGE_UID = "uid";
    private OCardListItem[] mAllSwitches;
    private ApplicationInfo mAppInfo;
    private NotificationBackend.AppRow mAppRow;
    private NotificationBackend mBackend;
    private NotificationChannel mChannel;
    private boolean mEnableFlags;
    private OCardListItem mEnabledSwitch;
    private OCardListItem mFloatingSwitch;
    private boolean mListeningToPackageRemove;
    private LockPatternUtils mLockPatternUtils;
    private OCardListItem mLockVisible;
    private OPopover mLockVisiblePopover;
    private final BroadcastReceiver mPackageRemovedReceiver;
    private String mPkg;
    protected PackageInfo mPkgInfo;
    private PackageManager mPm;
    private OCardListItem mRingtoneSwitch;
    private OSectionTitleBar mSelectionTitle;
    private int mUid;
    private UserManager mUm;
    private OCardListItem mVibrateSwitch;

    public void com_android_settings_notification_ChannelNotificationSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public ChannelNotificationSettings() {
        this.mBackend = new NotificationBackend();
        this.mEnableFlags = false;
        this.mAllSwitches = null;
        this.mPackageRemovedReceiver = new AnonymousClass1(this);
    }

    static /* synthetic */ String access$000(ChannelNotificationSettings r0) {
        return r0.TAG;
    }

    static /* synthetic */ void access$100(ChannelNotificationSettings r0) {
        r0.onPackageRemoved();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        super.onCreateView(r2, r3, r4);
        this.mRootView = r2.inflate(R.layout.notification_channel_detail, r3, false);
        this.mEnabledSwitch = (OCardListItem) this.mRootView.findViewById(R.id.notification_enabled);
        this.mFloatingSwitch = (OCardListItem) this.mRootView.findViewById(R.id.high_importance);
        this.mRingtoneSwitch = (OCardListItem) this.mRootView.findViewById(R.id.switch_notification_ringtone);
        this.mVibrateSwitch = (OCardListItem) this.mRootView.findViewById(R.id.switch_notification_vibrate);
        this.mLockVisible = (OCardListItem) this.mRootView.findViewById(R.id.switch_notification_visible);
        this.mSelectionTitle = (OSectionTitleBar) this.mRootView.findViewById(R.id.selection_title);
        this.mAllSwitches = new OCardListItem[]{this.mFloatingSwitch, this.mRingtoneSwitch, this.mVibrateSwitch, this.mLockVisible};
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        UIUtils.fitMaskTitle(this, (ScrollView) findViewByIdNullable(R.id.page_scrollview));
        NotificationChannel r3 = this.mChannel;
        if (r3 != null) goto L5;
        CharSequence r4 = "";
    L6:
        setTitle(r4);
        if (XTSUtils.isInXtsMode() == true) goto L9;
    L11:
        this.mLockVisible.setVisibility(8);
    L12:
        this.mLockVisible.setOnContentClickListener(new ChannelNotificationSettings$$ExternalSyntheticLambda0(this));
        updateLockVisible();
        return;
    L9:
        if (isLockScreenSecure() == false) goto L11;
        this.mLockVisible.setVisibility(0);
        goto L12
    L5:
        r4 = r3.getName();
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-notification-ChannelNotificationSettings, reason: not valid java name */
    /* synthetic */ void m520xe3636bfe(View r1) {
        showLockVisibleMenu(r1);
    }

    public void com_android_settings_notification_ChannelNotificationSettings__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        this.mContext = getActivity();
        this.mUm = UserManager.get(this.mContext);
        this.mLockPatternUtils = new LockPatternUtils(this.mContext);
        Intent r8 = getActivity().getIntent();
        Bundle r0 = getArguments();
        if (r8 == null) goto L62;
        if (r0 == null) goto L62;
        this.mPm = getPackageManager();
        ApplicationInfo r1 = (ApplicationInfo) getArguments().getParcelable("appInfo");
        this.mAppInfo = r1;
        if (r1 == null) goto L9;
        this.mPkg = r1.packageName;
        this.mUid = this.mAppInfo.uid;
    L19:
        if (this.mUid >= 0) goto L22;
        this.mUid = this.mPm.getPackageUidAsUser(this.mPkg, Utils.getSecureTargetUser(getActivity().getActivityToken(), UserManager.get(getActivity()), r0, r8.getExtras()).getIdentifier());     // Catch: PackageManager.NameNotFoundException -> L64
    L22:
        if (r8 == null) goto L24;
        String r9 = r8.getStringExtra("android.provider.extra.CHANNEL_ID");
    L25:
        if (r9 != null) goto L29;
        if (r0 == null) goto L28;
        r9 = r0.getString("android.provider.extra.CHANNEL_ID");
        goto L29
    L28:
        r9 = null;
    L29:
        if (r0 == null) goto L31;
        String r2 = r0.getString("android.provider.extra.CONVERSATION_ID");
    L32:
        NotificationChannel r3 = this.mBackend.getChannel(this.mPkg, this.mUid, r9, r2);
        this.mChannel = r3;
        if (r3 != null) goto L35;
        this.mChannel = this.mBackend.getChannel(this.mPkg, this.mUid, r9, null);
    L35:
        this.mPkgInfo = findPackageInfo(this.mPkg, this.mUid);
        if (this.mUid >= 0) goto L38;
    L60:
        OLog.w(this.TAG, "Missing package or uid or packageinfo");
        finish();
        return;
    L38:
        if (TextUtils.isEmpty(this.mPkg) == true) goto L60;
        if (this.mPkgInfo == null) goto L60;
        this.mAppRow = this.mBackend.loadAppRow(this.mContext, this.mPm, this.mPkgInfo);
        startListeningToPackageRemove();
        if (r0 != null) goto L45;
    L47:
        this.mEnableFlags = getEnabledFlag();
    L49:
        if (this.mUid >= 0) goto L51;
    L58:
        OLog.e(this.TAG, "Missing package or uid or packageinfo or channel");
        finish();
        return;
    L51:
        if (TextUtils.isEmpty(this.mPkg) == true) goto L58;
        if (this.mPkgInfo == null) goto L58;
        if (this.mChannel == null) goto L58;
        return;
    L45:
        if (r0.containsKey(ARG_PACKAGE_ENABLE_FLAGS) == false) goto L47;
        this.mEnableFlags = r0.getBoolean(ARG_PACKAGE_ENABLE_FLAGS, false);
        goto L49
    L31:
        r2 = null;
        goto L32
    L24:
        r9 = null;
        goto L25
    L9:
        if (r0.containsKey("package") == false) goto L11;
        String r4 = r0.getString("package");
    L12:
        this.mPkg = r4;
        if (r0.containsKey("uid") == false) goto L15;
        int r5 = r0.getInt("uid");
    L16:
        this.mUid = r5;
        goto L19
    L15:
        r5 = r8.getIntExtra("app_uid", -1);
        goto L16
    L11:
        r4 = r8.getStringExtra(NotificationDetailsFragment.ANDROID_PROVIDER_EXTRA_APP_PACKAGE);
    L62:
        OLog.w(this.TAG, "No intent");
        finish();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateSwitchStatus();
        OCardListItemUtils.setOnCheckedChangeListener(this.mEnabledSwitch, this);
        OCardListItemUtils.setOnCheckedChangeListener(this.mFloatingSwitch, this);
        OCardListItemUtils.setOnCheckedChangeListener(this.mVibrateSwitch, this);
        OCardListItemUtils.setOnCheckedChangeListener(this.mRingtoneSwitch, this);
    }

    private boolean getEnabledFlag() {
        OLog.d(this.TAG, "getEnabledFlag.... mPkg :" + this.mPkg + ", mUid: " + this.mUid);
        boolean r1 = true;
        boolean r0 = !NotificationSettingsFragment.isAllNotificationsDisabled(this.mContext);
        OLog.d(this.TAG, "getEnabledFlag....isEnableAll :" + r0);
        NotificationHelper.AppRow r2 = new NotificationHelper.AppRow();
        NotificationHelper.getInstance().recordCanBeBlocked(this.mPkgInfo, r2);
        r2.banned = !NotificationHelper.getInstance().areNotificationsEnabledForPackage(this.mPkg, this.mUid);
        if (r2.systemApp == true) goto L5;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L13;
    L15:
        boolean r4 = false;
    L16:
        OLog.i(this.TAG, "getEnabledFlag....systemApp :" + r2.systemApp + ", lockedImportance: " + r2.lockedImportance);
        boolean r5 = NotificationHelper.notificationPermissionFixed(this.mContext, this.mPkg, this.mUid);
        OLog.i(this.TAG, "getEnabledFlag.... fixed: " + r5);
        if (r0 == false) goto L21;
        if (r4 == false) goto L21;
        if (r5 == true) goto L21;
    L22:
        OLog.i(this.TAG, "getEnabledFlag....enabledFlag :" + r1);
        return r1;
    L21:
        r1 = false;
        goto L22
    L13:
        if (r2.lockedImportance == true) goto L15;
        r4 = true;
        goto L16
    L5:
        if (r2.systemApp == true) goto L7;
    L9:
        r3 = false;
        goto L11
    L7:
        if (r2.banned == false) goto L9;
        goto L9
    }

    private boolean getLockscreenNotificationsEnabled() {
        UserInfo r0 = this.mUm.getProfileParent(UserHandle.myUserId());
        if (r0 == null) goto L5;
        int r1 = r0.id;
    L7:
        if (Settings.Secure.getIntForUser(this.mContext.getContentResolver(), "lock_screen_show_notifications", 0, r1) == 0) goto L10;
        return true;
    L10:
        return false;
    L5:
        r1 = UserHandle.myUserId();
        goto L7
    }

    private boolean getLockscreenAllowPrivateNotifications() {
        if (Settings.Secure.getInt(this.mContext.getContentResolver(), "lock_screen_allow_private_notifications", 0) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    protected boolean isLockScreenSecure() {
        boolean r0 = this.mLockPatternUtils.isSecure(UserHandle.myUserId());
        UserInfo r1 = this.mUm.getProfileParent(UserHandle.myUserId());
        if (r1 != null) goto L5;
        return r0;
    L5:
        return r0 | this.mLockPatternUtils.isSecure(r1.id);
    }

    private int getGlobalVisibility() {
        if (getLockscreenNotificationsEnabled() == true) goto L6;
        return -1;
    L6:
        if (getLockscreenAllowPrivateNotifications() == true) goto L8;
        return 0;
    L8:
        return -1000;
    }

    private int getCurVisibility() {
        if (this.mChannel.getLockscreenVisibility() != (-1000)) goto L7;
        return getGlobalVisibility();
    L7:
        return this.mChannel.getLockscreenVisibility();
    }

    private void showLockVisibleMenu(View r9) {
        if (this.mChannel == null) goto L28;
        if (r9 == null) goto L29;
        final ArrayList r0 = new ArrayList();
        final ArrayList r1 = new ArrayList();
        boolean r3 = true;
        if (getLockscreenNotificationsEnabled() == false) goto L16;
        if (getLockscreenAllowPrivateNotifications() == false) goto L16;
        String r2 = this.mContext.getString(R.string.lock_screen_notifications_summary_show);
        r1.add(-1000);
        if ((-1000) != getCurVisibility()) goto L13;
        boolean r5 = true;
    L14:
        r0.add(new Item(r2, r5));
        goto L16
    L13:
        r5 = false;
    L16:
        if (getLockscreenNotificationsEnabled() == false) goto L22;
        String r4 = this.mContext.getString(R.string.lock_screen_notifications_summary_hide);
        r1.add(0);
        if (getCurVisibility() != 0) goto L20;
        boolean r6 = true;
    L21:
        r0.add(new Item(r4, r6));
        goto L22
    L20:
        r6 = false;
    L22:
        r1.add(-1);
        String r7 = this.mContext.getString(R.string.lock_screen_notifications_summary_disable);
        if ((-1) == getCurVisibility()) goto L26;
        r3 = false;
    L26:
        r0.add(new Item(r7, r3));
        this.mLockVisiblePopover = OPopoverHelper.showPopoverList(this._mActivity, r9, r0, new ChannelNotificationSettings$$ExternalSyntheticLambda1(this, r1, r0));
        return;
    L29:
        return;
    }

    /* JADX INFO: renamed from: lambda$showLockVisibleMenu$1$com-android-settings-notification-ChannelNotificationSettings, reason: not valid java name */
    /* synthetic */ void m522xf65a5ee4(List r1, List r2, View r3, int r4) {
        int r5 = ((Integer) r1.get(r4)).intValue();
        if (r5 != getGlobalVisibility()) goto L5;
        r5 = -1000;
    L5:
        this.mChannel.setLockscreenVisibility(r5);
        this.mChannel.lockFields(2);
        saveChannel();
        OPopover r6 = this.mLockVisiblePopover;
        if (r6 == null) goto L8;
        r6.dismiss();
    L8:
        OCardListItemUtils.setCustomEndTipTextView(this.mLockVisible, ((Item) r2.get(r4)).getTitle());
    }

    protected void saveChannel() {
        if (this.mChannel == null) goto L8;
        NotificationBackend.AppRow r0 = this.mAppRow;
        if (r0 == null) goto L9;
        this.mBackend.updateChannel(r0.pkg, this.mAppRow.uid, this.mChannel);
        return;
    L9:
        return;
    }

    private String getLockscreenVisibilitySummary() {
        if (this.mChannel != null) goto L6;
        return "";
    L6:
        int r0 = getCurVisibility();
        if (getLockscreenNotificationsEnabled() == false) goto L15;
        if (getLockscreenAllowPrivateNotifications() == false) goto L15;
        if (r0 != (-1000)) goto L15;
        return this.mContext.getString(R.string.lock_screen_notifications_summary_show);
    L15:
        if (getLockscreenNotificationsEnabled() == false) goto L20;
        if (r0 != 0) goto L20;
        return this.mContext.getString(R.string.lock_screen_notifications_summary_hide);
    L20:
        return this.mContext.getString(R.string.lock_screen_notifications_summary_disable);
    }

    private void updateLockVisible() {
        OCardListItem r0 = this.mLockVisible;
        if (r0 == null) goto L6;
        OCardListItemUtils.setCustomEndTipTextView(r0, getLockscreenVisibilitySummary());
        return;
    }

    private boolean isPkgAllNotificationSilent(String r4, int r5) {
        OLog.i(this.TAG, "isPkgAllNotificationSilent pkg: " + r4 + ", uid: " + r5);
        return INotificationManager.Stub.asInterface(ServiceManager.getService("notification")).isPkgAllNotificationSilent(r4, r5);
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.e(this.TAG, "isPkgAllNotificationSilent err: " + e);
        return false;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateSwitchStatus();
    }

    private PackageInfo findPackageInfo(String r8, int r9) {
        if (r8 == null) goto L18;
        if (r9 < 0) goto L18;
        String[] r10 = this.mPm.getPackagesForUid(r9);
        if (r10 == null) goto L18;
        if (r8 == null) goto L18;
        int r1 = r10.length;
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L18;
        if (r8.equals(r10[r2]) == false) goto L17;
        return this.mPm.getPackageInfo(r8, 4160);
    L15:
        e = move-exception;
        OLog.w(this.TAG, "Failed to load package " + r8, e);
    L17:
        r2 = r2 + 1;
    L18:
        return null;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (interceptRiskControlledNotificationSwitch(r4, r5) == false) goto L5;
        return;
    L5:
        int r1 = 3;
        if (r4 != OCardListItemUtils.getSwitchView(this.mEnabledSwitch)) goto L16;
        NotificationChannel r6 = this.mChannel;
        if (r6 == null) goto L33;
        if (r5 == true) goto L11;
        r6.setImportance(0);
        this.mChannel.lockFields(4);
        this.mBackend.updateChannel(this.mPkg, this.mUid, this.mChannel);
    L14:
        updateSwitchStatus(r5);
        return;
    L11:
        if (r6.getImportance() != 0) goto L14;
        this.mChannel.setImportance(3);
        this.mChannel.lockFields(4);
        this.mBackend.updateChannel(this.mPkg, this.mUid, this.mChannel);
        goto L14
    L33:
        return;
    L16:
        if (r4 != OCardListItemUtils.getSwitchView(this.mVibrateSwitch)) goto L21;
        NotificationChannel r7 = this.mChannel;
        if (r7 == null) goto L35;
        r7.enableVibration(r5);
        this.mChannel.lockFields(16);
        this.mBackend.updateChannel(this.mPkg, this.mUid, this.mChannel);
        return;
    L35:
        return;
    L21:
        if (r4 != OCardListItemUtils.getSwitchView(this.mRingtoneSwitch)) goto L26;
        if (this.mChannel == null) goto L37;
        OLog.w(this.TAG, this.mPkg + " getSound: " + this.mChannel.getSound());
        NotificationChannelSmt.getInstance().setSoundEnabled(this.mChannel, r5);
        this.mChannel.lockFields(32);
        this.mBackend.updateChannel(this.mPkg, this.mUid, this.mChannel);
        return;
    L37:
        return;
    L26:
        if (r4 != OCardListItemUtils.getSwitchView(this.mFloatingSwitch)) goto L39;
        NotificationChannel r8 = this.mChannel;
        if (r8 == null) goto L40;
        if (r5 == false) goto L31;
        r1 = 4;
    L31:
        r8.setImportance(r1);
        this.mChannel.lockFields(4);
        this.mBackend.updateChannel(this.mPkg, this.mUid, this.mChannel);
        return;
    L40:
        return;
    }

    private void setNotificationSwitchTouchInterceptor(OCardListItem r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (OCardListItemUtils.getSwitchView(r2) == null) goto L9;
        OCardListItemUtils.getSwitchView(r2).setOnTouchListener(new ChannelNotificationSettings$$ExternalSyntheticLambda2(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$setNotificationSwitchTouchInterceptor$2$com-android-settings-notification-ChannelNotificationSettings, reason: not valid java name */
    /* synthetic */ boolean m521x8fb3c9e3(View r3, MotionEvent r4) {
        return RiskPermissionControlGuard.interceptOnActionUp(getActivity(), this.mPkg, UserHandle.getUserId(this.mUid), 64, r4);
    }

    private boolean interceptRiskControlledNotificationSwitch(CompoundButton r5, boolean r6) {
        OCardListItem r7 = getNotificationSwitchItem(r5);
        if (r7 != null) goto L5;
        return false;
    L5:
        if (RiskPermissionControlGuard.intercept(getActivity(), this.mPkg, UserHandle.getUserId(this.mUid), 64) == false) goto L11;
        OCardListItemUtils.setOnCheckedChangeListener(r7, null);
        OCardListItemUtils.setChecked(r7, !r6);
        OCardListItemUtils.setOnCheckedChangeListener(r7, this);
        return true;
    L11:
        return false;
    }

    private OCardListItem getNotificationSwitchItem(CompoundButton r2) {
        if (r2 != OCardListItemUtils.getSwitchView(this.mEnabledSwitch)) goto L7;
        return this.mEnabledSwitch;
    L7:
        if (r2 != OCardListItemUtils.getSwitchView(this.mFloatingSwitch)) goto L11;
        return this.mFloatingSwitch;
    L11:
        if (r2 != OCardListItemUtils.getSwitchView(this.mVibrateSwitch)) goto L15;
        return this.mVibrateSwitch;
    L15:
        if (r2 == OCardListItemUtils.getSwitchView(this.mRingtoneSwitch)) goto L17;
        return null;
    L17:
        return this.mRingtoneSwitch;
    }

    private boolean isDefaultChannel() {
        NotificationChannel r1 = this.mChannel;
        if (r1 != null) goto L7;
        return false;
    L7:
        return Objects.equals(NotificationChannelCompat.DEFAULT_CHANNEL_ID, r1.getId());
    }

    private boolean isFloatingEnabled() {
        if (this.mChannel != null) goto L6;
        return false;
    L6:
        if (isDefaultChannel() == false) goto L9;
        return false;
    L9:
        if (this.mChannel.getImportance() < 3) goto L12;
        return true;
    L12:
        return false;
    }

    private void updateSwitchStatus() {
        NotificationChannel r0 = this.mChannel;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getImportance() == 0) goto L7;
        boolean r1 = true;
    L8:
        OCardListItemUtils.setChecked(this.mEnabledSwitch, r1);
        OCardListItemUtils.setEnabled(this.mEnabledSwitch, this.mEnableFlags);
        updateSwitchStatus(r1);
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void updateSwitchStatus(boolean r8) {
        if (this.mChannel != null) goto L5;
        return;
    L5:
        int r0 = 8;
        if (r8 == false) goto L8;
        this.mSelectionTitle.setVisibility(0);
    L9:
        OCardListItem r2 = this.mFloatingSwitch;
        boolean r4 = true;
        if (r2 == null) goto L29;
        if (r8 == false) goto L13;
        r2.setVisibility(0);
    L14:
        OCardListItem r3 = this.mFloatingSwitch;
        if (r8 == true) goto L17;
    L19:
        boolean r5 = false;
    L20:
        OCardListItemUtils.setEnabled(r3, r5);
        OCardListItemUtils.setOnCheckedChangeListener(this.mFloatingSwitch, null);
        if (r8 == false) goto L27;
        OCardListItem r6 = this.mFloatingSwitch;
        if (this.mChannel.getImportance() < 4) goto L25;
        boolean r7 = true;
    L26:
        OCardListItemUtils.setChecked(r6, r7);
    L28:
        OCardListItemUtils.setOnCheckedChangeListener(this.mFloatingSwitch, this);
        goto L29
    L25:
        r7 = false;
        goto L26
    L27:
        OCardListItemUtils.setChecked(this.mFloatingSwitch, false);
        goto L28
    L17:
        if (this.mEnableFlags == false) goto L19;
        r5 = true;
        goto L20
    L13:
        r2.setVisibility(8);
    L29:
        boolean r9 = isDefaultChannel();
        if (isPkgAllNotificationSilent(this.mPkg, this.mUid) == true) goto L34;
        if (r9 == true) goto L34;
        r4 = false;
    L34:
        OCardListItem r10 = this.mVibrateSwitch;
        if (r10 == null) goto L47;
        if (r8 == false) goto L41;
        if (r4 == false) goto L39;
        int r11 = 8;
    L40:
        r10.setVisibility(r11);
    L42:
        OCardListItemUtils.setEnabled(this.mVibrateSwitch, r8);
        OCardListItemUtils.setOnCheckedChangeListener(this.mVibrateSwitch, null);
        if (r8 == false) goto L45;
        OCardListItemUtils.setChecked(this.mVibrateSwitch, this.mChannel.shouldVibrate());
    L46:
        OCardListItemUtils.setOnCheckedChangeListener(this.mVibrateSwitch, this);
        goto L47
    L45:
        OCardListItemUtils.setChecked(this.mVibrateSwitch, false);
        goto L46
    L39:
        r11 = 0;
        goto L40
    L41:
        r10.setVisibility(8);
    L47:
        OCardListItem r12 = this.mRingtoneSwitch;
        if (r12 == null) goto L60;
        if (r8 == false) goto L54;
        if (r4 == true) goto L53;
        r0 = 0;
    L53:
        r12.setVisibility(r0);
    L55:
        OCardListItemUtils.setEnabled(this.mRingtoneSwitch, r8);
        OCardListItemUtils.setOnCheckedChangeListener(this.mRingtoneSwitch, null);
        if (r8 == false) goto L58;
        OCardListItemUtils.setChecked(this.mRingtoneSwitch, NotificationChannelSmt.getInstance().getSoundEnabled(this.mChannel));
    L59:
        OCardListItemUtils.setOnCheckedChangeListener(this.mRingtoneSwitch, this);
        goto L60
    L58:
        OCardListItemUtils.setChecked(this.mRingtoneSwitch, false);
        goto L59
    L54:
        r12.setVisibility(8);
    L60:
        OCardListItemUtils.updateGroupContainer(this.mAllSwitches);
        return;
    L8:
        this.mSelectionTitle.setVisibility(8);
        goto L9
    }

    private void startListeningToPackageRemove() {
        if (this.mListeningToPackageRemove == false) goto L5;
        return;
    L5:
        this.mListeningToPackageRemove = true;
        IntentFilter r0 = new IntentFilter("android.intent.action.PACKAGE_REMOVED");
        r0.addDataScheme("package");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getContext(), this.mPackageRemovedReceiver, r0, 2);
    }

    private void stopListeningToPackageRemove() {
        if (this.mListeningToPackageRemove == true) goto L5;
        return;
    L5:
        this.mListeningToPackageRemove = false;
        getContext().unregisterReceiver(this.mPackageRemovedReceiver);
    }

    private void onPackageRemoved() {
        getActivity().finishAndRemoveTask();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        stopListeningToPackageRemove();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChannelNotificationSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_ChannelNotificationSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChannelNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_ChannelNotificationSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChannelNotificationSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_ChannelNotificationSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
