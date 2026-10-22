package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: SlidingWindow.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(int r1, int r2, Iterator<? extends T> r3, boolean r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.$size = r1;
            this.$step = r2;
            this.$iterator = r3;
            this.$reuseBuffer = r4;
            this.$partialWindows = r5;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r10);
            r7.L$0 = r9;
            return r7;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r1, Continuation<? super Unit> r2) {
            return invoke((SequenceScope) r1, r2);
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a5 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x012b -> B:59:0x012e). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0163 -> B:72:0x0166). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r2 = (RingBuffer) this.L$1;
            SequenceScope r4 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L72:
            r2.removeFirst(this.$step);
        L64:
            if (r2.size() <= this.$step) goto L74;
            if (this.$reuseBuffer == false) goto L68;
            List r12 = r2;
        L69:
            this.L$0 = r4;
            this.L$1 = r2;
            this.L$2 = null;
            this.label = 4;
            if (r4.yield(r12, this) != r0) goto L72;
            return r0;
        L68:
            r12 = new ArrayList(r2);
            goto L69
        L74:
            if ((!r2.isEmpty()) == false) goto L79;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (r4.yield(r2, this) != r0) goto L79;
            return r0;
        L79:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r3 = (Iterator) this.L$2;
            RingBuffer r5 = (RingBuffer) this.L$1;
            SequenceScope r8 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L59:
            r5.removeFirst(this.$step);
        L46:
            if (r3.hasNext() == false) goto L61;
            r5.add(r3.next());
            if (r5.isFull() == false) goto L46;
            int r13 = r5.size();
            int r9 = this.$size;
            if (r13 >= r9) goto L53;
            r5 = r5.expanded(r9);
            goto L46
        L53:
            if (this.$reuseBuffer == false) goto L55;
            List r14 = r5;
        L56:
            this.L$0 = r8;
            this.L$1 = r5;
            this.L$2 = r3;
            this.label = 3;
            if (r8.yield(r14, this) != r0) goto L59;
            return r0;
        L55:
            r14 = new ArrayList(r5);
            goto L56
        L61:
            if (this.$partialWindows == false) goto L79;
            r2 = r5;
            r4 = r8;
        L14:
            ResultKt.throwOnFailure(r11);
            goto L79
        L15:
            int r6 = this.I$0;
            Iterator<T> r7 = (Iterator) this.L$2;
            ArrayList r10 = (ArrayList) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L16:
            int r16 = r6;
            if (this.$reuseBuffer == false) goto L33;
            r10.clear();
        L34:
            r6 = r16;
        L21:
            if (r7.hasNext() == false) goto L36;
            T r17 = r7.next();
            if (r16 > 0) goto L24;
            r10.add(r17);
            if (r10.size() != this.$size) goto L21;
            this.L$0 = r15;
            this.L$1 = r10;
            this.L$2 = r7;
            this.I$0 = r6;
            this.label = 1;
            if (r15.yield(r10, this) != r0) goto L16;
            return r0;
        L24:
            r16 = r16 - 1;
            goto L21
        L36:
            if ((!r10.isEmpty()) == false) goto L79;
            if (this.$partialWindows == false) goto L40;
        L41:
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r15.yield(r10, this) != r0) goto L79;
            return r0;
        L40:
            if (r10.size() != this.$size) goto L79;
        L33:
            r10 = new ArrayList(this.$size);
            goto L34
        L17:
            ResultKt.throwOnFailure(r11);
            SequenceScope r18 = (SequenceScope) this.L$0;
            int r19 = RangesKt.coerceAtMost(this.$size, 1024);
            int r20 = this.$step - this.$size;
            if (r20 < 0) goto L44;
            r15 = r18;
            r16 = 0;
            r10 = new ArrayList(r19);
            r7 = this.$iterator;
            r6 = r20;
            goto L21
        L44:
            r5 = new RingBuffer(r19);
            r3 = this.$iterator;
            r8 = r18;
            goto L46
        }
    }

    public static final void checkWindowSizeStep(int r3, int r4) {
        if (r3 <= 0) goto L5;
        if (r4 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r3 == r4) goto L10;
        String r5 = "Both size " + r3 + " and step " + r4 + " must be greater than zero.";
    L12:
        throw new IllegalArgumentException(r5.toString());
    L10:
        r5 = "size " + r3 + " must be greater than zero.";
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> r7, final int r8, final int r9, final boolean r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        checkWindowSizeStep(r8, r9);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(r7, r8, r9, r10, r11);
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> r8, int r9, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "iterator");
        if (r8.hasNext() == true) goto L7;
        return EmptyIterator.INSTANCE;
    L7:
        return SequencesKt.iterator(new AnonymousClass1(r9, r10, r8, r12, r11, null));
    }
}
