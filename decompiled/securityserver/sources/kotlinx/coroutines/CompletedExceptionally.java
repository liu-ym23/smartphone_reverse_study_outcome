package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class CompletedExceptionally {
    public static final AtomicIntegerFieldUpdater b = null;
    private volatile int _handled;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f364a;

    static {
        b = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    }

    public CompletedExceptionally(Throwable r1, boolean r2) {
        this.f364a = r1;
        this._handled = r2 ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final String toString() {
        return getClass().getSimpleName() + '[' + this.f364a + ']';
    }
}
