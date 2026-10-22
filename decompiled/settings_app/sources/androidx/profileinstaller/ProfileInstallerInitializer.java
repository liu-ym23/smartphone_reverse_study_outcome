package androidx.profileinstaller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements Initializer<Result> {
    private static final int DELAY_MS = 5000;

    private static class Choreographer16Impl {
        private Choreographer16Impl() {
        }

        static /* synthetic */ void lambda$postFrameCallback$0(Runnable r0, long r1) {
            r0.run();
        }

        public static void postFrameCallback(final Runnable r2) {
            Choreographer.getInstance().postFrameCallback(new ProfileInstallerInitializer$Choreographer16Impl$$ExternalSyntheticLambda0(r2));
        }
    }

    private static class Handler28Impl {
        private Handler28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }
    }

    public static class Result {
        public Result() {
        }
    }

    public ProfileInstallerInitializer() {
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ Result create(Context r1) {
        return create(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.startup.Initializer
    public Result create(Context r1) {
        delayAfterFirstFrame(r1.getApplicationContext());
        return new Result();
    }

    void delayAfterFirstFrame(final Context r2) {
        Choreographer16Impl.postFrameCallback(new ProfileInstallerInitializer$$ExternalSyntheticLambda1(this, r2));
    }

    /* JADX INFO: renamed from: lambda$delayAfterFirstFrame$0$androidx-profileinstaller-ProfileInstallerInitializer, reason: not valid java name */
    /* synthetic */ void m65xfbd6c934(Context r1) {
        installAfterDelay(r1);
    }

    void installAfterDelay(final Context r5) {
        Handler28Impl.createAsync(Looper.getMainLooper()).postDelayed(new ProfileInstallerInitializer$$ExternalSyntheticLambda0(r5), new Random().nextInt(Math.max(1000, 1)) + 5000);
    }

    static /* synthetic */ void lambda$installAfterDelay$1(Context r0) {
        writeInBackground(r0);
    }

    @Override // androidx.startup.Initializer
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    private static void writeInBackground(final Context r8) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new ProfileInstallerInitializer$$ExternalSyntheticLambda2(r8));
    }

    static /* synthetic */ void lambda$writeInBackground$2(Context r0) {
        ProfileInstaller.writeProfile(r0);
    }
}
