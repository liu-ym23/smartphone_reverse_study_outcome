package com.bytedance.monitor.collector.p;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Set<Integer> f5225a;

    static {
        HashSet r0 = new HashSet();
        f5225a = r0;
        r0.add(114);
        f5225a.add(115);
        f5225a.add(116);
        f5225a.add(121);
        f5225a.add(122);
        f5225a.add(123);
    }

    public static boolean a(Message r1) {
        return f5225a.contains(Integer.valueOf(r1.what));
    }
}
