'use client'

import { useRouter, useSearchParams } from 'next/navigation'
import { Suspense } from 'react'

function ResultContent() {
  const router = useRouter()
  const searchParams = useSearchParams()

  const score = parseInt(searchParams.get('score') || '0')
  const total = parseInt(searchParams.get('total') || '0')
  const percentage = total > 0 ? Math.round((score / total) * 100) : 0

  const getEmoji = () => {
    if (percentage >= 90) return '🏆'
    if (percentage >= 70) return '🎉'
    if (percentage >= 50) return '👍'
    return '📚'
  }

  const getMessage = () => {
    if (percentage >= 90) return '완벽합니다!'
    if (percentage >= 70) return '잘하셨어요!'
    if (percentage >= 50) return '괜찮아요!'
    return '조금 더 공부해봐요!'
  }

  return (
    <div className="py-12 px-4">
      <div className="max-w-2xl mx-auto">
        <div className="bg-white rounded-xl shadow-lg p-12 text-center">
          <div className="text-8xl mb-6">{getEmoji()}</div>

          <h1 className="text-4xl font-bold mb-4 text-gray-900">
            퀴즈 완료!
          </h1>

          <p className="text-2xl text-gray-600 mb-8">
            {getMessage()}
          </p>

          <div className="bg-gradient-to-r from-blue-500 to-purple-500 rounded-xl p-8 mb-8 text-white">
            <div className="text-6xl font-bold mb-2">
              {score} / {total}
            </div>
            <div className="text-2xl">
              정답률: {percentage}%
            </div>
          </div>

          <div className="grid grid-cols-2 gap-4 mb-8">
            <div className="bg-green-50 rounded-lg p-4">
              <div className="text-green-600 text-sm font-semibold mb-1">맞힌 문제</div>
              <div className="text-3xl font-bold text-green-700">{score}</div>
            </div>
            <div className="bg-red-50 rounded-lg p-4">
              <div className="text-red-600 text-sm font-semibold mb-1">틀린 문제</div>
              <div className="text-3xl font-bold text-red-700">{total - score}</div>
            </div>
          </div>

          <div className="space-y-3">
            <button
              onClick={() => router.push('/')}
              className="w-full py-4 bg-blue-500 text-white rounded-lg font-semibold text-lg hover:bg-blue-600 transition-colors"
            >
              다른 카테고리 도전하기
            </button>
            <button
              onClick={() => router.back()}
              className="w-full py-4 bg-gray-200 text-gray-700 rounded-lg font-semibold text-lg hover:bg-gray-300 transition-colors"
            >
              다시 풀기
            </button>
          </div>
        </div>

        <div className="mt-8 bg-blue-50 border border-blue-200 rounded-lg p-6">
          <h3 className="font-bold text-blue-900 mb-2">💡 학습 팁</h3>
          <ul className="text-gray-700 space-y-2 text-sm">
            <li>• 틀린 문제는 해설을 다시 읽어보세요</li>
            <li>• 여러 카테고리를 골고루 학습하면 효과적입니다</li>
            <li>• 반복 학습으로 개념을 확실히 익히세요</li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default function ResultPage() {
  return (
    <Suspense fallback={
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-xl">로딩 중...</div>
      </div>
    }>
      <ResultContent />
    </Suspense>
  )
}
