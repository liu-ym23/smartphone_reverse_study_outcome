package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
final class BarcodeValue {
    private final Map<Integer, Integer> values;

    BarcodeValue() {
        this.values = new HashMap();
    }

    void setValue(int r3) {
        Integer r0 = this.values.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        r0 = 0;
    L5:
        Integer r1 = Integer.valueOf(r0.intValue() + 1);
        this.values.put(Integer.valueOf(r3), r1);
    }

    int[] getValue() {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<Integer, Integer>> r4 = this.values.entrySet().iterator();
        int r1 = -1;
    L4:
        if (r4.hasNext() == false) goto L12;
        Map.Entry<Integer, Integer> r2 = r4.next();
        if (r2.getValue().intValue() > r1) goto L7;
        if (r2.getValue().intValue() != r1) goto L4;
        r0.add(r2.getKey());
        goto L4
    L7:
        r1 = r2.getValue().intValue();
        r0.clear();
        r0.add(r2.getKey());
        goto L4
    L12:
        return PDF417Common.toIntArray(r0);
    }

    Integer getConfidence(int r1) {
        return this.values.get(Integer.valueOf(r1));
    }
}
