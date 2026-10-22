package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class Empty implements Incomplete {
    public final boolean b;

    public Empty(boolean r1) {
        this.b = r1;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final boolean isActive() {
        return this.b;
    }

    @Override // kotlinx.coroutines.Incomplete
    public final NodeList j() {
        return null;
    }

    public final String toString() {
        StringBuilder r0 = new StringBuilder("Empty{");
        if (this.b == false) goto L5;
        String r2 = "Active";
    L6:
        r0.append(r2);
        r0.append('}');
        return r0.toString();
    L5:
        r2 = "New";
        goto L6
    }
}
