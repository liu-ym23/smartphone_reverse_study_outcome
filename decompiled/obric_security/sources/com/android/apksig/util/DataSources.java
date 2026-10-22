package com.android.apksig.util;

import com.android.apksig.internal.util.FileChannelDataSource;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class DataSources {
    private DataSources() {
    }

    public static DataSource asDataSource(RandomAccessFile r0, long r1, long r3) {
        return asDataSource(r0.getChannel(), r1, r3);
    }

    public static DataSource asDataSource(FileChannel r7, long r8, long r10) {
        r7.getClass();
        return new FileChannelDataSource(r7, r8, r10);
    }
}
