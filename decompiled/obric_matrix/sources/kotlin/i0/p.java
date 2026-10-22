package kotlin.i0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000\u001a,\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0000\u001a\u0018\u0010\t\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0002¨\u0006\u000b"}, d2 = {"convertToSetForSetOperation", "", "T", "", "([Ljava/lang/Object;)Ljava/util/Collection;", "", "Lkotlin/sequences/Sequence;", "convertToSetForSetOperationWith", "source", "safeToConvertToSet", "", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class p {
    public static final <T> Collection<T> a(Iterable<? extends T> r1, Iterable<? extends T> r2) {
        kotlin.n0.d.o.f(r1, "<this>");
        kotlin.n0.d.o.f(r2, "source");
        if ((r1 instanceof Set) == false) goto L6;
    L21:
        return (Collection) r1;
    L6:
        if ((r1 instanceof Collection) == false) goto L17;
        if ((r2 instanceof Collection) == true) goto L10;
    L12:
        Collection<T> r3 = (Collection) r1;
        if (b(r3) == true) goto L23;
        return r3;
    L23:
        return b0.x0(r1);
    L10:
        if (((Collection) r2).size() >= 2) goto L12;
    L17:
        if (q.f18359a == true) goto L23;
        return r.z0(r1);
    }

    private static final <T> boolean b(Collection<? extends T> r2) {
        if (q.f18359a == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.size() <= 2) goto L9;
        if ((r2 instanceof ArrayList) == false) goto L9;
        return true;
    }
}
