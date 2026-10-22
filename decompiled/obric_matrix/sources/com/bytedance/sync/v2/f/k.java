package com.bytedance.sync.v2.f;

import java.util.List;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public interface k extends com.ss.android.ug.bus.a {

    public static final class a {
        public static /* synthetic */ void a(k r0, boolean r1, int r2, Object r3) {
            if (r3 != null) goto L9;
            if ((r2 & 1) == 0) goto L6;
            r1 = false;
        L6:
            r0.G(r1);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendPollMsg");
        }
    }

    void G(boolean r1);

    List<u<String, String>> N(String r1, List<com.bytedance.sync.v2.presistence.d.f> r2, boolean r3);

    void P();

    boolean c();
}
