package cz.msebera.android.httpclient.config;

import cz.msebera.android.httpclient.util.Args;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class RegistryBuilder<I> {
    private final Map<String, I> items;

    public static <I> RegistryBuilder<I> create() {
        return new RegistryBuilder();
    }

    RegistryBuilder() {
        this.items = new HashMap();
    }

    public RegistryBuilder<I> register(String r3, I r4) {
        Args.notEmpty(r3, "ID");
        Args.notNull(r4, "Item");
        this.items.put(r3.toLowerCase(Locale.ROOT), r4);
        return this;
    }

    public Registry<I> build() {
        return new Registry(this.items);
    }

    public String toString() {
        return this.items.toString();
    }
}
