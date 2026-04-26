import type { Metadata } from 'next'
import Link from 'next/link'
import './globals.css'

export const metadata: Metadata = {
  title: 'Dev Quiz - 개발 용어 퀴즈',
  description: '면접 준비를 위한 개발 용어 퀴즈 플랫폼',
}

export default function RootLayout({
  children,
}: {
  children: React.ReactNode
}) {
  return (
    <html lang="ko">
      <body className="bg-gray-50">
        <nav className="bg-white shadow-sm border-b">
          <div className="max-w-6xl mx-auto px-4 py-4">
            <Link href="/" className="text-2xl font-bold text-blue-600">
              Dev Quiz
            </Link>
          </div>
        </nav>
        <main className="min-h-screen">
          {children}
        </main>
        <footer className="bg-white border-t py-6 text-center text-gray-600 text-sm">
          © 2024 Dev Quiz. 면접 준비를 위한 개발 용어 퀴즈
        </footer>
      </body>
    </html>
  )
}
