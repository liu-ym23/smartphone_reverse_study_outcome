package d.b.u;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class d implements i {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final e f15021f;

    public d(Context r1, e r2) {
        this.f15021f = r2;
    }

    @Override // d.b.u.i
    public boolean r(Context r1) {
        e r0 = this.f15021f;
        if (r0 == null) goto L9;
        i r2 = r0.f15034l;
        if (r2 == null) goto L9;
        return r2.r(r1);
    L9:
        return com.bytedance.common.utility.i.p(r1);
    }
}
