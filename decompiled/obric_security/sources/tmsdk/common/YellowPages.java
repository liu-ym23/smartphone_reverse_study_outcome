package tmsdk.common;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import tmsdk.common.creator.ManagerCreatorC;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.common.module.update.UpdateManager;
import tmsdkobf.ng;
import tmsdkobf.of;
import tmsdkobf.q8;
import tmsdkobf.z4;

/* JADX INFO: loaded from: classes5.dex */
public class YellowPages {
    private static YellowPages b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f41a;

    static {
        TMSDKContext.registerNatives(10, YellowPages.class);
    }

    private YellowPages() {
        a(TMSDKContext.getApplicaionContext());
    }

    private void a(Context r3) {
        q8.b(NumMarker.Tag, "init yp ");
        String r0 = UpdateConfig.YELLOW_PAGEV2_LARGE;
        if (TextUtils.isEmpty(of.a(r3, r0)) == false) goto L5;
        r0 = UpdateConfig.YELLOW_PAGE;
        z4.a(r3, r0, null);
    L5:
        this.f41a = ((UpdateManager) ManagerCreatorC.getManager(UpdateManager.class)).getFileSavePath() + File.separator + r0;
    }

    public static YellowPages getInstance() {
        if (b != null) goto L15;
        monitor-enter(YellowPages.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L9;
        b = new YellowPages();     // Catch: Throwable -> L11
    L9:
        monitor-exit(YellowPages.class);     // Catch: Throwable -> L11
    L15:
        return b;
    }

    private native int nQueryDataByNumberJNI(String r1, String r2, AtomicInteger r3, AtomicReference<byte[]> r4);

    private native int nUpdate(String r1, String r2);

    public String query(String r3) {
        String r0 = a(r3);
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        String r4 = ng.a(r3);
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return null;
    L8:
        return a(r4);
    }

    public int update(String r2) {
        return nUpdate(this.f41a, r2);
    }

    private String a(String r5) {
        String r1 = null;
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return null;
    L5:
        AtomicInteger r0 = new AtomicInteger(0);
        AtomicReference<byte[]> r2 = new AtomicReference();
        int r4 = nQueryDataByNumberJNI(this.f41a, r5, r0, r2);
        if (r4 == 0) goto L13;
    L10:
        q8.b("yellowPage", "error code::" + r4);
        return r1;
    L13:
        r1 = new String(r2.get(), "UTF-8");     // Catch: UnsupportedEncodingException -> L12
        goto L10
    }
}
