package sf;

import android.content.Context;
import com.bytedance.lynx.media.playable.IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType;
import com.lynx.jsbridge.LynxResourceModule;
import com.ss.ttvideoengine.TTVideoEngine;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f21894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public uf.b f21895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pf.b f21896c;
    public WeakReference d;
    public Map e;

    public d(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this.f21894a = r5;
    }

    public final void i(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "options");
        WeakReference r10 = this.d;
        if (r10 == null) goto L22;
        TTVideoEngine r11 = (TTVideoEngine) r10.get();
        if (r11 == null) goto L37;
        Iterator r12 = r5.entrySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L38;
        Map.Entry r13 = (Map.Entry) r12.next();
        int r14 = ((IVideoEnginePlayable$IVideoEnginePlayablePlayOptionType) ((Pair) r13.getValue()).getSecond()).ordinal();
        if (r14 != 0) goto L12;
        r11.setStringOption(((Number) r13.getKey()).intValue(), (String) ((Pair) r13.getValue()).getFirst());
        goto L8
    L12:
        if (r14 != 1) goto L14;
        r11.setIntOption(((Number) r13.getKey()).intValue(), ((Integer) ((Pair) r13.getValue()).getFirst()).intValue());
        goto L8
    L14:
        if (r14 != 2) goto L16;
        r11.setLongOption(((Number) r13.getKey()).intValue(), ((Long) ((Pair) r13.getValue()).getFirst()).longValue());
        goto L8
    L16:
        if (r14 != 3) goto L8;
        r11.setFloatOption(((Number) r13.getKey()).intValue(), ((Float) ((Pair) r13.getValue()).getFirst()).floatValue());
        goto L8
    L38:
        return;
    L37:
        return;
    }

    public boolean j(Map r5) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        if (r5.containsKey("muted") == false) goto L5;
        return true;
    L5:
        if (r5.containsKey("loop") == false) goto L7;
        return true;
    L7:
        if (r5.containsKey("speed") == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final void k(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "options");
        WeakReference r10 = this.d;
        if (r10 == null) goto L5;
        TTVideoEngine r11 = (TTVideoEngine) r10.get();
    L6:
        if (r11 != null) goto L9;
        this.e = r5;
        return;
    L9:
        i(r5);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
