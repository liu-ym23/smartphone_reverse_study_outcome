package com.android.settings.credential;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.android.settings.base.BaseActivity;
import com.android.settings.teaevent.AppMetricsUtils;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: compiled from: CredentialManagerAutofillStubActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u0002H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000f"}, d2 = {"Lcom/android/settings/credential/CredentialManagerAutofillStubActivity;", "Lcom/android/settings/base/BaseActivity;", "()V", "getBindFragment", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "shouldAutoBindFragment", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class CredentialManagerAutofillStubActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "CredentialManagerStub";

    /* JADX INFO: compiled from: CredentialManagerAutofillStubActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/settings/credential/CredentialManagerAutofillStubActivity$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$fpDR7bBnQEQv9rv--vN6Y8YliMw, reason: not valid java name */
    public static /* synthetic */ void m386$r8$lambda$fpDR7bBnQEQv9rvvN6Y8YliMw(CredentialManagerAutofillStubActivity r0) {
        onStart$lambda$0(r0);
    }

    static {
        Companion = new Companion(null);
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onStart(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // com.android.settings.base.BaseActivity
    public boolean shouldAutoBindFragment() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public CredentialManagerAutofillStubActivity() {
    }

    @Override // com.android.settings.base.BaseActivity
    public <T extends Fragment> T getBindFragment() {
        Intent r0 = getIntent();
        if (r0 == null) goto L5;
        String r1 = r0.getAction();
    L6:
        OLog.d(this.TAG, "Activity created with action: " + r1);
        return new AutofillServiceFragment();
    L5:
        r1 = null;
        goto L6
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        OLog.d(this.TAG, "CredentialManagerAutofillStubActivity onCreate");
        OLog.d(this.TAG, "zenglingwen intent: " + getIntent());
        String r5 = this.TAG;
        StringBuilder r0 = new StringBuilder("zenglingwen action: ");
        Intent r1 = getIntent();
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.getAction();
    L6:
        OLog.d(r5, r0.append(r3).toString());
        String r6 = this.TAG;
        StringBuilder r7 = new StringBuilder("zenglingwen data: ");
        Intent r8 = getIntent();
        if (r8 == null) goto L9;
        Uri r9 = r8.getData();
    L10:
        OLog.d(r6, r7.append(r9).toString());
        String r10 = this.TAG;
        StringBuilder r11 = new StringBuilder("zenglingwen scheme: ");
        Intent r12 = getIntent();
        if (r12 == null) goto L15;
        Uri r13 = r12.getData();
        if (r13 == null) goto L15;
        String r14 = r13.getScheme();
    L16:
        OLog.d(r10, r11.append(r14).toString());
        String r15 = this.TAG;
        StringBuilder r16 = new StringBuilder("zenglingwen ssp: ");
        Intent r17 = getIntent();
        if (r17 == null) goto L21;
        Uri r18 = r17.getData();
        if (r18 == null) goto L21;
        String r19 = r18.getSchemeSpecificPart();
    L22:
        OLog.d(r15, r16.append(r19).toString());
        String r20 = this.TAG;
        StringBuilder r21 = new StringBuilder("zenglingwen package: ");
        Intent r22 = getIntent();
        if (r22 == null) goto L25;
        r2 = r22.getPackage();
    L25:
        OLog.d(r20, r21.append(r2).toString());
        return;
    L21:
        r19 = null;
    L15:
        r14 = null;
        goto L16
    L9:
        r9 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public void com_android_settings_credential_CredentialManagerAutofillStubActivity__onStart$___twin___() {
        super.onStart();
        getWindow().getDecorView().post(new CredentialManagerAutofillStubActivity$$ExternalSyntheticLambda0(this));
    }

    private static final void onStart$lambda$0(CredentialManagerAutofillStubActivity r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        OLog.d(r1.TAG, "UI should now be fully visible for UI automation");
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(CredentialManagerAutofillStubActivity r1) {
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onCreate(CredentialManagerAutofillStubActivity r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialManagerAutofillStubActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_credential_CredentialManagerAutofillStubActivity__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_onResume(CredentialManagerAutofillStubActivity r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(CredentialManagerAutofillStubActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        CredentialManagerAutofillStubActivity r5 = r4;
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
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(CredentialManagerAutofillStubActivity r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_credential_CredentialManagerAutofillStubActivity__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_BatchedActivityLancet_onStop(CredentialManagerAutofillStubActivity r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onStart")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onStart(CredentialManagerAutofillStubActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialManagerAutofillStubActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStart();
        return;
    L6:
        r3.com_android_settings_credential_CredentialManagerAutofillStubActivity__onStart$___twin___();
    }

    @Insert("onResume")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onResume(CredentialManagerAutofillStubActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialManagerAutofillStubActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_credential_CredentialManagerAutofillStubActivity__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(CredentialManagerAutofillStubActivity r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onPause(CredentialManagerAutofillStubActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialManagerAutofillStubActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_credential_CredentialManagerAutofillStubActivity__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(CredentialManagerAutofillStubActivity r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        CredentialManagerAutofillStubActivity r5 = r3;
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
    public static void com_android_settings_credential_CredentialManagerAutofillStubActivity_com_obric_hook_lancet_PrivacyHook_onStop(CredentialManagerAutofillStubActivity r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        CredentialManagerAutofillStubActivity r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_credential_CredentialManagerAutofillStubActivity__onStop$___twin___();
    }
}
