package kotlin.s0.w.d;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.f1;
import kotlin.s0.w.d.l0.c.j1;
import kotlin.s0.w.d.l0.c.r0;
import kotlin.s0.w.d.l0.c.x0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J%\u00106\u001a\u00028\u00002\u0016\u00107\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010908\"\u0004\u0018\u000109H\u0016¢\u0006\u0002\u0010:J#\u0010;\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0002¢\u0006\u0002\u0010=J#\u0010>\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<H\u0016¢\u0006\u0002\u0010=J3\u0010?\u001a\u00028\u00002\u0014\u00107\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u0001090<2\f\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010AH\u0000¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u0002092\u0006\u0010E\u001a\u00020,H\u0002J\n\u0010F\u001a\u0004\u0018\u00010GH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\b \t*\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \t*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\u000e0\u000e0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010 \t*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00070\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010$R\u0014\u0010%\u001a\u00020#8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b%\u0010$R\u0012\u0010&\u001a\u00020#X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$R\u0014\u0010'\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010$R\u0014\u0010(\u001a\u00020#8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0013R\u0014\u0010+\u001a\u00020,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u0013R\u0016\u00102\u001a\u0004\u0018\u0001038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b4\u00105¨\u0006H"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", NotificationCompat.CATEGORY_CALL, "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", WsConstants.KEY_CONNECTION_TYPE, "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class f<R> implements kotlin.s0.c<R>, z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0.a<List<Annotation>> f18534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0.a<ArrayList<kotlin.s0.i>> f18535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c0.a<x> f18536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c0.a<List<y>> f18537i;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends Annotation>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<R> f18538f;

        /* JADX WARN: Multi-variable type inference failed */
        a(f<? extends R> r1) {
            this.f18538f = r1;
            super(0);
        }

        public final List<Annotation> a() {
            return i0.d(this.f18538f.u());
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends Annotation> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends kotlin.n0.d.q implements kotlin.n0.c.a<ArrayList<kotlin.s0.i>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<R> f18539f;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<r0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ x0 f18540f;

            a(x0 r1) {
                this.f18540f = r1;
                super(0);
            }

            public final r0 a() {
                return this.f18540f;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ r0 invoke() {
                return a();
            }
        }

        /* JADX INFO: renamed from: kotlin.s0.w.d.f$b$b, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0483b extends kotlin.n0.d.q implements kotlin.n0.c.a<r0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ x0 f18541f;

            C0483b(x0 r1) {
                this.f18541f = r1;
                super(0);
            }

            public final r0 a() {
                return this.f18541f;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ r0 invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ParameterDescriptor;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<r0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlin.s0.w.d.l0.c.b f18542f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ int f18543g;

            c(kotlin.s0.w.d.l0.c.b r1, int r2) {
                this.f18542f = r1;
                this.f18543g = r2;
                super(0);
            }

            public final r0 a() {
                j1 r1 = this.f18542f.h().get(this.f18543g);
                kotlin.n0.d.o.e(r1, "descriptor.valueParameters[i]");
                return r1;
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ r0 invoke() {
                return a();
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class d<T> implements Comparator {
            public d() {
            }

            @Override // java.util.Comparator
            public final int compare(T r1, T r2) {
                return kotlin.j0.a.a(((kotlin.s0.i) r1).getName(), ((kotlin.s0.i) r2).getName());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(f<? extends R> r1) {
            this.f18539f = r1;
            super(0);
        }

        public final ArrayList<kotlin.s0.i> a() {
            kotlin.s0.w.d.l0.c.b r0 = this.f18539f.u();
            ArrayList<kotlin.s0.i> r1 = new ArrayList();
            int r3 = 0;
            if (this.f18539f.w() == true) goto L11;
            x0 r2 = i0.h(r0);
            if (r2 == null) goto L7;
            r1.add(new p(this.f18539f, 0, kotlin.s0.i.a.f18470f, new a(r2)));
            int r4 = 1;
        L8:
            x0 r5 = r0.m0();
            if (r5 == null) goto L12;
            r1.add(new p(this.f18539f, r4, kotlin.s0.i.a.f18471g, new C0483b(r5)));
            r4 = r4 + 1;
        L12:
            int r6 = r0.h().size();
        L13:
            if (r3 >= r6) goto L16;
            r1.add(new p(this.f18539f, r4, kotlin.s0.i.a.f18472h, new c(r0, r3)));
            r3 = r3 + 1;
            r4 = r4 + 1;
            goto L13
        L16:
            if (this.f18539f.v() == true) goto L18;
        L22:
            r1.trimToSize();
            return r1;
        L18:
            if ((r0 instanceof kotlin.s0.w.d.l0.e.a.k0.a) == false) goto L22;
            if (r1.size() <= 1) goto L22;
            kotlin.i0.r.u(r1, new d());
            goto L22
        L7:
            r4 = 0;
            goto L8
        L11:
            r4 = 0;
            goto L12
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ ArrayList<kotlin.s0.i> invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends kotlin.n0.d.q implements kotlin.n0.c.a<x> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<R> f18544f;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<Type> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ f<R> f18545f;

            /* JADX WARN: Multi-variable type inference failed */
            a(f<? extends R> r1) {
                this.f18545f = r1;
                super(0);
            }

            public final Type a() {
                Type r0 = f.m(this.f18545f);
                if (r0 == null) goto L5;
                return r0;
            L5:
                return this.f18545f.r().getReturnType();
            }

            @Override // kotlin.n0.c.a
            public /* bridge */ /* synthetic */ Type invoke() {
                return a();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(f<? extends R> r1) {
            this.f18544f = r1;
            super(0);
        }

        public final x a() {
            kotlin.s0.w.d.l0.n.e0 r1 = this.f18544f.u().getReturnType();
            kotlin.n0.d.o.c(r1);
            return new x(r1, new a(this.f18544f));
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ x invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class d extends kotlin.n0.d.q implements kotlin.n0.c.a<List<? extends y>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f<R> f18546f;

        /* JADX WARN: Multi-variable type inference failed */
        d(f<? extends R> r1) {
            this.f18546f = r1;
            super(0);
        }

        public final List<y> a() {
            List<f1> r0 = this.f18546f.u().getTypeParameters();
            kotlin.n0.d.o.e(r0, "descriptor.typeParameters");
            f<R> r5 = this.f18546f;
            ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
            Iterator<T> r2 = r0.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            f1 r3 = (f1) r2.next();
            kotlin.n0.d.o.e(r3, "descriptor");
            r1.add(new y(r5, r3));
            goto L4
        L6:
            return r1;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ List<? extends y> invoke() {
            return a();
        }
    }

    public f() {
        c0.a<List<Annotation>> r0 = c0.d(new a(this));
        kotlin.n0.d.o.e(r0, "lazySoft { descriptor.computeAnnotations() }");
        this.f18534f = r0;
        c0.a<ArrayList<kotlin.s0.i>> r1 = c0.d(new b(this));
        kotlin.n0.d.o.e(r1, "lazySoft {\n        val d…ze()\n        result\n    }");
        this.f18535g = r1;
        c0.a<x> r2 = c0.d(new c(this));
        kotlin.n0.d.o.e(r2, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this.f18536h = r2;
        c0.a<List<y>> r3 = c0.d(new d(this));
        kotlin.n0.d.o.e(r3, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this.f18537i = r3;
    }

    public static final /* synthetic */ Type m(f r0) {
        return r0.q();
    }

    private final R n(Map<kotlin.s0.i, ? extends Object> r5) {
        List<kotlin.s0.i> r0 = getParameters();
        ArrayList r1 = new ArrayList(kotlin.i0.r.q(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L21;
        kotlin.s0.i r3 = (kotlin.s0.i) r2.next();
        if (r5.containsKey(r3) == false) goto L13;
        Object r4 = r5.get(r3);
        if (r4 != null) goto L18;
        throw new IllegalArgumentException("Annotation argument value cannot be null (" + r3 + ')');
    L18:
        r1.add(r4);
        goto L4
    L13:
        if (r3.l() == false) goto L16;
        r4 = null;
        goto L18
    L16:
        if (r3.c() == false) goto L20;
        r4 = p(r3.b());
        goto L18
    L20:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r3);
    L21:
        kotlin.s0.w.d.k0.d<?> r6 = t();
        if (r6 == null) goto L30;
        Object[] r7 = r1.toArray(new Object[0]);     // Catch: IllegalAccessException -> L26
        kotlin.n0.d.o.d(r7, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L26
        return (R) r6.call(r7);
    L26:
        e = move-exception;
        throw new kotlin.s0.v.a(e);
    L30:
        throw new a0("This callable does not support a default call: " + u());
    }

    private final Object p(kotlin.s0.m r3) {
        Class r2 = kotlin.n0.a.b(kotlin.s0.w.a.b(r3));
        if (r2.isArray() == false) goto L7;
        Object r4 = Array.newInstance(r2.getComponentType(), 0);
        kotlin.n0.d.o.e(r4, "type.jvmErasure.java.run…\"\n            )\n        }");
        return r4;
    L7:
        throw new a0("Cannot instantiate the default empty array of type " + r2.getSimpleName() + ", because it is not an array type");
    }

    private final Type q() {
        kotlin.s0.w.d.l0.c.b r0 = u();
        if ((r0 instanceof kotlin.s0.w.d.l0.c.y) == false) goto L5;
        kotlin.s0.w.d.l0.c.y r1 = (kotlin.s0.w.d.l0.c.y) r0;
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
    L11:
        r2 = false;
    L12:
        if (r2 == false) goto L31;
        Object r4 = kotlin.i0.r.d0(r().a());
        if ((r4 instanceof ParameterizedType) == false) goto L16;
        ParameterizedType r5 = (ParameterizedType) r4;
    L17:
        if (r5 == null) goto L19;
        Type r3 = r5.getRawType();
    L21:
        if (kotlin.n0.d.o.a(r3, kotlin.k0.d.class) == false) goto L32;
        Type[] r6 = r5.getActualTypeArguments();
        kotlin.n0.d.o.e(r6, "continuationType.actualTypeArguments");
        Object r7 = kotlin.i0.i.S(r6);
        if ((r7 instanceof WildcardType) == false) goto L25;
        WildcardType r8 = (WildcardType) r7;
    L26:
        if (r8 == null) goto L33;
        Type[] r9 = r8.getLowerBounds();
        if (r9 != null) goto L30;
        return null;
    L30:
        return (Type) kotlin.i0.i.w(r9);
    L33:
        return null;
    L25:
        r8 = null;
        goto L26
    L32:
        return null;
    L19:
        r3 = null;
        goto L21
    L16:
        r5 = null;
        goto L17
    L31:
        return null;
    L9:
        if (r1.isSuspend() != true) goto L11;
    L5:
        r1 = null;
        goto L6
    }

    @Override // kotlin.s0.c
    public R call(Object... r2) {
        kotlin.n0.d.o.f(r2, "args");
        return (R) r().call(r2);
    L5:
        e = move-exception;
        throw new kotlin.s0.v.a(e);
    }

    @Override // kotlin.s0.c
    public R callBy(Map<kotlin.s0.i, ? extends Object> r2) {
        kotlin.n0.d.o.f(r2, "args");
        if (v() == false) goto L6;
        return n(r2);
    L6:
        return o(r2, null);
    }

    @Override // kotlin.s0.b
    public List<Annotation> getAnnotations() {
        List<Annotation> r1 = this.f18534f.invoke();
        kotlin.n0.d.o.e(r1, "_annotations()");
        return r1;
    }

    @Override // kotlin.s0.c
    public List<kotlin.s0.i> getParameters() {
        ArrayList<kotlin.s0.i> r1 = this.f18535g.invoke();
        kotlin.n0.d.o.e(r1, "_parameters()");
        return r1;
    }

    @Override // kotlin.s0.c
    public kotlin.s0.m getReturnType() {
        x r1 = this.f18536h.invoke();
        kotlin.n0.d.o.e(r1, "_returnType()");
        return r1;
    }

    @Override // kotlin.s0.c
    public List<kotlin.s0.n> getTypeParameters() {
        List<y> r1 = this.f18537i.invoke();
        kotlin.n0.d.o.e(r1, "_typeParameters()");
        return r1;
    }

    @Override // kotlin.s0.c
    public kotlin.s0.q getVisibility() {
        kotlin.s0.w.d.l0.c.u r1 = u().getVisibility();
        kotlin.n0.d.o.e(r1, "descriptor.visibility");
        return i0.p(r1);
    }

    @Override // kotlin.s0.c
    public boolean isAbstract() {
        if (u().l() != kotlin.s0.w.d.l0.c.e0.f18863j) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.c
    public boolean isFinal() {
        if (u().l() != kotlin.s0.w.d.l0.c.e0.f18860g) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.s0.c
    public boolean isOpen() {
        if (u().l() != kotlin.s0.w.d.l0.c.e0.f18862i) goto L5;
        return true;
    L5:
        return false;
    }

    public final R o(Map<kotlin.s0.i, ? extends Object> r12, kotlin.k0.d<?> r13) {
        kotlin.n0.d.o.f(r12, "args");
        List<kotlin.s0.i> r0 = getParameters();
        ArrayList r1 = new ArrayList(r0.size());
        ArrayList r2 = new ArrayList(1);
        Iterator<kotlin.s0.i> r3 = r0.iterator();
        int r5 = 0;
        boolean r6 = false;
        int r7 = 0;
    L3:
        Object r9 = null;
        if (r3.hasNext() == false) goto L29;
        kotlin.s0.i r8 = r3.next();
        if (r5 == 0) goto L11;
        if ((r5 % 32) != 0) goto L11;
        r2.add(Integer.valueOf(r7));
        r7 = 0;
    L11:
        if (r12.containsKey(r8) == false) goto L15;
        Object r10 = r12.get(r8);
    L13:
        r1.add(r10);
    L25:
        if (r8.i() != kotlin.s0.i.a.f18472h) goto L3;
        r5 = r5 + 1;
        goto L3
    L15:
        if (r8.l() == false) goto L22;
        if (i0.j(r8.b()) == true) goto L20;
        r9 = i0.f(kotlin.s0.w.b.a(r8.b()));
    L20:
        r1.add(r9);
        r7 = (1 << (r5 % 32)) | r7;
        r6 = true;
        goto L25
    L22:
        if (r8.c() == false) goto L28;
        r10 = p(r8.b());
        goto L13
    L28:
        throw new IllegalArgumentException("No argument provided for a required parameter: " + r8);
    L29:
        if (r13 == null) goto L32;
        r1.add(r13);
    L32:
        if (r6 == true) goto L35;
        Object[] r14 = r1.toArray(new Object[0]);
        kotlin.n0.d.o.d(r14, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return call(Arrays.copyOf(r14, r14.length));
    L35:
        r2.add(Integer.valueOf(r7));
        kotlin.s0.w.d.k0.d<?> r15 = t();
        if (r15 == null) goto L44;
        r1.addAll(r2);
        r1.add(null);
        Object[] r11 = r1.toArray(new Object[0]);     // Catch: IllegalAccessException -> L40
        kotlin.n0.d.o.d(r11, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");     // Catch: IllegalAccessException -> L40
        return (R) r15.call(r11);
    L40:
        e = move-exception;
        throw new kotlin.s0.v.a(e);
    L44:
        throw new a0("This callable does not support a default call: " + u());
    }

    public abstract kotlin.s0.w.d.k0.d<?> r();

    public abstract i s();

    public abstract kotlin.s0.w.d.k0.d<?> t();

    public abstract kotlin.s0.w.d.l0.c.b u();

    protected final boolean v() {
        if (kotlin.n0.d.o.a(getName(), "<init>") == true) goto L5;
    L7:
        return false;
    L5:
        if (s().e().isAnnotation() == false) goto L7;
        return true;
    }

    public abstract boolean w();
}
