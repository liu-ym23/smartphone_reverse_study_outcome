package com.obric.oui.selection;

import android.util.Log;
import androidx.annotation.RequiresApi;
import com.obric.oui.sheet.OInsetSheet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@Metadata
public final class OSelectionSheet extends OInsetSheet {

    @Metadata
    public static final class Companion {

        @Metadata
        public static final enum ItemStyle extends Enum<ItemStyle> {
            public static final /* synthetic */ ItemStyle[] b = null;

            static {
                b = new ItemStyle[]{new ItemStyle("TEXT_ONLY", 0), new ItemStyle("ICON_AND_TEXT", 1)};
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

        @Metadata
        public static final enum SelectionType extends Enum<SelectionType> {
            public static final /* synthetic */ SelectionType[] b = null;

            static {
                b = new SelectionType[]{new SelectionType("SINGLE", 0), new SelectionType("MULTI", 1), new SelectionType("NONE", 2)};
            }

            public static SelectionType valueOf(String r1) {
                return (SelectionType) Enum.valueOf(SelectionType.class, r1);
            }

            public static SelectionType[] values() {
                return (SelectionType[]) b.clone();
            }
        }

        @Metadata
        public static final enum TitleBarControlType extends Enum<TitleBarControlType> {
            public static final /* synthetic */ TitleBarControlType[] b = null;

            static {
                b = new TitleBarControlType[]{new TitleBarControlType("CLOSE_ONLY", 0), new TitleBarControlType("CLOSE_AND_CONFIRM", 1)};
            }

            public static TitleBarControlType valueOf(String r1) {
                return (TitleBarControlType) Enum.valueOf(TitleBarControlType.class, r1);
            }

            public static TitleBarControlType[] values() {
                return (TitleBarControlType[]) b.clone();
            }
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[Companion.TitleBarControlType.values().length];
            r0[1] = 1;
            r0[0] = 2;
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
