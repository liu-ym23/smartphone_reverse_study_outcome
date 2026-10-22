package android.icu.text;

import java.text.ParsePosition;

/* JADX INFO: loaded from: classes.dex */
public interface SymbolTable {
    public static final char SYMBOL_REF = '$';

    char[] lookup(String r1);

    UnicodeMatcher lookupMatcher(int r1);

    String parseReference(String r1, ParsePosition r2, int r3);
}
