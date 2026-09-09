import { useState } from 'react'
import Navbar from '../components/Navbar'

function CreateStudent() {

    const [name, setName] = useState("")
    const [age, setAge] = useState("")
    const [major, setMajor] = useState("")
    const [message, setMessage] = useState("")
    const [createdStudent, setCreatedStudent] = useState(null)

    function createStudent() {

if (!name || !age || !major) {
    setMessage("Please fill in all fields.")
    return
}

if (age <= 1 || age >= 80) {
    setMessage("Please enter a valid age.")
    return
}

  const url =
    "http://localhost:8080/api/createstudent?name=" + name + "&age=" + age + "&major=" + major;

  fetch(url, {
    method: "POST"
  })
    .then(function(response) {
      if (!response.ok) {
        return response.json().then(function(errorData) {
          throw new Error(errorData.message);
        });
      }

      return response.json();
    }).then(function(student){
        setMessage("Student created successfully!");
        setCreatedStudent(student)
        setName("")
        setAge("")
        setMajor("")
    })
}

    return (

    <div className="bg-gray-100">

    <Navbar />

    <div className="min-h-screen bg-gray-100 flex items-center justify-center">
        <div className="bg-white p-8 rounded-xl shadow-lg w-full max-w-md">
                <h1 className="text-4xl font-bold text-blue-600 mb-4">Northfield Academy</h1>
                <h2 className="text-xl font-semibold text-gray-700 mb-6">Student Profile</h2>


        <div className="mb-4">
            <label className="block font-medium text-gray-700">Name: </label>
            <input type="text" value={name} onChange={(event) => setName(event.target.value)}
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
        </div>

        <div className="mb-4">
            <label className="block font-medium text-gray-700">Age: </label>
            <input type="number" value={age} onChange={(event) => setAge(event.target.value)}
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
        </div>

        <div className="mb-4">
            <label className="block font-medium text-gray-700">Major: </label>
            <input type="text" value={major} onChange={(event) => setMajor(event.target.value)}
            className="w-full border border-gray-300 rounded-lg px-3 py-2 mt-1 focus:outline-none focus:ring-2 focus:ring-blue-500"/>
        </div>

        <div className="mb-4">
            <button onClick={() => createStudent()}
            className="w-full bg-blue-600 text-white font-semibold py-2 rounded-lg hover:bg-blue-700 transition">Create Student
            </button>
        </div>

        <p className="mb-4">{message}</p>
            {createdStudent && (
                <pre>{JSON.stringify(createdStudent, null, 2)}</pre>
            )}

            </div>

            </div>

    </div>

    )


}

export default CreateStudent