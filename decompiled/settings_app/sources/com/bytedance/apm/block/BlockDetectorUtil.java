package com.bytedance.apm.block;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class BlockDetectorUtil {
    public static Map<String, String> tags;

    public BlockDetectorUtil() {
    }

    public static void addUserDataTags(Map<String, String> r0) {
        tags = r0;
    }

    public static Map<String, String> getTags() {
        return tags;
    }
}
