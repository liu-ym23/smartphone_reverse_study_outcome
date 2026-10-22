package com.android.apksig.util;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface DataSource {
    void copyTo(long r1, int r3, ByteBuffer r4) throws IOException;

    void feed(long r1, long r3, DataSink r5) throws IOException;

    ByteBuffer getByteBuffer(long r1, int r3) throws IOException;

    long size();

    DataSource slice(long r1, long r3);
}
