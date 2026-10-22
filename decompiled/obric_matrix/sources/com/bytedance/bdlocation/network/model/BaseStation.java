package com.bytedance.bdlocation.network.model;

import com.google.gson.y.c;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseStation {

    @c("current")
    public BssInfo current;

    @c("neighboring")
    public List<BssInfo> neighboring;

    public BaseStation() {
    }
}
