package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class c {

    static class a {
        public static Object a(Object r0) {
            return ((MediaDescription.Builder) r0).build();
        }

        public static Object b() {
            return new MediaDescription.Builder();
        }

        public static void c(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setDescription(r1);
        }

        public static void d(Object r0, Bundle r1) {
            ((MediaDescription.Builder) r0).setExtras(r1);
        }

        public static void e(Object r0, Bitmap r1) {
            ((MediaDescription.Builder) r0).setIconBitmap(r1);
        }

        public static void f(Object r0, Uri r1) {
            ((MediaDescription.Builder) r0).setIconUri(r1);
        }

        public static void g(Object r0, String r1) {
            ((MediaDescription.Builder) r0).setMediaId(r1);
        }

        public static void h(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setSubtitle(r1);
        }

        public static void i(Object r0, CharSequence r1) {
            ((MediaDescription.Builder) r0).setTitle(r1);
        }
    }

    public static Object a(Parcel r1) {
        return MediaDescription.CREATOR.createFromParcel(r1);
    }

    public static CharSequence b(Object r0) {
        return ((MediaDescription) r0).getDescription();
    }

    public static Bundle c(Object r0) {
        return ((MediaDescription) r0).getExtras();
    }

    public static Bitmap d(Object r0) {
        return ((MediaDescription) r0).getIconBitmap();
    }

    public static Uri e(Object r0) {
        return ((MediaDescription) r0).getIconUri();
    }

    public static String f(Object r0) {
        return ((MediaDescription) r0).getMediaId();
    }

    public static CharSequence g(Object r0) {
        return ((MediaDescription) r0).getSubtitle();
    }

    public static CharSequence h(Object r0) {
        return ((MediaDescription) r0).getTitle();
    }

    public static void i(Object r0, Parcel r1, int r2) {
        ((MediaDescription) r0).writeToParcel(r1, r2);
    }
}
