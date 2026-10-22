package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SeqNumber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f441a = null;
    private volatile long number;

    static {
        f441a = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
    }

    public SeqNumber() {
        this.number = 1;
    }
}
