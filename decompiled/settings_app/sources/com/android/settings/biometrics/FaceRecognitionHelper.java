package com.android.settings.biometrics;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.hardware.face.FaceManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.settings.SettingsFeature;
import com.android.settings.Utils;
import com.android.settings.biometrics.facejigan.CommonUtil;
import com.android.settings.biometrics.facejigan.LiteManager;
import com.bytedance.facerecognition.IFaceRecognition;
import com.obric.olog.OLog;
import com.zte.faceverify.FaceVerifyManager;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class FaceRecognitionHelper {
    private static final int MSG_BIND_SUCCESS = 1;
    private static final String TAG = "FaceRecognitionHelper";
    private static int mConnectedCount;
    private static boolean mInitialized;
    private boolean mConnected;
    private final ServiceConnection mConnection;
    private FaceRecognitionConnectionCallback mConnectionCallback;
    private Context mContext;
    private Handler mHandler;
    private IFaceRecognition mIFaceRecognition;

    public interface FaceRecognitionConnectionCallback {
        void onFaceRecognitionBindSuccess();
    }

    static /* synthetic */ FaceRecognitionConnectionCallback access$000(FaceRecognitionHelper r0) {
        return r0.mConnectionCallback;
    }

    static /* synthetic */ int access$100() {
        return mConnectedCount;
    }

    static /* synthetic */ int access$108() {
        int r0 = mConnectedCount;
        mConnectedCount = r0 + 1;
        return r0;
    }

    static /* synthetic */ boolean access$200(FaceRecognitionHelper r0) {
        return r0.mConnected;
    }

    static /* synthetic */ boolean access$202(FaceRecognitionHelper r0, boolean r1) {
        r0.mConnected = r1;
        return r1;
    }

    static /* synthetic */ boolean access$300() {
        return mInitialized;
    }

    static /* synthetic */ boolean access$302(boolean r0) {
        mInitialized = r0;
        return r0;
    }

    static /* synthetic */ IFaceRecognition access$402(FaceRecognitionHelper r0, IFaceRecognition r1) {
        r0.mIFaceRecognition = r1;
        return r1;
    }

    static /* synthetic */ Handler access$500(FaceRecognitionHelper r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Context access$600(FaceRecognitionHelper r0) {
        return r0.mContext;
    }

    static /* synthetic */ void access$700(FaceRecognitionHelper r0) {
        r0.tryRelease();
    }

    public FaceRecognitionHelper(Context r3) {
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        this.mConnection = new AnonymousClass2(this);
        this.mContext = r3;
    }

    private void tryRelease() {
        if (mConnectedCount <= 0) goto L7;
        OLog.d(TAG, "there has " + mConnectedCount + " active connection(s), should not release!");
        return;
    L7:
        if (mInitialized == true) goto L9;
    L23:
        OLog.d(TAG, "init not finished , not need release!");
        return;
    L9:
        if (this.mIFaceRecognition == null) goto L23;
        mInitialized = false;
        monitor-enter(this);
        this.mIFaceRecognition.release();     // Catch: Throwable -> L15 RemoteException -> L17
        OLog.d(TAG, "face recognition released");     // Catch: Throwable -> L15 RemoteException -> L17
    L19:
        monitor-exit(this);     // Catch: Throwable -> L15
        return;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void bind(FaceRecognitionConnectionCallback r3) {
        OLog.d(TAG, "bind face recognition");
        this.mConnectionCallback = r3;
        Intent r4 = new Intent();
        r4.setClassName("com.bytedance.facerecognition", "com.bytedance.facerecognition.FaceIDService");
        this.mContext.bindService(r4, this.mConnection, 1);
    }

    public void unbind() {
        OLog.d(TAG, "unbind face recognition");
        this.mContext.unbindService(this.mConnection);
        mConnectedCount--;
        OLog.d(TAG, "unbind face recognition. ConnectedCount = " + mConnectedCount);
        this.mConnected = false;
        this.mConnectionCallback = null;
        if (isReady() == false) goto L5;
        tryRelease();
    L5:
        this.mIFaceRecognition = null;
    }

    public boolean isReady() {
        if (mInitialized == true) goto L5;
    L9:
        boolean r2 = false;
    L10:
        OLog.d(TAG, "isReady: " + r2);
        return r2;
    L5:
        if (this.mConnected == false) goto L9;
        if (this.mIFaceRecognition == null) goto L9;
        r2 = true;
        goto L10
    }

    public boolean isFaceRecognitionDataExist() {
        if (SettingsFeature.isSupportZteFaceRecognition() == true) goto L5;
        FaceManager r1 = Utils.getFaceManagerOrNull(this.mContext);
        if (r1 != null) goto L9;
        return false;
    L9:
        return !r1.getEnrolledFaces(UserHandle.myUserId()).isEmpty();
    L5:
        return new FaceVerifyManager(this.mContext).isSpecSwitchOpen(FaceVerifyManager.PATH_HAS_FACE);
    }

    public boolean deleteFaceRecognitionData(Context r5) {
        if (SettingsFeature.isSupportZteFaceRecognition() == false) goto L8;
        int r4 = r5.getContentResolver().delete(Uri.parse("content://com.zte.faceverify/count"), null, null);
        OLog.d(TAG, "delete face recognition data ret: " + r4);
        if (r4 <= 0) goto L24;
        return true;
    L24:
        return false;
    L8:
        File r6 = r5.getExternalFilesDir(CommonUtil.UNLOCK_FACE_FOLDER_PATH);
        if (r6.exists() == true) goto L12;
        OLog.d(TAG, "Invalid folder.");
        return false;
    L12:
        File r0 = new File(r6, CommonUtil.UNLOCK_FACE_FEATURE_PATH);
        if (r0.exists() == true) goto L16;
        OLog.d(TAG, "Invalid folder");
        return false;
    L16:
        File[] r7 = r0.listFiles();
        if (r7 != null) goto L19;
    L22:
        OLog.d(TAG, "don't have image file.");
        return false;
    L19:
        if (r7.length == 0) goto L22;
        OLog.d(TAG, "ret:" + LiteManager.getInstance().deleteFeature(getImageFileId(r7[0].getName())));
        return false;
    }

    private int getImageFileId(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return 0;
    L6:
        return Integer.valueOf(r2.substring(5).split("\\.")[0]).intValue();
    }

    private boolean deleteImageFile(String r6) {
        boolean r3 = false;
        File r5 = this.mContext.getExternalFilesDir(String.format("%s/%s", new Object[]{CommonUtil.UNLOCK_FACE_FOLDER_PATH, CommonUtil.UNLOCK_FACE_FEATURE_PATH}));
        if (r5.exists() == true) goto L14;
        OLog.e(TAG, "deleteImageFile()...Invalid Folder.");
        return false;
    L14:
        File r1 = new File(r5, r6);     // Catch: Exception -> L11
        if (r1.exists() == false) goto L9;
        r3 = r1.delete();     // Catch: Exception -> L11
    L9:
        OLog.d(TAG, "delete:" + r1.getPath());     // Catch: Exception -> L11
    L13:
        return r3;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }
}
