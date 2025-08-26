CREATE TABLE event (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    status VARCHAR(50) NOT NULL CHECK (status IN ('PROSPECT', 'HOLD', 'PROPOSED', 'CONTRACTED', 'CANCELLED', 'COMPLETE')),
    title VARCHAR(150),
    company VARCHAR(150),
    start_date DATE,
    end_date DATE,
    guests INTEGER,
    rooms INTEGER,
    owner_id BIGINT NOT NULL REFERENCES users(id),
    lead_id BIGINT NOT NULL REFERENCES lead(id),
    contact_id BIGINT NOT NULL REFERENCES contact(id),
    type_id BIGINT REFERENCES event_type(id),
    venue_id BIGINT REFERENCES venue(id),
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);