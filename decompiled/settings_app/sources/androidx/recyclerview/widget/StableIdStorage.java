package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;

/* JADX INFO: loaded from: classes.dex */
interface StableIdStorage {

    public static class IsolatedStableIdStorage implements StableIdStorage {
        long mNextStableId;

        class WrapperStableIdLookup implements StableIdLookup {
            private final LongSparseArray<Long> mLocalToGlobalLookup;
            final /* synthetic */ IsolatedStableIdStorage this$0;

            WrapperStableIdLookup(IsolatedStableIdStorage r1) {
                this.this$0 = r1;
                this.mLocalToGlobalLookup = new LongSparseArray();
            }

            @Override // androidx.recyclerview.widget.StableIdStorage.StableIdLookup
            public long localToGlobal(long r3) {
                Long r0 = this.mLocalToGlobalLookup.get(r3);
                if (r0 != null) goto L6;
                r0 = Long.valueOf(this.this$0.obtainId());
                this.mLocalToGlobalLookup.put(r3, r0);
            L6:
                return r0.longValue();
            }
        }

        public IsolatedStableIdStorage() {
            this.mNextStableId = 0;
        }

        long obtainId() {
            long r0 = this.mNextStableId;
            this.mNextStableId = 1 + r0;
            return r0;
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return new WrapperStableIdLookup(this);
        }
    }

    public static class NoStableIdStorage implements StableIdStorage {
        private final StableIdLookup mNoIdLookup;

        public NoStableIdStorage() {
            this.mNoIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mNoIdLookup;
        }
    }

    public static class SharedPoolStableIdStorage implements StableIdStorage {
        private final StableIdLookup mSameIdLookup;

        public SharedPoolStableIdStorage() {
            this.mSameIdLookup = new AnonymousClass1(this);
        }

        @Override // androidx.recyclerview.widget.StableIdStorage
        public StableIdLookup createStableIdLookup() {
            return this.mSameIdLookup;
        }
    }

    public interface StableIdLookup {
        long localToGlobal(long r1);
    }

    StableIdLookup createStableIdLookup();
}
