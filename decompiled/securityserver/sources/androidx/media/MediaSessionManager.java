package androidx.media;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
public final class MediaSessionManager {
    static final boolean DEBUG = false;
    static final String TAG = "MediaSessionManager";
    private static final Object sLock = null;
    private static volatile MediaSessionManager sSessionManager;
    MediaSessionManagerImpl mImpl;

    public interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r1);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        public RemoteUserInfo(@NonNull String r2, int r3, int r4) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r2, r3, r4);
        }

        public boolean equals(@Nullable Object r2) {
            if (this != r2) goto L6;
            return true;
        L6:
            if ((r2 instanceof RemoteUserInfo) == true) goto L10;
            return false;
        L10:
            return this.mImpl.equals(((RemoteUserInfo) r2).mImpl);
        }

        @NonNull
        public String getPackageName() {
            return this.mImpl.getPackageName();
        }

        public int getPid() {
            return this.mImpl.getPid();
        }

        public int getUid() {
            return this.mImpl.getUid();
        }

        public int hashCode() {
            return this.mImpl.hashCode();
        }

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r2) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r2);
        }
    }

    public interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sLock = new Object();
    }

    private MediaSessionManager(Context r2) {
        this.mImpl = new MediaSessionManagerImplApi28(r2);
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context r2) {
        MediaSessionManager r0 = sSessionManager;
        if (r0 != null) goto L15;
        Object r1 = sLock;
        monitor-enter(r1);
        r0 = sSessionManager;     // Catch: Throwable -> L9
        if (r0 != null) goto L11;
        sSessionManager = new MediaSessionManager(r2.getApplicationContext());     // Catch: Throwable -> L9
        r0 = sSessionManager;     // Catch: Throwable -> L9
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L15:
        return r0;
    }

    public Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo r1) {
        if (r1 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r1.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
