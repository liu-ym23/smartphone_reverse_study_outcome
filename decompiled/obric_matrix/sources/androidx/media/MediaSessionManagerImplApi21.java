package androidx.media;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaSessionManagerImplApi21 extends MediaSessionManagerImplBase {
    MediaSessionManagerImplApi21(Context r1) {
        super(r1);
        this.mContext = r1;
    }

    private boolean hasMediaControlPermission(@NonNull MediaSessionManager.RemoteUserInfoImpl r3) {
        if (getContext().checkPermission("android.permission.MEDIA_CONTENT_CONTROL", r3.getPid(), r3.getUid()) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.media.MediaSessionManagerImplBase, androidx.media.MediaSessionManager.MediaSessionManagerImpl
    public boolean isTrustedForMediaControl(@NonNull MediaSessionManager.RemoteUserInfoImpl r2) {
        if (hasMediaControlPermission(r2) == false) goto L5;
    L8:
        return true;
    L5:
        if (super.isTrustedForMediaControl(r2) == true) goto L8;
        return false;
    }
}
