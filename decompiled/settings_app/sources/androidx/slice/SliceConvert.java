package androidx.slice;

import android.content.Context;
import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.graphics.drawable.IconCompat;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class SliceConvert {
    private static final String TAG = "SliceConvert";

    public static android.app.slice.Slice unwrap(Slice r5) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.getUri() == null) goto L70;
        android.app.slice.Slice.Builder r0 = new android.app.slice.Slice.Builder(r5.getUri(), unwrap(r5.getSpec()));
        r0.addHints(r5.getHints());
        Iterator<SliceItem> r6 = r5.getItems().iterator();
    L8:
        if (r6.hasNext() == false) goto L50;
        SliceItem r1 = r6.next();
        String r2 = r1.getFormat();
        r2.hashCode();
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1422950858: goto L37;
            case 104431: goto L33;
            case 3327612: goto L29;
            case 3556653: goto L25;
            case 100313435: goto L21;
            case 100358090: goto L17;
            case 109526418: goto L13;
            default: goto L40;
        };
    L40:
        switch(r4) {
            case 0: goto L48;
            case 1: goto L47;
            case 2: goto L46;
            case 3: goto L45;
            case 4: goto L44;
            case 5: goto L43;
            case 6: goto L42;
            default: goto L8;
        };
    L42:
        r0.addSubSlice(unwrap(r1.getSlice()), r1.getSubType());
        goto L8
    L43:
        r0.addRemoteInput(r1.getRemoteInput(), r1.getSubType(), r1.getHints());
        goto L8
    L44:
        r0.addIcon(r1.getIcon().toIcon(), r1.getSubType(), r1.getHints());
        goto L8
    L45:
        r0.addText(r1.getText(), r1.getSubType(), r1.getHints());
        goto L8
    L46:
        r0.addLong(r1.getLong(), r1.getSubType(), r1.getHints());
        goto L8
    L47:
        r0.addInt(r1.getInt(), r1.getSubType(), r1.getHints());
        goto L8
    L48:
        r0.addAction(r1.getAction(), unwrap(r1.getSlice()), r1.getSubType());
        goto L8
    L13:
        if (r2.equals("slice") == false) goto L40;
        r4 = 6;
        goto L40
    L17:
        if (r2.equals("input") == false) goto L40;
        r4 = 5;
        goto L40
    L21:
        if (r2.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L40;
        r4 = 4;
        goto L40
    L25:
        if (r2.equals("text") == false) goto L40;
        r4 = 3;
        goto L40
    L29:
        if (r2.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L40;
        r4 = 2;
        goto L40
    L33:
        if (r2.equals("int") == false) goto L40;
        r4 = 1;
        goto L40
    L37:
        if (r2.equals("action") == false) goto L40;
        r4 = 0;
        goto L40
    L50:
        return r0.build();
    L70:
        return null;
    }

    private static android.app.slice.SliceSpec unwrap(SliceSpec r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new android.app.slice.SliceSpec(r2.getType(), r2.getRevision());
    }

    static Set<android.app.slice.SliceSpec> unwrap(Set<SliceSpec> r2) {
        ArraySet r0 = new ArraySet();
        if (r2 == null) goto L8;
        Iterator<SliceSpec> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.add(unwrap(r3.next()));
    L8:
        return r0;
    }

    public static Slice wrap(android.app.slice.Slice r5, Context r6) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (r5.getUri() == null) goto L75;
        Slice.Builder r0 = new Slice.Builder(r5.getUri());
        r0.addHints(r5.getHints());
        r0.setSpec(wrap(r5.getSpec()));
        Iterator<android.app.slice.SliceItem> r7 = r5.getItems().iterator();
    L8:
        if (r7.hasNext() == false) goto L53;
        android.app.slice.SliceItem r1 = r7.next();
        String r2 = r1.getFormat();
        r2.hashCode();
        byte r4 = -1;
        switch(r2.hashCode()) {
            case -1422950858: goto L37;
            case 104431: goto L33;
            case 3327612: goto L29;
            case 3556653: goto L25;
            case 100313435: goto L21;
            case 100358090: goto L17;
            case 109526418: goto L13;
            default: goto L40;
        };
    L40:
        switch(r4) {
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L56;
            case 5: goto L43;
            case 6: goto L42;
            default: goto L8;
        };
    L56:
        r0.addIcon(IconCompat.createFromIcon(r6, r1.getIcon()), r1.getSubType(), r1.getHints());     // Catch: IllegalArgumentException -> L46
    L46:
        e = move-exception;
        Log.w(TAG, "The icon resource isn't available.", e);
        goto L8
    L42:
        r0.addSubSlice(wrap(r1.getSlice(), r6), r1.getSubType());
        goto L8
    L43:
        r0.addRemoteInput(r1.getRemoteInput(), r1.getSubType(), r1.getHints());
        goto L8
    L48:
        r0.addText(r1.getText(), r1.getSubType(), r1.getHints());
        goto L8
    L49:
        r0.addLong(r1.getLong(), r1.getSubType(), r1.getHints());
        goto L8
    L50:
        r0.addInt(r1.getInt(), r1.getSubType(), r1.getHints());
        goto L8
    L51:
        r0.addAction(r1.getAction(), wrap(r1.getSlice(), r6), r1.getSubType());
        goto L8
    L13:
        if (r2.equals("slice") == false) goto L40;
        r4 = 6;
        goto L40
    L17:
        if (r2.equals("input") == false) goto L40;
        r4 = 5;
        goto L40
    L21:
        if (r2.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L40;
        r4 = 4;
        goto L40
    L25:
        if (r2.equals("text") == false) goto L40;
        r4 = 3;
        goto L40
    L29:
        if (r2.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L40;
        r4 = 2;
        goto L40
    L33:
        if (r2.equals("int") == false) goto L40;
        r4 = 1;
        goto L40
    L37:
        if (r2.equals("action") == false) goto L40;
        r4 = 0;
        goto L40
    L53:
        return r0.build();
    L75:
        return null;
    }

    private static SliceSpec wrap(android.app.slice.SliceSpec r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return new SliceSpec(r2.getType(), r2.getRevision());
    }

    public static Set<SliceSpec> wrap(Set<android.app.slice.SliceSpec> r2) {
        ArraySet r0 = new ArraySet();
        if (r2 == null) goto L8;
        Iterator<android.app.slice.SliceSpec> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.add(wrap(r3.next()));
    L8:
        return r0;
    }

    private SliceConvert() {
    }
}
