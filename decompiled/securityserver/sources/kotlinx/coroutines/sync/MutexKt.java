package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MutexKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Symbol f444a = null;
    public static final Symbol b = null;
    public static final Symbol c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Empty f445d = null;

    static {
        f444a = new Symbol("LOCK_FAIL");
        b = new Symbol("UNLOCK_FAIL");
        Symbol r0 = new Symbol("UNLOCKED");
        c = r0;
        f445d = new Empty(r0);
    }
}
