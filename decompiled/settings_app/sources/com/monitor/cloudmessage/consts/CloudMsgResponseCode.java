package com.monitor.cloudmessage.consts;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface CloudMsgResponseCode {
    public static final int UPLOAD_STATUE_FAIL = 3;
    public static final int UPLOAD_STATUE_NO_EVENT = 0;
    public static final int UPLOAD_STATUE_SUCCESS = 2;
    public static final int UPLOAD_STATUE_UPLOADING = 1;
}
