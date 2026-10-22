package kotlin.s0.w.d;

import kotlin.Metadata;
import kotlin.s0.w.d.l0.c.u0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000bJ!\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/CreateKCallableVisitor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorVisitorEmptyBodies;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "visitFunctionDescriptor", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "data", "(Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "visitPropertyDescriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Lkotlin/Unit;)Lkotlin/reflect/jvm/internal/KCallableImpl;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a extends kotlin.s0.w.d.l0.c.q1.l<f<?>, kotlin.f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f18500a;

    public a(i r2) {
        kotlin.n0.d.o.f(r2, "container");
        this.f18500a = r2;
    }

    @Override // kotlin.s0.w.d.l0.c.o
    public /* bridge */ /* synthetic */ Object d(u0 r1, Object r2) {
        return q(r1, (kotlin.f0) r2);
    }

    @Override // kotlin.s0.w.d.l0.c.q1.l, kotlin.s0.w.d.l0.c.o
    public /* bridge */ /* synthetic */ Object g(kotlin.s0.w.d.l0.c.y r1, Object r2) {
        return p(r1, (kotlin.f0) r2);
    }

    public f<?> p(kotlin.s0.w.d.l0.c.y r2, kotlin.f0 r3) {
        kotlin.n0.d.o.f(r2, "descriptor");
        kotlin.n0.d.o.f(r3, "data");
        return new j(this.f18500a, r2);
    }

    public f<?> q(u0 r4, kotlin.f0 r5) {
        kotlin.n0.d.o.f(r4, "descriptor");
        kotlin.n0.d.o.f(r5, "data");
        int r0 = 0;
        if (r4.f0() == null) goto L5;
        int r6 = 1;
    L7:
        if (r4.m0() == null) goto L9;
        r0 = 1;
    L9:
        int r7 = r6 + r0;
        if (r4.j0() == false) goto L20;
        if (r7 == 0) goto L19;
        if (r7 == 1) goto L17;
        if (r7 != 2) goto L26;
        return new m(this.f18500a, r4);
    L26:
        throw new a0("Unsupported property: " + r4);
    L17:
        return new l(this.f18500a, r4);
    L19:
        return new k(this.f18500a, r4);
    L20:
        if (r7 == 0) goto L30;
        if (r7 == 1) goto L28;
        if (r7 != 2) goto L26;
        return new s(this.f18500a, r4);
    L28:
        return new r(this.f18500a, r4);
    L30:
        return new q(this.f18500a, r4);
    L5:
        r6 = 0;
        goto L7
    }
}
