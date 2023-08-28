create table profile_photo (
    profile_id uuid,
    file_id uuid,
    primary key (profile_id, file_id)
);