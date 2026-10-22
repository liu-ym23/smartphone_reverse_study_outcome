package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float f173g;

    static class a implements Parcelable.Creator<RatingCompat> {
        a() {
        }

        public RatingCompat a(Parcel r2) {
            return new RatingCompat(r2.readInt(), r2.readFloat());
        }

        public RatingCompat[] b(int r1) {
            return new RatingCompat[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RatingCompat createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RatingCompat[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    RatingCompat(int r1, float r2) {
        this.f172f = r1;
        this.f173g = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f172f;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("Rating:style=");
        r0.append(this.f172f);
        r0.append(" rating=");
        float r2 = this.f173g;
        if (r2 >= 0.0f) goto L5;
        String r3 = "unrated";
    L6:
        r0.append(r3);
        return r0.toString();
    L5:
        r3 = String.valueOf(r2);
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(this.f172f);
        r1.writeFloat(this.f173g);
    }
}
