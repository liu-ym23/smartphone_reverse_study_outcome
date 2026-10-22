package com.bytedance.platform.godzilla.crash.boostcrash.impl.providerInstalledFailed;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FileProviderInstallFailedExceptionCatcher implements ExceptionCatcher {
    private static List<String> mCrashes;

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean registerCondition() {
        return true;
    }

    public FileProviderInstallFailedExceptionCatcher() {
    }

    static {
        ArrayList r0 = new ArrayList();
        mCrashes = r0;
        r0.add("FILE_PROVIDER_PATHS");
        mCrashes.add("NullPointerException");
        mCrashes.add("Failed to resolve canonical path");
        mCrashes.add("android.os.DeadSystemException");
        mCrashes.add("Package manager has died");
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.fileProviderInstalledFailed.ExceptionCatcher
    public boolean analysis(Object r7, Throwable r8) {
        StackTraceElement[] r6 = Thread.currentThread().getStackTrace();
        int r9 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r9) goto L15;
        if (r6[r1].getMethodName().contains("installProvider") == false) goto L14;
        if (r8 == null) goto L14;
        String r2 = r8.toString();
        Iterator<String> r3 = mCrashes.iterator();
    L9:
        if (r3.hasNext() == false) goto L14;
        String r4 = r3.next();
        if (r2.contains(r4) == false) goto L9;
        Logger.d("ProviderInstallFailed", "Hint the crash " + r4);
        return true;
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        return false;
    }
}
