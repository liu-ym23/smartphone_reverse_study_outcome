package com.obric.search.sdk.embedding.query;

import android.net.Uri;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.vcard.VCardConstants;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.search.api.query.intf.IQuery;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EmbeddingSearchQuery.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery;", "Lcom/obric/search/api/query/intf/IQuery;", "type", "Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery$TYPE;", "value", "", SliceBroadcastRelay.EXTRA_URI, "Landroid/net/Uri;", "(Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery$TYPE;Ljava/lang/String;Landroid/net/Uri;)V", "getType", "()Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery$TYPE;", "getUri", "()Landroid/net/Uri;", "getValue", "()Ljava/lang/String;", "Companion", VCardConstants.PARAM_TYPE, "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EmbeddingSearchQuery implements IQuery {
    public static final Companion Companion = null;
    private static final String TAG = "EmbeddingSearchQuery";
    private final TYPE type;
    private final Uri uri;
    private final String value;

    /* JADX INFO: compiled from: EmbeddingSearchQuery.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery$Companion;", "", "()V", "TAG", "", "createImageEmbeddingSearchQuery", "Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery;", Params.FILE_PATH, "Landroid/net/Uri;", "createTextEmbeddingSearchQuery", "string", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final EmbeddingSearchQuery createTextEmbeddingSearchQuery(String r4) {
            Intrinsics.checkNotNullParameter(r4, "string");
            TYPE r0 = TYPE.TEXT_QUERY;
            Uri r1 = Uri.EMPTY;
            Intrinsics.checkNotNullExpressionValue(r1, "EMPTY");
            return new EmbeddingSearchQuery(r0, r4, r1, null);
        }

        public final EmbeddingSearchQuery createImageEmbeddingSearchQuery(Uri r4) {
            Intrinsics.checkNotNullParameter(r4, Params.FILE_PATH);
            return new EmbeddingSearchQuery(TYPE.IMAGE_QUERY, "", r4, null);
        }
    }

    /* JADX INFO: compiled from: EmbeddingSearchQuery.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/search/sdk/embedding/query/EmbeddingSearchQuery$TYPE;", "", "(Ljava/lang/String;I)V", "TEXT_QUERY", "IMAGE_QUERY", "embeddingPlugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE IMAGE_QUERY = null;
        public static final TYPE TEXT_QUERY = null;

        private static final /* synthetic */ TYPE[] $values() {
            return new TYPE[]{TEXT_QUERY, IMAGE_QUERY};
        }

        public static TYPE valueOf(String r1) {
            return (TYPE) Enum.valueOf(TYPE.class, r1);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }

        private TYPE(String r1, int r2) {
            super(r1, r2);
        }

        static {
            TEXT_QUERY = new TYPE("TEXT_QUERY", 0);
            IMAGE_QUERY = new TYPE("IMAGE_QUERY", 1);
            $VALUES = $values();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ EmbeddingSearchQuery(TYPE r1, String r2, Uri r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    private EmbeddingSearchQuery(TYPE r1, String r2, Uri r3) {
        this.type = r1;
        this.value = r2;
        this.uri = r3;
    }

    public final TYPE getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
