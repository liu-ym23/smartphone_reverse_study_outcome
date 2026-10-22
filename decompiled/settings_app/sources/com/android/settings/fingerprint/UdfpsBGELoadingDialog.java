package com.android.settings.fingerprint;

import android.app.Activity;
import android.hardware.fingerprint.FingerprintManager;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.UserHandle;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.LockPatternCheckerOnly;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.texteffects.preset.DimPointEffectTokens;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: UdfpsBGELoadingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BR\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\u0002\u0010\u0012J\u0006\u0010'\u001a\u00020\u0011J\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\u0011H\u0002J\u0006\u0010-\u001a\u00020\u0011J\u0006\u0010.\u001a\u00020\u0011J\u001a\u0010/\u001a\u00020\u00112\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u001bH\u0002R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001e\u001a\u0010\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/android/settings/fingerprint/UdfpsBGELoadingDialog;", "", "activity", "Landroid/app/Activity;", "title", "", "password", "Lcom/android/internal/widget/LockscreenCredential;", "sensorId", "", "sensorType", "actionCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "ba", "", "(Landroid/app/Activity;Ljava/lang/String;Lcom/android/internal/widget/LockscreenCredential;IILkotlin/jvm/functions/Function1;)V", "TAG", "getActionCallback", "()Lkotlin/jvm/functions/Function1;", "getActivity", "()Landroid/app/Activity;", "fingerprintManager", "Landroid/hardware/fingerprint/FingerprintManager;", "mChallenge", "", "mLockPatternUtils", "Lcom/android/internal/widget/LockPatternUtils;", "mPendingLockCheck", "Landroid/os/AsyncTask;", "getPassword", "()Lcom/android/internal/widget/LockscreenCredential;", "getSensorId", "()I", "getSensorType", "statusDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "dismiss", "genGenerateChallengeCallbackForGenerateChallenge", "Landroid/hardware/fingerprint/FingerprintManager$GenerateChallengeCallback;", "source", "originSensorId", "generateChallenge", "hide", "show", "startEnrollingActivity", "token", "Lcom/android/internal/widget/VerifyCredentialResponse;", "backIsCancel", "", "verify", "challenge", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UdfpsBGELoadingDialog {
    private final String TAG;
    private final Function1<byte[], Unit> actionCallback;
    private final Activity activity;
    private final FingerprintManager fingerprintManager;
    private long mChallenge;
    private LockPatternUtils mLockPatternUtils;
    private AsyncTask<?, ?, ?> mPendingLockCheck;
    private final LockscreenCredential password;
    private final int sensorId;
    private final int sensorType;
    private StatusDialog statusDialog;

    public static /* synthetic */ void $r8$lambda$Aki1rwg1r8Z8Fx4wJpddu5EwFkU(long r0, UdfpsBGELoadingDialog r2, VerifyCredentialResponse r3, int r4) {
        verify$lambda$4(r0, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$CXZkoVN2O1zTCzG5aTYurDMfFOg(UdfpsBGELoadingDialog r0, VerifyCredentialResponse r1) {
        verify$lambda$4$lambda$3(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$S6OrH_Uoa17bkJsDXAR94CTFreo(long r0, UdfpsBGELoadingDialog r2, VerifyCredentialResponse r3, int r4) {
        verify$lambda$2(r0, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$T8C8FV4Vkb0LFjv3EteRJQ0tD3Y(UdfpsBGELoadingDialog r0, VerifyCredentialResponse r1) {
        verify$lambda$2$lambda$1(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uFE4uL8I-aJPQb2bliT-T85HSc4, reason: not valid java name */
    public static /* synthetic */ void m474$r8$lambda$uFE4uL8IaJPQb2bliTT85HSc4(UdfpsBGELoadingDialog r0, String r1, int r2, int r3, int r4, long r5) {
        genGenerateChallengeCallbackForGenerateChallenge$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UdfpsBGELoadingDialog(Activity r2, String r3, LockscreenCredential r4, int r5, int r6, Function1<? super byte[], Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "password");
        Intrinsics.checkNotNullParameter(r7, "actionCallback");
        this.activity = r2;
        this.password = r4;
        this.sensorId = r5;
        this.sensorType = r6;
        this.actionCallback = r7;
        this.TAG = Reflection.getOrCreateKotlinClass(UdfpsBGELoadingDialog.class).getSimpleName();
        Activity r8 = r2;
        this.statusDialog = new StatusDialog(r8, new StatusDialog.Modifier(r3, "", null, null));
        FingerprintManager r9 = (FingerprintManager) r2.getSystemService("fingerprint");
        Intrinsics.checkNotNull(r9);
        this.fingerprintManager = r9;
        LockPatternUtils r10 = new ChooseLockSettingsHelper(r2).utils();
        Intrinsics.checkNotNullExpressionValue(r10, "utils(...)");
        this.mLockPatternUtils = r10;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final LockscreenCredential getPassword() {
        return this.password;
    }

    public final int getSensorId() {
        return this.sensorId;
    }

    public final int getSensorType() {
        return this.sensorType;
    }

    public final Function1<byte[], Unit> getActionCallback() {
        return this.actionCallback;
    }

    public final void show() {
        this.statusDialog.show();
        generateChallenge();
    }

    public final void dismiss() {
        this.statusDialog.dismiss();
    }

    public final void hide() {
        this.statusDialog.hide();
    }

    private final FingerprintManager.GenerateChallengeCallback genGenerateChallengeCallbackForGenerateChallenge(final String r4, final int r5) {
        OLog.i(this.TAG, "genGenerateChallengeCallbackForGenerateChallenge, source: " + r4 + ", originSensorId: " + r5 + ", sensorType: " + this.sensorType);
        return new UdfpsBGELoadingDialog$$ExternalSyntheticLambda3(this, r4, r5);
    }

    private static final void genGenerateChallengeCallbackForGenerateChallenge$lambda$0(UdfpsBGELoadingDialog r2, String r3, int r4, int r5, int r6, long r7) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        Intrinsics.checkNotNullParameter(r3, "$source");
        OLog.e(r2.TAG, "onChallengeGenerated, startEnrolling challenge: " + r7 + ", sensorId: " + r5 + ", source: " + r3 + ", originSensorId: " + r4 + ", sensorType: " + r2.sensorType);
        r2.verify(r7);
    }

    private final void generateChallenge() {
        int r0 = this.sensorId;
        if (r0 == (-1)) goto L5;
        this.fingerprintManager.generateChallenge(r0, UserHandle.myUserId(), genGenerateChallengeCallbackForGenerateChallenge("withSensorId", this.sensorId));
        return;
    L5:
        this.fingerprintManager.generateChallenge(UserHandle.myUserId(), genGenerateChallengeCallbackForGenerateChallenge("withoutSensorId", -1));
    }

    private final void verify(long r11) {
        OLog.e(this.TAG, "verify challenge " + r11);
        this.mChallenge = r11;
        AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.cancel(false);
    L6:
        final long r1 = System.currentTimeMillis();
        if (this.password.isPattern() == false) goto L9;
        OLog.i(this.TAG, "startEnrolling verifyPattern");
        this.mPendingLockCheck = LockPatternCheckerOnly.verifyPattern2(this.mLockPatternUtils, this.password, r11, UserHandle.myUserId(), new UdfpsBGELoadingDialog$$ExternalSyntheticLambda0(r1, this));
        return;
    L9:
        OLog.i(this.TAG, "startEnrolling verifyPassword");
        this.mPendingLockCheck = LockPatternCheckerOnly.verifyPassword2(this.mLockPatternUtils, this.password, r11, Utils.getEffectiveUserId(this.activity), new UdfpsBGELoadingDialog$$ExternalSyntheticLambda1(r1, this));
    }

    private static final void verify$lambda$2(long r2, final UdfpsBGELoadingDialog r4, final VerifyCredentialResponse r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "token");
        OLog.d(r4.TAG, "pattern onVerified, token = " + r5 + ", use time: " + (System.currentTimeMillis() - r2));
        r4.mPendingLockCheck = null;
        new Handler().postDelayed(new UdfpsBGELoadingDialog$$ExternalSyntheticLambda2(r4, r5), DimPointEffectTokens.PendingCycleMs);
    }

    private static final void verify$lambda$2$lambda$1(UdfpsBGELoadingDialog r1, VerifyCredentialResponse r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$token");
        r1.startEnrollingActivity(r2, false);
    }

    private static final void verify$lambda$4(long r2, final UdfpsBGELoadingDialog r4, final VerifyCredentialResponse r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        Intrinsics.checkNotNullParameter(r5, "token");
        OLog.d(r4.TAG, "password onVerified, token = " + r5 + ", use time: " + (System.currentTimeMillis() - r2));
        r4.mPendingLockCheck = null;
        new Handler().postDelayed(new UdfpsBGELoadingDialog$$ExternalSyntheticLambda4(r4, r5), DimPointEffectTokens.PendingCycleMs);
    }

    private static final void verify$lambda$4$lambda$3(UdfpsBGELoadingDialog r1, VerifyCredentialResponse r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$token");
        r1.startEnrollingActivity(r2, false);
    }

    private final void startEnrollingActivity(VerifyCredentialResponse r7, boolean r8) {
        OLog.e(this.TAG, "startEnrollingActivity token=" + r7);
        if (r7 == null) goto L12;
        byte[] r9 = r7.getGatekeeperHAT();
        if (r9 != null) goto L7;
        r9 = BaseFingerprintEnrollingActivity.requestGatekeeperHat(this.activity, r7.getGatekeeperPasswordHandle(), UserHandle.myUserId(), this.mChallenge);
    L7:
        String r10 = this.TAG;
        StringBuilder r0 = new StringBuilder("startEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: ba==null ");
        if (r9 != null) goto L10;
        boolean r1 = true;
    L11:
        OLog.i(r10, r0.append(r1).toString());
    L13:
        this.actionCallback.invoke(r9);
        return;
    L10:
        r1 = false;
        goto L11
    L12:
        OLog.i(this.TAG, "startEnrollingActivity EXTRA_KEY_CHALLENGE_TOKEN: token is null");
        r9 = null;
        goto L13
    }
}
