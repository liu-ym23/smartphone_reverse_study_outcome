package com.obric.search.sdk.jieba.utils;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: JiebaNativeHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086 J!\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086 J!\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086 J\t\u0010\f\u001a\u00020\u0004H\u0086 ¨\u0006\r"}, d2 = {"Lcom/obric/search/sdk/jieba/utils/JiebaNativeHelper;", "", "()V", "loadDict", "", "tokenizeDocument", "", "", "text", "hmm", "", "tokenizeQuery", "unloadDict", "jiebaExtension_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JiebaNativeHelper {
    public static final JiebaNativeHelper INSTANCE = null;

    public final native void loadDict();

    public final native List<String> tokenizeDocument(String r1, boolean r2);

    public final native List<String> tokenizeQuery(String r1, boolean r2);

    public final native void unloadDict();

    private JiebaNativeHelper() {
    }

    static {
        INSTANCE = new JiebaNativeHelper();
        System.loadLibrary("jiebatokenizer");
    }
}
