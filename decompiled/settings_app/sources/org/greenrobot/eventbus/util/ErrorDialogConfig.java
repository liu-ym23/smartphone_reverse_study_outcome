package org.greenrobot.eventbus.util;

import android.content.res.Resources;
import android.util.Log;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes6.dex */
public class ErrorDialogConfig {
    int defaultDialogIconId;
    final int defaultErrorMsgId;
    Class<?> defaultEventTypeOnDialogClosed;
    final int defaultTitleId;
    EventBus eventBus;
    boolean logExceptions;
    final ExceptionToResourceMapping mapping;
    final Resources resources;
    String tagForLoggingExceptions;

    public ErrorDialogConfig(Resources r2, int r3, int r4) {
        this.logExceptions = true;
        this.resources = r2;
        this.defaultTitleId = r3;
        this.defaultErrorMsgId = r4;
        this.mapping = new ExceptionToResourceMapping();
    }

    public ErrorDialogConfig addMapping(Class<? extends Throwable> r2, int r3) {
        this.mapping.addMapping(r2, r3);
        return this;
    }

    public int getMessageIdForThrowable(Throwable r4) {
        Integer r0 = this.mapping.mapThrowable(r4);
        if (r0 != null) goto L5;
        Log.d(EventBus.TAG, "No specific message ressource ID found for " + r4);
        return this.defaultErrorMsgId;
    L5:
        return r0.intValue();
    }

    public void setDefaultDialogIconId(int r1) {
        this.defaultDialogIconId = r1;
    }

    public void setDefaultEventTypeOnDialogClosed(Class<?> r1) {
        this.defaultEventTypeOnDialogClosed = r1;
    }

    public void disableExceptionLogging() {
        this.logExceptions = false;
    }

    public void setTagForLoggingExceptions(String r1) {
        this.tagForLoggingExceptions = r1;
    }

    public void setEventBus(EventBus r1) {
        this.eventBus = r1;
    }

    EventBus getEventBus() {
        EventBus r0 = this.eventBus;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return EventBus.getDefault();
    }
}
