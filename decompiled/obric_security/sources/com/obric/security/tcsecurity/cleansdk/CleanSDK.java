package com.obric.security.tcsecurity.cleansdk;

import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.securitycenter.api.TrackUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CleanSDK.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/obric/security/tcsecurity/cleansdk/CleanSDK;", "", "()V", "isCheckLicenceSafeState", "", "()Z", "setCheckLicenceSafeState", "(Z)V", "licenceCheckCode", "", "getLicenceCheckCode", "()I", "setLicenceCheckCode", "(I)V", "initCleanSDK", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanSDK {
    public static final CleanSDK INSTANCE = null;
    private static boolean isCheckLicenceSafeState;
    private static int licenceCheckCode;

    static {
        INSTANCE = new CleanSDK();
        licenceCheckCode = -1;
    }

    private CleanSDK() {
    }

    public final boolean isCheckLicenceSafeState() {
        return isCheckLicenceSafeState;
    }

    public final void setCheckLicenceSafeState(boolean r1) {
        isCheckLicenceSafeState = r1;
    }

    public final int getLicenceCheckCode() {
        return licenceCheckCode;
    }

    public final void setLicenceCheckCode(int r1) {
        licenceCheckCode = r1;
    }

    public final void initCleanSDK() {
        if (isCheckLicenceSafeState == false) goto L6;
        TencentCleanSdk.init(SecurityCenterApplication.getContext());
        return;
    L6:
        TencentCleanSdk.init(SecurityCenterApplication.getContext());
        int r7 = TencentCleanSdk.checkLicenceSafeState();
        licenceCheckCode = r7;
        if (r7 != 0) goto L9;
        isCheckLicenceSafeState = true;
    L9:
        TrackUtils r1 = TrackUtils.INSTANCE;
        Pair[] r3 = new Pair[2];
        Boolean r4 = TencentCleanSdk.getIsInit();
        Intrinsics.checkNotNullExpressionValue(r4, "TencentCleanSdk.getIsInit()");
        if (r4.booleanValue() == false) goto L12;
        String r5 = "success";
    L13:
        r3[0] = TuplesKt.to("result", r5);
        r3[1] = TuplesKt.to("licenceSafeState", Integer.valueOf(r7));
        TrackUtils.trackEvent$default(r1, "tencent_security_sdk_init", MapsKt.mapOf(r3), false, 4, null);
        OLog.d("TencentCleanSdk_TMSDK", "onCreate:checkLicenceSafeState code = " + r7);
        return;
    L12:
        r5 = "fail";
        goto L13
    }
}
