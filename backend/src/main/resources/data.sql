-- Sample Quiz Data for Dev Quiz Platform

-- 자료구조 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('자료구조', '스택(Stack)은 LIFO(Last In First Out) 구조이다.', 'OX', NULL, 'O', '스택은 마지막에 들어온 데이터가 먼저 나가는 LIFO 구조입니다.', 'EASY'),
('자료구조', '큐(Queue)는 FIFO(First In First Out) 구조이다.', 'OX', NULL, 'O', '큐는 먼저 들어온 데이터가 먼저 나가는 FIFO 구조입니다.', 'EASY'),
('자료구조', '해시 테이블의 평균 시간 복잡도는 O(1)이다.', 'OX', NULL, 'O', '해시 테이블은 해시 함수를 사용하여 평균적으로 O(1)의 시간 복잡도로 데이터에 접근할 수 있습니다.', 'MEDIUM'),
('자료구조', '이진 탐색 트리의 검색 시간 복잡도는 항상 O(log n)이다.', 'OX', NULL, 'X', '최악의 경우(편향 트리) O(n)의 시간 복잡도를 가질 수 있습니다. 평균적으로 O(log n)입니다.', 'MEDIUM'),
('자료구조', '다음 중 선형 자료구조가 아닌 것은?', 'MULTIPLE_CHOICE', ARRAY['배열', '연결 리스트', '트리', '스택'], '트리', '트리는 계층적 구조를 가진 비선형 자료구조입니다.', 'EASY'),
('자료구조', '힙(Heap) 자료구조에서 루트 노드는 어떤 특징을 가지는가?', 'MULTIPLE_CHOICE', ARRAY['항상 최댓값 또는 최솟값', '항상 중간값', '항상 평균값', '정해진 규칙 없음'], '항상 최댓값 또는 최솟값', '최대 힙에서는 최댓값, 최소 힙에서는 최솟값이 루트에 위치합니다.', 'MEDIUM');

-- 네트워크 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('네트워크', 'HTTP는 stateless 프로토콜이다.', 'OX', NULL, 'O', 'HTTP는 각 요청이 독립적으로 처리되는 stateless 프로토콜입니다.', 'EASY'),
('네트워크', 'TCP는 비연결형 프로토콜이다.', 'OX', NULL, 'X', 'TCP는 연결 지향형 프로토콜이고, UDP가 비연결형 프로토콜입니다.', 'EASY'),
('네트워크', 'HTTPS는 HTTP에 SSL/TLS를 적용한 프로토콜이다.', 'OX', NULL, 'O', 'HTTPS는 HTTP 통신을 암호화하기 위해 SSL/TLS를 사용합니다.', 'EASY'),
('네트워크', 'REST API에서 리소스 생성은 어떤 HTTP 메서드를 사용하는가?', 'MULTIPLE_CHOICE', ARRAY['GET', 'POST', 'PUT', 'DELETE'], 'POST', 'POST 메서드는 새로운 리소스를 생성할 때 사용됩니다.', 'EASY'),
('네트워크', 'OSI 7계층 모델에서 전송 계층은 몇 번째 계층인가?', 'MULTIPLE_CHOICE', ARRAY['3계층', '4계층', '5계층', '6계층'], '4계층', '전송 계층(Transport Layer)은 OSI 모델의 4계층입니다.', 'MEDIUM'),
('네트워크', '3-way handshake는 어떤 프로토콜에서 사용되는가?', 'MULTIPLE_CHOICE', ARRAY['UDP', 'TCP', 'HTTP', 'FTP'], 'TCP', 'TCP 연결 수립 과정에서 3-way handshake를 사용합니다.', 'MEDIUM');

-- 데이터베이스 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('데이터베이스', 'ACID는 데이터베이스 트랜잭션의 특성을 나타낸다.', 'OX', NULL, 'O', 'ACID는 Atomicity, Consistency, Isolation, Durability의 약자로 트랜잭션의 핵심 특성입니다.', 'EASY'),
('데이터베이스', 'NoSQL 데이터베이스는 스키마가 고정되어 있다.', 'OX', NULL, 'X', 'NoSQL은 스키마가 유연하거나 없는 것이 특징입니다.', 'EASY'),
('데이터베이스', 'JOIN 연산은 두 개 이상의 테이블을 결합하는 연산이다.', 'OX', NULL, 'O', 'JOIN은 관계형 데이터베이스에서 여러 테이블의 데이터를 결합하는 연산입니다.', 'EASY'),
('데이터베이스', 'SQL에서 중복을 제거하는 키워드는?', 'MULTIPLE_CHOICE', ARRAY['UNIQUE', 'DISTINCT', 'REMOVE', 'DELETE'], 'DISTINCT', 'DISTINCT 키워드는 중복된 결과를 제거합니다.', 'EASY'),
('데이터베이스', '인덱스를 사용하는 주요 목적은?', 'MULTIPLE_CHOICE', ARRAY['데이터 암호화', '검색 속도 향상', '데이터 압축', '백업 용이'], '검색 속도 향상', '인덱스는 데이터 검색 속도를 향상시키기 위해 사용됩니다.', 'MEDIUM'),
('데이터베이스', 'ACID의 I는 무엇을 의미하는가?', 'MULTIPLE_CHOICE', ARRAY['Integrity', 'Isolation', 'Identity', 'Immutability'], 'Isolation', 'Isolation(격리성)은 트랜잭션들이 서로 영향을 주지 않고 독립적으로 실행되는 것을 의미합니다.', 'MEDIUM');

-- 운영체제 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('운영체제', '프로세스와 스레드는 같은 개념이다.', 'OX', NULL, 'X', '프로세스는 독립적인 메모리 공간을 가지고, 스레드는 프로세스 내에서 메모리를 공유합니다.', 'EASY'),
('운영체제', '데드락은 두 개 이상의 프로세스가 서로의 자원을 기다리며 무한 대기하는 상태이다.', 'OX', NULL, 'O', '데드락은 프로세스들이 순환적으로 자원을 기다리며 진행할 수 없는 상태입니다.', 'MEDIUM'),
('운영체제', '페이징은 외부 단편화를 해결하는 메모리 관리 기법이다.', 'OX', NULL, 'O', '페이징은 메모리를 고정 크기로 나누어 외부 단편화를 해결합니다.', 'HARD'),
('운영체제', '컨텍스트 스위칭은 무엇인가?', 'MULTIPLE_CHOICE', ARRAY['프로세스 생성', 'CPU가 다른 프로세스로 전환', '메모리 할당', '파일 입출력'], 'CPU가 다른 프로세스로 전환', '컨텍스트 스위칭은 CPU가 실행 중인 프로세스를 바꾸는 작업입니다.', 'MEDIUM'),
('운영체제', '뮤텍스와 세마포어의 차이는?', 'MULTIPLE_CHOICE', ARRAY['동일한 개념', '뮤텍스는 1개, 세마포어는 여러 개 리소스 관리', '뮤텍스는 느리고 세마포어는 빠름', '차이 없음'], '뮤텍스는 1개, 세마포어는 여러 개 리소스 관리', '뮤텍스는 바이너리 세마포어로 1개의 리소스만, 세마포어는 N개의 리소스를 관리할 수 있습니다.', 'HARD'),
('운영체제', '가상 메모리의 주요 목적은?', 'MULTIPLE_CHOICE', ARRAY['보안 강화', '물리적 메모리보다 큰 프로그램 실행', '속도 향상', '전력 절약'], '물리적 메모리보다 큰 프로그램 실행', '가상 메모리는 물리적 메모리의 한계를 극복하고 더 큰 프로그램을 실행할 수 있게 합니다.', 'MEDIUM');

-- 디자인 패턴 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('디자인패턴', '싱글톤 패턴은 클래스의 인스턴스가 오직 하나만 생성되도록 보장한다.', 'OX', NULL, 'O', '싱글톤 패턴은 전역적으로 하나의 인스턴스만 존재하도록 보장하는 패턴입니다.', 'EASY'),
('디자인패턴', '팩토리 패턴은 객체 생성 로직을 캡슐화한다.', 'OX', NULL, 'O', '팩토리 패턴은 객체 생성 과정을 추상화하고 캡슐화합니다.', 'EASY'),
('디자인패턴', 'MVC 패턴에서 M은 무엇을 의미하는가?', 'MULTIPLE_CHOICE', ARRAY['Manager', 'Model', 'Module', 'Method'], 'Model', 'MVC는 Model-View-Controller의 약자입니다.', 'EASY'),
('디자인패턴', '옵저버 패턴의 주요 목적은?', 'MULTIPLE_CHOICE', ARRAY['객체 생성', '상태 변화 알림', '데이터 저장', '성능 최적화'], '상태 변화 알림', '옵저버 패턴은 객체의 상태 변화를 관찰자들에게 자동으로 알리는 패턴입니다.', 'MEDIUM'),
('디자인패턴', '전략 패턴이 해결하는 문제는?', 'MULTIPLE_CHOICE', ARRAY['싱글톤 보장', '알고리즘 동적 교체', '객체 복제', '메모리 관리'], '알고리즘 동적 교체', '전략 패턴은 알고리즘을 캡슐화하고 런타임에 교체 가능하게 합니다.', 'MEDIUM'),
('디자인패턴', '데코레이터 패턴의 특징은?', 'MULTIPLE_CHOICE', ARRAY['객체를 생성만 함', '기능을 동적으로 추가', '상태를 저장만 함', '객체를 삭제함'], '기능을 동적으로 추가', '데코레이터 패턴은 객체에 동적으로 새로운 기능을 추가할 수 있습니다.', 'HARD');

-- 알고리즘 문제
INSERT INTO questions (category, question_text, question_type, options, correct_answer, explanation, difficulty) VALUES
('알고리즘', '버블 정렬의 시간 복잡도는 O(n^2)이다.', 'OX', NULL, 'O', '버블 정렬은 평균과 최악의 경우 모두 O(n^2)의 시간 복잡도를 가집니다.', 'EASY'),
('알고리즘', '이진 탐색은 정렬된 배열에서만 사용할 수 있다.', 'OX', NULL, 'O', '이진 탐색은 데이터가 정렬되어 있어야 사용 가능합니다.', 'EASY'),
('알고리즘', '퀵 정렬의 평균 시간 복잡도는?', 'MULTIPLE_CHOICE', ARRAY['O(n)', 'O(n log n)', 'O(n^2)', 'O(log n)'], 'O(n log n)', '퀵 정렬은 평균적으로 O(n log n)의 시간 복잡도를 가집니다.', 'MEDIUM'),
('알고리즘', 'BFS는 어떤 자료구조를 사용하는가?', 'MULTIPLE_CHOICE', ARRAY['스택', '큐', '힙', '트리'], '큐', 'BFS(너비 우선 탐색)는 큐를 사용하여 구현합니다.', 'MEDIUM'),
('알고리즘', 'DFS는 어떤 자료구조를 사용하는가?', 'MULTIPLE_CHOICE', ARRAY['스택 또는 재귀', '큐', '힙', '배열'], '스택 또는 재귀', 'DFS(깊이 우선 탐색)는 스택이나 재귀를 사용하여 구현합니다.', 'MEDIUM'),
('알고리즘', '동적 계획법(DP)의 핵심 개념은?', 'MULTIPLE_CHOICE', ARRAY['분할 정복', '부분 문제의 결과 재사용', '탐욕적 선택', '무작위 선택'], '부분 문제의 결과 재사용', '동적 계획법은 중복되는 부분 문제의 결과를 저장하고 재사용합니다.', 'HARD');
