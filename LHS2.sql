create view NOTICE_VIEW
AS
select N.ID, N.TITLE, N.WRITER_ID, N.REGDATE, N.HIT, N.FILES,
  COUNT(C.ID) CMT_COUNT
  FROM notice N
    LEFT JOIN "COMMENT" C ON N.ID = C.NOTICE_ID
      GROUP BY N.ID, N.TITLE, N.WRITER_ID, N.REGDATE, N.HIT, N.FILES;
--order by N.regdate desc;
commit;

SELECT * FROM ( 
				        SELECT ROWNUM NUM, N.* FROM(
				              SELECT * FROM NOTICE_VIEW
				                WHERE TITLE LIKE '%%' 
				                  ORDER BY REGDATE DESC) N
				            )
				            WHERE NUM BETWEEN 1 AND 10;
