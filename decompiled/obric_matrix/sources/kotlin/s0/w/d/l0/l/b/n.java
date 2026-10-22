package kotlin.s0.w.d.l0.l.b;

import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.s0.w.d.l0.c.h0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends kotlin.s0.w.d.l0.k.r.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.s0.w.d.l0.n.e0 f20852c;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.l<h0, kotlin.s0.w.d.l0.n.e0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.s0.w.d.l0.n.e0 f20853f;

        a(kotlin.s0.w.d.l0.n.e0 r1) {
            this.f20853f = r1;
            super(1);
        }

        public final kotlin.s0.w.d.l0.n.e0 a(h0 r2) {
            kotlin.n0.d.o.f(r2, "it");
            return this.f20853f;
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.n.e0 invoke(h0 r1) {
            return a(r1);
        }
    }

    public n(List<? extends kotlin.s0.w.d.l0.k.r.g<?>> r2, kotlin.s0.w.d.l0.n.e0 r3) {
        kotlin.n0.d.o.f(r2, "value");
        kotlin.n0.d.o.f(r3, WsConstants.KEY_CONNECTION_TYPE);
        super(r2, new a(r3));
        this.f20852c = r3;
    }

    public final kotlin.s0.w.d.l0.n.e0 c() {
        return this.f20852c;
    }
}
