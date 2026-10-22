package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CharSequence f155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CharSequence f156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CharSequence f157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bitmap f158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Uri f159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Bundle f160l;
    private final Uri m;
    private Object n;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        public MediaDescriptionCompat a(Parcel r2) {
            if (Build.VERSION.SDK_INT >= 21) goto L7;
            return new MediaDescriptionCompat(r2);
        L7:
            return MediaDescriptionCompat.b(c.a(r2));
        }

        public MediaDescriptionCompat[] b(int r1) {
            return new MediaDescriptionCompat[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaDescriptionCompat createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaDescriptionCompat[] newArray(int r1) {
            return b(r1);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f161a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f162b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f163c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f164d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f165e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f166f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f167g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f168h;

        public b() {
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f161a, this.f162b, this.f163c, this.f164d, this.f165e, this.f166f, this.f167g, this.f168h);
        }

        public b b(@Nullable CharSequence r1) {
            this.f164d = r1;
            return this;
        }

        public b c(@Nullable Bundle r1) {
            this.f167g = r1;
            return this;
        }

        public b d(@Nullable Bitmap r1) {
            this.f165e = r1;
            return this;
        }

        public b e(@Nullable Uri r1) {
            this.f166f = r1;
            return this;
        }

        public b f(@Nullable String r1) {
            this.f161a = r1;
            return this;
        }

        public b g(@Nullable Uri r1) {
            this.f168h = r1;
            return this;
        }

        public b h(@Nullable CharSequence r1) {
            this.f163c = r1;
            return this;
        }

        public b i(@Nullable CharSequence r1) {
            this.f162b = r1;
            return this;
        }
    }

    static {
        CREATOR = new a();
    }

    MediaDescriptionCompat(Parcel r3) {
        this.f154f = r3.readString();
        this.f155g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.f156h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.f157i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        ClassLoader r0 = MediaDescriptionCompat.class.getClassLoader();
        this.f158j = (Bitmap) r3.readParcelable(r0);
        this.f159k = (Uri) r3.readParcelable(r0);
        this.f160l = r3.readBundle(r0);
        this.m = (Uri) r3.readParcelable(r0);
    }

    MediaDescriptionCompat(String r1, CharSequence r2, CharSequence r3, CharSequence r4, Bitmap r5, Uri r6, Bundle r7, Uri r8) {
        this.f154f = r1;
        this.f155g = r2;
        this.f156h = r3;
        this.f157i = r4;
        this.f158j = r5;
        this.f159k = r6;
        this.f160l = r7;
        this.m = r8;
    }

    public static MediaDescriptionCompat b(Object r9) {
        Bundle r0 = null;
        if (r9 == null) goto L26;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 21) goto L27;
        b r2 = new b();
        r2.f(c.f(r9));
        r2.i(c.h(r9));
        r2.h(c.g(r9));
        r2.b(c.b(r9));
        r2.d(c.d(r9));
        r2.e(c.e(r9));
        Bundle r3 = c.c(r9);
        if (r3 == null) goto L9;
        MediaSessionCompat.a(r3);
        Uri r5 = (Uri) r3.getParcelable("android.support.v4.media.description.MEDIA_URI");
    L10:
        if (r5 != null) goto L12;
    L17:
        r0 = r3;
    L18:
        r2.c(r0);
        if (r5 == null) goto L22;
        r2.g(r5);
    L24:
        MediaDescriptionCompat r4 = r2.a();
        r4.n = r9;
        return r4;
    L22:
        if (r1 < 23) goto L24;
        r2.g(d.a(r9));
        goto L24
    L12:
        if (r3.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") == true) goto L14;
    L16:
        r3.remove("android.support.v4.media.description.MEDIA_URI");
        r3.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
        goto L17
    L14:
        if (r3.size() != 2) goto L16;
    L9:
        r5 = null;
        goto L10
    L27:
        return null;
    L26:
        return null;
    }

    public Object d() {
        Object r0 = this.n;
        if (r0 != null) goto L19;
        int r1 = Build.VERSION.SDK_INT;
        if (r1 < 21) goto L20;
        Object r2 = c.a.b();
        c.a.g(r2, this.f154f);
        c.a.i(r2, this.f155g);
        c.a.h(r2, this.f156h);
        c.a.c(r2, this.f157i);
        c.a.e(r2, this.f158j);
        c.a.f(r2, this.f159k);
        Bundle r3 = this.f160l;
        if (r1 < 23) goto L10;
    L14:
        c.a.d(r2, r3);
        if (r1 < 23) goto L17;
        d.a.a(r2, this.m);
    L17:
        Object r4 = c.a.a(r2);
        this.n = r4;
        return r4;
    L10:
        if (this.m == null) goto L14;
        if (r3 != null) goto L13;
        r3 = new Bundle();
        r3.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
    L13:
        r3.putParcelable("android.support.v4.media.description.MEDIA_URI", this.m);
        goto L14
    L20:
        return r0;
    L19:
        return r0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String e() {
        return this.f154f;
    }

    public String toString() {
        return this.f155g + ", " + this.f156h + ", " + this.f157i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        r3.writeString(this.f154f);
        TextUtils.writeToParcel(this.f155g, r3, r4);
        TextUtils.writeToParcel(this.f156h, r3, r4);
        TextUtils.writeToParcel(this.f157i, r3, r4);
        r3.writeParcelable(this.f158j, r4);
        r3.writeParcelable(this.f159k, r4);
        r3.writeBundle(this.f160l);
        r3.writeParcelable(this.m, r4);
        return;
    L5:
        c.i(d(), r3, r4);
    }
}
