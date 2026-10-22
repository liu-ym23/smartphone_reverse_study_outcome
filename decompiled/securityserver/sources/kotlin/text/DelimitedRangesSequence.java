package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f355a;
    public final int b;
    public final int c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2 f356d;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    @Metadata
    public final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {
        public int b;
        public int c;
        public int e;
        public IntRange f;
        public int i;
        public final /* synthetic */ DelimitedRangesSequence j;

        public AnonymousClass1(DelimitedRangesSequence r3) {
            this.j = r3;
            this.b = -1;
            int r4 = RangesKt.b(r3.b, 0, r3.f355a.length());
            this.c = r4;
            this.e = r4;
        }

        public final void a() {
            int r0 = this.e;
            int r1 = 0;
            if (r0 >= 0) goto L5;
            this.b = 0;
            this.f = null;
            return;
        L5:
            DelimitedRangesSequence r2 = this.j;
            int r3 = r2.c;
            if (r3 <= 0) goto L10;
            int r6 = this.i + 1;
            this.i = r6;
            if (r6 < r3) goto L10;
        L11:
            this.f = new IntRange(this.c, StringsKt.q(r2.f355a), 1);
            this.e = -1;
        L19:
            this.b = 1;
            return;
        L10:
            if (r0 > r2.f355a.length()) goto L11;
            Pair r4 = (Pair) r2.f356d.mo7invoke(r2.f355a, Integer.valueOf(this.e));
            if (r4 != null) goto L15;
            this.f = new IntRange(this.c, StringsKt.q(r2.f355a), 1);
            this.e = -1;
            goto L19
        L15:
            int r5 = ((Number) r4.b).intValue();
            int r7 = ((Number) r4.c).intValue();
            this.f = RangesKt.e(this.c, r5);
            int r8 = r5 + r7;
            this.c = r8;
            if (r7 != 0) goto L18;
            r1 = 1;
        L18:
            this.e = r8 + r1;
            goto L19
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.b != (-1)) goto L6;
            a();
        L6:
            if (this.b == 1) goto L10;
            return false;
        L10:
            return true;
        }

        @Override // java.util.Iterator
        public final IntRange next() {
            if (this.b != (-1)) goto L6;
            a();
        L6:
            if (this.b == 0) goto L10;
            IntRange r0 = this.f;
            Intrinsics.d(r0, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f = null;
            this.b = -1;
            return r0;
        L10:
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public DelimitedRangesSequence(CharSequence r2, int r3, int r4, Function2 r5) {
        Intrinsics.f(r2, "input");
        this.f355a = r2;
        this.b = r3;
        this.c = r4;
        this.f356d = r5;
    }

    @Override // kotlin.sequences.Sequence
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }
}
