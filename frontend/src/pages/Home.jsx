import Navbar from '../components/Navbar'
import { Link } from 'react-router-dom'
import schoolImage from '../assets/school.jpg'

function Home() {


return (

    <div className="bg-gray-100">
    <Navbar />

    <section className="py-20 text-center max-w-5xl mx-auto md:flex md:items-center md:justify-between gap-10 text-left px-6">

    <div className="md:w-1/2">
        <h1 className="text-5xl font-bold mb-4 leading-tight md:text-6xl">Welcome to Northfield Academy</h1>
        <p className="text-lg text-gray-600 mb-8 max-w-2xl">Empowering students to learn, grow, and succeed in a supportive community.</p>


    <div className="flex justify-start gap-4">
                <button className="bg-blue-600 text-white px-6 py-3 rounded-lg font-semibold hover:bg-blue-700 transition">Explore Programs</button>
                <Link to='/Login' className="bg-white text-blue-600 border border-blue-600 px-6 py-3 rounded-lg font-semibold hover:bg-blue-50 transition">Portal Login</Link>
    </div>

    </div>


    <div className="md:w-1/2">
    <img src={schoolImage} alt="Northfield Academy" className="w-full rounded-xl shadow-lg"/>




    </div>

    </section>



    </div>

)

}

export default Home