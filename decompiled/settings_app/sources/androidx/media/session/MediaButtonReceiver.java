package androidx.media.session;

import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.media.MediaBrowserServiceCompat;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class MediaButtonReceiver extends BroadcastReceiver {
    private static final String TAG = "MediaButtonReceiver";

    private static class MediaButtonConnectionCallback extends MediaBrowserCompat.ConnectionCallback {
        private final Context mContext;
        private final Intent mIntent;
        private MediaBrowserCompat mMediaBrowser;
        private final BroadcastReceiver.PendingResult mPendingResult;

        MediaButtonConnectionCallback(Context r1, Intent r2, BroadcastReceiver.PendingResult r3) {
            this.mContext = r1;
            this.mIntent = r2;
            this.mPendingResult = r3;
        }

        void setMediaBrowser(MediaBrowserCompat r1) {
            this.mMediaBrowser = r1;
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
        public void onConnectionSuspended() {
            finish();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            finish();
        }

        private void finish() {
            this.mMediaBrowser.disconnect();
            this.mPendingResult.finish();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        androidx_media_session_MediaButtonReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public MediaButtonReceiver() {
    }

    public void androidx_media_session_MediaButtonReceiver__onReceive$___twin___(Context r3, Intent r4) {
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

    public static PendingIntent buildMediaButtonPendingIntent(Context r1, long r2) {
        ComponentName r0 = getMediaButtonReceiverComponent(r1);
        if (r0 != null) goto L7;
        Log.w(TAG, "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
        return null;
    L7:
        return buildMediaButtonPendingIntent(r1, r0, r2);
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

    public static ComponentName getMediaButtonReceiverComponent(Context r3) {
        Intent r0 = new Intent("android.intent.action.MEDIA_BUTTON");
        r0.setPackage(r3.getPackageName());
        List<ResolveInfo> r4 = r3.getPackageManager().queryBroadcastReceivers(r0, 0);
        if (r4.size() != 1) goto L7;
        ResolveInfo r5 = r4.get(0);
        return new ComponentName(r5.activityInfo.packageName, r5.activityInfo.name);
    L7:
        if (r4.size() <= 1) goto L11;
        Log.w(TAG, "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
        return null;
    L11:
        return null;
    }

    private static void startForegroundService(Context r0, Intent r1) {
        r0.startForegroundService(r1);
    }

    private static ComponentName getServiceComponentByAction(Context r3, String r4) {
        PackageManager r0 = r3.getPackageManager();
        Intent r1 = new Intent(r4);
        r1.setPackage(r3.getPackageName());
        List<ResolveInfo> r2 = r0.queryIntentServices(r1, 0);
        if (r2.size() != 1) goto L7;
        ResolveInfo r5 = r2.get(0);
        return new ComponentName(r5.serviceInfo.packageName, r5.serviceInfo.name);
    L7:
        if (r2.isEmpty() == false) goto L11;
        return null;
    L11:
        throw new IllegalStateException("Expected 1 service that handles " + r4 + ", found " + r2.size());
    }

    @Insert("onReceive")
    public static void androidx_media_session_MediaButtonReceiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(MediaButtonReceiver r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        MediaButtonReceiver r1 = r7;
        String r2 = r1.getClass().getName();
        String r3 = r1.getClass().getSimpleName();
        boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
        String r5 = null;
        if (r9 == null) goto L5;
        String r6 = r9.getAction();
    L7:
        if (ArraysKt.contains(r0, r6) == false) goto L13;
        StringBuilder r10 = new StringBuilder("onReceive allowList ");
        if (r9 == null) goto L11;
        r5 = r9.getAction();
    L11:
        OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
        r7.androidx_media_session_MediaButtonReceiver__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.androidx_media_session_MediaButtonReceiver__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.androidx_media_session_MediaButtonReceiver__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.androidx_media_session_MediaButtonReceiver__onReceive$___twin___(r8, r9);
        return;
    L19:
        if (r13.length() == 0) goto L22;
        r14 = false;
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
