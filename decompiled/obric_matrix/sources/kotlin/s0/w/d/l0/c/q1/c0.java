package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.t0;
import kotlin.s0.w.d.l0.c.u0;
import kotlin.s0.w.d.l0.c.v0;
import kotlin.s0.w.d.l0.c.w0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.j1;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public class c0 extends n0 implements u0 {
    private x0 A;
    private List<f1> B;
    private d0 C;
    private w0 D;
    private boolean E;
    private kotlin.s0.w.d.l0.c.w F;
    private kotlin.s0.w.d.l0.c.w G;
    private final kotlin.s0.w.d.l0.c.e0 n;
    private kotlin.s0.w.d.l0.c.u o;
    private Collection<? extends u0> p;
    private final u0 q;
    private final kotlin.s0.w.d.l0.c.b.a r;
    private final boolean s;
    private final boolean t;
    private final boolean u;
    private final boolean v;
    private final boolean w;
    private final boolean x;
    private List<x0> y;
    private x0 z;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private kotlin.s0.w.d.l0.c.m f18966a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private kotlin.s0.w.d.l0.c.e0 f18967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private kotlin.s0.w.d.l0.c.u f18968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private u0 f18969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f18970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private kotlin.s0.w.d.l0.c.b.a f18971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private j1 f18972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f18973h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private x0 f18974i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<f1> f18975j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private kotlin.s0.w.d.l0.g.f f18976k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private kotlin.s0.w.d.l0.n.e0 f18977l;
        final /* synthetic */ c0 m;

        public a(c0 r3) {
            this.m = r3;
            this.f18966a = r3.c();
            this.f18967b = r3.l();
            this.f18968c = r3.getVisibility();
            this.f18969d = null;
            this.f18970e = false;
            this.f18971f = r3.i();
            this.f18972g = j1.f21031a;
            this.f18973h = true;
            this.f18974i = c0.N0(r3);
            this.f18975j = null;
            this.f18976k = r3.getName();
            this.f18977l = r3.b();
        }

        private static /* synthetic */ void a(int r24) {
            if (r24 == 1) goto L16;
            if (r24 == 2) goto L16;
            if (r24 == 3) goto L16;
            if (r24 == 5) goto L16;
            if (r24 == 7) goto L16;
            if (r24 == 9) goto L16;
            if (r24 == 11) goto L16;
            if (r24 == 19) goto L16;
            if (r24 == 13) goto L16;
            if (r24 == 14) goto L16;
            if (r24 == 16) goto L16;
            if (r24 == 17) goto L16;
            String r13 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L17:
            if (r24 == 1) goto L30;
            if (r24 == 2) goto L30;
            if (r24 == 3) goto L30;
            if (r24 == 5) goto L30;
            if (r24 == 7) goto L30;
            if (r24 == 9) goto L30;
            if (r24 == 11) goto L30;
            if (r24 == 19) goto L30;
            if (r24 == 13) goto L30;
            if (r24 == 14) goto L30;
            if (r24 == 16) goto L30;
            if (r24 == 17) goto L30;
            int r14 = 3;
        L31:
            Object[] r15 = new Object[r14];
            switch(r24) {
                case 1: goto L41;
                case 2: goto L41;
                case 3: goto L41;
                case 4: goto L40;
                case 5: goto L41;
                case 6: goto L39;
                case 7: goto L41;
                case 8: goto L38;
                case 9: goto L41;
                case 10: goto L37;
                case 11: goto L41;
                case 12: goto L36;
                case 13: goto L41;
                case 14: goto L41;
                case 15: goto L35;
                case 16: goto L41;
                case 17: goto L41;
                case 18: goto L34;
                case 19: goto L41;
                default: goto L33;
            };
        L33:
            r15[0] = "owner";
        L43:
            if (r24 == 1) goto L67;
            if (r24 == 2) goto L66;
            if (r24 == 3) goto L65;
            if (r24 == 5) goto L64;
            if (r24 == 7) goto L63;
            if (r24 == 9) goto L62;
            if (r24 == 11) goto L61;
            if (r24 == 19) goto L60;
            if (r24 == 13) goto L59;
            if (r24 == 14) goto L58;
            if (r24 == 16) goto L57;
            if (r24 == 17) goto L56;
            r15[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L68:
            switch(r24) {
                case 1: goto L77;
                case 2: goto L77;
                case 3: goto L77;
                case 4: goto L76;
                case 5: goto L77;
                case 6: goto L75;
                case 7: goto L77;
                case 8: goto L74;
                case 9: goto L77;
                case 10: goto L73;
                case 11: goto L77;
                case 12: goto L72;
                case 13: goto L77;
                case 14: goto L77;
                case 15: goto L71;
                case 16: goto L77;
                case 17: goto L77;
                case 18: goto L70;
                case 19: goto L77;
                default: goto L69;
            };
        L69:
            r15[2] = "setOwner";
            goto L77
        L70:
            r15[2] = "setName";
            goto L77
        L71:
            r15[2] = "setSubstitution";
            goto L77
        L72:
            r15[2] = "setTypeParameters";
            goto L77
        L73:
            r15[2] = "setKind";
            goto L77
        L74:
            r15[2] = "setVisibility";
            goto L77
        L75:
            r15[2] = "setModality";
            goto L77
        L76:
            r15[2] = "setReturnType";
        L77:
            String r16 = String.format(r13, r15);
            if (r24 == 1) goto L92;
            if (r24 == 2) goto L92;
            if (r24 == 3) goto L92;
            if (r24 == 5) goto L92;
            if (r24 == 7) goto L92;
            if (r24 == 9) goto L92;
            if (r24 == 11) goto L92;
            if (r24 == 19) goto L92;
            if (r24 == 13) goto L92;
            if (r24 == 14) goto L92;
            if (r24 == 16) goto L92;
            if (r24 == 17) goto L92;
            throw new IllegalArgumentException(r16);
        L92:
            throw new IllegalStateException(r16);
        L56:
            r15[1] = "setCopyOverrides";
            goto L68
        L57:
            r15[1] = "setSubstitution";
            goto L68
        L58:
            r15[1] = "setDispatchReceiverParameter";
            goto L68
        L59:
            r15[1] = "setTypeParameters";
            goto L68
        L60:
            r15[1] = "setName";
            goto L68
        L61:
            r15[1] = "setKind";
            goto L68
        L62:
            r15[1] = "setVisibility";
            goto L68
        L63:
            r15[1] = "setModality";
            goto L68
        L64:
            r15[1] = "setReturnType";
            goto L68
        L65:
            r15[1] = "setPreserveSourceElement";
            goto L68
        L66:
            r15[1] = "setOriginal";
            goto L68
        L67:
            r15[1] = "setOwner";
            goto L68
        L34:
            r15[0] = "name";
            goto L43
        L35:
            r15[0] = "substitution";
            goto L43
        L36:
            r15[0] = "typeParameters";
            goto L43
        L37:
            r15[0] = "kind";
            goto L43
        L38:
            r15[0] = "visibility";
            goto L43
        L39:
            r15[0] = "modality";
            goto L43
        L40:
            r15[0] = WsConstants.KEY_CONNECTION_TYPE;
            goto L43
        L41:
            r15[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
        L30:
            r14 = 2;
        L16:
            r13 = "@NotNull method %s.%s must not return null";
            goto L17
        }

        static /* synthetic */ kotlin.s0.w.d.l0.c.m b(a r0) {
            return r0.f18966a;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.n.e0 c(a r0) {
            return r0.f18977l;
        }

        static /* synthetic */ x0 d(a r0) {
            return r0.f18974i;
        }

        static /* synthetic */ boolean e(a r0) {
            return r0.f18973h;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.c.e0 f(a r0) {
            return r0.f18967b;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.c.u g(a r0) {
            return r0.f18968c;
        }

        static /* synthetic */ u0 h(a r0) {
            return r0.f18969d;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.c.b.a i(a r0) {
            return r0.f18971f;
        }

        static /* synthetic */ kotlin.s0.w.d.l0.g.f j(a r0) {
            return r0.f18976k;
        }

        static /* synthetic */ boolean k(a r0) {
            return r0.f18970e;
        }

        static /* synthetic */ List l(a r0) {
            return r0.f18975j;
        }

        static /* synthetic */ j1 m(a r0) {
            return r0.f18972g;
        }

        public u0 n() {
            return this.m.R0(this);
        }

        v0 o() {
            u0 r0 = this.f18969d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.g();
        }

        w0 p() {
            u0 r0 = this.f18969d;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.Y();
        }

        public a q(boolean r1) {
            this.f18973h = r1;
            return this;
        }

        public a r(kotlin.s0.w.d.l0.c.b.a r1) {
            if (r1 == null) goto L5;
            this.f18971f = r1;
            return this;
        L5:
            a(10);
            throw null;
        }

        public a s(kotlin.s0.w.d.l0.c.e0 r1) {
            if (r1 == null) goto L5;
            this.f18967b = r1;
            return this;
        L5:
            a(6);
            throw null;
        }

        public a t(kotlin.s0.w.d.l0.c.b r1) {
            this.f18969d = (u0) r1;
            return this;
        }

        public a u(kotlin.s0.w.d.l0.c.m r1) {
            if (r1 == null) goto L5;
            this.f18966a = r1;
            return this;
        L5:
            a(0);
            throw null;
        }

        public a v(j1 r1) {
            if (r1 == null) goto L5;
            this.f18972g = r1;
            return this;
        L5:
            a(15);
            throw null;
        }

        public a w(kotlin.s0.w.d.l0.c.u r1) {
            if (r1 == null) goto L5;
            this.f18968c = r1;
            return this;
        L5:
            a(8);
            throw null;
        }
    }

    protected c0(kotlin.s0.w.d.l0.c.m r13, u0 r14, kotlin.s0.w.d.l0.c.o1.g r15, kotlin.s0.w.d.l0.c.e0 r16, kotlin.s0.w.d.l0.c.u r17, boolean r18, kotlin.s0.w.d.l0.g.f r19, kotlin.s0.w.d.l0.c.b.a r20, a1 r21, boolean r22, boolean r23, boolean r24, boolean r25, boolean r26, boolean r27) {
        if (r13 == null) goto L28;
        if (r15 == null) goto L26;
        if (r16 == null) goto L24;
        if (r17 == null) goto L22;
        if (r19 == null) goto L20;
        if (r20 == null) goto L18;
        if (r21 == null) goto L16;
        super(r13, r15, r19, null, r18, r21);
        this.p = null;
        this.y = Collections.emptyList();
        this.n = r16;
        this.o = r17;
        if (r14 != null) goto L13;
        u0 r0 = this;
    L14:
        this.q = r0;
        this.r = r20;
        this.s = r22;
        this.t = r23;
        this.u = r24;
        this.v = r25;
        this.w = r26;
        this.x = r27;
        return;
    L13:
        r0 = r14;
        goto L14
    L16:
        F(6);
        throw null;
    L18:
        F(5);
        throw null;
    L20:
        F(4);
        throw null;
    L22:
        F(3);
        throw null;
    L24:
        F(2);
        throw null;
    L26:
        F(1);
        throw null;
    L28:
        F(0);
        throw null;
    }

    private static /* synthetic */ void F(int r11) {
        if (r11 == 28) goto L10;
        if (r11 == 38) goto L10;
        if (r11 == 39) goto L10;
        if (r11 == 41) goto L10;
        if (r11 == 42) goto L10;
        switch(r11) {
            case 21: goto L10;
            case 22: goto L10;
            case 23: goto L10;
            case 24: goto L10;
            case 25: goto L10;
            case 26: goto L10;
            default: goto L9;
        };
    L9:
        String r5 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L12:
        if (r11 == 28) goto L19;
        if (r11 == 38) goto L83;
        if (r11 == 39) goto L84;
        if (r11 == 41) goto L85;
        if (r11 == 42) goto L86;
        switch(r11) {
            case 21: goto L87;
            case 22: goto L87;
            case 23: goto L87;
            case 24: goto L87;
            case 25: goto L87;
            case 26: goto L87;
            default: goto L18;
        };
    L18:
        int r7 = 3;
    L20:
        Object[] r8 = new Object[r7];
        switch(r11) {
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L22;
            case 8: goto L42;
            case 9: goto L41;
            case 10: goto L40;
            case 11: goto L39;
            case 12: goto L38;
            case 13: goto L37;
            case 14: goto L36;
            case 15: goto L35;
            case 16: goto L34;
            case 17: goto L35;
            case 18: goto L34;
            case 19: goto L33;
            case 20: goto L40;
            case 21: goto L32;
            case 22: goto L32;
            case 23: goto L32;
            case 24: goto L32;
            case 25: goto L32;
            case 26: goto L32;
            case 27: goto L31;
            case 28: goto L32;
            case 29: goto L30;
            case 30: goto L29;
            case 31: goto L28;
            case 32: goto L27;
            case 33: goto L26;
            case 34: goto L25;
            case 35: goto L38;
            case 36: goto L24;
            case 37: goto L37;
            case 38: goto L32;
            case 39: goto L32;
            case 40: goto L23;
            case 41: goto L32;
            case 42: goto L32;
            default: goto L22;
        };
    L22:
        r8[0] = "containingDeclaration";
    L44:
        if (r11 == 28) goto L61;
        if (r11 == 38) goto L60;
        if (r11 == 39) goto L59;
        if (r11 == 41) goto L58;
        if (r11 == 42) goto L57;
        switch(r11) {
            case 21: goto L56;
            case 22: goto L55;
            case 23: goto L54;
            case 24: goto L53;
            case 25: goto L52;
            case 26: goto L51;
            default: goto L50;
        };
    L50:
        r8[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
    L62:
        switch(r11) {
            case 7: goto L72;
            case 8: goto L72;
            case 9: goto L72;
            case 10: goto L72;
            case 11: goto L72;
            case 12: goto L72;
            case 13: goto L72;
            case 14: goto L71;
            case 15: goto L70;
            case 16: goto L70;
            case 17: goto L70;
            case 18: goto L70;
            case 19: goto L70;
            case 20: goto L69;
            case 21: goto L73;
            case 22: goto L73;
            case 23: goto L73;
            case 24: goto L73;
            case 25: goto L73;
            case 26: goto L73;
            case 27: goto L68;
            case 28: goto L73;
            case 29: goto L67;
            case 30: goto L66;
            case 31: goto L66;
            case 32: goto L65;
            case 33: goto L65;
            case 34: goto L65;
            case 35: goto L65;
            case 36: goto L65;
            case 37: goto L65;
            case 38: goto L73;
            case 39: goto L73;
            case 40: goto L64;
            case 41: goto L73;
            case 42: goto L73;
            default: goto L63;
        };
    L63:
        r8[2] = "<init>";
        goto L73
    L64:
        r8[2] = "setOverriddenDescriptors";
        goto L73
    L65:
        r8[2] = "createSubstitutedCopy";
        goto L73
    L66:
        r8[2] = "getSubstitutedInitialSignatureDescriptor";
        goto L73
    L67:
        r8[2] = "doSubstitute";
        goto L73
    L68:
        r8[2] = "substitute";
        goto L73
    L69:
        r8[2] = "setVisibility";
        goto L73
    L70:
        r8[2] = "setType";
        goto L73
    L71:
        r8[2] = "setInType";
        goto L73
    L72:
        r8[2] = "create";
    L73:
        String r6 = String.format(r5, r8);
        if (r11 == 28) goto L82;
        if (r11 == 38) goto L82;
        if (r11 == 39) goto L82;
        if (r11 == 41) goto L82;
        if (r11 == 42) goto L82;
        switch(r11) {
            case 21: goto L82;
            case 22: goto L82;
            case 23: goto L82;
            case 24: goto L82;
            case 25: goto L82;
            case 26: goto L82;
            default: goto L88;
        };
    L88:
        throw new IllegalArgumentException(r6);
    L82:
        throw new IllegalStateException(r6);
    L51:
        r8[1] = "getAccessors";
        goto L62
    L52:
        r8[1] = "getVisibility";
        goto L62
    L53:
        r8[1] = "getModality";
        goto L62
    L54:
        r8[1] = "getReturnType";
        goto L62
    L55:
        r8[1] = "getContextReceiverParameters";
        goto L62
    L56:
        r8[1] = "getTypeParameters";
        goto L62
    L57:
        r8[1] = "copy";
        goto L62
    L58:
        r8[1] = "getOverriddenDescriptors";
        goto L62
    L59:
        r8[1] = "getKind";
        goto L62
    L60:
        r8[1] = "getOriginal";
        goto L62
    L61:
        r8[1] = "getSourceToUseForCopy";
        goto L62
    L23:
        r8[0] = "overriddenDescriptors";
        goto L44
    L24:
        r8[0] = "newName";
        goto L44
    L25:
        r8[0] = "newVisibility";
        goto L44
    L26:
        r8[0] = "newModality";
        goto L44
    L27:
        r8[0] = "newOwner";
        goto L44
    L28:
        r8[0] = "accessorDescriptor";
        goto L44
    L29:
        r8[0] = "substitutor";
        goto L44
    L30:
        r8[0] = "copyConfiguration";
        goto L44
    L31:
        r8[0] = "originalSubstitutor";
        goto L44
    L32:
        r8[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl";
        goto L44
    L33:
        r8[0] = "contextReceiverParameters";
        goto L44
    L34:
        r8[0] = "typeParameters";
        goto L44
    L35:
        r8[0] = "outType";
        goto L44
    L36:
        r8[0] = "inType";
        goto L44
    L37:
        r8[0] = "source";
        goto L44
    L38:
        r8[0] = "kind";
        goto L44
    L39:
        r8[0] = "name";
        goto L44
    L40:
        r8[0] = "visibility";
        goto L44
    L41:
        r8[0] = "modality";
        goto L44
    L42:
        r8[0] = "annotations";
        goto L44
    L87:
        r7 = 2;
        goto L20
    L86:
        r7 = 2;
        goto L20
    L85:
        r7 = 2;
        goto L20
    L84:
        r7 = 2;
        goto L20
    L83:
        r7 = 2;
        goto L20
    L19:
        r7 = 2;
    L10:
        r5 = "@NotNull method %s.%s must not return null";
        goto L12
    }

    static /* synthetic */ x0 N0(c0 r0) {
        return r0.z;
    }

    public static c0 P0(kotlin.s0.w.d.l0.c.m r17, kotlin.s0.w.d.l0.c.o1.g r18, kotlin.s0.w.d.l0.c.e0 r19, kotlin.s0.w.d.l0.c.u r20, boolean r21, kotlin.s0.w.d.l0.g.f r22, kotlin.s0.w.d.l0.c.b.a r23, a1 r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30) {
        if (r17 == null) goto L24;
        if (r18 == null) goto L22;
        if (r19 == null) goto L20;
        if (r20 == null) goto L18;
        if (r22 == null) goto L16;
        if (r23 == null) goto L14;
        if (r24 != null) goto L11;
        F(13);
        throw null;
    L11:
        return new c0(r17, null, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    L14:
        F(12);
        throw null;
    L16:
        F(11);
        throw null;
    L18:
        F(10);
        throw null;
    L20:
        F(9);
        throw null;
    L22:
        F(8);
        throw null;
    L24:
        F(7);
        throw null;
    }

    private a1 T0(boolean r1, u0 r2) {
        if (r1 == false) goto L7;
        if (r2 != null) goto L6;
        r2 = a();
    L6:
        a1 r0 = r2.getSource();
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        F(28);
        throw null;
    L7:
        r0 = a1.f18847a;
        goto L8
    }

    private static kotlin.s0.w.d.l0.c.y U0(l1 r2, t0 r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L6;
        F(31);
        throw null;
    L6:
        if (r3.d0() != null) goto L8;
        return null;
    L8:
        return r3.d0().d(r2);
    L11:
        F(30);
        throw null;
    }

    private static kotlin.s0.w.d.l0.c.u Z0(kotlin.s0.w.d.l0.c.u r1, kotlin.s0.w.d.l0.c.b.a r2) {
        if (r2 == kotlin.s0.w.d.l0.c.b.a.f18849g) goto L5;
        return r1;
    L5:
        if (kotlin.s0.w.d.l0.c.t.g(r1.f()) == true) goto L7;
        return r1;
    L7:
        return kotlin.s0.w.d.l0.c.t.f19166h;
    }

    private static x0 e1(l1 r3, u0 r4, x0 r5) {
        kotlin.s0.w.d.l0.n.e0 r6 = r3.p(r5.b(), r1.f21066i);
        if (r6 != null) goto L7;
        return null;
    L7:
        return new f0(r4, new kotlin.s0.w.d.l0.k.w.o.c(r4, r6, r5.getValue()), r5.getAnnotations());
    }

    private static x0 f1(l1 r3, u0 r4, x0 r5) {
        kotlin.s0.w.d.l0.n.e0 r6 = r3.p(r5.b(), r1.f21066i);
        if (r6 != null) goto L7;
        return null;
    L7:
        return new f0(r4, new kotlin.s0.w.d.l0.k.w.o.d(r4, r6, r5.getValue()), r5.getAnnotations());
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return this.v;
    }

    @Override // kotlin.s0.w.d.l0.c.m
    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.d(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return this.u;
    }

    @Override // kotlin.s0.w.d.l0.c.l1
    public boolean O() {
        return this.x;
    }

    public u0 O0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        a r0 = Y0();
        r0.u(r1);
        r0.t(null);
        r0.s(r2);
        r0.w(r3);
        r0.r(r4);
        r0.q(r5);
        u0 r6 = r0.n();
        if (r6 == null) goto L5;
        return r6;
    L5:
        F(42);
        throw null;
    }

    protected c0 Q0(kotlin.s0.w.d.l0.c.m r18, kotlin.s0.w.d.l0.c.e0 r19, kotlin.s0.w.d.l0.c.u r20, u0 r21, kotlin.s0.w.d.l0.c.b.a r22, kotlin.s0.w.d.l0.g.f r23, a1 r24) {
        if (r18 == null) goto L21;
        if (r19 == null) goto L19;
        if (r20 == null) goto L17;
        if (r22 == null) goto L15;
        if (r23 == null) goto L13;
        if (r24 != null) goto L10;
        F(37);
        throw null;
    L10:
        return new c0(r18, r21, getAnnotations(), r19, r20, j0(), r23, r22, r24, s0(), y(), L(), E0(), isExternal(), O());
    L13:
        F(36);
        throw null;
    L15:
        F(35);
        throw null;
    L17:
        F(34);
        throw null;
    L19:
        F(33);
        throw null;
    L21:
        F(32);
        throw null;
    }

    protected u0 R0(a r22) {
        o r9 = null;
        if (r22 == null) goto L75;
        c0 r0 = Q0(a.b(r22), a.f(r22), a.g(r22), a.h(r22), a.i(r22), a.j(r22), T0(a.k(r22), a.h(r22)));
        if (a.l(r22) != null) goto L7;
        List<f1> r1 = getTypeParameters();
    L8:
        ArrayList r12 = new ArrayList(r1.size());
        l1 r2 = kotlin.s0.w.d.l0.n.t.b(r1, a.m(r22), r0, r12);
        kotlin.s0.w.d.l0.n.e0 r3 = a.c(r22);
        kotlin.s0.w.d.l0.n.e0 r11 = r2.p(r3, r1.f21067j);
        if (r11 != null) goto L11;
        return null;
    L11:
        kotlin.s0.w.d.l0.n.e0 r4 = r2.p(r3, r1.f21066i);
        if (r4 == null) goto L14;
        r0.a1(r4);
    L14:
        x0 r5 = a.d(r22);
        if (r5 == null) goto L20;
        x0 r6 = r5.d(r2);
        if (r6 != null) goto L19;
        return null;
    L19:
        x0 r13 = r6;
    L21:
        x0 r7 = this.A;
        if (r7 == null) goto L24;
        x0 r14 = f1(r2, r0, r7);
    L25:
        ArrayList r15 = new ArrayList();
        Iterator<x0> r8 = this.y.iterator();
    L27:
        if (r8.hasNext() == false) goto L31;
        x0 r10 = e1(r2, r0, r8.next());
        if (r10 == null) goto L27;
        r15.add(r10);
        goto L27
    L31:
        r0.c1(r11, r12, r13, r14, r15);
        if (this.C != null) goto L34;
        d0 r16 = null;
    L35:
        if (r16 == null) goto L42;
        kotlin.s0.w.d.l0.n.e0 r17 = this.C.getReturnType();
        r16.O0(U0(r2, this.C));
        if (r17 == null) goto L39;
        kotlin.s0.w.d.l0.n.e0 r18 = r2.p(r17, r1.f21067j);
    L40:
        r16.R0(r18);
        goto L42
    L39:
        r18 = null;
    L42:
        if (this.D != null) goto L44;
        e0 r19 = null;
    L45:
        if (r19 == null) goto L54;
        List<kotlin.s0.w.d.l0.c.j1> r20 = p.Q0(r19, this.D.h(), r2, false, false, null);
        if (r20 != null) goto L50;
        r0.b1(true);
        r20 = Collections.singletonList(e0.Q0(r19, kotlin.s0.w.d.l0.k.t.a.f(a.b(r22)).H(), this.D.h().get(0).getAnnotations()));
    L50:
        if (r20.size() != 1) goto L53;
        r19.O0(U0(r2, this.D));
        r19.S0(r20.get(0));
        goto L54
    L53:
        throw new IllegalStateException();
    L54:
        kotlin.s0.w.d.l0.c.w r21 = this.F;
        if (r21 != null) goto L57;
        o r23 = null;
    L58:
        kotlin.s0.w.d.l0.c.w r24 = this.G;
        if (r24 == null) goto L62;
        r9 = new o(r24.getAnnotations(), r0);
    L62:
        r0.W0(r16, r19, r23, r9);
        if (a.e(r22) == false) goto L70;
        kotlin.s0.w.d.l0.p.f r25 = kotlin.s0.w.d.l0.p.f.a();
        Iterator<? extends u0> r26 = f().iterator();
    L66:
        if (r26.hasNext() == false) goto L68;
        r25.add(r26.next().d(r2));
        goto L66
    L68:
        r0.x0(r25);
    L70:
        if (y() == false) goto L74;
        kotlin.n0.c.a<kotlin.s0.w.d.l0.m.j<kotlin.s0.w.d.l0.k.r.g<?>>> r27 = this.m;
        if (r27 == null) goto L74;
        r0.L0(this.f19023l, r27);
    L74:
        return r0;
    L57:
        r23 = new o(r21.getAnnotations(), r0);
        goto L58
    L44:
        r19 = new e0(r0, this.D.getAnnotations(), a.f(r22), Z0(this.D.getVisibility(), a.i(r22)), this.D.U(), this.D.isExternal(), this.D.isInline(), a.i(r22), r22.p(), a1.f18847a);
        goto L45
    L34:
        r16 = new d0(r0, this.C.getAnnotations(), a.f(r22), Z0(this.C.getVisibility(), a.i(r22)), this.C.U(), this.C.isExternal(), this.C.isInline(), a.i(r22), r22.o(), a1.f18847a);
        goto L35
    L24:
        r14 = null;
        goto L25
    L20:
        r13 = null;
        goto L21
    L7:
        r1 = a.l(r22);
        goto L8
    L75:
        F(29);
        throw null;
    }

    public d0 S0() {
        return this.C;
    }

    public void V0(d0 r2, w0 r3) {
        W0(r2, r3, null, null);
    }

    public void W0(d0 r1, w0 r2, kotlin.s0.w.d.l0.c.w r3, kotlin.s0.w.d.l0.c.w r4) {
        this.C = r1;
        this.D = r2;
        this.F = r3;
        this.G = r4;
    }

    public boolean X0() {
        return this.E;
    }

    @Override // kotlin.s0.w.d.l0.c.u0
    public w0 Y() {
        return this.D;
    }

    public a Y0() {
        return new a(this);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.a a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b a() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.m a() {
        return a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.s0.w.d.l0.c.u0] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public u0 a() {
        u0 r0 = this.q;
        ?? r1 = this;
        if (r0 == this) goto L6;
        r1 = r0.a();
    L6:
        if (r1 == 0) goto L8;
        return r1;
    L8:
        F(38);
        throw null;
    }

    public void a1(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 == null) goto L4;
        return;
    L4:
        F(14);
        throw null;
    }

    public void b1(boolean r1) {
        this.E = r1;
    }

    public void c1(kotlin.s0.w.d.l0.n.e0 r2, List<? extends f1> r3, x0 r4, x0 r5, List<x0> r6) {
        if (r2 == null) goto L12;
        if (r3 == null) goto L10;
        if (r6 == null) goto L8;
        F0(r2);
        this.B = new ArrayList(r3);
        this.A = r5;
        this.z = r4;
        this.y = r6;
        return;
    L8:
        F(19);
        throw null;
    L10:
        F(18);
        throw null;
    L12:
        F(17);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return d(r1);
    }

    @Override // kotlin.s0.w.d.l0.c.c1
    public u0 d(l1 r2) {
        if (r2 != null) goto L4;
        F(27);
        throw null;
    L4:
        if (r2.k() == false) goto L6;
        return this;
    L6:
        a r0 = Y0();
        r0.v(r2.j());
        r0.t(a());
        return r0.n();
    }

    public void d1(kotlin.s0.w.d.l0.c.u r1) {
        if (r1 == null) goto L5;
        this.o = r1;
        return;
    L5:
        F(20);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public Collection<? extends u0> f() {
        Collection<? extends u0> r0 = this.p;
        if (r0 != null) goto L6;
        r0 = Collections.emptyList();
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        F(41);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.m0, kotlin.s0.w.d.l0.c.a
    public x0 f0() {
        return this.z;
    }

    @Override // kotlin.s0.w.d.l0.c.u0
    public /* bridge */ /* synthetic */ v0 g() {
        return S0();
    }

    @Override // kotlin.s0.w.d.l0.c.q1.m0, kotlin.s0.w.d.l0.c.a
    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        kotlin.s0.w.d.l0.n.e0 r0 = b();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(23);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.m0, kotlin.s0.w.d.l0.c.a
    public List<f1> getTypeParameters() {
        List<f1> r0 = this.B;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        F(21);
        throw null;
    L9:
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = this.o;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(25);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public kotlin.s0.w.d.l0.c.b.a i() {
        kotlin.s0.w.d.l0.c.b.a r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(39);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public <V> V i0(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r1) {
        return null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean isExternal() {
        return this.w;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return O0(r1, r2, r3, r4, r5);
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.n;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(24);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.m0, kotlin.s0.w.d.l0.c.a
    public x0 m0() {
        return this.A;
    }

    @Override // kotlin.s0.w.d.l0.c.u0
    public kotlin.s0.w.d.l0.c.w n0() {
        return this.G;
    }

    @Override // kotlin.s0.w.d.l0.c.u0
    public kotlin.s0.w.d.l0.c.w q0() {
        return this.F;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<x0> r0() {
        List<x0> r0 = this.y;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(22);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public boolean s0() {
        return this.s;
    }

    @Override // kotlin.s0.w.d.l0.c.u0
    public List<t0> v() {
        ArrayList r0 = new ArrayList(2);
        d0 r1 = this.C;
        if (r1 == null) goto L5;
        r0.add(r1);
    L5:
        w0 r2 = this.D;
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.s0.w.d.l0.c.b
    public void x0(Collection<? extends kotlin.s0.w.d.l0.c.b> r1) {
        if (r1 == 0) goto L5;
        this.p = r1;
        return;
    L5:
        F(40);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.k1
    public boolean y() {
        return this.t;
    }
}
