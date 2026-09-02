import { Link } from 'react-router-dom'


function Navbar() {

    return (
        <nav>
            <h1>Northfield Academy</h1>
            <Link to='/'>Home</Link>
            <button>About</button>
            <button>Programs</button>
            <button>Contact</button>
            <Link to='/login'>Portal Login</Link>
        </nav>
    )

}

export default Navbar