package com.android.settingslib.volume;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerExecutor;
import android.os.Looper;
import android.os.Message;
import com.GlobalProxyLancet;
import com.android.settings.utils.HanziToPinyin;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessions {
    private static final String TAG = null;
    private static final boolean USE_SERVICE_LABEL = false;
    private final Callbacks mCallbacks;
    private final Context mContext;
    private final H mHandler;
    private final HandlerExecutor mHandlerExecutor;
    private boolean mInit;
    private final MediaSessionManager mMgr;
    private final Map<MediaSession.Token, MediaControllerRecord> mRecords;
    private final MediaSessionManager.RemoteSessionCallback mRemoteSessionCallback;
    private final MediaSessionManager.OnActiveSessionsChangedListener mSessionsListener;

    public interface Callbacks {
        void onRemoteRemoved(MediaSession.Token r1);

        void onRemoteUpdate(MediaSession.Token r1, String r2, MediaController.PlaybackInfo r3);

        void onRemoteVolumeChanged(MediaSession.Token r1, int r2);
    }

    private final class H extends Handler {
        private static final int REMOTE_VOLUME_CHANGED = 2;
        private static final int UPDATE_REMOTE_SESSION_LIST = 3;
        private static final int UPDATE_SESSIONS = 1;
        final /* synthetic */ MediaSessions this$0;

        /* synthetic */ H(MediaSessions r1, Looper r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private H(MediaSessions r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            int r0 = r3.what;
            if (r0 != 1) goto L5;
            MediaSessions r2 = this.this$0;
            r2.onActiveSessionsUpdatedH(MediaSessions.access$700(r2).getActiveSessions(null));
            return;
        L5:
            if (r0 != 2) goto L7;
            MediaSessions.access$800(this.this$0, (MediaSession.Token) r3.obj, r3.arg1);
            return;
        L7:
            if (r0 != 3) goto L15;
            MediaSessions.access$900(this.this$0, (MediaSession.Token) r3.obj);
            return;
        }
    }

    private final class MediaControllerRecord extends MediaController.Callback {
        public final MediaController controller;
        public String name;
        public boolean sentRemote;
        final /* synthetic */ MediaSessions this$0;

        /* synthetic */ MediaControllerRecord(MediaSessions r1, MediaController r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private MediaControllerRecord(MediaSessions r1, MediaController r2) {
            this.this$0 = r1;
            this.controller = r2;
        }

        private String cb(String r2) {
            return r2 + HanziToPinyin.Token.SEPARATOR + this.controller.getPackageName() + HanziToPinyin.Token.SEPARATOR;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r4) {
            if (D.BUG == false) goto L5;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onAudioInfoChanged") + Util.playbackInfoToString(r4) + " sentRemote=" + this.sentRemote);
        L5:
            boolean r0 = MediaSessions.access$300(r4);
            if (r0 == false) goto L8;
        L10:
            if (r0 == false) goto L14;
            MediaSessions.access$500(this.this$0, this.controller.getSessionToken(), this.name, r4);
            this.sentRemote = true;
            return;
        L14:
            return;
        L8:
            if (this.sentRemote == false) goto L10;
            MediaSessions.access$400(this.this$0).onRemoteRemoved(this.controller.getSessionToken());
            this.sentRemote = false;
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r4) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onExtrasChanged") + r4);
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r4) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onMetadataChanged") + Util.mediaMetadataToString(r4));
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r4) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onPlaybackStateChanged") + Util.playbackStateToString(r4));
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r4) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onQueueChanged") + r4);
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r4) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onQueueTitleChanged") + r4);
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onSessionDestroyed"));
            return;
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r4, Bundle r5) {
            if (D.BUG == false) goto L6;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(MediaSessions.access$200(), cb("onSessionEvent") + "event=" + r4 + " extras=" + r5);
            return;
        }
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    static /* synthetic */ boolean access$300(MediaController.PlaybackInfo r0) {
        return isRemote(r0);
    }

    static /* synthetic */ Callbacks access$400(MediaSessions r0) {
        return r0.mCallbacks;
    }

    static /* synthetic */ void access$500(MediaSessions r0, MediaSession.Token r1, String r2, MediaController.PlaybackInfo r3) {
        r0.updateRemoteH(r1, r2, r3);
    }

    static /* synthetic */ H access$600(MediaSessions r0) {
        return r0.mHandler;
    }

    static /* synthetic */ MediaSessionManager access$700(MediaSessions r0) {
        return r0.mMgr;
    }

    static /* synthetic */ void access$800(MediaSessions r0, MediaSession.Token r1, int r2) {
        r0.onRemoteVolumeChangedH(r1, r2);
    }

    static /* synthetic */ void access$900(MediaSessions r0, MediaSession.Token r1) {
        r0.onUpdateRemoteSessionListH(r1);
    }

    static {
        TAG = Util.logTag(MediaSessions.class);
    }

    public MediaSessions(Context r3, Looper r4, Callbacks r5) {
        this.mRecords = new HashMap();
        this.mSessionsListener = new AnonymousClass1(this);
        this.mRemoteSessionCallback = new AnonymousClass2(this);
        this.mContext = r3;
        H r0 = new H(this, r4, null);
        this.mHandler = r0;
        this.mHandlerExecutor = new HandlerExecutor(r0);
        this.mMgr = (MediaSessionManager) r3.getSystemService("media_session");
        this.mCallbacks = r5;
    }

    public void dump(PrintWriter r3) {
        r3.println(getClass().getSimpleName() + " state:");
        r3.print("  mInit: ");
        r3.println(this.mInit);
        r3.print("  mRecords.size: ");
        r3.println(this.mRecords.size());
        Iterator<MediaControllerRecord> r2 = this.mRecords.values().iterator();
        int r0 = 0;
    L4:
        if (r2.hasNext() == false) goto L6;
        r0 = r0 + 1;
        dump(r0, r3, r2.next().controller);
        goto L4
    }

    public void init() {
        if (D.BUG == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "init");
    L5:
        this.mMgr.addOnActiveSessionsChangedListener(this.mSessionsListener, null, this.mHandler);
        this.mInit = true;
        postUpdateSessions();
        this.mMgr.registerRemoteSessionCallback(this.mHandlerExecutor, this.mRemoteSessionCallback);
    }

    protected void postUpdateSessions() {
        if (this.mInit == true) goto L5;
        return;
    L5:
        this.mHandler.sendEmptyMessage(1);
    }

    public void destroy() {
        if (D.BUG == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "destroy");
    L5:
        this.mInit = false;
        this.mMgr.removeOnActiveSessionsChangedListener(this.mSessionsListener);
        this.mMgr.unregisterRemoteSessionCallback(this.mRemoteSessionCallback);
    }

    public void setVolume(MediaSession.Token r3, int r4) {
        MediaControllerRecord r2 = this.mRecords.get(r3);
        if (r2 != null) goto L7;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "setVolume: No record found for token " + r3);
        return;
    L7:
        if (D.BUG == false) goto L9;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Setting level to " + r4);
    L9:
        r2.controller.setVolumeTo(r4, 0);
    }

    private void onRemoteVolumeChangedH(MediaSession.Token r4, int r5) {
        MediaController r0 = new MediaController(this.mContext, r4);
        if (D.BUG == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "remoteVolumeChangedH " + r0.getPackageName() + HanziToPinyin.Token.SEPARATOR + Util.audioManagerFlagsToString(r5));
    L5:
        this.mCallbacks.onRemoteVolumeChanged(r0.getSessionToken(), r5);
    }

    private void onUpdateRemoteSessionListH(MediaSession.Token r4) {
        String r0 = null;
        if (r4 == null) goto L5;
        MediaController r1 = new MediaController(this.mContext, r4);
    L6:
        if (r1 == null) goto L9;
        r0 = r1.getPackageName();
    L9:
        if (D.BUG == false) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onUpdateRemoteSessionListH " + r0);
    L11:
        postUpdateSessions();
        return;
    L5:
        r1 = null;
        goto L6
    }

    protected void onActiveSessionsUpdatedH(List<MediaController> r7) {
        if (D.BUG == false) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "onActiveSessionsUpdatedH n=" + r7.size());
    L5:
        HashSet r0 = new HashSet(this.mRecords.keySet());
        Iterator<MediaController> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L14;
        MediaController r1 = r8.next();
        MediaSession.Token r2 = r1.getSessionToken();
        MediaController.PlaybackInfo r3 = r1.getPlaybackInfo();
        r0.remove(r2);
        if (this.mRecords.containsKey(r2) == true) goto L11;
        MediaControllerRecord r4 = new MediaControllerRecord(this, r1, null);
        r4.name = getControllerName(r1);
        this.mRecords.put(r2, r4);
        r1.registerCallback(r4, this.mHandler);
    L11:
        MediaControllerRecord r5 = this.mRecords.get(r2);
        if (isRemote(r3) == false) goto L7;
        updateRemoteH(r2, r5.name, r3);
        r5.sentRemote = true;
        goto L7
    L14:
        Iterator r9 = r0.iterator();
    L16:
        if (r9.hasNext() == false) goto L23;
        MediaSession.Token r6 = (MediaSession.Token) r9.next();
        MediaControllerRecord r10 = this.mRecords.get(r6);
        r10.controller.unregisterCallback(r10);
        this.mRecords.remove(r6);
        if (D.BUG == false) goto L21;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Removing " + r10.name + " sentRemote=" + r10.sentRemote);
    L21:
        if (r10.sentRemote == false) goto L16;
        this.mCallbacks.onRemoteRemoved(r6);
        r10.sentRemote = false;
        goto L16
    }

    private static boolean isRemote(MediaController.PlaybackInfo r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r1.getPlaybackType() != 2) goto L6;
        return true;
    }

    protected String getControllerName(MediaController r2) {
        PackageManager r1 = this.mContext.getPackageManager();
        String r3 = r2.getPackageName();
        String r4 = Objects.toString(r1.getApplicationInfo(r3, 0).loadLabel(r1), "").trim();     // Catch: PackageManager.NameNotFoundException -> L7
        if (r4.length() <= 0) goto L6;
        return r4;
    L6:
        return r3;
    }

    private void updateRemoteH(MediaSession.Token r1, String r2, MediaController.PlaybackInfo r3) {
        Callbacks r0 = this.mCallbacks;
        if (r0 == null) goto L6;
        r0.onRemoteUpdate(r1, r2, r3);
        return;
    }

    private static void dump(int r10, PrintWriter r11, MediaController r12) {
        r11.println("  Controller " + r10 + ": " + r12.getPackageName());
        Bundle r13 = r12.getExtras();
        long r0 = r12.getFlags();
        MediaMetadata r2 = r12.getMetadata();
        MediaController.PlaybackInfo r3 = r12.getPlaybackInfo();
        PlaybackState r4 = r12.getPlaybackState();
        List<MediaSession.QueueItem> r5 = r12.getQueue();
        CharSequence r6 = r12.getQueueTitle();
        int r7 = r12.getRatingType();
        PendingIntent r14 = r12.getSessionActivity();
        r11.println("    PlaybackState: " + Util.playbackStateToString(r4));
        r11.println("    PlaybackInfo: " + Util.playbackInfoToString(r3));
        if (r2 == null) goto L5;
        r11.println("  MediaMetadata.desc=" + r2.getDescription());
    L5:
        r11.println("    RatingType: " + r7);
        r11.println("    Flags: " + r0);
        if (r13 == null) goto L11;
        r11.println("    Extras:");
        Iterator<String> r1 = r13.keySet().iterator();
    L9:
        if (r1.hasNext() == false) goto L11;
        String r8 = r1.next();
        r11.println("      " + r8 + "=" + r13.get(r8));
    L11:
        if (r6 == null) goto L13;
        r11.println("    QueueTitle: " + r6);
    L13:
        if (r5 != null) goto L15;
    L20:
        if (r3 == null) goto L25;
        r11.println("    sessionActivity: " + r14);
        return;
    L25:
        return;
    L15:
        if (r5.isEmpty() == true) goto L20;
        r11.println("    Queue:");
        Iterator<MediaSession.QueueItem> r15 = r5.iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        r11.println("      " + r15.next());
        goto L18
    }
}
