package com.airbnb.lottie;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.bytedance.librarian.LibrarianImpl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.Okio;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionFactory {
    private static final Map<String, LottieTask<LottieComposition>> taskCache = null;

    static /* synthetic */ Map access$000() {
        return taskCache;
    }

    static {
        taskCache = new HashMap();
    }

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int r1) {
        LottieCompositionCache.getInstance().resize(r1);
    }

    public static LottieTask<LottieComposition> fromUrl(Context r2, String r3) {
        return fromUrl(r2, r3, "url_" + r3);
    }

    public static LottieTask<LottieComposition> fromUrl(final Context r1, final String r2, String r3) {
        return cache(r3, new AnonymousClass1(r1, r2));
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context r0, String r1) {
        return NetworkFetcher.fetchSync(r0, r1);
    }

    public static LottieTask<LottieComposition> fromAsset(Context r2, String r3) {
        return fromAsset(r2, r3, "asset_" + r3);
    }

    public static LottieTask<LottieComposition> fromAsset(Context r1, final String r2, final String r3) {
        final Context r4 = r1.getApplicationContext();
        return cache(r3, new AnonymousClass2(r4, r2, r3));
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context r2, String r3) {
        return fromAssetSync(r2, r3, "asset_" + r3);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context r1, String r2, String r3) {
    L8:
        e = move-exception;
        return new LottieResult(e);
    L3:
        if (r2.endsWith(".zip") == false) goto L7;
        return fromZipStreamSync(new ZipInputStream(r1.getAssets().open(r2)), r3);
    L7:
        return fromJsonInputStreamSync(r1.getAssets().open(r2), r3);
    }

    public static LottieTask<LottieComposition> fromRawRes(Context r1, int r2) {
        return fromRawRes(r1, r2, rawResCacheKey(r1, r2));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context r2, final int r3, String r4) {
        final WeakReference r0 = new WeakReference(r2);
        final Context r5 = r2.getApplicationContext();
        return cache(r4, new AnonymousClass3(r0, r5, r3));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context r1, int r2) {
        return fromRawResSync(r1, r2, rawResCacheKey(r1, r2));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context r0, int r1, String r2) {
        return fromJsonInputStreamSync(r0.getResources().openRawResource(r1), r2);
    L4:
        e = move-exception;
        return new LottieResult(e);
    }

    private static String rawResCacheKey(Context r2, int r3) {
        StringBuilder r0 = new StringBuilder("rawRes");
        if (isNightMode(r2) == false) goto L5;
        String r4 = "_night_";
    L7:
        return r0.append(r4).append(r3).toString();
    L5:
        r4 = "_day_";
        goto L7
    }

    private static boolean isNightMode(Context r1) {
        if ((r1.getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        return true;
    L5:
        return false;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(final InputStream r1, final String r2) {
        return cache(r2, new AnonymousClass4(r1, r2));
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream r1, String r2) {
        return fromJsonInputStreamSync(r1, r2, true);
    }

    private static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream r1, String r2, boolean r3) {
        LottieResult<LottieComposition> r4 = fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(r1))), r2);     // Catch: Throwable -> L6
        if (r3 == false) goto L5;
        Utils.closeQuietly(r1);
    L5:
        return r4;
    L6:
        th = move-exception;
        if (r3 == false) goto L9;
        Utils.closeQuietly(r1);
    L9:
        throw th;
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(final JSONObject r1, final String r2) {
        return cache(r2, new AnonymousClass5(r1, r2));
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject r0, String r1) {
        return fromJsonStringSync(r0.toString(), r1);
    }

    public static LottieTask<LottieComposition> fromJsonString(final String r1, final String r2) {
        return cache(r2, new AnonymousClass6(r1, r2));
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String r1, String r2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(new ByteArrayInputStream(r1.getBytes())))), r2);
    }

    public static LottieTask<LottieComposition> fromJsonReader(final JsonReader r1, final String r2) {
        return cache(r2, new AnonymousClass7(r1, r2));
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader r1, String r2) {
        return fromJsonReaderSyncInternal(r1, r2, true);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader r2, String r3, boolean r4) {
        LottieComposition r0 = LottieCompositionMoshiParser.parse(r2);     // Catch: Throwable -> L9 Exception -> L11
        if (r3 == null) goto L5;
        LottieCompositionCache.getInstance().put(r3, r0);     // Catch: Throwable -> L9 Exception -> L11
    L5:
        LottieResult<LottieComposition> r5 = new LottieResult(r0);     // Catch: Throwable -> L9 Exception -> L11
        if (r4 == false) goto L8;
        Utils.closeQuietly(r2);
    L8:
        return r5;
    L11:
        e = move-exception;
        LottieResult<LottieComposition> r1 = new LottieResult(e);     // Catch: Throwable -> L9
        if (r4 == false) goto L15;
        Utils.closeQuietly(r2);
    L15:
        return r1;
    L9:
        th = move-exception;
        if (r4 == false) goto L18;
        Utils.closeQuietly(r2);
    L18:
        throw th;
    }

    public static LottieTask<LottieComposition> fromZipStream(final ZipInputStream r1, final String r2) {
        return cache(r2, new AnonymousClass8(r1, r2));
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream r0, String r1) {
        LottieResult<LottieComposition> r2 = fromZipStreamSyncInternal(r0, r1);     // Catch: Throwable -> L5
        Utils.closeQuietly(r0);
        return r2;
    L5:
        th = move-exception;
        Utils.closeQuietly(r0);
        throw th;
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(ZipInputStream r6, String r7) {
        HashMap r0 = new HashMap();
        ZipEntry r1 = r6.getNextEntry();     // Catch: IOException -> L40
        LottieComposition r3 = null;
    L4:
        if (r1 == null) goto L20;
        String r4 = r1.getName();     // Catch: IOException -> L40
        if (r4.contains("__MACOSX") == false) goto L9;
        r6.closeEntry();     // Catch: IOException -> L40
    L18:
        r1 = r6.getNextEntry();     // Catch: IOException -> L40
        goto L4
    L9:
        if (r1.getName().contains(".json") == false) goto L12;
        r3 = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source(r6))), null, false).getValue();     // Catch: IOException -> L40
        goto L18
    L12:
        if (r4.contains(".png") == false) goto L14;
    L17:
        String[] r2 = r4.split(LibrarianImpl.Constants.SEPARATOR);     // Catch: IOException -> L40
        r0.put(r2[r2.length - 1], BitmapFactory.decodeStream(r6));     // Catch: IOException -> L40
        goto L18
    L14:
        if (r4.contains(".webp") == true) goto L17;
        r6.closeEntry();     // Catch: IOException -> L40
        goto L18
    L20:
        if (r3 == null) goto L22;
        Iterator r8 = r0.entrySet().iterator();
    L25:
        if (r8.hasNext() == false) goto L29;
        Map.Entry r5 = (Map.Entry) r8.next();
        LottieImageAsset r9 = findImageAssetForFileName(r3, (String) r5.getKey());
        if (r9 == null) goto L25;
        r9.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) r5.getValue(), r9.getWidth(), r9.getHeight()));
        goto L25
    L29:
        Iterator<Map.Entry<String, LottieImageAsset>> r10 = r3.getImages().entrySet().iterator();
    L31:
        if (r10.hasNext() == false) goto L36;
        Map.Entry<String, LottieImageAsset> r11 = r10.next();
        if (r11.getValue().getBitmap() != null) goto L31;
        return new LottieResult(new IllegalStateException("There is no image for " + r11.getValue().getFileName()));
    L36:
        if (r7 == null) goto L39;
        LottieCompositionCache.getInstance().put(r7, r3);
    L39:
        return new LottieResult(r3);
    L22:
        return new LottieResult(new IllegalArgumentException("Unable to parse composition"));
    L40:
        e = move-exception;
        return new LottieResult(e);
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition r2, String r3) {
        Iterator<LottieImageAsset> r4 = r2.getImages().values().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        LottieImageAsset r0 = r4.next();
        if (r0.getFileName().equals(r3) == false) goto L4;
        return r0;
    L8:
        return null;
    }

    private static LottieTask<LottieComposition> cache(final String r2, Callable<LottieResult<LottieComposition>> r3) {
        if (r2 != null) goto L4;
        final LottieComposition r0 = null;
    L5:
        if (r0 != null) goto L7;
        if (r2 == null) goto L13;
        Map<String, LottieTask<LottieComposition>> r1 = taskCache;
        if (r1.containsKey(r2) == false) goto L13;
        return r1.get(r2);
    L13:
        LottieTask<LottieComposition> r4 = new LottieTask(r3);
        if (r2 == null) goto L16;
        r4.addListener(new AnonymousClass10(r2));
        r4.addFailureListener(new AnonymousClass11(r2));
        taskCache.put(r2, r4);
    L16:
        return r4;
    L7:
        return new LottieTask(new AnonymousClass9(r0));
    L4:
        r0 = LottieCompositionCache.getInstance().get(r2);
        goto L5
    }
}
