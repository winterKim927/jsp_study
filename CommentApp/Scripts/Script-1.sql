CREATE TABLE news(
	news_idx NUMBER PRIMARY KEY
	, title varchar2(30) NOT NULL
	, writer varchar2(20) NOT NULL
	, content clob
	, regdate DATE DEFAULT sysdate
	, hit NUMBER DEFAULT 0
)

CREATE SEQUENCE seq_news
INCREMENT BY 1
START WITH 1

CREATE TABLE comments(
	comments_idx NUMBER PRIMARY KEY
	,news_idx number
	,msg clob NOT null
	,author varchar2(20) NOT null
	,writedate DATE DEFAULT sysdate
	,CONSTRAINT fk_news_comments FOREIGN KEY(news_idx) REFERENCES news(news_idx)
)

CREATE SEQUENCE seq_comments
INCREMENT BY 1
START WITH 1