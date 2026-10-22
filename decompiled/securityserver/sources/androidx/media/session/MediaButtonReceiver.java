package androidx.media.session;

import a.a;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    public static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        public MediaButtonConnectionCallback(Context r1, Intent r2, BroadcastReceiver.PendingResult r3) {
            this.mContext = r1;
            this.mIntent = r2;
            this.mPendingResult = r3;
        }

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            new MediaControllerCompat(this.mContext, this.mMediaBrowser.getSessionToken()).dispatchMediaButtonEvent((KeyEvent) this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));     // Catch: RemoteException -> L4
        L6:
            finish();
            return;
        L4:
            e = move-exception;
            Log.e(MediaButtonReceiver.TAG, "Failed to create a media controller", e);
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            finish();
        }

        public void setMediaBrowser(MediaBrowserCompat r1) {
            this.mMediaBrowser = r1;
        }
    }

    public MediaButtonReceiver() {
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r1, long r2) {
        ComponentName r0 = getMediaButtonReceiverComponent(r1);
        if (r0 != null) goto L7;
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    L7:
        return buildMediaButtonPendingIntent(r1, r0, r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static ComponentName getMediaButtonReceiverComponent(Context r3) {
        Intent r0 = new Intent("android.intent.action.MEDIA_BUTTON");
        r0.setPackage(r3.getPackageName());
        List<ResolveInfo> r4 = r3.getPackageManager().queryBroadcastReceivers(r0, 0);
        if (r4.size() != 1) goto L7;
        ActivityInfo r5 = r4.get(0).activityInfo;
        return new ComponentName(r5.packageName, r5.name);
    L7:
        if (r4.size() <= 1) goto L11;
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    private static ComponentName getServiceComponentByAction(Context r3, String r4) {
        PackageManager r0 = r3.getPackageManager();
        Intent r1 = new Intent(r4);
        r1.setPackage(r3.getPackageName());
        List<ResolveInfo> r2 = r0.queryIntentServices(r1, 0);
        if (r2.size() != 1) goto L7;
        ServiceInfo r5 = r2.get(0).serviceInfo;
        return new ComponentName(r5.packageName, r5.name);
    L7:
        if (r2.isEmpty() == false) goto L10;
        return null;
    L10:
        StringBuilder r6 = a.u("Expected 1 service that handles ", r4, ", found ");
        r6.append(r2.size());
        throw new IllegalStateException(r6.toString());
    }

    public static KeyEvent handleIntent(MediaSessionCompat r2, Intent r3) {
        if (r2 == null) goto L11;
        if (r3 != null) goto L5;
        return null;
    L5:
        if ("android.intent.action.MEDIA_BUTTON".equals(r3.getAction()) == true) goto L7;
        return null;
    L7:
        if (r3.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L15;
        KeyEvent r4 = (KeyEvent) r3.getParcelableExtra("android.intent.extra.KEY_EVENT");
        r2.getController().dispatchMediaButtonEvent(r4);
        return r4;
    L15:
        return null;
    L11:
        return null;
    }

    private static void startForegroundService(Context r0, Intent r1) {
        r0.startForegroundService(r1);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r3, Intent r4) {
        if (r4 != null) goto L4;
    L18:
        Log.d(TAG, "Ignore unsupported intent: " + r4);
        return;
    L4:
        if ("android.intent.action.MEDIA_BUTTON".equals(r4.getAction()) == false) goto L18;
        if (r4.hasExtra("android.intent.extra.KEY_EVENT") == false) goto L18;
        ComponentName r0 = getServiceComponentByAction(r3, "android.intent.action.MEDIA_BUTTON");
        if (r0 == null) goto L12;
        r4.setComponent(r0);
        startForegroundService(r3, r4);
        return;
    L12:
        ComponentName r1 = getServiceComponentByAction(r3, MediaBrowserServiceCompat.SERVICE_INTERFACE);
        if (r1 == null) goto L17;
        BroadcastReceiver.PendingResult r2 = goAsync();
        Context r5 = r3.getApplicationContext();
        MediaButtonConnectionCallback r6 = new MediaButtonConnectionCallback(r5, r4, r2);
        MediaBrowserCompat r7 = new MediaBrowserCompat(r5, r1, r6, null);
        r6.setMediaBrowser(r7);
        r7.connect();
        return;
    L17:
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }

    public static PendingIntent buildMediaButtonPendingIntent(Context r3, ComponentName r4, long r5) {
        if (r4 != null) goto L6;
        Log.w(TAG, "The component name of media button receiver should be provided.");
        return null;
    L6:
        int r2 = PlaybackStateCompat.toKeyCode(r5);
        if (r2 != 0) goto L10;
        Log.w(TAG, "Cannot build a media button pending intent with the given action: " + r5);
        return null;
    L10:
        Intent r6 = new Intent("android.intent.action.MEDIA_BUTTON");
        r6.setComponent(r4);
        r6.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, r2));
        return PendingIntent.getBroadcast(r3, r2, r6, 0);
    }
}
