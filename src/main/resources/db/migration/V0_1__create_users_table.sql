-- users table is plural to avoid conflict with user keyword
CREATE TABLE users (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    provider_id VARCHAR(64) UNIQUE NOT NULL,
    sync_key TEXT,
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);