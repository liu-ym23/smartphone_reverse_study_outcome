package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = null;
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    private final CharSequence mDescription;
    private Object mDescriptionObj;
    private final Bundle mExtras;
    private final Bitmap mIcon;
    private final Uri mIconUri;
    private final String mMediaId;
    private final Uri mMediaUri;
    private final CharSequence mSubtitle;
    private final CharSequence mTitle;

    public static final class Builder {
        private CharSequence mDescription;
        private Bundle mExtras;
        private Bitmap mIcon;
        private Uri mIconUri;
        private String mMediaId;
        private Uri mMediaUri;
        private CharSequence mSubtitle;
        private CharSequence mTitle;

        public Builder() {
        }

        public Builder setMediaId(String r1) {
            this.mMediaId = r1;
            return this;
        }

        public Builder setTitle(CharSequence r1) {
            this.mTitle = r1;
            return this;
        }

        public Builder setSubtitle(CharSequence r1) {
            this.mSubtitle = r1;
            return this;
        }

        public Builder setDescription(CharSequence r1) {
            this.mDescription = r1;
            return this;
        }

        public Builder setIconBitmap(Bitmap r1) {
            this.mIcon = r1;
            return this;
        }

        public Builder setIconUri(Uri r1) {
            this.mIconUri = r1;
            return this;
        }

        public Builder setExtras(Bundle r1) {
            this.mExtras = r1;
            return this;
        }

        public Builder setMediaUri(Uri r1) {
            this.mMediaUri = r1;
            return this;
        }

        public MediaDescriptionCompat build() {
            return new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String r1, CharSequence r2, CharSequence r3, CharSequence r4, Bitmap r5, Uri r6, Bundle r7, Uri r8) {
        this.mMediaId = r1;
        this.mTitle = r2;
        this.mSubtitle = r3;
        this.mDescription = r4;
        this.mIcon = r5;
        this.mIconUri = r6;
        this.mExtras = r7;
        this.mMediaUri = r8;
    }

    MediaDescriptionCompat(Parcel r3) {
        this.mMediaId = r3.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r3);
        ClassLoader r0 = getClass().getClassLoader();
        this.mIcon = (Bitmap) r3.readParcelable(r0);
        this.mIconUri = (Uri) r3.readParcelable(r0);
        this.mExtras = r3.readBundle(r0);
        this.mMediaUri = (Uri) r3.readParcelable(r0);
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getDescription() {
        return this.mDescription;
    }

    public Bitmap getIconBitmap() {
        return this.mIcon;
    }

    public Uri getIconUri() {
        return this.mIconUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Uri getMediaUri() {
        return this.mMediaUri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), r1, r2);
    }

    public String toString() {
        return this.mTitle + ", " + this.mSubtitle + ", " + this.mDescription;
    }

    public Object getMediaDescription() {
        Object r0 = this.mDescriptionObj;
        if (r0 != null) goto L6;
        Object r1 = MediaDescriptionCompatApi21.Builder.newInstance();
        MediaDescriptionCompatApi21.Builder.setMediaId(r1, this.mMediaId);
        MediaDescriptionCompatApi21.Builder.setTitle(r1, this.mTitle);
        MediaDescriptionCompatApi21.Builder.setSubtitle(r1, this.mSubtitle);
        MediaDescriptionCompatApi21.Builder.setDescription(r1, this.mDescription);
        MediaDescriptionCompatApi21.Builder.setIconBitmap(r1, this.mIcon);
        MediaDescriptionCompatApi21.Builder.setIconUri(r1, this.mIconUri);
        MediaDescriptionCompatApi21.Builder.setExtras(r1, this.mExtras);
        MediaDescriptionCompatApi23.Builder.setMediaUri(r1, this.mMediaUri);
        Object r2 = MediaDescriptionCompatApi21.Builder.build(r1);
        this.mDescriptionObj = r2;
        return r2;
    L6:
        return r0;
    }

    public static MediaDescriptionCompat fromMediaDescription(Object r8) {
        Bundle r0 = null;
        if (r8 == null) goto L22;
        Builder r1 = new Builder();
        r1.setMediaId(MediaDescriptionCompatApi21.getMediaId(r8));
        r1.setTitle(MediaDescriptionCompatApi21.getTitle(r8));
        r1.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(r8));
        r1.setDescription(MediaDescriptionCompatApi21.getDescription(r8));
        r1.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(r8));
        r1.setIconUri(MediaDescriptionCompatApi21.getIconUri(r8));
        Bundle r2 = MediaDescriptionCompatApi21.getExtras(r8);
        if (r2 == null) goto L7;
        MediaSessionCompat.ensureClassLoader(r2);
        Uri r4 = (Uri) r2.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
    L8:
        if (r4 != null) goto L10;
    L15:
        r0 = r2;
    L16:
        r1.setExtras(r0);
        if (r4 == null) goto L19;
        r1.setMediaUri(r4);
    L20:
        MediaDescriptionCompat r3 = r1.build();
        r3.mDescriptionObj = r8;
        return r3;
    L19:
        r1.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(r8));
        goto L20
    L10:
        if (r2.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) == true) goto L12;
    L14:
        r2.remove(DESCRIPTION_KEY_MEDIA_URI);
        r2.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
        goto L15
    L12:
        if (r2.size() != 2) goto L14;
    L7:
        r4 = null;
        goto L8
    L22:
        return null;
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
