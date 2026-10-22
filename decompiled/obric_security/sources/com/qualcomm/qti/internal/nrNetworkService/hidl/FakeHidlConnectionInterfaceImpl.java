package com.qualcomm.qti.internal.nrNetworkService.hidl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import org.codeaurora.internal.BearerAllocationStatus;
import org.codeaurora.internal.DcParam;
import org.codeaurora.internal.NrConfig;
import org.codeaurora.internal.NrConfigType;
import org.codeaurora.internal.NrIconType;
import org.codeaurora.internal.SignalStrength;
import org.codeaurora.internal.Status;
import org.codeaurora.internal.Token;
import org.codeaurora.internal.UpperLayerIndInfo;

/* JADX INFO: loaded from: classes4.dex */
public class FakeHidlConnectionInterfaceImpl implements IHidlConnectionInterface {
    private static final String TAG = "FakeHidlConnectionInterfaceImpl";
    private final int EVENT_SIMULATE_5G_DISABLED;
    private final int EVENT_SIMULATE_5G_ENABLED;
    private final int EVENT_SIMULATE_ENABLE_ENDC;
    private final int EVENT_SIMULATE_QUERY_5G_STATUS;
    private final int EVENT_SIMULATE_QUERY_BEARER_ALLOCATION;
    private final int EVENT_SIMULATE_QUERY_CONFIG_TYPE;
    private final int EVENT_SIMULATE_QUERY_ENDC_STATUS;
    private final int EVENT_SIMULATE_QUERY_ICON_TYPE;
    private final int EVENT_SIMULATE_QUERY_NRDC_PARAM;
    private final int EVENT_SIMULATE_QUERY_NR_CONFIG;
    private final int EVENT_SIMULATE_QUERY_SIGNAL_STRENGTH;
    private final int EVENT_SIMULATE_QUERY_UPPER_LAYER_IND_INFO;
    private final int EVENT_SIMULATE_SET_NR_CONFIG;
    private final Token UNSOL;
    private boolean m5gEnabledState;
    private IHidlConnectionCallback mCallback;
    private int mSerial;
    private Handler mWorkerHandler;
    private HandlerThread mWorkerThread;

    private class WorkerHandler extends Handler {
        private static final String TAG = "FakeHidleConnection-WorkerHandler";
        final /* synthetic */ FakeHidlConnectionInterfaceImpl this$0;

        public WorkerHandler(FakeHidlConnectionInterfaceImpl r1) {
            this.this$0 = r1;
        }

        public WorkerHandler(FakeHidlConnectionInterfaceImpl r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            Log.d(TAG, "handleMessage msg.what = " + r8.what);
            SignalStrength r2 = null;
            switch(r8.what) {
                case 0: goto L56;
                case 1: goto L53;
                case 2: goto L50;
                case 3: goto L43;
                case 4: goto L36;
                case 5: goto L30;
                case 6: goto L23;
                case 7: goto L20;
                case 8: goto L17;
                case 9: goto L14;
                case 10: goto L11;
                case 11: goto L8;
                case 12: goto L5;
                default: goto L85;
            };
        L5:
            int r0 = r8.arg1;
            Token r9 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L60;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_NR_CONFIG: token = " + r9);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrConfigStatus(r0, r9, new Status(1), new NrConfig(1));
            return;
        L60:
            return;
        L8:
            int r1 = r8.arg1;
            Token r10 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L62;
            Log.d(TAG, "EVENT_SIMULATE_SET_NR_CONFIG: token = " + r10);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).setNrConfigStatus(r1, r10, new Status(1));
            return;
        L62:
            return;
        L11:
            int r3 = r8.arg1;
            Token r11 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L64;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_ENDC_STATUS: token = " + r11);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onEndcStatus(r3, r11, new Status(1), true);
            return;
        L64:
            return;
        L14:
            int r4 = r8.arg1;
            Token r12 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L66;
            Log.d(TAG, "EVENT_SIMULATE_ENABLE_ENDC: token = " + r12);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onEnableEndc(r4, r12, new Status(1));
            return;
        L66:
            return;
        L17:
            int r5 = r8.arg1;
            Token r13 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L68;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_ICON_TYPE: token = " + r13);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrIconType(r5, r13, new Status(1), new NrIconType(1));
            return;
        L68:
            return;
        L20:
            int r6 = r8.arg1;
            Token r14 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L70;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_CONFIG_TYPE: token = " + r14);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gConfigInfo(r6, r14, new Status(1), new NrConfigType(0));
            return;
        L70:
            return;
        L23:
            int r7 = r8.arg1;
            Token r15 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L72;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_UPPER_LAYER_IND_INFO: token = " + r15);
            if (FakeHidlConnectionInterfaceImpl.m634$$Nest$fgetm5gEnabledState(this.this$0) == false) goto L28;
            UpperLayerIndInfo r16 = new UpperLayerIndInfo(1, 1);
        L29:
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onUpperLayerIndInfo(r7, r15, new Status(1), r16);
            return;
        L28:
            r16 = new UpperLayerIndInfo(0, 0);
            goto L29
        L72:
            return;
        L30:
            int r17 = r8.arg1;
            Token r18 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L74;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_SIGNAL_STRENGTH: token = " + r18);
            if (FakeHidlConnectionInterfaceImpl.m634$$Nest$fgetm5gEnabledState(this.this$0) == false) goto L35;
            r2 = new SignalStrength();
        L35:
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onSignalStrength(r17, r18, new Status(1), r2);
            return;
        L74:
            return;
        L36:
            int r19 = r8.arg1;
            Token r20 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L76;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_BEARER_ALLOCATION: token = " + r20);
            if (FakeHidlConnectionInterfaceImpl.m634$$Nest$fgetm5gEnabledState(this.this$0) == false) goto L41;
            BearerAllocationStatus r21 = new BearerAllocationStatus(2);
        L42:
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onAnyNrBearerAllocation(r19, r20, new Status(1), r21);
            return;
        L41:
            r21 = new BearerAllocationStatus(0);
            goto L42
        L76:
            return;
        L43:
            int r22 = r8.arg1;
            Token r23 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L78;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_NRDC_PARAM: token = " + r23);
            if (FakeHidlConnectionInterfaceImpl.m634$$Nest$fgetm5gEnabledState(this.this$0) == false) goto L48;
            DcParam r24 = new DcParam(1, 1);
        L49:
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrDcParam(r22, r23, new Status(1), r24);
            return;
        L48:
            r24 = new DcParam(0, 0);
            goto L49
        L78:
            return;
        L50:
            int r25 = r8.arg1;
            Token r26 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L80;
            Log.d(TAG, "EVENT_SIMULATE_QUERY_5G_STATUS: token = " + r26);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gStatus(r25, r26, new Status(1), FakeHidlConnectionInterfaceImpl.m634$$Nest$fgetm5gEnabledState(this.this$0));
            return;
        L80:
            return;
        L53:
            int r27 = r8.arg1;
            Token r28 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L82;
            Log.d(TAG, "EVENT_SIMULATE_5G_DISABLED: token = " + r28);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gStatus(r27, r28, new Status(1), false);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrDcParam(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new DcParam(0, 0));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onUpperLayerIndInfo(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new UpperLayerIndInfo(0, 0));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onAnyNrBearerAllocation(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new BearerAllocationStatus(0));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onSignalStrength(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), null);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrIconType(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new NrIconType(0));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gStatus(r27, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), false);
            FakeHidlConnectionInterfaceImpl.m636$$Nest$fputm5gEnabledState(this.this$0, false);
            return;
        L82:
            return;
        L56:
            int r29 = r8.arg1;
            Token r30 = (Token) r8.obj;
            if (FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0) == null) goto L84;
            Log.d(TAG, "EVENT_SIMULATE_5G_ENABLED: token = " + r30);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gStatus(r29, r30, new Status(1), true);
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrDcParam(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new DcParam(1, 1));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onUpperLayerIndInfo(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new UpperLayerIndInfo(1, 1));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onAnyNrBearerAllocation(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new BearerAllocationStatus(2));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onSignalStrength(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new SignalStrength());
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gConfigInfo(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new NrConfigType(0));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).onNrIconType(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), new NrIconType(1));
            FakeHidlConnectionInterfaceImpl.m635$$Nest$fgetmCallback(this.this$0).on5gStatus(r29, FakeHidlConnectionInterfaceImpl.m633$$Nest$fgetUNSOL(this.this$0), new Status(1), true);
            FakeHidlConnectionInterfaceImpl.m636$$Nest$fputm5gEnabledState(this.this$0, true);
            return;
        L84:
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetUNSOL, reason: not valid java name */
    static /* bridge */ /* synthetic */ Token m633$$Nest$fgetUNSOL(FakeHidlConnectionInterfaceImpl r0) {
        return r0.UNSOL;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetm5gEnabledState, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m634$$Nest$fgetm5gEnabledState(FakeHidlConnectionInterfaceImpl r0) {
        return r0.m5gEnabledState;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ IHidlConnectionCallback m635$$Nest$fgetmCallback(FakeHidlConnectionInterfaceImpl r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fputm5gEnabledState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m636$$Nest$fputm5gEnabledState(FakeHidlConnectionInterfaceImpl r0, boolean r1) {
        r0.m5gEnabledState = r1;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enable5gOnly(int r1, Token r2) throws RemoteException {
    }

    public FakeHidlConnectionInterfaceImpl() {
        this.mWorkerThread = new HandlerThread("FakeHidlConnectionInterfaceImplBgThread");
        this.mSerial = -1;
        this.UNSOL = new Token(-1);
        this.m5gEnabledState = false;
        this.EVENT_SIMULATE_5G_ENABLED = 0;
        this.EVENT_SIMULATE_5G_DISABLED = 1;
        this.EVENT_SIMULATE_QUERY_5G_STATUS = 2;
        this.EVENT_SIMULATE_QUERY_NRDC_PARAM = 3;
        this.EVENT_SIMULATE_QUERY_BEARER_ALLOCATION = 4;
        this.EVENT_SIMULATE_QUERY_SIGNAL_STRENGTH = 5;
        this.EVENT_SIMULATE_QUERY_UPPER_LAYER_IND_INFO = 6;
        this.EVENT_SIMULATE_QUERY_CONFIG_TYPE = 7;
        this.EVENT_SIMULATE_QUERY_ICON_TYPE = 8;
        this.EVENT_SIMULATE_ENABLE_ENDC = 9;
        this.EVENT_SIMULATE_QUERY_ENDC_STATUS = 10;
        this.EVENT_SIMULATE_SET_NR_CONFIG = 11;
        this.EVENT_SIMULATE_QUERY_NR_CONFIG = 12;
        this.mWorkerThread.start();
        Looper r0 = this.mWorkerThread.getLooper();
        this.mWorkerHandler = new WorkerHandler(this, r0);
        Log.d(TAG, "constructor... using its own bg thread Looper = " + r0);
    }

    public FakeHidlConnectionInterfaceImpl(Looper r3) {
        this.mWorkerThread = new HandlerThread("FakeHidlConnectionInterfaceImplBgThread");
        this.mSerial = -1;
        this.UNSOL = new Token(-1);
        this.m5gEnabledState = false;
        this.EVENT_SIMULATE_5G_ENABLED = 0;
        this.EVENT_SIMULATE_5G_DISABLED = 1;
        this.EVENT_SIMULATE_QUERY_5G_STATUS = 2;
        this.EVENT_SIMULATE_QUERY_NRDC_PARAM = 3;
        this.EVENT_SIMULATE_QUERY_BEARER_ALLOCATION = 4;
        this.EVENT_SIMULATE_QUERY_SIGNAL_STRENGTH = 5;
        this.EVENT_SIMULATE_QUERY_UPPER_LAYER_IND_INFO = 6;
        this.EVENT_SIMULATE_QUERY_CONFIG_TYPE = 7;
        this.EVENT_SIMULATE_QUERY_ICON_TYPE = 8;
        this.EVENT_SIMULATE_ENABLE_ENDC = 9;
        this.EVENT_SIMULATE_QUERY_ENDC_STATUS = 10;
        this.EVENT_SIMULATE_SET_NR_CONFIG = 11;
        this.EVENT_SIMULATE_QUERY_NR_CONFIG = 12;
        Log.d(TAG, "constructor... Looper = " + r3);
        this.mWorkerHandler = new WorkerHandler(this, r3);
    }

    private Token getNextToken() {
        int r1 = this.mSerial + 1;
        this.mSerial = r1;
        return new Token(r1);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enable5g(int r5, Token r6) throws RemoteException {
        Log.d(TAG, "enable5g: ");
        if (this.mCallback == null) goto L5;
        Handler r4 = this.mWorkerHandler;
        r4.sendMessageDelayed(r4.obtainMessage(0, r5, -1, r6), 2000);
    L5:
        Log.d(TAG, "enable5g: token = " + r6);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void disable5g(int r5, Token r6) throws RemoteException {
        Log.d(TAG, "disable5g: ");
        Handler r4 = this.mWorkerHandler;
        r4.sendMessageDelayed(r4.obtainMessage(1, r5, -1, r6), 2000);
        Log.d(TAG, "disable5g: token = " + r6);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void query5gStatus(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "query5gStatus: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(2, r4, -1, r5));
        Log.d(TAG, "query5gStatus: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void query5gConfigInfo(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "query5gConfigInfo: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(7, r4, -1, r5));
        Log.d(TAG, "query5gConfigInfo: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrDcParam(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryNrDcParam: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(3, r4, -1, r5));
        Log.d(TAG, "queryNrDcParam: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrBearerAllocation(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryNrBearerAllocation: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(4, r4, -1, r5));
        Log.d(TAG, "queryNrBearerAllocation: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrSignalStrength(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryNrSignalStrength: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(5, r4, -1, r5));
        Log.d(TAG, "queryNrSignalStrength: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryUpperLayerIndInfo(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryUpperLayerIndInfo: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(6, r4, -1, r5));
        Log.d(TAG, "queryUpperLayerIndInfo: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrIconType(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryNrIconType: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(8, r4, -1, r5));
        Log.d(TAG, "queryNrIconType: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void enableEndc(int r3, boolean r4, Token r5) throws RemoteException {
        Log.d(TAG, "enableEndc: ");
        Handler r2 = this.mWorkerHandler;
        r2.sendMessage(r2.obtainMessage(9, r3, -1, r5));
        Log.d(TAG, "enableEndc: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryEndcStatus(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryEndcStatus: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(10, r4, -1, r5));
        Log.d(TAG, "queryEndcStatus: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void setNrConfig(int r3, NrConfig r4, Token r5) throws RemoteException {
        Log.d(TAG, "setNrConfig: ");
        Handler r2 = this.mWorkerHandler;
        r2.sendMessage(r2.obtainMessage(11, r3, -1, r5));
        Log.d(TAG, "setNrConfig: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void queryNrConfig(int r4, Token r5) throws RemoteException {
        Log.d(TAG, "queryNrConfig: ");
        Handler r3 = this.mWorkerHandler;
        r3.sendMessage(r3.obtainMessage(12, r4, -1, r5));
        Log.d(TAG, "queryNrConfig: token = " + r5);
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public Token generateNextToken() {
        return getNextToken();
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void registerCallback(IHidlConnectionCallback r3) {
        Log.d(TAG, "registerCallback: callback = " + r3);
        this.mCallback = r3;
    }

    @Override // com.qualcomm.qti.internal.nrNetworkService.hidl.IHidlConnectionInterface
    public void unRegisterCallback(IHidlConnectionCallback r3) {
        Log.d(TAG, "unRegisterCallback: callback = " + r3);
        if (this.mCallback != r3) goto L6;
        this.mCallback = null;
        return;
    }
}
