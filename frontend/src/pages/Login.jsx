import Navbar from '../components/Navbar'

function Login() {
    return (

    <div className="bg-gray-100">
    <Navbar />

        <div className="min-h-screen bg-gray-100 flex items-center justify-center px-6">
            <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md border border-gray-200">
            <h1 className="text-4xl font-bold text-blue-600 mb-6">Northfield Academy Portal</h1>

            <div className="mb-4">
            <label className="block font-medium text-gray-700">Email </label>
            <input type="email"
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div className="mb-4">
            <label className="block font-medium text-gray-700">Password</label>
            <input type="password"
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div className="mb-4">
            <button className="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition">Login</button>
            </div>

            </div>
        </div>

    </div>
    )

}

export default Login