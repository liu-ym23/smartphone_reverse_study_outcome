package wu;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass f22908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22909b;

    public c(KClass r5) {
        Intrinsics.checkNotNullParameter(r5, "type");
        this.f22908a = r5;
        this.f22909b = yu.a.a(r5);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L14:
        return false;
    L8:
        if (c.class != r5.getClass()) goto L14;
        if (Intrinsics.areEqual(this.f22909b, ((c) r5).f22909b) == true) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // wu.a
    public final String getValue() {
        return this.f22909b;
    }

    public final int hashCode() {
        return this.f22909b.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("q:'"), this.f22909b, '\'');
    }
}
