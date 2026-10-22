package com.bytedance.sdk.account.settings;

import com.bytedance.sdk.account.impl.g;
import com.ss.android.i.j;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/account/settings/SettingsGetterImpl;", "Lcom/bytedance/sdk/account/settings/ISettingsGetter;", "", "moduleName", "Lorg/json/JSONObject;", "getSettings", "(Ljava/lang/String;)Lorg/json/JSONObject;", "<init>", "()V", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
public final class SettingsGetterImpl implements ISettingsGetter {
    public SettingsGetterImpl() {
    }

    @Override // com.bytedance.sdk.account.settings.ISettingsGetter
    public JSONObject getSettings(String r3) {
        o.g(r3, "moduleName");
        com.ss.android.d r2 = j.l();
        if (r2 == null) goto L8;
        d.b.s.a.d0.r.a r4 = g.b(r2.e());
        o.b(r4, "BDAccountDelegateInner\n ….getApplicationContext())");
        JSONObject r5 = r4.b();
        if (r5 != null) goto L7;
        return null;
    L7:
        return r5.optJSONObject(r3);
    L8:
        return null;
    }
}
