package tmsdk.common.module.lang;

import android.content.Context;
import java.util.HashSet;
import java.util.Iterator;
import tmsdk.common.creator.BaseManagerC;
import tmsdkobf.f;
import tmsdkobf.h9;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
class a extends BaseManagerC {
    private Context b;
    private int c;
    private HashSet d;
    h9 e;

    a() {
        this.d = new HashSet();
    }

    void addListener(ILangChangeListener r3) {
        q8.a("MultiLangManager", "addListener:[" + r3 + "]");
        this.d.add(r3);
    }

    void b(int r4) {
        q8.a("MultiLangManager", "setCurrentLang:[" + this.c + "][" + r4 + "]");
        this.e.a("LANG", r4, false);
        Iterator r3 = this.d.iterator();
    L4:
        if (r3.hasNext() == false) goto L7;
        ((ILangChangeListener) r3.next()).onCurrentLang(r4, r4);
        goto L4
    L7:
        if (r4 != 1) goto L11;
        int r5 = 1320014;
    L9:
        f.f(r5);
        return;
    L11:
        if (r4 != 2) goto L15;
        r5 = 1320015;
        goto L9
    }

    int getCurrentLang() {
        return this.e.a("LANG", 1);
    }

    @Override // tmsdkobf.b0
    public int getSingletonType() {
        return 1;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r3) {
        this.e = new h9("multi_lang_setting");
        this.b = r3;
    }

    void removeListener(ILangChangeListener r3) {
        q8.a("MultiLangManager", "removeListener:[" + r3 + "]");
        this.d.remove(r3);
    }
}
