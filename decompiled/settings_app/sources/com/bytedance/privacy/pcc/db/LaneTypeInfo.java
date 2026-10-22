package com.bytedance.privacy.pcc.db;

import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes3.dex */
public class LaneTypeInfo {
    public final int clientLaneType;
    public final int finalLaneType;
    public final int serverLaneType;

    public LaneTypeInfo(int r1, int r2, int r3) {
        this.clientLaneType = r1;
        this.serverLaneType = r2;
        this.finalLaneType = r3;
    }

    public boolean isValid() {
        if (this.clientLaneType >= 0) goto L5;
    L9:
        return false;
    L5:
        if (this.serverLaneType < 0) goto L9;
        if (this.finalLaneType < 0) goto L9;
        return true;
    }

    public String toString() {
        return "LaneTypeInfo{client=" + this.clientLaneType + ", server=" + this.serverLaneType + ", final=" + this.finalLaneType + VectorFormat.DEFAULT_SUFFIX;
    }
}
