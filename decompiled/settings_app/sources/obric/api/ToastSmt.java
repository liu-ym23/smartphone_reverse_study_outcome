package obric.api;

import android.content.Context;
import android.util.Singleton;
import android.widget.Toast;

/* JADX INFO: loaded from: classes5.dex */
public class ToastSmt {
    static final String TAG = "ToastSmt";
    static final Singleton<ToastSmt> sToastSmt = null;
    private ToastSmtImpl impl;

    class ToastSmtImpl {
        final /* synthetic */ ToastSmt this$0;

        ToastSmtImpl(ToastSmt r1) {
            this.this$0 = r1;
        }
    }

    public Toast makeText(Context r1, CharSequence r2, int r3, int r4) {
        return null;
    }

    /* synthetic */ ToastSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sToastSmt = new AnonymousClass1();
    }

    public static ToastSmt getInstance() {
        return (ToastSmt) sToastSmt.get();
    }

    private ToastSmt() {
        this.impl = new ToastSmtImpl(this);
    }
}
