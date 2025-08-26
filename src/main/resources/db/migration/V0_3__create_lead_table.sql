CREATE TABLE lead (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    status VARCHAR(50) NOT NULL CHECK (status IN ('NEW', 'QUALIFIED', 'PROPOSED', 'CONTRACTED', 'LOST')),
    company VARCHAR(150),
    title VARCHAR(50),
    description TEXT,
    budget INTEGER,
    owner_id BIGINT NOT NULL REFERENCES users(id),
    contact_id BIGINT NOT NULL REFERENCES contact(id),
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);