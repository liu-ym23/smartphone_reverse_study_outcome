package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 implements Iterable<Object>, KMappedMarker {
    public final /* synthetic */ Sequence b;

    public SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(Sequence r1) {
        this.b = r1;
    }

    @Override // java.lang.Iterable
    public final Iterator<Object> iterator() {
        return this.b.iterator();
    }
}
