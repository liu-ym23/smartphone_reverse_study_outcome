package com.bytedance.badger.k;

import java.util.List;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public interface a {
    boolean checkUnfinishedTasks();

    void handleResponse(String r1, List<u<String, String>> r2, List<u<String, String>> r3);

    boolean invalidateRecord();

    void sendFollowUpRequest(com.bytedance.badger.data.e r1, long r2);
}
