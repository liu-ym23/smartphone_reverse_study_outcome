package com.obric.oui.dialog.misc;

import androidx.annotation.RequiresApi;
import com.bytedance.securityserver.R;
import com.obric.oui.dialog.base.BaseDialog;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public class OSimpleFormDialog extends BaseDialog {

    @Metadata
    public static final class Companion {
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.misc.OSimpleFormDialog$onStart$1, reason: invalid class name */
    @Metadata
    final class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.dialog.misc.OSimpleFormDialog$onStart$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;     // Catch: Exception -> L4
        L4:
            e = move-exception;
            L.c("OSimpleFormDialog", "onStart, requestFocus failed", e);
        }
    }

    @Override // com.obric.oui.dialog.base.AbstractDialog
    public final int b() {
        return R.layout.o_simple_form_dialog;
    }

    @Override // com.obric.oui.dialog.base.BaseDialog, android.app.Dialog
    public final void onStart() {
        super.onStart();
        throw null;
    }
}
