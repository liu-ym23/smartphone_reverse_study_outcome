package androidx.core.graphics;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class PathSegment {
    private final PointF mEnd;
    private final float mEndFraction;
    private final PointF mStart;
    private final float mStartFraction;

    public PathSegment(@NonNull PointF r2, float r3, @NonNull PointF r4, float r5) {
        this.mStart = (PointF) Preconditions.checkNotNull(r2, "start == null");
        this.mStartFraction = r3;
        this.mEnd = (PointF) Preconditions.checkNotNull(r4, "end == null");
        this.mEndFraction = r5;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PathSegment) == true) goto L8;
        return false;
    L8:
        PathSegment r6 = (PathSegment) r5;
        if (Float.compare(this.mStartFraction, r6.mStartFraction) != 0) goto L18;
        if (Float.compare(this.mEndFraction, r6.mEndFraction) != 0) goto L18;
        if (this.mStart.equals(r6.mStart) == false) goto L18;
        if (this.mEnd.equals(r6.mEnd) == false) goto L18;
        return true;
    L18:
        return false;
    }

    @NonNull
    public PointF getEnd() {
        return this.mEnd;
    }

    public float getEndFraction() {
        return this.mEndFraction;
    }

    @NonNull
    public PointF getStart() {
        return this.mStart;
    }

    public float getStartFraction() {
        return this.mStartFraction;
    }

    public int hashCode() {
        int r0 = this.mStart.hashCode() * 31;
        float r1 = this.mStartFraction;
        int r4 = 0;
        if (r1 == 0.0f) goto L5;
        int r2 = Float.floatToIntBits(r1);
    L6:
        int r3 = (this.mEnd.hashCode() + ((r0 + r2) * 31)) * 31;
        float r5 = this.mEndFraction;
        if (r5 == 0.0f) goto L10;
        r4 = Float.floatToIntBits(r5);
    L10:
        return r3 + r4;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "PathSegment{start=" + this.mStart + ", startFraction=" + this.mStartFraction + ", end=" + this.mEnd + ", endFraction=" + this.mEndFraction + '}';
    }
}
