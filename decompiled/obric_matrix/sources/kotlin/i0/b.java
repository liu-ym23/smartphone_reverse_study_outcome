package kotlin.i0;

import com.bytedance.common.wschannel.WsConstants;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", "", "()V", "nextValue", "Ljava/lang/Object;", WsConstants.KEY_CONNECTION_STATE, "Lkotlin/collections/State;", "computeNext", "", "done", "hasNext", "", "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class b<T> implements Iterator<T>, kotlin.n0.d.l0.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private y0 f18328f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private T f18329g;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18330a = null;

        static {
            int[] r0 = new int[y0.values().length];
            r0[y0.f18363h.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[y0.f18361f.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f18330a = r0;
        }
    }

    public b() {
        this.f18328f = y0.f18362g;
    }

    private final boolean f() {
        this.f18328f = y0.f18364i;
        b();
        if (this.f18328f != y0.f18361f) goto L5;
        return true;
    L5:
        return false;
    }

    protected abstract void b();

    protected final void c() {
        this.f18328f = y0.f18363h;
    }

    protected final void e(T r1) {
        this.f18329g = r1;
        this.f18328f = y0.f18361f;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        y0 r0 = this.f18328f;
        if (r0 == y0.f18364i) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L15;
        int r2 = a.f18330a[r0.ordinal()];
        if (r2 != 1) goto L10;
        return false;
    L10:
        if (r2 == 2) goto L13;
        return f();
    L13:
        return true;
    L15:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r1 = false;
        goto L6
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        this.f18328f = y0.f18362g;
        return this.f18329g;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
