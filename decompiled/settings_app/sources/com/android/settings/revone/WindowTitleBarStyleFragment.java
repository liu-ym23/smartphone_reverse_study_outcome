package com.android.settings.revone;

import android.app.SmtPCUtils;
import android.database.ContentObserver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.VideoView;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.ToastUtils;
import com.android.settings.TrackerConstants;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;
import obric.widget.ListContentItemSwitch;
import obric.widget.ShadowDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class WindowTitleBarStyleFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int TOAST_TIME_GAP = 10000;
    private ContentObserver mContentObserver;
    private final Handler mHandler;
    private ImageView mImageView;
    private TextView mModeAutoTipsView;
    private ScrollView mScrollView;
    private ListContentItemCheck mStyleBottomItem;
    private ListContentItemCheck mStyleTopItem;
    private TextView mTextView;
    private long mToastTime;
    private View mVideoBg;
    private View mVideoLayout;
    private VideoView mVideoView;
    private ListContentItemSwitch mWindowTitleBarModeAuto;

    /* JADX INFO: renamed from: com.android.settings.revone.WindowTitleBarStyleFragment$2, reason: invalid class name */
    class AnonymousClass2 implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ WindowTitleBarStyleFragment this$0;

        AnonymousClass2(WindowTitleBarStyleFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer r2) {
            r2.setLooping(true);
            WindowTitleBarStyleFragment.access$200(this.this$0).start();
            r2.setOnInfoListener(new WindowTitleBarStyleFragment$2$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onPrepared$0$com-android-settings-revone-WindowTitleBarStyleFragment$2, reason: not valid java name */
        /* synthetic */ boolean m561xaba0b9b(MediaPlayer r1, int r2, int r3) {
            if (r2 != 3) goto L7;
            WindowTitleBarStyleFragment.access$300(this.this$0).setVisibility(8);
            return true;
        L7:
            return true;
        }
    }

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

    public void com_android_settings_revone_WindowTitleBarStyleFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$100(WindowTitleBarStyleFragment r0) {
        r0.updateViews();
    }

    static /* synthetic */ VideoView access$200(WindowTitleBarStyleFragment r0) {
        return r0.mVideoView;
    }

    static /* synthetic */ ImageView access$300(WindowTitleBarStyleFragment r0) {
        return r0.mImageView;
    }

    static /* synthetic */ void access$400(WindowTitleBarStyleFragment r0, boolean r1, Uri r2) {
        r0.updateVideoView(r1, r2);
    }

    public WindowTitleBarStyleFragment() {
        super(R.layout.revone_fragment_window_titlebar_settings);
        this.mToastTime = 0;
        final ObserverHandler r0 = new ObserverHandler(null);
        this.mHandler = r0;
        this.mContentObserver = new AnonymousClass1(this, r0);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        this.mWindowTitleBarModeAuto = (ListContentItemSwitch) findViewByIdNullable(R.id.id_window_title_bar_mode_auto);
        this.mModeAutoTipsView = (TextView) findViewByIdNullable(R.id.id_mode_auto_tips_view);
        this.mStyleTopItem = (ListContentItemCheck) findViewByIdNullable(R.id.id_style_top);
        this.mStyleBottomItem = (ListContentItemCheck) findViewByIdNullable(R.id.id_style_bottom);
        this.mVideoView = (VideoView) NullSafe.nonNull(findViewByIdNullable(R.id.video_view));
        this.mVideoBg = NullSafe.nonNull(findViewByIdNullable(R.id.video_background));
        this.mScrollView = (ScrollView) NullSafe.nonNull(findViewByIdNullable(R.id.page_scrollview));
        this.mVideoLayout = NullSafe.nonNull(findViewByIdNullable(R.id.video_layout));
        this.mImageView = (ImageView) NullSafe.nonNull(findViewByIdNullable(R.id.video_default));
        this.mTextView = (TextView) NullSafe.nonNull(findViewByIdNullable(R.id.id_window_title_bar_video_intro));
        if (SettingsFeature.isDarwin() == false) goto L5;
        ShadowDrawable.setViewBackground(this.mVideoLayout, R.drawable.group_list_item_bg_single, R.drawable.list_content_item_single_shadow);
    L6:
        this.mStyleTopItem.setOnClickListener(this);
        this.mStyleBottomItem.setOnClickListener(this);
        return;
    L5:
        this.mTextView.setVisibility(4);
        this.mVideoView.setVisibility(4);
        this.mVideoLayout.setVisibility(4);
        this.mImageView.setVisibility(4);
        this.mVideoBg.setVisibility(4);
        goto L6
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

    public void com_android_settings_revone_WindowTitleBarStyleFragment__onResume$___twin___() {
        super.onResume();
        this.mWindowTitleBarModeAuto.setOnCheckedChangeListener(this);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor("tablet_title_bar_location"), true, this.mContentObserver);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mContext.getContentResolver().unregisterContentObserver(this.mContentObserver);
        this.mWindowTitleBarModeAuto.setOnCheckedChangeListener(null);
        if (SettingsFeature.isDarwin() == false) goto L8;
        VideoView r2 = this.mVideoView;
        if (r2 == null) goto L9;
        r2.stopPlayback();
        return;
    L9:
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r9) {
        ListContentItemCheck r0 = this.mStyleTopItem;
        if (r9 != r0) goto L9;
        r0.setChecked(true);
        this.mStyleBottomItem.setChecked(false);
        Settings.Global.putInt(getContentResolver(), "tablet_title_bar_location", 0);
        if (SmtPCUtils.isTntDisplay() == false) goto L7;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.TNT_WINDOW_TITLEBAR_POSITION, 1);
        return;
    L7:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.THIRD_WINDOWS_TITLEBAR_POSITION, 1);
        return;
    L9:
        if (r9 != this.mStyleBottomItem) goto L17;
        r0.setChecked(false);
        this.mStyleBottomItem.setChecked(true);
        Settings.Global.putInt(getContentResolver(), "tablet_title_bar_location", 1);
        if (SmtPCUtils.isTntDisplay() == false) goto L13;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.TNT_WINDOW_TITLEBAR_POSITION, 2);
        return;
    L13:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.THIRD_WINDOWS_TITLEBAR_POSITION, 2);
        return;
    }

    private void updateViews() {
        boolean r1 = true;
        if (SmtPCUtils.isTntDisplay() == false) goto L12;
        this.mWindowTitleBarModeAuto.setVisibility(0);
        this.mModeAutoTipsView.setVisibility(0);
        ListContentItemSwitch r0 = this.mWindowTitleBarModeAuto;
        if (Settings.Global.getInt(getContentResolver(), "tablet_title_bar_mode", 0) != 0) goto L7;
        boolean r3 = true;
    L8:
        r0.setChecked(r3);
        if (this.mWindowTitleBarModeAuto.isChecked() == false) goto L11;
        this.mStyleTopItem.setEnabled(false);
        this.mStyleBottomItem.setEnabled(false);
    L13:
        ListContentItemCheck r2 = this.mStyleTopItem;
        if (Settings.Global.getInt(getContentResolver(), "tablet_title_bar_location", 0) != 0) goto L16;
        boolean r4 = true;
    L17:
        r2.setChecked(r4);
        ListContentItemCheck r5 = this.mStyleBottomItem;
        if (Settings.Global.getInt(getContentResolver(), "tablet_title_bar_location", 0) == 1) goto L21;
        r1 = false;
    L21:
        r5.setChecked(r1);
        this.mScrollView.scrollTo(0, 0);
        if (SettingsFeature.isDarwin() == false) goto L25;
        initVideoView();
        return;
    L25:
        return;
    L16:
        r4 = false;
        goto L17
    L11:
        this.mStyleTopItem.setEnabled(true);
        this.mStyleBottomItem.setEnabled(true);
        goto L13
    L7:
        r3 = false;
        goto L8
    L12:
        this.mWindowTitleBarModeAuto.setVisibility(8);
        this.mModeAutoTipsView.setVisibility(8);
        goto L13
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != this.mWindowTitleBarModeAuto.getSwitch()) goto L10;
        Settings.Global.putInt(getContentResolver(), "tablet_title_bar_mode", !r4 ? 1 : 0);
        if (r4 == false) goto L7;
        this.mStyleTopItem.setEnabled(false);
        this.mStyleBottomItem.setEnabled(false);
    L8:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.TNT_WINDOW_TITLEBAR_POSITION, 0);
        return;
    L7:
        this.mStyleTopItem.setEnabled(true);
        this.mStyleBottomItem.setEnabled(true);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        VideoView r0 = this.mVideoView;
        if (r0 == null) goto L5;
        r0.stopPlayback();
    L5:
        super.onDestroyView();
    }

    private void initVideoView() {
        final Uri r0 = getVideoUri();
        if (r0 != null) goto L5;
        updateVideoView(false, null);
    L6:
        this.mVideoView.setOnPreparedListener(new AnonymousClass2(this));
        this.mVideoView.setOnCompletionListener(new AnonymousClass3(this));
        this.mVideoView.setOnErrorListener(new AnonymousClass4(this, r0));
        this.mVideoView.setOnInfoListener(new AnonymousClass5(this));
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
        return Uri.parse("android.resource://" + getContext().getPackageName() + "/2131886141");
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
    public static void com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WindowTitleBarStyleFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_WindowTitleBarStyleFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WindowTitleBarStyleFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_WindowTitleBarStyleFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WindowTitleBarStyleFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_WindowTitleBarStyleFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
