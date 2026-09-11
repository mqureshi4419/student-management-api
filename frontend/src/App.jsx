import './App.css'
import { Routes, Route } from 'react-router-dom'
import Home from './pages/Home'
import Login from './pages/Login'
import Dashboard from './pages/Dashboard'
import CreateStudent from './pages/CreateStudent'
import Students from './pages/Students'
import Contact from './pages/Contact'
import ProtectedRoute from './components/ProtectedRoute'

function App() {

    return (
        <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route
                path="/dashboard"
                element={
                    <ProtectedRoute>
                        <Dashboard />
                    </ProtectedRoute>
                }
            />
            <Route
                path="/students/create"
                element={
                    <ProtectedRoute>
                        <CreateStudent />
                    </ProtectedRoute>
                }
            />
            <Route
                path="/students"
                element={
                    <ProtectedRoute>
                        <Students />
                    </ProtectedRoute>
                }
            />
            <Route path="/contact" element={<Contact />} />
        </Routes>
    )


}

export default App
