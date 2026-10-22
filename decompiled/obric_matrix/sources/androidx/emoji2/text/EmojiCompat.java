package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.AnyThread;
import androidx.annotation.CheckResult;
import androidx.annotation.ColorInt;
import androidx.annotation.GuardedBy;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
@AnyThread
public class EmojiCompat {
    private static final Object CONFIG_LOCK = null;
    public static final String EDITOR_INFO_METAVERSION_KEY = "android.support.text.emoji.emojiCompat_metadataVersion";
    public static final String EDITOR_INFO_REPLACE_ALL_KEY = "android.support.text.emoji.emojiCompat_replaceAll";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static final int EMOJI_COUNT_UNLIMITED = Integer.MAX_VALUE;
    public static final int EMOJI_FALLBACK = 2;
    public static final int EMOJI_SUPPORTED = 1;
    public static final int EMOJI_UNSUPPORTED = 0;
    private static final Object INSTANCE_LOCK = null;
    public static final int LOAD_STATE_DEFAULT = 3;
    public static final int LOAD_STATE_FAILED = 2;
    public static final int LOAD_STATE_LOADING = 0;
    public static final int LOAD_STATE_SUCCEEDED = 1;
    public static final int LOAD_STRATEGY_DEFAULT = 0;
    public static final int LOAD_STRATEGY_MANUAL = 1;
    private static final String NOT_INITIALIZED_ERROR_TEXT = "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.";
    public static final int REPLACE_STRATEGY_ALL = 1;
    public static final int REPLACE_STRATEGY_DEFAULT = 0;
    public static final int REPLACE_STRATEGY_NON_EXISTENT = 2;

    @GuardedBy("CONFIG_LOCK")
    private static volatile boolean sHasDoneDefaultConfigLookup;

    @Nullable
    @GuardedBy("INSTANCE_LOCK")
    private static volatile EmojiCompat sInstance;

    @Nullable
    final int[] mEmojiAsDefaultStyleExceptions;
    private final int mEmojiSpanIndicatorColor;
    private final boolean mEmojiSpanIndicatorEnabled;
    private final GlyphChecker mGlyphChecker;

    @NonNull
    private final CompatInternal mHelper;

    @NonNull
    @GuardedBy("mInitLock")
    private final Set<InitCallback> mInitCallbacks;

    @NonNull
    private final ReadWriteLock mInitLock;

    @GuardedBy("mInitLock")
    private volatile int mLoadState;

    @NonNull
    private final Handler mMainHandler;
    private final int mMetadataLoadStrategy;

    @NonNull
    final MetadataRepoLoader mMetadataLoader;
    final boolean mReplaceAll;
    final boolean mUseEmojiAsDefaultStyle;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface CodepointSequenceMatchResult {
    }

    private static class CompatInternal {
        final EmojiCompat mEmojiCompat;

        CompatInternal(EmojiCompat r1) {
            this.mEmojiCompat = r1;
        }

        String getAssetSignature() {
            return "";
        }

        public int getEmojiMatch(CharSequence r1, int r2) {
            return 0;
        }

        boolean hasEmojiGlyph(@NonNull CharSequence r1) {
            return false;
        }

        boolean hasEmojiGlyph(@NonNull CharSequence r1, int r2) {
            return false;
        }

        void loadMetadata() {
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        CharSequence process(@NonNull CharSequence r1, @IntRange(from = 0) int r2, @IntRange(from = 0) int r3, @IntRange(from = 0) int r4, boolean r5) {
            return r1;
        }

        void updateEditorInfoAttrs(@NonNull EditorInfo r1) {
        }
    }

    @RequiresApi(19)
    private static final class CompatInternal19 extends CompatInternal {
        private volatile MetadataRepo mMetadataRepo;
        private volatile EmojiProcessor mProcessor;

        CompatInternal19(EmojiCompat r1) {
            super(r1);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        String getAssetSignature() {
            String r0 = this.mMetadataRepo.getMetadataList().sourceSha();
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        public int getEmojiMatch(CharSequence r1, int r2) {
            return this.mProcessor.getEmojiMatch(r1, r2);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence r1) {
            if (this.mProcessor.getEmojiMatch(r1) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        boolean hasEmojiGlyph(@NonNull CharSequence r1, int r2) {
            if (this.mProcessor.getEmojiMatch(r1, r2) == 1) goto L7;
            return false;
        L7:
            return true;
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void loadMetadata() {
            MetadataRepoLoaderCallback r0 = new AnonymousClass1(this);     // Catch: Throwable -> L4
            this.mEmojiCompat.mMetadataLoader.load(r0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            this.mEmojiCompat.onMetadataLoadFailed(th);
        }

        void onMetadataLoadSuccess(@NonNull MetadataRepo r8) {
            if (r8 != null) goto L5;
            this.mEmojiCompat.onMetadataLoadFailed(new IllegalArgumentException("metadataRepo cannot be null"));
            return;
        L5:
            this.mMetadataRepo = r8;
            MetadataRepo r2 = this.mMetadataRepo;
            SpanFactory r3 = new SpanFactory();
            GlyphChecker r4 = EmojiCompat.access$000(this.mEmojiCompat);
            EmojiCompat r0 = this.mEmojiCompat;
            this.mProcessor = new EmojiProcessor(r2, r3, r4, r0.mUseEmojiAsDefaultStyle, r0.mEmojiAsDefaultStyleExceptions);
            this.mEmojiCompat.onMetadataLoadSuccess();
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        CharSequence process(@NonNull CharSequence r7, int r8, int r9, int r10, boolean r11) {
            return this.mProcessor.process(r7, r8, r9, r10, r11);
        }

        @Override // androidx.emoji2.text.EmojiCompat.CompatInternal
        void updateEditorInfoAttrs(@NonNull EditorInfo r4) {
            r4.extras.putInt(EmojiCompat.EDITOR_INFO_METAVERSION_KEY, this.mMetadataRepo.getMetadataVersion());
            r4.extras.putBoolean(EmojiCompat.EDITOR_INFO_REPLACE_ALL_KEY, this.mEmojiCompat.mReplaceAll);
        }
    }

    public static abstract class Config {

        @Nullable
        int[] mEmojiAsDefaultStyleExceptions;
        int mEmojiSpanIndicatorColor;
        boolean mEmojiSpanIndicatorEnabled;

        @NonNull
        GlyphChecker mGlyphChecker;

        @Nullable
        Set<InitCallback> mInitCallbacks;
        int mMetadataLoadStrategy;

        @NonNull
        final MetadataRepoLoader mMetadataLoader;
        boolean mReplaceAll;
        boolean mUseEmojiAsDefaultStyle;

        protected Config(@NonNull MetadataRepoLoader r2) {
            this.mEmojiSpanIndicatorColor = -16711936;
            this.mMetadataLoadStrategy = 0;
            this.mGlyphChecker = new DefaultGlyphChecker();
            Preconditions.checkNotNull(r2, "metadataLoader cannot be null.");
            this.mMetadataLoader = r2;
        }

        @NonNull
        protected final MetadataRepoLoader getMetadataRepoLoader() {
            return this.mMetadataLoader;
        }

        @NonNull
        public Config registerInitCallback(@NonNull InitCallback r2) {
            Preconditions.checkNotNull(r2, "initCallback cannot be null");
            if (this.mInitCallbacks != null) goto L5;
            this.mInitCallbacks = new ArraySet();
        L5:
            this.mInitCallbacks.add(r2);
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorColor(@ColorInt int r1) {
            this.mEmojiSpanIndicatorColor = r1;
            return this;
        }

        @NonNull
        public Config setEmojiSpanIndicatorEnabled(boolean r1) {
            this.mEmojiSpanIndicatorEnabled = r1;
            return this;
        }

        @NonNull
        public Config setGlyphChecker(@NonNull GlyphChecker r2) {
            Preconditions.checkNotNull(r2, "GlyphChecker cannot be null");
            this.mGlyphChecker = r2;
            return this;
        }

        @NonNull
        public Config setMetadataLoadStrategy(int r1) {
            this.mMetadataLoadStrategy = r1;
            return this;
        }

        @NonNull
        public Config setReplaceAll(boolean r1) {
            this.mReplaceAll = r1;
            return this;
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r2) {
            return setUseEmojiAsDefaultStyle(r2, null);
        }

        @NonNull
        public Config setUseEmojiAsDefaultStyle(boolean r4, @Nullable List<Integer> r5) {
            this.mUseEmojiAsDefaultStyle = r4;
            if (r4 == false) goto L10;
            if (r5 == null) goto L10;
            this.mEmojiAsDefaultStyleExceptions = new int[r5.size()];
            int r6 = 0;
            Iterator<Integer> r7 = r5.iterator();
        L7:
            if (r7.hasNext() == false) goto L9;
            Integer r0 = r7.next();
            this.mEmojiAsDefaultStyleExceptions[r6] = r0.intValue();
            r6 = r6 + 1;
            goto L7
        L9:
            Arrays.sort(this.mEmojiAsDefaultStyleExceptions);
        L11:
            return this;
        L10:
            this.mEmojiAsDefaultStyleExceptions = null;
            goto L11
        }

        @NonNull
        public Config unregisterInitCallback(@NonNull InitCallback r2) {
            Preconditions.checkNotNull(r2, "initCallback cannot be null");
            Set<InitCallback> r0 = this.mInitCallbacks;
            if (r0 == null) goto L5;
            r0.remove(r2);
        L5:
            return this;
        }
    }

    public interface GlyphChecker {
        boolean hasGlyph(@NonNull CharSequence r1, @IntRange(from = 0) int r2, @IntRange(from = 0) int r3, @IntRange(from = 0) int r4);
    }

    public static abstract class InitCallback {
        public InitCallback() {
        }

        public void onFailed(@Nullable Throwable r1) {
        }

        public void onInitialized() {
        }
    }

    private static class ListenerDispatcher implements Runnable {
        private final List<InitCallback> mInitCallbacks;
        private final int mLoadState;
        private final Throwable mThrowable;

        ListenerDispatcher(@NonNull InitCallback r3, int r4) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) Preconditions.checkNotNull(r3, "initCallback cannot be null")}), r4, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> r2, int r3) {
            this(r2, r3, null);
        }

        ListenerDispatcher(@NonNull Collection<InitCallback> r2, int r3, @Nullable Throwable r4) {
            Preconditions.checkNotNull(r2, "initCallbacks cannot be null");
            this.mInitCallbacks = new ArrayList(r2);
            this.mLoadState = r3;
            this.mThrowable = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            int r0 = this.mInitCallbacks.size();
            int r2 = 0;
            if (this.mLoadState == 1) goto L6;
        L4:
            if (r2 >= r0) goto L8;
            this.mInitCallbacks.get(r2).onFailed(this.mThrowable);
            r2 = r2 + 1;
            goto L4
        L8:
            return;
        L6:
            if (r2 >= r0) goto L11;
            this.mInitCallbacks.get(r2).onInitialized();
            r2 = r2 + 1;
            goto L6
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface LoadStrategy {
    }

    public interface MetadataRepoLoader {
        void load(@NonNull MetadataRepoLoaderCallback r1);
    }

    public static abstract class MetadataRepoLoaderCallback {
        public MetadataRepoLoaderCallback() {
        }

        public abstract void onFailed(@Nullable Throwable r1);

        public abstract void onLoaded(@NonNull MetadataRepo r1);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface ReplaceStrategy {
    }

    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class SpanFactory {
        SpanFactory() {
        }

        EmojiSpan createSpan(@NonNull EmojiMetadata r1) {
            return new TypefaceEmojiSpan(r1);
        }
    }

    static {
        INSTANCE_LOCK = new Object();
        CONFIG_LOCK = new Object();
    }

    private EmojiCompat(@NonNull Config r3) {
        this.mInitLock = new ReentrantReadWriteLock();
        this.mLoadState = 3;
        this.mReplaceAll = r3.mReplaceAll;
        this.mUseEmojiAsDefaultStyle = r3.mUseEmojiAsDefaultStyle;
        this.mEmojiAsDefaultStyleExceptions = r3.mEmojiAsDefaultStyleExceptions;
        this.mEmojiSpanIndicatorEnabled = r3.mEmojiSpanIndicatorEnabled;
        this.mEmojiSpanIndicatorColor = r3.mEmojiSpanIndicatorColor;
        this.mMetadataLoader = r3.mMetadataLoader;
        this.mMetadataLoadStrategy = r3.mMetadataLoadStrategy;
        this.mGlyphChecker = r3.mGlyphChecker;
        this.mMainHandler = new Handler(Looper.getMainLooper());
        ArraySet r0 = new ArraySet();
        this.mInitCallbacks = r0;
        Set<InitCallback> r1 = r3.mInitCallbacks;
        if (r1 == null) goto L8;
        if (r1.isEmpty() == true) goto L8;
        r0.addAll(r3.mInitCallbacks);
    L8:
        if (Build.VERSION.SDK_INT >= 19) goto L10;
        CompatInternal r4 = new CompatInternal(this);
    L11:
        this.mHelper = r4;
        loadMetadata();
        return;
    L10:
        r4 = new CompatInternal19(this);
        goto L11
    }

    static /* synthetic */ GlyphChecker access$000(EmojiCompat r0) {
        return r0.mGlyphChecker;
    }

    @NonNull
    public static EmojiCompat get() {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        EmojiCompat r1 = sInstance;     // Catch: Throwable -> L11
        if (r1 == null) goto L7;
        boolean r2 = true;
    L8:
        Preconditions.checkState(r2, NOT_INITIALIZED_ERROR_TEXT);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return r1;
    L7:
        r2 = false;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean handleDeleteSurroundingText(@NonNull InputConnection r2, @NonNull Editable r3, @IntRange(from = 0) int r4, @IntRange(from = 0) int r5, boolean r6) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleDeleteSurroundingText(r2, r3, r4, r5, r6);
    }

    public static boolean handleOnKeyDown(@NonNull Editable r2, int r3, @NonNull KeyEvent r4) {
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return false;
    L5:
        return EmojiProcessor.handleOnKeyDown(r2, r3, r4);
    }

    @Nullable
    public static EmojiCompat init(@NonNull Context r1) {
        return init(r1, null);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static EmojiCompat init(@NonNull Context r1, @Nullable DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory r2) {
        if (sHasDoneDefaultConfigLookup == true) goto L5;
        if (r2 != null) goto L9;
        r2 = new DefaultEmojiCompatConfig.DefaultEmojiCompatConfigFactory(null);
    L9:
        Config r3 = r2.create(r1);
        Object r4 = CONFIG_LOCK;
        monitor-enter(r4);
    L19:
        th = move-exception;
        throw th;
    L12:
        if (sHasDoneDefaultConfigLookup == true) goto L16;
        if (r3 == null) goto L15;
        init(r3);     // Catch: Throwable -> L19
    L15:
        sHasDoneDefaultConfigLookup = true;     // Catch: Throwable -> L19
    L16:
        EmojiCompat r5 = sInstance;     // Catch: Throwable -> L19
        monitor-exit(r4);     // Catch: Throwable -> L19
        return r5;
    L5:
        return sInstance;
    }

    @NonNull
    public static EmojiCompat init(@NonNull Config r2) {
        EmojiCompat r0 = sInstance;
        if (r0 != null) goto L14;
        Object r1 = INSTANCE_LOCK;
        monitor-enter(r1);
        r0 = sInstance;     // Catch: Throwable -> L11
        if (r0 != null) goto L9;
        r0 = new EmojiCompat(r2);     // Catch: Throwable -> L11
        sInstance = r0;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r1);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L14:
        return r0;
    }

    public static boolean isConfigured() {
        if (sInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isInitialized() {
        if (getLoadState() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void loadMetadata() {
        this.mInitLock.writeLock().lock();
    L10:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mMetadataLoadStrategy != 0) goto L6;
        this.mLoadState = 0;     // Catch: Throwable -> L10
    L6:
        this.mInitLock.writeLock().unlock();
        if (getLoadState() != 0) goto L15;
        this.mHelper.loadMetadata();
        return;
    }

    @NonNull
    public static EmojiCompat reset(@NonNull Config r2) {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        EmojiCompat r1 = new EmojiCompat(r2);     // Catch: Throwable -> L7
        sInstance = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.TESTS})
    public static EmojiCompat reset(@Nullable EmojiCompat r1) {
        Object r0 = INSTANCE_LOCK;
        monitor-enter(r0);
        sInstance = r1;     // Catch: Throwable -> L7
        EmojiCompat r2 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static void skipDefaultConfigurationLookup(boolean r1) {
        Object r0 = CONFIG_LOCK;
        monitor-enter(r0);
        sHasDoneDefaultConfigLookup = r1;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @NonNull
    public String getAssetSignature() {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        return this.mHelper.getAssetSignature();
    }

    public int getEmojiMatch(@NonNull CharSequence r3, @IntRange(from = 0) int r4) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r3, "sequence cannot be null");
        return this.mHelper.getEmojiMatch(r3, r4);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiSpanIndicatorColor() {
        return this.mEmojiSpanIndicatorColor;
    }

    public int getLoadState() {
        this.mInitLock.readLock().lock();
        int r0 = this.mLoadState;     // Catch: Throwable -> L6
        this.mInitLock.readLock().unlock();
        return r0;
    L6:
        th = move-exception;
        this.mInitLock.readLock().unlock();
        throw th;
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r3) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r3, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r3);
    }

    @Deprecated
    public boolean hasEmojiGlyph(@NonNull CharSequence r3, @IntRange(from = 0) int r4) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkNotNull(r3, "sequence cannot be null");
        return this.mHelper.hasEmojiGlyph(r3, r4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isEmojiSpanIndicatorEnabled() {
        return this.mEmojiSpanIndicatorEnabled;
    }

    public void load() {
        boolean r2 = true;
        if (this.mMetadataLoadStrategy == 1) goto L6;
        r2 = false;
    L6:
        Preconditions.checkState(r2, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (isInitialized() == false) goto L9;
        return;
    L9:
        this.mInitLock.writeLock().lock();
    L17:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L11:
        if (this.mLoadState != 0) goto L14;
        this.mInitLock.writeLock().unlock();
        return;
    L14:
        this.mLoadState = 0;     // Catch: Throwable -> L17
        this.mInitLock.writeLock().unlock();
        this.mHelper.loadMetadata();
    }

    void onMetadataLoadFailed(@Nullable Throwable r4) {
        ArrayList r0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 2;     // Catch: Throwable -> L6
        r0.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r0, this.mLoadState, r4));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    void onMetadataLoadSuccess() {
        ArrayList r0 = new ArrayList();
        this.mInitLock.writeLock().lock();
        this.mLoadState = 1;     // Catch: Throwable -> L6
        r0.addAll(this.mInitCallbacks);     // Catch: Throwable -> L6
        this.mInitCallbacks.clear();     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        this.mMainHandler.post(new ListenerDispatcher(r0, this.mLoadState));
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r3) {
        if (r3 != null) goto L5;
        int r1 = 0;
    L7:
        return process(r3, 0, r1);
    L5:
        r1 = r3.length();
        goto L7
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r2, @IntRange(from = 0) int r3, @IntRange(from = 0) int r4) {
        return process(r2, r3, r4, Integer.MAX_VALUE);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r7, @IntRange(from = 0) int r8, @IntRange(from = 0) int r9, @IntRange(from = 0) int r10) {
        return process(r7, r8, r9, r10, 0);
    }

    @Nullable
    @CheckResult
    public CharSequence process(@Nullable CharSequence r8, @IntRange(from = 0) int r9, @IntRange(from = 0) int r10, @IntRange(from = 0) int r11, int r12) {
        Preconditions.checkState(isInitialized(), "Not initialized yet");
        Preconditions.checkArgumentNonnegative(r9, "start cannot be negative");
        Preconditions.checkArgumentNonnegative(r10, "end cannot be negative");
        Preconditions.checkArgumentNonnegative(r11, "maxEmojiCount cannot be negative");
        boolean r0 = false;
        if (r9 > r10) goto L5;
        boolean r2 = true;
    L6:
        Preconditions.checkArgument(r2, "start should be <= than end");
        if (r8 != null) goto L11;
        return null;
    L11:
        if (r9 > r8.length()) goto L13;
        boolean r3 = true;
    L14:
        Preconditions.checkArgument(r3, "start should be < than charSequence length");
        if (r10 > r8.length()) goto L17;
        boolean r4 = true;
    L18:
        Preconditions.checkArgument(r4, "end should be < than charSequence length");
        if (r8.length() == 0) goto L30;
        if (r9 == r10) goto L30;
        if (r12 != 1) goto L24;
        boolean r6 = true;
    L29:
        return this.mHelper.process(r8, r9, r10, r11, r6);
    L24:
        if (r12 == 2) goto L26;
        r0 = this.mReplaceAll;
    L26:
        r6 = r0;
    L30:
        return r8;
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L5:
        r2 = false;
        goto L6
    }

    public void registerInitCallback(@NonNull InitCallback r4) {
        Preconditions.checkNotNull(r4, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
    L12:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    L4:
        if (this.mLoadState != 1) goto L6;
    L9:
        this.mMainHandler.post(new ListenerDispatcher(r4, this.mLoadState));     // Catch: Throwable -> L12
    L10:
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        if (this.mLoadState == 2) goto L9;
        this.mInitCallbacks.add(r4);     // Catch: Throwable -> L12
        goto L10
    }

    public void unregisterInitCallback(@NonNull InitCallback r2) {
        Preconditions.checkNotNull(r2, "initCallback cannot be null");
        this.mInitLock.writeLock().lock();
        this.mInitCallbacks.remove(r2);     // Catch: Throwable -> L6
        this.mInitLock.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        this.mInitLock.writeLock().unlock();
        throw th;
    }

    public void updateEditorInfo(@NonNull EditorInfo r2) {
        if (isInitialized() == false) goto L11;
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.extras != null) goto L9;
        r2.extras = new Bundle();
    L9:
        this.mHelper.updateEditorInfoAttrs(r2);
        return;
    }
}
