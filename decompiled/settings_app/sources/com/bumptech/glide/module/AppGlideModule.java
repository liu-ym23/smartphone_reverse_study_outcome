package com.bumptech.glide.module;

import android.content.Context;
import com.bumptech.glide.GlideBuilder;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AppGlideModule extends LibraryGlideModule implements AppliesOptions {
    @Override // com.bumptech.glide.module.AppliesOptions
    public void applyOptions(Context r1, GlideBuilder r2) {
    }

    public boolean isManifestParsingEnabled() {
        return true;
    }

    public AppGlideModule() {
    }
}
