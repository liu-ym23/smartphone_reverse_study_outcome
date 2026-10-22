package com.bytedanceos.security;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionGroup implements Parcelable {
    public static final Parcelable.Creator<PermissionGroup> CREATOR = null;
    private int mId;
    private ArrayList<PermissionItem> mIncludePermissions;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PermissionGroup(int id) {
        this.mIncludePermissions = new ArrayList();
        this.mId = id;
    }

    public PermissionGroup(Parcel in) {
        this.mIncludePermissions = new ArrayList();
        this.mId = in.readInt();
        this.mIncludePermissions = in.readArrayList(PermissionItem.class.getClassLoader());
    }

    public void addPermission(int opIndex) {
        PermissionItem r0 = new PermissionItem(opIndex);
        this.mIncludePermissions.add(r0);
        Collections.sort(this.mIncludePermissions);
    }

    public void addPermission(int index, int opIndex) {
        PermissionItem r0 = new PermissionItem(opIndex);
        this.mIncludePermissions.add(index, r0);
        Collections.sort(this.mIncludePermissions);
    }

    public ArrayList<PermissionItem> getIncludePermissions() {
        return this.mIncludePermissions;
    }

    public int getChildCount() {
        return this.mIncludePermissions.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.mId);
        dest.writeList(this.mIncludePermissions);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
