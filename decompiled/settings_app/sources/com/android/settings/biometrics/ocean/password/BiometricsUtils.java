package com.android.settings.biometrics.ocean.password;

import android.content.Context;
import android.content.Intent;
import android.hardware.face.FaceManager;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.VerifyCredentialResponse;
import com.android.settings.Utils;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BiometricsUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Je\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\fH\u0007J,\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J8\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\n2\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00060\u0019H\u0007J*\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/android/settings/biometrics/ocean/password/BiometricsUtils;", "", "()V", "EXTRA_ENROLL_REASON", "", "getChallenge", "", "context", "Landroid/content/Context;", AccountInfoBundleKey.USER_ID, "", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "sensorId", "", "challenge", "requestGatekeeperHat", "", "intent", "Landroid/content/Intent;", ApmTrafficStats.TTNET_RESPONSE, "Lcom/android/internal/widget/VerifyCredentialResponse;", "onDone", "Lkotlin/Function1;", "gkPwHandle", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BiometricsUtils {
    public static final String EXTRA_ENROLL_REASON = "BiometricManager.EXTRA_ENROLL_REASON";
    public static final BiometricsUtils INSTANCE = null;

    public static /* synthetic */ void $r8$lambda$sH8oMsPPRgtZHc4jWwJuBhgt29Y(Function3 r0, int r1, int r2, long r3) {
        getChallenge$lambda$0(r0, r1, r2, r3);
    }

    static {
        INSTANCE = new BiometricsUtils();
    }

    private BiometricsUtils() {
    }

    @JvmStatic
    public static final void getChallenge(Context r1, int r2, final Function3<? super Integer, ? super Integer, ? super Long, Unit> r3) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r3, "callback");
        FaceManager r4 = Utils.getFaceManagerOrNull(r1);
        if (r4 == null) goto L6;
        r4.generateChallenge(r2, new BiometricsUtils$$ExternalSyntheticLambda0(r3));
        return;
    }

    private static final void getChallenge$lambda$0(Function3 r1, int r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r1, "$callback");
        r1.invoke(Integer.valueOf(r2), Integer.valueOf(r3), Long.valueOf(r4));
    }

    @JvmStatic
    public static final byte[] requestGatekeeperHat(Context r9, Intent r10, int r11, long r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if (r10 == null) goto L7;
        return requestGatekeeperHat(r9, r10.getLongExtra("gk_pw_handle", 0), r11, r12);
    L7:
        throw new IllegalStateException("Gatekeeper Password is missing!!".toString());
    }

    @JvmStatic
    public static final byte[] requestGatekeeperHat(Context r7, long r8, int r10, long r11) {
        Intrinsics.checkNotNullParameter(r7, "context");
        VerifyCredentialResponse r9 = new LockPatternUtils(r7).verifyGatekeeperPasswordHandle(r8, r11, r10);
        Intrinsics.checkNotNullExpressionValue(r9, "verifyGatekeeperPasswordHandle(...)");
        if (r9.isMatched() == false) goto L7;
        return r9.getGatekeeperHAT();
    L7:
        throw new IllegalStateException("Unable to request Gatekeeper HAT".toString());
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [byte[], java.lang.Object] */
    @JvmStatic
    public static final void requestGatekeeperHat(final Context r3, final VerifyCredentialResponse r4, final int r5, final Function1<? super byte[], Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r6, "onDone");
        if (r4 == null) goto L17;
        ?? r0 = r4.getGatekeeperHAT();
        if (r0 != 0) goto L7;
    L14:
        getChallenge(r3, r5, new AnonymousClass1(r3, r4, r5, r6));
        return;
    L7:
        if (r0.length != 0) goto L9;
        boolean r1 = true;
    L11:
        if ((!r1) == false) goto L14;
        r6.invoke(r0);
        return;
    L9:
        r1 = false;
        goto L11
    L17:
        throw new IllegalStateException("response: VerifyCredentialResponse is null".toString());
    }
}
