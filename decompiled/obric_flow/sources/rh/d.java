package rh;

import com.bytedance.pia.core.api.resource.LoadFrom;
import com.bytedance.pia.core.utils.j;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class d implements fh.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f21742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f21743b;

    public /* synthetic */ d(i r5, int r10) {
        this.f21742a = r10;
        this.f21743b = r5;
    }

    @Override // fh.a
    public final void accept(Object r5) {
        switch(this.f21742a) {
            case 0: goto L14;
            case 1: goto L12;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        ReadableMap r10 = (ReadableMap) r5;
        i r11 = this.f21743b;
        r11.getClass();
        if (r10 == null) goto L26;
        JsonObject r12 = j.g(r10);
        r11.e.c(r12);
        return;
    L26:
        return;
    L8:
        ReadableMap r13 = (ReadableMap) r5;
        i r14 = this.f21743b;
        r14.getClass();
        if (r13 == null) goto L27;
        JsonObject r15 = j.g(r13);
        r14.d.c(r15);
        return;
    L27:
        return;
    L12:
        this.f21743b.g((Throwable) r5);
        return;
    L14:
        dh.f r16 = (dh.f) r5;
        i r17 = this.f21743b;
        r17.getClass();
        String r18 = j.l(r16);     // Catch: Throwable -> L21
        if (r16.a() != LoadFrom.f6955a) goto L18;
        boolean r19 = true;
    L19:
        r17.d(r18, Boolean.valueOf(r19));     // Catch: Throwable -> L21
        return;
    L18:
        r19 = false;
    L21:
        th = move-exception;
        r17.g(th);
    }
}
