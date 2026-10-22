package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ChannelKt {
    public static AbstractChannel a(int r3, BufferOverflow r4, int r5) {
        int r6 = r5 & 2;
        BufferOverflow r0 = BufferOverflow.b;
        if (r6 == 0) goto L5;
        r4 = r0;
    L5:
        int r2 = 1;
        if (r3 == (-2)) goto L26;
        if (r3 == (-1)) goto L21;
        if (r3 != 0) goto L11;
        if (r4 != r0) goto L34;
        return new RendezvousChannel(null);
    L34:
        return new ArrayChannel(1, r4, null);
    L11:
        if (r3 == Integer.MAX_VALUE) goto L32;
        if (r3 != 1) goto L31;
        if (r4 != BufferOverflow.c) goto L31;
        return new ConflatedChannel(null);
    L31:
        return new ArrayChannel(r3, r4, null);
    L32:
        return new LinkedListChannel(null);
    L21:
        if (r4 != r0) goto L24;
        return new ConflatedChannel(null);
    L24:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
    L26:
        if (r4 != r0) goto L29;
        Channel.h.getClass();
        r2 = Channel.Factory.f385a;
    L29:
        return new ArrayChannel(r2, r4, null);
    }
}
