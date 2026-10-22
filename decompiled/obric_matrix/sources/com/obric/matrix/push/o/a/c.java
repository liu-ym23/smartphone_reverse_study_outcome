package com.obric.matrix.push.o.a;

import com.obric.matrix.r.c.e;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/matrix/push/cross_process/method/UnRegisterChannelMethod;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "()V", "TAG", "", "getMethodName", "onMethodInvoke", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements com.obric.matrix.push.n.b.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f9766a;

    public c() {
        this.f9766a = "UnRegisterChannelMethod";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public String a() {
        return "un_register_channel";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public void b(String r3, List<Object> r4, com.obric.matrix.push.n.b.b r5) {
        o.f(r3, "originPkgName");
        e.a(this.f9766a, "on " + a() + " call, originPkgName is " + r3 + " args is " + r4);
    }
}
