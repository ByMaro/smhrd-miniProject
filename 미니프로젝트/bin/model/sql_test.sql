create table userinfo
(id varchar2(20) not null,
pw varchar2(20) not null,
nickname varchar2(20) not null,
score number(4) not null,
constraint userinfo_id_pk primary key(id),
constraint userinfo_nickname_uk unique(nickname)
)

create table musicinfo
(music_id number(3),
music_name varchar2(65) not null,
singer varchar2(65) not null,
music_h varchar2(100) not null,
music_a varchar2(100),
constraint musicinfo_musicid_pk primary key(music_id)
)

create view Music_Ranking_list as
                        (select rank() over(order by score desc) as rank, nickname, score 
                        from userinfo);
                        
select score from userinfo where id = '한규창' and nickname = '한규창';