insert into users (user_name, password,first_name, last_name, email, bio, is_admin, is_verified)
values ('bross', 'password', 'Bob', 'Ross', 'b.ross@happytree.com', 'I like frinds', 1, 1);
insert into users (user_name, password,first_name, last_name, email, bio, is_admin, is_verified)
values ('sking', 'password', 'Steven', 'King', 'Imma@scarydude.com', 'Many things.', 0, 0);
insert into users (user_name, password,first_name, last_name, email, bio, is_admin, is_verified)
values ('gbush', 'password', 'George', 'Bush', 'some@washington.com', 'I used to be president.', 0, 1);
insert into users (user_name, password,first_name, last_name, email, bio, is_admin, is_verified)
values ('dba', 'password', 'Database', 'Admin', 'data@base.com', 'I like chips.', 1, 1);

insert into reviews (user_id, movie_id, review, rating)
values (1, 399360, 'good movie.', 5);
insert into reviews (user_id, movie_id, review, rating)
values (1, 446894, 'great movie.', 3);
insert into reviews (user_id, movie_id, review, rating)
values (2, 399360, 'I liked this movie.', 5);
insert into reviews (user_id, movie_id, review, rating)
values (3, 335983, 'Some review.', 2);
insert into reviews (user_id, movie_id, review, rating)
values (3, 363088, 'I ate peanuts and popcorn.', 4);
insert into reviews (user_id, movie_id, review, rating)
values (3, 399360, 'Some enchanted evening.', 4);

insert into favorites (user_id, movie_id)
values (1, 399360);
insert into favorites (user_id, movie_id)
values (1, 335983);
insert into favorites (user_id, movie_id)
values (1, 446894);

insert into approvals (review_id, thumbs_up, source_id)
values (2, 1, 2);
insert into approvals (review_id, thumbs_up, source_id)
values (2, 0, 3);
