package com.bytedance.networkstackapplib;

import com.obric.capabilitykit.common.Ext;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class TTNETScoreAPI {
    private static Class<?> Chain = null;
    private static final String INTERCEPTOR_NAME = "MY_PROXY_INTERCEPTOR";
    public static final int MAX_WAIT_TIME = 3000;
    private static Class<?> Request = null;
    private static Class<?> SsResponse = null;
    private static final String TAG = "TTNETScoreAPI:";
    private static boolean isReflectSuccess = false;
    private static ParamConfig mConfigByApp = null;
    private static AtomicInteger mSequenceNumber = null;
    private static Method methodGetBody = null;
    private static Method methodGetPath = null;
    private static Method methodIsSuccessful = null;
    private static Method methodLength = null;
    private static Method methodProceed = null;
    private static Method methodRaw = null;
    private static Method methodRequset = null;
    private static Method sAddInterceptor = null;
    private static ArrayList<IWeakNetworkCallBack> sAllCallbacks = null;
    private static boolean sAppSupportTTNET = false;
    private static boolean sHasStarted = false;
    private static boolean sInitForReflect = false;
    private static Object sInterceptor = null;
    private static int sLastScore = -1;
    private static Method sRemoveInterceptor = null;
    public static int sSampleCircle = 5;
    public static long sSampleDebugLog = 0;
    public static long sSampleGapTime = 15000;
    private static RingBuffer<MyReqInfo> sSampleReqs = null;
    public static int sSampleSize = 26;
    public static long sSampleSpeed = 100000;
    public static int sSampleTimeFeed = 2700;
    public static int sSampleTimeImg = 256;
    public static int sSampleTimeNormal = 300;
    private static final Object sWeakNetLock = null;

    /* JADX INFO: renamed from: com.bytedance.networkstackapplib.TTNETScoreAPI$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface IWeakNetworkCallBack {
        void onScoreChange(int r1);
    }

    private static class MyInterceptorHandler implements InvocationHandler {
        private MyInterceptorHandler() {
        }

        /* synthetic */ MyInterceptorHandler(AnonymousClass1 r1) {
            this();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) throws Throwable {
        L24:
            e = move-exception;
            e.printStackTrace();
            throw e;
        L3:
            if (r4.getName().equals("intercept") == false) goto L8;
            return TTNETScoreAPI.access$000(r5[0]);
        L8:
            if (r4.getName().equals("equals") == false) goto L16;
            if (r5[0].toString().equals(TTNETScoreAPI.INTERCEPTOR_NAME) == false) goto L14;
            return true;
        L14:
            return false;
        L16:
            if (r4.getName().equals("toString") == false) goto L19;
            return TTNETScoreAPI.INTERCEPTOR_NAME;
        L19:
            if (r4.getName().equals("hashCode") == false) goto L23;
            return -1425398335;
        L23:
            return r4.invoke(this, r5);
        }
    }

    public static class MyReqInfo {
        public long badTime;
        public long costTime;
        public boolean hasException;
        public String path;
        public int reqId;
        public long speed;
        public long startTime;

        public boolean isHealthy(long r8) {
            if (this.hasException == false) goto L6;
            return false;
        L6:
            if (this.speed <= TTNETScoreAPI.sSampleSpeed) goto L9;
            return true;
        L9:
            if (this.costTime == 0) goto L11;
        L21:
            long r3 = this.costTime;
            if (r3 != 0) goto L25;
            r3 = r8 - this.startTime;
        L25:
            if (r3 <= this.badTime) goto L27;
            return false;
        L27:
            return true;
        L11:
            if (this.speed != 0) goto L21;
            String r0 = this.path;
            if (r0 == null) goto L21;
            if (r0.startsWith("/obj/") == false) goto L17;
        L20:
            return true;
        L17:
            if (this.path.startsWith("/tos-cn-") == true) goto L20;
            if (this.path.startsWith("/large/") == false) goto L21;
            goto L20
        }

        public MyReqInfo() {
            this.path = null;
            this.startTime = 0;
            this.costTime = 0;
            this.reqId = 0;
            this.badTime = 0;
            this.speed = 0;
            this.hasException = false;
            this.startTime = System.currentTimeMillis();
        }

        public String toString() {
            return "MyReqInfo{path='" + this.path + "', costTime=" + this.costTime + ", speed=" + this.speed + '}';
        }
    }

    public static class ParamConfig {
        public int configCircle;
        public int configDebugLog;
        public int configGapTime;
        public int configGoodSpeed;
        public int configSize;
        public int configTimeFeed;
        public int configTimeImg;
        public int configTimeNormal;

        public ParamConfig() {
            this.configCircle = 5;
            this.configSize = 26;
            this.configTimeImg = 256;
            this.configTimeFeed = 2700;
            this.configTimeNormal = 288;
            this.configGoodSpeed = 100000;
            this.configGapTime = 15000;
            this.configDebugLog = 0;
        }
    }

    private static int getScoreLevel(int r1) {
        if (r1 >= 30) goto L7;
        return 0;
    L7:
        if (r1 >= 60) goto L11;
        return 1;
    L11:
        if (r1 >= 80) goto L14;
        return 2;
    L14:
        return 3;
    }

    public TTNETScoreAPI() {
    }

    static /* synthetic */ Object access$000(Object r0) throws Throwable {
        return handleRequest(r0);
    }

    static {
        sWeakNetLock = new Object();
        mSequenceNumber = new AtomicInteger(0);
        sSampleReqs = new RingBuffer(MyReqInfo.class, 20);
        mConfigByApp = null;
        sAllCallbacks = new ArrayList();
        Chain = null;
        Request = null;
        SsResponse = null;
        methodRequset = null;
        methodGetPath = null;
        methodProceed = null;
        methodIsSuccessful = null;
        methodRaw = null;
        methodGetBody = null;
        methodLength = null;
        isReflectSuccess = false;
    }

    public static synchronized void setParamConfig(ParamConfig r1) {
        monitor-enter(TTNETScoreAPI.class);
        mConfigByApp = r1;     // Catch: Throwable -> L7
        monitor-exit(TTNETScoreAPI.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static int isWeakNetwork() {
        Object r0 = sWeakNetLock;
        monitor-enter(r0);
        MyReqInfo[] r1 = sSampleReqs.toArray();     // Catch: Throwable -> L42
        monitor-exit(r0);     // Catch: Throwable -> L42
        int r2 = r1.length;
        if (r2 >= 6) goto L9;
        return -1;
    L9:
        long r5 = sSampleReqs.getLatestItem().startTime - sSampleReqs.getEarliestItem().startTime;
        if (r5 <= sSampleGapTime) goto L18;
        monitor-enter(r0);
        sSampleReqs.clear();     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return -1;
    L15:
        th = move-exception;
        throw th;
    L18:
        HashSet r3 = new HashSet();
        HashSet r4 = new HashSet();
        long r7 = System.currentTimeMillis();
        int r6 = r1.length;
        int r9 = 0;
        int r10 = 0;
    L19:
        if (r9 >= r6) goto L25;
        MyReqInfo r11 = r1[r9];
        if (r11.isHealthy(r7) == false) goto L23;
        r10 = r10 + 1;
        r3.add(r11.toString());
    L24:
        r9 = r9 + 1;
        goto L19
    L23:
        r4.add(r11.toString());
        goto L24
    L25:
        int r8 = r3.size();
        int r12 = (r8 * 100) / (r8 + r4.size());
        if (r12 > 0) goto L28;
    L41:
        return r12;
    L28:
        if (getScoreLevel(r12) == getScoreLevel(sLastScore)) goto L41;
        if (Math.abs(r12 - sLastScore) <= 12) goto L41;
        if (sSampleDebugLog != 1) goto L41;
        System.out.println("TTNETScoreAPI: gaptime =" + r5);
        System.out.println("TTNETScoreAPI: successCount = " + r10 + ",badcount = " + (r2 - r10));
        Iterator r13 = r3.iterator();
    L35:
        if (r13.hasNext() == false) goto L37;
        System.out.println("TTNETScoreAPI: goodReqs = " + ((String) r13.next()));
        goto L35
    L37:
        Iterator r14 = r4.iterator();
    L39:
        if (r14.hasNext() == false) goto L41;
        System.out.println("TTNETScoreAPI: badReqs = " + ((String) r14.next()));
    L42:
        th = move-exception;
        throw th;
    }

    public static long getPathBadCostTime(String r3) {
        if (r3 != null) goto L6;
        return 0;
    L6:
        if (r3.startsWith("/img/") == false) goto L8;
    L36:
        int r4 = sSampleTimeImg;
    L14:
        return r4;
    L8:
        if (r3.startsWith("/article/content/") == true) goto L36;
        if (r3.startsWith("/api/news/feed/v88") == false) goto L16;
        r4 = sSampleTimeFeed;
        goto L14
    L16:
        if (r3.startsWith("/obj/") == false) goto L18;
    L35:
        r4 = sSampleTimeImg;
        goto L14
    L18:
        if (r3.startsWith("/tos-cn-") == true) goto L35;
        if (r3.startsWith("/large/") == true) goto L35;
        if (r3.startsWith("/gecko/server/") == false) goto L25;
    L34:
        r4 = sSampleTimeFeed / 3;
        goto L14
    L25:
        if (r3.startsWith("/monitor/collect/batch/") == true) goto L34;
        if (r3.startsWith("/client_impr/impr_recycle/") == false) goto L31;
        r4 = sSampleTimeNormal;
        goto L14
    L31:
        if (r3.startsWith("/search/suggest/") == false) goto L33;
        r4 = sSampleTimeNormal * 4;
        goto L14
    L33:
        return 0;
    }

    private static void initForWeakNetParam() {
        ParamConfig r0 = mConfigByApp;     // Catch: Exception -> L30
        if (r0 == null) goto L5;
        sSampleCircle = r0.configCircle;     // Catch: Exception -> L30
        sSampleSize = mConfigByApp.configSize;     // Catch: Exception -> L30
        sSampleTimeFeed = mConfigByApp.configTimeFeed;     // Catch: Exception -> L30
        sSampleTimeImg = mConfigByApp.configTimeImg;     // Catch: Exception -> L30
        sSampleTimeNormal = mConfigByApp.configTimeNormal;     // Catch: Exception -> L30
        sSampleSpeed = mConfigByApp.configGoodSpeed;     // Catch: Exception -> L30
        sSampleGapTime = mConfigByApp.configGapTime;     // Catch: Exception -> L30
        sSampleDebugLog = mConfigByApp.configDebugLog;     // Catch: Exception -> L30
    L33:
        if (sSampleSize >= 10) goto L35;
        sSampleSize = 10;
    L35:
        sSampleReqs = new RingBuffer(MyReqInfo.class, sSampleSize);
        return;
    L5:
        int r1 = getIntSystemProperties("debug.weaknet.circle");     // Catch: Exception -> L30
        if (r1 <= 0) goto L8;
        sSampleCircle = r1;     // Catch: Exception -> L30
    L8:
        int r2 = getIntSystemProperties("debug.weaknet.size");     // Catch: Exception -> L30
        if (r2 <= 0) goto L11;
        sSampleSize = r2;     // Catch: Exception -> L30
    L11:
        int r3 = getIntSystemProperties("debug.weaknet.feed");     // Catch: Exception -> L30
        if (r3 <= 0) goto L14;
        sSampleTimeFeed = r3;     // Catch: Exception -> L30
    L14:
        int r4 = getIntSystemProperties("debug.weaknet.img");     // Catch: Exception -> L30
        if (r4 <= 0) goto L17;
        sSampleTimeImg = r4;     // Catch: Exception -> L30
    L17:
        int r5 = getIntSystemProperties("debug.weaknet.normal");     // Catch: Exception -> L30
        if (r5 <= 0) goto L20;
        sSampleTimeNormal = r5;     // Catch: Exception -> L30
    L20:
        int r6 = getIntSystemProperties("debug.weaknet.speed");     // Catch: Exception -> L30
        if (r6 <= 0) goto L23;
        sSampleSpeed = r6;     // Catch: Exception -> L30
    L23:
        int r7 = getIntSystemProperties("debug.weaknet.gaptime");     // Catch: Exception -> L30
        if (r7 <= 0) goto L26;
        sSampleGapTime = r7;     // Catch: Exception -> L30
    L26:
        int r8 = getIntSystemProperties("debug.weaknet.debuglog");     // Catch: Exception -> L30
        if (r8 < 0) goto L33;
        sSampleDebugLog = r8;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L33
    }

    private static int getIntSystemProperties(String r7) {
        Method r0 = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return ((Integer) r0.invoke(null, new Object[]{r7, 0})).intValue();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static synchronized boolean registerWeakNetworkCallBack(IWeakNetworkCallBack r2) {
        monitor-enter(TTNETScoreAPI.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAllCallbacks.contains(r2) == true) goto L7;
        sAllCallbacks.add(r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(TTNETScoreAPI.class);
        return true;
    }

    public static synchronized boolean unregisterWeakNetworkCallBack(IWeakNetworkCallBack r2) {
        monitor-enter(TTNETScoreAPI.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAllCallbacks.contains(r2) == false) goto L7;
        sAllCallbacks.remove(r2);     // Catch: Throwable -> L10
    L7:
        monitor-exit(TTNETScoreAPI.class);
        return true;
    }

    private static void notifyScoreChange(int r5) {
        if (sAllCallbacks.size() <= 0) goto L10;
        Iterator<IWeakNetworkCallBack> r0 = sAllCallbacks.iterator();
    L6:
        if (r0.hasNext() == false) goto L16;
        r0.next().onScoreChange(r5);
        if (sSampleDebugLog != 1) goto L6;
        System.out.println("TTNETScoreAPI:weaknetwork_notifyscore score=" + r5);
        goto L6
    L16:
        return;
    }

    private static Object handleRequest(Object r15) throws Throwable {
        long r1 = System.currentTimeMillis();
        MyReqInfo r3 = new MyReqInfo();
        Object r5 = null;
    L32:
        e = move-exception;
        e.printStackTrace();
    L39:
        if (isReflectSuccess == true) goto L41;
        stopCheck();
    L41:
        return r5;
    L34:
        e = move-exception;
        e.printStackTrace();
    L36:
        e = move-exception;
        e.printStackTrace();
    L42:
        e = move-exception;
        isReflectSuccess = true;
        System.currentTimeMillis();
        r3.hasException = true;
        throw e.getTargetException();
    L4:
        if (sInitForReflect == true) goto L6;
        Class<?> r6 = Class.forName("com.bytedance.retrofit2.intercept.Interceptor$Chain");     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Class<?> r8 = Class.forName("com.bytedance.retrofit2.client.Request");     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Class<?> r9 = Class.forName("com.bytedance.retrofit2.SsResponse");     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Class<?> r10 = Class.forName("com.bytedance.retrofit2.client.Response");     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Class<?> r11 = Class.forName("com.bytedance.retrofit2.mime.TypedInput");     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r12 = r6.getDeclaredMethod(Ext.KEY_REQUEST, new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodRequset = r12;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r12.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r13 = r8.getDeclaredMethod("getPath", new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodGetPath = r13;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r13.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r7 = r6.getDeclaredMethod("proceed", new Class[]{r8});     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodProceed = r7;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r7.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r14 = r9.getDeclaredMethod("isSuccessful", new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodIsSuccessful = r14;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r14.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r16 = r9.getDeclaredMethod("raw", new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodRaw = r16;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r16.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r17 = r10.getDeclaredMethod("getBody", new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodGetBody = r17;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r17.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Method r18 = r11.getDeclaredMethod("length", new Class[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        methodLength = r18;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r18.setAccessible(true);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        sInitForReflect = true;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        initForWeakNetParam();     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
    L6:
        Object r19 = methodRequset.invoke(r15, new Object[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        Object r20 = methodGetPath.invoke(r19, new Object[0]);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        int r21 = mSequenceNumber.incrementAndGet();     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r3.path = (String) r20;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r3.reqId = r21;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r3.badTime = getPathBadCostTime((String) r20);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        if (r3.badTime <= 0) goto L17;
        Object r110 = sWeakNetLock;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        monitor-enter(r110);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        sSampleReqs.append(r3);     // Catch: Throwable -> L13
        monitor-exit(r110);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
    L17:
        if ((r21 % sSampleCircle) != 0) goto L25;
        int r22 = isWeakNetwork();     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        if (r22 <= 0) goto L25;
        if (getScoreLevel(r22) == getScoreLevel(sLastScore)) goto L25;
        if (Math.abs(r22 - sLastScore) <= 12) goto L25;
        sLastScore = r22;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        notifyScoreChange(r22);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
    L25:
        r5 = methodProceed.invoke(r15, new Object[]{r19});     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        isReflectSuccess = true;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        long r23 = System.currentTimeMillis() - r1;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        r3.costTime = r23;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        if (((Boolean) methodIsSuccessful.invoke(r5, new Object[0])).booleanValue() == false) goto L39;
        long r2 = ((Long) methodLength.invoke(methodGetBody.invoke(methodRaw.invoke(r5, new Object[0]), new Object[0]), new Object[0])).longValue();     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        long r24 = (1000 * r2) / r23;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        if (sSampleDebugLog != 1) goto L30;
        System.out.println("TTNETScoreAPI:weaknetwork_interceptor reply=" + r20 + ",requestCost=" + r23 + ",len=" + r2 + ",speed=" + r24);     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
    L30:
        r3.speed = r24;     // Catch: ClassNotFoundException -> L32 IllegalAccessException -> L34 NoSuchMethodException -> L36 InvocationTargetException -> L42
        goto L39
    }

    public static synchronized boolean isAppContainsTtnet() {
        monitor-enter(TTNETScoreAPI.class);
        boolean r3 = true;
        if (sAddInterceptor != null) goto L7;
    L12:
        AnonymousClass1 r4 = null;
        Class<?> r5 = Class.forName("com.bytedance.ttnet.utils.RetrofitUtils");     // Catch: Exception -> L15 Throwable -> L20
        Class<?> r6 = Class.forName("com.bytedance.retrofit2.intercept.Interceptor");     // Catch: Exception -> L15 Throwable -> L20
        sInterceptor = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{r6}, new MyInterceptorHandler(r4));     // Catch: Exception -> L15 Throwable -> L20
        sAddInterceptor = r5.getDeclaredMethod("addInterceptor", new Class[]{r6});     // Catch: Exception -> L15 Throwable -> L20
        sRemoveInterceptor = r5.getDeclaredMethod("removeInterceptor", new Class[]{r6});     // Catch: Exception -> L15 Throwable -> L20
        sAddInterceptor.setAccessible(true);     // Catch: Exception -> L15 Throwable -> L20
        sRemoveInterceptor.setAccessible(true);     // Catch: Exception -> L15 Throwable -> L20
    L17:
        System.out.println("TTNETScoreAPI:isAppContainsTtnet = " + r3);     // Catch: Throwable -> L20
        sAppSupportTTNET = r3;     // Catch: Throwable -> L20
        monitor-exit(TTNETScoreAPI.class);
        return r3;
    L15:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L20
        sAddInterceptor = null;     // Catch: Throwable -> L20
        sRemoveInterceptor = null;     // Catch: Throwable -> L20
        sInterceptor = null;     // Catch: Throwable -> L20
        r3 = false;
        goto L17
    L7:
        if (sRemoveInterceptor == null) goto L12;
        if (sInterceptor == null) goto L12;
        monitor-exit(TTNETScoreAPI.class);
        return true;
    L20:
        th = move-exception;
        throw th;
    }

    public static int getLastScore() {
        if (sAppSupportTTNET == true) goto L5;
        return -2;
    L5:
        return sLastScore;
    }

    public static synchronized void startCheck() {
        monitor-enter(TTNETScoreAPI.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sHasStarted == false) goto L18;
    L12:
        monitor-exit(TTNETScoreAPI.class);
        return;
    L18:
        sAddInterceptor.invoke(null, new Object[]{sInterceptor});     // Catch: Exception -> L8 Throwable -> L14
        sHasStarted = true;     // Catch: Throwable -> L14
        goto L12
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    }

    public static synchronized void stopCheck() {
        monitor-enter(TTNETScoreAPI.class);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (sHasStarted == true) goto L18;
    L12:
        monitor-exit(TTNETScoreAPI.class);
        return;
    L18:
        sRemoveInterceptor.invoke(null, new Object[]{sInterceptor});     // Catch: Exception -> L8 Throwable -> L14
        sHasStarted = false;     // Catch: Throwable -> L14
        goto L12
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    }
}
