package com.android.settings.biometrics;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.SurfaceHolder;
import com.obric.olog.OLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CameraWrapper {
    private static final int EVENT_OPEN_CAMERA = 1;
    private static final int EVENT_START_PREVIEW = 2;
    public static final int IMAGE_HEIGHT = 480;
    public static final int IMAGE_WIDTH = 640;
    public static final int ORIENTATION_90 = 90;
    public static final int RESULT_DISCONNECTED = 2;
    public static final int RESULT_FAILED = 3;
    public static final int RESULT_SUCCESS = 1;
    private static final String TAG = "CameraWrapper";
    private CameraCaptureSession mCameraCaptureSession;
    private CameraDevice mCameraDevice;
    private String mCameraId;
    private CameraManager mCameraManager;
    private CameraOpenCallback mCameraOpenCallback;
    private final CameraDevice.StateCallback mCameraStateCallback;
    private Context mContext;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private ImageReader.OnImageAvailableListener mImageAvailableListener;
    private ImageReader mImageReader;
    private IPreviewCallback mPreviewCallback;
    private SurfaceHolder mSurfaceHolder;
    private Handler mUIHandler;

    public interface CameraOpenCallback {
        void onDisconnected();

        void onOpenFailed();

        void onOpenSuccess();
    }

    public interface IPreviewCallback {
        void onPreviewFrame(byte[] r1);
    }

    public int getAngle() {
        return 90;
    }

    public int getHeight() {
        return 480;
    }

    public int getWidth() {
        return 640;
    }

    public CameraWrapper() {
        this.mCameraStateCallback = new AnonymousClass4(this);
        this.mImageAvailableListener = new AnonymousClass5(this);
    }

    static /* synthetic */ void access$000(CameraWrapper r0) {
        r0.handleOpenCamera();
    }

    static /* synthetic */ void access$100(CameraWrapper r0) {
        r0.handleStartPreview();
    }

    static /* synthetic */ CameraDevice access$200(CameraWrapper r0) {
        return r0.mCameraDevice;
    }

    static /* synthetic */ CameraDevice access$202(CameraWrapper r0, CameraDevice r1) {
        r0.mCameraDevice = r1;
        return r1;
    }

    static /* synthetic */ CameraCaptureSession access$302(CameraWrapper r0, CameraCaptureSession r1) {
        r0.mCameraCaptureSession = r1;
        return r1;
    }

    static /* synthetic */ Handler access$400(CameraWrapper r0) {
        return r0.mHandler;
    }

    static /* synthetic */ CameraOpenCallback access$500(CameraWrapper r0) {
        return r0.mCameraOpenCallback;
    }

    static /* synthetic */ void access$600(CameraWrapper r0, int r1) {
        r0.callbackToCaller(r1);
    }

    static /* synthetic */ IPreviewCallback access$700(CameraWrapper r0) {
        return r0.mPreviewCallback;
    }

    static /* synthetic */ IPreviewCallback access$702(CameraWrapper r0, IPreviewCallback r1) {
        r0.mPreviewCallback = r1;
        return r1;
    }

    public void openCamera(Context r3, CameraOpenCallback r4) {
        OLog.d(TAG, "openCamera");
        initEventLooper(r3);
        this.mContext = r3;
        this.mCameraOpenCallback = r4;
        Message.obtain(this.mHandler, 1).sendToTarget();
    }

    private void initEventLooper(Context r4) {
        OLog.d(TAG, "initEventLooper()...");
        HandlerThread r0 = new HandlerThread(TAG);
        this.mHandlerThread = r0;
        r0.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper(), new AnonymousClass1(this));
        this.mUIHandler = new Handler(r4.getMainLooper());
    }

    private void handleOpenCamera() {
        OLog.d(TAG, "handleOpenCamera()...");
        CameraManager r0 = (CameraManager) this.mContext.getSystemService("camera");
        this.mCameraManager = r0;
        if (r0 != null) goto L6;
        callbackToCaller(3);
        return;
    L6:
        String r1 = selectCamera();
        this.mCameraId = r1;
        if (r1 != null) goto L15;
        OLog.e(TAG, "Camera id is invalid, return!");
        callbackToCaller(3);
        return;
    L15:
        this.mCameraManager.openCamera(r1, this.mCameraStateCallback, this.mHandler);     // Catch: Throwable -> L12
        return;
    L12:
        e = move-exception;
        OLog.e(TAG, "Failed to open Camera");
        e.printStackTrace();
        callbackToCaller(3);
    }

    private void handleStartPreview() {
        OLog.d(TAG, "handleStartPreview()...");
        if (this.mCameraDevice != null) goto L6;
        OLog.e(TAG, "Invalid Camera device");
        return;
    L6:
        ArrayList r0 = new ArrayList();
        r0.add(this.mImageReader.getSurface());
        r0.add(this.mSurfaceHolder.getSurface());
        final CaptureRequest.Builder r2 = this.mCameraDevice.createCaptureRequest(1);     // Catch: Exception -> L9
        r2.addTarget(this.mImageReader.getSurface());     // Catch: Exception -> L9
        r2.addTarget(this.mSurfaceHolder.getSurface());     // Catch: Exception -> L9
        this.mCameraDevice.createCaptureSession(r0, new AnonymousClass2(this, r2), this.mHandler);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "Failed to start preview!");
    }

    private String selectCamera() {
        OLog.d(TAG, "selectBackOrFrontCamera()...");
        String[] r2 = this.mCameraManager.getCameraIdList();     // Catch: CameraAccessException -> L12
        int r3 = r2.length;     // Catch: CameraAccessException -> L12
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L19;
        String r5 = r2[r4];     // Catch: CameraAccessException -> L12
        Integer r6 = (Integer) this.mCameraManager.getCameraCharacteristics(r5).get(CameraCharacteristics.LENS_FACING);     // Catch: CameraAccessException -> L12
        if (r6 != null) goto L8;
    L10:
        OLog.d(TAG, "Camera Id:null");     // Catch: CameraAccessException -> L12
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6.intValue() != 0) goto L10;
        return r5;
    L19:
        return null;
    L12:
        OLog.e(TAG, "Invalid Camera Id");
        return null;
    }

    private void callbackToCaller(final int r3) {
        OLog.d(TAG, "callbackToCaller...");
        Handler r0 = this.mUIHandler;
        if (r0 == null) goto L6;
        r0.post(new AnonymousClass3(this, r3));
        return;
    }

    public void startPreview(SurfaceHolder r3) {
        OLog.d(TAG, "startPreview()...");
        this.mSurfaceHolder = r3;
        initImageReader();
        Message.obtain(this.mHandler, 2).sendToTarget();
    }

    private void initImageReader() {
        ImageReader r0 = ImageReader.newInstance(640, 480, 35, 3);
        this.mImageReader = r0;
        r0.setOnImageAvailableListener(this.mImageAvailableListener, this.mHandler);
    }

    public void closeCamera() {
        OLog.d(TAG, "closeCamera()...");
        stopPreview();
        CameraDevice r0 = this.mCameraDevice;
        if (r0 == null) goto L5;
        r0.close();
        this.mCameraDevice = null;
    L5:
        this.mCameraId = null;
        this.mSurfaceHolder = null;
        this.mCameraOpenCallback = null;
        this.mPreviewCallback = null;
        exitEventLooper();
    }

    public void stopPreview() {
        OLog.d(TAG, "stopPreview()...");
        CameraCaptureSession r0 = this.mCameraCaptureSession;
        if (r0 != null) goto L13;
    L9:
        ImageReader r1 = this.mImageReader;
        if (r1 == null) goto L15;
        r1.close();
        this.mImageReader = null;
        return;
    L15:
        return;
    L13:
        r0.stopRepeating();     // Catch: Exception -> L6
    L8:
        this.mCameraCaptureSession = null;
    L6:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "exception when stop repeating");
        goto L8
    }

    private void exitEventLooper() {
        OLog.d(TAG, "exitEventLooper()...");
        Handler r0 = this.mUIHandler;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        Handler r1 = this.mHandler;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        HandlerThread r2 = this.mHandlerThread;
        if (r2 == null) goto L11;
        r2.quit();
    L11:
        this.mHandlerThread = null;
        this.mHandler = null;
        this.mUIHandler = null;
    }

    public void startDetect(IPreviewCallback r1) {
        setPreviewCallback(r1);
    }

    public void stopDetect() {
        setPreviewCallback(null);
    }

    private void setPreviewCallback(final IPreviewCallback r3) {
        this.mHandler.post(new AnonymousClass6(this, r3));
    }
}
