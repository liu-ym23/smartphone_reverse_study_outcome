package obric.common.security.attestation;

import com.bytedance.privacy.bridge.IAccountBridge;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.tools.MatrixTeaInitManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: AccountBridge.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lobric/common/security/attestation/AccountBridge;", "Lcom/bytedance/privacy/bridge/IAccountBridge;", "()V", "onGetDeviceId", "", "onGetUDID", "onGetUserId", "onGetXttTokenMap", "", "onIsAccountLogin", "", "onTeaEvent", "", "p0", "p1", "Lorg/json/JSONObject;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AccountBridge implements IAccountBridge {
    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetUDID() {
        return "";
    }

    public AccountBridge() {
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetUserId() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        AccountBridge r1 = this;     // Catch: Throwable -> L4
        Object r2 = Result.m1508constructorimpl(OAccount.INSTANCE.accountInfo(true).getUserId());     // Catch: Throwable -> L4
    L7:
        if (Result.m1514isFailureimpl(r2) == false) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L15;
        return "";
    L15:
        return r3;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public boolean onIsAccountLogin() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        AccountBridge r1 = this;     // Catch: Throwable -> L4
        Object r2 = Result.m1508constructorimpl(Boolean.valueOf(OAccount.INSTANCE.isLogin(true)));     // Catch: Throwable -> L4
    L7:
        if (Result.m1514isFailureimpl(r2) == false) goto L9;
        r2 = null;
    L9:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L16;
        return false;
    L16:
        return r3.booleanValue();
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public Map<String, String> onGetXttTokenMap() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L4
        Object r2 = Result.m1508constructorimpl(MapsKt.toMutableMap(OAccount.INSTANCE.xttTokenMap()));     // Catch: Throwable -> L4
    L7:
        if (Result.m1514isFailureimpl(r2) == false) goto L9;
        r2 = null;
    L9:
        Map<String, String> r3 = (Map) r2;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return new LinkedHashMap();
    L4:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r2 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public void onTeaEvent(String r1, JSONObject r2) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        MatrixTeaManager r0 = MatrixTeaManager.Companion.getInstance();
        if (r2 != null) goto L5;
        r2 = new JSONObject();
    L5:
        r0.onEvent(r1, r2);
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public String onGetDeviceId() {
        String r0 = MatrixTeaInitManager.INSTANCE.getDeviceId();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
