package com.android.apksig.util;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public interface DataSink {
    void consume(ByteBuffer r1) throws IOException;

    void consume(byte[] r1, int r2, int r3) throws IOException;
}
