package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.OnReceiveContentListener;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TextViewOnReceiveContentListener implements OnReceiveContentListener {
    private static final String LOG_TAG = "ReceiveContent";

    @RequiresApi(16)
    private static final class Api16Impl {
        private Api16Impl() {
        }

        static CharSequence coerce(@NonNull Context r0, @NonNull ClipData.Item r1, int r2) {
            if ((r2 & 1) == 0) goto L9;
            CharSequence r3 = r1.coerceToText(r0);
            if ((r3 instanceof Spanned) == true) goto L7;
            return r3;
        L7:
            return r3.toString();
        L9:
            return r1.coerceToStyledText(r0);
        }
    }

    private static final class ApiImpl {
        private ApiImpl() {
        }

        static CharSequence coerce(@NonNull Context r0, @NonNull ClipData.Item r1, int r2) {
            CharSequence r3 = r1.coerceToText(r0);
            if ((r2 & 1) != 0) goto L5;
            return r3;
        L5:
            if ((r3 instanceof Spanned) == true) goto L7;
            return r3;
        L7:
            return r3.toString();
        }
    }

    public TextViewOnReceiveContentListener() {
    }

    private static CharSequence coerceToText(@NonNull Context r2, @NonNull ClipData.Item r3, int r4) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return Api16Impl.coerce(r2, r3, r4);
    L7:
        return ApiImpl.coerce(r2, r3, r4);
    }

    private static void replaceSelection(@NonNull Editable r4, @NonNull CharSequence r5) {
        int r0 = Selection.getSelectionStart(r4);
        int r1 = Selection.getSelectionEnd(r4);
        int r2 = Math.max(0, Math.min(r0, r1));
        int r3 = Math.max(0, Math.max(r0, r1));
        Selection.setSelection(r4, r3);
        r4.replace(r2, r3, r5);
    }

    @Override // androidx.core.view.OnReceiveContentListener
    @Nullable
    public ContentInfoCompat onReceiveContent(@NonNull View r7, @NonNull ContentInfoCompat r8) {
        if (Log.isLoggable(LOG_TAG, 3) == false) goto L6;
        Log.d(LOG_TAG, "onReceive: " + r8);
    L6:
        if (r8.getSource() != 2) goto L8;
        return r8;
    L8:
        ClipData r6 = r8.getClip();
        int r9 = r8.getFlags();
        TextView r10 = (TextView) r7;
        Editable r0 = (Editable) r10.getText();
        Context r11 = r10.getContext();
        int r1 = 0;
        boolean r2 = false;
    L10:
        if (r1 >= r6.getItemCount()) goto L17;
        CharSequence r3 = coerceToText(r11, r6.getItemAt(r1), r9);
        if (r3 == null) goto L16;
        if (r2 == true) goto L15;
        replaceSelection(r0, r3);
        r2 = true;
        goto L16
    L15:
        r0.insert(Selection.getSelectionEnd(r0), "\n");
        r0.insert(Selection.getSelectionEnd(r0), r3);
    L16:
        r1 = r1 + 1;
        goto L10
    L17:
        return null;
    }
}
