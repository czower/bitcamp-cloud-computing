openjdk download

(GA용도) General-Availability

Windows?/?x64	tar.gz (sha256)	198909999

--------------------------------------------

Electron + JavaScript + Chomeum
Atom / Visual Studio Code

visual studio code download

--------------------------------------------

https://scoop.sh/

ant -> maven -> gradle(groovy:.class) JVM 필요

gradle download

Scoop (Package manager)  설치

Windows PowerShell

실행   :  iex (new-object net.webclient).downloadstring('https://get.scoop.sh')

오류시 :  Set-ExecutionPolicy RemoteSigned -scope CurrentUser

scoop help

scoop install gradle

gradle --version

-------------------------------------------

c:// apps 폴더 

openjdk 압축해제

-----------------------

git client

Git - Downloads

git --version

https://github.com/

https://github.com/eomjinyoung/java106

mkdir git : git 폴더생성

cd git : 경로변경

pwd : 경로보기

git clone https://github.com/eomjinyoung/java106.git

------------------------------------

scoop install mariadb@10.3.7

mysqld -- install "mariadb"

서비스 -> mariadb 서비스 실행

---------------------------------------

서버접속
mysql -uroot -p
Enter password: 암호가 없기 때문에 그냥 친다

root사용자의 암호설정
update user set authentication_string=password('1111') where user='root';

암호 변경 후 권한 갱신
flush privilieges;
quit;

애플리케이션에서 DB에 접속할 때 사용할 사용자를 추가한다.
create user 'study'@'localhost' identified by '1111';

사용자가 사용할  데이터베이스 생성한다.
create database studydb character set utf8 collate utf8_general_ci;

studydb 데이터베이스의 사용권한을 study에게 부여한다.
grant all privileges on studydb.* to 'study'@'localhost';

study 사용자로 접속한다.

study 사용자가 사용할 수 있는 데이터베이스 목록 보기.

사용할 데이터 베이스 선택

studydb에 테이블 생성
=> bitcamp-sql/pms-ddl.sql 실행
sql을 복사하여 붙여 넣는다.

## Tomcat 설치
1) 톰캣 다운로드
- tomcat.apache.org 에서 다운로드

2) 톰캣 설치
- 


## eclipse 설정

'''
워크스페이스 설정
1) 문자집합을 utf-8로 설정한다.
- Preferences/General/Workspace/Text file encoding
  - UTF-8 로 설정한다.
2) 에디터 기본 환경 설정
- Preferences/General/Editors/Text Editors
 - 탭 크기를 2 또는 4로 설정
 - 탭을 스페이스로 표현
 - 한 줄 크기는 80자 정도
 - 탭이나 공백에 대해 흐릿하게 표시
3) 자바 설정
- Prefefences/Java/
   - Installed JRE : JDK 위치 지정하기
   - Code Style/Formatter : 자바 에디터 탭 정보 설정
   - Compiler : 기본 컴파일 버전 설정
4) 웹 환경 설정
- Preferences/Web/
 - CSS Files : 문자 집합을 UTF-8로 설정
 - HTML Files : 문자 집합을 UTF-8로 설정
 - JSP Files : 문자 집합을 UTF-8로 설정
'''

## 웹 프로젝트 폴더 준비

'''
예제 프로젝트 복사
java106-java-project 를 bitcamp-cloud-computing 폴더로 복사한다.

'''








