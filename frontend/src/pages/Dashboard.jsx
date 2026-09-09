import { Link } from 'react-router-dom'
import Navbar from '../components/Navbar'

function Dashboard() {


    return (

    <div className="bg-gray-100">
    <Navbar />

        <div className="min-h-screen bg-gray-100 flex items-center justify-center px-6">
        <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md border border-gray-200">
            <h1 className="text-4xl font-bold text-blue-600 mb-6">Northfield Academy Portal</h1>
            <h3 className="text-3xl font-bold text-blue-600 mb-8 text-center">Welcome!</h3>

            <div className="flex justify-center gap-6 mb-8">
            <Link to='/students/create' className="bg-blue-600 text-white px-6 py-3 rounded-lg font-semibold hover:bg-blue-700 transition">Create Student</Link>
            <Link to='/students' className="bg-white text-blue-600 border border-blue-600 px-6 py-3 rounded-lg font-semibold hover:bg-blue-50 transition">View Student</Link>
            </div>

            <div className="flex justify-center">
            <button className="w-full bg-blue-600 text-white py-2 rounded-lg font-semibold hover:bg-blue-700 transition">Logout</button>
            </div>
        </div>
        </div>

     </div>
    )


}
export default Dashboard