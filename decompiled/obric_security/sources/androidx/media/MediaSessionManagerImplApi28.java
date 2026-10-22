package androidx.media;

import android.content.Context;
import androidx.core.util.ObjectsCompat;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionManagerImplApi28 extends MediaSessionManagerImplApi21 {
    android.media.session.MediaSessionManager mObject;

    static final class RemoteUserInfoImplApi28 implements MediaSessionManager.RemoteUserInfoImpl {
        final android.media.session.MediaSessionManager.RemoteUserInfo mObject;

        RemoteUserInfoImplApi28(String r2, int r3, int r4) {
            this.mObject = new android.media.session.MediaSessionManager.RemoteUserInfo(r2, r3, r4);
        }

        RemoteUserInfoImplApi28(android.media.session.MediaSessionManager.RemoteUserInfo r1) {
            this.mObject = r1;
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public String getPackageName() {
            return this.mObject.getPackageName();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getPid() {
            return this.mObject.getPid();
        }

        @Override // androidx.media.MediaSessionManager.RemoteUserInfoImpl
        public int getUid() {
            return this.mObject.getUid();
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mObject});
        }

        public boolean equals(Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof RemoteUserInfoImplApi28) == true) goto L10;
            return false;
        L10:
            return this.mObject.equals(((RemoteUserInfoImplApi28) r2).mObject);
        }
    }

    MediaSessionManagerImplApi28(Context r2) {
        super(r2);
        this.mObject = (android.media.session.MediaSessionManager) r2.getSystemService("media_session");
    }

    @Override // androidx.media.MediaSessionManagerImplApi21, androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(MediaSessionManager.RemoteUserInfoImpl r2) {
        if ((r2 instanceof RemoteUserInfoImplApi28) == true) goto L5;
        return false;
    L5:
        return this.mObject.isTrustedForMediaControl(((RemoteUserInfoImplApi28) r2).mObject);
    }
}
