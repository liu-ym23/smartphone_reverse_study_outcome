package com.loc;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class e5 {

    static class a extends ThreadLocal<CharsetDecoder> {
        a() {
        }

        private static CharsetDecoder a() {
            return Charset.forName("UTF-8").newDecoder();
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ CharsetDecoder initialValue() {
            return a();
        }
    }

    static class b extends ThreadLocal<Charset> {
        b() {
        }

        private static Charset a() {
            return Charset.forName("UTF-8");
        }

        @Override // java.lang.ThreadLocal
        protected final /* synthetic */ Charset initialValue() {
            return a();
        }
    }

    static {
        new a();
        new b();
        new ThreadLocal();
    }
}
