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
public interface IMediaControllerCallback extends IInterface {

    public static abstract class Stub extends Binder implements IMediaControllerCallback {
        private static final String DESCRIPTOR = "android.support.v4.media.session.IMediaControllerCallback";
        static final int TRANSACTION_onCaptioningEnabledChanged = 11;
        static final int TRANSACTION_onEvent = 1;
        static final int TRANSACTION_onExtrasChanged = 7;
        static final int TRANSACTION_onMetadataChanged = 4;
        static final int TRANSACTION_onPlaybackStateChanged = 3;
        static final int TRANSACTION_onQueueChanged = 5;
        static final int TRANSACTION_onQueueTitleChanged = 6;
        static final int TRANSACTION_onRepeatModeChanged = 9;
        static final int TRANSACTION_onSessionDestroyed = 2;
        static final int TRANSACTION_onSessionReady = 13;
        static final int TRANSACTION_onShuffleModeChanged = 12;
        static final int TRANSACTION_onShuffleModeChangedRemoved = 10;
        static final int TRANSACTION_onVolumeInfoChanged = 8;

        public static class Proxy implements IMediaControllerCallback {
            private IBinder mRemote;

            public Proxy(IBinder r1) {
                this.mRemote = r1;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(11, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r3, Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeString(r3);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(1, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(7, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(4, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(3, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeTypedList(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(5, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                TextUtils.writeToParcel(r4, r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(6, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(9, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(2, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                this.mRemote.transact(13, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4);     // Catch: Throwable -> L6
                this.mRemote.transact(12, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                r0.writeInt(r4 ? 1 : 0);     // Catch: Throwable -> L6
                this.mRemote.transact(10, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r4) {
                Parcel r0 = Parcel.obtain();
                r0.writeInterfaceToken(Stub.DESCRIPTOR);     // Catch: Throwable -> L6
                if (r4 == null) goto L8;
                r0.writeInt(1);     // Catch: Throwable -> L6
                r4.writeToParcel(r0, 0);     // Catch: Throwable -> L6
            L9:
                this.mRemote.transact(8, r0, null, 1);     // Catch: Throwable -> L6
                r0.recycle();
                return;
            L8:
                r0.writeInt(0);     // Catch: Throwable -> L6
            L6:
                th = move-exception;
                r0.recycle();
                throw th;
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IMediaControllerCallback asInterface(IBinder r2) {
            if (r2 != null) goto L5;
            return null;
        L5:
            IInterface r0 = r2.queryLocalInterface(DESCRIPTOR);
            if (r0 == null) goto L12;
            if ((r0 instanceof IMediaControllerCallback) == false) goto L12;
            return (IMediaControllerCallback) r0;
        L12:
            return new Proxy(r2);
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
            r6.enforceInterface(DESCRIPTOR);
            onSessionReady();
            return true;
        L10:
            r6.enforceInterface(DESCRIPTOR);
            onShuffleModeChanged(r6.readInt());
            return true;
        L12:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L15;
            r0 = true;
        L15:
            onCaptioningEnabledChanged(r0);
            return true;
        L17:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L20;
            r0 = true;
        L20:
            onShuffleModeChangedRemoved(r0);
            return true;
        L22:
            r6.enforceInterface(DESCRIPTOR);
            onRepeatModeChanged(r6.readInt());
            return true;
        L24:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L27;
            r4 = ParcelableVolumeInfo.CREATOR.createFromParcel(r6);
        L27:
            onVolumeInfoChanged(r4);
            return true;
        L29:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L32;
            r9 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L32:
            onExtrasChanged(r9);
            return true;
        L34:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L37;
            r10 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r6);
        L37:
            onQueueTitleChanged(r10);
            return true;
        L39:
            r6.enforceInterface(DESCRIPTOR);
            onQueueChanged(r6.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
            return true;
        L41:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L44;
            r11 = MediaMetadataCompat.CREATOR.createFromParcel(r6);
        L44:
            onMetadataChanged(r11);
            return true;
        L46:
            r6.enforceInterface(DESCRIPTOR);
            if (r6.readInt() == 0) goto L49;
            r12 = PlaybackStateCompat.CREATOR.createFromParcel(r6);
        L49:
            onPlaybackStateChanged(r12);
            return true;
        L51:
            r6.enforceInterface(DESCRIPTOR);
            onSessionDestroyed();
            return true;
        L53:
            r6.enforceInterface(DESCRIPTOR);
            String r13 = r6.readString();
            if (r6.readInt() == 0) goto L56;
            r3 = (Bundle) Bundle.CREATOR.createFromParcel(r6);
        L56:
            onEvent(r13, r3);
            return true;
        L7:
            return super.onTransact(r5, r6, r7, r8);
        L58:
            r7.writeString(DESCRIPTOR);
            return true;
        }
    }

    void onCaptioningEnabledChanged(boolean r1);

    void onEvent(String r1, Bundle r2);

    void onExtrasChanged(Bundle r1);

    void onMetadataChanged(MediaMetadataCompat r1);

    void onPlaybackStateChanged(PlaybackStateCompat r1);

    void onQueueChanged(List<MediaSessionCompat.QueueItem> r1);

    void onQueueTitleChanged(CharSequence r1);

    void onRepeatModeChanged(int r1);

    void onSessionDestroyed();

    void onSessionReady();

    void onShuffleModeChanged(int r1);

    void onShuffleModeChangedRemoved(boolean r1);

    void onVolumeInfoChanged(ParcelableVolumeInfo r1);
}
