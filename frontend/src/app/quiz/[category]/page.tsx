'use client'

import { useParams, useRouter } from 'next/navigation'
import { useEffect, useState } from 'react'
import axios from 'axios'

interface Question {
  id: number
  category: string
  questionText: string
  questionType: 'OX' | 'MULTIPLE_CHOICE'
  options: string[] | null
  correctAnswer: string
  explanation: string
  difficulty: string
}

const categoryNames: Record<string, string> = {
  'data-structure': '자료구조',
  'network': '네트워크',
  'database': '데이터베이스',
  'os': '운영체제',
  'design-pattern': '디자인패턴',
  'algorithm': '알고리즘'
}

export default function QuizPage() {
  const params = useParams()
  const router = useRouter()
  const category = params.category as string

  const [questions, setQuestions] = useState<Question[]>([])
  const [currentIndex, setCurrentIndex] = useState(0)
  const [selectedAnswer, setSelectedAnswer] = useState<string | null>(null)
  const [showExplanation, setShowExplanation] = useState(false)
  const [score, setScore] = useState(0)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    fetchQuestions()
  }, [category])

  const fetchQuestions = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/questions/category/${categoryNames[category] || '자료구조'}`)
      setQuestions(response.data)
      setLoading(false)
    } catch (err) {
      console.error('Failed to fetch questions:', err)
      setLoading(false)
    }
  }

  const currentQuestion = questions[currentIndex]

  const handleAnswer = (answer: string) => {
    if (showExplanation) return

    setSelectedAnswer(answer)
    setShowExplanation(true)

    if (answer === currentQuestion.correctAnswer) {
      setScore(score + 1)
    }
  }

  const handleNext = () => {
    if (currentIndex < questions.length - 1) {
      setCurrentIndex(currentIndex + 1)
      setSelectedAnswer(null)
      setShowExplanation(false)
    } else {
      router.push(`/result?score=${score + (selectedAnswer === currentQuestion.correctAnswer ? 1 : 0)}&total=${questions.length}`)
    }
  }

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-xl">로딩 중...</div>
      </div>
    )
  }

  if (!currentQuestion) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <div className="text-center">
          <p className="text-xl mb-4">문제를 찾을 수 없습니다.</p>
          <button
            onClick={() => router.push('/')}
            className="px-6 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600"
          >
            홈으로 돌아가기
          </button>
        </div>
      </div>
    )
  }

  return (
    <div className="py-12 px-4">
      <div className="max-w-3xl mx-auto">
        <div className="mb-8">
          <div className="flex justify-between items-center mb-4">
            <h1 className="text-3xl font-bold">{categoryNames[category]}</h1>
            <div className="text-lg font-semibold text-gray-600">
              {currentIndex + 1} / {questions.length}
            </div>
          </div>
          <div className="w-full bg-gray-200 rounded-full h-2">
            <div
              className="bg-blue-500 h-2 rounded-full transition-all duration-300"
              style={{ width: `${((currentIndex + 1) / questions.length) * 100}%` }}
            />
          </div>
        </div>

        <div className="bg-white rounded-xl shadow-lg p-8">
          <div className="mb-6">
            <span className={`inline-block px-3 py-1 rounded-full text-sm font-semibold ${
              currentQuestion.difficulty === 'EASY' ? 'bg-green-100 text-green-800' :
              currentQuestion.difficulty === 'MEDIUM' ? 'bg-yellow-100 text-yellow-800' :
              'bg-red-100 text-red-800'
            }`}>
              {currentQuestion.difficulty === 'EASY' ? '쉬움' :
               currentQuestion.difficulty === 'MEDIUM' ? '보통' : '어려움'}
            </span>
          </div>

          <h2 className="text-2xl font-bold mb-8 text-gray-900">
            {currentQuestion.questionText}
          </h2>

          <div className="space-y-3">
            {currentQuestion.questionType === 'OX' ? (
              <>
                {['O', 'X'].map((option) => (
                  <button
                    key={option}
                    onClick={() => handleAnswer(option)}
                    disabled={showExplanation}
                    className={`w-full p-4 text-left rounded-lg border-2 transition-all ${
                      selectedAnswer === option
                        ? option === currentQuestion.correctAnswer
                          ? 'border-green-500 bg-green-50'
                          : 'border-red-500 bg-red-50'
                        : showExplanation && option === currentQuestion.correctAnswer
                        ? 'border-green-500 bg-green-50'
                        : 'border-gray-200 hover:border-blue-300'
                    } ${showExplanation ? 'cursor-not-allowed' : 'cursor-pointer'}`}
                  >
                    <div className="flex items-center justify-between">
                      <span className="text-xl font-semibold">{option}</span>
                      {showExplanation && option === currentQuestion.correctAnswer && (
                        <span className="text-green-600">✓</span>
                      )}
                    </div>
                  </button>
                ))}
              </>
            ) : (
              <>
                {currentQuestion.options?.map((option, index) => (
                  <button
                    key={index}
                    onClick={() => handleAnswer(option)}
                    disabled={showExplanation}
                    className={`w-full p-4 text-left rounded-lg border-2 transition-all ${
                      selectedAnswer === option
                        ? option === currentQuestion.correctAnswer
                          ? 'border-green-500 bg-green-50'
                          : 'border-red-500 bg-red-50'
                        : showExplanation && option === currentQuestion.correctAnswer
                        ? 'border-green-500 bg-green-50'
                        : 'border-gray-200 hover:border-blue-300'
                    } ${showExplanation ? 'cursor-not-allowed' : 'cursor-pointer'}`}
                  >
                    <div className="flex items-center justify-between">
                      <span>{option}</span>
                      {showExplanation && option === currentQuestion.correctAnswer && (
                        <span className="text-green-600">✓</span>
                      )}
                    </div>
                  </button>
                ))}
              </>
            )}
          </div>

          {showExplanation && (
            <div className="mt-6 p-4 bg-blue-50 border border-blue-200 rounded-lg">
              <h3 className="font-semibold text-blue-900 mb-2">💡 해설</h3>
              <p className="text-gray-700">{currentQuestion.explanation}</p>
            </div>
          )}

          {showExplanation && (
            <button
              onClick={handleNext}
              className="mt-6 w-full py-3 bg-blue-500 text-white rounded-lg font-semibold hover:bg-blue-600 transition-colors"
            >
              {currentIndex < questions.length - 1 ? '다음 문제' : '결과 보기'}
            </button>
          )}
        </div>
      </div>
    </div>
  )
}
