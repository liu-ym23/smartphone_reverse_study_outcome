package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {
        private static EditorCompat sInstance;
        private final Helper mHelper;

        public static class Helper {
            public Helper() {
            }

            public void apply(@NonNull SharedPreferences.Editor r1) {
                r1.apply();     // Catch: AbstractMethodError -> L4
                return;
            L4:
                r1.commit();
            }
        }

        private EditorCompat() {
            this.mHelper = new Helper();
        }

        @Deprecated
        public static EditorCompat getInstance() {
            if (sInstance != null) goto L6;
            sInstance = new EditorCompat();
        L6:
            return sInstance;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor r1) {
            this.mHelper.apply(r1);
        }
    }

    private SharedPreferencesCompat() {
    }
}
