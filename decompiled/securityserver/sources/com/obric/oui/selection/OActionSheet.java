package com.obric.oui.selection;

import android.util.Log;
import androidx.annotation.RequiresApi;
import com.obric.oui.sheet.OInsetSheet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class OActionSheet extends OInsetSheet {

    @Metadata
    public static final class Companion {

        @Metadata
        public static final enum ItemStyle extends Enum<ItemStyle> {
            public static final /* synthetic */ ItemStyle[] b = null;

            static {
                b = new ItemStyle[]{new ItemStyle("LIST_BUTTON", 0), new ItemStyle("LIST_TEXT_ONLY", 1), new ItemStyle("LIST_ICON_AND_TEXT", 2)};
            }

            public static ItemStyle valueOf(String r1) {
                return (ItemStyle) Enum.valueOf(ItemStyle.class, r1);
            }

            public static ItemStyle[] values() {
                return (ItemStyle[]) b.clone();
            }
        }

        @Metadata
        public static final class Modifier {
        }
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OSelectionSheet", "dismiss failed", e);
    }

    @Override // com.obric.oui.sheet.OInsetSheet, android.app.Dialog
    public final void show() {
        super.show();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.e("OSelectionSheet", "show failed", e);
    }
}
