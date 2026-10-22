package com.obric.securitycenter.nodisturb.manager;

import android.content.Context;
import android.provider.Settings;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.olog.OLog;
import com.obric.securitycenter.nodisturb.ProviderConstants;
import com.obric.securitycenter.nodisturb.utils.EncryptToMd5Kt;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SmsBodyCheckManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/SmsBodyCheckManager;", "", "()V", "mSmsBodyRiskService", "Lcom/obric/securitycenter/nodisturb/manager/SmsBodyRiskService;", "checkMessageRisk", "", "context", "Landroid/content/Context;", AccountConst.KEY_PHONE_NUMBER, "", ProviderConstants.Sms.BODY, "isBlockYuloreTypeHarassmentEnable", "", "isBlockYuloreTypeHighRiskEnable", "isBlockYuloreTypeMediumRiskEnable", "onDestroy", "", "truncateTo100Chars", "input", "Companion", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsBodyCheckManager {
    public static final Companion Companion = null;
    public static final int INTERCEPT_YULORE_TYPE_HARASSMENT = 4;
    public static final int INTERCEPT_YULORE_TYPE_HIGH_RISK = 1;
    public static final int INTERCEPT_YULORE_TYPE_MEDIUM_RISK = 2;
    public static final String SMS_INTERCEPT_YULORE_TYPE = "pref_key_sms_intercept_yulore_type";
    private static final String TAG = "SmsBodyCheckManager";
    private final SmsBodyRiskService mSmsBodyRiskService;

    /* JADX INFO: compiled from: SmsBodyCheckManager.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/securitycenter/nodisturb/manager/SmsBodyCheckManager$Companion;", "", "()V", "INTERCEPT_YULORE_TYPE_HARASSMENT", "", "INTERCEPT_YULORE_TYPE_HIGH_RISK", "INTERCEPT_YULORE_TYPE_MEDIUM_RISK", "SMS_INTERCEPT_YULORE_TYPE", "", "TAG", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SmsBodyCheckManager() {
        this.mSmsBodyRiskService = new SmsBodyRiskService();
    }

    public final boolean isBlockYuloreTypeHighRiskEnable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((Settings.System.getInt(r2.getContentResolver(), SMS_INTERCEPT_YULORE_TYPE, 0) & 1) != 0) goto L5;
        return false;
    L5:
        return true;
    }

    public final boolean isBlockYuloreTypeMediumRiskEnable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((Settings.System.getInt(r2.getContentResolver(), SMS_INTERCEPT_YULORE_TYPE, 0) & 2) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final boolean isBlockYuloreTypeHarassmentEnable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if ((Settings.System.getInt(r2.getContentResolver(), SMS_INTERCEPT_YULORE_TYPE, 0) & 4) == 0) goto L6;
        return true;
    L6:
        return false;
    }

    public final int checkMessageRisk(Context r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, AccountConst.KEY_PHONE_NUMBER);
        boolean r0 = isBlockYuloreTypeMediumRiskEnable(r9);
        boolean r1 = isBlockYuloreTypeHighRiskEnable(r9);
        boolean r2 = isBlockYuloreTypeHarassmentEnable(r9);
        if (r11 == null) goto L5;
        int r4 = r11.length();
    L6:
        OLog.d("_CallSmsIntercept", "checkMessageRisk: high=" + r1 + ", medium=" + r0 + ", harassment=" + r2 + ", bodyLen=" + r4);
        if (r0 == true) goto L12;
        if (r1 == true) goto L12;
        if (r2 == true) goto L12;
        OLog.d("_CallSmsIntercept", "checkMessageRisk skip: all block switches off");
        return 0;
    L12:
        OLog.d("_CallSmsIntercept", "checkMessageRisk initService: " + this.mSmsBodyRiskService.initService(r9));
        String r3 = r11;
        if (r3 != null) goto L15;
    L18:
        boolean r5 = true;
    L19:
        if (r5 == false) goto L22;
        OLog.d("_CallSmsIntercept", "checkMessageRisk skip: body is null or blank");
        return 0;
    L22:
        final CountDownLatch r6 = new CountDownLatch(1);
        final Ref.IntRef r7 = new Ref.IntRef();
        this.mSmsBodyRiskService.checkMessageRisk(EncryptToMd5Kt.calculateMD5(truncateTo100Chars(r11)), r10, r11, new AnonymousClass1(r7, r6));
    L27:
        e = move-exception;
        OLog.e("_CallSmsIntercept", "checkMessageRisk: wait result interrupted", e);
    L29:
        int r12 = r7.element;
        if (r12 != 1) goto L32;
        return 4;
    L32:
        if (r12 == 2) goto L35;
    L38:
        OLog.d("_CallSmsIntercept", "checkMessageRisk pass: riskLevel=" + r7.element + " -> type=0");
        return 0;
    L35:
        if (isBlockYuloreTypeHighRiskEnable(r9) == false) goto L38;
        OLog.d("_CallSmsIntercept", "checkMessageRisk hit SPAM -> intercept type=3");
        return 3;
    L24:
        if (r6.await(1000, TimeUnit.MILLISECONDS) == true) goto L29;
        OLog.w("_CallSmsIntercept", "checkMessageRisk: wait result timeout(1000ms), fallback NONE");     // Catch: InterruptedException -> L27
        goto L29
    L15:
        if (StringsKt.isBlank(r3) == true) goto L18;
        r5 = false;
        goto L19
    L5:
        r4 = 0;
        goto L6
    }

    public final void onDestroy() {
        OLog.d("_CallSmsIntercept", "onDestroy: unbind risk service");
        this.mSmsBodyRiskService.unbind();
    }

    public final String truncateTo100Chars(String r2) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r2.length() <= 100) goto L8;
        String r3 = r2.substring(0, 100);
        Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String…ing(startIndex, endIndex)");
        return r3;
    L8:
        return r2;
    }
}
