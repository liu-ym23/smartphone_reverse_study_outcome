package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@ExperimentalTime
public final class MonotonicTimeSource implements TimeSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359a = 0;

    static {
        System.nanoTime();
    }

    public final String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
