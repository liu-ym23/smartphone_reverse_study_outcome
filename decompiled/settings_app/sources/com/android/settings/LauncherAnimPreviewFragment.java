package com.android.settings;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SelectOptionsView;
import com.android.settings.widget.VideoPlayerView;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class LauncherAnimPreviewFragment extends BaseFragment implements SelectOptionsView.OptionsSelectedCallback {
    public static final String EXTRA_LAUNCHER_ANIM_INDEX = "extra_launcher_anim_index";
    private int mCurrentAnimValue;
    private Handler mHandler;
    private int mOriginIndex;
    private View mRightView;
    private SelectOptionsView mSelectOptionsView;
    private VideoPlayerView mVideoPlayerView;

    public void com_android_settings_LauncherAnimPreviewFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public LauncherAnimPreviewFragment() {
        this.mHandler = new AnonymousClass1(this);
    }

    static /* synthetic */ void access$000(LauncherAnimPreviewFragment r0) {
        r0.setVideoUri();
    }

    static /* synthetic */ VideoPlayerView access$100(LauncherAnimPreviewFragment r0) {
        return r0.mVideoPlayerView;
    }

    static /* synthetic */ int access$200(LauncherAnimPreviewFragment r0) {
        return r0.mCurrentAnimValue;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.launcher_anim_preview_layout, r3, false);
        this.mOriginIndex = Utils.getAnimIndexFromValue(getCurrentTheme());
        int r5 = getIntent().getIntExtra(EXTRA_LAUNCHER_ANIM_INDEX, -1);
        OLog.d(this.TAG, "animIndex=" + r5);
        if (r5 >= 0) goto L5;
        this.mCurrentAnimValue = getCurrentTheme();
    L6:
        initViews();
        return this.mRootView;
    L5:
        this.mCurrentAnimValue = Utils.getValueFromPosition(r5);
        goto L6
    }

    private void initViews() {
        this.mVideoPlayerView = (VideoPlayerView) findViewByIdNullable(R.id.video_player_view);
        setVideoUri();
        SelectOptionsView r0 = (SelectOptionsView) findViewByIdNullable(R.id.select_options_view);
        this.mSelectOptionsView = r0;
        r0.initView(R.array.launcher_anim_preview, R.array.launcher_anim_name, 0, R.dimen.selection_option_margin_bottom);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        super.onViewCreated(r4, r5);
        int r6 = Utils.getAnimIndexFromValue(this.mCurrentAnimValue);
        this.mSelectOptionsView.setSelectedIndex(r6);
        this.mSelectOptionsView.setCallback(this);
        View r7 = this.mTitleView.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null);
        this.mRightView = r7;
        if (r6 == this.mOriginIndex) goto L5;
        boolean r8 = true;
    L6:
        r7.setEnabled(r8);
        this.mRightView.setOnClickListener(new AnonymousClass2(this));
        return;
    L5:
        r8 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getWindow().clearFlags(1024);
    }

    private void setVideoUri() {
        this.mVideoPlayerView.setVideoUri(Uri.parse("android.resource://" + getPackageName() + LibrarianImpl.Constants.SEPARATOR + getResources().getIdentifier("launcher_anim_" + this.mCurrentAnimValue, "raw", getPackageName())));
    }

    @Override // com.android.settings.widget.SelectOptionsView.OptionsSelectedCallback
    public void onSelectIndex(int r4) {
        View r0 = this.mRightView;
        if (r4 == this.mOriginIndex) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        int r5 = Utils.getValueFromPosition(r4);
        if (r5 == this.mCurrentAnimValue) goto L10;
        this.mCurrentAnimValue = r5;
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, 300);
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mVideoPlayerView.stop();
    }

    public void com_android_settings_LauncherAnimPreviewFragment__onResume$___twin___() {
        super.onResume();
        setVideoUri();
        this.mVideoPlayerView.start();
    }

    private int getCurrentTheme() {
        return android.provider.Settings.Global.getInt(getContentResolver(), "launcher_page_animation", 0);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(LauncherAnimPreviewFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LauncherAnimPreviewFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(LauncherAnimPreviewFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_LauncherAnimPreviewFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(LauncherAnimPreviewFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_LauncherAnimPreviewFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
