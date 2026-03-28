# Quick Start Guide

## 빠른 실행 방법

### 1단계: Docker 실행
```bash
docker-compose up -d
```

### 2단계: Backend 실행 (IntelliJ IDEA)
1. IntelliJ에서 `backend` 폴더 열기
2. Gradle 자동 import 완료까지 대기
3. `DevQuizApplication.kt` 파일 열기
4. main 함수 옆 녹색 실행 버튼 클릭
5. http://localhost:8080/api/health 접속하여 확인

### 3단계: Frontend 실행
```bash
cd frontend
npm install
npm run dev
```

### 4단계: 브라우저 접속
http://localhost:3000

## 문제 해결

### Docker가 실행되지 않는 경우
- Docker Desktop을 실행했는지 확인
- `docker ps` 명령어로 Docker 데몬 실행 확인

### Backend가 실행되지 않는 경우
- PostgreSQL이 실행 중인지 확인: `docker-compose ps`
- application.yml의 DB 설정 확인
- IntelliJ에서 Gradle Refresh

### Frontend가 실행되지 않는 경우
- Node.js 버전 확인: `node --version` (v18 이상 권장)
- `npm install` 재실행

## 주요 URL
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api
- Health Check: http://localhost:8080/api/health
- PostgreSQL: localhost:5432 (devquiz/devquiz123)
- Redis: localhost:6379
