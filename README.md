# Dev Quiz - 개발 용어 퀴즈 사이트

면접 준비를 위한 개발 용어 퀴즈 플랫폼

## 기술 스택

### Backend
- Kotlin
- Spring Boot 3.x
- Spring WebFlux (비동기)
- Spring Security + JWT
- PostgreSQL
- Redis

### Frontend
- Next.js 15
- TypeScript
- TailwindCSS
- App Router

## 프로젝트 구조

```
dev-quiz/
├── backend/          # Kotlin Spring Boot
├── frontend/         # Next.js
└── README.md
```

## 주요 기능

- 개발 용어 퀴즈 (OX, 4지선다)
- 카테고리별 문제 (자료구조, 네트워크, DB, OS, 디자인패턴 등)
- 사용자 인증 및 진행도 저장
- 오답 노트
- 학습 통계 및 정답률

## 시작하기

### Backend
```bash
cd backend
./gradlew bootRun
```

### Frontend
```bash
cd frontend
npm install
npm run dev
```