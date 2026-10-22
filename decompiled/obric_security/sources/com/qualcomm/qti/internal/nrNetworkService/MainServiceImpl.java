package com.qualcomm.qti.internal.nrNetworkService;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionCallback;
import com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface;
import com.qualcomm.qti.internal.nrNetworkService.hidl.QtiRadioHidlClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.codeaurora.internal.BearerAllocationStatus;
import org.codeaurora.internal.Client;
import org.codeaurora.internal.DcParam;
import org.codeaurora.internal.INetworkCallback;
import org.codeaurora.internal.NrConfig;
import org.codeaurora.internal.NrConfigType;
import org.codeaurora.internal.NrIconType;
import org.codeaurora.internal.SignalStrength;
import org.codeaurora.internal.Status;
import org.codeaurora.internal.Token;
import org.codeaurora.internal.UpperLayerIndInfo;

/* JADX INFO: loaded from: classes4.dex */
public class MainServiceImpl {
    private static final int EVENT_ON_5G_CONFIG_INFO = 6;
    private static final int EVENT_ON_5G_ENABLE_STATUS_CHANGE_IND = 1;
    private static final int EVENT_ON_5G_SIGNAL_STRENGTH_CHANGE_IND = 2;
    private static final int EVENT_ON_BEARER_ALLOCATION_CHANGE_IND = 0;
    private static final int EVENT_ON_ENABLE_ENDC = 8;
    private static final int EVENT_ON_ENDC_STATUS = 9;
    private static final int EVENT_ON_NR_CONFIG_STATUS = 11;
    private static final int EVENT_ON_NR_DUAL_CONNECTIVITY_CHANGE_IND = 3;
    private static final int EVENT_ON_NR_ICON_TYPE = 7;
    private static final int EVENT_ON_RESTRICT_DCNR_CHANGE = 4;
    private static final int EVENT_ON_SET_NR_CONFIG = 10;
    private static final int EVENT_ON_UPPER_LAYER_INDICATION_INFO = 5;
    private static final String TAG = "MainServiceImpl";
    private static Context mContext;
    private static MainServiceImpl sInstance;
    private boolean FAILED;
    private boolean SUCCESS;
    private AppOpsManager mAppOpsManager;
    private final ArrayList<INetworkCallback> mCallbackList;
    private int mClientIndex;
    IHidlConnectionCallback mHidlConnectionCallback;
    private IHidlConnectionInterface mHidlConnectionInterface;
    private ConcurrentHashMap<Integer, Transaction> mInflightRequests;
    private HandlerThread mWorkerThread;
    private Handler mWorkerThreadHandler;

    class ClientBinderDeathRecipient implements IBinder.DeathRecipient {
        INetworkCallback mCallback;
        final /* synthetic */ MainServiceImpl this$0;

        public ClientBinderDeathRecipient(MainServiceImpl r2, INetworkCallback r3) {
            this.this$0 = r2;
            Log.d(MainServiceImpl.TAG, "registering for client cb = " + r3 + " binder = " + r3.asBinder() + " death notification");
            this.mCallback = r3;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.d(MainServiceImpl.TAG, "Client callback = " + this.mCallback + " binder = " + this.mCallback.asBinder() + "died");
            this.mCallback.asBinder().unlinkToDeath(this, 0);
            this.this$0.unRegisterCallback(this.mCallback);     // Catch: RemoteException -> L5
            return;
        L5:
            Log.d(MainServiceImpl.TAG, "Exception while unregistering callback = " + this.mCallback + " binder = " + this.mCallback.asBinder());
        }
    }

    class Result {
        Object mData;
        Status mStatus;
        Token mToken;
        final /* synthetic */ MainServiceImpl this$0;

        public Result(MainServiceImpl r1, Token r2, Status r3, Object r4) {
            this.this$0 = r1;
            this.mToken = r2;
            this.mStatus = r3;
            this.mData = r4;
        }

        public String toString() {
            return "Result{mToken=" + this.mToken + ", mStatus=" + this.mStatus + ", mData=" + this.mData + '}';
        }
    }

    class Transaction {
        Client mClient;
        String mName;
        Token mToken;
        final /* synthetic */ MainServiceImpl this$0;

        public Transaction(MainServiceImpl r1, Token r2, String r3, Client r4) {
            this.this$0 = r1;
            this.mToken = r2;
            this.mName = r3;
            this.mClient = r4;
        }

        public String toString() {
            return "Transaction{mToken=" + this.mToken + ", mName='" + this.mName + "', mClient=" + this.mClient + '}';
        }
    }

    private class WorkerHandler extends Handler {
        private static final String TAG = "MainServiceImplHandler: ";
        final /* synthetic */ MainServiceImpl this$0;

        public WorkerHandler(MainServiceImpl r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            Log.d(TAG, "handleMessage msg.what = " + r4.what);
            switch(r4.what) {
                case 0: goto L15;
                case 1: goto L14;
                case 2: goto L13;
                case 3: goto L12;
                case 4: goto L27;
                case 5: goto L11;
                case 6: goto L10;
                case 7: goto L9;
                case 8: goto L8;
                case 9: goto L7;
                case 10: goto L6;
                case 11: goto L5;
                default: goto L27;
            };
        L5:
            Log.d(TAG, "EVENT_ON_NR_CONFIG_STATUS");
            int r0 = r4.arg1;
            Result r5 = (Result) r4.obj;
            this.this$0.onNrConfigStatus(r0, r5.mToken, r5.mStatus, (NrConfig) r5.mData);
            return;
        L6:
            Log.d(TAG, "EVENT_ON_SET_NR_CONFIG");
            int r1 = r4.arg1;
            Result r6 = (Result) r4.obj;
            this.this$0.onSetNrConfig(r1, r6.mToken, r6.mStatus);
            return;
        L7:
            Log.d(TAG, "EVENT_ON_ENDC_STATUS");
            int r2 = r4.arg1;
            Result r7 = (Result) r4.obj;
            MainServiceImpl.m628$$Nest$monEndcStatus(this.this$0, r2, r7.mToken, r7.mStatus, ((Boolean) r7.mData).booleanValue());
            return;
        L8:
            Log.d(TAG, "EVENT_ON_ENABLE_ENDC");
            int r3 = r4.arg1;
            Result r8 = (Result) r4.obj;
            MainServiceImpl.m627$$Nest$monEnableEndc(this.this$0, r3, r8.mToken, r8.mStatus);
            return;
        L9:
            Log.d(TAG, "EVENT_ON_NR_ICON_TYPE");
            int r9 = r4.arg1;
            Result r10 = (Result) r4.obj;
            MainServiceImpl.m630$$Nest$monNrIconType(this.this$0, r9, r10.mToken, r10.mStatus, (NrIconType) r10.mData);
            return;
        L10:
            Log.d(TAG, "EVENT_ON_5G_CONFIG_INFO");
            int r11 = r4.arg1;
            Result r12 = (Result) r4.obj;
            MainServiceImpl.m624$$Nest$mon5gConfigInfo(this.this$0, r11, r12.mToken, r12.mStatus, (NrConfigType) r12.mData);
            return;
        L11:
            Log.d(TAG, "EVENT_ON_UPPER_LAYER_INDICATION_INFO");
            int r13 = r4.arg1;
            Result r14 = (Result) r4.obj;
            MainServiceImpl.m632$$Nest$monUpperLayerIndInfo(this.this$0, r13, r14.mToken, r14.mStatus, (UpperLayerIndInfo) r14.mData);
            return;
        L12:
            Log.d(TAG, "EVENT_ON_NR_DUAL_CONNECTIVITY_CHANGE_IND");
            int r15 = r4.arg1;
            Result r16 = (Result) r4.obj;
            MainServiceImpl.m629$$Nest$monNrDcParam(this.this$0, r15, r16.mToken, r16.mStatus, (DcParam) r16.mData);
            return;
        L13:
            Log.d(TAG, "EVENT_ON_5G_SIGNAL_STRENGTH_CHANGE_IND");
            int r17 = r4.arg1;
            Result r18 = (Result) r4.obj;
            MainServiceImpl.m631$$Nest$monSignalStrength(this.this$0, r17, r18.mToken, r18.mStatus, (SignalStrength) r18.mData);
            return;
        L14:
            Log.d(TAG, "EVENT_ON_5G_ENABLE_STATUS");
            int r19 = r4.arg1;
            Result r20 = (Result) r4.obj;
            MainServiceImpl.m625$$Nest$mon5gStatus(this.this$0, r19, r20.mToken, r20.mStatus, ((Boolean) r20.mData).booleanValue());
            return;
        L15:
            Log.d(TAG, "EVENT_ON_BEARER_ALLOCATION_CHANGE_IND");
            int r21 = r4.arg1;
            Result r22 = (Result) r4.obj;
            MainServiceImpl.m626$$Nest$monAnyNrBearerAllocation(this.this$0, r21, r22.mToken, r22.mStatus, (BearerAllocationStatus) r22.mData);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorkerThreadHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m623$$Nest$fgetmWorkerThreadHandler(MainServiceImpl r0) {
        return r0.mWorkerThreadHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mon5gConfigInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m624$$Nest$mon5gConfigInfo(MainServiceImpl r0, int r1, Token r2, Status r3, NrConfigType r4) {
        r0.on5gConfigInfo(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mon5gStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m625$$Nest$mon5gStatus(MainServiceImpl r0, int r1, Token r2, Status r3, boolean r4) {
        r0.on5gStatus(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monAnyNrBearerAllocation, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m626$$Nest$monAnyNrBearerAllocation(MainServiceImpl r0, int r1, Token r2, Status r3, BearerAllocationStatus r4) {
        r0.onAnyNrBearerAllocation(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monEnableEndc, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m627$$Nest$monEnableEndc(MainServiceImpl r0, int r1, Token r2, Status r3) {
        r0.onEnableEndc(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$monEndcStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m628$$Nest$monEndcStatus(MainServiceImpl r0, int r1, Token r2, Status r3, boolean r4) {
        r0.onEndcStatus(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monNrDcParam, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m629$$Nest$monNrDcParam(MainServiceImpl r0, int r1, Token r2, Status r3, DcParam r4) {
        r0.onNrDcParam(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monNrIconType, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m630$$Nest$monNrIconType(MainServiceImpl r0, int r1, Token r2, Status r3, NrIconType r4) {
        r0.onNrIconType(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monSignalStrength, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m631$$Nest$monSignalStrength(MainServiceImpl r0, int r1, Token r2, Status r3, SignalStrength r4) {
        r0.onSignalStrength(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$monUpperLayerIndInfo, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m632$$Nest$monUpperLayerIndInfo(MainServiceImpl r0, int r1, Token r2, Status r3, UpperLayerIndInfo r4) {
        r0.onUpperLayerIndInfo(r1, r2, r3, r4);
    }

    static {
    }

    public static MainServiceImpl init(Context r3) {
        monitor-enter(MainServiceImpl.class);
        mContext = r3;     // Catch: Throwable -> L11
        if (sInstance != null) goto L7;
        sInstance = new MainServiceImpl(r3);     // Catch: Throwable -> L11
    L8:
        MainServiceImpl r4 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(MainServiceImpl.class);     // Catch: Throwable -> L11
        return r4;
    L7:
        Log.wtf(TAG, "init() called multiple times!  sInstance = " + sInstance);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static MainServiceImpl getInstance() {
        if (sInstance != null) goto L6;
        Log.wtf(TAG, "getInstance null");
    L6:
        return sInstance;
    }

    public MainServiceImpl(Context r3) {
        this.SUCCESS = true;
        this.FAILED = false;
        this.mClientIndex = -1;
        this.mWorkerThread = new HandlerThread("MainServiceImplBgThread");
        this.mCallbackList = new ArrayList();
        this.mInflightRequests = new ConcurrentHashMap();
        this.mHidlConnectionCallback = new AnonymousClass1(this);
        Log.d(TAG, TAG);
        mContext = r3;
        this.mAppOpsManager = (AppOpsManager) r3.getSystemService("appops");
        setHidlClient(new QtiRadioHidlClient());
        this.mWorkerThread.start();
        setLooper(this.mWorkerThread.getLooper());
    }

    public MainServiceImpl(Context r3, IHidlConnectionInterface r4, Looper r5) {
        this.SUCCESS = true;
        this.FAILED = false;
        this.mClientIndex = -1;
        this.mWorkerThread = new HandlerThread("MainServiceImplBgThread");
        this.mCallbackList = new ArrayList();
        this.mInflightRequests = new ConcurrentHashMap();
        this.mHidlConnectionCallback = new AnonymousClass1(this);
        Log.d(TAG, TAG);
        mContext = r3;
        this.mAppOpsManager = (AppOpsManager) r3.getSystemService("appops");
        setHidlClient(r4);
        setLooper(r5);
    }

    public void setLooper(Looper r2) {
        this.mWorkerThreadHandler = new WorkerHandler(this, r2);
    }

    public void setHidlClient(IHidlConnectionInterface r1) {
        this.mHidlConnectionInterface = r1;
        r1.registerCallback(this.mHidlConnectionCallback);
    }

    public Token enable5g(int r6, Client r7) throws RemoteException {
        int r0 = Binder.getCallingUid();
        Log.d(TAG, "enable5g: slotId = " + r6 + " uid = " + r0 + " package=" + mContext.getPackageManager().getNameForUid(r0));
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r1 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r1.get()), new Transaction(this, r1, "Enable5g", r7));
        this.mHidlConnectionInterface.enable5g(r6, r1);
        return r1;
    }

    public Token disable5g(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "disable5g: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "disable5g", r7));
        this.mHidlConnectionInterface.disable5g(r6, r0);
        return r0;
    }

    public Token enable5gOnly(int r3, Client r4) throws RemoteException {
        Log.d(TAG, "enable5gOnly: slotId = " + r3);
        if (isClientValid(r4) == true) goto L7;
        return null;
    L7:
        throw new RemoteException("not implemented");
    }

    public Token query5gStatus(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "query5gStatus: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "query5gStatus", r7));
        this.mHidlConnectionInterface.query5gStatus(r6, r0);
        return r0;
    }

    public Token queryNrDcParam(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryNrDcParam: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryNrDcParam", r7));
        this.mHidlConnectionInterface.queryNrDcParam(r6, r0);
        return r0;
    }

    public Token queryNrBearerAllocation(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryNrBearerAllocation: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryNrBearerAllocation", r7));
        this.mHidlConnectionInterface.queryNrBearerAllocation(r6, r0);
        return r0;
    }

    public Token queryNrSignalStrength(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryNrSignalStrength: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryNrSignalStrength", r7));
        this.mHidlConnectionInterface.queryNrSignalStrength(r6, r0);
        return r0;
    }

    public Token queryUpperLayerIndInfo(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryUpperLayerIndInfo: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryUpperLayerIndInfo", r7));
        this.mHidlConnectionInterface.queryUpperLayerIndInfo(r6, r0);
        return r0;
    }

    public Token query5gConfigInfo(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "query5gConfigInfo: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "query5gConfigInfo", r7));
        this.mHidlConnectionInterface.query5gConfigInfo(r6, r0);
        return r0;
    }

    public Token queryNrIconType(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryNrIconType: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryNrIconType", r7));
        this.mHidlConnectionInterface.queryNrIconType(r6, r0);
        return r0;
    }

    public Token enableEndc(int r6, boolean r7, Client r8) throws RemoteException {
        Log.d(TAG, "enableEndc: slotId = " + r6);
        if (isClientValid(r8) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "enableEndc", r8));
        this.mHidlConnectionInterface.enableEndc(r6, r7, r0);
        return r0;
    }

    public Token queryEndcStatus(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryEndcStatus: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryEndcStatus", r7));
        this.mHidlConnectionInterface.queryEndcStatus(r6, r0);
        return r0;
    }

    public Token setNrConfig(int r6, NrConfig r7, Client r8) throws RemoteException {
        int r0 = Binder.getCallingUid();
        Log.d(TAG, "setNrConfig: slotId = " + r6 + " config = " + r7 + " uid = " + r0 + " package=" + mContext.getPackageManager().getNameForUid(r0));
        if (isClientValid(r8) == true) goto L6;
        return null;
    L6:
        Token r1 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r1.get()), new Transaction(this, r1, "setNrConfig", r8));
        this.mHidlConnectionInterface.setNrConfig(r6, r7, r1);
        return r1;
    }

    public Token queryNrConfig(int r6, Client r7) throws RemoteException {
        Log.d(TAG, "queryNrConfig: slotId = " + r6);
        if (isClientValid(r7) == true) goto L6;
        return null;
    L6:
        Token r0 = this.mHidlConnectionInterface.generateNextToken();
        this.mInflightRequests.put(Integer.valueOf(r0.get()), new Transaction(this, r0, "queryNrConfig", r7));
        this.mHidlConnectionInterface.queryNrConfig(r6, r0);
        return r0;
    }

    private boolean addCallback(INetworkCallback r5) {
        IBinder r0 = r5.asBinder();
        ArrayList<INetworkCallback> r1 = this.mCallbackList;
        monitor-enter(r1);
        Iterator<INetworkCallback> r2 = this.mCallbackList.iterator();     // Catch: Throwable -> L16
    L6:
        if (r2.hasNext() == false) goto L12;
        if (r2.next().asBinder().equals(r0) == false) goto L6;
        boolean r4 = this.FAILED;     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r4;
    L12:
        Log.d(TAG, "add callback= " + r5);     // Catch: Throwable -> L16
        this.mCallbackList.add(r5);     // Catch: Throwable -> L16
        monitor-exit(r1);     // Catch: Throwable -> L16
        return this.SUCCESS;
    L16:
        th = move-exception;
        throw th;
    }

    private void removeCallback(INetworkCallback r5) {
        IBinder r0 = r5.asBinder();
        Log.d(TAG, "removeCallback: callback= " + r5 + ", Binder = " + r0);
        ArrayList<INetworkCallback> r6 = this.mCallbackList;
        monitor-enter(r6);
        Iterator<INetworkCallback> r1 = this.mCallbackList.iterator();     // Catch: Throwable -> L14
    L6:
        if (r1.hasNext() == false) goto L12;
        INetworkCallback r2 = r1.next();     // Catch: Throwable -> L14
        if (r2.asBinder().equals(r0) == false) goto L6;
        Log.d(TAG, "remove callback= " + r2);     // Catch: Throwable -> L14
        this.mCallbackList.remove(r2);     // Catch: Throwable -> L14
        monitor-exit(r6);     // Catch: Throwable -> L14
        return;
    L12:
        monitor-exit(r6);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    private void removeClientFromInflightRequests(INetworkCallback r6) {
        Iterator<Integer> r0 = this.mInflightRequests.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        int r1 = r0.next().intValue();
        if (this.mInflightRequests.get(Integer.valueOf(r1)).mClient.getCallback().asBinder() != r6.asBinder()) goto L4;
        Log.d(TAG, "removeClientFromInflightRequests: Token = " + r1 + " => " + this.mInflightRequests.get(Integer.valueOf(r1)));
        this.mInflightRequests.remove(Integer.valueOf(r1));
        goto L4
    }

    private boolean isClientValid(Client r5) {
        if (r5 != null) goto L5;
    L23:
        Log.e(TAG, "Invalid client");
        return false;
    L5:
        if (r5.getCallback() == null) goto L23;
        ArrayList<INetworkCallback> r1 = this.mCallbackList;
        monitor-enter(r1);
        Iterator<INetworkCallback> r4 = this.mCallbackList.iterator();     // Catch: Throwable -> L20
    L11:
        if (r4.hasNext() == false) goto L17;
        if (r4.next().asBinder().equals(r5.getCallback().asBinder()) == false) goto L11;
        monitor-exit(r1);     // Catch: Throwable -> L20
        return true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L20
        Log.d(TAG, "This client is unregistered: " + r5);
        return false;
    L20:
        th = move-exception;
        throw th;
    }

    public Client registerCallback(String r6, INetworkCallback r7) throws RemoteException {
        IBinder r0 = r7.asBinder();
        r0.linkToDeath(new ClientBinderDeathRecipient(this, r7), 0);
        int r1 = Binder.getCallingUid();
        Log.d(TAG, "registerCallback: uid = " + r1 + " callerPackage=" + mContext.getPackageManager().getNameForUid(r1) + "callback = " + r7 + "binder = " + r0);
        this.mAppOpsManager.checkPackage(Binder.getCallingUid(), r6);
        if (addCallback(r7) != this.SUCCESS) goto L5;
        int r3 = this.mClientIndex + 1;
        this.mClientIndex = r3;
        Client r2 = new Client(r3, r1, r6, r7);
        Log.d(TAG, "registerCallback: client = " + r2);
        return r2;
    L5:
        Log.d(TAG, "registerCallback: callback could not be added.");
        return null;
    }

    public void unRegisterCallback(INetworkCallback r1) throws RemoteException {
        removeCallback(r1);
        removeClientFromInflightRequests(r1);
    }

    ArrayList<INetworkCallback> retrieveCallbacks(int r4) {
        ArrayList<INetworkCallback> r0 = new ArrayList();
        if (r4 == (-1)) goto L11;
        if (this.mInflightRequests.containsKey(Integer.valueOf(r4)) == false) goto L12;
        Client r5 = this.mInflightRequests.get(Integer.valueOf(r4)).mClient;
        if (isClientValid(r5) == false) goto L9;
        r0.add(r5.getCallback());
        return r0;
    L9:
        Log.e(TAG, "This client is invalid now: " + r5);
        return r0;
    L12:
        return r0;
    L11:
        return this.mCallbackList;
    }

    private void on5gStatus(int r9, Token r10, Status r11, boolean r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "on5gStatus: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.on5gStatus(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "on5gStatus: Exception = " + e);
    }

    private void onNrDcParam(int r9, Token r10, Status r11, DcParam r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onNrDcParam: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onNrDcParam(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "on5gStatus: Exception = " + e);
    }

    private void onUpperLayerIndInfo(int r9, Token r10, Status r11, UpperLayerIndInfo r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onUpperLayerIndInfo: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onUpperLayerIndInfo(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onUpperLayerIndInfo: Exception = " + e);
    }

    private void on5gConfigInfo(int r9, Token r10, Status r11, NrConfigType r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "on5gConfigInfo: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.on5gConfigInfo(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "on5gConfigInfo: Exception = " + e);
    }

    private void onAnyNrBearerAllocation(int r9, Token r10, Status r11, BearerAllocationStatus r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onAnyNrBearerAllocation: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onAnyNrBearerAllocation(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "on5gStatus: Exception = " + e);
    }

    private void onSignalStrength(int r9, Token r10, Status r11, SignalStrength r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onSignalStrength: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onSignalStrength(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "on5gStatus: Exception = " + e);
    }

    private void onNrIconType(int r9, Token r10, Status r11, NrIconType r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onNrIconType: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onNrIconType(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onNrIconType: Exception = " + e);
    }

    private void onEnableEndc(int r9, Token r10, Status r11) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onEnableEndc: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onEnableEndc(r9, r10, r11);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onEnableEndc: Exception = " + e);
    }

    private void onEndcStatus(int r9, Token r10, Status r11, boolean r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onEndcStatus: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onEndcStatus(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onEndcStatus: Exception = " + e);
    }

    public void onSetNrConfig(int r9, Token r10, Status r11) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onSetNrConfig: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onSetNrConfig(r9, r10, r11);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onSetNrConfig: Exception = " + e);
    }

    public void onNrConfigStatus(int r9, Token r10, Status r11, NrConfig r12) {
        int r0 = r10.get();     // Catch: RemoteException -> L13
        ArrayList<INetworkCallback> r1 = this.mCallbackList;     // Catch: RemoteException -> L13
        monitor-enter(r1);     // Catch: RemoteException -> L13
        Iterator<INetworkCallback> r2 = retrieveCallbacks(r0).iterator();     // Catch: Throwable -> L10
    L6:
        if (r2.hasNext() == false) goto L8;
        INetworkCallback r3 = r2.next();     // Catch: Throwable -> L10
        Log.d(TAG, "onNrConfigStatus: Responding back for transaction = " + this.mInflightRequests.get(Integer.valueOf(r0)));     // Catch: Throwable -> L10
        r3.onNrConfigStatus(r9, r10, r11, r12);     // Catch: Throwable -> L10
        this.mInflightRequests.remove(Integer.valueOf(r0));     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r1);     // Catch: Throwable -> L10
    L20:
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: RemoteException -> L13
    L13:
        e = move-exception;
        Log.d(TAG, "onNrConfigStatus: Exception = " + e);
    }

    public int getAidlClientsCount() {
        ArrayList<INetworkCallback> r0 = this.mCallbackList;
        monitor-enter(r0);
        int r1 = this.mCallbackList.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getInflightRequestsCount() {
        return this.mInflightRequests.size();
    }

    private void dumpAidlClients(PrintWriter r6) {
        ArrayList<INetworkCallback> r0 = this.mCallbackList;
        monitor-enter(r0);
        Iterator<INetworkCallback> r5 = this.mCallbackList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r5.hasNext() == false) goto L8;
        INetworkCallback r1 = r5.next();     // Catch: Throwable -> L10
        r6.println("Callback = " + r1 + "-> Binder = " + r1.asBinder());     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void dumpInflightRequests(PrintWriter r5) {
        Iterator<Integer> r0 = this.mInflightRequests.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Integer r1 = r0.next();
        r5.println("Token = " + r1 + " => " + this.mInflightRequests.get(r1));
        goto L4
    }

    public void dump(FileDescriptor r1, PrintWriter r2, String[] r3) {
        r2.println("5G-Middleware:");
        r2.println("mHidlConnectionInterface = " + this.mHidlConnectionInterface);
        r2.println("AIDL clients : ");
        dumpAidlClients(r2);
        r2.flush();
        r2.println("Inflight requests : ");
        dumpInflightRequests(r2);
        r2.flush();
    }
}
