package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SupervisorKt {
    public static CompletableJob a() {
        return new SupervisorJobImpl(null);
    }
}
