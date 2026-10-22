package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {
    public State b;
    public Object c;

    @Metadata
    public /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[State.values().length];
            r0[2] = 1;
            r0[0] = 2;
        }
    }

    public AbstractIterator() {
        this.b = State.c;
    }

    public abstract void a();

    public final void b() {
        this.b = State.e;
    }

    public final void c(Object r1) {
        this.c = r1;
        this.b = State.b;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        State r0 = this.b;
        State r1 = State.f;
        if (r0 == r1) goto L14;
        int r2 = r0.ordinal();
        if (r2 != 0) goto L7;
        return true;
    L7:
        if (r2 == 2) goto L12;
        this.b = r1;
        a();
        if (this.b != State.b) goto L12;
        return true;
    L12:
        return false;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext() == false) goto L7;
        this.b = State.c;
        return this.c;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
