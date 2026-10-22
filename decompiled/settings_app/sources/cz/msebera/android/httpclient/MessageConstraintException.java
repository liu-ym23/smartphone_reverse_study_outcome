package cz.msebera.android.httpclient;

import java.nio.charset.CharacterCodingException;

/* JADX INFO: loaded from: classes5.dex */
public class MessageConstraintException extends CharacterCodingException {
    private static final long serialVersionUID = 6077207720446368695L;
    private final String message;

    public MessageConstraintException(String r1) {
        this.message = r1;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }
}
