package com.bytedance.bdlocation.sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.ThreadLooperManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class SensorInfoManager {
    public static final int SENSOR_DELAY_FASTEST = 0;
    public static final int SENSOR_DELAY_GAME = 1;
    public static final int SENSOR_DELAY_NORMAL = 3;
    public static final int SENSOR_DELAY_UI = 2;
    public static final int TYPE_LIGHT = 5;
    private static volatile SensorInfoManager sInstance;
    private IBPEALocal mBPEAManager;
    private Context mContext;
    private Handler mHandler;
    private final Queue<LightInfo> mLightInfoQueue;
    private Sensor mLightSensor;
    private SensorCollectListener mSensorCollectListener;
    private SensorManager mSensorManager;
    private TimeOutTask mTimeOutTask;

    /* JADX INFO: renamed from: com.bytedance.bdlocation.sensor.SensorInfoManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class SensorCollectListener implements SensorEventListener {
        final /* synthetic */ SensorInfoManager this$0;

        private SensorCollectListener(SensorInfoManager r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SensorCollectListener(SensorInfoManager r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor r1, int r2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent r4) {
            if (r4.sensor.getType() != 5) goto L10;
            Logger.i("SensorInfoManager: onSensorChanged light");
            LightInfo r0 = new LightInfo();
            r0.lightValue = r4.values[0];
            r0.timestamp = System.currentTimeMillis();
            if (SensorInfoManager.access$100(this.this$0).size() < BDLocationConfig.getMaxLightCount()) goto L8;
            Logger.i("SensorInfoManager: light info count is more than " + BDLocationConfig.getMaxLightCount());
            SensorInfoManager.access$100(this.this$0).poll();
        L8:
            SensorInfoManager.access$100(this.this$0).offer(r0);
            return;
        }
    }

    private class TimeOutTask implements Runnable {
        private int mSensorType;
        final /* synthetic */ SensorInfoManager this$0;

        public TimeOutTask(SensorInfoManager r1, int r2) {
            this.this$0 = r1;
            this.mSensorType = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Logger.i("SensorInfoManager: collect sensor info timeout and sensor type is: " + this.mSensorType);
            this.this$0.unregisterListener(this.mSensorType);
        }
    }

    static {
    }

    private SensorInfoManager(Context r2) {
        this.mLightInfoQueue = new ConcurrentLinkedQueue();
        this.mContext = r2;
        if (r2 != null) goto L6;
        Logger.i("Context is null!");
        return;
    L6:
        this.mSensorManager = (SensorManager) r2.getSystemService("sensor");
        this.mSensorCollectListener = new SensorCollectListener(this, null);
        this.mHandler = new Handler(ThreadLooperManager.getSensorCollectWorker());
        this.mBPEAManager = BDLocationExtrasService.getBPEAManager();
    }

    static /* synthetic */ Queue access$100(SensorInfoManager r0) {
        return r0.mLightInfoQueue;
    }

    public static SensorInfoManager getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(SensorInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new SensorInfoManager(BDLocationConfig.getContext());     // Catch: Throwable -> L11
    L9:
        monitor-exit(SensorInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public List<LightInfo> getLightInfoList() {
        return new LinkedList(this.mLightInfoQueue);
    }

    public synchronized void registerListener(int r6) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: registerListener and sensor type is: " + r6);     // Catch: Throwable -> L21 Exception -> L23
        if (r6 != 5) goto L25;
        this.mLightInfoQueue.clear();     // Catch: Throwable -> L21 Exception -> L23
        if (BDLocationConfig.isCollectLightInfo() == false) goto L25;
        SensorManager r7 = this.mSensorManager;     // Catch: Throwable -> L21 Exception -> L23
        if (r7 == null) goto L25;
        this.mLightSensor = this.mBPEAManager.getDefaultSensor(r7, 5, null);     // Catch: Throwable -> L21 Exception -> L23
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L21 Exception -> L23
        r8.append("SensorInfoManager: registerListener and light sensor: ");     // Catch: Throwable -> L21 Exception -> L23
        if (this.mLightSensor == null) goto L13;
        boolean r1 = true;
    L14:
        r8.append(r1);     // Catch: Throwable -> L21 Exception -> L23
        Logger.i(r8.toString());     // Catch: Throwable -> L21 Exception -> L23
        Sensor r9 = this.mLightSensor;     // Catch: Throwable -> L21 Exception -> L23
        if (r9 == null) goto L25;
        this.mSensorManager.registerListener(this.mSensorCollectListener, r9, BDLocationConfig.getLightInfoInterval(), this.mHandler);     // Catch: Throwable -> L21 Exception -> L23
        if (this.mTimeOutTask != null) goto L19;
        this.mTimeOutTask = new TimeOutTask(this, 5);     // Catch: Throwable -> L21 Exception -> L23
    L19:
        this.mHandler.postDelayed(this.mTimeOutTask, BDLocationConfig.getMaxLightDuration());     // Catch: Throwable -> L21 Exception -> L23
    L13:
        r1 = false;
    L25:
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    L23:
        e = move-exception;
        Logger.e("SensorInfoManager: registerListener error", e);     // Catch: Throwable -> L21
        goto L25
    }

    public synchronized void unregisterListener(int r3) {
        monitor-enter(this);
        Logger.i("SensorInfoManager: unregisterListener and sensor type is: " + r3);     // Catch: Throwable -> L13 Exception -> L15
        if (r3 == 5) goto L7;
    L17:
        monitor-exit(this);
        return;
    L7:
        if (BDLocationConfig.isCollectLightInfo() == false) goto L11;
        SensorManager r4 = this.mSensorManager;     // Catch: Throwable -> L13 Exception -> L15
        if (r4 == null) goto L11;
        r4.unregisterListener(this.mSensorCollectListener, this.mLightSensor);     // Catch: Throwable -> L13 Exception -> L15
        Logger.i("SensorInfoManager: unregisterListener and light sensor");     // Catch: Throwable -> L13 Exception -> L15
    L11:
        this.mLightSensor = null;     // Catch: Throwable -> L13 Exception -> L15
    L13:
        th = move-exception;
        throw th;
    L15:
        e = move-exception;
        Logger.e("SensorInfoManager: unregisterListener error", e);     // Catch: Throwable -> L13
        goto L17
    }
}
