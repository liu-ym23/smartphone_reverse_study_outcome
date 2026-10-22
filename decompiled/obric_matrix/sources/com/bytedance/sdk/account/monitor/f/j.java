package com.bytedance.sdk.account.monitor.f;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.i0.r;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5684b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<g> f5685a;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final j a(List<? extends List<String>> r3) {
            o.g(r3, "expressions");
            ArrayList r2 = new ArrayList(r.q(r3, 10));
            Iterator<T> r4 = r3.iterator();
        L4:
            if (r4.hasNext() == false) goto L7;
            List<String> r0 = (List) r4.next();
            r2.add(b.f5675b.a(r0));
            goto L4
        L7:
            return new j(r2);
        }
    }

    static {
        f5684b = new a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(List<? extends g> r2) {
        o.g(r2, "conditions");
        super(null);
        this.f5685a = r2;
    }

    @Override // com.bytedance.sdk.account.monitor.f.g
    public boolean a(JSONObject r2) {
        o.g(r2, "params");
        Iterator<g> r1 = this.f5685a.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (r1.next().a(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }
}
