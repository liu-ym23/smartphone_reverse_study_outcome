package com.android.settings.utils;

import android.icu.text.Transliterator;
import android.text.TextUtils;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class HanziToPinyin {
    private static final String TAG = "HanziToPinyin";
    private static volatile HanziToPinyin sInstance;
    private Transliterator mAsciiTransliterator;
    private Transliterator mPinyinTransliterator;

    public static class Token {
        public static final int LATIN = 1;
        public static final int PINYIN = 2;
        public static final String SEPARATOR = " ";
        public static final int UNKNOWN = 3;
        public String source;
        public String target;
        public int type;

        public Token() {
        }

        public Token(int r1, String r2, String r3) {
            this.type = r1;
            this.source = r2;
            this.target = r3;
        }
    }

    private HanziToPinyin() {
        this.mPinyinTransliterator = Transliterator.getInstance("Han-Latin/Names; Latin-Ascii; Any-Upper");     // Catch: RuntimeException -> L5
        this.mAsciiTransliterator = Transliterator.getInstance("Latin-Ascii");     // Catch: RuntimeException -> L5
        return;
    L5:
        OLog.w(TAG, "Han-Latin/Names transliterator data is missing, HanziToPinyin is disabled");
    }

    public boolean hasChineseTransliterator() {
        if (this.mPinyinTransliterator == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static HanziToPinyin getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(HanziToPinyin.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HanziToPinyin();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HanziToPinyin.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void tokenize(char r3, Token r4) {
        r4.source = Character.toString(r3);
        if (r3 >= 128) goto L7;
        r4.type = 1;
        r4.target = r4.source;
        return;
    L7:
        if (r3 >= 592) goto L9;
    L19:
        r4.type = 1;
        Transliterator r2 = this.mAsciiTransliterator;
        if (r2 != null) goto L22;
        String r5 = r4.source;
    L23:
        r4.target = r5;
        return;
    L22:
        r5 = r2.transliterate(r4.source);
        goto L23
    L9:
        if (7680 <= r3) goto L11;
    L13:
        r4.type = 2;
        r4.target = this.mPinyinTransliterator.transliterate(r4.source);
        if (TextUtils.isEmpty(r4.target) == false) goto L16;
    L17:
        r4.type = 1;
        r4.target = r4.source;
        return;
    L16:
        if (TextUtils.equals(r4.source, r4.target) == true) goto L17;
        return;
    L11:
        if (r3 >= 7935) goto L13;
        goto L13
    }

    public ArrayList<Token> get(String r9) {
        ArrayList<Token> r0 = new ArrayList();
        if (hasChineseTransliterator() == true) goto L5;
    L32:
        return r0;
    L5:
        if (TextUtils.isEmpty(r9) == true) goto L32;
        int r1 = r9.length();
        StringBuilder r2 = new StringBuilder();
        Token r3 = new Token();
        int r4 = 1;
        int r5 = 0;
    L8:
        if (r5 >= r1) goto L30;
        char r6 = r9.charAt(r5);
        if (Character.isSpaceChar(r6) == true) goto L12;
        tokenize(r6, r3);
        if (r3.type != 2) goto L22;
        if (r2.length() <= 0) goto L20;
        addToken(r2, r0, r4);
    L20:
        r0.add(r3);
        r3 = new Token();
    L27:
        r4 = r3.type;
    L28:
        r5 = r5 + 1;
        goto L8
    L22:
        if (r4 != r3.type) goto L24;
    L26:
        r2.append(r3.target);
        goto L27
    L24:
        if (r2.length() <= 0) goto L26;
        addToken(r2, r0, r4);
        goto L26
    L12:
        if (r2.length() <= 0) goto L14;
        addToken(r2, r0, r4);
    L14:
        tokenize(TokenParser.SP, r3);
        r0.add(r3);
        r3 = new Token();
        goto L28
    L30:
        if (r2.length() <= 0) goto L32;
        addToken(r2, r0, r4);
        goto L32
    }

    private void addToken(StringBuilder r2, ArrayList<Token> r3, int r4) {
        String r1 = r2.toString();
        r3.add(new Token(r4, r1, r1));
        r2.setLength(0);
    }
}
