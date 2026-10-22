package okio;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
final class Segment {
    static final int SHARE_MINIMUM = 1024;
    static final int SIZE = 8192;
    final byte[] data;
    int limit;
    Segment next;
    boolean owner;
    int pos;
    Segment prev;
    boolean shared;

    Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    Segment(byte[] r1, int r2, int r3, boolean r4, boolean r5) {
        this.data = r1;
        this.pos = r2;
        this.limit = r3;
        this.shared = r4;
        this.owner = r5;
    }

    final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    final Segment unsharedCopy() {
        return new Segment((byte[]) this.data.clone(), this.pos, this.limit, false, true);
    }

    @Nullable
    public final Segment pop() {
        Segment r0 = this.next;
        if (r0 == this) goto L5;
        Segment r2 = r0;
    L6:
        Segment r3 = this.prev;
        r3.next = r0;
        this.next.prev = r3;
        this.next = null;
        this.prev = null;
        return r2;
    L5:
        r2 = null;
        goto L6
    }

    public final Segment push(Segment r2) {
        r2.prev = this;
        r2.next = this.next;
        this.next.prev = r2;
        this.next = r2;
        return r2;
    }

    public final Segment split(int r6) {
        if (r6 <= 0) goto L12;
        if (r6 > (this.limit - this.pos)) goto L12;
        if (r6 < 1024) goto L8;
        Segment r0 = sharedCopy();
    L9:
        r0.limit = r0.pos + r6;
        this.pos += r6;
        this.prev.push(r0);
        return r0;
    L8:
        r0 = SegmentPool.take();
        System.arraycopy(this.data, this.pos, r0.data, 0, r6);
    L12:
        throw new IllegalArgumentException();
    }

    public final void compact() {
        Segment r0 = this.prev;
        if (r0 == this) goto L17;
        if (r0.owner == true) goto L7;
        return;
    L7:
        int r1 = this.limit - this.pos;
        int r2 = 8192 - r0.limit;
        if (r0.shared == false) goto L10;
        int r3 = 0;
    L12:
        if (r1 <= (r2 + r3)) goto L14;
        return;
    L14:
        writeTo(r0, r1);
        pop();
        SegmentPool.recycle(this);
        return;
    L10:
        r3 = r0.pos;
        goto L12
    L17:
        throw new IllegalStateException();
    }

    public final void writeTo(Segment r5, int r6) {
        if (r5.owner == false) goto L18;
        int r0 = r5.limit;
        if ((r0 + r6) > 8192) goto L7;
    L15:
        System.arraycopy(this.data, this.pos, r5.data, r5.limit, r6);
        r5.limit += r6;
        this.pos += r6;
        return;
    L7:
        if (r5.shared == true) goto L14;
        int r3 = r5.pos;
        if (((r0 + r6) - r3) > 8192) goto L12;
        byte[] r1 = r5.data;
        System.arraycopy(r1, r3, r1, 0, r0 - r3);
        r5.limit -= r5.pos;
        r5.pos = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }
}
