package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@InternalCoroutinesApi
@Metadata
public interface ParentJob extends Job {

    @Metadata
    public static final class DefaultImpls {
    }

    CancellationException F();
}
