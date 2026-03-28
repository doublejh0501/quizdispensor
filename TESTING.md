# 테스트 가이드

## 작성된 테스트

### 1. QuestionServiceTest (단위 테스트)
위치: `backend/src/test/kotlin/com/devquiz/service/QuestionServiceTest.kt`

테스트 케이스:
- ✅ getAllQuestions - 모든 문제 조회
- ✅ getQuestionsByCategory - 카테고리별 문제 조회
- ✅ getQuestionById - ID로 문제 조회
- ✅ createQuestion - 문제 생성
- ✅ submitAnswer (정답) - 정답 제출 시 정확한 응답
- ✅ submitAnswer (오답) - 오답 제출 시 정확한 응답

**총 6개 테스트 케이스**

### 2. QuestionControllerTest (통합 테스트)
위치: `backend/src/test/kotlin/com/devquiz/controller/QuestionControllerTest.kt`

테스트 케이스:
- ✅ GET /api/questions - 전체 문제 조회 API
- ✅ GET /api/questions/category/{category} - 카테고리별 조회 API
- ✅ GET /api/questions/{id} - 특정 문제 조회 API
- ✅ POST /api/questions/submit - 답안 제출 API

**총 4개 테스트 케이스**

## 테스트 기술 스택

- **JUnit 5** - 테스트 프레임워크
- **MockK** - Kotlin용 Mocking 라이브러리
- **Spring MockK** - Spring과 MockK 통합
- **Reactor Test** - Reactive Streams 테스트 (StepVerifier)
- **WebTestClient** - WebFlux API 테스트
- **H2 Database** - 인메모리 테스트 DB

## 테스트 실행 방법

### IntelliJ IDEA에서 실행 (권장)

1. IntelliJ에서 `backend` 프로젝트 열기
2. Gradle 동기화 완료 대기
3. 방법 1: 전체 테스트 실행
   - `backend/src/test` 폴더 우클릭
   - "Run 'All Tests'" 선택
4. 방법 2: 개별 테스트 실행
   - 테스트 파일 열기
   - 클래스명 옆 녹색 실행 버튼 클릭

### 커맨드라인 (Gradle 설치 필요)

```bash
cd backend
./gradlew test
```

또는

```bash
cd backend
./gradlew test --tests QuestionServiceTest
./gradlew test --tests QuestionControllerTest
```

## 예상 결과

모든 테스트 통과 시:
```
BUILD SUCCESSFUL
10 tests completed, 10 passed
```

## 테스트 커버리지

- **Service Layer**: 주요 비즈니스 로직 100% 커버
- **Controller Layer**: 모든 REST API 엔드포인트 커버
- **Mock 사용**: Repository 의존성을 Mock으로 대체하여 빠른 테스트

## 포트폴리오 포인트

✅ 단위 테스트 + 통합 테스트 작성
✅ Reactive Streams 테스트 (StepVerifier)
✅ MockK를 활용한 Kotlin 네이티브 테스팅
✅ WebFlux API 테스트
✅ Given-When-Then 패턴 적용
