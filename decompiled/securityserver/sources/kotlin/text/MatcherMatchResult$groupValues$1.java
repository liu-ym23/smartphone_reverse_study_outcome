package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.AbstractList;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MatcherMatchResult$groupValues$1 extends AbstractList<String> {
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return false;
    L7:
        return super.contains((String) r2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final Object get(int r1) {
        throw null;
    }

    @Override // kotlin.collections.AbstractCollection
    public final int getSize() {
        throw null;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return -1;
    L7:
        return super.indexOf((String) r2);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object r2) {
        if ((r2 instanceof String) == true) goto L7;
        return -1;
    L7:
        return super.lastIndexOf((String) r2);
    }
}
