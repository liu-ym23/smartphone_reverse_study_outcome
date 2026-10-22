package kotlin.coroutines.intrinsics;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@PublishedApi
public final enum CoroutineSingletons extends Enum<CoroutineSingletons> {
    public static final CoroutineSingletons b = null;
    public static final CoroutineSingletons c = null;
    public static final CoroutineSingletons e = null;
    public static final /* synthetic */ CoroutineSingletons[] f = null;

    static {
        CoroutineSingletons r0 = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
        b = r0;
        CoroutineSingletons r1 = new CoroutineSingletons("UNDECIDED", 1);
        c = r1;
        CoroutineSingletons r2 = new CoroutineSingletons("RESUMED", 2);
        e = r2;
        f = new CoroutineSingletons[]{r0, r1, r2};
    }

    public static CoroutineSingletons valueOf(String r1) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, r1);
    }

    public static CoroutineSingletons[] values() {
        return (CoroutineSingletons[]) f.clone();
    }
}
