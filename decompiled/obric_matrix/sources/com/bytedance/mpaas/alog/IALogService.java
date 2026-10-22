package com.bytedance.mpaas.alog;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IALogService extends IService {
    void flushAlogDataToFile();

    List<String> getALogFiles(long r1, long r3);

    String getAlogDir();

    void logD(String r1, String r2);

    void logE(String r1, String r2);

    void logE(String r1, String r2, Throwable r3);

    void logI(String r1, String r2);

    void logV(String r1, String r2);

    void logW(String r1, String r2);

    void logW(String r1, String r2, Throwable r3);
}
