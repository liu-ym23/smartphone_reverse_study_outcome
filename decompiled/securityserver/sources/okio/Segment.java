package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Segment {
    public static final Companion Companion = null;
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @JvmField
    @NotNull
    public final byte[] data;

    @JvmField
    public int limit;

    @JvmField
    @Nullable
    public Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @JvmField
    @Nullable
    public Segment prev;

    @JvmField
    public boolean shared;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
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

    public final void compact() {
        Segment r0 = this.prev;
        int r1 = 0;
        if (r0 == this) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L20;
        Intrinsics.c(r0);
        if (r0.owner == true) goto L10;
        return;
    L10:
        int r3 = this.limit - this.pos;
        Segment r4 = this.prev;
        Intrinsics.c(r4);
        int r5 = 8192 - r4.limit;
        Segment r6 = this.prev;
        Intrinsics.c(r6);
        if (r6.shared == true) goto L15;
        Segment r7 = this.prev;
        Intrinsics.c(r7);
        r1 = r7.pos;
    L15:
        if (r3 <= (r5 + r1)) goto L17;
        return;
    L17:
        Segment r8 = this.prev;
        Intrinsics.c(r8);
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

    @Nullable
    public final Segment pop() {
        Segment r0 = this.next;
        if (r0 != this) goto L6;
        r0 = null;
    L6:
        Segment r2 = this.prev;
        Intrinsics.c(r2);
        r2.next = this.next;
        Segment r3 = this.next;
        Intrinsics.c(r3);
        r3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return r0;
    }

    @NotNull
    public final Segment push(@NotNull Segment r2) {
        Intrinsics.f(r2, "segment");
        r2.prev = this;
        r2.next = this.next;
        Segment r0 = this.next;
        Intrinsics.c(r0);
        r0.prev = r2;
        this.next = r2;
        return r2;
    }

    @NotNull
    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    @NotNull
    public final Segment split(int r7) {
        if (r7 <= 0) goto L12;
        if (r7 > (this.limit - this.pos)) goto L12;
        if (r7 < 1024) goto L8;
        Segment r0 = sharedCopy();
    L9:
        r0.limit = r0.pos + r7;
        this.pos += r7;
        Segment r6 = this.prev;
        Intrinsics.c(r6);
        r6.push(r0);
        return r0;
    L8:
        r0 = SegmentPool.take();
        byte[] r1 = this.data;
        byte[] r2 = r0.data;
        int r3 = this.pos;
        ArraysKt.g(r1, 0, r2, r3, r3 + r7);
    L12:
        throw new IllegalArgumentException("byteCount out of range".toString());
    }

    @NotNull
    public final Segment unsharedCopy() {
        byte[] r0 = this.data;
        byte[] r1 = Arrays.copyOf(r0, r0.length);
        Intrinsics.e(r1, "java.util.Arrays.copyOf(this, size)");
        return new Segment(r1, this.pos, this.limit, false, true);
    }

    public final void writeTo(@NotNull Segment r6, int r7) {
        Intrinsics.f(r6, "sink");
        if (r6.owner == false) goto L18;
        int r0 = r6.limit;
        int r1 = r0 + r7;
        if (r1 > 8192) goto L7;
    L15:
        byte[] r2 = this.data;
        byte[] r3 = r6.data;
        int r4 = r6.limit;
        int r5 = this.pos;
        ArraysKt.g(r2, r4, r3, r5, r5 + r7);
        r6.limit += r7;
        this.pos += r7;
        return;
    L7:
        if (r6.shared == true) goto L14;
        int r8 = r6.pos;
        if ((r1 - r8) > 8192) goto L12;
        byte[] r9 = r6.data;
        ArraysKt.g(r9, 0, r9, r8, r0);
        r6.limit -= r6.pos;
        r6.pos = 0;
        goto L15
    L12:
        throw new IllegalArgumentException();
    L14:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalStateException("only owner can write".toString());
    }

    public Segment(@NotNull byte[] r2, int r3, int r4, boolean r5, boolean r6) {
        Intrinsics.f(r2, "data");
        this.data = r2;
        this.pos = r3;
        this.limit = r4;
        this.shared = r5;
        this.owner = r6;
    }
}
