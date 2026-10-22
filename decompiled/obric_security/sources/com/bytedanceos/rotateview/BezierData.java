package com.bytedanceos.rotateview;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BezierData implements Parcelable {
    public static final Parcelable.Creator<BezierData> CREATOR = null;
    private float[] mCache;
    private final List<PointF> mControlPoints;
    private int mOrder;
    private final PointF mTmpPoint;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BezierData() {
        this.mTmpPoint = new PointF();
        this.mControlPoints = new ArrayList();
    }

    public BezierData(BezierData source) {
        this.mTmpPoint = new PointF();
        this.mControlPoints = (ArrayList) ((ArrayList) source.mControlPoints).clone();
    }

    public BezierData(Parcel parcel) {
        this.mTmpPoint = new PointF();
        this.mControlPoints = parcel.readArrayList(null);
    }

    public BezierData(Parcel parcel, ClassLoader loader) {
        this.mTmpPoint = new PointF();
        this.mControlPoints = parcel.readArrayList(loader);
    }

    public void clearControlPoints() {
        this.mControlPoints.clear();
    }

    public void setControlPoints(BezierData source) {
        clearControlPoints();
        this.mControlPoints.addAll(source.mControlPoints);
    }

    public void addControlPoint(PointF point) {
        this.mControlPoints.add(point);
    }

    public void removeControlPoint() {
        if (this.mControlPoints.isEmpty() == true) goto L6;
        List<PointF> r1 = this.mControlPoints;
        r1.remove(r1.size() - 1);
        return;
    }

    public PointF getControlPoint(int index) {
        return this.mControlPoints.get(index);
    }

    public int getControlPointsCount() {
        return this.mControlPoints.size();
    }

    private int getOrder() {
        int r0 = this.mControlPoints.size() - 1;
        this.mOrder = r0;
        return r0;
    }

    private void initCache() {
        int r0 = this.mOrder;
        int r1 = ((r0 + 1) * (r0 + 2)) / 2;
        float[] r2 = this.mCache;
        if (r2 != null) goto L5;
    L6:
        this.mCache = new float[r1];
    L7:
        Arrays.fill(this.mCache, Float.NaN);
        return;
    L5:
        if (r2.length == r1) goto L7;
        goto L6
    }

    public PointF getLocation(float t) {
        getOrder();
        initCache();
        float r0 = deCasteljau(this.mOrder, 0, t, true);
        initCache();
        float r4 = deCasteljau(this.mOrder, 0, t, false);
        this.mTmpPoint.set(r0, r4);
        return this.mTmpPoint;
    }

    private float deCasteljau(int curOrder, int j, float t, boolean isX) {
        int r0 = this.mOrder;
        int r1 = (((r0 - curOrder) * ((r0 - curOrder) + 1)) / 2) + j;
        if (Float.isNaN(this.mCache[r1]) == true) goto L7;
        return this.mCache[r1];
    L7:
        if (curOrder != 1) goto L14;
        PointF r6 = this.mControlPoints.get(j);
        PointF r7 = this.mControlPoints.get(j + 1);
        if (isX == false) goto L11;
        this.mCache[r1] = ((1.0f - t) * r6.x) + (t * r7.x);
    L13:
        return this.mCache[r1];
    L11:
        this.mCache[r1] = ((1.0f - t) * r6.y) + (t * r7.y);
        goto L13
    L14:
        int r8 = curOrder - 1;
        this.mCache[r1] = ((1.0f - t) * deCasteljau(r8, j, t, isX)) + (t * deCasteljau(r8, j + 1, t, isX));
        return this.mCache[r1];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.mControlPoints);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
