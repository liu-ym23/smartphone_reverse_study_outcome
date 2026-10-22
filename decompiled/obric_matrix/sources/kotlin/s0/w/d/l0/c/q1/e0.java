package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.w0;

/* JADX INFO: loaded from: classes2.dex */
public class e0 extends b0 implements w0 {
    private j1 r;
    private final w0 s;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e0(u0 r13, kotlin.s0.w.d.l0.c.o1.g r14, kotlin.s0.w.d.l0.c.e0 r15, kotlin.s0.w.d.l0.c.u r16, boolean r17, boolean r18, boolean r19, kotlin.s0.w.d.l0.c.b.a r20, w0 r21, a1 r22) {
        if (r13 == null) goto L25;
        if (r14 == null) goto L23;
        if (r15 == null) goto L21;
        if (r16 == null) goto L19;
        if (r20 == null) goto L17;
        if (r22 == null) goto L15;
        super(r15, r16, r13, r14, kotlin.s0.w.d.l0.g.f.n("<set-" + r13.getName() + ">"), r17, r18, r19, r20, r22);
        if (r21 == null) goto L12;
        e0 r1 = this;
        w0 r0 = r21;
    L13:
        r1.s = r0;
        return;
    L12:
        r0 = this;
        r1 = r0;
        goto L13
    L15:
        F(5);
        throw null;
    L17:
        F(4);
        throw null;
    L19:
        F(3);
        throw null;
    L21:
        F(2);
        throw null;
    L23:
        F(1);
        throw null;
    L25:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r6) {
        switch(r6) {
            case 10: goto L4;
            case 11: goto L4;
            case 12: goto L4;
            case 13: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r6) {
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L8;
            case 13: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r6) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L20;
            case 10: goto L12;
            case 11: goto L12;
            case 12: goto L12;
            case 13: goto L12;
            default: goto L11;
        };
    L11:
        r3[0] = "correspondingProperty";
    L22:
        switch(r6) {
            case 10: goto L27;
            case 11: goto L26;
            case 12: goto L25;
            case 13: goto L24;
            default: goto L23;
        };
    L23:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
    L28:
        switch(r6) {
            case 6: goto L31;
            case 7: goto L30;
            case 8: goto L30;
            case 9: goto L30;
            case 10: goto L32;
            case 11: goto L32;
            case 12: goto L32;
            case 13: goto L32;
            default: goto L29;
        };
    L29:
        r3[2] = "<init>";
        goto L32
    L30:
        r3[2] = "createSetterParameter";
        goto L32
    L31:
        r3[2] = "initialize";
    L32:
        String r1 = String.format(r0, r3);
        switch(r6) {
            case 10: goto L36;
            case 11: goto L36;
            case 12: goto L36;
            case 13: goto L36;
            default: goto L37;
        };
    L37:
        throw new IllegalArgumentException(r1);
    L36:
        throw new IllegalStateException(r1);
    L24:
        r3[1] = "getOriginal";
        goto L28
    L25:
        r3[1] = "getReturnType";
        goto L28
    L26:
        r3[1] = "getValueParameters";
        goto L28
    L27:
        r3[1] = "getOverriddenDescriptors";
        goto L28
    L12:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
        goto L22
    L13:
        r3[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L22
    L14:
        r3[0] = "setterDescriptor";
        goto L22
    L15:
        r3[0] = "parameter";
        goto L22
    L16:
        r3[0] = "source";
        goto L22
    L17:
        r3[0] = "kind";
        goto L22
    L18:
        r3[0] = "visibility";
        goto L22
    L19:
        r3[0] = "modality";
        goto L22
    L20:
        r3[0] = "annotations";
        goto L22
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public static l0 Q0(w0 r13, kotlin.s0.w.d.l0.n.e0 r14, kotlin.s0.w.d.l0.c.o1.g r15) {
        if (r13 == null) goto L12;
        if (r14 == null) goto L10;
        if (r15 != null) goto L7;
        F(9);
        throw null;
    L7:
        return new l0(r13, null, 0, r15, kotlin.s0.w.d.l0.g.h.f20281h, r14, false, false, false, null, a1.f18847a);
    L10:
        F(8);
        throw null;
    L12:
        F(7);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return R0();
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.i(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0
    public /* bridge */ /* synthetic */ t0 L0() {
        return R0();
    }

    public w0 R0() {
        w0 r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(13);
        throw null;
    }

    public void S0(j1 r1) {
        if (r1 == null) goto L5;
        this.r = r1;
        return;
    L5:
        F(6);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return R0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return R0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return R0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.b0, kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y a() {
        return R0();
    }

    @Override // kotlin.s0.w.d.l0.c.y, kotlin.s0.w.d.l0.c.b, kotlin.s0.w.d.l0.c.a
    public Collection<? extends w0> f() {
        Collection<t0> r1 = super.M0(false);
        if (r1 == null) goto L5;
        return r1;
    L5:
        F(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        kotlin.s0.w.d.l0.n.m0 r0 = kotlin.s0.w.d.l0.k.t.a.f(this).Z();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(12);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<j1> h() {
        j1 r0 = this.r;
        if (r0 == null) goto L10;
        List<j1> r1 = Collections.singletonList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        F(11);
        throw null;
    L10:
        throw new IllegalStateException();
    }
}
