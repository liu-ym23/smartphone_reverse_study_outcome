package h.a;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/Empty;", "Lkotlinx/coroutines/Incomplete;", "isActive", "", "(Z)V", "()Z", "list", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class g1 implements s1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f17438f;

    public g1(boolean r1) {
        this.f17438f = r1;
    }

    @Override // h.a.s1
    public boolean b() {
        return this.f17438f;
    }

    @Override // h.a.s1
    public j2 d() {
        return null;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Empty{");
        if (b() == false) goto L5;
        String r2 = "Active";
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "New";
        goto L6
    }
}
