package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.n0.d.g;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B/\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", "", "", "bootFinishTimeOut", "J", "getBootFinishTimeOut", "()J", "", "uiThreadTaskNum", "I", "getUiThreadTaskNum", "()I", "", "autoIdleTask", "Z", "getAutoIdleTask", "()Z", "nonUIThreadTaskNum", "getNonUIThreadTaskNum", "<init>", "(IIZJ)V", "Companion", "initscheduler_release"}, k = 1, mv = {1, 1, 15})
public final class IdleTaskConfig {
    public static final a Companion = null;
    public static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    public static final long IDLE_START_TIME_OUT = 15000;
    public final boolean autoIdleTask;
    public final long bootFinishTimeOut;
    public final int nonUIThreadTaskNum;
    public final int uiThreadTaskNum;

    public static final class a {
        public /* synthetic */ a(g r1) {
        }

        public final IdleTaskConfig a() {
            return IdleTaskConfig.DEFAULT_IDLETASK_CONFIG;
        }
    }

    static {
        Companion = new a(null);
        DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(0, 0, false, 0, 15, null);
    }

    public IdleTaskConfig() {
        this(0, 0, false, 0, 15, null);
    }

    public IdleTaskConfig(int r1, int r2, boolean r3, long r4) {
        this.uiThreadTaskNum = r1;
        this.nonUIThreadTaskNum = r2;
        this.autoIdleTask = r3;
        this.bootFinishTimeOut = r4;
    }

    public /* synthetic */ IdleTaskConfig(int r2, int r3, boolean r4, long r5, int r7, g r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 1;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 1;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = false;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r5 = IDLE_START_TIME_OUT;
    L14:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ IdleTaskConfig access$getDEFAULT_IDLETASK_CONFIG$cp() {
        return DEFAULT_IDLETASK_CONFIG;
    }

    public final boolean getAutoIdleTask() {
        return this.autoIdleTask;
    }

    public final long getBootFinishTimeOut() {
        return this.bootFinishTimeOut;
    }

    public final int getNonUIThreadTaskNum() {
        return this.nonUIThreadTaskNum;
    }

    public final int getUiThreadTaskNum() {
        return this.uiThreadTaskNum;
    }
}
