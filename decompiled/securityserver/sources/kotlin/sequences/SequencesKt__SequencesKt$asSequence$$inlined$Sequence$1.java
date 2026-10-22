package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 implements Sequence<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f351a;

    public SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(Iterator r1) {
        this.f351a = r1;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return this.f351a;
    }
}
