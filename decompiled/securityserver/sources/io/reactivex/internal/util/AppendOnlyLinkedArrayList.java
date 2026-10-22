package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;
import org.reactivestreams.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T r1);
    }

    public AppendOnlyLinkedArrayList(int r1) {
        this.capacity = r1;
        Object[] r2 = new Object[r1 + 1];
        this.head = r2;
        this.tail = r2;
    }

    public <U> boolean accept(Subscriber<? super U> r4) {
        Object[] r0 = this.head;
        int r3 = this.capacity;
    L3:
        int r1 = 0;
        if (r0 == null) goto L15;
    L5:
        if (r1 >= r3) goto L14;
        Object[] r2 = r0[r1];
        if (r2 == null) goto L14;
        if (NotificationLite.acceptFull(r2, r4) == true) goto L11;
        r1 = r1 + 1;
        goto L5
    L11:
        return true;
    L14:
        r0 = r0[r3];
        goto L3
    L15:
        return false;
    }

    public void add(T r4) {
        int r0 = this.capacity;
        int r1 = this.offset;
        if (r1 != r0) goto L5;
        Object[] r2 = new Object[r0 + 1];
        this.tail[r0] = r2;
        this.tail = r2;
        r1 = 0;
    L5:
        this.tail[r1] = r4;
        this.offset = r1 + 1;
    }

    public void forEachWhile(NonThrowingPredicate<? super T> r4) {
        Object[] r0 = this.head;
        int r3 = this.capacity;
    L3:
        if (r0 == null) goto L14;
        int r1 = 0;
    L5:
        if (r1 >= r3) goto L13;
        Object r2 = r0[r1];
        if (r2 == null) goto L13;
        if (r4.test(r2) == true) goto L11;
        r1 = r1 + 1;
        goto L5
    L11:
        return;
    L13:
        r0 = (Object[]) r0[r3];
        goto L3
    }

    public void setFirst(T r2) {
        this.head[0] = r2;
    }

    public <U> boolean accept(Observer<? super U> r4) {
        Object[] r0 = this.head;
        int r3 = this.capacity;
    L3:
        int r1 = 0;
        if (r0 == null) goto L15;
    L5:
        if (r1 >= r3) goto L14;
        Object[] r2 = r0[r1];
        if (r2 == null) goto L14;
        if (NotificationLite.acceptFull(r2, r4) == true) goto L11;
        r1 = r1 + 1;
        goto L5
    L11:
        return true;
    L14:
        r0 = r0[r3];
        goto L3
    L15:
        return false;
    }

    public <S> void forEachWhile(S r4, BiPredicate<? super S, ? super T> r5) {
        Object[] r0 = this.head;
        int r3 = this.capacity;
    L3:
        int r1 = 0;
    L4:
        if (r1 >= r3) goto L12;
        Object r2 = r0[r1];
        if (r2 == null) goto L7;
        if (r5.test(r4, r2) == true) goto L10;
        r1 = r1 + 1;
        goto L4
    L10:
        return;
    L7:
        return;
    L12:
        r0 = (Object[]) r0[r3];
        goto L3
    }
}
