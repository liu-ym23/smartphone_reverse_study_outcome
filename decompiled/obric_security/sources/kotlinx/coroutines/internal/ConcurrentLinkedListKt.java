package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u001a#\u0010\u0002\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001ao\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0004*\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u000628\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u00000\bH\u0082\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"\u001a\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", SlardarConfigConsts.CONFIG_ID, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "prev", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "getCLOSED$annotations", "()V", "", "POINTERS_SHIFT", "I", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = null;
    private static final int POINTERS_SHIFT = 16;

    public static final /* synthetic */ Symbol access$getCLOSED$p() {
        return CLOSED;
    }

    private static /* synthetic */ void getCLOSED$annotations() {
    }

    private static final <S extends Segment<S>> Object findSegmentInternal(S r4, long r5, Function2<? super Long, ? super S, ? extends S> r7) {
    L3:
        if (r4.getId() >= r5) goto L5;
    L9:
        Object r0 = ConcurrentLinkedListNode.access$getNextOrClosed(r4);
        if (r0 == access$getCLOSED$p()) goto L12;
        S r1 = (S) ((ConcurrentLinkedListNode) r0);
        if (r1 != null) goto L15;
        r1 = r7.invoke(Long.valueOf(r4.getId() + 1), r4);
        S r6 = r4;
        if (r6.trySetNext(r1) == false) goto L3;
        if (r4.getRemoved() == false) goto L15;
        r4.remove();
    L15:
        r4 = (Object) r1;
        goto L3
    L12:
        return SegmentOrClosed.m2329constructorimpl(access$getCLOSED$p());
    L5:
        if (r4.getRemoved() == true) goto L9;
        return SegmentOrClosed.m2329constructorimpl(r4);
    }

    static {
        CLOSED = new Symbol("CLOSED");
    }

    public static final <N extends ConcurrentLinkedListNode<N>> N close(N r2) {
    L2:
        Object r0 = ConcurrentLinkedListNode.access$getNextOrClosed(r2);
        if (r0 == access$getCLOSED$p()) goto L4;
        ConcurrentLinkedListNode r1 = (ConcurrentLinkedListNode) r0;
        if (r1 == null) goto L8;
        r2 = (N) r1;
        goto L2
    L8:
        if (r2.markAsClosed() == false) goto L2;
        return r2;
    L4:
        return r2;
    }
}
