package com.bytedance.bdlocation.provider;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.api.ILocationH3Core;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DefaultLocationH3Core implements ILocationH3Core {
    public DefaultLocationH3Core() {
    }

    @Override // com.bytedance.bdlocation.api.ILocationH3Core
    public long geoToH3(double r1, double r3, int r5) {
        return 0;
    }

    @Override // com.bytedance.bdlocation.api.ILocationH3Core
    @Nullable
    public Pair<Double, Double> h3ToGeo(long r1) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocationH3Core
    @Nullable
    public List<Long> kRing(long r1, int r3) {
        return null;
    }
}
