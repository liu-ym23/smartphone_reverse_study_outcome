package kotlin.s0.w.d.l0.o;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    public static final class a implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21230a = null;

        static {
            f21230a = new a();
        }

        private a() {
        }

        @Override // kotlin.s0.w.d.l0.o.l
        public boolean a(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
            kotlin.n0.d.o.f(r1, "what");
            kotlin.n0.d.o.f(r2, TypedValues.TransitionType.S_FROM);
            return true;
        }
    }

    boolean a(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2);
}
