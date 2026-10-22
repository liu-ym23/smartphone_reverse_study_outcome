package com.bytedance.common.utility.persistent;

import android.annotation.TargetApi;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
public class SharedPrefsEditorCompat {
    static final EditorImpl IMPL = null;

    public static class BaseEditorImpl implements EditorImpl {
        public BaseEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        public void apply(SharedPreferences.Editor r1) {
            r1.commit();
        }
    }

    public interface EditorImpl {
        void apply(SharedPreferences.Editor r1);
    }

    public static class GingerbreadEditorImpl implements EditorImpl {
        public GingerbreadEditorImpl() {
        }

        @Override // com.bytedance.common.utility.persistent.SharedPrefsEditorCompat.EditorImpl
        @TargetApi(9)
        public void apply(SharedPreferences.Editor r1) {
            r1.apply();
        }
    }

    static {
        IMPL = new GingerbreadEditorImpl();
    }

    public SharedPrefsEditorCompat() {
    }

    public static void apply(SharedPreferences.Editor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        IMPL.apply(r1);
    }
}
