package ye;

import com.bytedance.ies.xelement.viewpager.LynxFoldView;
import com.bytedance.ies.xelement.viewpager.childitem.LynxFoldToolbar;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.lynx.tasm.behavior.a {
    public final /* synthetic */ int e;

    public /* synthetic */ b(String r5, boolean r10, boolean r11, boolean r12, int r13) {
        this.e = r13;
        super(r5, r10, r11, r12);
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI e(b0 r5, z r10) {
        switch(this.e) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            default: goto L5;
        };
    L5:
        return new LynxFoldToolbar(r5, r10);
    L7:
        return new LynxFoldToolbar(r5, r10);
    L9:
        return new LynxFoldView(r5, r10);
    L11:
        return new LynxFoldView(r5, r10);
    }
}
