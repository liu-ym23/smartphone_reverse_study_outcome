package com.android.settings.provision;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.settings.R;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButton;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProvisonBaseActivity extends BaseActivity {
    private static final String TAG = "ProvisionBaseActivity";
    private OButton mBottomButton;
    private View mTitleBarContainer;

    public void com_android_settings_provision_ProvisonBaseActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_provision_ProvisonBaseActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_provision_ProvisonBaseActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        return null;
    }

    protected int getBottomStringId(int r1) {
        return R.string.next_step;
    }

    protected abstract int getContentLayoutId();

    protected boolean getShowBack() {
        return true;
    }

    protected abstract int getTitleId();

    protected abstract void nextStep(int r1);

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ProvisonBaseActivity() {
    }

    private void setupTitleBar(boolean r3, int r4) {
        this.mTitleBarContainer = findViewById(R.id.titlebar_container);
        OIconButton r0 = (OIconButton) findViewById(R.id.titlebar_back_btn);
        if (r0 == null) goto L9;
        r0.setOnClickListener(new ProvisonBaseActivity$$ExternalSyntheticLambda1(this));
        if (r3 == false) goto L7;
        int r5 = 0;
    L8:
        r0.setVisibility(r5);
        goto L9
    L7:
        r5 = 8;
    L9:
        TextView r2 = (TextView) findViewById(R.id.titlebar_title_tv);
        if (r2 == null) goto L13;
        r2.setText(r4);
        return;
    }

    /* JADX INFO: renamed from: lambda$setupTitleBar$0$com-android-settings-provision-ProvisonBaseActivity, reason: not valid java name */
    /* synthetic */ void m548xcd2c38ad(View r1) {
        onBackPressed();
    }

    public void com_android_settings_provision_ProvisonBaseActivity__onCreate$___twin___(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.activity_base);
        setupTitleBar(getShowBack(), getTitleId());
        OButton r0 = (OButton) findViewById(R.id.bottom_button);
        this.mBottomButton = r0;
        if (r0 == null) goto L5;
        r0.setText(getBottomStringId(0));
        this.mBottomButton.setOnClickListener(new ProvisonBaseActivity$$ExternalSyntheticLambda0(this));
    L5:
        FrameLayout r1 = (FrameLayout) findViewById(R.id.content_frame);
        LayoutInflater r2 = getLayoutInflater();
        if (getContentLayoutId() <= 0) goto L8;
        r1.addView(r2.inflate(getContentLayoutId(), r1, false));
        return;
    L8:
        bindFragment(r5);
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-provision-ProvisonBaseActivity, reason: not valid java name */
    /* synthetic */ void m547x639b584b(View r1) {
        nextStep(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindFragment(Bundle r2) {
        if (r2 == null) goto L4;
        return;
    L4:
        Fragment r3 = getBindFragment();
        if (r3 != null) goto L8;
        finish();
        return;
    L8:
        r3.setArguments(getIntent().getExtras());
        Fragment r0 = findFragment(r3.getClass());
        if (r0 != null) goto L11;
        loadRootFragment(R.id.content_frame, r3);
        return;
    L11:
        OLog.d(TAG, "no need load root fragment " + r0);
    }

    public void com_android_settings_provision_ProvisonBaseActivity__onResume$___twin___() {
        super.onResume();
    }

    public void updateRootView() {
        View r2 = findViewById(R.id.root_view);
        if (r2 == null) goto L6;
        OLog.e(TAG, "setPaddings 0 ");
        r2.setPadding(0, 0, 0, 0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ProvisonBaseActivity r1) {
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(ProvisonBaseActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvisonBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_provision_ProvisonBaseActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(ProvisonBaseActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ProvisonBaseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ProvisonBaseActivity r5 = r4;
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
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ProvisonBaseActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_provision_ProvisonBaseActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(ProvisonBaseActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_provision_ProvisonBaseActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onResume(ProvisonBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvisonBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_provision_ProvisonBaseActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ProvisonBaseActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onPause(ProvisonBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvisonBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_provision_ProvisonBaseActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ProvisonBaseActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ProvisonBaseActivity r5 = r3;
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
    public static void com_android_settings_provision_ProvisonBaseActivity_com_obric_hook_lancet_PrivacyHook_onStop(ProvisonBaseActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ProvisonBaseActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_provision_ProvisonBaseActivity__onStop$___twin___();
    }
}
