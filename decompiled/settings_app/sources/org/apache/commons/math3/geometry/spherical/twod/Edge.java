package org.apache.commons.math3.geometry.spherical.twod;

import java.util.List;
import org.apache.commons.math3.geometry.euclidean.threed.Vector3D;
import org.apache.commons.math3.geometry.spherical.oned.Arc;
import org.apache.commons.math3.util.MathUtils;

/* JADX INFO: loaded from: classes6.dex */
public class Edge {
    private final Circle circle;
    private Vertex end;
    private final double length;
    private final Vertex start;

    Edge(Vertex r1, Vertex r2, double r3, Circle r5) {
        this.start = r1;
        this.end = r2;
        this.length = r3;
        this.circle = r5;
        r1.setOutgoing(this);
        r2.setIncoming(this);
    }

    public Vertex getStart() {
        return this.start;
    }

    public Vertex getEnd() {
        return this.end;
    }

    public double getLength() {
        return this.length;
    }

    public Circle getCircle() {
        return this.circle;
    }

    public Vector3D getPointAt(double r4) {
        Circle r0 = this.circle;
        return r0.getPointAt(r4 + r0.getPhase(this.start.getLocation().getVector()));
    }

    void setNextEdge(Edge r1) {
        Vertex r2 = r1.getStart();
        this.end = r2;
        r2.setIncoming(this);
        this.end.bindWith(getCircle());
    }

    void split(Circle r21, List<Edge> r22, List<Edge> r23) {
        double r8 = this.circle.getPhase(this.start.getLocation().getVector());
        Arc r0 = this.circle.getInsideArc(r21);
        double r11 = MathUtils.normalizeAngle(r0.getInf(), 3.141592653589793d + r8) - r8;
        double r13 = r11 + r0.getSize();
        double r15 = r13 - 6.283185307179586d;
        double r17 = this.circle.getTolerance();
        Vertex r1 = this.start;
        if (r15 < (this.length - r17)) goto L6;
        r23.add(this);
        return;
    L6:
        if (r15 < 0.0d) goto L8;
        r1 = addSubEdge(r1, new Vertex(new S2Point(this.circle.getPointAt(r8 + r15))), r15, r23, r21);
    L9:
        double r2 = this.length;
        if (r11 < (r2 - r17)) goto L14;
        if (r15 < 0.0d) goto L13;
        addSubEdge(r1, this.end, r2 - r15, r22, r21);
        return;
    L13:
        r22.add(this);
        return;
    L14:
        double r9 = r8 + r11;
        Vertex r3 = addSubEdge(r1, new Vertex(new S2Point(this.circle.getPointAt(r9))), r11 - r15, r22, r21);
        double r4 = this.length;
        if (r13 < (r4 - r17)) goto L17;
        addSubEdge(r3, this.end, r4 - r11, r23, r21);
        return;
    L17:
        addSubEdge(addSubEdge(r3, new Vertex(new S2Point(this.circle.getPointAt(r9))), r11 - r11, r23, r21), this.end, this.length - r11, r22, r21);
        return;
    L8:
        r15 = 0.0d;
        goto L9
    }

    private Vertex addSubEdge(Vertex r8, Vertex r9, double r10, List<Edge> r12, Circle r13) {
        if (r10 > this.circle.getTolerance()) goto L5;
        return r8;
    L5:
        r9.bindWith(r13);
        r12.add(new Edge(r8, r9, r10, this.circle));
        return r9;
    }
}
