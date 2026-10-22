package com.android.vcard;

import com.android.vcard.exception.VCardException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class VCardParser {
    public abstract void addInterpreter(VCardInterpreter r1);

    public abstract void cancel();

    public abstract void parse(InputStream r1) throws IOException, VCardException;

    public abstract void parseOne(InputStream r1) throws IOException, VCardException;

    public VCardParser() {
    }

    @Deprecated
    public void parse(InputStream r1, VCardInterpreter r2) throws IOException, VCardException {
        addInterpreter(r2);
        parse(r1);
    }
}
