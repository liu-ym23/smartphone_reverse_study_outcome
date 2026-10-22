package kotlin.text;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class CharsKt__CharJVMKt {
    public static final boolean a(char r1) {
        if (Character.isWhitespace(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r1) == true) goto L8;
        return false;
    }
}
