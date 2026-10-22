package com.android.server.wm;

/* JADX INFO: loaded from: classes.dex */
public class ObricRecentTasksImpl implements IObricRecentTasks {
    public ObricRecentTasksImpl() {
    }

    public boolean isTrimmable(Task task) {
        if ((task.getBaseIntent().getObricExt().getObricFlags() & 16) == 0) goto L6;
        return false;
    L6:
        return true;
    }
}
