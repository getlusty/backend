create table matches (
    id uuid primary key,
    author_id uuid not null,
    target_id uuid not null,
    liked boolean not null,
    created_at timestamp not null default now()
);

create index idx_matched_target_id on matches(target_id, liked);
create index idx_matched_author_id on matches(author_id, liked);