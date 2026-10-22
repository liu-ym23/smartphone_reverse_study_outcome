package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.InternalCoroutinesApi;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public class LockFreeLinkedListNode {
    public static final AtomicReferenceFieldUpdater b = null;
    public static final AtomicReferenceFieldUpdater c = null;
    public static final AtomicReferenceFieldUpdater e = null;
    volatile Object _next;
    volatile Object _prev;
    private volatile Object _removedRef;

    @Metadata
    public static abstract class AbstractAtomicDesc extends AtomicDesc {
        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final void a(AtomicOp r5, Object r6) {
            if (r6 != null) goto L4;
            boolean r7 = true;
        L5:
            LockFreeLinkedListNode r0 = f();
            if (r0 == null) goto L19;
            LockFreeLinkedListNode r1 = g();
            if (r1 == null) goto L17;
            if (r7 == false) goto L11;
            Object r2 = l(r0, r1);
        L13:
            if (LockFreeLinkedListNode.b.compareAndSet(r0, r5, r2) == false) goto L21;
            if (r7 == false) goto L22;
            d(r1);
            return;
        L22:
            return;
        L21:
            return;
        L11:
            r2 = r1;
            goto L13
        L17:
            boolean r4 = DebugKt.f370a;
            return;
        L19:
            boolean r8 = DebugKt.f370a;
            return;
        L4:
            r7 = false;
            goto L5
        }

        @Override // kotlinx.coroutines.internal.AtomicDesc
        public final Object b(AtomicOp r7) {
        L2:
            LockFreeLinkedListNode r0 = k(r7);
            Symbol r1 = AtomicKt.b;
            if (r0 == null) goto L36;
            Object r2 = r0._next;
            if (r2 == r7) goto L6;
            if (r7.h() == true) goto L9;
            if ((r2 instanceof OpDescriptor) == true) goto L12;
            Object r3 = c(r0);
            if (r3 != null) goto L18;
            if (j(r2) == true) goto L2;
            if (r2 == null) goto L35;
            PrepareOp r4 = new PrepareOp(r0, (LockFreeLinkedListNode) r2, this);
            if (LockFreeLinkedListNode.b.compareAndSet(r0, r2, r4) == false) goto L2;
        L31:
            th = move-exception;
            LockFreeLinkedListNode.b.compareAndSet(r0, r4, r2);
            throw th;
        L27:
            if (r4.c(r0) == LockFreeLinkedList_commonKt.f417a) goto L2;
            boolean r6 = DebugKt.f370a;     // Catch: Throwable -> L31
            return null;
        L35:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        L18:
            return r3;
        L12:
            OpDescriptor r5 = (OpDescriptor) r2;
            if (r7.b(r5) == true) goto L14;
            r5.c(r0);
            goto L2
        L14:
            return r1;
        L9:
            return null;
        L6:
            return null;
        L36:
            return r1;
        }

        public Object c(LockFreeLinkedListNode r1) {
            return null;
        }

        public abstract void d(LockFreeLinkedListNode r1);

        public abstract void e(PrepareOp r1);

        public abstract LockFreeLinkedListNode f();

        public abstract LockFreeLinkedListNode g();

        public Object h(PrepareOp r1) {
            e(r1);
            return null;
        }

        public void i(LockFreeLinkedListNode r1) {
        }

        public boolean j(Object r1) {
            return false;
        }

        public LockFreeLinkedListNode k(OpDescriptor r1) {
            LockFreeLinkedListNode r0 = f();
            Intrinsics.c(r0);
            return r0;
        }

        public abstract Object l(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2);
    }

    @Metadata
    public static class AddLastDesc<T extends LockFreeLinkedListNode> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater b = null;
        private volatile Object _affectedNode;

        static {
            b = AtomicReferenceFieldUpdater.newUpdater(AddLastDesc.class, Object.class, "_affectedNode");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void d(LockFreeLinkedListNode r1) {
            AtomicReferenceFieldUpdater r0 = LockFreeLinkedListNode.b;
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void e(PrepareOp r3) {
            LockFreeLinkedListNode r4 = r3.f415a;
            b.compareAndSet(this, null, r4);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode f() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode g() {
            return null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean j(Object r1) {
            if (r1 == null) goto L4;
            return true;
        L4:
            return false;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode k(OpDescriptor r1) {
            AtomicReferenceFieldUpdater r0 = LockFreeLinkedListNode.b;
            throw null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object l(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2) {
            LockFreeLinkedListNode.c.compareAndSet(null, null, r1);
            LockFreeLinkedListNode.b.compareAndSet(null, null, null);
            return null;
        }
    }

    @Metadata
    @PublishedApi
    public static abstract class CondAddOp extends AtomicOp<LockFreeLinkedListNode> {
        public LockFreeLinkedListNode b;
        public final LockFreeLinkedListNode c;

        public CondAddOp(LockFreeLinkedListNode r1) {
            this.c = r1;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        public final void d(Object r4, Object r5) {
            LockFreeLinkedListNode r6 = (LockFreeLinkedListNode) r4;
            if (r5 != null) goto L5;
            boolean r7 = true;
        L6:
            LockFreeLinkedListNode r0 = this.c;
            if (r7 == false) goto L9;
            LockFreeLinkedListNode r1 = r0;
        L10:
            if (r1 != null) goto L12;
            return;
        L12:
            if (LockFreeLinkedListNode.b.compareAndSet(r6, this, r1) == false) goto L17;
            if (r7 == false) goto L18;
            LockFreeLinkedListNode r3 = this.b;
            Intrinsics.c(r3);
            r0.y(r3);
            return;
        L18:
            return;
        L17:
            return;
        L9:
            r1 = this.b;
            goto L10
        L5:
            r7 = false;
            goto L6
        }
    }

    @Metadata
    public static final class PrepareOp extends OpDescriptor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LockFreeLinkedListNode f415a;
        public final LockFreeLinkedListNode b;
        public final AbstractAtomicDesc c;

        public PrepareOp(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2, AbstractAtomicDesc r3) {
            this.f415a = r1;
            this.b = r2;
            this.c = r3;
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final AtomicOp a() {
            AtomicOp r0 = this.c.f406a;
            if (r0 == null) goto L5;
            return r0;
        L5:
            Intrinsics.m("atomicOp");
            throw null;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final Object c(Object r7) {
            boolean r0 = DebugKt.f370a;
            if (r7 == null) goto L21;
            LockFreeLinkedListNode r8 = (LockFreeLinkedListNode) r7;
            AbstractAtomicDesc r1 = this.c;
            Object r2 = r1.h(this);
            Symbol r3 = LockFreeLinkedList_commonKt.f417a;
            LockFreeLinkedListNode r4 = this.b;
            if (r2 != r3) goto L10;
            AtomicReferenceFieldUpdater r5 = LockFreeLinkedListNode.b;
            Removed r6 = r4.I();
            if (LockFreeLinkedListNode.b.compareAndSet(r8, this, r6) == false) goto L9;
            r1.i(r8);
            r4.v(null);
        L9:
            return r3;
        L10:
            if (r2 == null) goto L12;
            Object r9 = a().e(r2);
        L13:
            Object r10 = r4;
            if (r9 != AtomicKt.f407a) goto L16;
            r10 = a();
        L18:
            LockFreeLinkedListNode.b.compareAndSet(r8, this, r10);
            return null;
        L16:
            if (r9 != null) goto L18;
            r10 = r1.l(r8, r4);
            goto L18
        L12:
            r9 = a().f();
            goto L13
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        public final void d() {
            this.c.e(this);
        }

        @Override // kotlinx.coroutines.internal.OpDescriptor
        public final String toString() {
            return "PrepareOp(op=" + a() + ')';
        }
    }

    @Metadata
    public static class RemoveFirstDesc<T> extends AbstractAtomicDesc {
        public static final AtomicReferenceFieldUpdater c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f416d = null;
        private volatile Object _affectedNode;
        private volatile Object _originalNext;
        public final LockFreeLinkedListNode b;

        static {
            c = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_affectedNode");
            f416d = AtomicReferenceFieldUpdater.newUpdater(RemoveFirstDesc.class, Object.class, "_originalNext");
        }

        public RemoveFirstDesc(LockFreeLinkedListNode r1) {
            this.b = r1;
            this._affectedNode = null;
            this._originalNext = null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public Object c(LockFreeLinkedListNode r1) {
            if (r1 == this.b) goto L7;
            return null;
        L7:
            return LockFreeLinkedListKt.b;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void d(LockFreeLinkedListNode r1) {
            AtomicReferenceFieldUpdater r0 = LockFreeLinkedListNode.b;
            r1.v(null);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final void e(PrepareOp r4) {
            LockFreeLinkedListNode r0 = r4.f415a;
            c.compareAndSet(this, null, r0);
            f416d.compareAndSet(this, null, r4.b);
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode f() {
            return (LockFreeLinkedListNode) this._affectedNode;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode g() {
            return (LockFreeLinkedListNode) this._originalNext;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final boolean j(Object r1) {
            if ((r1 instanceof Removed) == true) goto L6;
            return false;
        L6:
            ((Removed) r1).f423a.E();
            return true;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final LockFreeLinkedListNode k(OpDescriptor r4) {
            LockFreeLinkedListNode r0 = this.b;
        L3:
            Object r1 = r0._next;
            if ((r1 instanceof OpDescriptor) == false) goto L10;
            OpDescriptor r2 = (OpDescriptor) r1;
            if (r4.b(r2) == true) goto L7;
            r2.c(this.b);
            goto L3
        L7:
            return null;
        L10:
            if (r1 == null) goto L14;
            return (LockFreeLinkedListNode) r1;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        public final Object l(LockFreeLinkedListNode r1, LockFreeLinkedListNode r2) {
            AtomicReferenceFieldUpdater r0 = LockFreeLinkedListNode.b;
            return r2.I();
        }

        public final LockFreeLinkedListNode m() {
            LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) this._affectedNode;
            Intrinsics.c(r0);
            return r0;
        }
    }

    static {
        b = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_next");
        c = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_prev");
        e = AtomicReferenceFieldUpdater.newUpdater(LockFreeLinkedListNode.class, Object.class, "_removedRef");
    }

    public LockFreeLinkedListNode() {
        this._next = this;
        this._prev = this;
        this._removedRef = null;
    }

    public final LockFreeLinkedListNode A() {
        Object r1 = z();
        if ((r1 instanceof Removed) == true) goto L5;
        Object r0 = null;
    L6:
        Removed r2 = (Removed) r0;
        if (r2 == null) goto L11;
        LockFreeLinkedListNode r3 = r2.f423a;
        if (r3 == null) goto L11;
        return r3;
    L11:
        if (r1 == null) goto L15;
        return (LockFreeLinkedListNode) r1;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L5:
        r0 = r1;
        goto L6
    }

    public final LockFreeLinkedListNode C() {
        LockFreeLinkedListNode r0 = v(null);
        if (r0 != null) goto L8;
        r0 = (LockFreeLinkedListNode) this._prev;
    L7:
        if (r0.F() == false) goto L8;
        r0 = (LockFreeLinkedListNode) r0._prev;
    L8:
        return r0;
    }

    public final void D() {
        Object r1 = z();
        if (r1 == null) goto L7;
        ((Removed) r1).f423a.v(null);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Removed");
    }

    public final void E() {
    L2:
        Object r0 = this.z();
        if ((r0 instanceof Removed) == false) goto L4;
        LockFreeLinkedListNode this = ((Removed) r0).f423a;
        goto L2
    L4:
        this.v(null);
    }

    public boolean F() {
        return z() instanceof Removed;
    }

    public boolean G() {
        if (H() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final LockFreeLinkedListNode H() {
    L2:
        Object r0 = z();
        if ((r0 instanceof Removed) == true) goto L5;
        if (r0 == this) goto L8;
        if (r0 == null) goto L15;
        LockFreeLinkedListNode r1 = (LockFreeLinkedListNode) r0;
        Removed r2 = r1.I();
        if (b.compareAndSet(this, r0, r2) == false) goto L2;
        r1.v(null);
        return null;
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L8:
        return (LockFreeLinkedListNode) r0;
    L5:
        return ((Removed) r0).f423a;
    }

    public final Removed I() {
        Removed r0 = (Removed) this._removedRef;
        if (r0 != null) goto L7;
        Removed r1 = new Removed(this);
        e.lazySet(this, r1);
        return r1;
    L7:
        return r0;
    }

    public final int J(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3, CondAddOp r4) {
        c.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = b;
        r0.lazySet(r2, r3);
        r4.b = r3;
        if (r0.compareAndSet(this, r3, r4) == true) goto L7;
        return 0;
    L7:
        if (r4.c(this) != null) goto L9;
        return 1;
    L9:
        return 2;
    }

    public void dispose() {
        G();
    }

    public final boolean t(LockFreeLinkedListNode r2, LockFreeLinkedListNode r3) {
        c.lazySet(r2, this);
        AtomicReferenceFieldUpdater r0 = b;
        r0.lazySet(r2, r3);
        if (r0.compareAndSet(this, r3, r2) == true) goto L6;
        return false;
    L6:
        r2.y(r3);
        return true;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + Integer.toHexString(System.identityHashCode(this));
    }

    public final LockFreeLinkedListNode v(OpDescriptor r7) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) this._prev;
        LockFreeLinkedListNode r2 = r0;
    L3:
        LockFreeLinkedListNode r3 = null;
    L4:
        Object r4 = r2._next;
        if (r4 == this) goto L6;
        if (F() == true) goto L14;
        if (r4 == r7) goto L16;
        if ((r4 instanceof OpDescriptor) == true) goto L19;
        if ((r4 instanceof Removed) == true) goto L26;
        if (r4 == null) goto L35;
        r3 = r2;
        r2 = (LockFreeLinkedListNode) r4;
        goto L4
    L35:
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    L26:
        if (r3 != null) goto L28;
        r2 = (LockFreeLinkedListNode) r2._prev;
        goto L4
    L28:
        if (b.compareAndSet(r3, r2, ((Removed) r4).f423a) == false) goto L2;
        r2 = r3;
        goto L3
    L19:
        if (r7 != null) goto L21;
    L23:
        ((OpDescriptor) r4).c(r2);
        goto L2
    L21:
        if (r7.b((OpDescriptor) r4) == false) goto L23;
        return null;
    L16:
        return r2;
    L14:
        return null;
    L6:
        if (r0 == r2) goto L7;
        if (c.compareAndSet(this, r0, r2) == false) goto L2;
        return r2;
    L7:
        return r2;
    }

    public final void y(LockFreeLinkedListNode r3) {
    L2:
        LockFreeLinkedListNode r0 = (LockFreeLinkedListNode) r3._prev;
        if (z() != r3) goto L4;
        if (c.compareAndSet(r3, r0, this) == false) goto L2;
        if (F() == false) goto L14;
        r3.v(null);
        return;
    L14:
        return;
    }

    public final Object z() {
    L2:
        Object r0 = this._next;
        if ((r0 instanceof OpDescriptor) == false) goto L4;
        ((OpDescriptor) r0).c(this);
        goto L2
    L4:
        return r0;
    }
}
