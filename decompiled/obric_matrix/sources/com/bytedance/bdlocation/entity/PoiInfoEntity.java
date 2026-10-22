package com.bytedance.bdlocation.entity;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class PoiInfoEntity implements Comparable<PoiInfoEntity> {
    public String AmapID;
    public String AwemeID;
    public float Confidence;
    public float Distance;
    public String LocationID;
    public String Name;
    public String Source;
    public String Typecode;

    public PoiInfoEntity() {
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(@NonNull PoiInfoEntity r1) {
        return Float.compare(r1.Confidence, this.Confidence);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(@NonNull PoiInfoEntity r1) {
        return compareTo2(r1);
    }
}
