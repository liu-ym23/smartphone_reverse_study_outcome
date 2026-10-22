package com.bytedance.monitor.collector.service;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class MessageHandleUtils {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Set<Integer> mMessageIds;

    static {
        HashSet r0 = new HashSet();
        mMessageIds = r0;
        r0.add(114);
        mMessageIds.add(115);
        mMessageIds.add(116);
        mMessageIds.add(121);
        mMessageIds.add(122);
        mMessageIds.add(123);
    }

    public MessageHandleUtils() {
    }

    public static boolean isServiceMessage(Message r1) {
        return mMessageIds.contains(Integer.valueOf(r1.what));
    }
}
