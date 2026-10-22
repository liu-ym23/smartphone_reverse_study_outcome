package ub;

import ai.j0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22319a;

    public a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "forestSessionId");
        this.f22319a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f22319a, ((a) r5).f22319a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f22319a.hashCode();
    }

    public final String toString() {
        return j0.p(new StringBuilder("ForestSessionId(forestSessionId="), this.f22319a, ')');
    }
}
