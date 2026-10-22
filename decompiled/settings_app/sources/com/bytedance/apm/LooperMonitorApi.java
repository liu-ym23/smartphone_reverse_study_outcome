package com.bytedance.apm;

import com.bytedance.crash.entity.ScheduleMsgItem;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LooperMonitorApi {
    private static LooperMonitorImpl sLooperMonitorImpl;

    public interface LooperMonitorImpl {
        List<ScheduleMsgItem> dumpMainLooperHistoryMsg();

        ScheduleMsgItem getDispatchingMsg();
    }

    public LooperMonitorApi() {
    }

    public static LooperMonitorImpl getLooperMonitorImpl() {
        return sLooperMonitorImpl;
    }

    static void setLooperMonitorImpl(LooperMonitorImpl r0) {
        sLooperMonitorImpl = r0;
    }
}
