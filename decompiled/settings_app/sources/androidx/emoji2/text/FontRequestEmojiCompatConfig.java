package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = null;

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long r1) {
            this.mTotalMs = r1;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin != 0) goto L6;
            this.mRetryOrigin = SystemClock.uptimeMillis();
            return 0;
        L6:
            long r0 = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (r0 <= this.mTotalMs) goto L11;
            return -1;
        L11:
            return Math.min(Math.max(r0, 1000), this.mTotalMs - r0);
        }
    }

    public static class FontProviderHelper {
        public FontProviderHelper() {
        }

        public FontsContractCompat.FontFamilyResult fetchFonts(Context r1, FontRequest r2) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(r1, null, r2);
        }

        public Typeface buildTypeface(Context r2, FontsContractCompat.FontInfo r3) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(r2, null, new FontsContractCompat.FontInfo[]{r3});
        }

        public void registerObserver(Context r1, Uri r2, ContentObserver r3) {
            r1.getContentResolver().registerContentObserver(r2, false, r3);
        }

        public void unregisterObserver(Context r1, ContentObserver r2) {
            r1.getContentResolver().unregisterContentObserver(r2);
        }
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";
        EmojiCompat.MetadataRepoLoaderCallback mCallback;
        private final Context mContext;
        private Executor mExecutor;
        private final FontProviderHelper mFontProviderHelper;
        private final Object mLock;
        private Handler mMainHandler;
        private Runnable mMainHandlerLoadCallback;
        private ThreadPoolExecutor mMyThreadPoolExecutor;
        private ContentObserver mObserver;
        private final FontRequest mRequest;
        private RetryPolicy mRetryPolicy;

        FontRequestMetadataLoader(Context r2, FontRequest r3, FontProviderHelper r4) {
            this.mLock = new Object();
            Preconditions.checkNotNull(r2, "Context cannot be null");
            Preconditions.checkNotNull(r3, "FontRequest cannot be null");
            this.mContext = r2.getApplicationContext();
            this.mRequest = r3;
            this.mFontProviderHelper = r4;
        }

        public void setExecutor(Executor r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mExecutor = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setRetryPolicy(RetryPolicy r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mRetryPolicy = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(EmojiCompat.MetadataRepoLoaderCallback r2) {
            Preconditions.checkNotNull(r2, "LoaderCallback cannot be null");
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCallback = r2;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            loadInternal();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        void loadInternal() {
            Object r0 = this.mLock;
            monitor-enter(r0);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L9;
            monitor-exit(r0);     // Catch: Throwable -> L14
            return;
        L9:
            if (this.mExecutor != null) goto L11;
            ThreadPoolExecutor r1 = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");     // Catch: Throwable -> L14
            this.mMyThreadPoolExecutor = r1;     // Catch: Throwable -> L14
            this.mExecutor = r1;     // Catch: Throwable -> L14
        L11:
            this.mExecutor.execute(new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L14
            monitor-exit(r0);     // Catch: Throwable -> L14
        }

        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontsContractCompat.FontFamilyResult r3 = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r3.getStatusCode() != 0) goto L14;
            FontsContractCompat.FontInfo[] r4 = r3.getFonts();
            if (r4 == null) goto L12;
            if (r4.length == 0) goto L12;
            return r4[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r3.getStatusCode() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        private void scheduleRetry(Uri r6, long r7) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            final Handler r1 = this.mMainHandler;     // Catch: Throwable -> L16
            if (r1 != null) goto L8;
            r1 = ConcurrencyHelpers.mainHandlerAsync();     // Catch: Throwable -> L16
            this.mMainHandler = r1;     // Catch: Throwable -> L16
        L8:
            if (this.mObserver != null) goto L11;
            ContentObserver r2 = new AnonymousClass1(this, r1);     // Catch: Throwable -> L16
            this.mObserver = r2;     // Catch: Throwable -> L16
            this.mFontProviderHelper.registerObserver(this.mContext, r6, r2);     // Catch: Throwable -> L16
        L11:
            if (this.mMainHandlerLoadCallback != null) goto L13;
            this.mMainHandlerLoadCallback = new FontRequestEmojiCompatConfig$FontRequestMetadataLoader$$ExternalSyntheticLambda1(this);     // Catch: Throwable -> L16
        L13:
            r1.postDelayed(this.mMainHandlerLoadCallback, r7);     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        private void cleanUp() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mCallback = null;     // Catch: Throwable -> L17
            ContentObserver r2 = this.mObserver;     // Catch: Throwable -> L17
            if (r2 == null) goto L8;
            this.mFontProviderHelper.unregisterObserver(this.mContext, r2);     // Catch: Throwable -> L17
            this.mObserver = null;     // Catch: Throwable -> L17
        L8:
            Handler r3 = this.mMainHandler;     // Catch: Throwable -> L17
            if (r3 == null) goto L11;
            r3.removeCallbacks(this.mMainHandlerLoadCallback);     // Catch: Throwable -> L17
        L11:
            this.mMainHandler = null;     // Catch: Throwable -> L17
            ThreadPoolExecutor r4 = this.mMyThreadPoolExecutor;     // Catch: Throwable -> L17
            if (r4 == null) goto L14;
            r4.shutdown();     // Catch: Throwable -> L17
        L14:
            this.mExecutor = null;     // Catch: Throwable -> L17
            this.mMyThreadPoolExecutor = null;     // Catch: Throwable -> L17
            monitor-exit(r0);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        void createMetadata() {
            Object r1 = this.mLock;
            monitor-enter(r1);
        L60:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L8;
            monitor-exit(r1);     // Catch: Throwable -> L60
            return;
        L8:
            monitor-exit(r1);     // Catch: Throwable -> L60
            FontsContractCompat.FontInfo r2 = retrieveFontInfo();     // Catch: Throwable -> L48
            int r3 = r2.getResultCode();     // Catch: Throwable -> L48
            if (r3 != 2) goto L25;
            Object r4 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r4);     // Catch: Throwable -> L48
            RetryPolicy r5 = this.mRetryPolicy;     // Catch: Throwable -> L22
            if (r5 == null) goto L20;
            long r6 = r5.getRetryDelay();     // Catch: Throwable -> L22
            if (r6 < 0) goto L20;
            scheduleRetry(r2.getUri(), r6);     // Catch: Throwable -> L22
            monitor-exit(r4);     // Catch: Throwable -> L22
            return;
        L20:
            monitor-exit(r4);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L25:
            if (r3 != 0) goto L47;
            TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);     // Catch: Throwable -> L43
            Typeface r0 = this.mFontProviderHelper.buildTypeface(this.mContext, r2);     // Catch: Throwable -> L43
            ByteBuffer r7 = TypefaceCompatUtil.mmap(this.mContext, null, r2.getUri());     // Catch: Throwable -> L43
            if (r7 == null) goto L42;
            if (r0 == null) goto L42;
            MetadataRepo r8 = MetadataRepo.create(r0, r7);     // Catch: Throwable -> L43
            TraceCompat.endSection();     // Catch: Throwable -> L48
            Object r9 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r9);     // Catch: Throwable -> L48
            EmojiCompat.MetadataRepoLoaderCallback r10 = this.mCallback;     // Catch: Throwable -> L38
            if (r10 == null) goto L35;
            r10.onLoaded(r8);     // Catch: Throwable -> L38
        L35:
            monitor-exit(r9);     // Catch: Throwable -> L38
            cleanUp();     // Catch: Throwable -> L48
            return;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L42:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            TraceCompat.endSection();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L47:
            throw new RuntimeException("fetchFonts result is not OK. (" + r3 + ")");     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            monitor-enter(this.mLock);
            EmojiCompat.MetadataRepoLoaderCallback r11 = this.mCallback;     // Catch: Throwable -> L57
            if (r11 == null) goto L54;
            r11.onFailed(th);     // Catch: Throwable -> L57
        L54:
            cleanUp();
            return;
        L57:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class RetryPolicy {
        public abstract long getRetryDelay();

        public RetryPolicy() {
        }
    }

    public FontRequestEmojiCompatConfig(Context r3, FontRequest r4) {
        super(new FontRequestMetadataLoader(r3, r4, DEFAULT_FONTS_CONTRACT));
    }

    public FontRequestEmojiCompatConfig(Context r2, FontRequest r3, FontProviderHelper r4) {
        super(new FontRequestMetadataLoader(r2, r3, r4));
    }

    public FontRequestEmojiCompatConfig setLoadingExecutor(Executor r2) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(r2);
        return this;
    }

    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(Handler r1) {
        if (r1 != null) goto L4;
        return this;
    L4:
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(r1));
        return this;
    }

    public FontRequestEmojiCompatConfig setRetryPolicy(RetryPolicy r2) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(r2);
        return this;
    }

    static {
        DEFAULT_FONTS_CONTRACT = new FontProviderHelper();
    }
}
