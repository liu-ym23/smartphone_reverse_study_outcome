package com.obric.matrix.platform.sdk.ones.hotfix;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NetHelper {
    private static final int BUFFER_SIZE = 8192;

    @NotNull
    public static final NetHelper INSTANCE = null;
    private static final int MIN_COMPRESS_LENGTH = 128;

    @NotNull
    private static final String TAG = "NetHelper";

    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[NetworkUtils.CompressType.values().length];
            r0[NetworkUtils.CompressType.GZIP.ordinal()] = 1;
            r0[NetworkUtils.CompressType.DEFLATER.ordinal()] = 2;
            $EnumSwitchMapping$0 = r0;
        }
    }

    static {
        INSTANCE = new NetHelper();
    }

    private NetHelper() {
    }

    private final byte[] compressWithDeflater(byte[] r4) {
        ByteArrayOutputStream r3 = new ByteArrayOutputStream(8192);
        Deflater r1 = new Deflater();
        r1.setInput(r4);
        r1.finish();
        byte[] r5 = new byte[8192];
    L4:
        if (r1.finished() == true) goto L6;
        r3.write(r5, 0, r1.deflate(r5));
        goto L4
    L6:
        r1.end();
        byte[] r6 = r3.toByteArray();
        Intrinsics.e(r6, "bos.toByteArray()");
        return r6;
    }

    private final byte[] compressWithGzip(byte[] r2) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = new GZIPOutputStream(r1);
        r0.write(r2);     // Catch: Throwable -> L6
        CloseableKt.a(r0, null);
        byte[] r3 = r1.toByteArray();
        Intrinsics.e(r3, "bos.toByteArray()");
        return r3;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.a(r0, th);
        throw th;
    }

    @Nullable
    public final String executePost(int r9, @Nullable String r10, @Nullable byte[] r11, @Nullable NetworkUtils.CompressType r12, @Nullable String r13) {
        if (r10 != null) goto L5;
    L29:
        Logger.w(TAG, "executePost: url is null or empty");
        return null;
    L5:
        if (r10.length() == 0) goto L29;
        Pair<byte[], String> r8 = tryCompressData(r11, r12);
        byte[] r14 = (byte[]) r8.first;
        String r15 = (String) r8.second;
        ArrayList r7 = new ArrayList();
        if (r15 == null) goto L10;
        r7.add(new Header("Content-Encoding", r15));
    L10:
        if (r13 != null) goto L12;
    L17:
        LinkedHashMap r5 = new LinkedHashMap();
        Pair<String, String> r16 = UrlUtils.parseUrl(r10, r5);
        if (r16 != null) goto L21;
        Logger.w(TAG, "executePost: parseUrl failed, url=" + r10);
        return null;
    L21:
        String r17 = (String) r16.first;
        String r4 = (String) r16.second;
        INetworkApi r2 = (INetworkApi) RetrofitUtils.createSsService(r17, INetworkApi.class);
        if (r2 == null) goto L27;
        String r18 = r2.postBody(r9, r4, r5, new TypedByteArray(null, r14, new String[0]), r7).execute().body();
        if (r18 == null) goto L27;
        return r18;
    L27:
        Logger.w(TAG, "executePost: create networkApi failed, baseUrl=" + r17);
        return null;
    L12:
        if (r13.length() > 0) goto L15;
        r13 = null;
    L15:
        if (r13 == null) goto L17;
        r7.add(new Header("Content-Type", r13));
        goto L17
    }

    @NotNull
    public final Pair<byte[], String> tryCompressData(@Nullable byte[] r5, @Nullable NetworkUtils.CompressType r6) {
        String r1 = null;
        if (r5 != null) goto L25;
        Logger.d(TAG, "tryCompressData: data is null, return empty");
        return new Pair(new byte[0], null);
    L25:
    L18:
        th = move-exception;
        Logger.e(TAG, "tryCompressData: compress failed, type=" + r6, th);
    L24:
        return new Pair(r5, r1);
    L7:
        if (r5.length <= 128) goto L24;
        if (r6 != null) goto L10;
        int r2 = -1;
    L12:
        if (r2 != 1) goto L14;
        String r3 = "gzip";
        r5 = compressWithGzip(r5);     // Catch: Throwable -> L18
    L17:
        r1 = r3;
        goto L24
    L14:
        if (r2 != 2) goto L24;
        r3 = "deflate";
        r5 = compressWithDeflater(r5);     // Catch: Throwable -> L18
        goto L17
    L10:
        r2 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];     // Catch: Throwable -> L18
        goto L12
    }
}
