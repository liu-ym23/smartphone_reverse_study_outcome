package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007\u001a\u0015\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f¨\u0006\f"}, d2 = {"and", "Landroid/graphics/Path;", "p", "flatten", "", "Landroidx/core/graphics/PathSegment;", WsConstants.KEY_CONNECTION_ERROR, "", "minus", "or", "plus", "xor", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ClassVerificationFailure"})
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path r2, Path r3) {
        o.f(r2, "<this>");
        o.f(r3, "p");
        Path r0 = new Path();
        r0.op(r2, r3, Path.Op.INTERSECT);
        return r0;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path r1, float r2) {
        o.f(r1, "<this>");
        Collection<PathSegment> r3 = PathUtils.flatten(r1, r2);
        o.e(r3, "flatten(this, error)");
        return r3;
    }

    public static /* synthetic */ Iterable flatten$default(Path r0, float r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0.5f;
    L6:
        return flatten(r0, r1);
    }

    @RequiresApi(19)
    public static final Path minus(Path r1, Path r2) {
        o.f(r1, "<this>");
        o.f(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.DIFFERENCE);
        return r0;
    }

    @RequiresApi(19)
    public static final Path or(Path r1, Path r2) {
        o.f(r1, "<this>");
        o.f(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.UNION);
        return r0;
    }

    @RequiresApi(19)
    public static final Path plus(Path r1, Path r2) {
        o.f(r1, "<this>");
        o.f(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.UNION);
        return r0;
    }

    @RequiresApi(19)
    public static final Path xor(Path r1, Path r2) {
        o.f(r1, "<this>");
        o.f(r2, "p");
        Path r0 = new Path(r1);
        r0.op(r2, Path.Op.XOR);
        return r0;
    }
}
