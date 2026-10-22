package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\tH\u0082\b\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001av\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\b\b\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0080\bø\u0001\u0000\u001aj\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0013*\b\u0012\u0004\u0012\u0002H\u00130\u0014*\b\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cur", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", ExifInterface.LATITUDE_SOUTH, "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", "id", "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "to", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = null;
    private static final int POINTERS_SHIFT = 16;

    public static final /* synthetic */ Symbol access$getCLOSED$p() {
        return CLOSED;
    }

    private static final void loop$atomicfu(AtomicReferenceFieldUpdater r1, Function1<Object, Unit> r2, Object r3) {
    L2:
        r2.invoke(r1.get(r3));
        goto L2
    }

    private static final void loop$atomicfu$array(AtomicReferenceArray r1, int r2, Function1<Object, Unit> r3) {
    L2:
        r3.invoke(r1.get(r2));
        goto L2
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S r4, long r5, Function2<? super Long, ? super S, ? extends S> r7) {
    L3:
        if (r4.id >= r5) goto L5;
    L9:
        Object r0 = ConcurrentLinkedListNode.access$getNextOrClosed(r4);
        if (r0 == access$getCLOSED$p()) goto L12;
        S r1 = (S) ((ConcurrentLinkedListNode) r0);
        if (r1 != null) goto L15;
        r1 = r7.invoke(Long.valueOf(r4.id + 1), r4);
        S r6 = r4;
        if (r6.trySetNext(r1) == false) goto L3;
        if (r4.isRemoved() == false) goto L15;
        r4.remove();
    L15:
        r4 = (Object) r1;
        goto L3
    L12:
        return SegmentOrClosed.m3070constructorimpl(CLOSED);
    L5:
        if (r4.isRemoved() == true) goto L9;
        return SegmentOrClosed.m3070constructorimpl(r4);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;TS;)Z */
    public static final boolean moveForward$atomicfu(Object r5, AtomicReferenceFieldUpdater r6, Segment r7) {
    L2:
        Segment r0 = (Segment) r6.get(r5);
        if (r0.id >= r7.id) goto L4;
        if (r7.tryIncPointers$kotlinx_coroutines_core() == false) goto L7;
        if (r6.compareAndSet(r5, r0, r7) == true) goto L12;
        if (r7.decPointers$kotlinx_coroutines_core() == false) goto L2;
        r7.remove();
        goto L2
    L12:
        if (r0.decPointers$kotlinx_coroutines_core() == false) goto L14;
        r0.remove();
    L14:
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicReferenceArray;ITS;)Z */
    public static final boolean moveForward$atomicfu$array(Object r4, AtomicReferenceArray r5, int r6, Segment r7) {
    L2:
        Segment r8 = (Segment) r5.get(r6);
        if (r8.id >= r7.id) goto L4;
        if (r7.tryIncPointers$kotlinx_coroutines_core() == false) goto L7;
        if (r5.compareAndSet(r6, r8, r7) == true) goto L12;
        if (r7.decPointers$kotlinx_coroutines_core() == false) goto L2;
        r7.remove();
        goto L2
    L12:
        if (r8.decPointers$kotlinx_coroutines_core() == false) goto L14;
        r8.remove();
    L14:
        return true;
    L7:
        return false;
    L4:
        return true;
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;JTS;Lkotlin/jvm/functions/Function2<-Ljava/lang/Long;-TS;+TS;>;)Ljava/lang/Object; */
    public static final Object findSegmentAndMoveForward$atomicfu(Object r7, AtomicReferenceFieldUpdater r8, long r9, Segment r11, Function2 r12) {
    L2:
        Object r0 = findSegmentInternal(r11, r9, r12);
        if (SegmentOrClosed.m3075isClosedimpl(r0) == true) goto L21;
        Segment r1 = SegmentOrClosed.m3073getSegmentimpl(r0);
    L5:
        Segment r2 = (Segment) r8.get(r7);
        boolean r4 = true;
        if (r2.id >= r1.id) goto L16;
        if (r1.tryIncPointers$kotlinx_coroutines_core() == false) goto L10;
        if (r8.compareAndSet(r7, r2, r1) == true) goto L14;
        if (r1.decPointers$kotlinx_coroutines_core() == false) goto L5;
        r1.remove();
        goto L5
    L14:
        if (r2.decPointers$kotlinx_coroutines_core() == false) goto L16;
        r2.remove();
        goto L16
    L10:
        r4 = false;
    L16:
        if (r4 == false) goto L2;
    L21:
        return r0;
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/util/concurrent/atomic/AtomicReferenceArray;IJTS;Lkotlin/jvm/functions/Function2<-Ljava/lang/Long;-TS;+TS;>;)Ljava/lang/Object; */
    public static final Object findSegmentAndMoveForward$atomicfu$array(Object r6, AtomicReferenceArray r7, int r8, long r9, Segment r11, Function2 r12) {
    L2:
        Object r10 = findSegmentInternal(r11, r9, r12);
        if (SegmentOrClosed.m3075isClosedimpl(r10) == true) goto L21;
        Segment r0 = SegmentOrClosed.m3073getSegmentimpl(r10);
    L5:
        Segment r1 = (Segment) r7.get(r8);
        boolean r3 = true;
        if (r1.id >= r0.id) goto L16;
        if (r0.tryIncPointers$kotlinx_coroutines_core() == false) goto L10;
        if (r7.compareAndSet(r8, r1, r0) == true) goto L14;
        if (r0.decPointers$kotlinx_coroutines_core() == false) goto L5;
        r0.remove();
        goto L5
    L14:
        if (r1.decPointers$kotlinx_coroutines_core() == false) goto L16;
        r1.remove();
        goto L16
    L10:
        r3 = false;
    L16:
        if (r3 == false) goto L2;
    L21:
        return r10;
    }

    private static final boolean addConditionally$atomicfu(Object r2, AtomicIntegerFieldUpdater r3, int r4, Function1<? super Integer, Boolean> r5) {
    L2:
        int r0 = r3.get(r2);
        if (r5.invoke(Integer.valueOf(r0)).booleanValue() == false) goto L4;
        if (r3.compareAndSet(r2, r0, r0 + r4) == false) goto L2;
        return true;
    L4:
        return false;
    }

    private static final boolean addConditionally$atomicfu$array(Object r1, AtomicIntegerArray r2, int r3, int r4, Function1<? super Integer, Boolean> r5) {
    L2:
        int r6 = r2.get(r3);
        if (r5.invoke(Integer.valueOf(r6)).booleanValue() == false) goto L4;
        if (r2.compareAndSet(r3, r6, r6 + r4) == false) goto L2;
        return true;
    L4:
        return false;
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
