# Dev Quiz - 개발 용어 퀴즈 사이트

면접 준비를 위한 개발 용어 퀴즈 플랫폼

## 기술 스택

### Backend
- Kotlin
- Spring Boot 3.x
- Spring WebFlux (비동기)
- Spring Security (CSRF 비활성화, CORS 설정)
- PostgreSQL (R2DBC)
- Redis

### Frontend
- Next.js 15
- TypeScript
- TailwindCSS
- Axios
- App Router

## 프로젝트 구조

```
dev-quiz/
├── backend/
│   ├── src/main/kotlin/com/devquiz/
│   │   ├── controller/      # REST API 컨트롤러
│   │   ├── service/          # 비즈니스 로직
│   │   ├── repository/       # 데이터 접근 계층
│   │   ├── domain/           # 엔티티
│   │   ├── dto/              # 데이터 전송 객체
│   │   └── config/           # 설정
│   └── src/main/resources/
│       ├── application.yml   # 애플리케이션 설정
│       ├── schema.sql        # DB 스키마
│       └── data.sql          # 샘플 데이터 (42개 문제)
├── frontend/
│   └── src/app/
│       ├── page.tsx          # 메인 페이지 (카테고리 선택)
│       ├── quiz/[category]/  # 퀴즈 풀기 페이지
│       └── result/           # 결과 페이지
└── docker-compose.yml        # PostgreSQL + Redis

```

## 주요 기능

### ✅ 구현 완료
- 개발 용어 퀴즈 (OX, 4지선다)
- 6개 카테고리 (자료구조, 네트워크, DB, OS, 디자인패턴, 알고리즘)
- 총 42개 샘플 문제 (각 카테고리 6-7문제)
- 난이도별 문제 (EASY, MEDIUM, HARD)
- 즉시 정답 피드백 및 해설
- 진행률 표시
- 최종 점수 및 통계
- 반응형 UI (TailwindCSS)

### 🚧 추후 확장 가능
- 사용자 인증 (JWT)
- 진행도 저장
- 오답 노트
- 학습 통계

## 시작하기

### 1. 데이터베이스 실행

Docker를 사용하여 PostgreSQL과 Redis를 실행합니다.

```bash
# Docker Desktop이 실행 중인지 확인
docker-compose up -d

# DB가 정상 실행되었는지 확인
docker-compose ps
```

초기 데이터(42개 문제)가 자동으로 로드됩니다.

### 2. Backend 실행

IntelliJ IDEA에서 프로젝트를 열거나 터미널에서 실행:

```bash
cd backend
./gradlew bootRun
```

Backend는 `http://localhost:8080`에서 실행됩니다.

### 3. Frontend 실행

```bash
cd frontend
npm install
npm run dev
```

Frontend는 `http://localhost:3000`에서 실행됩니다.

## API 엔드포인트

### Questions
- `GET /api/questions` - 모든 문제 조회
- `GET /api/questions/category/{category}` - 카테고리별 문제 조회
- `GET /api/questions/{id}` - 특정 문제 조회
- `POST /api/questions` - 문제 생성
- `POST /api/questions/submit` - 답안 제출

### Health Check
- `GET /api/health` - 서버 상태 확인

## 데이터베이스 스키마

### questions 테이블
- id: BIGSERIAL (PK)
- category: VARCHAR(100) - 카테고리
- question_text: TEXT - 문제 내용
- question_type: VARCHAR(20) - OX 또는 MULTIPLE_CHOICE
- options: TEXT[] - 선택지 배열 (4지선다용)
- correct_answer: VARCHAR(255) - 정답
- explanation: TEXT - 해설
- difficulty: VARCHAR(20) - EASY, MEDIUM, HARD
- created_at, updated_at: TIMESTAMP

## 샘플 데이터

각 카테고리별로 6개의 문제가 포함되어 있습니다:
- 자료구조: 스택, 큐, 해시 테이블, 트리, 힙 등
- 네트워크: HTTP, TCP/UDP, REST API, OSI 모델 등
- 데이터베이스: ACID, NoSQL, JOIN, 인덱스 등
- 운영체제: 프로세스/스레드, 데드락, 페이징, 메모리 등
- 디자인패턴: 싱글톤, 팩토리, MVC, 옵저버 등
- 알고리즘: 정렬, BFS/DFS, 시간복잡도, 동적계획법 등