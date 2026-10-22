package okhttp3.internal.ws;

import kotlin.Metadata;
import okio.ByteString;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MessageDeflaterKt {
    private static final ByteString EMPTY_DEFLATE_BLOCK = null;
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;

    static {
        EMPTY_DEFLATE_BLOCK = ByteString.Companion.decodeHex("000000ffff");
    }

    public static final /* synthetic */ ByteString access$getEMPTY_DEFLATE_BLOCK$p() {
        return EMPTY_DEFLATE_BLOCK;
    }
}
