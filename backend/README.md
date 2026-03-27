# Backend - Dev Quiz

Kotlin + Spring Boot WebFlux 기반 백엔드

## 요구사항

- JDK 17+
- PostgreSQL
- Redis

## 실행 방법

```bash
./gradlew bootRun
```

## API 엔드포인트

- `GET /api/health` - 헬스체크
- `GET /api/questions` - 모든 문제 조회
- `GET /api/questions/category/{category}` - 카테고리별 문제 조회
- `POST /api/questions` - 문제 생성
- `POST /api/questions/submit` - 답안 제출
