package h.a;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/NodeList;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/Incomplete;", "()V", "isActive", "", "()Z", "list", "getList", "()Lkotlinx/coroutines/NodeList;", "getString", "", WsConstants.KEY_CONNECTION_STATE, "toString", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class j2 extends h.a.f3.q implements s1 {
    public j2() {
    }

    public final String E(String r5) {
        StringBuilder r0 = new StringBuilder();
        r0.append("List{");
        r0.append(r5);
        r0.append("}[");
        h.a.f3.s r6 = (h.a.f3.s) r();
        boolean r1 = true;
    L4:
        if (kotlin.n0.d.o.a(r6, this) == true) goto L13;
        if ((r6 instanceof e2) == false) goto L12;
        e2 r2 = (e2) r6;
        if (r1 == false) goto L10;
        r1 = false;
    L11:
        r0.append(r2);
        goto L12
    L10:
        r0.append(", ");
    L12:
        r6 = r6.s();
        goto L4
    L13:
        r0.append("]");
        String r4 = r0.toString();
        kotlin.n0.d.o.e(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    }

    @Override // h.a.s1
    public boolean b() {
        return true;
    }

    @Override // h.a.s1
    public j2 d() {
        return this;
    }

    @Override // h.a.f3.s
    public String toString() {
        if (q0.c() == false) goto L6;
        return E("Active");
    L6:
        return super.toString();
    }
}
