package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class FileService {
    FileService() {
    }

    public boolean exists(File r1) {
        return r1.exists();
    }

    public long length(File r1) {
        return r1.length();
    }

    public File get(String r1) {
        return new File(r1);
    }
}
