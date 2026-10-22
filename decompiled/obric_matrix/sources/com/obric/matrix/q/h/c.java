package com.obric.matrix.q.h;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/obric/matrix/base/system/BasePackageChangeListener;", "Lcom/obric/matrix/base/system/PackageChangeListener;", "()V", "onPackageChanged", "", "packageAction", "Lcom/obric/matrix/base/system/PackageAction;", "packageName", "", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class c implements g {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9875a = null;

        static {
            int[] r0 = new int[e.values().length];
            r0[e.f9876f.ordinal()] = 1;
            r0[e.f9877g.ordinal()] = 2;
            f9875a = r0;
        }
    }

    public c() {
    }

    @Override // com.obric.matrix.q.h.g
    public void a(e r2, String r3) {
        o.f(r2, "packageAction");
        o.f(r3, "packageName");
        com.obric.matrix.r.c.c.b("BasePackageChangeListener", "onPackageChanged() called with: packageAction = " + r2 + ", packageName = " + r3);
        int r1 = a.f9875a[r2.ordinal()];
        if (r1 != 1) goto L5;
        b.f9869a.c(r3);
        return;
    L5:
        if (r1 != 2) goto L11;
        b.f9869a.d(r3);
        return;
    }
}
