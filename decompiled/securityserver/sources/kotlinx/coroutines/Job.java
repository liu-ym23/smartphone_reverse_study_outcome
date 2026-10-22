package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Job extends CoroutineContext.Element {
    public static final Key g = null;

    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ DisposableHandle a(Job r2, boolean r3, JobNode r4, int r5) {
            boolean r1 = false;
            if ((r5 & 1) == 0) goto L6;
            r3 = false;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r1 = true;
        L9:
            return r2.p(r3, r1, r4);
        }
    }

    @Metadata
    public static final class Key implements CoroutineContext.Key<Job> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Key f375a = null;

        static {
            f375a = new Key();
        }
    }

    static {
        g = Key.f375a;
    }

    void a(CancellationException r1);

    boolean isActive();

    boolean isCancelled();

    Object o(ContinuationImpl r1);

    DisposableHandle p(boolean r1, boolean r2, Function1 r3);

    CancellationException q();

    ChildHandle r(JobSupport r1);

    boolean start();
}
