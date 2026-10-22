package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetWriter;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.subtle.Hex;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedPrefKeysetWriter implements KeysetWriter {
    private final SharedPreferences.Editor editor;
    private final String keysetName;

    public SharedPrefKeysetWriter(Context context, String keysetName, String prefFileName) {
        if (keysetName == null) goto L10;
        this.keysetName = keysetName;
        Context r1 = context.getApplicationContext();
        if (prefFileName != null) goto L7;
        this.editor = PreferenceManager.getDefaultSharedPreferences(r1).edit();
        return;
    L7:
        this.editor = r1.getSharedPreferences(prefFileName, 0).edit();
        return;
    L10:
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(Keyset keyset) throws IOException {
        if (this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit() == false) goto L6;
        return;
    L6:
        throw new IOException("Failed to write to SharedPreferences");
    }

    @Override // com.google.crypto.tink.KeysetWriter
    public void write(EncryptedKeyset keyset) throws IOException {
        if (this.editor.putString(this.keysetName, Hex.encode(keyset.toByteArray())).commit() == false) goto L6;
        return;
    L6:
        throw new IOException("Failed to write to SharedPreferences");
    }
}
