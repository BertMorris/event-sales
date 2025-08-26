CREATE TABLE function (
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    start_time TIMESTAMPTZ,
    end_time TIMESTAMPTZ,
    guests INTEGER,
    event_id BIGINT NOT NULL REFERENCES event(id),
    type_id BIGINT NOT NULL REFERENCES function_type(id),
    venue_id BIGINT REFERENCES venue(id),
    setup_id BIGINT REFERENCES function_setup(id),
    owner_id BIGINT NOT NULL REFERENCES users(id),
    created_at TIMESTAMPTZ DEFAULT now() NOT NULL,
    updated_at TIMESTAMPTZ DEFAULT now() NOT NULL
);