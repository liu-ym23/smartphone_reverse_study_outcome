package com.android.settings;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.VideoPlayerView;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ChargingAnimationFragment extends BaseFragment implements View.OnClickListener {
    private static final int CHARGING_ANIMATION_INDEX_DEFAULT = 0;
    private static final int CHARGING_ANIMATION_INDEX_MOON = 1;
    public static final int DELAY_MILLIS = 300;
    public static final int MSG_ID = 0;
    public static final String TAG = "ChargingAnimationFragment";
    private List<ChargingAnimation> mChargingAnimations;
    private ImageView mCheckDefaultIv;
    private ImageView mCheckMoonIv;
    private ImageView mDefaultIv;
    private Handler mHandler;
    private ImageView mMoonIv;
    private int mOriginAnimIndex;
    private View mRightView;
    private int mSelectAnimIndex;
    private VideoPlayerView mVideoPlayerView;

    private class ChargingAnimation {
        private int mResId;
        private Uri mUri;
        final /* synthetic */ ChargingAnimationFragment this$0;

        public ChargingAnimation(ChargingAnimationFragment r3, int r4) {
            this.this$0 = r3;
            this.mResId = r4;
            this.mUri = Uri.parse("android.resource://" + r3.getContext().getPackageName() + LibrarianImpl.Constants.SEPARATOR + r4);
        }

        public Uri getUri() {
            return this.mUri;
        }

        public void setUri(Uri r1) {
            this.mUri = r1;
        }
    }

    static {
    }

    public void com_android_settings_ChargingAnimationFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(ChargingAnimationFragment r0) {
        r0.setVideoUri();
    }

    static /* synthetic */ VideoPlayerView access$100(ChargingAnimationFragment r0) {
        return r0.mVideoPlayerView;
    }

    public ChargingAnimationFragment() {
        super(R.layout.charging_animation_layout);
        this.mHandler = new AnonymousClass1(this);
        this.mOriginAnimIndex = 0;
        this.mSelectAnimIndex = 0;
        this.mChargingAnimations = new ArrayList();
    }

    @Override // com.android.settings.base.BaseFragment
    public void initViews(View r1, Bundle r2) {
        super.initViews(r1, r2);
        initData();
        initViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        OFloatingTitleBar r5 = this.mTitleView;
        if (r5 == null) goto L5;
        View r6 = r5.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null);
        this.mRightView = r6;
        r6.setOnClickListener(this);
        this.mRightView.setEnabled(false);
    L5:
        this.mDefaultIv.setOnClickListener(this);
        this.mMoonIv.setOnClickListener(this);
    }

    private void initData() {
        int r0 = android.provider.Settings.Global.getInt(getContentResolver(), "keyguard_charging_anim", 0);
        this.mOriginAnimIndex = r0;
        this.mSelectAnimIndex = r0;
        this.mChargingAnimations.add(new ChargingAnimation(this, R.raw.charging_animation_default));
        this.mChargingAnimations.add(new ChargingAnimation(this, R.raw.charging_animation_moon));
    }

    private void initViews() {
        VideoPlayerView r0 = (VideoPlayerView) findViewByIdNullable(R.id.video_player_view);
        this.mVideoPlayerView = r0;
        r0.hidePreview();
        this.mHandler.sendEmptyMessage(0);
        this.mDefaultIv = (ImageView) findViewByIdNullable(R.id.iv_default);
        this.mCheckDefaultIv = (ImageView) findViewByIdNullable(R.id.iv_check_default);
        this.mMoonIv = (ImageView) findViewByIdNullable(R.id.iv_moon);
        ImageView r1 = (ImageView) findViewByIdNullable(R.id.iv_check_moon);
        this.mCheckMoonIv = r1;
        if (this.mOriginAnimIndex != 1) goto L5;
        r1.setVisibility(0);
        this.mCheckDefaultIv.setVisibility(8);
        return;
    L5:
        this.mCheckDefaultIv.setVisibility(0);
        this.mCheckMoonIv.setVisibility(8);
    }

    private void playVideo() {
        View r0 = this.mRightView;
        if (r0 != null) goto L5;
    L9:
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageDelayed(0, 300);
        return;
    L5:
        if (this.mSelectAnimIndex == this.mOriginAnimIndex) goto L7;
        boolean r2 = true;
    L8:
        r0.setEnabled(r2);
        goto L9
    L7:
        r2 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (getWindow() == null) goto L6;
        getWindow().clearFlags(1024);
        return;
    }

    private void setVideoUri() {
        ChargingAnimation r0 = this.mChargingAnimations.get(this.mSelectAnimIndex);
        this.mVideoPlayerView.setVideoUri(r0.getUri());
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mVideoPlayerView.stop();
        this.mVideoPlayerView.hidePreview();
    }

    public void com_android_settings_ChargingAnimationFragment__onResume$___twin___() {
        super.onResume();
        setVideoUri();
        this.mVideoPlayerView.start();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        if (r4 != this.mRightView) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "keyguard_charging_anim", this.mSelectAnimIndex);
        finish();
        return;
    L6:
        if (r4 != this.mDefaultIv) goto L9;
        this.mSelectAnimIndex = 0;
        this.mCheckDefaultIv.setVisibility(0);
        this.mCheckMoonIv.setVisibility(8);
        playVideo();
        return;
    L9:
        if (r4 != this.mMoonIv) goto L14;
        this.mSelectAnimIndex = 1;
        this.mCheckMoonIv.setVisibility(0);
        this.mCheckDefaultIv.setVisibility(8);
        playVideo();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChargingAnimationFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChargingAnimationFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChargingAnimationFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChargingAnimationFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChargingAnimationFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_ChargingAnimationFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
