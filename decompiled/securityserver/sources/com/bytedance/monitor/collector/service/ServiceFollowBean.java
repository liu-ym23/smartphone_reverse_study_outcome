package com.bytedance.monitor.collector.service;

import a.a;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.Message;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public class ServiceFollowBean {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Field mFieldBindServiceDataToken;
    private static Field mFieldCreateServiceDataToken;
    private static Field mFieldCreateServiceInfo;
    private static Field mFieldDumpComponentInfoToken;
    private static Field mFieldServiceArgsDataToken;
    private static Field mFieldUnBindServiceDataToken;
    public String mServiceName;
    public String mThreadName;
    public long mTimeStamp;
    public String mToken;
    public int mWhat;

    public ServiceFollowBean() {
    }

    public static ServiceFollowBean fetchServiceName(Message r14) {
        switch(r14.what) {
            case 114: goto L39;
            case 115: goto L32;
            case 116: goto L30;
            case 117: goto L7;
            case 118: goto L7;
            case 119: goto L7;
            case 120: goto L7;
            case 121: goto L23;
            case 122: goto L16;
            case 123: goto L9;
            default: goto L7;
        };
    L7:
        throw new IllegalArgumentException("message.what = " + r14.what + " is not excepted!");     // Catch: Throwable -> L53
    L9:
        if (mFieldDumpComponentInfoToken != null) goto L11;
        mFieldDumpComponentInfoToken = DoubleReflectHelper.getField(r14.obj.getClass(), AccountInfoBundleKey.TOKEN);     // Catch: Throwable -> L53
    L11:
        IBinder r0 = (IBinder) mFieldDumpComponentInfoToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r0 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r0), r14.what, System.currentTimeMillis(), r0.toString());
    L16:
        if (mFieldUnBindServiceDataToken != null) goto L18;
        mFieldUnBindServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), AccountInfoBundleKey.TOKEN);     // Catch: Throwable -> L53
    L18:
        IBinder r1 = (IBinder) mFieldUnBindServiceDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r1 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r1), r14.what, System.currentTimeMillis(), r1.toString());
    L23:
        if (mFieldBindServiceDataToken != null) goto L25;
        mFieldBindServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), AccountInfoBundleKey.TOKEN);     // Catch: Throwable -> L53
    L25:
        IBinder r2 = (IBinder) mFieldBindServiceDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r2 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r2), r14.what, System.currentTimeMillis(), r2.toString());
    L30:
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName((IBinder) r14.obj), r14.what, System.currentTimeMillis(), r14.obj.toString());
    L32:
        if (mFieldServiceArgsDataToken != null) goto L34;
        mFieldServiceArgsDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), AccountInfoBundleKey.TOKEN);     // Catch: Throwable -> L53
    L34:
        IBinder r3 = (IBinder) mFieldServiceArgsDataToken.get(r14.obj);     // Catch: Throwable -> L53
        if (r3 == null) goto L52;
        return new ServiceFollowBean(ServiceTrackMonitor.getInstance().getServiceComponentName(r3), r14.what, System.currentTimeMillis(), r3.toString());
    L39:
        if (mFieldCreateServiceInfo != null) goto L42;
        mFieldCreateServiceInfo = DoubleReflectHelper.getField(r14.obj.getClass(), AlogMonitor.ALOG_RESULT_INFO);     // Catch: Throwable -> L53
    L42:
        if (mFieldCreateServiceDataToken != null) goto L44;
        mFieldCreateServiceDataToken = DoubleReflectHelper.getField(r14.obj.getClass(), AccountInfoBundleKey.TOKEN);     // Catch: Throwable -> L53
    L44:
        ServiceInfo r4 = (ServiceInfo) mFieldCreateServiceInfo.get(r14.obj);     // Catch: Throwable -> L53
        if (r4 == null) goto L48;
        String r5 = r4.name;     // Catch: Throwable -> L53
    L50:
        return new ServiceFollowBean(r5, r14.what, System.currentTimeMillis(), mFieldCreateServiceDataToken.get(r14.obj).toString());
    L48:
        r5 = null;
    L52:
        return new ServiceFollowBean("unknow", r14.what, System.currentTimeMillis(), "unknow");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("ServiceFollowBean{mServiceName='");
        r0.append(this.mServiceName);
        r0.append("', mWhat=");
        r0.append(this.mWhat);
        r0.append(", mTimeStamp=");
        r0.append(this.mTimeStamp);
        r0.append(", mToken='");
        r0.append(this.mToken);
        r0.append("', mThreadName='");
        return a.o(r0, this.mThreadName, "'}");
    }

    public ServiceFollowBean(String r1, int r2, long r3, String r5) {
        this.mServiceName = r1;
        this.mWhat = r2;
        this.mTimeStamp = r3;
        this.mToken = r5;
        this.mThreadName = Thread.currentThread().getName();
    }
}
