package com.bytedanceos.cleaner;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class SMTRubbishHolder {
    Map<String, SMTRubbishEntity> mAdsRubbishes;
    List<SMTRubbishEntity> mApkRubbishes;
    Map<String, SMTRubbishEntity> mInstallRubbishes;
    Map<String, SMTRubbishEntity> mUnInstallRubbishes;

    public SMTRubbishHolder() {
        this.mAdsRubbishes = new ConcurrentHashMap();
        this.mApkRubbishes = new CopyOnWriteArrayList();
        this.mInstallRubbishes = new ConcurrentHashMap();
        this.mUnInstallRubbishes = new ConcurrentHashMap();
    }

    public Map<String, SMTRubbishEntity> getAdsRubbishes() {
        return this.mAdsRubbishes;
    }

    public List<SMTRubbishEntity> getmApkRubbishes() {
        return this.mApkRubbishes;
    }

    public Map<String, SMTRubbishEntity> getmInstallRubbishes() {
        return this.mInstallRubbishes;
    }

    public Map<String, SMTRubbishEntity> getmUnInstallRubbishes() {
        return this.mUnInstallRubbishes;
    }
}
