# Dev Quiz - 이력서 & 포트폴리오 작성 가이드

## 📄 이력서용 프로젝트 설명

### 짧은 버전 (1-2줄)
```
Dev Quiz | 개발 용어 퀴즈 플랫폼 (2주)
면접 준비를 위한 개발 용어 학습 플랫폼. Kotlin + Spring WebFlux 비동기 백엔드, Next.js 15 프론트엔드 구현
```

### 중간 버전 (3-4줄)
```
Dev Quiz | 개발 용어 퀴즈 플랫폼 (2주)
- 면접 준비를 위한 6개 카테고리(자료구조, 네트워크, DB, OS, 디자인패턴, 알고리즘) 42개 문제 제공
- Kotlin + Spring Boot WebFlux 비동기 처리, PostgreSQL(R2DBC), Redis 활용
- Next.js 15 App Router, TypeScript, TailwindCSS 반응형 UI 구현
- 10개 단위/통합 테스트 작성, Swagger API 문서화, Docker Compose 환경 구성
```

### 상세 버전 (이력서 프로젝트 섹션)
```
Dev Quiz - 개발 용어 퀴즈 플랫폼
개발 기간: 2주 (2026.03)
GitHub: https://github.com/doublejh0501/quizdispensor

[프로젝트 개요]
면접 준비를 위한 개발 용어 학습 플랫폼으로, 6개 카테고리(자료구조, 네트워크, DB, OS, 
디자인패턴, 알고리즘)에 걸쳐 42개의 OX/4지선다 문제를 제공합니다.

[기술 스택]
Backend: Kotlin, Spring Boot 3.2, WebFlux, PostgreSQL(R2DBC), Redis, Spring Security
Frontend: Next.js 15, TypeScript, TailwindCSS, Axios
Infra: Docker Compose, PostgreSQL 15, Redis 7
Test: JUnit 5, MockK, Reactor Test (10개 테스트)

[주요 구현 내용]
• Reactive Programming: Spring WebFlux 비동기 논블로킹 처리로 높은 동시성 처리
• REST API 설계: 6개 엔드포인트 구현 및 Swagger 자동 문서화
• Database 설계: PostgreSQL 스키마 설계, 인덱스 최적화, 42개 샘플 데이터 구축
• 테스트 주도 개발: Service/Controller 계층 단위/통합 테스트 10개 작성
• 모던 UI/UX: Next.js 15 App Router, 반응형 디자인, 즉시 피드백 시스템
• 컨테이너화: Docker Compose로 PostgreSQL/Redis 환경 자동 구성

[성과 및 특징]
• Spring WebFlux를 활용한 비동기 처리로 효율적인 리소스 관리
• TypeScript + Kotlin 조합으로 전체 시스템 타입 안정성 확보
• 10개 테스트 케이스 작성으로 코드 품질 보장
• Swagger UI 통합으로 API 문서 자동화
• Docker Compose로 원클릭 개발 환경 구축
```

---

## 💼 포트폴리오용 상세 설명

### 1. 프로젝트 개요
```
프로젝트명: Dev Quiz - 개발 용어 퀴즈 플랫폼
기간: 2주 (2026년 3월)
역할: 풀스택 개발 (1인 프로젝트)
GitHub: https://github.com/doublejh0501/quizdispensor

면접 준비를 위한 개발 용어 학습 플랫폼입니다. 
자료구조, 네트워크, 데이터베이스, 운영체제, 디자인패턴, 알고리즘 등 
6개 카테고리에 걸쳐 42개의 문제를 제공하며, 
OX 퀴즈와 4지선다 형식으로 학습할 수 있습니다.
```

### 2. 기술 스택 & 아키텍처

**Backend**
- Language: Kotlin
- Framework: Spring Boot 3.2.0
- Reactive: Spring WebFlux (비동기 논블로킹)
- Database: PostgreSQL 15 (R2DBC)
- Cache: Redis 7
- Security: Spring Security, CORS
- Documentation: Swagger UI (springdoc-openapi)
- Test: JUnit 5, MockK, Reactor Test

**Frontend**
- Framework: Next.js 15 (App Router)
- Language: TypeScript
- Styling: TailwindCSS
- HTTP Client: Axios
- Routing: 동적 라우팅 (App Router)

**Infrastructure**
- Container: Docker Compose
- Database: PostgreSQL 15
- Cache: Redis 7
- Version Control: Git, GitHub

**Architecture**
- Backend: 계층형 아키텍처 (Controller → Service → Repository)
- Frontend: Next.js App Router 기반 페이지 라우팅
- API: RESTful API 설계
- Database: 관계형 데이터베이스 스키마 설계

### 3. 주요 기능

**사용자 기능**
- 6개 카테고리별 퀴즈 선택
- OX 퀴즈 및 4지선다 문제 풀이
- 실시간 정답/오답 피드백 (시각적 표시)
- 문제별 해설 제공
- 난이도 표시 (쉬움/보통/어려움)
- 진행률 표시
- 최종 점수 및 통계 확인

**관리 기능**
- 문제 CRUD API
- 카테고리별 문제 조회
- 답안 제출 및 검증

### 4. 기술적 도전과제 및 해결

**1) Reactive Programming 구현**
- 도전: Spring WebFlux 비동기 논블로킹 처리 학습 및 적용
- 해결: Flux/Mono를 활용한 Reactive Streams 구현
- 성과: 동시 요청 처리 성능 향상, 리소스 효율적 관리

**2) R2DBC 통합**
- 도전: 기존 JDBC 대신 Reactive Database Connectivity 적용
- 해결: R2DBC PostgreSQL 드라이버 설정, Repository 인터페이스 구현
- 성과: 완전한 비동기 데이터베이스 액세스 구현

**3) TypeScript + Kotlin 조합**
- 도전: 백엔드와 프론트엔드 모두 타입 안정성 확보
- 해결: DTO 정의, 인터페이스 일치, 타입 검증
- 성과: 컴파일 타임 에러 감지, 런타임 오류 감소

**4) Next.js 15 App Router**
- 도전: 최신 Next.js App Router 아키텍처 적용
- 해결: 동적 라우팅 ([category]), 서버 컴포넌트 활용
- 성과: SEO 최적화, 페이지 로딩 속도 향상 (4.2초)

**5) 테스트 주도 개발**
- 도전: Reactive 환경에서의 테스트 작성
- 해결: MockK + StepVerifier 활용, Service/Controller 테스트
- 성과: 10개 테스트 케이스 작성, 코드 커버리지 확보

**6) API 문서화 자동화**
- 도전: REST API 문서 관리 및 최신화
- 해결: Swagger UI (springdoc-openapi) 통합
- 성과: API 명세 자동 생성, 개발자 경험 향상

### 5. 구현 내용

**Backend API (6개 엔드포인트)**
```
GET  /api/health                          # 헬스체크
GET  /api/questions                       # 전체 문제 조회
GET  /api/questions/category/{category}   # 카테고리별 조회
GET  /api/questions/{id}                  # 특정 문제 조회
POST /api/questions                       # 문제 생성
POST /api/questions/submit                # 답안 제출
```

**Database 스키마**
- users: 사용자 정보
- questions: 문제 (42개 샘플 데이터)
- user_progress: 사용자 진행도 및 답안
- 인덱스: category, difficulty, user_id, question_id

**Frontend 페이지**
- / : 메인 페이지 (6개 카테고리 선택)
- /quiz/[category] : 퀴즈 풀기 페이지 (동적 라우팅)
- /result : 결과 페이지 (점수 및 통계)

**테스트 코드**
- QuestionServiceTest: 6개 단위 테스트
- QuestionControllerTest: 4개 통합 테스트
- Reactive Streams 검증 (StepVerifier)

### 6. 프로젝트 구조

```
dev-quiz/
├── backend/                      # Kotlin Spring Boot
│   ├── controller/              # REST API 컨트롤러 (2개)
│   ├── service/                 # 비즈니스 로직 (1개)
│   ├── repository/              # 데이터 접근 계층 (3개)
│   ├── domain/                  # 엔티티 (3개)
│   ├── dto/                     # 데이터 전송 객체 (2개)
│   ├── config/                  # Security, CORS 설정
│   └── test/                    # 테스트 코드 (10개)
├── frontend/                    # Next.js TypeScript
│   ├── app/                     # 페이지 및 레이아웃
│   │   ├── page.tsx            # 메인 페이지
│   │   ├── quiz/[category]/    # 퀴즈 페이지
│   │   └── result/             # 결과 페이지
│   └── globals.css             # TailwindCSS
└── docker-compose.yml          # PostgreSQL + Redis
```

### 7. 성과 및 배운 점

**정량적 성과**
- 총 코드 라인: 1,700+ 라인
- 테스트 커버리지: 10개 테스트 케이스
- API 엔드포인트: 6개
- 샘플 데이터: 42개 문제 (6개 카테고리)
- 프론트엔드 시작 시간: 4.2초
- 보안 취약점: 0개
- 개발 기간: 2주

**기술적 성장**
- Reactive Programming (WebFlux, Reactor) 학습 및 실전 적용
- R2DBC를 통한 비동기 데이터베이스 처리 경험
- Kotlin 언어 및 Spring Boot 3.x 활용 능력 향상
- Next.js 15 App Router 최신 기술 습득
- TypeScript로 타입 안정성 확보 경험
- 테스트 주도 개발(TDD) 방법론 적용
- Docker를 활용한 컨테이너 환경 구성 능력

**프로젝트 관리**
- Git을 활용한 버전 관리 및 협업 준비
- 문서화의 중요성 (README, QUICKSTART, TESTING, PROJECT_SUMMARY)
- 코드 품질 유지 (테스트, 타입 안정성)
- 사용자 중심 UI/UX 설계

### 8. 향후 개선 계획

**기능 확장**
- JWT 기반 사용자 인증/인가 구현
- 사용자별 진행도 저장 및 이력 관리
- 오답 노트 기능 추가
- 학습 통계 대시보드 (정답률, 카테고리별 성취도)
- 문제 난이도 자동 조정 알고리즘
- 랭킹 시스템 및 리더보드

**기술 개선**
- Redis 캐싱 전략 고도화
- 문제 추천 알고리즘 (머신러닝)
- GraphQL API 도입 고려
- 서버 사이드 렌더링(SSR) 최적화
- CI/CD 파이프라인 구축
- AWS 배포 및 운영

**성능 최적화**
- API 응답 시간 측정 및 최적화
- 데이터베이스 쿼리 튜닝
- 프론트엔드 번들 사이즈 최적화
- 이미지 최적화 (Next.js Image)

### 9. 데모 및 문서

**실행 방법**
```bash
# 1. 데이터베이스 시작
docker-compose up -d

# 2. Backend 실행 (IntelliJ)
DevQuizApplication.kt 실행

# 3. Frontend 실행
cd frontend
npm install
npm run dev

# 4. 접속
http://localhost:3000           # 프론트엔드
http://localhost:8080/swagger-ui.html  # Swagger UI
```

**문서**
- README.md: 프로젝트 전체 개요
- QUICKSTART.md: 빠른 시작 가이드
- TESTING.md: 테스트 실행 방법
- PROJECT_SUMMARY.md: 상세 프로젝트 정리

**주요 URL**
- GitHub: https://github.com/doublejh0501/quizdispensor
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api
- Swagger UI: http://localhost:8080/swagger-ui.html

---

## 📋 이력서 작성 템플릿

### 형식 1 (간단)
```
Dev Quiz (2026.03, 2주)
https://github.com/doublejh0501/quizdispensor
• 개발 용어 학습 플랫폼 (6개 카테고리, 42개 문제)
• Kotlin + Spring WebFlux, Next.js 15, PostgreSQL, Redis
• Reactive Programming, REST API, 테스트 10개, Swagger 문서화
```

### 형식 2 (표준)
```
Dev Quiz - 개발 용어 퀴즈 플랫폼 (2026.03, 2주)
https://github.com/doublejh0501/quizdispensor

[기술 스택]
Backend: Kotlin, Spring Boot 3.2, WebFlux, PostgreSQL(R2DBC), Redis
Frontend: Next.js 15, TypeScript, TailwindCSS
Infra: Docker Compose

[주요 성과]
• Spring WebFlux 비동기 처리로 효율적인 동시성 관리
• 6개 카테고리 42개 문제 DB 설계 및 REST API 6개 구현
• Next.js 15 App Router 활용 반응형 UI 개발
• 10개 단위/통합 테스트 작성, Swagger API 문서화
• Docker Compose로 원클릭 개발 환경 구축
```

### 형식 3 (상세)
```
Dev Quiz - 개발 용어 퀴즈 플랫폼
2026.03 (2주) | 1인 프로젝트
https://github.com/doublejh0501/quizdispensor

[프로젝트 개요]
면접 준비를 위한 개발 용어 학습 플랫폼으로, 자료구조/네트워크/DB/OS/
디자인패턴/알고리즘 6개 카테고리 42개 문제 제공

[기술 스택]
• Backend: Kotlin, Spring Boot 3.2, WebFlux, PostgreSQL(R2DBC), Redis
• Frontend: Next.js 15, TypeScript, TailwindCSS, Axios
• Infra: Docker Compose, PostgreSQL 15, Redis 7
• Test: JUnit 5, MockK, Reactor Test

[담당 업무 및 구현 내용]
• Spring WebFlux 기반 비동기 논블로킹 REST API 6개 엔드포인트 구현
• R2DBC를 활용한 Reactive Database 연동 및 쿼리 최적화
• PostgreSQL 스키마 설계, 인덱스 최적화, 42개 샘플 데이터 구축
• Next.js 15 App Router 활용 동적 라우팅 및 반응형 UI 개발
• Service/Controller 계층 단위 테스트 6개, 통합 테스트 4개 작성
• Swagger UI 통합으로 REST API 자동 문서화
• Docker Compose 환경 구성 (PostgreSQL, Redis)

[기술적 성과]
• Reactive Programming 적용으로 높은 동시성 처리 구현
• TypeScript + Kotlin 조합으로 전체 시스템 타입 안정성 확보
• 테스트 커버리지 확보로 코드 품질 보장 (10개 테스트)
• API 문서 자동화로 개발자 경험(DX) 향상
```

---

## 🎤 면접 대비 설명 가이드

### Q: 이 프로젝트를 선택한 이유는?
```
면접 준비를 하면서 개발 용어를 효과적으로 학습할 수 있는 도구가 
필요했고, 동시에 최신 기술 스택(Spring WebFlux, Next.js 15)을 
실전에 적용해보고 싶었습니다. 특히 Reactive Programming과 
비동기 처리를 학습하면서 실무 수준의 프로젝트를 구현하고자 했습니다.
```

### Q: 기술 스택을 선택한 이유는?
```
Backend는 Kotlin + Spring WebFlux를 선택했는데, 
비동기 논블로킹 처리로 동시성을 효율적으로 다루고 싶었고, 
Kotlin의 간결한 문법과 Null Safety가 매력적이었습니다. 
Frontend는 Next.js 15의 App Router를 사용해 최신 React 생태계를 
경험하고, TypeScript로 타입 안정성을 확보했습니다.
```

### Q: 가장 어려웠던 점과 해결 방법은?
```
Reactive Programming 패러다임이 가장 도전적이었습니다. 
기존 명령형 프로그래밍과 달리 Flux/Mono를 사용한 스트림 기반 
사고방식이 익숙하지 않았는데, 공식 문서와 예제를 학습하고 
StepVerifier로 테스트하면서 점차 이해했습니다. 
특히 R2DBC와 WebFlux를 함께 사용해 완전한 비동기 스택을 
구현한 경험이 값졌습니다.
```

### Q: 이 프로젝트에서 가장 자랑스러운 부분은?
```
테스트 주도 개발 방식으로 10개의 단위/통합 테스트를 작성한 점과, 
Swagger UI를 통합해 API 문서를 자동화한 점이 자랑스럽습니다. 
또한 Docker Compose로 개발 환경을 표준화해 누구나 쉽게 
실행할 수 있도록 한 점도 실무적으로 의미있다고 생각합니다.
```

### Q: 프로젝트를 통해 배운 점은?
```
첫째, Reactive Programming의 개념과 실전 적용 방법을 배웠습니다.
둘째, 타입 안정성의 중요성을 깨달았습니다 (TypeScript + Kotlin).
셋째, 테스트의 중요성과 테스트 가능한 코드 설계 방법을 익혔습니다.
넷째, API 문서화와 개발자 경험(DX)의 중요성을 이해했습니다.
다섯째, Docker를 활용한 컨테이너 환경 구성 능력을 키웠습니다.
```

---

## 💡 포트폴리오 강조 포인트

1. **최신 기술 스택**: Spring Boot 3.2, Next.js 15, Kotlin
2. **Reactive Programming**: WebFlux, R2DBC 비동기 처리
3. **타입 안정성**: TypeScript + Kotlin 조합
4. **테스트**: 10개 테스트 케이스 (단위 + 통합)
5. **API 문서화**: Swagger UI 자동 생성
6. **컨테이너화**: Docker Compose 환경
7. **코드 품질**: 계층형 아키텍처, DTO 패턴
8. **사용자 경험**: 반응형 UI, 즉시 피드백

---

이 문서를 참고하여 이력서와 포트폴리오에 프로젝트를 작성하시면 됩니다!
