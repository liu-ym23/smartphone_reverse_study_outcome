package com.android.settingslib;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* JADX INFO: loaded from: classes.dex */
public class AppItem implements Comparable<AppItem>, Parcelable {
    public static final int CATEGORY_APP = 2;
    public static final int CATEGORY_APP_TITLE = 1;
    public static final int CATEGORY_USER = 0;
    public static final Parcelable.Creator<AppItem> CREATOR = null;
    public int category;
    public final int key;
    public boolean restricted;
    public long total;
    public SparseBooleanArray uids;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AppItem r1) {
        return compareTo2(r1);
    }

    public AppItem() {
        this.uids = new SparseBooleanArray();
        this.key = 0;
    }

    public AppItem(int r2) {
        this.uids = new SparseBooleanArray();
        this.key = r2;
    }

    public AppItem(Parcel r3) {
        this.uids = new SparseBooleanArray();
        this.key = r3.readInt();
        this.uids = r3.readSparseBooleanArray();
        this.total = r3.readLong();
    }

    public void addUid(int r2) {
        this.uids.put(r2, true);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(this.key);
        r3.writeSparseBooleanArray(this.uids);
        r3.writeLong(this.total);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AppItem r3) {
        int r0 = Integer.compare(this.category, r3.category);
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return Long.compare(r3.total, this.total);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
