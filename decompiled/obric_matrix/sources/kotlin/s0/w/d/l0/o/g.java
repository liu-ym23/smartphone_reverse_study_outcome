package kotlin.s0.w.d.l0.o;

import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21213a;

    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f21214b = null;

        static {
            f21214b = new a();
        }

        private a() {
            super(false, null);
        }
    }

    public static final class b extends g {
        public b(String r2) {
            kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_ERROR);
            super(false, null);
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f21215b = null;

        static {
            f21215b = new c();
        }

        private c() {
            super(true, null);
        }
    }

    private g(boolean r1) {
        this.f21213a = r1;
    }

    public /* synthetic */ g(boolean r1, kotlin.n0.d.g r2) {
        this(r1);
    }

    public final boolean a() {
        return this.f21213a;
    }
}
