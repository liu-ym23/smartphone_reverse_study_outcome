package wt;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22907a = 0;
    private static volatile Choreographer choreographer;

    static {
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L4
        Object r10 = Result.m124constructorimpl(new d(a(Looper.getMainLooper())));     // Catch: Throwable -> L4
    L7:
        if (Result.m130isFailureimpl(r10) == false) goto L9;
        r10 = null;
    L9:
        d r11 = (d) r10;
        return;
    L4:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r10 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static final Handler a(Looper r5) {
        Object r10 = Handler.class.getDeclaredMethod("createAsync", new Class[]{Looper.class}).invoke(null, new Object[]{r5});
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.os.Handler");
        return (Handler) r10;
    }
}
