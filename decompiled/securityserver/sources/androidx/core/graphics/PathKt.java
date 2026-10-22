package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PathKt {
    @RequiresApi(19)
    @NotNull
    public static final Path and(@NotNull Path r2, @NotNull Path r3) {
        Intrinsics.g(r2, "$this$and");
        Intrinsics.g(r3, "p");
        Path r0 = new Path();
        r0.op(r2, r3, Path.Op.INTERSECT);
        return r0;
    }

    @RequiresApi(26)
    @NotNull
    public static final Iterable<PathSegment> flatten(@NotNull Path r1, float r2) {
        Intrinsics.g(r1, "$this$flatten");
        Collection<PathSegment> r3 = PathUtils.flatten(r1, r2);
        Intrinsics.b(r3, "PathUtils.flatten(this, error)");
        return r3;
    }

    @RequiresApi(26)
    @NotNull
    public static /* synthetic */ Iterable flatten$default(Path r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0.5f;
    L6:
        return flatten(r0, r1);
    }

    @RequiresApi(19)
    @NotNull
    public static final Path minus(@NotNull Path r1, @NotNull Path r2) {
        Intrinsics.g(r1, "$this$minus");
        Intrinsics.g(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.DIFFERENCE);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path or(@NotNull Path r1, @NotNull Path r2) {
        Intrinsics.g(r1, "$this$or");
        Intrinsics.g(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.UNION);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path plus(@NotNull Path r1, @NotNull Path r2) {
        Intrinsics.g(r1, "$this$plus");
        Intrinsics.g(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.UNION);
        return r0;
    }

    @RequiresApi(19)
    @NotNull
    public static final Path xor(@NotNull Path r1, @NotNull Path r2) {
        Intrinsics.g(r1, "$this$xor");
        Intrinsics.g(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.XOR);
        return r0;
    }
}
