package com.android.settings;

import android.app.INotificationManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationChannelCompat;
import bytedanceos.api.NotificationChannelSmt;
import bytedanceos.api.SmtOpsManagerSmt;
import com.GlobalProxyLancet;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.notification.NotificationBackend;
import com.android.settings.riskcontrol.RiskPermissionControlGuard;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.AppCustomConfig;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationDetailsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String ANDROID_PROVIDER_EXTRA_APP_PACKAGE = "android.provider.extra.APP_PACKAGE";
    private static final String DEFAULT_DISABLE_SMART_NOTIFICATION_APP = "com.tencent.mm,com.ss.android.lark";
    private static final String DISABLE_SMART_NOTIFICATION = "smart_notification_disable_packages";
    private static final String HIGH_PRIORITY_NOTIFICATION = "high_priority_notification";
    private static final String KEY_NOTIFICATION_HEADS_UP = "notification_heads_up";
    private static final String NOTIFICATION_REDUCTION_MODE = "notification_reduction_mode";
    private static final String TAG = "NotificationDetailsFg";
    public static final String TELECOM_PACKAGE_NAME = "com.android.server.telecom";
    private List<NotificationChannel> mAllChannels;
    private List<NotificationChannelGroup> mAllGroups;
    private OCardListItem mAllowSmartNotification;
    private ApplicationInfo mAppInfo;
    private NotificationBackend.AppRow mAppRow;
    private int mAppUid;
    private NotificationBackend mBackend;
    private NotificationChannel mChannel;
    private Comparator<NotificationChannel> mChannelComparator;
    private LinearLayout mChannelContainer;
    private Comparator<NotificationChannelGroup> mChannelGroupComparator;
    private View mChannelView;
    private LinearLayout mContainer;
    private Context mContext;
    private OCardListItem mDefaltRingTitleSwitch;
    private OCardListItem mDefaltVibrateSwitch;
    private boolean mEnabledFlag;
    private OCardListItem mEnabledSwitch;
    private boolean mIsChanged;
    private String mKeyAppPopupDialogSetting;
    private OCardListItem mLightenSwitch;
    private boolean mListeningToPackageRemove;
    private View mMoreTitle;
    private View mNotificationDetailGapView;
    private OCardListItem mNotificationHeadsUp;
    private OCardListItem mNotificationShowDetail;
    private final BroadcastReceiver mPackageRemovedReceiver;
    private String mPackagesStr;
    private String mPkg;
    private PackageInfo mPkgInfo;
    private PackageManager mPm;
    private OCardListItem mPopUpDialogInLockScreen;
    private List<String> mPopUpDialogPkgs;
    private boolean mShowLegacyChannelConfig;
    private OCardListItem mSilentSwitch;
    private SmtOpsManagerSmt mSmtOps;
    private String mTargetPkgName;
    private int mUid;

    public void com_android_settings_NotificationDetailsFragment__onResume$___twin___() {
        super.onResume();
    }

    public boolean isDefaultTopPadding() {
        return false;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NotificationDetailsFragment() {
        this.mBackend = new NotificationBackend();
        this.mShowLegacyChannelConfig = false;
        this.mAllChannels = new ArrayList();
        this.mAllGroups = new ArrayList();
        this.mEnabledFlag = false;
        this.mPackageRemovedReceiver = new AnonymousClass4(this);
        this.mChannelGroupComparator = new AnonymousClass8(this);
        this.mChannelComparator = new AnonymousClass9(this);
    }

    static /* synthetic */ String access$000(NotificationDetailsFragment r0) {
        return r0.mPkg;
    }

    static /* synthetic */ int access$100(NotificationDetailsFragment r0) {
        return r0.mUid;
    }

    static /* synthetic */ PackageInfo access$1000(NotificationDetailsFragment r0) {
        return r0.mPkgInfo;
    }

    static /* synthetic */ void access$1100(NotificationDetailsFragment r0) {
        r0.onPackageRemoved();
    }

    static /* synthetic */ String access$1200(NotificationDetailsFragment r0) {
        return r0.mTargetPkgName;
    }

    static /* synthetic */ int access$1300(NotificationDetailsFragment r0) {
        return r0.mAppUid;
    }

    static /* synthetic */ NotificationBackend.AppRow access$1400(NotificationDetailsFragment r0) {
        return r0.mAppRow;
    }

    static /* synthetic */ ApplicationInfo access$1500(NotificationDetailsFragment r0) {
        return r0.mAppInfo;
    }

    static /* synthetic */ boolean access$1600(NotificationDetailsFragment r0) {
        return r0.mEnabledFlag;
    }

    static /* synthetic */ NotificationBackend access$200(NotificationDetailsFragment r0) {
        return r0.mBackend;
    }

    static /* synthetic */ Comparator access$300(NotificationDetailsFragment r0) {
        return r0.mChannelGroupComparator;
    }

    static /* synthetic */ List access$400(NotificationDetailsFragment r0) {
        return r0.mAllGroups;
    }

    static /* synthetic */ Comparator access$500(NotificationDetailsFragment r0) {
        return r0.mChannelComparator;
    }

    static /* synthetic */ List access$600(NotificationDetailsFragment r0) {
        return r0.mAllChannels;
    }

    static /* synthetic */ void access$700(NotificationDetailsFragment r0) {
        r0.updateCategorys();
    }

    static /* synthetic */ OCardListItem access$800(NotificationDetailsFragment r0) {
        return r0.mAllowSmartNotification;
    }

    static /* synthetic */ void access$900(NotificationDetailsFragment r0, boolean r1) {
        r0.setSmartNotificationAppEnabled(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.notification_details, r3, false);
        this.mSmtOps = SmtOpsManagerSmt.getInstance();
        this.mDefaltRingTitleSwitch = (OCardListItem) findViewByIdNullable(R.id.notification_ringtone_title);
        this.mDefaltVibrateSwitch = (OCardListItem) findViewByIdNullable(R.id.notification_ringtone_vibrate);
        this.mEnabledSwitch = (OCardListItem) findViewByIdNullable(R.id.notification_enabled);
        this.mContainer = (LinearLayout) findViewByIdNullable(R.id.items_container);
        this.mNotificationShowDetail = (OCardListItem) findViewByIdNullable(R.id.notification_detail);
        this.mSilentSwitch = (OCardListItem) findViewByIdNullable(R.id.notification_silent);
        this.mLightenSwitch = (OCardListItem) findViewByIdNullable(R.id.switch_lighten_screen);
        this.mAllowSmartNotification = (OCardListItem) findViewByIdNullable(R.id.allow_smart_notification);
        this.mPopUpDialogInLockScreen = (OCardListItem) findViewByIdNullable(R.id.pop_up_dialog_notification);
        this.mNotificationHeadsUp = (OCardListItem) findViewByIdNullable(R.id.switch_heads_up);
        this.mNotificationDetailGapView = findViewByIdNullable(R.id.notification_detail_gap_view);
        this.mChannelView = findViewByIdNullable(R.id.channel_settings);
        this.mMoreTitle = findViewByIdNullable(R.id.notification_more_text);
        ApplicationInfo r5 = this.mAppInfo;
        if (r5 == null) goto L5;
        this.mTargetPkgName = r5.packageName;
        this.mAppUid = this.mAppInfo.uid;
    L5:
        OLog.d(TAG, "mTargetPkgName " + this.mTargetPkgName + ", mAppUid " + this.mAppUid);
        this.mKeyAppPopupDialogSetting = "pop_up_dialog_in_lock_screen_" + this.mTargetPkgName + ":" + UserHandle.getUserId(this.mAppUid);
        this.mPopUpDialogPkgs = Arrays.asList(this.mContext.getResources().getStringArray(R.array.pop_up_dialog_package_list));
        if (getArguments().getBoolean("from_app_detail", false) == false) goto L8;
        Utils.setAppLabelAndIconViews(this.mRootView, this.mAppInfo.packageName, this.mAppInfo.uid);
        findViewByIdNullable(R.id.page_container).setPadding(0, 0, 0, 0);
    L9:
        this.mChannelContainer = (LinearLayout) findViewByIdNullable(R.id.listView);
        this.mNotificationShowDetail.setOnContentClickListener(this);
        setNotificationSwitchTouchInterceptor(this.mNotificationHeadsUp);
        if (this.mIsLandScreen == false) goto L15;
        if (this.mIsExtDisplaying == false) goto L15;
        ((TextView) findViewByIdNullable(R.id.notification_tips)).setText(R.string.notification_tips_landscape);
    L15:
        return this.mRootView;
    L8:
        findViewByIdNullable(R.id.app_snippet).setVisibility(8);
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        UIUtils.fitMaskTitle(this);
        ApplicationInfo r5 = this.mAppInfo;
        if (r5 == null) goto L6;
        setTitle(r5.loadLabel(getPackageManager()));
    L6:
        if (this.mUid >= 0) goto L8;
    L14:
        OLog.w(TAG, "Missing package or uid or packageinfo");
        finish();
        return;
    L8:
        if (TextUtils.isEmpty(this.mPkg) == true) goto L14;
        PackageInfo r6 = this.mPkgInfo;
        if (r6 == null) goto L14;
        NotificationBackend.AppRow r7 = this.mBackend.loadAppRow(this.mContext, this.mPm, r6);
        this.mAppRow = r7;
        this.mShowLegacyChannelConfig = this.mBackend.onlyHasDefaultChannel(r7.pkg, this.mAppRow.uid);
    }

    private void setLargeScreenViewVisibility() {
        this.mLightenSwitch.setVisibility(8);
        this.mNotificationShowDetail.setVisibility(8);
        this.mDefaltVibrateSwitch.setVisibility(8);
        this.mPopUpDialogInLockScreen.setVisibility(8);
        this.mNotificationDetailGapView.setVisibility(8);
        if ("com.android.server.telecom".equals(this.mTargetPkgName) == false) goto L5;
        this.mNotificationHeadsUp.setVisibility(8);
        return;
    L5:
        this.mNotificationHeadsUp.setVisibility(0);
        this.mMoreTitle.setVisibility(0);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [com.android.settings.NotificationDetailsFragment$1] */
    private void updateViews() {
        boolean r0 = !NotificationSettingsFragment.isAllNotificationsDisabled(this.mContext);
        OLog.d(TAG, "updateViews....isEnableAll :" + r0);
        NotificationHelper.AppRow r2 = new NotificationHelper.AppRow();
        NotificationHelper.getInstance().recordCanBeBlocked(this.mPkgInfo, r2);
        boolean r4 = NotificationHelper.getInstance().areNotificationsEnabledForPackage(this.mTargetPkgName, this.mAppUid);
        r2.banned = !r4;
        if (r2.systemApp == true) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
    L15:
        boolean r6 = false;
    L16:
        OLog.i(TAG, "updateViews....systemApp :" + r2.systemApp + ", lockedImportance: " + r2.lockedImportance);
        boolean r3 = NotificationHelper.notificationPermissionFixed(this.mContext, this.mTargetPkgName, this.mAppUid);
        OLog.i(TAG, "updateViews.... fixed: " + r3);
        if (r0 == false) goto L21;
        if (r6 == false) goto L21;
        if (r3 == true) goto L21;
        boolean r7 = true;
    L22:
        OCardListItemUtils.setChecked(this.mEnabledSwitch, r7);
        LinearLayout r8 = this.mContainer;
        int r9 = 8;
        if (r7 == false) goto L25;
        int r10 = 0;
    L26:
        r8.setVisibility(r10);
        OCardListItemUtils.setEnabled(this.mEnabledSwitch, r7);
        this.mEnabledFlag = r7;
        OLog.i(TAG, "updateViews....mTargetPkgName :" + this.mTargetPkgName);
        OLog.i(TAG, "updateViews....mAppUid :" + this.mAppUid);
        OLog.i(TAG, "updateViews....enabled :" + r4);
        if (this.mSmtOps.checkOpNoThrow(this.mContext, 25, this.mAppUid, this.mTargetPkgName) != 0) goto L29;
        boolean r11 = true;
    L30:
        OLog.d(TAG, "updateViews....lightenScreen :" + r11);
        if (this.mSmtOps.checkOpNoThrow(this.mContext, 26, this.mAppUid, this.mTargetPkgName) != 0) goto L33;
        boolean r12 = true;
    L34:
        OLog.d(TAG, "updateViews....topLocated :" + r12);
        OCardListItemUtils.setChecked(this.mSilentSwitch, isPkgAllNotificationSilent(this.mPkg, this.mUid));
        OCardListItemUtils.setChecked(this.mEnabledSwitch, r4);
        LinearLayout r13 = this.mContainer;
        if (r4 == false) goto L37;
        r9 = 0;
    L37:
        r13.setVisibility(r9);
        OCardListItemUtils.setChecked(this.mLightenSwitch, r11);
        if (r4 == false) goto L42;
        if (r0 == false) goto L42;
        if (r6 == false) goto L42;
        boolean r1 = true;
    L43:
        updateWidgetEnable(r1);
        OCardListItemUtils.setChecked(this.mAllowSmartNotification, isSmartNotificationAppEnabled());
        NotificationChannel r14 = this.mChannel;
        if (r14 == null) goto L47;
        OCardListItemUtils.setChecked(this.mDefaltVibrateSwitch, r14.shouldVibrate());
    L47:
        if (this.mPopUpDialogPkgs.contains(this.mTargetPkgName) == false) goto L53;
        OCardListItem r15 = this.mPopUpDialogInLockScreen;
        if (android.provider.Settings.Global.getInt(getContentResolver(), this.mKeyAppPopupDialogSetting, 1) != 1) goto L51;
        boolean r16 = true;
    L52:
        OCardListItemUtils.setChecked(r15, r16);
        goto L53
    L51:
        r16 = false;
    L53:
        int r17 = NotificationHelper.getInstance().getNotificationsVisibilityForPackage(this.mTargetPkgName, this.mAppUid);
        OCardListItem r18 = this.mNotificationShowDetail;
        Resources r19 = getResources();
        if (r17 != 1) goto L56;
        int r20 = R.string.always_show;
    L57:
        OCardListItemUtils.setSubTitleString(r18, r19.getString(r20));
        registerSwitcherListener(this);
        if (Utils.isPackageInstalled(this.mContext, this.mTargetPkgName) == true) goto L61;
        finish();
    L61:
        if (this.mIsLandScreen == false) goto L66;
        if (this.mIsExtDisplaying == false) goto L66;
        setLargeScreenViewVisibility();
    L66:
        if ("com.android.contacts".equals(this.mPkg) == true) goto L69;
        new AnonymousClass1(this).execute(new Void[0]);
        return;
    L69:
        return;
    L56:
        r20 = R.string.display_after_unlocking;
    L42:
        r1 = false;
        goto L43
    L33:
        r12 = false;
        goto L34
    L29:
        r11 = false;
        goto L30
    L25:
        r10 = 8;
    L21:
        r7 = false;
        goto L22
    L13:
        if (r2.lockedImportance == true) goto L15;
        r6 = true;
        goto L16
    L5:
        if (r2.systemApp == true) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (r2.banned == false) goto L9;
        goto L9
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void setPkgAllNotificationSilent(String r2, int r3, boolean r4) {
        OLog.i(TAG, "setPkgAllNotificationSilent pkg: " + r2 + ", uid: " + r3 + ", allSilent=" + r4);
        INotificationManager.Stub.asInterface(ServiceManager.getService("notification")).setPkgAllNotificationSilent(r2, r3, r4);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "setPkgAllNotificationSilent err: " + e);
    }

    public boolean isPkgAllNotificationSilent(String r2, int r3) {
        OLog.i(TAG, "isPkgAllNotificationSilent pkg: " + r2 + ", uid: " + r3);
        return INotificationManager.Stub.asInterface(ServiceManager.getService("notification")).isPkgAllNotificationSilent(r2, r3);
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "isPkgAllNotificationSilent err: " + e);
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r14, boolean r15) {
        if (interceptRiskControlledNotificationSwitch(r14, r15) == false) goto L5;
        return;
    L5:
        this.mIsChanged = true;
        int r6 = 0;
        if (r14 != OCardListItemUtils.getSwitchView(this.mEnabledSwitch)) goto L13;
        LinearLayout r16 = this.mContainer;
        if (r15 == true) goto L11;
        r6 = 8;
    L11:
        r16.setVisibility(r6);
        NotificationHelper.getInstance().setNotificationsEnabledForPackage(this.mTargetPkgName, this.mAppUid, r15);
        updateWidgetEnable(r15);
        HashMap r17 = new HashMap();
        r17.put("scene", "switch_event_for_notification");
        r17.put("is_enabled", Boolean.valueOf(r15));
        r17.put("package", this.mTargetPkgName);
        TrackerEvent.uploadEvent("switch_event_for_package", r17);
        return;
    L13:
        if (r14 != OCardListItemUtils.getSwitchView(this.mLightenSwitch)) goto L16;
        SmtOpsManagerSmt.getInstance().setMode(this.mContext, 25, this.mAppUid, this.mTargetPkgName, !r15 ? 1 : 0);
        return;
    L16:
        if (r14 != OCardListItemUtils.getSwitchView(this.mAllowSmartNotification)) goto L21;
        if (r15 == false) goto L19;
        OCardListItemUtils.setChecked(this.mAllowSmartNotification, false);
        new OAlertDialogBuilder(this._mActivity).autoDismiss(false).horizontalButton().title(R.string.notification_allow_smart_notification_title).message(getString(R.string.notification_allow_smart_notification_tip)).negativeButton(android.R.string.cancel, new AnonymousClass3(this)).positiveButton(android.R.string.ok, new AnonymousClass2(this)).show();
        return;
    L19:
        setSmartNotificationAppEnabled(false);
        return;
    L21:
        if (r14 != OCardListItemUtils.getSwitchView(this.mPopUpDialogInLockScreen)) goto L24;
        android.provider.Settings.Global.putInt(getContentResolver(), this.mKeyAppPopupDialogSetting, r15 ? 1 : 0);
        return;
    L24:
        if (r14 != OCardListItemUtils.getSwitchView(this.mDefaltVibrateSwitch)) goto L29;
        NotificationChannel r18 = this.mChannel;
        if (r18 == null) goto L45;
        r18.enableVibration(r15);
        this.mChannel.lockFields(16);
        this.mBackend.updateChannel(this.mTargetPkgName, this.mAppUid, this.mChannel);
        return;
    L45:
        return;
    L29:
        if (r14 != OCardListItemUtils.getSwitchView(this.mDefaltRingTitleSwitch)) goto L34;
        if (this.mChannel == null) goto L47;
        NotificationChannelSmt.getInstance().setSoundEnabled(this.mChannel, r15);
        this.mChannel.lockFields(32);
        this.mBackend.updateChannel(this.mTargetPkgName, this.mAppUid, this.mChannel);
        return;
    L47:
        return;
    L34:
        if (r14 != OCardListItemUtils.getSwitchView(this.mNotificationHeadsUp)) goto L37;
        AppCustomConfig.setInteger(getContext(), this.mTargetPkgName, "notification_heads_up", Integer.valueOf(r15 ? 1 : 0));
        return;
    L37:
        if (r14 != OCardListItemUtils.getSwitchView(this.mSilentSwitch)) goto L50;
        OLog.i(TAG, "mSilentSwitch checked=" + r15);
        setPkgAllNotificationSilent(this.mPkg, this.mUid, r15);
        HashMap r19 = new HashMap();
        r19.put("scene", "switch_event_for_notification_silent");
        r19.put("is_enabled", Boolean.valueOf(r15));
        r19.put("package", this.mTargetPkgName);
        TrackerEvent.uploadEvent("switch_event_for_package", r19);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.mIsChanged == false) goto L5;
        Utils.notifyNotificationSettingsChanged(this.mContext);
    L5:
        stopListeningToPackageRemove();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        if (r3.getId() != R.id.notification_detail) goto L7;
        Intent r4 = new Intent(this.mContext, NotificationDisplayDetailsActivity.class);
        r4.putExtra(NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, this.mTargetPkgName);
        r4.putExtra(NotificationDisplayDetailsActivity.EXTRA_APP_UID, this.mAppUid);
        Utils.startActivity(this._mActivity, r4);
        return;
    }

    private void registerSwitcherListener(CompoundButton.OnCheckedChangeListener r2) {
        OCardListItemUtils.setOnCheckedChangeListener(this.mEnabledSwitch, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mSilentSwitch, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mLightenSwitch, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mAllowSmartNotification, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mPopUpDialogInLockScreen, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mDefaltRingTitleSwitch, r2);
        OCardListItemUtils.setOnCheckedChangeListener(this.mDefaltVibrateSwitch, r2);
        registerSwitcherTouchInterceptors();
    }

    private void registerSwitcherTouchInterceptors() {
        setNotificationSwitchTouchInterceptor(this.mEnabledSwitch);
        setNotificationSwitchTouchInterceptor(this.mSilentSwitch);
        setNotificationSwitchTouchInterceptor(this.mLightenSwitch);
        setNotificationSwitchTouchInterceptor(this.mAllowSmartNotification);
        setNotificationSwitchTouchInterceptor(this.mPopUpDialogInLockScreen);
        setNotificationSwitchTouchInterceptor(this.mDefaltRingTitleSwitch);
        setNotificationSwitchTouchInterceptor(this.mDefaltVibrateSwitch);
        setNotificationSwitchTouchInterceptor(this.mNotificationHeadsUp);
    }

    private void setNotificationSwitchTouchInterceptor(OCardListItem r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (OCardListItemUtils.getSwitchView(r2) == null) goto L9;
        OCardListItemUtils.getSwitchView(r2).setOnTouchListener(new NotificationDetailsFragment$$ExternalSyntheticLambda0(this));
        return;
    }

    /* JADX INFO: renamed from: lambda$setNotificationSwitchTouchInterceptor$0$com-android-settings-NotificationDetailsFragment, reason: not valid java name */
    /* synthetic */ boolean m177xd3219155(View r3, MotionEvent r4) {
        return RiskPermissionControlGuard.interceptOnActionUp(this._mActivity, this.mTargetPkgName, UserHandle.getUserId(this.mAppUid), 64, r4);
    }

    private boolean interceptRiskControlledNotificationSwitch(CompoundButton r5, boolean r6) {
        OCardListItem r7 = getNotificationSwitchItem(r5);
        if (r7 != null) goto L5;
        return false;
    L5:
        if (RiskPermissionControlGuard.intercept(this._mActivity, this.mTargetPkgName, UserHandle.getUserId(this.mAppUid), 64) == false) goto L11;
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
        if (r2 != OCardListItemUtils.getSwitchView(this.mSilentSwitch)) goto L11;
        return this.mSilentSwitch;
    L11:
        if (r2 != OCardListItemUtils.getSwitchView(this.mLightenSwitch)) goto L15;
        return this.mLightenSwitch;
    L15:
        if (r2 != OCardListItemUtils.getSwitchView(this.mAllowSmartNotification)) goto L19;
        return this.mAllowSmartNotification;
    L19:
        if (r2 != OCardListItemUtils.getSwitchView(this.mPopUpDialogInLockScreen)) goto L23;
        return this.mPopUpDialogInLockScreen;
    L23:
        if (r2 != OCardListItemUtils.getSwitchView(this.mDefaltRingTitleSwitch)) goto L27;
        return this.mDefaltRingTitleSwitch;
    L27:
        if (r2 != OCardListItemUtils.getSwitchView(this.mDefaltVibrateSwitch)) goto L31;
        return this.mDefaltVibrateSwitch;
    L31:
        if (r2 == OCardListItemUtils.getSwitchView(this.mNotificationHeadsUp)) goto L33;
        return null;
    L33:
        return this.mNotificationHeadsUp;
    }

    private void ConstructNewStrings(String r12, int r13, boolean r14) {
        int r15 = UserHandle.getUserId(r13);
        boolean r0 = !r14;
        if (TextUtils.isEmpty(this.mPackagesStr) == true) goto L30;
        String[] r1 = this.mPackagesStr.split(";");
        StringBuffer r4 = new StringBuffer();
        int r6 = 0;
    L6:
        if (r6 >= r1.length) goto L27;
        String r7 = r1[r6];
        if (r7.contains(r12) == true) goto L33;
        r4.append(r7 + ";");
    L26:
        r6 = r6 + 1;
        goto L6
    L33:
        int r8 = Integer.parseInt(r7.split(":")[1]);     // Catch: Exception -> L15
        if (r8 == 10) goto L18;
        if (r8 == 0) goto L18;
    L17:
        r8 = -1;
    L18:
        if (r15 != r8) goto L22;
        if (r14 == true) goto L26;
        r4.append(r7 + ";");
        r0 = false;
        goto L26
    L22:
        if (r8 == (-1)) goto L26;
        r4.append(r7 + ";");
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    L27:
        if (r0 == false) goto L29;
        r4.append(r12 + ":" + r15);
        r4.append(";");
    L29:
        String r16 = r4.toString();
        this.mPackagesStr = r16;
        this.mPackagesStr = r16.substring(0, Math.max(0, r16.length() - 1));
        return;
    L30:
        if (r14 == true) goto L42;
        this.mPackagesStr = r12 + ":" + r15;
        return;
    }

    private boolean shouldCheck(String r2, int r3) {
        return this.mPackagesStr.contains(r2 + ":" + UserHandle.getUserId(r3));
    }

    private boolean isLockscreenNotificationOn(String r3, int r4) {
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "lockscreen_notification_for" + r3 + ":" + UserHandle.getUserId(r4), 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setLockscreenNotification(String r3, int r4, boolean r5) {
        android.provider.Settings.Global.putInt(this.mContext.getContentResolver(), "lockscreen_notification_for" + r3 + ":" + UserHandle.getUserId(r4), r5 ? 1 : 0);
    }

    public void com_android_settings_NotificationDetailsFragment__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        this.mContext = getActivity();
        Bundle r7 = getArguments();
        if (r7 != null) goto L6;
        OLog.w(TAG, "No intent");
        finish();
        return;
    L6:
        this.mPm = getPackageManager();
        ApplicationInfo r1 = (ApplicationInfo) r7.getParcelable("appInfo");
        this.mAppInfo = r1;
        if (r1 == null) goto L10;
        this.mPkg = r1.packageName;
        this.mUid = this.mAppInfo.uid;
    L18:
        String r2 = r7.getString(ANDROID_PROVIDER_EXTRA_APP_PACKAGE);
        if (r2 == null) goto L28;
        this.mPkg = r2;
        if (r7.containsKey("android.provider.extra.CHANNEL_ID") == false) goto L24;
        this.mUid = r7.getInt("android.provider.extra.CHANNEL_ID");
        OLog.d(TAG, "EXTRA_CHANNEL_ID mPkg=" + this.mPkg + ", mUid=" + this.mUid);
    L24:
        if (this.mUid >= 0) goto L28;
        if (r7.containsKey("app_uid") == false) goto L28;
        this.mUid = r7.getInt("app_uid");
        OLog.d(TAG, "EXTRA_APP_UID mPkg=" + this.mPkg + ", mUid=" + this.mUid);
    L28:
        String r3 = r7.getString("app_package");
        if (this.mPkg.isEmpty() == false) goto L35;
        if (r3 == null) goto L35;
        this.mPkg = r3;
        if (r7.containsKey("app_uid") == false) goto L35;
        this.mUid = r7.getInt("app_uid");
        OLog.d(TAG, "app_uid mPkg=" + this.mPkg + ", mUid=" + this.mUid);
    L35:
        if (this.mUid >= 0) goto L41;
        this.mUid = this._mActivity.getLaunchedFromUid();     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        OLog.e(TAG, "getLaunchedFromUid err=" + th);
    L41:
        if (this.mUid < 0) goto L65;
    L46:
        PackageInfo r8 = findPackageInfo(this.mPkg, this.mUid);
        this.mPkgInfo = r8;
        if (this.mAppInfo != null) goto L53;
        if (r8 == null) goto L53;
        if (r8.applicationInfo == null) goto L53;
        this.mAppInfo = this.mPkgInfo.applicationInfo;
        OLog.d(TAG, "mAppInfo after findPackageInfo uid=" + this.mAppInfo.uid);
    L53:
        if (this.mUid >= 0) goto L55;
    L61:
        OLog.w(TAG, "Missing package or uid or packageinfo");
        finish();
        return;
    L55:
        if (TextUtils.isEmpty(this.mPkg) == true) goto L61;
        if (this.mPkgInfo == null) goto L61;
        startListeningToPackageRemove();
        return;
    L65:
        this.mUid = this.mPm.getPackageUid(this.mPkg, 0);     // Catch: PackageManager.NameNotFoundException -> L44
    L44:
        e = move-exception;
        OLog.e(TAG, "getPackageUid err=" + e);
        goto L46
    L10:
        if (r7.containsKey("package") == false) goto L12;
        String r4 = r7.getString("package");
    L13:
        this.mPkg = r4;
        if (r7.containsKey("uid") == false) goto L16;
        int r5 = r7.getInt("uid");
    L17:
        this.mUid = r5;
        goto L18
    L16:
        r5 = -1;
        goto L17
    L12:
        r4 = "";
        goto L13
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r5) {
        super.onViewStateRestored(r5);
        if ("com.android.contacts".equals(this.mPkg) == false) goto L5;
    L7:
        this.mNotificationDetailGapView.setVisibility(8);
        if ("com.android.contacts".equals(this.mPkg) == false) goto L10;
        this.mTargetPkgName = "com.android.server.telecom";
        this.mAppUid = Utils.getAppUid(this.mContext, "com.android.server.telecom");
        this.mLightenSwitch.setVisibility(8);
        this.mChannelView.setVisibility(8);
        this.mNotificationShowDetail.setVisibility(8);
        findViewByIdNullable(R.id.enabled_container).setVisibility(8);
    L10:
        updateViews();
        OCardListItem r6 = this.mNotificationHeadsUp;
        boolean r3 = true;
        if (AppCustomConfig.getInt(getContext(), this.mTargetPkgName, "notification_heads_up", 1) == 1) goto L14;
        r3 = false;
    L14:
        OCardListItemUtils.setChecked(r6, r3);
        OCardListItemUtils.setOnCheckedChangeListener(this.mNotificationHeadsUp, this);
        return;
    L5:
        if (this.mShowLegacyChannelConfig == false) goto L7;
        this.mChannel = this.mBackend.getChannel(this.mAppRow.pkg, this.mAppRow.uid, NotificationChannelCompat.DEFAULT_CHANNEL_ID);
        updateLegacyChannel();
        goto L10
    }

    private PackageInfo findPackageInfo(String r9, int r10) {
        OLog.e(TAG, "findPackageInfo pkg=" + r9 + ", uid=" + r10);
        if (r9 == null) goto L18;
        if (r10 < 0) goto L18;
        String[] r2 = this.mPm.getPackagesForUid(r10);
        if (r2 == null) goto L18;
        if (r9 == null) goto L18;
        int r3 = r2.length;
        int r4 = 0;
    L10:
        if (r4 >= r3) goto L18;
        if (r9.equals(r2[r4]) == false) goto L17;
        return this.mPm.getPackageInfoAsUser(r9, 4160, UserHandle.getUserId(r10));
    L15:
        e = move-exception;
        OLog.w(TAG, "Failed to load package " + r9, e);
    L17:
        r4 = r4 + 1;
    L18:
        return null;
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

    private void updateCategorys() {
        long r1 = System.currentTimeMillis();
        this.mAllChannels.size();
        this.mChannelContainer.removeAllViews();
        NotificationHelper.getInstance().areNotificationsEnabledForPackage(this.mTargetPkgName, this.mAppUid);
        Iterator<NotificationChannelGroup> r3 = this.mAllGroups.iterator();
    L3:
        boolean r4 = r3.hasNext();
        int r8 = R.string.settings_state_off;
        if (r4 == false) goto L23;
        final NotificationChannelGroup r5 = r3.next();
        OCardListItem r12 = new OCardListItem(this.mContext);
        r12.setTitle(r5.getName().toString());
        r12.showTitle(true);
        r12.showSubTitle(false);
        r12.setDefaultCustomEndView(1);
        r12.showCustomEnd(true);
        r12.getEndSwitch().setChecked(!r5.isBlocked());
        r12.getEndSwitch().setOnTouchListener(new NotificationDetailsFragment$$ExternalSyntheticLambda1(this));
        r12.getEndSwitch().setOnCheckedChangeListener(new AnonymousClass5(this, r5));
        if (r5.isBlocked() == true) goto L7;
        r12.setCardPosition(1);
        this.mChannelContainer.addView(r12);
        List<NotificationChannel> r6 = r5.getChannels();
        Collections.sort(r6, this.mChannelComparator);
        int r13 = 0;
    L10:
        if (r13 >= r6.size()) goto L3;
        final NotificationChannel r14 = r6.get(r13);
        OCardListItem r15 = new OCardListItem(this.mContext);
        r15.setTitle(r14.getName().toString());
        r15.showTitle(true);
        r15.showSubTitle(false);
        r15.showCustomEnd(true);
        r15.setDefaultTailIcon(0);
        r15.setDefaultCustomEndView(3);
        r15.showTailIcon(true);
        if (r14.getImportance() == 0) goto L14;
        String r7 = getResources().getString(R.string.settings_state_on);
    L15:
        OCardListItemUtils.setTrailingText(r15, r7);
        r15.setTag(r14.getId() + "");
        r15.setOnContentClickListener(new AnonymousClass6(this, r14));
        if (r13 != (r6.size() - 1)) goto L18;
        int r9 = 3;
    L19:
        r15.setCardPosition(r9);
        this.mChannelContainer.addView(r15);
        if (r13 != (r6.size() - 1)) goto L22;
        r15.setPadding(0, 0, 0, Utils.dp2Pixels(getActivity(), 16.0f));
    L22:
        r13 = r13 + 1;
        r8 = R.string.settings_state_off;
        goto L10
    L18:
        r9 = 2;
        goto L19
    L14:
        r7 = getResources().getString(r8);
        goto L15
    L7:
        r12.setCardPosition(0);
        r12.setPadding(0, 0, 0, Utils.dp2Pixels(getActivity(), 16.0f));
        this.mChannelContainer.addView(r12);
        goto L3
    L23:
        int r10 = 0;
    L25:
        if (r10 >= this.mAllChannels.size()) goto L42;
        final NotificationChannel r11 = this.mAllChannels.get(r10);
        OCardListItem r16 = new OCardListItem(this.mContext);
        r16.setTitle(r11.getName().toString());
        r16.showTitle(true);
        r16.showSubTitle(false);
        r16.showCustomEnd(true);
        r16.setDefaultTailIcon(0);
        r16.setDefaultCustomEndView(3);
        r16.showTailIcon(true);
        if (r11.getImportance() == 0) goto L29;
        String r17 = getResources().getString(R.string.settings_state_on);
    L30:
        OCardListItemUtils.setTrailingText(r16, r17);
        r16.setTag(r11.getId() + "");
        r16.setOnContentClickListener(new AnonymousClass7(this, r11));
        if (this.mAllChannels.size() != 1) goto L34;
        r16.setCardPosition(0);
    L40:
        r16.setPadding(0, 0, 0, 0);
        this.mChannelContainer.addView(r16);
        r10 = r10 + 1;
        goto L25
    L34:
        if (r10 != 0) goto L37;
        r16.setCardPosition(1);
        goto L40
    L37:
        if (r10 != (this.mAllChannels.size() - 1)) goto L39;
        r16.setCardPosition(3);
        goto L40
    L39:
        r16.setCardPosition(2);
        goto L40
    L29:
        r17 = getResources().getString(R.string.settings_state_off);
        goto L30
    L42:
        if (this.mAllGroups.isEmpty() == true) goto L44;
    L46:
        this.mChannelView.setVisibility(0);
        OLog.d(TAG, "updateCategorys 运行时间：" + (System.currentTimeMillis() - r1) + DateFormat.MINUTE_SECOND);
        return;
    L44:
        if (this.mAllChannels.isEmpty() == false) goto L46;
        View r18 = this.mLayoutInflater.inflate(R.layout.settings_oui_card_list_item, null, false);
        OCardListItem r19 = (OCardListItem) r18.findViewById(R.id.card_list_item);
        OCardListItemUtils.setTitle(r19, getResources().getString(R.string.no_channels));
        r19.showTailIcon(false);
        r19.setCardPosition(0);
        OCardListItemUtils.setEnabled(r19, false);
        this.mChannelContainer.addView(r18);
        r18.setTag(Integer.valueOf(R.string.no_channels));
        goto L46
    }

    /* JADX INFO: renamed from: lambda$updateCategorys$1$com-android-settings-NotificationDetailsFragment, reason: not valid java name */
    /* synthetic */ boolean m178x5869362f(View r3, MotionEvent r4) {
        return RiskPermissionControlGuard.interceptOnActionUp(this._mActivity, this.mTargetPkgName, UserHandle.getUserId(this.mAppUid), 64, r4);
    }

    private void updateLegacyChannel() {
        boolean r0 = NotificationHelper.getInstance().areNotificationsEnabledForPackage(this.mTargetPkgName, this.mAppUid);
        if (this.mChannel == null) goto L5;
        OCardListItemUtils.setEnabled(this.mDefaltRingTitleSwitch, r0);
        OCardListItemUtils.setEnabled(this.mDefaltVibrateSwitch, r0);
        this.mNotificationDetailGapView.setVisibility(8);
        this.mDefaltRingTitleSwitch.setVisibility(0);
        this.mMoreTitle.setVisibility(0);
        this.mDefaltVibrateSwitch.setVisibility(0);
        OCardListItemUtils.setChecked(this.mDefaltRingTitleSwitch, NotificationChannelSmt.getInstance().getSoundEnabled(this.mChannel));
        OCardListItemUtils.setChecked(this.mDefaltVibrateSwitch, this.mChannel.shouldVibrate());
        this.mPopUpDialogInLockScreen.getVisibility();
        return;
    L5:
        this.mNotificationDetailGapView.setVisibility(8);
        this.mPopUpDialogInLockScreen.getVisibility();
    }

    private void updateWidgetEnable(boolean r11) {
        boolean r1 = false;
        if (this.mChannelContainer == null) goto L27;
        long r2 = System.currentTimeMillis();
        int r0 = this.mChannelContainer.getChildCount();
        int r4 = 0;
    L6:
        if (r4 >= (r0 - 1)) goto L26;
        View r5 = this.mChannelContainer.getChildAt(r4);
        if (r5 == null) goto L25;
        OListItemSettings r6 = (OListItemSettings) r5.findViewById(R.id.item_text);
        if (r6 == null) goto L25;
        if (r0 == 2) goto L15;
    L17:
        r6.setEnabled(r11);
        NotificationChannel r7 = this.mBackend.getChannel(this.mAppRow.pkg, this.mAppRow.uid, (String) r6.getTag());
        if (r7 != null) goto L20;
        r6.setSubTitleString(getResources().getString(R.string.settings_state_off));
        goto L25
    L20:
        if (r7.getImportance() == 0) goto L22;
        String r8 = getResources().getString(R.string.settings_state_on);
    L23:
        r6.setSubTitleString(r8);
        goto L25
    L22:
        r8 = getResources().getString(R.string.settings_state_off);
        goto L23
    L15:
        if (r5.getTag() == null) goto L17;
        r6.setEnabled(false);
    L25:
        r4 = r4 + 1;
        goto L6
    L26:
        OLog.d(TAG, "updateWidgetEnable 运行时间：" + (System.currentTimeMillis() - r2) + DateFormat.MINUTE_SECOND);
    L27:
        OCardListItemUtils.setEnabled(this.mLightenSwitch, r11);
        OCardListItem r3 = this.mAllowSmartNotification;
        if (r11 == true) goto L30;
    L34:
        r3.setEnabled(r1);
        this.mPopUpDialogInLockScreen.setEnabled(r11);
        OCardListItemUtils.setEnabled(this.mNotificationShowDetail, r11);
        this.mDefaltVibrateSwitch.setEnabled(r11);
        OCardListItemUtils.setEnabled(this.mDefaltRingTitleSwitch, r11);
        OCardListItemUtils.setEnabled(this.mNotificationHeadsUp, r11);
        return;
    L30:
        if (isHighPriorityNotification() == false) goto L32;
    L33:
        r1 = true;
        goto L34
    L32:
        if (isNotificationReduction() == false) goto L34;
        goto L33
    }

    private boolean isSmartNotificationAppEnabled() {
        if (this.mTargetPkgName != null) goto L6;
        return false;
    L6:
        String r0 = android.provider.Settings.System.getString(getContentResolver(), DISABLE_SMART_NOTIFICATION);
        if (r0 != null) goto L9;
        r0 = DEFAULT_DISABLE_SMART_NOTIFICATION_APP;
    L9:
        OLog.d(TAG, "disable smart notification apps: " + r0);
        return !r0.contains(this.mTargetPkgName);
    }

    private void setSmartNotificationAppEnabled(boolean r9) {
        if (this.mTargetPkgName != null) goto L5;
        return;
    L5:
        String r0 = android.provider.Settings.System.getString(getContentResolver(), DISABLE_SMART_NOTIFICATION);
        if (r0 != null) goto L8;
        r0 = DEFAULT_DISABLE_SMART_NOTIFICATION_APP;
    L8:
        OLog.d(TAG, "disable smart notification apps: " + r0 + ". target package: " + this.mTargetPkgName);
        if (r9 == true) goto L11;
    L12:
        if (r9 == true) goto L17;
        if (r0.contains(this.mTargetPkgName) == false) goto L17;
        return;
    L17:
        if (r9 == false) goto L31;
        String[] r10 = r0.split(",");
        StringBuilder r1 = new StringBuilder();
        int r5 = 0;
    L20:
        if (r5 >= r10.length) goto L27;
        if (r10[r5].equals(this.mTargetPkgName) == true) goto L26;
        r1.append(r10[r5]);
        if (r5 >= (r10.length - 1)) goto L26;
        r1.append(",");
    L26:
        r5 = r5 + 1;
        goto L20
    L27:
        String r11 = r1.toString();
        if (r11.endsWith(",") == false) goto L34;
        r11 = r11.substring(0, r11.length() - 1);
    L34:
        OLog.d(TAG, "new disable smart notification apps: " + r11);
        android.provider.Settings.System.putString(getContentResolver(), DISABLE_SMART_NOTIFICATION, r11);
        return;
    L31:
        if (r0.isEmpty() == false) goto L33;
        r11 = this.mTargetPkgName;
        goto L34
    L33:
        r11 = r0 + "," + this.mTargetPkgName;
        goto L34
    L11:
        if (r0.contains(this.mTargetPkgName) == true) goto L12;
    }

    private boolean isHighPriorityNotification() {
        if (android.provider.Settings.System.getInt(getContentResolver(), "high_priority_notification", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private boolean isNotificationReduction() {
        if (android.provider.Settings.System.getInt(getContentResolver(), NOTIFICATION_REDUCTION_MODE, 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NotificationDetailsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationDetailsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NotificationDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_NotificationDetailsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NotificationDetailsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_NotificationDetailsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
