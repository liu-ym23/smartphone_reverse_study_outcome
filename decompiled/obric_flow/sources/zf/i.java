package zf;

import com.bytedance.fresco.sr.SRPostProcessor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile SRPostProcessor f23436a;

    public static SRPostProcessor a() {
        if (f23436a != null) goto L6;
        f23436a = new SRPostProcessor(32768, true);
    L6:
        return f23436a;
    }
}
