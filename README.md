# Community project
### 프로젝트 소개
커뮤니티 프로젝트

### 개발 환경
- Java 11
- Framework: Springboot(2.7.7)
- IDE: IntelliJ
- Database: MySQL
- ORM: JPA

### 주요 기능
- 회원가입
  - 회원가입 시 이메일, 이름, 전화번호, 비밀번호 정보가 필요하다.
  - 이미 회원가입된 이메일로 회원가입을 시도하면 에러가 발생한다.
  
- 로그인
  - 회원가입한 적 없는 이메일을 이용하여 로그인을 시도하면 에러가 발생한다.
  - 로그인 시 비밀번호가 일치하지 않으면 에러가 발생한다.

- 게시물 검색 및 조회
  - 로그인을 하지 않아도 게시판 조회가 가능하다.
  - 게시물 상세보기는 로그인한 유저만 가능하다.
  
- 게시물 관리
  - 로그인한 회원만 게시물을 작성할 수 있다.
  - 로그인한 회원만 게시물을 수정 및 삭제할 수 있다.
