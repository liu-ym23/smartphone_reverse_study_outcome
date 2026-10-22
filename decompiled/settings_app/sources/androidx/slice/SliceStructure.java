package androidx.slice;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import java.util.Iterator;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class SliceStructure {
    private final String mStructure;

    public SliceStructure(Slice r2) {
        StringBuilder r0 = new StringBuilder();
        getStructure(r2, r0);
        this.mStructure = r0.toString();
    }

    public SliceStructure(SliceItem r2) {
        StringBuilder r0 = new StringBuilder();
        getStructure(r2, r0);
        this.mStructure = r0.toString();
    }

    public int hashCode() {
        return this.mStructure.hashCode();
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof SliceStructure) == true) goto L7;
        return false;
    L7:
        return this.mStructure.equals(((SliceStructure) r2).mStructure);
    }

    private static void getStructure(Slice r1, StringBuilder r2) {
        r2.append("s{");
        Iterator<SliceItem> r3 = r1.getItems().iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        getStructure(r3.next(), r2);
        goto L4
    L6:
        r2.append(VectorFormat.DEFAULT_SUFFIX);
    }

    private static void getStructure(SliceItem r5, StringBuilder r6) {
        String r0 = r5.getFormat();
        switch(r0.hashCode()) {
            case -1422950858: goto L27;
            case -1377881982: goto L24;
            case 104431: goto L21;
            case 3327612: goto L18;
            case 3556653: goto L15;
            case 100313435: goto L12;
            case 100358090: goto L9;
            case 109526418: goto L6;
            default: goto L29;
        };
    L29:
        byte r1 = -1;
    L30:
        if (r1 == 0) goto L41;
        if (r1 == 1) goto L37;
        if (r1 == 2) goto L36;
        if (r1 != 3) goto L46;
        r6.append('i');
        return;
    L46:
        return;
    L36:
        r6.append('t');
        return;
    L37:
        r6.append('a');
        if ("range".equals(r5.getSubType()) == false) goto L40;
        r6.append('r');
    L40:
        getStructure(r5.getSlice(), r6);
        return;
    L41:
        getStructure(r5.getSlice(), r6);
        return;
    L6:
        if (r0.equals("slice") == false) goto L29;
        r1 = 0;
        goto L30
    L9:
        if (r0.equals("input") == false) goto L29;
        r1 = 6;
        goto L30
    L12:
        if (r0.equals(SlardarSettingsConsts.SETTING_IMAGE) == false) goto L29;
        r1 = 3;
        goto L30
    L15:
        if (r0.equals("text") == false) goto L29;
        r1 = 2;
        goto L30
    L18:
        if (r0.equals(WsChannelMultiProcessSharedProvider.LONG_TYPE) == false) goto L29;
        r1 = 5;
        goto L30
    L21:
        if (r0.equals("int") == false) goto L29;
        r1 = 4;
        goto L30
    L24:
        if (r0.equals("bundle") == false) goto L29;
        r1 = 7;
        goto L30
    L27:
        if (r0.equals("action") == false) goto L29;
        r1 = 1;
        goto L30
    }
}
