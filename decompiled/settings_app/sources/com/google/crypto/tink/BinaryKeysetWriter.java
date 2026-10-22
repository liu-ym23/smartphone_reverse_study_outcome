package com.google.crypto.tink;

import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class BinaryKeysetWriter implements KeysetWriter {
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream stream) {
        this.outputStream = stream;
    }

    public static KeysetWriter withOutputStream(OutputStream stream) {
        return new BinaryKeysetWriter(stream);
    }

    @Deprecated
    public static KeysetWriter withFile(File file) throws IOException {
        return withOutputStream(new FileOutputStream(file));
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        keyset.writeTo(this.outputStream);     // Catch: Throwable -> L5
        this.outputStream.close();
        return;
    L5:
        th = move-exception;
        this.outputStream.close();
        throw th;
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        ((EncryptedKeyset) ((EncryptedKeyset.Builder) keyset.toBuilder()).clearKeysetInfo().build()).writeTo(this.outputStream);     // Catch: Throwable -> L5
        this.outputStream.close();
        return;
    L5:
        th = move-exception;
        this.outputStream.close();
        throw th;
    }
}
