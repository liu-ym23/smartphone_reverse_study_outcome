package com.facebook.imagepipeline.memory;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface t {
    int a();

    long b();

    void close();

    byte f(int r1);

    void g(int r1, t r2, int r3, int r4);

    int h(int r1, byte[] r2, int r3, int r4);

    ByteBuffer i();

    boolean isClosed();

    long j();

    int l(int r1, byte[] r2, int r3, int r4);
}
