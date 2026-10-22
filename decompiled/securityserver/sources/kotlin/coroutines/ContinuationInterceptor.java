package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.internal.DispatchedContinuation;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public interface ContinuationInterceptor extends CoroutineContext.Element {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f335a = 0;

    @Metadata
    public static final class DefaultImpls {
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<ContinuationInterceptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f336a = null;

        static {
            f336a = new Key();
        }
    }

    DispatchedContinuation C(ContinuationImpl r1);

    void b(Continuation r1);
}
