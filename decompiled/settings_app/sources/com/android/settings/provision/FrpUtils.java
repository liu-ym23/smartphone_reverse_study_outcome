package com.android.settings.provision;

import com.android.settings.utils.SLog;
import com.bytedance.security.frpdata.FrpData;
import com.bytedance.security.frpdata.FrpDataManager;
import com.bytedance.security.frpdata.FrpReadResult;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FrpUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u0004\u0018\u00010\bJ\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\bJ\f\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/android/settings/provision/FrpUtils;", "", "()V", "TAG", "", "frpdataManager", "Lcom/bytedance/security/frpdata/FrpDataManager;", "lastReadResult", "Lcom/bytedance/security/frpdata/FrpData;", "generateDisabledFrpState", "", "generateEnabledFrpState", AccountInfoBundleKey.USER_ID, "mobile", AccountInfoBundleKey.COUNTRY_CODE, "", "generateFrpState", "frpState", "getCountryCode", "getFrpState", "getMaskedUserId", "getUserId", "getUserMobile", "isFrpOn", "updateLastReadResult", "", "writeFrpState", "inFrpData", "masked", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FrpUtils {
    private final String TAG;
    private final FrpDataManager frpdataManager;
    private FrpData lastReadResult;

    public FrpUtils() {
        this.TAG = "FrpUtils";
        FrpDataManager r0 = FrpDataManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(r0, "getInstance(...)");
        this.frpdataManager = r0;
        updateLastReadResult();
    }

    public final boolean isFrpOn() {
        FrpData r0 = this.lastReadResult;
        if (r0 != null) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNull(r0);
        String r1 = r0.userID;
        if (r1 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L25;
        FrpData r3 = this.lastReadResult;
        Intrinsics.checkNotNull(r3);
        if (r3.frpState != 1) goto L26;
        FrpData r4 = this.lastReadResult;
        Intrinsics.checkNotNull(r4);
        String r5 = r4.userMobile;
        if (r5 != null) goto L18;
    L21:
        boolean r6 = true;
    L22:
        if (r6 == false) goto L24;
        return false;
    L24:
        return true;
    L18:
        if (r5.length() == 0) goto L21;
        r6 = false;
        goto L22
    L26:
        return false;
    L25:
        return false;
    L8:
        if (r1.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public final String getUserMobile() {
        if (isFrpOn() == true) goto L6;
        return null;
    L6:
        FrpData r1 = this.lastReadResult;
        Intrinsics.checkNotNull(r1);
        return r1.userMobile;
    }

    public final int getCountryCode() {
        if (isFrpOn() == true) goto L6;
        return 86;
    L6:
        FrpData r1 = this.lastReadResult;
        Intrinsics.checkNotNull(r1);
        return r1.countryCode;
    }

    public final String getUserId() {
        if (isFrpOn() == true) goto L6;
        return null;
    L6:
        FrpData r1 = this.lastReadResult;
        Intrinsics.checkNotNull(r1);
        return r1.userID;
    }

    private final String masked(String r5) {
        int r1 = 0;
        if (r5.length() <= 9) goto L9;
        IntRange r4 = RangesKt.until(7, r5.length() - 2);
        int r2 = r5.length() - 9;
        char[] r3 = new char[r2];
    L5:
        if (r1 >= r2) goto L7;
        r3[r1] = '*';
        r1 = r1 + 1;
        goto L5
    L7:
        String r6 = r5;
        return StringsKt.replaceRange(r6, r4, new String(r3)).toString();
    L9:
        if (r5.length() <= 2) goto L18;
        IntRange r7 = RangesKt.until(1, r5.length() - 1);
        int r8 = r5.length() - 2;
        char[] r9 = new char[r8];
    L11:
        if (r1 >= r8) goto L13;
        r9[r1] = '*';
        r1 = r1 + 1;
        goto L11
    L13:
        String r10 = r5;
        return StringsKt.replaceRange(r10, r7, new String(r9)).toString();
    L18:
        return r5;
    }

    public final String getMaskedUserId() {
        String r0 = getUserId();
        if (r0 != null) goto L7;
        return null;
    L7:
        if (r0.length() != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        return r0;
    L13:
        if (r0.length() > 9) goto L15;
        return r0;
    L15:
        return masked(r0);
    L9:
        r1 = false;
        goto L10
    }

    private final boolean generateFrpState(String r3, String r4, int r5, int r6) {
        OLog.i(this.TAG, "generateFrpState");
        FrpData r0 = new FrpData();
        r0.userID = r3;
        r0.userEmail = "";
        r0.userMobile = r4;
        r0.countryCode = r5;
        r0.frpState = r6;
        int r7 = writeFrpState(r0);
        if (r7 == 0) goto L6;
        OLog.e(this.TAG, "generateFrpState, ret: " + r7);
        return false;
    L6:
        return true;
    }

    public final boolean generateDisabledFrpState() {
        OLog.i(this.TAG, "generateDisabledFrpState");
        return generateFrpState("0", "", 86, 0);
    }

    public final boolean generateEnabledFrpState(String r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, AccountInfoBundleKey.USER_ID);
        Intrinsics.checkNotNullParameter(r4, "mobile");
        OLog.i(this.TAG, "generateEnabledFrpState");
        return generateFrpState(r3, r4, r5, 1);
    }

    public final int writeFrpState(FrpData r5) {
        Intrinsics.checkNotNullParameter(r5, "inFrpData");
        OLog.i(this.TAG, "writeFrpState: " + r5.frpState);
        SLog.i(this.TAG, "writeFrpState: " + r5.userID + TokenParser.SP + r5.userMobile + TokenParser.SP + r5.countryCode + TokenParser.SP + r5.frpState);
        int r6 = this.frpdataManager.writeFrpData(r5);     // Catch: Exception -> L6
        updateLastReadResult();
        return r6;
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e(this.TAG, "writeFrpState err : " + e.getMessage());
        return -1000;
    }

    public final FrpData getFrpState() {
        FrpReadResult r1 = this.frpdataManager.readFrpData();     // Catch: Exception -> L10
        Intrinsics.checkNotNullExpressionValue(r1, "readFrpData(...)");     // Catch: Exception -> L10
        if (r1.getResultCode() == 0) goto L9;
        OLog.e(this.TAG, "getFrpState error_code: " + r1.getResultCode());
        return null;
    L9:
        return r1.getResultData();
    L10:
        e = move-exception;
        e.printStackTrace();
        OLog.e(this.TAG, "getFrpState err: " + e.getMessage());
        return null;
    }

    public final void updateLastReadResult() {
        OLog.i(this.TAG, "updateLastReadResult");
        this.lastReadResult = getFrpState();
    }
}
