package com.obric.baseservice.privacy;

import com.bytedance.privacy.bridge.IAccountBridge;
import com.obric.matrix.platform.sdk.ones.account.AccountException;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.olog.OLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: PrivacyAccountBridge.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/baseservice/privacy/PrivacyAccountBridge;", "Lcom/bytedance/privacy/bridge/IAccountBridge;", "()V", "TAG", "", "logAccountFailure", "", "message", "throwable", "", "onGetDeviceId", "onGetUDID", "onGetUserId", "onGetXttTokenMap", "", "onIsAccountLogin", "", "onTeaEvent", "event", "params", "Lorg/json/JSONObject;", "baseservice_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PrivacyAccountBridge implements IAccountBridge {
    public static final PrivacyAccountBridge INSTANCE = null;
    private static final String TAG = "PrivacyAccountBridge";

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetUDID() {
        return "";
    }

    static {
        INSTANCE = new PrivacyAccountBridge();
    }

    private PrivacyAccountBridge() {
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetUserId() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        PrivacyAccountBridge r4 = this;     // Catch: Throwable -> L8
        String r5 = OAccount.INSTANCE.accountInfo(true).getUserId();     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        Object r6 = Result.m774constructorimpl(r5);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.m777exceptionOrNullimpl(r6);
        if (r2 == null) goto L14;
        INSTANCE.logAccountFailure("get userId failed", r2);
    L14:
        if (Result.m780isFailureimpl(r6) == true) goto L18;
        r0 = r6;
    L18:
        return (String) r0;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public boolean onIsAccountLogin() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        PrivacyAccountBridge r3 = this;     // Catch: Throwable -> L4
        Object r4 = Result.m774constructorimpl(Boolean.valueOf(OAccount.INSTANCE.isLogin(true)));     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.m777exceptionOrNullimpl(r4);
        if (r1 == null) goto L10;
        INSTANCE.logAccountFailure("get account login state failed", r1);
    L10:
        if (Result.m780isFailureimpl(r4) == false) goto L13;
        r4 = false;
    L13:
        return ((Boolean) r4).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public Map<String, String> onGetXttTokenMap() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        PrivacyAccountBridge r3 = this;     // Catch: Throwable -> L4
        Object r4 = Result.m774constructorimpl(OAccount.INSTANCE.xttTokenMap());     // Catch: Throwable -> L4
    L6:
        Throwable r1 = Result.m777exceptionOrNullimpl(r4);
        if (r1 == null) goto L9;
        INSTANCE.logAccountFailure("get xtt token map failed", r1);
    L9:
        Map r2 = MapsKt.emptyMap();
        if (Result.m780isFailureimpl(r4) == false) goto L13;
        r4 = r2;
    L13:
        return (Map) r4;
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public void onTeaEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, "params");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        PrivacyAccountBridge r1 = this;     // Catch: Throwable -> L5
        MatrixTeaManager.Companion.getInstance().onEvent(r2, r3);     // Catch: Throwable -> L5
        Object r4 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        if (r5 == null) goto L13;
        OLog.w(TAG, "report privacy tea event failed: " + r2, r5);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetDeviceId() {
        Object r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        PrivacyAccountBridge r4 = this;     // Catch: Throwable -> L8
        String r5 = MatrixTeaManager.Companion.getInstance().getDeviceId();     // Catch: Throwable -> L8
        if (r5 != null) goto L6;
        r5 = "";
    L6:
        Object r6 = Result.m774constructorimpl(r5);     // Catch: Throwable -> L8
    L10:
        Throwable r2 = Result.m777exceptionOrNullimpl(r6);
        if (r2 == null) goto L14;
        OLog.w(TAG, "get deviceId failed", r2);
    L14:
        if (Result.m780isFailureimpl(r6) == true) goto L18;
        r0 = r6;
    L18:
        return (String) r0;
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void logAccountFailure(String r4, Throwable r5) {
        if ((r5 instanceof AccountException) == false) goto L5;
        AccountException r3 = (AccountException) r5;
        OLog.w(TAG, r4 + ", code=" + r3.getCode() + ", msg=" + r3.getMsg(), r5);
        return;
    L5:
        OLog.w(TAG, r4, r5);
    }
}
