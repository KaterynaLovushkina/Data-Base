
use Lovushkina;


SELECT * FROM user;
-- SELECT * FROM card;
-- SELECT * FROM email_preferences;
SELECT * FROM app;
-- SELECT * FROM creater;
-- SELECT * FROM app_creating;
-- SELECT * FROM device_type;
-- SELECT * FROM app_category;
-- SELECT * FROM category;
SELECT * FROM download;
SELECT * FROM download_info;
SELECT * FROM feedback;


SELECT 1 QUERY
SELECT full_name
From user join email_preferences on id = user_id
GROUP BY full_name
HAVING COUNT(email) = 1
ORDER BY 1;

SELECT 2 QUERY
SELECT full_name, name app_name, rate
FROM feedback join user on user_id = user.id 
              join app on app_id = app.id
WHERE rate>3

SELECT 3 QUERY
SELECT name
from app
where is_free = true and id = any(SELECT app_id from device_type where device ='tablet')

SELECT 4 QUERY
select ac.name app_category , app.name app,
case when audience_type like 'child' and rate >= 3 then 'reccomended to user as child'
	 when audience_type like 'teen' and rate >= 3 then 'reccomended to user as teen'
     when audience_type like 'adult' and rate >= 3 then 'reccomended to user as adult'
     when audience_type like 'all' and rate >= 3 then 'reccomended to all users'
     else 'we dont recommend this app'
     end reccomendation
from category  c join app_category ac on c.app_category_id = ac.id
				 join app  on c.id = app.id
                                join feedback  fb on app.id = fb.id 

SELECT 5 QUERY: find app and creaters modt rated app
SELECT app.name ,rate, creater.full_name, work_branch
FROM app_creating ac 
join app on ac.app_id = app.id
join feedback  fb on app.id = fb.app_id 
join creater on ac.creater_id = creater.id
where  rate = (select max(rate) from feedback)

SELECT 6 QUERY: find only privat bank users
SELECT full_name only_privat_user_name
FROM user join card on user.id = card.user_id
where bank_name = 'privat' 
group by full_name
having count(number_hash)=1

SELECT 7 QUERY: find most downloaded app
select name 
from download_info join app on app_id = app.id
group by name
having count(app_id) = (select max(app_count) as max_count
                         from (select name  app, count(app_id ) app_count
                               from download_info join app on app_id = app.id
                               group by app) tab)

SELECT 8 QUERY: find users with email ukr.net
select full_name, email
from user join email_preferences as ep on user.id = ep.user_id
where email regexp 'ukr.net$'



 -- SELECT 9 QUERY : find users who didn't give feedback on downloaded app
select user, app
from(
SELECT user.full_name user, app.name app, feedback.description fb
FROM download right join user on download.user_id = user.id
              left join feedback on user.id= feedback.user_id
              join app on feedback.app_id = app.id
union
select user.full_name user, app.name app, feedback.description
from user join  download on user.id = download.user_id
          join download_info inf on download.id = inf.download_id
          right join app on inf.app_id = app.id
          left join feedback on app.id= feedback.app_id) tab
where fb is null

SELECT 10 QUERY 
select 'The most active user:', user.full_name user,count(app.name) app_count 
from user join  download on user.id = download.user_id
          join download_info inf on download.id = inf.download_id
          right join app on inf.app_id = app.id
group by user
order by app_count desc
limit 3