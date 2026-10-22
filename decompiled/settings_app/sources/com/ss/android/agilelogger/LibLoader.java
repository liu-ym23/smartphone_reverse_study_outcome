package com.ss.android.agilelogger;

import com.bytedance.android.alog.ILibLoader;
import com.bytedance.librarian.Librarian;
import com.monitor.cloudmessage.consts.CloudControlInf;

/* JADX INFO: loaded from: classes5.dex */
class LibLoader implements ILibLoader {
    LibLoader() {
    }

    @Override // com.bytedance.android.alog.ILibLoader
    public void loadLibrary(String r1) {
        Librarian.loadLibraryForModule(CloudControlInf.ALOG, ALog.sConfig.getContext());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary(CloudControlInf.ALOG);
    }
}
