create table verifications (
    id uuid primary key,
    profile_id uuid not null,
    file_id uuid not null,
    created_at timestamp not null default now(),
    approved boolean null,
    reviewed_at timestamp null
);
create index verifications_approved on verifications(approved, created_at);
create index verifications_profile_id on verifications(profile_id);