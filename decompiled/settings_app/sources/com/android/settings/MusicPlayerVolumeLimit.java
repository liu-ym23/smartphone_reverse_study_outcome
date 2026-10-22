package com.android.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.slider.OSlider;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class MusicPlayerVolumeLimit extends BaseFragment {
    private OSlider mSeekBar;
    private TextView mVolumeLimitTips;

    public void com_android_settings_MusicPlayerVolumeLimit__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_MusicPlayerVolumeLimit__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MusicPlayerVolumeLimit() {
    }

    static /* synthetic */ void access$000(MusicPlayerVolumeLimit r0, int r1) {
        r0.setVolumeLimit(r1);
    }

    static /* synthetic */ void access$100(MusicPlayerVolumeLimit r0, int r1) {
        r0.setTips(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.music_player_volume_limit, r3, false);
        OSlider r5 = (OSlider) findViewByIdNullable(R.id.seekbar_layout);
        this.mSeekBar = r5;
        r5.setMaxValue(100.0f);
        this.mSeekBar.setOnSeekBarChangeListenerExt(new AnonymousClass1(this));
        this.mVolumeLimitTips = (TextView) findViewByIdNullable(R.id.volume_limit_tips);
        int r6 = getCurrentVolumeLimit(this.mContext);
        this.mSeekBar.setProgress(r6);
        setTips(r6);
        return this.mRootView;
    }

    private void setTips(int r4) {
        this.mVolumeLimitTips.setText(String.format(getString(R.string.headset_max_volume_limit_tips), new Object[]{Integer.valueOf(r4)}));
    }

    public static int getCurrentVolumeLimit(Context r2) {
        return android.provider.Settings.Global.getInt(r2.getContentResolver(), "volume_limit", 100);
    }

    private void setVolumeLimit(int r2) {
        android.provider.Settings.Global.putInt(getContentResolver(), "volume_limit", r2);
    }

    private int dip2px(float r1) {
        return (int) ((r1 * this.mContext.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MusicPlayerVolumeLimit r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MusicPlayerVolumeLimit__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MusicPlayerVolumeLimit r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MusicPlayerVolumeLimit_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MusicPlayerVolumeLimit r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MusicPlayerVolumeLimit__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
