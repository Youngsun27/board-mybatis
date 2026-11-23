

-- Oracle 11g 테이블 생성 스크립트 (11g 문법: IDENTITY 미사용)
-- Oracle テーブル作成スクリプト（11g 文法：IDENTITY 未使用）


-- 회원 테이블 / 会員テーブル
CREATE TABLE member (
    id       VARCHAR2(8)  PRIMARY KEY,   -- 아이디 / ID
    password VARCHAR2(8)  NOT NULL,      -- 비밀번호 (평문, 실습용) / パスワード（平文、実習用）
    name     VARCHAR2(20) NOT NULL,      -- 이름 / 名前
    role     VARCHAR2(5)                 -- 권한 (Admin / User) / 権限
);

-- 게시판 테이블 / 掲示板テーブル
CREATE TABLE board (
    seq      NUMBER(5)      PRIMARY KEY,       -- 글 번호 / 投稿番号
    title    VARCHAR2(200)  NOT NULL,          -- 제목 / タイトル
    writer   VARCHAR2(20)   NOT NULL,          -- 작성자 / 作成者
    content  VARCHAR2(2000) NOT NULL,          -- 내용 / 内容
    regdate  DATE           DEFAULT SYSDATE,   -- 등록일 (기본값: 지금) / 登録日（デフォルト：現在）
    cnt      NUMBER(5)      DEFAULT 0          -- 조회수 / 閲覧数
);

-- 테스트 데이터 / テストデータ
INSERT INTO member VALUES ('test',  'test123', '관리자', 'Admin');
INSERT INTO member VALUES ('user1', 'user1',   '홍길동', 'User');
INSERT INTO board (seq, title, writer, content) VALUES (1, '가입인사', '관리자', '잘 부탁드립니다...');
COMMIT;
