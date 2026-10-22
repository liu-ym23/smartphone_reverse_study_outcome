package d.b.s.a.t;

import android.view.View;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View.OnClickListener f14912b;

    public a(String r7) {
        this(r7, null, null, 6, null);
    }

    public a(String r7, View.OnClickListener r8) {
        this(r7, r8, null, 4, null);
    }

    public a(String r2, View.OnClickListener r3, b r4) {
        o.g(r2, "text");
        o.g(r4, "style");
        this.f14911a = r2;
        this.f14912b = r3;
    }

    public /* synthetic */ a(String r1, View.OnClickListener r2, b r3, int r4, g r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = b.f14913f;
    L8:
        this(r1, r2, r3);
    }

    public final View.OnClickListener a() {
        return this.f14912b;
    }

    public final String b() {
        return this.f14911a;
    }
}
