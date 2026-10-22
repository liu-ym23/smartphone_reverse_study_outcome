package com.ttnet.org.chromium.base;

import java.io.File;
import java.io.FileFilter;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File r1) {
        return CpuUtils.a(r1);
    }
}
