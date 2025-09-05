CREATE TABLE email (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    provider_id VARCHAR(64) UNIQUE NOT NULL,
    subject VARCHAR(255),
    body TEXT,
    conversation_id VARCHAR(64),
    has_attachments BOOLEAN NOT NULL,
    read_at TIMESTAMPTZ,
    received_at TIMESTAMPTZ,
    sent_at TIMESTAMPTZ,
    sender_id BIGINT NOT NULL REFERENCES contact(id),
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);