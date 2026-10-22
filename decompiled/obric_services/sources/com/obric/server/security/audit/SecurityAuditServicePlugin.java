package com.obric.server.security.audit;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.obric.server.security.IObricSecurityPlugin;

/* JADX INFO: loaded from: classes.dex */
public class SecurityAuditServicePlugin implements IObricSecurityPlugin {
    private static final long CLEANUP_INTERVAL_MS = 300000;
    public static final IObricSecurityPlugin.Creator CREATOR = null;
    private static final long KEEP_DURATION_MS = 5184000000L;
    private static final String TAG = "SecurityAuditServicePlugin";
    private final Runnable mCleanupTask;
    private final Context mContext;
    private AuditDbHelper mDbHelper;
    private SecurityAuditManagerService mManagerService;
    private AuditRepository mRepository;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;

    /* JADX INFO: renamed from: -$$Nest$fgetmRepository, reason: not valid java name */
    static /* bridge */ /* synthetic */ AuditRepository m92$$Nest$fgetmRepository(SecurityAuditServicePlugin r0) {
        return r0.mRepository;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorkerHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m93$$Nest$fgetmWorkerHandler(SecurityAuditServicePlugin r0) {
        return r0.mWorkerHandler;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public SecurityAuditServicePlugin(Context context) {
        this.mCleanupTask = new AnonymousClass2(this);
        this.mContext = context;
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStart() {
        Log.i(TAG, "onStart: init worker thread and database.");
        this.mWorkerThread = new HandlerThread("SecurityAuditWorker");
        this.mWorkerThread.start();
        this.mWorkerHandler = new Handler(this.mWorkerThread.getLooper());
        this.mDbHelper = new AuditDbHelper(this.mContext);
        this.mRepository = new AuditRepository(this.mDbHelper, this.mWorkerHandler);
        final MerkleIntegrityManager integrityManager = new MerkleIntegrityManager(this.mContext);
        this.mRepository.setIntegrityManager(integrityManager);
        this.mWorkerHandler.post(new AnonymousClass3(this, integrityManager));
        this.mManagerService = new SecurityAuditManagerService(this.mContext, this.mRepository, this.mWorkerHandler);
        this.mWorkerHandler.postDelayed(this.mCleanupTask, CLEANUP_INTERVAL_MS);
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public void onStop() {
        Log.i(TAG, "onStop");
        if (this.mWorkerHandler == null) goto L6;
        this.mWorkerHandler.removeCallbacks(this.mCleanupTask);
    L6:
        if (this.mWorkerThread == null) goto L9;
        this.mWorkerThread.quitSafely();
        this.mWorkerThread = null;
        this.mWorkerHandler = null;
        return;
    }

    @Override // com.obric.server.security.IObricSecurityPlugin
    public IBinder asBinder() {
        return this.mManagerService;
    }
}
