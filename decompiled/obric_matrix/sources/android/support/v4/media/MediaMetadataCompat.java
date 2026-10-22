package android.support.v4.media;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.collection.ArrayMap;

/* JADX INFO: loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final ArrayMap<String, Integer> f169h = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Bundle f170f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f171g;

    static class a implements Parcelable.Creator<MediaMetadataCompat> {
        a() {
        }

        public MediaMetadataCompat a(Parcel r1) {
            return new MediaMetadataCompat(r1);
        }

        public MediaMetadataCompat[] b(int r1) {
            return new MediaMetadataCompat[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaMetadataCompat createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MediaMetadataCompat[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        ArrayMap<String, Integer> r0 = new ArrayMap();
        f169h = r0;
        r0.put("android.media.metadata.TITLE", 1);
        r0.put("android.media.metadata.ARTIST", 1);
        r0.put("android.media.metadata.DURATION", 0);
        r0.put("android.media.metadata.ALBUM", 1);
        r0.put("android.media.metadata.AUTHOR", 1);
        r0.put("android.media.metadata.WRITER", 1);
        r0.put("android.media.metadata.COMPOSER", 1);
        r0.put("android.media.metadata.COMPILATION", 1);
        r0.put("android.media.metadata.DATE", 1);
        r0.put("android.media.metadata.YEAR", 0);
        r0.put("android.media.metadata.GENRE", 1);
        r0.put("android.media.metadata.TRACK_NUMBER", 0);
        r0.put("android.media.metadata.NUM_TRACKS", 0);
        r0.put("android.media.metadata.DISC_NUMBER", 0);
        r0.put("android.media.metadata.ALBUM_ARTIST", 1);
        r0.put("android.media.metadata.ART", 2);
        r0.put("android.media.metadata.ART_URI", 1);
        r0.put("android.media.metadata.ALBUM_ART", 2);
        r0.put("android.media.metadata.ALBUM_ART_URI", 1);
        r0.put("android.media.metadata.USER_RATING", 3);
        r0.put("android.media.metadata.RATING", 3);
        r0.put("android.media.metadata.DISPLAY_TITLE", 1);
        r0.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        r0.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        r0.put("android.media.metadata.DISPLAY_ICON", 2);
        r0.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        r0.put("android.media.metadata.MEDIA_ID", 1);
        r0.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        r0.put("android.media.metadata.MEDIA_URI", 1);
        r0.put("android.media.metadata.ADVERTISEMENT", 0);
        r0.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        CREATOR = new a();
    }

    MediaMetadataCompat(Parcel r2) {
        this.f170f = r2.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public static MediaMetadataCompat b(Object r2) {
        if (r2 != null) goto L4;
        return null;
    L4:
        if (Build.VERSION.SDK_INT < 21) goto L9;
        Parcel r0 = Parcel.obtain();
        e.a(r2, r0, 0);
        r0.setDataPosition(0);
        MediaMetadataCompat r1 = CREATOR.createFromParcel(r0);
        r0.recycle();
        r1.f171g = r2;
        return r1;
    L9:
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeBundle(this.f170f);
    }
}
