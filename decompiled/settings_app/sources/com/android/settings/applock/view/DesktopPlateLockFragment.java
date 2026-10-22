package com.android.settings.applock.view;

import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class DesktopPlateLockFragment extends BaseFragment {
    public static final int FLIP_TO_LEFT = 0;
    public static final int FLIP_TO_RIGHT = 1;
    public static final int HAND_MODE_LEFT = 0;
    public static final int HAND_MODE_RIGHT = 1;
    private int mFlipMode;
    private boolean mNeedFinish;
    private int mOperateMode;

    public void com_android_settings_applock_view_DesktopPlateLockFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DesktopPlateLockFragment() {
    }

    public void com_android_settings_applock_view_DesktopPlateLockFragment__onCreate$___twin___(Bundle r3) {
        super.onCreate(r3);
        this.mNeedFinish = true;
        this.mOperateMode = Settings.Global.getInt(getContentResolver(), "one_hand_mode", 1);
        this.mFlipMode = Settings.Global.getInt(getContentResolver(), "launcher_switching_orientation", 0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.desktop_plate_lock, r3, false);
        ImageView r5 = (ImageView) NullSafe.nonNull(this.mRootView.findViewById(R.id.plate_lock_guide));
        TextView r6 = (TextView) NullSafe.nonNull(this.mRootView.findViewById(R.id.plate_lock_content));
        int r7 = this.mFlipMode;
        if (r7 != 0) goto L10;
        int r8 = this.mOperateMode;
        if (r8 != 0) goto L7;
        r5.setBackgroundResource(R.drawable.desktop_plate_lock_left_mode_to_left);
    L9:
        r6.setText(R.string.security_desk_plate_lock_content);
    L18:
        return this.mRootView;
    L7:
        if (r8 != 1) goto L9;
        r5.setBackgroundResource(R.drawable.desktop_plate_lock_right_mode_to_left);
        goto L9
    L10:
        if (r7 != 1) goto L18;
        int r9 = this.mOperateMode;
        if (r9 != 0) goto L14;
        r5.setBackgroundResource(R.drawable.desktop_plate_lock_left_mode_to_right);
    L16:
        r6.setText(R.string.security_desk_plate_lock_content_left);
        goto L18
    L14:
        if (r9 != 1) goto L16;
        r5.setBackgroundResource(R.drawable.desktop_plate_lock_right_mode_to_right);
        goto L16
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.mNeedFinish == false) goto L6;
        Utils.finishActivityDelay(getActivity());
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DesktopPlateLockFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_DesktopPlateLockFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DesktopPlateLockFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_DesktopPlateLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DesktopPlateLockFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_DesktopPlateLockFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
