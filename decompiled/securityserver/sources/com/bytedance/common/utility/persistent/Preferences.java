package com.bytedance.common.utility.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class Preferences implements SharedPreferences {
    public static final String PREFERENCE_PREFIX = "pref_id_";
    private SharedPreferences mPreference;

    public static class CustomEditor implements SharedPreferences.Editor {
        private SharedPreferences.Editor mEditor;

        public CustomEditor(SharedPreferences.Editor r1) {
            this.mEditor = r1;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mEditor.apply();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mEditor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.mEditor.putBoolean(r2, r3);
            return this;
        }

        @Deprecated
        public SharedPreferences.Editor putBundle(String r2, Bundle r3) {
            this.mEditor.putString(r2, Preferences.access$000(r3));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.mEditor.putFloat(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.mEditor.putInt(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.mEditor.putLong(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, String r3) {
            this.mEditor.putString(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r2, Set<String> r3) {
            this.mEditor.putStringSet(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r2) {
            this.mEditor.remove(r2);
            return this;
        }
    }

    public Preferences(SharedPreferences r1) {
        this.mPreference = r1;
    }

    public static /* synthetic */ String access$000(Bundle r0) {
        return bundleToString(r0);
    }

    @Deprecated
    private static String bundleToString(Bundle r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        Parcel r1 = Parcel.obtain();
        r3.writeToParcel(r1, 0);     // Catch: Throwable -> L9
        String r4 = Base64.encodeToString(r1.marshall(), 0);     // Catch: Throwable -> L9
        r1.recycle();
        return r4;
    L9:
        r1.recycle();
        return null;
    }

    public static Preferences getById(Context r2, String r3) {
        return new Preferences(r2.getSharedPreferences(PREFERENCE_PREFIX + r3, 0));
    }

    @Deprecated
    private static Bundle stringToBundle(String r3) {
        byte[] r4 = Base64.decode(r3, 0);
        Parcel r1 = Parcel.obtain();
        r1.unmarshall(r4, 0, r4.length);     // Catch: Throwable -> L6
        r1.setDataPosition(0);     // Catch: Throwable -> L6
        Bundle r5 = (Bundle) Bundle.CREATOR.createFromParcel(r1);     // Catch: Throwable -> L6
        r1.recycle();
        return r5;
    L6:
        th = move-exception;
        r1.recycle();
        throw th;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r1) {
        return this.mPreference.contains(r1);
    }

    @Override // android.content.SharedPreferences
    public /* bridge */ /* synthetic */ SharedPreferences.Editor edit() {
        return edit();
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mPreference.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r1, boolean r2) {
        return this.mPreference.getBoolean(r1, r2);
    }

    public Bundle getBundle(String r2, Bundle r3) {
        String r1 = this.mPreference.getString(r2, null);
        if (r1 != null) goto L6;
        return r3;
    L6:
        return stringToBundle(r1);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r1, float r2) {
        return this.mPreference.getFloat(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r1, int r2) {
        return this.mPreference.getInt(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r1, long r2) {
        return this.mPreference.getLong(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public String getString(String r1, String r2) {
        return this.mPreference.getString(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String r1, Set<String> r2) {
        return this.mPreference.getStringSet(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
        this.mPreference.registerOnSharedPreferenceChangeListener(r1);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r1) {
        this.mPreference.unregisterOnSharedPreferenceChangeListener(r1);
    }

    @Override // android.content.SharedPreferences
    public CustomEditor edit() {
        return new CustomEditor(this.mPreference.edit());
    }
}
