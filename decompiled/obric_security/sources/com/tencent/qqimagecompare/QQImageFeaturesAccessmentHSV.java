package com.tencent.qqimagecompare;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class QQImageFeaturesAccessmentHSV extends QQImageNativeObject {

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27a = null;

        static {
            int[] r0 = new int[eDimensionType.values().length];
            f27a = r0;
            r0[eDimensionType.Sharpness.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f27a[eDimensionType.Lightness.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum eDimensionType extends Enum<eDimensionType> {
        public static final eDimensionType Lightness = null;
        public static final eDimensionType Sharpness = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ eDimensionType[] f28a = null;

        static {
            Sharpness = new eDimensionType(ExifInterface.TAG_SHARPNESS, 0);
            Lightness = new eDimensionType("Lightness", 1);
            f28a = a();
        }

        private eDimensionType(String r1, int r2) {
            super(r1, r2);
        }

        private static /* synthetic */ eDimensionType[] a() {
            return new eDimensionType[]{Sharpness, Lightness};
        }

        public static eDimensionType valueOf(String r1) {
            return (eDimensionType) Enum.valueOf(eDimensionType.class, r1);
        }

        public static eDimensionType[] values() {
            return (eDimensionType[]) f28a.clone();
        }
    }

    public QQImageFeaturesAccessmentHSV() {
    }

    private static native void AddDimensionC(long r0, int r2, int r3);

    private static native int GetFeaturesRankC(long r0, long[] r2, int[] r3);

    public void addDimension(eDimensionType r2, int r3) {
        int r4 = a.f27a[r2.ordinal()];
        int r0 = 1;
        if (r4 == 1) goto L7;
        r0 = 2;
        if (r4 == 2) goto L7;
        r0 = 0;
    L7:
        AddDimensionC(this.mThisC, r0, r3);
    }

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native long createNativeObject();

    @Override // com.tencent.qqimagecompare.QQImageNativeObject
    protected native void destroyNativeObject(long r1);

    public int[] getFeaturesRanks(ArrayList<QQImageFeatureHSV> r7) {
        int r0 = r7.size();
        int[] r1 = new int[r0];
        long[] r2 = new long[r0];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r2[r3] = r7.get(r3).mThisC;
        r3 = r3 + 1;
        goto L3
    L5:
        GetFeaturesRankC(this.mThisC, r2, r1);
        return r1;
    }
}
