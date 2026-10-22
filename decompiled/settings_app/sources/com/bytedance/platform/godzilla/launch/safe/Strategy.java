package com.bytedance.platform.godzilla.launch.safe;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.launch.safe.api.CrashHandler;
import com.bytedance.platform.godzilla.launch.safe.api.CrashPortrait;
import com.bytedance.platform.godzilla.utils.ProcessHelper;

/* JADX INFO: loaded from: classes3.dex */
public class Strategy {
    private Context mContext;
    private CrashHandler mCrashHandler;
    private CrashPortrait mCrashPortrait;
    private int mSerialCrashCount;

    public Strategy(CrashPortrait r1, CrashHandler r2, int r3, Context r4) {
        if (r1 == null) goto L9;
        if (r2 == null) goto L9;
        if (r3 <= 0) goto L9;
        this.mCrashPortrait = r1;
        this.mCrashHandler = r2;
        this.mSerialCrashCount = r3;
        this.mContext = r4;
        return;
    L9:
        throw new IllegalArgumentException("crashPortrait or crashHandler or serialCrashCount is illegal!");
    }

    public boolean onExceptionOccur(Throwable r1, Thread r2, int r3) {
        if (isMatch(r1, r2, r3) == false) goto L6;
        this.mCrashHandler.handle(this.mContext);
        return true;
    L6:
        return false;
    }

    private boolean isMatch(Throwable r7, Thread r8, int r9) {
        if (r9 >= this.mSerialCrashCount) goto L6;
        return false;
    L6:
        if (this.mCrashPortrait.osVersion <= 0) goto L11;
        if (Build.VERSION.SDK_INT == this.mCrashPortrait.osVersion) goto L11;
        return false;
    L11:
        if (TextUtils.isEmpty(this.mCrashPortrait.threadName) == true) goto L16;
        if (this.mCrashPortrait.threadName.equalsIgnoreCase(r8.getName()) == true) goto L16;
        return false;
    L16:
        if (TextUtils.isEmpty(this.mCrashPortrait.processName) == true) goto L21;
        if (this.mCrashPortrait.processName.equalsIgnoreCase(ProcessHelper.getCurrentProcessName(this.mContext)) == true) goto L21;
        return false;
    L21:
        if (TextUtils.isEmpty(this.mCrashPortrait.detailMessage) == true) goto L26;
        if (this.mCrashPortrait.detailMessage.equalsIgnoreCase(r7.getMessage()) == true) goto L26;
        return false;
    L26:
        if (TextUtils.isEmpty(this.mCrashPortrait.throwableClassName) == true) goto L31;
        if (this.mCrashPortrait.throwableClassName.equalsIgnoreCase(r7.getClass().getName()) == true) goto L31;
        return false;
    L31:
        if (TextUtils.isEmpty(this.mCrashPortrait.clazzName) == false) goto L37;
        if (TextUtils.isEmpty(this.mCrashPortrait.methodName) == false) goto L37;
        Logger.e("CloudUntExPlugin", "Hint crash," + this.mCrashPortrait);
        return true;
    L37:
        if (TextUtils.isEmpty(this.mCrashPortrait.clazzName) == false) goto L39;
    L40:
        Logger.e("CloudUntExPlugin", this.mCrashPortrait.clazzName + "." + this.mCrashPortrait.methodName + " does not match.");
    L41:
        StackTraceElement[] r10 = r7.getStackTrace();
        int r11 = r10.length;
        int r2 = 0;
    L42:
        if (r2 >= r11) goto L55;
        StackTraceElement r3 = r10[r2];
        if (TextUtils.isEmpty(this.mCrashPortrait.clazzName) == true) goto L49;
        if (this.mCrashPortrait.clazzName.equalsIgnoreCase(r3.getClassName()) == true) goto L49;
    L52:
        r2 = r2 + 1;
    L49:
        if (TextUtils.isEmpty(this.mCrashPortrait.methodName) == true) goto L53;
        if (this.mCrashPortrait.methodName.equalsIgnoreCase(r3.getMethodName()) == false) goto L52;
    L53:
        Logger.e("CloudUntExPlugin", "Hint crash,and allow to fix crash:" + this.mCrashPortrait);
        return true;
    L55:
        return false;
    L39:
        if (TextUtils.isEmpty(this.mCrashPortrait.methodName) == false) goto L41;
        goto L40
    }
}
