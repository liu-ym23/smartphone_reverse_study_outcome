package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.ContextThemeWrapper;

/* JADX INFO: loaded from: classes.dex */
public interface ThemedSpinnerAdapter extends SpinnerAdapter {

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public Helper(@NonNull Context r1) {
            this.mContext = r1;
            this.mInflater = LayoutInflater.from(r1);
        }

        @NonNull
        public LayoutInflater getDropDownViewInflater() {
            LayoutInflater r0 = this.mDropDownInflater;
            if (r0 == null) goto L6;
            return r0;
        L6:
            return this.mInflater;
        }

        @Nullable
        public Resources.Theme getDropDownViewTheme() {
            LayoutInflater r0 = this.mDropDownInflater;
            if (r0 != null) goto L6;
            return null;
        L6:
            return r0.getContext().getTheme();
        }

        public void setDropDownViewTheme(@Nullable Resources.Theme r3) {
            if (r3 != null) goto L6;
            LayoutInflater r4 = null;
        L4:
            this.mDropDownInflater = r4;
            return;
        L6:
            if (r3.equals(this.mContext.getTheme()) == false) goto L8;
            r4 = this.mInflater;
            goto L4
        L8:
            r4 = LayoutInflater.from(new ContextThemeWrapper(this.mContext, r3));
            goto L4
        }
    }

    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme r1);
}
