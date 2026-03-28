'use client'

import Link from 'next/link'

const categories = [
  {
    name: '자료구조',
    slug: 'data-structure',
    description: '배열, 스택, 큐, 트리, 그래프 등',
    icon: '📊',
    color: 'bg-blue-500'
  },
  {
    name: '네트워크',
    slug: 'network',
    description: 'HTTP, TCP/IP, REST API 등',
    icon: '🌐',
    color: 'bg-green-500'
  },
  {
    name: '데이터베이스',
    slug: 'database',
    description: 'SQL, 트랜잭션, 인덱스 등',
    icon: '🗄️',
    color: 'bg-purple-500'
  },
  {
    name: '운영체제',
    slug: 'os',
    description: '프로세스, 메모리, 동기화 등',
    icon: '💻',
    color: 'bg-orange-500'
  },
  {
    name: '디자인패턴',
    slug: 'design-pattern',
    description: '싱글톤, 팩토리, 옵저버 등',
    icon: '🎨',
    color: 'bg-pink-500'
  },
  {
    name: '알고리즘',
    slug: 'algorithm',
    description: '정렬, 탐색, 동적계획법 등',
    icon: '🧮',
    color: 'bg-red-500'
  }
]

export default function Home() {
  return (
    <div className="py-12 px-4">
      <div className="max-w-6xl mx-auto">
        <div className="text-center mb-12">
          <h1 className="text-5xl font-bold mb-4 text-gray-900">
            개발 용어 퀴즈
          </h1>
          <p className="text-xl text-gray-600">
            면접 준비를 위한 카테고리별 퀴즈로 실력을 점검하세요
          </p>
        </div>

        <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
          {categories.map((category) => (
            <Link
              key={category.slug}
              href={`/quiz/${category.slug}`}
              className="block"
            >
              <div className="bg-white rounded-xl p-6 shadow-md hover:shadow-xl transition-all duration-300 hover:-translate-y-1 border border-gray-100">
                <div className={`w-16 h-16 ${category.color} rounded-lg flex items-center justify-center text-3xl mb-4`}>
                  {category.icon}
                </div>
                <h2 className="text-2xl font-bold mb-2 text-gray-900">
                  {category.name}
                </h2>
                <p className="text-gray-600">
                  {category.description}
                </p>
              </div>
            </Link>
          ))}
        </div>

        <div className="mt-16 bg-white rounded-xl p-8 shadow-md text-center">
          <h3 className="text-2xl font-bold mb-4 text-gray-900">
            학습 팁
          </h3>
          <div className="grid md:grid-cols-3 gap-6 text-left">
            <div>
              <div className="text-3xl mb-2">✅</div>
              <h4 className="font-semibold mb-1">OX 퀴즈</h4>
              <p className="text-sm text-gray-600">기본 개념을 빠르게 확인</p>
            </div>
            <div>
              <div className="text-3xl mb-2">📝</div>
              <h4 className="font-semibold mb-1">4지선다</h4>
              <p className="text-sm text-gray-600">심화 내용 이해도 테스트</p>
            </div>
            <div>
              <div className="text-3xl mb-2">💡</div>
              <h4 className="font-semibold mb-1">해설 제공</h4>
              <p className="text-sm text-gray-600">틀린 문제는 해설로 학습</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}
