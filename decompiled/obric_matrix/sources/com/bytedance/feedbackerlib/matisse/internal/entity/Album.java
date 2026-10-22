package com.bytedance.feedbackerlib.matisse.internal.entity;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.feedbackerlib.j.e;

/* JADX INFO: loaded from: classes.dex */
public class Album implements Parcelable {
    public static final Parcelable.Creator<Album> CREATOR = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4328j = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f4329f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Uri f4330g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f4331h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f4332i;

    static class a implements Parcelable.Creator<Album> {
        a() {
        }

        public Album a(Parcel r2) {
            return new Album(r2, null);
        }

        public Album[] b(int r1) {
            return new Album[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Album createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Album[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
        f4328j = String.valueOf(-1);
    }

    private Album(Parcel r3) {
        this.f4329f = r3.readString();
        this.f4330g = (Uri) r3.readParcelable(Uri.class.getClassLoader());
        this.f4331h = r3.readString();
        this.f4332i = r3.readLong();
    }

    /* synthetic */ Album(Parcel r1, a r2) {
        this(r1);
    }

    public Album(String r1, Uri r2, String r3, long r4) {
        this.f4329f = r1;
        this.f4330g = r2;
        this.f4331h = r3;
        this.f4332i = r4;
    }

    public static Album j(Cursor r8) {
        String r0 = r8.getString(r8.getColumnIndex("uri"));
        String r2 = r8.getString(r8.getColumnIndex("bucket_id"));
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        return new Album(r2, Uri.parse(r0), r8.getString(r8.getColumnIndex("bucket_display_name")), r8.getLong(r8.getColumnIndex("count")));
    }

    public void b() {
        this.f4332i++;
    }

    public long d() {
        return this.f4332i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Uri e() {
        return this.f4330g;
    }

    public String f(Context r1) {
        if (h() == false) goto L7;
        return e.e().g("recent");
    L7:
        return this.f4331h;
    }

    public String g() {
        return this.f4329f;
    }

    public boolean h() {
        return f4328j.equals(this.f4329f);
    }

    public boolean i() {
        if (this.f4332i != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeString(this.f4329f);
        r3.writeParcelable(this.f4330g, 0);
        r3.writeString(this.f4331h);
        r3.writeLong(this.f4332i);
    }
}
