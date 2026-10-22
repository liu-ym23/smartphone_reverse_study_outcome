package d.b.m.c;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class a implements SharedPreferences {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile boolean f14139c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Keva.OnChangeListener> f14140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Keva f14141b;

    /* JADX INFO: renamed from: d.b.m.c.a$a, reason: collision with other inner class name */
    class C0378a implements Keva.OnChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener f14142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14143b;

        C0378a(a r1, SharedPreferences.OnSharedPreferenceChangeListener r2) {
            this.f14143b = r1;
            this.f14142a = r2;
        }

        @Override // com.bytedance.keva.Keva.OnChangeListener
        public void onChanged(Keva r1, String r2) {
            this.f14142a.onSharedPreferenceChanged(this.f14143b, r2);
        }
    }

    static class b implements SharedPreferences.Editor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Keva f14144a;

        b(Keva r1) {
            this.f14144a = r1;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f14144a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return true;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String r2, boolean r3) {
            this.f14144a.storeBoolean(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String r2, float r3) {
            this.f14144a.storeFloat(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String r2, int r3) {
            this.f14144a.storeInt(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String r2, long r3) {
            this.f14144a.storeLong(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String r2, @Nullable String r3) {
            this.f14144a.storeString(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String r2, @Nullable Set<String> r3) {
            this.f14144a.storeStringSet(r2, r3);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String r2) {
            this.f14144a.erase(r2);
            return this;
        }
    }

    static {
    }

    public a(Context r2, String r3, int r4) {
        this.f14140a = new WeakHashMap();
        a(r2);
        if (r4 != 4) goto L5;
        int r5 = 1;
    L6:
        this.f14141b = Keva.getRepo(r3, r5);
        return;
    L5:
        r5 = 0;
        goto L6
    }

    private static void a(Context r3) {
        if (f14139c == false) goto L5;
        return;
    L5:
        monitor-enter(a.class);
        f14139c = true;     // Catch: Throwable -> L13
        KevaBuilder r1 = KevaBuilder.getInstance();     // Catch: Throwable -> L13
        if ((r3 instanceof Application) == false) goto L10;
    L9:
        r1.setContext(r3);     // Catch: Throwable -> L13
        monitor-exit(a.class);     // Catch: Throwable -> L13
        return;
    L10:
        r3 = r3.getApplicationContext();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String r1) {
        return this.f14141b.contains(r1);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return new b(this.f14141b);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.f14141b.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String r1, boolean r2) {
        return this.f14141b.getBoolean(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String r1, float r2) {
        return this.f14141b.getFloat(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String r1, int r2) {
        return this.f14141b.getInt(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String r1, long r2) {
        return this.f14141b.getLong(r1, r2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public String getString(String r1, @Nullable String r2) {
        String r0 = this.f14141b.getString(r1, r2);
        if (r0 != null) goto L6;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return r0;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public Set<String> getStringSet(String r1, @Nullable Set<String> r2) {
        return this.f14141b.getStringSet(r1, r2);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r3) {
        monitor-enter(this);
        C0378a r0 = new C0378a(this, r3);     // Catch: Throwable -> L6
        this.f14141b.registerChangeListener(r0);     // Catch: Throwable -> L6
        this.f14140a.put(r3, r0);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener r2) {
        monitor-enter(this);
        Keva.OnChangeListener r3 = this.f14140a.remove(r2);     // Catch: Throwable -> L6
        this.f14141b.unRegisterChangeListener(r3);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
