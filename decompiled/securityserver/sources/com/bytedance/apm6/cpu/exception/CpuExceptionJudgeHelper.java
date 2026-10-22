package com.bytedance.apm6.cpu.exception;

import com.bytedance.apm6.cpu.ApmCpuManager;
import com.bytedance.apm6.cpu.config.CpuExceptionConfig;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CpuExceptionJudgeHelper {
    private static String cacheScene;

    public CpuExceptionJudgeHelper() {
    }

    public static String getCacheScene() {
        return cacheScene;
    }

    public static void initScene(String r0) {
        cacheScene = r0;
    }

    public static boolean isForeMatchScene(CpuExceptionConfig r4) {
        if (r4.getForeSceneMaxSpeedMap().isEmpty() == false) goto L5;
        return false;
    L5:
        Iterator<String> r0 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        String r2 = r0.next();
        if (r4.getForeSceneMaxSpeedMap().containsKey(r2) == false) goto L7;
        return true;
    L12:
        return false;
    }

    public static boolean isNeedSkipJudge() {
        return isSceneChanged();
    }

    private static boolean isSceneChanged() {
        cacheScene = ApmCpuManager.getInstance().getCpuSceneString();
        return false;
    }

    public static boolean judge(CpuExceptionConfig r9, double r10, boolean r12) {
        if (r12 == false) goto L29;
        if (r9.getBackSceneMaxSpeedMap().isEmpty() == true) goto L19;
        Iterator<String> r13 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r4 = 0.0d;
    L8:
        if (r13.hasNext() == false) goto L21;
        String r6 = r13.next();
        if (r9.getBackSceneMaxSpeedMap().containsKey(r6) == false) goto L8;
        double r7 = r9.getBackSceneMaxSpeedMap().get(r6).doubleValue();
        if (r7 < 0.0d) goto L8;
        if (r4 > r7) goto L8;
        r4 = r7;
    L21:
        if (r4 > 0.0d) goto L25;
        r4 = r9.getMaxProcessBackCpuSpeed();
    L25:
        if (r10 > r4) goto L27;
        return false;
    L27:
        return true;
    L19:
        r4 = 0.0d;
        goto L21
    L29:
        if (r9.getForeSceneMaxSpeedMap().isEmpty() == true) goto L43;
        Iterator<String> r14 = ApmCpuManager.getInstance().getCpuSceneSet().iterator();
        double r5 = 0.0d;
    L32:
        if (r14.hasNext() == false) goto L45;
        String r8 = r14.next();
        if (r9.getForeSceneMaxSpeedMap().containsKey(r8) == false) goto L32;
        double r11 = r9.getForeSceneMaxSpeedMap().get(r8).doubleValue();
        if (r11 < 0.0d) goto L32;
        if (r5 > r11) goto L32;
        r5 = r11;
    L45:
        if (r5 > 0.0d) goto L49;
        r5 = r9.getMaxProcessForeCpuSpeed();
    L49:
        if (r10 > r5) goto L51;
        return false;
    L51:
        return true;
    L43:
        r5 = 0.0d;
        goto L45
    }
}
