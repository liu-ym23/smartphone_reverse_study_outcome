package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class EventLoopImplPlatform extends EventLoop {
    public static void z(long r1, EventLoopImplBase.DelayedTask r3) {
        boolean r0 = DebugKt.f370a;
        DefaultExecutor.m.J(r1, r3);
    }

    public abstract Thread x();
}
