package d.g.d.b.b;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import androidx.annotation.RawRes;
import androidx.annotation.RequiresApi;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f0;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SoundPool f16794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, Integer> f16795b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap.KeySetView<Integer, Boolean> f16796c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f16797d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final l f16798e = null;

    static final class a implements SoundPool.OnLoadCompleteListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f16799a = null;

        static {
            f16799a = new a();
        }

        a() {
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool r3, int r4, int r5) {
            if (r5 != 0) goto L22;
            Set r6 = l.b(l.f16798e).entrySet();
            kotlin.n0.d.o.e(r6, "soundIdMap.entries");
            Iterator r7 = r6.iterator();
        L5:
            Integer r0 = null;
            if (r7.hasNext() == false) goto L16;
            Object r8 = r7.next();
            Integer r1 = (Integer) ((Map.Entry) r8).getValue();
            if (r1 != null) goto L11;
        L13:
            boolean r2 = false;
        L14:
            if (r2 == false) goto L5;
        L17:
            Map.Entry r9 = (Map.Entry) r8;
            if (r9 == null) goto L20;
            r0 = (Integer) r9.getKey();
        L20:
            if (r0 == null) goto L29;
            l.a(l.f16798e).add(r0);
            d.g.d.f.f.b.a("OUISoundEffectHelper", "loaded: resId=" + r0);
            return;
        L29:
            return;
        L11:
            if (r1.intValue() != r4) goto L13;
            r2 = true;
            goto L14
        L16:
            r8 = null;
            goto L17
        L22:
            d.g.d.f.f.b.b("OUISoundEffectHelper", "load failed, sampleId=" + r4 + ", status=" + r5);
        }
    }

    static {
        f16798e = new l();
        f16795b = new ConcurrentHashMap();
        f16796c = ConcurrentHashMap.newKeySet();
        f16797d = new Object();
    }

    private l() {
    }

    public static final /* synthetic */ ConcurrentHashMap.KeySetView a(l r0) {
        return f16796c;
    }

    public static final /* synthetic */ ConcurrentHashMap b(l r0) {
        return f16795b;
    }

    private final void c(Context r3) {
        if (f16794a != null) goto L17;
        Object r2 = f16797d;
        monitor-enter(r2);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (f16794a != null) goto L11;
        d.g.d.f.f.b.a("OUISoundEffectHelper", "init soundPool");     // Catch: Throwable -> L14
        AudioAttributes r4 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L14
        SoundPool r5 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r4).build();     // Catch: Throwable -> L14
        f16794a = r5;     // Catch: Throwable -> L14
        if (r5 == null) goto L11;
        r5.setOnLoadCompleteListener(a.f16799a);     // Catch: Throwable -> L14
    L11:
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L14
        monitor-exit(r2);
        return;
    }

    private final int d(Context r3) {
        return Settings.System.getInt(r3.getContentResolver(), "sound_effects_enabled", 0);
    L5:
        e = move-exception;
        d.g.d.f.f.b.c("OUISoundEffectHelper", "get sound effect enabled failed", e);
        return 0;
    }

    public final void e(Context r12, int... r13) {
        kotlin.n0.d.o.f(r12, "context");
        kotlin.n0.d.o.f(r13, "soundResIds");
        c(r12);     // Catch: Exception -> L14
        int r11 = 0;
        int r1 = r13.length;     // Catch: Exception -> L14
    L4:
        if (r11 >= r1) goto L26;
        int r2 = r13[r11];     // Catch: Exception -> L14
        r11 = r11 + 1;     // Catch: Exception -> L14
        ConcurrentHashMap<Integer, Integer> r3 = f16795b;     // Catch: Exception -> L14
        if (r3.containsKey(Integer.valueOf(r2)) == true) goto L4;
        SoundPool r4 = f16794a;     // Catch: Exception -> L14
        if (r4 == null) goto L10;
        Integer r5 = Integer.valueOf(r4.load(r12.getApplicationContext(), r2, 1));     // Catch: Exception -> L14
    L11:
        if (r5 == null) goto L4;
        r3.put(Integer.valueOf(r2), r5);     // Catch: Exception -> L14
        d.g.d.f.f.b.a("OUISoundEffectHelper", "start load, resId=" + r2 + ", 分配的 soundId=" + r5);     // Catch: Exception -> L14
        goto L4
    L10:
        r5 = null;
        goto L11
    L26:
        return;
    L14:
        e = move-exception;
        d.g.d.f.f.b.c("OUISoundEffectHelper", "load failed, resIds=" + kotlin.i0.i.M(r13, ", ", null, null, 0, null, null, 62, null), e);
    }

    public final void f(Context r9, @RawRes int r10) {
        if (r9 != null) goto L7;
        d.g.d.f.f.b.j("OUISoundEffectHelper", "can't play, context is null");
        return;
    L7:
        if (d(r9) != 0) goto L25;
        return;
    L25:
        c(r9);     // Catch: Exception -> L21
        if (f16796c.contains(Integer.valueOf(r10)) == false) goto L12;
        Integer r8 = f16795b.get(Integer.valueOf(r10));     // Catch: Exception -> L21
        if (r8 == null) goto L24;
        SoundPool r1 = f16794a;     // Catch: Exception -> L21
        if (r1 == null) goto L24;
        kotlin.n0.d.o.e(r8, "soundId");     // Catch: Exception -> L21
        r1.play(r8.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L21
    L24:
        return;
    L12:
        if (f16795b.containsKey(Integer.valueOf(r10)) == true) goto L14;
        d.g.d.f.f.b.j("OUISoundEffectHelper", "not loaded, start now: resId=" + r10);     // Catch: Exception -> L21
        e(r9, new int[]{r10});     // Catch: Exception -> L21
        goto L24
    L14:
        d.g.d.f.f.b.a("OUISoundEffectHelper", "loading: resId=" + r10);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        d.g.d.f.f.b.c("OUISoundEffectHelper", "play failed, resId=" + r10, e);
    }

    public final void g() {
        d.g.d.f.f.b.a("OUISoundEffectHelper", "release");
        SoundPool r1 = f16794a;
        if (r1 == null) goto L5;
        r1.release();
    L5:
        f16794a = null;
        f16795b.clear();
        f16796c.clear();
    }
}
