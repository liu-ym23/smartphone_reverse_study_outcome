package com.bytedance.bdinstall.loader;

import android.os.Environment;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.librarian.LibrarianImpl;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
final class DeprecatedFileCleaner implements Runnable {
    private final InstallOptions mOptions;

    public DeprecatedFileCleaner(InstallOptions r1) {
        this.mOptions = r1;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList r1 = new ArrayList();
    L9:
        th = move-exception;
        th.printStackTrace();
    L12:
        if (this.mOptions.isAnonymous() == false) goto L34;
    L21:
        Iterator r5 = r1.iterator();
    L23:
        if (r5.hasNext() == false) goto L29;
        String r0 = (String) r5.next();
        IOUtils.deletePath(r0);     // Catch: Throwable -> L27
        DrLog.v("dt " + r0);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L29:
        return;
    L34:
        r1.add(Environment.getExternalStorageDirectory().getPath() + StringEncryptUtils.base64DecodeToString("L0FuZHJvaWQvZGF0YS9jb20uc25zc2RrLmFwaS9ieXRlZGFuY2U="));     // Catch: Throwable -> L15
    L32:
        r1.add(Environment.getExternalStorageDirectory().getPath() + LibrarianImpl.Constants.SEPARATOR + StringEncryptUtils.getBytedanceString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
    L15:
        th = move-exception;
        th.printStackTrace();
        goto L32
    L4:
        if (this.mOptions.isAnonymous() == false) goto L6;
        String r2 = "device_id";
    L7:
        r1.add(this.mOptions.getContext().getExternalCacheDir().getParent() + LibrarianImpl.Constants.SEPARATOR + r2);     // Catch: Throwable -> L9
        goto L12
    L6:
        r2 = StringEncryptUtils.getBytedanceString();     // Catch: Throwable -> L9
        goto L7
    }
}
