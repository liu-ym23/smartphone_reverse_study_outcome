package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface CoroutineExceptionHandler extends CoroutineContext.Element {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f367d = 0;

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<CoroutineExceptionHandler> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f368a = null;

        static {
            f368a = new Key();
        }
    }

    void y();
}
