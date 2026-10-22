package kotlin.s0.w.d.l0.n.t1;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.s0.w.d.l0.n.e1;

/* JADX INFO: loaded from: classes2.dex */
class t implements v {
    t() {
    }

    private static /* synthetic */ void b(int r3) {
        Object[] r0 = new Object[3];
        switch(r3) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L4;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L9;
            case 8: goto L6;
            case 9: goto L5;
            case 10: goto L8;
            case 11: goto L7;
            default: goto L4;
        };
    L4:
        r0[0] = "a";
    L11:
        r0[1] = "kotlin/reflect/jvm/internal/impl/types/checker/TypeCheckerProcedureCallbacksImpl";
        switch(r3) {
            case 3: goto L17;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L16;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L14;
            default: goto L13;
        };
    L13:
        r0[2] = "assertEqualTypes";
    L19:
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L14:
        r0[2] = "noCorrespondingSupertype";
        goto L19
    L15:
        r0[2] = "capture";
        goto L19
    L16:
        r0[2] = "assertSubtype";
        goto L19
    L17:
        r0[2] = "assertEqualTypeConstructors";
        goto L19
    L5:
        r0[0] = "typeProjection";
        goto L11
    L6:
        r0[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L11
    L7:
        r0[0] = "supertype";
        goto L11
    L8:
        r0[0] = "subtype";
        goto L11
    L9:
        r0[0] = "typeCheckingProcedure";
        goto L11
    L10:
        r0[0] = "b";
        goto L11
    }

    @Override // kotlin.s0.w.d.l0.n.t1.v
    public boolean a(e1 r1, e1 r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        b(4);
        throw null;
    L6:
        return r1.equals(r2);
    L9:
        b(3);
        throw null;
    }
}
