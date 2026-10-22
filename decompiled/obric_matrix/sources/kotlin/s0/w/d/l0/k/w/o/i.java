package kotlin.s0.w.d.l0.k.w.o;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.s0.w.d.l0.n.e0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a {
    public i(e0 r2) {
        if (r2 == null) goto L6;
        this(r2, null);
        return;
    L6:
        c(0);
        throw null;
    }

    private i(e0 r1, f r2) {
        if (r1 == null) goto L5;
        super(r1, r2);
        return;
    L5:
        c(1);
        throw null;
    }

    private static /* synthetic */ void c(int r4) {
        Object[] r0 = new Object[3];
        if (r4 == 2) goto L5;
        r0[0] = WsConstants.KEY_CONNECTION_TYPE;
    L6:
        r0[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (r4 == 2) goto L9;
        r0[2] = "<init>";
    L11:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L9:
        r0[2] = "replaceType";
        goto L11
    L5:
        r0[0] = "newType";
        goto L6
    }

    public String toString() {
        return "{Transient} : " + b();
    }
}
