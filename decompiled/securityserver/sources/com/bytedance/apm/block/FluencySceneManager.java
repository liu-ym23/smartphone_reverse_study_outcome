package com.bytedance.apm.block;

import com.bytedance.apm.util.ListUtils;
import java.util.ConcurrentModificationException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class FluencySceneManager {
    private static HashSet<String> sFpsScenes;
    private static String sFpsScenesString;
    private static boolean sInjectSceneChanged;

    static {
        sFpsScenes = new HashSet();
        sFpsScenesString = "";
        sInjectSceneChanged = true;
    }

    public FluencySceneManager() {
    }

    public static void addScene(String r1) {
        sInjectSceneChanged = true;
        sFpsScenes.add(r1);
    }

    public static String getInjectScene() {
        if (sInjectSceneChanged == false) goto L6;
        sFpsScenesString = ListUtils.listToString(sFpsScenes, ",");     // Catch: ConcurrentModificationException -> L7
        sInjectSceneChanged = false;     // Catch: ConcurrentModificationException -> L7
    L6:
        return sFpsScenesString;
    }

    public static void removeScene(String r1) {
        sInjectSceneChanged = true;
        sFpsScenes.remove(r1);
    }
}
