package com.obric.security.rot_provision;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import system.bytedance.hardware.rot_provision.IRotProvisionService;
import vendor.bytedance.hardware.rot_provision.ProcessResult;

/* JADX INFO: loaded from: classes.dex */
public class RotProvisionManager {
    private static final String TAG = null;
    private static volatile RotProvisionManager mRotProvisionManager;

    static {
        TAG = RotProvisionManager.class.getSimpleName();
    }

    private RotProvisionManager() {
    }

    public static RotProvisionManager getInstance() {
        if (mRotProvisionManager != null) goto L15;
        monitor-enter(RotProvisionManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mRotProvisionManager != null) goto L9;
        mRotProvisionManager = new RotProvisionManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RotProvisionManager.class);     // Catch: Throwable -> L11
    L15:
        return mRotProvisionManager;
    }

    public RotProvisionResult processCmd(Context context, int cmd, byte[] input, Bundle extras) {
        if (context == null) goto L36;
        if (extras == null) goto L36;
        if (input != null) goto L8;
    L34:
        Log.e(TAG, "Invalid input params: input data is null, empty or exceeds max length");
        return new RotProvisionResult(RotProvisionErrorCode.ROT_PROVISION_INVALID_PARAM, null);
    L8:
        if (input.length == 0) goto L34;
        if (input.length > 65536) goto L34;
        if (cmd != 1) goto L15;
    L20:
        IRotProvisionService rotProvisionServiceBinder = RotProvisionUtils.getRotProvisionService();
        if (rotProvisionServiceBinder != null) goto L24;
        Log.e(TAG, "Service not ready!");
        return new RotProvisionResult(RotProvisionErrorCode.ROT_PROVISION_SERVICE_NOT_READY, null);
    L24:
        ProcessResult processResult = null;
        processResult = rotProvisionServiceBinder.processCmd(cmd, input);     // Catch: RemoteException -> L27
    L29:
        if (processResult != null) goto L33;
        return new RotProvisionResult(RotProvisionErrorCode.ROT_PROVISION_BINDER_IPC_FAILED, null);
    L33:
        return new RotProvisionResult(processResult.status, processResult.output);
    L27:
        ex = move-exception;
        Log.e(TAG, "processCmd binder failed, error: " + ex.getMessage());
        goto L29
    L15:
        if (cmd == 2) goto L20;
        if (cmd == 3) goto L20;
        Log.e(TAG, "Invalid cmd: " + cmd);
        return new RotProvisionResult(RotProvisionErrorCode.ROT_PROVISION_INVALID_CMD, null);
    L36:
        Log.e(TAG, "Invalid input params: context or extras is null");
        return new RotProvisionResult(RotProvisionErrorCode.ROT_PROVISION_INVALID_PARAM, null);
    }

    public String checkState(Context context, Bundle extras) {
        if (context == null) goto L26;
        if (extras == null) goto L26;
        IRotProvisionService rotProvisionServiceBinder = RotProvisionUtils.getRotProvisionService();
        if (rotProvisionServiceBinder != null) goto L10;
        Log.e(TAG, "Service not ready!");
        return null;
    L10:
        ProcessResult processResult = null;
        processResult = rotProvisionServiceBinder.checkState();     // Catch: RemoteException -> L13
    L15:
        if (processResult != null) goto L17;
    L24:
        Log.e(TAG, "checkState failed or returned null");
        return null;
    L17:
        if (processResult.output == null) goto L24;
        return new String(processResult.output, "UTF-8");
    L21:
        ex = move-exception;
        Log.e(TAG, "Failed to convert output to String: " + ex.getMessage());
        return null;
    L13:
        ex = move-exception;
        Log.e(TAG, "checkState binder failed, error: " + ex.getMessage());
    L26:
        Log.e(TAG, "Invalid input params");
        return null;
    }
}
