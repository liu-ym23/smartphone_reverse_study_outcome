package com.bytedance.networkstackapplib;

import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.PrintStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
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
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface IWeakNetworkCallBack {
        void onScoreChange(int r1);
    }

    public static class MyInterceptorHandler implements InvocationHandler {
        private MyInterceptorHandler() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r3, Method r4, Object[] r5) {
        L6:
            e = move-exception;
            e.printStackTrace();
            throw e;
        L3:
            if (r4.getName().equals("intercept") == false) goto L10;
            return TTNETScoreAPI.access$000(r5[0]);
        L10:
            if (r4.getName().equals("equals") == false) goto L18;
            if (r5[0].toString().equals(TTNETScoreAPI.INTERCEPTOR_NAME) == false) goto L16;
            return Boolean.TRUE;
        L16:
            return Boolean.FALSE;
        L18:
            if (r4.getName().equals("toString") == false) goto L21;
            return TTNETScoreAPI.INTERCEPTOR_NAME;
        L21:
            if (r4.getName().equals("hashCode") == false) goto L25;
            return -1425398335;
        L25:
            return r4.invoke(this, r5);
        }

        public /* synthetic */ MyInterceptorHandler(AnonymousClass1 r1) {
            this();
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

        public boolean isHealthy(long r10) {
            if (this.hasException == false) goto L5;
            return false;
        L5:
            long r2 = this.speed;
            if (r2 <= TTNETScoreAPI.sSampleSpeed) goto L9;
            return true;
        L9:
            if (this.costTime == 0) goto L11;
        L21:
            long r3 = this.costTime;
            if (r3 != 0) goto L25;
            r3 = r10 - this.startTime;
        L25:
            if (r3 <= this.badTime) goto L27;
            return false;
        L27:
            return true;
        L11:
            if (r2 != 0) goto L21;
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

    public TTNETScoreAPI() {
    }

    public static /* synthetic */ Object access$000(Object r0) {
        return handleRequest(r0);
    }

    private static int getIntSystemProperties(String r4) {
        Method r0 = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
        return ((Integer) r0.invoke(null, new Object[]{r4, 0})).intValue();
    L4:
        e = move-exception;
        e.printStackTrace();
        return -1;
    }

    public static int getLastScore() {
        if (sAppSupportTTNET == true) goto L5;
        return -2;
    L5:
        return sLastScore;
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

    private static Object handleRequest(Object r14) {
        long r1 = System.currentTimeMillis();
        MyReqInfo r3 = new MyReqInfo();
        Object r5 = null;
    L12:
        e = move-exception;
        isReflectSuccess = true;
        System.currentTimeMillis();
        r3.hasException = true;
        throw e.getTargetException();
    L6:
        e = e;
    L47:
        e.printStackTrace();
    L48:
        Object r15 = r5;
    L52:
        if (isReflectSuccess == true) goto L54;
        stopCheck();
    L54:
        return r15;
    L8:
        e = e;
    L49:
        e.printStackTrace();
    L10:
        e = e;
    L50:
        e.printStackTrace();
        goto L48
    L4:
        if (sInitForReflect == true) goto L14;
        Method r11 = Interceptor.Chain.class.getDeclaredMethod("request", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodRequset = r11;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r11.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r12 = Request.class.getDeclaredMethod("getPath", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodGetPath = r12;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r12.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r6 = Interceptor.Chain.class.getDeclaredMethod("proceed", new Class[]{Request.class});     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodProceed = r6;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r6.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r7 = SsResponse.class.getDeclaredMethod("isSuccessful", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodIsSuccessful = r7;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r7.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r8 = SsResponse.class.getDeclaredMethod("raw", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodRaw = r8;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r8.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r9 = Response.class.getDeclaredMethod("getBody", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodGetBody = r9;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r9.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Method r10 = TypedInput.class.getDeclaredMethod("length", null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        methodLength = r10;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r10.setAccessible(true);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        sInitForReflect = true;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        initForWeakNetParam();     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
    L14:
        Object r13 = methodRequset.invoke(r14, null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        Object r16 = methodGetPath.invoke(r13, null);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        int r17 = mSequenceNumber.incrementAndGet();     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r3.path = (String) r16;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r3.reqId = r17;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        long r18 = getPathBadCostTime((String) r16);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        r3.badTime = r18;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        if (r18 <= 0) goto L25;
        Object r19 = sWeakNetLock;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        monitor-enter(r19);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        sSampleReqs.append(r3);     // Catch: Throwable -> L21
        monitor-exit(r19);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
    L25:
        if ((r17 % sSampleCircle) != 0) goto L33;
        int r20 = isWeakNetwork();     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        if (r20 <= 0) goto L33;
        if (getScoreLevel(r20) == getScoreLevel(sLastScore)) goto L33;
        if (Math.abs(r20 - sLastScore) <= 12) goto L33;
        sLastScore = r20;     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        notifyScoreChange(r20);     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
    L33:
        r15 = methodProceed.invoke(r14, new Object[]{r13});     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12
        isReflectSuccess = true;     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
        long r21 = System.currentTimeMillis() - r1;     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
        r3.costTime = r21;     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
        if (((Boolean) methodIsSuccessful.invoke(r15, null)).booleanValue() == false) goto L52;
        long r2 = ((Long) methodLength.invoke(methodGetBody.invoke(methodRaw.invoke(r15, null), null), null)).longValue();     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
        long r22 = (1000 * r2) / r21;     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
        if (sSampleDebugLog != 1) goto L45;
        System.out.println("TTNETScoreAPI:weaknetwork_interceptor reply=" + r16 + ",requestCost=" + r21 + ",len=" + r2 + ",speed=" + r22);     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
    L45:
        r3.speed = r22;     // Catch: InvocationTargetException -> L12 ClassNotFoundException -> L39 IllegalAccessException -> L41 NoSuchMethodException -> L43
    L39:
        e = move-exception;
        r5 = r15;
        e = e;
    L41:
        e = move-exception;
        r5 = r15;
        e = e;
    L43:
        e = move-exception;
        r5 = r15;
        e = e;
        goto L50
    }

    private static void initForWeakNetParam() {
        ParamConfig r0 = mConfigByApp;     // Catch: Exception -> L5
        if (r0 == null) goto L7;
        sSampleCircle = r0.configCircle;     // Catch: Exception -> L5
        sSampleSize = r0.configSize;     // Catch: Exception -> L5
        sSampleTimeFeed = r0.configTimeFeed;     // Catch: Exception -> L5
        sSampleTimeImg = r0.configTimeImg;     // Catch: Exception -> L5
        sSampleTimeNormal = r0.configTimeNormal;     // Catch: Exception -> L5
        sSampleSpeed = r0.configGoodSpeed;     // Catch: Exception -> L5
        sSampleGapTime = r0.configGapTime;     // Catch: Exception -> L5
        sSampleDebugLog = r0.configDebugLog;     // Catch: Exception -> L5
    L34:
        if (sSampleSize >= 10) goto L36;
        sSampleSize = 10;
    L36:
        sSampleReqs = new RingBuffer(MyReqInfo.class, sSampleSize);
        return;
    L7:
        int r1 = getIntSystemProperties("debug.weaknet.circle");     // Catch: Exception -> L5
        if (r1 <= 0) goto L10;
        sSampleCircle = r1;     // Catch: Exception -> L5
    L10:
        int r2 = getIntSystemProperties("debug.weaknet.size");     // Catch: Exception -> L5
        if (r2 <= 0) goto L13;
        sSampleSize = r2;     // Catch: Exception -> L5
    L13:
        int r3 = getIntSystemProperties("debug.weaknet.feed");     // Catch: Exception -> L5
        if (r3 <= 0) goto L16;
        sSampleTimeFeed = r3;     // Catch: Exception -> L5
    L16:
        int r4 = getIntSystemProperties("debug.weaknet.img");     // Catch: Exception -> L5
        if (r4 <= 0) goto L19;
        sSampleTimeImg = r4;     // Catch: Exception -> L5
    L19:
        int r5 = getIntSystemProperties("debug.weaknet.normal");     // Catch: Exception -> L5
        if (r5 <= 0) goto L22;
        sSampleTimeNormal = r5;     // Catch: Exception -> L5
    L22:
        int r6 = getIntSystemProperties("debug.weaknet.speed");     // Catch: Exception -> L5
        if (r6 <= 0) goto L25;
        sSampleSpeed = r6;     // Catch: Exception -> L5
    L25:
        int r7 = getIntSystemProperties("debug.weaknet.gaptime");     // Catch: Exception -> L5
        if (r7 <= 0) goto L28;
        sSampleGapTime = r7;     // Catch: Exception -> L5
    L28:
        int r8 = getIntSystemProperties("debug.weaknet.debuglog");     // Catch: Exception -> L5
        if (r8 < 0) goto L34;
        sSampleDebugLog = r8;     // Catch: Exception -> L5
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    public static synchronized boolean isAppContainsTtnet() {
        monitor-enter(TTNETScoreAPI.class);
        boolean r3 = true;
        if (sAddInterceptor != null) goto L7;
    L14:
        AnonymousClass1 r2 = null;
        String r5 = RetrofitUtils.CONTENT_TYPE_JSON;     // Catch: Throwable -> L12 Exception -> L17
        sInterceptor = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{Interceptor.class}, new MyInterceptorHandler(r2));     // Catch: Throwable -> L12 Exception -> L17
        sAddInterceptor = RetrofitUtils.class.getDeclaredMethod("addInterceptor", new Class[]{Interceptor.class});     // Catch: Throwable -> L12 Exception -> L17
        sRemoveInterceptor = RetrofitUtils.class.getDeclaredMethod("removeInterceptor", new Class[]{Interceptor.class});     // Catch: Throwable -> L12 Exception -> L17
        sAddInterceptor.setAccessible(true);     // Catch: Throwable -> L12 Exception -> L17
        sRemoveInterceptor.setAccessible(true);     // Catch: Throwable -> L12 Exception -> L17
    L19:
        System.out.println("TTNETScoreAPI:isAppContainsTtnet = " + r3);     // Catch: Throwable -> L12
        sAppSupportTTNET = r3;     // Catch: Throwable -> L12
        monitor-exit(TTNETScoreAPI.class);
        return r3;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L12
        sAddInterceptor = null;     // Catch: Throwable -> L12
        sRemoveInterceptor = null;     // Catch: Throwable -> L12
        sInterceptor = null;     // Catch: Throwable -> L12
        r3 = false;
        goto L19
    L7:
        if (sRemoveInterceptor == null) goto L14;
        if (sInterceptor == null) goto L14;
        monitor-exit(TTNETScoreAPI.class);
        return true;
    L12:
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
        PrintStream r13 = System.out;
        r13.println("TTNETScoreAPI: gaptime =" + r5);
        r13.println("TTNETScoreAPI: successCount = " + r10 + ",badcount = " + (r2 - r10));
        Iterator r14 = r3.iterator();
    L35:
        if (r14.hasNext() == false) goto L37;
        String r15 = (String) r14.next();
        System.out.println("TTNETScoreAPI: goodReqs = " + r15);
        goto L35
    L37:
        Iterator r16 = r4.iterator();
    L39:
        if (r16.hasNext() == false) goto L41;
        String r17 = (String) r16.next();
        System.out.println("TTNETScoreAPI: badReqs = " + r17);
    L42:
        th = move-exception;
        throw th;
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

    public static synchronized boolean registerWeakNetworkCallBack(IWeakNetworkCallBack r2) {
        monitor-enter(TTNETScoreAPI.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sAllCallbacks.contains(r2) == true) goto L10;
        sAllCallbacks.add(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(TTNETScoreAPI.class);
        return true;
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

    public static synchronized void startCheck() {
        monitor-enter(TTNETScoreAPI.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sHasStarted == false) goto L19;
    L15:
        monitor-exit(TTNETScoreAPI.class);
        return;
    L19:
        sAddInterceptor.invoke(null, new Object[]{sInterceptor});     // Catch: Throwable -> L9 Exception -> L11
    L8:
        sHasStarted = true;     // Catch: Throwable -> L9
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    }

    public static synchronized void stopCheck() {
        monitor-enter(TTNETScoreAPI.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sHasStarted == true) goto L19;
    L15:
        monitor-exit(TTNETScoreAPI.class);
        return;
    L19:
        sRemoveInterceptor.invoke(null, new Object[]{sInterceptor});     // Catch: Throwable -> L9 Exception -> L11
    L8:
        sHasStarted = false;     // Catch: Throwable -> L9
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L9
    }

    public static synchronized boolean unregisterWeakNetworkCallBack(IWeakNetworkCallBack r2) {
        monitor-enter(TTNETScoreAPI.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (sAllCallbacks.contains(r2) == false) goto L10;
        sAllCallbacks.remove(r2);     // Catch: Throwable -> L8
    L10:
        monitor-exit(TTNETScoreAPI.class);
        return true;
    }
}
