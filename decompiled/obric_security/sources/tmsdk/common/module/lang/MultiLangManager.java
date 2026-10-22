package tmsdk.common.module.lang;

import android.content.Context;
import tmsdk.common.creator.BaseManagerC;

/* JADX INFO: loaded from: classes5.dex */
public class MultiLangManager extends BaseManagerC {
    private a b;

    public MultiLangManager() {
    }

    public void addListener(ILangChangeListener r1) {
        this.b.addListener(r1);
    }

    public int getCurrentLang() {
        return this.b.getCurrentLang();
    }

    public boolean isCHS() {
        if (getCurrentLang() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isENG() {
        if (getCurrentLang() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        a r0 = new a();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }

    public void onCurrentLangNotify(int r1) {
        this.b.b(r1);
    }

    public void removeListener(ILangChangeListener r1) {
        this.b.removeListener(r1);
    }
}
