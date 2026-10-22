package i.a.a.a;

import com.obric.matrix.account_api.OAccount;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016¨\u0006\u0010"}, d2 = {"Lobric/common/security/attestation/AccountBridge;", "Lcom/bytedance/privacy/bridge/IAccountBridge;", "()V", "onGetDeviceId", "", "onGetUDID", "onGetUserId", "onGetXttTokenMap", "", "onIsAccountLogin", "", "onTeaEvent", "", "p0", "p1", "Lorg/json/JSONObject;", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a implements com.bytedance.privacy.b.a {
    public a() {
    }

    @Override // com.bytedance.privacy.b.a
    public Map<String, String> a() {
        v.a r1 = v.f21457g;     // Catch: Throwable -> L4
        Object r2 = m0.u(OAccount.INSTANCE.getXttTokenMap());     // Catch: Throwable -> L4
        v.b(r2);     // Catch: Throwable -> L4
    L7:
        if (v.f(r2) == false) goto L9;
        r2 = null;
    L9:
        Map<String, String> r3 = (Map) r2;
        if (r3 == null) goto L12;
        return r3;
    L12:
        return new LinkedHashMap();
    L4:
        th = move-exception;
        v.a r0 = v.f21457g;
        r2 = w.a(th);
        v.b(r2);
        goto L7
    }

    @Override // com.bytedance.privacy.b.a
    public String b() {
        v.a r1 = v.f21457g;     // Catch: Throwable -> L4
        Object r2 = OAccount.INSTANCE.getAccountInfo().n();     // Catch: Throwable -> L4
        v.b(r2);     // Catch: Throwable -> L4
    L7:
        if (v.f(r2) == false) goto L9;
        r2 = null;
    L9:
        String r3 = (String) r2;
        if (r3 != null) goto L15;
        return "";
    L15:
        return r3;
    L4:
        th = move-exception;
        v.a r0 = v.f21457g;
        r2 = w.a(th);
        v.b(r2);
        goto L7
    }

    @Override // com.bytedance.privacy.b.a
    public String c() {
        return "";
    }

    @Override // com.bytedance.privacy.b.a
    public boolean d() {
        v.a r1 = v.f21457g;     // Catch: Throwable -> L4
        Object r2 = Boolean.valueOf(OAccount.INSTANCE.getAccountInfo().f());     // Catch: Throwable -> L4
        v.b(r2);     // Catch: Throwable -> L4
    L7:
        if (v.f(r2) == false) goto L9;
        r2 = null;
    L9:
        Boolean r3 = (Boolean) r2;
        if (r3 != null) goto L16;
        return false;
    L16:
        return r3.booleanValue();
    L4:
        th = move-exception;
        v.a r0 = v.f21457g;
        r2 = w.a(th);
        v.b(r2);
        goto L7
    }

    @Override // com.bytedance.privacy.b.a
    public String e() {
        String r0 = com.obric.matrix.ostracker_api.b.c();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
