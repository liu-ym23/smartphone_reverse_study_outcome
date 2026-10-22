package com.bytedance.apm6.foundation.safety;

import com.bytedance.apm6.util.log.Logger;

/* JADX INFO: loaded from: classes.dex */
public class EnhancedLogger extends Logger.DefaultLogger {
    public EnhancedLogger() {
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void e(String r1, String r2) {
        super.e(r1, r2);
        CustomExceptionHelper.reportSlardarIfNeed(r1, r2, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r1, String r2) {
        super.wtf(r1, r2);
        CustomExceptionHelper.reportSlardarIfNeed(r1, r2, null);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void e(String r1, String r2, Throwable r3) {
        super.e(r1, r2, r3);
        CustomExceptionHelper.reportSlardarIfNeed(r1, r2, r3);
    }

    @Override // com.bytedance.apm6.util.log.Logger.DefaultLogger, com.bytedance.apm6.util.log.ILogger
    public void wtf(String r1, String r2, Throwable r3) {
        super.wtf(r1, r2, r3);
        CustomExceptionHelper.reportSlardarIfNeed(r1, r2, r3);
    }
}
