package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NonBlockingContext implements TaskContext {
    public static final NonBlockingContext b = null;

    static {
        b = new NonBlockingContext();
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final void c() {
    }

    @Override // kotlinx.coroutines.scheduling.TaskContext
    public final int g() {
        return 0;
    }
}
