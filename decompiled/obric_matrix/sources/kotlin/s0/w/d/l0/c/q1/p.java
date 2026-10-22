package kotlin.s0.w.d.l0.c.q1;

import com.bytedance.common.wschannel.WsConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.l1;
import kotlin.s0.w.d.l0.n.r1;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p extends k implements kotlin.s0.w.d.l0.c.y {
    private boolean A;
    private boolean B;
    private boolean C;
    private Collection<? extends kotlin.s0.w.d.l0.c.y> D;
    private volatile kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.c.y>> E;
    private final kotlin.s0.w.d.l0.c.y F;
    private final kotlin.s0.w.d.l0.c.b.a G;
    private kotlin.s0.w.d.l0.c.y H;
    protected Map<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> I;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<f1> f19025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<j1> f19026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private kotlin.s0.w.d.l0.n.e0 f19027l;
    private List<x0> m;
    private x0 n;
    private x0 o;
    private kotlin.s0.w.d.l0.c.e0 p;
    private kotlin.s0.w.d.l0.c.u q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    class a implements kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.c.y>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l1 f19028f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f19029g;

        a(p r1, l1 r2) {
            this.f19029g = r1;
            this.f19028f = r2;
        }

        public Collection<kotlin.s0.w.d.l0.c.y> a() {
            kotlin.s0.w.d.l0.p.e r0 = new kotlin.s0.w.d.l0.p.e();
            Iterator<? extends kotlin.s0.w.d.l0.c.y> r1 = this.f19029g.f().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r0.add(r1.next().d(this.f19028f));
            goto L4
        L6:
            return r0;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Collection<kotlin.s0.w.d.l0.c.y> invoke() {
            return a();
        }
    }

    static class b implements kotlin.n0.c.a<List<k1>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f19030f;

        b(List r1) {
            this.f19030f = r1;
        }

        public List<k1> a() {
            return this.f19030f;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<k1> invoke() {
            return a();
        }
    }

    public class c implements kotlin.s0.w.d.l0.c.y.a<kotlin.s0.w.d.l0.c.y> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.n.j1 f19031a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.c.m f19032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.c.e0 f19033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.c.u f19034d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.c.y f19035e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.c.b.a f19036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected List<j1> f19037g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        protected List<x0> f19038h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected x0 f19039i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        protected x0 f19040j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.n.e0 f19041k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        protected kotlin.s0.w.d.l0.g.f f19042l;
        protected boolean m;
        protected boolean n;
        protected boolean o;
        protected boolean p;
        private boolean q;
        private List<f1> r;
        private kotlin.s0.w.d.l0.c.o1.g s;
        private boolean t;
        private Map<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> u;
        private Boolean v;
        protected boolean w;
        final /* synthetic */ p x;

        public c(p r5, kotlin.s0.w.d.l0.n.j1 r6, kotlin.s0.w.d.l0.c.m r7, kotlin.s0.w.d.l0.c.e0 r8, kotlin.s0.w.d.l0.c.u r9, kotlin.s0.w.d.l0.c.b.a r10, List<j1> r11, List<x0> r12, x0 r13, kotlin.s0.w.d.l0.n.e0 r14, kotlin.s0.w.d.l0.g.f r15) {
            if (r6 != null) goto L5;
            u(0);
            throw null;
        L5:
            if (r7 == null) goto L26;
            if (r8 == null) goto L24;
            if (r9 == null) goto L22;
            if (r10 == null) goto L20;
            if (r11 == null) goto L18;
            if (r12 == null) goto L16;
            if (r14 == null) goto L14;
            this.x = r5;
            this.f19035e = null;
            this.f19040j = p.F0(r5);
            this.m = true;
            this.n = false;
            this.o = false;
            this.p = false;
            this.q = r5.w0();
            this.r = null;
            this.s = null;
            this.t = r5.C0();
            this.u = new LinkedHashMap();
            this.v = null;
            this.w = false;
            this.f19031a = r6;
            this.f19032b = r7;
            this.f19033c = r8;
            this.f19034d = r9;
            this.f19036f = r10;
            this.f19037g = r11;
            this.f19038h = r12;
            this.f19039i = r13;
            this.f19041k = r14;
            this.f19042l = r15;
            return;
        L14:
            u(7);
            throw null;
        L16:
            u(6);
            throw null;
        L18:
            u(5);
            throw null;
        L20:
            u(4);
            throw null;
        L22:
            u(3);
            throw null;
        L24:
            u(2);
            throw null;
        L26:
            u(1);
            throw null;
        }

        static /* synthetic */ Map A(c r0) {
            return r0.u;
        }

        private static /* synthetic */ void u(int r17) {
            switch(r17) {
                case 9: goto L4;
                case 10: goto L3;
                case 11: goto L4;
                case 12: goto L3;
                case 13: goto L4;
                case 14: goto L3;
                case 15: goto L4;
                case 16: goto L4;
                case 17: goto L3;
                case 18: goto L4;
                case 19: goto L3;
                case 20: goto L4;
                case 21: goto L3;
                case 22: goto L4;
                case 23: goto L3;
                case 24: goto L4;
                case 25: goto L3;
                case 26: goto L4;
                case 27: goto L4;
                case 28: goto L4;
                case 29: goto L4;
                case 30: goto L4;
                case 31: goto L4;
                case 32: goto L4;
                case 33: goto L4;
                case 34: goto L4;
                case 35: goto L3;
                case 36: goto L4;
                case 37: goto L3;
                case 38: goto L4;
                case 39: goto L3;
                case 40: goto L4;
                case 41: goto L4;
                case 42: goto L4;
                default: goto L3;
            };
        L3:
            String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        L6:
            switch(r17) {
                case 9: goto L8;
                case 10: goto L7;
                case 11: goto L8;
                case 12: goto L7;
                case 13: goto L8;
                case 14: goto L7;
                case 15: goto L8;
                case 16: goto L8;
                case 17: goto L7;
                case 18: goto L8;
                case 19: goto L7;
                case 20: goto L8;
                case 21: goto L7;
                case 22: goto L8;
                case 23: goto L7;
                case 24: goto L8;
                case 25: goto L7;
                case 26: goto L8;
                case 27: goto L8;
                case 28: goto L8;
                case 29: goto L8;
                case 30: goto L8;
                case 31: goto L8;
                case 32: goto L8;
                case 33: goto L8;
                case 34: goto L8;
                case 35: goto L7;
                case 36: goto L8;
                case 37: goto L7;
                case 38: goto L8;
                case 39: goto L7;
                case 40: goto L8;
                case 41: goto L8;
                case 42: goto L8;
                default: goto L7;
            };
        L7:
            int r2 = 3;
        L9:
            Object[] r3 = new Object[r2];
            switch(r17) {
                case 1: goto L28;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L22;
                case 8: goto L21;
                case 9: goto L20;
                case 10: goto L19;
                case 11: goto L20;
                case 12: goto L18;
                case 13: goto L20;
                case 14: goto L25;
                case 15: goto L20;
                case 16: goto L20;
                case 17: goto L17;
                case 18: goto L20;
                case 19: goto L16;
                case 20: goto L20;
                case 21: goto L16;
                case 22: goto L20;
                case 23: goto L15;
                case 24: goto L20;
                case 25: goto L14;
                case 26: goto L20;
                case 27: goto L20;
                case 28: goto L20;
                case 29: goto L20;
                case 30: goto L20;
                case 31: goto L20;
                case 32: goto L20;
                case 33: goto L20;
                case 34: goto L20;
                case 35: goto L13;
                case 36: goto L20;
                case 37: goto L11;
                case 38: goto L20;
                case 39: goto L12;
                case 40: goto L20;
                case 41: goto L20;
                case 42: goto L20;
                default: goto L11;
            };
        L11:
            r3[0] = "substitution";
        L30:
            switch(r17) {
                case 9: goto L54;
                case 10: goto L31;
                case 11: goto L53;
                case 12: goto L31;
                case 13: goto L52;
                case 14: goto L31;
                case 15: goto L51;
                case 16: goto L50;
                case 17: goto L31;
                case 18: goto L49;
                case 19: goto L31;
                case 20: goto L48;
                case 21: goto L31;
                case 22: goto L47;
                case 23: goto L31;
                case 24: goto L46;
                case 25: goto L31;
                case 26: goto L45;
                case 27: goto L44;
                case 28: goto L43;
                case 29: goto L42;
                case 30: goto L41;
                case 31: goto L40;
                case 32: goto L39;
                case 33: goto L38;
                case 34: goto L37;
                case 35: goto L31;
                case 36: goto L36;
                case 37: goto L31;
                case 38: goto L35;
                case 39: goto L31;
                case 40: goto L34;
                case 41: goto L33;
                case 42: goto L32;
                default: goto L31;
            };
        L31:
            r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
        L55:
            switch(r17) {
                case 8: goto L68;
                case 9: goto L69;
                case 10: goto L67;
                case 11: goto L69;
                case 12: goto L66;
                case 13: goto L69;
                case 14: goto L65;
                case 15: goto L69;
                case 16: goto L69;
                case 17: goto L64;
                case 18: goto L69;
                case 19: goto L63;
                case 20: goto L69;
                case 21: goto L62;
                case 22: goto L69;
                case 23: goto L61;
                case 24: goto L69;
                case 25: goto L60;
                case 26: goto L69;
                case 27: goto L69;
                case 28: goto L69;
                case 29: goto L69;
                case 30: goto L69;
                case 31: goto L69;
                case 32: goto L69;
                case 33: goto L69;
                case 34: goto L69;
                case 35: goto L59;
                case 36: goto L69;
                case 37: goto L58;
                case 38: goto L69;
                case 39: goto L57;
                case 40: goto L69;
                case 41: goto L69;
                case 42: goto L69;
                default: goto L56;
            };
        L56:
            r3[2] = "<init>";
            goto L69
        L57:
            r3[2] = "putUserData";
            goto L69
        L58:
            r3[2] = "setSubstitution";
            goto L69
        L59:
            r3[2] = "setAdditionalAnnotations";
            goto L69
        L60:
            r3[2] = "setContextReceiverParameters";
            goto L69
        L61:
            r3[2] = "setReturnType";
            goto L69
        L62:
            r3[2] = "setTypeParameters";
            goto L69
        L63:
            r3[2] = "setValueParameters";
            goto L69
        L64:
            r3[2] = "setName";
            goto L69
        L65:
            r3[2] = "setKind";
            goto L69
        L66:
            r3[2] = "setVisibility";
            goto L69
        L67:
            r3[2] = "setModality";
            goto L69
        L68:
            r3[2] = "setOwner";
        L69:
            String r1 = String.format(r0, r3);
            switch(r17) {
                case 9: goto L73;
                case 10: goto L74;
                case 11: goto L73;
                case 12: goto L74;
                case 13: goto L73;
                case 14: goto L74;
                case 15: goto L73;
                case 16: goto L73;
                case 17: goto L74;
                case 18: goto L73;
                case 19: goto L74;
                case 20: goto L73;
                case 21: goto L74;
                case 22: goto L73;
                case 23: goto L74;
                case 24: goto L73;
                case 25: goto L74;
                case 26: goto L73;
                case 27: goto L73;
                case 28: goto L73;
                case 29: goto L73;
                case 30: goto L73;
                case 31: goto L73;
                case 32: goto L73;
                case 33: goto L73;
                case 34: goto L73;
                case 35: goto L74;
                case 36: goto L73;
                case 37: goto L74;
                case 38: goto L73;
                case 39: goto L74;
                case 40: goto L73;
                case 41: goto L73;
                case 42: goto L73;
                default: goto L74;
            };
        L74:
            throw new IllegalArgumentException(r1);
        L73:
            throw new IllegalStateException(r1);
        L32:
            r3[1] = "setJustForTypeSubstitution";
            goto L55
        L33:
            r3[1] = "getSubstitution";
            goto L55
        L34:
            r3[1] = "putUserData";
            goto L55
        L35:
            r3[1] = "setSubstitution";
            goto L55
        L36:
            r3[1] = "setAdditionalAnnotations";
            goto L55
        L37:
            r3[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
            goto L55
        L38:
            r3[1] = "setHiddenToOvercomeSignatureClash";
            goto L55
        L39:
            r3[1] = "setDropOriginalInContainingParts";
            goto L55
        L40:
            r3[1] = "setPreserveSourceElement";
            goto L55
        L41:
            r3[1] = "setSignatureChange";
            goto L55
        L42:
            r3[1] = "setOriginal";
            goto L55
        L43:
            r3[1] = "setDispatchReceiverParameter";
            goto L55
        L44:
            r3[1] = "setExtensionReceiverParameter";
            goto L55
        L45:
            r3[1] = "setContextReceiverParameters";
            goto L55
        L46:
            r3[1] = "setReturnType";
            goto L55
        L47:
            r3[1] = "setTypeParameters";
            goto L55
        L48:
            r3[1] = "setValueParameters";
            goto L55
        L49:
            r3[1] = "setName";
            goto L55
        L50:
            r3[1] = "setCopyOverrides";
            goto L55
        L51:
            r3[1] = "setKind";
            goto L55
        L52:
            r3[1] = "setVisibility";
            goto L55
        L53:
            r3[1] = "setModality";
            goto L55
        L54:
            r3[1] = "setOwner";
            goto L55
        L12:
            r3[0] = "userDataKey";
            goto L30
        L13:
            r3[0] = "additionalAnnotations";
            goto L30
        L14:
            r3[0] = "contextReceiverParameters";
            goto L30
        L15:
            r3[0] = WsConstants.KEY_CONNECTION_TYPE;
            goto L30
        L16:
            r3[0] = "parameters";
            goto L30
        L17:
            r3[0] = "name";
            goto L30
        L18:
            r3[0] = "visibility";
            goto L30
        L19:
            r3[0] = "modality";
            goto L30
        L20:
            r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
            goto L30
        L21:
            r3[0] = "owner";
            goto L30
        L22:
            r3[0] = "newReturnType";
            goto L30
        L23:
            r3[0] = "newContextReceiverParameters";
            goto L30
        L24:
            r3[0] = "newValueParameterDescriptors";
            goto L30
        L25:
            r3[0] = "kind";
            goto L30
        L26:
            r3[0] = "newVisibility";
            goto L30
        L27:
            r3[0] = "newModality";
            goto L30
        L28:
            r3[0] = "newOwner";
            goto L30
        L8:
            r2 = 2;
            goto L9
        L4:
            r0 = "@NotNull method %s.%s must not return null";
            goto L6
        }

        static /* synthetic */ kotlin.s0.w.d.l0.c.o1.g v(c r0) {
            return r0.s;
        }

        static /* synthetic */ List w(c r0) {
            return r0.r;
        }

        static /* synthetic */ boolean x(c r0) {
            return r0.q;
        }

        static /* synthetic */ boolean y(c r0) {
            return r0.t;
        }

        static /* synthetic */ Boolean z(c r0) {
            return r0.v;
        }

        public c B(kotlin.s0.w.d.l0.c.o1.g r1) {
            if (r1 == null) goto L5;
            this.s = r1;
            return this;
        L5:
            u(35);
            throw null;
        }

        public c C(boolean r1) {
            this.m = r1;
            return this;
        }

        public c D(x0 r1) {
            this.f19040j = r1;
            return this;
        }

        public c E() {
            this.p = true;
            return this;
        }

        public c F(x0 r1) {
            this.f19039i = r1;
            return this;
        }

        public c G(boolean r1) {
            this.v = Boolean.valueOf(r1);
            return this;
        }

        public c H() {
            this.t = true;
            return this;
        }

        public c I() {
            this.q = true;
            return this;
        }

        public c J(boolean r1) {
            this.w = r1;
            return this;
        }

        public c K(kotlin.s0.w.d.l0.c.b.a r1) {
            if (r1 == null) goto L5;
            this.f19036f = r1;
            return this;
        L5:
            u(14);
            throw null;
        }

        public c L(kotlin.s0.w.d.l0.c.e0 r1) {
            if (r1 == null) goto L5;
            this.f19033c = r1;
            return this;
        L5:
            u(10);
            throw null;
        }

        public c M(kotlin.s0.w.d.l0.g.f r1) {
            if (r1 == null) goto L5;
            this.f19042l = r1;
            return this;
        L5:
            u(17);
            throw null;
        }

        public c N(kotlin.s0.w.d.l0.c.b r1) {
            this.f19035e = (kotlin.s0.w.d.l0.c.y) r1;
            return this;
        }

        public c O(kotlin.s0.w.d.l0.c.m r1) {
            if (r1 == null) goto L5;
            this.f19032b = r1;
            return this;
        L5:
            u(8);
            throw null;
        }

        public c P() {
            this.o = true;
            return this;
        }

        public c Q(kotlin.s0.w.d.l0.n.e0 r1) {
            if (r1 == null) goto L5;
            this.f19041k = r1;
            return this;
        L5:
            u(23);
            throw null;
        }

        public c R() {
            this.n = true;
            return this;
        }

        public c S(kotlin.s0.w.d.l0.n.j1 r1) {
            if (r1 == null) goto L5;
            this.f19031a = r1;
            return this;
        L5:
            u(37);
            throw null;
        }

        public c T(List<f1> r1) {
            if (r1 == null) goto L5;
            this.r = r1;
            return this;
        L5:
            u(21);
            throw null;
        }

        public c U(List<j1> r1) {
            if (r1 == null) goto L5;
            this.f19037g = r1;
            return this;
        L5:
            u(19);
            throw null;
        }

        public c V(kotlin.s0.w.d.l0.c.u r1) {
            if (r1 == null) goto L5;
            this.f19034d = r1;
            return this;
        L5:
            u(12);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a a() {
            E();
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a b(List r1) {
            U(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public kotlin.s0.w.d.l0.c.y build() {
            return this.x.N0(this);
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a c(kotlin.s0.w.d.l0.c.e0 r1) {
            L(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a d(x0 r1) {
            D(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a e() {
            P();
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a f(kotlin.s0.w.d.l0.n.e0 r1) {
            Q(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a g(kotlin.s0.w.d.l0.c.b r1) {
            N(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a h() {
            H();
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a i(boolean r1) {
            C(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a j(x0 r1) {
            F(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a k(kotlin.s0.w.d.l0.n.j1 r1) {
            S(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a l(List r1) {
            T(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public <V> kotlin.s0.w.d.l0.c.y.a<kotlin.s0.w.d.l0.c.y> m(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r2, V r3) {
            if (r2 == null) goto L5;
            this.u.put(r2, r3);
            return this;
        L5:
            u(39);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a n(kotlin.s0.w.d.l0.c.u r1) {
            V(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a o(kotlin.s0.w.d.l0.c.m r1) {
            O(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a p() {
            I();
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a q(kotlin.s0.w.d.l0.c.b.a r1) {
            K(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a r(kotlin.s0.w.d.l0.c.o1.g r1) {
            B(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a s(kotlin.s0.w.d.l0.g.f r1) {
            M(r1);
            return this;
        }

        @Override // kotlin.s0.w.d.l0.c.y.a
        public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.y.a t() {
            R();
            return this;
        }
    }

    protected p(kotlin.s0.w.d.l0.c.m r4, kotlin.s0.w.d.l0.c.y r5, kotlin.s0.w.d.l0.c.o1.g r6, kotlin.s0.w.d.l0.g.f r7, kotlin.s0.w.d.l0.c.b.a r8, a1 r9) {
        if (r4 != null) goto L5;
        F(0);
        throw null;
    L5:
        if (r6 == null) goto L20;
        if (r7 == null) goto L18;
        if (r8 == null) goto L16;
        if (r9 == null) goto L14;
        super(r4, r6, r7, r9);
        this.q = kotlin.s0.w.d.l0.c.t.f19167i;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = true;
        this.C = false;
        this.D = null;
        this.E = null;
        this.H = null;
        this.I = null;
        if (r5 != null) goto L12;
        r5 = this;
    L12:
        this.F = r5;
        this.G = r8;
        return;
    L14:
        F(4);
        throw null;
    L16:
        F(3);
        throw null;
    L18:
        F(2);
        throw null;
    L20:
        F(1);
        throw null;
    }

    private static /* synthetic */ void F(int r7) {
        switch(r7) {
            case 9: goto L4;
            case 10: goto L3;
            case 11: goto L3;
            case 12: goto L3;
            case 13: goto L4;
            case 14: goto L4;
            case 15: goto L4;
            case 16: goto L4;
            case 17: goto L3;
            case 18: goto L4;
            case 19: goto L4;
            case 20: goto L4;
            case 21: goto L4;
            case 22: goto L3;
            case 23: goto L4;
            case 24: goto L3;
            case 25: goto L3;
            case 26: goto L4;
            case 27: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r7) {
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            case 13: goto L8;
            case 14: goto L8;
            case 15: goto L8;
            case 16: goto L8;
            case 17: goto L7;
            case 18: goto L8;
            case 19: goto L8;
            case 20: goto L8;
            case 21: goto L8;
            case 22: goto L7;
            case 23: goto L8;
            case 24: goto L7;
            case 25: goto L7;
            case 26: goto L8;
            case 27: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r7) {
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L19;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L18;
            case 14: goto L18;
            case 15: goto L18;
            case 16: goto L18;
            case 17: goto L15;
            case 18: goto L18;
            case 19: goto L18;
            case 20: goto L18;
            case 21: goto L18;
            case 22: goto L14;
            case 23: goto L18;
            case 24: goto L13;
            case 25: goto L12;
            case 26: goto L18;
            case 27: goto L18;
            case 28: goto L20;
            case 29: goto L13;
            case 30: goto L20;
            case 31: goto L13;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L28:
        switch(r7) {
            case 9: goto L41;
            case 10: goto L29;
            case 11: goto L29;
            case 12: goto L29;
            case 13: goto L40;
            case 14: goto L39;
            case 15: goto L38;
            case 16: goto L37;
            case 17: goto L29;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L29;
            case 23: goto L32;
            case 24: goto L29;
            case 25: goto L29;
            case 26: goto L31;
            case 27: goto L30;
            default: goto L29;
        };
    L29:
        r3[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
    L42:
        switch(r7) {
            case 5: goto L52;
            case 6: goto L52;
            case 7: goto L52;
            case 8: goto L52;
            case 9: goto L53;
            case 10: goto L51;
            case 11: goto L50;
            case 12: goto L49;
            case 13: goto L53;
            case 14: goto L53;
            case 15: goto L53;
            case 16: goto L53;
            case 17: goto L48;
            case 18: goto L53;
            case 19: goto L53;
            case 20: goto L53;
            case 21: goto L53;
            case 22: goto L47;
            case 23: goto L53;
            case 24: goto L46;
            case 25: goto L45;
            case 26: goto L53;
            case 27: goto L53;
            case 28: goto L44;
            case 29: goto L44;
            case 30: goto L44;
            case 31: goto L44;
            default: goto L43;
        };
    L43:
        r3[2] = "<init>";
        goto L53
    L44:
        r3[2] = "getSubstitutedValueParameters";
        goto L53
    L45:
        r3[2] = "doSubstitute";
        goto L53
    L46:
        r3[2] = "newCopyBuilder";
        goto L53
    L47:
        r3[2] = "substitute";
        goto L53
    L48:
        r3[2] = "setOverriddenDescriptors";
        goto L53
    L49:
        r3[2] = "setExtensionReceiverParameter";
        goto L53
    L50:
        r3[2] = "setReturnType";
        goto L53
    L51:
        r3[2] = "setVisibility";
        goto L53
    L52:
        r3[2] = "initialize";
    L53:
        String r1 = String.format(r0, r3);
        switch(r7) {
            case 9: goto L57;
            case 10: goto L58;
            case 11: goto L58;
            case 12: goto L58;
            case 13: goto L57;
            case 14: goto L57;
            case 15: goto L57;
            case 16: goto L57;
            case 17: goto L58;
            case 18: goto L57;
            case 19: goto L57;
            case 20: goto L57;
            case 21: goto L57;
            case 22: goto L58;
            case 23: goto L57;
            case 24: goto L58;
            case 25: goto L58;
            case 26: goto L57;
            case 27: goto L57;
            default: goto L58;
        };
    L58:
        throw new IllegalArgumentException(r1);
    L57:
        throw new IllegalStateException(r1);
    L30:
        r3[1] = "getSourceToUseForCopy";
        goto L42
    L31:
        r3[1] = "copy";
        goto L42
    L32:
        r3[1] = "newCopyBuilder";
        goto L42
    L33:
        r3[1] = "getKind";
        goto L42
    L34:
        r3[1] = "getOriginal";
        goto L42
    L35:
        r3[1] = "getValueParameters";
        goto L42
    L36:
        r3[1] = "getTypeParameters";
        goto L42
    L37:
        r3[1] = "getVisibility";
        goto L42
    L38:
        r3[1] = "getModality";
        goto L42
    L39:
        r3[1] = "getOverriddenDescriptors";
        goto L42
    L40:
        r3[1] = "getContextReceiverParameters";
        goto L42
    L41:
        r3[1] = "initialize";
        goto L42
    L12:
        r3[0] = "configuration";
        goto L28
    L13:
        r3[0] = "substitutor";
        goto L28
    L14:
        r3[0] = "originalSubstitutor";
        goto L28
    L15:
        r3[0] = "overriddenDescriptors";
        goto L28
    L16:
        r3[0] = "extensionReceiverParameter";
        goto L28
    L17:
        r3[0] = "unsubstitutedReturnType";
        goto L28
    L18:
        r3[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
        goto L28
    L19:
        r3[0] = "visibility";
        goto L28
    L20:
        r3[0] = "unsubstitutedValueParameters";
        goto L28
    L21:
        r3[0] = "typeParameters";
        goto L28
    L22:
        r3[0] = "contextReceiverParameters";
        goto L28
    L23:
        r3[0] = "source";
        goto L28
    L24:
        r3[0] = "kind";
        goto L28
    L25:
        r3[0] = "name";
        goto L28
    L26:
        r3[0] = "annotations";
        goto L28
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    static /* synthetic */ x0 F0(p r0) {
        return r0.o;
    }

    private a1 O0(boolean r1, kotlin.s0.w.d.l0.c.y r2) {
        if (r1 == false) goto L7;
        if (r2 != null) goto L6;
        r2 = a();
    L6:
        a1 r0 = r2.getSource();
    L8:
        if (r0 == null) goto L10;
        return r0;
    L10:
        F(27);
        throw null;
    L7:
        r0 = a1.f18847a;
        goto L8
    }

    public static List<j1> P0(kotlin.s0.w.d.l0.c.y r7, List<j1> r8, l1 r9) {
        if (r8 == null) goto L9;
        if (r9 != null) goto L6;
        F(29);
        throw null;
    L6:
        return Q0(r7, r8, r9, false, false, null);
    L9:
        F(28);
        throw null;
    }

    public static List<j1> Q0(kotlin.s0.w.d.l0.c.y r19, List<j1> r20, l1 r21, boolean r22, boolean r23, boolean[] r24) {
        if (r20 == null) goto L34;
        if (r21 == null) goto L32;
        ArrayList r2 = new ArrayList(r20.size());
        Iterator<j1> r3 = r20.iterator();
    L7:
        if (r3.hasNext() == false) goto L31;
        j1 r4 = r3.next();
        kotlin.s0.w.d.l0.n.e0 r5 = r4.b();
        r1 r6 = r1.f21066i;
        kotlin.s0.w.d.l0.n.e0 r12 = r21.p(r5, r6);
        kotlin.s0.w.d.l0.n.e0 r7 = r4.l0();
        if (r7 != null) goto L11;
        kotlin.s0.w.d.l0.n.e0 r8 = null;
    L12:
        if (r12 == null) goto L13;
        if (r12 != r4.b()) goto L17;
        if (r7 != r8) goto L17;
    L20:
        if ((r4 instanceof l0.b) == false) goto L22;
        b r18 = new b(((l0.b) r4).O0());
    L23:
        if (r22 == false) goto L25;
        j1 r9 = null;
    L26:
        int r10 = r4.j();
        kotlin.s0.w.d.l0.c.o1.g r11 = r4.getAnnotations();
        kotlin.s0.w.d.l0.g.f r13 = r4.getName();
        boolean r14 = r4.u0();
        boolean r15 = r4.b0();
        boolean r16 = r4.X();
        if (r23 == false) goto L29;
        a1 r17 = r4.getSource();
    L30:
        r2.add(l0.L0(r19, r9, r10, r11, r13, r12, r14, r15, r16, r8, r17, r18));
        goto L7
    L29:
        r17 = a1.f18847a;
        goto L30
    L25:
        r9 = r4;
        goto L26
    L22:
        r18 = null;
    L17:
        if (r24 == null) goto L20;
        r24[0] = true;
        goto L20
    L13:
        return null;
    L11:
        r8 = r21.p(r7, r6);
        goto L12
    L31:
        return r2;
    L32:
        F(31);
        throw null;
    L34:
        F(30);
        throw null;
    }

    private void U0() {
        kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.c.y>> r0 = this.E;
        if (r0 == null) goto L6;
        this.D = r0.invoke();
        this.E = null;
        return;
    }

    private void b1(boolean r1) {
        this.z = r1;
    }

    private void c1(boolean r1) {
        this.y = r1;
    }

    private void e1(kotlin.s0.w.d.l0.c.y r1) {
        this.H = r1;
    }

    @Override // kotlin.s0.w.d.l0.c.q1.k
    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.p A0() {
        return a();
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean C0() {
        return this.z;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public boolean E() {
        return this.C;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean E0() {
        return this.x;
    }

    public <R, D> R K(kotlin.s0.w.d.l0.c.o<R, D> r1, D r2) {
        return r1.g(this, r2);
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public boolean L() {
        return this.w;
    }

    public kotlin.s0.w.d.l0.c.y L0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        kotlin.s0.w.d.l0.c.y r0 = t().o(r1).c(r2).n(r3).q(r4).i(r5).build();
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(26);
        throw null;
    }

    protected abstract p M0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.y r2, kotlin.s0.w.d.l0.c.b.a r3, kotlin.s0.w.d.l0.g.f r4, kotlin.s0.w.d.l0.c.o1.g r5, a1 r6);

    protected kotlin.s0.w.d.l0.c.y N0(c r22) {
        if (r22 == null) goto L107;
        boolean[] r11 = new boolean[1];
        if (c.v(r22) == null) goto L7;
        kotlin.s0.w.d.l0.c.o1.g r0 = kotlin.s0.w.d.l0.c.o1.i.a(getAnnotations(), c.v(r22));
    L8:
        kotlin.s0.w.d.l0.c.m r1 = r22.f19032b;
        kotlin.s0.w.d.l0.c.y r2 = r22.f19035e;
        p r6 = M0(r1, r2, r22.f19036f, r22.f19042l, r0, O0(r22.o, r2));
        if (c.w(r22) != null) goto L11;
        List<f1> r3 = getTypeParameters();
    L12:
        r11[0] = r11[0] | (!r3.isEmpty());
        ArrayList r15 = new ArrayList(r3.size());
        l1 r14 = kotlin.s0.w.d.l0.n.t.c(r3, r22.f19031a, r6, r15, r11);
        if (r14 != null) goto L15;
        return null;
    L15:
        ArrayList r13 = new ArrayList();
        if (r22.f19038h.isEmpty() == true) goto L28;
        Iterator<x0> r4 = r22.f19038h.iterator();
    L19:
        if (r4.hasNext() == false) goto L28;
        x0 r5 = r4.next();
        kotlin.s0.w.d.l0.n.e0 r7 = r14.p(r5.b(), r1.f21066i);
        if (r7 == null) goto L22;
        r13.add(kotlin.s0.w.d.l0.k.c.b(r6, r7, r5.getAnnotations()));
        boolean r8 = r11[0];
        if (r7 == r5.b()) goto L26;
        boolean r9 = true;
    L27:
        r11[0] = r9 | r8;
        goto L19
    L26:
        r9 = false;
        goto L27
    L22:
        return null;
    L28:
        x0 r10 = r22.f19039i;
        if (r10 == null) goto L38;
        kotlin.s0.w.d.l0.n.e0 r12 = r14.p(r10.b(), r1.f21066i);
        if (r12 != null) goto L33;
        return null;
    L33:
        f0 r16 = new f0(r6, new kotlin.s0.w.d.l0.k.w.o.d(r6, r12, r22.f19039i.getValue()), r22.f19039i.getAnnotations());
        boolean r17 = r11[0];
        if (r12 == r22.f19039i.b()) goto L36;
        boolean r18 = true;
    L37:
        r11[0] = r18 | r17;
        f0 r19 = r16;
    L39:
        x0 r20 = r22.f19040j;
        if (r20 == null) goto L49;
        x0 r21 = r20.d(r14);
        if (r21 != null) goto L44;
        return null;
    L44:
        boolean r23 = r11[0];
        if (r21 == r22.f19040j) goto L47;
        boolean r24 = true;
    L48:
        r11[0] = r23 | r24;
        x0 r110 = r21;
    L50:
        List<j1> r25 = Q0(r6, r22.f19037g, r14, r22.p, r22.o, r11);
        if (r25 != null) goto L53;
        return null;
    L53:
        kotlin.s0.w.d.l0.n.e0 r26 = r14.p(r22.f19041k, r1.f21067j);
        if (r26 != null) goto L56;
        return null;
    L56:
        boolean r27 = r11[0];
        if (r26 == r22.f19041k) goto L59;
        boolean r28 = true;
    L60:
        r11[0] = r27 | r28;
        if (r11[0] == false) goto L63;
    L65:
        r6.S0(r19, r110, r13, r15, r25, r26, r22.f19033c, r22.f19034d);
        r6.g1(this.r);
        r6.d1(this.s);
        r6.Y0(this.t);
        r6.f1(this.u);
        r6.j1(this.v);
        r6.i1(this.A);
        r6.X0(this.w);
        r6.W0(this.x);
        r6.Z0(this.B);
        r6.c1(c.x(r22));
        r6.b1(c.y(r22));
        if (c.z(r22) == null) goto L68;
        boolean r29 = c.z(r22).booleanValue();
    L69:
        r6.a1(r29);
        if (c.A(r22).isEmpty() == true) goto L72;
    L73:
        Map<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> r30 = c.A(r22);
        Map<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> r31 = this.I;
        if (r31 == null) goto L82;
        Iterator<Map.Entry<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object>> r32 = r31.entrySet().iterator();
    L77:
        if (r32.hasNext() == false) goto L82;
        Map.Entry<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> r33 = r32.next();
        if (r30.containsKey(r33.getKey()) == true) goto L77;
        r30.put(r33.getKey(), r33.getValue());
    L82:
        if (r30.size() != 1) goto L84;
        r30 = Collections.singletonMap(r30.keySet().iterator().next(), r30.values().iterator().next());
    L84:
        r6.I = r30;
    L86:
        if (r22.n == true) goto L90;
        if (d0() != null) goto L90;
    L95:
        if (r22.m == true) goto L97;
    L106:
        return r6;
    L97:
        if (a().f().isEmpty() == true) goto L106;
        if (r22.f19031a.f() == false) goto L104;
        kotlin.n0.c.a<Collection<kotlin.s0.w.d.l0.c.y>> r34 = this.E;
        if (r34 != null) goto L105;
        r6.x0(f());
    L105:
        r6.E = r34;
        goto L106
    L104:
        r34 = new a(this, r14);
    L90:
        if (d0() == null) goto L92;
        kotlin.s0.w.d.l0.c.y r35 = d0();
    L93:
        r6.e1(r35.d(r14));
        goto L95
    L92:
        r35 = this;
        goto L93
    L72:
        if (this.I == null) goto L86;
    L68:
        r29 = this.C;
        goto L69
    L63:
        if (r22.w == false) goto L65;
        return this;
    L59:
        r28 = false;
        goto L60
    L47:
        r24 = false;
        goto L48
    L49:
        r110 = null;
        goto L50
    L36:
        r18 = false;
        goto L37
    L38:
        r19 = null;
        goto L39
    L11:
        r3 = c.w(r22);
        goto L12
    L7:
        r0 = getAnnotations();
        goto L8
    L107:
        F(25);
        throw null;
    }

    public boolean P() {
        return this.v;
    }

    public boolean R0() {
        return this.B;
    }

    public p S0(x0 r2, x0 r3, List<x0> r4, List<? extends f1> r5, List<j1> r6, kotlin.s0.w.d.l0.n.e0 r7, kotlin.s0.w.d.l0.c.e0 r8, kotlin.s0.w.d.l0.c.u r9) {
        if (r4 == null) goto L29;
        if (r5 == null) goto L27;
        if (r6 == null) goto L25;
        if (r9 == null) goto L23;
        this.f19025j = kotlin.i0.r.z0(r5);
        this.f19026k = kotlin.i0.r.z0(r6);
        this.f19027l = r7;
        this.p = r8;
        this.q = r9;
        this.n = r2;
        this.o = r3;
        this.m = r4;
        int r10 = 0;
        int r11 = 0;
    L9:
        if (r11 >= r5.size()) goto L16;
        f1 r12 = r5.get(r11);
        if (r12.j() != r11) goto L14;
        r11 = r11 + 1;
        goto L9
    L14:
        throw new IllegalStateException(r12 + " index is " + r12.j() + " but position is " + r11);
    L16:
        if (r10 >= r6.size()) goto L22;
        j1 r13 = r6.get(r10);
        if (r13.j() != (r10 + 0)) goto L21;
        r10 = r10 + 1;
        goto L16
    L21:
        throw new IllegalStateException(r13 + "index is " + r13.j() + " but position is " + r10);
    L22:
        return this;
    L23:
        F(8);
        throw null;
    L25:
        F(7);
        throw null;
    L27:
        F(6);
        throw null;
    L29:
        F(5);
        throw null;
    }

    protected c T0(l1 r14) {
        if (r14 != null) goto L4;
        F(24);
        throw null;
    L4:
        return new c(this, r14.j(), c(), l(), getVisibility(), i(), h(), r0(), m0(), getReturnType(), null);
    }

    public <V> void V0(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r2, Object r3) {
        if (this.I != null) goto L5;
        this.I = new LinkedHashMap();
    L5:
        this.I.put(r2, r3);
    }

    public void W0(boolean r1) {
        this.x = r1;
    }

    public void X0(boolean r1) {
        this.w = r1;
    }

    public void Y0(boolean r1) {
        this.t = r1;
    }

    public void Z0(boolean r1) {
        this.B = r1;
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
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.s0.w.d.l0.c.y] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    @Override // kotlin.s0.w.d.l0.c.q1.k, kotlin.s0.w.d.l0.c.q1.j, kotlin.s0.w.d.l0.c.m
    public kotlin.s0.w.d.l0.c.y a() {
        kotlin.s0.w.d.l0.c.y r0 = this.F;
        ?? r1 = this;
        if (r0 == this) goto L6;
        r1 = r0.a();
    L6:
        if (r1 == 0) goto L8;
        return r1;
    L8:
        F(20);
        throw null;
    }

    public void a1(boolean r1) {
        this.C = r1;
    }

    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.n d(l1 r1) {
        return d(r1);
    }

    public kotlin.s0.w.d.l0.c.y d(l1 r2) {
        if (r2 != null) goto L4;
        F(22);
        throw null;
    L4:
        if (r2.k() == false) goto L6;
        return this;
    L6:
        c r3 = T0(r2);
        r3.N(a());
        r3.P();
        r3.J(true);
        return r3.build();
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public kotlin.s0.w.d.l0.c.y d0() {
        return this.H;
    }

    public void d1(boolean r1) {
        this.s = r1;
    }

    public Collection<? extends kotlin.s0.w.d.l0.c.y> f() {
        U0();
        Collection<? extends kotlin.s0.w.d.l0.c.y> r0 = this.D;
        if (r0 != null) goto L6;
        r0 = Collections.emptyList();
    L6:
        if (r0 == null) goto L8;
        return r0;
    L8:
        F(14);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 f0() {
        return this.o;
    }

    public void f1(boolean r1) {
        this.u = r1;
    }

    public void g1(boolean r1) {
        this.r = r1;
    }

    public kotlin.s0.w.d.l0.n.e0 getReturnType() {
        return this.f19027l;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<f1> getTypeParameters() {
        List<f1> r0 = this.f19025j;
        if (r0 == null) goto L9;
        if (r0 == null) goto L6;
        return r0;
    L6:
        F(18);
        throw null;
    L9:
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.s0.w.d.l0.c.q, kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.u getVisibility() {
        kotlin.s0.w.d.l0.c.u r0 = this.q;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(16);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<j1> h() {
        List<j1> r0 = this.f19026k;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(19);
        throw null;
    }

    public void h1(kotlin.s0.w.d.l0.n.e0 r1) {
        if (r1 == null) goto L5;
        this.f19027l = r1;
        return;
    L5:
        F(11);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.b
    public kotlin.s0.w.d.l0.c.b.a i() {
        kotlin.s0.w.d.l0.c.b.a r0 = this.G;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(21);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public <V> V i0(kotlin.s0.w.d.l0.c.a.InterfaceC0500a<V> r1) {
        Map<kotlin.s0.w.d.l0.c.a.InterfaceC0500a<?>, Object> r0 = this.I;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (V) r0.get(r1);
    }

    public void i1(boolean r1) {
        this.A = r1;
    }

    public boolean isExternal() {
        return this.t;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isInfix() {
        if (this.s == false) goto L5;
        return true;
    L5:
        Iterator<? extends kotlin.s0.w.d.l0.c.y> r2 = a().f().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().isInfix() == false) goto L7;
        return true;
    L11:
        return false;
    }

    public boolean isInline() {
        return this.u;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isOperator() {
        if (this.r == false) goto L5;
        return true;
    L5:
        Iterator<? extends kotlin.s0.w.d.l0.c.y> r2 = a().f().iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (r2.next().isOperator() == false) goto L7;
        return true;
    L11:
        return false;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean isSuspend() {
        return this.A;
    }

    public void j1(boolean r1) {
        this.v = r1;
    }

    public /* bridge */ /* synthetic */ kotlin.s0.w.d.l0.c.b k0(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.e0 r2, kotlin.s0.w.d.l0.c.u r3, kotlin.s0.w.d.l0.c.b.a r4, boolean r5) {
        return L0(r1, r2, r3, r4, r5);
    }

    public void k1(kotlin.s0.w.d.l0.c.u r1) {
        if (r1 == null) goto L5;
        this.q = r1;
        return;
    L5:
        F(10);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.d0
    public kotlin.s0.w.d.l0.c.e0 l() {
        kotlin.s0.w.d.l0.c.e0 r0 = this.p;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(15);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public x0 m0() {
        return this.n;
    }

    @Override // kotlin.s0.w.d.l0.c.a
    public List<x0> r0() {
        List<x0> r0 = this.m;
        if (r0 == null) goto L5;
        return r0;
    L5:
        F(13);
        throw null;
    }

    public kotlin.s0.w.d.l0.c.y.a<? extends kotlin.s0.w.d.l0.c.y> t() {
        c r1 = T0(l1.f21038b);
        if (r1 == null) goto L5;
        return r1;
    L5:
        F(23);
        throw null;
    }

    @Override // kotlin.s0.w.d.l0.c.y
    public boolean w0() {
        return this.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void x0(Collection<? extends kotlin.s0.w.d.l0.c.b> r2) {
        if (r2 == 0) goto L10;
        this.D = r2;
        Iterator r3 = r2.iterator();
    L5:
        if (r3.hasNext() == false) goto L15;
        if (((kotlin.s0.w.d.l0.c.y) r3.next()).C0() == false) goto L5;
        this.z = true;
        return;
    L15:
        return;
    L10:
        F(17);
        throw null;
    }
}
