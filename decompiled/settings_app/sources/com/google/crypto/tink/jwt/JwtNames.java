package com.google.crypto.tink.jwt;

/* JADX INFO: loaded from: classes4.dex */
final class JwtNames {
    static final String CLAIM_AUDIENCE = "aud";
    static final String CLAIM_EXPIRATION = "exp";
    static final String CLAIM_ISSUED_AT = "iat";
    static final String CLAIM_ISSUER = "iss";
    static final String CLAIM_JWT_ID = "jti";
    static final String CLAIM_NOT_BEFORE = "nbf";
    static final String CLAIM_SUBJECT = "sub";
    static final String HEADER_ALGORITHM = "alg";
    static final String HEADER_CRITICAL = "crit";
    static final String HEADER_KEY_ID = "kid";
    static final String HEADER_TYPE = "typ";

    static void validate(String name) {
        if (isRegisteredName(name) == true) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(String.format("claim '%s' is invalid because it's a registered name; use the corresponding setter method.", new Object[]{name}));
    }

    static boolean isRegisteredName(String name) {
        if (name.equals(CLAIM_ISSUER) == false) goto L5;
    L18:
        return true;
    L5:
        if (name.equals(CLAIM_SUBJECT) == true) goto L18;
        if (name.equals(CLAIM_AUDIENCE) == true) goto L18;
        if (name.equals(CLAIM_EXPIRATION) == true) goto L18;
        if (name.equals(CLAIM_NOT_BEFORE) == true) goto L18;
        if (name.equals(CLAIM_ISSUED_AT) == true) goto L18;
        if (name.equals(CLAIM_JWT_ID) == true) goto L18;
        return false;
    }

    private JwtNames() {
    }
}
