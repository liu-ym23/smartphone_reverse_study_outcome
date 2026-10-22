package com.google.crypto.tink.integration.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.crypto.tink.KeysetReader;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.subtle.Hex;
import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class SharedPrefKeysetReader implements KeysetReader {
    private final String keysetName;
    private final SharedPreferences sharedPreferences;

    public SharedPrefKeysetReader(Context context, String keysetName, String prefFilename) throws IOException {
        if (keysetName == null) goto L10;
        this.keysetName = keysetName;
        Context r1 = context.getApplicationContext();
        if (prefFilename != null) goto L7;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(r1);
        return;
    L7:
        this.sharedPreferences = r1.getSharedPreferences(prefFilename, 0);
        return;
    L10:
        throw new IllegalArgumentException("keysetName cannot be null");
    }

    private byte[] readPref() throws IOException {
        String r2 = this.sharedPreferences.getString(this.keysetName, null);     // Catch: Throwable -> L9
        if (r2 == null) goto L8;
        return Hex.decode(r2);
    L8:
        throw new FileNotFoundException(String.format("can't read keyset; the pref value %s does not exist", new Object[]{this.keysetName}));     // Catch: Throwable -> L9
    L10:
        throw new CharConversionException(String.format("can't read keyset; the pref value %s is not a valid hex string", new Object[]{this.keysetName}));
    }

    @Override // com.google.crypto.tink.KeysetReader
    public Keyset read() throws IOException {
        return Keyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.google.crypto.tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        return EncryptedKeyset.parseFrom(readPref(), ExtensionRegistryLite.getEmptyRegistry());
    }
}
