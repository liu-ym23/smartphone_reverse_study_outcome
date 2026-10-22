package com.github.mikephil.charting.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.github.mikephil.charting.utils.Utils;

/* JADX INFO: loaded from: classes2.dex */
public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = null;
    private float x;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Entry() {
        this.x = 0.0f;
    }

    public Entry(float r1, float r2) {
        super(r2);
        this.x = r1;
    }

    public Entry(float r1, float r2, Object r3) {
        super(r2, r3);
        this.x = r1;
    }

    public Entry(float r1, float r2, Drawable r3) {
        super(r2, r3);
        this.x = r1;
    }

    public Entry(float r1, float r2, Drawable r3, Object r4) {
        super(r2, r3, r4);
        this.x = r1;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float r1) {
        this.x = r1;
    }

    public Entry copy() {
        return new Entry(this.x, getY(), getData());
    }

    public boolean equalTo(Entry r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.getData() == getData()) goto L9;
        return false;
    L9:
        if (Math.abs(r4.x - this.x) <= Utils.FLOAT_EPSILON) goto L12;
        return false;
    L12:
        if (Math.abs(r4.getY() - getY()) <= Utils.FLOAT_EPSILON) goto L14;
        return false;
    L14:
        return true;
    }

    public String toString() {
        return "Entry, x: " + this.x + " y: " + getY();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeFloat(this.x);
        r2.writeFloat(getY());
        if (getData() != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        if ((getData() instanceof Parcelable) == false) goto L8;
        r2.writeInt(1);
        r2.writeParcelable((Parcelable) getData(), r3);
        return;
    L8:
        throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
    }

    protected Entry(Parcel r3) {
        this.x = 0.0f;
        this.x = r3.readFloat();
        setY(r3.readFloat());
        if (r3.readInt() != 1) goto L6;
        setData(r3.readParcelable(Object.class.getClassLoader()));
        return;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
