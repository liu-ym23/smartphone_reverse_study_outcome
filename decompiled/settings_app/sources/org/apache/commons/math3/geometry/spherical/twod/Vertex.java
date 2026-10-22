package org.apache.commons.math3.geometry.spherical.twod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class Vertex {
    private final List<Circle> circles;
    private Edge incoming;
    private final S2Point location;
    private Edge outgoing;

    Vertex(S2Point r1) {
        this.location = r1;
        this.incoming = null;
        this.outgoing = null;
        this.circles = new ArrayList();
    }

    public S2Point getLocation() {
        return this.location;
    }

    void bindWith(Circle r1) {
        this.circles.add(r1);
    }

    Circle sharedCircleWith(Vertex r4) {
        Iterator<Circle> r3 = this.circles.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Circle r0 = r3.next();
        Iterator<Circle> r1 = r4.circles.iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        if (r0 != r1.next()) goto L7;
        return r0;
    L11:
        return null;
    }

    void setIncoming(Edge r1) {
        this.incoming = r1;
        bindWith(r1.getCircle());
    }

    public Edge getIncoming() {
        return this.incoming;
    }

    void setOutgoing(Edge r1) {
        this.outgoing = r1;
        bindWith(r1.getCircle());
    }

    public Edge getOutgoing() {
        return this.outgoing;
    }
}
