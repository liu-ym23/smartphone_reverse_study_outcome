package com.ttnet.org.chromium.net.impl;

import android.text.TextUtils;
import android.util.Log;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public class CronetFrontierClient {
    private static final int STATE_BUILDING = 1;
    private static final int STATE_CLOSE = 4;
    private static final int STATE_ESTABLISHED = 2;
    private static final int STATE_FAILED = 3;
    private static final int STATE_NONE = 0;
    private static final String TAG = "CronetFrontierClient";
    private int mAppId;
    private String mAppKey;
    private String mAppVersion;
    private IConnectionCallback mCallback;
    private String mDeviceId;
    private String mEnv;
    private int mFpid;
    private long mFrontierClientAdapter;
    private final Object mFrontierClientAdapterLock;
    private Map<String, String> mHeaders;
    private String mHost;
    private TransportMode mMode;
    private String mPath;
    private int mPingInterval;
    private int mPort;
    private boolean mProxy;
    private String mQuery;
    private Map<Integer, TTServiceInfo> mServiceInfoMap;
    private AtomicInteger mState;
    private int mTimeout;
    private List<Integer> mUniqueServiceIdList;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetFrontierClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int appId;
        private String appKey;
        private String appVersion;
        private IConnectionCallback callback;
        private String deviceId;
        private String env;
        private int fpid;
        private Map<String, String> headers;
        private String host;
        private TransportMode mode;
        private String path;
        private int pingInterval;
        private int port;
        private boolean proxy;
        private String query;
        private int timeout;
        private List<Integer> uniqueServiceIdList;

        Builder(int r2, int r3, String r4, int r5, String r6, String r7, String r8) {
            this.mode = TransportMode.UNKNOWN;
            if (r2 <= 0) goto L19;
            if (r3 <= 0) goto L19;
            if (r5 <= 0) goto L19;
            if (TextUtils.isEmpty(r4) == true) goto L17;
            if (TextUtils.isEmpty(r6) == true) goto L17;
            if (TextUtils.isEmpty(r7) == true) goto L17;
            if (TextUtils.isEmpty(r8) == true) goto L17;
            this.appId = r2;
            this.fpid = r3;
            this.port = r5;
            this.host = r4;
            this.appVersion = r6;
            this.deviceId = r7;
            this.appKey = r8;
            return;
        L17:
            throw new IllegalArgumentException("Host, appVersion, appKey and deviceId must not be empty.");
        L19:
            throw new IllegalArgumentException("Appid, fpid and port must be set greater than 0.");
        }

        static /* synthetic */ int access$000(Builder r0) {
            return r0.appId;
        }

        static /* synthetic */ int access$100(Builder r0) {
            return r0.fpid;
        }

        static /* synthetic */ Map access$1000(Builder r0) {
            return r0.headers;
        }

        static /* synthetic */ TransportMode access$1100(Builder r0) {
            return r0.mode;
        }

        static /* synthetic */ IConnectionCallback access$1200(Builder r0) {
            return r0.callback;
        }

        static /* synthetic */ List access$1300(Builder r0) {
            return r0.uniqueServiceIdList;
        }

        static /* synthetic */ String access$1400(Builder r0) {
            return r0.query;
        }

        static /* synthetic */ String access$1500(Builder r0) {
            return r0.path;
        }

        static /* synthetic */ boolean access$1600(Builder r0) {
            return r0.proxy;
        }

        static /* synthetic */ String access$200(Builder r0) {
            return r0.host;
        }

        static /* synthetic */ int access$300(Builder r0) {
            return r0.port;
        }

        static /* synthetic */ String access$400(Builder r0) {
            return r0.appVersion;
        }

        static /* synthetic */ String access$500(Builder r0) {
            return r0.deviceId;
        }

        static /* synthetic */ String access$600(Builder r0) {
            return r0.appKey;
        }

        static /* synthetic */ String access$700(Builder r0) {
            return r0.env;
        }

        static /* synthetic */ int access$800(Builder r0) {
            return r0.pingInterval;
        }

        static /* synthetic */ int access$900(Builder r0) {
            return r0.timeout;
        }

        public static Builder create(int r9, int r10, String r11, int r12, String r13, String r14, String r15) {
            return new Builder(r9, r10, r11, r12, r13, r14, r15);
        }

        public CronetFrontierClient build() {
            return new CronetFrontierClient(this, null);
        }

        public Builder callback(IConnectionCallback r1) {
            this.callback = r1;
            return this;
        }

        public Builder env(String r1) {
            this.env = r1;
            return this;
        }

        public Builder headers(Map<String, String> r1) {
            this.headers = r1;
            return this;
        }

        public Builder path(String r1) {
            this.path = r1;
            return this;
        }

        public Builder pingInterval(int r1) {
            this.pingInterval = r1;
            return this;
        }

        public Builder proxy(boolean r1) {
            this.proxy = r1;
            return this;
        }

        public Builder query(String r1) {
            this.query = r1;
            return this;
        }

        public Builder timeout(int r1) {
            this.timeout = r1;
            return this;
        }

        public Builder transportMode(TransportMode r1) {
            this.mode = r1;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> r1) {
            this.uniqueServiceIdList = r1;
            return this;
        }
    }

    public interface IConnectionCallback {
        void onConnectionError(int r1, String r2, String r3);

        void onConnectionStateChanged(int r1, String r2);

        void onTrafficChanged(String r1, long r2, long r4, boolean r6);
    }

    public interface IServiceMessageReceiver {
        void onError(int r1, int r2, String r3);

        void onReceivedAck(int r1, long r2, String r4, Boolean r5);

        void onReceivedMessage(int r1, Map<String, String> r2, byte[] r3);

        void onServiceReady(int r1, String r2);
    }

    interface Natives {
        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addHeader(long r1, CronetFrontierClient r3, String r4, String r5);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void addServiceId(long r1, CronetFrontierClient r3, int r4);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void configParams(long r1, CronetFrontierClient r3, int r4, int r5, String r6, int r7, String r8, String r9, String r10, String r11, int r12, int r13, int r14, boolean r15, String r16, String r17);

        long createFrontierClientAdapter(CronetFrontierClient r1);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void destroy(long r1, CronetFrontierClient r3);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        boolean isServiceReady(long r1, CronetFrontierClient r3, int r4);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void registerService(long r1, CronetFrontierClient r3, String[] r4, ByteBuffer r5, int r6, int r7, boolean r8);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void reportAppStateChange(long r1, CronetFrontierClient r3, boolean r4);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void sendMessage(long r1, CronetFrontierClient r3, int r4, String[] r5, ByteBuffer r6);

        @NativeClassQualifiedName("CronetFrontierClientAdapter")
        void unregisterService(long r1, CronetFrontierClient r3, int r4);
    }

    public static final enum TransportMode extends Enum<TransportMode> {
        private static final /* synthetic */ TransportMode[] $VALUES = null;
        public static final TransportMode HTTP2 = null;
        public static final TransportMode QUIC = null;
        public static final TransportMode SPDY = null;
        public static final TransportMode TLS = null;
        public static final TransportMode UNKNOWN = null;
        final int mode;

        static {
            TransportMode r0 = new TransportMode("UNKNOWN", 0, -1);
            UNKNOWN = r0;
            TransportMode r1 = new TransportMode("QUIC", 1, 0);
            QUIC = r1;
            TransportMode r3 = new TransportMode("TLS", 2, 1);
            TLS = r3;
            TransportMode r5 = new TransportMode("HTTP2", 3, 2);
            HTTP2 = r5;
            TransportMode r7 = new TransportMode("SPDY", 4, 3);
            SPDY = r7;
            $VALUES = new TransportMode[]{r0, r1, r3, r5, r7};
        }

        private TransportMode(String r1, int r2, int r3) {
            super(r1, r2);
            this.mode = r3;
        }

        public static TransportMode valueOf(String r1) {
            return (TransportMode) Enum.valueOf(TransportMode.class, r1);
        }

        public static TransportMode[] values() {
            return (TransportMode[]) $VALUES.clone();
        }

        public int getValue() {
            return this.mode;
        }
    }

    static {
    }

    private CronetFrontierClient(Builder r3) {
        this.mMode = TransportMode.UNKNOWN;
        this.mServiceInfoMap = new ConcurrentHashMap();
        this.mFrontierClientAdapterLock = new Object();
        this.mState = new AtomicInteger(0);
        this.mAppId = Builder.access$000(r3);
        this.mFpid = Builder.access$100(r3);
        this.mHost = Builder.access$200(r3);
        this.mPort = Builder.access$300(r3);
        this.mAppVersion = Builder.access$400(r3);
        this.mDeviceId = Builder.access$500(r3);
        this.mAppKey = Builder.access$600(r3);
        this.mEnv = Builder.access$700(r3);
        this.mPingInterval = Builder.access$800(r3);
        this.mTimeout = Builder.access$900(r3);
        this.mHeaders = Builder.access$1000(r3);
        this.mMode = Builder.access$1100(r3);
        this.mCallback = Builder.access$1200(r3);
        this.mUniqueServiceIdList = Builder.access$1300(r3);
        this.mQuery = Builder.access$1400(r3);
        this.mPath = Builder.access$1500(r3);
        this.mProxy = Builder.access$1600(r3);
        createNativeFrontierClient();
    }

    /* synthetic */ CronetFrontierClient(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    private void createNativeFrontierClient() {
        Object r15 = this.mFrontierClientAdapterLock;
        monitor-enter(r15);
    L32:
        th = th;
    L30:
        monitor-exit(r20);     // Catch: Throwable -> L32
        throw th;
    L28:
        th = th;
        Object r20 = r15;
        goto L30
    L5:
        if (this.mFrontierClientAdapter != 0) goto L7;
        this.mFrontierClientAdapter = CronetFrontierClientJni.get().createFrontierClientAdapter(this);     // Catch: Throwable -> L28
    L7:
        Map<String, String> r1 = this.mHeaders;     // Catch: Throwable -> L28
        if (r1 == null) goto L13;
        Iterator<Map.Entry<String, String>> r7 = r1.entrySet().iterator();     // Catch: Throwable -> L28
    L11:
        if (r7.hasNext() == false) goto L13;
        Map.Entry<String, String> r2 = r7.next();     // Catch: Throwable -> L28
        CronetFrontierClientJni.get().addHeader(this.mFrontierClientAdapter, this, r2.getKey(), r2.getValue());     // Catch: Throwable -> L28
    L13:
        List<Integer> r3 = this.mUniqueServiceIdList;     // Catch: Throwable -> L28
        if (r3 == null) goto L19;
        Iterator<Integer> r4 = r3.iterator();     // Catch: Throwable -> L28
    L17:
        if (r4.hasNext() == false) goto L19;
        Integer r5 = r4.next();     // Catch: Throwable -> L28
        CronetFrontierClientJni.get().addServiceId(this.mFrontierClientAdapter, this, r5.intValue());     // Catch: Throwable -> L28
    L19:
        CronetFrontierClientJni.get().configParams(this.mFrontierClientAdapter, this, this.mAppId, this.mFpid, this.mHost, this.mPort, this.mAppVersion, this.mDeviceId, this.mAppKey, this.mEnv, this.mPingInterval, this.mTimeout, this.mMode.getValue(), this.mProxy, this.mQuery, this.mPath);     // Catch: Throwable -> L32
        monitor-exit(r15);     // Catch: Throwable -> L32
        return;
    L26:
        th = th;
        r20 = r15;
        goto L30
    }

    @CalledByNative
    private void onConnectionError(int r4, String r5, String r6) {
        Log.e(TAG, "onConnectionError: " + r6);
        this.mState.set(r4);
        this.mCallback.onConnectionError(r4, r5, r6);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    @CalledByNative
    private void onConnectionStateChanged(int r4, String r5) {
        Log.v(TAG, "onConnectionStateChanged: state = " + r4 + ", url = " + r5);
        this.mState.set(r4);
        this.mCallback.onConnectionStateChanged(r4, r5);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    @CalledByNative
    private void onError(int r2, int r3, String r4) {
        TTServiceInfo r1 = this.mServiceInfoMap.get(Integer.valueOf(r2));
        if (r1 != null) goto L5;
        return;
    L5:
        r1.connected = false;
        r1.listener.onError(r2, r3, r4);
    }

    @CalledByNative
    private void onReceivedAck(int r7, long r8, String r10, boolean r11) {
        if (r11 == false) goto L4;
        return;
    L4:
        TTServiceInfo r6 = this.mServiceInfoMap.get(Integer.valueOf(r7));
        if (r6 != null) goto L7;
        return;
    L7:
        r6.listener.onReceivedAck(r7, r8, r10, Boolean.valueOf(r11));
    }

    @CalledByNative
    private void onReceivedMessage(int r6, String[] r7, ByteBuffer r8, int r9) {
        TTServiceInfo r5 = this.mServiceInfoMap.get(Integer.valueOf(r6));
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r7.length;
        if ((r0 % 2) == 0) goto L9;
        Log.e(TAG, "length is not even number:" + r0);
        return;
    L9:
        HashMap r1 = new HashMap();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L17;
        if (TextUtils.isEmpty(r7[r2]) == true) goto L16;
        int r3 = r2 + 1;
        if (TextUtils.isEmpty(r7[r3]) == true) goto L16;
        r1.put(r7[r2], r7[r3]);
    L16:
        r2 = r2 + 2;
        goto L10
    L17:
        byte[] r10 = new byte[r8.capacity()];
        r8.get(r10);
        if (r9 < 0) goto L20;
        r6 = r9;
    L20:
        r5.listener.onReceivedMessage(r6, r1, r10);
    }

    @CalledByNative
    private void onServiceReady(int r2, String r3) {
        TTServiceInfo r1 = this.mServiceInfoMap.get(Integer.valueOf(r2));
        if (r1 != null) goto L5;
        return;
    L5:
        r1.connected = true;
        r1.listener.onServiceReady(r2, r3);
    }

    @CalledByNative
    private void onTrafficChanged(String r10, long r11, long r13, boolean r15) {
        Log.v(TAG, "OnTrafficChanged");
        this.mCallback.onTrafficChanged(r10, r11, r13, r15);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, "Exception in callback: ", e);
    }

    public void destroy() {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().destroy(this.mFrontierClientAdapter, this);     // Catch: Throwable -> L11
        this.mFrontierClientAdapter = 0;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public TTServiceInfo getServiceInfoById(int r1) {
        return this.mServiceInfoMap.get(Integer.valueOf(r1));
    }

    public boolean isConnected() {
        if (this.mState.get() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isServiceExisted(int r1) {
        return this.mServiceInfoMap.containsKey(Integer.valueOf(r1));
    }

    public boolean isServiceReady(int r6) {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L8:
        TTServiceInfo r5 = this.mServiceInfoMap.get(Integer.valueOf(r6));     // Catch: Throwable -> L15
        if (r5 != null) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return false;
    L12:
        boolean r7 = r5.connected;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return r7;
    }

    public void registerService(TTServiceInfo r13, ByteBuffer r14, String[] r15) {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.put(Integer.valueOf(r13.identity), r13);     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().registerService(this.mFrontierClientAdapter, this, r15, r14, r13.identity, r13.priority.getValue(), r13.sequence);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void reportAppStateChange(boolean r6) {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().reportAppStateChange(this.mFrontierClientAdapter, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void sendMessage(int r9, String[] r10, ByteBuffer r11) {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetFrontierClientJni.get().sendMessage(this.mFrontierClientAdapter, this, r9, r10, r11);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }

    public void setMaxPacketSize(int r1, int r2) {
    }

    public void setMsgCursor(int r1, int r2) {
    }

    public void unregisterService(int r6) {
        Object r0 = this.mFrontierClientAdapterLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mFrontierClientAdapter != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mServiceInfoMap.remove(Integer.valueOf(r6));     // Catch: Throwable -> L11
        CronetFrontierClientJni.get().unregisterService(this.mFrontierClientAdapter, this, r6);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
    }
}
