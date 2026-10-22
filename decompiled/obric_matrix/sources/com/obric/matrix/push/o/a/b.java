package com.obric.matrix.push.o.a;

import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/matrix/push/cross_process/method/SDKEventMethod;", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessMethod;", "()V", "getMethodName", "", "onMethodInvoke", "", "originPkgName", "args", "", "", "callback", "Lcom/obric/matrix/push/common/cross_process/ICrossProcessCallbackInterface;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements com.obric.matrix.push.n.b.d.b {
    public b() {
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public String a() {
        return "sdk_event";
    }

    @Override // com.obric.matrix.push.n.b.d.b
    public void b(String r8, List<Object> r9, com.obric.matrix.push.n.b.b r10) {
        o.f(r8, "originPkgName");
        Object r7 = null;
        if (r9 != null) goto L21;
        Object r11 = null;
    L9:
        if (r11 == null) goto L18;
        String r1 = (String) r11;     // Catch: Throwable -> L19
        if (r9 == null) goto L13;
        r7 = r9.get(1);     // Catch: Throwable -> L19
    L13:
        if (r7 == null) goto L16;
        com.obric.matrix.push.m.d.c.a.a(com.obric.matrix.push.m.b.f9633a.c(), r1, new JSONObject((String) r7), true, false, 8, null);     // Catch: Throwable -> L19
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");     // Catch: Throwable -> L19
    L21:
        r11 = r9.get(0);     // Catch: Throwable -> L19
    L19:
        com.obric.matrix.push.n.c.c.c("sdk event method is error");
    }
}
