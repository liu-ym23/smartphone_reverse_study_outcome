package com.bytedance.apm6.consumer.slardar.weedout;

/* JADX INFO: loaded from: classes.dex */
public class WeedOutItem {
    private long afterSize;
    private long beforeSize;
    private String name;
    private boolean reachTopOfToday;

    public WeedOutItem() {
    }

    public String getName() {
        return this.name;
    }

    void setName(String r1) {
        this.name = r1;
    }

    public long getBeforeSize() {
        return this.beforeSize;
    }

    void setBeforeSize(long r1) {
        this.beforeSize = r1;
    }

    public long getAfterSize() {
        return this.afterSize;
    }

    void setAfterSize(long r1) {
        this.afterSize = r1;
    }

    public boolean isReachTopOfToday() {
        return this.reachTopOfToday;
    }

    public void setReachTopOfToday(boolean r1) {
        this.reachTopOfToday = r1;
    }
}
