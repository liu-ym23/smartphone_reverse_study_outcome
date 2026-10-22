package com.bytedance.bdlocation.api;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ILocationH3Core extends IManager {
    long geoToH3(double r1, double r3, int r5);

    Pair<Double, Double> h3ToGeo(long r1);

    List<Long> kRing(long r1, int r3);
}
