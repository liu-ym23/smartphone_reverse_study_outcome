package com.android.settingslib.qrcode;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.ArrayMap;
import android.util.Size;
import android.view.WindowManager;
import com.GlobalProxyLancet;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: loaded from: classes.dex */
public class QrCamera extends Handler {
    private static final long AUTOFOCUS_INTERVAL_MS = 1500;
    private static List<BarcodeFormat> FORMATS = null;
    private static Map<DecodeHintType, List<BarcodeFormat>> HINTS = null;
    private static final double MAX_RATIO_DIFF = 0.1d;
    private static final int MSG_AUTO_FOCUS = 1;
    private static final String TAG = "QrCamera";
    Camera mCamera;
    private int mCameraOrientation;
    private WeakReference<Context> mContext;
    private DecodingTask mDecodeTask;
    Camera.Parameters mParameters;
    private Size mPreviewSize;
    private MultiFormatReader mReader;
    private ScannerCallback mScannerCallback;

    /* JADX INFO: renamed from: com.android.settingslib.qrcode.QrCamera$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class DecodingTask extends AsyncTask<Void, Void, String> {
        private QrYuvLuminanceSource mImage;
        private SurfaceTexture mSurface;
        final /* synthetic */ QrCamera this$0;

        /* synthetic */ DecodingTask(QrCamera r1, SurfaceTexture r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ String doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(String r1) {
            onPostExecute2(r1);
        }

        private DecodingTask(QrCamera r1, SurfaceTexture r2) {
            this.this$0 = r1;
            this.mSurface = r2;
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected String doInBackground2(Void... r5) {
            if (initCamera(this.mSurface) == true) goto L5;
            return null;
        L5:
            final Semaphore r6 = new Semaphore(0);
        L6:
            this.this$0.mCamera.setOneShotPreviewCallback(new QrCamera$DecodingTask$$ExternalSyntheticLambda0(this, r6));
            r6.acquire();     // Catch: InterruptedException -> L15
            Result r1 = decodeQrCode(this.mImage);     // Catch: InterruptedException -> L15
            if (r1 != null) goto L10;
            r1 = decodeQrCode(this.mImage.invert());     // Catch: InterruptedException -> L15
        L10:
            if (r1 == null) goto L6;
            if (QrCamera.access$100(this.this$0).isValid(r1.getText()) == false) goto L6;
            return r1.getText();
        L15:
            Thread.currentThread().interrupt();
            return null;
        }

        /* JADX INFO: renamed from: lambda$doInBackground$0$com-android-settingslib-qrcode-QrCamera$DecodingTask, reason: not valid java name */
        /* synthetic */ void m771x41d99441(Semaphore r1, byte[] r2, Camera r3) {
            this.mImage = QrCamera.access$700(this.this$0, r2);
            r1.release();
        }

        private Result decodeQrCode(LuminanceSource r4) {
            Result r5 = QrCamera.access$200(this.this$0).decodeWithState(new BinaryBitmap(new HybridBinarizer(r4)));     // Catch: Throwable -> L5 ReaderException -> L8
            QrCamera.access$200(this.this$0).reset();
            return r5;
        L8:
            QrCamera.access$200(this.this$0).reset();
            return null;
        L5:
            th = move-exception;
            QrCamera.access$200(this.this$0).reset();
            throw th;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(String r1) {
            if (r1 == null) goto L5;
            QrCamera.access$100(this.this$0).handleSuccessfulResult(r1);
            return;
        }

        private boolean initCamera(SurfaceTexture r8) {
            int r0 = Camera.getNumberOfCameras();
            Camera.CameraInfo r1 = new Camera.CameraInfo();
            int r3 = 0;
        L4:
            if (r3 >= r0) goto L10;
            Camera.getCameraInfo(r3, r1);     // Catch: RuntimeException -> L26
            if (r1.facing == 0) goto L7;
            r3 = r3 + 1;     // Catch: RuntimeException -> L26
            goto L4
        L7:
            QrCamera.access$300(this.this$0);     // Catch: RuntimeException -> L26
            this.this$0.mCamera = Camera.open(r3);     // Catch: RuntimeException -> L26
            QrCamera.access$402(this.this$0, r1.orientation);     // Catch: RuntimeException -> L26
        L26:
            e = move-exception;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(QrCamera.TAG, "Fail to open camera: " + e);
            this.this$0.mCamera = null;
            QrCamera.access$100(this.this$0).handleCameraFailure();
            return false;
        L10:
            if (this.this$0.mCamera != null) goto L31;
            if (r0 <= 0) goto L31;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(QrCamera.TAG, "Can't find back camera. Opening a different camera");     // Catch: RuntimeException -> L26
            Camera.getCameraInfo(0, r1);     // Catch: RuntimeException -> L26
            QrCamera.access$300(this.this$0);     // Catch: RuntimeException -> L26
            this.this$0.mCamera = Camera.open(0);     // Catch: RuntimeException -> L26
            QrCamera.access$402(this.this$0, r1.orientation);     // Catch: RuntimeException -> L26
        L31:
        L23:
            e = move-exception;
            GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(QrCamera.TAG, "Fail to startPreview camera: " + e);
            this.this$0.mCamera = null;
            QrCamera.access$100(this.this$0).handleCameraFailure();
            return false;
        L14:
            if (this.this$0.mCamera == null) goto L22;
            this.this$0.mCamera.setPreviewTexture(r8);     // Catch: IOException -> L23
            this.this$0.setCameraParameter();     // Catch: IOException -> L23
            QrCamera.access$500(this.this$0);     // Catch: IOException -> L23
            if (QrCamera.access$600(this.this$0) == false) goto L20;
            return true;
        L20:
            throw new IOException("Lost contex");     // Catch: IOException -> L23
        L22:
            throw new IOException("Cannot find available camera");     // Catch: IOException -> L23
        }
    }

    public interface ScannerCallback {
        Rect getFramePosition(Size r1, int r2);

        Size getViewSize();

        void handleCameraFailure();

        void handleSuccessfulResult(String r1);

        boolean isValid(String r1);

        void setTransform(Matrix r1);
    }

    private double getRatio(double r1, double r3) {
        if (r1 >= r3) goto L6;
        return r1 / r3;
    L6:
        return r3 / r1;
    }

    static /* synthetic */ ScannerCallback access$100(QrCamera r0) {
        return r0.mScannerCallback;
    }

    static /* synthetic */ MultiFormatReader access$200(QrCamera r0) {
        return r0.mReader;
    }

    static /* synthetic */ void access$300(QrCamera r0) {
        r0.releaseCamera();
    }

    static /* synthetic */ int access$402(QrCamera r0, int r1) {
        r0.mCameraOrientation = r1;
        return r1;
    }

    static /* synthetic */ void access$500(QrCamera r0) {
        r0.setTransformationMatrix();
    }

    static /* synthetic */ boolean access$600(QrCamera r0) {
        return r0.startPreview();
    }

    static /* synthetic */ QrYuvLuminanceSource access$700(QrCamera r0, byte[] r1) {
        return r0.getFrameImage(r1);
    }

    static {
        HINTS = new ArrayMap();
        ArrayList r0 = new ArrayList();
        FORMATS = r0;
        r0.add(BarcodeFormat.QR_CODE);
        HINTS.put(DecodeHintType.POSSIBLE_FORMATS, FORMATS);
    }

    public QrCamera(Context r2, ScannerCallback r3) {
        this.mContext = new WeakReference(r2);
        this.mScannerCallback = r3;
        MultiFormatReader r4 = new MultiFormatReader();
        this.mReader = r4;
        r4.setHints(HINTS);
    }

    public void start(SurfaceTexture r3) {
        if (this.mDecodeTask != null) goto L6;
        DecodingTask r0 = new DecodingTask(this, r3, null);
        this.mDecodeTask = r0;
        r0.executeOnExecutor(Executors.newSingleThreadExecutor(), new Void[0]);
        return;
    }

    public void stop() {
        removeMessages(1);
        DecodingTask r1 = this.mDecodeTask;
        if (r1 == null) goto L5;
        r1.cancel(true);
        this.mDecodeTask = null;
    L5:
        Camera r0 = this.mCamera;
        if (r0 == null) goto L14;
        r0.stopPreview();     // Catch: RuntimeException -> L9
        releaseCamera();     // Catch: RuntimeException -> L9
        return;
    L9:
        e = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Stop previewing camera failed:" + e);
        this.mCamera = null;
        return;
    }

    void setCameraParameter() {
        Camera.Parameters r0 = this.mCamera.getParameters();
        this.mParameters = r0;
        Size r1 = getBestPreviewSize(r0);
        this.mPreviewSize = r1;
        this.mParameters.setPreviewSize(r1.getWidth(), this.mPreviewSize.getHeight());
        Size r2 = getBestPictureSize(this.mParameters);
        this.mParameters.setPictureSize(r2.getWidth(), r2.getHeight());
        List<String> r3 = this.mParameters.getSupportedFlashModes();
        if (r3 != null) goto L5;
    L7:
        List<String> r4 = this.mParameters.getSupportedFocusModes();
        if (r4.contains("continuous-picture") == false) goto L11;
        this.mParameters.setFocusMode("continuous-picture");
    L13:
        this.mCamera.setParameters(this.mParameters);
        return;
    L11:
        if (r4.contains(DebugKt.DEBUG_PROPERTY_VALUE_AUTO) == false) goto L13;
        this.mParameters.setFocusMode(DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        goto L13
    L5:
        if (r3.contains("off") == false) goto L7;
        this.mParameters.setFlashMode("off");
        goto L7
    }

    private boolean startPreview() {
        int r1 = 0;
        if (this.mContext.get() != null) goto L5;
        return false;
    L5:
        int r0 = ((WindowManager) this.mContext.get().getSystemService("window")).getDefaultDisplay().getRotation();
        if (r0 == 0) goto L16;
        if (r0 != 1) goto L9;
        r1 = 90;
        goto L16
    L9:
        if (r0 != 2) goto L11;
        r1 = 180;
        goto L16
    L11:
        if (r0 != 3) goto L16;
        r1 = 270;
    L16:
        int r2 = ((this.mCameraOrientation - r1) + 360) % 360;
        this.mCamera.setDisplayOrientation(r2);
        this.mCamera.startPreview();
        if (DebugKt.DEBUG_PROPERTY_VALUE_AUTO.equals(this.mParameters.getFocusMode()) == false) goto L19;
        this.mCamera.autoFocus(null);
        sendMessageDelayed(obtainMessage(1), 1500);
    L19:
        return true;
    }

    private void releaseCamera() {
        Camera r0 = this.mCamera;
        if (r0 == null) goto L6;
        r0.release();
        this.mCamera = null;
        return;
    }

    private void setTransformationMatrix() {
        boolean r1 = true;
        if (this.mContext.get().getResources().getConfiguration().orientation == 1) goto L6;
        r1 = false;
    L6:
        Size r0 = this.mPreviewSize;
        if (r1 == false) goto L9;
        int r2 = r0.getWidth();
    L10:
        if (r1 == false) goto L12;
        int r3 = this.mPreviewSize.getHeight();
    L13:
        float r4 = (float) getRatio(r2, r3);
        float r5 = 1.0f;
        if (r2 <= r3) goto L16;
        float r6 = 1.0f / r4;
    L17:
        Matrix r7 = new Matrix();
        r7.setScale(r5, r6);
        this.mScannerCallback.setTransform(r7);
        return;
    L16:
        r5 = 1.0f / r4;
        r6 = 1.0f;
        goto L17
    L12:
        r3 = this.mPreviewSize.getWidth();
        goto L13
    L9:
        r2 = r0.getHeight();
        goto L10
    }

    private QrYuvLuminanceSource getFrameImage(byte[] r4) {
        Rect r0 = this.mScannerCallback.getFramePosition(this.mPreviewSize, this.mCameraOrientation);
        return (QrYuvLuminanceSource) new QrYuvLuminanceSource(r4, this.mPreviewSize.getWidth(), this.mPreviewSize.getHeight()).crop(r0.left, r0.top, r0.width(), r0.height());
    }

    @Override // android.os.Handler
    public void handleMessage(Message r3) {
        if (r3.what == 1) goto L5;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Unexpected Message: " + r3.what);
        return;
    L5:
        this.mCamera.autoFocus(null);
        sendMessageDelayed(obtainMessage(1), 1500);
    }

    private Size getBestPreviewSize(Camera.Parameters r13) {
        Size r0 = this.mScannerCallback.getViewSize();
        double r1 = getRatio(r0.getWidth(), r0.getHeight());
        Size r2 = new Size(0, 0);
        Iterator<Camera.Size> r14 = r13.getSupportedPreviewSizes().iterator();
        double r3 = 0.0d;
    L4:
        if (r14.hasNext() == false) goto L12;
        Camera.Size r5 = r14.next();
        double r6 = getRatio(r5.width, r5.height);
        if ((r5.height * r5.width) <= (r2.getWidth() * r2.getHeight())) goto L4;
        if ((Math.abs(r3 - r1) / r1) > 0.1d) goto L11;
        if ((Math.abs(r6 - r1) / r1) > 0.1d) goto L4;
    L11:
        r2 = new Size(r5.width, r5.height);
        r3 = getRatio(r5.width, r5.height);
        goto L4
    L12:
        return r2;
    }

    private Size getBestPictureSize(Camera.Parameters r12) {
        Camera.Size r0 = r12.getPreviewSize();
        double r1 = getRatio(r0.width, r0.height);
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        Iterator<Camera.Size> r5 = r12.getSupportedPictureSizes().iterator();
    L4:
        if (r5.hasNext() == false) goto L12;
        Camera.Size r6 = r5.next();
        double r7 = getRatio(r6.width, r6.height);
        if (r7 == r1) goto L7;
        if (Math.abs(r7 - r1) >= 0.1d) goto L4;
        r4.add(new Size(r6.width, r6.height));
        goto L4
    L7:
        r3.add(new Size(r6.width, r6.height));
        goto L4
    L12:
        if (r3.size() != 0) goto L18;
        if (r4.size() != 0) goto L18;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "No proper picture size, return default picture size");
        Camera.Size r11 = r12.getPictureSize();
        return new Size(r11.width, r11.height);
    L18:
        if (r3.size() != 0) goto L20;
        r3 = r4;
    L20:
        int r13 = r0.width * r0.height;
        Iterator r14 = r3.iterator();
        int r2 = Integer.MAX_VALUE;
        Size r8 = null;
    L22:
        if (r14.hasNext() == false) goto L26;
        Size r9 = (Size) r14.next();
        int r10 = Math.abs((r9.getWidth() * r9.getHeight()) - r13);
        if (r10 >= r2) goto L22;
        r8 = r9;
        r2 = r10;
        goto L22
    L26:
        return r8;
    }

    protected void decodeImage(BinaryBitmap r2) {
        Result r3 = this.mReader.decodeWithState(r2);     // Catch: Throwable -> L4 ReaderException -> L7
        this.mReader.reset();
    L8:
        if (r3 == null) goto L13;
        this.mScannerCallback.handleSuccessfulResult(r3.getText());
        return;
    L13:
        return;
    L7:
        this.mReader.reset();
        r3 = null;
    L4:
        th = move-exception;
        this.mReader.reset();
        throw th;
    }

    public boolean isDecodeTaskAlive() {
        if (this.mDecodeTask == null) goto L5;
        return true;
    L5:
        return false;
    }
}
