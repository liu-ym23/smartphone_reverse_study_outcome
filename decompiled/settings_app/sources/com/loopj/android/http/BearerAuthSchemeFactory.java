package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.auth.AuthScheme;
import cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import cz.msebera.android.httpclient.auth.AuthenticationException;
import cz.msebera.android.httpclient.auth.ContextAwareAuthScheme;
import cz.msebera.android.httpclient.auth.Credentials;
import cz.msebera.android.httpclient.auth.MalformedChallengeException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.CharArrayBuffer;

/* JADX INFO: loaded from: classes4.dex */
public class BearerAuthSchemeFactory implements AuthSchemeFactory {

    public static class BearerAuthScheme implements ContextAwareAuthScheme {
        private boolean complete;

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public String getParameter(String r1) {
            return null;
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public String getRealm() {
            return null;
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public String getSchemeName() {
            return "Bearer";
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public boolean isConnectionBased() {
            return false;
        }

        public BearerAuthScheme() {
            this.complete = false;
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public void processChallenge(Header r1) throws MalformedChallengeException {
            this.complete = true;
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public Header authenticate(Credentials r2, HttpRequest r3) throws AuthenticationException {
            return authenticate(r2, r3, null);
        }

        @Override // cz.msebera.android.httpclient.auth.ContextAwareAuthScheme
        public Header authenticate(Credentials r1, HttpRequest r2, HttpContext r3) throws AuthenticationException {
            CharArrayBuffer r0 = new CharArrayBuffer(32);
            r0.append("Authorization");
            r0.append(": Bearer ");
            r0.append(r1.getUserPrincipal().getName());
            return new BufferedHeader(r0);
        }

        @Override // cz.msebera.android.httpclient.auth.AuthScheme
        public boolean isComplete() {
            return this.complete;
        }
    }

    public BearerAuthSchemeFactory() {
    }

    @Override // cz.msebera.android.httpclient.auth.AuthSchemeFactory
    public AuthScheme newInstance(HttpParams r1) {
        return new BearerAuthScheme();
    }
}
