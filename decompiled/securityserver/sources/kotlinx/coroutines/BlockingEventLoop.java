package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class BlockingEventLoop extends EventLoopImplBase {
    public final Thread l;

    public BlockingEventLoop(Thread r1) {
        this.l = r1;
    }

    @Override // kotlinx.coroutines.EventLoopImplPlatform
    public final Thread x() {
        return this.l;
    }
}
