package com.bytedance.crash;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NpthAlogApi {

    @Nullable
    private static Runnable sAlogFlushRunnable;

    @Nullable
    private static AlogGetFilesInterface sAlogGetFilesImpl;

    @Nullable
    private static AlogInitInterface sAlogInitImpl;

    public interface AlogGetFilesInterface {
        List<String> getFiles(long r1, String r3);
    }

    public interface AlogInitInterface {
        boolean isInited();
    }

    public NpthAlogApi() {
    }

    public static void flushAlogSync() {
        Runnable r0 = sAlogFlushRunnable;
        if (r0 == null) goto L6;
        r0.run();
        return;
    }

    @Nullable
    public static List<String> getAlogFiles(long r1, String r3) {
        AlogGetFilesInterface r0 = sAlogGetFilesImpl;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getFiles(r1, r3);
    }

    public static boolean getAlogFilesInit() {
        if (sAlogGetFilesImpl == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isAlogInit() {
        AlogInitInterface r0 = sAlogInitImpl;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isInited() == false) goto L7;
        return true;
    }

    public static boolean sAlogFlushInit() {
        if (sAlogFlushRunnable == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static void setAlogFlushImpl(Runnable r0) {
        sAlogFlushRunnable = r0;
    }

    public static void setAlogGetFilesImpl(AlogGetFilesInterface r0) {
        sAlogGetFilesImpl = r0;
    }

    public static void setAlogInitImpl(AlogInitInterface r0) {
        sAlogInitImpl = r0;
    }
}
