package com.bytedance.applog.util;

import android.content.Context;
import com.bytedance.applog.compress.CompressManager;
import com.bytedance.applog.compress.CompressRecord;
import com.bytedance.applog.compress.ICompressReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.applog.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.q.b f2420a;

    class a implements ICompressReporter {
        a(d r1) {
        }
    }

    public d(Context r2, com.bytedance.applog.q.b r3) {
        this.f2420a = r3;
        CompressManager.getInstance().init(r2, new a(this));
    }

    @Override // com.bytedance.applog.i
    public com.bytedance.applog.c a(byte[] r5) {
        com.bytedance.applog.c r0 = new com.bytedance.applog.c();
        CompressRecord r1 = new CompressRecord();
        r0.d(CompressManager.getInstance().compress(r5, this.f2420a.o(), r1));     // Catch: Throwable -> L5
    L7:
        r0.e(r1.encodeType);
        HashMap r4 = new HashMap(4);
        if (r1.encodeType != 0) goto L11;
        r4.put("log-encode-type", "gzip");
    L15:
        r0.f(r4);
        return r0;
    L11:
        if (r1.encodeType != 1) goto L13;
    L14:
        r4.put("log-encode-type", "zstd");
        r4.put("log-encode-token", String.valueOf(0));
        goto L15
    L13:
        if (r1.encodeType != 2) goto L15;
    L5:
        th = move-exception;
        n.c("Compress do compress failed", th);
        goto L7
    }
}
