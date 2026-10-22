package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.Hook;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ServiceManagerHook extends Hook {
    private MethodProxy mBinderProxy;
    private String mService;

    public ServiceManagerHook(String r1, MethodProxy r2) {
        this.mService = r1;
        this.mBinderProxy = r2;
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.Hook
    public void onHook() {
        Class<?> r0 = Class.forName("android.os.ServiceManager");     // Catch: Exception -> L10
        Object r1 = MethodUtils.invokeStaticMethod(r0, "getService", new Object[]{this.mService});     // Catch: Exception -> L10
        if (r1 == null) goto L13;
        Object r2 = FieldUtils.readStaticField(r0, "sCache");     // Catch: Exception -> L10
        if (r2 != null) goto L7;
        return;
    L7:
        if ((r2 instanceof Map) == false) goto L15;
        this.mBinderProxy.setTarget(r1);     // Catch: Exception -> L10
        ((Map) r2).put(this.mService, ProxyHelper.createProxy(r1, this.mBinderProxy));     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    }
}
