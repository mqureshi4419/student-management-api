import { Link } from 'react-router-dom'

function Dashboard() {


    return (

        <div>
        <h1>Northfield Academy Portal</h1>
        <h3>Welcome!</h3>

        <Link to='/students/create'>Create Student</Link>
        <Link to='/students'>View Student</Link>
        <button>Logout</button>
        </div>
    )


}
export default Dashboard