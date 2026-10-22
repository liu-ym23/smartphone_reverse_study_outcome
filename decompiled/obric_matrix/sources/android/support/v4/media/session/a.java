package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface a extends IInterface {

    /* JADX INFO: renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    public static abstract class AbstractBinderC0010a extends Binder implements a {
        public AbstractBinderC0010a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int r5, Parcel r6, Parcel r7, int r8) {
            if (r5 == 1598968902) goto L58;
            boolean r0 = false;
            Bundle r3 = null;
            ParcelableVolumeInfo r4 = null;
            Bundle r9 = null;
            CharSequence r10 = null;
            MediaMetadataCompat r11 = null;
            PlaybackStateCompat r12 = null;
            switch(r5) {
                case 1: goto L53;
                case 2: goto L51;
                case 3: goto L46;
                case 4: goto L41;
                case 5: goto L39;
                case 6: goto L34;
                case 7: goto L29;
                case 8: goto L24;
                case 9: goto L22;
                case 10: goto L17;
                case 11: goto L12;
                case 12: goto L10;
                case 13: goto L8;
                default: goto L7;
            };
        L8:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            p();
            return true;
        L10:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            U(r6.readInt());
            return true;
        L12:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L15;
            r0 = true;
        L15:
            C(r0);
            return true;
        L17:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L20;
            r0 = true;
        L20:
            H(r0);
            return true;
        L22:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            O(r6.readInt());
            return true;
        L24:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L27;
            r4 = ParcelableVolumeInfo.CREATOR.createFromParcel(r6);
        L27:
            i0(r4);
            return true;
        L29:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L32;
            r9 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L32:
            d(r9);
            return true;
        L34:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L37;
            r10 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r6);
        L37:
            g(r10);
            return true;
        L39:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            e(r6.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L44;
            r11 = MediaMetadataCompat.CREATOR.createFromParcel(r6);
        L44:
            L(r11);
            return true;
        L46:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (r6.readInt() == 0) goto L49;
            r12 = PlaybackStateCompat.CREATOR.createFromParcel(r6);
        L49:
            e0(r12);
            return true;
        L51:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            h();
            return true;
        L53:
            r6.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
            String r13 = r6.readString();
            if (r6.readInt() == 0) goto L56;
            r3 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L56:
            g0(r13, r3);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L58:
            r7.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void C(boolean r1);

    void H(boolean r1);

    void L(MediaMetadataCompat r1);

    void O(int r1);

    void U(int r1);

    void d(Bundle r1);

    void e(List<MediaSessionCompat.QueueItem> r1);

    void e0(PlaybackStateCompat r1);

    void g(CharSequence r1);

    void g0(String r1, Bundle r2);

    void h();

    void i0(ParcelableVolumeInfo r1);

    void p();
}
