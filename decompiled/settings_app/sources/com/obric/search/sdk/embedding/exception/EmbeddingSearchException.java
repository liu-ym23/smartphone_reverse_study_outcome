package com.obric.search.sdk.embedding.exception;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EmbeddingSearchException.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00060\u0001j\u0002`\u0002:\u0001\nB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/obric/search/sdk/embedding/exception/EmbeddingSearchException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AccountConst.KEY_ERROR_CODE, "", "message", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "Companion", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchException extends Exception {
    public static final int AIK_MODEL_ERROR = 3000005;
    public static final Companion Companion = null;
    public static final int GET_DB_RESULT_ERROR = 3000002;
    public static final int GET_EXECUTOR_ERROR = 3000004;
    public static final int QUERY_TYPE_ERROR = 3000001;
    public static final int SEARCH_SPEC_TYPE_ERROR = 3000003;
    private final int errorCode;

    /* JADX INFO: compiled from: EmbeddingSearchException.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/search/sdk/embedding/exception/EmbeddingSearchException$Companion;", "", "()V", "AIK_MODEL_ERROR", "", "GET_DB_RESULT_ERROR", "GET_EXECUTOR_ERROR", "QUERY_TYPE_ERROR", "SEARCH_SPEC_TYPE_ERROR", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public EmbeddingSearchException(int r1, String r2) {
        super(r2);
        this.errorCode = r1;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
