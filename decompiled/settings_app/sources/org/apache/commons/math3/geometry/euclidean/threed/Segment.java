package org.apache.commons.math3.geometry.euclidean.threed;

/* JADX INFO: loaded from: classes6.dex */
public class Segment {
    private final Vector3D end;
    private final Line line;
    private final Vector3D start;

    public Segment(Vector3D r1, Vector3D r2, Line r3) {
        this.start = r1;
        this.end = r2;
        this.line = r3;
    }

    public Vector3D getStart() {
        return this.start;
    }

    public Vector3D getEnd() {
        return this.end;
    }

    public Line getLine() {
        return this.line;
    }
}
