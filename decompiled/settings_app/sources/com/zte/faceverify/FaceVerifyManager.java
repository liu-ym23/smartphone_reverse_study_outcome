package com.zte.faceverify;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class FaceVerifyManager {
    public static final String AUTHORITY = "com.zte.faceverify";
    public static final Uri AUTHORITY_URI = null;
    public static final String BASE_URL = "content://com.zte.faceverify/";
    private static int ERROR_RESULT_CODE_KILL_SERVICE = 0;
    public static final String FACE_FOR_APPLOCK = "face_for_applock";
    public static final String FACE_FOR_HAS_FACE = "face_for_has_face";
    public static final String FACE_FOR_SCREEN_DIRECT = "face_for_screen_direct";
    public static final String FACE_FOR_SCREEN_NOTIFICATION = "face_for_notification";
    public static final String FACE_FOR_SCREEN_SLIDE = "face_for_screen_slide";
    public static final String FACE_FOR_SECRET = "face_for_secret";
    public static final int FACE_FOR_SECURITY_HIGH = 0;
    public static final String FACE_FOR_SECURITY_LEVEL = "face_for_security_level";
    public static final int FACE_FOR_SECURITY_NORMAL = 1;
    public static final int HELP_RESULT_CODE_FOR_AUTHEN = 1;
    public static final int HELP_RESULT_CODE_FOR_CAMERA_OPEN_FAILED = 8;
    public static final int HELP_RESULT_CODE_FOR_LIGHT_DIM = 16;
    public static final int HELP_RESULT_CODE_FOR_REPEATED_AUTH = 4;
    public static final int HELP_RESULT_CODE_FOR_WAKEUP = 0;
    public static final String PATH_APPLOCK = "applock";
    public static final String PATH_COUNT = "count";
    public static final String PATH_DISABLE_UNLOCK_SCREEN = "disable_unlock_screen";
    public static final String PATH_EYES_CLOSED_DETECTION = "eyes_closed_detection";
    public static final String PATH_GESTURE = "gesture";
    public static final String PATH_HAS_FACE = "enroll_face";
    public static final String PATH_LIGHT = "light";
    public static final String PATH_NOTIFICATION = "notification";
    public static final String PATH_SCREEN_DIRECT = "screen_direct";
    public static final String PATH_SCREEN_SLIDE = "screen_slide";
    public static final String PATH_SECRET = "secret";
    public static final String PATH_UNDER_SCREEN_ANIMATION = "under_screen_animation";
    private final String TAG;
    private final IBinder.DeathRecipient deathRecipient;
    private final Object mAuthLock;
    private AuthenticationCallback mAuthenticationCallback;
    private final AtomicBoolean mCanceled;
    private final Context mContext;
    private IFaceVerifyService mIFaceVerifyService;
    private final IFaceVerifyServiceReceiverBinder mIFaceVerifyServiceReceiverBinder;
    private CountDownLatch mLatch;
    private final Handler mMainHandler;
    private final String mPackageName;
    private volatile boolean mServiceConnected;
    private final ServiceConnection mServiceConnection;
    private int mServiceDeadCount;
    private final ContentObserver mSettingsObserver;
    private final Handler mWorkHandler;

    /* JADX INFO: renamed from: com.zte.faceverify.FaceVerifyManager$1, reason: invalid class name */
    class AnonymousClass1 extends ContentObserver {
        final /* synthetic */ FaceVerifyManager this$0;

        AnonymousClass1(FaceVerifyManager r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " face settings has changed");
            if (FaceVerifyManager.access$200(this.this$0) == false) goto L5;
            FaceVerifyManager.access$300(this.this$0).post(new FaceVerifyManager$1$$ExternalSyntheticLambda0(this));
            return;
        L5:
            FaceVerifyManager.access$300(this.this$0).post(new FaceVerifyManager$1$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-zte-faceverify-FaceVerifyManager$1, reason: not valid java name */
        /* synthetic */ void m1491lambda$onChange$0$comztefaceverifyFaceVerifyManager$1() {
            FaceVerifyManager.access$500(this.this$0);
        }

        /* JADX INFO: renamed from: lambda$onChange$1$com-zte-faceverify-FaceVerifyManager$1, reason: not valid java name */
        /* synthetic */ void m1492lambda$onChange$1$comztefaceverifyFaceVerifyManager$1() {
            FaceVerifyManager.access$400(this.this$0);
        }
    }

    /* JADX INFO: renamed from: com.zte.faceverify.FaceVerifyManager$2, reason: invalid class name */
    class AnonymousClass2 implements IBinder.DeathRecipient {
        final /* synthetic */ FaceVerifyManager this$0;

        AnonymousClass2(FaceVerifyManager r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            FaceVerifyManager.access$608(this.this$0);
            if (FaceVerifyManager.access$700(this.this$0) == null) goto L5;
            FaceVerifyManager.access$700(this.this$0).onAuthenticationError(FaceVerifyManager.access$800(), null);
        L5:
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " binderDied to unbindService:" + FaceVerifyManager.access$900(this.this$0));
            if (FaceVerifyManager.access$900(this.this$0) == false) goto L9;
            FaceVerifyManager.access$902(this.this$0, false);
            FaceVerifyManager.access$300(this.this$0).post(new FaceVerifyManager$2$$ExternalSyntheticLambda0(this));
        L9:
            if (FaceVerifyManager.access$600(this.this$0) < 5) goto L11;
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " dead 5 times do not bind service again");
            return;
        L11:
            if (FaceVerifyManager.access$200(this.this$0) == false) goto L15;
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " rebind service,mServiceDeadCount: " + FaceVerifyManager.access$600(this.this$0));
            FaceVerifyManager.access$300(this.this$0).postDelayed(new FaceVerifyManager$2$$ExternalSyntheticLambda1(this), 300);
            return;
        }

        /* JADX INFO: renamed from: lambda$binderDied$0$com-zte-faceverify-FaceVerifyManager$2, reason: not valid java name */
        /* synthetic */ void m1493lambda$binderDied$0$comztefaceverifyFaceVerifyManager$2() {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " unbind service after binderDied");
            FaceVerifyManager.access$1100(this.this$0).unbindService(FaceVerifyManager.access$1000(this.this$0));     // Catch: Exception -> L5
        L7:
            FaceVerifyManager.access$1200(this.this$0);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        /* JADX INFO: renamed from: lambda$binderDied$1$com-zte-faceverify-FaceVerifyManager$2, reason: not valid java name */
        /* synthetic */ void m1494lambda$binderDied$1$comztefaceverifyFaceVerifyManager$2() {
            FaceVerifyManager.access$500(this.this$0);
        }
    }

    public interface AuthenticationCallback {
        void onAuthenticationError(int r1, String r2);

        void onAuthenticationFailed();

        void onAuthenticationHelp(int r1, String r2);

        void onAuthenticationSucceeded(int r1);
    }

    private class IFaceVerifyServiceReceiverBinder extends IFaceVerifyServiceReceiver.Stub {
        final /* synthetic */ FaceVerifyManager this$0;

        private IFaceVerifyServiceReceiverBinder(FaceVerifyManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ IFaceVerifyServiceReceiverBinder(FaceVerifyManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationSucceeded(final int r3) throws RemoteException {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " on AuthenticationSucceeded");
            FaceVerifyManager.access$1700(this.this$0).post(new FaceVerifyManager$IFaceVerifyServiceReceiverBinder$$ExternalSyntheticLambda3(this, r3));
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationSucceeded$0$com-zte-faceverify-FaceVerifyManager$IFaceVerifyServiceReceiverBinder, reason: not valid java name */
        /* synthetic */ void m1498xecb6b61a(int r2) {
            if (FaceVerifyManager.access$700(this.this$0) == null) goto L6;
            FaceVerifyManager.access$700(this.this$0).onAuthenticationSucceeded(r2);
            return;
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationFailed() throws RemoteException {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " on authenticationFailed");
            FaceVerifyManager.access$1700(this.this$0).post(new FaceVerifyManager$IFaceVerifyServiceReceiverBinder$$ExternalSyntheticLambda1(this));
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationFailed$1$com-zte-faceverify-FaceVerifyManager$IFaceVerifyServiceReceiverBinder, reason: not valid java name */
        /* synthetic */ void m1496xcee84df() {
            if (FaceVerifyManager.access$700(this.this$0) == null) goto L6;
            FaceVerifyManager.access$700(this.this$0).onAuthenticationFailed();
            return;
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationError(final int r3, final String r4) throws RemoteException {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " on authenticationError errorCode=" + r3);
            FaceVerifyManager.access$1700(this.this$0).post(new FaceVerifyManager$IFaceVerifyServiceReceiverBinder$$ExternalSyntheticLambda2(this, r3, r4));
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationError$2$com-zte-faceverify-FaceVerifyManager$IFaceVerifyServiceReceiverBinder, reason: not valid java name */
        /* synthetic */ void m1495xdc0e3343(int r2, String r3) {
            if (FaceVerifyManager.access$700(this.this$0) == null) goto L6;
            FaceVerifyManager.access$700(this.this$0).onAuthenticationError(r2, r3);
            return;
        }

        @Override // com.zte.faceverify.IFaceVerifyServiceReceiver
        public void onAuthenticationHelp(final int r3, final String r4) throws RemoteException {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " on authenticationHelp helpCode=" + r3);
            FaceVerifyManager.access$1700(this.this$0).post(new FaceVerifyManager$IFaceVerifyServiceReceiverBinder$$ExternalSyntheticLambda0(this, r3, r4));
        }

        /* JADX INFO: renamed from: lambda$onAuthenticationHelp$3$com-zte-faceverify-FaceVerifyManager$IFaceVerifyServiceReceiverBinder, reason: not valid java name */
        /* synthetic */ void m1497x5f0d5765(int r2, String r3) {
            if (FaceVerifyManager.access$700(this.this$0) == null) goto L6;
            FaceVerifyManager.access$700(this.this$0).onAuthenticationHelp(r2, r3);
            return;
        }
    }

    class MyServiceConnection implements ServiceConnection {
        final /* synthetic */ FaceVerifyManager this$0;

        MyServiceConnection(FaceVerifyManager r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r3, IBinder r4) {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " onServiceConnected");
            FaceVerifyManager.access$602(this.this$0, 0);
            FaceVerifyManager.access$902(this.this$0, true);
            Object r5 = FaceVerifyManager.access$1300(this.this$0);
            monitor-enter(r5);
            FaceVerifyManager.access$1402(this.this$0, IFaceVerifyService.Stub.asInterface(r4));     // Catch: Throwable -> L15
            FaceVerifyManager.access$1400(this.this$0).asBinder().linkToDeath(FaceVerifyManager.access$1500(this.this$0), 0);     // Catch: RemoteException -> L7 Throwable -> L15
        L9:
            FaceVerifyManager.access$1300(this.this$0).notify();     // Catch: Throwable -> L15
            monitor-exit(r5);     // Catch: Throwable -> L15
            if (FaceVerifyManager.access$1600(this.this$0) == null) goto L22;
            FaceVerifyManager.access$1600(this.this$0).countDown();
            return;
        L22:
            return;
        L7:
            e = move-exception;
            FaceVerifyManager.access$1402(this.this$0, null);     // Catch: Throwable -> L15
            e.printStackTrace();     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            throw th;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r2) {
            Log.i("FaceVerifyManager", FaceVerifyManager.access$100(this.this$0) + " onServiceDisconnected");
            FaceVerifyManager.access$902(this.this$0, false);
        }
    }

    public static /* synthetic */ void $r8$lambda$EhPIc8AsJHXpqG8hiix5leXwbwQ(FaceVerifyManager r0) {
        r0.unbindService();
    }

    public static /* synthetic */ void $r8$lambda$m8LORZ6Z6LCcOsVqNuX1gRHqk4E(FaceVerifyManager r0) {
        r0.bindService();
    }

    static /* synthetic */ String access$100(FaceVerifyManager r0) {
        return r0.mPackageName;
    }

    static /* synthetic */ ServiceConnection access$1000(FaceVerifyManager r0) {
        return r0.mServiceConnection;
    }

    static /* synthetic */ Context access$1100(FaceVerifyManager r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$1200(FaceVerifyManager r0) {
        r0.unlinkToDeath();
    }

    static /* synthetic */ Object access$1300(FaceVerifyManager r0) {
        return r0.mAuthLock;
    }

    static /* synthetic */ IFaceVerifyService access$1400(FaceVerifyManager r0) {
        return r0.mIFaceVerifyService;
    }

    static /* synthetic */ IFaceVerifyService access$1402(FaceVerifyManager r0, IFaceVerifyService r1) {
        r0.mIFaceVerifyService = r1;
        return r1;
    }

    static /* synthetic */ IBinder.DeathRecipient access$1500(FaceVerifyManager r0) {
        return r0.deathRecipient;
    }

    static /* synthetic */ CountDownLatch access$1600(FaceVerifyManager r0) {
        return r0.mLatch;
    }

    static /* synthetic */ Handler access$1700(FaceVerifyManager r0) {
        return r0.mMainHandler;
    }

    static /* synthetic */ boolean access$200(FaceVerifyManager r0) {
        return r0.shouldBindService();
    }

    static /* synthetic */ Handler access$300(FaceVerifyManager r0) {
        return r0.mWorkHandler;
    }

    static /* synthetic */ void access$400(FaceVerifyManager r0) {
        r0.unbindService();
    }

    static /* synthetic */ void access$500(FaceVerifyManager r0) {
        r0.bindService();
    }

    static /* synthetic */ int access$600(FaceVerifyManager r0) {
        return r0.mServiceDeadCount;
    }

    static /* synthetic */ int access$602(FaceVerifyManager r0, int r1) {
        r0.mServiceDeadCount = r1;
        return r1;
    }

    static /* synthetic */ int access$608(FaceVerifyManager r2) {
        int r0 = r2.mServiceDeadCount;
        r2.mServiceDeadCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ AuthenticationCallback access$700(FaceVerifyManager r0) {
        return r0.mAuthenticationCallback;
    }

    static /* synthetic */ int access$800() {
        return ERROR_RESULT_CODE_KILL_SERVICE;
    }

    static /* synthetic */ boolean access$900(FaceVerifyManager r0) {
        return r0.mServiceConnected;
    }

    static /* synthetic */ boolean access$902(FaceVerifyManager r0, boolean r1) {
        r0.mServiceConnected = r1;
        return r1;
    }

    static {
        AUTHORITY_URI = Uri.parse("content://com.zte.faceverify");
        ERROR_RESULT_CODE_KILL_SERVICE = 0;
    }

    public FaceVerifyManager(Context r8) {
        this.TAG = "FaceVerifyManager";
        this.mIFaceVerifyServiceReceiverBinder = new IFaceVerifyServiceReceiverBinder(this, null);
        this.mCanceled = new AtomicBoolean(false);
        this.mAuthLock = new Object();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mServiceConnection = new MyServiceConnection(this);
        this.mServiceDeadCount = 0;
        this.mServiceConnected = false;
        this.deathRecipient = new AnonymousClass2(this);
        Context r1 = r8.getApplicationContext();
        this.mContext = r1;
        String r9 = r8.getPackageName();
        this.mPackageName = r9;
        HandlerThread r3 = new HandlerThread("FaceVerifyManager");
        r3.start();
        Handler r4 = new Handler(r3.getLooper());
        this.mWorkHandler = r4;
        AnonymousClass1 r5 = new AnonymousClass1(this, r4);
        this.mSettingsObserver = r5;
        r1.getContentResolver().registerContentObserver(Settings.System.getUriFor(FACE_FOR_HAS_FACE), false, r5);
        r1.getContentResolver().registerContentObserver(Settings.System.getUriFor(PATH_DISABLE_UNLOCK_SCREEN), false, r5);
        if (shouldBindService() == false) goto L5;
        r4.post(new FaceVerifyManager$$ExternalSyntheticLambda3(this));
    L5:
        Log.i("FaceVerifyManager", r9 + " init FaceVerifyManager");
    }

    private void unlinkToDeath() {
        Object r0 = this.mAuthLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mIFaceVerifyService == null) goto L10;
        Log.w("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService unlinkToDeath");     // Catch: Throwable -> L13
        this.mIFaceVerifyService.asBinder().unlinkToDeath(this.deathRecipient, 0);     // Catch: Exception -> L9 Throwable -> L13
    L9:
        Log.e("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService.asBinder().unlinkToDeath failed");     // Catch: Throwable -> L13
    L10:
        this.mIFaceVerifyService = null;     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
    }

    public void authenticate(final IBinder r13, final long r14, final int r16, AuthenticationCallback r17, final int r18, final String r19) {
        Log.i("FaceVerifyManager", this.mPackageName + " authenticate");
        this.mAuthenticationCallback = r17;
        Object r1 = this.mAuthLock;
        monitor-enter(r1);
        this.mCanceled.set(false);     // Catch: Throwable -> L19
        IFaceVerifyService r4 = this.mIFaceVerifyService;     // Catch: Throwable -> L19
        if (r4 != null) goto L23;
        monitor-exit(r1);     // Catch: Throwable -> L19
        if (shouldBindService() == true) goto L17;
        Log.i("FaceVerifyManager", this.mPackageName + " no need to bind service");
        return;
    L17:
        this.mWorkHandler.post(new FaceVerifyManager$$ExternalSyntheticLambda0(this, r13, r14, r16, r18, r19));
        return;
    L23:
        r4.authenticate(r13, r14, r16, this.mIFaceVerifyServiceReceiverBinder, r18, r19);     // Catch: RemoteException -> L8 Throwable -> L19
    L10:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$authenticate$1$com-zte-faceverify-FaceVerifyManager, reason: not valid java name */
    /* synthetic */ void m1490lambda$authenticate$1$comztefaceverifyFaceVerifyManager(IBinder r13, long r14, int r16, int r17, String r18) {
        Object r1 = this.mAuthLock;
        monitor-enter(r1);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (this.mIFaceVerifyService == null) goto L13;
        Log.i("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService is not null");     // Catch: Throwable -> L34
        this.mIFaceVerifyService.authenticate(r13, r14, r16, this.mIFaceVerifyServiceReceiverBinder, r17, r18);     // Catch: RemoteException -> L9 Throwable -> L34
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L34
        return;
    L9:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L34
        goto L11
    L13:
        monitor-exit(r1);     // Catch: Throwable -> L34
        bindService();
        Object r2 = this.mAuthLock;
        monitor-enter(r2);
    L31:
        th = move-exception;
        throw th;
    L17:
        if (this.mCanceled.get() == false) goto L21;
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L21:
        if (this.mIFaceVerifyService != null) goto L39;
        monitor-exit(r2);     // Catch: Throwable -> L31
        this.mMainHandler.post(new FaceVerifyManager$$ExternalSyntheticLambda1(this));
        return;
    L39:
        Log.i("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService.authenticate");     // Catch: Exception -> L24 Throwable -> L31
        this.mIFaceVerifyService.authenticate(r13, r14, r16, this.mIFaceVerifyServiceReceiverBinder, r17, r18);     // Catch: Exception -> L24 Throwable -> L31
    L26:
        monitor-exit(r2);     // Catch: Throwable -> L31
        return;
    L24:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L31
        goto L26
    }

    /* JADX INFO: renamed from: lambda$authenticate$0$com-zte-faceverify-FaceVerifyManager, reason: not valid java name */
    /* synthetic */ void m1489lambda$authenticate$0$comztefaceverifyFaceVerifyManager() {
        Log.w("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService == null duo to fail");
        AuthenticationCallback r2 = this.mAuthenticationCallback;
        if (r2 == null) goto L6;
        r2.onAuthenticationFailed();
        return;
    }

    public void cancelAuthentication(IBinder r4, String r5) {
        Log.d("FaceVerifyManager", this.mPackageName + " cancelAuthentication ");
        Object r0 = this.mAuthLock;
        monitor-enter(r0);
        this.mCanceled.set(true);     // Catch: Throwable -> L13
        IFaceVerifyService r1 = this.mIFaceVerifyService;     // Catch: Throwable -> L13
        if (r1 != null) goto L18;
    L10:
        this.mAuthenticationCallback = null;     // Catch: Throwable -> L13
        this.mAuthLock.notify();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L18:
        r1.cancelAuthentication(r4, r5);     // Catch: RemoteException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public boolean isSpecSwitchOpen(String r7) {
        int r0 = ActivityManager.getCurrentUser();
        r7.hashCode();
        boolean r3 = true;
        byte r5 = -1;
        switch(r7.hashCode()) {
            case -1402639880: goto L26;
            case -1336254434: goto L22;
            case -709101994: goto L18;
            case 595233003: goto L14;
            case 1093846812: goto L10;
            case 1423288496: goto L6;
            default: goto L29;
        };
    L29:
        switch(r5) {
            case 0: goto L49;
            case 1: goto L46;
            case 2: goto L41;
            case 3: goto L38;
            case 4: goto L35;
            case 5: goto L32;
            default: goto L30;
        };
    L30:
        boolean r1 = isEnable(r7);
    L51:
        Log.d("FaceVerifyManager", this.mPackageName + " isSpecSwitchOpen: " + r7 + " values: " + r1 + ", UserId:" + r0);
        return r1;
    L32:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), PATH_DISABLE_UNLOCK_SCREEN, 0, r0) != 0) goto L44;
    L43:
        r3 = false;
    L44:
        r1 = r3;
        goto L51
    L35:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), FACE_FOR_SCREEN_DIRECT, 0, r0) == 0) goto L43;
    L38:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), FACE_FOR_SCREEN_NOTIFICATION, 0, r0) == 0) goto L43;
    L41:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), FACE_FOR_HAS_FACE, 0, r0) == 0) goto L43;
    L46:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), FACE_FOR_SCREEN_SLIDE, 0, r0) == 0) goto L43;
    L49:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), r7, 1, r0) != 1) goto L43;
    L6:
        if (r7.equals(PATH_DISABLE_UNLOCK_SCREEN) == false) goto L29;
        r5 = 5;
        goto L29
    L10:
        if (r7.equals(PATH_SCREEN_DIRECT) == false) goto L29;
        r5 = 4;
        goto L29
    L14:
        if (r7.equals("notification") == false) goto L29;
        r5 = 3;
        goto L29
    L18:
        if (r7.equals(PATH_HAS_FACE) == false) goto L29;
        r5 = 2;
        goto L29
    L22:
        if (r7.equals(PATH_SCREEN_SLIDE) == false) goto L29;
        r5 = 1;
        goto L29
    L26:
        if (r7.equals(PATH_UNDER_SCREEN_ANIMATION) == false) goto L29;
        r5 = 0;
        goto L29
    }

    public void setSpecSwitchState(String r5, boolean r6, String r7) {
        Log.d("FaceVerifyManager", this.mPackageName + " setSpecSwitchState: " + r5 + ", state: " + r6 + ", " + r7);
        r5.hashCode();
        byte r3 = -1;
        switch(r5.hashCode()) {
            case -1336254434: goto L18;
            case 595233003: goto L14;
            case 1093846812: goto L10;
            case 1423288496: goto L6;
            default: goto L21;
        };
    L21:
        switch(r3) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            default: goto L22;
        };
    L22:
        updateIsOpenValue(r5, r6);
        return;
    L23:
        Settings.System.putInt(this.mContext.getContentResolver(), PATH_DISABLE_UNLOCK_SCREEN, r6 ? 1 : 0);
        return;
    L24:
        Settings.System.putInt(this.mContext.getContentResolver(), FACE_FOR_SCREEN_DIRECT, r6 ? 1 : 0);
        return;
    L25:
        updateIsOpenValue("notification", r6);
        Settings.System.putInt(this.mContext.getContentResolver(), FACE_FOR_SCREEN_NOTIFICATION, r6 ? 1 : 0);
        return;
    L26:
        updateIsOpenValue(PATH_SCREEN_SLIDE, r6);
        Settings.System.putInt(this.mContext.getContentResolver(), FACE_FOR_SCREEN_SLIDE, r6 ? 1 : 0);
        return;
    L6:
        if (r5.equals(PATH_DISABLE_UNLOCK_SCREEN) == false) goto L21;
        r3 = 3;
        goto L21
    L10:
        if (r5.equals(PATH_SCREEN_DIRECT) == false) goto L21;
        r3 = 2;
        goto L21
    L14:
        if (r5.equals("notification") == false) goto L21;
        r3 = 1;
        goto L21
    L18:
        if (r5.equals(PATH_SCREEN_SLIDE) == false) goto L21;
        r3 = 0;
        goto L21
    }

    private boolean isEnable(String r3) {
        return "true".equals(this.mContext.getContentResolver().getType(Uri.parse(BASE_URL + r3)));
    }

    private void updateIsOpenValue(String r3, boolean r4) {
        ContentValues r0 = new ContentValues();
        r0.put("isOpen", Boolean.valueOf(r4));
        this.mContext.getContentResolver().update(Uri.parse(BASE_URL + r3), r0, null, null);
    }

    private boolean shouldBindService() {
        if (isSpecSwitchOpen(PATH_HAS_FACE) == true) goto L7;
        Log.i("FaceVerifyManager", this.mPackageName + " has no face");
        return false;
    L7:
        if ("com.android.systemui".equals(this.mPackageName) == true) goto L9;
        return true;
    L9:
        if (isSpecSwitchOpen(PATH_DISABLE_UNLOCK_SCREEN) == false) goto L14;
        Log.i("FaceVerifyManager", this.mPackageName + " has disabled unlock screen");
        return false;
    L14:
        return true;
    }

    private void bindService() {
        if (this.mServiceConnected == false) goto L7;
        Log.i("FaceVerifyManager", this.mPackageName + " has bound to service");
        return;
    L7:
        if (this.mLatch == null) goto L10;
        Log.i("FaceVerifyManager", this.mPackageName + " binding to service");
        return;
    L10:
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(AUTHORITY, "com.zte.faceverify.FaceVerifyService"));
        if (this.mContext.getPackageManager().resolveService(r0, 0) != null) goto L14;
        Log.i("FaceVerifyManager", this.mPackageName + " no FaceVerifyService detected");
        return;
    L14:
        boolean r1 = this.mContext.bindService(r0, this.mServiceConnection, 1);
        Log.i("FaceVerifyManager", this.mPackageName + " start bind to service success:" + r1);
        if (r1 == false) goto L24;
        CountDownLatch r2 = new CountDownLatch(1);
        this.mLatch = r2;
        r2.await(2, TimeUnit.SECONDS);     // Catch: InterruptedException -> L19
        this.mLatch = null;     // Catch: InterruptedException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private void unbindService() {
        if (this.mServiceConnected == false) goto L13;
        this.mServiceConnected = false;
        Log.i("FaceVerifyManager", this.mPackageName + " unbind service");
        this.mContext.unbindService(this.mServiceConnection);     // Catch: Exception -> L7
    L9:
        unlinkToDeath();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public int getFaceCount() {
        Log.i("FaceVerifyManager", this.mPackageName + " getFaceCount");
        return "true".equals(this.mContext.getContentResolver().getType(Uri.parse("content://com.zte.faceverify/count"))) ? 1 : 0;
    }

    public void releaseResource() {
        this.mWorkHandler.post(new FaceVerifyManager$$ExternalSyntheticLambda2(this));
        if (this.mSettingsObserver == null) goto L6;
        this.mContext.getContentResolver().unregisterContentObserver(this.mSettingsObserver);
    L6:
        if (this.mAuthenticationCallback == null) goto L8;
        this.mAuthenticationCallback = null;
    L8:
        this.mWorkHandler.getLooper().quitSafely();
    }

    public void updateMultiAuthenticator() {
        Object r0 = this.mAuthLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mIFaceVerifyService == null) goto L10;
        Log.i("FaceVerifyManager", this.mPackageName + " updateMultiAuthenticator");     // Catch: Throwable -> L13
        this.mIFaceVerifyService.updateMultiAuthenticator();     // Catch: RemoteException -> L9 Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L9:
        Log.w("FaceVerifyManager", this.mPackageName + " updateMultiAuthenticator failed, remote error");     // Catch: Throwable -> L13
        goto L11
    L10:
        Log.w("FaceVerifyManager", this.mPackageName + " mIFaceVerifyService is null");     // Catch: Throwable -> L13
        goto L11
    }
}
