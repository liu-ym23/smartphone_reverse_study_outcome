package okio;

import com.android.settings.DataUsageFragment;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Segment.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B/\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006J\u0006\u0010\u0016\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lokio/Segment;", "", "()V", "data", "", "pos", "", DataUsageFragment.INTENT_EXTRA_LIMIT, "shared", "", "owner", "([BIIZZ)V", "next", "prev", "compact", "", "pop", "push", "segment", "sharedCopy", "split", "byteCount", "unsharedCopy", "writeTo", "sink", "Companion", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Segment {
    public static final Companion Companion = null;
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    /* JADX INFO: compiled from: Segment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lokio/Segment$Companion;", "", "()V", "SHARE_MINIMUM", "", "SIZE", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.data = r2;
        this.pos = r3;
        this.limit = r4;
        this.shared = r5;
        this.owner = r6;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment unsharedCopy() {
        byte[] r0 = this.data;
        byte[] r1 = Arrays.copyOf(r0, r0.length);
        Intrinsics.checkNotNullExpressionValue(r1, "copyOf(this, size)");
        return new Segment(r1, this.pos, this.limit, false, true);
    }

    public final Segment pop() {
        Segment r0 = this.next;
        if (r0 != this) goto L6;
        r0 = null;
    L6:
        Segment r2 = this.prev;
        Intrinsics.checkNotNull(r2);
        r2.next = this.next;
        Segment r3 = this.next;
        Intrinsics.checkNotNull(r3);
        r3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return r0;
    }

    public final Segment push(Segment r2) {
        Intrinsics.checkNotNullParameter(r2, "segment");
        r2.prev = this;
        r2.next = this.next;
        Segment r0 = this.next;
        Intrinsics.checkNotNull(r0);
        r0.prev = r2;
        this.next = r2;
        return r2;
    }

    public final Segment split(int r9) {
        if (r9 > 0) goto L4;
    L6:
        boolean r0 = false;
    L7:
        if (r0 == false) goto L15;
        if (r9 < 1024) goto L11;
        Segment r1 = sharedCopy();
    L12:
        r1.limit = r1.pos + r9;
        this.pos += r9;
        Segment r8 = this.prev;
        Intrinsics.checkNotNull(r8);
        r8.push(r1);
        return r1;
    L11:
        r1 = SegmentPool.take();
        byte[] r2 = this.data;
        byte[] r3 = r1.data;
        int r4 = this.pos;
        ArraysKt.copyInto$default(r2, r3, 0, r4, r4 + r9, 2, null);
        goto L12
    L15:
        throw new IllegalArgumentException("byteCount out of range".toString());
    L4:
        if (r9 > (this.limit - this.pos)) goto L6;
        r0 = true;
        goto L7
    }

    public final void compact() {
        Segment r0 = this.prev;
        int r1 = 0;
        if (r0 == this) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L20;
        Intrinsics.checkNotNull(r0);
        if (r0.owner == true) goto L10;
        return;
    L10:
        int r3 = this.limit - this.pos;
        Segment r4 = this.prev;
        Intrinsics.checkNotNull(r4);
        int r5 = 8192 - r4.limit;
        Segment r6 = this.prev;
        Intrinsics.checkNotNull(r6);
        if (r6.shared == true) goto L15;
        Segment r7 = this.prev;
        Intrinsics.checkNotNull(r7);
        r1 = r7.pos;
    L15:
        if (r3 <= (r5 + r1)) goto L17;
        return;
    L17:
        Segment r8 = this.prev;
        Intrinsics.checkNotNull(r8);
        writeTo(r8, r3);
        pop();
        SegmentPool.recycle(this);
        return;
    L20:
        throw new IllegalStateException("cannot compact".toString());
    L5:
        r2 = false;
        goto L6
    }

    public final void writeTo(Segment r9, int r10) {
        Intrinsics.checkNotNullParameter(r9, "sink");
        if (r9.owner == false) goto L18;
        int r5 = r9.limit;
        if ((r5 + r10) > 8192) goto L7;
    L15:
        byte[] r0 = this.data;
        byte[] r1 = r9.data;
        int r2 = r9.limit;
        int r3 = this.pos;
        ArraysKt.copyInto(r0, r1, r2, r3, r3 + r10);
        r9.limit += r10;
        this.pos += r10;
        return;
    L7:
        if (r9.shared == true) goto L14;
        int r4 = r9.pos;
        if (((r5 + r10) - r4) > 8192) goto L12;
        byte[] r6 = r9.data;
        ArraysKt.copyInto$default(r6, r6, 0, r4, r5, 2, null);
        r9.limit -= r9.pos;
        r9.pos = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }
}
