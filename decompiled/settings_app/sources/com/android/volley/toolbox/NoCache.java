package com.android.volley.toolbox;

import com.android.volley.Cache;

/* JADX INFO: loaded from: classes.dex */
public class NoCache implements Cache {
    @Override // com.android.volley.Cache
    public void clear() {
    }

    @Override // com.android.volley.Cache
    public Cache.Entry get(String r1) {
        return null;
    }

    @Override // com.android.volley.Cache
    public void initialize() {
    }

    @Override // com.android.volley.Cache
    public void invalidate(String r1, boolean r2) {
    }

    @Override // com.android.volley.Cache
    public void put(String r1, Cache.Entry r2) {
    }

    @Override // com.android.volley.Cache
    public void remove(String r1) {
    }

    public NoCache() {
    }
}
