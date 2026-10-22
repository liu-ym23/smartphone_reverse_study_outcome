package com.android.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSimRename extends BaseActivity {
    private EditText mEditor;
    private int simIndex;

    public void com_android_settings_MultiSimRename__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_MultiSimRename__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_MultiSimRename__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_MultiSimRename__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public MultiSimRename() {
    }

    static /* synthetic */ EditText access$000(MultiSimRename r0) {
        return r0.mEditor;
    }

    static /* synthetic */ int access$100(MultiSimRename r0) {
        return r0.simIndex;
    }

    public void com_android_settings_MultiSimRename__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.sim_rename_layout);
        this.simIndex = Utils.getIntExtraSafely(getIntent(), MultiSimSettings.EXTRA_SIM_INDEX, 0);
        this.mEditor = (EditText) findViewById(R.id.sim_name);
        String r5 = MultiSimUtil.getSimNameInDb(this, this.simIndex);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        this.mEditor.setText(r5);
    L6:
        EditText r6 = this.mEditor;
        r6.setSelection(r6.getText().length());
        this.mEditor.setSelectAllOnFocus(true);
        this.mEditor.addTextChangedListener(new AnonymousClass1(this));
        this.mTitle = setupBackBtnOnTitle(false);
        this.mTitle.addEndAction(R.drawable.standard_icon_hignlight_confirm_selector, -1, null).setOnClickListener(new AnonymousClass2(this));
        new Handler().postDelayed(new MultiSimRename$$ExternalSyntheticLambda0(this), 300);
        return;
    L5:
        this.mEditor.setHint(MultiSimSettings.getSimName(this, this.simIndex));
        goto L6
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-MultiSimRename, reason: not valid java name */
    /* synthetic */ void m159lambda$onCreate$0$comandroidsettingsMultiSimRename() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L13;
        EditText r0 = this.mEditor;
        if (r0 == null) goto L12;
        r0.requestFocus();
        ((InputMethodManager) getSystemService("input_method")).showSoftInput(this.mEditor, 0);
        return;
    L12:
        return;
    }

    public static String getStringInLengthLimit(CharSequence r8) {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
        int r2 = 0;
        boolean r3 = false;
    L4:
        if (r1 >= r8.length()) goto L22;
        char r4 = r8.charAt(r1);
        String r5 = Character.toString(r4);
        if (Character.isHighSurrogate(r4) == true) goto L22;
        boolean r7 = true;
        if (r5.matches("[Α-￥]") == false) goto L12;
        r2 = r2 + 2;
    L18:
        if (r2 > 8) goto L22;
        r0.append(r5);
        r3 = r7;
    L20:
        r1 = r1 + 1;
        goto L4
    L12:
        if (Character.isSpaceChar(r4) == true) goto L14;
        r3 = true;
    L16:
        r2 = r2 + 1;
        r7 = r3;
        goto L18
    L14:
        if (r3 == true) goto L16;
    L22:
        return r0.toString();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimRename_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(MultiSimRename r1) {
        com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onCreate(MultiSimRename r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimRename r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_MultiSimRename__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_onResume(MultiSimRename r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(MultiSimRename r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        MultiSimRename r5 = r4;
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
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(MultiSimRename r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_MultiSimRename__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_BatchedActivityLancet_onStop(MultiSimRename r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_MultiSimRename_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onResume(MultiSimRename r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimRename r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_MultiSimRename__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(MultiSimRename r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onPause(MultiSimRename r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimRename r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_MultiSimRename__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(MultiSimRename r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        MultiSimRename r5 = r3;
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
    public static void com_android_settings_MultiSimRename_com_obric_hook_lancet_PrivacyHook_onStop(MultiSimRename r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        MultiSimRename r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_MultiSimRename__onStop$___twin___();
    }
}
