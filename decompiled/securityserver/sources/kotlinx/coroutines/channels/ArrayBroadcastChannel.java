package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private volatile int _size;
    private volatile long _tail;

    @Metadata
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private volatile long _subHead;

        public final Object A() {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public final boolean h() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public final boolean i() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public final boolean r() {
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public final boolean t() {
            if (this._subHead < ArrayBroadcastChannel.p(null)) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public final Object v() {
            throw null;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public final Object w(SelectInstance r1) {
            throw null;
        }

        public final boolean y() {
            if (e() == null) goto L6;
            return false;
        L6:
            if (t() == false) goto L10;
            throw null;
        L10:
            throw null;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
        public final boolean z(Throwable r1) {
            boolean r0 = super.z(r1);
            if (r0 == true) goto L6;
            return r0;
        L6:
            throw null;
        }
    }

    public static final long p(ArrayBroadcastChannel r2) {
        return r2._tail;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final String d() {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean h() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean i() {
        if (this._size < 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final Object k(Object r1) {
        throw null;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public final boolean z(Throwable r1) {
        if (super.z(r1) == true) goto L7;
        return false;
    L7:
        throw null;
    }
}
