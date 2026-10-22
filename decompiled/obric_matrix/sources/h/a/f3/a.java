package h.a.f3;

import java.util.Objects;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object[] f17356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17358c;

    public a() {
        this.f17356a = new Object[16];
    }

    private final void b() {
        Object[] r1 = this.f17356a;
        int r8 = r1.length;
        Object[] r15 = new Object[r8 << 1];
        kotlin.i0.i.h(r1, r15, 0, this.f17357b, 0, 10, null);
        Object[] r9 = this.f17356a;
        int r2 = r9.length;
        int r13 = this.f17357b;
        kotlin.i0.i.h(r9, r15, r2 - r13, 0, r13, 4, null);
        this.f17356a = r15;
        this.f17357b = 0;
        this.f17358c = r8;
    }

    public final void a(T r3) {
        Object[] r0 = this.f17356a;
        int r1 = this.f17358c;
        r0[r1] = r3;
        int r4 = (r0.length - 1) & (r1 + 1);
        this.f17358c = r4;
        if (r4 != this.f17357b) goto L6;
        b();
        return;
    }

    public final boolean c() {
        if (this.f17357b != this.f17358c) goto L5;
        return true;
    L5:
        return false;
    }

    public final T d() {
        int r0 = this.f17357b;
        if (r0 != this.f17358c) goto L5;
        return null;
    L5:
        Object[] r1 = this.f17356a;
        T r3 = (T) r1[r0];
        r1[r0] = null;
        this.f17357b = (r0 + 1) & (r1.length - 1);
        Objects.requireNonNull(r3, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return r3;
    }
}
