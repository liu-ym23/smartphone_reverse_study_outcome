package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1 implements Sequence<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f332a;

    public CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(Iterable r1) {
        this.f332a = r1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return this.f332a.iterator();
    }
}
