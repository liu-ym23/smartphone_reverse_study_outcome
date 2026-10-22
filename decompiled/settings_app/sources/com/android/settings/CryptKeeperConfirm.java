package com.android.settings;

import android.app.StatusBarManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.preference.PreferenceFragmentCompat;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import com.obric.privacy.LifeHookActivity2;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CryptKeeperConfirm extends PreferenceFragmentCompat {
    private static final String TAG = "CryptKeeperConfirm";
    private View mContentView;
    private Button mFinalButton;
    private View.OnClickListener mFinalClickListener;

    public static class Blank extends LifeHookActivity2 {
        private Handler mHandler;

        public void com_android_settings_CryptKeeperConfirm$Blank__onPause$___twin___() {
            super.onPause();
        }

        public void com_android_settings_CryptKeeperConfirm$Blank__onResume$___twin___() {
            super.onResume();
        }

        public void com_android_settings_CryptKeeperConfirm$Blank__onStop$___twin___() {
            super.onStop();
        }

        public void com_android_settings_CryptKeeperConfirm$Blank__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
            super.startActivityForResult(r1, r2, r3);
        }

        @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
        public void onCreate(Bundle r1) {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onPause() {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onResume() {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
        }

        @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
        public void onStop() {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
        }

        @Override // androidx.activity.ComponentActivity, android.app.Activity
        public void startActivityForResult(Intent r1, int r2, Bundle r3) {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
        }

        public Blank() {
            this.mHandler = new Handler();
        }

        public void com_android_settings_CryptKeeperConfirm$Blank__onCreate$___twin___(Bundle r4) {
            super.onCreate(r4);
            setContentView(R.layout.crypt_keeper_blank);
            if (Utils.isMonkeyRunning() == false) goto L5;
            finish();
        L5:
            StatusBarManager r5 = (StatusBarManager) getSystemService("statusbar");
            if (r5 == null) goto L8;
            r5.disable(58130432);
        L8:
            this.mHandler.postDelayed(new AnonymousClass1(this), 700);
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(Blank r1) {
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onStop(r1);
            if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
            return;
        L8:
            r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
            return;
        }

        @Insert("onCreate")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(Blank r3, Bundle r4) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            Blank r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onCreateWhenPrivacyNotOk(null);
            r0.onSuperCreate(null);
            return;
        L6:
            GrantUtil.INSTANCE.applicationInit();
            r3.com_android_settings_CryptKeeperConfirm$Blank__onCreate$___twin___(r4);
        }

        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_onResume(Blank r1) {
            String r0 = r1.getClass().getName();
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            AppMetricsUtils.INSTANCE.activityEventEnd(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(Blank r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onResume(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
            OLog.i("AppLifecycle", "onResume_Activity " + r0);
            AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r1.recordVisibleTime(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
            Blank r5 = r4;
            String r2 = r5.getCallingPackage();
            if (r2 != null) goto L9;
            OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
            Uri r6 = r5.getReferrer();
            if (r6 == null) goto L9;
            r2 = r6.toString();
        L9:
            OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
            if (r2 != null) goto L12;
            r2 = "null";
        L12:
            AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
        L13:
            AppMetricsUtils.INSTANCE.setColdStartTime(0);
        }

        @Insert(mayCreateSuper = true, value = "startActivityForResult")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(Blank r2, Intent r3, int r4, Bundle r5) {
            Intrinsics.checkNotNullParameter(r3, "intent");
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStart(r0);
        L5:
            r2.com_android_settings_CryptKeeperConfirm$Blank__startActivityForResult$___twin___(r3, r4, r5);
        }

        @Insert(mayCreateSuper = true, value = "onStop")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_BatchedActivityLancet_onStop(Blank r2) {
            String r0 = r2.getClass().getName();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
            AppMetricsUtils.INSTANCE.activityEventStoped(r0);
        L5:
            com_android_settings_CryptKeeperConfirm$Blank_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
        }

        @Insert("onResume")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onResume(Blank r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            Blank r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperResume();
            return;
        L6:
            r3.com_android_settings_CryptKeeperConfirm$Blank__onResume$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onPause")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(Blank r4) {
            String r0 = r4.getClass().getName();
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onPause(r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_Activity " + r0);
            AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
            return;
        }

        @Insert("onPause")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onPause(Blank r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            Blank r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperPause();
            return;
        L6:
            r3.com_android_settings_CryptKeeperConfirm$Blank__onPause$___twin___();
        }

        @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(Blank r3, Bundle r4) {
            String r0 = r3.getClass().getName();
            com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(r3, r4);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
            OLog.i("AppLifecycle", "onCreate_Activity " + r0);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
            Blank r5 = r3;
            String r6 = r5.getCallingPackage();
            if (r6 != null) goto L9;
            OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
            Uri r7 = r5.getReferrer();
            if (r7 == null) goto L9;
            r6 = r7.toString();
        L9:
            OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
            if (r6 != null) goto L12;
            r6 = "null";
        L12:
            AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r8.callingPackageEvent(r6, r0, false);
            return;
        }

        @Insert("onStop")
        public static void com_android_settings_CryptKeeperConfirm$Blank_com_obric_hook_lancet_PrivacyHookActivity2_onStop(Blank r3) {
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
            Blank r0 = r3;
            if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
            r0.onSuperStop();
            return;
        L6:
            r3.com_android_settings_CryptKeeperConfirm$Blank__onStop$___twin___();
        }
    }

    public void com_android_settings_CryptKeeperConfirm__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_CryptKeeperConfirm__onResume$___twin___() {
        super.onResume();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public CryptKeeperConfirm() {
        this.mFinalClickListener = new AnonymousClass1(this);
    }

    private void establishFinalConfirmationState() {
        Button r0 = (Button) this.mContentView.findViewById(R.id.execute_encrypt);
        this.mFinalButton = r0;
        r0.setOnClickListener(this.mFinalClickListener);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        this.mContentView = r1.inflate(R.layout.crypt_keeper_confirm, null);
        establishFinalConfirmationState();
        return this.mContentView;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CryptKeeperConfirm r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CryptKeeperConfirm__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CryptKeeperConfirm r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_CryptKeeperConfirm_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CryptKeeperConfirm r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_CryptKeeperConfirm__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
