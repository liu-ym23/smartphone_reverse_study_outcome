package org.threeten.bp.zone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public final class ZoneOffsetTransition implements Comparable<ZoneOffsetTransition>, Serializable {
    private static final long serialVersionUID = -6946044323557704546L;
    private final ZoneOffset offsetAfter;
    private final ZoneOffset offsetBefore;
    private final LocalDateTime transition;

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ZoneOffsetTransition r1) {
        return compareTo2(r1);
    }

    public static ZoneOffsetTransition of(LocalDateTime r1, ZoneOffset r2, ZoneOffset r3) {
        Jdk8Methods.requireNonNull(r1, "transition");
        Jdk8Methods.requireNonNull(r2, "offsetBefore");
        Jdk8Methods.requireNonNull(r3, "offsetAfter");
        if (r2.equals(r3) == true) goto L11;
        if (r1.getNano() != 0) goto L9;
        return new ZoneOffsetTransition(r1, r2, r3);
    L9:
        throw new IllegalArgumentException("Nano-of-second must be zero");
    L11:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    ZoneOffsetTransition(LocalDateTime r1, ZoneOffset r2, ZoneOffset r3) {
        this.transition = r1;
        this.offsetBefore = r2;
        this.offsetAfter = r3;
    }

    ZoneOffsetTransition(long r2, ZoneOffset r4, ZoneOffset r5) {
        this.transition = LocalDateTime.ofEpochSecond(r2, 0, r4);
        this.offsetBefore = r4;
        this.offsetAfter = r5;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    void writeExternal(DataOutput r3) throws IOException {
        Ser.writeEpochSec(toEpochSecond(), r3);
        Ser.writeOffset(this.offsetBefore, r3);
        Ser.writeOffset(this.offsetAfter, r3);
    }

    static ZoneOffsetTransition readExternal(DataInput r4) throws IOException {
        long r0 = Ser.readEpochSec(r4);
        ZoneOffset r2 = Ser.readOffset(r4);
        ZoneOffset r5 = Ser.readOffset(r4);
        if (r2.equals(r5) == true) goto L7;
        return new ZoneOffsetTransition(r0, r2, r5);
    L7:
        throw new IllegalArgumentException("Offsets must not be equal");
    }

    public Instant getInstant() {
        return this.transition.toInstant(this.offsetBefore);
    }

    public long toEpochSecond() {
        return this.transition.toEpochSecond(this.offsetBefore);
    }

    public LocalDateTime getDateTimeBefore() {
        return this.transition;
    }

    public LocalDateTime getDateTimeAfter() {
        return this.transition.plusSeconds(getDurationSeconds());
    }

    public ZoneOffset getOffsetBefore() {
        return this.offsetBefore;
    }

    public ZoneOffset getOffsetAfter() {
        return this.offsetAfter;
    }

    public Duration getDuration() {
        return Duration.ofSeconds(getDurationSeconds());
    }

    private int getDurationSeconds() {
        return getOffsetAfter().getTotalSeconds() - getOffsetBefore().getTotalSeconds();
    }

    public boolean isGap() {
        if (getOffsetAfter().getTotalSeconds() <= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOverlap() {
        if (getOffsetAfter().getTotalSeconds() >= getOffsetBefore().getTotalSeconds()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isValidOffset(ZoneOffset r3) {
        if (isGap() == false) goto L6;
        return false;
    L6:
        if (getOffsetBefore().equals(r3) == false) goto L8;
    L9:
        return true;
    L8:
        if (getOffsetAfter().equals(r3) == true) goto L9;
        return false;
    }

    List<ZoneOffset> getValidOffsets() {
        if (isGap() == false) goto L7;
        return Collections.emptyList();
    L7:
        return Arrays.asList(new ZoneOffset[]{getOffsetBefore(), getOffsetAfter()});
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(ZoneOffsetTransition r1) {
        return getInstant().compareTo2(r1.getInstant());
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof ZoneOffsetTransition) == false) goto L16;
        ZoneOffsetTransition r6 = (ZoneOffsetTransition) r5;
        if (this.transition.equals(r6.transition) == false) goto L15;
        if (this.offsetBefore.equals(r6.offsetBefore) == false) goto L15;
        if (this.offsetAfter.equals(r6.offsetAfter) == false) goto L15;
        return true;
    L15:
        return false;
    L16:
        return false;
    }

    public int hashCode() {
        int r0 = this.transition.hashCode() ^ this.offsetBefore.hashCode();
        return Integer.rotateLeft(this.offsetAfter.hashCode(), 16) ^ r0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Transition[");
        if (isGap() == false) goto L5;
        String r1 = "Gap";
    L6:
        r0.append(r1).append(" at ").append(this.transition).append(this.offsetBefore).append(" to ").append(this.offsetAfter).append(']');
        return r0.toString();
    L5:
        r1 = "Overlap";
        goto L6
    }
}
