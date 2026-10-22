package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher m();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        ExecutorCoroutineDispatcher r0 = Dispatchers.f372a;
        MainCoroutineDispatcher r1 = MainDispatcherLoader.f422a;
        if (this != r1) goto L16;
        String r2 = "Dispatchers.Main";
    L12:
        if (r2 == null) goto L15;
        return r2;
    L15:
        return getClass().getSimpleName() + '@' + DebugStringsKt.a(this);
    L16:
        MainCoroutineDispatcher r3 = r1.m();     // Catch: UnsupportedOperationException -> L8
    L9:
        if (this != r3) goto L11;
        r2 = "Dispatchers.Main.immediate";
        goto L12
    L11:
        r2 = null;
    L8:
        r3 = null;
        goto L9
    }
}
