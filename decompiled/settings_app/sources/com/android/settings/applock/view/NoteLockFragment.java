package com.android.settings.applock.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class NoteLockFragment extends BaseFragment {
    private boolean mNeedFinish;

    static /* synthetic */ void lambda$onCreateView$0(View r0) {
    }

    public void com_android_settings_applock_view_NoteLockFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NoteLockFragment() {
    }

    public void com_android_settings_applock_view_NoteLockFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mNeedFinish = true;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.note_lock, r3, false);
        ((OFloatingTitleBar) findViewByIdNullable(R.id.view_title)).addEndAction(R.string.go_to_use, -1, null).setOnClickListener(new NoteLockFragment$$ExternalSyntheticLambda0());
        return this.mRootView;
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
    public static void com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NoteLockFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_NoteLockFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NoteLockFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_applock_view_NoteLockFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NoteLockFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_applock_view_NoteLockFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
