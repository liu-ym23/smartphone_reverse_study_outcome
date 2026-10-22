package com.bumptech.glide.load.engine.prefill;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class PreFillQueue {
    private final Map<PreFillType, Integer> bitmapsPerType;
    private int bitmapsRemaining;
    private int keyIndex;
    private final List<PreFillType> keyList;

    public PreFillQueue(Map<PreFillType, Integer> r3) {
        this.bitmapsPerType = r3;
        this.keyList = new ArrayList(r3.keySet());
        Iterator<Integer> r4 = r3.values().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        this.bitmapsRemaining += r4.next().intValue();
        goto L4
    }

    public PreFillType remove() {
        PreFillType r0 = this.keyList.get(this.keyIndex);
        Integer r1 = this.bitmapsPerType.get(r0);
        if (r1.intValue() != 1) goto L5;
        this.bitmapsPerType.remove(r0);
        this.keyList.remove(this.keyIndex);
    L6:
        this.bitmapsRemaining--;
        if (this.keyList.isEmpty() == false) goto L9;
        int r2 = 0;
    L10:
        this.keyIndex = r2;
        return r0;
    L9:
        r2 = (this.keyIndex + 1) % this.keyList.size();
        goto L10
    L5:
        this.bitmapsPerType.put(r0, Integer.valueOf(r1.intValue() - 1));
        goto L6
    }

    public int getSize() {
        return this.bitmapsRemaining;
    }

    public boolean isEmpty() {
        if (this.bitmapsRemaining != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
