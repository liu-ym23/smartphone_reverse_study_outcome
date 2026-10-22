package com.android.settings.eyesprotection;

import android.content.Context;
import android.hardware.display.ColorDisplayManager;
import android.text.TextUtils;
import bytedanceos.util.DeviceType;
import com.android.settings.Calibration;
import com.android.settings.ColorProfilesFragment;
import com.android.settings.ExecutorManager;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import com.qti.snapdragon.sdk.display.ColorManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class EyesProtectionAPI {
    private static final String COLOR_MIDDLE_VALUE = "7400";
    private static final String DARWIN_COLOR_MIDDLE_VALUE = "740";
    private static final String TAG = "EyesProtectionAPI";
    private static boolean mIsColorTemperature = false;
    private static int mProgress = 0;
    private static WeakReference<EyesProtectionAPI> sInstanceRef = null;
    private static boolean sIsSetActiveMode = false;
    private final Runnable mAdjustColorTemperature;
    private final Runnable mClose;
    private ColorManager mColorManager;
    private final ColorManager.ColorManagerListener mListener;
    private final Runnable mOpen;
    private final List<Runnable> mPendingTask;
    private final List<Runnable> mTemperaturePendingTask;

    private class GradualTask implements Runnable {
        final boolean mGradualToOn;
        final /* synthetic */ EyesProtectionAPI this$0;

        public GradualTask(EyesProtectionAPI r1, boolean r2) {
            this.this$0 = r1;
            this.mGradualToOn = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            EyesProtectionAPI.access$500(this.this$0, this.mGradualToOn);
        }
    }

    private class SetActiveModeTask implements Runnable {
        private int mModeId;
        final /* synthetic */ EyesProtectionAPI this$0;

        public SetActiveModeTask(EyesProtectionAPI r1, int r2) {
            this.this$0 = r1;
            this.mModeId = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (EyesProtectionAPI.access$100(this.this$0) != null) goto L5;
            return;
        L5:
            EyesProtectionAPI.access$902(true);
            EyesProtectionAPI.access$100(this.this$0).setActiveMode(this.mModeId);
        }
    }

    private class colorTemperatureTask implements Runnable {
        final /* synthetic */ EyesProtectionAPI this$0;

        private colorTemperatureTask(EyesProtectionAPI r1) {
            this.this$0 = r1;
        }

        /* synthetic */ colorTemperatureTask(EyesProtectionAPI r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            Context r0 = SettingsApplication.getContext();
            if (r0 != null) goto L7;
            OLog.e(EyesProtectionAPI.TAG, "try toggle eyes protection but application is not created yet!");
            return;
        L7:
            if (((ColorDisplayManager) r0.getSystemService(ColorDisplayManager.class)) != null) goto L10;
            OLog.e(EyesProtectionAPI.TAG, "colorDisplayManager is null");
            return;
        L10:
            EyesProtectionAPI.access$800(this.this$0, r0, false);
        }
    }

    static {
    }

    static /* synthetic */ ColorManager.ColorManagerListener access$000(EyesProtectionAPI r0) {
        return r0.mListener;
    }

    static /* synthetic */ ColorManager access$100(EyesProtectionAPI r0) {
        return r0.mColorManager;
    }

    static /* synthetic */ ColorManager access$102(EyesProtectionAPI r0, ColorManager r1) {
        r0.mColorManager = r1;
        return r1;
    }

    static /* synthetic */ boolean access$200() {
        return mIsColorTemperature;
    }

    static /* synthetic */ void access$300(EyesProtectionAPI r0) {
        r0.runTemperaturePendingTaskIfNeed();
    }

    static /* synthetic */ void access$400(EyesProtectionAPI r0) {
        r0.runPendingTaskIfNeed();
    }

    static /* synthetic */ void access$500(EyesProtectionAPI r0, boolean r1) {
        r0.eyesProtectionByColorDisplayManager(r1);
    }

    static /* synthetic */ void access$600(EyesProtectionAPI r0, boolean r1) {
        r0.gradual(r1);
    }

    static /* synthetic */ int access$800(EyesProtectionAPI r0, Context r1, boolean r2) {
        return r0.getCurrentColor(r1, r2);
    }

    static /* synthetic */ boolean access$902(boolean r0) {
        sIsSetActiveMode = r0;
        return r0;
    }

    public static boolean isEyesProtectionEnabled() {
        Context r0 = SettingsApplication.getContext();
        if (r0 != null) goto L6;
        OLog.e(TAG, "try toggle eyes protection but application is not created yet!");
        return false;
    L6:
        ColorDisplayManager r1 = (ColorDisplayManager) r0.getSystemService(ColorDisplayManager.class);
        if (r1 != null) goto L11;
        OLog.e(TAG, "colorDisplayManager is null");
        return false;
    L11:
        return r1.isNightDisplayActivated();
    }

    public static void openEyesProtection() {
        Context r0 = SettingsApplication.getContext();
        if (r0 != null) goto L6;
        OLog.e(TAG, "try toggle eyes protection but application is not created yet!");
        return;
    L6:
        ColorDisplayManager r1 = (ColorDisplayManager) r0.getSystemService(ColorDisplayManager.class);
        if (r1 != null) goto L10;
        OLog.e(TAG, "colorDisplayManager is null");
        return;
    L10:
        r1.setNightDisplayActivated(true);
    }

    public static void closeEyesProtection() {
        Context r0 = SettingsApplication.getContext();
        if (r0 != null) goto L6;
        OLog.e(TAG, "try toggle eyes protection but application is not created yet!");
        return;
    L6:
        ColorDisplayManager r1 = (ColorDisplayManager) r0.getSystemService(ColorDisplayManager.class);
        if (r1 != null) goto L10;
        OLog.e(TAG, "colorDisplayManager is null");
        return;
    L10:
        r1.setNightDisplayActivated(false);
    }

    private static EyesProtectionAPI getInstance() {
        WeakReference<EyesProtectionAPI> r0 = sInstanceRef;
        if (r0 != null) goto L5;
        EyesProtectionAPI r1 = null;
    L6:
        if (r1 != null) goto L9;
        EyesProtectionAPI r2 = new EyesProtectionAPI();
        sInstanceRef = new WeakReference(r2);
        return r2;
    L9:
        return r1;
    L5:
        r1 = r0.get();
        goto L6
    }

    private EyesProtectionAPI() {
        this.mPendingTask = new ArrayList(2);
        this.mTemperaturePendingTask = new ArrayList();
        this.mListener = new AnonymousClass2(this);
        this.mOpen = new AnonymousClass3(this);
        this.mClose = new AnonymousClass4(this);
        this.mAdjustColorTemperature = new AnonymousClass5(this);
        ExecutorManager.execute(new AnonymousClass1(this));
    }

    private void runPendingTaskIfNeed() {
        List<Runnable> r0 = this.mPendingTask;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mPendingTask.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        Iterator<Runnable> r2 = this.mPendingTask.iterator();     // Catch: Throwable -> L14
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().run();     // Catch: Throwable -> L14
        r2.remove();     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    private void gradual(boolean r2) {
        ExecutorManager.execute(new GradualTask(this, r2), true);
    }

    private void open() {
        List<Runnable> r0 = this.mPendingTask;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mColorManager == null) goto L7;
        this.mOpen.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (this.mPendingTask.contains(this.mOpen) == false) goto L9;
        this.mPendingTask.remove(this.mOpen);     // Catch: Throwable -> L13
    L9:
        this.mPendingTask.add(this.mOpen);     // Catch: Throwable -> L13
        goto L11
    }

    private void close() {
        List<Runnable> r0 = this.mPendingTask;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mColorManager == null) goto L7;
        this.mClose.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (this.mPendingTask.contains(this.mClose) == false) goto L9;
        this.mPendingTask.remove(this.mClose);     // Catch: Throwable -> L13
    L9:
        this.mPendingTask.add(this.mClose);     // Catch: Throwable -> L13
        goto L11
    }

    public void setProgress(int r1) {
        mProgress = r1;
    }

    private void runTemperaturePendingTaskIfNeed() {
        List<Runnable> r0 = this.mTemperaturePendingTask;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mTemperaturePendingTask.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        Iterator<Runnable> r2 = this.mTemperaturePendingTask.iterator();     // Catch: Throwable -> L14
    L10:
        if (r2.hasNext() == false) goto L12;
        r2.next().run();     // Catch: Throwable -> L14
        r2.remove();     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
    }

    public void adjustColorTemperature() {
        List<Runnable> r0 = this.mTemperaturePendingTask;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mColorManager == null) goto L7;
        this.mAdjustColorTemperature.run();     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L7:
        if (this.mTemperaturePendingTask.contains(this.mAdjustColorTemperature) == false) goto L9;
        this.mTemperaturePendingTask.remove(this.mAdjustColorTemperature);     // Catch: Throwable -> L13
    L9:
        this.mTemperaturePendingTask.add(this.mAdjustColorTemperature);     // Catch: Throwable -> L13
        goto L11
    }

    public static EyesProtectionAPI getInstance(boolean r0) {
        mIsColorTemperature = r0;
        return getInstance();
    }

    private static void restoreColorMode() {
        Context r0 = SettingsApplication.getContext();
        int r1 = Utils.getPreviousColorMode(r0);
        if (SettingsFeature.isEyesProtectionRejectColorMode() == true) goto L5;
        return;
    L5:
        if (r1 == 1) goto L9;
        Calibration.setColorMode(r1);
        Utils.setCurrentColorMode(r0, r1);
        return;
    }

    private void eyesProtectionByColorDisplayManager(boolean r3) {
        sIsSetActiveMode = false;
        Context r2 = SettingsApplication.getContext();
        if (r2 != null) goto L6;
        OLog.e(TAG, "try toggle eyes protection but application is not created yet!");
        return;
    L6:
        ColorDisplayManager r4 = (ColorDisplayManager) r2.getSystemService(ColorDisplayManager.class);
        if (r4 != null) goto L10;
        OLog.e(TAG, "colorDisplayManager is null");
        return;
    L10:
        r4.setNightDisplayActivated(r3);
    }

    private String getColorMiddleValue() {
        if (DeviceType.is(DeviceType.DELTA) == false) goto L6;
        return COLOR_MIDDLE_VALUE;
    L6:
        return DARWIN_COLOR_MIDDLE_VALUE;
    }

    private int getCurrentColor(Context r2, boolean r3) {
        String r4 = ColorProfilesFragment.getCalibrationValuesFromDb(r2);
        if (TextUtils.isEmpty(r4) == false) goto L5;
        r4 = getColorMiddleValue();
    L5:
        if (r3 == false) goto L8;
        return Integer.parseInt(r4);
    L8:
        return mProgress;
    }

    public void setActiveMode(int r3) {
        SetActiveModeTask r0 = new SetActiveModeTask(this, r3);
        List<Runnable> r4 = this.mTemperaturePendingTask;
        monitor-enter(r4);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mColorManager != null) goto L7;
        this.mTemperaturePendingTask.remove(r0);     // Catch: Throwable -> L10
        this.mTemperaturePendingTask.add(r0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r4);     // Catch: Throwable -> L10
        return;
    L7:
        r0.run();     // Catch: Throwable -> L10
        goto L8
    }
}
