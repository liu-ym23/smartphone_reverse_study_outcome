package com.bytedanceos.security;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedanceos.security.reflect.OpsManagerHelper;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionItem implements Parcelable, Comparable<PermissionItem> {
    public static final Parcelable.Creator<PermissionItem> CREATOR = null;
    private int mId;
    private int mMode;
    private int mOrder;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(PermissionItem permission) {
        return compareTo2(permission);
    }

    public PermissionItem(int index) {
        this.mMode = OpsManagerHelper.get_MODE_INVALID();
        this.mId = index;
        this.mOrder = Utils.mPermissionsOrder[index];
    }

    public PermissionItem(Parcel in) {
        this.mMode = OpsManagerHelper.get_MODE_INVALID();
        this.mId = in.readInt();
    }

    public int getId() {
        return this.mId;
    }

    public int getType() {
        return Utils.mPermissionViewType[this.mId];
    }

    public void setMode(int mode) {
        this.mMode = mode;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public int hashCode() {
        return this.mId;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(PermissionItem permission) {
        if (permission.mOrder <= this.mOrder) goto L6;
        return -1;
    L6:
        return 1;
    }
}
