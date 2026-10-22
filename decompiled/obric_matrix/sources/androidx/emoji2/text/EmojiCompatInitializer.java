package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.os.TraceCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements Initializer<Boolean> {
    private static final long STARTUP_THREAD_CREATION_DELAY_MS = 500;
    private static final String S_INITIALIZER_THREAD_NAME = "EmojiCompatInitializer";

    @RequiresApi(19)
    static class BackgroundDefaultConfig extends EmojiCompat.Config {
        protected BackgroundDefaultConfig(Context r2) {
            super(new BackgroundDefaultLoader(r2));
            setMetadataLoadStrategy(1);
        }
    }

    @RequiresApi(19)
    static class BackgroundDefaultLoader implements EmojiCompat.MetadataRepoLoader {
        private final Context mContext;

        BackgroundDefaultLoader(Context r1) {
            this.mContext = r1.getApplicationContext();
        }

        private /* synthetic */ void a(EmojiCompat.MetadataRepoLoaderCallback r1, ThreadPoolExecutor r2) {
            doLoad(r1, r2);
        }

        public /* synthetic */ void b(EmojiCompat.MetadataRepoLoaderCallback r1, ThreadPoolExecutor r2) {
            a(r1, r2);
        }

        @WorkerThread
        void doLoad(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r3, @NonNull final ThreadPoolExecutor r4) {
            FontRequestEmojiCompatConfig r0 = DefaultEmojiCompatConfig.create(this.mContext);     // Catch: Throwable -> L7
            if (r0 == null) goto L6;
            r0.setLoadingExecutor(r4);     // Catch: Throwable -> L7
            r0.getMetadataRepoLoader().load(new AnonymousClass1(this, r3, r4));     // Catch: Throwable -> L7
            return;
        L6:
            throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            r3.onFailed(th);
            r4.shutdown();
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        public void load(@NonNull final EmojiCompat.MetadataRepoLoaderCallback r3) {
            final ThreadPoolExecutor r0 = ConcurrencyHelpers.createBackgroundPriorityExecutor(EmojiCompatInitializer.S_INITIALIZER_THREAD_NAME);
            r0.execute(new c(this, r3, r0));
        }
    }

    static class LoadEmojiCompatRunnable implements Runnable {
        LoadEmojiCompatRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TraceCompat.beginSection("EmojiCompat.EmojiCompatInitializer.run");     // Catch: Throwable -> L7
            if (EmojiCompat.isConfigured() == false) goto L5;
            EmojiCompat.get().load();     // Catch: Throwable -> L7
        L5:
            TraceCompat.endSection();
            return;
        L7:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }
    }

    public EmojiCompatInitializer() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    @NonNull
    public Boolean create(@NonNull Context r3) {
        if (Build.VERSION.SDK_INT < 19) goto L7;
        EmojiCompat.init(new BackgroundDefaultConfig(r3));
        delayUntilFirstResume(r3);
        return Boolean.TRUE;
    L7:
        return Boolean.FALSE;
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public /* bridge */ /* synthetic */ Boolean create(@NonNull Context r1) {
        return create(r1);
    }

    @RequiresApi(19)
    void delayUntilFirstResume(@NonNull Context r2) {
        final Lifecycle r3 = ((LifecycleOwner) AppInitializer.getInstance(r2).initializeComponent(ProcessLifecycleInitializer.class)).getLifecycle();
        r3.addObserver(new AnonymousClass1(this, r3));
    }

    @Override // androidx.startup.Initializer
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @RequiresApi(19)
    void loadEmojiCompatAfterDelay() {
        ConcurrencyHelpers.mainHandlerAsync().postDelayed(new LoadEmojiCompatRunnable(), STARTUP_THREAD_CREATION_DELAY_MS);
    }
}
