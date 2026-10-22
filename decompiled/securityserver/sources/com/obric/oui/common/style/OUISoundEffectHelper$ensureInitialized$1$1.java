package com.obric.oui.common.style;

import android.media.SoundPool;
import com.obric.oui.utils.log.L;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
final class OUISoundEffectHelper$ensureInitialized$1$1 implements SoundPool.OnLoadCompleteListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OUISoundEffectHelper$ensureInitialized$1$1 f203a = null;

    static {
        f203a = new OUISoundEffectHelper$ensureInitialized$1$1();
    }

    @Override // android.media.SoundPool.OnLoadCompleteListener
    public final void onLoadComplete(SoundPool r3, int r4, int r5) {
        if (r5 != 0) goto L19;
        SoundPool r6 = OUISoundEffectHelper.f201a;
        Set r7 = OUISoundEffectHelper.b.entrySet();
        Intrinsics.e(r7, "soundIdMap.entries");
        Iterator r8 = r7.iterator();
    L5:
        Integer r0 = null;
        if (r8.hasNext() == false) goto L13;
        Object r9 = r8.next();
        Integer r1 = (Integer) ((Map.Entry) r9).getValue();
        if (r1 == null) goto L5;
        if (r1.intValue() != r4) goto L5;
    L14:
        Map.Entry r10 = (Map.Entry) r9;
        if (r10 == null) goto L17;
        r0 = (Integer) r10.getKey();
    L17:
        if (r0 == null) goto L27;
        SoundPool r11 = OUISoundEffectHelper.f201a;
        OUISoundEffectHelper.c.add(r0);
        L.a("OUISoundEffectHelper", "loaded: resId=" + r0);
        return;
    L27:
        return;
    L13:
        r9 = null;
        goto L14
    L19:
        L.b("OUISoundEffectHelper", "load failed, sampleId=" + r4 + ", status=" + r5);
    }
}
