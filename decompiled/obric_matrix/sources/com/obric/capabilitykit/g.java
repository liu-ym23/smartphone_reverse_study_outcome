package com.obric.capabilitykit;

import android.util.Log;
import com.obric.capabilitykit.common.ICapabilityManager;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.UtilsKt;
import java.lang.reflect.Proxy;
import kotlin.Metadata;
import kotlin.n0.d.o;
import kotlin.v;
import kotlin.w;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/capabilitykit/CapabilityManagerClient;", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "api", "Lcom/obric/capabilitykit/common/ICapabilityManager;", "(Lcom/obric/capabilitykit/common/ICapabilityManager;)V", "apiVersion", "", "mApi", "registerFunction", "", "tool", "Lcom/obric/capabilitykit/common/Tool;", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "unregisterFunction", "unregisterResultCallback", "Companion", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ICapabilityManager f8138a;

    static {
    }

    public g(ICapabilityManager r6) {
        o.f(r6, "api");
        com.obric.capabilitykit.corecommon.a.C0217a r1 = com.obric.capabilitykit.corecommon.a.f8101i;
        v.a r2 = v.f21457g;     // Catch: Throwable -> L8
        Object r3 = Proxy.newProxyInstance(ICapabilityManager.class.getClassLoader(), new Class[]{ICapabilityManager.class}, new com.obric.capabilitykit.corecommon.a(r6, "CapabilityManagerClient", ICapabilityManager.class));     // Catch: Throwable -> L8
        if (r3 == null) goto L7;
        r6 = (ICapabilityManager) r3;     // Catch: Throwable -> L8
    L12:
        ICapabilityManager r7 = r6;
        this.f8138a = r7;
        int r5 = r7.getVersion();
        com.obric.capabilitykit.k.c.f8155a.b("CapabilityManagerClient", "ICapabilityManager version: " + r5);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.capabilitykit.common.ICapabilityManager");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        v.a r4 = v.f21457g;
        Object r8 = w.a(th);
        v.b(r8);
        if (v.d(r8) == null) goto L12;
        Log.e("CapabilityManagerClient", "BinderExceptionHandlerProxy createProxyInstance for " + r6.getClass() + " fail");
        goto L12
    }

    @Override // com.obric.capabilitykit.b
    public void a(IMAppAction r2) {
        o.f(r2, "result");
        this.f8138a.sendActionExecuteResult(UtilsKt.getGson().v(r2));
    }
}
