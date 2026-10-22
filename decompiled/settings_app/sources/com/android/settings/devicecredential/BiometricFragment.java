package com.android.settings.devicecredential;

import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.hardware.biometrics.PromptInfo;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Flags;
import android.text.TextUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BiometricFragment extends InstrumentedFragment {
    private static final String KEY_PROMPT_INFO = "prompt_info";
    private static final String TAG = "ConfirmDeviceCredential/BiometricFragment";
    private BiometricPrompt.AuthenticationCallback mAuthenticationCallback;
    private BiometricPrompt mBiometricPrompt;
    private CancellationSignal mCancellationSignal;
    private BiometricPrompt.AuthenticationCallback mClientCallback;
    private Executor mClientExecutor;
    private int mUserId;

    /* JADX INFO: renamed from: com.android.settings.devicecredential.BiometricFragment$1, reason: invalid class name */
    class AnonymousClass1 extends BiometricPrompt.AuthenticationCallback {
        final /* synthetic */ BiometricFragment this$0;

        AnonymousClass1(BiometricFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(final int r3, final CharSequence r4) {
            BiometricFragment.access$000(this.this$0).execute(new BiometricFragment$1$$ExternalSyntheticLambda3(this, r3, r4));
            BiometricFragment.access$100(this.this$0);
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationError$0$com-android-settings-devicecredential-BiometricFragment$1, reason: not valid java name */
        /* synthetic */ void m428x7b1f7911(int r1, CharSequence r2) {
            BiometricFragment.access$200(this.this$0).onAuthenticationError(r1, r2);
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(final BiometricPrompt.AuthenticationResult r3) {
            BiometricFragment.access$000(this.this$0).execute(new BiometricFragment$1$$ExternalSyntheticLambda0(this, r3));
            BiometricFragment.access$100(this.this$0);
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationSucceeded$1$com-android-settings-devicecredential-BiometricFragment$1, reason: not valid java name */
        /* synthetic */ void m430x452dacab(BiometricPrompt.AuthenticationResult r1) {
            BiometricFragment.access$200(this.this$0).onAuthenticationSucceeded(r1);
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            BiometricFragment.access$000(this.this$0).execute(new BiometricFragment$1$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationFailed$2$com-android-settings-devicecredential-BiometricFragment$1, reason: not valid java name */
        /* synthetic */ void m429x63b9baf0() {
            BiometricFragment.access$200(this.this$0).onAuthenticationFailed();
        }

        public void onSystemEvent(final int r3) {
            BiometricFragment.access$000(this.this$0).execute(new BiometricFragment$1$$ExternalSyntheticLambda2(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onSystemEvent$3$com-android-settings-devicecredential-BiometricFragment$1, reason: not valid java name */
        /* synthetic */ void m431xa93e6c0f(int r1) {
            BiometricFragment.access$200(this.this$0).onSystemEvent(r1);
        }
    }

    @Override // com.android.settingslib.core.instrumentation.Instrumentable
    public int getMetricsCategory() {
        return 1585;
    }

    @Override // com.android.settingslib.core.lifecycle.ObservableFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.devicecredential.InstrumentedFragment, com.android.settingslib.core.lifecycle.ObservableFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public BiometricFragment() {
        this.mAuthenticationCallback = new AnonymousClass1(this);
    }

    static /* synthetic */ Executor access$000(BiometricFragment r0) {
        return r0.mClientExecutor;
    }

    static /* synthetic */ void access$100(BiometricFragment r0) {
        r0.cleanup();
    }

    static /* synthetic */ BiometricPrompt.AuthenticationCallback access$200(BiometricFragment r0) {
        return r0.mClientCallback;
    }

    public static BiometricFragment newInstance(PromptInfo r3) {
        BiometricFragment r0 = new BiometricFragment();
        Bundle r1 = new Bundle();
        r1.putParcelable(KEY_PROMPT_INFO, r3);
        r0.setArguments(r1);
        return r0;
    }

    public void setCallbacks(Executor r1, BiometricPrompt.AuthenticationCallback r2) {
        this.mClientExecutor = r1;
        this.mClientCallback = r2;
    }

    public void setUser(int r1) {
        this.mUserId = r1;
    }

    public void cancel() {
        CancellationSignal r0 = this.mCancellationSignal;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        cleanup();
    }

    private void cleanup() {
        if (getActivity() == null) goto L6;
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    }

    public void com_android_settings_devicecredential_BiometricFragment__onCreate$___twin___(Bundle r6) {
        super.onCreate(r6);
        setRetainInstance(true);
        PromptInfo r0 = getArguments().getParcelable(KEY_PROMPT_INFO);
        BiometricPrompt.Builder r1 = new BiometricPrompt.Builder(getContext()).setTitle(r0.getTitle()).setUseDefaultTitle().setAllowedAuthenticators(r0.getAuthenticators()).setSubtitle(r0.getSubtitle()).setDescription(r0.getDescription()).setTextForDeviceCredential(r0.getDeviceCredentialTitle(), r0.getDeviceCredentialSubtitle(), r0.getDeviceCredentialDescription()).setConfirmationRequired(r0.isConfirmationRequested()).setDisallowBiometricsIfPolicyExists(r0.isDisallowBiometricsIfPolicyExists()).setShowEmergencyCallButton(r0.isShowEmergencyCallButton()).setReceiveSystemEvents(true).setRealCallerForConfirmDeviceCredentialActivity(r0.getRealCallerForConfirmDeviceCredentialActivity());
        if (r0.getLogoRes() == 0) goto L5;
        r1.setLogoRes(r0.getLogoRes());
    L5:
        String r2 = r0.getLogoDescription();
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r1.setLogoDescription(r2);
    L9:
        if (Flags.allowPrivateProfile() == true) goto L11;
    L15:
        BiometricPrompt.Builder r7 = r1.setAllowBackgroundAuthentication(true);
    L17:
        if (r0.isUseDefaultSubtitle() == false) goto L20;
        r7.setUseDefaultSubtitle();
    L20:
        if ((r0.getAuthenticators() & 32768) != 0) goto L22;
        r7.setNegativeButton(r0.getNegativeButtonText(), getContext().getMainExecutor(), new BiometricFragment$$ExternalSyntheticLambda0(this));
    L22:
        this.mBiometricPrompt = r7.build();
        return;
    L11:
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L15;
        if (android.multiuser.Flags.enableBiometricsToUnlockPrivateSpace() == false) goto L15;
        r7 = r1.setAllowBackgroundAuthentication(true, r0.shouldUseParentProfileForDeviceCredential());
        goto L17
    }

    /* JADX INFO: renamed from: lambda$onCreate$0$com-android-settings-devicecredential-BiometricFragment, reason: not valid java name */
    /* synthetic */ void m427xf18cb388(DialogInterface r1, int r2) {
        this.mAuthenticationCallback.onAuthenticationError(10, null);
    }

    public void com_android_settings_devicecredential_BiometricFragment__onResume$___twin___() {
        super.onResume();
        if (this.mCancellationSignal != null) goto L6;
        CancellationSignal r0 = new CancellationSignal();
        this.mCancellationSignal = r0;
        this.mBiometricPrompt.authenticateUser(r0, this.mClientExecutor, this.mAuthenticationCallback, this.mUserId);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BiometricFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_devicecredential_BiometricFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BiometricFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_devicecredential_BiometricFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BiometricFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_devicecredential_BiometricFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
