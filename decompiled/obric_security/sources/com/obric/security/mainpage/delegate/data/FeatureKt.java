package com.obric.security.mainpage.delegate.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Feature.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003\u001a\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u001a\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002\u001a\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u000f"}, d2 = {"dataMap", "", "", "Lcom/obric/security/mainpage/delegate/data/Feature;", "getDataMap", "()Ljava/util/Map;", "addFeature", "", "feature", "getOrderList", "", "isExistFeature", "", "position", "removeFeature", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class FeatureKt {
    private static final Map<Integer, Feature> dataMap = null;

    static {
        dataMap = new LinkedHashMap();
    }

    public static final Map<Integer, Feature> getDataMap() {
        return dataMap;
    }

    public static final void addFeature(Feature r2) {
        Intrinsics.checkNotNullParameter(r2, "feature");
        dataMap.put(Integer.valueOf(r2.getPosition()), r2);
    }

    public static final void removeFeature(int r1) {
        dataMap.remove(Integer.valueOf(r1));
    }

    public static final boolean isExistFeature(int r1) {
        return dataMap.containsKey(Integer.valueOf(r1));
    }

    public static final List<Feature> getOrderList() {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 > 3) goto L9;
        Feature r2 = dataMap.get(Integer.valueOf(r1));
        if (r2 == null) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        return r0;
    }
}
