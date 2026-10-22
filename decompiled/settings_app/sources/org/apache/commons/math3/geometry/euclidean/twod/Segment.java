package org.apache.commons.math3.geometry.euclidean.twod;

import org.apache.commons.math3.util.FastMath;

/* JADX INFO: loaded from: classes6.dex */
public class Segment {
    private final Vector2D end;
    private final Line line;
    private final Vector2D start;

    public Segment(Vector2D r1, Vector2D r2, Line r3) {
        this.start = r1;
        this.end = r2;
        this.line = r3;
    }

    public Vector2D getStart() {
        return this.start;
    }

    public Vector2D getEnd() {
        return this.end;
    }

    public Line getLine() {
        return this.line;
    }

    public double distance(Vector2D r11) {
        double r0 = this.end.getX() - this.start.getX();
        double r2 = this.end.getY() - this.start.getY();
        double r4 = (((r11.getX() - this.start.getX()) * r0) + ((r11.getY() - this.start.getY()) * r2)) / ((r0 * r0) + (r2 * r2));
        if (r4 < 0.0d) goto L10;
        if (r4 > 1.0d) goto L10;
        return new Vector2D(this.start.getX() + (r0 * r4), this.start.getY() + (r4 * r2)).distance(r11);
    L10:
        return FastMath.min(getStart().distance(r11), getEnd().distance(r11));
    }
}
