package com.bumptech.glide.provider;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageHeaderParserRegistry {
    private final List<ImageHeaderParser> parsers;

    public ImageHeaderParserRegistry() {
        this.parsers = new ArrayList();
    }

    public synchronized List<ImageHeaderParser> getParsers() {
        monitor-enter(this);
        List<ImageHeaderParser> r0 = this.parsers;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void add(ImageHeaderParser r2) {
        monitor-enter(this);
        this.parsers.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
