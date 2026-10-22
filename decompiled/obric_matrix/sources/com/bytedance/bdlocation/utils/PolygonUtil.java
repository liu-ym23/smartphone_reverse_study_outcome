package com.bytedance.bdlocation.utils;

import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PolygonUtil {
    private List<PointF> vertices;

    public static class Builder {
        private List<PointF> vertices;

        public Builder() {
            this.vertices = new ArrayList();
        }

        public Builder addVertice(PointF r2) {
            this.vertices.add(r2);
            return this;
        }

        public PolygonUtil build() {
            if (this.vertices.size() < 3) goto L7;
            return new PolygonUtil(this.vertices);
        L7:
            throw new RuntimeException("Polygon must have at least 3 points");
        }
    }

    public PolygonUtil() {
        this.vertices = new ArrayList();
    }

    public PolygonUtil(List<PointF> r1) {
        this.vertices = r1;
    }

    public static Builder Builder() {
        return new Builder();
    }

    public static boolean isPointInPolygon(PointF r10, List<PointF> r11) {
        int r3 = r11.size() - 1;
        int r0 = 0;
        boolean r4 = false;
    L4:
        if (r0 >= r11.size()) goto L18;
        if (r11.get(r0).y < r10.y) goto L8;
        boolean r5 = true;
    L10:
        if (r11.get(r3).y < r10.y) goto L12;
        boolean r6 = true;
    L13:
        if (r5 == r6) goto L17;
        if (r10.x > ((((r11.get(r3).x - r11.get(r0).x) * (r10.y - r11.get(r0).y)) / (r11.get(r3).y - r11.get(r0).y)) + r11.get(r0).x)) goto L17;
        r4 = !r4;
    L17:
        r3 = r0;
        r0 = r0 + 1;
        goto L4
    L12:
        r6 = false;
        goto L13
    L8:
        r5 = false;
        goto L10
    L18:
        return r4;
    }

    public boolean contains(PointF r1) {
        return isPointInPolygon(r1, this.vertices);
    }

    public boolean contains(List<PointF> r2) {
        Iterator<PointF> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        if (contains(r3.next()) == true) goto L4;
        return false;
    L9:
        return true;
    }

    public Path getPolygonPath() {
        Path r0 = new Path();
        Iterator<PointF> r4 = this.vertices.iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L10;
        PointF r2 = r4.next();
        float r3 = r2.x;
        float r5 = r2.y;
        if (r1 != 0) goto L8;
        r0.moveTo(r3, r5);
    L9:
        r1 = r1 + 1;
        goto L4
    L8:
        r0.lineTo(r3, r5);
        goto L9
    L10:
        r0.close();
        return r0;
    }

    public List<PointF> getVertices() {
        return this.vertices;
    }

    public void setVertices(List<PointF> r1) {
        this.vertices = r1;
    }
}
