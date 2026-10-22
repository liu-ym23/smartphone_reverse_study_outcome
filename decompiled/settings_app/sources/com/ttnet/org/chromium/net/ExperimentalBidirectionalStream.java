package com.ttnet.org.chromium.net;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ExperimentalBidirectionalStream extends BidirectionalStream {

    public static abstract class Builder extends BidirectionalStream.Builder {
        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder addHeader(String r1, String r2);

        public Builder addRequestAnnotation(Object r1) {
            return this;
        }

        public Builder bindToNetwork(long r1) {
            return this;
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract ExperimentalBidirectionalStream build();

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder delayRequestHeadersUntilFirstFlush(boolean r1);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setHttpMethod(String r1);

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public abstract Builder setPriority(int r1);

        public Builder setTrafficStatsTag(int r1) {
            return this;
        }

        public Builder setTrafficStatsUid(int r1) {
            return this;
        }

        public Builder() {
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder addHeader(String r1, String r2) {
            return addHeader(r1, r2);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream build() {
            return build();
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder delayRequestHeadersUntilFirstFlush(boolean r1) {
            return delayRequestHeadersUntilFirstFlush(r1);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setHttpMethod(String r1) {
            return setHttpMethod(r1);
        }

        @Override // com.ttnet.org.chromium.net.BidirectionalStream.Builder
        public /* bridge */ /* synthetic */ BidirectionalStream.Builder setPriority(int r1) {
            return setPriority(r1);
        }
    }

    public ExperimentalBidirectionalStream() {
    }
}
