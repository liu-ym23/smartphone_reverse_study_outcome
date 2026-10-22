package androidx.media;

import android.content.Context;
import android.os.Build;
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

    interface MediaSessionManagerImpl {
        Context getContext();

        boolean isTrustedForMediaControl(RemoteUserInfoImpl r1);
    }

    public static final class RemoteUserInfo {
        public static final String LEGACY_CONTROLLER = "android.media.session.MediaController";
        RemoteUserInfoImpl mImpl;

        @RequiresApi(28)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public RemoteUserInfo(android.media.session.MediaSessionManager.RemoteUserInfo r2) {
            this.mImpl = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r2);
        }

        public RemoteUserInfo(@NonNull String r3, int r4, int r5) {
            if (Build.VERSION.SDK_INT < 28) goto L5;
            RemoteUserInfoImpl r0 = new MediaSessionManagerImplApi28.RemoteUserInfoImplApi28(r3, r4, r5);
        L6:
            this.mImpl = r0;
            return;
        L5:
            r0 = new MediaSessionManagerImplBase.RemoteUserInfoImplBase(r3, r4, r5);
            goto L6
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
    }

    interface RemoteUserInfoImpl {
        String getPackageName();

        int getPid();

        int getUid();
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        sLock = new Object();
    }

    private MediaSessionManager(Context r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        MediaSessionManagerImpl r1 = new MediaSessionManagerImplApi28(r3);
    L5:
        this.mImpl = r1;
        return;
    L7:
        if (r0 < 21) goto L9;
        r1 = new MediaSessionManagerImplApi21(r3);
        goto L5
    L9:
        r1 = new MediaSessionManagerImplBase(r3);
        goto L5
    }

    @NonNull
    public static MediaSessionManager getSessionManager(@NonNull Context r2) {
        MediaSessionManager r0 = sSessionManager;
        if (r0 != null) goto L14;
        Object r1 = sLock;
        monitor-enter(r1);
        r0 = sSessionManager;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        sSessionManager = new MediaSessionManager(r2.getApplicationContext());     // Catch: Throwable -> L11
        r0 = sSessionManager;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    Context getContext() {
        return this.mImpl.getContext();
    }

    public boolean isTrustedForMediaControl(@NonNull RemoteUserInfo r1) {
        if (r1 == null) goto L6;
        return this.mImpl.isTrustedForMediaControl(r1.mImpl);
    L6:
        throw new IllegalArgumentException("userInfo should not be null");
    }
}
