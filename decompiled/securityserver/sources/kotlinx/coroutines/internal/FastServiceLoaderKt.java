package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FastServiceLoaderKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f413a = false;

    static {
        Object r0 = Class.forName("android.os.Build");     // Catch: Throwable -> L4
    L6:
        f413a = !(r0 instanceof Result.Failure);
        return;
    L4:
        th = move-exception;
        r0 = ResultKt.a(th);
        goto L6
    }
}
