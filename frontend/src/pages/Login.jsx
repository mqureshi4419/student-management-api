import Navbar from '../components/Navbar'
import { useState} from 'react'
import { useNavigate } from 'react-router-dom'

function Login() {

const [email, setEmail] = useState("")
const [password, setPassword] = useState("")
const [message, setMessage] = useState("")
const navigate = useNavigate()

function loginUser() {
    setMessage("")
    const url = "http://localhost:8080/api/login?email=" + email + "&password=" + password;

    fetch(url, {
    method: "POST"
    }).then(function(response){
        if (!response.ok) {
            return response.text().then(function(errorMessage) {
                throw new Error(errorMessage)
            });
        }

        return response.json();

    }).then(function(user) {
           console.log(user);
           navigate('/dashboard')

    }).catch(function(error){
        setMessage(error.message)
    })

}

    return (

    <div className="bg-gray-100">
    <Navbar />

        <div className="min-h-screen bg-gray-100 flex items-center justify-center px-6">
            <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md border border-gray-200">
            <h1 className="text-4xl font-bold text-blue-600 mb-6">Northfield Academy Portal</h1>

            <div className="mb-4">
            <label className="block font-medium text-gray-700">Email </label>
            <input type="email"
                   value={email}
                   onChange={(event) => setEmail(event.target.value)}
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div className="mb-4">
            <label className="block font-medium text-gray-700">Password</label>
            <input type="password"
                   value={password}
                   onChange={(event) => setPassword(event.target.value)}
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
            </div>

            <div className="mb-4">
            <button className="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition"
                    onClick={loginUser}>Login</button>
            </div>

            <div>
                <p>{message}</p>
            </div>

            </div>
        </div>

    </div>
    )

}

export default Login