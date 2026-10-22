package com.bytedance.sdk.account.monitor;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.ss.android.i.j;
import com.ss.android.token.w;
import d.b.s.a.l0.f;
import d.b.s.a.l0.h;
import d.b.s.a.l0.n;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0007J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/account/monitor/AccountSdkMonitorServiceImpl;", "Lcom/bytedance/sdk/account/monitor/IAccountSdkMonitorService;", "", NotificationCompat.CATEGORY_EVENT, "", "", "getMonitorCommonParams", "(Ljava/lang/String;)Ljava/util/Map;", "getOverrideCommonParams", "Lorg/json/JSONObject;", "params", "", "onEvent", "(Ljava/lang/String;Lorg/json/JSONObject;)Z", "isDebug", "()Z", "<init>", "()V", "account-sdk-core_release"}, k = 1, mv = {1, 1, 15})
public final class AccountSdkMonitorServiceImpl implements IAccountSdkMonitorService {
    public AccountSdkMonitorServiceImpl() {
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public Map<String, Object> getMonitorCommonParams(String r5) {
        o.g(r5, NotificationCompat.CATEGORY_EVENT);
        String r4 = d.b.s.a.j0.a.a();
        LinkedHashMap r6 = new LinkedHashMap();
        f.a(r6, new u[]{a0.a("passport-sdk-version", 601339), a0.a("passport_sdk_version", 601339)});
        com.ss.android.d r0 = j.l();
        if (r0 == null) goto L5;
        Context r1 = r0.e();
    L6:
        r6.put("process_name", w.g(r1));
        if (n.a(r4) == false) goto L9;
        r6.put("trace_id", r4);
    L9:
        return r6;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public Map<String, Object> getOverrideCommonParams(String r1) {
        o.g(r1, NotificationCompat.CATEGORY_EVENT);
        return m0.e(a0.a("params_for_special", "uc_login"));
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService
    public boolean isDebug() {
        return false;
    }

    @Override // com.bytedance.sdk.account.monitor.IAccountSdkMonitorService, com.bytedance.sdk.account.monitor.e.a
    public boolean onEvent(String r1, JSONObject r2) {
        o.g(r1, NotificationCompat.CATEGORY_EVENT);
        com.ss.android.d r0 = j.l();
        if (r0 == null) goto L7;
        h r3 = r0.b();
        if (r3 == null) goto L7;
        r3.onEvent(r1, r2);
        f0 r4 = f0.f18324a;
    L8:
        if (r4 == null) goto L10;
        return true;
    L10:
        return false;
    L7:
        r4 = null;
        goto L8
    }
}
