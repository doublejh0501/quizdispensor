'use client'

import { useEffect, useState } from 'react'
import axios from 'axios'

interface Question {
  id: number
  category: string
  questionText: string
  questionType: string
  options: string[] | null
  difficulty: string
}

export default function Home() {
  const [questions, setQuestions] = useState<Question[]>([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState<string | null>(null)

  useEffect(() => {
    fetchQuestions()
  }, [])

  const fetchQuestions = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/questions')
      setQuestions(response.data)
      setLoading(false)
    } catch (err) {
      setError('Failed to load questions')
      setLoading(false)
    }
  }

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <p className="text-xl">Loading...</p>
      </div>
    )
  }

  if (error) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <p className="text-xl text-red-500">{error}</p>
      </div>
    )
  }

  return (
    <div className="min-h-screen p-8">
      <header className="max-w-4xl mx-auto mb-8">
        <h1 className="text-4xl font-bold mb-2">Dev Quiz</h1>
        <p className="text-gray-600">개발 용어 퀴즈로 면접 준비하기</p>
      </header>

      <main className="max-w-4xl mx-auto">
        <div className="grid gap-4">
          {questions.length === 0 ? (
            <p className="text-center text-gray-500">아직 퀴즈가 없습니다.</p>
          ) : (
            questions.map((question) => (
              <div
                key={question.id}
                className="border rounded-lg p-6 hover:shadow-lg transition-shadow"
              >
                <div className="flex justify-between items-start mb-2">
                  <span className="text-sm bg-blue-100 text-blue-800 px-2 py-1 rounded">
                    {question.category}
                  </span>
                  <span className="text-sm text-gray-500">
                    {question.difficulty}
                  </span>
                </div>
                <h3 className="text-lg font-semibold mb-2">
                  {question.questionText}
                </h3>
                <p className="text-sm text-gray-600">
                  {question.questionType === 'OX' ? 'OX 퀴즈' : '4지선다'}
                </p>
              </div>
            ))
          )}
        </div>
      </main>
    </div>
  )
}
