package com.obric.capabilitykit;

import com.obric.capabilitykit.common.IMAppAction;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/EmptyCapabilityManager;", "Lcom/obric/capabilitykit/AbstractCapabilityManager;", "()V", "TAG", "", "registerFunction", "", "tool", "Lcom/obric/capabilitykit/common/Tool;", "registerResultCallback", "listener", "Lcom/obric/capabilitykit/ErrorCodeCallback;", "sendActionExecuteResult", "result", "Lcom/obric/capabilitykit/common/IMAppAction;", "unregisterFunction", "unregisterResultCallback", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8139a = null;

    static {
        f8139a = new h();
    }

    private h() {
    }

    @Override // com.obric.capabilitykit.b
    public void a(IMAppAction r2) {
        o.f(r2, "result");
        com.obric.capabilitykit.k.c.f8155a.d("EmptyCapabilityManager", "sendActionExecuteResult");
    }
}
