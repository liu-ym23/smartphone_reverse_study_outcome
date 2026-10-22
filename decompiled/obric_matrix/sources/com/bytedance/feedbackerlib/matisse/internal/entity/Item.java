package com.bytedance.feedbackerlib.matisse.internal.entity;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.j;

/* JADX INFO: loaded from: classes.dex */
public class Item implements Parcelable {
    public static final Parcelable.Creator<Item> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f4334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Uri f4335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f4336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f4337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4338k;

    static class a implements Parcelable.Creator<Item> {
        a() {
        }

        @Nullable
        public Item a(Parcel r2) {
            return new Item(r2, null);
        }

        public Item[] b(int r1) {
            return new Item[r1];
        }

        @Override // android.os.Parcelable.Creator
        @Nullable
        public /* bridge */ /* synthetic */ Item createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Item[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public Item(long r1, String r3, long r4, long r6, String r8) {
        this.f4333f = r1;
        this.f4334g = r3;
        this.f4338k = r8;
        if (f() == false) goto L6;
        Uri r5 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L9:
        this.f4335h = ContentUris.withAppendedId(r5, r1);
        this.f4336i = r4;
        this.f4337j = r6;
        return;
    L6:
        if (g() == false) goto L8;
        r5 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L9
    L8:
        r5 = MediaStore.Files.getContentUri("external");
        goto L9
    }

    public Item(@NonNull Context r10, @NonNull Uri r11) {
        if (r11 == null) goto L8;
        if (r10 == null) goto L8;
        ContentResolver r3 = r10.getContentResolver();
        if (r3 == null) goto L8;
        this.f4335h = r11;
        Cursor r12 = r3.query(r11, null, null, null, null);
    L25:
        th = move-exception;
        r12.close();
        throw th;
    L12:
        if (r12.moveToFirst() == true) goto L18;
        this.f4335h = null;     // Catch: Throwable -> L25
        this.f4333f = -1;     // Catch: Throwable -> L25
        this.f4334g = null;     // Catch: Throwable -> L25
        this.f4336i = -1;     // Catch: Throwable -> L25
        this.f4337j = -1;     // Catch: Throwable -> L25
        this.f4338k = null;     // Catch: Throwable -> L25
        r12.close();
        return;
    L18:
        if (j.i(r11) == false) goto L21;
        this.f4333f = r12.getLong(r12.getColumnIndex("_id"));     // Catch: Throwable -> L25
        this.f4334g = r12.getString(r12.getColumnIndex("mime_type"));     // Catch: Throwable -> L25
        this.f4336i = r12.getLong(r12.getColumnIndex("_size"));     // Catch: Throwable -> L25
        this.f4337j = 0;     // Catch: Throwable -> L25
        String r13 = r12.getString(r12.getColumnIndex("bucket_id"));     // Catch: Throwable -> L25
    L20:
        this.f4338k = r13;     // Catch: Throwable -> L25
        r12.close();
        return;
    L21:
        this.f4333f = r12.getLong(r12.getColumnIndex("_id"));     // Catch: Throwable -> L25
        this.f4334g = r12.getString(r12.getColumnIndex("mime_type"));     // Catch: Throwable -> L25
        this.f4336i = r12.getLong(r12.getColumnIndex("_size"));     // Catch: Throwable -> L25
        this.f4337j = 0;     // Catch: Throwable -> L25
        r13 = r12.getString(r12.getColumnIndex("bucket_id"));     // Catch: Throwable -> L25
    L8:
        this.f4335h = null;
        this.f4333f = -1;
        this.f4334g = null;
        this.f4336i = -1;
        this.f4337j = -1;
        this.f4338k = null;
    }

    private Item(Parcel r3) {
        this.f4333f = r3.readLong();
        this.f4334g = r3.readString();
        this.f4335h = (Uri) r3.readParcelable(Uri.class.getClassLoader());
        this.f4336i = r3.readLong();
        this.f4337j = r3.readLong();
        this.f4338k = r3.readString();
    }

    /* synthetic */ Item(Parcel r1, a r2) {
        this(r1);
    }

    public static Item i(Cursor r10) {
        int r0 = r10.getColumnIndex("bucket_id");
        if (r0 < 0) goto L5;
        String r1 = r10.getString(r0);
    L6:
        long r2 = r10.getLong(r10.getColumnIndex("_id"));
        String r4 = r10.getString(r10.getColumnIndex("mime_type"));
        long r5 = r10.getLong(r10.getColumnIndex("_size"));
        long r7 = r10.getLong(r10.getColumnIndex(TypedValues.TransitionType.S_DURATION));
        return new Item(r2, r4, r5, r7, r1);
    L5:
        r1 = "";
        goto L6
    }

    public Uri b() {
        return this.f4335h;
    }

    public boolean d() {
        if (this.f4333f != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        return com.bytedance.feedbackerlib.k.b.c(this.f4334g);
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof Item) == true) goto L5;
        return false;
    L5:
        Item r5 = (Item) r4;
        Uri r0 = this.f4335h;
        if (r0 == null) goto L10;
        if (r0.equals(r5.f4335h) == false) goto L10;
    L13:
        return true;
    L10:
        if (this.f4335h == null) goto L12;
        return false;
    L12:
        if (r5.f4335h == null) goto L13;
        return false;
    }

    public boolean f() {
        return com.bytedance.feedbackerlib.k.b.g(this.f4334g);
    }

    public boolean g() {
        return com.bytedance.feedbackerlib.k.b.j(this.f4334g);
    }

    public void h() {
        if (TextUtils.isEmpty(this.f4338k) == true) goto L5;
        return;
    L5:
        if (this.f4335h != null) goto L7;
        return;
    L7:
        if (Feedbacker.getApplicationContext() == null) goto L30;
        ContentResolver r1 = Feedbacker.getApplicationContext().getContentResolver();
        if (r1 != null) goto L11;
        return;
    L11:
        Cursor r0 = r1.query(this.f4335h, null, null, null, null);
    L23:
        th = move-exception;
        r0.close();
        throw th;
    L13:
        if (r0.getCount() > 0) goto L15;
    L21:
        r0.close();
        return;
    L15:
        if (r0.moveToFirst() == false) goto L21;
        int r2 = r0.getColumnIndex("bucket_id");     // Catch: Throwable -> L23
        if (r2 < 0) goto L20;
        this.f4338k = r0.getString(r2);     // Catch: Throwable -> L23
    L20:
        r0.close();
        return;
    }

    public int hashCode() {
        return this.f4335h.hashCode() + 31;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeLong(this.f4333f);
        r3.writeString(this.f4334g);
        r3.writeParcelable(this.f4335h, 0);
        r3.writeLong(this.f4336i);
        r3.writeLong(this.f4337j);
        r3.writeString(this.f4338k);
    }
}
