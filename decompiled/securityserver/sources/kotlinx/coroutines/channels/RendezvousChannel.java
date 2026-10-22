package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class RendezvousChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean h() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final boolean i() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean r() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean t() {
        return true;
    }
}
