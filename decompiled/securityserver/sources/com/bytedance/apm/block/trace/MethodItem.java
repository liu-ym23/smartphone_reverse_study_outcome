package com.bytedance.apm.block.trace;

import a.a;

/* JADX INFO: loaded from: classes.dex */
public class MethodItem {
    public int count;
    public int depth;
    public int durTime;
    public int methodId;
    public long startTime;

    public MethodItem(int r2, int r3, long r4, int r6) {
        this.count = 1;
        this.methodId = r2;
        this.durTime = r3;
        this.depth = r6;
        this.startTime = r4;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof MethodItem) == false) goto L10;
        MethodItem r4 = (MethodItem) r3;
        if (r4.methodId == this.methodId) goto L7;
        return false;
    L7:
        if (r4.depth != this.depth) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public String getKey() {
        return this.depth + "," + this.methodId + "," + this.count;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void mergeMore(long r3) {
        this.count++;
        this.durTime = (int) (((long) this.durTime) + r3);
    }

    public String print() {
        StringBuffer r0 = new StringBuffer();
        int r1 = 0;
    L4:
        if (r1 >= this.depth) goto L7;
        r0.append('.');
        r1 = r1 + 1;
        goto L4
    L7:
        return r0.toString() + this.methodId + " " + this.count + " " + this.durTime;
    }

    public String toPrettyString() {
        StringBuilder r0 = new StringBuilder("{methodId=");
        r0.append(this.methodId);
        r0.append(", durTime=");
        r0.append(this.durTime);
        r0.append(", startTime=");
        r0.append(this.startTime);
        r0.append(", depth=");
        r0.append(this.depth);
        r0.append(", count=");
        return a.l(r0, this.count, '}');
    }

    public String toString() {
        return this.depth + "," + this.methodId + "," + this.count + "," + this.durTime + "," + this.startTime;
    }
}
