package w1;

import ai.j0;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k implements u1.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList f22692a;

    public k() {
        this.f22692a = new LinkedList();
    }

    public final String toString() {
        return j0.p(new StringBuilder("href=["), CollectionsKt.q(this.f22692a, ", ", null, null, 0, null, null, 62), ']');
    }
}
