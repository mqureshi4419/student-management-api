import { Link } from 'react-router-dom'
import { useNavigate } from 'react-router-dom'

function Navbar() {

const navigate = useNavigate()
const user = localStorage.getItem("user")

function logoutUser() {
    localStorage.removeItem("user")
    navigate('/login')
}

    return (
        <nav className="flex items-center justify-between px-8 py-4 bg-white">
            <h1 className="text-2xl font-bold text-blue-600">Northfield Academy</h1>

            <div className="flex items-center gap-6">
            <Link to='/' className="text-gray-700 font-medium hover:text-blue-600 transition">Home</Link>
            <button className="text-gray-700 font-medium hover:text-blue-600 transition">About</button>
            <button className="text-gray-700 font-medium hover:text-blue-600 transition">Programs</button>
            <Link to='/contact' className="text-gray-700 font-medium hover:text-blue-600 transition">Contact</Link>
             {user ? (
             <>
                <Link to='/dashboard'
                className="border border-blue-600 text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-blue-50 transition">
                Dashboard</Link>
                <button onClick={logoutUser}
                className="w-full bg-blue-600 text-white px-4 py-2 rounded-lg font-semibold hover:bg-blue-700 transition">
                Logout</button>
             </>
             ) : (
                <Link to='/login'
                className="border border-blue-600 text-blue-600 px-4 py-2 rounded-lg font-semibold hover:bg-blue-50 transition">
                Portal Login</Link>
             )}
            </div>
        </nav>
    )

}

export default Navbar