# Board — MyBatis 표준형 (Spring Boot + JSP + Oracle 11g)

기존 **순수 JDBC(no bean)** 게시판을 **MyBatis 표준형**으로 바꾼 버전입니다.

```
JSP → Controller → Service → Mapper 인터페이스 → Mapper XML(SQL) → [yml + HikariCP 자동 연결] → Oracle DB
                                    ↕ DTO (데이터 상자)
```

DB 접속 정보는 `src/main/resources/application.yml`의 `spring.datasource`에서 환경변수(`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`)로 읽습니다. `DB_URL`·`DB_USERNAME`은 설정하지 않으면 기본값(orcl, scott)을 쓰고, `DB_PASSWORD`는 꼭 설정해야 합니다.

```bash
# 1) 환경변수 설정 (Windows는 set, PowerShell은 $env:DB_PASSWORD="...")
export DB_URL=jdbc:oracle:thin:@localhost:1521:orcl
export DB_USERNAME=scott
export DB_PASSWORD=비밀번호

# 2) 실행 (Java 17 이상)
mvn spring-boot:run

# 3) 접속
http://localhost:8080/biz/login
```
