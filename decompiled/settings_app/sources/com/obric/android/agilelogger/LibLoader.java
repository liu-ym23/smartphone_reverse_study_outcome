package com.obric.android.agilelogger;

import com.bytedance.librarian.Librarian;
import com.obric.android.alog.ILibLoader;

/* JADX INFO: loaded from: classes4.dex */
class LibLoader implements ILibLoader {
    LibLoader() {
    }

    @Override // com.obric.android.alog.ILibLoader
    public void loadLibrary(String r1) {
        Librarian.loadLibraryForModule("oalog", ALog.sConfig.getContext());     // Catch: Throwable -> L5
        return;
    L5:
        System.loadLibrary("oalog");
    }
}
