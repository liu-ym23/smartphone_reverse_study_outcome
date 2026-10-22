package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class ThreadFactoryBuilder {

    @CheckForNull
    private ThreadFactory backingThreadFactory;

    @CheckForNull
    private Boolean daemon;

    @CheckForNull
    private String nameFormat;

    @CheckForNull
    private Integer priority;

    @CheckForNull
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    static /* synthetic */ String access$000(String r0, Object[] r1) {
        return format(r0, r1);
    }

    public ThreadFactoryBuilder() {
        this.nameFormat = null;
        this.daemon = null;
        this.priority = null;
        this.uncaughtExceptionHandler = null;
        this.backingThreadFactory = null;
    }

    public ThreadFactoryBuilder setNameFormat(String r4) {
        format(r4, new Object[]{0});
        this.nameFormat = r4;
        return this;
    }

    public ThreadFactoryBuilder setDaemon(boolean r1) {
        this.daemon = Boolean.valueOf(r1);
        return this;
    }

    public ThreadFactoryBuilder setPriority(int r5) {
        boolean r0 = false;
        if (r5 < 1) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "Thread priority (%s) must be >= %s", r5, 1);
        if (r5 > 10) goto L9;
        r0 = true;
    L9:
        Preconditions.checkArgument(r0, "Thread priority (%s) must be <= %s", r5, 10);
        this.priority = Integer.valueOf(r5);
        return this;
    L5:
        r2 = false;
        goto L6
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler r1) {
        this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(r1);
        return this;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory r1) {
        this.backingThreadFactory = (ThreadFactory) Preconditions.checkNotNull(r1);
        return this;
    }

    @CheckReturnValue
    public ThreadFactory build() {
        return doBuild(this);
    }

    private static ThreadFactory doBuild(ThreadFactoryBuilder r9) {
        final String r2 = r9.nameFormat;
        final Boolean r4 = r9.daemon;
        final Integer r5 = r9.priority;
        final Thread.UncaughtExceptionHandler r6 = r9.uncaughtExceptionHandler;
        ThreadFactory r10 = r9.backingThreadFactory;
        if (r10 != null) goto L6;
        r10 = Executors.defaultThreadFactory();
    L6:
        final ThreadFactory r1 = r10;
        if (r2 == null) goto L9;
        AtomicLong r11 = new AtomicLong(0);
    L10:
        final AtomicLong r3 = r11;
        return new AnonymousClass1(r1, r2, r3, r4, r5, r6);
    L9:
        r11 = null;
        goto L10
    }

    private static String format(String r1, Object... r2) {
        return String.format(Locale.ROOT, r1, r2);
    }
}
