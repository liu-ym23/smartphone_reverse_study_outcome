package com.qualcomm.qti.internal.telephony;

import android.content.Context;
import android.os.Binder;
import android.os.ServiceManager;
import android.telephony.Rlog;
import android.util.Log;
import com.qualcomm.qti.internal.nrNetworkService.MainServiceImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.codeaurora.internal.IExtTelephony;

/* JADX INFO: loaded from: classes4.dex */
public class ExtTelephonyServiceImpl extends IExtTelephony.Stub {
    private static final boolean DBG = true;
    private static final String LOG_TAG = "ExtTelephonyServiceImpl";
    private static final String TELEPHONY_SERVICE_NAME = "qti.radio.extphone";
    private static Context mContext;
    private static ExtTelephonyServiceImpl sInstance;
    private QtiRilInterface mQtiRilInterface;
    private QtiUiccEfHelper mQtiUiccEfHelper;

    static {
    }

    public static ExtTelephonyServiceImpl init(Context r3) {
        monitor-enter(ExtTelephonyServiceImpl.class);
        mContext = r3;     // Catch: Throwable -> L11
        if (sInstance != null) goto L7;
        sInstance = new ExtTelephonyServiceImpl();     // Catch: Throwable -> L11
    L8:
        ExtTelephonyServiceImpl r4 = sInstance;     // Catch: Throwable -> L11
        monitor-exit(ExtTelephonyServiceImpl.class);     // Catch: Throwable -> L11
        return r4;
    L7:
        Log.wtf(LOG_TAG, "init() called multiple times!  sInstance = " + sInstance);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public static ExtTelephonyServiceImpl getInstance() {
        if (sInstance != null) goto L6;
        Log.wtf(LOG_TAG, "getInstance null");
    L6:
        return sInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ExtTelephonyServiceImpl() {
        logd("init constructor, " + this);
        if (ServiceManager.getService(TELEPHONY_SERVICE_NAME) != null) goto L6;
        logd("ExtTelephonyServiceImpl: Adding IExtTelephony to ServiceManager as qti.radio.extphone");
        ServiceManager.addService(TELEPHONY_SERVICE_NAME, this);
    L6:
        if (ServiceManager.getService("extphone") != null) goto L8;
        logd("ExtTelephonyServiceImpl: Adding IExtTelephony to ServiceManager as extphone");
        ServiceManager.addService("extphone", this);
    L8:
        this.mQtiRilInterface = QtiRilInterface.getInstance(mContext);
        this.mQtiUiccEfHelper = new QtiUiccEfHelper(mContext);
    }

    private void enforceReadPrivilegedPermission(String r2) {
        Log.d(LOG_TAG, "enforceReadPrivilegedPermission for " + r2);
        mContext.enforceCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE", r2);
    }

    public int getPhoneIdForECall() {
        enforceReadPrivilegedPermission("getPhoneIdForECall");
        return QtiEmergencyCallHelper.getPhoneIdForECall(mContext);
    }

    public boolean hasGetIccFileHandler(int r3, int r4) {
        if (mContext.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) goto L11;
        if (this.mQtiUiccEfHelper.loadIccFileHandler(r3, r4) == null) goto L8;
        return true;
    L8:
        return false;
    L11:
        throw new SecurityException("Requires android.permission.READ_PRIVILEGED_PHONE_STATE permission");
    }

    public boolean readEfFromIcc(int r3, int r4, int r5) {
        if (mContext.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) goto L7;
        return this.mQtiUiccEfHelper.readUiccEf(r3, r4, r5);
    L7:
        throw new SecurityException("Requires android.permission.READ_PRIVILEGED_PHONE_STATE permission");
    }

    public boolean writeEfToIcc(int r3, int r4, int r5, byte[] r6) {
        if (mContext.checkCallingOrSelfPermission("android.permission.READ_PRIVILEGED_PHONE_STATE") != 0) goto L7;
        return this.mQtiUiccEfHelper.writeUiccEf(r3, r4, r5, r6);
    L7:
        throw new SecurityException("Requires android.permission.READ_PRIVILEGED_PHONE_STATE permission");
    }

    private void logd(String r1) {
        Rlog.d(LOG_TAG, r1);
    }

    protected void dump(FileDescriptor r2, PrintWriter r3, String[] r4) {
        if (mContext.checkCallingOrSelfPermission("android.permission.DUMP") == 0) goto L6;
        r3.println("Permission Denial: can't dump ExtPhone from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + "without permission android.permission.DUMP");
        r3.flush();
        return;
    L6:
        MainServiceImpl.getInstance().dump(r2, r3, r4);
    }
}
