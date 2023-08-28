create table profiles (
    id uuid primary key,
    name text not null,
    birthday date not null,
    gender text not null,
    hidden boolean not null default false,
    created_at timestamp not null default now(),
    deleted_at timestamp null
);
create index profiles_search_idx on profiles(deleted_at, hidden, gender, birthday);