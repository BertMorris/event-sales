CREATE TABLE email_recipient (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    email_id BIGINT NOT NULL REFERENCES email(id),
    contact_id BIGINT NOT NULL REFERENCES contact(id),
    type VARCHAR(20) NOT NULL CHECK (type IN ('TO', 'CC', 'BCC', 'REPLY_TO')),
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);