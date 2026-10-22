package com.android.settings.revone;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.fragment.app.FragmentActivity;
import com.android.internal.content.PackageMonitor;
import com.android.settings.Constants;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.TrackerConstants;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.android.settings.widget.SettingItemCheckbox;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;
import obric.widget.ShadowDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class DockSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int TOAST_TIME_GAP = 10000;
    private ContentObserver mContentObserver;
    private SettingItemCheckbox mDockBarToolsAllApps;
    private SettingItemCheckbox mDockBarToolsBingBang;
    private SettingItemCheckbox mDockBarToolsGlobalSearch;
    private SettingItemCheckbox mDockBarToolsMultiTasks;
    private SettingItemCheckbox mDockBarToolsScreenShot;
    private SettingItemCheckbox mDockBarToolsShowLauncher;
    private SettingItemCheckbox mDockBarToolsWhitePad;
    private SettingItemCheckbox mDockBarToolsWindowTidy;
    private Handler mHandler;
    private ImageView mImageView;
    private boolean mMeetingMode;
    private PackageMonitor mPackageReceiver;
    private ScrollView mScrollView;
    private SettingItemCheckbox mStatusBarToolsLocalSearch;
    private SettingItemCheckbox mStatusBarToolsNetworkSearch;
    private SettingItemCheckbox mStatusBarToolsScreenRecord;
    private SettingItemCheckbox mStatusBarToolsSearchWord;
    private TextView mTextView;
    private long mToastTime;
    private View mVideoBg;
    private View mVideoLayout;
    private VideoView mVideoView;
    private AlertDialog mWarningDialog;
    private SettingItemText mWindowTitleStyle;

    private static class ObserverHandler extends Handler {
        private ObserverHandler() {
        }

        /* synthetic */ ObserverHandler(AnonymousClass1 r1) {
            this();
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            super.handleMessage(r1);
        }
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DockSettingsFragment() {
        this.mToastTime = 0;
        this.mHandler = new ObserverHandler(null);
        final Handler r1 = this.mHandler;
        this.mContentObserver = new AnonymousClass1(this, r1);
        this.mPackageReceiver = new AnonymousClass2(this);
    }

    static /* synthetic */ void access$100(DockSettingsFragment r0) {
        r0.updateViews();
    }

    static /* synthetic */ AlertDialog access$200(DockSettingsFragment r0) {
        return r0.mWarningDialog;
    }

    static /* synthetic */ AlertDialog access$202(DockSettingsFragment r0, AlertDialog r1) {
        r0.mWarningDialog = r1;
        return r1;
    }

    static /* synthetic */ void access$300(DockSettingsFragment r0) {
        r0.showWarningDialog();
    }

    static /* synthetic */ void access$400(DockSettingsFragment r0, String r1) {
        r0.launchAppStoreForPackage(r1);
    }

    static /* synthetic */ VideoView access$500(DockSettingsFragment r0) {
        return r0.mVideoView;
    }

    static /* synthetic */ ImageView access$600(DockSettingsFragment r0) {
        return r0.mImageView;
    }

    static /* synthetic */ void access$700(DockSettingsFragment r0, boolean r1, Uri r2) {
        r0.updateVideoView(r1, r2);
    }

    public void com_android_settings_revone_DockSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        if (this.mMeetingMode == false) goto L5;
        int r0 = R.layout.dock_settings_meeting_layout;
    L7:
        return r1.inflate(r0, r2, false);
    L5:
        r0 = R.layout.dock_settings_layout;
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        if (this.mMeetingMode == false) goto L5;
        this.mWindowTitleStyle = (SettingItemText) findViewByIdNullable(R.id.id_window_title_bar_style);
        this.mStatusBarToolsLocalSearch = (SettingItemCheckbox) findViewByIdNullable(R.id.id_status_bar_tools_local_search);
        this.mStatusBarToolsNetworkSearch = (SettingItemCheckbox) findViewByIdNullable(R.id.id_status_bar_tools_network_search);
        this.mStatusBarToolsScreenRecord = (SettingItemCheckbox) findViewByIdNullable(R.id.id_status_bar_tools_screen_record);
        this.mStatusBarToolsSearchWord = (SettingItemCheckbox) findViewByIdNullable(R.id.id_status_bar_tools_search_word);
        this.mDockBarToolsWindowTidy = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_window_tidy);
        this.mDockBarToolsShowLauncher = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_show_launcher);
        this.mDockBarToolsAllApps = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_all_apps);
    L6:
        this.mDockBarToolsBingBang = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_bing_bang);
        this.mDockBarToolsMultiTasks = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_multi_tasks);
        this.mVideoView = (VideoView) NullSafe.nonNull(findViewByIdNullable(R.id.video_view));
        this.mVideoBg = NullSafe.nonNull(findViewByIdNullable(R.id.video_background));
        this.mScrollView = (ScrollView) NullSafe.nonNull(findViewByIdNullable(R.id.page_scrollview));
        this.mVideoLayout = NullSafe.nonNull(findViewByIdNullable(R.id.video_layout));
        this.mImageView = (ImageView) NullSafe.nonNull(findViewByIdNullable(R.id.video_default));
        this.mTextView = (TextView) NullSafe.nonNull(findViewByIdNullable(R.id.id_dock_title_bar_video_intro));
        if (SettingsFeature.isDarwin() == false) goto L9;
        ShadowDrawable.setViewBackground(this.mVideoLayout, R.drawable.group_list_item_bg_single, R.drawable.list_content_item_single_shadow);
        return;
    L9:
        this.mTextView.setVisibility(4);
        this.mVideoView.setVisibility(4);
        this.mVideoLayout.setVisibility(4);
        this.mImageView.setVisibility(4);
        this.mVideoBg.setVisibility(4);
        return;
    L5:
        this.mDockBarToolsGlobalSearch = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_global_search);
        this.mDockBarToolsScreenShot = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_screenshot);
        this.mDockBarToolsWhitePad = (SettingItemCheckbox) findViewByIdNullable(R.id.id_dock_bar_tools_white_pad);
        goto L6
    }

    public void com_android_settings_revone_DockSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mDockBarToolsBingBang.setOnCheckedChangeListener(this);
        this.mDockBarToolsBingBang.setOnDisabledClickListener(new AnonymousClass3(this));
        this.mDockBarToolsMultiTasks.setOnCheckedChangeListener(this);
        if (this.mMeetingMode == false) goto L5;
        this.mWindowTitleStyle.setOnClickListener(this);
        this.mStatusBarToolsLocalSearch.setOnCheckedChangeListener(this);
        this.mStatusBarToolsNetworkSearch.setOnCheckedChangeListener(this);
        this.mStatusBarToolsScreenRecord.setOnCheckedChangeListener(this);
        this.mStatusBarToolsSearchWord.setOnCheckedChangeListener(this);
        this.mDockBarToolsWindowTidy.setOnCheckedChangeListener(this);
        this.mDockBarToolsShowLauncher.setOnCheckedChangeListener(this);
        this.mDockBarToolsAllApps.setOnCheckedChangeListener(this);
    L6:
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_bing_bang_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_multi_tasks_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_global_search"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_screenshot"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_white_pad"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_status_bar_local_search_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_status_bar_network_search_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_status_bar_screen_record_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_status_bar_search_word_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_hide_show_window_show"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_window_tidy"), true, this.mContentObserver);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_dock_bar_hide_show_window_show"), true, this.mContentObserver);
        this.mPackageReceiver.register(this.mContext, Looper.getMainLooper(), true);
        return;
    L5:
        this.mDockBarToolsGlobalSearch.setOnCheckedChangeListener(this);
        this.mDockBarToolsScreenShot.setOnCheckedChangeListener(this);
        this.mDockBarToolsWhitePad.setOnCheckedChangeListener(this);
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
        this.mPackageReceiver.unregister();
        if (SettingsFeature.isDarwin() == false) goto L8;
        VideoView r2 = this.mVideoView;
        if (r2 == null) goto L9;
        r2.stopPlayback();
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mWindowTitleStyle) goto L6;
        start(WindowTitleBarStyleFragment.class);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        boolean r0 = Utils.isPackageInstalled(this.mContext, Constants.PKG_BIG_BANG);
        boolean r1 = false;
        if (r0 == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        this.mDockBarToolsBingBang.setEnabled(r0);
        this.mDockBarToolsBingBang.setChecked(r3);
        SettingItemCheckbox r2 = this.mDockBarToolsMultiTasks;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_multi_tasks_show", 1) != 1) goto L11;
        boolean r4 = true;
    L12:
        r2.setChecked(r4);
        this.mScrollView.scrollTo(0, 0);
        if (SettingsFeature.isDarwin() == false) goto L16;
        initVideoView();
    L16:
        if (this.mMeetingMode == false) goto L45;
        SettingItemCheckbox r5 = this.mStatusBarToolsLocalSearch;
        if (Settings.Global.getInt(getContentResolver(), "tablet_status_bar_local_search_show", 1) != 1) goto L20;
        boolean r6 = true;
    L21:
        r5.setChecked(r6);
        SettingItemCheckbox r7 = this.mStatusBarToolsNetworkSearch;
        if (Settings.Global.getInt(getContentResolver(), "tablet_status_bar_network_search_show", 1) != 1) goto L24;
        boolean r8 = true;
    L25:
        r7.setChecked(r8);
        SettingItemCheckbox r9 = this.mStatusBarToolsScreenRecord;
        if (Settings.Global.getInt(getContentResolver(), "tablet_status_bar_screen_record_show", 1) != 1) goto L28;
        boolean r10 = true;
    L29:
        r9.setChecked(r10);
        SettingItemCheckbox r11 = this.mStatusBarToolsSearchWord;
        if (Settings.Global.getInt(getContentResolver(), "tablet_status_bar_search_word_show", 1) != 1) goto L32;
        boolean r12 = true;
    L33:
        r11.setChecked(r12);
        SettingItemCheckbox r13 = this.mDockBarToolsWindowTidy;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_window_tidy", 1) != 1) goto L36;
        boolean r14 = true;
    L37:
        r13.setChecked(r14);
        SettingItemCheckbox r15 = this.mDockBarToolsShowLauncher;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_hide_show_window_show", 1) != 1) goto L40;
        boolean r16 = true;
    L41:
        r15.setChecked(r16);
        SettingItemCheckbox r17 = this.mDockBarToolsAllApps;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_app_drawer_show", 1) != 1) goto L44;
        r1 = true;
    L44:
        r17.setChecked(r1);
        return;
    L40:
        r16 = false;
        goto L41
    L36:
        r14 = false;
        goto L37
    L32:
        r12 = false;
        goto L33
    L28:
        r10 = false;
        goto L29
    L24:
        r8 = false;
        goto L25
    L20:
        r6 = false;
        goto L21
    L45:
        SettingItemCheckbox r18 = this.mDockBarToolsGlobalSearch;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_global_search", 1) != 1) goto L48;
        boolean r19 = true;
    L49:
        r18.setChecked(r19);
        SettingItemCheckbox r20 = this.mDockBarToolsScreenShot;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_screenshot", 1) != 1) goto L52;
        boolean r21 = true;
    L53:
        r20.setChecked(r21);
        SettingItemCheckbox r22 = this.mDockBarToolsWhitePad;
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_white_pad", 1) != 1) goto L56;
        r1 = true;
    L56:
        r22.setChecked(r1);
        return;
    L52:
        r21 = false;
        goto L53
    L48:
        r19 = false;
        goto L49
    L11:
        r4 = false;
        goto L12
    L5:
        if (Settings.Global.getInt(getContentResolver(), "tablet_dock_bar_bing_bang_show", 1) != 1) goto L7;
        r3 = true;
        goto L8
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r4, boolean r5) {
        if (r4 != this.mDockBarToolsBingBang.getCheckBox()) goto L6;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_bing_bang_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.BIGBANG, r5);
    L9:
        if (this.mMeetingMode == false) goto L32;
        if (r4 != this.mStatusBarToolsLocalSearch.getCheckBox()) goto L14;
        Settings.Global.putInt(getContentResolver(), "tablet_status_bar_local_search_show", r5 ? 1 : 0);
        return;
    L14:
        if (r4 != this.mStatusBarToolsNetworkSearch.getCheckBox()) goto L17;
        Settings.Global.putInt(getContentResolver(), "tablet_status_bar_network_search_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.ONLINE_SEARCH, r5);
        return;
    L17:
        if (r4 != this.mStatusBarToolsScreenRecord.getCheckBox()) goto L20;
        Settings.Global.putInt(getContentResolver(), "tablet_status_bar_screen_record_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.SCREEN_RECORDING, r5);
        return;
    L20:
        if (r4 != this.mStatusBarToolsSearchWord.getCheckBox()) goto L23;
        Settings.Global.putInt(getContentResolver(), "tablet_status_bar_search_word_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.LOOK_UP, r5);
        return;
    L23:
        if (r4 != this.mDockBarToolsWindowTidy.getCheckBox()) goto L26;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_window_tidy", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.ARRANGE_SMALL_WINDOWS, r5);
        return;
    L26:
        if (r4 != this.mDockBarToolsShowLauncher.getCheckBox()) goto L29;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_hide_show_window_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.SHOW_LANUCHER, r5);
        return;
    L29:
        if (r4 != this.mDockBarToolsAllApps.getCheckBox()) goto L47;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_app_drawer_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, "all_apps", r5);
        return;
    L47:
        return;
    L32:
        if (r4 != this.mDockBarToolsGlobalSearch.getCheckBox()) goto L35;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_global_search", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, "all_apps", r5);
        return;
    L35:
        if (r4 != this.mDockBarToolsScreenShot.getCheckBox()) goto L38;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_screenshot", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, "all_apps", r5);
        return;
    L38:
        if (r4 != this.mDockBarToolsWhitePad.getCheckBox()) goto L51;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_white_pad", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, "all_apps", r5);
        return;
    L51:
        return;
    L6:
        if (r4 != this.mDockBarToolsMultiTasks.getCheckBox()) goto L9;
        Settings.Global.putInt(getContentResolver(), "tablet_dock_bar_multi_tasks_show", r5 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.OVERVIEW, r5);
        goto L9
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        if (SettingsFeature.isDarwin() == false) goto L7;
        VideoView r0 = this.mVideoView;
        if (r0 == null) goto L7;
        r0.stopPlayback();
    L7:
        super.onDestroyView();
    }

    private void showWarningDialog() {
        AlertDialog r0 = this.mWarningDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(this.TAG, "showChangeValueDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        r2.setTitle(R.string.dlg_title_notice).setNegativeButton(android.R.string.cancel, null).setCancelable(false).setOnDismissListener(new AnonymousClass4(this));
        r2.setPositiveButton(R.string.install_text, new AnonymousClass5(this));
        r2.setMessage(R.string.install_bigbang_message);
        AlertDialog r3 = r2.create();
        this.mWarningDialog = r3;
        r3.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private void launchAppStoreForPackage(String r3) {
        Intent r0 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + r3));     // Catch: ActivityNotFoundException -> L5
        r0.setPackage(Utils.APP_STORE_PACKAGE);     // Catch: ActivityNotFoundException -> L5
        r0.addFlags(268435456);     // Catch: ActivityNotFoundException -> L5
        startActivity(r0);     // Catch: ActivityNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private void initVideoView() {
        final Uri r0 = getVideoUri();
        if (r0 != null) goto L5;
        updateVideoView(false, null);
    L6:
        this.mVideoView.setOnPreparedListener(new AnonymousClass6(this));
        this.mVideoView.setOnCompletionListener(new AnonymousClass7(this));
        this.mVideoView.setOnErrorListener(new AnonymousClass8(this, r0));
        this.mVideoView.setOnInfoListener(new AnonymousClass9(this));
        return;
    L5:
        updateVideoView(true, r0);
        goto L6
    }

    private Uri getVideoUri() {
        if (getContext() != null) goto L6;
        return null;
    L6:
        if (SettingsFeature.isDarwin() == true) goto L8;
        return null;
    L8:
        return Uri.parse("android.resource://" + getContext().getPackageName() + "/2131886140");
    }

    private void updateVideoView(boolean r3, Uri r4) {
        if (r3 == false) goto L4;
        this.mVideoView.setVideoURI(r4);
        this.mVideoBg.setVisibility(4);
        return;
    L4:
        this.mVideoView.stopPlayback();
        this.mVideoView.setVisibility(8);
        this.mVideoBg.setVisibility(0);
        this.mVideoBg.setBackgroundResource(R.drawable.load_fail_video);
        if (this.mToastTime != 0) goto L7;
    L8:
        ToastUtils.show(getActivity(), R.string.toast_gesture_download_error);
        this.mToastTime = System.currentTimeMillis();
        return;
    L7:
        if ((System.currentTimeMillis() - this.mToastTime) > 10000) goto L8;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DockSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_DockSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DockSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_DockSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DockSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_DockSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
