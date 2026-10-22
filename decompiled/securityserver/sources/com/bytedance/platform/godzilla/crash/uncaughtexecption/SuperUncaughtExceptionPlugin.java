package com.bytedance.platform.godzilla.crash.uncaughtexecption;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.platform.godzilla.common.CrashPortrait;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin;
import com.bytedance.platform.godzilla.utils.ProcessHelper;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SuperUncaughtExceptionPlugin extends UncaughtExceptionPlugin {
    private ConfigFetcher mConfigFetcher;
    private Context mContext;

    public interface ConfigFetcher {
        String getAppVersion();

        List<CrashPortrait> getCrashPortrait();

        int getUpdateVersion();

        void onCrashCatchSucceed(CrashPortrait r1);
    }

    public SuperUncaughtExceptionPlugin(ConfigFetcher r1, Context r2) {
        this.mConfigFetcher = r1;
        this.mContext = r2;
        if (r1 == null) goto L7;
        if (r2 == null) goto L7;
        return;
    L7:
        throw new IllegalArgumentException("mConfigFetcher and mContext can not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [int] */
    /* JADX WARN: Type inference failed for: r14v3 */
    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin, com.bytedance.platform.godzilla.common.UncaughtExceptionConsumer
    public boolean consumeUncaughtException(Thread r17, Throwable r18) {
        ConfigFetcher r1 = this.mConfigFetcher;
        boolean r2 = false;
        if (r1 != null) goto L5;
        return false;
    L5:
        List<CrashPortrait> r3 = r1.getCrashPortrait();
        if (r3 != null) goto L8;
    L71:
        return r2;
    L8:
        if (r3.isEmpty() == true) goto L71;
        String r4 = this.mConfigFetcher.getAppVersion();
        int r5 = this.mConfigFetcher.getUpdateVersion();
        int r6 = Build.VERSION.SDK_INT;
        String r7 = r17.getName();
        String r8 = ProcessHelper.getCurrentProcessName(this.mContext);
        Iterator<CrashPortrait> r9 = r3.iterator();
    L12:
        if (r9.hasNext() == false) goto L71;
        CrashPortrait r10 = r9.next();
        if (TextUtils.isEmpty(r10.appVersion) == true) goto L18;
        if (r10.appVersion.equalsIgnoreCase(r4) == false) goto L12;
    L18:
        int r11 = r10.updateVersion;
        if (r11 <= 0) goto L22;
        if (r11 != r5) goto L12;
    L22:
        int r12 = r10.osVersion;
        if (r12 <= 0) goto L27;
        if (r6 != r12) goto L12;
    L27:
        if (TextUtils.isEmpty(r10.threadName) == true) goto L32;
        if (r10.threadName.equalsIgnoreCase(r7) == false) goto L12;
    L32:
        if (TextUtils.isEmpty(r10.processName) == true) goto L37;
        if (r10.processName.equalsIgnoreCase(r8) == false) goto L12;
    L37:
        if (TextUtils.isEmpty(r10.detailMessage) == true) goto L42;
        if (r10.detailMessage.equalsIgnoreCase(r18.getMessage()) == false) goto L12;
    L42:
        if (TextUtils.isEmpty(r10.throwableClassName) == true) goto L47;
        if (r10.throwableClassName.equalsIgnoreCase(r18.getClass().getName()) == false) goto L12;
    L47:
        if (TextUtils.isEmpty(r10.clazzName) == false) goto L53;
        if (TextUtils.isEmpty(r10.methodName) == false) goto L53;
        Logger.e("CloudUntExPlugin", "Hint crash," + r10);
        this.mConfigFetcher.onCrashCatchSucceed(r10);
        return true;
    L53:
        if (TextUtils.isEmpty(r10.clazzName) == false) goto L55;
    L56:
        Logger.e("CloudUntExPlugin", r10.clazzName + LibrarianImpl.Constants.DOT + r10.methodName + " does not match.");
    L57:
        StackTraceElement[] r13 = r18.getStackTrace();
        int r14 = r13.length;
        ?? r15 = r2;
    L58:
        if (r15 >= r14) goto L12;
        StackTraceElement r16 = r13[r15];
        if (TextUtils.isEmpty(r10.clazzName) == true) goto L65;
        if (r10.clazzName.equalsIgnoreCase(r16.getClassName()) == true) goto L65;
    L68:
        r2 = false;
        r15 = r15 + 1;
    L65:
        if (TextUtils.isEmpty(r10.methodName) == true) goto L69;
        if (r10.methodName.equalsIgnoreCase(r16.getMethodName()) == false) goto L68;
    L69:
        Logger.e("CloudUntExPlugin", "Hint crash," + r10);
        this.mConfigFetcher.onCrashCatchSucceed(r10);
        return true;
    L55:
        if (TextUtils.isEmpty(r10.methodName) == false) goto L57;
        goto L56
    }

    @Override // com.bytedance.platform.godzilla.plugin.BasePlugin
    public String getName() {
        return "CloudUncaughtExceptionCatcher";
    }

    @Override // com.bytedance.platform.godzilla.plugin.UncaughtExceptionPlugin
    public boolean shouldEnableOpt() {
        return true;
    }
}
