# Board — MyBatis標準型（표준형） (Spring Boot + JSP + Oracle 11g)

既存の **純粋なJDBC（no bean）掲示板（게시판）** を **MyBatis標準型（표준형）** に変更したバージョンです。

```text
JSP → Controller → Service → Mapperインターフェース → Mapper XML（SQL）→ [yml + HikariCP 自動接続] → Oracle DB
                                    ↕ DTO（データボックス）
```

DBアクセス情報：`src/main/resources/application.yml` の `spring.datasource`

```bash
# 1) 環境変数の設定（환경변수 설정）
# Windowsは set、PowerShellは $env:DB_PASSWORD="..." を使用

export DB_URL=jdbc:oracle:thin:@localhost:1521:orcl
export DB_USERNAME=scott
export DB_PASSWORD=パスワード（비밀번호）

# 2) 実行（실행）
# Java 17以上
mvn spring-boot:run

# 3) アクセス（접속）
http://localhost:8080/biz/login
```
```
