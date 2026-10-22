package com.obric.matrix.platform.sdk.ones.hotfix;

import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.compression.zstd.BuildConfig;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.zip.Deflater;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J8\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007J(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00132\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/hotfix/NetHelper;", "", "()V", "BUFFER_SIZE", "", "MIN_COMPRESS_LENGTH", "TAG", "", "compressWithDeflater", "", "data", "compressWithGzip", "executePost", "maxLength", "url", BuildConfig.FLAVOR, "Lcom/bytedance/common/utility/NetworkUtils$CompressType;", "contentType", "tryCompressData", "Landroid/util/Pair;", "compressType", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetHelper {
    private static final int BUFFER_SIZE = 8192;
    public static final NetHelper INSTANCE = null;
    private static final int MIN_COMPRESS_LENGTH = 128;
    private static final String TAG = "NetHelper";

    /* JADX INFO: compiled from: NetHelper.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
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

    public final String executePost(int r16, String r17, byte[] r18, NetworkUtils.CompressType r19, String r20) throws Exception {
        String r2 = r17;
        boolean r3 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r4 = true;
    L10:
        if (r4 == false) goto L13;
        Logger.w(TAG, "executePost: url is null or empty");
        return null;
    L13:
        Pair<byte[], String> r5 = tryCompressData(r18, r19);
        byte[] r7 = (byte[]) r5.first;
        String r6 = (String) r5.second;
        ArrayList r14 = new ArrayList();
        if (r6 == null) goto L16;
        r14.add(new Header("Content-Encoding", r6));
    L16:
        if (r20 != null) goto L18;
    L26:
        LinkedHashMap r12 = new LinkedHashMap();
        Pair<String, String> r8 = UrlUtils.parseUrl(r17, r12);
        if (r8 != null) goto L30;
        Logger.w(TAG, "executePost: parseUrl failed, url=" + r17);
        return null;
    L30:
        String r1 = (String) r8.first;
        String r11 = (String) r8.second;
        INetworkApi r9 = (INetworkApi) RetrofitUtils.createSsService(r1, INetworkApi.class);
        if (r9 == null) goto L36;
        String r10 = r9.postBody(r16, r11, r12, new TypedByteArray(null, r7, new String[0]), r14).execute().body();
        if (r10 == null) goto L36;
        return r10;
    L36:
        Logger.w(TAG, "executePost: create networkApi failed, baseUrl=" + r1);
        String r0 = (String) null;
        return null;
    L18:
        if (r20.length() > 0) goto L21;
        r3 = false;
    L21:
        if (r3 == false) goto L23;
        String r13 = r20;
    L24:
        if (r13 == null) goto L26;
        r14.add(new Header("Content-Type", r13));
        goto L26
    L23:
        r13 = null;
        goto L24
    L5:
        if (r2.length() == 0) goto L8;
        r4 = false;
        goto L10
    }

    public final Pair<byte[], String> tryCompressData(byte[] r5, NetworkUtils.CompressType r6) throws IOException {
        String r1 = null;
        if (r5 != null) goto L23;
        Logger.d(TAG, "tryCompressData: data is null, return empty");
        return new Pair(new byte[0], null);
    L23:
    L19:
        th = move-exception;
        Logger.e(TAG, "tryCompressData: compress failed, type=" + r6, th);
    L22:
        return new Pair(r5, r1);
    L7:
        if (r5.length <= 128) goto L22;
        if (r6 != null) goto L10;
        int r2 = -1;
    L12:
        if (r2 != 1) goto L14;
        String r3 = "gzip";
        byte[] r4 = compressWithGzip(r5);     // Catch: Throwable -> L19
    L18:
        r5 = r4;
        r1 = r3;
        goto L22
    L14:
        if (r2 != 2) goto L22;
        r3 = "deflate";
        r4 = compressWithDeflater(r5);     // Catch: Throwable -> L19
        goto L18
    L10:
        r2 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];     // Catch: Throwable -> L19
        goto L12
    }

    private final byte[] compressWithGzip(byte[] r3) {
        ByteArrayOutputStream r2 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r0 = new GZIPOutputStream(r2);
        r0.write(r3);     // Catch: Throwable -> L6
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r0, null);
        byte[] r5 = r2.toByteArray();
        Intrinsics.checkNotNullExpressionValue(r5, "bos.toByteArray()");
        return r5;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
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
        Intrinsics.checkNotNullExpressionValue(r6, "bos.toByteArray()");
        return r6;
    }
}
