package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
class MediaDescriptionCompatApi21 {

    static class Builder {
        public static Object newInstance() {
            return new MediaDescription.Builder();
        }

        public static void setMediaId(Object r0, String r1) {
            ((MediaDescription.Builder) r0).setMediaId(r1);
        }

        public static void setTitle(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setTitle(r1);
        }

        public static void setSubtitle(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setSubtitle(r1);
        }

        public static void setDescription(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setDescription(r1);
        }

        public static void setIconBitmap(Object r0, Bitmap r1) {
            ((MediaDescription.Builder) r0).setIconBitmap(r1);
        }

        public static void setIconUri(Object r0, Uri r1) {
            ((MediaDescription.Builder) r0).setIconUri(r1);
        }

        public static void setExtras(Object r0, Bundle r1) {
            ((MediaDescription.Builder) r0).setExtras(r1);
        }

        public static Object build(Object r0) {
            return ((MediaDescription.Builder) r0).build();
        }

        private Builder() {
        }
    }

    public static String getMediaId(Object r0) {
        return ((MediaDescription) r0).getMediaId();
    }

    public static CharSequence getTitle(Object r0) {
        return ((MediaDescription) r0).getTitle();
    }

    public static CharSequence getSubtitle(Object r0) {
        return ((MediaDescription) r0).getSubtitle();
    }

    public static CharSequence getDescription(Object r0) {
        return ((MediaDescription) r0).getDescription();
    }

    public static Bitmap getIconBitmap(Object r0) {
        return ((MediaDescription) r0).getIconBitmap();
    }

    public static Uri getIconUri(Object r0) {
        return ((MediaDescription) r0).getIconUri();
    }

    public static Bundle getExtras(Object r0) {
        return ((MediaDescription) r0).getExtras();
    }

    public static void writeToParcel(Object r0, Parcel r1, int r2) {
        ((MediaDescription) r0).writeToParcel(r1, r2);
    }

    public static Object fromParcel(Parcel r1) {
        return MediaDescription.CREATOR.createFromParcel(r1);
    }

    private MediaDescriptionCompatApi21() {
    }
}
