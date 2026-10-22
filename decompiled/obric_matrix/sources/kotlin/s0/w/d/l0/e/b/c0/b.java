package kotlin.s0.w.d.l0.e.b.c0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.s0.w.d.l0.c.a1;
import kotlin.s0.w.d.l0.e.a.a0;
import kotlin.s0.w.d.l0.e.b.q;
import kotlin.s0.w.d.l0.g.f;

/* JADX INFO: loaded from: classes2.dex */
public class b implements q.c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final boolean f19738j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<kotlin.s0.w.d.l0.g.b, kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a> f19739k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f19740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f19741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String[] f19744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String[] f19745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String[] f19746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a f19747h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String[] f19748i;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c0.b$b, reason: collision with other inner class name */
    private static abstract class AbstractC0528b implements q.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<String> f19749a;

        public AbstractC0528b() {
            this.f19749a = new ArrayList();
        }

        private static /* synthetic */ void f(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "enumClassId";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (r6 == 2) goto L15;
            if (r6 == 3) goto L14;
            r1[2] = "visitEnum";
        L17:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L14:
            r1[2] = "visitAnnotation";
            goto L17
        L15:
            r1[2] = "visitClassLiteral";
            goto L17
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "classLiteralValue";
            goto L10
        L9:
            r1[0] = "enumEntryName";
            goto L10
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.b
        public void a() {
            g((String[]) this.f19749a.toArray(new String[0]));
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.b
        public void b(Object r2) {
            if ((r2 instanceof String) == false) goto L6;
            this.f19749a.add((String) r2);
            return;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.b
        public void c(kotlin.s0.w.d.l0.g.b r1, f r2) {
            if (r1 == null) goto L8;
            if (r2 == null) goto L6;
            return;
        L6:
            f(1);
            throw null;
        L8:
            f(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.b
        public q.a d(kotlin.s0.w.d.l0.g.b r1) {
            if (r1 == null) goto L5;
            return null;
        L5:
            f(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.b
        public void e(kotlin.s0.w.d.l0.k.r.f r1) {
            if (r1 == null) goto L4;
            return;
        L4:
            f(2);
            throw null;
        }

        protected abstract void g(String[] r1);
    }

    private class c implements q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f19750a;

        class a extends AbstractC0528b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f19751b;

            a(c r1) {
                this.f19751b = r1;
            }

            private static /* synthetic */ void f(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$1", "visitEnd"}));
            }

            @Override // kotlin.s0.w.d.l0.e.b.c0.b.AbstractC0528b
            protected void g(String[] r1) {
                if (r1 == null) goto L5;
                b.k(this.f19751b.f19750a, r1);
                return;
            L5:
                f(0);
                throw null;
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c0.b$c$b, reason: collision with other inner class name */
        class C0529b extends AbstractC0528b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ c f19752b;

            C0529b(c r1) {
                this.f19752b = r1;
            }

            private static /* synthetic */ void f(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor$2", "visitEnd"}));
            }

            @Override // kotlin.s0.w.d.l0.e.b.c0.b.AbstractC0528b
            protected void g(String[] r1) {
                if (r1 == null) goto L5;
                b.l(this.f19752b.f19750a, r1);
                return;
            L5:
                f(0);
                throw null;
            }
        }

        private c(b r1) {
            this.f19750a = r1;
        }

        /* synthetic */ c(b r1, a r2) {
            this(r1);
        }

        private static /* synthetic */ void g(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "classLiteralValue";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            if (r6 == 1) goto L16;
            if (r6 == 2) goto L16;
            if (r6 == 3) goto L15;
            r1[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L15:
            r1[2] = "visitAnnotation";
        L16:
            r1[2] = "visitEnum";
            goto L18
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "enumEntryName";
            goto L10
        L9:
            r1[0] = "enumClassId";
            goto L10
        }

        private q.b h() {
            return new a(this);
        }

        private q.b i() {
            return new C0529b(this);
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void a() {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void b(f r1, kotlin.s0.w.d.l0.k.r.f r2) {
            if (r2 == null) goto L4;
            return;
        L4:
            g(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void c(f r2, Object r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            String r4 = r2.b();
            if ("k".equals(r4) == false) goto L10;
            if ((r3 instanceof Integer) == false) goto L30;
            b.f(this.f19750a, kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.c(((Integer) r3).intValue()));
            return;
        L30:
            return;
        L10:
            if ("mv".equals(r4) == false) goto L15;
            if ((r3 instanceof int[]) == false) goto L32;
            b.g(this.f19750a, (int[]) r3);
            return;
        L32:
            return;
        L15:
            if ("xs".equals(r4) == false) goto L20;
            if ((r3 instanceof String) == false) goto L34;
            b.h(this.f19750a, (String) r3);
            return;
        L34:
            return;
        L20:
            if ("xi".equals(r4) == false) goto L25;
            if ((r3 instanceof Integer) == false) goto L36;
            b.i(this.f19750a, ((Integer) r3).intValue());
            return;
        L36:
            return;
        L25:
            if ("pn".equals(r4) == true) goto L27;
            return;
        L27:
            if ((r3 instanceof String) == false) goto L39;
            b.j(this.f19750a, (String) r3);
            return;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void d(f r1, kotlin.s0.w.d.l0.g.b r2, f r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L6;
            return;
        L6:
            g(2);
            throw null;
        L8:
            g(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.a e(f r1, kotlin.s0.w.d.l0.g.b r2) {
            if (r2 == null) goto L5;
            return null;
        L5:
            g(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.b f(f r3) {
            if (r3 == null) goto L5;
            String r4 = r3.b();
        L7:
            if ("d1".equals(r4) == false) goto L11;
            return h();
        L11:
            if ("d2".equals(r4) == true) goto L13;
            return null;
        L13:
            return i();
        L5:
            r4 = null;
            goto L7
        }
    }

    private class d implements q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f19753a;

        class a extends AbstractC0528b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ d f19754b;

            a(d r1) {
                this.f19754b = r1;
            }

            private static /* synthetic */ void f(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"result", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor$1", "visitEnd"}));
            }

            @Override // kotlin.s0.w.d.l0.e.b.c0.b.AbstractC0528b
            protected void g(String[] r1) {
                if (r1 == null) goto L5;
                b.e(this.f19754b.f19753a, r1);
                return;
            L5:
                f(0);
                throw null;
            }
        }

        private d(b r1) {
            this.f19753a = r1;
        }

        /* synthetic */ d(b r1, a r2) {
            this(r1);
        }

        private static /* synthetic */ void g(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "classLiteralValue";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinSerializedIrArgumentVisitor";
            if (r6 == 1) goto L16;
            if (r6 == 2) goto L16;
            if (r6 == 3) goto L15;
            r1[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L15:
            r1[2] = "visitAnnotation";
        L16:
            r1[2] = "visitEnum";
            goto L18
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "enumEntryName";
            goto L10
        L9:
            r1[0] = "enumClassId";
            goto L10
        }

        private q.b h() {
            return new a(this);
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void a() {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void b(f r1, kotlin.s0.w.d.l0.k.r.f r2) {
            if (r2 == null) goto L4;
            return;
        L4:
            g(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void c(f r1, Object r2) {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void d(f r1, kotlin.s0.w.d.l0.g.b r2, f r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L6;
            return;
        L6:
            g(2);
            throw null;
        L8:
            g(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.a e(f r1, kotlin.s0.w.d.l0.g.b r2) {
            if (r2 == null) goto L5;
            return null;
        L5:
            g(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.b f(f r3) {
            if (r3 == null) goto L5;
            String r4 = r3.b();
        L7:
            if ("b".equals(r4) == true) goto L9;
            return null;
        L9:
            return h();
        L5:
            r4 = null;
            goto L7
        }
    }

    private class e implements q.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f19755a;

        class a extends AbstractC0528b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f19756b;

            a(e r1) {
                this.f19756b = r1;
            }

            private static /* synthetic */ void f(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$1", "visitEnd"}));
            }

            @Override // kotlin.s0.w.d.l0.e.b.c0.b.AbstractC0528b
            protected void g(String[] r1) {
                if (r1 == null) goto L5;
                b.k(this.f19756b.f19755a, r1);
                return;
            L5:
                f(0);
                throw null;
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.e.b.c0.b$e$b, reason: collision with other inner class name */
        class C0530b extends AbstractC0528b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ e f19757b;

            C0530b(e r1) {
                this.f19757b = r1;
            }

            private static /* synthetic */ void f(int r2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", new Object[]{"data", "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor$2", "visitEnd"}));
            }

            @Override // kotlin.s0.w.d.l0.e.b.c0.b.AbstractC0528b
            protected void g(String[] r1) {
                if (r1 == null) goto L5;
                b.l(this.f19757b.f19755a, r1);
                return;
            L5:
                f(0);
                throw null;
            }
        }

        private e(b r1) {
            this.f19755a = r1;
        }

        /* synthetic */ e(b r1, a r2) {
            this(r1);
        }

        private static /* synthetic */ void g(int r6) {
            Object[] r1 = new Object[3];
            if (r6 == 1) goto L9;
            if (r6 == 2) goto L8;
            if (r6 == 3) goto L7;
            r1[0] = "classLiteralValue";
        L10:
            r1[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            if (r6 == 1) goto L16;
            if (r6 == 2) goto L16;
            if (r6 == 3) goto L15;
            r1[2] = "visitClassLiteral";
        L18:
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r1));
        L15:
            r1[2] = "visitAnnotation";
        L16:
            r1[2] = "visitEnum";
            goto L18
        L7:
            r1[0] = "classId";
            goto L10
        L8:
            r1[0] = "enumEntryName";
            goto L10
        L9:
            r1[0] = "enumClassId";
            goto L10
        }

        private q.b h() {
            return new a(this);
        }

        private q.b i() {
            return new C0530b(this);
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void a() {
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void b(f r1, kotlin.s0.w.d.l0.k.r.f r2) {
            if (r2 == null) goto L4;
            return;
        L4:
            g(0);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void c(f r2, Object r3) {
            if (r2 != null) goto L4;
            return;
        L4:
            String r4 = r2.b();
            if ("version".equals(r4) == false) goto L10;
            if ((r3 instanceof int[]) == false) goto L17;
            b.g(this.f19755a, (int[]) r3);
            return;
        L17:
            return;
        L10:
            if ("multifileClassName".equals(r4) == false) goto L19;
            b r1 = this.f19755a;
            if ((r3 instanceof String) == false) goto L14;
            String r5 = (String) r3;
        L15:
            b.h(r1, r5);
            return;
        L14:
            r5 = null;
            goto L15
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public void d(f r1, kotlin.s0.w.d.l0.g.b r2, f r3) {
            if (r2 == null) goto L8;
            if (r3 == null) goto L6;
            return;
        L6:
            g(2);
            throw null;
        L8:
            g(1);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.a e(f r1, kotlin.s0.w.d.l0.g.b r2) {
            if (r2 == null) goto L5;
            return null;
        L5:
            g(3);
            throw null;
        }

        @Override // kotlin.s0.w.d.l0.e.b.q.a
        public q.b f(f r3) {
            if (r3 == null) goto L5;
            String r4 = r3.b();
        L7:
            if ("data".equals(r4) == true) goto L17;
            if ("filePartClassNames".equals(r4) == true) goto L17;
            if ("strings".equals(r4) == true) goto L14;
            return null;
        L14:
            return i();
        L17:
            return h();
        L5:
            r4 = null;
            goto L7
        }
    }

    static {
        f19738j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        HashMap r0 = new HashMap();
        f19739k = r0;
        r0.put(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal.KotlinClass")), kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19734j);
        r0.put(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal.KotlinFileFacade")), kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19735k);
        r0.put(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal.KotlinMultifileClass")), kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.m);
        r0.put(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal.KotlinMultifileClassPart")), kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.n);
        r0.put(kotlin.s0.w.d.l0.g.b.m(new kotlin.s0.w.d.l0.g.c("kotlin.jvm.internal.KotlinSyntheticClass")), kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19736l);
    }

    public b() {
        this.f19740a = null;
        this.f19741b = null;
        this.f19742c = 0;
        this.f19743d = null;
        this.f19744e = null;
        this.f19745f = null;
        this.f19746g = null;
        this.f19747h = null;
        this.f19748i = null;
    }

    private static /* synthetic */ void d(int r3) {
        Object[] r0 = new Object[3];
        if (r3 == 1) goto L5;
        r0[0] = "classId";
    L6:
        r0[1] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        r0[2] = "visitAnnotation";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", r0));
    L5:
        r0[0] = "source";
        goto L6
    }

    static /* synthetic */ String[] e(b r0, String[] r1) {
        r0.f19748i = r1;
        return r1;
    }

    static /* synthetic */ kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a f(b r0, kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r1) {
        r0.f19747h = r1;
        return r1;
    }

    static /* synthetic */ int[] g(b r0, int[] r1) {
        r0.f19740a = r1;
        return r1;
    }

    static /* synthetic */ String h(b r0, String r1) {
        r0.f19741b = r1;
        return r1;
    }

    static /* synthetic */ int i(b r0, int r1) {
        r0.f19742c = r1;
        return r1;
    }

    static /* synthetic */ String j(b r0, String r1) {
        r0.f19743d = r1;
        return r1;
    }

    static /* synthetic */ String[] k(b r0, String[] r1) {
        r0.f19744e = r1;
        return r1;
    }

    static /* synthetic */ String[] l(b r0, String[] r1) {
        r0.f19745f = r1;
        return r1;
    }

    private boolean n() {
        kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r1 = this.f19747h;
        if (r1 != kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19734j) goto L5;
    L10:
        return true;
    L5:
        if (r1 == kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.f19735k) goto L10;
        if (r1 == kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a.n) goto L10;
        return false;
    }

    @Override // kotlin.s0.w.d.l0.e.b.q.c
    public void a() {
    }

    @Override // kotlin.s0.w.d.l0.e.b.q.c
    public q.a b(kotlin.s0.w.d.l0.g.b r3, a1 r4) {
        a r0 = null;
        if (r3 == null) goto L26;
        if (r4 == null) goto L24;
        kotlin.s0.w.d.l0.g.c r5 = r3.b();
        if (r5.equals(a0.f19204a) == false) goto L10;
        return new c(this, r0);
    L10:
        if (r5.equals(a0.o) == false) goto L14;
        return new d(this, r0);
    L14:
        if (f19738j == false) goto L17;
        return null;
    L17:
        if (this.f19747h == null) goto L19;
        return null;
    L19:
        kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r6 = f19739k.get(r3);
        if (r6 == null) goto L23;
        this.f19747h = r6;
        return new e(this, r0);
    L23:
        return null;
    L24:
        d(1);
        throw null;
    L26:
        d(0);
        throw null;
    }

    public kotlin.s0.w.d.l0.e.b.c0.a m() {
        byte[] r1 = null;
        if (this.f19747h != null) goto L5;
    L24:
        return null;
    L5:
        if (this.f19740a == null) goto L24;
        int[] r0 = this.f19740a;
        if ((this.f19742c & 8) == 0) goto L10;
        boolean r2 = true;
    L11:
        kotlin.s0.w.d.l0.f.a0.b.e r4 = new kotlin.s0.w.d.l0.f.a0.b.e(r0, r2);
        if (r4.h() == true) goto L15;
        this.f19746g = this.f19744e;
        this.f19744e = null;
    L19:
        String[] r3 = this.f19748i;
        if (r3 == null) goto L22;
        r1 = kotlin.s0.w.d.l0.f.a0.b.a.e(r3);
    L22:
        kotlin.s0.w.d.l0.e.b.c0.a.EnumC0526a r5 = this.f19747h;
        String[] r6 = this.f19744e;
        String[] r7 = this.f19746g;
        String[] r8 = this.f19745f;
        String r9 = this.f19741b;
        int r10 = this.f19742c;
        String r11 = this.f19743d;
        return new kotlin.s0.w.d.l0.e.b.c0.a(r5, r4, r6, r7, r8, r9, r10, r11, r1);
    L15:
        if (n() == false) goto L19;
        if (this.f19744e != null) goto L19;
        return null;
    L10:
        r2 = false;
        goto L11
    }
}
