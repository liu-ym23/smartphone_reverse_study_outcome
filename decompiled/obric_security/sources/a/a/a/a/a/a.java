package a.a.a.a.a;

import a.a.a.a.a.b.c.c;
import android.content.Context;
import com.obric.matrix.push.common.cross_process.CrossProcessService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/matrix/push/common/CommonSupport;", "", "()V", "iCrossProcessService", "Lcom/obric/matrix/push/common/cross_process/interfaze/ICrossProcessService;", "getCrossProcessService", "context", "Landroid/content/Context;", "sdk_push_common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5a = null;
    public static c b;

    static {
        f5a = new a();
    }

    public a() {
    }

    public final c a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (b != null) goto L13;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (b != null) goto L8;
        b = new CrossProcessService(r2);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
    L13:
        c r1 = b;
        Intrinsics.checkNotNull(r1);
        return r1;
    }
}
