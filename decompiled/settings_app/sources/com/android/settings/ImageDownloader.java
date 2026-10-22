package com.android.settings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Handler;
import android.provider.MediaStore;
import android.widget.ImageView;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

/* JADX INFO: loaded from: classes2.dex */
public class ImageDownloader {
    private static final int DELAY_BEFORE_PURGE = 10000;
    private static final int HARD_CACHE_CAPACITY = 10;
    private static final String LOG_TAG = "ImageDownloader";
    private static volatile ImageDownloader mInstance;
    private static final ConcurrentHashMap<String, SoftReference<Bitmap>> sSoftBitmapCache = null;
    private Context mContext;
    private final Handler purgeHandler;
    private final Runnable purger;
    private final HashMap<String, Bitmap> sHardBitmapCache;

    class BitmapDownloaderTask extends AsyncTask<String, Void, Bitmap> {
        private final WeakReference<ImageView> imageViewReference;
        final /* synthetic */ ImageDownloader this$0;
        private String url;

        static /* synthetic */ String access$000(BitmapDownloaderTask r0) {
            return r0.url;
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ Bitmap doInBackground(String[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(Bitmap r1) {
            onPostExecute2(r1);
        }

        public BitmapDownloaderTask(ImageDownloader r1, ImageView r2) {
            this.this$0 = r1;
            this.imageViewReference = new WeakReference(r2);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Bitmap doInBackground2(String... r2) {
            String r3 = r2[0];
            this.url = r3;
            return ImageDownloader.access$100(this.this$0, r3);
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Bitmap r3) {
            if (isCancelled() == false) goto L5;
            r3 = null;
        L5:
            ImageDownloader.access$200(this.this$0, this.url, r3);
            WeakReference<ImageView> r0 = this.imageViewReference;
            if (r0 == null) goto L11;
            ImageView r1 = r0.get();
            if (this != ImageDownloader.access$300(r1)) goto L12;
            r1.setImageBitmap(r3);
            return;
        L12:
            return;
        }
    }

    static class DownloadedDrawable extends ColorDrawable {
        private final WeakReference<BitmapDownloaderTask> bitmapDownloaderTaskReference;

        public DownloadedDrawable(BitmapDownloaderTask r2) {
            super(0);
            this.bitmapDownloaderTaskReference = new WeakReference(r2);
        }

        public BitmapDownloaderTask getBitmapDownloaderTask() {
            return this.bitmapDownloaderTaskReference.get();
        }
    }

    static class FlushedInputStream extends FilterInputStream {
        public FlushedInputStream(InputStream r1) {
            super(r1);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long r8) throws IOException {
            long r2 = 0;
        L4:
            if (r2 >= r8) goto L12;
            long r4 = this.in.skip(r8 - r2);
            if (r4 != 0) goto L11;
            if (read() < 0) goto L12;
            r4 = 1;
        L11:
            r2 = r2 + r4;
        L12:
            return r2;
        }
    }

    static /* synthetic */ Bitmap access$100(ImageDownloader r0, String r1) {
        return r0.downloadBitmap(r1);
    }

    static /* synthetic */ void access$200(ImageDownloader r0, String r1, Bitmap r2) {
        r0.addBitmapToCache(r1, r2);
    }

    static /* synthetic */ BitmapDownloaderTask access$300(ImageView r0) {
        return getBitmapDownloaderTask(r0);
    }

    static /* synthetic */ ConcurrentHashMap access$400() {
        return sSoftBitmapCache;
    }

    private ImageDownloader(Context r5) {
        final float r1 = 0.75f;
        final boolean r2 = true;
        final int r3 = 5;
        this.sHardBitmapCache = new AnonymousClass1(this, r3, r1, r2);
        this.purgeHandler = new Handler();
        this.purger = new AnonymousClass2(this);
        this.mContext = r5.getApplicationContext();
    }

    public static ImageDownloader getInstance(Context r2) {
        if (mInstance != null) goto L15;
        monitor-enter(ImageDownloader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new ImageDownloader(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(ImageDownloader.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public void download(String r2, ImageView r3) {
        resetPurgeTimer();
        Bitmap r0 = getBitmapFromCache(r2);
        r3.setTag(r2);
        if (r0 != null) goto L5;
        forceDownload(r2, r3);
        return;
    L5:
        cancelPotentialDownload(r2, r3);
        r3.setImageBitmap(r0);
    }

    private void forceDownload(String r2, ImageView r3) {
        if (r2 != null) goto L6;
        r3.setImageDrawable(null);
        return;
    L6:
        if (cancelPotentialDownload(r2, r3) == false) goto L9;
        BitmapDownloaderTask r0 = new BitmapDownloaderTask(this, r3);
        r3.setImageDrawable(new DownloadedDrawable(r0));
        r3.setMinimumHeight(156);
        r0.execute(new String[]{r2});
        return;
    }

    private static boolean cancelPotentialDownload(String r2, ImageView r3) {
        BitmapDownloaderTask r4 = getBitmapDownloaderTask(r3);
        if (r4 == null) goto L12;
        String r1 = BitmapDownloaderTask.access$000(r4);
        if (r1 != null) goto L7;
    L11:
        r4.cancel(true);
        goto L12
    L7:
        if (r1.equals(r2) == false) goto L11;
        return false;
    L12:
        return true;
    }

    private static BitmapDownloaderTask getBitmapDownloaderTask(ImageView r1) {
        if (r1 == null) goto L7;
        Drawable r2 = r1.getDrawable();
        if ((r2 instanceof DownloadedDrawable) == true) goto L6;
        return null;
    L6:
        return ((DownloadedDrawable) r2).getBitmapDownloaderTask();
    L7:
        return null;
    }

    Bitmap loadLocalWallpaper(String r7) {
        Bitmap r0 = null;
        if (r7 == null) goto L23;
        Uri r8 = Uri.parse(r7);
        String r1 = r8.getScheme();
        if ("android.resource".equals(r1) == false) goto L7;
    L21:
        r0 = MediaStore.Images.Media.getBitmap(this.mContext.getContentResolver(), r8);     // Catch: Exception -> L12
    L14:
        if (r0 == null) goto L16;
    L18:
        if (r0 != null) goto L20;
        return r0;
    L20:
        return Utils.resizeWallpaper(r0, 1080);
    L16:
        if ("content".equals(r1) == false) goto L18;
        r0 = getBitmapByContentUri(r8);
    L12:
        e = move-exception;
        OLog.w(LOG_TAG, "Unable to open content: " + r8, e);
        goto L14
    L7:
        if ("file".equals(r1) == true) goto L21;
        if ("content".equals(r1) == false) goto L14;
    L23:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.InputStream] */
    Bitmap getBitmapByContentUri(Uri r6) {
        ?? r1 = 0;
        if (r6 == null) goto L35;
        if (r6 == null) goto L35;
        if ("content".equals(r6.getScheme()) == false) goto L35;
        InputStream r5 = this.mContext.getContentResolver().openInputStream(r6);     // Catch: Throwable -> L17 Exception -> L19
        Bitmap r7 = ((BitmapDrawable) Drawable.createFromResourceStream(null, null, r5, null, null)).getBitmap();     // Catch: Exception -> L15 Throwable -> L27
        if (r5 != null) goto L41;
    L14:
        return r7;
    L41:
        r5.close();     // Catch: IOException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();
    L15:
        e = e;
    L21:
        OLog.w("", "Unable to open content: " + r6, e);     // Catch: Throwable -> L27
        if (r5 == null) goto L35;
        r5.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L19:
        e = e;
        r5 = null;
    L17:
        th = th;
    L29:
        if (r1 != 0) goto L39;
    L34:
        throw th;
    L39:
        r1.close();     // Catch: IOException -> L32
    L32:
        e = move-exception;
        e.printStackTrace();
    L27:
        th = th;
        r1 = this;
    L35:
        return null;
    }

    private Bitmap downloadBitmap(String r11) {
        if (r11 == null) goto L13;
        if (r11.startsWith("android.resource") == true) goto L11;
        if (r11.startsWith("content") == true) goto L11;
        if (r11.startsWith("file") == false) goto L13;
    L11:
        return loadLocalWallpaper(r11);
    L13:
        if (r11 != null) goto L15;
    L24:
        AndroidHttpClient r5 = AndroidHttpClient.newInstance("Android");
        HttpGet r6 = new HttpGet(r11);
        HttpResponse r7 = r5.execute(r6);     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        int r8 = r7.getStatusLine().getStatusCode();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        if (r8 == 200) goto L32;
        OLog.w(LOG_TAG, "Error " + r8 + " while retrieving bitmap from " + r11);     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        if ((r5 instanceof AndroidHttpClient) == false) goto L31;
        r5.close();
    L31:
        return null;
    L32:
        HttpEntity r1 = r7.getEntity();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        if (r1 == null) goto L52;
        InputStream r9 = r1.getContent();     // Catch: Throwable -> L45
        Bitmap r10 = BitmapFactory.decodeStream(new FlushedInputStream(r9));     // Catch: Throwable -> L43
        if (r9 == null) goto L38;
        r9.close();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
    L38:
        r1.consumeContent();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        if ((r5 instanceof AndroidHttpClient) == false) goto L42;
        r5.close();
    L42:
        return r10;
    L43:
        th = th;
    L47:
        if (r9 == null) goto L49;
        r9.close();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
    L49:
        r1.consumeContent();     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
        throw th;     // Catch: Throwable -> L54 Exception -> L56 IllegalStateException -> L61 IOException -> L65
    L45:
        th = th;
        r9 = null;
        goto L47
    L52:
        if ((r5 instanceof AndroidHttpClient) == false) goto L70;
    L53:
        r5.close();
    L70:
        return null;
    L54:
        th = move-exception;
        if ((r5 instanceof AndroidHttpClient) == false) goto L74;
        r5.close();
    L74:
        throw th;
    L65:
        e = move-exception;
        r6.abort();     // Catch: Throwable -> L54
        OLog.w(LOG_TAG, "I/O error while retrieving bitmap from " + r11, e);     // Catch: Throwable -> L54
        if ((r5 instanceof AndroidHttpClient) == false) goto L70;
    L61:
        r6.abort();     // Catch: Throwable -> L54
        OLog.w(LOG_TAG, "Incorrect URL: " + r11);     // Catch: Throwable -> L54
        if ((r5 instanceof AndroidHttpClient) == false) goto L70;
    L56:
        e = move-exception;
        r6.abort();     // Catch: Throwable -> L54
        OLog.w(LOG_TAG, "Error while retrieving bitmap from " + r11, e);     // Catch: Throwable -> L54
        if ((r5 instanceof AndroidHttpClient) == false) goto L70;
    L15:
        if (r11.startsWith("/data/system/icon") == false) goto L24;
        File r0 = new File(r11);
        if (r0.exists() == true) goto L19;
        return null;
    L19:
        if (r0.isFile() == false) goto L83;
        return ((BitmapDrawable) Drawable.createFromPath(r0.getPath())).getBitmap();
    L22:
        OLog.d("", "can't get bitmap :" + r11);
        return null;
    L83:
        return null;
    }

    static {
        sSoftBitmapCache = new ConcurrentHashMap(5);
    }

    private void addBitmapToCache(String r2, Bitmap r3) {
        if (r3 == null) goto L11;
        HashMap<String, Bitmap> r0 = this.sHardBitmapCache;
        monitor-enter(r0);
        this.sHardBitmapCache.put(r2, r3);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private Bitmap getBitmapFromCache(String r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        HashMap<String, Bitmap> r1 = this.sHardBitmapCache;
        monitor-enter(r1);
        Bitmap r2 = this.sHardBitmapCache.get(r4);     // Catch: Throwable -> L20
        if (r2 == null) goto L12;
        this.sHardBitmapCache.remove(r4);     // Catch: Throwable -> L20
        this.sHardBitmapCache.put(r4, r2);     // Catch: Throwable -> L20
        monitor-exit(r1);     // Catch: Throwable -> L20
        return r2;
    L12:
        monitor-exit(r1);     // Catch: Throwable -> L20
        ConcurrentHashMap<String, SoftReference<Bitmap>> r3 = sSoftBitmapCache;
        SoftReference<Bitmap> r5 = r3.get(r4);
        if (r5 == null) goto L19;
        Bitmap r6 = r5.get();
        if (r6 == null) goto L18;
        return r6;
    L18:
        r3.remove(r4);
    L19:
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public void removeBitmapFromCache(String r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ConcurrentHashMap<String, SoftReference<Bitmap>> r0 = sSoftBitmapCache;
        monitor-enter(r0);
        r0.remove(r3);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        HashMap<String, Bitmap> r1 = this.sHardBitmapCache;
        monitor-enter(r1);
        this.sHardBitmapCache.remove(r3);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        th = move-exception;
        throw th;
    }

    public void updateBitmap(final String r2) {
        ExecutorManager.execute(new AnonymousClass3(this, r2));
    }

    public void clearCache() {
        HashMap<String, Bitmap> r0 = this.sHardBitmapCache;
        monitor-enter(r0);
        this.sHardBitmapCache.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        ConcurrentHashMap<String, SoftReference<Bitmap>> r1 = sSoftBitmapCache;
        monitor-enter(r1);
        r1.clear();     // Catch: Throwable -> L11
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        th = move-exception;
        throw th;
    }

    private void resetPurgeTimer() {
        this.purgeHandler.removeCallbacks(this.purger);
        this.purgeHandler.postDelayed(this.purger, 10000);
    }
}
